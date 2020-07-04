package com.zoo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3、正整数数组，实现一个方法，将数组中的数分组并输出，分组规则如下：
 * 1~10、11~100、101~1000、1001~10000 …… 10000001~100000000 ……
 * 输出的数据结构，需要自己定义；
 * 例：
 * public static grouping(long[] arr);
 */
public class GroupPrint {

    public static Map<Integer, List<Long>> grouping(long[] arr) {
        Map<Integer, List<Long>> ans = new HashMap<>();
        for (long ele : arr) {
            int bitNum = bitNumOf(ele - 1);
            List<Long> longs = ans.putIfAbsent(bitNum, Arrays.asList(ele));
            if (longs != null) {
                longs.add(ele);
            }
        }
        return ans;
    }

    public static int bitNumOf(long ele) {
        return String.valueOf(ele).length();
    }
}
