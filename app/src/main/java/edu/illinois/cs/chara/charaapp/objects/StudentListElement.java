package edu.illinois.cs.chara.charaapp.objects;

/**
 * Created by Stephen on 10/22/2014.
 */
public class StudentListElement {

    private String name;
    private String roomNumber;

    public StudentListElement(String name, String roomNumber) {
        this.name = name;
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}
