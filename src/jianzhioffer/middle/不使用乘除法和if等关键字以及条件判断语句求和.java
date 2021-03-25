package jianzhioffer.middle;

public class 不使用乘除法和if等关键字以及条件判断语句求和 {
    /**
     * 利用逻辑与的短路运算
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean flag = (n > 1 && (n += sumNums(n - 1)) > 0);
        return n;
    }
}
