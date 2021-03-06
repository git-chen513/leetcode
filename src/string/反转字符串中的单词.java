package string;

import java.util.Arrays;

public class 反转字符串中的单词 {
    /**
     * 方法一：先对字符串按照空格进行切分，然后遍历字符串数组str，依次对每个单词进行反转
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // 对字符串按照空格进行切分
        String[] str = s.split(" ");
        // 遍历字符串数组str，依次对每个单词进行反转
        for (int i = 0; i < str.length; i++) {
            str[i] = reverse(str[i]);
        }
        return String.join(" ", str);
    }
    /**
     * 反转字符串：双指针法
     * @param s
     * @return
     */
    public String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] ch = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char c = ch[left];
            ch[left] = ch[right];
            ch[right] = c;
            left++;
            right--;
        }
        return new String(ch);
    }

    /**
     * 方法二：使用双指针直接从前往后反转每一个单词
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        int left = 0;
        int right = 0;
        char[] ch = s.toCharArray();
        while (right < s.length()) {
            while (right < s.length() && ch[right] != ' ') {
                right++;
            }
            // 退出循环说明已经找到第一个单词了，区间为[left,right - 1]
            reverse(ch, left, right - 1);
            right++;
            left = right;
        }
        return new String(ch);
    }
    /**
     * 对字符串数组ch的子区间[left,right]进行翻转
     * @param ch
     * @param left
     * @param right
     */
    public void reverse(char[] ch, int left, int right) {
        while (left < right) {
            char c = ch[left];
            ch[left] = ch[right];
            ch[right] = c;
            left++;
            right--;
        }
    }
}
