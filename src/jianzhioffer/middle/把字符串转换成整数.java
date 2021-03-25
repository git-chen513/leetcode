package jianzhioffer.middle;

public class 把字符串转换成整数 {
    public static int strToInt(String str) {
        // 去除首部多余空格
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) {
            return 0;
        }
        // i指向第一个非空格字符
        // 如果第一个非空格字符不是数字字符，也不是正负号，那么直接返回0
        if (!((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '-' || str.charAt(i) == '+')) {
            return 0;
        }
        // flag为true代表第一个有效字符为负号
        boolean flag = false;
        if (str.charAt(i) == '-') {
            flag = true;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            i++;
        }
        long res = 0;
        int INT_MAX = (int)(Math.pow(2, 31) - 1);
        int INT_MIN = -(int)(Math.pow(2, 31)) - 1;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }
        if ((flag == true) && (res > INT_MAX)) {
            // 负数越界
            return INT_MIN;
        } else if (res > INT_MAX) {
            // 正数越界
            return INT_MAX;
        } else {
            return flag ? -(int)res : (int)res;
        }
    }

    public static void main(String[] args) {
        System.out.println(strToInt("9223372036854775808"));
    }
}
