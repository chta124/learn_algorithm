package cn.com.tangpzh.week01;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *  
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestRectangleInHistogram_84 {

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(LargestRectangleInHistogram_84.method2(heights));
    }

    /**
     * 使用【单调栈】来处理
     * @param heights
     * @return
     */
    public static int method2(int[] heights) {
        if (heights == null || heights.length <= 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        // 将数组的前面和后面补一个0元素
        // 添加哨兵*******************
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        heights = newHeights;
        int len = heights.length;

        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            // 如果后面的柱子高度比栈顶柱子的高度要小，则进行【出栈】操作，并计算每根柱子能够勾勒出来的矩形的最大面积。
            while (heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;
                area = Math.max(area, w * h);
            }
            // 如果后面的柱子高度比当前的柱子高度要高，则直接入栈
            // 即满意如下条件时入栈：heights[i] >= heights[stack.peek()]
            stack.push(i);
        }


        return area;
    }


}
