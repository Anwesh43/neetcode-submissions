class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> chMap = new HashMap(){{
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character poppedCh = stack.pop();
                if (poppedCh != chMap.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
