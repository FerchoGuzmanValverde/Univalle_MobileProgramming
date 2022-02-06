package com.example.ejemplofragmentos;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private TextView _textViewDitails;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        // Inflate the layout for this fragment
        _textViewDitails=view.findViewById(R.id.textViewDetails);
        return view;
    }

    public void renderText(String text, int size, String color){
        _textViewDitails.setTextColor(Color.parseColor(color));
        _textViewDitails.setTextSize(size);
        _textViewDitails.setText(text);
    }
}
