package edu.illinois.cs.chara.charaapp.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs.chara.charaapp.objects.StudentListElement;
import edu.illinois.cs.chara.charaapp.utils.JsonUtils;

/**
 * Created by Stephen on 11/12/2014.
 */
public class StudentLoader extends AsyncTaskLoader<List<StudentListElement>> {

    private static final String ENTRIES_FILE_NAME = "Entries.json";
    private Context context;
    private String queueId;

    public StudentLoader(Context context, String queueId) {
        super(context);
        this.context = context;
        this.queueId = queueId;
    }

    @Override
    public List<StudentListElement> loadInBackground() {

        String data = JsonUtils.loadJSONFromAsset(context, ENTRIES_FILE_NAME);
        ArrayList<StudentListElement> studentListElements = new ArrayList<StudentListElement>();

        if (data != null) {
            try {
                JSONObject studentsObject = new JSONObject(data);
                JSONArray queuesArr = studentsObject.getJSONArray(queueId);
                for(int i = 0; i < queuesArr.length(); i++) {
                    JSONObject jsonObject = queuesArr.getJSONObject(i);
                    StudentListElement student = parseStudent(jsonObject);
                    studentListElements.add(student);
                }
                // TODO do something/load for each queue in the array

            } catch(JSONException j) {
                j.printStackTrace();
            } catch(NullPointerException e) {
                e.printStackTrace();
            }
        }
        return studentListElements;
    }

    public StudentListElement parseStudent(JSONObject jsonObject) throws JSONException{
        String name = jsonObject.getString("name");
        String roomNumber = jsonObject.getString("location");
        String topic = jsonObject.getString("topic");

        return new StudentListElement(name, roomNumber, topic);
    }
}
