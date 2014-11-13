package edu.illinois.cs.chara.charaapp.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.holders.DataHolder;
import edu.illinois.cs.chara.charaapp.objects.StudentListElement;


public class StudentActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Bundle extras = this.getIntent().getExtras();
        String name = extras.getString("name");
        String location = extras.getString("location");
        String topic = extras.getString("topic");
        final String queueId = extras.getString("queue_id");

        TextView nameText = (TextView) findViewById(R.id.student_name);
        TextView locationText = (TextView) findViewById(R.id.student_location);
        TextView topicText = (TextView) findViewById(R.id.student_issue_description);

        nameText.setText(name);
        locationText.setText(location);
        topicText.setText(topic);

        Button submitButton = (Button) findViewById(R.id.student_submit);
        Button snoozeButton = (Button) findViewById(R.id.student_snooze);
        final Activity studentActivity = this;
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<StudentListElement> students = DataHolder.getStudents(queueId);
                students.remove(0);
                finish();
            }
        });

        snoozeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(studentActivity);
                builder.setTitle("Snooze");
                builder.setMessage("Put this student back on top of the queue?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
