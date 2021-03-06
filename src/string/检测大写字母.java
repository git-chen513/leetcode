package string;

public class 检测大写字母 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 0) {
            return false;
        }
        char[] ch = word.toCharArray();
        // 分别统计大写字母和小写字母的个数
        int upper = 0; // 大写
        int lower = 0; // 小写
        for (char c : ch) {
            // 由于题目限定了字符串只有大小写字母，因此这个判断条件足矣
            if (c >= 97) {
                lower++;
            } else {
                upper++;
            }
        }
        //分三种情况讨论：
        // 1. 如果大写字母个数等于字符串的长度，说明字符串只由大写字母组成，满足要求
        if (upper == ch.length) {
            return true;
        }
        // 2. 如果大写字母的个数为0，说明字符串只由小写字母组成，满足要求
        if (upper == 0) {
            return true;
        }
        // 3. 如果大写字母的个数为1，并且字符串第一个字符为大写字母，满足要求
        if (upper == 1 && ch[0] < 97) {
            return true;
        }
        return false;
    }
}
