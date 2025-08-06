package com.huobi.trade.ui;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.RemainingAmountBean;
import com.hbg.lib.network.hbg.core.bean.SpotContractEntryBean;
import com.huobi.index.bean.IndexFeature;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.prime.bean.AliToken;
import dt.e3;
import dt.r2;
import v9.a;

public interface h1 extends s, r2.d, e3.c {
    void A1(boolean z11);

    void B(int i11);

    void B2(int i11);

    void D1(int i11);

    void D2();

    void E2();

    void E3(boolean z11);

    void F2();

    void H2(RemainingAmountBean remainingAmountBean);

    void I3(boolean z11);

    void K2(String str, String str2, int i11);

    void K8(String str, String str2);

    void L1(IndexFeature indexFeature);

    void L2();

    void N1();

    void O1(String str, TradeType tradeType);

    void O2(int i11, int i12);

    void R1(boolean z11, boolean z12);

    int S1();

    void U1(int i11, boolean z11);

    void U2();

    boolean U7();

    void W1(int i11);

    String Wf();

    void X1(boolean z11);

    void Ya(String str, boolean z11);

    void b(a aVar);

    void b3();

    int c2();

    void d(boolean z11);

    void d2(int i11);

    void d3(int i11);

    void f3(boolean z11);

    void finishRefresh();

    int getUiPlanTradeBuyMode();

    int getUiPlanTradeSellMode();

    void id();

    void j3(OrderPlaceBean orderPlaceBean, AliToken aliToken);

    void k3();

    void l1();

    void l2(String str);

    void n1(boolean z11);

    void o3(int i11, int i12);

    void t4();

    void u9(String str, boolean z11);

    void v(int i11, int i12, boolean z11, String str);

    void vf();

    void w3();

    void wb(SpotContractEntryBean spotContractEntryBean, String str);

    void x2(boolean z11, boolean z12, String str);

    void y0(boolean z11);

    void y2();

    boolean z6();
}
