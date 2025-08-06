package com.huobi.index.presenter;

import android.util.Log;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.index.presenter.IndexPresenter;
import com.huobi.index.presenter.g;
import i6.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Observable;
import rx.Subscription;
import yl.m;

public class FutureRankPresenter {

    /* renamed from: a  reason: collision with root package name */
    public final List<g> f73330a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public IndexPresenter.s0 f73331b;

    /* renamed from: c  reason: collision with root package name */
    public IndexPresenter f73332c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f73333d;

    /* renamed from: e  reason: collision with root package name */
    public Subscription f73334e;

    /* renamed from: f  reason: collision with root package name */
    public List<g.b> f73335f = new ArrayList(11);

    /* renamed from: g  reason: collision with root package name */
    public List<g.b> f73336g = new ArrayList(11);

    public class a extends BaseSubscriber<ContractHeartBeat> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(ContractHeartBeat contractHeartBeat) {
            synchronized (FutureRankPresenter.this.f73330a) {
                for (g gVar : FutureRankPresenter.this.f73330a) {
                    if (gVar != null) {
                        gVar.onRefresh();
                    }
                }
            }
        }
    }

    public static /* synthetic */ int j(g.b bVar, g.b bVar2) {
        boolean z11 = bVar == null || bVar.e() == null;
        boolean z12 = bVar2 == null || bVar2.e() == null;
        if (z11 && z12) {
            return 0;
        }
        if (z11) {
            return -1;
        }
        if (z12) {
            return 1;
        }
        return bVar2.e().compareTo(bVar.e());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(List list) {
        this.f73332c.Z2(this.f73335f, 1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(List list) {
        this.f73332c.Z2(this.f73336g, 6);
    }

    public static /* synthetic */ ContractHeartBeat m(List list, List list2, ContractHeartBeat contractHeartBeat) {
        return contractHeartBeat;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(ContractHeartBeat contractHeartBeat) {
        if (this.f73333d) {
            synchronized (this.f73330a) {
                for (g next : this.f73330a) {
                    if (next != null) {
                        next.b(true);
                    }
                }
            }
            return;
        }
        r(this.f73331b, this.f73332c);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(ContractHeartBeat contractHeartBeat) {
        synchronized (this.f73330a) {
            if (!this.f73333d) {
                this.f73330a.clear();
                this.f73330a.add(new e(new h(this)));
                this.f73330a.add(new l0(new h(this)));
                this.f73330a.add(new f0(new h(this)));
                this.f73333d = true;
            }
        }
    }

    public final void i() {
        if (this.f73333d) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.f73330a) {
                for (g next : this.f73330a) {
                    if (next != null) {
                        List<? extends g.b> a11 = next.a();
                        if (a11 != null) {
                            arrayList.addAll(a11);
                        }
                    }
                }
            }
            d.j("FutureRank", "srcList.size=" + arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                g.b bVar = (g.b) arrayList.get(i11);
                if (bVar != null && m.a(bVar.b())) {
                    arrayList2.add(bVar);
                }
            }
            arrayList.removeAll(arrayList2);
            Collections.sort(arrayList, i.f73448b);
            try {
                this.f73335f = arrayList.subList(0, Math.min(arrayList.size(), 10));
                List<g.b> subList = arrayList.subList(Math.max(arrayList.size() - 10, 0), arrayList.size());
                this.f73336g = subList;
                Collections.reverse(subList);
            } catch (Exception e11) {
                Log.e("tab", e11.getMessage());
            }
            d.j("FutureRank", "rankItems.size=" + this.f73335f.size() + " dropRankItems.size=" + this.f73336g.size());
            List<g.b> list = this.f73335f;
            if (list != null && !list.isEmpty()) {
                Observable.just(this.f73335f).compose(RxJavaHelper.t(this.f73331b)).subscribe(EasySubscriber.create(new l(this)));
            }
            List<g.b> list2 = this.f73336g;
            if (list2 != null && !list2.isEmpty()) {
                Observable.just(this.f73336g).compose(RxJavaHelper.t(this.f73331b)).subscribe(EasySubscriber.create(new m(this)));
            }
        }
    }

    public void p() {
        if (!this.f73333d) {
            r(this.f73331b, this.f73332c);
        } else {
            Observable.zip(ContractCurrencyUtils.g(false), SwapCurrencyInfoController.k().f(false), bj.d.p(), n.f73463b).compose(RxJavaHelper.s()).subscribe(new a());
        }
    }

    public void q(boolean z11) {
        if (z11) {
            bj.d.p().compose(RxJavaHelper.t((u6.g) null)).subscribe(EasySubscriber.create(new j(this)));
        } else if (this.f73333d) {
            synchronized (this.f73330a) {
                for (g next : this.f73330a) {
                    if (next != null) {
                        next.b(false);
                    }
                }
            }
        }
    }

    public void r(IndexPresenter.s0 s0Var, IndexPresenter indexPresenter) {
        this.f73331b = s0Var;
        this.f73332c = indexPresenter;
        Subscription subscription = this.f73334e;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f73334e = bj.d.p().compose(RxJavaHelper.s()).subscribe(EasySubscriber.create(new k(this)));
    }
}
