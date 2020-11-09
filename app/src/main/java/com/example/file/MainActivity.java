package com.example.file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    public static String FileName ="qxra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                    FileOutputStream fileOutputStream = openFileOutput(FileName, MODE_PRIVATE);
                    out = new BufferedOutputStream(fileOutputStream);
                    String content = "stuNum:20180111394\n stuName:zhengnaying";
                    try {
                        out.write(content.getBytes(StandardCharsets.UTF_8));
                    } finally {
                        if (out != null)
                            out.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream in = null;
                try{
                    FileInputStream fileInputStream = openFileInput(FileName);
                    in = new BufferedInputStream(fileInputStream);
                    int c;
                    StringBuilder builder = new StringBuilder("");
                    try {
                        while ((c = in.read()) != -1) {
                            builder.append((char) c);
                        }
                        Toast.makeText(MainActivity.this,builder.toString(),Toast.LENGTH_LONG).show();
                    } finally {
                        if(in!=null)
                            in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}