package com.example.maps;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.Layer;

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
            public void onMapReady(@NonNull final MapboxMap mapboxMap) {
              mapboxMap.setStyle(Style.TRAFFIC_DAY, new Style.OnStyleLoaded() {
                  @Override
                  public void onStyleLoaded(@NonNull Style style) {



                      mapboxMap.addMarker(new MarkerOptions()
                            .position(new LatLng(-1.252908, 36.947694))

                            .title("This is Home!")
                            .snippet("Welcome, hope to see you soon")
                      );

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
    public void onBackPressed(){
        backPressed();
        Toast.makeText(this,"Back key pressed", Toast.LENGTH_LONG).show();
    }

    private void backPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);

    }
}
