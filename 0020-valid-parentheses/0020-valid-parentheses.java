import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // An odd length string can never be valid
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push expected closing character when encountering an opening bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // If stack is empty or top element doesn't match the closing bracket
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // Return true if all opening brackets were matched
        return stack.isEmpty();
    }
}