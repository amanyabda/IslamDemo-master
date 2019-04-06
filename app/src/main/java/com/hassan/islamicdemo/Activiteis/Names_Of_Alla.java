package com.hassan.islamicdemo.Activiteis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.hassan.islamicdemo.R;


public class Names_Of_Alla extends AppCompatActivity {

    GridView gridView;
    int[] fruitImages = {R.drawable.a_0, R.drawable.a_1, R.drawable.a_2,
                         R.drawable.a_3, R.drawable.a_4, R.drawable.a_5,

                         R.drawable.a_6, R.drawable.a_7, R.drawable.a_8,
                         R.drawable.a_9, R.drawable.a_10, R.drawable.a_11,

                         R.drawable.a_12, R.drawable.a_13, R.drawable.a_14,
                         R.drawable.a_15, R.drawable.a_16, R.drawable.a_17,

                         R.drawable.a_18, R.drawable.a_19, R.drawable.a_20,
                         R.drawable.a_21, R.drawable.a_22, R.drawable.a_23,

                         R.drawable.a_24, R.drawable.a_25, R.drawable.a_26,
                         R.drawable.a_27, R.drawable.a_28, R.drawable.a_29,

                        R.drawable.a_30, R.drawable.a_31, R.drawable.a_32,
                        R.drawable.a_33, R.drawable.a_34, R.drawable.a_35,

                        R.drawable.a_36, R.drawable.a_37, R.drawable.a_38,
                        R.drawable.a_9, R.drawable.a_10, R.drawable.a_11,

                        R.drawable.a_39, R.drawable.a_40, R.drawable.a_41,
                        R.drawable.a_42, R.drawable.a_43, R.drawable.a_44,

                        R.drawable.a_45, R.drawable.a_46, R.drawable.a_47,
                        R.drawable.a_48, R.drawable.a_49, R.drawable.a_50,

                        R.drawable.a_51, R.drawable.a_52, R.drawable.a_53,
                        R.drawable.a_54, R.drawable.a_55, R.drawable.a_56,

                        R.drawable.a_57, R.drawable.a_58, R.drawable.a_59,
                        R.drawable.a_3, R.drawable.a_4, R.drawable.a_5,

                        R.drawable.a_60, R.drawable.a_61, R.drawable.a_62,
                        R.drawable.a_63, R.drawable.a_64, R.drawable.a_65,

                        R.drawable.a_66, R.drawable.a_67, R.drawable.a_68,
                        R.drawable.a_15, R.drawable.a_16, R.drawable.a_17,

                        R.drawable.a_69, R.drawable.a_70, R.drawable.a_71,
                        R.drawable.a_72, R.drawable.a_73, R.drawable.a_74,

                        R.drawable.a_75, R.drawable.a_76, R.drawable.a_77,
                        R.drawable.a_78, R.drawable.a_79, R.drawable.a_80,

                        R.drawable.a_81, R.drawable.a_82, R.drawable.a_83,
                        R.drawable.a_84, R.drawable.a_85, R.drawable.a_86,

                        R.drawable.a_87, R.drawable.a_88, R.drawable.a_89,
                        R.drawable.a_90, R.drawable.a_91, R.drawable.a_92,

                        R.drawable.a_93, R.drawable.a_94, R.drawable.a_95,
                        R.drawable.a_96, R.drawable.a_97, R.drawable.a_98,

                         };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names__of__alla);

        //finding listview
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);



    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount()
        {
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

            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            ImageView image = view1.findViewById(R.id.images);
            image.setImageResource(fruitImages[i]);
            return view1;



        }
    }
}
