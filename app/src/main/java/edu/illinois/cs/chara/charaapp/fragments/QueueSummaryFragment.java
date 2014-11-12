package edu.illinois.cs.chara.charaapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.activities.StudentActivity;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueSummaryFragment extends Fragment {

    public static QueueSummaryFragment newInstance() {
        return new QueueSummaryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_queue_summary, null);
        final Activity queueActivity = this.getActivity();
        Button takeStudent = (Button) view.findViewById(R.id.take_student);
        takeStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentActivityIntent = new Intent(queueActivity, StudentActivity.class);
                startActivity(studentActivityIntent);
            }
        });

        Button leaveQueue = (Button) view.findViewById(R.id.leave_queue);
        leaveQueue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queueActivity.finish();
            }
        });
        return view;
    }
}
