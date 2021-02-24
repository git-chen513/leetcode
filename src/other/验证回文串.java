package other;

public class 验证回文串 {
    public static boolean isPalindrome(String s) {
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

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
}
