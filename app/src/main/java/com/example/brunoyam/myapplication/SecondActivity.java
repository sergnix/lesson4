package com.example.brunoyam.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //new  MainActivity();
        LinearLayout ll_root = new LinearLayout(this);
        ll_root.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout top_half;
        LinearLayout bottom_half;
        TextView input;
        TextView res;

        View.OnClickListener listen = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        };
        setContentView(ll_root);
    }
}
