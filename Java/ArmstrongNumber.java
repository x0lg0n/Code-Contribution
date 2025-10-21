// Java/ArmstrongNumber.java

/**
 * This program checks whether a number is an Armstrong number.
 * Author: Sohum Seth
 */

import java.util.Scanner;

public class ArmstrongNumber {

    /**
     * Checks if a number is an Armstrong number.
     * 
     * @param num Input number
     * @return true if Armstrong, false otherwise
     *
     * Example:
     * ArmstrongNumber.isArmstrong(153); // returns true
     */
    public static boolean isArmstrong(int num) {
        int sum = 0, temp = num, digits = String.valueOf(num).length();
        while (temp != 0) {
            int remainder = temp % 10;
            sum += Math.pow(remainder, digits);
            temp /= 10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        sc.close();
    }
}
