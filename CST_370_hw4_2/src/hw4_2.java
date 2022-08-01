/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw4/challenges/bfs-hops/submissions/code/1323587430
 * Title: hw4_2.java
 * Abstract: Takes user input of number of vertices, edges, source/destination cities, starting city, and
 *          number of hops.  Outputs all cities within number of hops of starting city.
 * Author: Adam Houser
 * ID: 1144
 * Date: 5/14/2020
 */

import java.util.*;

public class hw4_2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<String> cities = new ArrayList<String>();
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> output = new ArrayList<String>();
        TreeSet<String> foutput = new TreeSet<String>();
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        // get vertices
        int v = in.nextInt();

        // add cities to list for future lookup
        for (int i = 0; i < v; i++) {
            cities.add(in.next());
        }

        // get edges
        int e = in.nextInt();

        // create a list for each vertex
        for (int i = 0; i < v; i++) {
            ArrayList<String> destination = new ArrayList<String>();
            list.add(destination);
        }

        // add destination mapping for each
        for (int j = 0; j < e; j++) {
            list.get(cities.indexOf(in.next())).add(in.next());
        }

        // get starting city
        String start = in.next();

        // get number of hops
        int hops = in.nextInt();

        in.close();

        // add starting city to output
        visited.add(start);
        output.add(start);

        // if hops is greater than 0 add the list of places from start
        while (hops > 0) {
            // if hops is odd start with visited
            if (hops % 2 == 1) {
                for (int i = 0; i < visited.size(); i++) {
                    output.add(visited.get(i));

                    for(int j = 0; j < list.get(cities.indexOf(visited.get(i))).size(); j++) {
                        output.add(list.get(cities.indexOf(visited.get(i))).get(j));
                    }
                }
            }else {
                for (int i = 0; i < output.size(); i++) {
                    visited.add(output.get(i));

                    for(int j = 0; j < list.get(cities.indexOf(output.get(i))).size(); j++) {
                        visited.add(list.get(cities.indexOf(output.get(i))).get(j));
                    }
                }
            }

            // decrement hops
            hops--;
        }

        // put it all in a TreeSet to sort and remove dups
        for (int x = 0; x < output.size(); x++) {
            foutput.add(output.get(x));
        }
        for (int y = 0; y < visited.size(); y++) {
            foutput.add(visited.get(y));
        }

        // print final
        Iterator<String> iterator = foutput.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
