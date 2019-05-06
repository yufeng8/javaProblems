// what is the asymptotic complexity?

class Solution {
    public List<String> palindromePermutation(String s) {
        List<String> result = new ArrayList<String>();
        // == or equals?
        // is this even needed?
        if (s == "") return result;
        StringBuilder sb = new StringBuilder();
        helper(s, 0, sb, result);
        return result;
    }

    public void helper(String s, int startIndex, StringBuilder sb, List<String> result) {
        if (sb.length() == s.length()) {
            if (isPalindrome(sb))
                result.add(sb.toString());
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            sb.append(s.charAt(i));
            helper(s, i+1, sb, result);
            sb.deleteChatAt(sb.length()-1);
        }
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i<j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}