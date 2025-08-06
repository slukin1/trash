package com.huobi.tradenew.ui;

import com.hbg.lib.network.hbg.core.bean.CurrencyAsset;
import com.hbg.lib.network.hbg.core.bean.PrimeKycLimit;
import com.hbg.lib.network.pro.core.bean.CallAuction;
import com.hbg.lib.widgets.TopScrollData;
import it.k;
import java.util.List;
import rt.a0;
import ws.h;

public interface a5 extends n3, a0.e {
    void E(int i11, long j11);

    void I(int i11);

    void O(String str, String str2, String str3, String str4, String str5, String str6, int i11);

    void V(List<TopScrollData> list, boolean z11, boolean z12, int i11);

    void W3();

    void f0(CurrencyAsset currencyAsset);

    void k0(String str);

    void ld(h hVar);

    void o(boolean z11);

    void o1();

    void p1(PrimeKycLimit primeKycLimit);

    void q3(boolean z11);

    void r(CallAuction callAuction, String str);

    k r1();

    void u1();

    void w1();

    void x3(String str);

    void z1();
}
