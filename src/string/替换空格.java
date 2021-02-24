package string;

public class 替换空格 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 遍历一遍字符串，统计空格的个数
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        if (count == 0) {
            return s;
        }
        // 由于一个空格字符替换成三个字符，所以替换后的总字符数要比原字符串总字符数多了：空格数乘以2
        for (int i = 0; i < count; i++) {
            s += "00";
        }
        // 将字符串转化为数组
        char[] ch = s.toCharArray();
        int newLen = ch.length;
        // 双指针：一个指向原字符串的末尾，一个指向新字符串末尾
        int i = len - 1;
        int j = newLen - 1;
        while (i != j) {
            if (ch[i] != ' '){
                ch[j] = ch[i];
                i--;
                j--;
            } else {
                ch[j] = '0';
                ch[j - 1] = '2';
                ch[j - 2] = '%';
                j = j - 3;
                i--;
            }
        }
        String str = new String(ch);
        return str;
    }
}
