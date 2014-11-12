package edu.illinois.cs.chara.charaapp.activities;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.adapters.QueueListAdapter;
import edu.illinois.cs.chara.charaapp.objects.QueueListElement;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_list);

        QueueListAdapter queueListAdapter = new QueueListAdapter(this);
        queueListAdapter.setData(makeFakeList());
        getListView().setAdapter(queueListAdapter);

        final Context queueListContext = this;
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent queueIntent = new Intent(queueListContext, QueueActivity.class);
                startActivity(queueIntent);
            }
        });
    }

    private List<QueueListElement> makeFakeList() {
        ArrayList<QueueListElement> list = new ArrayList<QueueListElement>();
        for(int i = 0; i < 10; i++) {
            QueueListElement element = new QueueListElement("225", "Data Structures", "10 students");
            list.add(element);
        }
        return list;
    }
}
