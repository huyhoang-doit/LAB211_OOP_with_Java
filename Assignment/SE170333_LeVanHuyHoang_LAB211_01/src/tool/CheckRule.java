/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author lvhho
 */
public class CheckRule {

    private static Scanner sc = new Scanner(System.in);

    // <1> Method to check if the product code does not exist
    // Purpose: to find the product code does not exist, to create new code, can not duplicate
    public static String findProductCodeNotExist(ArrayList<String> listCode) {
        String code;
        boolean check = true;
        do {
            code = CheckRule.productCodeValid();
            if (listCode.isEmpty()) {
                return code;
            } else {
                for (String string : listCode) {
                    if (code.equalsIgnoreCase(string)) {
                        check = false;
                        System.out.println("Code already exists!");
                        break;
                    }
                }
            }

            if (check == false) {
                System.out.print("Try again!, Product code: ");
            }
        } while (check == false);
        return code;
    }

    
    //<2> Check if the product code is in the list or not - check code exist or not exist
    // Purpose : to find the product exist in the list, choose product in the list
    public static String findProductCodeExist(ArrayList<String> listCode) {
        String code;
        boolean check = false;
        do {
            code = CheckRule.productCodeValid();
            for (String string : listCode) {
                if (code.equalsIgnoreCase(string)) {
                    check = true;
                    return code;
                }
            }
            if (check == false) {
                System.out.println("Product does not exist!");
                System.out.print("Try again!, Product code: ");
            }
        } while (check == false);
        return code;
    }
    
    
    //<3> Check code valid with format
    //Purpose: keep the product code in one format
    public static String productCodeValid() {
        String code;
        boolean check = false;
        do {
            Pattern p = Pattern.compile("^[a-zA-z0-9]{5}$");
            code = sc.nextLine().trim();
            if (p.matcher(code).find()) {
                check = true;
                return code;
            } else {
                System.out.print("Invalid code, try again <Code:*****>: ");
            }
        } while (check == false);
        return code;
    }
}
