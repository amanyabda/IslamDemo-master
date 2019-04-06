package com.hassan.islamicdemo.Activiteis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hassan.islamicdemo.Home.MainActivity;
import com.hassan.islamicdemo.R;


public class FirstScreen extends AppCompatActivity {

    GridView gridView;
    String[] fruitNames = {"اوقات الصلاة","الادعية","اسماء الله الحسنى","بطاقات تهنئة"};
    int[] fruitImages = {R.drawable.calendar,R.drawable.dua,R.drawable.asm2,
            R.drawable.ic_message};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);

        //finding listview
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(),fruitImages[0],Toast.LENGTH_LONG).show();

                if (i==0){
                    //  Toast.makeText(getApplicationContext(),view.getId()+"",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(FirstScreen.this,MainActivity.class);
                    startActivity(intent);
                }
                else if (i==1){
                    //  Toast.makeText(getApplicationContext(),view.getId()+"",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(FirstScreen.this,DouActivity.class);
                    startActivity(intent);
                }
                else if (i==2){
                    //Toast.makeText(getApplicationContext(),view.getId()+"",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(FirstScreen.this,Names_Of_Alla.class);
                    startActivity(intent);
                }
                else if (i==3){
                    // Toast.makeText(getApplicationContext(),view.getId()+"",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(FirstScreen.this,Congratulation.class);
                    startActivity(intent);
                }



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
            View view1 = getLayoutInflater().inflate(R.layout.row_data1,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.fruits);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(fruitNames[i]);
            image.setImageResource(fruitImages[i]);
            return view1;



        }
    }
}
