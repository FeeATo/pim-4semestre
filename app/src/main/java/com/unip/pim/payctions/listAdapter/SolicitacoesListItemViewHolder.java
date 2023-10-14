package com.unip.pim.payctions.listAdapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.unip.pim.payctions.R;
import com.unip.pim.payctions.model.Solicitacao;

public class SolicitacoesListItemViewHolder extends RecyclerView.ViewHolder {

    final TextView txtSolicitacaoItem_data;
    final TextView txtSolicitacaoItem_nome;
    final TextView txtSolicitacaoItem_responsavel;
    final TextView txtSolicitacaoItem_registro;
    final TextView btnSolicitacaoItem_confirmar;
    final TextView btnSolicitacaoItem_cancelar;


    public SolicitacoesListItemViewHolder(final View itemView) {
        super(itemView);
        txtSolicitacaoItem_data = itemView.findViewById(R.id.solicitacaoItem_data);
        txtSolicitacaoItem_nome = itemView.findViewById(R.id.solicitacaoItem_nome);
        txtSolicitacaoItem_responsavel = itemView.findViewById(R.id.solicitacaoItem_responsavel);
        txtSolicitacaoItem_registro = itemView.findViewById(R.id.solicitacaoItem_registro);
        btnSolicitacaoItem_confirmar = itemView.findViewById(R.id.solicitacaoItem_confirmar);
        btnSolicitacaoItem_cancelar = itemView.findViewById(R.id.solicitacaoItem_cancelar);
    }

    public TextView getTxtSolicitacaoItem_data() {
        return txtSolicitacaoItem_data;
    }

    public TextView getTxtSolicitacaoItem_nome() {
        return txtSolicitacaoItem_nome;
    }

    public TextView getTxtSolicitacaoItem_responsavel() {
        return txtSolicitacaoItem_responsavel;
    }

    public TextView getTxtSolicitacaoItem_registro() {
        return txtSolicitacaoItem_registro;
    }

    public TextView getBtnSolicitacaoItem_confirmar() {
        return btnSolicitacaoItem_confirmar;
    }

    public TextView getBtnSolicitacaoItem_cancelar() {
        return btnSolicitacaoItem_cancelar;
    }
}
