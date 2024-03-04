package com.example.demo1;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JobsDesc_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobsDesc_Fragment extends DialogFragment {
    ListView list;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static Context context;
    public  View view;
    JobsDesc_Item[] Jobs_List;

    public JobsDesc_Fragment(JobsDesc_Item[] Jobs_List) {
        // Required empty public constructor
        this.Jobs_List=Jobs_List;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobsDesc_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JobsDesc_Fragment newInstance(String param1, String param2, JobsDesc_Item[] Jobs_List) {
        JobsDesc_Fragment fragment = new JobsDesc_Fragment(Jobs_List);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_jobs_desc_, container, false);
        return view;
    }
    //Dialog Frag Implementation
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().getAttributes().windowAnimations = R.anim.pop_up_enter;

        return dialog;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list=(ListView) view.findViewById(R.id.jobs_desc_lv);
        list.setAdapter(new JobsVarietyList_Adapter(view.getContext(),Jobs_List));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    @Override
    public void onStart()
    {
        super.onStart();

        // safety check
        if (getDialog() == null)
            return;
        DisplayMetrics dm=new DisplayMetrics();
        ((AppCompatActivity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
//        ((AppCompatActivity)context).getWindow().setLayout((int)(width),(int)(height*0.7));
//        WindowManager.LayoutParams params=((AppCompatActivity)context).getWindow().getAttributes();
//        params.gravity= Gravity.CENTER;
//        params.x=0;
//        params.y=-20;
//        ((AppCompatActivity)context).getWindow().setAttributes(params);
//        int dialogWidth = 700; // specify a value here
//        int dialogHeight = 600 ; // specify a value here

        getDialog().getWindow().setLayout((int)(width),(int)(height*0.7));

        // ... other stuff you want to do in your onStart() method
    }
}