import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hwangfantasy on 2017/8/22.
 *
 * @question： Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {3, 2, 4};
        int target = 6;

        long start1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(twoSum.twoSum1(nums, target)));
        long end1 = System.currentTimeMillis();
        System.out.println("twoSum1 spend time :" + (end1 - start1));

        long start2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(twoSum.twoSum2(nums, target)));
        long end2 = System.currentTimeMillis();
        System.out.println("twoSum2 spend time :" + (end2 - start2));
    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("No two nums add equals target");
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference))
                return new int[]{i, map.get(difference)};
            else
                map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two nums add equals target");
    }
}
