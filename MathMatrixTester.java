import java.util.Random;

/*  Student information for assignment:
 *
 *  UTEID: sk44823
 *  email address: sonalikon@gmail.com
 *  Grader name: Shelby
 *  Unique section number: 51485
 *  Number of slip days I am using:
 */


/*Answers to Questions:
 * 1. Around 280 seconds.
 * 2. O(N^2), yes, it is supported.
 * 3. Around 1525 seconds.
 * 4. O(N^3), yes, it is supported.
 * 5. About 4000 * 4000, which would need around 64 bytes.
 * 
 * Experiment 1:
 * N = 1000 t = 5.73
 * 2N = 2000 t = 18.46
 * 4N = 4000 t = 68.01
 * 
 * Experiment 2:
 * N = 100: 0.983
 * N = 200: 10.02
 * N = 400: 134.72
 
*  Random rand = new Random(6201919);
*  int rows = 100;
*  int cols = 100;
*  int limit = 1000;
*  MathMatrix mm1 = createMat(rand, rows, cols, limit);
*  MathMatrix mm2 = createMat(rand, rows, cols, limit);
*  Stopwatch sw = new Stopwatch();
*  sw.start();
*  for(int i = 0; i <= 100; i++){
    *  mm1.multiply(mm2);
*  }
*  sw.stop();
*  System.out.println(sw.time()); 
*  
*/
        

/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester {
    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {

        int[][] data1 = { {2, 3, 4},
                          {3, 4, 5}};
        int[][] data2 = { {1, 1, 1},
                          {2, 3, 4}};
        int[][] e1;

        //test 1, specify size and values constructor
        MathMatrix mat1 = new MathMatrix(3, 3, 2);
        e1 = new int[][] {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        printTestResult( get2DArray(mat1), e1, 1, "Constructor with size and initial val specified.");
        
        //test 2, specify size and values constructor
        mat1 = new MathMatrix(1, 3, 2);
        e1 = new int[][] {{2, 2, 2}};
        printTestResult( get2DArray(mat1), e1, 2, "Constructor with size and initial val specified.");

        //tests 3, int[][] constructor and deep copy
        mat1 = new MathMatrix( data1 );
        data1[0][0] = 4;
        // alter data1. mat1 should be unchanged if deep copy made
        e1 = new int[][] { {4, 3, 4}, {3, 4, 5} };
        printTestResult( data1, e1, 3, "Constructor with one parameter of type int[][]");
        // data1 altered. mat1 should be unchanged if deep copy made
        e1 = new int[][] { {2, 3, 4}, {3, 4, 5} };
        printTestResult( get2DArray(mat1), e1, 3, "Constructor with one parameter of type int[][]. Testing deep copy made.");
        
        //tests 4, int[][] constructor and deep copy
        mat1 = new MathMatrix( data2 );
        // data1 altered. mat1 should be unchanged if deep copy made
        e1 = new int[][] { {1, 1, 1}, {2, 3, 4} };
        printTestResult( get2DArray(mat1), e1, 4, "Constructor with one parameter of type int[][]. Testing deep copy made.");
        
        //tests 5, changeElement
        mat1.changeElement(0, 0, 2);
        e1 = new int[][] { {2, 1, 1}, {2, 3, 4} };
        printTestResult( get2DArray(mat1), e1, 5, "ChangeElement.");
        
        //tests 6, changeElement
        mat1.changeElement(0, 0, 1);
        e1 = new int[][] { {1, 1, 1}, {2, 3, 4} };
        printTestResult( get2DArray(mat1), e1, 6, "ChangeElement.");
        
        //tests 7, numRows
        mat1 = new MathMatrix(2, 5, 0);
        if (mat1.numRows() == 2){
            System.out.println("Passed test 7, numRows.");
        } else {
            System.out.println("Failed test 7, numRows.");
        }
        
        //tests 8, numRows
        mat1 = new MathMatrix(3, 7, 4);
        if (mat1.numRows() == 3){
            System.out.println("Passed test 8, numRows.");
        } else {
            System.out.println("Failed test 8, numRows.");
        }
        
        //tests 9, numCols
        mat1 = new MathMatrix(4, 7, 1);
        if (mat1.numCols() == 7){
            System.out.println("Passed test 9, numCols.");
        } else {
            System.out.println("Failed test 9, numCols.");
        }
        
        //tests 10, numCols
        mat1 = new MathMatrix(2, 8, 9);
        if (mat1.numCols() == 8){
            System.out.println("Passed test 10, numCols.");
        } else {
            System.out.println("Failed test 10, numCols");
        }
        
        //tests 11, getVal
        mat1 = new MathMatrix(2, 8, 9);
        if (mat1.getVal(1, 4) == 9){
            System.out.println("Passed test 11, getVal.");
        } else {
            System.out.println("Failed test 11, getVal.");
        }
        
        //tests 12, getVal
        mat1 = new MathMatrix(2, 5, 2);
        if (mat1.getVal(1, 4) == 2){
            System.out.println("Passed test 12, getVal.");
        } else {
            System.out.println("Failed test 12, getVal.");
        }
        
        //tests 13, addition
        mat1 = new MathMatrix(data1);
        MathMatrix mat2 = new MathMatrix(data2);
        MathMatrix mat3 = mat1.add(mat2);

        e1 = new int[][] { {4, 3, 4}, {3, 4, 5} };
        printTestResult( get2DArray(mat1), e1, 13, "add method. Testing mat1 unchanged.");
        e1 = new int[][] { {1, 1, 1}, {2, 3, 4} };
        printTestResult( get2DArray(mat2), e1, 13, "add method. Testing mat2 unchanged.");
        e1 = new int[][] { {5, 4, 5}, {5, 7, 9} };
        printTestResult( get2DArray(mat3), e1, 13, "add method. Testing mat3 correct result.");
        
        //tests 14, addition
        data1[1][1] = 4;
        data2[0][2] = 8;
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.add(mat2);
        e1 = new int[][] { {4, 3, 4}, {3, 4, 5} };
        printTestResult( get2DArray(mat1), e1, 14, "add method. Testing mat1 unchanged.");
        e1 = new int[][] { {1, 1, 8}, {2, 3, 4} };
        printTestResult( get2DArray(mat2), e1, 14, "add method. Testing mat2 unchanged.");
        e1 = new int[][] { {5, 4, 12}, {5, 7, 9} };
        printTestResult( get2DArray(mat3), e1, 14, "add method. Testing mat3 correct result.");

        //tests 15, subtraction
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.subtract(mat2);
        e1 = new int[][] { {4, 3, 4}, {3, 4, 5} };
        printTestResult( get2DArray(mat1), e1, 15, "subtract method. Testing mat1 unchanged.");
        e1 = new int[][] { {1, 1, 8}, {2, 3, 4} };
        printTestResult( get2DArray(mat2), e1, 15, "subtract method. Testing mat2 unchanged.");
        e1 = new int[][] { {3, 2, -4}, {1, 1, 1} };
        printTestResult( get2DArray(mat3), e1, 15, "subtract method. Testing mat3 correct result.");
        
        //tests 16, subtraction
        data1[1][1] = 2;
        data2[0][2] = 9;
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.subtract(mat2);
        e1 = new int[][] { {4, 3, 4}, {3, 2, 5} };
        printTestResult( get2DArray(mat1), e1, 16, "subtract method. Testing mat1 unchanged.");
        e1 = new int[][] { {1, 1, 9}, {2, 3, 4} };
        printTestResult( get2DArray(mat2), e1, 16, "subtract method. Testing mat2 unchanged.");
        e1 = new int[][] { {3, 2, -5}, {1, -1, 1} };
        printTestResult( get2DArray(mat3), e1, 16, "subtract method. Testing mat3 correct result.");
        
        //test 17, multiplication
        data1[1][1] = 4;
        data2 = new int[][] { {0, 4}, {2, 5}, {2, 7} };
        mat2 = new MathMatrix(data2);
        mat1 = new MathMatrix(data1);
        mat3 = mat2.multiply(mat1);
        e1 = new int[][] { {12, 16, 20}, {23, 26, 33}, {29, 34, 43} };
        printTestResult( get2DArray(mat3), e1, 17, "multiply method");
        
        //test 18, multiplication
        data2 = new int[][] { {3, 4}, {2, 1}, {5, 2} };
        mat2 = new MathMatrix(data2);
        mat1 = new MathMatrix(data1);
        mat3 = mat2.multiply(mat1);
        e1 = new int[][] { {24, 25, 32}, {11, 10, 13}, {26, 23, 30} };
        printTestResult( get2DArray(mat3), e1, 18, "multiply method");
        
        //test 19, scale
        data1 = new int[][] { {3, 4}, {2, 1}, {5, 2} };
        mat1 = new MathMatrix(data1);
        mat1.scale(2);
        e1 = new int[][] { {6, 8}, {4, 2}, {10, 4} };
        printTestResult( get2DArray(mat1), e1, 19, "scale method.");
        
        //test 20, scale
        data1 = new int[][] { {8, 6, 7}, {2, 1, 4}};
        mat1 = new MathMatrix(data1);
        mat1.scale(3);
        e1 = new int[][] { {24, 18, 21}, {6, 3, 12}};
        printTestResult(get2DArray(mat1), e1, 20, "scale method.");
        
        //test 21, transpose
        data1 = new int[][] { {2, 2, 2}};
        mat1 = new MathMatrix(data1).getTranspose();  
        e1 = new int[][] {{2}, {2}, {2}};
        printTestResult( get2DArray(mat1), e1, 21, "transpose method.");
        
        //test 22, transpose
        data1 = new int[][] { {2, 2, 8}, {2, 2, 8}};
        mat1 = new MathMatrix(data1).getTranspose();
        e1 = new int[][] {{2, 2}, {2, 2}, {8, 8}};
        printTestResult( get2DArray(mat1), e1, 22, "transpose method.");

        //test 23, equals
        data1 = new int[][] { {8, 6, 7}, {2, 1, 4}};
        mat1 = new MathMatrix(data1);
        data2 = new int[][] { {8, 6, 7}, {2, 1, 4}};
        mat2 = new MathMatrix(data2);
        if( mat1.equals(mat2) ) {
            System.out.println("Passed test 23, equals method.");
        } else {
            System.out.println("Failed test 23, equals method.");
        }
        
        //test 24, equals
        data1 = new int[][] { {4, 2, 1}};
        mat1 = new MathMatrix(data1);
        data2 = new int[][] {{3, 2, 1}};
        mat2 = new MathMatrix(data2);
        if( mat1.equals(mat2) ) {
            System.out.println("Failed test 24, equals method.");
        } else {
            System.out.println("Passed test 24, equals method.");
        }
        
        //test 25, toString()
        data1 = new int[][] {{34, 56, 32, -10},
                             {45, 3, 2, 5},
                             {6, -3, 9, 0}};
        mat1 = new MathMatrix(data1);
        String expected = "|  34  56  32 -10|\n|  45   3   2   5|\n|   6  -3   9   0|\n";
        if( mat1.toString().equals( expected ) ) {
            System.out.println("Passed test 25, toString method.");
        } else {
            System.out.println("Failed test 25, toString method.");
        }
        
        //test 26, toString()
        data1 = new int[][] {{2, 534, 2, -1},
                             {56, 23, 2, 2},
                             {67, 5, 8, 1}};
        mat1 = new MathMatrix(data1);
        expected = "|   2 534   2  -1|\n|  56  23   2   2|\n|  67   5   8   1|\n";
        if( mat1.toString().equals( expected ) ) {
            System.out.println("Passed test 26, toString method.");
        } else {
            System.out.println("Failed test 26, toString method.");
        }
        
        //test 27, upperTriangular
        data1 = new int[][] {{4, 2, 5, 0}, {0, 2, 6, 3}, {0, 0, 4, 8}, {0, 0, 0, 90}};
        mat1 = new MathMatrix(data1);
        if( mat1.isUpperTriangular()){
            System.out.println("Passed test 27, upperTriangular method.");
        } else {
            System.out.println("Failed test 27, upperTriangular method.");
        }
        
        //test 28, upperTriangular
        data1 = new int[][] {{5, 2, 3, 0}, {0, 3, 1, 3}, {0, 0, 6, -2}, {8, 7, 3, 4}};
        mat1 = new MathMatrix(data1);
        if(!mat1.isUpperTriangular()) { 
            System.out.println("Passed test 28, upperTriangular method.");
        } else {
            System.out.println("Failed test 28, upperTriangular method.");   
        }
    }
    
    // method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(MathMatrix mat) {
        if(mat == null){
            throw new IllegalArgumentException("mat may not be null");
        }
        
        int result = 0;
        final int ROWS =  mat.numRows();
        final int COLS = mat.numCols();
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                result += mat.getVal(r, c); // likely to overflow, but can still do simple check
            }
        }
        return result;
    }
    
    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    private static MathMatrix createMat(Random randNumGen, int rows,
            int cols, final int LIMIT) {
        
        if(randNumGen == null)
            throw new IllegalArgumentException("randomNumGen variable may no be null");
        else if(rows <= 0 || cols <= 0)
            throw new IllegalArgumentException("rows and columns must be greater than 0. " +
                    "rows: " + rows + ", cols: " + cols);
        
        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
        
        return new MathMatrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2, int testNum, String testingWhat) {
        System.out.print( "Test number " + testNum + " tests the " + testingWhat +". The test ");
        String result = equals(data1, data2) ? "passed" : "failed";
        System.out.println( result );
    }

    // pre: m != null, m is at least 1 by 1 in size
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        assert ( m != null ) && ( m.numRows() > 0 ) && ( m.numCols()> 0 )
                : "Violation of precondition: get2DArray";

        int[][] result = new int[m.numRows()][m.numCols()];
        for(int r = 0; r < result.length; r++)
        {   for(int c = 0; c < result[0].length; c++)
            {   result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
       //check precondition
        if( ( data1 == null ) || ( data1.length == 0 )
               || ( data1[0].length == 0 ) || !rectangularMatrix(data1)
               ||  ( data2 == null ) || ( data2.length == 0 )
               || ( data2[0].length == 0 ) || !rectangularMatrix(data2))
                throw new IllegalArgumentException( "Violation of precondition: equals check on 2d arrays of ints");

        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
        int row = 0;
        while( result && row < data1.length ) {
            int col = 0;
            while( result && col < data1[0].length ) {
               result = (data1[row][col] == data2[row][col]);
                col++;
            }
            row++;
        }

        return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
        if(mat == null || mat.length == 0 || mat[0].length == 0)
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null" 
                    + " and must be at least 1 by 1");
        return MathMatrix.rectangularMatrix(mat);
    }
}
