package grp88_ueb02;

/**
 * Gegebene Daten in Form eines Zahlenarrays (gemessene Temperaturen)
 *
 * @author ODK / IAW100728
 * @version Mai 26, 2016
 */
public class TemperatureValues {

    /**
     * Gemessene Temperaturen.
     */
    private static final float[] TEMPERATURES = {
        2, -1, 3, 7, 8, 3, 2, 5, 6, 8, 11, 15, 13, 16, 18, 20, 21, 5,
        10, 1, 8, 6, 4, 5, 7, 8, 21, 18, 19, 20, 17, 15, 16, 14, 15, 13,
        18, 17, 18, 19, 21, 22, 20, 19, 21, 21, 22, 25, 26, 25, 25, 26, 25, 26,
        28, 29, 24, 23, 22, 21, 26, 27, 28, 23, 30, 29, 25, 29, 30, 31, 32, 33,
        35, 31, 30, 29, 27, 25, 24, 23, 23, 24, 25, 25, 23, 22, 20, 22, 21, 19,
        20, 19, 19, 19, 21, 20, 19, 20, 15, 16, 14, 12, 10, 10, 13, 13, 12, 9,
        12, 10, 8, 10, 11, 5, 3, 1, -3, 5, 2.5f, -5.5f
    };

    /**
     * gets temperature data as defined by parameters
     *
     * @param offset index position
     * @param amount amount of data
     * @return temperature data array
     */
    public static float[] getTemperatures(int offset, int amount) {
        // define a new array + allocate space 
        float[] temperatureData;
        // exception handling
        if (offset > TEMPERATURES.length) {
            temperatureData = null;
        } else {
            if (amount > TEMPERATURES.length - offset) {
                amount = TEMPERATURES.length - offset;
                // TODO: remove test call
                System.out.println(amount);

            }

            temperatureData = new float[amount];
            // TODO: remove test call
            System.out.println(temperatureData.length);
            // fill new array with temperature values as defined by parameters
            for (int i = 0; i < amount; i++) {
                temperatureData[i] = TEMPERATURES[offset + i];
            }
        }
        return temperatureData;
    }
;

}
