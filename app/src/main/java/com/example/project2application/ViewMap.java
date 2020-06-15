package com.example.project2application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class ViewMap extends FragmentActivity implements OnMapReadyCallback {
        GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng tester = new LatLng(24.242484,55.719130);
        LatLng tester2 = new LatLng(24.242562,55.702666);
        LatLng tester3 = new LatLng(24.234014,55.719415);
        LatLng tester4 = new LatLng(24.233545,55.706211);

        //LatLng faker = new LatLng(24.200109,55.663259);
        //Northeast
        //double test1 = Double.valueOf(sndCommandsPage.getmNELATT());
        //double test2 = Double.valueOf(sndCommandsPage.getmNELNGG());
        //Northwest
        //double test3 = Double.valueOf(sndCommandsPage.getmNWLATT());
        //double test4 = Double.valueOf(sndCommandsPage.getmNWLNGG());
        //Southeast
        //double test5 = Double.valueOf(sndCommandsPage.getmSELATT());
        //double test6 = Double.valueOf(sndCommandsPage.getmSELNGG());
        //Southwest
        //double test7 = Double.valueOf(sndCommandsPage.getmSWLATT());
        //double test8 = Double.valueOf(sndCommandsPage.getmSWLNGG());
        //LatLng objects
        //LatLng tester = new LatLng(test1, test2);
        //LatLng tester2 = new LatLng(test3,test4);
        //LatLng tester3 = new LatLng(test5,test6);
        //LatLng tester4 = new LatLng(test7,test8);

        map.addMarker(new MarkerOptions().position(tester).title("NorthEast"));
        map.addMarker(new MarkerOptions().position(tester2).title("NorthWest"));
        map.addMarker(new MarkerOptions().position(tester3).title("SouthEast"));
        map.addMarker(new MarkerOptions().position(tester4).title("SouthWest"));
        //map.addMarker(new MarkerOptions().position(faker).title("Current loc"));
        map.moveCamera(CameraUpdateFactory.newLatLng(tester));
        //map.addPolyline( new PolylineOptions().add(tester,tester2,tester4,tester3,tester).width(12f).color(Color.RED) );
        // 0x35ff0000 ------- 35% transparency ------- ff00000 hex color
        map.addPolygon( new PolygonOptions().add(tester, tester2, tester4, tester3, tester).fillColor(0x35ff0000));
    }
}
