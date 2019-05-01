package com.example.travelo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapSouthActivity extends FragmentActivity implements OnMapReadyCallback , View.OnClickListener {

    private GoogleMap sMap;
    Button buttonNormal;
    Button buttonSatellite;
    Button buttonHybrid;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        buttonNormal = (Button) findViewById(R.id.buttonNormal);
        buttonSatellite = (Button) findViewById(R.id.buttonSatellite);
        buttonHybrid = (Button) findViewById(R.id.buttonHybrid);

        buttonNormal.setOnClickListener(this);
        buttonSatellite.setOnClickListener(this);
        buttonHybrid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSatellite:
                sMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.buttonHybrid:
                sMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            default:
                sMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
        }

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
        sMap = googleMap;


        //NortMap
        LatLng S1 = new LatLng(10.021236, 99.071540);
        sMap.addMarker(new MarkerOptions().position(S1).title("Marker in Sydney").snippet("Hello Sydney"));

        LatLng S2 = new LatLng(9.897583, 99.113939);
        sMap.addMarker(new MarkerOptions().position(S2).title("My Home").snippet("Hello my home"));

        LatLng centerS = new LatLng(10.522706, 100.556103);
        sMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerS, 8));


        sMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter()  {


            @Override
            // Return null here, so that getInfoContents() is called next.
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                // Inflate the layouts for the info window, title and snippet.
                View infoWindow = getLayoutInflater().inflate(R.layout.custom_info_contents, null);


                TextView title = ((TextView) infoWindow.findViewById(R.id.textViewName));
                title.setText(marker.getTitle());


                TextView snippet = ((TextView) infoWindow.findViewById(R.id.textViewSnippet));
                snippet.setText(marker.getSnippet());

                ImageView imageView = (ImageView) infoWindow.findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.ic_city);

                if ("My Home".equals(marker.getTitle())) {
                    imageView.setImageResource(R.drawable.ic_home);
                }

                return infoWindow;
            }

        });


    }
}
