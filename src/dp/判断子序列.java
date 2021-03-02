package dp;

public class 判断子序列 {

    /**
     * 方法一：使用双指针法
     * @param s
     * @param t
     * @return
     */
    public static boolean test1(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int len1 = s.length();
        int len2 = t.length();
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (c2[j] == c1[i]) {
                j++;
                i++;
            } else {
                j++;
            }
        }
        if (i == len1) {
            return true;
        } else {
            return false;
        }
    }
}
