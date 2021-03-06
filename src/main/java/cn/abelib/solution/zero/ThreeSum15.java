package cn.abelib.solution.zero;

import java.util.*;

/**
 *
 * @author abel-huang
 * @date 2016/8/10
 * 1. Sort the array.
 * 2. Change the 3 sum to a target and a 2 sum problem.
 * 3. Delete all duplicate.
 * 4. Be careful of the range.
 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            find(nums, i + 1, len - 1, nums[i], lists);
        }
        return lists;
    }

    private void find(int[] nums, int begin, int end, int target, List<List<Integer>> lists) {
        int left = begin;
        int right = end;
        while (left < right) {
            if (nums[left] + nums[right] + target == 0) {
                List<Integer> ans = new ArrayList<>();
                ans.add(nums[left]);
                ans.add(nums[right]);
                ans.add(target);
                lists.add(ans);
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            } else if (nums[left] + nums[right] + target < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}
