package jianzhioffer.simple;

/**
 * @Author Baker.chen
 * @create 2020/11/28 15:08
 */
public class 左旋转字符串 {

    /**
     * 方法一：借助额外空间StringBuilder
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords1(String s, int n) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (n <= 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 方法二：使用String自带的substring方法
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords2("lrloseumgh", 6));
    }
}
