package com.example.demo1;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class JobsGV_Adapter extends ArrayAdapter<Jobs_Item>{
Context context;
    public JobsGV_Adapter(@NonNull Context context, ArrayList<Jobs_Item> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        View curent;
        if (listitemView == null || convertView.getBackground()== ContextCompat.getDrawable(context,R.drawable.on_item_select)) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.job_category_item, parent, false);
        }

        Jobs_Item courseModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.job_title);
        ImageView courseIV = listitemView.findViewById(R.id.job_image);

        courseTV.setText(courseModel.getTitle());
        courseIV.setImageResource(courseModel.getImg_id());
        View finalListitemView = listitemView;
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (JobsCategory_Choose.selected != finalListitemView && JobsCategory_Choose.selected != null) {
                    finalListitemView.setBackgroundResource(R.drawable.on_item_select);
                    JobsCategory_Choose.selected.setBackgroundResource(R.drawable.item_background);
                    JobsCategory_Choose.selected = finalListitemView;
                }
                else
                {
                    finalListitemView.setBackgroundResource(R.drawable.on_item_select);
                    JobsCategory_Choose.selected = finalListitemView;
                }
                JobsDesc_Fragment jobsDesc_fragment=new JobsDesc_Fragment(courseModel.getList());
                JobsDesc_Fragment.context=context;
                FragmentManager manager=((AppCompatActivity)context).getSupportFragmentManager();
//                FragmentTransaction transaction=manager.beginTransaction();
//                transaction.setCustomAnimations(R.anim.pop_up_enter,R.anim.pop_up_exit,R.anim.pop_up_enter,R.anim.pop_up_exit);
//                transaction.addToBackStack(null);
//                transaction.add(R.id.container,jobsDesc_fragment,"hill");
//                transaction.commit();
                jobsDesc_fragment.show(manager,"Chumma");
            }
        });
        return listitemView;
    }
}
