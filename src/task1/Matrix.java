package task1;

/**
 * Created by Anton on 10.11.16.
 */
public class Matrix {
    private int[][] a11;
    private int[][] a12;
    private int[][] a21;
    private int[][] a22;

    public int[][] getA11() {
        return a11;
    }

    public int[][] getA12() {
        return a12;
    }

    public int[][] getA21() {
        return a21;
    }

    public int[][] getA22() {
        return a22;
    }

    public void setA11(int[][] a11) {
        this.a11 = a11;
    }

    public void setA12(int[][] a12) {
        this.a12 = a12;
    }

    public void setA21(int[][] a21) {
        this.a21 = a21;
    }

    public void setA22(int[][] a22) {
        this.a22 = a22;
    }
}
