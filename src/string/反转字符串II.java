package string;

public class 反转字符串II {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return s;
        }
        // 1. 如果剩余字符少于 k 个，则将剩余字符全部反转
        if (s.length() < k) {
            // 将整个字符串反转
            return reverseString(s);
        }
        // 2. 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
        if (s.length() >= k && s.length() < (2 * k)) {
            // 对前k个字符进行反转
            return reverseString(s.substring(0, k)) + (s.substring(k));
        }
        // 字符串长度大于2k，对前k个字符进行反转，并且对2k个字符之后的字符进行递归反转
        return reverseString(s.substring(0, k)) + s.substring(k, 2 * k) + reverseStr(s.substring(2 * k), k);
    }
    /**
     * 对字符串进行反转：双指针
     * @param s
     */
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        while (i < j) {
            char c = ch[i];
            ch[i] = ch[j];
            ch[j] = c;
            i++;
            j--;
        }
        return new String(ch);
    }
}
