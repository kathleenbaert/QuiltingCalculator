package com.example.quiltcalculator.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.quiltcalculator.R;

public class HomeFragment extends Fragment {

    private static int quiltDimension;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.difficulty_levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinnerPiecingQuiltConstruction = (Spinner) root.findViewById(R.id.QuiltConstructionPiecingSpinner);
        spinnerPiecingQuiltConstruction.setAdapter(adapter);

        Spinner spinnerMachineAppliqueQuiltConstruction = (Spinner) root.findViewById(R.id.QuiltConstructionMachineAppliqueSpinner);
        spinnerMachineAppliqueQuiltConstruction.setAdapter(adapter);

        Spinner spinnerHandAppliqueQuiltConstruction = (Spinner) root.findViewById(R.id.QuiltConstructionHandAppliqueSpinner);
        spinnerHandAppliqueQuiltConstruction.setAdapter(adapter);

        Button calculateDimensionsButton = (Button) root.findViewById(R.id.calculateDimensions);
        calculateDimensionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handleCalculateDimensions(root);
            }
        });

        return root;
    }

    public static void handleCalculateDimensions(View v){
        TextView dimensionWidthTextView;
        TextView dimensionHeightTextView;
        dimensionWidthTextView   = (EditText)v.findViewById(R.id.DimensionsWidth);
        dimensionHeightTextView = (EditText)v.findViewById(R.id.DimensionsHeight);

        int width = Integer.parseInt(dimensionWidthTextView.getText().toString());
        int height = Integer.parseInt((dimensionHeightTextView.getText().toString()));

        TextView calculatedDimensionsTextView = v.findViewById(R.id.calculatedDimensions);
        String calculatedDimensionTextValue = calculatedDimensionsTextView.getText().toString();

        quiltDimension = width * height;
        calculatedDimensionTextValue = calculatedDimensionTextValue +" "+  quiltDimension;

        calculatedDimensionsTextView.setText(calculatedDimensionTextValue);
    }
}