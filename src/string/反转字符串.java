package string;

public class 反转字符串 {
    /**
     * 方法一：双指针
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }
    /**
     * 方法二：使用StringBuilder
     * @param s
     */
    public void reverseString1(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            sb.append(s[i]);
        }
        for (int j = 0; j < s.length; j++) {
            s[j] = sb.toString().charAt(j);
        }
    }
}
