package com.example.geocodificacion;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Iterator;
import java.util.List;
import java.lang.Object;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener, AdapterView.OnItemSelectedListener {

    private GoogleMap mMap;

    EditText editText;
    Spinner spinner;
    int nmax=20;
    int resource=android.R.layout.simple_spinner_item;
    ArrayAdapter<String> adapter;
    String[] spinnerArray;
    String[] result=new String[nmax];
    double[] latitud=new double[nmax];
    double[] longitud=new double[nmax];
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        tv=findViewById(R.id.textView);
        editText=findViewById(R.id.editText1);
        Button boton=findViewById(R.id.buttonl);
        boton.setOnClickListener(this);

        spinner=findViewById(R.id.spinnerl);
        spinner.setPrompt("Mostrar mapa");
        spinnerArray=new String[1];
        spinnerArray[0]="Isla Elephanta Bombay, India";
        adapter=new ArrayAdapter<>(this,resource,spinnerArray);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        latitud[0]=18.963223;
        longitud[0]=72.9314073;


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

    @Override
    public void onClick(View v) {
        try {
            String busqueda = editText.getText().toString();
            Geocoder geocoder=new Geocoder(this);
            List<Address> list=geocoder.getFromLocationName(busqueda, 5);
            Iterator<Address> iterator= list.iterator();
            int n=0;
            Address address;
            while(iterator.hasNext()) {
                address=iterator.next();
                result[n]=address.getAddressLine(0);
                n++;
            }
            spinnerArray=new String[n] ;
            for(int i=0; i<n; i++){
                spinnerArray[i]=result[i];
            }
            adapter = new ArrayAdapter<>(this, resource, spinnerArray);
            spinner.setAdapter(adapter);
        }catch(Exception e){
            Toast.makeText(this, "Error en la búsqueda", Toast.LENGTH_LONG).show();
        }
    }

    /*@Override
    protected boolean isRouteDisplayed() {
        return false;
    }*/

    @Override
    public void onItemSelected(AdapterView<?> arg0, View argl, int arg2,long arg3) {
        int lat=(int) (latitud[arg2]*1e6);
        int lon=(int) (longitud[arg2]*1e6);
        mMap.moveCamera(CameraUpdateFactory.zoomBy(14));
        LatLng lugar = new LatLng(Double.valueOf(lat), Double.valueOf(lon));
        mMap.addMarker(new MarkerOptions().position(lugar).title("Marker in Ubiqeishon"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lugar));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        tv.setText(spinnerArray[arg2]);
        tv.append("\n"+latitud[arg2]+","+longitud[arg2]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> argO) { }


}
