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

    public void appendElement(int value) {
        if (this.isEmpty()) {
            elements = new Element();
            elements.setValue(value);
        } else {
            elements = elements.appendElement(value);
        }

    }

    public void insertElement(int value) {
        if (this.isEmpty()) {
            elements = new Element();
            elements.setValue(value);
        } else {
            elements = elements.insertElement(value);
        }
    }

    public void deleteElement(int value) {
        if (!isEmpty()) {
            elements = elements.deleteElement(value);
        }
    }

    public void printList() {
        if (!isEmpty()) {
            elements.printList();
        }
    }
}

}
