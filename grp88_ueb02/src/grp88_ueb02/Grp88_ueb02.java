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

    // define temperature range
    static final int RANGE = 10;
    // define amount of ranges to search
    static final int STEPS = 5;
    // define names for month number values
    static final String[] MONTH_NAMES = {"January", "February", "March",
        "April", "May", "June", "July", "August", "September", "October",
        "November", "December"};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // private routin to algin the results

        // coldest month and temperature
        System.out.format("The coldest month was %s with %.2f°C average.%n", 
                MONTH_NAMES[TemperatureAnalyser.getColdestMonth() - 1], 
                TemperatureAnalyser.getTemperatures(TemperatureAnalyser.getColdestMonth()));
        // warmest month and temperature
        System.out.format("The coldest month was %s with %.2f°C average.%n",
                MONTH_NAMES[TemperatureAnalyser.getWarmestMonth()-1],
                TemperatureAnalyser.getTemperatures(TemperatureAnalyser.getWarmestMonth()));
        // yearaverage
        System.out.format("The average temperature this year was %.2f°C.%n", TemperatureAnalyser.getYearAverage());
        // empty println
        System.out.println();
        // median of the first month
        System.out.format("The median in january was %.2f°C.%n", Utilities.getMedian(TemperatureAnalyser.getTemperatures(1)));
        // Temperature of the first day in first month
        System.out.format("The temperature in the first day of january was %.2f°C.%n", TemperatureAnalyser.getTemperatures(1)[0]);
        // empty println
        System.out.println();
        // temperatures under 0°C (-50 - 0)
        //System.out.format(format, args);
        // in STEPS begining with 0° - amount of days that are in the defined RANGE
        // use private routine printTemperaturesInRange(int min, int max)

        //FIXME Ausgabe in STEPS, RANGES
        /*
         //TODO: remove TEST CALLS       
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
        
         // TODO: remove out.println
         System.out.println("TemperaturesPerMonths Arrray: "
         + TemperatureAnalyser.createTemperaturesPerMonth()); 
        
         // TODO: remove out.println
         System.out.println("average Month temperatures Arrray: "
         + Arrays.toString(TemperatureAnalyser.createAverageTemperatures()));
        
         // TODO: remove out.println
         System.out.println("coldest month: "
         + TemperatureAnalyser.getColdestMonth());
        
         // TODO: remove out.println
         System.out.println("YearAverage: "
         + TemperatureAnalyser.getYearAverage()); 
         */
    }

}
