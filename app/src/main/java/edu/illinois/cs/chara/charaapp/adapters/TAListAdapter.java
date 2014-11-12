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
 * Created by Stephen on 11/4/2014.
 */
public class TAListAdapter extends BaseAdapter {

    private Context context;
    private List<String> data;

    public TAListAdapter(Context context) {
        this.context = context;
        data = new ArrayList<String>();
    }

    public void setData(List<String> data) {
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
            convertView = inflater.inflate(R.layout.list_item_student, null);
            holder = new ViewHolder();
            holder.nameText = (TextView) convertView.findViewById(R.id.list_item_student_name);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        String element = data.get(position);

        holder.nameText.setText(element);

        return convertView;
    }

    private class ViewHolder {
        TextView nameText;
    }
}
