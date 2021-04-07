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
        // 使用双端队列
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            // 如果队列不为空，则判断队尾元素是否少于nums[i]，如果少于，则需要执行出队操作----这样队列里只保留了比nums[i]大的元素
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.removeLast();
            }
            // 入到队列尾部
            queue.addLast(i);

            // 判断队列头部元素是否有效（有效的定义就是：队列中的元素个数不能超过k个，超过了就要移除头部元素，保证队列中最多只有 k 个元素）
            if(queue.peekFirst() < i-k+1){
                queue.removeFirst();
            }

            // 判断遍历到的下标，是否满足滑动窗口的元素个数（例如 k=3时，遍历下标 0 1 时，滑动窗口中的元素个数是不够3个的，只有遍历到下标2后，滑动窗口中的元素才够3个）
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }


        return result;
    }


}


