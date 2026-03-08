import java.util.*;

public class GrahamScan {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int orientation(Point p, Point q, Point r) {
        long val = (long)(q.y - p.y) * (r.x - q.x) - (long)(q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0;
        return (val > 0) ? 1 : 2;
    }

    static List<Point> grahamScan(Point[] points) {
        int n = points.length;
        if (n < 3) return Arrays.asList(points);

        // Find bottom-most point
        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].y < points[minIdx].y || 
                (points[i].y == points[minIdx].y && points[i].x < points[minIdx].x)) {
                minIdx = i;
            }
        }
        Point start = points[minIdx];
        Point[] temp = points.clone();
        temp[minIdx] = temp[0];
        temp[0] = start;

        // Sort by polar angle
        Point pivot = start;
        Arrays.sort(temp, 1, n, (a, b) -> {
            int o = orientation(pivot, a, b);
            if (o == 0) {
                return Integer.compare((a.x - pivot.x) * (a.x - pivot.x) + (a.y - pivot.y) * (a.y - pivot.y),
                                      (b.x - pivot.x) * (b.x - pivot.x) + (b.y - pivot.y) * (b.y - pivot.y));
            }
            return (o == 2) ? -1 : 1;
        });

        Stack<Point> hull = new Stack<>();
        hull.push(temp[0]);
        hull.push(temp[1]);

        for (int i = 2; i < n; i++) {
            while (hull.size() > 1 && orientation(hull.get(hull.size() - 2), hull.peek(), temp[i]) != 2) {
                hull.pop();
            }
            hull.push(temp[i]);
        }

        return new ArrayList<>(hull);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        GrahamScan.Point[] points = new GrahamScan.Point[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new GrahamScan.Point(x, y);
        }
        List<GrahamScan.Point> hull = GrahamScan.grahamScan(points);
        System.out.println("Convex Hull:");
        for (GrahamScan.Point p : hull) {
            System.out.println(p.x + " " + p.y);
        }
        sc.close();
    }
}