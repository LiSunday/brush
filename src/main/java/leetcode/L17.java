package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L17 {

  public static void main(String[] args) {

  }

  static class Solution {
    char[][] arr = {{'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
      List<String> list = new ArrayList<String>();
      if (digits.equals("")) return list;
      dfs(list, 0, "", digits);
      return list;
    }

    public void dfs(List<String> list, int idx, String str, String digits) {
      if (idx == digits.length()) {
        list.add(str);
        return;
      }
      int n = digits.charAt(idx) - '2';
      for (int i = 0; i < arr[n].length; i++) {
        dfs(list, idx+1, str+arr[n][i], digits);
      }
    }
  }
}
