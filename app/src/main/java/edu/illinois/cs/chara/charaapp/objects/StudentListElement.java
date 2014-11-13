package edu.illinois.cs.chara.charaapp.objects;

/**
 * Created by Stephen on 10/22/2014.
 */
public class StudentListElement {

    private String name;
    private String roomNumber;
    private String topic;

    public StudentListElement(String name, String roomNumber, String topic) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getTopic() {
        return topic;
    }
}
