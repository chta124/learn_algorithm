package cn.com.tangpzh.week01;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(RemoveDuplicatesFromSortedArray.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }

        // 打印去重后的
//        int[] newArray = new int[i+1];
//        System.arraycopy(nums, 0, newArray, 0, i+1);
//        System.out.println("去重后的数组元素：" + Arrays.toString(newArray));

        return i+1;
    }

}
