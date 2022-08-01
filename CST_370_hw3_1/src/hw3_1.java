/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw3/challenges/palindrome-check-10/submissions/code/1323407483
 * Title: hw3_1.java
 * Abstract: Reads user input of string and recursively determines if it is a palindrome
 * Author: Adam Houser
 * ID: 1144
 * Date: 5/6/2020
 */

import java.util.Scanner;

public class hw3_1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // read input
        String input = in.nextLine();

        // eliminate all non-alphanumeric characters
        input = input.replaceAll("[^a-zA-Z0-9]", "");

        // change all letters to same case
        input = input.toLowerCase();

        // check palindrome with recursive function
        if (checkPalindrome(input)) {
            System.out.println("TRUE");
        }
        else {
            System.out.println("FALSE");
        };

        in.close();
    }

    static boolean checkPalindrome(String str) {

        // if length is 0 or 1 then true
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }

        // If first and last characters match, recursively do the next pair
        if(str.charAt(0) == str.charAt(str.length()-1)) {
            return checkPalindrome(str.substring(1, str.length()-1));
        }

        // otherwise no good
        return false;
    }
}
