package cn.com.tangpzh.week01;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        int k = 3;
//        RotateArray.method1(nums, k);
//        System.out.println(Arrays.toString(nums));
        RotateArray.method2(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    // 开一个新数组，按照移动规则对新数组赋值，再将新数组内容复制到原数组中
    public static void method1(int[] nums, int k){
        int len = nums.length;
        int[] newArray = new int[len];
        for(int i = 0; i < len; i++){
            newArray[(i+k)%len] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, len);
    }

    // 循环替换
    public static void method2(int[] nums, int k){
        // 1,2,3,4,5,6
        int holds = nums[0];
        int len = nums.length;
        int idx = 0;
        int[] flags = new int[len];
        for(int i = 0; i < len; i++){
            idx = (idx + k) % len;
            if(flags[idx] == 1){
                // idx 位置已被更换过，则从下一个位置开始进行置换
                idx = (idx + 1) % len;
                holds = nums[idx];
                // 本次循环没有完成置换任务，所以i--
                i--;
            }else{
                // 标记idx下标位置的元素已经被更换过了，每个位置的元素只能被更换1次
                flags[idx] = 1;
                int temp = nums[idx];
                // 将idx位置的值更换为 holds
                nums[idx] = holds;
                // 同时更新 holds 的值为下一次循环的起点下标所在位置的值
                holds = temp;
            }
        }
    }

}
