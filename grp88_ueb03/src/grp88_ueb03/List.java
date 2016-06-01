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
public class List {

    private Element elements;

    public boolean isEmpty() {
        return elements == null;
    }

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
            elements = elements.insertElement(value);
        }
    }

    public void deleteElement(char value) {
        if (!isEmpty()) {
            elements = elements.deleteElement(value);
        }
    }

    /**
     * @author ODK
     * @return
     */
    public Element showValues() {
        //elements = new Element();
        value =;
        elements = elements.toString();
        return value;
    }

}

//    /**
//     * @author ODK
//     * @return
//     */
//    public String showValues() {
//        Element element = elements;
//        String values = "";
//        while (element != null) {
//            values += element.getValue();
//            element = element.getNext();
//        }
//        return values;
//    }
