/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp88_ueb04;
// TODO: add license

import java.util.Arrays;

/**
 * TODO: describe class function in javaDoc.
 *
 * @author iaw100728
 */
public class Grp88_ueb04 {

    final static char SETS_DELIMITER = '/'; // Trennzeichen bei Mengen

    /**
     * @param args the command line arguments
     */
    /**
     * TODO: create charValues array
     * -> add values from s
     * -!-> filter values "," & ""
     * -&> add char[] charValues
     * ->
     * -> create Set
     * -> fill Set
     * -!> scan charValues for SETS_DELIMITER
     * -> create new Set
     * -> fill remaining values in charValues
     * ->
     */
    public static void getSetsFromArgs(String[] args) {
        Set setA = new Set();
        Set setB = new Set();
        boolean nextSet = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].charAt(0) == SETS_DELIMITER) {
                nextSet = true;
                i++; // skip delimiter
            }
            if (nextSet == false) {
            setA.addValue(args[i].charAt(0));
        } else if (nextSet == true) {
            setB.addValue(args[i].charAt(0));
        }
        }
        System.out.println(setA.toString());
        System.out.println(setB.toString());
    }
     

//        for (int i = 0; i < charArray.length; i++) {
//            System.out.print(charArray[i] + "|");
//        }
//        System.out.println("");
//        System.out.println(s);
//           char[] charArray = s.toCharArray();
    

    // TODO: code test methods for required console output
    /**
     * command-line. arguments passed as string elements in array
     *
     * @param args array with strings values
     *
     */
    public static void main(String[] args) {
        // TODO code application logic here
        getSetsFromArgs(args);
        


        /**
         * String[] args. when the application is launched the command line
         * arguments are passed to main method via an array of Strings. the
         * space character separates command-line arguments as a single
         * argument. cmd arguments in quotation marks are passed as one argument
         */
        // TODO: required Console Output
        //die erste Menge A,
        //die zweite Menge B,
        //die Vereinigungsmenge,
        //die Schnittmenge,
        //die Differenzmenge A - B,
        //die Differenzmenge B - A und
        //die symmetrische Differenz.
    }
    
}
