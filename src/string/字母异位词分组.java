package string;

import java.util.*;

public class 字母异位词分组 {
    /**
     * 方法一：对于每个字符串，用一个长度为26的数组充当哈希表统计每个字符出现的次数
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        // 创建一个哈希表，哈希表的key存放每一组字母异位词的一个标志（即对这个字母异位词中的一个单词进行按字典排序）
        // 哈希表的value是一个列表，存放属于同一分组的字符串
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            // 由于字符串都只有小写字母，因此可以用一个长度为26的数组来统计每一个单词中字符出现的次数
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
            }
            // 遍历字符数组arr，将字符从小到大重新拼接成一个字符串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                while (arr[i] != 0) {
                    sb.append((char)('a' + i));
                    arr[i]--;
                }
            }
            String str = sb.toString();
            List<String> list = map.getOrDefault(str, new ArrayList<String>());
            list.add(s);
            map.put(str, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 方法二：对于每个字符串，直接使用排序方法进行按照字典序排序
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        // 创建一个哈希表，哈希表的key存放每一组字母异位词的一个标志（即对这个字母异位词中的一个单词进行按字典排序）
        // 哈希表的value是一个列表，存放属于同一分组的字符串
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            List<String> list = map.getOrDefault(str, new ArrayList<String>());
            list.add(s);
            map.put(str, list);
        }
        return new ArrayList<>(map.values());
    }
}
