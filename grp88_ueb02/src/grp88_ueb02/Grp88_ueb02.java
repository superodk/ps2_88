/*
 * Copyright (C) 2016 ODK
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package grp88_ueb02;

import java.util.Arrays;

/**
 * Aufgabe 2: Wetterstation
 *
 * @author ODK / IAW100728
 * @version UNFINISHED
 */
public class Grp88_ueb02 {
    
    static final String[] MONTH_NAMES = {"January", "February", "March",
        "April", "May", "June", "July", "August", "September", "October",
        "November", "December"};
    
    /*TODO: 
    STEPS enthält die Anzahl der Temperaturbereiche, die als letztes ausgegeben werden sollen
    /*
    
    /*TODO: RANGE 
    enthält die Temperaturspanne, die jeweils beachtet werden soll.
    /*
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TODO: remove final in consts
        final int OFFSET = 0;
        final int AMOUNT = 9;
        
        // TODO: remove out.println
        System.out.println(TemperatureValues.getTemperatures(OFFSET, AMOUNT).length);
        
        // TODO: remove out.println
        System.out.println("Refined Array: "
                + Arrays.toString(TemperatureValues.getTemperatures(OFFSET, AMOUNT)));

        // TODO: remove out.println
        // print sorted array
        System.out.println("Sorted Array: "
                + Arrays.toString(Utilities.getSortedArray(TemperatureValues.getTemperatures(OFFSET, AMOUNT))));
        
        //TODO: remove out.println
        System.out.println("Original Array: " + Arrays.toString(TemperatureValues.TEMPERATURES));

        // TODO: remove out.println
        System.out.println("Calc. Median: "
                + Utilities.getMedian(TemperatureValues.getTemperatures(OFFSET, AMOUNT)));

        // TODO: remove out.println
        System.out.println("Calc. Average: "
                + Utilities.getAverage(TemperatureValues.getTemperatures(OFFSET, AMOUNT)));

    }

}
