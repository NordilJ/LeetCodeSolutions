package BaseballGame;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.callPoints(new String[]{"5", "2", "C", "D", "+"});
    }
}

class Solution {
    public int callPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            if (!"DC+".contains(ops[i])){
                stack.push(Integer.parseInt(ops[i]));
            } else if (ops[i].equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (ops[i].equals("C")) {
                stack.pop();
            } else if (ops[i].equals("+")) {
                int lastNum = stack.pop();
                int prevNum = stack.peek();
                stack.push(lastNum);
                stack.push(lastNum + prevNum);
            }
        }

        int sum = 0;
        while (stack.size() > 0) {
            sum += stack.pop();
        }

        return sum;
    }
}
