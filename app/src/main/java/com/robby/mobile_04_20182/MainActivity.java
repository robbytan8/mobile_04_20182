package com.robby.mobile_04_20182;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.robby.mobile_04_20182.adapter.DepartmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Robby
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_data)
    RecyclerView rvDepartment;
    private DepartmentAdapter departmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvDepartment.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvDepartment.getContext(),
                layoutManager.getOrientation());
        rvDepartment.addItemDecoration(dividerItemDecoration);
        rvDepartment.setHasFixedSize(true);
        rvDepartment.setAdapter(getDepartmentAdapter());
    }

    private DepartmentAdapter getDepartmentAdapter() {
        if (departmentAdapter == null) {
            departmentAdapter = new DepartmentAdapter();
        }
        return departmentAdapter;
    }
}
