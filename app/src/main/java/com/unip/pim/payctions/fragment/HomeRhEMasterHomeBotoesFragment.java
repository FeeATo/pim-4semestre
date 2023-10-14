package com.unip.pim.payctions.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unip.pim.payctions.R;

public class HomeRhEMasterHomeBotoesFragment extends Fragment {


    public HomeRhEMasterHomeBotoesFragment() {
        // Required empty public constructor
    }

    public static HomeRhEMasterHomeBotoesFragment newInstance(String param1, String param2) {
        HomeRhEMasterHomeBotoesFragment fragment = new HomeRhEMasterHomeBotoesFragment();
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
        return inflater.inflate(R.layout.fragment_home_rh_e_master_home_botoes, container, false);
    }
}