package com.hbg.module.kline.presenter;

import android.content.Intent;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.EtpInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRebalanceResult;
import com.hbg.lib.network.hbg.core.bean.EtpRiskInfo;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import d7.a1;
import java.util.ArrayList;
import java.util.List;
import u6.g;

public class MarketInfoEtpChangePresenter extends BaseFragmentPresenter<e> {

    /* renamed from: c  reason: collision with root package name */
    public String f23635c;

    /* renamed from: d  reason: collision with root package name */
    public String f23636d;

    /* renamed from: e  reason: collision with root package name */
    public String f23637e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Integer> f23638f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final List<ud.b> f23639g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public long f23640h = 0;

    public class a extends BaseSubscriber<EtpInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(EtpInfo etpInfo) {
            super.onNext(etpInfo);
            ((e) MarketInfoEtpChangePresenter.this.getUI()).N4(etpInfo);
        }
    }

    public class b extends q6.a<List<EtpRiskInfo>> {
        public b(g gVar, boolean z11) {
            super(gVar, z11);
        }

        /* renamed from: a */
        public void onRequestSuccess(List<EtpRiskInfo> list) {
            ArrayList arrayList = new ArrayList();
            for (EtpRiskInfo aVar : list) {
                arrayList.add(new ud.a(aVar));
            }
            ((e) MarketInfoEtpChangePresenter.this.getUI()).d0(arrayList);
        }
    }

    public class c extends RequestCallback1<List<EtpRebalanceResult>> {
        public c() {
        }

        /* renamed from: a */
        public void onRequestSuccess(List<EtpRebalanceResult> list) {
            if (list.size() < 10) {
                ((e) MarketInfoEtpChangePresenter.this.getUI()).i8();
            }
            if (!list.isEmpty()) {
                long unused = MarketInfoEtpChangePresenter.this.f23640h = (long) list.get(list.size() - 1).getId();
            }
            ArrayList arrayList = new ArrayList();
            for (EtpRebalanceResult next : list) {
                if (!MarketInfoEtpChangePresenter.this.f23638f.contains(Integer.valueOf(next.getId()))) {
                    MarketInfoEtpChangePresenter.this.f23638f.add(Integer.valueOf(next.getId()));
                    arrayList.add(new ud.b(next));
                }
            }
            MarketInfoEtpChangePresenter.this.f23639g.addAll(arrayList);
            ((e) MarketInfoEtpChangePresenter.this.getUI()).M3(MarketInfoEtpChangePresenter.this.f23639g);
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            ((e) MarketInfoEtpChangePresenter.this.getUI()).m0();
            ((e) MarketInfoEtpChangePresenter.this.getUI()).q7();
        }
    }

    public class d extends BaseSubscriber<EtpRebalInfo> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(EtpRebalInfo etpRebalInfo) {
            super.onNext(etpRebalInfo);
            ((e) MarketInfoEtpChangePresenter.this.getUI()).b0(etpRebalInfo);
        }
    }

    public interface e extends g {
        void M3(List<ud.b> list);

        void N4(EtpInfo etpInfo);

        void b0(EtpRebalInfo etpRebalInfo);

        void d0(List<ud.a> list);

        void i8();

        void m0();

        void q7();

        void showLoading();
    }

    public String f0() {
        return this.f23637e;
    }

    public boolean g0() {
        return this.f23639g.isEmpty();
    }

    /* renamed from: h0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, e eVar) {
        super.onUIReady(baseCoreActivity, eVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f23635c = intent.getStringExtra("symbolId");
        }
        this.f23636d = a1.v().n(this.f23635c);
        this.f23637e = a1.v().D(this.f23635c);
        j0();
        m0();
        i0();
    }

    public void i0() {
        x7.d.c(this.f23636d, false).compose(RxJavaHelper.t((g) getUI())).subscribe(new d());
    }

    public void j0() {
        x7.b.b(this.f23636d, true).compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    public void k0() {
        l0(this.f23639g.isEmpty());
    }

    public void l0(boolean z11) {
        if (z11) {
            ((e) getUI()).showLoading();
        }
        v7.b.a().G0(this.f23640h, 1, 10, this.f23636d).d(new c());
    }

    public void m0() {
        v7.b.a().S("etp", 1).d(new b((g) getUI(), false));
    }
}
