package ValidParentheses;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '[':
                case '(':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }

                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }

                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }

                    break;
                default:
                    return false;
            }

        }

        return stack.isEmpty();
    }
}