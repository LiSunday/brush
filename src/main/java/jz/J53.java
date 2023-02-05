package jz;

import java.util.List;

public class J53 {

  public static void main(String[] args) {
  }

  public int GetNumberOfK(List<Integer> array , int k) {
    int idx = find(0, array.size() - 1, array, k);
    if (idx == -1) return 0;
    int res = 1;
    int tmp = idx + 1;
    while (tmp < array.size() && array.get(tmp++) == k) res++;
    tmp = idx - 1;
    while (tmp >= 0 && array.get(tmp--) == k) res++;
    return res;
  }

  private int find(int l, int r, List<Integer> arr, int k) {
    if (l == r) {
      if (k == arr.get(l)) return l;
      return -1;
    }
    if (l > r) return -1;
    int idx = (l + r) / 2;
    if (arr.get(idx) == k) {
      return idx;
    } else if (arr.get(idx) > k) {
      return find(l, idx, arr, k);
    } else {
      return find(idx + 1, r, arr, k);
    }
  }
}
