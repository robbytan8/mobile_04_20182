package com.robby.mobile_04_20182.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Robby
 */
public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder> {

    private ArrayList<String> departments;

    @NonNull
    @Override
    public DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = new TextView(viewGroup.getContext());
        return new DepartmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewHolder departmentViewHolder, int i) {
        departmentViewHolder.txtName.setText(getDepartments().get(i));
    }

    @Override
    public int getItemCount() {
        return getDepartments().size();
    }

    private ArrayList<String> getDepartments() {
        if (departments == null) {
            departments = new ArrayList<>();
            departments.add("S1 Teknik Informatika");
            departments.add("S1 Sistem Informasi");
            departments.add("S2 Ilmu Komputer");
            departments.add("S1 Teknik Sipil");
            departments.add("S1 Teknik Elektro");
            departments.add("S1 Teknik Industri");
            departments.add("S1 Sistem Komputer");
        }
        return departments;
    }

    class DepartmentViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;

        DepartmentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtName = (TextView) itemView;
        }
    }
}
