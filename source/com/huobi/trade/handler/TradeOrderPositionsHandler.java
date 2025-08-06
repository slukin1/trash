package com.huobi.trade.handler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import bt.l2;
import bt.m2;
import bt.n2;
import bt.o2;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.trade.bean.TradeOrderPositions;
import com.huobi.view.BaseTradeMarginBalanceDialog;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ct.b;
import gs.g;
import i6.d;
import i6.m;
import i6.r;
import io.flutter.Log;
import java.math.BigDecimal;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;

public class TradeOrderPositionsHandler implements c<Object, TradeOrderPositions> {

    /* renamed from: b  reason: collision with root package name */
    public b f82006b;

    /* renamed from: c  reason: collision with root package name */
    public int f82007c = 1;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(String str, View view) {
        b bVar = this.f82006b;
        if (bVar != null) {
            bVar.d(str);
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
            hashMap.put("version_type", this.f82007c == 1 ? "vertical" : MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL);
            hashMap.put("symbol", str);
            g.i("app_trade_positions_item_click", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(String str, View view) {
        b bVar = this.f82006b;
        if (bVar != null) {
            bVar.c(str);
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
            hashMap.put("version_type", this.f82007c == 1 ? "vertical" : MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL);
            hashMap.put("symbol", str);
            g.i("app_trade_positions_tab_repay_click", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(String str, View view) {
        b bVar = this.f82006b;
        if (bVar != null) {
            bVar.b(str);
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
            hashMap.put("version_type", this.f82007c == 1 ? "vertical" : MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL);
            hashMap.put("symbol", str);
            g.i("app_trade_positions_tab_borrow_click", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j(String str, View view) {
        b bVar = this.f82006b;
        if (bVar != null) {
            bVar.a(str);
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
            hashMap.put("version_type", this.f82007c == 1 ? "vertical" : MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL);
            hashMap.put("symbol", str);
            g.i("app_trade_positions_tab_transfer_click", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: f */
    public void handleView(Object obj, int i11, TradeOrderPositions tradeOrderPositions, ViewGroup viewGroup) {
        r rVar;
        String str;
        Object obj2 = obj;
        TradeOrderPositions tradeOrderPositions2 = tradeOrderPositions;
        if (tradeOrderPositions2 == null) {
            Log.e("TradeOrderPositionsHandler", "Positions data is null");
            return;
        }
        Log.d("TradeOrderPositionsHandler", "Positions data:" + tradeOrderPositions2);
        if (obj2 instanceof v9.c) {
            rVar = ((v9.c) obj2).e();
        } else if (obj2 instanceof u9.b) {
            rVar = ((u9.b) obj2).c();
        } else {
            d.d("should not be here");
            return;
        }
        TradeOrderPositions.BaseAccount baseAccount = tradeOrderPositions.getBaseAccount();
        TradeOrderPositions.QuoteAccount quoteAccount = tradeOrderPositions.getQuoteAccount();
        if (baseAccount != null && quoteAccount != null) {
            TextView textView = (TextView) rVar.b(R.id.tv_order_base_coin);
            TextView textView2 = (TextView) rVar.b(R.id.tv_order_base_coin_position);
            TextView textView3 = (TextView) rVar.b(R.id.tv_order_base_coin_position_value);
            TextView textView4 = (TextView) rVar.b(R.id.tv_order_quote_coin);
            TextView textView5 = (TextView) rVar.b(R.id.tv_order_quote_coin_position);
            TextView textView6 = (TextView) rVar.b(R.id.tv_order_quote_coin_position_value);
            TextView textView7 = (TextView) rVar.b(R.id.tv_order_liq_price);
            TextView textView8 = (TextView) rVar.b(R.id.tv_order_risk_ratio);
            ((TextView) rVar.b(R.id.tv_order_title)).setText(tradeOrderPositions.getSymbolDisplayName());
            String symbolCode = tradeOrderPositions.getSymbolCode();
            ((LinearLayout) rVar.b(R.id.root_layout)).setOnClickListener(new l2(this, symbolCode));
            ((TextView) rVar.b(R.id.tv_order_repay)).setOnClickListener(new m2(this, symbolCode));
            ((TextView) rVar.b(R.id.tv_order_borrow)).setOnClickListener(new n2(this, symbolCode));
            ((TextView) rVar.b(R.id.tv_order_transfer)).setOnClickListener(new o2(this, symbolCode));
            int z11 = PrecisionUtil.z(symbolCode);
            int i12 = 8;
            if (z11 <= 0) {
                z11 = 8;
            }
            textView.setText(baseAccount.getCurrencyDisplayName());
            textView2.setText(nb.c.c(m.V(m.i(baseAccount.getPosition(), z11), z11), z11));
            String V = m.V(m.i(baseAccount.getPositionValue(), 4), 4);
            textView3.setText(m.c(V, V));
            int z12 = PrecisionUtil.z(symbolCode);
            if (z12 <= 0) {
                z12 = 8;
            }
            textView4.setText(quoteAccount.getCurrencyDisplayName());
            textView5.setText(nb.c.c(m.V(m.i(quoteAccount.getPosition(), z12), z12), z12));
            String V2 = m.V(m.i(quoteAccount.getPositionValue(), 4), 4);
            textView6.setText(m.c(V2, V2));
            String liquidationPrice = tradeOrderPositions.getLiquidationPrice();
            if (TextUtils.isEmpty(liquidationPrice) || liquidationPrice.equals(OptionsBridge.NULL_VALUE)) {
                str = "--";
            } else {
                if (!m.a0(liquidationPrice) || Float.parseFloat(liquidationPrice) >= 1.0f) {
                    i12 = 4;
                }
                String V3 = m.V(m.m(liquidationPrice, i12), i12);
                str = m.c(V3, V3);
            }
            textView7.setText(str);
            String V4 = m.V(m.i(tradeOrderPositions.getRiskRatio() * 100.0d, 2), 2);
            String c11 = m.c(V4, V4);
            if (BigDecimal.valueOf(tradeOrderPositions.getRiskRatio()).compareTo(m.a(BaseTradeMarginBalanceDialog.RISK_999)) >= 0) {
                c11 = "≥999";
            }
            textView8.setText(c11 + "%");
        }
    }

    public int getResId() {
        return R.layout.myorder_positions_item_parent;
    }

    public void k(int i11) {
        this.f82007c = i11;
    }

    public void l(b bVar) {
        this.f82006b = bVar;
    }
}
