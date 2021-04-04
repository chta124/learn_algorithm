package cn.com.tangpzh.week01;


/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = new int[]{4, 3, 2, 1, 4};
        System.out.println(MaxArea.method1(height));
        System.out.println(MaxArea.method2(height));
    }

    /**
     * @description: 暴力解法--两层循环
     */
    public static int method1(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = height.length -1; j >= i+1; j--) {
                if (height[i] < height[j]) {
                    area = Math.max(area, (j - i) * height[i]);
                } else {
                    area = Math.max(area, (j - i) * height[j]);
                }
                if(height[j-1] < height[j]){
                    j--;
                }
            }
        }

        return area;
    }

    /**
     * @description: 双指针移动法
     */
    public static int method2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                // 说明左边的柱子比较短，需要移动左边的柱子-->往右移 i++
                area = Math.max(area, (j - i) * height[i++]);
            } else {
                // 说明右边的柱子比较短，需要移动右边的柱子-->往左移 j--
                area = Math.max(area, (j - i) * height[j--]);
            }
        }

        return area;
    }

}
