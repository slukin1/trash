package com.hbg.module.linear.swap.viewhandler;

import android.view.View;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;

public class LinearSwapCurrentTrackOrderHandler implements c, View.OnClickListener {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0264  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r32, int r33, ye.c r34, android.view.ViewGroup r35) {
        /*
            r31 = this;
            r0 = r32
            r1 = r34
            android.view.View r2 = r0.itemView
            android.content.Context r3 = r2.getContext()
            if (r1 != 0) goto L_0x000d
            return
        L_0x000d:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapTrackOrderInfo r2 = r34.g()
            i6.r r4 = r32.e()
            android.view.View r0 = r0.itemView
            android.content.res.Resources r0 = r0.getResources()
            int r5 = com.hbg.lib.contract.R$id.item_contract_order_tv_title_symbol
            android.view.View r5 = r4.b(r5)
            r13 = r5
            android.widget.TextView r13 = (android.widget.TextView) r13
            int r5 = com.hbg.lib.contract.R$id.item_contract_order_tv_title_date
            android.view.View r5 = r4.b(r5)
            r14 = r5
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r5 = com.hbg.lib.contract.R$id.item_contract_order_tv_title_cancel
            android.view.View r5 = r4.b(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r6 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_volume
            android.view.View r6 = r4.b(r6)
            r15 = r6
            android.widget.TextView r15 = (android.widget.TextView) r15
            int r6 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_volume_title
            android.view.View r6 = r4.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r7 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_trigger
            android.view.View r7 = r4.b(r7)
            r12 = r7
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r7 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_trigger_title
            android.view.View r7 = r4.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r8 = com.hbg.lib.contract.R$id.item_contract_order_tv_call_back_rate
            android.view.View r8 = r4.b(r8)
            r11 = r8
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r8 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_price
            android.view.View r8 = r4.b(r8)
            r10 = r8
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r8 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_price_title
            android.view.View r8 = r4.b(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r9 = com.hbg.lib.contract.R$id.item_contract_order_tv_state
            android.view.View r4 = r4.b(r9)
            r9 = r4
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r4 = r34.getQuoteCurrency()
            java.lang.String r16 = com.hbg.lib.common.utils.StringUtils.i(r4)
            java.lang.String r4 = r2.getSymbol()
            r32 = r15
            java.lang.String r15 = r34.e()
            r33 = r15
            com.hbg.lib.data.symbol.TradeType r15 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP
            boolean r17 = a7.e.E(r15)
            boolean r18 = a7.e.G(r15)
            if (r18 == 0) goto L_0x00a7
            r35 = r9
            java.util.Locale r9 = java.util.Locale.US
            r19 = r10
            java.lang.String r10 = "usdt"
            java.lang.String r9 = r10.toUpperCase(r9)
            goto L_0x00b8
        L_0x00a7:
            r35 = r9
            r19 = r10
            if (r17 == 0) goto L_0x00b2
            java.lang.String r9 = r2.getSymbol()
            goto L_0x00b8
        L_0x00b2:
            int r9 = com.hbg.lib.contract.R$string.contract_market_vol_sheet
            java.lang.String r9 = r0.getString(r9)
        L_0x00b8:
            java.util.Locale r10 = java.util.Locale.US
            r20 = r11
            int r11 = com.hbg.lib.contract.R$string.contract_entrust_order_volume
            java.lang.String r11 = r0.getString(r11)
            r21 = r15
            r15 = 1
            r22 = r12
            java.lang.Object[] r12 = new java.lang.Object[r15]
            r23 = 0
            r12[r23] = r9
            java.lang.String r9 = java.lang.String.format(r10, r11, r12)
            r6.setText(r9)
            int r6 = com.hbg.lib.contract.R$string.n_contract_track_order_unit
            java.lang.String r6 = r0.getString(r6)
            java.lang.Object[] r9 = new java.lang.Object[r15]
            r9[r23] = r16
            java.lang.String r6 = java.lang.String.format(r10, r6, r9)
            r7.setText(r6)
            int r6 = com.hbg.lib.contract.R$string.contract_entrust_order_price
            java.lang.String r6 = r0.getString(r6)
            java.lang.Object[] r7 = new java.lang.Object[r15]
            r7[r23] = r16
            java.lang.String r6 = java.lang.String.format(r10, r6, r7)
            r8.setText(r6)
            r5.setTag(r1)
            r12 = r31
            r5.setOnClickListener(r12)
            int r5 = r34.h()
            java.lang.String r7 = r34.i()
            boolean r8 = r34.j()
            boolean r9 = r34.k()
            int r11 = r2.getLeverRate()
            java.lang.String r24 = r2.getContractCode()
            java.lang.String r25 = r2.getContractType()
            r6 = r16
            r26 = r35
            r28 = r10
            r27 = r19
            r10 = r11
            r29 = r20
            r11 = r24
            r30 = r22
            r12 = r25
            android.text.SpannableStringBuilder r3 = a7.e.j(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.setText(r3)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = com.hbg.lib.contract.R$string.n_contract_order_time
            java.lang.String r4 = r0.getString(r4)
            r3[r23] = r4
            long r4 = r2.getCreatedAt()
            java.lang.String r4 = com.hbg.lib.common.utils.DateTimeUtils.C(r4)
            r3[r15] = r4
            java.lang.String r4 = "%s %s"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r14.setText(r3)
            java.lang.String r3 = r2.getOrderPriceType()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r4 = 0
            if (r3 != 0) goto L_0x01a2
            java.lang.String r3 = r2.getOrderPriceType()
            java.lang.String r5 = "_"
            boolean r3 = r3.contains(r5)
            if (r3 == 0) goto L_0x01a2
            java.lang.String r3 = r2.getOrderPriceType()
            java.lang.String r6 = "formula_price"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x017c
            int r3 = com.hbg.lib.contract.R$string.n_contract_theoretical_price
            java.lang.String r0 = r0.getString(r3)
            r3 = r28
            goto L_0x01a5
        L_0x017c:
            java.lang.String r3 = r2.getOrderPriceType()
            java.lang.String[] r3 = r3.split(r5)
            int r5 = r3.length
            if (r5 <= r15) goto L_0x01a2
            r5 = r3[r15]
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x01a2
            int r5 = com.hbg.lib.contract.R$string.contract_order_trigger_optimal
            java.lang.String r0 = r0.getString(r5)
            java.lang.Object[] r5 = new java.lang.Object[r15]
            r3 = r3[r15]
            r5[r23] = r3
            r3 = r28
            java.lang.String r0 = java.lang.String.format(r3, r0, r5)
            goto L_0x01a5
        L_0x01a2:
            r3 = r28
            r0 = r4
        L_0x01a5:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r6 = "--"
            if (r5 == 0) goto L_0x01c0
            java.lang.String r0 = r2.getOrderPrice()
            java.lang.String r5 = r2.getContractCode()
            r7 = r33
            int r5 = com.hbg.lib.data.future.util.FuturePrecisionUtil.y(r5, r7, r4)
            java.lang.String r0 = i6.m.n(r0, r5, r6)
            goto L_0x01c2
        L_0x01c0:
            r7 = r33
        L_0x01c2:
            r8 = r27
            r8.setText(r0)
            if (r18 == 0) goto L_0x01e9
            java.lang.String r0 = r2.getVolume()
            java.lang.String r5 = r2.getActivePrice()
            java.lang.String r1 = r34.d()
            java.lang.String r8 = r2.getSymbol()
            int r8 = com.hbg.lib.data.future.util.FuturePrecisionUtil.g(r8)
            r9 = r21
            java.lang.String r0 = com.hbg.lib.data.future.util.FutureUnitUtil.b(r0, r5, r1, r9, r8)
            r5 = r32
            r5.setText(r0)
            goto L_0x0213
        L_0x01e9:
            r5 = r32
            r9 = r21
            java.lang.String r0 = r2.getVolume()
            java.lang.String r8 = r2.getActivePrice()
            java.lang.String r1 = r34.d()
            java.lang.String r0 = com.hbg.lib.data.future.util.FutureUnitUtil.a(r0, r8, r1, r9)
            if (r17 == 0) goto L_0x0208
            java.lang.String r1 = r2.getContractCode()
            int r1 = com.hbg.lib.data.future.util.FuturePrecisionUtil.s(r1, r7, r4)
            goto L_0x020c
        L_0x0208:
            int r1 = com.hbg.lib.data.future.util.FuturePrecisionUtil.B()
        L_0x020c:
            java.lang.String r0 = i6.m.m(r0, r1)
            r5.setText(r0)
        L_0x0213:
            java.lang.String r0 = r2.getActiveType()
            java.lang.String r1 = "ge"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0226
            int r0 = com.hbg.lib.contract.R$string.string_flag_bigger_equals
            java.lang.String r0 = com.hbg.lib.common.BaseApplication.c(r0)
            goto L_0x022c
        L_0x0226:
            int r0 = com.hbg.lib.contract.R$string.string_flag_smaller_equals
            java.lang.String r0 = com.hbg.lib.common.BaseApplication.c(r0)
        L_0x022c:
            java.lang.String r1 = r2.getActivePrice()
            java.lang.String r5 = r2.getContractCode()
            int r4 = com.hbg.lib.data.future.util.FuturePrecisionUtil.y(r5, r7, r4)
            java.lang.String r1 = i6.m.n(r1, r4, r6)
            java.lang.Object[] r4 = new java.lang.Object[r15]
            r4[r23] = r1
            java.lang.String r0 = java.lang.String.format(r3, r0, r4)
            r7 = r30
            r7.setText(r0)
            java.lang.String r0 = r2.getCallbackRate()
            java.lang.String r0 = i6.m.Q(r0, r15, r15)
            r8 = r29
            r8.setText(r0)
            int r0 = r2.getIsActive()
            if (r0 != r15) goto L_0x0264
            int r0 = com.hbg.lib.contract.R$string.n_contract_track_order_state_order
            r4 = r26
            r4.setText(r0)
            goto L_0x026b
        L_0x0264:
            r4 = r26
            int r0 = com.hbg.lib.contract.R$string.n_contract_track_order_state_active
            r4.setText(r0)
        L_0x026b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.linear.swap.viewhandler.LinearSwapCurrentTrackOrderHandler.handleView(v9.c, int, ye.c, android.view.ViewGroup):void");
    }

    public int getResId() {
        return R$layout.item_contract_current_track_order_list;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        ye.c cVar = (ye.c) view.getTag();
        if (!(view.getId() != R$id.item_contract_order_tv_title_cancel || cVar == null || cVar.c() == null)) {
            cVar.c().a(cVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
