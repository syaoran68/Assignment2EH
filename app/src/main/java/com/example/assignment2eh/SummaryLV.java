package com.example.assignment2eh;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment2eh.Adaptor.CourseListAdapter;
import com.example.assignment2eh.Adaptor.SummaryListAdapter;


public class SummaryLV extends AppCompatActivity {

    protected Menu detailMenu;
    ListView mSummaryView;
    protected SummaryListAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.person_list_lv);
        //
        mSummaryView = findViewById(R.id.summary_list_id);
        ad = new SummaryListAdapter(this);
        mSummaryView.setAdapter(ad);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.detain_menu_list, menu);
        menu.findItem(R.id.action_add).setVisible(true);
        menu.findItem(R.id.action_edit).setVisible(false);
        menu.findItem(R.id.action_done).setVisible(false);
        detailMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //.. you are now on this option you selected, no what can you do..
        switch (item.getItemId()){
            case R.id.action_add:{
                Intent i = new Intent(this, AddStudentDetail.class);
                startActivity(i);
            }
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        ad.updateList();
        ad.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
