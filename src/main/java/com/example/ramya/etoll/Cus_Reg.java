package com.example.ramya.etoll;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.jar.Manifest;

public class Cus_Reg extends AppCompatActivity {
    //private static String cus_reg;
  //  private static final String TAG =cus_reg ;
    //private static final String TAG = Cus_Reg;
    Button sel_photo, sel_rc, sel_kyc, up_photo, up_rc, up_kyc,reg_btn;
    TextView photo_name, rc_name, kyc_name;

    EditText fname,lname,mob,email,address,veh_no,password;
    Spinner vehicle_type;

    private ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;
    FirebaseStorage storage;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus__reg);

        progressDialog = new ProgressDialog(this);

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

        fname = (EditText)findViewById(R.id.ed_fname);
        lname = (EditText)findViewById(R.id.ed_lname);
        address = (EditText)findViewById(R.id.ed_address);
        mob = (EditText)findViewById(R.id.ed_mobno);
        email = (EditText)findViewById(R.id.ed_email);
        veh_no = (EditText)findViewById(R.id.ed_veh_no);
        password = (EditText)findViewById(R.id.ed_password);

        vehicle_type = (Spinner) findViewById(R.id.sp_veh_type);

        sel_rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });




        reg_btn.setOnClickListener(new View.OnClickListener() {
           

            @Override
            public void onClick(View v) {
               // Log.d(TAG,"pressed");
                //registerUser();


                Intent intent = new Intent(Cus_Reg.this,Cus_Mod.class);
                startActivity(intent);
            }
        });
    }
/*
    private void registerUser() {

        String mfname = fname.getText().toString().trim();
        String mlname = lname.getText().toString().trim();
        String maddress = address.getText().toString().trim();
        String mmob = mob.getText().toString().trim();
        String memail = email.getText().toString().trim();
        String mveh_no = veh_no.getText().toString().trim();
        String mpassword = password.getText().toString().trim();

        String mveh_type = vehicle_type.getSelectedItem().toString().trim();

        if (TextUtils.isEmpty(mfname)){
            Toast.makeText(this,"Enter Value",Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(mlname)){
            Toast.makeText(this,"Enter Value",Toast.LENGTH_LONG).show();
            return;

        }
        if (TextUtils.isEmpty(maddress)){
            Toast.makeText(this,"Enter Value",Toast.LENGTH_LONG).show();
            return;

        }
        if (TextUtils.isEmpty(mmob)){
            Toast.makeText(this,"Enter Value",Toast.LENGTH_LONG).show();
            return;

        }
        if (TextUtils.isEmpty(memail)){
            Toast.makeText(this,"Enter Value",Toast.LENGTH_LONG).show();
            return;

        }
        if (TextUtils.isEmpty(mveh_no)){
            Toast.makeText(this,"Enter Value",Toast.LENGTH_LONG).show();
            return;

        }
        if (TextUtils.isEmpty(mveh_type)){
            Toast.makeText(this,"Enter Value",Toast.LENGTH_LONG).show();
            return;

        }if (TextUtils.isEmpty(mpassword)){
            Toast.makeText(this,"Enter Value",Toast.LENGTH_LONG).show();
            return;

        }


        progressDialog.setMessage("Registering User....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(mmob,mpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Cus_Reg.this,"Registered Successfully",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(Cus_Reg.this,"Could not Register",Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }*/
}
