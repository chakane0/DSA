package Arrays;
/*
    Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

    

    Example 1:

        Input: nums = [3,2,1]
        Output: 1
        Explanation:
        The first distinct maximum is 3.
        The second distinct maximum is 2.
        The third distinct maximum is 1.

    Example 2:

    Input: nums = [1,2]
        Output: 2
        Explanation:
        The first distinct maximum is 2.
        The second distinct maximum is 1.
        The third distinct maximum does not exist, so the maximum (2) is returned instead.

    Example 3:

        Input: nums = [2,2,3,1]
        Output: 1
        Explanation:
        The first distinct maximum is 3.
        The second distinct maximum is 2 (both 2's are counted together since they have the same value).
        The third distinct maximum is 1.
    
    Constraints:

        1 <= nums.length <= 10^4
        -2^31 <= nums[i] <= 2^31 - 1
        

    Follow up: Can you find an O(n) solution?
 */

public class ThirdMaximum {
    public static void main(String[] args) {
        int[] nums = {  3, 2, 1 };
        int result = thirdMax(nums);
        System.out.println(result);

    }


    public static int thirdMax(int[] nums) {
        Integer max = null;
        Integer second_max = null;
        Integer third_max = null;

        for(Integer num : nums) {

            if(num.equals(max) || num.equals(second_max) || num.equals(third_max)) {
                continue;
            }

            if(max == null || num > max) {
                third_max = second_max;
                second_max = max;
                max = num;
            } else if(second_max == null || num > second_max) {
                third_max = second_max;
                second_max = num;
            } else if(third_max == null || num > third_max) {
                third_max = num;
            }
        }

        if(third_max == null) {
            return max;
        }

        return third_max;
    }
}
