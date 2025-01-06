import  java.util.HashMap;
import  java.util.Arrays;

class TwoSumSolution {

    public static void main (String[] args) {
        int[] nums = {1,2,3};
        TwoSumSolution solution = new TwoSumSolution();
        int[] twoSum = solution.twoSum(nums, 5);
        System.out.println(Arrays.toString(twoSum));
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int[] result = {0, 0};
        
        for(int i=0; i< nums.length; i++) {
            int searched = target - nums[i];
            if (map.containsKey(searched)) {
                result[0] = map.get(searched);
                result[1] =  i;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}