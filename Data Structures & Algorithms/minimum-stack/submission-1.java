class MinStack {
    Stack<Integer> st;
    Map<Integer, Integer> treeMap;
    public MinStack() {
        st = new Stack<Integer>();
        treeMap = new TreeMap();
    }
    
    public void push(int val) {
        st.push(val);
        treeMap.putIfAbsent(val, 0);
        treeMap.put(val, treeMap.get(val) + 1);
    }
    
    public void pop() {
        int num = st.pop();
        treeMap.put(num, treeMap.get(num) - 1);
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
