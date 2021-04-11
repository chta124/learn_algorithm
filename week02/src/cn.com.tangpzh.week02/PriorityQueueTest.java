package cn.com.tangpzh.week02;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

//        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2) -> o1>o2?1:-1);
//        for(int i = 0;i<100;i++){
//            minHeap.offer(i);
//        }
//
//        System.out.println(minHeap.poll());
//        System.out.println(minHeap.poll());
//        System.out.println(minHeap.poll());
//        System.out.println(minHeap.poll());
//        System.out.println(minHeap.poll());


        PriorityQueue<User> minHeap = new PriorityQueue<User>(new UserComparator());
        minHeap.offer(new User("张三", 13));
        minHeap.offer(new User("李四", 24));
        minHeap.offer(new User("王五", 35));
        minHeap.offer(new User("赵六", 46));
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());

    }

}

class User implements  Comparable{

    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o==null){
            return 1;
        }
        boolean isInstance = o instanceof User;
        if(o instanceof User){
            return this.getAge() >= ((User)(o)).getAge() ? 1 : -1;
        }else{
            return 1;
        }
    }
}

class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if(o1==null){
            return -1;
        }
        if(o2==null){
            return 1;
        }
        return o2.getAge() >= o1.getAge() ? 1 : -1;
    }
}
