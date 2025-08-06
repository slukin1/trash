package com.huobi.trade.handler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bt.k2;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.huobi.trade.bean.TradeOrderOutstanding;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ct.b;
import gs.g;
import i6.d;
import i6.m;
import i6.r;
import io.flutter.Log;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;

public class TradeOrderOutstandingHandler implements c<Object, TradeOrderOutstanding> {

    /* renamed from: b  reason: collision with root package name */
    public b f82004b;

    /* renamed from: c  reason: collision with root package name */
    public int f82005c = 1;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d(TradeOrderOutstanding tradeOrderOutstanding, View view) {
        b bVar = this.f82004b;
        if (bVar != null) {
            bVar.c(tradeOrderOutstanding.getCurrency());
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_CROSS);
            hashMap.put("version_type", this.f82005c == 1 ? "vertical" : MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL);
            hashMap.put("symbol", tradeOrderOutstanding.getCurrency());
            g.i("app_trade_outstanding_tab_repay_click", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(Object obj, int i11, TradeOrderOutstanding tradeOrderOutstanding, ViewGroup viewGroup) {
        r rVar;
        String str;
        if (tradeOrderOutstanding == null) {
            Log.e("TradeOrderOutstandingHandler", "outstanding data is null");
            return;
        }
        Log.d("TradeOrderOutstandingHandler", "outstanding data:" + tradeOrderOutstanding);
        if (obj instanceof v9.c) {
            rVar = ((v9.c) obj).e();
        } else if (obj instanceof u9.b) {
            rVar = ((u9.b) obj).c();
        } else {
            d.d("should not be here");
            return;
        }
        TextView textView = (TextView) rVar.b(R.id.tv_order_borrow_size);
        TextView textView2 = (TextView) rVar.b(R.id.tv_order_position_value);
        TextView textView3 = (TextView) rVar.b(R.id.tv_order_price);
        ((TextView) rVar.b(R.id.tv_order_title)).setText(tradeOrderOutstanding.getCurrency());
        ((TextView) rVar.b(R.id.tv_order_repay)).setOnClickListener(new k2(this, tradeOrderOutstanding));
        String borrowSize = tradeOrderOutstanding.getBorrowSize();
        String usdtPoistionValue = tradeOrderOutstanding.getUsdtPoistionValue();
        String liquidationPrice = tradeOrderOutstanding.getLiquidationPrice();
        int i12 = 4;
        String V = m.V(m.m(borrowSize, 4), 4);
        String c11 = m.c(V, V);
        String V2 = m.V(m.m(usdtPoistionValue, 4), 4);
        String c12 = m.c(V2, V2);
        if (TextUtils.isEmpty(liquidationPrice) || liquidationPrice.equals(OptionsBridge.NULL_VALUE)) {
            str = "--";
        } else {
            if (m.a0(liquidationPrice) && Float.parseFloat(liquidationPrice) < 1.0f) {
                i12 = 8;
            }
            String V3 = m.V(m.m(liquidationPrice, i12), i12);
            str = m.c(V3, V3);
        }
        textView.setText(c11);
        textView2.setText(c12);
        textView3.setText(str);
    }

    public void e(int i11) {
        this.f82005c = i11;
    }

    public void f(b bVar) {
        this.f82004b = bVar;
    }

    public int getResId() {
        return R.layout.myorder_outstanding_item_parent;
    }
}
