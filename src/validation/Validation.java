/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.Scanner;

/**
 *
 * @author MSII
 */
public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public String inputString(String msg) {
        // neu ma nguoi dung khong dung ma bam enter 
        // string rong thi yeu cau nguoi dung nhap lai 
        System.out.println(msg);
        String rs = "";

        while (true) {
            rs = sc.nextLine();
            if (rs.length() == 0 || rs == null) {
                System.out.println("Not allow empty string ! Pls enter again");
                continue;
            }
            return rs;
        }
    }

    public int inputInt(String msg, int min, int max) {
        System.out.println(msg);
        while (true) {
            // "12" -> 12 
            // "ab12" 
            String rs_raw = sc.nextLine();
            try {
                int rs = Integer.parseInt(rs_raw);
                if (rs < min || rs > max) {
                    System.out.println("This number must be " + min + " to " + max);
                    continue;
                }
                return rs;
            } catch (NumberFormatException e) {
                System.out.println("This must be number ");

            }

        }
    }

    public double inputDouble(String msg, double min, double max) {
        System.out.println(msg);
        while (true) {
            // "12" -> 12 
            // "ab12" 
            String rs_raw = sc.nextLine();
            try {
                double rs = Integer.parseInt(rs_raw);
                if (rs < min || rs > max) {
                    System.out.println("This number must be " + min + " to " + max);
                    continue;
                }
                return rs;
            } catch (NumberFormatException e) {
                System.out.println("This must be number ");

            }

        }
    }
    
    

}
