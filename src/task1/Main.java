package task1;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by Anton on 10.11.16.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MatrixSup matrSup = new MatrixSup();
        int n = scanner.nextInt();
        int[][] massA = new int[n][n];
        int[][] massB = new int[n][n];
        int[][] result;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                massA[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                massB[i][j] = scanner.nextInt();
            }
        }
        result = matrSup.VinStrassMulti(massA,massB);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}

