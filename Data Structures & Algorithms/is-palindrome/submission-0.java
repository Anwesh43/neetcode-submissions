class Solution {
    
    public String getTrimmedString(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z')) {
                sb.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append((char)((int)ch + 32));
            } else if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public boolean isPalindrome(String s) {
        
        String lowerS = getTrimmedString(s);
        int l = 0, h = lowerS.length() - 1; 
        System.out.println(lowerS);
        while (l < h && lowerS.charAt(l) == lowerS.charAt(h)) {
            l++;
            h--;
        }
        //System.out.println("L,H " + l +", " + h);
        return l >= h;
    }
}
