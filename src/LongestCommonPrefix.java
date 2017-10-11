/**
 * Created by hwangfantasy on 2017/10/11.
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * 给定一个String类型数组，要求写一个方法，返回数组中这些字符串的最长公共前缀。
 * 举个例子：假如数组为["123","12","4"]，经过这个方法返回的结果就应该是""。
 * 因为"123"，"12"，"4"并没有共同的前缀，虽然"123"，"12"的公共最长前缀是"12"，
 * 但是这个公共前缀"12"与"4"没有公共前缀，所以最后返回的结果就是""。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs.length == 0)
            return prefix;
        prefix = strs[0];
        for (int i = 0, length = strs.length; i < length; i++) {
            while (strs[i].indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() - 1);
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"abab","ab",""};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
