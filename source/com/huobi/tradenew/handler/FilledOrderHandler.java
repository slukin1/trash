package com.huobi.tradenew.handler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.trade.bean.TradeOrderType;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import pro.huobi.R;
import pt.d;
import pt.e;
import s9.c;

public class FilledOrderHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public TextView f82826b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f82827c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f82828d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f82829e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f82830f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f82831g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f82832h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f82833i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f82834j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f82835k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f82836l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f82837m;

    @SensorsDataInstrumented
    public static /* synthetic */ void g(Context context, OrderBeanDetails orderBeanDetails, View view) {
        k0.O(context, orderBeanDetails.getSymbol(), orderBeanDetails.isBuy());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void h(Context context, OrderBeanDetails orderBeanDetails, View view) {
        k0.O(context, orderBeanDetails.getSymbol(), orderBeanDetails.isBuy());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String d(String str) {
        return "(" + str + ")";
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, OrderBeanDetails orderBeanDetails, ViewGroup viewGroup) {
        String str;
        String str2;
        OrderBeanDetails orderBeanDetails2 = orderBeanDetails;
        Context context = cVar.itemView.getContext();
        f(cVar.e());
        String type = orderBeanDetails.getType();
        String source = orderBeanDetails.getSource();
        SymbolBean J = a1.v().J(orderBeanDetails.getSymbol(), TradeType.PRO);
        if (J != null) {
            str = J.getBaseCurrencyDisplayName();
            str2 = J.getQuoteCurrencyDisplayName();
        } else {
            str2 = "";
            str = str2;
        }
        this.f82827c.setText(str + "/" + str2);
        this.f82828d.setText(DateTimeUtils.C(orderBeanDetails.getCreatedAt()));
        this.f82827c.setOnClickListener(new e(context, orderBeanDetails2));
        this.f82826b.setOnClickListener(new d(context, orderBeanDetails2));
        boolean e11 = TradeOrderType.e(source);
        if (TradeOrderType.c(type)) {
            if (e11) {
                this.f82826b.setText(R.string.order_system_buy_label);
            } else {
                this.f82826b.setText(R.string.order_buy_label);
            }
            this.f82826b.setTextColor(ContextCompat.getColor(context, w.h()));
        } else if (TradeOrderType.d(type)) {
            if (e11) {
                this.f82826b.setText(R.string.order_system_sell_label);
            } else {
                this.f82826b.setText(R.string.order_sell_label);
            }
            this.f82826b.setTextColor(ContextCompat.getColor(context, w.d()));
        } else if ("buy-market".equals(type)) {
            if (e11) {
                this.f82826b.setText(R.string.order_system_buy_label);
            } else {
                this.f82826b.setText(R.string.order_buy_label);
            }
            this.f82826b.setTextColor(ContextCompat.getColor(context, w.h()));
        } else if ("sell-market".equals(type)) {
            if (e11) {
                this.f82826b.setText(R.string.order_system_sell_label);
            } else {
                this.f82826b.setText(R.string.order_sell_label);
            }
            this.f82826b.setTextColor(ContextCompat.getColor(context, w.d()));
        } else if ("sell-market-grid".equals(type) || "sell-limit-grid".equals(type)) {
            if (e11) {
                this.f82826b.setText(R.string.order_system_sell_label);
            } else {
                this.f82826b.setText(R.string.order_sell_label);
            }
            this.f82826b.setTextColor(ContextCompat.getColor(context, w.d()));
        } else if ("buy-limit-grid".equals(type) || "buy-market-grid".equals(type)) {
            if (e11) {
                this.f82826b.setText(R.string.order_system_buy_label);
            } else {
                this.f82826b.setText(R.string.order_buy_label);
            }
            this.f82826b.setTextColor(ContextCompat.getColor(context, w.h()));
        } else {
            this.f82826b.setText("");
        }
        if ("sell-market".equals(type) || "buy-market".equals(type) || "sell-market-grid".equals(type) || "buy-market-grid".equals(type)) {
            this.f82829e.setText(R.string.n_exchange_order_list_market);
        } else {
            this.f82829e.setText(R.string.n_exchange_order_list_limit);
        }
        if (!TextUtils.isEmpty(source) && source.contains("stop")) {
            this.f82829e.setText(String.format("%s-%s", new Object[]{context.getText(R.string.n_exchange_plan_entrusts), this.f82829e.getText().toString()}));
        } else if (TradeOrderType.f(type)) {
            this.f82829e.setText(R.string.trade_trend_stop);
        }
        this.f82830f.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_detail_trade_price), d(str2)}));
        this.f82831g.setText(m.m(orderBeanDetails.getPrice(), PrecisionUtil.A(orderBeanDetails.getSymbol())));
        this.f82832h.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_detail_trade_amount), d(str)}));
        this.f82833i.setText(m.m(orderBeanDetails.getFilledAmount(), PrecisionUtil.z(orderBeanDetails.getSymbol())));
        this.f82834j.setText(String.format("%s%s", new Object[]{context.getText(R.string.n_exchange_order_list_filled_volume), d(str2)}));
        this.f82835k.setText(m.q(m.a(orderBeanDetails.getPrice()).multiply(m.a(orderBeanDetails.getFilledAmount())), PrecisionUtil.y(orderBeanDetails.getSymbol())));
        String u11 = m.u(orderBeanDetails.getFilledFees(), PrecisionUtil.B(orderBeanDetails.getSymbol(), orderBeanDetails.isBuy()));
        String m11 = m.m(orderBeanDetails.getFilledPoints(), PrecisionUtil.c(orderBeanDetails.getSymbol()));
        String m12 = m.m(m11, PrecisionUtil.c(orderBeanDetails.getSymbol()));
        BigDecimal a11 = m.a(u11);
        BigDecimal a12 = m.a(m11);
        BigDecimal a13 = m.a(m12);
        if (!TextUtils.isEmpty(u11)) {
            u11 = a11.multiply(m.a("-1")).toPlainString();
            if (m.a(u11).compareTo(BigDecimal.ZERO) == 1) {
                u11 = "+" + u11;
            }
        }
        if (!TextUtils.isEmpty(m11)) {
            m11 = a12.multiply(m.a("-1")).toPlainString();
            if (m.a(m11).compareTo(BigDecimal.ZERO) == 1) {
                m11 = "+" + m11;
            }
        }
        if (!TextUtils.isEmpty(m12)) {
            m12 = a13.multiply(m.a("-1")).toPlainString();
            if (m.a(m12).compareTo(BigDecimal.ZERO) == 1) {
                m12 = "+" + m12;
            }
        }
        if (BigDecimal.ZERO.compareTo(a11) != 0) {
            if (a11.compareTo(BigDecimal.ZERO) > 0) {
                TextView textView = this.f82836l;
                String string = context.getString(R.string.order_fee_icon_label);
                Object[] objArr = new Object[1];
                if (orderBeanDetails.isBuy()) {
                    str2 = str;
                }
                objArr[0] = str2;
                textView.setText(String.format(string, objArr));
            } else {
                TextView textView2 = this.f82836l;
                String string2 = context.getString(R.string.order_fee_icon_label);
                Object[] objArr2 = new Object[1];
                if (!orderBeanDetails.isBuy()) {
                    str2 = str;
                }
                objArr2[0] = str2;
                textView2.setText(String.format(string2, objArr2));
            }
            this.f82837m.setText(u11);
        } else if ("ht".equalsIgnoreCase(orderBeanDetails.getFeeDeductCurrency())) {
            this.f82836l.setText(String.format(context.getString(R.string.order_fee_icon_label), new Object[]{StringUtils.i("ht")}));
            this.f82837m.setText(m12);
        } else if ("htx".equalsIgnoreCase(orderBeanDetails.getFeeDeductCurrency())) {
            this.f82836l.setText(String.format(context.getString(R.string.order_fee_icon_label), new Object[]{StringUtils.i("htx")}));
            this.f82837m.setText(m12);
        } else if ("TRX".equalsIgnoreCase(orderBeanDetails.getFeeDeductCurrency())) {
            this.f82836l.setText(String.format(context.getString(R.string.order_fee_icon_label), new Object[]{"TRX"}));
            this.f82837m.setText(m12);
        } else {
            this.f82836l.setText(String.format(context.getString(R.string.order_fee_icon_label), new Object[]{context.getString(R.string.points_pack_points)}));
            this.f82837m.setText(m11);
        }
    }

    public final void f(r rVar) {
        this.f82826b = (TextView) rVar.b(R.id.tv_order_type);
        this.f82827c = (TextView) rVar.b(R.id.tv_symbol);
        this.f82828d = (TextView) rVar.b(R.id.tv_order_time);
        this.f82829e = (TextView) rVar.b(R.id.tv_way_content);
        this.f82830f = (TextView) rVar.b(R.id.tv_filled_order_price_title);
        this.f82831g = (TextView) rVar.b(R.id.tv_filled_order_price_content);
        this.f82832h = (TextView) rVar.b(R.id.tv_amount_volume_title);
        this.f82833i = (TextView) rVar.b(R.id.tv_amount_volume_content);
        this.f82834j = (TextView) rVar.b(R.id.tv_order_total_volume_title);
        this.f82835k = (TextView) rVar.b(R.id.tv_order_total_volume_content);
        this.f82836l = (TextView) rVar.b(R.id.tv_order_fee_title);
        this.f82837m = (TextView) rVar.b(R.id.tv_order_fee_content);
    }

    public int getResId() {
        return R.layout.item_filled_order;
    }
}
