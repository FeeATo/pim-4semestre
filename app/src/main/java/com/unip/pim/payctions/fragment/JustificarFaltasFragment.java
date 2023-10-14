package com.unip.pim.payctions.fragment;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unip.pim.payctions.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JustificarFaltasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JustificarFaltasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView btnConfirmar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JustificarFaltasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JustificarFaltasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JustificarFaltasFragment newInstance(String param1, String param2) {
        JustificarFaltasFragment fragment = new JustificarFaltasFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_justificar_faltas, container, false);
        btnConfirmar = view.findViewById(R.id.btnConfirmarJustificar);

        btnConfirmar.setPaintFlags(btnConfirmar.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        return view;
    }
}