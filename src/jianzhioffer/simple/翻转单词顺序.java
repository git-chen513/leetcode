package jianzhioffer.simple;

/**
 * @Author Baker.chen
 * @create 2020/11/29 23:01
 */
public class 翻转单词顺序 {
    public static String reverseWords1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String s1 = s.trim();
        String s2 = s1.replaceAll("[ ]{2,}", " ");
        String[] str = s2.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i] + " " );
        }
        return sb.toString().trim();
    }

    /**
     * 方法二：使用双指针
     * @param s
     * @return
     */
    public static String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 先去除首尾空格
        String str = s.trim();
        int i = str.length() - 1;
        int j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && str.charAt(i) != ' ') {
                i--;
            }
            sb.append(str.substring(i + 1, j + 1) + " ");
            while (i >= 0 && str.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "the sky   is blue";
        System.out.println(reverseWords2(s));
    }
}
