package Pharmacy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Printable {
  public void print(String str);
}

public class InputValidation implements Printable {

  static Scanner in = Main.in;

  public static String getString(String printString) {
    String str = null;
    new InputValidation().print(printString);
    while (true) {
      str = in.nextLine();
      if (!str.matches(".*[0-9].*")) break; else System.out.println(
        "invalid!! Enter valid.."
      );
    }
    return str;
  }

  public static String getPhoneNumber() {
    System.out.println("Enter the Phone Number: ");
    String phone = null;
    while(true){
      phone = in.nextLine();
      Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
      Matcher match = ptrn.matcher(phone);  
      if(match.find() && match.group().equals(phone))
        break;
      else
        System.out.println("Phone Number is invalid..");
    }
    return phone;
  }
  public static int getYesOrNo() {
    int yesNo = 0;
    while(true){
      yesNo = in.nextInt();
      if(yesNo<3 && yesNo!=0)
        break;
      else
        System.out.println("Enter 1 or 2..");
    }
    return yesNo;
  }
  @Override
  public void print(String str) {
    System.out.println("Enter the " + str);
  }
}
