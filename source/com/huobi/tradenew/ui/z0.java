package com.huobi.tradenew.ui;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.EtpAvailableBean;
import com.hbg.lib.network.hbg.core.bean.RemainingAmountBean;
import com.huobi.homemarket.helper.AppBarStateChangeListener;
import com.huobi.index.bean.IndexFeature;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.prime.bean.AliToken;
import rt.b0;
import rt.i;
import v9.a;

public interface z0 extends j, i.d, b0.c {
    void A1(boolean z11);

    void B(int i11);

    void B2(int i11);

    void C8(boolean z11);

    void D1(int i11);

    void D2();

    void E2();

    void E3(boolean z11);

    void F2();

    void H2(RemainingAmountBean remainingAmountBean);

    void I3(boolean z11);

    void J2();

    void K2(String str, String str2, int i11);

    void L1(IndexFeature indexFeature);

    void L2();

    void N1();

    void Nd(AppBarStateChangeListener.State state);

    void O1(String str, TradeType tradeType);

    void O2(int i11, int i12);

    void R1(boolean z11, boolean z12);

    int S1();

    void U1(int i11, boolean z11);

    void U2();

    void W1(int i11);

    void X1(boolean z11);

    void b(a aVar);

    void b3();

    int c2();

    void ca(int i11);

    void d(boolean z11);

    void d2(int i11);

    void d3(int i11);

    void db(boolean z11);

    void f3(boolean z11);

    void finishRefresh();

    int getUiPlanTradeBuyMode();

    int getUiPlanTradeSellMode();

    void j3(OrderPlaceBean orderPlaceBean, AliToken aliToken);

    void k3();

    void l1();

    void l2(String str);

    void me(int i11);

    void n1(boolean z11);

    void o3(int i11, int i12);

    void o6(String str, boolean z11);

    void og(EtpAvailableBean etpAvailableBean);

    void qc(String str);

    void t5();

    void v(int i11, int i12, boolean z11, String str);

    void w3();

    void x2(boolean z11, boolean z12, String str);

    void y0(boolean z11);

    void y2();
}
