/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw5/challenges/connect-components/submissions/code/1323830193
 * Title: hw5_4.java
 * Abstract: Reads in graph by user input.  Checks for connectivity and adds edges if they are needed to connect
 * Author: Adam Houser
 * ID: 1144
 * Date: 5/25/2020
 */

import java.util.*;

public class hw5_4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<Integer> notVisited = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> queue = new LinkedList<>();

        // get vertices
        int v = in.nextInt();

        // get edges
        int e = in.nextInt();

        // create a list for each vertex
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> destination = new ArrayList<Integer>();
            list.add(destination);
            notVisited.add(i);
        }

        // add destination mapping for each
        for (int j = 0; j < e; j++) {
            list.get(in.nextInt()).add(in.nextInt());
        }

        in.close();

        // add starting city to queue
        notVisited.remove(Integer.valueOf(0));
        queue.add(0);

        // start searching to find child nodes
        while (!queue.isEmpty()) {
            // peek at the front of the queue
            int temp = queue.poll();

            // add all of it's subs to the queue
            for (int i = 0; i < list.get(temp).size(); i++) {

                // if a sub hasn't been visited add it to the queue prevents cycle loops
                if (notVisited.contains(list.get(temp).get(i))) {
                    queue.add(list.get(temp).get(i));
                }

                // remove from list of notVisited
                notVisited.remove(list.get(temp).get(i));
            }
        }

        // if notVisited has anything in it, we have unconnected graphs
        if (notVisited.isEmpty()) {
            System.out.println("No new edge:");
        }
        else {
            // while there are still vertices not visited
            int start = 0;
            while (!notVisited.isEmpty()) {

                int temp2 = notVisited.get(0);

                // add an edge from our start point to the first non-visited
                list.get(start).add(temp2);
                System.out.println("Edge: " + start + "-" + temp2);

                // move start for any further edges to add
                start = temp2;

                // add the newly connected vertex to the queue and mark as visited
                queue.add(temp2);
                notVisited.remove(Integer.valueOf(temp2));

                // run check on that
                while (!queue.isEmpty()) {
                    // peek at the front of the queue
                    int temp = queue.poll();

                    // add all of it's subs to the queue
                    for (int i = 0; i < list.get(temp).size(); i++) {

                        // if a sub hasn't been visited add it to the queue prevents cycle loops
                        if (notVisited.contains(list.get(temp).get(i))) {
                            queue.add(list.get(temp).get(i));
                        }

                        // remove from list of notVisited
                        notVisited.remove(list.get(temp).get(i));
                    }
                }
            }
        }
    }
}
