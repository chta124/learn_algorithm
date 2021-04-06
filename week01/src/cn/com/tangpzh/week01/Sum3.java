package cn.com.tangpzh.week01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(Sum3.method1(nums));
    }

    public static List<List<Integer>> method1(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }
        // 首先排序
        Arrays.sort(nums);
        if (nums[0] > 0 || (nums[0] + nums[1]) > 0) {
            return result;
        }
        if (nums[0] == 0 && (nums[0] + nums[1] + nums[2]) == 0) {
            result.add(Arrays.asList(0, 0, 0));
            return result;
        }

        int len = nums.length;
        for (int i = 0; i <= len - 3; i++) {
            if (nums[i] > 0 || (nums[i] + nums[i + 1] > 0)) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // i下标值去重，相邻的两个数字值相同
            }
            int L = i + 1;
            int R = len - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++; // L下标值去重，相邻的两个数字值相同
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--; // R下标值去重，相邻的两个数字值相同
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    if (nums[i] + nums[L] > 0) {
                        break;
                    }
                    R--;
                }

            }

        }

        return result;
    }
}
