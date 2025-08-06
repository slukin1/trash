package com.huobi.trade.handler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import bt.p1;
import bt.q1;
import bt.r1;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import i6.r;
import pro.huobi.R;
import s9.c;
import vo.b;

public class PlanOrderHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public TextView f81988b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f81989c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f81990d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f81991e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f81992f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f81993g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f81994h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f81995i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f81996j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f81997k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f81998l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f81999m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f82000n;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AlgoOrderInfo f82001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f82002c;

        public a(AlgoOrderInfo algoOrderInfo, Context context) {
            this.f82001b = algoOrderInfo;
            this.f82002c = context;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if ("rejected".equals(this.f82001b.getOrderStatus())) {
                String errMessage = this.f82001b.getErrMessage();
                if (TextUtils.isEmpty(errMessage)) {
                    errMessage = "";
                }
                DialogUtils.X((FragmentActivity) oa.a.g().b(), this.f82002c.getString(R.string.n_exchange_failure_reason), errMessage, (String) null, this.f82002c.getString(R.string.n_known), r1.f12968a);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void g(Context context, b bVar, boolean z11, View view) {
        k0.O(context, bVar.d(), z11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void h(Context context, b bVar, boolean z11, View view) {
        k0.O(context, bVar.d(), z11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String d(String str) {
        return "(" + str + ")";
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        String str;
        String str2;
        v9.c cVar2 = cVar;
        b bVar2 = bVar;
        Context context = cVar2.itemView.getContext();
        f(cVar.e());
        AlgoOrderInfo c11 = bVar.c();
        SymbolBean J = a1.v().J(bVar.d(), TradeType.PRO);
        String str3 = "";
        if (J != null) {
            str = J.getBaseCurrencyDisplayName();
            str2 = J.getQuoteCurrencyDisplayName();
        } else {
            str2 = str3;
            str = str2;
        }
        boolean equals = "buy".equals(c11.getOrderSide());
        this.f81989c.setText(str + "/" + str2);
        this.f81990d.setText(DateTimeUtils.D(c11.getOrderOrigTime()));
        this.f81989c.setOnClickListener(new q1(context, bVar2, equals));
        this.f81988b.setOnClickListener(new p1(context, bVar2, equals));
        if ("buy".equals(c11.getOrderSide())) {
            this.f81988b.setText(R.string.order_buy_label);
            this.f81988b.setTextColor(ContextCompat.getColor(context, w.h()));
        } else if ("sell".equals(c11.getOrderSide())) {
            this.f81988b.setText(R.string.order_sell_label);
            this.f81988b.setTextColor(ContextCompat.getColor(context, w.d()));
        }
        this.f82000n.setVisibility(bVar.c().getSource().contains("fl") ? 0 : 8);
        this.f81999m.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        if ("triggered".equals(c11.getOrderStatus())) {
            this.f81999m.setText(R.string.n_exchange_order_triggered);
            this.f81999m.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if ("rejected".equals(c11.getOrderStatus())) {
            this.f81999m.setText(R.string.n_exchange_order_rejected);
            this.f81999m.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(context, R.drawable.icon_ask), (Drawable) null);
        } else if ("canceled".equals(c11.getOrderStatus())) {
            this.f81999m.setText(R.string.n_exchange_order_list_canceled);
            this.f81999m.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.f81999m.setOnClickListener(new a(c11, context));
        this.f81991e.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_list_entrust_price), d(str2)}));
        if (c11.isLimitOrderType()) {
            this.f81992f.setText(m.m(c11.getOrderPrice(), PrecisionUtil.A(bVar.d())));
        } else {
            this.f81992f.setText(R.string.n_exchange_order_list_market);
        }
        if (c11.isLimitOrderType()) {
            this.f81993g.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_list_entrust_amount), d(str)}));
            this.f81994h.setText(m.m(c11.getOrderSize(), PrecisionUtil.z(bVar.d())));
        } else if ("buy".equals(c11.getOrderSide())) {
            this.f81993g.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_entrusts_total_volume), d(str2)}));
            this.f81994h.setText(m.m(c11.getOrderValue(), PrecisionUtil.y(bVar.d())));
        } else {
            this.f81993g.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_list_entrust_amount), d(str)}));
            this.f81994h.setText(m.m(c11.getOrderSize(), PrecisionUtil.z(bVar.d())));
        }
        if ("canceled".equals(c11.getOrderStatus())) {
            this.f81995i.setVisibility(8);
            this.f81996j.setVisibility(8);
            cVar2.itemView.setBackgroundColor(context.getColor(R.color.baseColorRemarksBackground));
        } else {
            if (c11.getOrderCreateTime() == 0) {
                this.f81995i.setVisibility(8);
                this.f81996j.setVisibility(8);
            } else {
                this.f81995i.setVisibility(0);
                this.f81996j.setVisibility(0);
                this.f81996j.setText(DateTimeUtils.D(c11.getOrderCreateTime()));
            }
            cVar2.itemView.setBackgroundResource(R.drawable.selector_trade_order_bg);
        }
        this.f81997k.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_list_trigger_condition), d(str2)}));
        if ("gte".equalsIgnoreCase(c11.getOperator())) {
            str3 = "≥";
        } else if (MTCommonConstants.Network.RADIO_4G.equalsIgnoreCase(c11.getOperator())) {
            str3 = "≤";
        }
        this.f81998l.setText(String.format("%s%s", new Object[]{str3, m.m(c11.getStopPrice(), PrecisionUtil.A(bVar.d()))}));
    }

    public final void f(r rVar) {
        this.f81988b = (TextView) rVar.b(R.id.tv_order_type);
        this.f81989c = (TextView) rVar.b(R.id.tv_symbol);
        this.f81999m = (TextView) rVar.b(R.id.tv_order_process_result);
        this.f81990d = (TextView) rVar.b(R.id.tv_order_time);
        this.f81991e = (TextView) rVar.b(R.id.tv_order_price_title);
        this.f81992f = (TextView) rVar.b(R.id.tv_order_price_value);
        this.f81993g = (TextView) rVar.b(R.id.tv_order_size_title);
        this.f81994h = (TextView) rVar.b(R.id.tv_order_size_value);
        this.f81995i = (TextView) rVar.b(R.id.tv_order_create_time_title);
        this.f81996j = (TextView) rVar.b(R.id.tv_order_create_time_value);
        this.f81997k = (TextView) rVar.b(R.id.tv_stop_price_title);
        this.f81998l = (TextView) rVar.b(R.id.tv_stop_price_value);
        this.f82000n = (TextView) rVar.b(R.id.tv_order_fl);
    }

    public int getResId() {
        return R.layout.item_plan_trade_order;
    }
}
