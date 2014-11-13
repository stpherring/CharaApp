package edu.illinois.cs.chara.charaapp.objects;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueListElement {

    private String number;
    private String name;
    private String[] TAs;
    private int numTAs;

    public QueueListElement(String number, String name, String[] TAs) {
        this.number = number;
        this.name = name;
        this.TAs = TAs;
        this.numTAs = TAs.length;

    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getNumTAs() {
        return numTAs;
    }

    public String[] getTAs() {
        return TAs;
    }

    public void setName(String name) {
        this.name = name;
    }
}
