package BackspaceStringCompare;

import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.backspaceCompare("ab#c", "ad#c");

    }
}

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> firstContainer = fillStack(s);
        Stack<Character> secondContainer = fillStack(t);

        return firstContainer.equals(secondContainer);
    }

    private Stack<Character> fillStack(String input) {
        Stack<Character> result = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '#') {
                result.push(input.charAt(i));
            }
            else if (!result.isEmpty()){
                result.pop();
            }
        }
        return result;
    }
}
