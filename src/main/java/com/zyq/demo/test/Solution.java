package com.zyq.demo.test;

import java.util.*;

//"pwwkew"  动态规划
//输出: 3
public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        //pwwkew
        int max = 0, start = -1;
        //K是字母，V是位置，如果发现Map中有这个字母就跳到他的位置 重新计算
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (map.containsKey(tmp)) {
                //start是开始计算的位置
                start = Math.max(start, map.get(tmp));
            }
            map.put(tmp, i);
            //最大值就是 索引减去开始的位置
            max = Math.max(max, i - start);
        }
        return max;
    }
}

class Solution2 {
    //n = 10
    //输出: 12
    //解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}

//买股票。肯定是最低的时候买入，遍历整个表，得到最低的，然后在最高的时候抛出，遍历后面的表，找到最大的抛出
class Solution3 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 2, 7, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int res = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //遍历整个表，得到最低的，
            min = Math.min(min, prices[i]);
            //遍历后面的表，找到最大的-
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}

class Solution4 {
    //给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
    //单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'},
        };
        String word = "abcced";
        System.out.println(exist(board, word));
    }

    static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //回溯
    static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word[k]) return false;

        if (k == word.length - 1) return true;
        //右上左下
        boolean res = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j - 1, k + 1);
        // 这个[][]中有这个单词  最后一个字母等于  word 的最后一个字母
        if (board[i][j] == word[k]) return true;
        return res;
    }
}

class Solution5 {
    //输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    //输出: [3,3,5,5,6,7]
    public int[] maxSlidingWindow(int[] nums, int k) {

        return null;
    }
}

class Solution6 {
    //：A = [1,2,3], B = [3,1]
    //输出：false
    //A = [3,4,5,1,2], B = [4,1]
    //输出：true

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return false;
    }

}

class Solution7 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}

class Solution8 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}

class Solution9 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null && A.val != B.val) return false;
       return recur(A.left,B.left) && recur(A.right,B.right);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}