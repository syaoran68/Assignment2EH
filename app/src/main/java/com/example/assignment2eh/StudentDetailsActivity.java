package com.example.assignment2eh;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment2eh.model.Student;
import com.example.assignment2eh.model.StudentDB;


public class StudentDetailsActivity extends AppCompatActivity {

    protected Menu detailMenu;
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

        studentObj = StudentDB.getInstance().getStudentList().get(studentIndex);
        //
        EditText editView = findViewById(R.id.p_first_name_id);
        editView.setText(studentObj.getFirstName());
        editView.setEnabled(false);
        editView.findViewById(R.id.p_last_name_id);
        editView.setText(studentObj.getLastName());
        editView.setEnabled(false);
        editView.findViewById(R.id.p_student_id);
        editView.setText(studentObj.getStudentId());
        editView.setEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.detain_menu_list, menu);
        menu.findItem(R.id.action_edit).setVisible(true);
        menu.findItem(R.id.action_done).setVisible(false);
        detailMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //.. you are now on this option you selected, no what can you do..
        if (item.getItemId() == R.id.action_edit) {
            EditText editView = findViewById(R.id.p_first_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.p_last_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.p_student_id);
            editView.setEnabled(true);
            //
            item.setVisible(false);
            detailMenu.findItem(R.id.action_done).setVisible(true);
        } else if (item.getItemId() == R.id.action_done) {

            EditText editView = findViewById(R.id.p_first_name_id);
            StudentDB.getInstance().getStudentList().get(studentIndex).setFirstName(editView.getText().toString());
            editView.setEnabled(false);

            editView = findViewById(R.id.p_last_name_id);
            StudentDB.getInstance().getStudentList().get(studentIndex).setLastName(editView.getText().toString());
            editView.setEnabled(false);

            editView = findViewById(R.id.p_student_id);

            StudentDB.getInstance().getStudentList().get(studentIndex).setStudentId(editView.getText().toString());
            editView.setEnabled(false);

            item.setVisible(false);
            detailMenu.findItem(R.id.action_edit).setVisible(true);
        }
        return super.onOptionsItemSelected(item);
    }
}
