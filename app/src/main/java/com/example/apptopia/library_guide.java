package com.example.apptopia;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class library_guide extends AppCompatActivity {
    Button library_floorguide_btn, library_usetime_btn, library_notifi_btn, library_intro_btn;
    LinearLayout library_floorGuide, library_useTIme, library_useNotifi, library_intro;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_guide);

        //findViewById --> ViewBinding 교체 예정

        library_floorguide_btn = findViewById(R.id.library_floorguide_btn);
        library_usetime_btn = findViewById(R.id.library_usetime_btn);
        library_notifi_btn = findViewById(R.id.library_notifi_btn);
        library_intro_btn = findViewById(R.id.library_intro_btn);

        library_floorGuide = findViewById(R.id.library_floorGuide);
        library_useTIme = findViewById(R.id.library_useTime);
        library_useNotifi = findViewById(R.id.library_useNotifi);
        library_intro = findViewById(R.id.library_intro);

        LinearLayout views[] = {library_floorGuide,library_useTIme,library_useNotifi,library_intro};
        Button buttons[] = {library_floorguide_btn,library_usetime_btn, library_notifi_btn, library_intro_btn};
        library_floorguide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showView(views,buttons,0);
            }
        });
        library_usetime_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showView(views,buttons,1);
            }
        });
        library_notifi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showView(views,buttons,2);
            }
        });
        library_intro_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showView(views,buttons,3);
            }
        });


    }
    private void showView(View[] views,Button[] buttons, int index) {
        for (int i = 0; i < 4; i++) {
            if (i == index) {
                views[i].setVisibility(View.VISIBLE);
                buttons[i].setBackgroundTintList(ColorStateList.valueOf(Color.rgb(128,128,128)));
                buttons[i].setTextColor(Color.WHITE);
            } else {
                views[i].setVisibility(View.GONE);
                buttons[i].setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                buttons[i].setTextColor(Color.BLACK);
            }
        }
    }

}

