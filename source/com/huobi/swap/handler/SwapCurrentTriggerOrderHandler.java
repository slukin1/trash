package com.huobi.swap.handler;

import android.view.View;
import com.huobi.swap.bean.SwapCurrentTriggerOrderItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import s9.c;

public class SwapCurrentTriggerOrderHandler implements c, View.OnClickListener {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01b9  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r19, int r20, com.huobi.swap.bean.SwapCurrentTriggerOrderItem r21, android.view.ViewGroup r22) {
        /*
            r18 = this;
            r0 = r19
            r1 = r21
            if (r1 == 0) goto L_0x02d8
            com.hbg.lib.network.swap.core.bean.SwapTriggerOrderInfo r2 = r21.e()
            if (r2 != 0) goto L_0x000e
            goto L_0x02d8
        L_0x000e:
            android.view.View r2 = r0.itemView
            android.content.Context r2 = r2.getContext()
            com.hbg.lib.network.swap.core.bean.SwapTriggerOrderInfo r3 = r21.e()
            i6.r r4 = r19.e()
            android.view.View r0 = r0.itemView
            android.content.res.Resources r0 = r0.getResources()
            r5 = 2131431227(0x7f0b0f3b, float:1.8484177E38)
            android.view.View r5 = r4.b(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r6 = 2131431226(0x7f0b0f3a, float:1.8484175E38)
            android.view.View r6 = r4.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r7 = 2131431221(0x7f0b0f35, float:1.8484165E38)
            android.view.View r7 = r4.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r8 = 2131431220(0x7f0b0f34, float:1.8484163E38)
            android.view.View r8 = r4.b(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r9 = 2131431215(0x7f0b0f2f, float:1.8484153E38)
            android.view.View r9 = r4.b(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r10 = 2131431216(0x7f0b0f30, float:1.8484155E38)
            android.view.View r10 = r4.b(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r11 = 2131431210(0x7f0b0f2a, float:1.8484143E38)
            android.view.View r11 = r4.b(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r12 = 2131431214(0x7f0b0f2e, float:1.848415E38)
            android.view.View r12 = r4.b(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r13 = 2131431208(0x7f0b0f28, float:1.8484139E38)
            android.view.View r13 = r4.b(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            r14 = 2131431209(0x7f0b0f29, float:1.848414E38)
            android.view.View r14 = r4.b(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r15 = 2131431202(0x7f0b0f22, float:1.8484127E38)
            r4.b(r15)
            com.hbg.lib.data.symbol.TradeType r15 = com.hbg.lib.data.symbol.TradeType.SWAP
            boolean r16 = a7.e.E(r15)
            if (r16 == 0) goto L_0x0091
            java.lang.String r16 = r3.getSymbol()
            r20 = r4
            goto L_0x009a
        L_0x0091:
            r20 = r4
            r4 = 2132018209(0x7f140421, float:1.9674718E38)
            java.lang.String r16 = r0.getString(r4)
        L_0x009a:
            java.util.Locale r4 = java.util.Locale.US
            r19 = r11
            r11 = 2132018201(0x7f140419, float:1.9674702E38)
            java.lang.String r11 = r0.getString(r11)
            r22 = r5
            r5 = 1
            r17 = r15
            java.lang.Object[] r15 = new java.lang.Object[r5]
            r5 = 0
            r15[r5] = r16
            java.lang.String r11 = java.lang.String.format(r4, r11, r15)
            r10.setText(r11)
            r10 = 2132027244(0x7f14276c, float:1.9693043E38)
            java.lang.String r10 = r0.getString(r10)
            r11 = 1
            java.lang.Object[] r15 = new java.lang.Object[r11]
            java.lang.String r11 = "usd"
            java.lang.String r16 = r11.toUpperCase(r4)
            r15[r5] = r16
            java.lang.String r10 = java.lang.String.format(r4, r10, r15)
            r12.setText(r10)
            r10 = 2132018200(0x7f140418, float:1.96747E38)
            java.lang.String r10 = r0.getString(r10)
            r12 = 1
            java.lang.Object[] r15 = new java.lang.Object[r12]
            java.lang.String r11 = r11.toUpperCase(r4)
            r15[r5] = r11
            java.lang.String r10 = java.lang.String.format(r4, r10, r15)
            r14.setText(r10)
            r8.setTag(r1)
            r10 = r18
            r8.setOnClickListener(r10)
            java.lang.String r8 = r3.getSymbol()
            java.lang.String r2 = us.j.g(r2, r8)
            r6.setText(r2)
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r6 = 2132020966(0x7f140ee6, float:1.968031E38)
            java.lang.String r6 = r0.getString(r6)
            r2[r5] = r6
            long r11 = r3.getCreatedAt()
            java.lang.String r6 = com.hbg.lib.common.utils.DateTimeUtils.C(r11)
            r8 = 1
            r2[r8] = r6
            java.lang.String r6 = "%s %s"
            java.lang.String r2 = java.lang.String.format(r6, r2)
            r7.setText(r2)
            java.lang.String r2 = r3.getOrderPriceType()
            java.lang.String r6 = "tpsl_position_trigger"
            boolean r2 = android.text.TextUtils.equals(r2, r6)
            if (r2 == 0) goto L_0x013b
            r1 = 2132021349(0x7f141065, float:1.9681087E38)
            java.lang.String r1 = r0.getString(r1)
            r13.setText(r1)
            r1 = 2132020733(0x7f140dfd, float:1.9679837E38)
            java.lang.String r1 = r0.getString(r1)
            r9.setText(r1)
            goto L_0x01c8
        L_0x013b:
            java.lang.String r2 = r3.getOrderPriceType()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r6 = 0
            if (r2 != 0) goto L_0x017c
            java.lang.String r2 = r3.getOrderPriceType()
            java.lang.String r7 = "_"
            boolean r2 = r2.contains(r7)
            if (r2 == 0) goto L_0x017c
            java.lang.String r2 = r3.getOrderPriceType()
            java.lang.String[] r2 = r2.split(r7)
            int r7 = r2.length
            r8 = 1
            if (r7 <= r8) goto L_0x017c
            r7 = r2[r8]
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x017c
            r6 = 2132018226(0x7f140432, float:1.9674753E38)
            java.lang.String r6 = r0.getString(r6)
            java.lang.Object[] r7 = new java.lang.Object[r8]
            r2 = r2[r8]
            r7[r5] = r2
            java.lang.String r6 = java.lang.String.format(r4, r6, r7)
            java.lang.String r2 = r3.getTriggerPrice()
            goto L_0x017d
        L_0x017c:
            r2 = r6
        L_0x017d:
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x0199
            java.lang.String r2 = r3.getOrderPrice()
            java.lang.String r6 = r3.getSymbol()
            int r6 = us.i.m(r6)
            java.lang.String r7 = "--"
            java.lang.String r6 = i6.m.n(r2, r6, r7)
            java.lang.String r2 = r3.getOrderPrice()
        L_0x0199:
            r13.setText(r6)
            boolean r6 = a7.e.E(r17)
            java.lang.String r7 = r3.getVolume()
            java.lang.String r1 = r21.d()
            r8 = r17
            java.lang.String r1 = com.huobi.contract.helper.ContractOrderHelper.f(r7, r2, r1, r8)
            if (r6 == 0) goto L_0x01b9
            java.lang.String r2 = r3.getSymbol()
            int r2 = us.i.p(r2)
            goto L_0x01c1
        L_0x01b9:
            java.lang.String r2 = r3.getSymbol()
            int r2 = us.i.z(r2)
        L_0x01c1:
            java.lang.String r1 = i6.m.m(r1, r2)
            r9.setText(r1)
        L_0x01c8:
            boolean r1 = r3.isBuy()
            if (r1 == 0) goto L_0x01dc
            int r1 = com.hbg.lib.core.util.w.h()
            int r1 = r0.getColor(r1)
            r2 = r22
            r2.setTextColor(r1)
            goto L_0x01e9
        L_0x01dc:
            r2 = r22
            int r1 = com.hbg.lib.core.util.w.d()
            int r1 = r0.getColor(r1)
            r2.setTextColor(r1)
        L_0x01e9:
            boolean r1 = r3.isOpen()
            if (r1 == 0) goto L_0x0205
            boolean r1 = r3.isBuy()
            if (r1 == 0) goto L_0x01fd
            r1 = 2132021131(0x7f140f8b, float:1.9680645E38)
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0236
        L_0x01fd:
            r1 = 2132021130(0x7f140f8a, float:1.9680643E38)
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0236
        L_0x0205:
            boolean r1 = r3.isDelivery()
            if (r1 == 0) goto L_0x0213
            r1 = 2132018386(0x7f1404d2, float:1.9675077E38)
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0236
        L_0x0213:
            boolean r1 = r3.isExplose()
            if (r1 == 0) goto L_0x0221
            r1 = 2132018387(0x7f1404d3, float:1.967508E38)
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0236
        L_0x0221:
            boolean r1 = r3.isBuy()
            if (r1 == 0) goto L_0x022f
            r1 = 2132021099(0x7f140f6b, float:1.968058E38)
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0236
        L_0x022f:
            r1 = 2132021101(0x7f140f6d, float:1.9680584E38)
            java.lang.String r0 = r0.getString(r1)
        L_0x0236:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r6 = r3.getLeverRate()
            r1.append(r6)
            java.lang.String r6 = "X·"
            r1.append(r6)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r2.setText(r0)
            java.lang.String r0 = r3.getTriggerType()
            java.lang.String r1 = "ge"
            boolean r0 = r1.equalsIgnoreCase(r0)
            r1 = 2132026964(0x7f142654, float:1.9692475E38)
            if (r0 == 0) goto L_0x0266
            java.lang.String r0 = bh.j.d(r1)
        L_0x0264:
            r1 = 1
            goto L_0x027f
        L_0x0266:
            java.lang.String r0 = r3.getTriggerType()
            java.lang.String r2 = "ge_mark"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0277
            java.lang.String r0 = bh.j.d(r1)
            goto L_0x0264
        L_0x0277:
            r0 = 2132026965(0x7f142655, float:1.9692477E38)
            java.lang.String r0 = bh.j.d(r0)
            goto L_0x0264
        L_0x027f:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r3.getTriggerPrice()
            java.lang.String r6 = r3.getSymbol()
            int r6 = us.i.m(r6)
            java.lang.String r2 = i6.m.m(r2, r6)
            r1[r5] = r2
            java.lang.String r0 = java.lang.String.format(r4, r0, r1)
            r11 = r19
            r11.setText(r0)
            r0 = 2131431217(0x7f0b0f31, float:1.8484157E38)
            r1 = r20
            android.view.View r0 = r1.b(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r3.getTpslOrderType()
            java.lang.String r2 = "sl"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x02bd
            r1 = 2132021042(0x7f140f32, float:1.9680464E38)
            r0.setText(r1)
            r0.setVisibility(r5)
            goto L_0x02d7
        L_0x02bd:
            java.lang.String r1 = r3.getTpslOrderType()
            java.lang.String r2 = "tp"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x02d3
            r1 = 2132021058(0x7f140f42, float:1.9680497E38)
            r0.setText(r1)
            r0.setVisibility(r5)
            goto L_0x02d7
        L_0x02d3:
            r1 = 4
            r0.setVisibility(r1)
        L_0x02d7:
            return
        L_0x02d8:
            r10 = r18
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.swap.handler.SwapCurrentTriggerOrderHandler.handleView(v9.c, int, com.huobi.swap.bean.SwapCurrentTriggerOrderItem, android.view.ViewGroup):void");
    }

    public int getResId() {
        return R.layout.item_contract_current_trigger_order_list;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SwapCurrentTriggerOrderItem swapCurrentTriggerOrderItem = (SwapCurrentTriggerOrderItem) view.getTag();
        if (!(view.getId() != R.id.item_contract_order_tv_title_cancel || swapCurrentTriggerOrderItem == null || swapCurrentTriggerOrderItem.c() == null)) {
            swapCurrentTriggerOrderItem.c().a(swapCurrentTriggerOrderItem.e());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
