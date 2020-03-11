package com.fight.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人
 *
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人的最大欧式距离的平方。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 *
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0307_1_WalkingRobotSimulation {
    public static void main(String[] args) {
    }

    class Solution {

        public int robotSim(int[] commands, int[][] obstacles) {
            Set<String> set = new HashSet<>();
            for (int[] obstacle : obstacles) {
                set.add(obstacle[0] + "-" + obstacle[1]);
            }

            int[] pos = {0, 0};
            int deg = 90;
            int ans = 0;

            for (int command : commands) {
                if (command == -2) {
                    deg = (deg + 90) % 360;
                } else if (command == -1) {
                    deg = (deg + 270) % 360;
                } else {
                    switch (deg) {
                        case 0:
                            while (command > 0 && !set.contains(pos[0] + 1 + "-" + pos[1])) {
                                pos[0]++;
                                command--;
                            }
                            break;
                        case 90:
                            while (command > 0 && !set.contains(pos[0] + "-" + (pos[1] + 1))) {
                                pos[1]++;
                                command--;
                            }
                            break;
                        case 180:
                            while (command > 0 && !set.contains(pos[0] - 1 + "-" + pos[1])) {
                                pos[0]--;
                                command--;
                            }
                            break;
                        case 270:
                            while (command > 0 && !set.contains(pos[0] + "-" + (pos[1] - 1))) {
                                pos[1]--;
                                command--;
                            }
                            break;
                    }
                    ans = Math.max(ans, (int) (Math.pow(pos[0], 2) + Math.pow(pos[1], 2)));
                }
            }
            return ans;
        }
    }
}
