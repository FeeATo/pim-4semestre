package com.unip.pim.payctions.fragment;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unip.pim.payctions.R;
import com.unip.pim.payctions.interfaces.fragment.FragmentActionListener;
import com.unip.pim.payctions.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeMasterMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeMasterMenuFragment extends Fragment {

    LinearLayout btnHome, btnEstadoSolicitacoes, btnHistoricoPagamento;
    TextView txtHome, txtEstadoSolicitacoes, txtHistoricoPagamento;
    int opcaoAtiva;
    FragmentActionListener fragmentActionListener;

    public static List<Integer> sequenciaMenus;

    static {
        sequenciaMenus = new ArrayList<>();
        sequenciaMenus.add(R.id.home_llHome);
        sequenciaMenus.add(R.id.home_llEstadoSolicitacoes);
        sequenciaMenus.add(R.id.home_llHistoricoPagamentos);
    }

    public void setMenuFragmentActionListener(FragmentActionListener fragmentActionListener) {
        this.fragmentActionListener = fragmentActionListener;
    }

    public HomeMasterMenuFragment() {
        // Required empty public constructor
    }

    public static HomeMasterMenuFragment newInstance(String param1, String param2) {
        HomeMasterMenuFragment fragment = new HomeMasterMenuFragment();
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
        View view = inflater.inflate(R.layout.fragment_home_master_menu, container, false);
        btnHome = view.findViewById(R.id.home_llHome);
        btnEstadoSolicitacoes = view.findViewById(R.id.home_llEstadoSolicitacoes);
        btnHistoricoPagamento = view.findViewById(R.id.home_llHistoricoPagamentos);
        txtHome = view.findViewById(R.id.home_txtHome);
        txtEstadoSolicitacoes = view.findViewById(R.id.home_txtEstadoSolicitacoes);
        txtHistoricoPagamento = view.findViewById(R.id.home_txtHistoricoPagamento);

        mudaBotaoAtivo(getArguments().getInt(FragmentActionListener.opcaoSelecionada));

        btnHome.setOnClickListener(onClickListenerSetMenuSelected(R.id.home_llHome));
        btnHistoricoPagamento.setOnClickListener(onClickListenerSetMenuSelected(R.id.home_llHistoricoPagamentos));
        btnEstadoSolicitacoes.setOnClickListener(onClickListenerSetMenuSelected(R.id.home_llEstadoSolicitacoes));

        return view;
    }

    private View.OnClickListener onClickListenerSetMenuSelected(int opcaoSelecionada) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("fui clicado");
                if (fragmentActionListener != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(FragmentActionListener.opcaoSelecionada, opcaoSelecionada);
                    bundle.putInt(FragmentActionListener.opcaoAtiva, opcaoAtiva);

                    fragmentActionListener.onMenuSelected(bundle);
                }
            }
        };
    }


    public void mudaBotaoAtivo(int layout) {
        if (layout == R.id.home_llHome) {
            alteraHomeImg(true);
            alteraHistoricoPagamentoImg(false);
            alteraEstadoSolicitacoesImg(false);
            opcaoAtiva = R.id.home_llHome;
        } else if (layout == R.id.home_llEstadoSolicitacoes) {
            alteraHomeImg(false);
            alteraHistoricoPagamentoImg(false);
            alteraEstadoSolicitacoesImg(true);
            opcaoAtiva = R.id.home_llEstadoSolicitacoes;
        } else if (layout == R.id.home_llHistoricoPagamentos) {
            alteraHomeImg(false);
            alteraHistoricoPagamentoImg(true);
            alteraEstadoSolicitacoesImg(false);
            opcaoAtiva = R.id.home_llHistoricoPagamentos;
        }
    }

    public void alteraHomeImg(boolean isAtivo) {
        int drawableAtivo = R.drawable.home_home_ativo_30x30;
        int drawableInativo = R.drawable.home_home_inativo_30x30;

        txtHome.setCompoundDrawablesWithIntrinsicBounds(null,
                getResources().getDrawable(isAtivo ? drawableAtivo : drawableInativo, null),
                null,
                null);

        txtHome.setTextColor(isAtivo ? ContextCompat.getColor(getContext(), Utils.COR_MENU_ATIVO) : ContextCompat.getColor(getContext(), Utils.COR_MENU_INATIVO));
    }

    public void alteraHistoricoPagamentoImg(boolean isAtivo) {
        int ativo = R.drawable.home_money_ativo_32x32;
        int inativo = R.drawable.home_money_inativo_32x32;

        txtHistoricoPagamento.setCompoundDrawablesWithIntrinsicBounds(null,
                getResources().getDrawable(isAtivo ? ativo : inativo, null),
                null,
                null);

        txtHistoricoPagamento.setTextColor(isAtivo ? ContextCompat.getColor(getContext(), Utils.COR_MENU_ATIVO) : ContextCompat.getColor(getContext(), Utils.COR_MENU_INATIVO));
    }

    public void alteraEstadoSolicitacoesImg(boolean isAtivo) {
        int ativo = R.drawable.home_graphics_ativo_30x33;
        int inativo = R.drawable.home_graphics_inativo_30x33;

        txtEstadoSolicitacoes.setCompoundDrawablesWithIntrinsicBounds(null,
                getResources().getDrawable(isAtivo ? ativo : inativo, null),
                null,
                null);

        txtEstadoSolicitacoes.setTextColor(isAtivo ? ContextCompat.getColor(getContext(), Utils.COR_MENU_ATIVO) : ContextCompat.getColor(getContext(), Utils.COR_MENU_INATIVO));
    }


}