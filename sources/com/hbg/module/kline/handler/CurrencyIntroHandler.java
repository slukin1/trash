package com.hbg.module.kline.handler;

import ae.a;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.util.CommonFunc;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.bean.CurrencyIntroItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import s9.c;

public class CurrencyIntroHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(v9.c cVar, CurrencyIntroItem currencyIntroItem, View view) {
        Context context = cVar.itemView.getContext();
        if (context != null) {
            CommonFunc.a(context, currencyIntroItem.getUrl());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, CurrencyIntroItem currencyIntroItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        ((ImageView) e11.b(R$id.iv_currency_intro_about_link)).setImageResource(currencyIntroItem.getImageResId());
        ((TextView) e11.b(R$id.tv_currency_intro_about_link)).setText(currencyIntroItem.getName());
        if (!TextUtils.isEmpty(currencyIntroItem.getUrl())) {
            cVar.itemView.setOnClickListener(new a(cVar, currencyIntroItem));
        }
    }

    public int getResId() {
        return R$layout.item_currency_intro_about_link;
    }
}
