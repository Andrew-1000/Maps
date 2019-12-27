package com.example.maps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
public class MapsActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Mapbox.getInstance(this, "pk.eyJ1IjoiYW5kcmV3MTAwMDAiLCJhIjoiY2s0MHl2NjlsMDZmMjNscGY4OGJ2cWMxayJ9.az_HB4TQxDoywQMl05gisA");
        setContentView(R.layout.activity_maps);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
              mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                  @Override
                  public void onStyleLoaded(@NonNull Style style) {

                  }
              });
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onPause(){
        super.onPause();
        mapView.onPause();
    }
    @Override
    public void onStop(){
        super.onStop();
        mapView.onStop();
    }
    @Override
    public void onLowMemory(){
        super.onLowMemory();
        mapView.onLowMemory();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);

    }
}
