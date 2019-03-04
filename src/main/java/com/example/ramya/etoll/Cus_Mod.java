package com.example.ramya.etoll;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Cus_Mod extends AppCompatActivity {

    ArrayList<String> numberList = new ArrayList<>();


    Button Profile,search;
    Spinner from_station, to_station,mode_travel,type_journey;
    TextView distance,time,cost,station1,station2,station3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus__mod);

        distance=findViewById(R.id.distance);
        time=findViewById(R.id.time);
        cost=findViewById(R.id.cost);
        station1=findViewById(R.id.station1);
        station2=findViewById(R.id.station2);
        station3=findViewById(R.id.station3);

        from_station=findViewById(R.id.from_station);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.From, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_station.setAdapter(adapter);

        to_station=findViewById(R.id.to_station);

        ArrayAdapter<CharSequence> to_adapter = ArrayAdapter.createFromResource(this,
                R.array.To, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        to_station.setAdapter(to_adapter);

        mode_travel=findViewById(R.id.mode_travel);

        ArrayAdapter<CharSequence> veh_adapter = ArrayAdapter.createFromResource(this,
                R.array.Veh_Type, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mode_travel.setAdapter(veh_adapter);

        type_journey=findViewById(R.id.type_journey);

        ArrayAdapter<CharSequence> journey_adapter = ArrayAdapter.createFromResource(this,
                R.array.Journey_Type, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_journey.setAdapter(journey_adapter);

        //from_station.setOnItemSelectedListener(Cus_Mod.this);

        search = findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                station1.setVisibility(TextView.GONE);
                station2.setVisibility(TextView.GONE);
                station3.setVisibility(TextView.GONE);

                get_json();
               // Toast.makeText(Cus_Mod.this,"On Click Listener"+String.valueOf(from_station.getSelectedItem()),Toast.LENGTH_LONG).show();
            }
        });


       // from_station.setOnItemSelectedListener(Cus_Mod.this);


        Profile = findViewById(R.id.profile);
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cus_Mod.this,Cus_Wallet.class);
                startActivity(intent);
            }
        });
    }



    public void get_json(){
        String json;
        try {
            InputStream is = getAssets().open("toll.json");
            int size= is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json=new String(buffer,"UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i=0;i<jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);

                if (Boolean.valueOf(from_station.getSelectedItem().equals(obj.getString("from")))
                        && Boolean.valueOf(to_station.getSelectedItem().equals(obj.getString("to")))
                        && Boolean.valueOf(mode_travel.getSelectedItem().equals(obj.getString("mode")))
                        && Boolean.valueOf(type_journey.getSelectedItem().equals(obj.getString("journey")))){
                    distance.setText(obj.getString("distance"));
                    time.setText(obj.getString("time"));
                    cost.setText(obj.getString("charges"));


                    if (obj.getString("station1").equals("")){
                        station1.setVisibility(TextView.GONE);
                    }else{
                        station1.setVisibility(TextView.VISIBLE);
                        station1.setText(obj.getString("station1"));
                    }


                    if (obj.getString("station2").equals("")){
                        station2.setVisibility(TextView.GONE);
                    }else{
                        station2.setVisibility(TextView.VISIBLE);
                        station2.setText(obj.getString("station2"));
                    }


                    if (obj.getString("station3").equals("")){
                        station3.setVisibility(TextView.GONE);
                    }else{
                        station3.setVisibility(TextView.VISIBLE);
                        station3.setText(obj.getString("station3"));
                    }

                }

                /*if (obj.getString("from").equals("Tambaram")){
                    numberList.add(obj.getString("to"));

                }*/

            }

           // Toast.makeText(getApplicationContext(),numberList.toString(),Toast.LENGTH_LONG).show();


        } catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();

        }

    }
}
