/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw5/challenges/kahns-topological-sort/submissions/code/1323827951
 * Title: hw5_3.java
 * Abstract: Reads in graph by user input and performs topological sort by Kahn's algorithm
 * Author: Adam Houser
 * ID: 1144
 * Date: 5/25/2020
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hw5_3 {

    public static void main(String[] args) {

        String output = "Order:";
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        Scanner in = new Scanner(System.in);

        // get number of vertices
        int v = in.nextInt();

        // populate list headers
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> vertex = new ArrayList<Integer>();
            list.add(vertex);
        }

        // create array for inorder degree
        int[] iod = new int[v];

        // get number of edges
        int e = in.nextInt();

        // get edges
        for (int i = 0; i < e; i++) {
            int src = in.nextInt();
            int dest = in.nextInt();

            // increment inorder degree for each destination
            iod[dest] += 1;

            // add to list info for directions
            list.get(src).add(dest);
        }

        in.close();

        // print inorder degree array and prep for DAG check
        int DAGcheck = 0;
        for (int x = 0; x < v; x++) {
            System.out.println("In-degree[" + x + "]:" + iod[x]);
            if (iod[x] > 0) {
                DAGcheck += 1;
            }
        }

        // check for DAG if there is no 0 then it is connected
        // if inorder degree is 0, add to queue
        for (int y = 0; y < v; y++) {
            if (iod[y] == 0) {
                queue.add(y);
            }
        }

        // start Kahn process dequeue, remove links and add to output
        int printCounter = 0;
        int queueCounter = 0;

        while (!queue.isEmpty()) {

            // get head of queue
            int temp = queue.poll();

            // add it to output
            output = output + temp;
            printCounter = printCounter + 1;

            if (printCounter < v) {
                output = output + "->";
            }

            // go through sublist and reduce inorder degree of destinations
            for (int j = 0; j < list.get(temp).size(); j++) {
                iod[list.get(temp).get(j)]--;

                // if we reduced it to 0, add to the queue
                if (iod[list.get(temp).get(j)] == 0) {
                    queue.add(list.get(temp).get(j));
                }
            }

            queueCounter++;
        }

        if(queueCounter != v) {
            output = "No Order:";
        }

        System.out.println(output);
    }
}
