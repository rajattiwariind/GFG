import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        // Step 1: Precompute indices of each character in string s
        ArrayList<Integer>[] charIndices = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            charIndices[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            charIndices[s.charAt(i) - 'a'].add(i);
        }
        
        String longestWord = "";
        
        for (String word : d) {
            // Optimization: Skip words that cannot improve our result length or lexicographical order
            int a = word.length();
            int b = longestWord.length();
            if (a < b || (a == b && word.compareTo(longestWord) > 0)) {
                continue;
            }
            
            // Step 2: Check if 'word' is a subsequence using binary search
            if (isSubsequence(word, charIndices)) {
                longestWord = word;
            }
        }
        
        return longestWord;
    }
    
    private boolean isSubsequence(String word, ArrayList<Integer>[] charIndices) {
        int currIdx = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            ArrayList<Integer> list = charIndices[c - 'a'];
            
            // Find the first occurrence index greater than currIdx using binary search
            int idx = Collections.binarySearch(list, currIdx + 1);
            if (idx < 0) {
                idx = -1 - idx; // Convert negative insertion point
            }
            
            // If no valid index is found, it's not a subsequence
            if (idx >= list.size()) {
                return false;
            }
            
            currIdx = list.get(idx);
        }
        return true;
    }
}
