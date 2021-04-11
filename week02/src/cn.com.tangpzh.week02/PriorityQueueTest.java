package cn.com.tangpzh.week02;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2) -> o1>o2?1:-1);
        for(int i = 0;i<100;i++){
            minHeap.offer(i);
        }

        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());

    }

}
