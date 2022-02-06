package com.example.mapsapi;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    Button botonIr;
    Button botonIn;
    Button botonOut;
    Button botonSatelite;

    EditText latitud;
    EditText longitud;

    TextView textitoZoom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        botonIr = this.findViewById(R.id.btnIr);
        botonIn = this.findViewById(R.id.btnIn);
        botonOut = this.findViewById(R.id.btnOut);
        botonSatelite = this.findViewById(R.id.btnSatelite);

        latitud = this.findViewById(R.id.txtLatitud);
        longitud = this.findViewById(R.id.txtLongitud);

        textitoZoom = this.findViewById(R.id.txtZoom);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        botonIr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String Latitud = latitud.getText().toString();
                String Longitud= longitud.getText().toString();

                LatLng lugar = new LatLng(Double.valueOf(Latitud), Double.valueOf(Longitud));
                mMap.addMarker(new MarkerOptions().position(lugar).title("Marker in Ubiqeishon"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(lugar));
            }
        });

        botonIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mMap.moveCamera(CameraUpdateFactory.zoomIn());
                textitoZoom.setText("Zoom: " + mMap.getCameraPosition().zoom);
            }
        });

        botonOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mMap.moveCamera(CameraUpdateFactory.zoomOut());
                textitoZoom.setText("Zoom: " + mMap.getCameraPosition().zoom);
            }
        });

        botonSatelite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                mMap.getUiSettings().setZoomControlsEnabled(true);
            }
        });
    }

    public void onClick(View v) {

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


}
