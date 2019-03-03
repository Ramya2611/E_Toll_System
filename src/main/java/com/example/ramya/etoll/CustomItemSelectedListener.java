package com.example.ramya.etoll;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;


public class CustomItemSelectedListener extends Activity implements AdapterView.OnItemSelectedListener {


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

      //  from_station.setOnItemSelectedListener(this);

        Toast.makeText(parent.getContext(),"ans"+parent.getItemAtPosition(pos).toString(),Toast.LENGTH_LONG).show();
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}