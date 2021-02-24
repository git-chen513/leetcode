package backtracking;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        backtracking(s, 0, list, res);
        return res;
    }
    public void backtracking(String s, int startIndex, List<String> list, List<String> res) {
        // 递归终止的条件：因为要将字符串分割成四段，所以当list集合长度等于三，递归终止
        // 注意：并不是等到list集合长度等于四递归才终止，而是当集合长度等于三时，再判断剩余字符串是否有效，有效则加到res中
        if (list.size() == 3) {
            // 判断最后一段是否有效
            if (isValid(s.substring(startIndex))) {
                String str = "";
                for (int i = 0; i < list.size(); i++) {
                    str += list.get(i);
                    str += ".";
                }
                str += s.substring(startIndex);
                res.add(str);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 判断s的子串[startIndex, i]是否有效，无效则直接break退出for循环，因为后面的肯定也不符合
            if (!isValid(s.substring(startIndex, i + 1))) {
                break;
            }
            list.add(s.substring(startIndex, i + 1));
            backtracking(s, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
    /**
     * 判断字符串s代表的整数是否有效
     * （每个整数位于 0 到 255 之间组成，且不能含有前导 0，并且不能含有其他非数字字符）
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        // 判断是否含有前导0
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        // 遍历整个字符串，判断是否存在非数字字符
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return false;
            }
        }
        // 将字符串转换成整数，看看值的范围是否在0-255（如果值超过Integer范围会异常）
        try {
            int x = Integer.parseInt(s);
            if (x >= 0 && x <= 255) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
