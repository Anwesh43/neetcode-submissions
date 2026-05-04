class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class CountSquares {
    int[][] points;
    int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
    public CountSquares() {
        points = new int[1001][1001];
    }

    private int firstQuadrantSquares(int i, int j, int n) {
        int firstPoints = i - n >= 0 && j - n >= 0 ? points[i - n][j - n]  : 0; 
        int secondPoints = i - n >= 0 ? points[i - n][j] : 0;
        int thirdPoints = j - n >= 0 ? points[i][j - n] : 0;
        return firstPoints * secondPoints * thirdPoints;
    }

    private int secondQuadrantSquares(int i, int j, int n) {
        int firstPoints = i + n <= 1000 && j - n >= 0? points[i + n][j - n]  : 0; 
        int secondPoints = i + n <= 1000  ? points[i + n][j] : 0;
        int thirdPoints = j - n >=  0 ? points[i][j - n] : 0;
        return firstPoints * secondPoints * thirdPoints;
    }

    private int thirdQuadrantSquares(int i, int j, int n) {
        int firstPoints = i + n <= 1000 && j + n <= 1000 ? points[i + n][j + n] : 0; 
        int secondPoints = i + n <= 1000  ? points[i + n][j] : 0;
        int thirdPoints = j + n <= 1000 ? points[i][j + n] : 0;
        return firstPoints * secondPoints * thirdPoints;
    }

    private int fourthQuadrantSquares(int i, int j, int n) {
        int firstPoints = i - n >= 0 && j + n <= 1000 ? points[i - n][j + n] : 0; 
        int secondPoints = i - n >= 0  ? points[i - n][j] : 0;
        int thirdPoints = j + n <= 1000 ? points[i][j + n] : 0;
        return firstPoints * secondPoints * thirdPoints;
    }
    
    public void add(int[] point) {
        points[point[0]][point[1]]++;
        maxX = Math.max(point[0], maxX);
        maxY = Math.max(point[1], maxY);
        minX = Math.min(point[0], minX);
        minY = Math.min(point[1], minY);
    }

    private int squaresAtN(int i, int j, int n) {
        return firstQuadrantSquares(i, j, n) + secondQuadrantSquares(i, j, n) + thirdQuadrantSquares(i, j, n) + fourthQuadrantSquares(i, j, n);
    }
    
    public int count(int[] point) {
        int end = Math.max(maxX, maxY);
        System.out.println("END" + end);
        int count = 0;
        for (int i = 1; i <= end; i++) {
            count += squaresAtN(point[0], point[1], i);
        }
        return count;
    }
}
