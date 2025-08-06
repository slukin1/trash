package com.huobi.tradenew.prime.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import ft.b;
import pro.huobi.R;
import s9.c;

public class PrimeEmptyHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        ((TextView) cVar.e().b(R.id.prime_list_empty_title)).setText(bVar.c());
    }

    public int getResId() {
        return R.layout.prime_list_empty_item_layout;
    }
}
