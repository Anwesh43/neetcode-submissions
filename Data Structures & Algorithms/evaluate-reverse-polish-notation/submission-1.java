class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> stack = new Stack();
       for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int currResult = 1;
                if (token.equals("+") || token.equals("-")) {
                    currResult = 0;
                }
                int ops = 0;
                while (ops < 2) {
                    ops++;
                    int a = stack.pop();
                    if (token.equals("+")) {
                        currResult += a;
                    } else if (token.equals("-")) {
                        currResult = a - currResult;
                    } else if (token.equals("/")) {
                        currResult = a / currResult;
                    } else if (token.equals("*")) {
                        currResult = a * currResult;
                    }
                }
                stack.push(currResult);
            } else {
                stack.push(Integer.parseInt(token));
            }
       }
       return stack.pop();
    }
}
