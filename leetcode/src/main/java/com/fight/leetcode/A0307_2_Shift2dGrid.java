package com.fight.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * <p>
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shift-2d-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0307_2_Shift2dGrid {
    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            while (k > 0) {
                int[][] tmp = new int[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        tmp[i][j + 1] = grid[i][j];
                    }
                }
                for (int i = 0; i < m - 1; i++) {
                    tmp[i + 1][0] = grid[i][n - 1];
                }
                tmp[0][0] = grid[m - 1][n - 1];
                grid = tmp;
                k--;
            }
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    list.add(grid[i][j]);
                }
                result.add(list);
            }
            return result;
        }
    }

    class Solution2 {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid[0].length;
            int n = grid.length;
            int length = (m==0 || n==0) ? m+n : m*n ;
            int[] array = new int[length];
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++){
                    System.out.println(i*n + j);
                    array[i*n + j] = grid[i][j];
                }
            }
            System.out.println(Arrays.toString(array));
            move(array, k);
            System.out.println(Arrays.toString(array));

            List<List<Integer>> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                List<Integer> tmp = new ArrayList<>();
                for(int j=0; j<m; j++){
                    tmp.add(array[i*n + j]);
                }
                list.add(tmp);
            }
            return list;
        }

        public void move(int[] array, int k) {
            k = k % array.length;
            int n = array.length;
            reverse(array, 0, n-k-1);
            reverse(array, n-k, n -1);
            reverse(array, 0, n -1);
        }

        public void reverse(int[] array, int begin, int end) {
            while(begin < end) {
                int tmp = array[begin];
                array[begin++] = array[end];
                array[end--] = tmp;
            }
        }
    }
}
