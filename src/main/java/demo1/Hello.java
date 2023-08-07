package demo1;

public class Hello {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] arr3 = {{1,2}, {5,6}, {7,8}};
        int[][] arr2 = matrixReshape(arr3, 2, 3);
        System.out.println("done");

    }


    public static int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0;

        for(int i = 0; i < n / 2; i++) {
            sum += mat[i][i] +  mat[i][n - 1 - i] +  mat[n - 1 - i][i] + mat[n - 1 - i][n - 1 - i];
        }
        if (n % 2 == 1) {
            sum += mat[n / 2][n / 2];
        }
        return sum;
    }


    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int oldRow = mat.length;
        int oldColumn = mat[0].length;

        if (oldColumn * oldRow != r * c)
            return mat;

        int[][] resultArr = new int[r][c];

        for (int i = 0; i < r * c; i++) {
            resultArr[i / c][i % c] = mat[i / oldColumn][i % oldColumn];
        }

        return resultArr;
    }

}
