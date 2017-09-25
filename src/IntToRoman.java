/**
 * Created by hwangfantasy on 2017/9/25.
 * Given an integer, convert it to a roman numeral.
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
public class IntToRoman {
    public String intToRoman(int num) {
        String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        String ret = "";
        int digit = 0;
        while (num != 0) {
            int remain = num % 10;
            ret = roman[digit][remain] + ret;
            digit++;
            num /= 10;
        }
        return ret;
    }
}
