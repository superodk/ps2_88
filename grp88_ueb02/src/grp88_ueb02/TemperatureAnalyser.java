package grp88_ueb02;

/**
 * Enthält Funktionen zur Analyse der Daten aus TemperatureValues.
 *
 * @author ...
 */
public class TemperatureAnalyser {

    /**
     * Angabe, wieviele Tage ein Monat jeweils besitzt.
     * Um mit weniger Testdaten arbeiten zu können, sind die Monate hier sehr kurz.
     * Die Summe der Tage kann mit der Anzahl der Testdaten übereinstimmen,
     * muss aber nicht!
     */
    private static final int[] DAYS_PER_MONTH = new int[] {10, 12, 31, 30, 25, 29};
    /**
     * Angabe, für wie viele Monate die Tagesangaben vorliegen.
     */
    private static final int MONTHS = DAYS_PER_MONTH.length;    
    /**
     * ungültiger Temperaturwert.
     */
    private static final float INVALID_TEMPERATURE = Utilities.INVALID_TEMPERATURE;	

}
