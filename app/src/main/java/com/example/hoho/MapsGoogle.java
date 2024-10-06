package com.example.hoho;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsGoogle extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap myMap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_google);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap = googleMap;

        // Add scrap yard locations with markers
        LatLng scrapYard1 = new LatLng(28.6139, 77.2090); // Connaught Place
        myMap.addMarker(new MarkerOptions().position(scrapYard1).title("Scrap Yard 1: Delhi Auto Salvage"));

        LatLng scrapYard2 = new LatLng(28.7041, 77.1025); // New Delhi
        myMap.addMarker(new MarkerOptions().position(scrapYard2).title("Scrap Yard 2: NCR Scrap Traders"));

        LatLng scrapYard3 = new LatLng(28.5365, 77.1758); // Noida
        myMap.addMarker(new MarkerOptions().position(scrapYard3).title("Scrap Yard 3: Noida Recyclers"));

        LatLng scrapYard4 = new LatLng(28.4595, 77.0266); // Gurugram
        myMap.addMarker(new MarkerOptions().position(scrapYard4).title("Scrap Yard 4: Gurugram Parts Hub"));

        LatLng scrapYard5 = new LatLng(28.4082, 77.3179); // Ghaziabad
        myMap.addMarker(new MarkerOptions().position(scrapYard5).title("Scrap Yard 5: Ghaziabad Auto Salvage"));

        LatLng scrapYard6 = new LatLng(28.6012, 77.3010); // Faridabad
        myMap.addMarker(new MarkerOptions().position(scrapYard6).title("Scrap Yard 6: Faridabad Scrap Center"));

        LatLng scrapYard7 = new LatLng(28.4112, 77.0517); // Meerut
        myMap.addMarker(new MarkerOptions().position(scrapYard7).title("Scrap Yard 7: Meerut Parts Warehouse"));

        LatLng scrapYard8 = new LatLng(28.5355, 77.3910); // Sonipat
        myMap.addMarker(new MarkerOptions().position(scrapYard8).title("Scrap Yard 8: Sonipat Auto Parts"));

        LatLng scrapYard9 = new LatLng(28.6742, 77.0500); // Panipat
        myMap.addMarker(new MarkerOptions().position(scrapYard9).title("Scrap Yard 9: Panipat Recyclers"));

        LatLng scrapYard10 = new LatLng(28.6519, 77.2415); // Aligarh
        myMap.addMarker(new MarkerOptions().position(scrapYard10).title("Scrap Yard 10: Aligarh Salvage Yard"));

        LatLng scrapYard11 = new LatLng(28.8353, 77.0945); // Hapur
        myMap.addMarker(new MarkerOptions().position(scrapYard11).title("Scrap Yard 11: Hapur Auto Salvage"));

        LatLng scrapYard12 = new LatLng(28.7882, 77.4602); // Khurja
        myMap.addMarker(new MarkerOptions().position(scrapYard12).title("Scrap Yard 12: Khurja Parts Depot"));

        LatLng scrapYard13 = new LatLng(28.6812, 77.2246); // Bhiwani
        myMap.addMarker(new MarkerOptions().position(scrapYard13).title("Scrap Yard 13: Bhiwani Salvage Center"));

        LatLng scrapYard14 = new LatLng(28.6680, 76.9852); // Rohtak
        myMap.addMarker(new MarkerOptions().position(scrapYard14).title("Scrap Yard 14: Rohtak Auto Parts"));

        LatLng scrapYard15 = new LatLng(28.6013, 77.2490); // Ballabgarh
        myMap.addMarker(new MarkerOptions().position(scrapYard15).title("Scrap Yard 15: Ballabgarh Scrap Hub"));

        LatLng scrapYard16 = new LatLng(28.5633, 77.0872); // Sonepat
        myMap.addMarker(new MarkerOptions().position(scrapYard16).title("Scrap Yard 16: Sonepat Auto Salvage"));

        LatLng scrapYard17 = new LatLng(28.6095, 76.8404); // Jhajjar
        myMap.addMarker(new MarkerOptions().position(scrapYard17).title("Scrap Yard 17: Jhajjar Recyclers"));

        LatLng scrapYard18 = new LatLng(28.6010, 77.4893); // Dadri
        myMap.addMarker(new MarkerOptions().position(scrapYard18).title("Scrap Yard 18: Dadri Auto Parts"));

        LatLng scrapYard19 = new LatLng(28.5404, 76.8445); // Nuh
        myMap.addMarker(new MarkerOptions().position(scrapYard19).title("Scrap Yard 19: Nuh Salvage Yard"));

        LatLng scrapYard20 = new LatLng(28.5441, 76.9811); // Manesar
        myMap.addMarker(new MarkerOptions().position(scrapYard20).title("Scrap Yard 20: Manesar Parts Depot"));

        // Optionally, move the camera to the first scrap yard location
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(scrapYard1, 10)); // Adjust the zoom level as needed
    }
}
