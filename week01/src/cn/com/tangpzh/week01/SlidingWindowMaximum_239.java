package cn.com.tangpzh.algorithm;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * <p>
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * <p>
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SlidingWindowMaximum_239 {

    public static void main(String[] args) {
        SlidingWindowMaximum_239 test = new SlidingWindowMaximum_239();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] result = test.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 2) {
            return nums;
        }
        int len = nums.length;
        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);

            if(queue.peekFirst() < i-k+1){
                queue.removeFirst();
            }

            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }


        return result;
    }


}


