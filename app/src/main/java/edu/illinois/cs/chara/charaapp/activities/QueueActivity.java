package edu.illinois.cs.chara.charaapp.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.viewpagerindicator.TitlePageIndicator;

import java.util.List;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.adapters.QueuePagerAdapter;
import edu.illinois.cs.chara.charaapp.holders.DataHolder;
import edu.illinois.cs.chara.charaapp.objects.QueueListElement;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);

        ViewPager queuePager = (ViewPager) findViewById(R.id.queue_pager);
        QueuePagerAdapter adapter = new QueuePagerAdapter(getSupportFragmentManager());
        queuePager.setAdapter(adapter);
        queuePager.setCurrentItem(1);

        TitlePageIndicator queueTitlePageIndicator = (TitlePageIndicator) findViewById(R.id.pager_title);
        queueTitlePageIndicator.setViewPager(queuePager);
        queueTitlePageIndicator.setTextColor(Color.BLACK);
        queueTitlePageIndicator.setSelectedColor(Color.BLACK);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Bundle extras = this.getIntent().getExtras();
        String name = extras.getString("name");
        String number = extras.getString("number");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.queue, menu);
        getActionBar().setTitle(number + " " + name);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        final QueueActivity activity = this;
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
        if (id == R.id.leave_queue) {
            final String username = this.getIntent().getExtras().getString("username");
            Intent queueListActivity = new Intent(activity, QueueListActivity.class);
            queueListActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            queueListActivity.putExtra("username", username);
            startActivity(queueListActivity);
            finish();
        }
        if(id == R.id.close_queue) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Close queue");
            builder.setMessage("Are you sure you want to close this queue?");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    deleteQueue();
                    final String username = activity.getIntent().getExtras().getString("username");
                    Intent queueListActivity = new Intent(activity, QueueListActivity.class);
                    queueListActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    queueListActivity.putExtra("username", username);
                    startActivity(queueListActivity);
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

    private void deleteQueue() {
        DataHolder holder = DataHolder.getInstance();
        List<QueueListElement> queues = holder.getQueues();
        Bundle extras = this.getIntent().getExtras();
        String name = extras.getString("name");
        String number = extras.getString("number");
        for(QueueListElement queue : queues) {
            if(name.equals(queue.getName()) && number.equals(queue.getNumber())) {
                queues.remove(queue);
                break;
            }
        }
    }
}
