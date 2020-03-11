package com.fight.leetcode;

import java.util.HashMap;
import java.util.Map;

public class B0310_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

    }
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int result = 0;
            Map<Character, Integer> map = new HashMap<>();
            for(int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                Integer last = map.putIfAbsent(ch, i);
                if(last != null) {
                    left = Math.max(left, last+1);
                    map.put(ch, i);
                }
                result = Math.max(result, i - left +1);
            }
            return result;
        }
    }
}
