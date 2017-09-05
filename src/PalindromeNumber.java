/**
 * Created by hwangfantasy on 2017/9/5.
 * 判断一个数字是否为回文数字
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (0 <= x && x < 10)
            return true;
        if (x >= 10) {
            //判断是几位数,len会变成1,10,100,1000等
            int len = 1;
            while (x / len >= 10) {
                len = len * 10;
            }
            while (x > 0) {
                int left = x / len;
                int right = x % 10;
                if (left != right)
                    return false;
                else {
                    x = (x % len) / 10;
                    len = len / 100;
                }
            }
        }
        return true;
    }

}
