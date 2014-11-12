package edu.illinois.cs.chara.charaapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.objects.QueueListElement;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueListAdapter extends BaseAdapter {

    private Context context;
    List<QueueListElement> data;

    public QueueListAdapter(Context context) {
        this.context = context;
        data = new ArrayList<QueueListElement>();
    }

    public void setData(List<QueueListElement> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item_queue, null);
            holder = new ViewHolder();
            holder.number = (TextView) convertView.findViewById(R.id.queue_item_course_number);
            holder.name = (TextView) convertView.findViewById(R.id.queue_item_name);
            holder.numStudents = (TextView) convertView.findViewById(R.id.queue_item_num_people);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        QueueListElement element = data.get(position);
        String number = element.getNumber();
        String name = element.getName();
        String numStudents = element.getNumStudents();

        holder.number.setText(number);
        holder.name.setText(name);
        holder.numStudents.setText(numStudents);

        return convertView;
    }

    private class ViewHolder {
        TextView number;
        TextView name;
        TextView numStudents;
    }
}
