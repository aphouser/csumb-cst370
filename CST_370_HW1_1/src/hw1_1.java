/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw1/challenges/common-nums/submissions/code/1323146052import java.util.*;
 * Title: hw1_1.java
 * Abstract: This program reads the user's input data for 2 groups of numbers
 *          and compares for common entries.  Then prints those entries or NONE.
 * Author: Adam Houser
 * ID: 1144
 * Date: 04/26/2020
 */

import java.util.*;

public class hw1_1 {


    public static void main(String[] args) {

        int g1Count = 0;
        int g2Count = 0;
        Set<Integer> common = new TreeSet<Integer>();
        boolean check = true;

        Scanner in = new Scanner(System.in);

        // find out how big the first group is
        g1Count = in.nextInt();

        // add g1Count next numbers to a new array
        int[] group1 = new int[g1Count];
        for (int i = 0; i < g1Count; i++) {
            group1[i] = in.nextInt();
        }

        // find out how big the second group is
        g2Count = in.nextInt();

        // add g1Count next numbers to a new array
        int[] group2 = new int[g2Count];
        for (int i = 0; i < g2Count; i++) {
            group2[i] = in.nextInt();
        }

        // check which numbers are in both arrays and then add to common TreeSet to
        // sort and avoid duplicates
        for (int x = 0; x < group1.length; x++) {
            for (int y = 0; y < group2.length; y++) {
                if (group1[x] == group2[y]) {
                    common.add(group1[x]);
                }
            }
        }

        System.out.print("Answer:");

        if (common.size() > 0) {
            for (int i : common) {
                System.out.print(i + " ");
            }
        }
        else {
            System.out.print("NONE");
        }
    }
}