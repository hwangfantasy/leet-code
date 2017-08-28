/**
 * Created by hwangfantasy on 2017/8/28.
 * 找到一个字符串的最大回文子字符串
 * 如 abedebf 的最大回文子字符串为 bedeb
 * <p>
 * 解题思路:
 * 动态规划法，
 * 　　假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。那么可以推出：
 * 　　dp[ i ][ j ] = (dp[ i + 1][ j - 1] && s[ i ] == s[ j ])。
 * (也就是说字符串的i到j位为回文等同于，i+1位到j-1位为回文并且 i位的字符等于j位的字符)
 * 　　这是一般的情况，由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1，因此需要求出基准情况才能套用以上的公式：
 * 　　a. i + 1 = j -1，即回文子串长度为1时，dp[ i ][ i ] = true;
 * 　  b. i + 1 = (j - 1) -1，即回文子串长度为2时，就是i和它的下一位是相等的，就是类似 "abbf" 这种情况，dp[ i ][ i + 1] = （s[ i ] == s[ i + 1]）。
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        //字符串为1,本身就是回文
        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLength = 0;
        int len = s.length();
        String longest = "";
        boolean[][] dp = new boolean[len][len];

        //a情况，单个字符都算是回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            longest = s.substring(i, i + 1);
            maxLength = 1;
        }

        //b情况，回文子串长度为2
        for (int i = 0; i < len - 1; i++) {//i最多到长度-1
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                longest = s.substring(i, i + 2);
                maxLength = 2;
            }
        }

        //回文子串长度大于等于3开始
        for (int length = 3; length <= len; length++) {
            for (int i = 0, j; (j = i + length - 1) <= len - 1; i++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j] && maxLength < length) {
                        longest = s.substring(i, j + 1);
                        maxLength = length;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "abwwfwwb";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }
}
