package com.zy.open.videocontroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.zy.open.videocontroller.view.ControllersView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ControllersView(this));
    }
}