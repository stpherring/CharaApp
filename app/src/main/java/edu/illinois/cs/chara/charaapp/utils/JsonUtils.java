package edu.illinois.cs.chara.charaapp.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by willhennessy on 11/12/14.
 */
public class JsonUtils {

    /*
     * Given a file name from the assets/ folder, read it and return its contents
     */
    public static String loadJSONFromAsset(Context context, String file_name) {
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open("/"+file_name);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
