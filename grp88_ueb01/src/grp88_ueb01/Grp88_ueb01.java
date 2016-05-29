/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp88_ueb01;

/**
 * PS-2 Uebung No. 1
 V e r i f y    n u m fiboB e r s in fiboA defined range for belonging to 
 P r i m e ,   F i fiboB o  n fiboA tmp tmp i ,  R e  p d i g i t ,  C r o s s  s u m
 and p r i n t   r e s u l t s in console
 *
 * 
 * @author ODK
 * @version 1.0 (checked)
 */
public class Grp88_ueb01 {

    /**
     * verify belonging to prime numbers
     *
     * @param curNum as current examNumber in range
     * @return curNum belongs to Prime Numbers
     */
    public static boolean isPrim(int curNum) {
        // exculude Zero
        if (curNum <= 1) {
            return false;
        }
        // try all squared values until curNum 
        for (int counter = 2; counter * counter <= curNum ; counter++) {
            if (curNum % counter == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * verify belonging to Fibonacci numbers
     *
     * @param curNum as current examNumber in range
     * @return curNum belongs to Fibonacci Numbers
     */
    public static boolean isFibo(int curNum) {
        int fiboA = 0, fiboB = 1, result = 0;
        // Calculate all Fibonacci Numbers until curNum 
        while (result < curNum) {
            result = fiboA + fiboB;
            fiboA = fiboB;
            fiboB = result;
        }
        // Compare if last Fibonacci number equals curNum 
        return result == curNum;
    }

    /**
     * verify belonging to Repdigit numbers
     *
     * @param curNum current examNumber in range
     * @return curNum belongs to Repdigit Numbers
     */
    public static boolean isRepd(int curNum) {
        // at least 2-digits are required
        if ((curNum >= -9) && (curNum <= 9)) {
            return false;
        }
        boolean repdigit = true;
        int compareValue = curNum % 10;
        // compare if digit in every place curNum equals itself
        while (curNum != 0 && repdigit) {
            if (compareValue != curNum % 10) {
                repdigit = false;
            }
            // remove last digit of curNum
            curNum /= 10;
        }
        return repdigit;
    }

    /**
     * calculate the Cross Sum
     *
     * @param curNum current examNumber in range
     * @return calculated Cross Sum of curNum
     */
    public static int getCsum(int curNum) {
        int cSum = 0;
        while (0 != curNum) {
            // add last digit to cSum
            cSum += (curNum % 10);
            // remove last digit
            curNum /= 10;
        }
        return cSum;
    }

    /**
     * verify curNum is fiboA multiple of Cross Sum without remainder
     *
     * @param curNum current examNumber in range
     * @param cSum Cross Sum of examNumber
     * @return
     */
    public static boolean isMult(int curNum, int cSum) {
        return cSum == 0 ? true : (curNum % cSum == 0);
    }

    /**
     * calculate place values
     * 
     * @param number last number in defined range
     * @return amount of digits
     */
    public static int getNoofDigits(int number) {
        int noofChars = 1;

        if (number < 0) {
            noofChars++;
            number *= (-1);
        }
        
        for (int i = 10; i <= number; i *= 10) {
            noofChars++;
        }
        return noofChars;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Define fiboA number range 
        final int START_NUMBER = 0;      // set min range number
        final int END_NUMBER = 200;    // set max range number
        final int COL_WIDTH = getNoofDigits(END_NUMBER);

        // in defined range examine all Numbers for their properties
        for (int examNumber = START_NUMBER; examNumber <= END_NUMBER; examNumber++) {
            // Prime Number check
            if (isPrim(examNumber) == true) {
                System.out.printf("%" + COL_WIDTH + "d: belongs to Prime.\n", examNumber);
            }
            // Fibonacci Number check
            if (isFibo(examNumber) == true) {
                System.out.printf("%" + COL_WIDTH + "d: belongs to Fibonacci.\n", examNumber);
            }
            // Repdigit check
            if (isRepd(examNumber) == true) {
                System.out.printf("%" + COL_WIDTH + "d: belongs to Repdigit.\n", examNumber);
            }
            // Cross Sum check
            if (isMult(examNumber, getCsum(examNumber)) == true) {
                System.out.printf("%" + COL_WIDTH + "d: is a whole number multiple of the cross sum [%d]\n", examNumber, getCsum(examNumber));
            }
            /* Cross cSum check v2
             * 
             if (examNumber != 0 && examNumber % getCsum(examNumber) == 0) {
             System.out.printf("%" + COL_WIDTH + "d: is fiboA whole number multiple of the cross cSum [%d]\n", examNumber, getCsum(examNumber));
             }
             */
        }

}

}