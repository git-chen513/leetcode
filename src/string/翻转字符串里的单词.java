package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 翻转字符串里的单词 {
    /**
     * 方法一：双指针
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // 先去除字符串首尾多余的空格
        String str = s.trim();
        int right = str.length() - 1;
        int left = str.length() - 1;
        StringBuilder sb = new StringBuilder();
        // 从后往前遍历
        while (left >= 0) {
            while (left >= 0 && str.charAt(left) != ' ') {
                left--;
            }
            // 退出循环说明左指针已经到达空格位置了，将下标为[left + 1, right]的子串拼接到sb字符串中
            // 每个单词后面需要拼接一个空格
            sb.append(str.substring(left + 1, right +1)).append(" ");
            while (left >= 0 && str.charAt(left) == ' ') {
                left--;
            }
            // 退出循环说明左指针已经指向了字符
            right = left;
        }
        // 由于最后一个单词也会拼接上一个空格，这里需进行处理
        return sb.toString().trim();
    }

    /**
     * 方法二：使用正则表达式和Java API进行操作
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        // 先去除字符串首尾多余的空格
        String str = s.trim();
        // 使用正则表达式对字符串str切分成字符串数组
        // （+代表前面的字符出现1次或多次，*代表前面的字符出现0次或多次，？代表前面的字符出现0次或1次）
        String[] split = str.split(" +");
        // 对split数组进行翻转（数组并没有提供翻转功能，可以将数组转化为List）
        List<String> list = Arrays.asList(split);
        Collections.reverse(list);
        // 使用字符串的拼接方法，将翻转后的list拼接成一个字符串
        return String.join(" ", list);
    }

    /**
     * 方法三思路：
     *  1. 先去除字符串多余空格
     *  2. 反转整个字符串
     *  3. 反转每个单词
     *
     * PS：由于第一步操作比较复杂，而第二步和第三步较为简单，因此这里只给出第一步的步骤
     *
     * 这里去除重复字符串的方法是使用快慢指针直接在原来的字符串数组上进行操作，
     * 并没有创建额外的空间，所以空间复杂度为O(1)
     * @param s
     * @return
     */
    public String test(String s) {
        // 先去除字符串首尾多余的空格
        String str = s.trim();
        char[] ch = str.toCharArray();
        int left = 0; // 慢指针
        int right = 0; // 快指针
        for (; right < ch.length; right++) {
            if (ch[right] != ' ') {
                ch[left] = ch[right];
                left++;
            } else {
                // 判断一下这个空格是不是多余的：如果前一个位置也是空格，说明当前空格是多余的
                if (ch[right - 1] == ' ') {
                    continue;
                } else {
                    ch[left] = ch[right];
                    left++;
                }
            }
        }
        return new String(Arrays.copyOfRange(ch, 0, left));
    }
}
