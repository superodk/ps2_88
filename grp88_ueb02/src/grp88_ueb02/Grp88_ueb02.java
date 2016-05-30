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

    static final int COL_WIDTH = 3;
    // define temperature range
    static final int RANGE = 10;
    // define amount of ranges to search
    static final int STEPS = 5;
    // define names for month number values
    static final String[] MONTH_NAMES = {"January", "February", "March",
        "April", "May", "June", "July", "August", "September", "October",
        "November", "December"};
    
    /**
    * print temperatures occurence in given range
    */
    private static void printTemperaturesInRange() {      
        for (int i = 0; i < STEPS; i++) {
            int min = RANGE * i;
            int max = RANGE * (i + 1);
            System.out.printf("There were %" + COL_WIDTH + "d days, with temperatures in between %"
                    + COL_WIDTH + "d°C and %" + COL_WIDTH + "d°C.%n",
                    TemperatureAnalyser.countTemperaturesInRange(min, max), min, max);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // private routin to algin the results

        // coldest month and temperature
        System.out.printf("The coldest month was %s with %.2f°C average.%n",
                MONTH_NAMES[TemperatureAnalyser.getColdestMonth() - 1], TemperatureAnalyser.getAverage(TemperatureAnalyser.getColdestMonth()));
        // warmest month and temperature
        System.out.printf("The warmest month was %s with %.2f°C average.%n",
                MONTH_NAMES[TemperatureAnalyser.getWarmestMonth() - 1],
                TemperatureAnalyser.getAverage(TemperatureAnalyser.getWarmestMonth()));
        // yearaverage
        System.out.printf("The average temperature this year was %.2f°C.%n", TemperatureAnalyser.getYearAverage());
        // empty println
        System.out.println();
        // median of the first month
        System.out.printf("The median in january was %.2f°C.%n",
                Utilities.getMedian(TemperatureAnalyser.getTemperatures(1)));
        // Temperature of the first day in first month
        System.out.printf("The temperature in the first day of january was %.2f°C.%n",
                TemperatureAnalyser.getTemperatures(1)[0]);
        // empty println
        System.out.println();
        // temperatures under 0°C (-50 - 0)
        System.out.printf("There were %" + COL_WIDTH + "d days, with temperatures in between -50°C and   0°C.%n",
                TemperatureAnalyser.countTemperaturesInRange(-50, 0));
        printTemperaturesInRange();
    }

}
