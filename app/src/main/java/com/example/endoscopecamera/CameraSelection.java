package com.example.endoscopecamera;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class CameraSelection extends AppCompatActivity {
    private CameraManager manager;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_camera);
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            int i =0;
            for (String s : manager.getCameraIdList()) {
                TextView textView = new TextView(this);
                textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setGravity(Gravity.CENTER);
                textView.setHeight(200);
                textView.setWidth(200);
                textView.setText(s);
//                textView.setId(i++);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Toast.makeText(CameraSelection.this, s, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CameraSelection.this,MainActivity.class);
                        intent.putExtra("cameraId",s);
                        startActivity(intent);
                    }
                });
                linearLayout.addView(textView);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }


    }
}
