import java.util.Arrays;
import java.util.HashMap;

class MinTimeToVisitAllPointsSolution {

    public static void main (String[] args) {
        int[][] points = {{1,1},{3,4},{-1,0}};
        MinTimeToVisitAllPointsSolution solution = new MinTimeToVisitAllPointsSolution();
        int result = solution.minTimeToVisitAllPoints(points);
        System.out.println(result);
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        if(points.length < 2) {
            return result;
        }

        for(int i=0; i< points.length-1; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i+1][0];
            int y2 = points[i+1][1];
            int diffX = Math.abs(x2 - x1);
            int diffY = Math.abs(y2 - y1);
            result += Math.max(diffX, diffY);
        }
        return result;
    }
}