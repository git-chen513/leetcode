package slidingwindow;

public class 长度最小的子数组 {
    // 暴力解法：双重for循环
    public static int minSubArrayLen1(int s, int[] nums) {
        int sum = 0;
        int len = 0;
        for (int i = 0; i <nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    len = (len == 0) ? (j - i + 1) : Math.min(len, j - i + 1);
                    break;
                }
            }
        }
        return len;
    }

    // 滑动窗口
    public static int minSubArrayLen2(int s, int[] nums) {
        int sum = 0;
        int len = 0;
        int i = 0;//指定起始位置
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = (len == 0) ? (j - i + 1) : Math.min(len, j - i + 1);
                sum -= nums[i++];//缩小窗口大小
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen2(7, nums));
    }
}
