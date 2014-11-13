package edu.illinois.cs.chara.charaapp.activities;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.adapters.QueueListAdapter;
import edu.illinois.cs.chara.charaapp.holders.DataHolder;
import edu.illinois.cs.chara.charaapp.loaders.QueuesLoader;
import edu.illinois.cs.chara.charaapp.objects.QueueListElement;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueListActivity extends ListActivity implements LoaderManager.LoaderCallbacks<List<QueueListElement>> {

    private QueueListAdapter queueListAdapter;
    private String username;

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
                queueIntent.putExtra("username", username);
                queueIntent.putExtra("queue_id", "queue_" + number);
                queueIntent.putExtra("TAs", TAs);
                queueIntent.putExtra("name", name);
                queueIntent.putExtra("number", number);
                startActivity(queueIntent);
            }
        });
        Bundle args = this.getIntent().getExtras();
        username = args.getString("username");
        this.getLoaderManager().initLoader(0, null, this).forceLoad();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.queue_list, menu);
        getActionBar().setTitle("Queues");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        final QueueListActivity activity = this;
        if(id == R.id.logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Log out");
            builder.setMessage("Are you sure you want to log out?");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent loginActivity = new Intent(activity, LoginActivity.class);
                    loginActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginActivity);
                    finish();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<List<QueueListElement>> onCreateLoader(int id, Bundle args) {
        return new QueuesLoader(this, username);
    }

    @Override
    public void onLoadFinished(Loader<List<QueueListElement>> loader, List<QueueListElement> data) {
        queueListAdapter.setData(data);
        DataHolder.getInstance().setQueues(data);
    }

    @Override
    public void onLoaderReset(Loader<List<QueueListElement>> loader) {

    }
}
