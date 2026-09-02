class Solution {
    public int solve(int n, String s) {
        // 0 = not arrived
        // 1 = currently using a computer
        // 2 = rejected
        int[] status = new int[26];

        int available = n;
        int rejected = 0;

        for (char c : s.toCharArray()) {
            int customer = c - 'A';

            if (status[customer] == 0) {
                // Arrival
                if (available > 0) {
                    available--;
                    status[customer] = 1;
                } else {
                    rejected++;
                    status[customer] = 2;
                }
            } else if (status[customer] == 1) {
                // Departure of a customer who had a computer
                available++;
                status[customer] = 0;
            } else {
                // Departure of a rejected customer
                status[customer] = 0;
            }
        }

        return rejected;
    }
}
