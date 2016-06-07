/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp88_ueb04;

/**
 *
 * @author iaw100728
 */
public class Set {

    private Element elements;

    /**
     * TODO: isEmpty() : boolean. - prüft, ob Elemente enthalten sind,
     */
    public boolean isEmpty() {
        return elements == null;
    }

    /**
     * TODO: isSame(Set other) : boolean . - prüft, ob die übergebene Menge die
     * gleichen Werte enthält wie die aktuelle
     */
    /**
     * TODO: addValue(char value) . - fügt ein neues Element mit übergebenem
     * Wert zu, wenn der Wert noch nicht existiert. Ein Wert kann also nur ein
     * Mal in der Menge vorkommen
     */
    public void appendElement(char value) {
        if (this.isEmpty()) {
            elements = new Element();
            elements.setValue(value);
        } else {
            elements = elements.appendElement(value);
        }
    }

    public void insertElement(char value) {
        if (this.isEmpty()) {
            elements = new Element();
            elements.setValue(value);
        } else {
            elements = elements.appendElement(value);
        }

        /**
         * TODO: existsValue(char value ) : boolean . - prüft , ob der Wert
         * schon in
         * der Elementliste existiert
         */
        /**
         * TODO: deleteValue(char value ) . - löscht ein Element diesen Wertes ;
         * falls es nicht vorhanden ist , passiert nichts
         */
        /**
         * TODO: showValues(String SEPARATOR) : String . - liefert eine
         * Stringdarstellung des Mengeninhalts mit umschließenden geschweiften
         * Klammern.Die einzelnen Elemente der Menge werden durch das als
         * Parameter
         * übergebene Trennzeichen separiert
         */
        /**
         * TODO: union(Set other) : Set . - liefert eine neue Menge, die die
         * Vereinigung der aktuellen mit der übergebenen abbildet
         */
        /**
         * TODO: intersection(Set other) : Set . - liefert eine neue Menge, die
         * die
         * Schnittmenge der aktuellen mit der übergebenen abbildet
         */
        /**
         * TODO: diff(Set other) : Set . - liefert eine neue Menge, die die
         * Differenzmenge der aktuellen mit der übergebenen abbildet
         */
        /**
         * TODO: symmDiff(Set other) : Set . - liefert eine neue Menge, die die
         * symmetrische Differenzmenge der aktuellen mit der übergebenen
         * abbildet
         */
        // Die Methoden, die ein Set zurückliefern, verändern weder die ursprüngliche,noch die übergebene Menge.
        // Als private legt mindestens folgende Routinen an:
        /**
         * TODO: addElementList(Element list) . - fügt der aktuellen Liste alle
         * noch
         * nicht in ihr enthaltenen Werte einer übergebenen Liste vom Typ
         * Element
         * zu. Die übergebene Liste darf nicht verändert werden
         */
        /**
         * TODO: cloneSet() : Set . - erstellt eine Kopie der aktuellen Menge
         */
        //Keine der public-Methoden benutzt die Klasse Element als Typ für die Rückgabe oder einen Parameter. 
    }
