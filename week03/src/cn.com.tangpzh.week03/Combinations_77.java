package cn.com.tangpzh.week03;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combinations_77 test = new Combinations_77();
        List<List<Integer>> result = test.method1(n, k);
        System.out.println(result);
    }

    public List<List<Integer>> method1(int n, int k) {
        System.out.println("n = " + n + "  k = " + k);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = method1(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(method1(n - 1, k));

        return result;
    }

}
