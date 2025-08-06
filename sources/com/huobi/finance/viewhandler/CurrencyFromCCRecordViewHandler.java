package com.huobi.finance.viewhandler;

import android.content.Intent;
import android.view.View;
import com.huobi.finance.bean.CurrencyFromCCFinanceRecordItem;
import com.huobi.finance.ui.CurrencyFromCCDetailOrderActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import s9.c;

public class CurrencyFromCCRecordViewHandler implements c, View.OnClickListener {

    public static class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final CurrencyFromCCFinanceRecordItem f67616b;

        public a(CurrencyFromCCFinanceRecordItem currencyFromCCFinanceRecordItem) {
            this.f67616b = currencyFromCCFinanceRecordItem;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            CurrencyFromCCFinanceRecordItem currencyFromCCFinanceRecordItem = this.f67616b;
            if (!(currencyFromCCFinanceRecordItem == null || currencyFromCCFinanceRecordItem.getListener() == null)) {
                this.f67616b.getListener().onCancelListener(this.f67616b);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public CurrencyFromCCFinanceRecordItem f67617b;

        public b(CurrencyFromCCFinanceRecordItem currencyFromCCFinanceRecordItem) {
            this.f67617b = currencyFromCCFinanceRecordItem;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            CurrencyFromCCFinanceRecordItem currencyFromCCFinanceRecordItem = this.f67617b;
            if (!(currencyFromCCFinanceRecordItem == null || currencyFromCCFinanceRecordItem.getListener() == null)) {
                this.f67617b.getListener().onPaymentListener(this.f67617b);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x010a  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r17, int r18, com.huobi.finance.bean.CurrencyFromCCFinanceRecordItem r19, android.view.ViewGroup r20) {
        /*
            r16 = this;
            r0 = r19
            java.lang.String r1 = "--"
            r2 = r17
            android.view.View r3 = r2.itemView
            android.content.Context r4 = r3.getContext()
            com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo r5 = r19.getInfo()
            r6 = r16
            r3.setOnClickListener(r6)
            i6.r r2 = r17.e()
            r7 = 2131428964(0x7f0b0664, float:1.8479587E38)
            android.widget.TextView r7 = r2.e(r7)
            r8 = 2131428965(0x7f0b0665, float:1.847959E38)
            android.widget.TextView r8 = r2.e(r8)
            java.lang.String r9 = ""
            r8.setText(r9)
            r9 = 2131428976(0x7f0b0670, float:1.8479612E38)
            android.widget.TextView r9 = r2.e(r9)
            r10 = 2131428968(0x7f0b0668, float:1.8479595E38)
            android.widget.TextView r10 = r2.e(r10)
            r11 = 2131428969(0x7f0b0669, float:1.8479597E38)
            android.view.View r11 = r2.b(r11)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r12 = 2131428972(0x7f0b066c, float:1.8479604E38)
            android.widget.TextView r12 = r2.e(r12)
            r13 = 2131428971(0x7f0b066b, float:1.8479602E38)
            android.widget.TextView r13 = r2.e(r13)
            r14 = 2131428959(0x7f0b065f, float:1.8479577E38)
            android.widget.TextView r14 = r2.e(r14)
            r15 = 2131428962(0x7f0b0662, float:1.8479583E38)
            android.widget.TextView r15 = r2.e(r15)
            r18 = r1
            r1 = 2131431236(0x7f0b0f44, float:1.8484196E38)
            android.view.View r1 = r2.b(r1)
            r2 = 0
            r1.setVisibility(r2)
            int r2 = r5.getType()
            r6 = 1
            r20 = r3
            r3 = 2
            if (r2 == r6) goto L_0x009c
            if (r2 == r3) goto L_0x0095
            r3 = 3
            if (r2 == r3) goto L_0x007c
            goto L_0x00a2
        L_0x007c:
            r2 = 2132021598(0x7f14115e, float:1.9681592E38)
            r7.setText(r2)
            r2 = 8
            r1.setVisibility(r2)
            boolean r1 = r5.isTransferIn()
            if (r1 == 0) goto L_0x0091
            r1 = 2132022082(0x7f141342, float:1.9682574E38)
            goto L_0x00a3
        L_0x0091:
            r1 = 2132022083(0x7f141343, float:1.9682576E38)
            goto L_0x00a3
        L_0x0095:
            r1 = 2132021599(0x7f14115f, float:1.9681594E38)
            r7.setText(r1)
            goto L_0x00a2
        L_0x009c:
            r1 = 2132021597(0x7f14115d, float:1.968159E38)
            r7.setText(r1)
        L_0x00a2:
            r1 = 0
        L_0x00a3:
            int r2 = r5.getStateInt()
            if (r6 != r2) goto L_0x00cb
            int r2 = r5.getType()
            r3 = 2
            if (r2 != r3) goto L_0x00b1
            goto L_0x00cb
        L_0x00b1:
            r2 = 8
            r10.setVisibility(r2)
            r3 = 0
            r11.setVisibility(r3)
            com.huobi.finance.viewhandler.CurrencyFromCCRecordViewHandler$b r2 = new com.huobi.finance.viewhandler.CurrencyFromCCRecordViewHandler$b
            r2.<init>(r0)
            r12.setOnClickListener(r2)
            com.huobi.finance.viewhandler.CurrencyFromCCRecordViewHandler$a r2 = new com.huobi.finance.viewhandler.CurrencyFromCCRecordViewHandler$a
            r2.<init>(r0)
            r13.setOnClickListener(r2)
            goto L_0x00db
        L_0x00cb:
            r2 = 8
            r3 = 0
            r10.setVisibility(r3)
            r11.setVisibility(r2)
            java.lang.String r2 = r0.getStatusTextId(r4)
            r10.setText(r2)
        L_0x00db:
            if (r1 == 0) goto L_0x00f2
            java.lang.String r2 = " ("
            r8.append(r2)
            android.content.res.Resources r2 = r8.getResources()
            java.lang.String r1 = r2.getString(r1)
            r8.append(r1)
            java.lang.String r1 = ")"
            r8.append(r1)
        L_0x00f2:
            long r1 = r5.getCreateAtLong()
            boolean r1 = com.hbg.lib.common.utils.DateTimeUtils.E(r1)
            if (r1 == 0) goto L_0x010a
            long r1 = r5.getCreateAtLong()
            java.lang.String r3 = "HH:mm MM/dd"
            java.lang.String r1 = com.hbg.lib.common.utils.DateTimeUtils.h(r1, r3)
            r9.setText(r1)
            goto L_0x0117
        L_0x010a:
            long r1 = r5.getCreateAtLong()
            java.lang.String r3 = "HH:mm MM/dd/yyyy "
            java.lang.String r1 = com.hbg.lib.common.utils.DateTimeUtils.h(r1, r3)
            r9.setText(r1)
        L_0x0117:
            java.math.BigDecimal r1 = r5.getAmount()     // Catch:{ Exception -> 0x0121 }
            r2 = 2
            java.lang.String r1 = i6.m.q(r1, r2)     // Catch:{ Exception -> 0x0122 }
            goto L_0x0124
        L_0x0121:
            r2 = 2
        L_0x0122:
            r1 = r18
        L_0x0124:
            r14.setText(r1)
            java.math.BigDecimal r1 = r5.getFee()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r1 = i6.m.q(r1, r2)     // Catch:{ Exception -> 0x0130 }
            goto L_0x0132
        L_0x0130:
            r1 = r18
        L_0x0132:
            r15.setText(r1)
            r1 = 2131431238(0x7f0b0f46, float:1.84842E38)
            r2 = r20
            r2.setTag(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.viewhandler.CurrencyFromCCRecordViewHandler.handleView(v9.c, int, com.huobi.finance.bean.CurrencyFromCCFinanceRecordItem, android.view.ViewGroup):void");
    }

    public int getResId() {
        return R.layout.item_currency_from_cc_allrecord;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        CurrencyFromCCFinanceRecordItem currencyFromCCFinanceRecordItem = (CurrencyFromCCFinanceRecordItem) view.getTag(R.id.item_data);
        if (currencyFromCCFinanceRecordItem == null || !(currencyFromCCFinanceRecordItem.getInfo().getType() == 1 || currencyFromCCFinanceRecordItem.getInfo().getType() == 2)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(view.getContext(), CurrencyFromCCDetailOrderActivity.class);
        intent.putExtra("currency_from_cc_finance_record_item", currencyFromCCFinanceRecordItem.getInfo().clone());
        view.getContext().startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
