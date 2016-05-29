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
 * Subroutines for arrays
 * sort, median, average
 *
 * @author ODK / IAW100728
 * @version FINISHED*
 */
public class Utilities {

    // TODO: a wrong temperature? was das?
    public static final float INVALID_TEMPERATURE = -Float.MAX_VALUE;

    /**
     * Sorts array 
     * sorts elements in descending order
     *
     * @param suppliedArray array with elements to process
     * @return create sorted array
     */
    public static float[] getSortedArray(float[] suppliedArray) {
        float swapValue;                     // define swap variable
        float[] sortedArray = suppliedArray.clone(); // clone array to sort
        // compare values beginning from last with the precedent
        for (int i = sortedArray.length - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                // sort asscending(>=) or *descending(<=)
                if (sortedArray[j] <= sortedArray[i]) {
                    swapValue = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = swapValue;
                }
            }
        }
        return sortedArray;
    }

    /**
     * Calculate median 
     * uses separate calculation for even and odd arrays
     *
     * @param suppliedArray array with elements to process
     * @return determined median value
     */
    public static float getMedian(float[] suppliedArray) {
        // define array with presorted values
        float[] sortedArray = getSortedArray(suppliedArray);
        float median; // calculated median
        // check even or odd amount of array elements (suppliedArray)
        if (sortedArray.length % 2 == 0) { // case: even number
            median = ((float) sortedArray[sortedArray.length / 2] + (float) sortedArray[sortedArray.length / 2 - 1]) / 2;
        } else {                           // case: odd number
            median = (float) sortedArray[sortedArray.length / 2];
        }
        return median;
    }

    /**
     * Calculate average
     *
     * @param suppliedArray array with elements to process
     * @return determined average value
     */
    public static float getAverage(float[] suppliedArray) {
        float sum = 0; // init sum variable with zero
        // calc. sum of all array elements
        for (float value : suppliedArray) {
            sum += value;
        }
        // define average with calc. average value
        float average = sum / suppliedArray.length;
        return average;
    }
;
}
