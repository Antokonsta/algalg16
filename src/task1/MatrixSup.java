package task1;

/**
 * Created by Anton on 10.11.16.
 */
public class MatrixSup {

    public int[][] VinStrassMulti(int[][] first, int[][] second) {
        int n = first.length;
        if (n < 64) {
            return multi(first, second);
        } else {
            Matrix A = divideAndAddZeros(first);
            Matrix B = divideAndAddZeros(second);
            int[][] S1 = matrixPlus(A.getA21(), A.getA22());
            int[][] S2 = matrixMinus(S1, A.getA11());
            int[][] S3 = matrixMinus(A.getA11(), A.getA21());
            int[][] S4 = matrixMinus(A.getA12(), S2);
            int[][] S5 = matrixMinus(B.getA12(), B.getA11());
            int[][] S6 = matrixMinus(B.getA22(), S5);
            int[][] S7 = matrixMinus(B.getA22(), B.getA12());
            int[][] S8 = matrixMinus(S6, B.getA21());

            int[][] P1 = VinStrassMulti(S2, S6);
            int[][] P2 = VinStrassMulti(A.getA11(), B.getA11());
            int[][] P3 = VinStrassMulti(A.getA12(), B.getA21());
            int[][] P4 = VinStrassMulti(S3, S7);
            int[][] P5 = VinStrassMulti(S1, S5);
            int[][] P6 = VinStrassMulti(S4, B.getA22());
            int[][] P7 = VinStrassMulti(A.getA22(), S8);

            int[][] T1 = matrixPlus(P1, P2);
            int[][] T2 = matrixPlus(T1, P4);

            int[][] C11 = matrixPlus(P2, P3);
            int[][] C12 = matrixPlus(matrixPlus(T1, P5), P6);
            int[][] C21 = matrixMinus(T2, P7);
            int[][] C22 = matrixPlus(T2, P5);

            int razm = 2 * C11.length;

            int[][] result = new int[razm][razm];

            for (int i = 0; i < razm; i++) {
                for (int j = 0; j < razm; j++) {
                    if (i < razm / 2 && j < razm / 2) {
                        result[i][j] = C11[i][j];
                    }
                    if (i < razm / 2 && j >= razm / 2) {
                        result[i][j] = C12[i][j - razm / 2];
                    }
                    if (i >= razm / 2 && j < razm / 2) {
                        result[i][j] = C21[i - razm / 2][j];
                    }
                    if (i >= razm / 2 && j >= razm / 2) {
                        result[i][j] = C22[i - razm / 2][j - razm / 2];
                    }
                }
            }
            return result;


        }
    }


    public int[][] multi(int[][] first, int[][] second) {
        int n = first.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        return result;
    }

    private Matrix divideAndAddZeros(int[][] mass) {
        Matrix matr = new Matrix();

        int n = mass.length;
        int m = (int) Math.pow(2, roundUpLog2(n));
        int[][] result = new int[m][m];

        int[][] a11 = new int[m / 2][m / 2];
        int[][] a12 = new int[m / 2][m / 2];
        int[][] a21 = new int[m / 2][m / 2];
        int[][] a22 = new int[m / 2][m / 2];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n && j < n) {
                    result[i][j] = mass[i][j];
                } else {
                    result[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                a11[i][j] = result[i][j];
            }
        }

        for (int i = 0; i < m / 2; i++) {
            for (int j = m / 2; j < m; j++) {
                a12[i][j - m / 2] = result[i][j];
            }
        }

        for (int i = m / 2; i < m; i++) {
            for (int j = 0; j < m / 2; j++) {
                a21[i - m / 2][j] = result[i][j];
            }
        }

        for (int i = m / 2; i < m; i++) {
            for (int j = m / 2; j < m; j++) {
                a22[i - m / 2][j - m / 2] = result[i][j];
            }
        }

        matr.setA11(a11);
        matr.setA12(a12);
        matr.setA21(a21);
        matr.setA22(a22);

        return matr;

    }

    private int[][] matrixPlus(int[][] first, int[][] second) {
        int n = first.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }
        return result;
    }

    private int[][] matrixMinus(int[][] first, int[][] second) {
        int n = first.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = first[i][j] - second[i][j];
            }
        }
        return result;
    }

    private int roundUpLog2(int x) {
        return (int) Math.ceil((Math.log(x) / Math.log(2)));
    }


}
