package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长不含重复字符的子字符串 {
    /**
     * 动态规划+哈希表
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        // 创建一个dp一维数组，dp[i]指的是以下标i为结尾的字符串的最长不含重复字符的子字符串长度
        // 注意：这个不含重复字符的子字符串是以下标i的字符为结尾的
        char[] ch = s.toCharArray();
        int len = ch.length;
        int dp[] = new int[len];
        // dp数组初始化：第一个字符一定不会重复
        dp[0] = 1;
        // 创建一个哈希表Map，用来记录子字符串中包含的字符以及对应的下标
        Map<Character, Integer> map = new HashMap<>();
        // 第一个字符先记录下来
        map.put(ch[0], 0);
        // 用来记录结果的最大值，不断更新
        int res = dp[0];
        // 从下标为1开始遍历
        for (int i = 1; i < len; i++) {
            // i - map.get(ch[i]) <= dp[i - 1] 这个判断条件至关重要（至于为什么要加，可以在纸上用"abba"这个字符串测试一下不加的话会产生什么效果）
            if (map.containsKey(ch[i]) && (i - map.get(ch[i]) <= dp[i - 1])) {
                // 递推公式一：如果前面的子字符串中已经包含此刻遍历的字符的情况
                dp[i] = i - map.get(ch[i]);
            } else {
                // 递推公式二：如果前面的子字符串中不包含此刻遍历的字符的情况
                dp[i] = dp[i - 1] + 1;
            }
            // 更新map
            map.put(ch[i], i);
            // 更新res
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 滑动窗口
     * 滑动窗口的限制条件：窗口内的字符串不含重复字符
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int left = 0; // 左指针
        int res = 0; // 保存结果的最大值，不断更新
        Set<Character> set = new HashSet<>(); // set集合主要用来存储窗口内的字符，便于判断是否存在重复字符
        char[] ch = s.toCharArray();
        for (int right = 0; right < ch.length; right++) {
            if (set.contains(ch[right])) {
                // 存在重复字符，则左指针需要收缩，直至不包含该重复字符
                while (ch[left] != ch[right]) {
                    set.remove(ch[left]);
                    left++;
                }
                left++;
            }
            set.add(ch[right]);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
