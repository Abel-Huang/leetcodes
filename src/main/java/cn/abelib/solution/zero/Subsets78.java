package cn.abelib.solution.zero;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: abel.huang
 * @Date: 2020-02-19 20:56
 */
public class Subsets78 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        backtracking(list, nums, 0);
        return lists;

    }

    private void backtracking(List<Integer>list, int[] nums, int start){
        lists.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            backtracking(list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,3};
        System.err.println(  subsets(nums));

    }
}
