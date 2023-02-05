package leetcode;

import java.util.Arrays;

public class L28 {

  public static void main(String[] args) {
    new L28().strStr(null, null);
  }

  public int strStr(String haystack, String needle) {
    int[] next = getNext("aabaaca");
    System.out.println(Arrays.toString(next));
    return 0;
  }


  public static int[] getNext(String p) {
    int[] next = new int[p.length()];
    next[0] = -1;
    int k = -1;

    for (int i = 1; i < p.length(); i++) {

      // 当前字符和最长前缀下一个字符不同，则往前回溯
      while (k > -1 && p.charAt(i) != p.charAt(k + 1)) {
        // 已经比较了位置k+1的字符不同，往前回溯的话应该往k位置，k位置的最长前缀的位置k=next[k]
        k = next[k];
      }

      // 当前字符和当前字符前面字符串的最长前缀的下一个字符相同，则k+1
      if (p.charAt(i) == p.charAt(k + 1)) {
        k = k + 1;
      }

      next[i] = k;
    }
    return next;
  }
}
