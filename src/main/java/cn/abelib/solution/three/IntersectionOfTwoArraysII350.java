package cn.abelib.solution.three;

import java.util.*;

/**
 *
 * @author abel-huang
 * @date 2016/7/18
 * Use two hashmaps to save each element's total number.
 */
public class IntersectionOfTwoArraysII350 {
    public static void main(String args[]) {
        int[] a = {1, 1};
        int[] b = {1, 2};
        int[] c = intersect(a, b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> hashMap1 = new HashMap<>();
        Map<Integer, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!hashMap1.containsKey(nums1[i])) {
                hashMap1.put(nums1[i], 1);
            } else {
                hashMap1.put(nums1[i], hashMap1.get(nums1[i]) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!hashMap2.containsKey(nums2[i])) {
                hashMap2.put(nums2[i], 1);
            } else {
                hashMap2.put(nums2[i], hashMap2.get(nums2[i]) + 1);
            }
        }
        Iterator<Integer> iterator = hashMap1.keySet().iterator();
        List<Integer> list = new ArrayList<>();
        while (iterator.hasNext()) {
            Integer keyWord = iterator.next();
            if (hashMap2.containsKey(keyWord)) {
                int range = Math.min(hashMap1.get(keyWord), hashMap2.get(keyWord));
                while (range > 0) {
                    list.add(keyWord);
                    range--;
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
