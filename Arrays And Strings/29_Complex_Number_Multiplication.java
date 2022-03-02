https://nados.io/question/complex-number-multiplication?zen=true




import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~User''s Section~~~~~~~~~~~~~
  public static String complexNumberMultiply(String num1, String num2) {
    // num1 = a + bi
    // num2 = c + di
    // res = (a * c - b * d) + (a * d + c * b) * i
    //            REAL               IMAGINARY
    int a = Integer.parseInt(num1.substring(0, num1.indexOf('+')));
    int b = Integer.parseInt(num1.substring(num1.indexOf('+') + 1, num1.indexOf('i')));
    int c = Integer.parseInt(num2.substring(0, num2.indexOf('+')));
    int d = Integer.parseInt(num2.substring(num2.indexOf('+') + 1, num2.indexOf('i')));

    return "" + (a * c - b * d) + "+" + (a * d + c * b) + "i";
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String num1 = scn.nextLine();
    String num2 = scn.nextLine();
    String res = complexNumberMultiply(num1, num2);
    System.out.println(res);
  }
}
