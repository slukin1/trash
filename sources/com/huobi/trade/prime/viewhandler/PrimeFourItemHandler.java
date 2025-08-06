package com.huobi.trade.prime.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import ft.a;
import i6.r;
import pro.huobi.R;
import s9.c;

public class PrimeFourItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        ((TextView) e11.b(R.id.id_prime_item_title)).setText(aVar.d());
        ((TextView) e11.b(R.id.id_prime_content)).setText(aVar.c());
    }

    public int getResId() {
        return R.layout.prime_four_item_layout;
    }
}
