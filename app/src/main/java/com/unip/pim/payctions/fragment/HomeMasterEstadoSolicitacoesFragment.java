package com.unip.pim.payctions.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unip.pim.payctions.R;
import com.unip.pim.payctions.listAdapter.SolicitacoesListAdapter;
import com.unip.pim.payctions.model.Solicitacao;

public class HomeMasterEstadoSolicitacoesFragment extends Fragment {

    private RecyclerView recyclerView;
    private SolicitacoesListAdapter solicitacoesListAdapter;
    private LinearLayoutManager linearLayoutManager;

    public HomeMasterEstadoSolicitacoesFragment() {
        // Required empty public constructor
    }

    public static HomeMasterEstadoSolicitacoesFragment newInstance(String param1, String param2) {
        HomeMasterEstadoSolicitacoesFragment fragment = new HomeMasterEstadoSolicitacoesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_master_estado_solicitacoes, container, false);

        recyclerView = view.findViewById(R.id.solicitacoesRecyclerView);
        solicitacoesListAdapter = new SolicitacoesListAdapter(Solicitacao.getSolicitacaoList());
        recyclerView.setAdapter(solicitacoesListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
}