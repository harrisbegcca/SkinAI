package com.ai.shadowcipher.projectai;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Bitmap mImageBitmap;
    private String mCurrentPhotoPath;
    private ImageView mImageView;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        public static final String TAG = "Hello";

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(i,20);
                    return true;
            }
            return true;
        }


    };
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode,resultCode, data);

            if(requestCode == 20 && resultCode==RESULT_OK && data!=null)
            {
                Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                mImageView.setImageBitmap(bitmap);
                //mImageView.setMaxHeight(20);
            }



        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            mImageView = (ImageView) findViewById(R.id.imageView);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mTextMessage = (TextView) findViewById(R.id.message);
            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        }


}

