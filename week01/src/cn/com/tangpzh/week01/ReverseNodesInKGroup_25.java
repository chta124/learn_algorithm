package cn.com.tangpzh.week01;

/**
* 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *  
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 * 示例 3：
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 *
 * 示例 4：
 * 输入：head = [1], k = 1
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class ReverseNodesInKGroup_25 {

    public static void main(String[] args) {
        ReverseNodesInKGroup_25 test = new ReverseNodesInKGroup_25();
        ListNode head = ListNode.initListNode(10);
        System.out.println(test.reverseKGroup(head, 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;// 【待翻转子链表】的前驱节点
        ListNode end = dummy;// 【待翻转子链表】的结束节点（需要遍历k次后，得到真正的end节点）

        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                end = end.next;
                // 说明不够 k 个节点，直接跳出循环，结束
                if (end == null) {
                    break;
                }
            }
            // 说明不够 k 个节点了，直接跳出循环，结束
            if (end == null) {
                break;
            }

            ListNode start = prev.next;
            ListNode next = end.next;// 子链表的[end]节点的下一个节点，待子链表翻转完成后，需要用到这个节点，将子链表接回至主链表
            end.next = null;// 将本次要翻转的子链表的[end]节点的next置为null----相当于将子链表从主链表上截断了，等子链表翻转完成后再接上
            prev.next = reverse(start);
            start.next = next;// 翻转完成后，将子链表接回主链表上----原来的start节点就是新的end节点了
            prev = start;// 新的[prev]节点就是翻转前的[end]节点，也就是翻转后的[start]节点
            end = prev;// 新的[end]节点就从[prev]节点开始往后遍历k次
        }


        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }



}
