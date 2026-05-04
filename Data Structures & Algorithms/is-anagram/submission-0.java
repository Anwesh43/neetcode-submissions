class Solution {
    public boolean isAnagram(String s, String t) {
        char chbuf1[] = s.toCharArray();
        char chbuf2[] = t.toCharArray();
        Arrays.sort(chbuf1);
        Arrays.sort(chbuf2);
        return new String(chbuf1).equals(new String(chbuf2));
    }
}
