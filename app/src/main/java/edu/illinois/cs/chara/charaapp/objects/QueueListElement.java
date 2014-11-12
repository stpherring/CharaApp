package edu.illinois.cs.chara.charaapp.objects;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueListElement {

    private String number;
    private String name;
    private String numStudents;

    public QueueListElement(String number, String name, String numStudents) {
        this.number = number;
        this.name = name;
        this.numStudents = numStudents;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getNumStudents() {
        return numStudents;
    }
}
