package hashtable;

import java.util.HashMap;
import java.util.Map;

public class 赎金信 {
    /**
     * 哈希法
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 0) {
            return true;
        }
        if (magazine.length() == 0) {
            return false;
        }
        // 用一个Map集合统计magazine字符串中各字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = magazine.toCharArray();
        for (char c : ch) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // 遍历ransomNote字符串的每个字符，看看是否能在Map集合中找到对应的字符
        // 由于杂志字符串中的每个字符只能在赎金信字符串中使用一次，因此每次都要将对应的value减一
        char[] chars = ransomNote.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 改进：由于两个字符串均只含有小写字母，因此可以使用一个长度为26的数组来做哈希表，可以减小空间复杂度
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() == 0) {
            return true;
        }
        if (magazine.length() == 0) {
            return false;
        }
        // 用一个长度为26的数组充当哈希表统计magazine字符串中各字符出现的次数，下标为0代表字符a，以此类推
        int[] nums = new int[26];
        char[] ch = magazine.toCharArray();
        for (char c : ch) {
            nums[c - 'a']++;
        }
        // 遍历ransomNote字符串的每个字符
        // 由于杂志字符串中的每个字符只能在赎金信字符串中使用一次，因此每次都要将对应的值减一
        char[] chars = ransomNote.toCharArray();
        for (char c : chars) {
            if (nums[c - 'a'] <= 0) {
                return false;
            } else {
                nums[c - 'a']--;
            }
        }
        return true;
    }
}
