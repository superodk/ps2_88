/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp88_ueb00;

/**
 *
 * @author iaw100728
 */
public class Grp88_ueb00 {

    public static int getNext(int n) {
        if (n > 0) {
            n *= 10;
        } //TODO n <0; n ==0;
        else if (n == 0) {
            n = 10;
        } else {
            n /= 10;
        }

        return n;
    }

    /**
     * liefert die Anzahl der benötigten Zeichen für n.
     *
     * @param n die zu untersuchende Zahl
     * @return die Anzahl der benötigten Zeichen für n
     */
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
        final int START = -1000;
        final int END = 100;
        final int colWidth = getMaxWidth(START, END);

        int i = START;
        while (i <= END) {
            System.out.printf("%" + colWidth + "d benoetigt %5d Zeichen Platz. %n", i, getNoofChars(i));
            i = getNext(i);
        }
    }

}
