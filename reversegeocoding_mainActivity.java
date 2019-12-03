package com.prakruti.reversegeocoding;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
TextView addressorloc;
EditText lat,lon;
Button check;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressorloc = (TextView) findViewById(R.id.address);
        lat = (EditText) findViewById(R.id.Lat);
        lon = (EditText) findViewById(R.id.Lon);

        check =(Button) findViewById(R.id.btn);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lat.getText().equals("") || lon.getText().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Invalid Longitude and Lattitude", Toast.LENGTH_SHORT).show();

                }
                else {
                    double latitude = Double.parseDouble(lat.getText().toString());
                    double longitude = Double.parseDouble(lon.getText().toString());
                    Geocoder gc = new Geocoder(getApplicationContext(), Locale.getDefault());
                    if (gc.isPresent()) {
                        try {

                            List<Address> list = gc.getFromLocation(latitude,longitude,1);
                            Address address = list.get(0);
                            StringBuffer getadd = new StringBuffer();
                            getadd.append("Name: "+address.getLocality()+"\n");
                            getadd.append("Subadmin area: "+address.getSubAdminArea()+"\n");
                            getadd.append("Admin area: "+address.getAdminArea()+"\n");
                            getadd.append("Country Name: "+address.getCountryName()+"\n");
                            getadd.append("CC: "+address.getCountryCode()+"\n");
                            String fetchall = getadd.toString();
                            addressorloc.setText(fetchall);
                            Toast.makeText(getApplicationContext(),fetchall,Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
        });





    }
}
