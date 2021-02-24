package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Baker.chen
 * @create 2021/1/29 23:43
 */
public class 分割回文串 {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        backtracking(s, 0, list, res);
        return res;
    }
    public void backtracking(String s, int startIndex, List<String> list, List<List<String>> res) {
        // 递归终止的条件：startIndex代表遍历到字符串s的哪个位置，当startIndex大于等于字符串s的长度时，说明找到一个切割组合了
        if (startIndex >= s.length()) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                temp.add(list.get(i));
            }
            res.add(temp);
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 判断s的子串[startIndex,i]是不是回文串，是则添加到list集合中，否则直接跳过该循环
            boolean flag = isPalindrome(s.substring(startIndex, i + 1));
            if (flag) {
                list.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backtracking(s, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
    /**
     * 判断一个字符串是不是回文串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
