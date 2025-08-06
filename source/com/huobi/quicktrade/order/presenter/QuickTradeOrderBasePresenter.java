package com.huobi.quicktrade.order.presenter;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.login.bean.JumpTarget;
import com.huobi.trade.bean.AssetAndOrderUpdateEvent;
import com.huobi.trade.bean.TradeHoldBean;
import com.huobi.trade.helper.c;
import d7.a1;
import dt.a5;
import dt.i2;
import i6.d;
import i6.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.ThreadMode;
import pq.e;
import tg.r;
import u6.g;

public abstract class QuickTradeOrderBasePresenter<V extends e> extends BaseFragmentPresenter<V> implements a5.l {

    /* renamed from: c  reason: collision with root package name */
    public String f80516c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f80517d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f80518e = "";

    /* renamed from: f  reason: collision with root package name */
    public a5 f80519f;

    /* renamed from: g  reason: collision with root package name */
    public TradeType f80520g = TradeType.PRO;

    /* renamed from: h  reason: collision with root package name */
    public boolean f80521h;

    /* renamed from: i  reason: collision with root package name */
    public int f80522i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f80523j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f80524k = 0;

    /* renamed from: l  reason: collision with root package name */
    public boolean f80525l = true;

    /* renamed from: m  reason: collision with root package name */
    public final List<TradeHoldBean> f80526m = new ArrayList();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (((e) QuickTradeOrderBasePresenter.this.getUI()).isCanBeSeen()) {
                QuickTradeOrderBasePresenter quickTradeOrderBasePresenter = QuickTradeOrderBasePresenter.this;
                quickTradeOrderBasePresenter.g0(false, quickTradeOrderBasePresenter.o0(), true);
            }
        }
    }

    public void Z(boolean z11) {
        super.Z(z11);
        v0(z11);
    }

    public void b0() {
        this.f80519f.L1();
        this.f80519f.N1();
        this.f80519f.K1();
    }

    public void c0() {
        ((e) getUI()).d(r.x().F0());
        ((e) getUI()).l1();
        t0();
        this.f80521h = true;
        ((e) getUI()).l1();
        ((e) getUI()).J2();
    }

    public /* bridge */ /* synthetic */ g d() {
        return (g) super.getUI();
    }

    public void d0() {
        this.f80519f.C1(this.f80517d, this.f80523j, this.f80522i);
    }

    public int e() {
        return this.f80522i;
    }

    public TradeType f0() {
        return this.f80520g;
    }

    public int g() {
        return this.f80523j;
    }

    public abstract void g0(boolean z11, String str, boolean z12);

    public final void h0() {
        String string = Q().getArguments().getString("tradingview_symbol", "btcusdt");
        if (!TextUtils.isEmpty(string)) {
            this.f80517d = string;
            SymbolBean J = a1.v().J(this.f80517d, this.f80520g);
            this.f80516c = J.getSymbolName();
            this.f80518e = J.getBaseCurrency();
            return;
        }
        List<SymbolBean> Z = a1.v().Z(this.f80520g);
        if (Z != null && !Z.isEmpty()) {
            SymbolBean symbolBean = Z.get(0);
            this.f80517d = symbolBean.getSymbol();
            this.f80516c = symbolBean.getSymbolName();
            this.f80518e = symbolBean.getBaseCurrency();
            i2.a().h(this.f80520g, this.f80517d);
        }
    }

    public void i0() {
        is.a.j("4247", (Map<String, Object>) null, "1000048");
    }

    /* renamed from: j0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, V v11) {
        super.onUIReady(baseCoreActivity, v11);
        this.f80519f = new a5(this, true);
        ((e) getUI()).b(this.f80519f.o0());
    }

    public void k0(int i11) {
        d.e("PLAN_TRADE", "setCurOrderListTradeType - " + i11);
        c.b().l(Integer.valueOf(i11));
        c.b().h();
        this.f80522i = i11;
    }

    public void l0(int i11) {
        this.f80523j = i11;
    }

    public void m0() {
        i0();
        rn.c.i().d(getActivity(), new JumpTarget((Intent) null, (Intent) null));
    }

    public void n0() {
        this.f80519f.E1(this.f80520g, this.f80517d, this.f80523j, this.f80522i);
    }

    public String o0() {
        return this.f80517d;
    }

    public void onErrorCodeEvent(mo.a aVar) {
        if (((e) getUI()).isCanBeSeen()) {
            ((e) getUI()).d(false);
            this.f80519f.C1(this.f80517d, this.f80523j, this.f80522i);
            m0();
        }
    }

    public void onPause() {
        super.onPause();
        this.f80519f.L1();
        this.f80519f.N1();
        this.f80519f.K1();
    }

    public void p0() {
        this.f80519f.K1();
    }

    public void q0() {
        this.f80519f.L1();
    }

    public void r0() {
        this.f80519f.N1();
    }

    public abstract void s0();

    public void t0() {
        if (r.x().F0()) {
            this.f80519f.F1(true, this.f80520g, this.f80517d, this.f80523j, this.f80522i);
            if (this.f80523j == 2) {
                n0();
                return;
            }
            return;
        }
        this.f80519f.C1(this.f80517d, this.f80523j, this.f80524k);
    }

    public abstract void u0();

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void updateAssetAndOrder(AssetAndOrderUpdateEvent assetAndOrderUpdateEvent) {
        if (((e) getUI()).isCanBeSeen()) {
            this.f80519f.H1(true, this.f80520g, this.f80517d, this.f80523j, this.f80522i);
            int i11 = this.f80523j;
            if (i11 == 2) {
                this.f80519f.E1(this.f80520g, this.f80517d, i11, this.f80524k);
            }
            i.b().g(new a(), 500);
        }
    }

    public void v0(boolean z11) {
        if (Q().getActivity() != null) {
            if (z11) {
                h0();
                c0();
                return;
            }
            b0();
        }
    }
}
