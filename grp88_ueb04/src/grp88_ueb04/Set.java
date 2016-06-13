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

    private Element elements; // simple linked list

    /**
     * TODO: check method checks for present elements
     *
     * @return logical value
     */
    public boolean isEmpty() {
        return this.elements == null;
    }

    /**
     * TODO: check method isSame(Set other) : boolean . - prüft, ob die
     * übergebene Menge die gleichen Werte enthält wie die aktuelle
     *
     * @param other
     * @return
     */
    public boolean isSame(Set other) {
        if (this.isEmpty()) {              //TODO diese leer und andere nicht 
            return false;
        }
        return elements.isSame(other.elements);
    }

    /**
     * TODO: check method
     * addValue(char value) . - fügt ein neues Element mit übergebenem Wert zu,
     * wenn der Wert noch nicht existiert. Ein Wert kann also nur ein Mal in der
     * Menge vorkommen
     *
     * @param value
     */
    public void addValue(char value) {
        //TODO Set.existsValue nutzen
        if (!existsValue(value)) {
            elements = elements.insertElementSorted(value);
        }
    }
//            elements = new Element();
//            elements.setValue(value);
//        } else {
//            elements = elements.insertElementSorted(value);
//        }
//
//    }

    /**
     * TODO: check method checks if the parameter already exists in element list
     *
     * @param value to check
     * @return logical value
     */
    public boolean existsValue(char value) {
        if (!isEmpty()) {
        return elements.containsValue(value); 
        }
        return false;
    }

    /**
     * delete element with this value, otherwise nothing
     *
     * @param value to delete
     */
    public void deleteValue(char value) {
        if (!isEmpty()) {
            elements = elements.deleteElement(value);
        }
    }

    /**
     * showValues(String SEPARATOR) : String . - liefert eine Stringdarstellung
     * des Mengeninhalts mit umschließenden geschweiften Klammern.Die einzelnen
     * Elemente der Menge werden durch das als Parameter übergebene Trennzeichen
     * separiert
     */
    public String showValues(String separator) {
        if (isEmpty()) {
            // aus char wird string durch + ""
            return "{}";
        } else {
            return "{" + this.elements.showValues(separator) + "}";
        }
    }

    /**
     * union(Set other) : Set . - liefert eine neue Menge, die die Vereinigung
     * der aktuellen mit der übergebenen abbildet
     */
    public Set union(Set other) {
        Set newSet = this.cloneSet();
        newSet.addElementList(other.elements);
        return newSet;
    }

    /**
     * TODO: intersection(Set other) : Set . - liefert eine neue Menge, die die
     * Schnittmenge der aktuellen mit der übergebenen abbildet
     */
    /**
     * TODO: diff(Set other) : Set . - liefert eine neue Menge, die die
     * Differenzmenge der aktuellen mit der übergebenen abbildet
     */
    /**
     * TODO: symmDiff(Set other) : Set . - liefert eine neue Menge, die die
     * symmetrische Differenzmenge der aktuellen mit der übergebenen abbildet
     */
    // Die Methoden, die ein Set zurückliefern, verändern weder die ursprüngliche,noch die übergebene Menge.
    // Als private legt mindestens folgende Routinen an:
    /**
     * addElementList(Element list) . - fügt der aktuellen Liste alle noch nicht
     * in ihr enthaltenen Werte einer übergebenen Liste vom Typ Element zu. Die
     * übergebene Liste darf nicht verändert werden
     */
    private Element addElementList(Element list) {
        while (list != null) {
            addValue(list.getValue());
            list = list.getNext();
        }
        return this.elements;
    }

    /**
     * cloneSet() : Set . - erstellt eine Kopie der aktuellen Menge
     */
    private Set cloneSet() {
        Set newSet = new Set();
        newSet.elements = newSet.addElementList(this.elements);
        return newSet;
    } 

//        //<editor-fold defaultstate="collapsed" desc="tests">
//    /**
//     * create a list of the given chars in the array in the order of the
//     * arraychars.
//     *
//     * @param charArray array of the chars to add
//     * @return a list holding the chars in the order of the arraychars
//     */
//    private static Set createTestList(char[] charArray) {           
//        Set set = new Set();        
//        for (int i = 0; i < charArray.length; i++) {
//            set.addValue(charArray[i]);
//        }
//        return set;
//    }
//        
////        if (charArray != null && charArray.length > 0) {
////            list = new Element();
////            list.setValue(charArray[0]);
////
////            for (int i = 1; i < charArray.length; i++) {
////                list = list.addValue(charArray[i]);
////            }
////        }
////        return list;
////    }
//        /**
//     * creates a new Element with the given value.
//     *
//     * @param value value to set
//     * @return a new Element with the given value
//     */
//    private static Element createElement(char value) {
//        Element element = new Element();
//        element.setValue(value);
//        return element;
//    }
//    
//    
//    /**
//     * tests showValues with one and more listElements.
//     */
//    private static void testShowValues() {
//        System.out.println("teste showValues()");
//        Set set = new Set();
//        set.addValue('A');
//        System.out.print('A' == set.elements.getValue()
//                ? ""
//                : "Wert von einem Element fehlerhaft: "
//                + "SOLL (A), IST (" + set.elements.showValues(" ") + ")\n");
//
//        set = createTestList(new char[]{'A'});
//        System.out.print("A".equals(set.elements.showValues(" "))
//                ? ""
//                : "showValues oder createTestList für Liste mit einem Element fehlerhaft: "
//                + "SOLL (A), IST (" + set.elements.showValues(" ") + ")\n");
//
//        set = createTestList(new char[]{'A', 'B', 'C'});
//        System.out.print("A B C".equals(set.elements.showValues(" "))
//                ? ""
//                : "showValues oder createTestList fehlerhaft: "
//                + "SOLL (A B C), IST (" + set.elements.showValues(" ") + ")\n");
//
//        System.out.println("");
//    }
//    
//     /**
//     * checks the method isSame()
//     */
//    private static void testIsSame() {
//
//        System.out.println("teste isSame()");
//
//        Set list1 = createTestList(new char[]{'a'});
//        Set list2 = createTestList(new char[]{'a', 'B', 'c'});
//        Set list3 = createTestList(new char[]{'a', 'B', 'c'});
//        Set list4 = createTestList(new char[]{'x', 'y', 'z'});
//
// 
//        System.out.print(list1.isSame(list1)
//                ? ""
//                : "isSame() selbe Listen: {" + list1.showValues(" ")
//                + "}.isSame({" + list1.showValues(" ") + "}) sollte true liefern.\n");
//
//        // equal lists
//        System.out.print(list2.isSame(list3)
//                ? ""
//                : "isSame() gleiche Listen: {" + list2.showValues(" ")
//                + "}.isSame({" + list3.showValues(" ") + "}) sollte true liefern.\n");
//
//        // same length, different values
//        System.out.print(!list3.isSame(list4)
//                ? ""
//                : "isSame() gleiche Listenlänge anderer Inhalt: {" + list2.showValues(" ")
//                + "}.isSame({" + list3.showValues(" ") + "}) sollte false liefern.\n");
//
//        // compare longer with shorter list
//        System.out.print(!list2.isSame(list1)
//                ? ""
//                : "längereListe.isSame(kurzeListe): {" + list2.showValues(" ")
//                + "}.isSame({" + list1.showValues(" ") + "}) sollte false liefern.\n");
//
//        // compare shorter with longer list
//        System.out.print(!list1.isSame(list2)
//                ? ""
//                : "kurzeListe.isSame(längereListe): {" + list2.showValues(" ")
//                + "}.isSame({" + list3.showValues(" ") + "}) sollte false liefern.\n");
//    }
//
////       /**
////     * tests deleteElement().
////     */
////    private static void testDeleteElement() {
////        System.out.println("teste deleteElement()");
////
////        // delete at the end
////        Set list = createTestList(new char[]{'D', 'd', 'B', 'b'});
////        list.elements = list.deleteValue('b');
////        System.out.print("D d B".equals(list.showValues(" "))
////                ? ""
////                : "deleteElement('b') in {D d B b} liefert {" + list.showValues(" ") + "}\n");
////
////        // delete in the middle
////        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
////        list = list.deleteValue('B');
////        System.out.print("D d b".equals(list.showValues(" "))
////                ? ""
////                : "deleteElement('B') in {D d B b} liefert {" + list.showValues(" ") + "}\n");
////
////        // delete in the middle
////        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
////        list = list.deleteValue('d');
////        System.out.print("D B b".equals(list.showValues(" "))
////                ? ""
////                : "deleteElement('d') in {D d B b} liefert {" + list.showValues(" ") + "}\n");
////
////        // delete at the beginning
////        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
////        list = list.deleteValue('D');
////        System.out.print("d B b".equals(list.showValues(" "))
////                ? ""
////                : "deleteElement('B') in {D d B b} liefert {" + list.showValues(" ") + "}\n");
////
////        // delete names not contained
////        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
////        list = list.deleteValue('A');
////        System.out.print("D d B b".equals(list.showValues(" "))
////                ? ""
////                : "nicht existentes El: deleteElement('A') in {D d B b} liefert {" + list.showValues(" ") + "}\n");
////
////        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
////        list = list.deleteValue('c');
////        System.out.print("D d B b".equals(list.showValues(" "))
////                ? ""
////                : "nicht existentes El: deleteElement('c') in {D d B b} liefert {" + list.showValues(" ") + "}\n");
////
////        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
////        list = list.deleteValue('E');
////        System.out.print("D d B b".equals(list.showValues(" "))
////                ? ""
////                : "nicht existentes El: deleteElement('E') in {D d B b} liefert {" + list.showValues(" ") + "}\n");
////
////        // sorting shall be relevant
////        Element unsorted = createTestList(new char[]{'y', 'x', 'z'});
////        unsorted = unsorted.deleteElement('z');
////        System.out.print("y x z".equals(unsorted.showValues(" "))
////                ? ""
////                : "deleteElement('z') in {y x z} liefert {" + unsorted.showValues(" ")
////                + "}, obwohl von sortierter Liste ausgegangen werden soll ('z' kann nicht nach 'x' kommen).\n");
////
////        unsorted = createTestList(new char[]{'c', 'b', 'C'});
////        unsorted = unsorted.deleteElement('C');
////        System.out.print("c b C".equals(unsorted.showValues(" "))
////                ? ""
////                : "deleteElement('C') in {c b C} liefert {" + unsorted.showValues(" ")
////                + "}, obwohl von sortierter Liste ausgegangen werden soll ('C' kann nicht nach 'c' kommen).\n");
////
////        unsorted = createTestList(new char[]{'c', 'e', 'C'});
////        unsorted = unsorted.deleteElement('C');
////        System.out.print("c e C".equals(unsorted.showValues(" "))
////                ? ""
////                : "deleteElement('C') in {c e C} liefert {" + unsorted.showValues(" ")
////                + "}, obwohl von sortierter Liste ausgegangen werden soll ('C' kann nicht nach 'c' kommen).\n");
////
////        System.out.println("");
////    }
//    /**
//     * calls testRoutines
//     *
//     * @param args
//     */
//    public static void main(String[] args) {
//        testShowValues();
//        //testIsPredecessor();
//        //testInsertElementSorted();
//        //testContainsValue();
//        //testDeleteElement();
//        testIsSame();
//    }
////</editor-fold>    
}
