package com.jayeed;

import java.awt.*;
import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Put in the number: ");
//        short num = sc.nextShort();
//
//        if (num%5 == 0 && num%3 ==0)
//            System.out.println("fizzbuzz");
//        else if (num%3 ==0)
//            System.out.println("fizz");
//        else if (num%5 ==0)
//            System.out.println("buzz");
//        else
//            System.out.println(num);
//        Scanner sc = new Scanner(System.in);
//

        int principalAmount = 0;
        float monthlyInterest =0;
        int numberOfPayments = 0;


        while(true) {
            System.out.println("Principal ($1k - $1M): ");
            principalAmount = sc.nextInt();

            if (principalAmount >= 1000 && principalAmount <= 1_000_000)
                break;
            System.out.println("Enter a number greater than 1000 and less than 1000000.");
        }


        while(true) {
            System.out.println("Annual Interest Rate: ");
            float annualInterestRate = sc.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                monthlyInterest = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");


        }


        while(true) {
            System.out.print("Period (years): ");
            int yearsOfPayment = sc.nextInt();
            if (yearsOfPayment >= 1 && yearsOfPayment <= 30) {
                numberOfPayments = (MONTHS_IN_YEAR*yearsOfPayment);
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }


        double mortgage = principalAmount * (monthlyInterest * Math.pow((1+monthlyInterest),numberOfPayments))
                / (Math.pow((1+monthlyInterest),numberOfPayments) - 1) ;


        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(mortgage);
        System.out.println(result);


//        String role = "admin";
//        switch (role) {
//            case "admin":
//                System.out.println("admin role");
//                break;
//            case "moderator":
//                System.out.println("moderator role");
//                break;
//            default:
//                System.out.println("no role assigned");
//        }



    }
}