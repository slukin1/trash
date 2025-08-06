package com.huobi.trade.prime.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import i6.r;
import pro.huobi.R;
import s9.c;

public class PrimeListItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, ft.c cVar2, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.id_prime_list_item_title);
        textView.setText(cVar2.d());
        ((TextView) e11.b(R.id.id_prime_list_item_desc)).setText(cVar2.c());
        ViewUtil.m(textView, cVar2.e());
    }

    public int getResId() {
        return R.layout.prime_list_item_layout;
    }
}
