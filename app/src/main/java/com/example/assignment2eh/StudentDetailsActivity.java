package com.example.assignment2eh;



import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment2eh.model.Student;
import com.example.assignment2eh.model.Studentdb;


public class StudentDetailsActivity extends AppCompatActivity {

    protected int studentIndex;
    protected Student studentObj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        studentIndex = getIntent().getIntExtra("StudentIndex", 0);
        TextView tv = findViewById(R.id.display_string_id);
        //display the student index
        String origStr = (String)tv.getText();
        tv.setText(origStr + studentIndex);
        tv.setTextSize(24);

        studentObj = Studentdb.getInstance().getStudentList().get(studentIndex);
        //
        EditText editView = findViewById(R.id.p_first_name_id);
        editView.setText(studentObj.getFirstName());
        editView.setEnabled(false);
        editView.findViewById(R.id.p_last_name_id);
        editView.setText(studentObj.getLastName());
        editView.setEnabled(false);
        editView.findViewById(R.id.p_CWID);
        editView.setText(studentObj.getCWID());
        editView.setEnabled(false);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) { //three dots
//        getMenuInflater().inflate(R.menu.detain_screen_menu, menu);
//        //menu.findItem(R.id.action_edit)
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId() == R.id.action_edit)
//    }
}
