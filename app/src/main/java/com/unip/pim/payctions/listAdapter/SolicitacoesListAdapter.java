package com.unip.pim.payctions.listAdapter;

import android.content.Context;
import android.content.Intent;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unip.pim.payctions.R;
import com.unip.pim.payctions.model.Funcionario;
import com.unip.pim.payctions.model.Solicitacao;
import com.unip.pim.payctions.utils.Utils;

import java.util.List;

public class SolicitacoesListAdapter extends RecyclerView.Adapter<SolicitacoesListItemViewHolder> {

    @NonNull
    private List<Solicitacao> solicitacaoList;

    public SolicitacoesListAdapter(@NonNull List<Solicitacao> solicitacaoList) {
        this.solicitacaoList = solicitacaoList;
    }

    @NonNull
    @Override
    public SolicitacoesListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        final Context context = viewGroup.getContext();
        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        final View stickerPackRow = layoutInflater.inflate(R.layout.solicitacoes_list_item, viewGroup, false);
        return new SolicitacoesListItemViewHolder(stickerPackRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final SolicitacoesListItemViewHolder viewHolder, final int index) {
        Solicitacao solicitacao = solicitacaoList.get(index);
        viewHolder.txtSolicitacaoItem_data.setText(Utils.formatData(solicitacao.getDtSolicitacao(), "dd/MM/yyyy"));
        viewHolder.txtSolicitacaoItem_nome.setText(Funcionario.getFuncionarioByCdFuncionario(solicitacao.getCdFuncionario()).getNome());
        viewHolder.txtSolicitacaoItem_responsavel.setText(Funcionario.getFuncionarioByCdFuncionario(solicitacao.getCdResponsavel()).getNome());

//        viewHolder.btnSolicitacaoItem_confirmar.setOnClickListener(view -> {
//
//        });
//
//        viewHolder.btnSolicitacaoItem_cancelar.setOnClickListener(view -> {
//
//        });
    }

    @Override
    public int getItemCount() {
        return solicitacaoList.size();
    }
}
