class Solution {
    class FrequencyElement {
        int number;
        int freq = 0; 

        public FrequencyElement(int number, int frequency) {
            this.number = number; 
            this.freq = frequency;
        }

        public String toString() {
            return this.number + ", " + this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap(nums.length);
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        PriorityQueue<FrequencyElement> queue = new PriorityQueue<FrequencyElement>((e1, e2) -> e1.freq - e2.freq);
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new FrequencyElement(entry.getKey(), entry.getValue()));
            //System.out.println(queue.peek());
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int result[] = new int[k];
        int i = 0;
        while (queue.size() > 0) {
            result[i++] = queue.poll().number;
        }
        return result;
    }
}
