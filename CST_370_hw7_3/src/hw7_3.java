/*
 * HackerRank link:https://www.hackerrank.com/contests/cst370-su20-hw7/challenges/floyd-all-pairs-shortest-paths/submissions/code/1324211899
 * Title: hw7_3.java
 * Abstract: Reads in adjcency matrix by user and performs Floyd's algorithm to find shortest distances
 * Author: Adam Houser
 * ID: 1144
 * Date: 6/11/2020
 */

import java.util.Scanner;

public class hw7_3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // read in the number of vertices
        int num = in.nextInt();

        // create matrix
        int matrix[][] = new int[num][num];

        // read in distance matrix
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        in.close();

        // sort matrix
        floydSort(matrix, num);

        // print after matrix
        print(matrix, num);
    }

    static void print(int[][] matrix, int num)
    {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void floydSort(int[][] matrix, int num)
    {
        for (int k = 0; k < num; k++) {
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    // using -1 to represent infinity so check for that first
                    // if our "home" square is negative = infinity,
                    // make sure the others are not also negative to get a distance
                    if (matrix[i][j] < 0 && matrix[i][k] > 0 && matrix[k][j] > 0) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                    // otherwise check the lesser between "home" square and the other two
                    // provided they are also not negative
                    else if (matrix[i][j] > matrix[i][k] + matrix[k][j] && matrix[i][k] > 0 && matrix[k][j] > 0){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
    }
}
