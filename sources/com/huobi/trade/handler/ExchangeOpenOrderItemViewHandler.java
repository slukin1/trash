package com.huobi.trade.handler;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import bh.j;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.VibrateManager;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.ExchangeOpenOrder;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.order.bean.ExchangeOpenOrderItem;
import com.huobi.order.service.OrderService;
import com.huobi.trade.bean.AssetAndOrderUpdateEvent;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import q6.d;
import s9.c;
import tq.p;
import u6.g;

public class ExchangeOpenOrderItemViewHandler implements c, View.OnClickListener {

    public class a extends d {
        public a(g gVar) {
            super(gVar);
        }

        public void onAfter() {
            super.onAfter();
            EventBus.d().k(new AssetAndOrderUpdateEvent());
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            HuobiToastUtil.k(j.c(), R.string.string_order_cancel_fail);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.k(j.c(), R.string.string_order_cancel_fail);
            } else {
                super.onFailed(aPIStatusErrorException);
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            HuobiToastUtil.t(j.c(), R.string.string_order_cancel_ok);
            s6.a.b(j.c()).c(R.raw.order_canceled);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(ExchangeOpenOrder exchangeOpenOrder, ExchangeOpenOrderItem exchangeOpenOrderItem, TextView textView, View view) {
        c(d(view), exchangeOpenOrder, exchangeOpenOrderItem);
        VibrateManager.a(textView);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void c(Context context, ExchangeOpenOrder exchangeOpenOrder, ExchangeOpenOrderItem exchangeOpenOrderItem) {
        g gVar = context instanceof g ? (g) context : null;
        if (!NetworkStatus.c(j.c())) {
            HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
        } else if (exchangeOpenOrderItem.g()) {
            HuobiToastUtil.k(context, R.string.n_exchange_call_auction_order_cancel);
        } else {
            ((OrderService) p.X(TradeType.PRO, OrderService.class)).submitCancel(exchangeOpenOrder.getId(), "user-actively-cancels-order-android").delay(1, TimeUnit.SECONDS).compose(p.a0()).compose(RxJavaHelper.t(gVar)).subscribe(new a(gVar));
        }
    }

    public Activity d(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0308, code lost:
        if ("submitted".equals(r4.getState()) != false) goto L_0x02fa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x03bd  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r24, int r25, com.huobi.order.bean.ExchangeOpenOrderItem r26, android.view.ViewGroup r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r24
            android.view.View r3 = r2.itemView
            android.content.Context r3 = r3.getContext()
            android.content.res.Resources r4 = r3.getResources()
            i6.r r2 = r24.e()
            r5 = 2131436611(0x7f0b2443, float:1.8495097E38)
            android.view.View r5 = r2.b(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r6 = 2131436606(0x7f0b243e, float:1.8495087E38)
            android.view.View r6 = r2.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r7 = 2131436589(0x7f0b242d, float:1.8495053E38)
            android.view.View r7 = r2.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r8 = 2131436592(0x7f0b2430, float:1.8495059E38)
            android.view.View r8 = r2.b(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r9 = 2131436569(0x7f0b2419, float:1.8495012E38)
            android.view.View r9 = r2.b(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r10 = 2131436568(0x7f0b2418, float:1.849501E38)
            android.view.View r10 = r2.b(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r11 = 2131433700(0x7f0b18e4, float:1.8489193E38)
            android.view.View r11 = r2.b(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r12 = 2131433259(0x7f0b172b, float:1.8488299E38)
            android.view.View r12 = r2.b(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r13 = 2131433266(0x7f0b1732, float:1.8488313E38)
            android.view.View r13 = r2.b(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            r14 = 2131436866(0x7f0b2542, float:1.8495615E38)
            android.view.View r14 = r2.b(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r15 = 2131430840(0x7f0b0db8, float:1.8483392E38)
            android.view.View r15 = r2.b(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r25 = r4
            r4 = 2131430839(0x7f0b0db7, float:1.848339E38)
            android.view.View r4 = r2.b(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r24 = r4
            r4 = 2131430841(0x7f0b0db9, float:1.8483394E38)
            android.view.View r4 = r2.b(r4)
            r27 = r15
            r15 = 2131436451(0x7f0b23a3, float:1.8494773E38)
            android.view.View r15 = r2.b(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r16 = r4
            com.hbg.lib.data.symbol.TradeType r4 = r26.e()
            r17 = r7
            com.hbg.lib.data.symbol.TradeType r7 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN
            r18 = r10
            r10 = 0
            if (r4 != r7) goto L_0x00af
            r15.setVisibility(r10)
            r4 = 2132021049(0x7f140f39, float:1.9680478E38)
            r15.setText(r4)
            goto L_0x00c5
        L_0x00af:
            com.hbg.lib.data.symbol.TradeType r4 = r26.e()
            com.hbg.lib.data.symbol.TradeType r7 = com.hbg.lib.data.symbol.TradeType.MARGIN
            if (r4 != r7) goto L_0x00c1
            r15.setVisibility(r10)
            r4 = 2132021119(0x7f140f7f, float:1.968062E38)
            r15.setText(r4)
            goto L_0x00c5
        L_0x00c1:
            r4 = 4
            r15.setVisibility(r4)
        L_0x00c5:
            com.hbg.lib.network.pro.core.bean.ExchangeOpenOrder r4 = r26.d()
            r14.setTag(r1)
            r14.setOnClickListener(r0)
            r5.setTag(r1)
            r5.setOnClickListener(r0)
            d7.a1 r7 = d7.a1.v()
            java.lang.String r15 = r4.getSymbol()
            com.hbg.lib.data.symbol.TradeType r10 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.network.pro.core.bean.SymbolBean r7 = r7.J(r15, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            if (r7 == 0) goto L_0x00f3
            java.lang.String r15 = r7.getBaseCurrencyDisplayName()
            java.lang.String r7 = r7.getQuoteCurrencyDisplayName()
            goto L_0x0142
        L_0x00f3:
            d7.a1 r7 = d7.a1.v()
            java.util.List r7 = r7.j()
            java.util.Iterator r7 = r7.iterator()
            java.lang.String r15 = ""
            r19 = r15
        L_0x0103:
            boolean r20 = r7.hasNext()
            if (r20 == 0) goto L_0x013c
            java.lang.Object r20 = r7.next()
            r21 = r7
            r7 = r20
            java.lang.String r7 = (java.lang.String) r7
            r20 = r15
            java.lang.String r15 = r4.getSymbol()
            int r15 = r15.lastIndexOf(r7)
            if (r15 <= 0) goto L_0x0135
            java.lang.String r15 = r4.getSymbol()
            java.lang.String r0 = r4.getSymbol()
            int r0 = r0.lastIndexOf(r7)
            r22 = r7
            r7 = 0
            java.lang.String r19 = r15.substring(r7, r0)
            r15 = r22
            goto L_0x0137
        L_0x0135:
            r15 = r20
        L_0x0137:
            r0 = r23
            r7 = r21
            goto L_0x0103
        L_0x013c:
            r20 = r15
            r15 = r19
            r7 = r20
        L_0x0142:
            r10.append(r15)
            java.lang.String r0 = "/"
            r10.append(r0)
            r10.append(r7)
            r14.setText(r10)
            java.lang.String r0 = r4.getType()
            java.lang.String r10 = r4.getSource()
            java.lang.String r14 = r4.getType()
            java.lang.String r10 = com.huobi.trade.bean.TradeOrderType.a(r10, r14, r3)
            r5.setText(r10)
            boolean r10 = r26.f()
            r14 = 2131100920(0x7f0604f8, float:1.7814235E38)
            r19 = 2131102051(0x7f060963, float:1.781653E38)
            if (r10 == 0) goto L_0x018a
            int r10 = com.hbg.lib.core.util.w.h()
            int r10 = androidx.core.content.ContextCompat.getColor(r3, r10)
            r5.setTextColor(r10)
            boolean r10 = com.hbg.lib.core.util.w.l()
            if (r10 == 0) goto L_0x0182
            r14 = r19
        L_0x0182:
            int r10 = androidx.core.content.ContextCompat.getColor(r3, r14)
            r5.setBackgroundColor(r10)
            goto L_0x01a5
        L_0x018a:
            int r10 = com.hbg.lib.core.util.w.d()
            int r10 = androidx.core.content.ContextCompat.getColor(r3, r10)
            r5.setTextColor(r10)
            boolean r10 = com.hbg.lib.core.util.w.l()
            if (r10 == 0) goto L_0x019c
            goto L_0x019e
        L_0x019c:
            r14 = r19
        L_0x019e:
            int r10 = androidx.core.content.ContextCompat.getColor(r3, r14)
            r5.setBackgroundColor(r10)
        L_0x01a5:
            java.lang.String r5 = "buy-market"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01ca
            java.lang.String r5 = "sell-market"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x01b6
            goto L_0x01ca
        L_0x01b6:
            java.lang.String r0 = r4.getPrice()
            java.lang.String r5 = r4.getSymbol()
            int r5 = com.hbg.lib.data.symbol.PrecisionUtil.A(r5)
            java.lang.String r0 = i6.m.m(r0, r5)
            r8.setText(r0)
            goto L_0x01d0
        L_0x01ca:
            r0 = 2132021960(0x7f1412c8, float:1.9682326E38)
            r8.setText(r0)
        L_0x01d0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r5 = 2132021961(0x7f1412c9, float:1.9682328E38)
            java.lang.String r5 = r3.getString(r5)
            r0.append(r5)
            java.lang.String r5 = "(%s)"
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r8 = 1
            java.lang.Object[] r10 = new java.lang.Object[r8]
            r14 = 0
            r10[r14] = r7
            java.lang.String r0 = java.lang.String.format(r0, r10)
            r11.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r10 = 2132021951(0x7f1412bf, float:1.9682308E38)
            java.lang.String r10 = r3.getString(r10)
            r0.append(r10)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r10 = new java.lang.Object[r8]
            r10[r14] = r15
            java.lang.String r0 = java.lang.String.format(r0, r10)
            r12.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r10 = 2132022012(0x7f1412fc, float:1.9682432E38)
            java.lang.String r10 = r3.getString(r10)
            r0.append(r10)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r10 = new java.lang.Object[r8]
            r10[r14] = r15
            java.lang.String r0 = java.lang.String.format(r0, r10)
            r13.setText(r0)
            long r10 = r4.getCreatedAt()
            java.lang.String r0 = com.hbg.lib.common.utils.DateTimeUtils.C(r10)
            r6.setText(r0)
            r0 = 2131430267(0x7f0b0b7b, float:1.848223E38)
            android.view.View r0 = r2.b(r0)
            r6 = 2131430268(0x7f0b0b7c, float:1.8482232E38)
            android.view.View r6 = r2.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r10 = 2131430266(0x7f0b0b7a, float:1.8482228E38)
            android.view.View r2 = r2.b(r10)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r10 = r4.getIceAmount()
            java.math.BigDecimal r10 = i6.m.a(r10)
            java.math.BigDecimal r11 = java.math.BigDecimal.ZERO
            int r11 = r10.compareTo(r11)
            if (r11 <= 0) goto L_0x02a0
            java.lang.String r11 = r4.getSymbol()
            int r11 = com.hbg.lib.data.symbol.PrecisionUtil.z(r11)
            java.lang.String r10 = i6.m.q(r10, r11)
            r2.setText(r10)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r10 = 2132025080(0x7f141ef8, float:1.9688654E38)
            java.lang.String r10 = r3.getString(r10)
            r2.append(r10)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r5 = new java.lang.Object[r8]
            r10 = 0
            r5[r10] = r15
            java.lang.String r2 = java.lang.String.format(r2, r5)
            r6.setText(r2)
            r0.setVisibility(r10)
            goto L_0x02a5
        L_0x02a0:
            r2 = 8
            r0.setVisibility(r2)
        L_0x02a5:
            java.lang.String r0 = r4.getAmount()
            java.math.BigDecimal r0 = i6.m.a(r0)
            java.lang.String r2 = r4.getFilledAmount()
            java.math.BigDecimal r2 = i6.m.a(r2)
            java.lang.String r5 = r4.getSymbol()
            int r5 = com.hbg.lib.data.symbol.PrecisionUtil.z(r5)
            java.lang.String r0 = i6.m.q(r0, r5)
            r9.setText(r0)
            java.lang.String r0 = r4.getState()
            java.lang.String r5 = "filled"
            boolean r0 = r5.equals(r0)
            java.lang.String r5 = "0"
            if (r0 == 0) goto L_0x02e2
            java.lang.String r0 = r4.getSymbol()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.z(r0)
            java.lang.String r5 = i6.m.q(r2, r0)
        L_0x02de:
            r10 = r18
            r0 = 0
            goto L_0x030b
        L_0x02e2:
            java.lang.String r0 = r4.getState()
            java.lang.String r6 = "partial-filled"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x02fe
            java.lang.String r0 = r4.getSymbol()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.z(r0)
            java.lang.String r5 = i6.m.q(r2, r0)
        L_0x02fa:
            r0 = r8
            r10 = r18
            goto L_0x030b
        L_0x02fe:
            java.lang.String r0 = r4.getState()
            java.lang.String r2 = "submitted"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x02de
            goto L_0x02fa
        L_0x030b:
            r10.setText(r5)
            java.lang.String r2 = r4.getSource()
            boolean r2 = com.huobi.trade.bean.TradeOrderType.e(r2)
            if (r2 == 0) goto L_0x0331
            r2 = 0
            r5 = r17
            r5.setOnClickListener(r2)
            r2 = 2132021962(0x7f1412ca, float:1.968233E38)
            r5.setText(r2)
            r2 = 2131099934(0x7f06011e, float:1.7812235E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r3, r2)
            r5.setTextColor(r2)
            r6 = r23
            goto L_0x035e
        L_0x0331:
            r5 = r17
            bt.h0 r2 = new bt.h0
            r6 = r23
            r2.<init>(r6, r4, r1, r5)
            r5.setOnClickListener(r2)
            r2 = 2132023181(0x7f14178d, float:1.9684803E38)
            r5.setText(r2)
            boolean r2 = r26.g()
            if (r2 == 0) goto L_0x0354
            r2 = 2131099918(0x7f06010e, float:1.7812203E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r3, r2)
            r5.setTextColor(r2)
            goto L_0x035e
        L_0x0354:
            r2 = 2131100806(0x7f060486, float:1.7814004E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r3, r2)
            r5.setTextColor(r2)
        L_0x035e:
            boolean r2 = com.hbg.lib.core.util.o.g()
            if (r2 == 0) goto L_0x03bd
            boolean r1 = r26.h()
            if (r1 == 0) goto L_0x03bd
            r1 = r16
            com.hbg.lib.common.utils.ViewUtil.m(r1, r8)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r4.getStopPrice()
            java.lang.String r2 = r4.getSymbol()
            int r2 = com.hbg.lib.data.symbol.PrecisionUtil.A(r2)
            java.lang.String r1 = i6.m.m(r1, r2)
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r15 = r27
            r15.setText(r0)
            java.lang.String r0 = r4.getState()
            java.lang.String r1 = "created"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x03ae
            r0 = 2132021969(0x7f1412d1, float:1.9682344E38)
            r1 = r25
            java.lang.String r0 = r1.getString(r0)
            r4 = r24
            r4.setText(r0)
            goto L_0x03c4
        L_0x03ae:
            r4 = r24
            r1 = r25
            r0 = 2132021967(0x7f1412cf, float:1.968234E38)
            java.lang.String r0 = r1.getString(r0)
            r4.setText(r0)
            goto L_0x03c4
        L_0x03bd:
            r1 = r16
            r2 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r1, r2)
            r8 = r0
        L_0x03c4:
            com.hbg.lib.common.utils.ViewUtil.m(r5, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.trade.handler.ExchangeOpenOrderItemViewHandler.handleView(v9.c, int, com.huobi.order.bean.ExchangeOpenOrderItem, android.view.ViewGroup):void");
    }

    public int getResId() {
        return R.layout.item_order_layout;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        ExchangeOpenOrderItem exchangeOpenOrderItem = (ExchangeOpenOrderItem) view.getTag();
        if (view.getId() == R.id.tv_symbol) {
            if (exchangeOpenOrderItem.c() != null) {
                exchangeOpenOrderItem.c().a(exchangeOpenOrderItem, view.getContext());
            }
        } else if (view.getId() == R.id.tv_order_type) {
            if (exchangeOpenOrderItem.i()) {
                k0.S(view.getContext(), exchangeOpenOrderItem.d().getSymbol(), exchangeOpenOrderItem.f(), exchangeOpenOrderItem.e());
            } else {
                k0.O(view.getContext(), exchangeOpenOrderItem.d().getSymbol(), exchangeOpenOrderItem.f());
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
