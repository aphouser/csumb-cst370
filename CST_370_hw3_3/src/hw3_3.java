/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw3/challenges/equal-groups/submissions/code/1323407591
 * Title: hw3_3.java
 * Abstract: Reads user input of number of elements in a set and then those set elements.
 *          Output is all combinations of those elements
 * Author: Adam Houser
 * ID: 1144
 * Date: 5/6/2020
 */

import java.util.*;

public class hw3_3 {

    public static void main(String[] args) {

        ArrayList<Integer> members = new ArrayList();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sums = new ArrayList();

        Scanner in = new Scanner(System.in);

        // read input
        int elements = in.nextInt();
        int combos = (int)Math.pow(2, elements);
        int answer = 0;

        // add all members to ArrayList
        for (int i = 0; i < elements; i++){
            members.add(in.nextInt());
        }

        // sort ArrayList
        Collections.sort(members);

        // create a list for each combination of numbers
        for (int i = 0; i < combos; i++) {
            ArrayList<Integer> solution = new ArrayList<Integer>();
            list.add(solution);
        }

        // create combinations with binary
        for (int j = 0; j < combos; j++) {
            int tempSum = 0;
            String temp = Integer.toBinaryString(j);
            if (temp.length() < elements) {
                temp = String.format("%0"+ (elements - temp.length() )+"d%s",0 ,temp);
            }

            // check for each number in the new combination
            for (int k = 0; k < temp.length(); k++) {

                // if we have a 1 then add the number to both sum and arraylist for output
                if (temp.charAt(k) == 1 + '0') {
                    list.get(j).add(members.get(k));
                    tempSum += members.get(k);
                }
            }

            sums.add(tempSum);
        }

        in.close();

        // checking for matching sum pairs and saving the highest line for output
        for (int x = 0; x < sums.size(); x++) {
            if (sums.get(x) == sums.get(combos-1 - x)) {
                if (x > answer) {
                    answer = x;
                }
            }
        }

        System.out.print("Equal Set:");
        if (answer == 0) {
            System.out.print(" 0");
        }
        else {
            for (int y = 0; y < list.get(answer).size(); y++ ) {
                System.out.print(" " + list.get(answer).get(y));
            }
        }
    }
}
