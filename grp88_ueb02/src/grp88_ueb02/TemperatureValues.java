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

/**
 * Gegebene Daten in Form eines Zahlenarrays (gemessene Temperaturen)
 *
 * @author ODK / IAW100728
 * @version UNFINISHED
 */
public class TemperatureValues {

    /**
     * Gemessene Temperaturen.
     */
    static final float[] TEMPERATURES = {
        2, -1, 3, 7, 8, 3, 2, 5, 6, 8, 11, 15, 13, 16, 18, 20, 21, 5,
        10, 1, 8, 6, 4, 5, 7, 8, 21, 18, 19, 20, 17, 15, 16, 14, 15, 13,
        18, 17, 18, 19, 21, 22, 20, 19, 21, 21, 22, 25, 26, 25, 25, 26, 25, 26,
        28, 29, 24, 23, 22, 21, 26, 27, 28, 23, 30, 29, 25, 29, 30, 31, 32, 33,
        35, 31, 30, 29, 27, 25, 24, 23, 23, 24, 25, 25, 23, 22, 20, 22, 21, 19,
        20, 19, 19, 19, 21, 20, 19, 20, 15, 16, 14, 12, 10, 10, 13, 13, 12, 9,
        12, 10, 8, 10, 11, 5, 3, 1, -3, 5, 2.5f, -5.5f
    };

    /** gets temperature data as defined by parameters
     *  from TEMPERATUES array
     * 
     * @param offset index position (TEMPERATURES)
     * @param amount amount of data to copy
     * @return temperature data array
     */
    public static float[] getTemperatures(int offset, int amount) {
        float[] temperatureData;  // define internal array

        if (offset > TEMPERATURES.length) {  // exception: (offset) invalid TEMPERATURES index
            temperatureData = null;             // return array {null}
        } else {
            if (amount > TEMPERATURES.length - offset) {  // exception: (amount) invalid TEMPERATURES range
                amount = TEMPERATURES.length - offset;    // adjust to TEMPERATURES possible range
            }
            temperatureData = new float[amount];  // define new array size           
            for (int i = 0; i < amount; i++) {    // fill internal array
                temperatureData[i] = TEMPERATURES[offset + i];
            }
        }
        return temperatureData;
    }
}
