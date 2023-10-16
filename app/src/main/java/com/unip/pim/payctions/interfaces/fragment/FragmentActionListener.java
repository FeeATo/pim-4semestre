package com.unip.pim.payctions.interfaces.fragment;

import android.os.Bundle;

public interface FragmentActionListener {

    String opcaoSelecionada = "opcaoSelecionada";
    String opcaoAtiva = "opcaoAtiva";

    void onMenuSelected(Bundle bundle);

}
