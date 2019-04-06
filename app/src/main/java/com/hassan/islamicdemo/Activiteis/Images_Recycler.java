package com.hassan.islamicdemo.Activiteis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hassan.islamicdemo.R;

import java.util.ArrayList;
import java.util.List;

public class Images_Recycler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images__recycler);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        List<Images> imageList = new ArrayList();
        imageList.add(new Images(R.drawable.a1,"save","share","set_wellpaper"));
        imageList.add(new Images(R.drawable.a2,"save","share","set_wellpaper"));
        imageList.add(new Images(R.drawable.a3,"save","share","set_wellpaper"));

        final ImagesAdapter adapter = new ImagesAdapter(this, (ArrayList<Images>) imageList);
        recyclerView.setAdapter(adapter);

    }
}
