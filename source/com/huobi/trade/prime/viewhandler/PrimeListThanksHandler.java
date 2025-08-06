package com.huobi.trade.prime.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import ft.e;
import pro.huobi.R;
import s9.c;

public class PrimeListThanksHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, e eVar, ViewGroup viewGroup) {
        ((TextView) cVar.e().b(R.id.id_prime_order_list_item_title)).setText(eVar.f84148b);
    }

    public int getResId() {
        return R.layout.prime_lucky_list_order_item_layout_thanks;
    }
}
