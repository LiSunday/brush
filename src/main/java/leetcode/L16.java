package leetcode;

import java.util.Arrays;

public class L16 {

  public static void main(String[] args) {
    int[] arr = {-1,2,1,-4};
    System.out.println(new Solution().threeSumClosest(arr, 1));
  }

  static class Solution {
    public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      Integer sum = null;
      for (int i = 0; i < nums.length; i++) {
        int l = 0;
        int r = nums.length - 1;
        while (true) {
          if (l == i) l++;
          if (r == i) r--;
          if (l < r) {
            int tmp = nums[i] + nums[l] + nums[r];
            if (tmp == target) return target;
            if (tmp > target) {
              r--;
            }
            if (tmp < target) {
              l++;
            }
            if (sum == null) {
              sum = tmp;
            } else if (Math.abs(target -tmp) < Math.abs(target - sum)) {
              sum = tmp;
            }
          } else {
            break;
          }
        }
      }
      return sum;
    }
  }
}
