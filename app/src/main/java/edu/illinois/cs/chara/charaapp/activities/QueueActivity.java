package edu.illinois.cs.chara.charaapp.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.viewpagerindicator.TitlePageIndicator;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.adapters.QueuePagerAdapter;

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
}
