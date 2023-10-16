package com.unip.pim.payctions.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unip.pim.payctions.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrarColaboradorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrarColaboradorFragment extends Fragment {

    public RegistrarColaboradorFragment() {
        // Required empty public constructor
    }

    public static RegistrarColaboradorFragment newInstance(String param1, String param2) {
        RegistrarColaboradorFragment fragment = new RegistrarColaboradorFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registrar_colaborador, container, false);
    }
}