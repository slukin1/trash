package com.huobi.otc.handler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hp.s;
import ip.b;
import s9.c;
import up.f;

public class OtcNewCurrencySelectHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(b bVar, QuickTradeConfigBean.Asset asset, View view) {
        if (bVar.e() != null) {
            bVar.e().Ra(asset);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R$id.id_currency_name_tv);
        TextView textView2 = (TextView) cVar.e().b(R$id.id_currency_full_name_tv);
        ImageView imageView = (ImageView) cVar.e().b(R$id.iv_selected);
        ImageView imageView2 = (ImageView) cVar.e().b(R$id.iv_currency);
        ViewUtil.m(cVar.e().b(R$id.id_line_view), !bVar.l());
        QuickTradeConfigBean.Asset d11 = bVar.d();
        if (d11 != null) {
            if (!TextUtils.isEmpty(d11.getName())) {
                textView.setText(d11.getName().toUpperCase());
            }
            int i12 = 0;
            if (!TextUtils.isEmpty(d11.getFullName())) {
                textView2.setVisibility(0);
                textView2.setText(d11.getFullName());
            } else {
                textView2.setVisibility(8);
            }
            cVar.itemView.setOnClickListener(new s(bVar, d11));
            String c11 = f.b().c(d11.getName());
            if (TextUtils.isEmpty(c11)) {
                imageView2.setImageResource(R$drawable.coin_default_icon);
            } else if (c11.endsWith("svg")) {
                f6.c.a().l(imageView2.getContext(), c11, imageView2, R$drawable.coin_default_icon);
            } else {
                f6.c.a().f(imageView2, c11, R$drawable.coin_default_icon);
            }
            if (!bVar.j()) {
                i12 = 8;
            }
            imageView.setVisibility(i12);
        }
    }

    public int getResId() {
        return R$layout.item_new_otc_currency_select_layout;
    }
}
