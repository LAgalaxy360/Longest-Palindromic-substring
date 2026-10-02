class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);       // odd length, e.g. "aba"
            int len2 = expand(s, i, i + 1);   // even length, e.g. "abba"
            int len = Math.max(len1, len2);

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of the palindrome found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println("Test 1 - Input: \"babad\" | Output: \"" + solution.longestPalindrome("babad") + "\"");
        System.out.println("Test 2 - Input: \"cbbd\" | Output: \"" + solution.longestPalindrome("cbbd") + "\"");
        System.out.println("Test 3 - Input: \"a\" | Output: \"" + solution.longestPalindrome("a") + "\"");
        System.out.println("Test 4 - Input: \"ac\" | Output: \"" + solution.longestPalindrome("ac") + "\"");
    }
}