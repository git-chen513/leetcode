package string;

import java.util.Arrays;

public class 有效的字母异位词 {
    /**
     * 哈希表：使用长度为26的数组作为哈希表
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        // 先统计一遍ch1数组，数组对应的位置使用++操作
        for (char c : ch1) {
            arr[c - 'a']++;
        }
        // 统计一遍ch2数组，数组对应的位置使用--操作
        for (char c : ch2) {
            arr[c - 'a']--;
        }
        // 遍历arr数组，如果遇到某个位置的值不等于0，即s和t并不互为异位词
        for (int a : arr) {
            if (a != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将字符串转换为字符数组，对数组进行排序，判断排序后的数组是否相同
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }
}
