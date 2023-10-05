package com.example.apptopia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class fragment_change extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private fragment_main fragment_main;
    private fragment_library fragment_library;
    private fragment_profile fragment_profile;
    private fragment_seat fragment_seat;
    private FragmentTransaction transaction;
    private ListView mListView;
    private SlidingUpPanelLayout slidePanel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);

        ImageButton mainpage_btn = findViewById(R.id.mainpage_btn);
        ImageButton profilepage_btn = findViewById(R.id.profilepage_btn);
        ImageButton librarypage_btn = findViewById(R.id.librarypage_btn);
        ImageButton seatpage_btn = findViewById(R.id.seatpage_btn);

        fragmentManager = getSupportFragmentManager();

        fragment_main = new fragment_main();
        fragment_profile = new fragment_profile();
        fragment_seat = new fragment_seat();
        fragment_library = new fragment_library();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout, fragment_main).commitAllowingStateLoss();

        mainpage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.framelayout, fragment_main).commit();
            }
        });
        profilepage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.framelayout, fragment_profile).commit();
            }
        });
        librarypage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.framelayout, fragment_library).commit();
            }
        });
        seatpage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.framelayout, fragment_seat).commit();
            }
        });


        // 슬라이딩 패널 이벤트
        slidePanel = findViewById(R.id.mainpage_slide);
        ImageButton list_btn = findViewById(R.id.list_icon);

        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlidingUpPanelLayout.PanelState state = slidePanel.getPanelState();
                if (state == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                    slidePanel.setPanelState(SlidingUpPanelLayout.PanelState.ANCHORED);
                }
            }
        });


        /* 위젯과 멤버변수 참조 획득 */
        mListView = (ListView) findViewById(R.id.listview);
        /* 아이템 추가 및 어댑터 등록 */
        dataSetting();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent1 = new Intent(getApplicationContext(), notifi_board.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getApplicationContext(), freewrite_board.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(getApplicationContext(), library_guide.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(getApplicationContext(), login_page.class);
                        startActivity(intent4);
                }
            }
        });

    }

    private void dataSetting() {

        slideList_Adapter mMyAdapter = new slideList_Adapter();


        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.notifi_board), "공지사항");
            }
            if (i == 1) {
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.freeboard), "자유게시판");
            }
            if (i == 2) {
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.library_noti), "도서관 이용안내");
            }
            if (i == 3) {
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.logout), "로그아웃");
            }
        }
        mListView.setAdapter(mMyAdapter);

    }
}
