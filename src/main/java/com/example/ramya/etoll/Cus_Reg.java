package com.example.ramya.etoll;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.jar.Manifest;

public class Cus_Reg extends AppCompatActivity {

    Button sel_photo, sel_rc, sel_kyc, up_photo, up_rc, up_kyc,reg_btn;
    TextView photo_name, rc_name, kyc_name;

    FirebaseStorage storage;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus__reg);

        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

        sel_photo = findViewById(R.id.sel_photo);
        sel_rc = findViewById(R.id.sel_rc);
        sel_kyc = findViewById(R.id.sel_kyc);


        reg_btn = findViewById(R.id.reg_btn);

        up_photo = findViewById(R.id.upl_photo);
        up_rc = findViewById(R.id.upl_rc);
        up_kyc = findViewById(R.id.upl_kyc);

        photo_name = findViewById(R.id.photo_name);
        rc_name = findViewById(R.id.rc_name);
        kyc_name = findViewById(R.id.kyc_name);

        sel_rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });




        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cus_Reg.this,Cus_Mod.class);
                startActivity(intent);
            }
        });
    }
}
