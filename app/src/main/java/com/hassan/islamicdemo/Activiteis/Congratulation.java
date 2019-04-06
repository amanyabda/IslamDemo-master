package com.hassan.islamicdemo.Activiteis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hassan.islamicdemo.R;


public class Congratulation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);

        TextView text1=(TextView)findViewById(R.id.tex1);
        TextView text2=(TextView)findViewById(R.id.tex2);
        TextView text3=(TextView)findViewById(R.id.tex3);


        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_page_One=new Intent(Congratulation.this,Images_Recycler.class);
                startActivity(go_page_One);
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_Page_two=new Intent(Congratulation.this,Page_two.class);
                startActivity(go_Page_two);
            }
        });text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_Page_three=new Intent(Congratulation.this,Page_three.class);
                startActivity(go_Page_three);
            }
        });

    }
}
