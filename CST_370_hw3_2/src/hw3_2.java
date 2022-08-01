/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw3/challenges/binary-numbs/submissions/code/1323407569
 * Title: hw3_2.java
 * Abstract: Reads user input of number of elements in a set and then those set elements.
 *          Output is all combinations of those elements
 * Author: Adam Houser
 * ID: 1144
 * Date: 5/6/2020
 */

import java.util.ArrayList;
import java.util.Scanner;

public class hw3_2 {

    public static void main(String[] args) {

        ArrayList<String> members = new ArrayList();

        Scanner in = new Scanner(System.in);

        // read input
        int elements = in.nextInt();

        // add all members to ArrayList
        for (int i = 0; i < elements; i++){
            members.add(in.next());
        }

        // print the lines with binary
        for (int j = 0; j < Math.pow(2, elements); j++) {
            String temp = Integer.toBinaryString(j);
            if (temp.length() < elements) {
                temp = String.format("%0"+ (elements - temp.length() )+"d%s",0 ,temp);
            }

            System.out.print(temp + ":");

            if (j == 0) {
                System.out.print("EMPTY");
            }

            for (int k = 0; k < temp.length(); k++) {
                if (temp.charAt(k) == 1 + '0') {
                    System.out.print(members.get (k) + " ");
                }
            }

            if (j != Math.pow(2, elements)-1) {
                System.out.print("\n");
            }
        }

        in.close();
    }
}
