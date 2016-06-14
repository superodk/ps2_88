/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp88_ueb04;

// TODO: remove library if unused
import java.util.Arrays;

/**
 * Class main. unfinished/unchecked
 *
 * @author iaw100728
 */
public class Grp88_ueb04 {

    // symbol signals to continue with next set
    final static char SETS_DELIMITER = '/';
    // declare and init two sets to work with
    static Set setA = new Set();
    static Set setB = new Set();

    /**
     * fills two sets with string values. string values from the committed
     * command-line arguments list are converted to char values and associated
     * with the the sets. the sets are separated by the constant delimiter
     *
     * @param args string array with one char value per argument
     * @param setA heap A to fill with arguments
     * @param setB heap B to fill with arguments
     */
    public static void getSetsFromArgs(String[] args, Set setA, Set setB) {
        boolean nextSet = false; // flag to pass arguments to setB
        // traverse the string array
        for (int index = 0; index < args.length; index++) {
            if (args[index].charAt(0) == SETS_DELIMITER) {
                nextSet = true; // activate nextSet flag
                index++; // skip separator string
            } else if (nextSet == false) { // pass arguments to setA
                setA.addValue(args[index].charAt(0));
            } else { // pass arguments to setB
                setB.addValue(args[index].charAt(0));
            }
        }
        // TODO: remove debugging/testing calls/procedures
        System.out.println("Test Klasse Set");
        // Argumente ausgeben
        System.out.printf("Argumente: %18s\n", Arrays.toString(args));
        // Menge A
        System.out.printf("Menge A: %26s\n", setA.showValues(", ")); // print all values from setA
        // Menge B
        System.out.printf("Menge B: %-5s\n", setB.showValues(", ")); // print all values from setB        
        // Vereinigung
        System.out.printf("Vereinigung: %-5s\n", setA.union(setB).showValues(", "));
        // Schnittmenge
        System.out.printf("Schnittmenge: %-5s\n", setA.intersection(setB).showValues(", "));
        // Differenzmenge A - B
        //System.out.printf("", args)
        // Differenzmenge B - A
        // Symmetrische Differenz
        System.out.printf("Symmetrische Differenz: %s", setA.diff(setB).showValues(", "));
    }

    /**
     * main method.
     *
     * @param args array with strings values
     *
     */
    public static void main(String[] args) {
        getSetsFromArgs(args, setA, setB); // fill sets with passed arguments

        // TODO: print set operation methods tests
        //die erste Menge A,
        //die zweite Menge B,
        //die Vereinigungsmenge,
        //die Schnittmenge,
        //die Differenzmenge A - B,
        //die Differenzmenge B - A und
        //die symmetrische Differenz.
//    Test Klasse Set
//Argumente:              [X, y, l, o, p, h, o, n, /, N, o, t]
//Menge A:                {y X p o n l h}
//Menge B:                {t o N}
//Vereinigung:            {y X t p o N n l h}
//Schnittmenge:           {o}
//Differenzmenge A - B:   {y X p n l h}
//Differenzmenge B - A:   {t N}
//Symmetrische Differenz: {y X t p N n l h}
    }

}
