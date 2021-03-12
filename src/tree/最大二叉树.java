package tree;

import java.util.Arrays;

public class 最大二叉树 {
    /**
     * 方法一：递归法，每次递归都要创建一个新数组，效率低
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 记录数组最大值
        int val = nums[0];
        // 记录数组最大值的下标
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > val) {
                val = nums[i];
                temp = i;
            }
        }
        // 创建一个根节点
        TreeNode root = new TreeNode(val);
        if (temp > 0) {
            // 说明左子树不为空，递归创建左子树
            root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, temp));
        }
        if (temp < nums.length - 1) {
            // 说明右子树不为空，递归创建右子树
            root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, temp + 1, nums.length));
        }
        return root;
    }

    /**
     * 方法二：递归法，通过下标界定，直接在原数组上操作，不需要创建新数组，效率高
     * 区间采用左闭右闭
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        // 记录数组最大值
        int val = nums[left];
        // 记录数组最大值的下标
        int temp = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > val) {
                val = nums[i];
                temp = i;
            }
        }
        // 创建一个根节点
        TreeNode root = new TreeNode(val);
        if (temp > left) {
            // 说明左子树不为空，递归创建左子树
            root.left = constructMaximumBinaryTree(nums, left, temp - 1);
        }
        if (temp < right) {
            // 说明右子树不为空，递归创建右子树
            root.right = constructMaximumBinaryTree(nums, temp + 1, right);
        }
        return root;
    }
}
