import  java.util.HashMap;
import  java.util.Arrays;

class NumbersSmallerSolution {

    public static void main (String[] args) {
        int[] nums = {8,1,2,2,3};
        NumbersSmallerSolution solution = new NumbersSmallerSolution();
        int[] result = solution.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] copy = nums.clone();
        // clone array because sort overwrites it
        Arrays.sort(copy);
        // no need to create a separate result array, copy array can be reused after hashmap filling

        HashMap<Integer, Integer> map = new HashMap();

        // important to check if number was not added before to avoid overwriting
        for(int i=0; i<copy.length; i++) {
           map.putIfAbsent(copy[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            copy[i] = map.get(nums[i]);
        }

        return copy;
    }
}