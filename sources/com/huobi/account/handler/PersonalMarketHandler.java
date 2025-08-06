package com.huobi.account.handler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huawei.secure.android.common.ssl.util.f;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.HashMap;
import pg.b;
import pro.huobi.R;
import s9.c;

public class PersonalMarketHandler implements c {
    public static String c(double d11, String str) {
        BigDecimal bigDecimal = new BigDecimal(d11);
        if (BigDecimal.valueOf(d11).compareTo(BigDecimal.ZERO) != 0) {
            int v11 = PrecisionUtil.v(str);
            String str2 = bigDecimal.compareTo(BigDecimal.ZERO) > 0 ? "+" : "";
            return str2 + m.V(m.i(d11, v11), v11) + "%";
        }
        return String.format("%." + PrecisionUtil.v(str) + f.f38658a, new Object[]{Float.valueOf(0.0f)}) + "%";
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(SymbolBean symbolBean, v9.c cVar, View view) {
        String symbol = symbolBean.getSymbol();
        sn.f.C(cVar.itemView.getContext(), symbol, false, TradeType.PRO);
        HashMap hashMap = new HashMap();
        hashMap.put("type", symbol);
        g.i("Crypto_View_Me_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int d(Context context, double d11) {
        if (Double.compare(d11, 0.0d) > 0) {
            if (w.l()) {
                return ContextCompat.getColor(context, R.color.color_down);
            }
            return ContextCompat.getColor(context, R.color.color_rise);
        } else if (Double.compare(d11, 0.0d) >= 0) {
            return ContextCompat.getColor(context, R.color.color_flat);
        } else {
            if (w.l()) {
                return ContextCompat.getColor(context, R.color.color_rise);
            }
            return ContextCompat.getColor(context, R.color.color_down);
        }
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        int i12;
        String str;
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.text_view_personal_footprint_market_item_percent);
        TextView textView2 = (TextView) e11.b(R.id.text_view_personal_footprint_market_item_symbol);
        TextView textView3 = (TextView) e11.b(R.id.text_view_personal_footprint_market_item_price);
        TextView textView4 = (TextView) e11.b(R.id.text_view_personal_footprint_market_item_legal);
        SymbolBean f11 = bVar.f();
        String baseCurrencyDisplayName = f11.getBaseCurrencyDisplayName();
        String quoteCurrencyDisplayName = f11.getQuoteCurrencyDisplayName();
        String str2 = "--";
        if (TextUtils.isEmpty(bVar.c())) {
            i12 = d(cVar.itemView.getContext(), 0.0d);
            textView.setText(str2);
        } else {
            i12 = d(cVar.itemView.getContext(), Double.parseDouble(bVar.c()));
            textView.setText(c(Double.parseDouble(bVar.c()), f11.getSymbol()));
        }
        textView.setTextColor(i12);
        textView3.setTextColor(i12);
        textView2.setText(baseCurrencyDisplayName + "/" + quoteCurrencyDisplayName);
        if (TextUtils.isEmpty(bVar.e())) {
            textView3.setText(str2);
        } else {
            textView3.setText(m.m(bVar.e(), PrecisionUtil.x(f11.getSymbol())));
        }
        if (f11.getQuoteCurrency().equalsIgnoreCase("usdt")) {
            str = LegalCurrencyConfigUtil.w() + LegalCurrencyConfigUtil.B(bVar.e());
        } else {
            str = LegalCurrencyConfigUtil.w() + LegalCurrencyConfigUtil.A(bVar.e(), f11.getSymbol(), TradeType.PRO);
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
        }
        textView4.setText(str2);
        cVar.itemView.setOnClickListener(new sg.c(f11, cVar));
    }

    public int getResId() {
        return R.layout.item_personal_footprint_market;
    }
}
