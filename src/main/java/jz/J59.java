package jz;

import java.util.ArrayList;
import java.util.LinkedList;

public class J59 {

  public static void main(String[] args) {
    int[] arr = {9,10,9,-7,-3,8,2,-6};
    ArrayList<Integer> integers = new J59().maxInWindows(arr, 5);
    System.out.println(integers);
  }

  public ArrayList<Integer> maxInWindows(int [] num, int size) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (size == 0) return result;
    LinkedList<Integer> stack = new LinkedList<Integer>();
    LinkedList<Integer> stackIdx = new LinkedList<Integer>();
    for (int i = 0; i < size && i < num.length; i++) {
      addVal(stack, stackIdx, num[i], i, size);
    }
    result.add(stack.getFirst());
    for (int i = size; i < num.length; i++) {
      addVal(stack, stackIdx, num[i], i, size);
      result.add(stack.getFirst());
    }
    return result;
  }

  private void addVal(LinkedList<Integer> stack, LinkedList<Integer> stackIdx, int v, int idx, int size) {
    while (!stack.isEmpty() && idx - stackIdx.getFirst() >= size) {
      stack.removeFirst();
      stackIdx.removeFirst();
    }
    while (!stack.isEmpty() && stack.getLast() < v) {
      stack.removeLast();
      stackIdx.removeLast();
    }
    stack.add(v);
    stackIdx.add(idx);
  }

}
