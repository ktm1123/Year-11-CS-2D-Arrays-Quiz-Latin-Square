public class LatinSquare {

    /**
     *
     * @param rowSize
     * @return given the rowSize N (corresponding to an array of size N x N),
     *         calculate and return the sum of consecutive integers 1 + 2 + ... + N
     */
    public static int targetCheckSum1(int rowSize) {
        int sum = (rowSize * (rowSize + 1)) / 2;
        return sum;
    }

    /**
     *
     * @param rowSize
     * @return given the rowSize N (corresponding to an array of size N x N),
     *         calculate and return the product of consecutive integers 1 * 2 * ... * N
     */
    public static int targetCheckSum2(int rowSize) {
        int prod = 1;
        for (int i = 1; i <= rowSize; i++) {
            prod *= i;
        }
        return prod;
    }

    /**
     *
     * @param array2d
     * @param checkSum1
     * @param checkSum2
     * @return whether or not every row's sum in array2d is equal to checkSum1,
     *         AND that every row's product in array2d is equal to checkSum2
     */
    public static boolean isLatinRows(int[][] array2d, int checkSum1, int checkSum2) {
        for (int[] row : array2d) {
            int rowSum = 0;
            int rowProd = 1;
            for (int num : row) {
                rowSum += num;
                rowProd *= num;
            }
            if (rowSum != checkSum1 || rowProd != checkSum2) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum1
     * @param checkSum2
     * @return whether or not every column's sum in array2d is equal to checkSum1,
     *         AND that every column's product in array2d is equal to checkSum2
     */
    public static boolean isLatinColumns(int[][] array2d, int checkSum1, int checkSum2) {
        int rowSize = array2d.length;
        for (int col = 0; col < rowSize; col++) {
            int colSum = 0;
            int colProd = 1;
            for (int row = 0; row < rowSize; row++) {
                colSum += array2d[row][col];
                colProd *= array2d[row][col];
            }
            if (colSum != checkSum1 || colProd != checkSum2) {
                return false;
            }
        }
        return true;
    }


    /**
     *
     * @param array2d
     * @return whether array2d is a Latin square or not.
     *         Hint: make use of isLatinRows and isLatinColumns
     */
    public static boolean isLatinSquare(int[][] array2d) {
        int rowSize = array2d.length;
        int checkSum1 = targetCheckSum1(rowSize);
        int checkSum2 = targetCheckSum2(rowSize);
        return isLatinRows(array2d, checkSum1, checkSum2) && isLatinColumns(array2d, checkSum1, checkSum2);
    }



    /** OPTIONAL (only do if you have time)
     *
     * @param array2d
     * @return whether or not array2d is a latin square
     *         as well as whether the sum and product of each of the two main diagonals is equal
     *         to the checkSums or not.
     *
     * NOTE: not all Latin squares are diagonal; for example, diagonal Latin squares do not exist for 2x2 or 3x3
     */
    public static boolean isDiagonalLatinSquare(int[][] array2d) {
        return false;
    }

}
