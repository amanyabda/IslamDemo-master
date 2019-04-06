package com.hassan.islamicdemo.Activiteis;

import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.hassan.islamicdemo.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Page_One extends AppCompatActivity implements  View.OnClickListener {
    ImageView imageView1;
    Button save, share, wells;
    private AlertDialog alertDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page__one);


        imageView1 = findViewById(R.id.a2);
        save = findViewById(R.id.save);
        share = findViewById(R.id.share);
        wells = findViewById(R.id.set_wallpaper);

              set_Up_view();
    }

public  void set_Up_view(){
    save.setOnClickListener(this);
    share.setOnClickListener(this);
    wells.setOnClickListener(this);

}
public static Bitmap viewToBitmap(View view, int width, int hight) {
        Bitmap bitmap = Bitmap.createBitmap(width, hight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;


    }

    @Override
    public void onClick(View v) {
        int id =v.getId();
        switch (id){
            case R.id.set_wallpaper: {
                startWall();
                break;
            }
            case R.id.save: {
                alertDialog=new AlertDialog.Builder(this).create();
                alertDialog.setTitle("احفظ الصورة");
                alertDialog.setMessage("هل تريد حفظ الصورة؟");
                alertDialog.setButton("Yas", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                          startSave();
                    }
                });

                alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       alertDialog.dismiss();
                    }
                });
                break;
            }
            case R.id.share: {
                startShare();
                break;
            }
        }
    }

    public void startWall(){
        WallpaperManager wallpaperManager=WallpaperManager.getInstance(getApplicationContext());
        try {
            wallpaperManager.setBitmap(viewToBitmap(imageView1,imageView1.getWidth(),imageView1.getHeight()));
            Toast.makeText(this, "تم بنجاح تعين الصورة كخلفية", Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            e.printStackTrace();
            
            
        }



    }

    public  void startSave(){
        FileOutputStream fileOutputStream=null;
        File file=getDisc();
        if (!file.exists() && !file.mkdirs()){

            Toast.makeText(this, "Can't create dirctory to save image", Toast.LENGTH_SHORT).show();
            return;
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyymmmm");
        String date=simpleDateFormat.format(new Date());
        String name="Img"+date+".jpg";
        String file_name=file.getAbsolutePath()+"/"+name;
        File new_file=new File(file_name);
        try {
            fileOutputStream=new FileOutputStream(new_file);
            Bitmap bitmap=viewToBitmap(imageView1,imageView1.getWidth(),imageView1.getHeight());
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            Toast.makeText(this, "تم حفظ الصورة بنجاح", Toast.LENGTH_SHORT).show();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        refreshGallery(new_file);
    }

    private void refreshGallery(File file) {
        Intent intent=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        sendBroadcast(intent);
    }

       public File getDisc(){
        File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        return new File(file,"ImageDemo");
        }

       public  void  startShare() {
           Intent intent = new Intent(Intent.ACTION_SEND);
           Bitmap bitmap = viewToBitmap(imageView1,imageView1.getWidth(),imageView1.getHeight());;
           try {
               File file = new File(this.getExternalCacheDir(), "qr.png");
               FileOutputStream fileOutputStream = new FileOutputStream(file);
               bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
               fileOutputStream.flush();
               fileOutputStream.close();
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
               intent.setType("image/png");
               startActivity(Intent.createChooser(intent, "مشاركة الصورة عبر"));

           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
}
