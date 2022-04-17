package binaryTree.uniqueBinarySearchTrees96;

/**
 * @author Ji Chen
 * @className: Main
 * @date 2022/3/31
 */
public class Solution {

	/**
	 * 方法一：
	 *  可以直接按照95题的方式去构造出来所有的情况，最后再获取list的size即可，这种方式会浪费很多时间
	 *  而且显然不是题目的最优解。既然只要求求出多少种情况，说明可以用数学抽象，那么回溯法构造情况就不应该。
	 * 结果： 超时
	 *
	 * 方法二：
	 *  G(n) = G(1, n) = G(1, 0) * G(2, n-1) + G(1, 1) * G(3, n-1)
	 *  + ... + G(1, i-1) * G(i+1, n) + ... + G(1, n-1) * G(n + 1, n);
	 *  同样使用方法一的方法，只不过没有做构造，但是没有抽象没有提炼，所以性能差
	 *  Time: 5.01%  Memory: 40.57%
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		return numTree(1, n);
	}

	public int numTree(int m, int n) {
		int res = 0;
		if (m >= n) {
			return 1;
		}
		for (int i = m; i < n + 1; i ++) {
			int x = numTree(m, i - 1);
			int y = numTree(i + 1, n);
			res += x * y;
		}
		return res;
	}

	/**
	 * 方法三：
	 *  直接使用抽象的数字规律，使用动态规划
	 *  Time: 100%  Memory: 24.45%
	 */
	public int numTrees1(int n) {
		int[] res = new int[n+1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i < n+1; i++) {
			for (int j = 1; j < i+1; j++) {
				//只需要知道数量多少，并不需要具体什么数据
				res[i] += res[j-1] * res[i-j];
			}
		}
		return res[n];
	}
}
