package backtracking;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    // 数字i代表的字母对应numbers[i]（题目说字符串只包含2-9，因此可以不考虑其他特殊情况）
    String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<Character> ch = new ArrayList<>();
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtracking(digits, 0, ch, res);
        return res;
    }
    // index用来表示遍历到参数字符串digits的第几个数字（index从0开始）
    public void backtracking(String digits, int index, List<Character> ch, List<String> res) {
        // 递归终止的条件：当字符列表ch的长度等于参数字符串digits的长度
        // 递归出口记得加上return，否则会死循环
        if (ch.size() == digits.length()) {
            String s = "";
            for (int i = 0; i < ch.size(); i++) {
                s += ch.get(i);
            }
            res.add(s);
            return;
        }
        int temp = digits.charAt(index) - '0';
        for (int i = 0; i < numbers[temp].length(); i++) {
            ch.add(numbers[temp].charAt(i));
            backtracking(digits, index + 1, ch, res);
            ch.remove(ch.size() - 1);
        }
    }
}
