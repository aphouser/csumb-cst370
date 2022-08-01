/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw2/challenges/time-difference-2/submissions/code/1323248347
 * Title: hw2_2.java
 * Abstract: Takes user input of two timestamps and caculates the difference.  Second timestamp is always later.
 * Author: Adam Houser
 * ID: 1144
 * Date: 4/30/2020
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw2_2 {

    public static void main(String[] args) {

        ArrayList<Integer> times = new ArrayList<Integer>();
        Pattern pattern = Pattern.compile("\\d+");

        Scanner in = new Scanner(System.in);

        // read numbers into array
        String time1 = in.nextLine();
        Matcher matcher = pattern.matcher(time1);

        while (matcher.find()) {
            times.add(Integer.parseInt(matcher.group()));
        }

        String time2 = in.nextLine();
        Matcher matcher2 = pattern.matcher(time2);

        while (matcher2.find()) {
            times.add(Integer.parseInt(matcher2.group()));
        }

        // check if later time needs to borrow for subtraction
        // seconds
        if(times.get(5) < times.get(2)) {
            times.set(5, times.get(5) + 60);
            times.set(4, times.get(4) - 1);
        }
        times.add(times.get(5) - times.get(2));

        // minutes
        if(times.get(4) < times.get(1)) {
            times.set(4, times.get(4) + 60);
            times.set(3, times.get(3) - 1);
        }
        times.add(times.get(4) - times.get(1));

        // no borrowing for hours but it may go overnight
        if(times.get(3) < times.get(0)) {
            times.set(3, times.get(3) + 24);
        }
        times.add(times.get(3) - times.get(0));

        String hours = String.format("%02d", times.get(8));
        String minutes = String.format("%02d", times.get(7));
        String seconds = String.format("%02d", times.get(6));

        System.out.println(hours + ":" + minutes + ":" + seconds);

        in.close();
    }
}
