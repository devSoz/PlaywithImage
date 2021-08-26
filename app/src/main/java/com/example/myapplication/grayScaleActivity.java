package com.example.myapplication;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class grayScaleActivity extends AppCompatActivity {

    public Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gray_scale);
        imageListener();
    }

    private void imageListener()
    {

        TextView txtSelect = findViewById(R.id.txtClick);
        Button btnUpload = findViewById(R.id.uploadButton);

        txtSelect.setOnClickListener((View view) -> {
            mGetContent.launch("image/*");
        });

        /*btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream is = null;
                try {
                    is = getContentResolver().openInputStream(uri);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                   // uploadProgress.setProgress(10);
                   // uploadProgress.setVisibility(View.VISIBLE);
                    uploadFile(getBytes(is));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/
    }
/*
    public byte[] getBytes(InputStream is) throws IOException
    {
        ByteArrayOutputStream byteBuff = new ByteArrayOutputStream();

        int buffSize = 1024;
        byte[] buff = new byte[buffSize];

        int len = 0;
        while ((len = is.read(buff)) != -1) {
            byteBuff.write(buff, 0, len);
        }

        return byteBuff.toByteArray();
    }*/

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new
                    ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    Log.d("test", "Test");
                    uri = result;
                    ImageView imageView = (ImageView) findViewById(R.id.imageView2);
                    imageView.setImageURI(result);
                }
            });

}