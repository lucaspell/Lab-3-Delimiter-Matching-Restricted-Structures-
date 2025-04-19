package validparentheses;

public class ValidParentheses {

    // Custom Stack class using an array
    static class Stack {
        private char[] stackArray;
        private int top;

        public Stack(int size) {
            stackArray = new char[size];
            top = -1;
        }

        public void push(char value) {
            if (top < stackArray.length - 1) {
                stackArray[++top] = value;
            } else {
                System.out.println("Stack Overflow");
            }
        }

        public char pop() {
            if (!isEmpty()) {
                return stackArray[top--];
            } else {
                return '\0'; // return null char if empty
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    // Function to check if the string has valid brackets
    public static boolean isValid(String s) {
        Stack stack = new Stack(s.length());

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // Push opening brackets onto the stack
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else {
                // If stack is empty or doesn't match the correct opening bracket
                if (stack.isEmpty()) return false;
                char top = stack.pop();

                if ((current == ')' && top != '(') ||
                    (current == '}' && top != '{') ||
                    (current == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty at the end, all brackets matched
        return stack.isEmpty();
    }

    // Main method to test with inputs
    public static void main(String[] args) {
        System.out.println("Input: \"()\" -> Output: " + isValid("()"));           // true
        System.out.println("Input: \"()[]{}\" -> Output: " + isValid("()[]{}"));   // true
        System.out.println("Input: \"(]\" -> Output: " + isValid("(]"));           // false
        System.out.println("Input: \"([)]\" -> Output: " + isValid("([)]"));       // false
        System.out.println("Input: \"{[]}\" -> Output: " + isValid("{[]}"));       // true
    }
}
