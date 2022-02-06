package com.example.localizacion;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ResourceBundle;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener, View.OnClickListener {

    private GoogleMap mMap;

    LocationManager locationManager;
    int minTime = 60000;
    int minDistance = 1;
    String provider1 = LocationManager.GPS_PROVIDER;
    String provider2 = LocationManager.NETWORK_PROVIDER;
    String provider;
    Button boton1,boton2,boton3;
    TextView tv, tvl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        tv = findViewById(R.id.textView);
        tvl = findViewById(R.id.textViewl);

        boton1 = findViewById(R.id.button1);
        boton2 = findViewById(R.id.button2);
        boton3 = findViewById(R.id.button3);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        provider = provider2;
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

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        float maxzoom = mMap.getMaxZoomLevel();
        float initZoom = (float) (0.95 * maxzoom);

        mMap.animateCamera(CameraUpdateFactory.zoomTo(initZoom));

    }

    void localiza() {
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            Location location = locationManager.getLastKnownLocation(provider);
            if (location != null) {
                tv.append("\nProvider : " + provider);
                double latitud = location.getLatitude();
                double longitud = location.getLongitude();
                tv.append("\nLatitud: " + latitud);
                tv.append("\nLongitud: " + longitud);
                LatLng lugar = new LatLng(latitud, longitud);
                mMap.addMarker(new MarkerOptions().position(lugar));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(lugar));
                //mapView.invalídate();
            }
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(provider, minTime, minDistance, this);
            localiza();
        }



    }

    @Override
    public void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    /*@Override
    protected boolean isRouteDisplayed() {
        return false;
    }*/

    @Override
    public void onLocationChanged(Location location) {
        tv.append("\nLocation changed1");
        localiza();
    }

    @Override
    public void onProviderDisabled(String provider) {
        locationManager.removeUpdates(this);
    }

    @Override
    public void onProviderEnabled(String provider) {
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(provider, minTime, minDistance, this);
            localiza();
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        if (status == LocationProvider.AVAILABLE)
            tv.append("\nStatus changed: AVAILABLE");
        if (status == LocationProvider.OUT_OF_SERVICE)
            tv.append("\nStatus changed: OUT OF SERVICE");
        if (status == LocationProvider.TEMPORARILY_UNAVAILABLE)
            tv.append("\nStatus changed: TEMPORARILY UNAVAILABLE");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button1)
            provider = provider1;
        else if (id == R.id.button2)
            provider = provider2;
        else {
            Criteria criteria = new Criteria();
            provider = locationManager.getBestProvider(criteria, true);
        }
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationProvider locationProvider = locationManager.getProvider(provider);
            tv.append("\nProvider Accuracy= " + locationProvider.getAccuracy());
            tvl.setText(provider);

            locationManager.requestLocationUpdates(provider, minTime, minDistance, this);
            localiza ();
        }

    }


}
