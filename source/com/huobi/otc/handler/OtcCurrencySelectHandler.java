package com.huobi.otc.handler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.enums.OtcCurrencySelectType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hp.q;
import ip.b;
import jp.c1;
import jp.v1;
import s9.c;

public class OtcCurrencySelectHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(b bVar, View view) {
        if (bVar.c() != null) {
            bVar.c().a(bVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R$id.id_currency_group_title_tv);
        TextView textView2 = (TextView) cVar.e().b(R$id.id_currency_parent_title_tv);
        TextView textView3 = (TextView) cVar.e().b(R$id.id_fist_desc_tv);
        v1.d(textView);
        FrameLayout frameLayout = (FrameLayout) cVar.e().b(R$id.id_currency_rl);
        TextView textView4 = (TextView) cVar.e().b(R$id.id_currency_symbol_tv);
        TextView textView5 = (TextView) cVar.e().b(R$id.id_currency_name_tv);
        ImageView imageView = (ImageView) cVar.e().b(R$id.iv_flag);
        textView2.setVisibility(8);
        textView.setVisibility(8);
        if (bVar.i() == OtcCurrencySelectType.SEARCH) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
        } else if (bVar.i() == OtcCurrencySelectType.COMMONLY) {
            textView.setVisibility(8);
            if (!TextUtils.isEmpty(bVar.h())) {
                textView2.setText(bVar.h());
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        } else {
            textView.setVisibility(0);
            textView.setText(bVar.g());
            if (!TextUtils.isEmpty(bVar.h())) {
                textView2.setText(bVar.h());
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        ViewUtil.m(cVar.e().b(R$id.id_line_view), !bVar.l());
        if (bVar.f() != null) {
            if (!TextUtils.isEmpty(bVar.f().getName())) {
                textView5.setText(bVar.f().getName().toUpperCase());
                if (bVar.f().getName().equalsIgnoreCase("cny") || bVar.f().getName().equalsIgnoreCase("cnh")) {
                    textView3.setVisibility(0);
                } else {
                    textView3.setVisibility(8);
                }
            }
            frameLayout.setOnClickListener(new q(bVar));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView5.getLayoutParams();
            textView4.setVisibility(8);
            imageView.setVisibility(0);
            String str = c1.h().d() + bVar.f().getIcon();
            if (TextUtils.isEmpty(str)) {
                imageView.setImageResource(R$drawable.coin_default_icon);
            } else {
                g6.b.c().i(imageView, str, R$drawable.coin_default_icon);
            }
            marginLayoutParams.setMarginStart(PixelUtils.a(18.0f));
            textView5.setLayoutParams(marginLayoutParams);
        }
    }

    public int getResId() {
        return R$layout.item_otc_currency_select_layout;
    }
}
