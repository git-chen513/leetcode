package string;

public class 验证回文串 {
    public boolean isPalindrome(String s) {
        if (s == " " || s == null || s.length() == 0) {
            return true;
        }
        // 由于不区分大小写，这里先将字符串中的所有字母转成小写
        s = s.toLowerCase();
        // 遍历一遍字符串s，将字母和数字提取出来，追加到sb
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                sb.append(s.charAt(i));
            }
        }
        // 用双指针判断回文串
        String str = sb.toString();
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 直接在原字符串上进行判断，不占用额外的空间
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        if (s == " " || s == null || s.length() == 0) {
            return true;
        }
        // 由于不区分大小写，这里先将字符串中的所有字母转成小写，方便判断
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            // 左指针找到字母或者数字字符
            while (i < j && !((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                i++;
            }
            // 右指针找到字母或者数字字符
            while (i < j && !((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
                j--;
            }
            if (i < j) {
                // 说明左右指针都找到字母或者数字字符
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
