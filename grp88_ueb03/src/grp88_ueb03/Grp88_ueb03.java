/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp88_ueb03;

/**
 *
 * @author ODK
 */
public class Grp88_ueb03 {

    /**
     * Separator
     */
    private final static String SEPARATOR = "----------------------------------------";

    /**
     * Creates a linked list filled with characters.
     *
     * @param charArray to fill the list
     * @return list filled with Elements from charArray in same order
     */
    private static List createTestList(char[] charArray) {
        List list = new List();
        for (int i = 0; i < charArray.length; i++) {
            list.appendElement(charArray[i]);
        }
        return list;
    }

    /**
     * Test for List.showValues() method.
     */
    private static void testShowValues() {
        System.out.println("teste showValues()");

        // empty list
        List list = new List();
        System.out.println("erwarte: {}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // full list
        list = createTestList(new char[]{'A', 'b', 'Z', 'u', 'J'});
        System.out.println("erwarte: {A,b,Z,u,J}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);
        System.out.println("");
    }

    /**
     * Test for List.size() method
     */
    private static void testSize() {
        System.out.println("teste size()");

        // leere Liste
        List list = new List();
        System.out.println("erwarte: 0");
        System.out.println("bekomme: " + list.size()
                + ((list.isEmpty())
                        ? ""
                        : " <-- expect size 0 for empty list"));
        System.out.println(SEPARATOR);

        // volle Liste
        list = createTestList(new char[]{'A', 'b', 'Z', 'u', 'J'});
        System.out.println("erwarte: 5");
        System.out.println("bekomme: " + list.size()
                + ((list.size() == 5)
                        ? ""
                        : " <-- expect size 5 for test list"));
        System.out.println(SEPARATOR);

        System.out.println();
    }

    /**
     * Test for List.isSorted() method.
     */
    private static void testIsSorted() {
        System.out.println("teste isSorted()");

        // empty list
        List list = new List();
        System.out.println("erwarte: true");
        System.out.println("bekomme: " + list.isSorted()
                + ((list.isSorted())
                        ? ""
                        : " <-- expect empty list to be sorted"));
        System.out.println(SEPARATOR);

        // sorted test list
        list = createTestList(new char[]{'A', 'B', 'Z', 'b', 'u'});
        System.out.println("erwarte: true");
        System.out.println("bekomme: " + list.isSorted()
                + ((list.isSorted())
                        ? ""
                        : " <-- expect sorted test list {A,B,Z,b,u} to be sorted"));
        System.out.println(SEPARATOR);

        // unsorted test list
        list = createTestList(new char[]{'B', 'A'});
        System.out.println("erwarte: false");
        System.out.println("bekomme: " + list.isSorted()
                + ((!list.isSorted())
                        ? ""
                        : " <-- expect unsorted test list {B,A} not to be sorted"));
        System.out.println(SEPARATOR);

        // unsorted test list
        list = createTestList(new char[]{'b', 'a'});
        System.out.println("erwarte: false");
        System.out.println("bekomme: " + list.isSorted()
                + ((!list.isSorted())
                        ? ""
                        : " <-- expect unsorted test list {b,a} not to be sorted"));
        System.out.println(SEPARATOR);

        // unsorted test list
        list = createTestList(new char[]{'a', 'B'});
        System.out.println("erwarte: false");
        System.out.println("bekomme: " + list.isSorted()
                + ((!list.isSorted())
                        ? ""
                        : " <-- expect unsorted test list {a,B} not to be sorted"));
        System.out.println(SEPARATOR);

        System.out.println("");
    }

    /**
     * Test for List.insertElementSorted() method.
     */
    private static void testInsertElementSorted() {
        System.out.println("teste insertElementSorted()");

        // empty list
        List list = new List();
        list.insertElementSorted('A');
        System.out.println("erwarte: {A}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // insert at first
        list = createTestList(new char[]{'B', 'D'});
        list.insertElementSorted('A');
        System.out.println("erwarte: {A,B,D}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // insert in middle
        list = createTestList(new char[]{'B', 'D'});
        list.insertElementSorted('C');
        System.out.println("erwarte: {B,C,D}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // insert at end
        list = createTestList(new char[]{'B', 'D'});
        list.insertElementSorted('E');
        System.out.println("erwarte: {B,D,E}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // insert lowercase in uppercase
        list = createTestList(new char[]{'B', 'D'});
        list.insertElementSorted('a');
        System.out.println("erwarte: {B,D,a}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // insert uppercase in lowercase
        list = createTestList(new char[]{'b', 'd'});
        list.insertElementSorted('C');
        System.out.println("erwarte: {C,b,d}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        System.out.println("");
    }

    /**
     * Test for List.containsValue() method.
     */
    private static void testContainsValue() {
        System.out.println("teste containsValue()");
        List list = createTestList(new char[]{'A', 'b', 'Z', 'u', 'J'});

        // first and last element
        System.out.println("erwarte: true");
        System.out.println("bekomme: " + list.containsValue('A')
                + ((list.containsValue('A'))
                ? ""
                : " <-- expect first element to be contained"));
        System.out.println(SEPARATOR);
        System.out.println("erwarte: true");
        System.out.println("bekomme: " + list.containsValue('J')
                + ((list.containsValue('J'))
                ? ""
                : " <-- expect last element to be contained"));
        System.out.println(SEPARATOR);

        // elements not in the list
        System.out.println("erwarte: false");
        System.out.println("bekomme: " + list.containsValue('h')
                + ((!list.containsValue('h'))
                ? ""
                : " <-- expect 'h' not to bei contained"));
        System.out.println(SEPARATOR);

        System.out.println("erwarte: false");
        System.out.println("bekomme: " + list.containsValue('g')
                + ((!list.containsValue('g'))
                ? ""
                : " <-- expect 'g' not to be contained"));
        System.out.println(SEPARATOR);

        System.out.println("");
    }

    /**
     * Test for List.getValueAt() method.
     */
    private static void testGetValueAt() {
        System.out.println("teste getValueAt()");

        // at the beginning
        List list = createTestList(new char[]{'A', 'J', 'Z', 'b', 'u'});
        char testResult = list.getValueAt(0);
        System.out.println("erwarte: A");
        System.out.println("bekomme: " + testResult
                + ((testResult == 'A')
                        ? ""
                        : " <-- looked for first value"));
        System.out.println(SEPARATOR);

        // in the middle
        testResult = list.getValueAt(2);
        System.out.println("erwarte: Z");
        System.out.println("bekomme: " + testResult
                + ((testResult == 'Z')
                        ? ""
                        : " <-- looked for third value"));
        System.out.println(SEPARATOR);

        // at the end
        testResult = list.getValueAt(4);
        System.out.println("erwarte: u");
        System.out.println("bekomme: " + testResult
                + ((testResult == 'u')
                        ? ""
                        : " <-- looked for fifth (last) value"));
        System.out.println(SEPARATOR);

        // invalid index
        testResult = list.getValueAt(15);
        System.out.println("erwarte: invalidValue");
        System.out.println("bekomme: "
                + ((testResult == Element.getInvalidValue())
                        ? "invalidValue"
                        : " <-- looked at invalid index 15 "));
        System.out.println(SEPARATOR);

        testResult = list.getValueAt(-15);
        System.out.println("erwarte: invalidValue");
        System.out.println("bekomme: "
                + ((testResult == Element.getInvalidValue())
                        ? "invalidValue"
                        : " <-- looked at invalid index -15"));
        System.out.println(SEPARATOR);

        System.out.println();
    }

    /**
     * Test for List.insertElementAt() method.
     */
    private static void testInsertElementAt() {
        System.out.println("teste insertElementAt()");

        // insert at the end
        List list = createTestList(new char[]{'A', 'b', 'Z', 'u', 'J'});
        list.insertElementAt('I', 5);
        System.out.println("erwarte: {A,b,Z,u,J,I}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // insert in the middle
        list = createTestList(new char[]{'A', 'b', 'Z', 'u', 'J'});
        list.insertElementAt('I', 3);
        System.out.println("erwarte: {A,b,Z,I,u,J}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // insert at the start
        list = createTestList(new char[]{'A', 'b', 'Z', 'u', 'J'});
        list.insertElementAt('I', 0);
        System.out.println("erwarte: {I,A,b,Z,u,J}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // invalid index
        list = createTestList(new char[]{'A', 'b', 'Z', 'u', 'J'});
        list.insertElementAt('I', -15);
        System.out.println("erwarte: {A,b,Z,u,J}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);
        System.out.println();

    }

    /**
     * Test for List.insertElementAtFront() method.
     */
    private static void testInsertElementAtFront() {
        System.out.println("teste insertElementAtFront()");

        // empty list
        List list = new List();
        list.insertElementAtFront('F');
        System.out.println("erwarte: {F}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // short list
        list = createTestList(new char[]{'A', 'J'});
        list.insertElementAtFront('F');
        System.out.println("erwarte: {F,A,J}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);
        System.out.println();

    }

    /**
     * Test for List.insertSortedIfUnique() method.
     */
    private static void testInsertSortedIfUnique() {
        System.out.println("teste insertIfUnique()");

        // add unique value
        List list = createTestList(new char[]{'A', 'Z', 'u'});
        list.insertSortedIfUnique('k');
        System.out.println("erwarte: {A,Z,k,u}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // add existing value again
        list = createTestList(new char[]{'Z', 'b', 'u'});
        list.insertSortedIfUnique('b');
        System.out.println("erwarte: {Z,b,u}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);

        // case sensitive test 
        list = createTestList(new char[]{'A', 'Z', 'b', 'u'});
        list.insertSortedIfUnique('B');
        System.out.println("erwarte: {A,B,Z,b,u}");
        System.out.println("bekomme: " + list.showValues());
        System.out.println(SEPARATOR);
    }

    /**
     * Calls tests for several methods of List.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testSize();
        testShowValues();
        //testInsertElementSorted();
        //testIsSorted();
        //testContainsValue();
        //testGetValueAt();
        //testInsertElementAt();
        //testInsertElementAtFront();
        //testInsertSortedIfUnique();
    }
}
