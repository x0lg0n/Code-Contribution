// Java Program to Check if a Year is a Leap Year or Not
// Author: Sohum Seth
// Description: Checks whether the entered year is a leap year.

import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        // Leap year conditions:
        // 1. Divisible by 4
        // 2. Not divisible by 100 unless divisible by 400
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a Leap Year ✅");
        } else {
            System.out.println(year + " is NOT a Leap Year ❌");
        }

        sc.close();
    }
}
