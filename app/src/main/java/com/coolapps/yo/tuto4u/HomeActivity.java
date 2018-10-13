package com.coolapps.yo.tuto4u;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    RecyclerView mockTutorRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        List<TutorData> info = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            TutorData t_data = new TutorData();
            t_data.setText1("Tutor " + i);
            t_data.setText2("Profession " + i);
            t_data.setImage(R.mipmap.ic_launcher_round);
            info.add(t_data);
        }

        mockTutorRecycler = findViewById(R.id.mock_tutor_recyclerView);
        TutorAdapter tutorList = new TutorAdapter(info);
        mockTutorRecycler.setAdapter(tutorList);
        mockTutorRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
