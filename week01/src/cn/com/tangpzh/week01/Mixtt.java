package cn.com.tangpzh.week01;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Mixtt
 * @Description 递归打印排列组合
 * @Author tangpzh@mail.open.com.cn
 * @Date2021/3/24 17:04
 * @Version V1.0
 **/
public class Mixtt {

    public static void listAll(List list, int len, String prefix) {
        if (prefix.length() == len) {
            System.out.println(prefix);
        }
        for (int i = 0; i < list.size(); i++) {
            List<String> temp = new LinkedList<String>(list);
            listAll(temp, len, prefix + temp.remove(i));
        }
    }

    public static void main(String[] args) {
        List<String> candidate = new LinkedList<String>();
        candidate.add("1");
        candidate.add("2");
        candidate.add("3");
        candidate.add("4");
        listAll(candidate, 4, "");
    }

}
