package edu.illinois.cs.chara.charaapp.holders;

/**
 * Created by Stephen on 11/13/2014.
 */
public class DataHolder {

    private static DataHolder holder = new DataHolder();

    public static DataHolder getInstance() {
        return holder;
    }
}
