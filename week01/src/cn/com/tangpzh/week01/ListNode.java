package cn.com.tangpzh.week01;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode tail;
    public ListNode head;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String ss = "";
        ListNode temp = this;
        while (temp != null) {
            ss += temp.val + (temp.next != null ? "-->" : "-->null");
            temp = temp.next;
        }

        return ss;
    }

    public static ListNode initListNode(int n) {
        if (n <= 0) {
            return new ListNode(-1);
        }
        ListNode linkedList = null;
        ListNode tail = null;
        ListNode currNode = null;
        for (int i = 1; i <= n; i++) {
            ListNode node = new ListNode(i);
            tail = node;
            if (linkedList == null) {
                linkedList = node;
                linkedList.head = node;
            }
            if (currNode == null) {
                currNode = node;
            } else {
                currNode.next = node;
            }
            currNode = node;
        }

        linkedList.tail = tail;
        return linkedList;
    }

}
