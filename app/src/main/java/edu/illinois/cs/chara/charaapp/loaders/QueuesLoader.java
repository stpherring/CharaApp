package edu.illinois.cs.chara.charaapp.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs.chara.charaapp.objects.QueueListElement;
import edu.illinois.cs.chara.charaapp.utils.JsonUtils;

/**
 * Created by willhennessy on 11/12/14.
 */
public class QueuesLoader extends AsyncTaskLoader<List<QueueListElement>> {

    private static final String QUEUES_FILE_NAME = "Queues.json";
    private Context mContext;

    public QueuesLoader(Context context, String TANetid) {
        super(context);
        mContext = context;
    }

    @Override
    public List<QueueListElement> loadInBackground() {
        String data = null;
//        future use for loading server. see the HackIllinois git repo from last year
//        try {
//            HttpUtils httpUtils = HttpUtils.getHttpUtils(mContext);
//            data = httpUtils.loadData(urlToLoad);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        boolean loginSuccess = false;

        data = JsonUtils.loadJSONFromAsset(mContext, QUEUES_FILE_NAME);
        ArrayList<QueueListElement> queueListElements = new ArrayList<QueueListElement>();

        if (data != null) {

            try {
                JSONObject queuesObj = new JSONObject(data);
                // error is thrown and caught if netid is not found
                JSONArray queuesArr = queuesObj.getJSONArray("queues");
                for(int i = 0; i < queuesArr.length(); i++) {
                    JSONObject jsonObject = queuesArr.getJSONObject(i);
                    QueueListElement queue = parseQueue(jsonObject);
                    queueListElements.add(queue);
                }
                // TODO do something/load for each queue in the array

            } catch(JSONException j) {
                j.printStackTrace();
            } catch(NullPointerException e) {
                e.printStackTrace();
            }
        }
        return queueListElements;
    }

    private QueueListElement parseQueue(JSONObject jsonObject) throws JSONException {
        String name = jsonObject.getString("name");
        String courseId = jsonObject.getString("course_id");
        JSONArray activeTAsArr = jsonObject.getJSONArray("active_tas");
        String[] taList = new String[activeTAsArr.length()];
        for(int i = 0; i < activeTAsArr.length(); i++) {
            taList[i] = activeTAsArr.getString(i);
        }

        return new QueueListElement(courseId, name, taList);

    }


}