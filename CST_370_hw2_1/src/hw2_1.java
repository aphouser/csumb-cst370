/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw2/challenges/reverse-number-13/submissions/code/1323247916
 * Title: hw2_1.java
 * Abstract: Takes user input of a positive integer, reverses it, and outputs, dropping leading zeroes.
 * Author: Adam Houser
 * ID: 1144
 * Date: 4/30/2020
 */

import java.util.Scanner;

public class hw2_1 {

    public static void main(String[] args) {

        String output = "";

        Scanner in = new Scanner(System.in);

        // read input as a string
        String input = in.nextLine();

        // copy to new string in reverse order
        for (int i = input.length()-1; i >= 0; i--) {
            output += input.charAt(i);
        }

        // if there are leading zeroes
        int j = 0;
        while (j < output.length() && output.charAt(j) == '0') {

            j++;
        }

        // convert to stringbuffer and replace leading zeroes
        StringBuffer sb = new StringBuffer(output);

        sb.replace(0, j, "");

        System.out.println(sb);

        in.close();
    }
}
