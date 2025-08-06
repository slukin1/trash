package com.huobi.trade.handler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bt.i0;
import bt.j0;
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
import s9.c;

public class FilledOrderHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public TextView f81974b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f81975c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f81976d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f81977e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f81978f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f81979g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f81980h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f81981i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f81982j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f81983k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f81984l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f81985m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f81986n;

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
        r e11 = cVar.e();
        f(e11);
        String type = orderBeanDetails.getType();
        String source = orderBeanDetails.getSource();
        ((TextView) e11.b(R.id.tv_order_deal_type)).setText(orderBeanDetails.getRole());
        this.f81986n.setVisibility(orderBeanDetails.getSource().contains("fl") ? 0 : 8);
        SymbolBean J = a1.v().J(orderBeanDetails.getSymbol(), TradeType.PRO);
        if (J != null) {
            str = J.getBaseCurrencyDisplayName();
            str2 = J.getQuoteCurrencyDisplayName();
        } else {
            str2 = "";
            str = str2;
        }
        this.f81975c.setText(str + "/" + str2);
        this.f81976d.setText(DateTimeUtils.D(orderBeanDetails.getCreatedAt()));
        this.f81975c.setOnClickListener(new j0(context, orderBeanDetails2));
        this.f81974b.setOnClickListener(new i0(context, orderBeanDetails2));
        boolean e12 = TradeOrderType.e(source);
        if (TradeOrderType.c(type)) {
            if (e12) {
                this.f81974b.setText(R.string.order_system_buy_label);
            } else {
                this.f81974b.setText(R.string.order_buy_label);
            }
            this.f81974b.setTextColor(ContextCompat.getColor(context, w.h()));
        } else if (TradeOrderType.d(type)) {
            if (e12) {
                this.f81974b.setText(R.string.order_system_sell_label);
            } else {
                this.f81974b.setText(R.string.order_sell_label);
            }
            this.f81974b.setTextColor(ContextCompat.getColor(context, w.d()));
        } else if ("buy-market".equals(type)) {
            if (e12) {
                this.f81974b.setText(R.string.order_system_buy_label);
            } else {
                this.f81974b.setText(R.string.order_buy_label);
            }
            this.f81974b.setTextColor(ContextCompat.getColor(context, w.h()));
        } else if ("sell-market".equals(type)) {
            if (e12) {
                this.f81974b.setText(R.string.order_system_sell_label);
            } else {
                this.f81974b.setText(R.string.order_sell_label);
            }
            this.f81974b.setTextColor(ContextCompat.getColor(context, w.d()));
        } else if ("sell-market-grid".equals(type) || "sell-limit-grid".equals(type)) {
            if (e12) {
                this.f81974b.setText(R.string.order_system_sell_label);
            } else {
                this.f81974b.setText(R.string.order_sell_label);
            }
            this.f81974b.setTextColor(ContextCompat.getColor(context, w.d()));
        } else if ("buy-limit-grid".equals(type) || "buy-market-grid".equals(type)) {
            if (e12) {
                this.f81974b.setText(R.string.order_system_buy_label);
            } else {
                this.f81974b.setText(R.string.order_buy_label);
            }
            this.f81974b.setTextColor(ContextCompat.getColor(context, w.h()));
        } else {
            this.f81974b.setText("");
        }
        if ("sell-market".equals(type) || "buy-market".equals(type) || "sell-market-grid".equals(type) || "buy-market-grid".equals(type)) {
            this.f81977e.setText(R.string.n_exchange_order_list_market);
        } else if (type.toLowerCase().endsWith("-maker")) {
            this.f81977e.setText(R.string.n_contract_trade_post_only);
        } else if (type.toLowerCase().endsWith("-ioc")) {
            this.f81977e.setText(context.getResources().getString(R.string.n_exchange_order_list_limit) + "-IOC");
        } else if (type.toLowerCase().endsWith("-fok")) {
            this.f81977e.setText(context.getResources().getString(R.string.n_exchange_order_list_limit) + "-FOK");
        } else {
            this.f81977e.setText(context.getResources().getString(R.string.n_exchange_order_list_limit) + "-GTC");
        }
        if (!TextUtils.isEmpty(source) && source.contains("stop")) {
            this.f81977e.setText(String.format("%s-%s", new Object[]{context.getText(R.string.n_exchange_plan_entrusts), this.f81977e.getText().toString()}));
        } else if (TradeOrderType.f(type)) {
            this.f81977e.setText(R.string.trade_trend_stop);
        }
        this.f81978f.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_detail_trade_price), d(str2)}));
        this.f81979g.setText(m.m(orderBeanDetails.getPrice(), PrecisionUtil.A(orderBeanDetails.getSymbol())));
        this.f81980h.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_detail_trade_amount), d(str)}));
        this.f81981i.setText(m.m(orderBeanDetails.getFilledAmount(), PrecisionUtil.z(orderBeanDetails.getSymbol())));
        this.f81982j.setText(String.format("%s%s", new Object[]{context.getText(R.string.n_exchange_order_list_filled_volume), d(str2)}));
        this.f81983k.setText(m.q(m.a(orderBeanDetails.getPrice()).multiply(m.a(orderBeanDetails.getFilledAmount())), PrecisionUtil.y(orderBeanDetails.getSymbol())));
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
                TextView textView = this.f81984l;
                String string = context.getString(R.string.order_fee_icon_label);
                Object[] objArr = new Object[1];
                if (orderBeanDetails.isBuy()) {
                    str2 = str;
                }
                objArr[0] = str2;
                textView.setText(String.format(string, objArr));
            } else {
                TextView textView2 = this.f81984l;
                String string2 = context.getString(R.string.order_fee_icon_label);
                Object[] objArr2 = new Object[1];
                if (!orderBeanDetails.isBuy()) {
                    str2 = str;
                }
                objArr2[0] = str2;
                textView2.setText(String.format(string2, objArr2));
            }
            this.f81985m.setText(u11);
        } else if ("ht".equalsIgnoreCase(orderBeanDetails.getFeeDeductCurrency())) {
            this.f81984l.setText(String.format(context.getString(R.string.order_fee_icon_label), new Object[]{StringUtils.i("ht")}));
            this.f81985m.setText(m12);
        } else if ("htx".equalsIgnoreCase(orderBeanDetails.getFeeDeductCurrency())) {
            this.f81984l.setText(String.format(context.getString(R.string.order_fee_icon_label), new Object[]{StringUtils.i("htx")}));
            this.f81985m.setText(m12);
        } else if ("TRX".equalsIgnoreCase(orderBeanDetails.getFeeDeductCurrency())) {
            this.f81984l.setText(String.format(context.getString(R.string.order_fee_icon_label), new Object[]{"TRX"}));
            this.f81985m.setText(m12);
        } else {
            this.f81984l.setText(String.format(context.getString(R.string.order_fee_icon_label), new Object[]{context.getString(R.string.points_pack_points)}));
            this.f81985m.setText(m11);
        }
    }

    public final void f(r rVar) {
        this.f81974b = (TextView) rVar.b(R.id.tv_order_type);
        this.f81975c = (TextView) rVar.b(R.id.tv_symbol);
        this.f81976d = (TextView) rVar.b(R.id.tv_order_time);
        this.f81977e = (TextView) rVar.b(R.id.tv_way_content);
        this.f81978f = (TextView) rVar.b(R.id.tv_filled_order_price_title);
        this.f81979g = (TextView) rVar.b(R.id.tv_filled_order_price_content);
        this.f81980h = (TextView) rVar.b(R.id.tv_amount_volume_title);
        this.f81981i = (TextView) rVar.b(R.id.tv_amount_volume_content);
        this.f81982j = (TextView) rVar.b(R.id.tv_order_total_volume_title);
        this.f81983k = (TextView) rVar.b(R.id.tv_order_total_volume_content);
        this.f81984l = (TextView) rVar.b(R.id.tv_order_fee_title);
        this.f81985m = (TextView) rVar.b(R.id.tv_order_fee_content);
        this.f81986n = (TextView) rVar.b(R.id.tv_order_fl);
    }

    public int getResId() {
        return R.layout.item_filled_order;
    }
}
