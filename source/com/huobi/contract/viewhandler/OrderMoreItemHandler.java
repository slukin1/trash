package com.huobi.contract.viewhandler;

import aj.e;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.data.symbol.TradeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;
import tc.a;

public class OrderMoreItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, e eVar, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R$id.order_more_tv);
        textView.setTag(eVar);
        textView.setOnClickListener(this);
    }

    public int getResId() {
        return R$layout.item_order_more;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        e eVar = (e) view.getTag();
        if (eVar != null) {
            TradeType h11 = eVar.h();
            TradeType tradeType = TradeType.CONTRACT;
            if (h11 == tradeType) {
                BaseModuleConfig.a().A(view.getContext(), eVar.g(), a.a(tradeType), eVar.d(), 0);
            } else {
                TradeType h12 = eVar.h();
                TradeType tradeType2 = TradeType.SWAP;
                if (h12 == tradeType2) {
                    BaseModuleConfig.a().E((Activity) view.getContext(), eVar.g(), a.a(tradeType2), 0);
                } else {
                    TradeType h13 = eVar.h();
                    TradeType tradeType3 = TradeType.LINEAR_SWAP;
                    if (h13 == tradeType3) {
                        BaseModuleConfig.a().g0((Activity) view.getContext(), eVar.g(), a.a(tradeType3), eVar.e() == 1 ? 1 : 0, eVar.c(), eVar.d(), 0);
                    } else {
                        BaseModuleConfig.a().r((Activity) view.getContext(), eVar.g(), a.a(eVar.h()));
                    }
                }
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
