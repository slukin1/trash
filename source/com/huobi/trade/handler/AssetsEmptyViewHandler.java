package com.huobi.trade.handler;

import android.view.View;
import android.view.ViewGroup;
import bt.b;
import com.hbg.lib.core.R$id;
import com.hbg.lib.core.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.ref.WeakReference;
import s9.c;
import ws.a;

public class AssetsEmptyViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void e(a aVar, View view) {
        xs.a aVar2;
        WeakReference<? extends xs.a> a11 = aVar.a();
        if (!(a11 == null || (aVar2 = (xs.a) a11.get()) == null)) {
            aVar2.e3();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(a aVar, View view) {
        xs.a aVar2;
        WeakReference<? extends xs.a> a11 = aVar.a();
        if (!(a11 == null || (aVar2 = (xs.a) a11.get()) == null)) {
            aVar2.V2();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        cVar.e().b(R$id.current_order_guide_deposit).setOnClickListener(new b(aVar));
        cVar.e().b(R$id.current_order_guide_transfer).setOnClickListener(new bt.a(aVar));
    }

    public int getResId() {
        return R$layout.item_trade_assets_empty;
    }
}
