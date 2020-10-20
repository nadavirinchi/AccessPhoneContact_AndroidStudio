package com.example.accessphonecontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CALL = 1;
    private static String[] PERMISSIONS = {Manifest.permission.CALL_PHONE};
    public static void Checkifcancall(Activity activity){
        int permission = ActivityCompat.checkSelfPermission(activity,Manifest.permission.CALL_PHONE);
        if (permission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity,PERMISSIONS,CALL);
        }
    }

    Button btnopenudemy;
    Button btnsearchgoogle;
    Button btncall;
    Button btnaccessdialpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Checkifcancall(MainActivity.this);
        btnopenudemy = findViewById(R.id.btnopenudemy);
        btnsearchgoogle = findViewById(R.id.btnsearchgooley);
        btncall = findViewById(R.id.btncallsomeone);
        btnaccessdialpad = findViewById(R.id.btnaccessdialpad);

        btnopenudemy.setOnClickListener(MainActivity.this);
        btnsearchgoogle.setOnClickListener(MainActivity.this);
        btncall.setOnClickListener(MainActivity.this);
        btnaccessdialpad.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnopenudemy:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.udemy.com"));
                startActivity(intent);
                break;
            case R.id.btnsearchgooley:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://www.google.com"));
                startActivity(intent1);
                break;
            case R.id.btncallsomeone:
                if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},CALL);
                }
                else {
                    Intent intent2 = new Intent(Intent.ACTION_CALL);
                    intent2.setData(Uri.parse("tel:9573178484"));
                    startActivity(intent2);
                }
                break;
            case R.id.btnaccessdialpad:
                Intent intent3 = new Intent(Intent.ACTION_DIAL);
                startActivity(intent3);
                break;
        }
    }
}