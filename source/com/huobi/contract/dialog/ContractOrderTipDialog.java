package com.huobi.contract.dialog;

import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractHistoryOrderInfo;
import com.huobi.contract.entity.ContractOrderDetailResult;
import com.huobi.contract.helper.ContractOrderHelper;
import i6.r;
import u6.g;

public class ContractOrderTipDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public ContractHistoryOrderInfo f43052b;

    /* renamed from: c  reason: collision with root package name */
    public LoadingView f43053c;

    public class a extends EasySubscriber<ContractOrderDetailResult> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(ContractOrderDetailResult contractOrderDetailResult) {
            super.onNext(contractOrderDetailResult);
            ContractOrderTipDialog.this.f43053c.d();
            ContractOrderTipDialog.this.f43053c.setVisibility(8);
            ContractOrderTipDialog.this.Ah(contractOrderDetailResult);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ContractOrderTipDialog.this.dismiss();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ContractOrderTipDialog.this.dismiss();
        }
    }

    public static /* synthetic */ void xh(HBDialogFragment hBDialogFragment) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        dismiss();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ah(com.huobi.contract.entity.ContractOrderDetailResult r24) {
        /*
            r23 = this;
            r0 = r23
            boolean r1 = r23.isVisible()
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = r24.getLiquidationType()
            java.lang.String r2 = "0"
            boolean r1 = r2.equalsIgnoreCase(r1)
            java.lang.String r2 = "3"
            if (r1 != 0) goto L_0x0025
            java.lang.String r1 = r24.getLiquidationType()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0022
            goto L_0x0025
        L_0x0022:
            r1 = r24
            goto L_0x002a
        L_0x0025:
            r1 = r24
            r1.setLiquidationType(r2)
        L_0x002a:
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyy-MM-dd HH:mm:ss"
            r3.<init>(r4)
            long r4 = r24.getCreatedAt()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r3 = r3.format(r4)
            java.lang.String r4 = r24.getAdjustValue()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r5 = "--"
            if (r4 == 0) goto L_0x004b
            r4 = r5
            goto L_0x0072
        L_0x004b:
            java.lang.String r4 = r24.getAdjustValue()
            java.math.BigDecimal r4 = i6.m.a(r4)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.math.BigDecimal r7 = i6.m.f68179a
            java.math.BigDecimal r4 = r4.multiply(r7)
            int r7 = ej.f.a()
            java.lang.String r4 = i6.m.q(r4, r7)
            r6.append(r4)
            java.lang.String r4 = "%"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
        L_0x0072:
            int r6 = com.hbg.lib.contract.R$string.setting_quickly_withdraw_dialog_title
            java.lang.String r6 = r0.getString(r6)
            java.lang.String r7 = r24.getLiquidationType()
            r7.hashCode()
            int r9 = r7.hashCode()
            java.lang.String r10 = "4"
            java.lang.String r11 = "2"
            java.lang.String r12 = "1"
            r14 = 2
            r15 = 1
            r8 = 0
            switch(r9) {
                case 49: goto L_0x00b0;
                case 50: goto L_0x00a6;
                case 51: goto L_0x009c;
                case 52: goto L_0x0092;
                default: goto L_0x008f;
            }
        L_0x008f:
            r16 = -1
            goto L_0x00b9
        L_0x0092:
            boolean r7 = r7.equals(r10)
            if (r7 != 0) goto L_0x0099
            goto L_0x008f
        L_0x0099:
            r16 = 3
            goto L_0x00b9
        L_0x009c:
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x00a3
            goto L_0x008f
        L_0x00a3:
            r16 = r14
            goto L_0x00b9
        L_0x00a6:
            boolean r7 = r7.equals(r11)
            if (r7 != 0) goto L_0x00ad
            goto L_0x008f
        L_0x00ad:
            r16 = r15
            goto L_0x00b9
        L_0x00b0:
            boolean r7 = r7.equals(r12)
            if (r7 != 0) goto L_0x00b7
            goto L_0x008f
        L_0x00b7:
            r16 = r8
        L_0x00b9:
            switch(r16) {
                case 0: goto L_0x00d1;
                case 1: goto L_0x00bd;
                case 2: goto L_0x00d1;
                case 3: goto L_0x00bd;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            goto L_0x00e4
        L_0x00bd:
            boolean r6 = r24.isBuy()
            if (r6 == 0) goto L_0x00ca
            int r6 = com.hbg.lib.contract.R$string.contract_trade_force_cutdown_low
            java.lang.String r6 = r0.getString(r6)
            goto L_0x00e4
        L_0x00ca:
            int r6 = com.hbg.lib.contract.R$string.contract_trade_force_cutdown_more
            java.lang.String r6 = r0.getString(r6)
            goto L_0x00e4
        L_0x00d1:
            boolean r6 = r24.isBuy()
            if (r6 == 0) goto L_0x00de
            int r6 = com.hbg.lib.contract.R$string.contract_trade_force_low
            java.lang.String r6 = r0.getString(r6)
            goto L_0x00e4
        L_0x00de:
            int r6 = com.hbg.lib.contract.R$string.contract_trade_force_more
            java.lang.String r6 = r0.getString(r6)
        L_0x00e4:
            java.lang.String r7 = r24.getLiquidationType()
            boolean r7 = r12.equalsIgnoreCase(r7)
            r9 = 12
            java.lang.String r12 = ""
            r16 = 10
            r17 = 9
            r18 = 8
            r19 = 7
            r20 = 6
            r21 = 5
            r13 = 11
            r22 = 4
            if (r7 == 0) goto L_0x01af
            android.content.Context r2 = r23.getContext()
            int r7 = com.hbg.lib.contract.R$string.contarct_liquidation_order_new_hint_double_ga
            java.lang.String r2 = r2.getString(r7)
            java.lang.Object[] r7 = new java.lang.Object[r9]
            r7[r8] = r3
            java.lang.String r3 = r24.getContractCode()
            r7[r15] = r3
            java.lang.String r3 = r24.getInstrumentPrice()
            java.lang.String r9 = r24.getSymbol()
            int r9 = ej.f.r(r9)
            java.lang.String r3 = i6.m.m(r3, r9)
            r7[r14] = r3
            java.lang.String r3 = r24.getSymbol()
            r9 = 3
            r7[r9] = r3
            java.lang.String r3 = r24.getFinalInterest()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x013a
            goto L_0x014e
        L_0x013a:
            java.lang.String r3 = r24.getFinalInterest()
            java.math.BigDecimal r3 = i6.m.a(r3)
            java.lang.String r5 = r24.getSymbol()
            int r5 = ej.f.o(r5)
            java.lang.String r5 = i6.m.q(r3, r5)
        L_0x014e:
            r7[r22] = r5
            java.lang.String r3 = r24.getSymbol()
            r7[r21] = r3
            r7[r20] = r4
            java.lang.String r3 = r24.getContractCode()
            r7[r19] = r3
            java.lang.Integer r3 = r24.getLeverRate()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r7[r18] = r3
            boolean r3 = r24.isBuy()
            if (r3 == 0) goto L_0x0179
            android.content.Context r3 = r23.getContext()
            int r4 = com.hbg.lib.contract.R$string.contarct_position_empty
            java.lang.String r3 = r3.getString(r4)
            goto L_0x0183
        L_0x0179:
            android.content.Context r3 = r23.getContext()
            int r4 = com.hbg.lib.contract.R$string.contarct_position_more
            java.lang.String r3 = r3.getString(r4)
        L_0x0183:
            r7[r17] = r3
            java.lang.String r3 = r24.getPrice()
            java.lang.String r4 = r24.getSymbol()
            int r4 = ej.f.r(r4)
            java.lang.String r3 = i6.m.m(r3, r4)
            r7[r16] = r3
            java.lang.String r3 = r24.getVolume()
            java.lang.String r1 = r24.getSymbol()
            int r1 = ej.f.t(r1)
            java.lang.String r1 = i6.m.m(r3, r1)
            r7[r13] = r1
            java.lang.String r1 = java.lang.String.format(r2, r7)
            goto L_0x0401
        L_0x01af:
            java.lang.String r7 = r24.getLiquidationType()
            boolean r7 = r11.equalsIgnoreCase(r7)
            r11 = 13
            if (r7 == 0) goto L_0x027a
            android.content.Context r2 = r23.getContext()
            int r7 = com.hbg.lib.contract.R$string.contarct_liquidation_order_new_hint_part_take
            java.lang.String r2 = r2.getString(r7)
            java.lang.Object[] r7 = new java.lang.Object[r11]
            r7[r8] = r3
            java.lang.String r3 = r24.getContractCode()
            r7[r15] = r3
            java.lang.String r3 = r24.getInstrumentPrice()
            java.lang.String r10 = r24.getSymbol()
            int r10 = ej.f.r(r10)
            java.lang.String r3 = i6.m.m(r3, r10)
            r7[r14] = r3
            java.lang.String r3 = r24.getSymbol()
            r10 = 3
            r7[r10] = r3
            java.lang.String r3 = r24.getFinalInterest()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x01f3
            goto L_0x0207
        L_0x01f3:
            java.lang.String r3 = r24.getFinalInterest()
            java.math.BigDecimal r3 = i6.m.a(r3)
            java.lang.String r5 = r24.getSymbol()
            int r5 = ej.f.o(r5)
            java.lang.String r5 = i6.m.q(r3, r5)
        L_0x0207:
            r7[r22] = r5
            java.lang.String r3 = r24.getSymbol()
            r7[r21] = r3
            r7[r20] = r4
            java.lang.String r3 = r24.getContractCode()
            r7[r19] = r3
            java.lang.Integer r3 = r24.getLeverRate()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r7[r18] = r3
            boolean r3 = r24.isBuy()
            if (r3 == 0) goto L_0x0232
            android.content.Context r3 = r23.getContext()
            int r4 = com.hbg.lib.contract.R$string.contarct_position_empty
            java.lang.String r3 = r3.getString(r4)
            goto L_0x023c
        L_0x0232:
            android.content.Context r3 = r23.getContext()
            int r4 = com.hbg.lib.contract.R$string.contarct_position_more
            java.lang.String r3 = r3.getString(r4)
        L_0x023c:
            r7[r17] = r3
            java.lang.String r3 = r24.getPrice()
            java.lang.String r4 = r24.getSymbol()
            int r4 = ej.f.r(r4)
            java.lang.String r3 = i6.m.m(r3, r4)
            r7[r16] = r3
            java.lang.String r3 = r24.getTradedVolume()
            java.lang.String r4 = r24.getSymbol()
            int r4 = ej.f.t(r4)
            java.lang.String r3 = i6.m.m(r3, r4)
            r7[r13] = r3
            java.lang.String r3 = r24.getPostPosition()
            java.lang.String r1 = r24.getSymbol()
            int r1 = ej.f.t(r1)
            java.lang.String r1 = i6.m.m(r3, r1)
            r7[r9] = r1
            java.lang.String r1 = java.lang.String.format(r2, r7)
            goto L_0x0401
        L_0x027a:
            java.lang.String r7 = r24.getLiquidationType()
            boolean r2 = r2.equalsIgnoreCase(r7)
            if (r2 == 0) goto L_0x031f
            android.content.Context r2 = r23.getContext()
            int r7 = com.hbg.lib.contract.R$string.contarct_liquidation_order_new_hint
            java.lang.String r2 = r2.getString(r7)
            java.lang.Object[] r7 = new java.lang.Object[r13]
            r7[r8] = r3
            java.lang.String r3 = r24.getContractCode()
            r7[r15] = r3
            java.lang.String r3 = r24.getInstrumentPrice()
            java.lang.String r9 = r24.getSymbol()
            int r9 = ej.f.r(r9)
            java.lang.String r3 = i6.m.m(r3, r9)
            r7[r14] = r3
            java.lang.String r3 = r24.getSymbol()
            r9 = 3
            r7[r9] = r3
            java.lang.String r3 = r24.getFinalInterest()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x02bc
            goto L_0x02d0
        L_0x02bc:
            java.lang.String r3 = r24.getFinalInterest()
            java.math.BigDecimal r3 = i6.m.a(r3)
            java.lang.String r5 = r24.getSymbol()
            int r5 = ej.f.o(r5)
            java.lang.String r5 = i6.m.t(r3, r5, r8, r12)
        L_0x02d0:
            r7[r22] = r5
            java.lang.String r3 = r24.getSymbol()
            r7[r21] = r3
            r7[r20] = r4
            java.lang.String r3 = r24.getContractCode()
            r7[r19] = r3
            java.lang.Integer r3 = r24.getLeverRate()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r7[r18] = r3
            boolean r3 = r24.isBuy()
            if (r3 == 0) goto L_0x02fb
            android.content.Context r3 = r23.getContext()
            int r4 = com.hbg.lib.contract.R$string.contarct_position_empty
            java.lang.String r3 = r3.getString(r4)
            goto L_0x0305
        L_0x02fb:
            android.content.Context r3 = r23.getContext()
            int r4 = com.hbg.lib.contract.R$string.contarct_position_more
            java.lang.String r3 = r3.getString(r4)
        L_0x0305:
            r7[r17] = r3
            java.lang.String r3 = r24.getPrice()
            java.lang.String r1 = r24.getSymbol()
            int r1 = ej.f.r(r1)
            java.lang.String r1 = i6.m.m(r3, r1)
            r7[r16] = r1
            java.lang.String r1 = java.lang.String.format(r2, r7)
            goto L_0x0401
        L_0x031f:
            java.lang.String r2 = r24.getLiquidationType()
            boolean r2 = r10.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0400
            java.util.List r2 = r24.getTrades()
            if (r2 == 0) goto L_0x033f
            int r7 = r2.size()
            if (r7 <= 0) goto L_0x033f
            java.lang.Object r2 = r2.get(r8)
            com.huobi.contract.entity.ContractOrderDetailInfo r2 = (com.huobi.contract.entity.ContractOrderDetailInfo) r2
            r2.getCreatedAt()
            goto L_0x0342
        L_0x033f:
            r24.getCreatedAt()
        L_0x0342:
            android.content.Context r2 = r23.getContext()
            int r7 = com.hbg.lib.contract.R$string.contarct_liquidation_order_new_hint_part_order
            java.lang.String r2 = r2.getString(r7)
            java.lang.Object[] r7 = new java.lang.Object[r11]
            r7[r8] = r3
            java.lang.String r3 = r24.getContractCode()
            r7[r15] = r3
            java.lang.String r3 = r24.getInstrumentPrice()
            java.lang.String r10 = r24.getSymbol()
            int r10 = ej.f.r(r10)
            java.lang.String r3 = i6.m.m(r3, r10)
            r7[r14] = r3
            java.lang.String r3 = r24.getSymbol()
            r10 = 3
            r7[r10] = r3
            java.lang.String r3 = r24.getFinalInterest()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x037a
            goto L_0x038e
        L_0x037a:
            java.lang.String r3 = r24.getFinalInterest()
            java.math.BigDecimal r3 = i6.m.a(r3)
            java.lang.String r5 = r24.getSymbol()
            int r5 = ej.f.o(r5)
            java.lang.String r5 = i6.m.q(r3, r5)
        L_0x038e:
            r7[r22] = r5
            java.lang.String r3 = r24.getSymbol()
            r7[r21] = r3
            r7[r20] = r4
            java.lang.String r3 = r24.getContractCode()
            r7[r19] = r3
            java.lang.Integer r3 = r24.getLeverRate()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r7[r18] = r3
            boolean r3 = r24.isBuy()
            if (r3 == 0) goto L_0x03b9
            android.content.Context r3 = r23.getContext()
            int r4 = com.hbg.lib.contract.R$string.contarct_position_empty
            java.lang.String r3 = r3.getString(r4)
            goto L_0x03c3
        L_0x03b9:
            android.content.Context r3 = r23.getContext()
            int r4 = com.hbg.lib.contract.R$string.contarct_position_more
            java.lang.String r3 = r3.getString(r4)
        L_0x03c3:
            r7[r17] = r3
            java.lang.String r3 = r24.getPrice()
            java.lang.String r4 = r24.getSymbol()
            int r4 = ej.f.r(r4)
            java.lang.String r3 = i6.m.m(r3, r4)
            r7[r16] = r3
            java.lang.String r3 = r24.getVolume()
            java.lang.String r4 = r24.getSymbol()
            int r4 = ej.f.t(r4)
            java.lang.String r3 = i6.m.m(r3, r4)
            r7[r13] = r3
            java.lang.String r3 = r24.getTradedVolume()
            java.lang.String r1 = r24.getSymbol()
            int r1 = ej.f.t(r1)
            java.lang.String r1 = i6.m.m(r3, r1)
            r7[r9] = r1
            java.lang.String r1 = java.lang.String.format(r2, r7)
            goto L_0x0401
        L_0x0400:
            r1 = r12
        L_0x0401:
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r2 = new com.hbg.lib.widgets.dialog.DialogUtils$b$d
            androidx.fragment.app.FragmentActivity r3 = r23.getActivity()
            r2.<init>(r3)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r2 = r2.c1(r6)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r1 = r2.C0(r1)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r1 = r1.T0(r15)
            int r2 = com.hbg.lib.contract.R$string.n_contract_order_force_liquidation
            java.lang.String r2 = r0.getString(r2)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r1 = r1.R0(r2)
            android.content.Context r2 = r23.getContext()
            int r3 = com.hbg.lib.contract.R$color.baseColorMajorTheme100
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r1 = r1.S0(r2)
            zi.b r2 = zi.b.f63075a
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r1 = r1.U0(r2)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r1 = r1.q0(r8)
            android.content.Context r2 = r23.getContext()
            int r3 = com.hbg.lib.contract.R$string.contract_trade_i_know
            java.lang.String r2 = r2.getString(r3)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r1 = r1.P0(r2)
            zi.a r2 = new zi.a
            r2.<init>(r0)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r1 = r1.Q0(r2)
            com.hbg.lib.widgets.dialog.HBDialogFragment r1 = r1.j0()
            androidx.fragment.app.FragmentManager r2 = r23.getChildFragmentManager()
            r1.show(r2, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.dialog.ContractOrderTipDialog.Ah(com.huobi.contract.entity.ContractOrderDetailResult):void");
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.contract_order_tip_dialog;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        LoadingView loadingView = (LoadingView) rVar.b(R$id.loading_img);
        this.f43053c = loadingView;
        loadingView.setVisibility(0);
        this.f43053c.c();
        wh();
    }

    public boolean isTransparent() {
        return true;
    }

    public boolean useWindowBg() {
        return false;
    }

    public final void wh() {
        ContractOrderHelper.c(this.f43052b.getSymbol(), this.f43052b.getOrderType(), this.f43052b.getOrderId().longValue(), this.f43052b.getCreateDate().longValue()).compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }

    public void zh(ContractHistoryOrderInfo contractHistoryOrderInfo) {
        this.f43052b = contractHistoryOrderInfo;
    }
}
