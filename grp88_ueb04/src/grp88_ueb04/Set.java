/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp88_ueb04;

/**
 * Class Set. unfinished/unchecked
 * set interface implementation
 *
 * @author iaw100728
 */
public class Set {

    /**
     * private class variable. Set elements implemented as linked list
     */
    private Element elements; // simple linked list

    /**
     * anticipate possible NullPointerException.
     *
     * @return logical value
     */
    public boolean isEmpty() {
        return this.elements == null;
    }

    /**
     * checks if committed heap contain the same values as the actual heap
     * crowd.
     *
     * @param other heap to compare
     * @return logical value
     */
    public boolean isSame(Set other) {
        if (this.isEmpty() || other.isEmpty()) {
            return false;
        }
        return this.elements.isSame(other.elements);
    }

    /**
     * adds a new element with committed value, when this value is unique.
     *
     * @param value character value
     */
    public void addValue(char value) {
        //TODO Set.existsValue nutzen
        if (this.isEmpty()) {
            this.elements = new Element();
            this.elements.setValue(value);
        }
        if (!this.existsValue(value)) {
            this.elements = this.elements.insertElementSorted(value);
        }
    }

    /**
     * checks if committed parameter exists in list.
     *
     * @param value character value
     * @return logical value
     */
    public boolean existsValue(char value) {
        if (this.isEmpty()) {
            return false;
        }
        return this.elements.containsValue(value);
    }

    /**
     * delete element containing committed character, otherwise nothing.
     *
     * @param value character to delete
     */
    public void deleteValue(char value) {
        if (!this.isEmpty()) {
            this.elements = this.elements.deleteElement(value);
        }
    }

    /**
     * prints crowds values separated by committed separator as a string.
     *
     * @param separator string
     * @return crowds characters as string
     */
    public String showValues(String separator) {
        if (this.isEmpty()) {
            // aus char wird string durch + ""
            return "{}";
        } else {
            return "{" + this.elements.showValues(separator) + "}";
        }
    }

    /**
     * adds all not already present values of the committed list from type
     * element to current list. the committed list must not be change
     *
     * @param list linked list
     * @return list out of elements
     */
    private Element addElementList(Element list) {
        while (list != null) {
            this.addValue(list.getValue());
            list = list.getNext();
        }
        return this.elements;
    }

    /**
     * creates a clone of the current set.
     *
     * @return cloned set
     */
    private Set cloneSet() {
        Set newSet = new Set();
        newSet.elements = newSet.addElementList(this.elements);
        return newSet;
    }

    //<editor-fold defaultstate="collapsed" desc="operation methods">
    /**
     * provides a new set, that is a union of the actual and the committed set.
     *
     * @param other set for operation
     * @return new set
     */
    public Set union(Set other) {
        Set newSet = this.cloneSet();
        newSet.elements = newSet.addElementList(other.elements);
        return newSet;
    }

    /**
     * returns a new set as a intersection of the current list with the
     * committed list.
     *
     * @param other another set
     * @return new set
     */
    public Set intersection(Set other) {
        Set newSet = new Set();
        while (this.elements != null) {
            if (other.existsValue(this.elements.getValue())) {
                newSet.addValue(this.elements.getValue());
            }
            this.elements = this.elements.getNext();
        }
        return newSet;
    }

    /**
     * TODO: liefert eine neue Menge, die die Differenzmenge der aktuellen mit
     * der übergebenen abbildet.
     *
     * @param other another ser
     * @return new set
     */
    public Set diff(Set other) {
        Set unionSet = this.union(other);
        Set intersectionSet = this.intersection(other);
        Set newSet = new Set();
        while (unionSet.elements != null) {
                newSet.addValue(unionSet.elements.getValue());
            }
            unionSet.elements = unionSet.elements.getNext();            
        
        System.out.println(newSet.showValues(", "));
        return newSet;
    }

//    /**
//     * TODO: liefert eine neue Menge, die die symmetrische Differenzmenge der
//     * aktuellen mit der übergebenen abbildet.
//     *
//     * @param other another set
//     * @return new set
//     */
//    public Set symmDiff(Set other) {
//
//        return
//    }
//</editor-fold>
//        //<editor-fold defaultstate="collapsed" desc="settests">
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
