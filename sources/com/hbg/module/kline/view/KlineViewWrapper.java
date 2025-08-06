package com.hbg.module.kline.view;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import be.i;
import c6.b;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.shape.BSTShape;
import com.hbg.component.kline.view.KlineScrollView;
import com.hbg.component.kline.view.RenderView;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.o;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineFixInfo;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.module.kline.KlineReqConfig;
import com.hbg.module.kline.bean.KlineWithPeriodAndSymbolInfo;
import fe.h;
import fe.k;
import i6.m;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import s5.d;
import xd.c;
import xd.e;
import xd.f;
import xd.g;
import xd.j;
import xd.l;

public class KlineViewWrapper extends FrameLayout implements d, b<RectF>, j.f {

    /* renamed from: b  reason: collision with root package name */
    public String f24381b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24382c;

    /* renamed from: d  reason: collision with root package name */
    public View f24383d;

    /* renamed from: e  reason: collision with root package name */
    public CandleStickRender f24384e;

    /* renamed from: f  reason: collision with root package name */
    public RenderView f24385f;

    /* renamed from: g  reason: collision with root package name */
    public LoadingView f24386g;

    /* renamed from: h  reason: collision with root package name */
    public l f24387h;

    /* renamed from: i  reason: collision with root package name */
    public KlineScrollView f24388i;

    /* renamed from: j  reason: collision with root package name */
    public String f24389j;

    /* renamed from: k  reason: collision with root package name */
    public String f24390k;

    /* renamed from: l  reason: collision with root package name */
    public Runnable f24391l;

    public class a extends BaseSubscriber<List<KlineWithPeriodAndSymbolInfo>> {
        public a() {
        }

        public void onNext(List<KlineWithPeriodAndSymbolInfo> list) {
            super.onNext(list);
            if (list != null && !list.isEmpty()) {
                if (System.currentTimeMillis() - list.get(list.size() - 1).getTimeMs() < Period.acceptableLocalDiffServer(KlineViewWrapper.this.f24387h.g())) {
                    KlineViewWrapper.this.e(list, false);
                }
            }
        }
    }

    public KlineViewWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int r(List<i> list, int i11) {
        i iVar;
        int i12 = 0;
        if (!(list == null || list.size() <= i11 || (iVar = list.get(i11)) == null)) {
            i12 = Math.max(0, m.l0(iVar.b(), 0));
        }
        i6.d.b("KlineViewWrapper-->getMaxMA-->" + i11 + "-->" + i12);
        return i12;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(Subscriber subscriber) {
        subscriber.onStart();
        Vector<KlineWithPeriodAndSymbolInfo> d11 = wd.a.b(BaseApplication.b()).d(this.f24387h.k1(), this.f24387h.g().value, getKlineNum());
        if (!UtilCollections.f(d11) && this.f24387h.g() == Period.week) {
            int size = d11.size() - 1;
            while (true) {
                if (size <= 0) {
                    break;
                } else if (d11.get(size).getTimeMs() - d11.get(size - 1).getTimeMs() < Period.WEEK_MILLS) {
                    d11 = null;
                    break;
                } else {
                    size--;
                }
            }
        }
        subscriber.onNext(d11);
        subscriber.onCompleted();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.f24388i.fullScroll(33);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v() {
        this.f24388i.fullScroll(130);
    }

    public void A(boolean z11) {
        CandleStickRender candleStickRender;
        i6.d.i("KlineViewWrapper showLoading:" + z11 + " loading:" + this.f24386g);
        if (!z11 || this.f24387h.g() != Period.expandtl || (candleStickRender = this.f24384e) == null || !candleStickRender.B3()) {
            ViewUtil.m(this.f24386g, z11);
            if (z11) {
                this.f24386g.c();
            } else {
                this.f24386g.d();
            }
        }
    }

    public void B(List<?> list, int i11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.e4(list, i11);
        }
    }

    public void C() {
        l lVar = this.f24387h;
        if (lVar != null) {
            lVar.onPause();
        }
    }

    public void D() {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.u3();
        }
        this.f24387h.onResume();
        postDelayed(this.f24391l, 20);
    }

    public void E() {
        if (this.f24387h != null && this.f24384e != null) {
            postDelayed(this.f24391l, 20);
        }
    }

    public final void F() {
        if (!TradeType.isContractIndex(this.f24381b) && !TradeType.isLinearSwapIndex(this.f24381b) && !KlineReqConfig.c(1, this.f24387h.k1())) {
            Observable.create(new k(this)).observeOn(Schedulers.io()).subscribeOn(Schedulers.computation()).subscribe(new a());
        }
        this.f24387h.f();
    }

    public void G() {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.j4();
            this.f24384e.m();
        }
    }

    public void H(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.t4(i11, i12, i13, i14, i15, i16, i17, i18);
        }
    }

    public void I(List<?> list, int i11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.v4(list, i11);
        }
    }

    public void J(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.w4(i11, i12, i13, i14, i15, i16, i17, i18, i19, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33);
        }
    }

    public void K(Period period, boolean z11) {
        boolean a11 = this.f24387h.a(period);
        this.f24387h.b(true);
        if (!a11) {
            postDelayed(this.f24391l, 20);
            CandleStickRender candleStickRender = this.f24384e;
            if (candleStickRender != null) {
                candleStickRender.f4(z11);
            }
        }
        q5.a.g().p(period.key);
        setKLineType(CandleStickRender.KLineType.parse(period.key));
    }

    public void L(boolean z11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.N4(z11);
        }
    }

    public void M(int i11) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i11;
        setLayoutParams(layoutParams);
    }

    public void a(Map<Long, KlineFixInfo> map) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.S4(map);
        }
    }

    public void b(List<KlineInfo> list) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.B4(list);
        }
    }

    public void c() {
        CandleStickRender candleStickRender;
        KlineInfo t12;
        if (this.f24387h != null && (candleStickRender = this.f24384e) != null && (t12 = candleStickRender.t1()) != null) {
            this.f24387h.e(t12);
            this.f24387h.b(false);
        }
    }

    public void d(KlineInfo klineInfo) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.M(klineInfo);
        }
    }

    public void e(List<? extends KlineInfo> list, boolean z11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.u4(list, z11);
        }
        p(ConfigPreferences.c("user_config", "KLINE_CONFIG_COUNTDOWN_SWITCH", false));
    }

    public void f(List<KlineInfo> list) {
        for (KlineInfo next : list) {
            CandleStickRender candleStickRender = this.f24384e;
            if (candleStickRender != null) {
                candleStickRender.M(next);
            }
        }
    }

    public Period getCurrentPeriod() {
        return this.f24387h.g();
    }

    public l getKlineDataSource() {
        if (TradeType.isIndex(this.f24381b)) {
            return new xd.b(this);
        }
        if (TradeType.isContract(this.f24381b)) {
            return new xd.d(this);
        }
        if (TradeType.isSwap(this.f24381b)) {
            return new xd.k(this);
        }
        if (TradeType.isContractIndex(this.f24381b)) {
            return new c(this);
        }
        if (TradeType.isLinearSwapIndex(this.f24381b)) {
            return new e(this);
        }
        if (TradeType.isOption(this.f24381b)) {
            return new g(this);
        }
        if (TradeType.isLinearSwap(this.f24381b)) {
            return new f(this);
        }
        return new j(this);
    }

    public int getKlineNum() {
        if (getCurrentPeriod() == Period.expandtl) {
            return 49;
        }
        int d11 = o.d(this.f24382c);
        i6.d.b("KlineViewWrapper-->getKlineNum-->cloud num = " + d11);
        List<i> a11 = be.j.c().a();
        int max = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(0, r(a11, 0)), r(a11, 1)), r(a11, 2)), r(a11, 3)), r(a11, 4)), r(a11, 5)), r(a11, 20)), r(a11, 21));
        i6.d.b("KlineViewWrapper-->getKlineNum-->maxMA = " + max);
        int i11 = max + 60;
        i6.d.b("KlineViewWrapper-->getKlineNum-->maxMA = " + i11);
        int min = Math.min(Math.max(Math.max(d11, i11), 100), 300);
        i6.d.b("KlineViewWrapper-->getKlineNum-->result = " + min);
        return min;
    }

    public String getSlaveIndex1() {
        return this.f24390k;
    }

    public float getWaterLogoMarginTop() {
        return (float) this.f24384e.r3();
    }

    public void l(List<BSTShape> list, List<BSTShape> list2, List<BSTShape> list3) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.m4(list, list2, list3);
        }
    }

    public void m(boolean z11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.V(z11);
        }
    }

    public boolean n() {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            return candleStickRender.W();
        }
        return false;
    }

    public void o() {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.X();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        i6.d.i("KlineViewWrapper onFinishInflate:" + this);
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof RenderView) {
                RenderView renderView = (RenderView) childAt;
                com.hbg.component.kline.render.m render = renderView.getRender();
                if (render instanceof CandleStickRender) {
                    CandleStickRender candleStickRender = (CandleStickRender) render;
                    this.f24384e = candleStickRender;
                    candleStickRender.C4(this);
                    this.f24384e.F4(renderView);
                    this.f24384e.n4(this);
                }
                this.f24385f = renderView;
            } else if (childAt instanceof LoadingView) {
                this.f24386g = (LoadingView) childAt;
            }
        }
    }

    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.o(z11);
        }
    }

    public void p(boolean z11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.Z(z11);
        }
    }

    public boolean postDelayed(Runnable runnable, long j11) {
        removeCallbacks(runnable);
        return super.postDelayed(runnable, j11);
    }

    public boolean q() {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            return candleStickRender.d0();
        }
        return false;
    }

    public final void s() {
    }

    public void setColorDown(int i11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.o4(i11);
        }
    }

    public void setColorRaise(int i11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.p4(i11);
        }
    }

    public void setContract(boolean z11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.q4(z11);
        }
    }

    public void setContractIndexSymbol(boolean z11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.r4(z11);
        }
    }

    public void setDrawLineLayerEnable(boolean z11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.s4(z11);
        }
    }

    public void setHighLightVisiableChangeListerner(s5.a aVar) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.L0 = aVar;
        }
    }

    public void setIndexSymbol(boolean z11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.x4(z11);
        }
    }

    public void setIsCoin(boolean z11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.y4(z11);
        }
    }

    public void setKLineType(CandleStickRender.KLineType kLineType) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.z4(kLineType);
        }
    }

    public void setKlineDragLeftOrRightListerner(s5.b bVar) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.M0 = bVar;
        }
    }

    public void setLandScape(boolean z11) {
        this.f24382c = z11;
    }

    public void setMasterIndex(int i11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.A4(i11);
        }
    }

    public void setOnPointDrawListener(q5.b bVar) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.D4(bVar);
        }
    }

    public void setPeriod(Period period) {
        K(period, false);
    }

    public void setPricePrecision(int i11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.E4(i11);
        }
    }

    public void setScrollView(KlineScrollView klineScrollView) {
        this.f24388i = klineScrollView;
    }

    public void setSlaveIndex1(String str) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.G4(str);
        }
        this.f24390k = str;
    }

    public void setSlaveIndex2(LinkedHashSet<String> linkedHashSet) {
        String str;
        KlineScrollView klineScrollView;
        if (this.f24382c && (klineScrollView = this.f24388i) != null) {
            klineScrollView.setScrollDisable(false);
            if (!TextUtils.isEmpty(this.f24389j)) {
                if (linkedHashSet == null || linkedHashSet.isEmpty()) {
                    post(new fe.i(this));
                } else if (!TextUtils.equals(this.f24389j, linkedHashSet.toString())) {
                    postDelayed(new fe.j(this), 16);
                }
            }
        }
        if (linkedHashSet == null) {
            str = null;
        } else {
            str = linkedHashSet.toString();
        }
        this.f24389j = str;
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.H4(linkedHashSet);
        }
    }

    public void setSymbolId(String str) {
        String k12 = this.f24387h.k1();
        this.f24387h.d(str);
        this.f24387h.b(true);
        if (this.f24384e != null && !TextUtils.equals(str, k12)) {
            this.f24384e.j4();
            this.f24384e.I4(str);
            this.f24384e.m();
        }
        if (!TextUtils.isEmpty(str) && !str.equals(k12)) {
            postDelayed(this.f24391l, 20);
        }
    }

    public void setTradeType(String str) {
        String str2 = this.f24381b;
        this.f24381b = str;
        if (str2 == null || !str2.equals(str)) {
            this.f24387h = getKlineDataSource();
        }
        boolean z11 = true;
        setIsCoin((TradeType.isContract(str) && a7.e.E(TradeType.CONTRACT)) || (TradeType.isSwap(str) && a7.e.E(TradeType.SWAP)) || (TradeType.isLinearSwap(str) && a7.e.F(TradeType.valueOf(str))) || (TradeType.isOption(str) && a7.e.E(TradeType.valueOf(str))));
        setContract(TradeType.isContract(str) || TradeType.isSwap(str) || TradeType.isOption(str) || TradeType.isLinearSwap(str));
        setIndexSymbol(TradeType.isIndex(str));
        if (!TradeType.isContractIndex(str) && !TradeType.isLinearSwapIndex(str)) {
            z11 = false;
        }
        setContractIndexSymbol(z11);
        setColorDown(getContext().getResources().getColor(w.d()));
        setColorRaise(getContext().getResources().getColor(w.h()));
    }

    public void setVolPrecision(int i11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.J4(i11);
        }
    }

    public boolean w(boolean z11) {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            return candleStickRender.b4(z11);
        }
        return false;
    }

    /* renamed from: x */
    public void onCallback(RectF rectF) {
        View view = this.f24383d;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = (int) rectF.bottom;
            this.f24383d.setLayoutParams(layoutParams);
            this.f24383d.setVisibility(0);
        }
    }

    public void y() {
        CandleStickRender candleStickRender = this.f24384e;
        if (candleStickRender != null) {
            candleStickRender.d4();
        }
    }

    public void z(boolean z11) {
        if (TradeType.isPro(this.f24381b)) {
            l lVar = this.f24387h;
            if (lVar instanceof j) {
                ((j) lVar).v(z11);
            }
        }
    }

    public KlineViewWrapper(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f24391l = new h(this);
        s();
    }
}
