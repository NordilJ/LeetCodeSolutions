package AsteroidCollision;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        Solution solution = new Solution();
        var test = solution.asteroidCollision(new int[]{2,1,-1,-2,-5});

        System.out.println(Arrays.toString(test));

    }
}

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); // -5 5

        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                int lastAsteroid = stack.pop();
                int newAsteroid = asteroids[i];
                while (true) {
                    if (shouldCollide(lastAsteroid, newAsteroid)) {
                        int x = Math.abs(lastAsteroid);
                        int y = Math.abs(newAsteroid);
                        if (x > y) {
                            stack.push(lastAsteroid);
                            break;
                        } else if (y > x) {
                            if(stack.isEmpty()){
                                stack.push(newAsteroid);
                                break;
                            } else { // тук ни е loop-а
                                lastAsteroid = stack.pop();
                            }
                        } else {
                            break; // когато са равни
                        }
                    } else { //ако нямаме сблъсък
                        stack.push(lastAsteroid);
                        stack.push(newAsteroid);
                        break;
                    }
                }
            }

        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    private boolean shouldCollide(int x, int y) {
        return x > 0 && y < 0;
    }
}