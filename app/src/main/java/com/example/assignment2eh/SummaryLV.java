package com.example.assignment2eh;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.assignment2eh.Adaptor.SummaryListAdapter;


public class SummaryLV extends Activity {

    ListView mSummaryView;
    protected SummaryListAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.person_list_lv);
        //
        mSummaryView = findViewById(R.id.summary_list_id);
        ad = new SummaryListAdapter();
        mSummaryView.setAdapter(ad);

    }
}
