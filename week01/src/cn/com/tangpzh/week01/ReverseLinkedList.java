package cn.com.tangpzh.week01;


import java.util.List;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList {

    public static void main(String[] args){
        ListNode sourceNode = ListNode.initListNode(5);
        System.out.println(sourceNode);
        ListNode targetNode = ReverseLinkedList.reverseList(sourceNode);
        System.out.println(targetNode);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
