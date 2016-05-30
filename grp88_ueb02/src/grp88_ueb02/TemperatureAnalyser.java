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
 * Enthält Funktionen zur Analyse der Daten aus TemperatureValues.
 *
 * @author ODK / IAW100728
 * @version UNFINISHED
 */
public class TemperatureAnalyser {

    // gets invalid temperature (MAX) from Class Utilities
    private static final float INVALID_TEMPERATURE = Utilities.INVALID_TEMPERATURE;
    // amount of days with temp data per month
    private static final int[] DAYS_PER_MONTH = new int[]{10, 12, 31, 30, 25, 29};
    // amount of months with temperature data 
    private static final int MONTHS = DAYS_PER_MONTH.length;

    //TODO: change to private
    /**
     * create day temperatures values per month using
     * TemperatureValues.TEMPERATURES array
     *
     * @return 2-D array values
     */
    public static float[][] createTemperaturesPerMonth() {
        // erstelle 2Darray mit der länge MONTHS als D1
        float[][] temperaturesPerMonth = new float[MONTHS][];
        // init position in array (temperatures) index
        int temperaturesIndexPosition = 0;
        // generate amount of months(rows)
        for (int month = 0; month < MONTHS; month++) {
            // create array with temperature Data of current Month [code readability]
            float[] temperatureData = TemperatureValues.getTemperatures(temperaturesIndexPosition, DAYS_PER_MONTH[month]);
            // define size of month(row)
            temperaturesPerMonth[month] = new float[DAYS_PER_MONTH[month]];
            // fill days(columns) with temperature data
            temperaturesPerMonth[month] = temperatureData.clone();
            temperaturesIndexPosition = +DAYS_PER_MONTH[month];
        }
        return temperaturesPerMonth;
    }
    // constant array[month][day temp] with day temperatures per month
    static final float[][] TEMPERATURES_PER_MONTH = createTemperaturesPerMonth();

    //TODO: change to private
    /**
     * creates average month temperatures
     *
     * @return 1-D array values
     */
    public static float[] createAverageTemperatures() {
        // define array with size
        float[] averageTemperatures = new float[MONTHS];
        for (int month = 0; month < MONTHS; month++) {
            averageTemperatures[month] = Utilities.getAverage(TEMPERATURES_PER_MONTH[month]);
        }
        return averageTemperatures;
    }
    // constant array[] with average month temperature values
    static final float[] AVERAGE_MONTH_TEMPERATURES = createAverageTemperatures();

    /**
     * gets months day temperatures
     *
     * @param month
     * @return 1-D array values
     */
    public static float[] getTemperatures(int month) {
        // month-1 start with 1
        float[] daysTemperatures = new float[TEMPERATURES_PER_MONTH[month].length];
        for (int day = 0; day < daysTemperatures.length; day++) {
            daysTemperatures[day] = TEMPERATURES_PER_MONTH[month][day];
        }
        return daysTemperatures;
    }

    /**
     * get average temperature of month
     *
     * @param month month as number value
     * @return average temperature of
     */
    public static float getAverage(int month) {
        float averageTemperature;
        averageTemperature = (month == 0 || month > MONTHS) ? INVALID_TEMPERATURE : Utilities.getAverage(TEMPERATURES_PER_MONTH[month]);
        return averageTemperature;
    }

    /**
     * count amount of days with temperature in between
     *
     * @param min minimum Temperature
     * @param max
     * @return
     */
    public static int countTemperaturesinRange(int min, int max) {
        int days = 0;
        for (int index = 0; index < TemperatureValues.TEMPERATURES.length; index++) {
            if (TemperatureValues.TEMPERATURES[index] < min || TemperatureValues.TEMPERATURES[index] > max) {
            } else {
                days = +1;
            }
        }
        return days;
    }

    /**
     * get year average temperature
     *
     * @return average temperature value
     */
    public static float getYearAverage() {
        float yearAverage = Utilities.getAverage(AVERAGE_MONTH_TEMPERATURES);
        return yearAverage;
    }

    /**
     * get coldest month
     *
     * @return month number value
     */
    public static int getColdestMonth() {
        // define as maximum available float value
        float minValue = Float.MAX_VALUE;
        // define coldestMonth variable;
        int coldestMonth = 0;
        for (int month = 0; month < AVERAGE_MONTH_TEMPERATURES.length; month++) {
            if (AVERAGE_MONTH_TEMPERATURES[month] < minValue) {
                minValue = AVERAGE_MONTH_TEMPERATURES[month];
                // set month with smallest value
                coldestMonth = month;
            }
        }
        return coldestMonth;
    }

    /**
     * get warmest month
     *
     * @return month number value
     */
    public static int getWarmestMonth() {
        float maxValue = Float.MIN_VALUE;
        int warmestMonth = 0;
        for (int month = 0; month < AVERAGE_MONTH_TEMPERATURES.length; month++) {
            if (AVERAGE_MONTH_TEMPERATURES[month] > maxValue) {
                maxValue = AVERAGE_MONTH_TEMPERATURES[month];
                // set month with smallest value
                warmestMonth = month;
            }
        }
        return warmestMonth;
    }

}
