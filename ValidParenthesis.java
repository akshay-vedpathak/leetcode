import java.util.Stack;


/**
 * Solution to problem : https://leetcode.com/problems/valid-parentheses/description/
 */

public class ValidParenthesis{

    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i)==')' && !stack.empty() && (char) stack.peek()=='('){
                stack.pop();
            }else if(s.charAt(i)==']' && !stack.empty() && (char) stack.peek()=='['){
                stack.pop();
            }else if(s.charAt(i)=='}' && !stack.empty() && (char) stack.peek()=='{'){
                stack.pop();
            }else{
                return false;
            }
        }

        if(stack.empty()){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isValid("()()()"));
        System.out.println(isValid("{[()]}"));
        System.out.println(isValid("[[[]]}"));
    }
    /**
     * Expected Output:
     * true
     * true
     * false
     */
}