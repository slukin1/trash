package com.huobi.contract.viewhandler;

import android.view.View;
import com.hbg.lib.contract.R$layout;
import com.huobi.contract.entity.ContractHistoryTriggerOrderInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;

public class ContractHistoryTriggerOrderHandler implements c, View.OnClickListener {

    public interface a {
        void a(ContractHistoryTriggerOrderInfo contractHistoryTriggerOrderInfo);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02d6  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r19, int r20, com.huobi.contract.entity.ContractHistoryTriggerOrderInfo r21, android.view.ViewGroup r22) {
        /*
            r18 = this;
            r0 = r21
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            i6.r r1 = r19.e()
            r2 = r19
            android.view.View r2 = r2.itemView
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.hbg.lib.contract.R$id.item_contract_order_tv_title_type
            android.view.View r3 = r1.b(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = com.hbg.lib.contract.R$id.item_contract_order_tv_title_symbol
            android.view.View r4 = r1.b(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r5 = com.hbg.lib.contract.R$id.item_contract_order_tv_title_date
            android.view.View r5 = r1.b(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r6 = com.hbg.lib.contract.R$id.item_contract_order_tv_title_cancel
            android.view.View r6 = r1.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r6 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_volume
            android.view.View r6 = r1.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r7 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_volume_title
            android.view.View r7 = r1.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r8 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_trigger
            android.view.View r8 = r1.b(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r9 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_trigger_title
            android.view.View r9 = r1.b(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r10 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_price
            android.view.View r10 = r1.b(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r11 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_price_title
            android.view.View r11 = r1.b(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = com.hbg.lib.contract.R$id.item_contract_order_tv_title_status
            android.view.View r12 = r1.b(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r13 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_trigger_time
            android.view.View r13 = r1.b(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            int r14 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_trigger_time_title
            android.view.View r14 = r1.b(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r15 = com.hbg.lib.contract.R$id.item_contract_order_tv_order_trigger_layout
            android.view.View r15 = r1.b(r15)
            r19 = r13
            int r13 = com.hbg.lib.contract.R$id.item_contract_order_data_ll
            r1.b(r13)
            com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT
            boolean r13 = a7.e.E(r1)
            if (r13 == 0) goto L_0x0093
            java.lang.String r13 = r21.getSymbol()
            goto L_0x0099
        L_0x0093:
            int r13 = com.hbg.lib.contract.R$string.contract_market_vol_sheet
            java.lang.String r13 = r2.getString(r13)
        L_0x0099:
            r20 = r14
            java.util.Locale r14 = java.util.Locale.US
            r22 = r15
            int r15 = com.hbg.lib.contract.R$string.contract_entrust_order_volume
            java.lang.String r15 = r2.getString(r15)
            r0 = 1
            r16 = r12
            java.lang.Object[] r12 = new java.lang.Object[r0]
            r0 = 0
            r12[r0] = r13
            java.lang.String r12 = java.lang.String.format(r14, r15, r12)
            r7.setText(r12)
            int r7 = com.hbg.lib.contract.R$string.trade_trend_trigger_price_unit
            java.lang.String r7 = r2.getString(r7)
            r12 = 1
            java.lang.Object[] r13 = new java.lang.Object[r12]
            java.lang.String r15 = "usd"
            java.lang.String r17 = r15.toUpperCase(r14)
            r13[r0] = r17
            java.lang.String r7 = java.lang.String.format(r14, r7, r13)
            r9.setText(r7)
            int r7 = com.hbg.lib.contract.R$string.contract_entrust_order_price
            java.lang.String r7 = r2.getString(r7)
            java.lang.Object[] r9 = new java.lang.Object[r12]
            java.lang.String r12 = r15.toUpperCase(r14)
            r9[r0] = r12
            java.lang.String r7 = java.lang.String.format(r14, r7, r9)
            r11.setText(r7)
            android.content.Context r7 = r4.getContext()
            java.lang.String r9 = r21.getSymbol()
            java.lang.String r11 = r21.getContractCode()
            java.lang.String r12 = r21.getContractType()
            java.lang.String r7 = ej.g.e(r7, r9, r11, r12)
            r4.setText(r7)
            long r11 = r21.getCreatedAt()
            java.lang.String r4 = com.hbg.lib.common.utils.DateTimeUtils.C(r11)
            r5.setText(r4)
            java.lang.String r4 = r21.getOrderPriceType()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r5 = 0
            if (r4 != 0) goto L_0x0143
            java.lang.String r4 = r21.getOrderPriceType()
            java.lang.String r7 = "_"
            boolean r4 = r4.contains(r7)
            if (r4 == 0) goto L_0x0143
            java.lang.String r4 = r21.getOrderPriceType()
            java.lang.String[] r4 = r4.split(r7)
            int r7 = r4.length
            r9 = 1
            if (r7 <= r9) goto L_0x0143
            r7 = r4[r9]
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0143
            int r7 = com.hbg.lib.contract.R$string.contract_order_trigger_optimal
            java.lang.String r7 = r2.getString(r7)
            java.lang.Object[] r11 = new java.lang.Object[r9]
            r4 = r4[r9]
            r11[r0] = r4
            java.lang.String r4 = java.lang.String.format(r14, r7, r11)
            java.lang.String r7 = r21.getTriggerPrice()
            goto L_0x0145
        L_0x0143:
            r4 = r5
            r7 = r4
        L_0x0145:
            boolean r9 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r11 = "--"
            if (r9 == 0) goto L_0x0161
            java.lang.String r4 = r21.getOrderPrice()
            java.lang.String r7 = r21.getSymbol()
            int r7 = ej.f.r(r7)
            java.lang.String r4 = i6.m.n(r4, r7, r11)
            java.lang.String r7 = r21.getOrderPrice()
        L_0x0161:
            r10.setText(r4)
            boolean r1 = a7.e.E(r1)
            java.lang.String r4 = r21.getVolume()
            java.lang.String r9 = r21.getContractFace()
            java.lang.String r4 = com.huobi.contract.helper.ContractOrderHelper.e(r4, r7, r9)
            if (r1 == 0) goto L_0x017f
            java.lang.String r1 = r21.getSymbol()
            int r1 = ej.f.o(r1)
            goto L_0x0187
        L_0x017f:
            java.lang.String r1 = r21.getSymbol()
            int r1 = ej.f.t(r1)
        L_0x0187:
            java.lang.String r1 = i6.m.m(r4, r1)
            r6.setText(r1)
            boolean r1 = r21.isBuy()
            if (r1 == 0) goto L_0x01a0
            int r1 = com.hbg.lib.core.util.w.h()
            int r1 = r2.getColor(r1)
            r3.setTextColor(r1)
            goto L_0x01ab
        L_0x01a0:
            int r1 = com.hbg.lib.core.util.w.d()
            int r1 = r2.getColor(r1)
            r3.setTextColor(r1)
        L_0x01ab:
            boolean r1 = r21.isOpen()
            if (r1 == 0) goto L_0x01c5
            boolean r1 = r21.isBuy()
            if (r1 == 0) goto L_0x01be
            int r1 = com.hbg.lib.contract.R$string.contract_trade_open_more
            java.lang.String r1 = r2.getString(r1)
            goto L_0x01f2
        L_0x01be:
            int r1 = com.hbg.lib.contract.R$string.contract_trade_open_low
            java.lang.String r1 = r2.getString(r1)
            goto L_0x01f2
        L_0x01c5:
            boolean r1 = r21.isDelivery()
            if (r1 == 0) goto L_0x01d2
            int r1 = com.hbg.lib.contract.R$string.currency_detail_contract_status_force_delivry
            java.lang.String r1 = r2.getString(r1)
            goto L_0x01f2
        L_0x01d2:
            boolean r1 = r21.isExplose()
            if (r1 == 0) goto L_0x01df
            int r1 = com.hbg.lib.contract.R$string.currency_detail_contract_status_force_flat
            java.lang.String r1 = r2.getString(r1)
            goto L_0x01f2
        L_0x01df:
            boolean r1 = r21.isBuy()
            if (r1 == 0) goto L_0x01ec
            int r1 = com.hbg.lib.contract.R$string.contract_trade_close_low
            java.lang.String r1 = r2.getString(r1)
            goto L_0x01f2
        L_0x01ec:
            int r1 = com.hbg.lib.contract.R$string.contract_trade_close_more
            java.lang.String r1 = r2.getString(r1)
        L_0x01f2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r1 = "·"
            r4.append(r1)
            int r1 = r21.getLeverRate()
            r4.append(r1)
            java.lang.String r1 = "X"
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.setText(r1)
            java.lang.String r1 = r21.getTriggerType()
            java.lang.String r3 = "ge"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0225
            int r1 = com.hbg.lib.contract.R$string.string_flag_bigger_equals
            java.lang.String r1 = com.hbg.lib.common.BaseApplication.c(r1)
            goto L_0x023e
        L_0x0225:
            java.lang.String r1 = r21.getTriggerType()
            java.lang.String r3 = "ge_mark"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0238
            int r1 = com.hbg.lib.contract.R$string.string_flag_bigger_equals
            java.lang.String r1 = com.hbg.lib.common.BaseApplication.c(r1)
            goto L_0x023e
        L_0x0238:
            int r1 = com.hbg.lib.contract.R$string.string_flag_smaller_equals
            java.lang.String r1 = com.hbg.lib.common.BaseApplication.c(r1)
        L_0x023e:
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r21.getTriggerPrice()
            java.lang.String r6 = r21.getSymbol()
            int r6 = ej.f.r(r6)
            java.lang.String r4 = i6.m.m(r4, r6)
            r3[r0] = r4
            r4 = 1
            r3[r4] = r11
            java.lang.String r1 = java.lang.String.format(r14, r1, r3)
            r8.setText(r1)
            int r1 = r21.getStatus()
            if (r1 == 0) goto L_0x028b
            r3 = 4
            if (r1 == r3) goto L_0x0282
            r3 = 5
            if (r1 == r3) goto L_0x0279
            r3 = 6
            if (r1 == r3) goto L_0x0272
            java.lang.String r1 = ""
        L_0x026e:
            r3 = r0
        L_0x026f:
            r12 = r16
            goto L_0x0292
        L_0x0272:
            int r1 = com.hbg.lib.contract.R$string.order_canceled_label
            java.lang.String r1 = r2.getString(r1)
            goto L_0x026e
        L_0x0279:
            int r1 = com.hbg.lib.contract.R$string.contract_trigger_order_status_failed
            java.lang.String r1 = r2.getString(r1)
            int r3 = com.hbg.lib.contract.R$drawable.icon_ask
            goto L_0x026f
        L_0x0282:
            int r1 = com.hbg.lib.contract.R$string.contract_trigger_order_status_ordered
            java.lang.String r1 = r2.getString(r1)
            int r3 = com.hbg.lib.contract.R$drawable.lite_form_right_arrow
            goto L_0x026f
        L_0x028b:
            int r1 = com.hbg.lib.contract.R$string.contract_order_canceled
            java.lang.String r1 = r2.getString(r1)
            goto L_0x026e
        L_0x0292:
            r12.setCompoundDrawablesWithIntrinsicBounds(r0, r0, r3, r0)
            r12.setText(r1)
            if (r3 == 0) goto L_0x02a6
            r0 = r21
            r1 = r4
            r12.setTag(r0)
            r3 = r18
            r12.setOnClickListener(r3)
            goto L_0x02ae
        L_0x02a6:
            r3 = r18
            r0 = r21
            r1 = r4
            r12.setOnClickListener(r5)
        L_0x02ae:
            r4 = r22
            com.hbg.lib.common.utils.ViewUtil.m(r4, r1)
            long r4 = r21.getTriggeredAt()
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x02d6
            int r1 = com.hbg.lib.contract.R$string.contract_trigger_order_trigger_time
            java.lang.String r1 = r2.getString(r1)
            r14 = r20
            r14.setText(r1)
            long r0 = r21.getTriggeredAt()
            java.lang.String r0 = com.hbg.lib.common.utils.DateTimeUtils.C(r0)
            r13 = r19
            r13.setText(r0)
            goto L_0x02ee
        L_0x02d6:
            r13 = r19
            r14 = r20
            int r1 = com.hbg.lib.contract.R$string.n_contract_order_time
            java.lang.String r1 = r2.getString(r1)
            r14.setText(r1)
            long r0 = r21.getCreatedAt()
            java.lang.String r0 = com.hbg.lib.common.utils.DateTimeUtils.C(r0)
            r13.setText(r0)
        L_0x02ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.viewhandler.ContractHistoryTriggerOrderHandler.handleView(v9.c, int, com.huobi.contract.entity.ContractHistoryTriggerOrderInfo, android.view.ViewGroup):void");
    }

    public int getResId() {
        return R$layout.item_contract_history_trigger_order_list;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        ContractHistoryTriggerOrderInfo contractHistoryTriggerOrderInfo = (ContractHistoryTriggerOrderInfo) view.getTag();
        if (!(contractHistoryTriggerOrderInfo == null || contractHistoryTriggerOrderInfo.getCallback() == null)) {
            contractHistoryTriggerOrderInfo.getCallback().a(contractHistoryTriggerOrderInfo);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
