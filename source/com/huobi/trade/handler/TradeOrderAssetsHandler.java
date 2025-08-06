package com.huobi.trade.handler;

import al.p;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bt.g2;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.trade.bean.TradeOrderAssets;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import i6.m;
import i6.r;
import oa.a;
import pro.huobi.R;
import s9.c;
import u9.b;

public class TradeOrderAssetsHandler implements c<Object, TradeOrderAssets>, View.OnClickListener {
    /* renamed from: c */
    public void handleView(Object obj, int i11, TradeOrderAssets tradeOrderAssets, ViewGroup viewGroup) {
        r rVar;
        String str;
        if (tradeOrderAssets != null) {
            if (obj instanceof v9.c) {
                rVar = ((v9.c) obj).e();
            } else if (obj instanceof b) {
                rVar = ((b) obj).c();
            } else {
                d.d("should not be here");
                return;
            }
            ImageView imageView = (ImageView) rVar.b(R.id.trade_hold_symbol_iv);
            TextView textView = (TextView) rVar.b(R.id.trade_hold_head_tv);
            TextView textView2 = (TextView) rVar.b(R.id.trade_hold_name_tv);
            TextView textView3 = (TextView) rVar.b(R.id.tv_order_balance);
            TextView textView4 = (TextView) rVar.b(R.id.tv_order_position_value);
            TextView textView5 = (TextView) rVar.b(R.id.tv_order_price);
            TextView textView6 = (TextView) rVar.b(R.id.liquidation_price_title_tv);
            textView.setText(tradeOrderAssets.getHead());
            int i12 = 8;
            textView.setVisibility(TextUtils.isEmpty(tradeOrderAssets.getHead()) ? 8 : 0);
            f6.c.a().f(imageView, p.l(tradeOrderAssets.getCurrency()), p.m());
            String balance = tradeOrderAssets.getBalance();
            String usdtPoistionValue = tradeOrderAssets.getUsdtPoistionValue();
            String liquidationPrice = tradeOrderAssets.getLiquidationPrice();
            String V = m.V(m.m(balance, 4), 4);
            String c11 = m.c(V, V);
            String V2 = m.V(m.m(usdtPoistionValue, 4), 4);
            String c12 = m.c(V2, V2);
            if (TextUtils.isEmpty(liquidationPrice) || liquidationPrice.equals(OptionsBridge.NULL_VALUE)) {
                str = "--";
            } else {
                if (!m.a0(liquidationPrice) || Float.parseFloat(liquidationPrice) >= 1.0f) {
                    i12 = 4;
                }
                String V3 = m.V(m.m(liquidationPrice, i12), i12);
                str = m.c(V3, V3);
            }
            textView2.setText(tradeOrderAssets.getCurrency());
            textView3.setText(c11);
            textView4.setText(c12);
            textView5.setText(str);
            textView6.setOnClickListener(this);
        }
    }

    public int getResId() {
        return R.layout.item_super_margin_asset;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        DialogUtils.X((FragmentActivity) a.g().b(), "", view.getResources().getString(R.string.n_cross_margin_liquidation_price_tips), "", view.getResources().getString(R.string.n_known), g2.f12904a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
