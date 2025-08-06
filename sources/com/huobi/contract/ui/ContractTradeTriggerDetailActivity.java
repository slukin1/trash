package com.huobi.contract.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.contract.entity.ContractHistoryTriggerOrderInfo;
import com.huobi.contract.entity.ContractOrderRspInfo;
import com.huobi.contract.helper.ContractOrderHelper;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import dj.b3;
import dj.c3;
import java.util.List;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import q6.d;

public class ContractTradeTriggerDetailActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public ContractHistoryTriggerOrderInfo f43497b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f43498c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f43499d;

    public static /* synthetic */ ContractOrderRspInfo Pg(List list) {
        return (ContractOrderRspInfo) list.get(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qg(ContractOrderRspInfo contractOrderRspInfo) {
        if (contractOrderRspInfo != null) {
            Zf(contractOrderRspInfo);
        }
    }

    public final void Og() {
        setToolBar((Toolbar) this.viewFinder.b(R.id.toolbar), gg(), true);
        ((CollapsingToolbarLayout) this.viewFinder.b(R.id.collapsing_toolbar)).setShowDivider(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0375  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Zf(com.huobi.contract.entity.ContractOrderRspInfo r13) {
        /*
            r12 = this;
            java.lang.String r0 = r13.getOrderPriceType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0043
            java.lang.String r0 = r13.getOrderPriceType()
            java.lang.String r3 = "_"
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = r13.getOrderPriceType()
            java.lang.String[] r0 = r0.split(r3)
            int r3 = r0.length
            if (r3 <= r2) goto L_0x0043
            r3 = r0[r2]
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0043
            java.util.Locale r3 = java.util.Locale.US
            android.content.res.Resources r4 = r12.getResources()
            r5 = 2132018226(0x7f140432, float:1.9674753E38)
            java.lang.String r4 = r4.getString(r5)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r0 = r0[r2]
            r5[r1] = r0
            java.lang.String r0 = java.lang.String.format(r3, r4, r5)
            goto L_0x0044
        L_0x0043:
            r0 = 0
        L_0x0044:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r4 = 2132021979(0x7f1412db, float:1.9682365E38)
            r5 = 2
            java.lang.String r6 = "%s-%s"
            if (r3 == 0) goto L_0x006b
            android.widget.TextView r0 = r12.f43499d
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r4 = r12.getString(r4)
            r3[r1] = r4
            r1 = 2132021959(0x7f1412c7, float:1.9682324E38)
            java.lang.String r1 = r12.getString(r1)
            r3[r2] = r1
            java.lang.String r1 = java.lang.String.format(r6, r3)
            r0.setText(r1)
            goto L_0x007e
        L_0x006b:
            android.widget.TextView r3 = r12.f43499d
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r4 = r12.getString(r4)
            r5[r1] = r4
            r5[r2] = r0
            java.lang.String r0 = java.lang.String.format(r6, r5)
            r3.setText(r0)
        L_0x007e:
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.CONTRACT
            boolean r0 = a7.e.E(r0)
            r1 = 2132018209(0x7f140421, float:1.9674718E38)
            if (r0 == 0) goto L_0x008e
            java.lang.String r2 = r13.getSymbol()
            goto L_0x0092
        L_0x008e:
            java.lang.String r2 = r12.getString(r1)
        L_0x0092:
            com.huobi.view.KeyValueItemView r3 = new com.huobi.view.KeyValueItemView
            r3.<init>(r12)
            r4 = 2132021932(0x7f1412ac, float:1.968227E38)
            java.lang.String r4 = r12.getString(r4)
            r3.setKeyText(r4)
            com.huobi.contract.entity.ContractHistoryTriggerOrderInfo r4 = r12.f43497b
            long r4 = r4.getTriggeredAt()
            java.lang.String r4 = com.hbg.lib.common.utils.DateTimeUtils.C(r4)
            r3.setValueText(r4)
            android.widget.LinearLayout r4 = r12.f43498c
            r4.addView(r3)
            boolean r3 = r13.isOpen()
            r4 = 2132021848(0x7f141258, float:1.9682099E38)
            r5 = 2132021999(0x7f1412ef, float:1.9682405E38)
            if (r3 == 0) goto L_0x00fc
            boolean r3 = r13.isBuy()
            if (r3 == 0) goto L_0x00e1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r12.getString(r4)
            r3.append(r4)
            r4 = 2132018295(0x7f140477, float:1.9674893E38)
            java.lang.String r4 = r12.getString(r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            goto L_0x0153
        L_0x00e1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r12.getString(r5)
            r3.append(r4)
            r4 = 2132018294(0x7f140476, float:1.967489E38)
            java.lang.String r4 = r12.getString(r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            goto L_0x0153
        L_0x00fc:
            boolean r3 = r13.isDelivery()
            if (r3 == 0) goto L_0x010a
            r3 = 2132018386(0x7f1404d2, float:1.9675077E38)
            java.lang.String r3 = r12.getString(r3)
            goto L_0x0153
        L_0x010a:
            boolean r3 = r13.isExplose()
            if (r3 == 0) goto L_0x0118
            r3 = 2132018387(0x7f1404d3, float:1.967508E38)
            java.lang.String r3 = r12.getString(r3)
            goto L_0x0153
        L_0x0118:
            boolean r3 = r13.isBuy()
            if (r3 == 0) goto L_0x0139
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r12.getString(r4)
            r3.append(r4)
            r4 = 2132018276(0x7f140464, float:1.9674854E38)
            java.lang.String r4 = r12.getString(r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            goto L_0x0153
        L_0x0139:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r12.getString(r5)
            r3.append(r4)
            r4 = 2132018277(0x7f140465, float:1.9674856E38)
            java.lang.String r4 = r12.getString(r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x0153:
            com.huobi.view.KeyValueItemView r4 = new com.huobi.view.KeyValueItemView
            r4.<init>(r12)
            r5 = 2132021088(0x7f140f60, float:1.9680557E38)
            java.lang.String r5 = r12.getString(r5)
            r4.setKeyText(r5)
            r4.setValueText(r3)
            android.widget.LinearLayout r3 = r12.f43498c
            r3.addView(r4)
            java.lang.String r3 = r13.getVolume()
            java.lang.String r4 = r13.getPrice()
            com.huobi.contract.entity.ContractHistoryTriggerOrderInfo r5 = r12.f43497b
            java.lang.String r5 = r5.getContractFace()
            java.lang.String r3 = com.huobi.contract.helper.ContractOrderHelper.e(r3, r4, r5)
            if (r0 == 0) goto L_0x0187
            java.lang.String r4 = r13.getSymbol()
            int r4 = ej.f.o(r4)
            goto L_0x018f
        L_0x0187:
            java.lang.String r4 = r13.getSymbol()
            int r4 = ej.f.t(r4)
        L_0x018f:
            java.lang.String r3 = i6.m.m(r3, r4)
            com.huobi.view.KeyValueItemView r4 = new com.huobi.view.KeyValueItemView
            r4.<init>(r12)
            r5 = 2132021956(0x7f1412c4, float:1.9682318E38)
            java.lang.String r5 = r12.getString(r5)
            r4.setKeyText(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r3 = " "
            r5.append(r3)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4.setValueText(r2)
            android.widget.LinearLayout r2 = r12.f43498c
            r2.addView(r4)
            com.huobi.view.KeyValueItemView r2 = new com.huobi.view.KeyValueItemView
            r2.<init>(r12)
            r4 = 2132021957(0x7f1412c5, float:1.968232E38)
            java.lang.String r4 = r12.getString(r4)
            r2.setKeyText(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r13.getPrice()
            java.lang.String r6 = r13.getSymbol()
            int r6 = ej.f.r(r6)
            java.lang.String r7 = "--"
            java.lang.String r5 = i6.m.n(r5, r6, r7)
            r4.append(r5)
            java.lang.String r5 = " USD"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.setValueText(r4)
            android.widget.LinearLayout r4 = r12.f43498c
            r4.addView(r2)
            int r2 = r13.getStatus()
            r4 = 6
            r6 = 5
            r8 = 4
            if (r2 == r8) goto L_0x020d
            int r2 = r13.getStatus()
            if (r2 == r6) goto L_0x020d
            int r2 = r13.getStatus()
            if (r2 != r4) goto L_0x033b
        L_0x020d:
            if (r0 == 0) goto L_0x0214
            java.lang.String r1 = r13.getSymbol()
            goto L_0x0218
        L_0x0214:
            java.lang.String r1 = com.hbg.lib.common.BaseApplication.c(r1)
        L_0x0218:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r9 = r13.getTradeVolume()
            java.lang.String r10 = r13.getPrice()
            com.huobi.contract.entity.ContractHistoryTriggerOrderInfo r11 = r12.f43497b
            java.lang.String r11 = r11.getContractFace()
            java.lang.String r9 = com.huobi.contract.helper.ContractOrderHelper.e(r9, r10, r11)
            if (r0 == 0) goto L_0x023a
            java.lang.String r0 = r13.getSymbol()
            int r0 = ej.f.o(r0)
            goto L_0x0242
        L_0x023a:
            java.lang.String r0 = r13.getSymbol()
            int r0 = ej.f.c(r0)
        L_0x0242:
            java.lang.String r0 = i6.m.m(r9, r0)
            r2.append(r0)
            r2.append(r3)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            com.huobi.view.KeyValueItemView r1 = new com.huobi.view.KeyValueItemView
            r1.<init>(r12)
            r2 = 2132021938(0x7f1412b2, float:1.9682281E38)
            java.lang.String r2 = r12.getString(r2)
            r1.setKeyText(r2)
            r1.setValueText(r0)
            android.widget.LinearLayout r0 = r12.f43498c
            r0.addView(r1)
            java.lang.String r0 = r13.getTradeAvgPrice()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = r13.getTradeAvgPrice()
            java.lang.String r1 = r13.getContractCode()
            int r1 = ej.f.p(r1)
            java.lang.String r7 = i6.m.m(r0, r1)
        L_0x0284:
            com.huobi.view.KeyValueItemView r0 = new com.huobi.view.KeyValueItemView
            r0.<init>(r12)
            r1 = 2132021963(0x7f1412cb, float:1.9682332E38)
            java.lang.String r1 = r12.getString(r1)
            r0.setKeyText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.setValueText(r1)
            android.widget.LinearLayout r1 = r12.f43498c
            r1.addView(r0)
            boolean r0 = r13.isOpen()
            if (r0 == 0) goto L_0x02c1
            java.lang.String r0 = r13.getMarginFrozen()
            java.lang.String r1 = r13.getContractCode()
            int r1 = ej.f.n(r1)
            java.lang.String r0 = i6.m.m(r0, r1)
            goto L_0x02d1
        L_0x02c1:
            java.lang.String r0 = r13.getProfit()
            java.lang.String r1 = r13.getContractCode()
            int r1 = ej.f.n(r1)
            java.lang.String r0 = i6.m.m(r0, r1)
        L_0x02d1:
            com.huobi.view.KeyValueItemView r1 = new com.huobi.view.KeyValueItemView
            r1.<init>(r12)
            r2 = 2132021006(0x7f140f0e, float:1.9680391E38)
            java.lang.String r2 = r12.getString(r2)
            r1.setKeyText(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r3)
            java.lang.String r0 = r13.getSymbol()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.setValueText(r0)
            android.widget.LinearLayout r0 = r12.f43498c
            r0.addView(r1)
            com.huobi.view.KeyValueItemView r0 = new com.huobi.view.KeyValueItemView
            r0.<init>(r12)
            r1 = 2132021933(0x7f1412ad, float:1.9682271E38)
            java.lang.String r1 = r12.getString(r1)
            r0.setKeyText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r13.getFee()
            java.lang.String r5 = r13.getContractCode()
            int r5 = ej.f.l(r5)
            java.lang.String r2 = i6.m.u(r2, r5)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = r13.getSymbol()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setValueText(r1)
            android.widget.LinearLayout r1 = r12.f43498c
            r1.addView(r0)
        L_0x033b:
            com.huobi.view.KeyValueItemView r0 = new com.huobi.view.KeyValueItemView
            r0.<init>(r12)
            r1 = 2132020965(0x7f140ee5, float:1.9680308E38)
            java.lang.String r1 = r12.getString(r1)
            r0.setKeyText(r1)
            int r13 = r13.getStatus()
            r1 = 3
            if (r13 == r1) goto L_0x0375
            if (r13 == r8) goto L_0x036d
            if (r13 == r6) goto L_0x036d
            if (r13 == r4) goto L_0x0365
            r1 = 7
            if (r13 == r1) goto L_0x035d
            java.lang.String r13 = ""
            goto L_0x037c
        L_0x035d:
            r13 = 2132018213(0x7f140425, float:1.9674726E38)
            java.lang.String r13 = r12.getString(r13)
            goto L_0x037c
        L_0x0365:
            r13 = 2132018220(0x7f14042c, float:1.967474E38)
            java.lang.String r13 = r12.getString(r13)
            goto L_0x037c
        L_0x036d:
            r13 = 2132018222(0x7f14042e, float:1.9674745E38)
            java.lang.String r13 = r12.getString(r13)
            goto L_0x037c
        L_0x0375:
            r13 = 2132021172(0x7f140fb4, float:1.9680728E38)
            java.lang.String r13 = r12.getString(r13)
        L_0x037c:
            r0.setValueText(r13)
            android.widget.LinearLayout r13 = r12.f43498c
            r13.addView(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.ui.ContractTradeTriggerDetailActivity.Zf(com.huobi.contract.entity.ContractOrderRspInfo):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x02ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fg(com.huobi.contract.entity.ContractHistoryTriggerOrderInfo r20) {
        /*
            r19 = this;
            r0 = r19
            com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT
            boolean r1 = a7.e.E(r1)
            i6.r r2 = r0.viewFinder
            r3 = 2131431227(0x7f0b0f3b, float:1.8484177E38)
            android.view.View r2 = r2.b(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            i6.r r3 = r0.viewFinder
            r4 = 2131431226(0x7f0b0f3a, float:1.8484175E38)
            android.view.View r3 = r3.b(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            i6.r r4 = r0.viewFinder
            r5 = 2131431221(0x7f0b0f35, float:1.8484165E38)
            android.view.View r4 = r4.b(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            i6.r r5 = r0.viewFinder
            r6 = 2131431220(0x7f0b0f34, float:1.8484163E38)
            android.view.View r5 = r5.b(r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            i6.r r5 = r0.viewFinder
            r6 = 2131431215(0x7f0b0f2f, float:1.8484153E38)
            android.view.View r5 = r5.b(r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            i6.r r6 = r0.viewFinder
            r7 = 2131431216(0x7f0b0f30, float:1.8484155E38)
            android.view.View r6 = r6.b(r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            i6.r r7 = r0.viewFinder
            r8 = 2131431210(0x7f0b0f2a, float:1.8484143E38)
            android.view.View r7 = r7.b(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            i6.r r8 = r0.viewFinder
            r9 = 2131431214(0x7f0b0f2e, float:1.848415E38)
            android.view.View r8 = r8.b(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            i6.r r9 = r0.viewFinder
            r10 = 2131431208(0x7f0b0f28, float:1.8484139E38)
            android.view.View r9 = r9.b(r10)
            android.widget.TextView r9 = (android.widget.TextView) r9
            i6.r r10 = r0.viewFinder
            r11 = 2131431209(0x7f0b0f29, float:1.848414E38)
            android.view.View r10 = r10.b(r11)
            android.widget.TextView r10 = (android.widget.TextView) r10
            i6.r r11 = r0.viewFinder
            r12 = 2131431224(0x7f0b0f38, float:1.8484171E38)
            android.view.View r11 = r11.b(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            i6.r r12 = r0.viewFinder
            r13 = 2131431212(0x7f0b0f2c, float:1.8484147E38)
            android.view.View r12 = r12.b(r13)
            android.widget.TextView r12 = (android.widget.TextView) r12
            i6.r r13 = r0.viewFinder
            r14 = 2131431211(0x7f0b0f2b, float:1.8484145E38)
            android.view.View r13 = r13.b(r14)
            i6.r r14 = r0.viewFinder
            r15 = 2131431202(0x7f0b0f22, float:1.8484127E38)
            r14.b(r15)
            if (r1 == 0) goto L_0x00a4
            java.lang.String r14 = r20.getSymbol()
            goto L_0x00af
        L_0x00a4:
            android.content.res.Resources r14 = r19.getResources()
            r15 = 2132018209(0x7f140421, float:1.9674718E38)
            java.lang.String r14 = r14.getString(r15)
        L_0x00af:
            java.util.Locale r15 = java.util.Locale.US
            android.content.res.Resources r0 = r19.getResources()
            r16 = r12
            r12 = 2132018201(0x7f140419, float:1.9674702E38)
            java.lang.String r0 = r0.getString(r12)
            r12 = 1
            r17 = r13
            java.lang.Object[] r13 = new java.lang.Object[r12]
            r12 = 0
            r13[r12] = r14
            java.lang.String r0 = java.lang.String.format(r15, r0, r13)
            r6.setText(r0)
            android.content.res.Resources r0 = r19.getResources()
            r6 = 2132027244(0x7f14276c, float:1.9693043E38)
            java.lang.String r0 = r0.getString(r6)
            r6 = 1
            java.lang.Object[] r13 = new java.lang.Object[r6]
            java.lang.String r14 = "usd"
            java.lang.String r18 = r14.toUpperCase(r15)
            r13[r12] = r18
            java.lang.String r0 = java.lang.String.format(r15, r0, r13)
            r8.setText(r0)
            android.content.res.Resources r0 = r19.getResources()
            r8 = 2132018200(0x7f140418, float:1.96747E38)
            java.lang.String r0 = r0.getString(r8)
            java.lang.Object[] r8 = new java.lang.Object[r6]
            java.lang.String r6 = r14.toUpperCase(r15)
            r8[r12] = r6
            java.lang.String r0 = java.lang.String.format(r15, r0, r8)
            r10.setText(r0)
            java.lang.String r0 = r20.getContractCode()
            java.lang.String r0 = ej.g.g(r0)
            r3.setText(r0)
            long r13 = r20.getCreatedAt()
            java.lang.String r0 = com.hbg.lib.common.utils.DateTimeUtils.C(r13)
            r4.setText(r0)
            java.lang.String r0 = r20.getOrderPriceType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r3 = 0
            if (r0 != 0) goto L_0x015f
            java.lang.String r0 = r20.getOrderPriceType()
            java.lang.String r4 = "_"
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto L_0x015f
            java.lang.String r0 = r20.getOrderPriceType()
            java.lang.String[] r0 = r0.split(r4)
            int r4 = r0.length
            r6 = 1
            if (r4 <= r6) goto L_0x015f
            r4 = r0[r6]
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x015f
            android.content.res.Resources r3 = r19.getResources()
            r4 = 2132018226(0x7f140432, float:1.9674753E38)
            java.lang.String r3 = r3.getString(r4)
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r0 = r0[r6]
            r4[r12] = r0
            java.lang.String r3 = java.lang.String.format(r15, r3, r4)
            java.lang.String r0 = r20.getTriggerPrice()
            goto L_0x0160
        L_0x015f:
            r0 = r3
        L_0x0160:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r6 = "--"
            if (r4 == 0) goto L_0x017c
            java.lang.String r0 = r20.getOrderPrice()
            java.lang.String r3 = r20.getSymbol()
            int r3 = ej.f.r(r3)
            java.lang.String r3 = i6.m.n(r0, r3, r6)
            java.lang.String r0 = r20.getOrderPrice()
        L_0x017c:
            r9.setText(r3)
            java.lang.String r3 = r20.getVolume()
            java.lang.String r4 = r20.getContractFace()
            java.lang.String r0 = com.huobi.contract.helper.ContractOrderHelper.e(r3, r0, r4)
            if (r1 == 0) goto L_0x0196
            java.lang.String r1 = r20.getSymbol()
            int r1 = ej.f.o(r1)
            goto L_0x019e
        L_0x0196:
            java.lang.String r1 = r20.getSymbol()
            int r1 = ej.f.t(r1)
        L_0x019e:
            java.lang.String r0 = i6.m.m(r0, r1)
            r5.setText(r0)
            boolean r0 = r20.isBuy()
            if (r0 == 0) goto L_0x01bb
            android.content.res.Resources r0 = r19.getResources()
            int r1 = com.hbg.lib.core.util.w.h()
            int r0 = r0.getColor(r1)
            r2.setTextColor(r0)
            goto L_0x01ca
        L_0x01bb:
            android.content.res.Resources r0 = r19.getResources()
            int r1 = com.hbg.lib.core.util.w.d()
            int r0 = r0.getColor(r1)
            r2.setTextColor(r0)
        L_0x01ca:
            boolean r0 = r20.isOpen()
            if (r0 == 0) goto L_0x01ee
            boolean r0 = r20.isBuy()
            if (r0 == 0) goto L_0x01e2
            android.content.res.Resources r0 = r19.getResources()
            r1 = 2132018295(0x7f140477, float:1.9674893E38)
            java.lang.String r0 = r0.getString(r1)
            goto L_0x022f
        L_0x01e2:
            android.content.res.Resources r0 = r19.getResources()
            r1 = 2132018294(0x7f140476, float:1.967489E38)
            java.lang.String r0 = r0.getString(r1)
            goto L_0x022f
        L_0x01ee:
            boolean r0 = r20.isDelivery()
            if (r0 == 0) goto L_0x0200
            android.content.res.Resources r0 = r19.getResources()
            r1 = 2132018386(0x7f1404d2, float:1.9675077E38)
            java.lang.String r0 = r0.getString(r1)
            goto L_0x022f
        L_0x0200:
            boolean r0 = r20.isExplose()
            if (r0 == 0) goto L_0x0212
            android.content.res.Resources r0 = r19.getResources()
            r1 = 2132018387(0x7f1404d3, float:1.967508E38)
            java.lang.String r0 = r0.getString(r1)
            goto L_0x022f
        L_0x0212:
            boolean r0 = r20.isBuy()
            if (r0 == 0) goto L_0x0224
            android.content.res.Resources r0 = r19.getResources()
            r1 = 2132018276(0x7f140464, float:1.9674854E38)
            java.lang.String r0 = r0.getString(r1)
            goto L_0x022f
        L_0x0224:
            android.content.res.Resources r0 = r19.getResources()
            r1 = 2132018277(0x7f140465, float:1.9674856E38)
            java.lang.String r0 = r0.getString(r1)
        L_0x022f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "·"
            r1.append(r0)
            int r0 = r20.getLeverRate()
            r1.append(r0)
            java.lang.String r0 = "X"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r2.setText(r0)
            java.lang.String r0 = r20.getTriggerType()
            java.lang.String r1 = "ge"
            boolean r0 = r1.equalsIgnoreCase(r0)
            r1 = 2132026964(0x7f142654, float:1.9692475E38)
            if (r0 == 0) goto L_0x0263
            java.lang.String r0 = com.hbg.lib.common.BaseApplication.c(r1)
            goto L_0x027b
        L_0x0263:
            java.lang.String r0 = r20.getTriggerType()
            java.lang.String r2 = "ge_mark"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0274
            java.lang.String r0 = com.hbg.lib.common.BaseApplication.c(r1)
            goto L_0x027b
        L_0x0274:
            r0 = 2132026965(0x7f142655, float:1.9692477E38)
            java.lang.String r0 = com.hbg.lib.common.BaseApplication.c(r0)
        L_0x027b:
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r20.getTriggerPrice()
            java.lang.String r3 = r20.getSymbol()
            int r3 = ej.f.r(r3)
            java.lang.String r2 = i6.m.m(r2, r3)
            r1[r12] = r2
            r2 = 1
            r1[r2] = r6
            java.lang.String r0 = java.lang.String.format(r15, r0, r1)
            r7.setText(r0)
            r11.setCompoundDrawablesWithIntrinsicBounds(r12, r12, r12, r12)
            java.lang.String r0 = ""
            r11.setText(r0)
            long r0 = r20.getTriggeredAt()
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x02ad
            r12 = r2
        L_0x02ad:
            r0 = r17
            com.hbg.lib.common.utils.ViewUtil.m(r0, r12)
            long r0 = r20.getTriggeredAt()
            java.lang.String r0 = com.hbg.lib.common.utils.DateTimeUtils.C(r0)
            r12 = r16
            r12.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.ui.ContractTradeTriggerDetailActivity.fg(com.huobi.contract.entity.ContractHistoryTriggerOrderInfo):void");
    }

    public int getContentView() {
        return R.layout.contract_activity_trade_trigger_detail;
    }

    public String gg() {
        return getString(R.string.n_contract_entrusted_record);
    }

    public final void oh(ContractHistoryTriggerOrderInfo contractHistoryTriggerOrderInfo) {
        ContractOrderHelper.k(contractHistoryTriggerOrderInfo.getSymbol(), contractHistoryTriggerOrderInfo.getRelationOrderId()).compose(RxJavaHelper.t(getUI())).map(c3.f53656b).subscribe(d.c(getUI(), new b3(this)));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.d().p(this);
        this.f43497b = (ContractHistoryTriggerOrderInfo) getIntent().getSerializableExtra("EXTRA");
        Og();
        this.f43498c = (LinearLayout) findViewById(R.id.ll_detail);
        this.f43499d = (TextView) findViewById(R.id.tv_detail_title);
        ph(this.f43497b);
        oh(this.f43497b);
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(a aVar) {
        finish();
    }

    public final void ph(ContractHistoryTriggerOrderInfo contractHistoryTriggerOrderInfo) {
        if (contractHistoryTriggerOrderInfo == null) {
            i6.d.d("ContractTradeDetailActivity-->updateData-->null!!!!!!!!!!!!!!!!!!!!!!");
        } else {
            fg(contractHistoryTriggerOrderInfo);
        }
    }
}
