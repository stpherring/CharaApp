package edu.illinois.cs.chara.charaapp.holders;

import java.util.HashMap;
import java.util.List;

import edu.illinois.cs.chara.charaapp.objects.QueueListElement;
import edu.illinois.cs.chara.charaapp.objects.StudentListElement;

/**
 * Created by Stephen on 11/13/2014.
 */
public class DataHolder {


    /*
     * This class only exists so we can modify the stuff we parse from the local JSON (in assets).
     * When this is finally hooked into the actual back end, we are going to send a request to the
     * server instead.
     */

    private static DataHolder holder = new DataHolder();
    private static List<QueueListElement> queues;
    private static HashMap<String, List<StudentListElement>> studentQueueMap = new HashMap<String, List<StudentListElement>>();

    public static DataHolder getInstance() {
        return holder;
    }

    public static List<StudentListElement> getStudents(String queueId) {
        return studentQueueMap.get(queueId);
    }

    public static List<QueueListElement> getQueues() {
        return queues;
    }

    public static void setQueues(List<QueueListElement> data) {
        queues = data;
    }

    public static void setStudents(String queueId, List<StudentListElement> students) {
        studentQueueMap.put(queueId, students);
    }

}
