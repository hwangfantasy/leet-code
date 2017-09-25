/**
 * Created by hwangfantasy on 2017/9/25.
 * <p>
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * 罗马数字对应：
 * <p>
 * 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
 * <p>
 * 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
 * <p>
 * 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
 * <p>
 * 1000~3000: {"M", "MM", "MMM"}.
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int ret = toNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (toNumber(s.charAt(i - 1)) < toNumber(s.charAt(i))) {
                ret += toNumber(s.charAt(i)) - 2 * toNumber(s.charAt(i - 1));
            } else {
                ret += toNumber(s.charAt(i));
            }
        }
        return ret;
    }

    private int toNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
