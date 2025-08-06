package com.huobi.otc.handler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.persenter.OtcTradePresenter;
import dw.a;
import java.util.concurrent.TimeUnit;
import jp.b1;
import s9.c;

public class AdsPublishViewHandler implements c {
    public static /* synthetic */ void d(Context context, Void voidR) {
        if (context instanceof OtcTradePresenter.i) {
            b1.h().k((FragmentActivity) context, (OtcTradePresenter.i) context);
        }
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, Ads ads, ViewGroup viewGroup) {
        View b11 = cVar.e().b(R$id.item_tv_create);
        a.a(b11).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new hp.a(b11.getContext()));
    }

    public int getResId() {
        return R$layout.item_otc_public_ad_entry;
    }
}
