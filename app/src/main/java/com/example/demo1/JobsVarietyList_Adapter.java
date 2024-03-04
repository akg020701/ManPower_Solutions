package com.example.demo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class JobsVarietyList_Adapter extends ArrayAdapter<JobsDesc_Item> {
    JobsDesc_Item[] list;
    Context context;
    public JobsVarietyList_Adapter(@NonNull Context context,@NonNull JobsDesc_Item[] objects) {
        super(context, 0,objects);
        list=objects;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null || ((CheckBox)listitemView.findViewById(R.id.checkBox)).isChecked()) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.jobs_variety_list_layout, parent, false);
        }
        JobsDesc_Item job=getItem(position);
        CheckBox jobsCB = listitemView.findViewById(R.id.checkBox);
        jobsCB.setText(job.getTitle());
        final boolean bc;
        jobsCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                job.setCheck(b);
                notifyDataSetChanged();
            }
        });
        jobsCB.setChecked(job.check);
        return listitemView;
    }
}
