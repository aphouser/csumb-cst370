/*
 * HackerRank link: https://www.hackerrank.com/contests/cst370-su20-hw1/challenges/max-events/submissions/code/1323168229
 * Abstract: This program reads the user's input data and simulates a calendar check.
 *          The hours are exploded and the check is for the highest number of
 *          overlapping events.
 * Author: Adam Houser
 * ID: 1144
 * Date: 04/27/2020
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class hw1_2 {

    public static void main(String[] args) {

        int events = 0;
        ArrayList<Integer> hours = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        // get number of events
        events = in.nextInt();

        // add hours for each event to load times
        for (int i = 0; i < events; i++) {
            hours.add(in.nextInt());
            hours.add(in.nextInt());
        }

        // expand all hours
        // this is close, not iterating right yet
        for (int j = 0; j < events * 2; j+=2) {
            for (int k = hours.get(j); k <= hours.get(j+1); k++) {
                results.add(k);
            }
        }

        // check for highest occurrence of overlapping
        int overlap = 0;

        for (int x = 0; x < results.size(); x++) {
            if (Collections.frequency(results, x) > overlap) {
                overlap = Collections.frequency(results, x);
            };
        }

        System.out.print("Answer:" + overlap);

        in.close();
    }
}
