package jz;

import java.util.Stack;

public class J31 {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    int[] ppp = {4,5,3,2,1};
    System.out.println(new J31().IsPopOrder(arr, ppp));
  }

  public boolean IsPopOrder(int [] pushA,int [] popA) {
    Stack<Integer> stack = new Stack<Integer>();
    int idx = 0;
    for (int i = 0; i < pushA.length; i++) {
      if (pushA[i] == popA[idx]) {
        idx++;
      } else {
        while (!stack.empty()) {
          if (stack.peek() == popA[idx]) {
            stack.pop();
            idx++;
          } else {
            break;
          }
        }
        stack.push(pushA[i]);
      }
    }
    while (!stack.empty()) {
      if (stack.peek() == popA[idx]) {
        stack.pop();
        idx++;
      } else {
        break;
      }
    }
    return stack.isEmpty();
  }
}
