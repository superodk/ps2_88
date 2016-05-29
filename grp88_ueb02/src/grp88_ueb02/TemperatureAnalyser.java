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
 * Enthält Funktionen zur Analyse der Daten aus TemperatureValues.
 *
 * @author ODK / IAW100728
 * @version UNFINISHED
 */
public class TemperatureAnalyser {
    /* TODO: private Konstanten
    ein Array DAYS_PER_MONTH, welches die Anzahl der Tage pro Monat enthält,
    */
    
    /* TODO: private Konstante
    ein Wert MONTHS, der die Anzahl der zu untersuchenden Monate gemäß des 
    Arrays DAYS_PER_MONTH enthält,
    */
    
    /*TODO: private Konstante
    ein Wert INVALID_TEMPERATURE, der den Wert aus der Klasse Utilities übernimmt.
    */
    
    /* TODO: Klassenvariable 
    ein nach Monaten aufgeschlüsseltes zweidimensionales Array 
    TEMPERATURES_PER_MONTH mit den Tagestemperaturen
    */
    
    /*TODO: Klassenvariable
    eindimensionales Array AVERAGE_MONTH_TEMPERATURES mit den 
    Durchschnittstemperaturen der einzelnen Monate erstellt
    */

    /** TODO:
     * Angabe, wieviele Tage ein Monat jeweils besitzt.
     * Um mit weniger Testdaten arbeiten zu können, sind die Monate hier sehr kurz.
     * Die Summe der Tage kann mit der Anzahl der Testdaten übereinstimmen,
     * muss aber nicht!
     */
    private static final int[] DAYS_PER_MONTH = new int[] {10, 12, 31, 30, 25, 29};
    
    /**
     * Angabe, für wie viele Monate die Tagesangaben vorliegen. gemäß des Arrays DAYS_PER_MONTH
     */
    private static final int MONTHS = DAYS_PER_MONTH.length; 
    
    // ungültiger Temperaturwert
    private static final float INVALID_TEMPERATURE = Utilities.INVALID_TEMPERATURE;	

}
