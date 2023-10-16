package com.unip.pim.payctions.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unip.pim.payctions.R;
import com.unip.pim.payctions.interfaces.fragment.FragmentActionListener;

public class HomeRhEMasterHomeBotoesFragment extends Fragment {

    TextView btnJustificarFalta;

    FragmentActionListener fragmentActionListener;

    public HomeRhEMasterHomeBotoesFragment() {
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
        View view = inflater.inflate(R.layout.fragment_home_rh_e_master_home_botoes, container, false);
        iniciarCampos(view);
        btnJustificarFalta.setOnClickListener(onClickListenerBotoes(R.id.homeBotoesFragment_btnJustificarFalta));
        return view;
    }

    private View.OnClickListener onClickListenerBotoes(int opcaoSelecionada) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("fui clicado");
                if (fragmentActionListener != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(FragmentActionListener.opcaoSelecionada, opcaoSelecionada);

                    fragmentActionListener.onMenuSelected(bundle);
                }
            }
        };
    }

    private void iniciarCampos(View view) {
        btnJustificarFalta = view.findViewById(R.id.homeBotoesFragment_btnJustificarFalta);
    }

    public void setMenuFragmentActionListener(FragmentActionListener fragmentActionListener) {
        this.fragmentActionListener = fragmentActionListener;
    }
}