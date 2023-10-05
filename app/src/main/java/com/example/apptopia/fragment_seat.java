package com.example.apptopia;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_seat extends Fragment {
    View reading_room_ly, discussion_room_ly, notebook_zoon_ly;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.seat_page,container,false);

        reading_room_ly = view.findViewById(R.id.zone3);
        notebook_zoon_ly = view.findViewById(R.id.zone2);
        discussion_room_ly = view.findViewById(R.id.zone1);

        reading_room_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity().getApplicationContext(),reading_room.class);
                startActivity(intent1);
            }
        });
        discussion_room_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity().getApplicationContext(),discussion_room.class);
                startActivity(intent2);
            }
        });
        notebook_zoon_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity().getApplicationContext(),notebook_zoon.class);
                startActivity(intent3);
            }
        });
        return view;
    }
}
