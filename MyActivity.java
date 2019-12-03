package com.example.hp.geocoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MyActivity extends Activity {
    EditText edit;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        edit = (EditText) findViewById(R.id.editText);
        text = (TextView) findViewById(R.id.textView);

        Button findBtn = (Button) findViewById(R.id.button_find);

        findBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String address = edit.getText().toString();

                Geocoder geoCoder = new Geocoder(getApplicationContext());

                try {
                    List<Address> locations = geoCoder.getFromLocationName(
                            address, 1);

                    for (Address a : locations) {
                        double latti = a.getLatitude();
                        double longi = a.getLongitude();

                        text.append(latti + "," + longi);
                    }

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

    }
}