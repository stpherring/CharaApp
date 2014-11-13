package edu.illinois.cs.chara.charaapp.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        data = JsonUtils.loadJSONFromAsset(mContext, QUEUES_FILE_NAME);
        boolean loginSuccess = false;

        if (data != null) {

            try {
                JSONObject queuesObj = new JSONObject(data);
                // error is thrown and caught if netid is not found
                JSONArray queuesArr = queuesObj.getJSONArray("queues");

                // TODO do something/load for each queue in the array

            } catch(JSONException j) {
                j.printStackTrace();
            } catch(NullPointerException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}