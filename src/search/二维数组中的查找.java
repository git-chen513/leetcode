package search;

/**
 * 思路：可以从二维数组的左下角开始搜索，比它大的可以往右边一列搜索，比小的可以往上面一行搜索
 *      也可以从二维数组的右上角开始搜索，比它大的可以往下面一行搜索，比小的可以往左边一列搜索
 */
public class 二维数组中的查找 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        return findNumberIn2DArray(matrix, target, matrix.length - 1, 0);
    }
    /**
     * 递归的二分法（从二维数组的左下角开始搜索）
     * @param matrix
     * @param target
     * @param row：行下标
     * @param column：列下标
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target, int row, int column) {
        if (row < 0 || column >= matrix[0].length) {
            return false;
        }
        int temp = matrix[row][column];
        if (target < temp) {
            return findNumberIn2DArray(matrix, target, row-1, column);
        } else if (target > temp) {
            return findNumberIn2DArray(matrix, target, row, column+1);
        } else {
            return true;
        }
    }

    /**
     * 非递归的二分法（从二维数组的左下角开始搜索）
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int len1 = matrix.length; //行数
        int len2 = matrix[0].length; //列数
        int row = len1 - 1;
        int column = 0;
        while (row >= 0 && column < len2) {
            if (target < matrix[row][column]) {
                row--;
            } else if (target > matrix[row][column]){
                column++;
            } else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(findNumberIn2DArray(arr, 20));
    }
}
