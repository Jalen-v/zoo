package com.fight.leetcode;

/**
 * 26. 删除排序数组中的重复项
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0109_2_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        Solution solution = new A0109_2_RemoveDuplicatesFromSortedArray().new Solution();

        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = solution.removeDuplicates(nums);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 双指针法
     */
    class Solution {
        public int removeDuplicates(int[] nums) {
            int low = 0;
            int fast = 0;
            for (int i = 0; i<nums.length; i++) {
                if (nums[low] != nums[fast]) {
                    low++;
                    nums[low] = nums[fast];
                }
                fast++;
            }
            return fast == 0 ? 0 : low+1;
        }
    }
}


