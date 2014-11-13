package edu.illinois.cs.chara.charaapp.activities;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.adapters.QueueListAdapter;
import edu.illinois.cs.chara.charaapp.loaders.QueuesLoader;
import edu.illinois.cs.chara.charaapp.objects.QueueListElement;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueListActivity extends ListActivity implements LoaderManager.LoaderCallbacks<List<QueueListElement>> {

    private QueueListAdapter queueListAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_list);

        queueListAdapter = new QueueListAdapter(this);
        getListView().setAdapter(queueListAdapter);

        final Context queueListContext = this;
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                QueueListElement element = queueListAdapter.getItem(position);
                String name = element.getName();
                String number = element.getNumber();
                String[] TAs = element.getTAs();
                Intent queueIntent = new Intent(queueListContext, QueueActivity.class);
                queueIntent.putExtra("queue_id", "queue_" + number);
                queueIntent.putExtra("TAs", TAs);
                queueIntent.putExtra("name", name);
                startActivity(queueIntent);
            }
        });
        Bundle args = this.getIntent().getExtras();

        this.getLoaderManager().initLoader(0, args, this).forceLoad();
    }

    @Override
    public Loader<List<QueueListElement>> onCreateLoader(int id, Bundle args) {
        return new QueuesLoader(this, args.getString("username"));
    }

    @Override
    public void onLoadFinished(Loader<List<QueueListElement>> loader, List<QueueListElement> data) {

        queueListAdapter.setData(data);
    }

    @Override
    public void onLoaderReset(Loader<List<QueueListElement>> loader) {

    }
}
