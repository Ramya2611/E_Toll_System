package com.example.ramya.etoll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Reg extends AppCompatActivity {

    Button ad_reg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__reg);

        ad_reg_btn = findViewById(R.id.ad_reg_btn);

        ad_reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Reg.this,Admin_Module.class);
                startActivity(intent);
            }
        });
    }
}
