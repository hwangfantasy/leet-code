/**
 * Created by hwangfantasy on 2017/8/30.
 * 自己实现将string字符串转成integer
 * <p>
 * 思路
 * 字符串题一般考查的都是边界条件、特殊情况的处理。所以遇到此题一定要问清楚各种条件下的输入输出应该是什么样的。这里已知的特殊情况有：
 * <p>
 * 能够排除首部的空格，从第一个非空字符开始计算
 * 允许数字以正负号(+-)开头
 * 遇到非法字符便停止转换，返回当前已经转换的值，如果开头就是非法字符则返回0
 * 在转换结果溢出时返回特定值，这里是最大/最小整数
 * 注意
 * 检查溢出时最大整数要先减去即将加的最末位再除以10，来处理"2147483648"类似的情况
 */
public class StringToInteger {
    public int atoi(String s) {
        boolean isPositive = true;
        s = s.trim();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char index = s.charAt(i);
            //正负号开头判断正负后从下一位开始
            if (i == 0 && (index == '+' || index == '-')) {
                isPositive = index == '+';
            } else if (index >= '0' && index <= '9') {
                // 先检查加上当前这一位会不会溢出，再决定是否加上这一位
                // 但是如果直接改变result的值来比较的话可能result直接溢出就无法比较了，所以要对MAX_VALUE反过来处理
                if (result > (Integer.MAX_VALUE - (index - '0')) / 10) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10;
                result = result + (index - '0');
            } else {
                return isPositive ? result : -result;
            }

        }
        return isPositive ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println('9' - '0');
    }
}
