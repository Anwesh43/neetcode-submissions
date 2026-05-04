class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> strResult = new HashSet<String>();
        for (int i = 0; i < nums.length; i++) {
            int targetSum = -nums[i];
            
            
            Set<Integer> set = new HashSet<Integer>();
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(targetSum - nums[j])) {
                    int currNums[] = {nums[i], targetSum - nums[j], nums[j]};
                    Arrays.sort(currNums);
                    String numbers = currNums[0] +", " + currNums[1] + ", " + currNums[2];
                
                    strResult.add(numbers);
                     
                } else {
                    set.add(nums[j]);
                }
            }
        }
        for (String numStr : strResult) {
            String[] parts = numStr.split(", ");
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(Integer.parseInt(parts[0]));
            curr.add(Integer.parseInt(parts[1]));
            curr.add(Integer.parseInt(parts[2]));
            result.add(curr);
        }
        return result;
    }
}
