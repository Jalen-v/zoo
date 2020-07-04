package com.zoo;

import java.math.BigInteger;

public class boss02 {
    public static void main(String[] args) {
        BigInteger ans = sumOfPrimeFactorial(100);
        System.out.println(ans);
    }

    /**
     * 计算数值n以内的质数的阶乘之和
     * @param n
     * @return
     */
    public static BigInteger sumOfPrimeFactorial(int n) {
        BigInteger ans = new BigInteger("0");
        for (int i = 0; i < n; i++) {
            if (isPrime(i)) {
                BigInteger factorial = getFactorial(i);
                ans = ans.add(factorial);
            }
        }
        return ans;
    }

    /**
     * 判断n是否为素数
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        // 非素数必定含有一个小于等于它平方根的因子。
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算n的阶乘
     * @param n
     * @return
     */
    private static BigInteger getFactorial(int n) {
        if (n < 1) {
            return new BigInteger("0");
        }
        BigInteger ans = new BigInteger("1");
        while (n > 1) {
            ans = ans.multiply(BigInteger.valueOf(n--));
        }
        return ans;
    }
}

/**
 将硬币分为A、B两堆，A堆分10枚，B堆分13枚，将A堆的所有硬币反转，即能满足两堆硬币正面朝上的一样多；
 证明：
 设B堆里面有x个正面朝上的硬币，则A堆里面有10-x个正面朝上的硬币；
 将A堆全部反转，A堆里面正面朝上的硬币数是10-（10-x）=x
 */
