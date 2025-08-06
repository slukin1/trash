package com.hbg.lib.core.page;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.Assert;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import ky.j;
import r6.g;
import r6.h;
import r6.i;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import s9.a;
import u6.f;

public class SmartRefreshPageSplitter<T extends s9.a> {

    /* renamed from: a  reason: collision with root package name */
    public d f68473a;

    /* renamed from: b  reason: collision with root package name */
    public ny.d f68474b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f68475c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f68476d;

    /* renamed from: e  reason: collision with root package name */
    public int f68477e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68478f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68479g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68480h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68481i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f68482j;

    /* renamed from: k  reason: collision with root package name */
    public RecyclerView f68483k;

    /* renamed from: l  reason: collision with root package name */
    public List<T> f68484l;

    /* renamed from: m  reason: collision with root package name */
    public List<T> f68485m;

    /* renamed from: n  reason: collision with root package name */
    public T f68486n;

    /* renamed from: o  reason: collision with root package name */
    public v9.a<T> f68487o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f68488p = false;

    /* renamed from: q  reason: collision with root package name */
    public SmartRefreshHeader f68489q;

    /* renamed from: r  reason: collision with root package name */
    public e f68490r;

    /* renamed from: s  reason: collision with root package name */
    public SmartRefreshFooter f68491s;

    /* renamed from: t  reason: collision with root package name */
    public b<T> f68492t;

    /* renamed from: u  reason: collision with root package name */
    public Action1<List<T>> f68493u = new g(this);

    public static class Builder<T extends s9.a> {

        /* renamed from: a  reason: collision with root package name */
        public d f68494a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f68495b;

        /* renamed from: c  reason: collision with root package name */
        public c<T> f68496c;

        /* renamed from: d  reason: collision with root package name */
        public int f68497d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f68498e;

        /* renamed from: f  reason: collision with root package name */
        public e f68499f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68500g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f68501h = true;

        /* renamed from: i  reason: collision with root package name */
        public ny.d f68502i;

        /* renamed from: j  reason: collision with root package name */
        public b f68503j;

        public SmartRefreshPageSplitter<T> k() {
            boolean z11 = true;
            Assert.a(this.f68494a != null);
            Assert.a(this.f68496c != null);
            if (this.f68497d <= 0) {
                z11 = false;
            }
            Assert.a(z11);
            return new SmartRefreshPageSplitter<>(this);
        }

        public Builder l(boolean z11) {
            this.f68500g = z11;
            return this;
        }

        public Builder m(int i11) {
            this.f68497d = i11;
            return this;
        }

        public Builder n(boolean z11) {
            this.f68498e = z11;
            return this;
        }

        public Builder o(c cVar) {
            this.f68496c = cVar;
            return this;
        }

        public Builder p(d dVar) {
            this.f68494a = dVar;
            return this;
        }
    }

    public class a implements ny.d {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Observable d(Observable observable) {
            if (SmartRefreshPageSplitter.this.f68476d.a() == null) {
                return observable;
            }
            return observable.distinct(SmartRefreshPageSplitter.this.f68476d.a());
        }

        public void P8(j jVar) {
            s9.a aVar;
            if (SmartRefreshPageSplitter.this.f68474b != null) {
                SmartRefreshPageSplitter.this.f68474b.P8(jVar);
            }
            if (SmartRefreshPageSplitter.this.f68488p) {
                jVar.e();
                return;
            }
            c m11 = SmartRefreshPageSplitter.this.f68476d;
            if (SmartRefreshPageSplitter.this.f68486n != null) {
                aVar = SmartRefreshPageSplitter.this.f68486n;
            } else {
                aVar = SmartRefreshPageSplitter.this.f68484l.size() > 0 ? (s9.a) SmartRefreshPageSplitter.this.f68484l.get(SmartRefreshPageSplitter.this.f68484l.size() - 1) : null;
            }
            Observable subscribeOn = m11.b(aVar).doOnNext(SmartRefreshPageSplitter.this.f68493u).subscribeOn(Schedulers.io());
            subscribeOn.observeOn(AndroidSchedulers.mainThread());
            Observable.merge(Observable.just(SmartRefreshPageSplitter.this.f68484l), subscribeOn).flatMap(i.f70514b).compose(new h(this)).toList().observeOn(AndroidSchedulers.mainThread()).subscribe(SmartRefreshPageSplitter.this.p(false));
        }

        public void bf(j jVar) {
            if (SmartRefreshPageSplitter.this.f68474b != null) {
                SmartRefreshPageSplitter.this.f68474b.bf(jVar);
            }
            jVar.setNoMoreData(false);
            SmartRefreshPageSplitter.this.A();
        }
    }

    public interface b<T extends s9.a> {
        void Q();

        void R(List<T> list);
    }

    public interface c<T extends s9.a> {
        Func1<? super T, ? extends Long> a();

        Observable<List<T>> b(T t11);

        Observable<List<T>> c();
    }

    public interface d extends f {
        RecyclerView Y0();

        SmartRefreshLayout t2();
    }

    public interface e {
        void onRetry();
    }

    public SmartRefreshPageSplitter(Builder<T> builder) {
        this.f68473a = builder.f68494a;
        this.f68476d = builder.f68496c;
        this.f68474b = builder.f68502i;
        this.f68477e = builder.f68497d;
        this.f68478f = builder.f68498e;
        this.f68479g = builder.f68500g;
        this.f68481i = builder.f68501h;
        this.f68480h = builder.f68500g;
        this.f68492t = builder.f68503j;
        this.f68482j = builder.f68495b;
        this.f68490r = builder.f68499f;
        r();
        s();
        q();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t() {
        i6.d.b("enter");
        b<T> bVar = this.f68492t;
        if (bVar != null) {
            bVar.Q();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(List list) {
        List<T> list2 = this.f68485m;
        boolean z11 = true;
        if (list2 != null) {
            if (this.f68480h) {
                boolean z12 = list2.size() >= this.f68477e;
                this.f68479g = z12;
                if (!z12 && list.size() < this.f68477e) {
                    z11 = false;
                }
                this.f68479g = z11;
            }
        } else if (this.f68480h) {
            if (list.size() < this.f68477e) {
                z11 = false;
            }
            this.f68479g = z11;
        }
        i6.d.b("enter");
        this.f68484l.clear();
        if (list == null || list.isEmpty()) {
            this.f68473a.f6().i();
        } else {
            this.f68484l.addAll(list);
            this.f68473a.f6().g();
        }
        this.f68487o.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(APIStatusErrorException aPIStatusErrorException) {
        List<T> list;
        if (!this.f68482j || (list = this.f68484l) == null || list.size() <= 0) {
            this.f68473a.f6().k();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(Throwable th2) {
        List<T> list;
        if (!this.f68482j || (list = this.f68484l) == null || list.size() <= 0) {
            this.f68473a.f6().k();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(boolean z11) {
        if (z11) {
            this.f68475c.finishRefresh();
            this.f68475c.g(this.f68479g);
        } else {
            this.f68475c.w();
        }
        this.f68489q.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
        b<T> bVar = this.f68492t;
        if (bVar != null) {
            bVar.R(this.f68484l);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void y(View view) {
        e eVar = this.f68490r;
        if (eVar != null) {
            eVar.onRetry();
        } else {
            this.f68473a.f6().p();
            A();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(List list) {
        List<T> list2 = this.f68485m;
        boolean z11 = true;
        if (list2 != null) {
            if (this.f68477e <= list2.size()) {
                z11 = false;
            }
            this.f68488p = z11;
            return;
        }
        if (this.f68477e <= list.size()) {
            z11 = false;
        }
        this.f68488p = z11;
    }

    public final void A() {
        c<T> cVar = this.f68476d;
        if (cVar != null) {
            cVar.c().compose(RxJavaHelper.t(this.f68473a)).doOnNext(this.f68493u).subscribe(p(true));
        }
    }

    public void B() {
        this.f68473a.f6().p();
        SmartRefreshLayout smartRefreshLayout = this.f68475c;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setNoMoreData(false);
        }
        A();
    }

    public final Observer<List<T>> p(boolean z11) {
        return EasySubscriber.create(new r6.b(this), new r6.f(this), new r6.d(this), new r6.e(this), new r6.c(this, z11));
    }

    public final void q() {
        this.f68473a.f6().setOnRetryClickListener(new r6.a(this));
    }

    public final void r() {
        SmartRefreshLayout t22 = this.f68473a.t2();
        this.f68475c = t22;
        t22.W(false);
        SmartRefreshFooter smartRefreshFooter = new SmartRefreshFooter(this.f68475c.getContext());
        this.f68491s = smartRefreshFooter;
        smartRefreshFooter.setFooterDividerVisible(this.f68481i);
        this.f68475c.h0(this.f68491s);
        this.f68475c.i(this.f68478f);
        this.f68475c.g(this.f68479g);
        this.f68475c.V(false);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(this.f68475c.getContext());
        this.f68489q = smartRefreshHeader;
        this.f68475c.j0(smartRefreshHeader);
        this.f68475c.e0(new a());
    }

    public void s() {
        this.f68483k = this.f68473a.Y0();
        ArrayList arrayList = new ArrayList();
        this.f68484l = arrayList;
        v9.a<T> aVar = new v9.a<>(arrayList);
        this.f68487o = aVar;
        this.f68483k.setAdapter(aVar);
    }
}
