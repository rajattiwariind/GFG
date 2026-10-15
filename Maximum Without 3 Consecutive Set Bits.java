class Solution {
	public
	int maxValue(int n) {
		// code here
		for (int i = 30; i >= 0; --i) {
			if (((n>> i)&7) == 7) {
				n &= ~(1 << i);
			}
		}
		return n;
	}
};
