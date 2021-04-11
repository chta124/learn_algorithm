package cn.com.tangpzh.week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] result1 = test.method1(nums, target);
        System.out.println(Arrays.toString(result1));
        int[] result2 = test.method2(nums, target);
        System.out.println(Arrays.toString(result2));
    }

    public int[] method1(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0;i<len-1;i++){
            for(int j = i+1;j<len;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    public int[] method2(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i = 0;i<len;i++){
            if(valueIndexMap.containsKey(target-nums[i])){
                return new int[]{i, valueIndexMap.get(target-nums[i])};
            }else{
                valueIndexMap.put(nums[i], i);
            }
        }

        return new int[0];
    }

}

