import java.util.HashMap;
import java.util.Map;

/**
 * Created by hwangfantasy on 2017/8/24.
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0, mark = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //mark标记上一次位置，如果有多次取最大的，因为是从左往右下标递增
                mark = Math.max(mark, map.get(s.charAt(i) + 1));
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - mark + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwweke"));
    }
}
