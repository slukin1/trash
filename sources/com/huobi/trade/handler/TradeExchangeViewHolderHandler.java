package com.huobi.trade.handler;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.trade.helper.f0;
import com.huobi.utils.HBHTtoHTXManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import i6.r;
import ml.d;
import pro.huobi.R;
import s9.c;

public class TradeExchangeViewHolderHandler implements c, View.OnClickListener {
    public final int b(d dVar) {
        return dVar.x() ? R.color.global_default_text_color_night : R.color.global_market_compare_about_light_color;
    }

    public final int c(d dVar) {
        return dVar.x() ? R.color.trade_dialog_divider_color_night : R.color.trade_dialog_divider_color_light;
    }

    public final int d(d dVar) {
        return dVar.x() ? R.color.global_module_focus_bg_night : R.color.global_module_focus_bg_light;
    }

    public final int e(d dVar) {
        return dVar.x() ? R.color.global_main_text_color_night : R.color.global_main_text_color_light;
    }

    public final int f(d dVar) {
        return dVar.x() ? R.drawable.selector_trade_coin_market_bg_night : R.drawable.selector_trade_coin_market_bg_light;
    }

    public final int g(d dVar) {
        return dVar.x() ? R.color.global_sec_text_color_night : R.color.global_sec_text_color_light;
    }

    public int getResId() {
        return R.layout.item_trade_coin_market;
    }

    /* renamed from: h */
    public void handleView(v9.c cVar, int i11, d dVar, ViewGroup viewGroup) {
        View view = cVar.itemView;
        i(cVar, dVar, view.getContext());
        view.setTag(R.id.item_data1, dVar);
        view.setOnClickListener(this);
    }

    public final void i(v9.c cVar, d dVar, Context context) {
        v9.c cVar2 = cVar;
        d dVar2 = dVar;
        Context context2 = context;
        r e11 = cVar.e();
        Resources resources = cVar2.itemView.getResources();
        TextView textView = (TextView) e11.b(R.id.item_trade_market_name);
        TextView textView2 = (TextView) e11.b(R.id.item_trade_market_price);
        TextView textView3 = (TextView) e11.b(R.id.item_leverage_tv);
        TextView textView4 = (TextView) e11.b(R.id.item_trade_market_symbol);
        View b11 = e11.b(R.id.item_trade_market_line);
        ImageView imageView = (ImageView) e11.b(R.id.prime_tip);
        String o11 = dVar.o();
        if (o11 == null) {
            o11 = "";
        }
        textView2.setTextSize(1, 14.0f);
        textView.setText(dVar.j());
        textView4.setText("/" + a1.v().F(o11));
        textView4.setTextColor(ContextCompat.getColor(context2, g(dVar2)));
        double h02 = (TextUtils.isEmpty(dVar.d()) || dVar.getSymbolPrice().getOpen() == null) ? 0.0d : m.h0(dVar.d()) - dVar.getSymbolPrice().getOpen().doubleValue();
        if (dVar.B()) {
            cVar2.itemView.setBackgroundColor(ContextCompat.getColor(context2, d(dVar2)));
        } else {
            cVar2.itemView.setBackgroundResource(f(dVar2));
        }
        if (!TextUtils.isEmpty(dVar.d())) {
            textView2.setText(m.m(dVar.d(), PrecisionUtil.x(o11)));
        } else {
            textView2.setText("--");
        }
        if (SymbolBean.SUSPEND.equals(dVar.n()) || SymbolBean.TRANSFER_BOARD.equals(dVar.n()) || SymbolBean.FUSE.equals(dVar.n())) {
            textView.setTextColor(ContextCompat.getColor(context2, b(dVar2)));
            textView2.setTextColor(ContextCompat.getColor(context2, b(dVar2)));
            if (SymbolBean.SUSPEND.equals(dVar.n())) {
                if (HBHTtoHTXManager.f83692a.f(dVar.o())) {
                    textView2.setText("--");
                } else {
                    textView2.setText(R.string.trade_suspend);
                }
            } else if (SymbolBean.TRANSFER_BOARD.equals(dVar.n())) {
                textView2.setText(R.string.trade_transfer_board);
            } else {
                textView2.setText(R.string.trade_fuse);
            }
        } else if (!SymbolBean.PRE_ONLINE.equals(dVar.n()) || dVar.r() <= DateTimeUtils.v()) {
            textView.setTextColor(ContextCompat.getColor(context2, e(dVar2)));
            if (Double.compare(h02, 0.0d) > 0) {
                textView2.setTextColor(resources.getColor(w.h()));
            } else if (Double.compare(h02, 0.0d) < 0) {
                textView2.setTextColor(resources.getColor(w.d()));
            } else {
                textView2.setTextColor(resources.getColor(R.color.color_flat));
            }
        } else {
            textView.setTextColor(ContextCompat.getColor(context2, b(dVar2)));
            textView2.setTextColor(ContextCompat.getColor(context2, b(dVar2)));
            textView2.setText(R.string.trade_pre_online);
        }
        b11.setBackgroundColor(ContextCompat.getColor(context2, c(dVar2)));
        textView3.setBackgroundResource(f0.f(dVar.x(), a1.v().p0(o11), dVar.g()));
        textView3.setTextColor(f0.g(context2, a1.v().p0(o11), dVar.g()));
        String i11 = dVar.i();
        dVar.A();
        int i12 = 0;
        if (!((a1.v().p0(o11) || SymbolBean.ONLINE.equals(dVar.n())) && !TextUtils.isEmpty(i11))) {
            i12 = 4;
        }
        textView3.setVisibility(i12);
        textView3.setText(i11);
        TextView textView5 = (TextView) cVar.itemView.findViewById(R.id.tv_raise_value);
        textView5.setText(dVar.k());
        textView5.setTextColor(dVar.q(context));
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        d dVar = (d) view.getTag(R.id.item_data1);
        if (dVar.c() != null) {
            dVar.c().c(dVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
