/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw7/challenges/radix-sort-4-1/submissions/code/1324191099
 * Title: hw7_1.java
 * Abstract: Reads in numbers by user and performs radix sort, outputting each interim step and final sort
 * Author: Adam Houser
 * ID: 1144
 * Date: 6/10/2020
 */

package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class hw7_1 {

    public static void main(String[] args) {

        int max = 0;

        Scanner in = new Scanner(System.in);

        // read in the number of numbers for radix sort
        int num = in.nextInt();

        // create array of that size
        int input[] = new int[num];

        // read into arraylist the input numbers
        for (int i = 0; i < num; i++) {
            int temp = in.nextInt();
            input[i] = temp;

            if (temp > max) {
                max = temp;
            }
        }

        in.close();

        // get number of digits for radix sorting
        int length = String.valueOf(max).length();

        // perform radix sort for each digit
        for (int i = 0; i < length; i++)
            radixSort(input, num, i);
    }

    static void radixSort(int input[], int num, int rDigit)
    {
        int output[] = new int[num];
        int count[] = new int[10];
        int rValue = (int)Math.pow(10, rDigit);

        // populate the count array with all 0s to start
        Arrays.fill(count,0);

        // map the rDigit from input to count occurrences in the count array
        // this is the frequency
        for (int i = 0; i < num; i++) {
            int freqIndex = (input[i]/rValue)%10;
            count[freqIndex]++;
        }

        // Change count[i] to now be distribution sum of count[i] and count[i-1]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // working backwards and using distribution in count[], build output
        for (int i = num-1; i >= 0; i--) {
            int distIndex = (input[i]/rValue)%10;

            // index number from distribution, which is count[], used to map fom input to output
            output[count[distIndex] - 1] = input[i];
            // reduce the distribution number by 1
            count[distIndex]--;
        }

        // copy output values to input so we can do the next rDigit
        for (int i = 0; i < num; i++)
            input[i] = output[i];

        // print the output array
        for (int i = 0; i < num; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }
}
