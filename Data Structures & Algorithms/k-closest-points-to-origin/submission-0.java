class Solution {
    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistanceFromOrigin() {
            int d = x * x + y * y;
            return d;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pointQueue = new PriorityQueue<Point>((p1, p2) -> p2.getDistanceFromOrigin() - p1.getDistanceFromOrigin());
        for (int[] point : points) {
            pointQueue.add(new Point(point[0], point[1]));
            if (pointQueue.size() > k) {
                pointQueue.poll();
            }
        }
        int[][] result = new int[k][2];
        int r = 0;
        while (pointQueue.size() > 0) {
            Point point = pointQueue.poll();
            result[r++] = new int[]{point.x, point.y};
        } 
        return result;
    }
}
