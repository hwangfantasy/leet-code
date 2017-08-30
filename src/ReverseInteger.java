/**
 * Created by hwangfantasy on 2017/8/30.
 * <p>
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 * 思路
 * 通过对数字模十取余得到它的最低位。其实本题考查的是整数相加的溢出处理，检查溢出有这么几种办法：
 * 两个正数数相加得到负数，或者两个负数相加得到正数，但某些编译器溢出或优化的方式不一样
 * 对于正数，如果最大整数减去一个数小于另一个数，或者对于负数，最小整数减去一个数大于另一个数，则溢出。这是用减法来避免加法的溢出。
 * 使用long来保存可能溢出的结果，再与最大/最小整数相比较
 */
public class ReverseInteger {
    public int reverse(int x) {
        long result = 0;
        int temp = Math.abs(x);
        while (temp > 0) {
            //从个位开始
            result = result * 10;
            result = result + temp % 10;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            temp = temp / 10;
        }
        return (int) (x >= 0 ? result : -result);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(123));
    }
}
