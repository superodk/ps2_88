/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp88_ueb01;

/**
 *
 * @author ODK
 */
public class Grp88_ueb01 {

    /**
     * verify belonging to prime numbers
     *
     * @param examNumber current number in range
     * @return boolean value
     */
    public static boolean isPrim(int examNumber) {
        // exculude Zero
        if (examNumber == 0){
            return false;
        }
        // try all values until squareroot of examNumber 
        for (int counter = 2; counter < Math.sqrt(examNumber) + 1; counter++) {
            if (examNumber % counter == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * verify belonging to Fibonacci numbers
     *
     * @param examNumber current number in range
     * @return current number belongs to Fibonacci
     */
    public static boolean isFibo(int examNumber) {
        int a = 0, b = 1, c = 0;
        // Calculate all Fibonacci Numbers until examNumber 
        while (c < examNumber) {
            c = a + b;
            a = b;
            b = c;
        }
        // Compare if last Fibonacci number equals examNumber 
        return c == examNumber;
    }

    /**
     * verify belonging to Repdigit numbers
     *
     * @param examNumber current number in range
     * @return the current number belongs to Repdigit
     */
    public static boolean isRepd(int examNumber) {
        // at least 2-digits are required
        if ((examNumber >= -9) && (examNumber <= 9)) {
            return false;
        }
        boolean repdigit = true;
        int compareValue = examNumber % 10;
        // compare if the number in every place value equals
        while (examNumber != 0) {
            if (compareValue != examNumber % 10) {
                repdigit = false;
                break;
            }
            // remove last place value of the examNumber
            examNumber = examNumber / 10;
        }
        return repdigit;
    }

    /**
     * calculate the Cross Sum
     *
     * @param examNumber current number in range
     * @return calculated Cross Sum
     */
    public static int getCsum(int examNumber) {
        int sum = 0;
        while (0 != examNumber) {
            // add last digit to sum
            sum = sum + (examNumber % 10);
            // remove last digit
            examNumber = examNumber / 10;
        }
        return sum;
    }

    /**
     * verify examNumber is a multiple of Cross Sum without remainder
     *
     * @param examNumber current number in range
     * @param sum Cross Sum of examNumber
     * @return
     */
    public static boolean isMult(int examNumber, int sum) {
        if (examNumber == 0) {
            return false;
        }
        return (examNumber % sum == 0);
    }
// benötigte Spaltenbreite errechnen
    public static int getNoofChars(int n) {
        int noofChars = 1;

        if (n < 0) {
            noofChars++;
            n = n * (-1);
        }

        for (int i = 10; i <= n; i *= 10) {
            noofChars++;
        }
        return noofChars;
    }

    public static int getMaxWidth(int start, int end) {
        if (getNoofChars(start) > getNoofChars(end)) {
            return getNoofChars(start);
        } else {
            return getNoofChars(end);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Define a number range 
        final int minNumber = 0;      // set min range number
        final int maxNumber = 23;    // set max range number
        final int colWidth = getMaxWidth(minNumber, maxNumber);

        // Runs all Numbers through defined range and checks for their properties
        for (int counter = minNumber; counter < maxNumber; counter++) {
            // Prime check
            if (isPrim(counter) == true) {
                System.out.printf("%" + colWidth + "d: belongs to Prime.\n", counter);
            }
            // Fibo check
            if (isFibo(counter) == true) {
                System.out.printf("%" + colWidth + "d: belongs to Fibonacci.\n", counter);
            }
            // Repd check
            if (isRepd(counter) == true) {
                System.out.printf("%" + colWidth + "d: belongs to Repdigit.\n", counter);
            }
            // Crosssum check
            if (isMult(counter, getCsum(counter)) == true) {
                System.out.printf("%" + colWidth + "d: is a whole number multiple of the cross sum [%d]\n", counter, getCsum(counter));
            }
            // Crosssum Check v2
            if (counter != 0 && counter % getCsum(counter) == 0) {
                System.out.printf("%" + colWidth + "d: is a whole number multiple of the cross sum [%d]\n", counter, getCsum(counter));
            }

        }

    }

}
