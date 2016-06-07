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
public class Element {

    private char value;
    private Element next;

    /**
     *
     * @param value
     */
    public void setValue(char value) {
        this.value = value;
    }

    /**
     *
     * @param next
     */
    public void setNext(Element next) {
        this.next = next;
    }

    /**
     *
     * @return
     */
    public char getValue() {
        return this.value;
    }

    /**
     *
     * @return
     */
    public Element getNext() {
        return this.next;
    }

    /**
     *
     * @param value
     * @return
     */
    public Element appendElement(char value) {
        if (this.next == null) {
            Element newElement = new Element();
            newElement.setValue(value);
            this.next = newElement;
        } else {
            this.next = this.next.appendElement(value);
        }
        return this;
    }

    /**
     *
     * @param value
     * @return
     */
    public Element insertElementSorted(char value) {
        if (!isPredecessor(value)) {
            Element newElement = new Element();
            newElement.setValue(value);
            newElement.setNext(this);
            return newElement;
        } else if (this.next == null) {
            Element newElement = new Element();
            newElement.setValue(value);
            this.next = newElement;
            return this;
        } else {
            this.next = this.next.insertElementSorted(value);
            return this;
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public Element deleteElement(char value) {
        if (this.value == value) {
            return this.next;
        } else {
            if ((this.next != null) && (isPredecessor(value))) {
                this.next = this.next.deleteElement(value);
            }
            return this;
        }

    }

    /**
     *
     * @param value
     * @return
     */
    private boolean isPredecessor(char value) {
        char valueLow = Character.toLowerCase(value);
        char value2 = Character.toLowerCase(this.value);

        if (value2 > valueLow) {
            return true;
        }
        if (value2 == valueLow) {
            return this.value < value;
        }

        return false;
    }

    /**
     *
     * @param value
     * @return
     */
    public boolean containsValue(char value) {
        if (this.value == value) {
            return true;
        } else if ((this.next != null) && (isPredecessor(value))) {
            return next.containsValue(value);
        }
        return false;
    }

    /**
     * Die Methode showValues() soll jetzt einen Parameter vom Typ String
     * erhalten, der die Trennzeichen für die Aneinanderreihung angibt (z.B. " "
     * oder ", ").
     *
     * @param separator
     * @return
     */
    public String showValues(String separator) {
        if (this.next == null) {
            // aus char wird string durch + ""
            return getValue() + "";
        } else {
            return getValue() + separator + next.showValues(separator);
        }

    }

    /**
     *
     * @param charList
     * @return
     */
    public int ssize(char[] charList) {
        if (charList != null) {
            return charList.length;
        } else {
            return charList.length;
        }

    }

    public boolean isSame(Element other) {

        if (this.getValue() == other.getValue()) {
            if (this.getNext() != null && other.getNext() != null) {
                return this.next.isSame(other.getNext());
            } else if (this.getNext() == null && other.getNext() == null) {
                return true;
            }
        }
        return false;

    }

    //<editor-fold defaultstate="collapsed" desc="tests">
    /**
     * create a list of the given chars in the array in the order of the
     * arraychars.
     *
     * @param charList array of the chars to add
     * @return a list holding the chars in the order of the arraychars
     */
    private static Element createTestList(char[] charList) {
        Element list = null;
        if (charList != null && charList.length > 0) {
            list = new Element();
            list.setValue(charList[0]);

            for (int i = 1; i < charList.length; i++) {
                list = list.appendElement(charList[i]);
            }
        }
        return list;
    }

    /**
     * tests showValues with one and more listElements.
     */
    private static void testShowValues() {
        System.out.println("teste showValues()");
        Element list = new Element();
        list.setValue('A');
        System.out.print('A' == list.value
                ? ""
                : "Wert von einem Element fehlerhaft: "
                + "SOLL (A), IST (" + list.showValues(" ") + ")\n");

        list = createTestList(new char[]{'A'});
        System.out.print("A".equals(list.showValues(" "))
                ? ""
                : "showValues oder createTestList für Liste mit einem Element fehlerhaft: "
                + "SOLL (A), IST (" + list.showValues(" ") + ")\n");

        list = createTestList(new char[]{'A', 'B', 'C'});
        System.out.print("A B C".equals(list.showValues(" "))
                ? ""
                : "showValues oder createTestList fehlerhaft: "
                + "SOLL (A B C), IST (" + list.showValues(" ") + ")\n");

        System.out.println("");
    }

    /**
     * creates a new Element with the given value.
     *
     * @param value value to set
     * @return a new Element with the given value
     */
    private static Element createElement(char value) {
        Element element = new Element();
        element.setValue(value);
        return element;
    }

    /**
     * tests isPredecessor().
     */
    private static void testIsPredecessor() {
        System.out.println("teste isPredecessor()");

        Element element = createElement('A');
        System.out.print(!element.isPredecessor('B')
                ? ""
                : "upcase Characters: A shouldn't precede B\n");

        element = createElement('B');
        System.out.print(element.isPredecessor('A')
                ? ""
                : "upcase Characters: B should precede A\n");

        element = createElement('a');
        System.out.print(!element.isPredecessor('b')
                ? ""
                : "lowercase Characters: a shouldn't precede b\n");

        element = createElement('b');
        System.out.print(element.isPredecessor('a')
                ? ""
                : "lowercase Characters: b should precede a\n");

        element = createElement('A');
        System.out.print(element.isPredecessor('a')
                ? ""
                : "same Characters: A should precede a\n");

        element = createElement('a');
        System.out.print(!element.isPredecessor('B')
                ? ""
                : "mixed case: a shouldn't precede B\n");

        System.out.println("");
    }

    /**
     * tests insertElementSorted().
     */
    private static void testInsertElementSorted() {

        System.out.println("teste insertElementSorted()");

        //insert at end
        Element list = createTestList(new char[]{'B'});
        list = list.insertElementSorted('A');
        System.out.print("B A".equals(list.showValues(" "))
                ? ""
                : "{B}.insertElementSorted('A'): "
                + "SOLL (B A), IST (" + list.showValues(" ") + ")\n");

        //insert in middle
        list = createTestList(new char[]{'D', 'B'});
        list = list.insertElementSorted('C');
        System.out.print("D C B".equals(list.showValues(" "))
                ? ""
                : "{D B}.insertElementSorted('C'): "
                + "SOLL (D C B), IST (" + list.showValues(" ") + ")\n");

        //insert at front
        list = createTestList(new char[]{'B', 'A'});
        list = list.insertElementSorted('C');
        System.out.print("C B A".equals(list.showValues(" "))
                ? ""
                : "{B A}.insertElementSorted('C'): "
                + "SOLL (C B A), IST (" + list.showValues(" ") + ")\n");

        //insert lowercase in uppercase
        list = createTestList(new char[]{'A'});
        list = list.insertElementSorted('a');
        System.out.print("A a".equals(list.showValues(" "))
                ? ""
                : "{A}.insertElementSorted('a'): "
                + "SOLL (A a), IST (" + list.showValues(" ") + ")\n");

        //insert uppercase in lowercase
        list = createTestList(new char[]{'b', 'a'});
        list = list.insertElementSorted('A');
        System.out.print("b A a".equals(list.showValues(" "))
                ? ""
                : "{b a}.insertElementSorted('A'): "
                + "SOLL (b A a), IST (" + list.showValues(" ") + ")\n");

        System.out.println("");
    }

    /**
     * tests containsValue().
     */
    private static void testContainsValue() {
        System.out.println("teste containsValue()");
        Element sorted = createTestList(new char[]{'D', 'd', 'B', 'b'});
        // values contained
        System.out.print(sorted.containsValue('B')
                ? ""
                : "containsValue('B') in {D d B b} liefert false\n");
        System.out.print(sorted.containsValue('b')
                ? ""
                : "containsValue('b') in {D d B b} liefert false\n");
        System.out.print(sorted.containsValue('d')
                ? ""
                : "containsValue('d') in {D d B b} liefert false\n");

        // values not contained
        System.out.print(!sorted.containsValue('A')
                ? ""
                : "containsValue('A') in {D d B b} liefert true\n");
        System.out.print(!sorted.containsValue('c')
                ? ""
                : "containsValue('c') in {D d B b} liefert true\n");
        System.out.print(!sorted.containsValue('e')
                ? ""
                : "containsValue('e') in {D d B b} liefert true\n");

        // sorting shall be relevant
        Element unsorted = createTestList(new char[]{'y', 'x', 'z'});
        System.out.print(!unsorted.containsValue('z')
                ? ""
                : "containsValue('z') in {y x z} liefert true, obwohl "
                + "von sortierter Liste ausgegangen werden soll "
                + "('z' kann nicht nach 'y' kommen).\n");

        unsorted = createTestList(new char[]{'c', 'b', 'C'});
        System.out.print(!unsorted.containsValue('C')
                ? ""
                : "containsValue('C') in {c b C} liefert true, obwohl "
                + "von sortierter Liste ausgegangen werden soll "
                + "('C' kann nicht nach 'c' vorkommen).\n");

        unsorted = createTestList(new char[]{'c', 'e', 'C'});
        System.out.print(!unsorted.containsValue('C')
                ? ""
                : "containsValue('C') in {c e C} liefert true, obwohl "
                + "von sortierter Liste ausgegangen werden soll "
                + "('C' kann nicht nach 'c' kommen).\n");

        System.out.println("");
    }

    /**
     * tests deleteElement().
     */
    private static void testDeleteElement() {
        System.out.println("teste deleteElement()");

        // delete at the end
        Element list = createTestList(new char[]{'D', 'd', 'B', 'b'});
        list = list.deleteElement('b');
        System.out.print("D d B".equals(list.showValues(" "))
                ? ""
                : "deleteElement('b') in {D d B b} liefert {" + list.showValues(" ") + "}\n");

        // delete in the middle
        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
        list = list.deleteElement('B');
        System.out.print("D d b".equals(list.showValues(" "))
                ? ""
                : "deleteElement('B') in {D d B b} liefert {" + list.showValues(" ") + "}\n");

        // delete in the middle
        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
        list = list.deleteElement('d');
        System.out.print("D B b".equals(list.showValues(" "))
                ? ""
                : "deleteElement('d') in {D d B b} liefert {" + list.showValues(" ") + "}\n");

        // delete at the beginning
        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
        list = list.deleteElement('D');
        System.out.print("d B b".equals(list.showValues(" "))
                ? ""
                : "deleteElement('B') in {D d B b} liefert {" + list.showValues(" ") + "}\n");

        // delete names not contained
        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
        list = list.deleteElement('A');
        System.out.print("D d B b".equals(list.showValues(" "))
                ? ""
                : "nicht existentes El: deleteElement('A') in {D d B b} liefert {" + list.showValues(" ") + "}\n");

        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
        list = list.deleteElement('c');
        System.out.print("D d B b".equals(list.showValues(" "))
                ? ""
                : "nicht existentes El: deleteElement('c') in {D d B b} liefert {" + list.showValues(" ") + "}\n");

        list = createTestList(new char[]{'D', 'd', 'B', 'b'});
        list = list.deleteElement('E');
        System.out.print("D d B b".equals(list.showValues(" "))
                ? ""
                : "nicht existentes El: deleteElement('E') in {D d B b} liefert {" + list.showValues(" ") + "}\n");

        // sorting shall be relevant
        Element unsorted = createTestList(new char[]{'y', 'x', 'z'});
        unsorted = unsorted.deleteElement('z');
        System.out.print("y x z".equals(unsorted.showValues(" "))
                ? ""
                : "deleteElement('z') in {y x z} liefert {" + unsorted.showValues(" ")
                + "}, obwohl von sortierter Liste ausgegangen werden soll ('z' kann nicht nach 'x' kommen).\n");

        unsorted = createTestList(new char[]{'c', 'b', 'C'});
        unsorted = unsorted.deleteElement('C');
        System.out.print("c b C".equals(unsorted.showValues(" "))
                ? ""
                : "deleteElement('C') in {c b C} liefert {" + unsorted.showValues(" ")
                + "}, obwohl von sortierter Liste ausgegangen werden soll ('C' kann nicht nach 'c' kommen).\n");

        unsorted = createTestList(new char[]{'c', 'e', 'C'});
        unsorted = unsorted.deleteElement('C');
        System.out.print("c e C".equals(unsorted.showValues(" "))
                ? ""
                : "deleteElement('C') in {c e C} liefert {" + unsorted.showValues(" ")
                + "}, obwohl von sortierter Liste ausgegangen werden soll ('C' kann nicht nach 'c' kommen).\n");

        System.out.println("");
    }

    /**
     * checks the method isSame()
     */
    private static void testIsSame() {

        System.out.println("teste isSame()");

        Element list1 = createTestList(new char[]{'a'});
        Element list2 = createTestList(new char[]{'a', 'B', 'c'});
        Element list3 = createTestList(new char[]{'a', 'B', 'c'});
        Element list4 = createTestList(new char[]{'x', 'y', 'z'});

        // identical lists (same reference)
        System.out.print(list1.isSame(list1)
                ? ""
                : "isSame() selbe Listen: {" + list1.showValues(" ")
                + "}.isSame({" + list1.showValues(" ") + "}) sollte true liefern.\n");

        // equal lists
        System.out.print(list2.isSame(list3)
                ? ""
                : "isSame() gleiche Listen: {" + list2.showValues(" ")
                + "}.isSame({" + list3.showValues(" ") + "}) sollte true liefern.\n");

        // same length, different values
        System.out.print(!list3.isSame(list4)
                ? ""
                : "isSame() gleiche Listenlänge anderer Inhalt: {" + list2.showValues(" ")
                + "}.isSame({" + list3.showValues(" ") + "}) sollte false liefern.\n");

        // compare longer with shorter list
        System.out.print(!list2.isSame(list1)
                ? ""
                : "längereListe.isSame(kurzeListe): {" + list2.showValues(" ")
                + "}.isSame({" + list1.showValues(" ") + "}) sollte false liefern.\n");

        // compare shorter with longer list
        System.out.print(!list1.isSame(list2)
                ? ""
                : "kurzeListe.isSame(längereListe): {" + list2.showValues(" ")
                + "}.isSame({" + list3.showValues(" ") + "}) sollte false liefern.\n");
    }

    /**
     * calls testRoutines
     *
     * @param args
     */
    public static void main(String[] args) {
        testShowValues();
        testIsPredecessor();
        testInsertElementSorted();
        testContainsValue();
        testDeleteElement();
        testIsSame();
    }
//</editor-fold>    

}
