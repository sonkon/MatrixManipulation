//  MathMatrix.java - CS314 Assignment 2

/*  Student information for assignment:
 *
 *  On my honor, Sonali, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: sk44823
 *  email address: sonalikon@gmail.com
 *  Grader name: Shelby
 *  Unique section number: 51485
 *  Number of slip days I am using:
 */

import java.lang.*;

public class MathMatrix
{
    int[][] values;

    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix 
     */
    
    public MathMatrix(int[][] mat) {
        // check the precondition. rectangularMatrix is a private method at end of Matrix class
        if((mat == null) || (mat.length == 0) || (mat[0].length == 0) || !rectangularMatrix(mat)){
            throw new IllegalArgumentException("Violation of precondition: int[][] Matrix constructor");
        }
        values = new int[mat.length][mat[0].length]; 

        // For loop copies values from one array to another.
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                values[i][j] = mat[i][j];
            }
        }

    }

    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns. 
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal 
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
        if (numRows < 0 || numCols < 0){ 
            throw new IllegalArgumentException("Violation of precondition: numRows or numCols < 0");
        }
        values = new int[numRows][numCols]; 

        // For loops to fill array with the inital value.
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                values[i][j] = initialVal;
            }
        }

    }

    /**
     * change the value of one of the cells in this MathMatrix.
     * <br>pre: 0 <= row < numRows(), 0 <= col < numCols()
     * <br>post: getVal(row, col) = newValue
     * @param row 0 <= row < numRows()
     * @param col 0 <= col < numCols()
     */
    public void changeElement(int row, int col, int newValue) {
        if (col >= values[0].length || row >= values.length || col < 0 || row < 0){ 
            throw new IllegalArgumentException("Violation of precondition: row or col less than length");
        }
        values[row][col] = newValue;
    }

    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int numRows() {
        return values.length;
    }

    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int numCols() {
        return values[0].length;
    }

    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < numRows(), col  0 <= col < numCols()
     * @param  row  0 <= row < numRows()
     * @param  col  0 <= col < numCols()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
        return values[row][col];
    }

    /**
     * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
     * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
     * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
     * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
     */
    public MathMatrix add(MathMatrix rightHandSide) {
        if (rightHandSide.numRows() != values.length || rightHandSide.numCols() != values[0].length){ 
            throw new IllegalArgumentException("Violation of precondition: row or col < 0");
        }

        // Two for loops to add the values in both arrays together.
        MathMatrix result = new MathMatrix(values.length, values[0].length, 0);
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                result.changeElement(i,j,values[i][j] + rightHandSide.getVal(i,j));
            }
        }
        return result;
    }

    /**
     * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
     * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
     * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
     * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
     */
    public MathMatrix subtract(MathMatrix rightHandSide) {
        if (rightHandSide.numRows() != values.length || rightHandSide.numCols() != values[0].length){ 
            throw new IllegalArgumentException("Violation of precondition: row or col < 0");
        }

        // Two for loops to substract the corresponding values in both arrays.
        
        MathMatrix result = new MathMatrix(values.length, values[0].length, 0);
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                result.changeElement(i,j,values[i][j] - rightHandSide.getVal(i,j));
            }
        }
        return result;
    }

    /**
     * implements matrix multiplication, (this MathMatrix) * rightHandSide.
     * <br>pre: rightHandSide.numRows() = numCols()
     * <br>post: This method should not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.numRows() = numCols()
     * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
     * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
     */
    public MathMatrix multiply(MathMatrix rightHandSide) {
        if (rightHandSide.numRows() != values[0].length){ 
            throw new IllegalArgumentException("Violation of precondition: row or col < 0");
        }

        // Three for loops for matrix multiplicaiton.
        
        MathMatrix result = new MathMatrix(values.length, rightHandSide.numCols(), 0);

        for(int i = 0; i < values.length; i++){
            for(int j = 0; j < rightHandSide.numCols(); j++){
                for (int k = 0; k < values[0].length; k++){
                    result.changeElement(i,j,result.getVal(i,j) + (values[i][k] * rightHandSide.getVal(k,j)));
                }
            }
        }

        return result;
    } 

    /**
     * Multiply all elements of this MathMatrix by factor.
     * <br>pre: none
     * <br>post: all elements in this matrix have been multiplied by factor. 
     * In other words after this method has been called getVal(r,c) = old getVal(r, c) * factor
     * for all valid r and c.
     * @param factor the value to multipy every cell in this Matrix by.
     */
    public void scale(int factor) {
        // Multiply all the values in the matrix by the factor.
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                values[i][j] =  values[i][j] * factor;
            }
        }
    }

    /**
     * accessor: get a transpose of this MathMatrix. 
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
        // Transpose the elements in the matrix.
        MathMatrix result = new MathMatrix(values[0].length, values.length, 0);
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                result.changeElement(j,i, values[i][j]);
            }
        }
        return result;
    }

    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide) {
        if(rightHandSide != null && this.getClass() == rightHandSide.getClass()){
            // rightHandSide is a non null MathMatrix
            MathMatrix otherMatrix = (MathMatrix)rightHandSide;

            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[0].length; j++) {
                    if (values[i][j] != otherMatrix.getVal(i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * override toString.
     * @return a String with all elements of this MathMatrix. 
     * Each row is on a seperate line.
     * Spacing based on longest element in this Matrix.
     * Each row stats and ends with a vertical bar: '|'
     */
    public String toString(){
        int maxlength = 0;
        StringBuilder strb = new StringBuilder();
        
        // For loops to check for longest value.
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                int lengthOfX = ("" + values[i][j]).length();
                if (lengthOfX > maxlength){
                    maxlength = lengthOfX;
                }
            }
        }
        
        //Space and fill string according to the format.
        maxlength++;
        for (int i = 0; i < values.length; i++) {
            strb.append("|");
            for (int j = 0; j < values[0].length; j++) {
                for (int k = 0; k < (maxlength - ("" + values[i][j]).length()); k++) {
                    strb.append(" ");
                }
                strb.append("" + values[i][j]);

            }
            strb.append("|" + "\n");
        }

        return strb.toString();
    }

    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main 
     * diagonal must be 0.<br>
     * pre: this is a square matrix. numRows() == numCols()  
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise. 
     */
    public boolean isUpperTriangular() {
        
        // Check for patterns in the matrix.
        if (values.length != values[0].length){
            throw new IllegalArgumentException("Not a square matrix");
        }
        for(int i = 0; i < values.length; i++) {
            for(int j = 0; j < i; j++){ 
                if (values[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // method to ensure mat is rectangular
    // pre: mat != null
    public static boolean rectangularMatrix(int[][] mat) {
        if(mat == null) {
            throw new IllegalArgumentException("Violation of precondition: "
                + " Parameter mat may not be null");
        }

        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;

        while( isRectangular && row < mat.length ) {
            isRectangular = ( mat[row].length == COLUMNS );
            row++;
        }

        return isRectangular;
    }
}