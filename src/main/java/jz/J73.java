package jz;

public class J73 {

  public static void main(String[] args) {

  }

  public String ReverseSentence(String str) {
    String[] s = str.split(" ");
    StringBuilder builder = new StringBuilder();
    if (s.length > 0) {
      builder.append(s[s.length - 1]);
      for (int i = s.length - 2; i >=0; i++) {
        builder.append(" ");
        builder.append(s[i]);
      }
      return builder.toString();
    }
    return "";
  }
}
