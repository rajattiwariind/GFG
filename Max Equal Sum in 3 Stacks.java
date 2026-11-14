import java.util.List;

class Solution {
    public static int maxEqualSum(List<Integer> s1, List<Integer> s2, List<Integer> s3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int num : s1) sum1 += num;
        for (int num : s2) sum2 += num;
        for (int num : s3) sum3 += num;

        int i1 = 0, i2 = 0, i3 = 0;
        int n1 = s1.size(), n2 = s2.size(), n3 = s3.size();

        while (i1 < n1 && i2 < n2 && i3 < n3) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.get(i1++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.get(i2++);
            } else {
                sum3 -= s3.get(i3++);
            }
        }

        return 0;
    }
}
