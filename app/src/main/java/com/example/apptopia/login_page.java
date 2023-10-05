package com.example.apptopia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class login_page extends AppCompatActivity {
    Button btn_login;
    EditText text_id, text_pw;
    Integer id;
    String pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        btn_login = findViewById(R.id.btn_login);

        text_id = findViewById(R.id.text_id);
        text_pw = findViewById(R.id.text_pw);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id = Integer.parseInt(text_id.getText().toString());
                pw = text_pw.getText().toString();

                if(id == 1 && pw.equals("1")){
                    Intent intent = new Intent(getApplicationContext(), fragment_change.class);
                    startActivity(intent);
                }
            }
        });

    }
}
