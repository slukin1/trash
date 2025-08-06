package com.hbg.module.linear.swap.viewhandler;

import android.content.Context;
import android.view.View;
import com.hbg.lib.contract.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;
import ye.d;

public class LinearSwapCurrentTriggerOrderItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void e(d dVar, View view) {
        if (dVar.c() != null) {
            dVar.c().b(dVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void f(d dVar, Context context, Void voidR) {
        if (dVar.c() != null) {
            dVar.c().a(dVar, context);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x02f1  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r30, int r31, ye.d r32, android.view.ViewGroup r33) {
        /*
            r29 = this;
            r0 = r30
            r1 = r32
            i6.r r2 = r30.e()
            android.view.View r3 = r0.itemView
            android.content.Context r3 = r3.getContext()
            android.view.View r0 = r0.itemView
            android.content.res.Resources r0 = r0.getResources()
            int r4 = com.hbg.lib.contract.R$id.contract_position_some_id
            android.view.View r4 = r2.b(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r5 = com.hbg.lib.contract.R$id.id_option_current_order_item_title2
            android.view.View r5 = r2.b(r5)
            r14 = r5
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r5 = com.hbg.lib.contract.R$id.id_option_current_order_item_cancel
            android.view.View r15 = r2.b(r5)
            int r5 = com.hbg.lib.contract.R$id.id_option_current_order_item_order_amount_title
            android.view.View r5 = r2.b(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r6 = com.hbg.lib.contract.R$id.id_option_current_order_item_order_amount
            android.view.View r6 = r2.b(r6)
            r13 = r6
            android.widget.TextView r13 = (android.widget.TextView) r13
            int r6 = com.hbg.lib.contract.R$id.id_option_current_order_item_condition_title
            android.view.View r6 = r2.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r7 = com.hbg.lib.contract.R$id.id_option_current_order_item_condition
            android.view.View r7 = r2.b(r7)
            r12 = r7
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r7 = com.hbg.lib.contract.R$id.id_option_current_order_item_price_title
            android.view.View r7 = r2.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r8 = com.hbg.lib.contract.R$id.id_option_current_order_item_price
            android.view.View r8 = r2.b(r8)
            r11 = r8
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r8 = com.hbg.lib.contract.R$id.id_option_current_order_item_time
            android.view.View r8 = r2.b(r8)
            r10 = r8
            android.widget.TextView r10 = (android.widget.TextView) r10
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo r16 = r32.g()
            java.lang.String r8 = r16.getSymbol()
            java.lang.String r9 = r32.getQuoteCurrency()
            java.lang.String r9 = com.hbg.lib.common.utils.StringUtils.i(r9)
            r31 = r2
            java.lang.String r2 = r32.d()
            r30 = r15
            com.hbg.lib.data.symbol.TradeType r15 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP
            boolean r17 = a7.e.E(r15)
            boolean r18 = a7.e.G(r15)
            if (r18 == 0) goto L_0x0098
            r33 = r10
            java.util.Locale r10 = java.util.Locale.US
            r19 = r11
            java.lang.String r11 = "usdt"
            java.lang.String r10 = r11.toUpperCase(r10)
            goto L_0x00a9
        L_0x0098:
            r33 = r10
            r19 = r11
            if (r17 == 0) goto L_0x00a3
            java.lang.String r10 = r16.getSymbol()
            goto L_0x00a9
        L_0x00a3:
            int r10 = com.hbg.lib.contract.R$string.contract_market_vol_sheet
            java.lang.String r10 = r0.getString(r10)
        L_0x00a9:
            java.util.Locale r11 = java.util.Locale.US
            r20 = r12
            int r12 = com.hbg.lib.contract.R$string.contract_entrust_order_volume
            java.lang.String r12 = r0.getString(r12)
            r1 = 1
            r21 = r13
            java.lang.Object[] r13 = new java.lang.Object[r1]
            r1 = 0
            r13[r1] = r10
            java.lang.String r10 = java.lang.String.format(r11, r12, r13)
            r5.setText(r10)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r10 = com.hbg.lib.contract.R$string.n_exchange_order_list_trigger_condition
            java.lang.String r10 = r0.getString(r10)
            r5.append(r10)
            java.lang.String r10 = "("
            r5.append(r10)
            r5.append(r9)
            java.lang.String r10 = ")"
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            r6.setText(r5)
            int r5 = com.hbg.lib.contract.R$string.contract_entrust_order_price
            java.lang.String r5 = r0.getString(r5)
            r6 = 1
            java.lang.Object[] r10 = new java.lang.Object[r6]
            r10[r1] = r9
            java.lang.String r5 = java.lang.String.format(r11, r5, r10)
            r7.setText(r5)
            boolean r5 = r16.isGrid()
            r13 = 8
            if (r5 == 0) goto L_0x0102
            r4.setVisibility(r1)
            goto L_0x0105
        L_0x0102:
            r4.setVisibility(r13)
        L_0x0105:
            int r6 = r32.f()
            java.lang.String r10 = r16.getOffset()
            boolean r12 = r16.isBuy()
            boolean r22 = r16.isDelivery()
            int r23 = r16.getLeverRate()
            java.lang.String r24 = r16.getContractCode()
            java.lang.String r25 = r32.e()
            r4 = r3
            r5 = r8
            r7 = r9
            r8 = r10
            r9 = r12
            r12 = r33
            r10 = r22
            r27 = r11
            r26 = r19
            r11 = r23
            r1 = r12
            r28 = r20
            r12 = r24
            r19 = r3
            r3 = r21
            r13 = r25
            android.text.SpannableStringBuilder r4 = a7.e.j(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r14.setText(r4)
            int r4 = com.hbg.lib.contract.R$string.otc_order_detail_payed_order_time
            java.lang.String r4 = r0.getString(r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = " "
            r5.append(r4)
            long r6 = r16.getCreatedAt()
            java.lang.String r4 = com.hbg.lib.common.utils.DateTimeUtils.C(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r1.setText(r4)
            java.lang.String r1 = r16.getOrderPriceType()
            java.lang.String r4 = "tpsl_position_trigger"
            boolean r1 = android.text.TextUtils.equals(r1, r4)
            r5 = 0
            if (r1 == 0) goto L_0x017e
            int r1 = com.hbg.lib.contract.R$string.n_contract_all_position
            java.lang.String r1 = r0.getString(r1)
            r3.setText(r1)
            goto L_0x01d7
        L_0x017e:
            if (r18 == 0) goto L_0x01b1
            java.lang.String r1 = r16.getOrderPrice()
            java.math.BigDecimal r1 = i6.m.a(r1)
            java.math.BigDecimal r6 = java.math.BigDecimal.ZERO
            int r1 = r1.compareTo(r6)
            if (r1 != 0) goto L_0x0195
            java.lang.String r1 = r16.getTriggerPrice()
            goto L_0x0199
        L_0x0195:
            java.lang.String r1 = r16.getOrderPrice()
        L_0x0199:
            java.lang.String r6 = r16.getVolume()
            java.lang.String r7 = r16.getContractFace()
            java.lang.String r8 = r16.getSymbol()
            int r8 = com.hbg.lib.data.future.util.FuturePrecisionUtil.g(r8)
            java.lang.String r1 = com.hbg.lib.data.future.util.FutureUnitUtil.b(r6, r1, r7, r15, r8)
            r3.setText(r1)
            goto L_0x01d7
        L_0x01b1:
            java.lang.String r1 = r16.getVolume()
            java.lang.String r6 = r16.getOrderPrice()
            java.lang.String r7 = r16.getContractFace()
            java.lang.String r1 = com.hbg.lib.data.future.util.FutureUnitUtil.a(r1, r6, r7, r15)
            if (r17 == 0) goto L_0x01cc
            java.lang.String r6 = r16.getContractCode()
            int r6 = com.hbg.lib.data.future.util.FuturePrecisionUtil.s(r6, r2, r5)
            goto L_0x01d0
        L_0x01cc:
            int r6 = com.hbg.lib.data.future.util.FuturePrecisionUtil.B()
        L_0x01d0:
            java.lang.String r1 = i6.m.m(r1, r6)
            r3.setText(r1)
        L_0x01d7:
            boolean r1 = r16.isGe()
            java.lang.String r3 = "--"
            if (r1 == 0) goto L_0x01fb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r6 = com.hbg.lib.contract.R$string.n_contract_latest_price
            java.lang.String r6 = r0.getString(r6)
            r1.append(r6)
            int r6 = com.hbg.lib.contract.R$string.string_flag_bigger_equals
            java.lang.String r6 = r0.getString(r6)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            goto L_0x0262
        L_0x01fb:
            boolean r1 = r16.isLe()
            if (r1 == 0) goto L_0x021d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r6 = com.hbg.lib.contract.R$string.n_contract_latest_price
            java.lang.String r6 = r0.getString(r6)
            r1.append(r6)
            int r6 = com.hbg.lib.contract.R$string.string_flag_smaller_equals
            java.lang.String r6 = r0.getString(r6)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            goto L_0x0262
        L_0x021d:
            boolean r1 = r16.isMarketPriceGe()
            if (r1 == 0) goto L_0x023f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r6 = com.hbg.lib.contract.R$string.n_contract_mark_price
            java.lang.String r6 = r0.getString(r6)
            r1.append(r6)
            int r6 = com.hbg.lib.contract.R$string.string_flag_bigger_equals
            java.lang.String r6 = r0.getString(r6)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            goto L_0x0262
        L_0x023f:
            boolean r1 = r16.isMarketPriceLe()
            if (r1 == 0) goto L_0x0261
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r6 = com.hbg.lib.contract.R$string.n_contract_mark_price
            java.lang.String r6 = r0.getString(r6)
            r1.append(r6)
            int r6 = com.hbg.lib.contract.R$string.string_flag_smaller_equals
            java.lang.String r6 = r0.getString(r6)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            goto L_0x0262
        L_0x0261:
            r1 = r3
        L_0x0262:
            java.lang.String r6 = r16.getTriggerPrice()
            java.lang.String r7 = r16.getContractCode()
            int r7 = com.hbg.lib.data.future.util.FuturePrecisionUtil.y(r7, r2, r5)
            java.lang.String r6 = i6.m.n(r6, r7, r3)
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r7 = 0
            r8[r7] = r6
            r6 = r27
            java.lang.String r1 = java.lang.String.format(r6, r1, r8)
            r7 = r28
            r7.setText(r1)
            java.lang.String r1 = r16.getOrderPriceType()
            boolean r1 = android.text.TextUtils.equals(r1, r4)
            if (r1 == 0) goto L_0x0299
            int r1 = com.hbg.lib.contract.R$string.n_copy_trading_market_price
            java.lang.String r0 = r0.getString(r1)
            r8 = r26
            r8.setText(r0)
            goto L_0x0304
        L_0x0299:
            r8 = r26
            java.lang.String r1 = r16.getOrderPriceType()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x02d7
            java.lang.String r1 = r16.getOrderPriceType()
            java.lang.String r4 = "_"
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L_0x02d7
            java.lang.String r1 = r16.getOrderPriceType()
            java.lang.String[] r1 = r1.split(r4)
            int r4 = r1.length
            r7 = 1
            if (r4 <= r7) goto L_0x02ea
            r4 = r1[r7]
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x02ea
            int r4 = com.hbg.lib.contract.R$string.contract_order_trigger_optimal
            java.lang.String r0 = r0.getString(r4)
            java.lang.Object[] r4 = new java.lang.Object[r7]
            r1 = r1[r7]
            r7 = 0
            r4[r7] = r1
            java.lang.String r0 = java.lang.String.format(r6, r0, r4)
            goto L_0x02eb
        L_0x02d7:
            java.lang.String r1 = r16.getOrderPriceType()
            java.lang.String r4 = "market"
            boolean r1 = android.text.TextUtils.equals(r1, r4)
            if (r1 == 0) goto L_0x02ea
            int r1 = com.hbg.lib.contract.R$string.n_exchange_order_list_market
            java.lang.String r0 = r0.getString(r1)
            goto L_0x02eb
        L_0x02ea:
            r0 = r5
        L_0x02eb:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0301
            java.lang.String r0 = r16.getOrderPrice()
            java.lang.String r1 = r16.getContractCode()
            int r1 = com.hbg.lib.data.future.util.FuturePrecisionUtil.y(r1, r2, r5)
            java.lang.String r0 = i6.m.n(r0, r1, r3)
        L_0x0301:
            r8.setText(r0)
        L_0x0304:
            ze.h r0 = new ze.h
            r1 = r32
            r0.<init>(r1)
            r2 = r30
            r2.setOnClickListener(r0)
            int r0 = com.hbg.lib.contract.R$id.id_ll_edit
            r2 = r31
            android.view.View r0 = r2.b(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            int r3 = com.hbg.lib.contract.R$id.item_contract_order_tv_sltp
            android.view.View r2 = r2.b(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = r16.getTpslOrderType()
            java.lang.String r4 = "sl"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x033b
            int r3 = com.hbg.lib.contract.R$string.n_contract_stop_loss
            r2.setText(r3)
            r3 = 0
            r2.setVisibility(r3)
            r0.setVisibility(r3)
            goto L_0x035d
        L_0x033b:
            r3 = 0
            java.lang.String r4 = r16.getTpslOrderType()
            java.lang.String r5 = "tp"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0354
            int r4 = com.hbg.lib.contract.R$string.n_contract_take_profit
            r2.setText(r4)
            r2.setVisibility(r3)
            r0.setVisibility(r3)
            goto L_0x035d
        L_0x0354:
            r3 = 4
            r2.setVisibility(r3)
            r2 = 8
            r0.setVisibility(r2)
        L_0x035d:
            rx.Observable r0 = dw.a.a(r0)
            r2 = 1
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
            rx.Observable r0 = r0.throttleFirst(r2, r4)
            ze.i r2 = new ze.i
            r3 = r19
            r2.<init>(r1, r3)
            r0.subscribe(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.linear.swap.viewhandler.LinearSwapCurrentTriggerOrderItemHandler.handleView(v9.c, int, ye.d, android.view.ViewGroup):void");
    }

    public int getResId() {
        return R$layout.layout_linear_swap_current_trigger_order_list_item;
    }
}
