package com.unip.pim.payctions.utils;

import com.unip.pim.payctions.exception.PayctionsException;

import com.unip.pim.payctions.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public static final int COR_MENU_ATIVO = R.color.black_ativo;
    public static final int COR_MENU_INATIVO = R.color.gray_inativo;

    private Utils() {
    }

    public static String formatData(Date date, String format) {
        String result = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
            result = simpleDateFormat.format(date);
        } catch (Exception ex) {
//            throw new PayctionsException("Erro ao formatar data", "formatData", Utils.class, ex);
            ex.printStackTrace();
        }
        return result;
    }

    public static Date toDate(String date, String format) {
        Date result = null;
        try {
            result = new SimpleDateFormat(format).parse(date);
        } catch (Exception ex) {
//            throw new PayctionsException("Erro ao transformar em data", "toDate", Utils.class, ex);
            ex.printStackTrace();
        }
        return result;
    }

    public static Date addDias(Date date, int dias) {
        Date result = null;
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            calendar.add(dias, Calendar.DAY_OF_MONTH);

            result = calendar.getTime();
        } catch (Exception ex) {
//            throw new PayctionsException("Erro ao adicionar dias", "addDias", Utils.class, ex);
            ex.printStackTrace();
        }
        return result;
    }
}
