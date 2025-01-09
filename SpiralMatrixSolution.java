import java.util.Arrays;
import java.util.List;

class SpiralMatrixSolution {

    public static void main (String[] args) {
        SpiralMatrixSolution solution = new SpiralMatrixSolution();
        int[][] nums1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> spiral1 = solution.spiralOrder(nums1);
        System.out.println(spiral1.toString());
        System.out.println(spiral1.equals(Arrays.asList(1,2,3,6,9,8,7,4,5)));

        int[][] nums2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};;
        List<Integer> spiral2 = solution.spiralOrder(nums2);
        System.out.println(spiral2.toString());
        System.out.println(spiral2.equals(Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7)));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        Integer[] result = new Integer[matrix.length * matrix[0].length];
        int count = 0;
        int upperRowIndex = 0;
        int leftColumnIndex = 0;
        int lowerRowIndex = matrix.length-1;
        int rightColumnIndex = matrix[0].length-1;

        makeMatrixRound(matrix, result, count, upperRowIndex, leftColumnIndex, lowerRowIndex, rightColumnIndex);
        return Arrays.asList(result);
    }

    private static void makeMatrixRound(int[][] matrix, Integer[] result, int count, int upperRowIndex,
                                        int leftColumnIndex, int lowerRowIndex, int rightColumnIndex) {
        // horiz matrix[0] loop forwards i++ ->
        for(int i = leftColumnIndex; i<= rightColumnIndex; i++){
            result[count] = matrix[upperRowIndex][i];
            count++;
            if(count == result.length){
                return;
            }
        }
        upperRowIndex++;

        // vertical matrix loop forwards i++ \/
        for(int i = upperRowIndex; i<= lowerRowIndex; i++){
            result[count] = matrix[i][rightColumnIndex];
            count++;
            if(count == result.length){
                return;
            }
        }
        rightColumnIndex--;

        // horiz matrix[0] loop backwards i--  <-
        for(int i = rightColumnIndex; i>=leftColumnIndex; i--){
            result[count] = matrix[lowerRowIndex][i];
            count++;
            if(count == result.length){
                return;
            }
        }

        lowerRowIndex--;

        // vertical matrix loop backwards i-- /\
        for(int i = lowerRowIndex; i>= upperRowIndex; i--){
            result[count] = matrix[i][leftColumnIndex];
            count++;
            if(count == result.length){
                return;
            }
        }
        leftColumnIndex++;
        makeMatrixRound(matrix, result, count, upperRowIndex, leftColumnIndex, lowerRowIndex, rightColumnIndex);
    }

}