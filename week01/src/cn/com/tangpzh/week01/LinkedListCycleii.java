package cn.com.tangpzh.week01;


import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class LinkedListCycleii {

    public static void main(String[] args) {
        ListNode linkedList = ListNode.initListNode(5);
        linkedList.tail.next = linkedList.head.next;

        System.out.println(LinkedListCycleii.method1(linkedList).val);
    }

    /**
     * 利用HashSet的特性来筛选入环节点
     */
    public static ListNode method1(ListNode node){
        if(node == null || node.next == null){
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        while(node !=null && node.next != null){
            if(!nodeSet.add(node)){
                return node;
            }
            node = node.next;
        }

        return null;
    }

}
