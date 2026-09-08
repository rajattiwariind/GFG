class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        
        int n = mat.length;
        int m = mat[0].length;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // First character must match
                if (mat[i][j] != word.charAt(0)) {
                    continue;
                }

                // Check all 8 directions
                for (int d = 0; d < 8; d++) {

                    int r = i;
                    int c = j;
                    int k;

                    for (k = 1; k < word.length(); k++) {
                        r += dr[d];
                        c += dc[d];

                        // Out of bounds
                        if (r < 0 || r >= n || c < 0 || c >= m) {
                            break;
                        }

                        // Character doesn't match
                        if (mat[r][c] != word.charAt(k)) {
                            break;
                        }
                    }

                    // Whole word found
                    if (k == word.length()) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        ans.add(temp);

                        // Don't add same starting position again
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
