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
public class Element {

    private char value;
    private Element next;

    public void setValue(char value) {
        this.value = value;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public char getValue() {
        return this.value;
    }

    public Element getNext() {
        return this.next;
    }

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

    public Element insertElement(char value) {
        if (this.value > value) {
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
            this.next = this.next.insertElement(value);
            return this;
        }
    }

    public Element deleteElement(char value) {
        if (this.value == value) {
            return this.next;
        } else {
            if (this.next != null) {
                this.next = this.next.deleteElement(value);
            }
            return this;
        }
    }

    public char showValues() {
        if (next != null) {
            value += getValue();

        }
        return value;
    }

    /**
     * count elements in list
     *
     * @return size of next as integer
     */
    public int getSize() {
        if (this.next != null) {
            return (this.next.getSize()) + 1;
        }
        return 1;
    }

//    public char showValues() {        
//        if (next != null) {
//            value += getValue();
//           
//        }
//        return value;
//    }
}
