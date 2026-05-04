class KthLargest {
    PriorityQueue<Integer> queue;
    int k = 0;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
