package cn.com.tangpzh.week01;

/**
 *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapNodesInPairs {


    public static void main(String[] args) {

        ListNode head = ListNode.initListNode(9);
        System.out.println("原链表：" + head);
        ListNode newHead = SwapNodesInPairs.method2(head);
        System.out.println("新链表：" + newHead);

    }

    /**
     * 递归方法
     * @param head
     * @return
     */
    public static ListNode method1(ListNode head){
        // 链表为空或者链表中只有一个元素的时候，递归结束
        if(head == null || head.next == null){
            return head;
        }

        // newHead表示新的链表，新链表的第一个元素是原链表的第二个元素    2-->
        ListNode newHead = head.next;
        // 原链表的第一个元素的next就是下一次递归后的得到的链表的第一个元素    1-->
        head.next = method1(newHead.next);
        // 新链表的第二个元素是原链表的第一个元素    2-->1
        newHead.next = head;
        return newHead;
    }

    /**
     * 遍历法
     * @param head
     * @return
     */
    public static ListNode method2(ListNode head){
        // 设置一个新的头节点
        ListNode newHead = new ListNode(-1);
        // 将新的头节点的next指向head
        newHead.next = head;
        // 设置一个临时节点，用于标记接下来要交换的两个节点的前置节点
        // temp-->1-->2 ，接下来的一次交换是对节点 temp 1 2进行操作，交换 1 和 2节点
        // 2-->1-->3-->4 这时temp指向1，接下来的一次交换是 对节点 1 3 4进行操作，交换 3 和 4节点
        // 2-->1-->4-->3-->5-->6 这时temp指向3，接下来的一次交换是 对节点  3 5 6进行操作，交换 5 和 6节点
        ListNode tempNode = newHead;
        while(tempNode !=null && tempNode.next != null && tempNode.next.next != null){
            ListNode node1 = tempNode.next;
            ListNode node2 = tempNode.next.next;
            tempNode.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tempNode = node1;
        }

        return newHead.next;
    }

}
