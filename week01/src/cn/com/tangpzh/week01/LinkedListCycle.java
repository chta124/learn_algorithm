package cn.com.tangpzh.week01;


import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode linkedList = ListNode.initListNode(100);
//        linkedList.tail.next = linkedList.head;

        System.out.println(LinkedListCycle.method1(linkedList));

        System.out.println(LinkedListCycle.method2(linkedList));
    }

    /**
     * 利用HashSet的特性来筛选是否有环
     */
    public static boolean method1(ListNode node){
        if(node == null || node.next == null){
            return false;
        }
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        ListNode temp = node;
        while(node !=null && node.next != null){
            if(!nodeSet.add(node)){
                return true;
            }
            node = node.next;
        }

        return false;
    }


    public static boolean method2(ListNode node){
        if(node == null || node.next == null){
            return false;
        }
        // 慢指针
        ListNode slow = node;
        // 快指针
        ListNode fast = node.next;
        // 快、慢指针没有相遇，就一直循环
        while(slow != fast){
            // 快指针已经走完一遍了，但是还没有和慢指针相遇，就文明没有环
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // 说明遇到了环
        return true;
    }


}
