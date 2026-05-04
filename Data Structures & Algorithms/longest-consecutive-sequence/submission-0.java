class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> countIndexMap = new TreeSet<Integer>();
        int maxTillNow = 0;
        for (int i = 0; i < nums.length; i++) {
            countIndexMap.add(nums[i]);
        }
        int curr = 0, prev = 0;
        boolean start = true;
        for (Integer num : countIndexMap) {
            if (start) {
                curr = 1;
                start = false;
            } else {
                if (num - prev == 1) {
                    curr++;
                    System.out.println(curr);
                } else {
                    maxTillNow = Math.max(maxTillNow, curr);
                    curr = 1;
                }
            }
            prev = num;
        }
        return Math.max(maxTillNow, curr);
    }
}


