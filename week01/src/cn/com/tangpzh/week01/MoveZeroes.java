package cn.com.tangpzh.week01;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 9, 0, 4, 5, 0, 3, 7, 7, 0, 0, 2, 4, 8};
        MoveZeroes.method2(nums);
        System.out.println(Arrays.toString(nums));
//        MoveZeroes.method1(nums);
//        System.out.println(Arrays.toString(nums));
    }

    public static void method1(int[] nums){
        // 将不为0的数字全部移到最前面
        int nonZeroIdx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[nonZeroIdx++] = nums[i];
            }
        }
        // 1, 9, 4, 5, 3, 7, 7, 2, 4, 8, 0, 0, 2, 4, 8
        // nonZeroIdx = 10;
        System.out.println(Arrays.toString(nums));
        System.out.println(nonZeroIdx);

        // 再将nonZeroIdx位置之后的全部元素置为0即可
        for(int i = nonZeroIdx; i < nums.length; i++){
            nums[i] = 0;
        }

    }

    public static void method2(int[] nums){
        // 当前的非0元素应该放置的位置（下标）
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                // i!=j 表示前面遍历到的数字中出现过数字0  ---- 只有这种情况下才需要交换元素
                // i==j表示前面遍历到的元素都是非0数字  ---- 这种情况下不需要交换元素，因为前面没有出现数字0
                if(i != j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++; // 非0数字放置的位置（下标）向后移动
            }
        }
    }

}
