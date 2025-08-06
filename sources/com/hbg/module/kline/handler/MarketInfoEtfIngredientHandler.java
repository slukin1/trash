package com.hbg.module.kline.handler;

import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.bean.EtfIngredient;
import i6.m;
import i6.r;
import java.util.Locale;
import s9.c;

public class MarketInfoEtfIngredientHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, EtfIngredient etfIngredient, ViewGroup viewGroup) {
        r e11 = cVar.e();
        ((TextView) e11.b(R$id.coin_text)).setText(etfIngredient.getCurrency().toUpperCase(Locale.US));
        ((TextView) e11.b(R$id.coin_weight_text)).setText(m.M(etfIngredient.getRate(), 2));
    }

    public int getResId() {
        return R$layout.item_market_info_etf_ingredient;
    }
}
