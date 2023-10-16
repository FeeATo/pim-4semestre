package com.unip.pim.payctions.fragment;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unip.pim.payctions.R;
import com.unip.pim.payctions.interfaces.fragment.FragmentActionListener;
import com.unip.pim.payctions.utils.Utils;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UsuarioInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsuarioInfoFragment extends Fragment {

    public static final String DESDE = "desde";
    public static final String CD_FUNCIONARIO = "cdFuncionario";
    public static final String CARGO = "cargo";
    public static final String NOME_FUNCIONARIO = "nomeFuncionario";
    public static final String LAYOUT = "layout";
    public static final String IMG = "img";

    public static final String COR_LAYOUT = "cor_layout";

    private Date desde;
    private Integer cdFuncionario;
    private String cargo;
    private String nomeFuncionario;
    private String img;
    private int layoutId;

    private int corLayout;

    TextView txtUsuario, txtCargo, txtDesde, txtCdFuncionario;

    public UsuarioInfoFragment() {
    }

    public static UsuarioInfoFragment newInstance(Date desde, Integer cdFuncionario, String cargo, String nomeFuncionario) {
        UsuarioInfoFragment fragment = new UsuarioInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DESDE, desde);
        bundle.putInt(CD_FUNCIONARIO, cdFuncionario);
        bundle.putString(CARGO, cargo);
        bundle.putString(NOME_FUNCIONARIO, nomeFuncionario);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            layoutId = getArguments().getInt(LAYOUT);
            desde = (Date) getArguments().getSerializable(DESDE);
            cdFuncionario = getArguments().getInt(CD_FUNCIONARIO);
            cargo = getArguments().getString(CARGO);
            nomeFuncionario = getArguments().getString(NOME_FUNCIONARIO);
            corLayout = getArguments().getInt(COR_LAYOUT);
            System.out.println(nomeFuncionario);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(layoutId, container, false);
        preencheTextosComUsuario(view, layoutId);
        return view;
    }

    private void preencheTextosComUsuario(View view, int layoutId) {
        inicializaCampos(view, layoutId);

        txtDesde.setText(String.format(getResources().getString(R.string.home_user_since), Utils.formatData(desde, "dd/MM/yyyy")));
        txtCdFuncionario.setText(String.format(getResources().getString(R.string.home_user_id), cdFuncionario));
        txtCargo.setText(String.format(getResources().getString(R.string.home_user_role), cargo));

        if (layoutId == R.layout.fragment_bem_vindo_usuario_fragment) {
            txtUsuario.setText(nomeFuncionario);
        }
    }

    private void inicializaCampos(View view, int layoutId) {
        if (layoutId == R.layout.fragment_bem_vindo_usuario_fragment) {
            txtUsuario = view.findViewById(R.id.txtNome_menu);
        }
        txtCargo = view.findViewById(R.id.txtCargo_menu);
        txtDesde = view.findViewById(R.id.txtDesde_menu);
        txtCdFuncionario = view.findViewById(R.id.txtCdFuncionario_menu);

        if (layoutId == R.layout.fragment_usuario_info) {
            view.findViewById(R.id.usuarioInfo_llUser).setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.background_cactus_top));
        } else {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), corLayout));
        }
    }
}