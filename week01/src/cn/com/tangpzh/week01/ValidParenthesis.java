package cn.com.tangpzh.week01;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(ValidParenthesis.isValid("()()()()"));
        System.out.println(ValidParenthesis.isValid("(()()()"));
        System.out.println(ValidParenthesis.isValid("(){[({[[[]]]})]}"));
        System.out.println(ValidParenthesis.isValid("(]]{}{{))"));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 1、左括号必须用相同类型的右括号闭合。
     * 2、左括号必须以正确的顺序闭合。
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if(s==null || s.length()%2 == 1){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] array = s.toCharArray();
        for(char c : array){
            if('(' == c || '{' == c || '[' == c){
                stack.push(c);
            }else if(stack.empty()){
                return false;
            }else if(')' == c && stack.pop() != '('){
                return false;
            }else if('}' == c && stack.pop() != '{'){
                return false;
            }else if(']' == c && stack.pop() != '['){
                return false;
            }

        }
        return stack.empty();
    }

}
