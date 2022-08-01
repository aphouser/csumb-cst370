/*
 * HackerRank link: https://www.hackerrank.com/contests/cst370-su20-hw0/challenges/370-hw0-1/submissions/code/1323105249
 * Title: hw0_1.java
 * Abstract: This program reads the user's input data and
 *           conducts sum and difference operations, depending
 *           on the command key.
 * Author: Adam Houser
 * ID: 1144
 * Date: 04/25/2020
 */


import java.util.*;

import static java.lang.Math.abs;

public class hw0_1 {

    public static void main(String[] args) {

        ArrayList<Integer> results = new ArrayList<>();
        int choice = 0, num1, num2;
        int result = 0;

        Scanner in = new Scanner(System.in);

        while (true)
        {
            choice = in.nextInt();
            if (choice == 9)
            {
                break;
            }

            num1 = in.nextInt();
            num2 = in.nextInt();


            if (choice == 1)
            {
                // 1 means add
                results.add(num1 + num2);
            }
            else if (choice == 2)
            {
                results.add(Math.abs(num1 - num2));
            }
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

    }
}