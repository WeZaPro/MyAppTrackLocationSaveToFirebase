package com.example.myapptracklocationsavetofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

public class StreetViewActivity extends AppCompatActivity {

    double lati, longti;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);

        Bundle bundle = getIntent().getExtras();
        lati = bundle.getDouble("lati");
        longti = bundle.getDouble("longti");
        //Toast.makeText(this,"longti : "+longti+"lati : "+lati,Toast.LENGTH_SHORT).show();

        final LatLng currentLocation = new LatLng(longti, lati);

        SupportStreetViewPanoramaFragment streetViewPanoramaFragment = (SupportStreetViewPanoramaFragment) getSupportFragmentManager().findFragmentById(R.id.streetviewpanorama);

        streetViewPanoramaFragment.getStreetViewPanoramaAsync(new OnStreetViewPanoramaReadyCallback() {
            @Override
            public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {
                // Only set the panorama to SYDNEY on startup (when no panoramas have been
                // loaded which is when the savedInstanceState is null).
                if (savedInstanceState == null) {
                    panorama.setPosition(currentLocation);
                }
            }
        });
    }
}
