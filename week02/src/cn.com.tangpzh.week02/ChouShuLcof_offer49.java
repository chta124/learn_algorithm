package cn.com.tangpzh.week02;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ChouShuLcof_offer49 {

    public static void main(String[] args) {
        ChouShuLcof_offer49 test = new ChouShuLcof_offer49();
        System.out.println(test.method1(1402));
        System.out.println(test.method2(1402));
    }

    /**
     * 小根堆实现
     *
     * @param n
     * @return
     */
    public int method1(int n) {
        // 质因子
        int[] factors = {2, 3, 5};
        long maxUgly = 0;
        // 利用hash来去重
        Set<Long> visited = new HashSet<Long>();
        // 使用小根堆来实现
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>((o1, o2) -> o1>o2?1:-1);
//        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        // 最小的丑数是1
        minHeap.offer(1L);
        visited.add(1L);
        for (int i = 0; i < n; i++) {
            // 从小根堆中取出堆顶元素（最小值）
            long curr = minHeap.poll();
            maxUgly = curr;
            // for loop 依次将丑数的2倍、3倍、5倍数放入小根堆中
            for (int factor : factors) {
                long next = factor * curr;
                // 去重处理
                if (visited.add(next)) {
                    minHeap.offer(next);
                }
            }
        }

        return (int) maxUgly;
    }

    /**
     * 动态规划（递推公式和动态规划还不太了解，需要多看多练习）
     *
     * @param n
     * @return
     */
    public int method2(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }

        return dp[n - 1];
    }

}
