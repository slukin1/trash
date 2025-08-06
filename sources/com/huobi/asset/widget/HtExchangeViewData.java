package com.huobi.asset.widget;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.account.spot.SpotFastEntranceView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.a;
import s9.c;
import vh.n0;

public class HtExchangeViewData implements a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f42493b;

    /* renamed from: c  reason: collision with root package name */
    public int f42494c = 0;

    public static class HtExchangeViewHandler implements c {
        @SensorsDataInstrumented
        public static /* synthetic */ void d(View view) {
            if (view.getContext() instanceof Activity) {
                BaseModuleConfig.a().S((Activity) view.getContext(), AssetAccountType.MORTGAGE.toString());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: c */
        public void handleView(v9.c cVar, int i11, HtExchangeViewData htExchangeViewData, ViewGroup viewGroup) {
            SpotFastEntranceView spotFastEntranceView = (SpotFastEntranceView) cVar.e().b(R$id.entrance);
            View b11 = cVar.e().b(R$id.goto_mortgage);
            spotFastEntranceView.setUserClear(htExchangeViewData.f42493b);
            spotFastEntranceView.setTag(htExchangeViewData.f42494c);
            b11.setOnClickListener(n0.f61049b);
        }

        public int getResId() {
            return R$layout.item_ht_exchange_entrance;
        }
    }

    public boolean d(Object obj) {
        return obj instanceof HtExchangeViewData;
    }

    public int e() {
        return this.f42494c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HtExchangeViewData)) {
            return false;
        }
        HtExchangeViewData htExchangeViewData = (HtExchangeViewData) obj;
        return htExchangeViewData.d(this) && f() == htExchangeViewData.f() && e() == htExchangeViewData.e();
    }

    public boolean f() {
        return this.f42493b;
    }

    public void g(int i11) {
        this.f42494c = i11;
    }

    public String getViewHandlerName() {
        return HtExchangeViewHandler.class.getName();
    }

    public void h(boolean z11) {
        this.f42493b = z11;
    }

    public int hashCode() {
        return (((f() ? 79 : 97) + 59) * 59) + e();
    }

    public String toString() {
        return "HtExchangeViewData(isUserCleared=" + f() + ", tag=" + e() + ")";
    }
}
