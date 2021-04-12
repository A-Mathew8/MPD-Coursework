package com.example.mpd_coursework;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;
import java.util.ArrayList;

public class  MapsFragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }




    }
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap)
        {

            LatLng MullAandB = new LatLng(56.410,-6.210);
            googleMap.addMarker(new MarkerOptions().position(MullAandB).title("Marker in Mull, Argyll and Bute").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(MullAandB));

            LatLng NorthAtlanticOcean = new LatLng(56.607, -10.454);
            googleMap.addMarker(new MarkerOptions().position(NorthAtlanticOcean).title("Marker in North Atlantic Ocean").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(NorthAtlanticOcean));

            LatLng NorthAtlanticOcean2 = new LatLng(56.597, -10.468);
            googleMap.addMarker(new MarkerOptions().position(NorthAtlanticOcean2).title("Marker in North Atlantic Ocean").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(NorthAtlanticOcean2));

            LatLng GosbertonLincolnshire = new LatLng(52.871, -0.255);
            googleMap.addMarker(new MarkerOptions().position(GosbertonLincolnshire).title("Marker in Gosberton, Lincolnshire").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(GosbertonLincolnshire));

            LatLng BlackfordPerth = new LatLng(56.284, -3.759);
            googleMap.addMarker(new MarkerOptions().position(BlackfordPerth).title("Marker in Blackford, Perth/Kinross").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(BlackfordPerth));

            LatLng HolmeWY = new LatLng(53.550, -1.879);
            googleMap.addMarker(new MarkerOptions().position(HolmeWY).title("Marker in Holme, West Yorkshire").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(HolmeWY));

            LatLng ConchraAB = new LatLng(56.038, -5.174);
            googleMap.addMarker(new MarkerOptions().position(ConchraAB).title("Marker in Conchra, Argyll and Bute").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(ConchraAB));

            LatLng BailiehillDG = new LatLng(55.193, -3.138);
            googleMap.addMarker(new MarkerOptions().position(BailiehillDG).title("Marker in Bailiehill, D and G").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(BailiehillDG));

            LatLng MullAG = new LatLng(56.434, -6.090);
            googleMap.addMarker(new MarkerOptions().position(MullAG).title("Marker in Mull, Argyll and Bute").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(MullAG));

            LatLng MullArgyllB = new LatLng(56.405, -5.686);
            googleMap.addMarker(new MarkerOptions().position(MullArgyllB).title("Marker in Mull, Argyll and Bute").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(MullArgyllB));

            LatLng CragganAB = new LatLng(56.163, -4.774);
            googleMap.addMarker(new MarkerOptions().position(CragganAB).title("Marker in Craggan, Argyll and Bute").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(CragganAB));

            LatLng Highland = new LatLng(56.696, -4.913);
            googleMap.addMarker(new MarkerOptions().position(Highland).title("Marker in Kinlochleven, Highland").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(Highland));

            LatLng SNorthSea = new LatLng(52.194, 2.183);
            googleMap.addMarker(new MarkerOptions().position(SNorthSea).title("Marker in Southern, North Sea").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(SNorthSea));

            LatLng BeattockDG = new LatLng(55.281, -3.524);
            googleMap.addMarker(new MarkerOptions().position(BeattockDG).title("Marker in Beattock D and G").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(BeattockDG));

            LatLng HighnamG = new LatLng(51.898, -2.309);
            googleMap.addMarker(new MarkerOptions().position(HighnamG).title("Marker in Highnam, Gloucestershire").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(HighnamG));

            LatLng HighlandLN = new LatLng(56.969, -5.448);
            googleMap.addMarker(new MarkerOptions().position(HighlandLN).title("Marker in Loch Nevis, Highland").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(HighlandLN));

            LatLng CentralNS = new LatLng(56.114, -2.288);
            googleMap.addMarker(new MarkerOptions().position(CentralNS).title("Marker in Central North Sea").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(CentralNS));

            LatLng ABLephinmore = new LatLng(56.087, -5.190);
            googleMap.addMarker(new MarkerOptions().position(ABLephinmore).title("Marker in Lephinmore, Argyll and Bute").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(ABLephinmore));

            LatLng BlairlogieS = new LatLng(56.140, -3.893);
            googleMap.addMarker(new MarkerOptions().position(BlairlogieS).title("Marker in Blairlogie, Stirling").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(BlairlogieS));

            LatLng HartsopC = new LatLng(54.510, -2.918);
            googleMap.addMarker(new MarkerOptions().position(HartsopC).title("Marker in Hartsop, Cumbria").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(HartsopC));

            LatLng SolwayFirth = new LatLng(54.816, -3.667);
            googleMap.addMarker(new MarkerOptions().position(SolwayFirth).title("Marker in Solway, Firth").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(SolwayFirth));

            LatLng ThrimbyC = new LatLng(54.576, -2.694);
            googleMap.addMarker(new MarkerOptions().position(ThrimbyC).title("Marker in Thrimby, Cumbria").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(ThrimbyC));

            LatLng LlandderfelG = new LatLng(52.901, -3.492);
            googleMap.addMarker(new MarkerOptions().position(LlandderfelG).title("Marker in LLANDDERFEL, GWYNEDD").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(LlandderfelG));

            LatLng BuckdenNY = new LatLng(54.185, -2.073);
            googleMap.addMarker(new MarkerOptions().position(BuckdenNY).title("Marker in Buckden, North Yorkshire").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(BuckdenNY));

            LatLng KerreraAB = new LatLng(56.389, -5.544);
            googleMap.addMarker(new MarkerOptions().position(KerreraAB).title("Marker in Kerrera, Argyll and Bute").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(KerreraAB));

            LatLng BriggNL = new LatLng(53.540, -0.436);
            googleMap.addMarker(new MarkerOptions().position(BriggNL).title("Marker in Brigg, North Lincs").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(BriggNL));

            LatLng HighlandB = new LatLng(56.964, -4.769);
            googleMap.addMarker(new MarkerOptions().position(HighlandB).title("Marker in Bohuntine, Highland").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(HighlandB));

        }
    };

}