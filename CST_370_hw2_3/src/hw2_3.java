/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw2/challenges/adjacency-list/submissions/code/1323248607
 * Title: hw2_3.java
 * Abstract: Takes user input of number of vertices and number of edges, then each directed edge vertex pair.
 *          Output is each vertex and the directed edges from that vertex.
 * Author: Adam Houser
 * ID: 1144
 * Date: 4/30/2020
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class hw2_3 {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        Scanner in = new Scanner(System.in);

        // read vertices and edges in
        int v = in.nextInt();
        int e = in.nextInt();

        // create a list for each vertex
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> vertex = new ArrayList<Integer>();
            list.add(vertex);
        }

        // add edge mapping for each
        for (int j = 0; j < e; j++) {
            list.get(in.nextInt()).add(in.nextInt());
        }

        // sort arraylists
        for (int k = 0; k < v; k++) {
            Collections.sort(list.get(k));
        }

        // print arraylists
        for (int m = 0; m < v; m++) {
            System.out.print(m);

            if (list.get(m).size() > 0) {
                for (int n =0; n < list.get(m).size(); n++)
                    System.out.print("->" + list.get(m).get(n));
            }

            System.out.print("\n");
        }

        in.close();
    }
}