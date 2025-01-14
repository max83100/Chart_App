package com.chartapp.bottom;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.chartapp.R;
import com.chartapp.laptop.Laptop;
import com.chartapp.mainboard.Mainboard;
import com.chartapp.monitors.Monitor;
import com.chartapp.phones.Phone;
import com.chartapp.power.Power;
import com.chartapp.videocard.Videocard;
import com.chartapp.welding.Welding;

public class ChartFragment extends Fragment {
    private static final String TAG = "MyActivity";

    Intent intent;
    ImageView laptop;
    ImageView mainboard;
    ImageView phone;
    ImageView welding;
    ImageView power;
    ImageView videocard;
    ImageView monitor;




    public ChartFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_chart, container, false);
        getActivity().setTitle("Каталог схем");
        laptop = view.findViewById(R.id.notebookView);
        mainboard = view.findViewById(R.id.mainboardView);
        phone = view.findViewById(R.id.phoneView);
        welding = view.findViewById(R.id.weldingView);
        power = view.findViewById(R.id.powersupView);
        videocard = view.findViewById(R.id.videocardView);
        monitor = view.findViewById(R.id.monitorView);


        preload();

        return view;




    }

    private void preload() {
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Phone.class);
                startActivity(intent);
            }
        });

        mainboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Mainboard.class);
                startActivity(intent);
            }
        });

        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Laptop.class);
                startActivity(intent);
            }
        });
        welding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Welding.class);
                startActivity(intent);
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Power.class);
                startActivity(intent);
            }
        });
        videocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Videocard.class);
                startActivity(intent);
            }
        });
        monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), Monitor.class));
            }
        });

    }



}