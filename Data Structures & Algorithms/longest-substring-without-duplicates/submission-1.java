class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
        int count = 0, maxLength = 0, duplicateIndex = -1; 
        for (int i = 0; i < s.length(); i++) {
            if (charIndexMap.containsKey(s.charAt(i)) && charIndexMap.get(s.charAt(i)) > duplicateIndex) {
                maxLength = Math.max(maxLength, count);
                duplicateIndex = charIndexMap.get(s.charAt(i));
                count = i - duplicateIndex;
            } else {
                count++;
            }
            charIndexMap.put(s.charAt(i), i);
        }
        return Math.max(count, maxLength);
    }
}
