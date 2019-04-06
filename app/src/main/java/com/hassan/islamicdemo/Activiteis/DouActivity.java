package com.hassan.islamicdemo.Activiteis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.hassan.islamicdemo.R;


public class DouActivity extends AppCompatActivity {

    GridView gridView;

    String[] fruitNames = {"1","2","3","4","5","6","7","8","9","10","11","12","13",
                            "14","15","16","17","18","19","20","21","22","23","24",
                            "25","26","27","28","29","30"};

    int[] fruitImages = {R.drawable.r1, R.drawable.r2, R.drawable.r3,
            R.drawable.r4, R.drawable.r5, R.drawable.r6,
            R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10, R.drawable.r11,
            R.drawable.r12, R.drawable.r13, R.drawable.r14, R.drawable.r15, R.drawable.r16, R.drawable.r17, R.drawable.r18,
            R.drawable.r19, R.drawable.r20, R.drawable.r21,
            R.drawable.r22, R.drawable.r23, R.drawable.r24, R.drawable.r25, R.drawable.r26,
            R.drawable.r27, R.drawable.r28, R.drawable.r29, R.drawable.r30};

   String [] Namesday = {"اليوم الاول","اليوم الثاني","اليوم الثالت","اليوم الرابع","اليوم الخامس","اليوم السادس",
           "اليوم السابع","اليوم الثامن","اليوم التاسع","اليوم العاشر","اليوم الحادي عشر","اليوم الثاني عشر","اليوم الثالث عشر",
           "اليوم الرابع عشر","اليوم الخامس عشر","اليوم السادس عشر","اليوم السابع عشر",
           "اليوم الثامن عشر","اليوم التاسع عشر","اليوم العشرون","اليوم الواحد والعشرون","اليوم الثاني والعشرون",
           "اليوم الثالث والعشرون","اليوم الرابع والعشرون",
           "اليوم الخامس والعشرون","اليوم السادس والعشرون","اليوم السابع والعشرون","اليوم الثامن والعشرون",
           "اليوم التاسع والعشرون","اليوم الثلاثون"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dou_activity);

        //finding listview
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",Namesday[i]);
                intent.putExtra("image",fruitImages[i]);
                startActivity(intent);

            }
        });


    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return fruitImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data2,null);

            //getting view in row_data
             TextView name = view1.findViewById(R.id.rr);
           // ImageView image = view1.findViewById(R.id.images);

            name.setText(fruitNames[i]);
           // image.setImageResource(fruitImages[i]);
            return view1;



        }
    }
}