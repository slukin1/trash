package com.huobi.tradenew.prime.viewhandler;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import ft.d;
import i6.r;
import pro.huobi.R;
import s9.c;

public class PrimeListOrderItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, d dVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        ((TextView) e11.b(R.id.id_prime_order_list_item_title)).setText(dVar.d());
        ((TextView) e11.b(R.id.id_prime_order_list_item_status)).setText(dVar.c());
        ViewUtil.m((ImageView) e11.b(R.id.id_prime_order_list_item_img), dVar.e());
    }

    public int getResId() {
        return R.layout.prime_list_order_item_layout;
    }
}
