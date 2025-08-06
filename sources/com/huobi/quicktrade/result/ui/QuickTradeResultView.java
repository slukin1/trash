package com.huobi.quicktrade.result.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.AlgoSpecificOrderInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.order.bean.OrderBean;
import d7.a1;
import i6.m;
import pro.huobi.R;

public class QuickTradeResultView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f80564b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80565c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80566d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f80567e;

    /* renamed from: f  reason: collision with root package name */
    public View f80568f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f80569g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f80570h;

    /* renamed from: i  reason: collision with root package name */
    public View f80571i;

    public QuickTradeResultView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context) {
        View.inflate(context, R.layout.quick_trade_result_limit_order, this);
        this.f80564b = (TextView) findViewById(R.id.tv_order_price_value);
        this.f80565c = (TextView) findViewById(R.id.tv_order_size_title);
        this.f80566d = (TextView) findViewById(R.id.tv_order_size_value);
        this.f80568f = findViewById(R.id.ll_field_amount);
        this.f80567e = (TextView) findViewById(R.id.tv_order_field_amount_value);
        this.f80571i = findViewById(R.id.ll_stop_price);
        this.f80569g = (TextView) findViewById(R.id.tv_stop_price_title);
        this.f80570h = (TextView) findViewById(R.id.tv_stop_price_value);
    }

    public void b(OrderBean orderBean, int i11) {
        String str;
        String str2;
        if (orderBean != null) {
            SymbolBean J = a1.v().J(orderBean.getSymbol(), TradeType.PRO);
            String str3 = "";
            if (J != null) {
                str = J.getBaseCurrencyDisplayName();
                str2 = J.getQuoteCurrencyDisplayName();
            } else {
                str2 = str3;
                str = str2;
            }
            this.f80564b.setText(String.format("%s %s", new Object[]{m.m(orderBean.getPrice(), PrecisionUtil.A(orderBean.getSymbol())), str2}));
            this.f80565c.setText(getContext().getString(R.string.n_exchange_order_list_entrust_amount));
            this.f80566d.setText(String.format("%s %s", new Object[]{m.m(orderBean.getAmount(), PrecisionUtil.z(orderBean.getSymbol())), str}));
            this.f80567e.setText(String.format("%s %s", new Object[]{m.m(orderBean.getFieldAmount(), PrecisionUtil.z(orderBean.getSymbol())), str}));
            if (i11 == 0) {
                this.f80571i.setVisibility(8);
            } else if (i11 == 1) {
                this.f80571i.setVisibility(8);
                this.f80564b.setText(getContext().getString(R.string.n_trade_market_hint));
                if (orderBean.isBuy()) {
                    this.f80565c.setText(getContext().getString(R.string.n_exchange_order_entrusts_total_volume));
                    this.f80566d.setText(String.format("%s %s", new Object[]{m.m(orderBean.getAmount(), PrecisionUtil.y(orderBean.getSymbol())), str2}));
                    return;
                }
                this.f80565c.setText(String.format(getContext().getString(R.string.n_exchange_order_list_entrust_amount), new Object[0]));
                this.f80566d.setText(String.format("%s %s", new Object[]{m.m(orderBean.getAmount(), PrecisionUtil.z(orderBean.getSymbol())), str}));
            } else {
                this.f80565c.setText(getContext().getString(R.string.n_exchange_order_list_entrust_amount));
                this.f80571i.setVisibility(0);
                this.f80569g.setText(getContext().getString(R.string.n_exchange_order_list_trigger_condition));
                if ("gte".equalsIgnoreCase(orderBean.getOperator())) {
                    str3 = "≥";
                } else if (MTCommonConstants.Network.RADIO_4G.equalsIgnoreCase(orderBean.getOperator())) {
                    str3 = "≤";
                }
                this.f80570h.setText(String.format("%s%s %s", new Object[]{str3, m.m(orderBean.getStopPrice(), PrecisionUtil.A(orderBean.getSymbol())), str2}));
            }
        }
    }

    public void setData(AlgoSpecificOrderInfo algoSpecificOrderInfo) {
        String str;
        String str2;
        if (algoSpecificOrderInfo != null) {
            SymbolBean J = a1.v().J(algoSpecificOrderInfo.getSymbol(), TradeType.PRO);
            String str3 = "";
            if (J != null) {
                str = J.getBaseCurrencyDisplayName();
                str2 = J.getQuoteCurrencyDisplayName();
            } else {
                str2 = str3;
                str = str2;
            }
            this.f80571i.setVisibility(0);
            this.f80569g.setText(getContext().getString(R.string.n_exchange_order_list_trigger_condition));
            if ("gte".equalsIgnoreCase(algoSpecificOrderInfo.getOperator())) {
                str3 = "≥";
            } else if (MTCommonConstants.Network.RADIO_4G.equalsIgnoreCase(algoSpecificOrderInfo.getOperator())) {
                str3 = "≤";
            }
            this.f80570h.setText(String.format("%s%s %s", new Object[]{str3, m.m(algoSpecificOrderInfo.getStopPrice(), PrecisionUtil.A(algoSpecificOrderInfo.getSymbol())), str2}));
            if (algoSpecificOrderInfo.isLimitOrderType()) {
                this.f80564b.setText(String.format("%s %s", new Object[]{m.m(algoSpecificOrderInfo.getOrderPrice(), PrecisionUtil.A(algoSpecificOrderInfo.getSymbol())), str2}));
            } else {
                this.f80564b.setText(getContext().getString(R.string.n_trade_market_hint));
            }
            if (algoSpecificOrderInfo.isLimitOrderType()) {
                this.f80565c.setText(getContext().getString(R.string.n_exchange_order_list_entrust_amount));
                this.f80566d.setText(String.format("%s %s", new Object[]{m.m(algoSpecificOrderInfo.getOrderSize(), PrecisionUtil.z(algoSpecificOrderInfo.getSymbol())), str}));
            } else if ("buy".equals(algoSpecificOrderInfo.getOrderSide())) {
                this.f80565c.setText(getContext().getString(R.string.n_exchange_order_entrusts_total_volume));
                this.f80566d.setText(String.format("%s %s", new Object[]{m.m(algoSpecificOrderInfo.getOrderValue(), PrecisionUtil.y(algoSpecificOrderInfo.getSymbol())), str2}));
            } else {
                this.f80565c.setText(getContext().getString(R.string.n_exchange_order_list_entrust_amount));
                this.f80566d.setText(String.format("%s %s", new Object[]{m.m(algoSpecificOrderInfo.getOrderSize(), PrecisionUtil.z(algoSpecificOrderInfo.getSymbol())), str}));
            }
            this.f80568f.setVisibility(8);
        }
    }

    public QuickTradeResultView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
