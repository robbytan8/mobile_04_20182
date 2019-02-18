package com.robby.mobile_04_20182;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.robby.mobile_04_20182.adapter.StudentAdapter;
import com.robby.mobile_04_20182.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Robby
 */
public class Main2Activity extends AppCompatActivity implements StudentAdapter.StudentDataClickedListener {

    @BindView(R.id.rv_data)
    RecyclerView rvStudents;

    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        this.populateStudentsData();
        this.populateStudentsGsonData();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        DividerItemDecoration decoration = new DividerItemDecoration(this, manager.getOrientation());
        rvStudents.setLayoutManager(manager);
        rvStudents.addItemDecoration(decoration);
        rvStudents.setAdapter(getStudentAdapter());
    }

    private StudentAdapter getStudentAdapter() {
        if (studentAdapter == null) {
            studentAdapter = new StudentAdapter();
            studentAdapter.setStudentDataClickedListener(this);
        }
        return studentAdapter;
    }

    private void populateStudentsData() {
        try {
            InputStream inputStream = getAssets().open("students.json");
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<Student> students = new ArrayList<>(Arrays.asList(objectMapper.readValue(inputStream, Student[].class)));
            getStudentAdapter().setStudents(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateStudentsGsonData() {
        try {
            InputStream inputStream = getAssets().open("students.json");
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            Gson gson = new Gson();
            Student[] studentsArr = gson.fromJson(reader, Student[].class);
            ArrayList<Student> students = new ArrayList<>(Arrays.asList(studentsArr));
            getStudentAdapter().setStudents(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStudentDataClicked(Student student) {
        Intent intent = new Intent(Main2Activity.this, ActivityDetail.class);
        intent.putExtra(getResources().getString(R.string.parcel_student), student);
        startActivity(intent);
    }
}
