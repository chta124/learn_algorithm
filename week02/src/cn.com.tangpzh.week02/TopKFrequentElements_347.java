package cn.com.tangpzh.week02;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * <p>
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequentElements_347 {

    public static void main(String[] args) {
        TopKFrequentElements_347 test = new TopKFrequentElements_347();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] result = test.method1(nums, 2);
        System.out.println(Arrays.toString(result));
    }

    public int[] method1(int[] nums, int k) {
        // 先利用hashMap统计数组中每个数字出现的次数
        Map<Integer, Integer> numCountMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 1) + 1);
        }

        // 利用大根堆来实现
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((int[] arry1, int[] arry2) -> (arry1[1] - arry2[1]));
        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (maxHeap.size() == k) {
                // 堆顶元素比下一个将要入堆的元素小的情况下，需要移除堆顶元素
                if (maxHeap.peek()[1] < count) {
                    maxHeap.poll();
                    maxHeap.offer(new int[]{num, count});
                }
            } else {
                maxHeap.offer(new int[]{num, count});
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = maxHeap.poll()[0];
        }
        return result;
    }


}
