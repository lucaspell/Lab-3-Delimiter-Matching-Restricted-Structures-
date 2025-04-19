package validparentheses;

public class ValidParentheses {

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
                return '\0';
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static boolean isValid(String s) {
        Stack stack = new Stack(s.length());

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else {

                if (stack.isEmpty()) return false;
                char top = stack.pop();

                if ((current == ')' && top != '(') ||
                    (current == '}' && top != '{') ||
                    (current == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Input: \"()\" -> Output: " + isValid("()"));     
        System.out.println("Input: \"()[]{}\" -> Output: " + isValid("()[]{}"));   
        System.out.println("Input: \"(]\" -> Output: " + isValid("(]"));           
        System.out.println("Input: \"([)]\" -> Output: " + isValid("([)]"));      
        System.out.println("Input: \"{[]}\" -> Output: " + isValid("{[]}"));       
    }
}
