/**
 * Created by hwangfantasy on 2017/8/29.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * <p>
 * solution:
 * 就是要找到每一行的下标的规律
 * 第0行和最后一行中，前一个下标的值和后一个下标的值相差 2 * nRows - 2
 * 中间行中，前一个下标的值和后一个下标的值需要根据这个下标是该行中的奇数列还是偶数列来计算。
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 0)
            return "";
        if (numRows == 1)
            return s;

        StringBuilder res = new StringBuilder();
        int size = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += size) {
                //第一行和最后一行的处理
                res.append(s.charAt(j));
                //处理中间的行
                if (i != 0 && i != numRows - 1) {
                    int temp = j + size - 2 * i;
                    if (temp < s.length())
                        res.append(s.charAt(temp));
                }
            }
        }
        return res.toString();
    }
}
