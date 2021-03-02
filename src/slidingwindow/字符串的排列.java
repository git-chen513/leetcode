package slidingwindow;

import java.util.Arrays;

/**
 * 滑动窗口一般有两种套路的题型：
 *      一是窗口大小不固定，但是会有窗口限制条件，右指针无脑移动，左指针看情况收缩
 *      二是窗口大小固定，每次都是右指针和左指针同时移动一个单元格，依次改变窗口内容
 */
public class 字符串的排列 {
    /**
     * 滑动窗口解法一
     *  思路：窗口大小固定为s1字符串的长度，分别对字符串s1和窗口内的子串进行排序，判断是否相等，不等则整体右移窗口
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        // 对字符串s1进行排序
        String str = sort(s1);
        // 滑动窗口的大小
        int len = s1.length();
        // 左指针
        int left = 0;
        // 右指针
        int right = len - 1;
        while (right < s2.length()) {
            // 对滑动窗口内的子串进行排序
            String sort = sort(s2.substring(left, right + 1));
            // 比较排好序的字符串s1和排好序的滑动窗口内的子串是否相等
            if (str.equals(sort)) {
                return true;
            } else {
                left++;
                right++;
            }
        }
        return false;
    }

    /**
     * 对字符串按照字典序进行
     * @param s
     * @return
     */
    public String sort(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }

    /**
     * 滑动窗口解法二
     *  思路：由于字符串只包含小写字母，因此可以用两个长度为26的数组充当哈希表统计字符串s1和滑动窗口内字符串各字符的出现个数，并比较这两个数组是否相等
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        // 滑动窗口的大小
        int len = s1.length();
        // 左指针
        int left = 0;
        // 右指针
        int right = len - 1;
        // 统计字符串s1各字符出现的次数
        for (int i = 0; i < len; i++) {
            ch1[s1.charAt(i) - 'a']++;
        }
        // 为了下面while循环的一致性，循环外面先统计滑动窗口的len-1个字符
        for (int j = 0; j < right; j++) {
            ch2[s2.charAt(j) - 'a']++;
        }
        while (right < s2.length()){
            ch2[s2.charAt(right) - 'a']++;
            if (Arrays.equals(ch1, ch2)) {
                return true;
            }
            ch2[s2.charAt(left) - 'a']--;
            left++;
            right++;
        }
        return false;
    }
}
