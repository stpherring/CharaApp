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
import edu.illinois.cs.chara.charaapp.objects.StudentListElement;

/**
 * Created by Stephen on 10/22/2014.
 */
public class StudentListAdapter extends BaseAdapter {

    private Context context;
    private List<StudentListElement> data;

    public StudentListAdapter(Context context) {
        this.context = context;
        data = new ArrayList<StudentListElement>();
    }

    public void setData(List<StudentListElement> data) {
        this.data = data;
        notifyDataSetChanged();
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
            convertView = inflater.inflate(R.layout.list_item_student, null);
            holder = new ViewHolder();
            holder.nameText = (TextView) convertView.findViewById(R.id.list_item_student_name);
            holder.roomText = (TextView) convertView.findViewById(R.id.list_item_student_room_number);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        StudentListElement element = data.get(position);
        String name = element.getName();
        String room = element.getRoomNumber();

        holder.nameText.setText(name);
        holder.roomText.setText(room);

        return convertView;
    }

    private class ViewHolder {
        TextView nameText;
        TextView roomText;
    }
}
