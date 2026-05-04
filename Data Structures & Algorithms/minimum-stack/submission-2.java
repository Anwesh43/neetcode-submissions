public class StackElement {
    public Integer num;
    public Integer index;
    public StackElement(int num, int index) {
        this.num = num;
        this.index = index;
    }
}
class MinStack {
    Stack<StackElement> mainStack;
    Stack<StackElement> minStack;
    int k = 0;
    public MinStack() {
        mainStack = new Stack<StackElement>();
        minStack = new Stack<StackElement>();
    }
    
    public void push(int val) {
        k++;
        StackElement element = new StackElement(val, k);
        mainStack.push(element);
        if (minStack.size() == 0) {
            minStack.push(element);
        } else if (val < minStack.peek().num) {
            minStack.push(element);
        }
        System.out.println(minStack.size());
    }
    
    public void pop() {
        StackElement element = mainStack.pop();
        if (element.index == minStack.peek().index) {
            minStack.pop();
        }
    }
    
    public int top() {
        return mainStack.peek().num;
    }
    
    public int getMin() {
        return minStack.peek().num;
    }
}
