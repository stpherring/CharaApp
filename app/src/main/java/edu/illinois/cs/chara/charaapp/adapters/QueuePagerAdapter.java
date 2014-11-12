package edu.illinois.cs.chara.charaapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import edu.illinois.cs.chara.charaapp.fragments.QueueStudentListFragment;
import edu.illinois.cs.chara.charaapp.fragments.QueueSummaryFragment;
import edu.illinois.cs.chara.charaapp.fragments.QueueTAListFragment;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueuePagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 3;

    public QueuePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return QueueStudentListFragment.newInstance();
            case 1:
                return QueueSummaryFragment.newInstance();
            case 2:
                return QueueTAListFragment.newInstance();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Students";
            case 1:
                return "Summary";
            case 2:
                return "TAs";
        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
