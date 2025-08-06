package com.huobi.tradenew.presenter;

import android.text.TextUtils;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.tradenew.ui.w1;
import d7.a1;

public abstract class TradeHorizontalBasePresenter<V extends w1> extends TradeBasePresenter<V> {
    public void B0(boolean z11, boolean z12) {
        String o02 = o0();
        ((w1) getUI()).n(z12, this.f82879m, o02);
        ((w1) getUI()).F(this.f82879m, false);
        c1(false, o02, true);
    }

    public String N0() {
        String str;
        if (e1()) {
            str = ((w1) getUI()).A4();
        } else {
            str = ((w1) getUI()).A8();
        }
        return TextUtils.isEmpty(str) ? String.valueOf(this.f82875i.z()) : str;
    }

    public void a2() {
        e2(true, ((w1) getUI()).A4());
        e2(false, ((w1) getUI()).A8());
    }

    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        super.afterSymbolIdChanged(symbolChangeEvent);
        ((w1) getUI()).t(a1.v().J(this.f82871e, this.f82880n));
        ((w1) getUI()).b3();
    }

    public boolean d2() {
        return this.f82879m == 3 && ((w1) getUI()).getUiPlanTradeBuyMode() == 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e2(boolean r7, java.lang.String r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x000d
            h6.a r0 = r6.getUI()
            com.huobi.tradenew.ui.w1 r0 = (com.huobi.tradenew.ui.w1) r0
            int r0 = r0.S1()
            goto L_0x0017
        L_0x000d:
            h6.a r0 = r6.getUI()
            com.huobi.tradenew.ui.w1 r0 = (com.huobi.tradenew.ui.w1) r0
            int r0 = r0.c2()
        L_0x0017:
            com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.data.symbol.TradeType r2 = r6.f82880n
            if (r1 != r2) goto L_0x0024
            java.lang.String r0 = r6.f82871e
            java.math.BigDecimal r0 = r6.R0(r7, r0)
            goto L_0x0046
        L_0x0024:
            com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.MARGIN
            if (r1 != r2) goto L_0x0031
            rt.z r1 = r6.f82877k
            java.lang.String r2 = r6.f82871e
            java.math.BigDecimal r0 = r1.z(r2, r7, r0)
            goto L_0x0046
        L_0x0031:
            com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.C2C
            if (r1 != r2) goto L_0x003e
            rt.z r0 = r6.f82877k
            java.lang.String r1 = r6.f82871e
            java.math.BigDecimal r0 = r0.v(r1, r7)
            goto L_0x0046
        L_0x003e:
            rt.z r1 = r6.f82877k
            java.lang.String r3 = r6.f82871e
            java.math.BigDecimal r0 = r1.F(r2, r3, r7, r0)
        L_0x0046:
            boolean r1 = r6.e1()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0054
            int r1 = r6.f82879m
            if (r1 != r3) goto L_0x0054
            r1 = r3
            goto L_0x0055
        L_0x0054:
            r1 = r2
        L_0x0055:
            boolean r4 = r6.e1()
            if (r4 == 0) goto L_0x006a
            d7.a1 r4 = d7.a1.v()
            java.lang.String r5 = r6.o0()
            boolean r4 = r4.Q(r5)
            if (r4 == 0) goto L_0x006a
            r2 = r3
        L_0x006a:
            if (r1 != 0) goto L_0x0078
            if (r2 == 0) goto L_0x006f
            goto L_0x0078
        L_0x006f:
            java.lang.String r1 = r6.o0()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.C(r1)
            goto L_0x0080
        L_0x0078:
            java.lang.String r1 = r6.o0()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.y(r1)
        L_0x0080:
            java.math.BigDecimal r2 = java.math.BigDecimal.ZERO
            int r3 = r6.f82879m
            r4 = 32
            if (r3 == 0) goto L_0x00f0
            r5 = 2
            if (r3 != r5) goto L_0x008c
            goto L_0x00f0
        L_0x008c:
            r5 = 3
            if (r3 != r5) goto L_0x00e7
            java.lang.String r1 = r6.o0()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.C(r1)
            if (r7 == 0) goto L_0x00dc
            boolean r2 = r6.d2()
            if (r2 == 0) goto L_0x00b3
            java.lang.String r8 = r6.o0()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.y(r8)
            java.math.BigDecimal r8 = java.math.BigDecimal.ZERO
            int r8 = r0.compareTo(r8)
            if (r8 != 0) goto L_0x013a
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            goto L_0x013a
        L_0x00b3:
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 == 0) goto L_0x00bd
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            goto L_0x013a
        L_0x00bd:
            java.math.BigDecimal r8 = i6.m.a(r8)
            java.math.BigDecimal r2 = java.math.BigDecimal.ZERO
            int r2 = r8.compareTo(r2)
            if (r2 <= 0) goto L_0x00d8
            java.math.BigDecimal r2 = java.math.BigDecimal.ZERO
            int r2 = r0.compareTo(r2)
            if (r2 <= 0) goto L_0x00d8
            java.math.RoundingMode r2 = java.math.RoundingMode.FLOOR
            java.math.BigDecimal r8 = r0.divide(r8, r4, r2)
            goto L_0x00da
        L_0x00d8:
            java.math.BigDecimal r8 = java.math.BigDecimal.ZERO
        L_0x00da:
            r0 = r8
            goto L_0x013a
        L_0x00dc:
            java.math.BigDecimal r8 = java.math.BigDecimal.ZERO
            int r8 = r0.compareTo(r8)
            if (r8 != 0) goto L_0x013a
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            goto L_0x013a
        L_0x00e7:
            int r8 = r0.compareTo(r2)
            if (r8 != 0) goto L_0x013a
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            goto L_0x013a
        L_0x00f0:
            if (r7 == 0) goto L_0x0132
            d7.a1 r2 = d7.a1.v()
            java.lang.String r3 = r6.o0()
            boolean r2 = r2.Q(r3)
            if (r2 == 0) goto L_0x010b
            java.math.BigDecimal r8 = java.math.BigDecimal.ZERO
            int r8 = r0.compareTo(r8)
            if (r8 != 0) goto L_0x013a
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            goto L_0x013a
        L_0x010b:
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 == 0) goto L_0x0114
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            goto L_0x013a
        L_0x0114:
            java.math.BigDecimal r8 = i6.m.a(r8)
            java.math.BigDecimal r2 = java.math.BigDecimal.ZERO
            int r2 = r8.compareTo(r2)
            if (r2 <= 0) goto L_0x012f
            java.math.BigDecimal r2 = java.math.BigDecimal.ZERO
            int r2 = r0.compareTo(r2)
            if (r2 <= 0) goto L_0x012f
            java.math.RoundingMode r2 = java.math.RoundingMode.FLOOR
            java.math.BigDecimal r8 = r0.divide(r8, r4, r2)
            goto L_0x00da
        L_0x012f:
            java.math.BigDecimal r8 = java.math.BigDecimal.ZERO
            goto L_0x00da
        L_0x0132:
            int r8 = r0.compareTo(r2)
            if (r8 != 0) goto L_0x013a
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
        L_0x013a:
            java.math.BigDecimal r8 = java.math.BigDecimal.ZERO
            int r8 = r0.compareTo(r8)
            if (r8 > 0) goto L_0x0144
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
        L_0x0144:
            h6.a r8 = r6.getUI()
            com.huobi.tradenew.ui.w1 r8 = (com.huobi.tradenew.ui.w1) r8
            r8.oc(r7, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.tradenew.presenter.TradeHorizontalBasePresenter.e2(boolean, java.lang.String):void");
    }
}
