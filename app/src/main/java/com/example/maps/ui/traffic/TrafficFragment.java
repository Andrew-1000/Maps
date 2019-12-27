package com.example.maps.ui.traffic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.example.maps.R;
import com.example.maps.ui.tools.ToolsViewModel;
import com.mapbox.mapboxsdk.maps.MapView;

public class TrafficFragment extends Fragment {
    private TrafficViewModel trafficViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        trafficViewModel = ViewModelProviders.of(this).get(TrafficViewModel.class);
        View root = inflater.inflate(R.layout.fragment_traffic, container, false);
        final TextView textView = root.findViewById(R.id.text_traffic);
        trafficViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}