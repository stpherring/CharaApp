package edu.illinois.cs.chara.charaapp.objects;

/**
 * Created by Stephen on 11/12/2014.
 */
public class QueueObject {

    private String name;
    private String courseId;
    private String[] activeTAs;

    public QueueObject(String name, String courseId, String[] activeTAs) {
        this.name = name;
        this.courseId = courseId;
        this.activeTAs = activeTAs;
    }

    public String getName() {
        return name;
    }

    public String getCourseId() {
        return courseId;
    }

    public String[] getActiveTAs() {
        return activeTAs;
    }


}
