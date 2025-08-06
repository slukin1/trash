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
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.order.bean.OrderBean;
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

public class OrderBeanViewHandler implements c, View.OnClickListener {

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
    public /* synthetic */ void f(OrderBean orderBean, TextView textView, View view) {
        c(d(view), orderBean);
        VibrateManager.a(textView);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void c(Context context, OrderBean orderBean) {
        g gVar = context instanceof g ? (g) context : null;
        if (!NetworkStatus.c(j.c())) {
            HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
        } else if (orderBean.isCallAuctionTwo()) {
            HuobiToastUtil.k(context, R.string.n_exchange_call_auction_order_cancel);
        } else {
            ((OrderService) p.X(TradeType.PRO, OrderService.class)).submitCancel(orderBean.getId(), "user-actively-cancels-order-android").delay(1, TimeUnit.SECONDS).compose(p.a0()).compose(RxJavaHelper.t(gVar)).subscribe(new a(gVar));
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

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x02c6, code lost:
        if ("submitted".equals(r24.getState()) != false) goto L_0x02ba;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x037b  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r22, int r23, com.huobi.order.bean.OrderBean r24, android.view.ViewGroup r25) {
        /*
            r21 = this;
            r0 = r21
            r1 = r24
            r2 = r22
            android.view.View r3 = r2.itemView
            android.content.Context r3 = r3.getContext()
            android.content.res.Resources r4 = r3.getResources()
            i6.r r2 = r22.e()
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
            r23 = r4
            r4 = 2131430839(0x7f0b0db7, float:1.848339E38)
            android.view.View r4 = r2.b(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r22 = r4
            r4 = 2131430841(0x7f0b0db9, float:1.8483394E38)
            android.view.View r4 = r2.b(r4)
            r14.setTag(r1)
            r14.setOnClickListener(r0)
            r5.setTag(r1)
            r5.setOnClickListener(r0)
            r25 = r15
            d7.a1 r15 = d7.a1.v()
            r16 = r4
            java.lang.String r4 = r24.getSymbol()
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.network.pro.core.bean.SymbolBean r0 = r15.J(r4, r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            if (r0 == 0) goto L_0x00bb
            java.lang.String r17 = r0.getBaseCurrencyDisplayName()
            java.lang.String r0 = r0.getQuoteCurrencyDisplayName()
            r1 = r17
            goto L_0x0103
        L_0x00bb:
            d7.a1 r0 = d7.a1.v()
            java.util.List r0 = r0.j()
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r17 = ""
            r18 = r17
        L_0x00cb:
            boolean r19 = r0.hasNext()
            if (r19 == 0) goto L_0x00ff
            java.lang.Object r19 = r0.next()
            r15 = r19
            java.lang.String r15 = (java.lang.String) r15
            r19 = r0
            java.lang.String r0 = r24.getSymbol()
            int r0 = r0.lastIndexOf(r15)
            if (r0 <= 0) goto L_0x00fa
            java.lang.String r0 = r24.getSymbol()
            java.lang.String r1 = r24.getSymbol()
            int r1 = r1.lastIndexOf(r15)
            r20 = r15
            r15 = 0
            java.lang.String r18 = r0.substring(r15, r1)
            r17 = r20
        L_0x00fa:
            r1 = r24
            r0 = r19
            goto L_0x00cb
        L_0x00ff:
            r0 = r17
            r1 = r18
        L_0x0103:
            r4.append(r1)
            java.lang.String r15 = "/"
            r4.append(r15)
            r4.append(r0)
            r14.setText(r4)
            java.lang.String r4 = r24.getType()
            java.lang.String r14 = r24.getSource()
            java.lang.String r15 = r24.getType()
            java.lang.String r14 = com.huobi.trade.bean.TradeOrderType.a(r14, r15, r3)
            r5.setText(r14)
            boolean r14 = r24.isBuy()
            r15 = 2131100920(0x7f0604f8, float:1.7814235E38)
            r17 = 2131102051(0x7f060963, float:1.781653E38)
            if (r14 == 0) goto L_0x014b
            int r14 = com.hbg.lib.core.util.w.h()
            int r14 = androidx.core.content.ContextCompat.getColor(r3, r14)
            r5.setTextColor(r14)
            boolean r14 = com.hbg.lib.core.util.w.l()
            if (r14 == 0) goto L_0x0143
            r15 = r17
        L_0x0143:
            int r14 = androidx.core.content.ContextCompat.getColor(r3, r15)
            r5.setBackgroundColor(r14)
            goto L_0x0166
        L_0x014b:
            int r14 = com.hbg.lib.core.util.w.d()
            int r14 = androidx.core.content.ContextCompat.getColor(r3, r14)
            r5.setTextColor(r14)
            boolean r14 = com.hbg.lib.core.util.w.l()
            if (r14 == 0) goto L_0x015d
            goto L_0x015f
        L_0x015d:
            r15 = r17
        L_0x015f:
            int r14 = androidx.core.content.ContextCompat.getColor(r3, r15)
            r5.setBackgroundColor(r14)
        L_0x0166:
            java.lang.String r5 = "buy-market"
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x018b
            java.lang.String r5 = "sell-market"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0177
            goto L_0x018b
        L_0x0177:
            java.lang.String r4 = r24.getPrice()
            java.lang.String r5 = r24.getSymbol()
            int r5 = com.hbg.lib.data.symbol.PrecisionUtil.A(r5)
            java.lang.String r4 = i6.m.m(r4, r5)
            r8.setText(r4)
            goto L_0x0191
        L_0x018b:
            r4 = 2132021960(0x7f1412c8, float:1.9682326E38)
            r8.setText(r4)
        L_0x0191:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 2132021961(0x7f1412c9, float:1.9682328E38)
            java.lang.String r5 = r3.getString(r5)
            r4.append(r5)
            java.lang.String r5 = "(%s)"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r15 = 1
            java.lang.Object[] r8 = new java.lang.Object[r15]
            r14 = 0
            r8[r14] = r0
            java.lang.String r4 = java.lang.String.format(r4, r8)
            r11.setText(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r8 = 2132021951(0x7f1412bf, float:1.9682308E38)
            java.lang.String r8 = r3.getString(r8)
            r4.append(r8)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r8 = new java.lang.Object[r15]
            r8[r14] = r1
            java.lang.String r4 = java.lang.String.format(r4, r8)
            r12.setText(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r8 = 2132022012(0x7f1412fc, float:1.9682432E38)
            java.lang.String r8 = r3.getString(r8)
            r4.append(r8)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r8 = new java.lang.Object[r15]
            r8[r14] = r1
            java.lang.String r4 = java.lang.String.format(r4, r8)
            r13.setText(r4)
            long r11 = r24.getCreatedAt()
            java.lang.String r4 = com.hbg.lib.common.utils.DateTimeUtils.C(r11)
            r6.setText(r4)
            r4 = 2131430267(0x7f0b0b7b, float:1.848223E38)
            android.view.View r4 = r2.b(r4)
            r6 = 2131430268(0x7f0b0b7c, float:1.8482232E38)
            android.view.View r6 = r2.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r8 = 2131430266(0x7f0b0b7a, float:1.8482228E38)
            android.view.View r2 = r2.b(r8)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r8 = r24.getIceAmount()
            java.math.BigDecimal r8 = i6.m.a(r8)
            java.math.BigDecimal r11 = java.math.BigDecimal.ZERO
            int r11 = r8.compareTo(r11)
            if (r11 <= 0) goto L_0x0261
            java.lang.String r11 = r24.getSymbol()
            int r11 = com.hbg.lib.data.symbol.PrecisionUtil.z(r11)
            java.lang.String r8 = i6.m.q(r8, r11)
            r2.setText(r8)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r8 = 2132025080(0x7f141ef8, float:1.9688654E38)
            java.lang.String r8 = r3.getString(r8)
            r2.append(r8)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r5 = new java.lang.Object[r15]
            r8 = 0
            r5[r8] = r1
            java.lang.String r1 = java.lang.String.format(r2, r5)
            r6.setText(r1)
            r4.setVisibility(r8)
            goto L_0x0266
        L_0x0261:
            r1 = 8
            r4.setVisibility(r1)
        L_0x0266:
            java.lang.String r1 = r24.getAmount()
            java.math.BigDecimal r1 = i6.m.a(r1)
            java.math.BigDecimal r2 = new java.math.BigDecimal
            java.lang.String r4 = r24.getFieldAmount()
            r2.<init>(r4)
            java.lang.String r4 = r24.getSymbol()
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.z(r4)
            java.lang.String r1 = i6.m.q(r1, r4)
            r9.setText(r1)
            java.lang.String r1 = r24.getState()
            java.lang.String r4 = "filled"
            boolean r1 = r4.equals(r1)
            java.lang.String r4 = "0"
            if (r1 == 0) goto L_0x02a2
            java.lang.String r1 = r24.getSymbol()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.z(r1)
            java.lang.String r4 = i6.m.q(r2, r1)
        L_0x02a0:
            r1 = 0
            goto L_0x02c9
        L_0x02a2:
            java.lang.String r1 = r24.getState()
            java.lang.String r5 = "partial-filled"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x02bc
            java.lang.String r1 = r24.getSymbol()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.z(r1)
            java.lang.String r4 = i6.m.q(r2, r1)
        L_0x02ba:
            r1 = r15
            goto L_0x02c9
        L_0x02bc:
            java.lang.String r1 = r24.getState()
            java.lang.String r2 = "submitted"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x02a0
            goto L_0x02ba
        L_0x02c9:
            r10.setText(r4)
            java.lang.String r2 = r24.getSource()
            boolean r2 = com.huobi.trade.bean.TradeOrderType.e(r2)
            if (r2 == 0) goto L_0x02ef
            r2 = 0
            r7.setOnClickListener(r2)
            r2 = 2132021962(0x7f1412ca, float:1.968233E38)
            r7.setText(r2)
            r2 = 2131099934(0x7f06011e, float:1.7812235E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r3, r2)
            r7.setTextColor(r2)
            r4 = r21
            r5 = r24
            goto L_0x031c
        L_0x02ef:
            bt.o1 r2 = new bt.o1
            r4 = r21
            r5 = r24
            r2.<init>(r4, r5, r7)
            r7.setOnClickListener(r2)
            r2 = 2132023181(0x7f14178d, float:1.9684803E38)
            r7.setText(r2)
            boolean r2 = r24.isCallAuctionTwo()
            if (r2 == 0) goto L_0x0312
            r2 = 2131099918(0x7f06010e, float:1.7812203E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r3, r2)
            r7.setTextColor(r2)
            goto L_0x031c
        L_0x0312:
            r2 = 2131100806(0x7f060486, float:1.7814004E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r3, r2)
            r7.setTextColor(r2)
        L_0x031c:
            boolean r2 = com.hbg.lib.core.util.o.g()
            if (r2 == 0) goto L_0x037b
            boolean r2 = r24.isStopLimitType()
            if (r2 == 0) goto L_0x037b
            r2 = r16
            com.hbg.lib.common.utils.ViewUtil.m(r2, r15)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r24.getStopPrice()
            java.lang.String r3 = r24.getSymbol()
            int r3 = com.hbg.lib.data.symbol.PrecisionUtil.A(r3)
            java.lang.String r2 = i6.m.m(r2, r3)
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r25
            r1.setText(r0)
            java.lang.String r0 = r24.getState()
            java.lang.String r1 = "created"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x036c
            r0 = 2132021969(0x7f1412d1, float:1.9682344E38)
            r1 = r23
            java.lang.String r0 = r1.getString(r0)
            r2 = r22
            r2.setText(r0)
            goto L_0x0382
        L_0x036c:
            r2 = r22
            r1 = r23
            r0 = 2132021967(0x7f1412cf, float:1.968234E38)
            java.lang.String r0 = r1.getString(r0)
            r2.setText(r0)
            goto L_0x0382
        L_0x037b:
            r2 = r16
            r0 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r2, r0)
            r15 = r1
        L_0x0382:
            com.hbg.lib.common.utils.ViewUtil.m(r7, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.trade.handler.OrderBeanViewHandler.handleView(v9.c, int, com.huobi.order.bean.OrderBean, android.view.ViewGroup):void");
    }

    public int getResId() {
        return R.layout.item_order_layout;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        OrderBean orderBean = (OrderBean) view.getTag();
        if (view.getId() == R.id.tv_symbol) {
            if (orderBean.getCallback() != null) {
                orderBean.getCallback().a(orderBean, view.getContext());
            }
        } else if (view.getId() == R.id.tv_order_type) {
            boolean isBuy = orderBean.isBuy();
            if (orderBean.isTrade()) {
                k0.S(view.getContext(), orderBean.getSymbol(), isBuy, orderBean.getTradeType());
            } else {
                k0.O(view.getContext(), orderBean.getSymbol(), isBuy);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
