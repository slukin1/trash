package com.huobi.page;

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
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import s9.a;
import yp.f;
import yp.g;
import yp.h;
import yp.i;

public class SmartRefreshPageSplitter<T extends s9.a> {

    /* renamed from: a  reason: collision with root package name */
    public d f80265a;

    /* renamed from: b  reason: collision with root package name */
    public ny.d f80266b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f80267c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f80268d;

    /* renamed from: e  reason: collision with root package name */
    public int f80269e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f80270f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f80271g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f80272h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f80273i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f80274j;

    /* renamed from: k  reason: collision with root package name */
    public RecyclerView f80275k;

    /* renamed from: l  reason: collision with root package name */
    public List<T> f80276l;

    /* renamed from: m  reason: collision with root package name */
    public List<T> f80277m;

    /* renamed from: n  reason: collision with root package name */
    public T f80278n;

    /* renamed from: o  reason: collision with root package name */
    public v9.a<T> f80279o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f80280p = false;

    /* renamed from: q  reason: collision with root package name */
    public SmartRefreshHeader f80281q;

    /* renamed from: r  reason: collision with root package name */
    public e f80282r;

    /* renamed from: s  reason: collision with root package name */
    public SmartRefreshFooter f80283s;

    /* renamed from: t  reason: collision with root package name */
    public b<T> f80284t;

    /* renamed from: u  reason: collision with root package name */
    public Action1<List<T>> f80285u = new f(this);

    public static class Builder<T extends s9.a> {

        /* renamed from: a  reason: collision with root package name */
        public d f80286a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f80287b;

        /* renamed from: c  reason: collision with root package name */
        public c<T> f80288c;

        /* renamed from: d  reason: collision with root package name */
        public int f80289d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f80290e;

        /* renamed from: f  reason: collision with root package name */
        public e f80291f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f80292g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f80293h = true;

        /* renamed from: i  reason: collision with root package name */
        public ny.d f80294i;

        /* renamed from: j  reason: collision with root package name */
        public b f80295j;

        public SmartRefreshPageSplitter<T> k() {
            boolean z11 = true;
            Assert.a(this.f80286a != null);
            Assert.a(this.f80288c != null);
            if (this.f80289d <= 0) {
                z11 = false;
            }
            Assert.a(z11);
            return new SmartRefreshPageSplitter<>(this);
        }

        public Builder l(b bVar) {
            this.f80295j = bVar;
            return this;
        }

        public Builder m(boolean z11) {
            this.f80293h = z11;
            return this;
        }

        public Builder n(boolean z11) {
            this.f80292g = z11;
            return this;
        }

        public Builder o(int i11) {
            this.f80289d = i11;
            return this;
        }

        public Builder p(boolean z11) {
            this.f80290e = z11;
            return this;
        }

        public Builder q(c cVar) {
            this.f80288c = cVar;
            return this;
        }

        public Builder r(d dVar) {
            this.f80286a = dVar;
            return this;
        }
    }

    public class a implements ny.d {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Observable d(Observable observable) {
            if (SmartRefreshPageSplitter.this.f80268d.a() == null) {
                return observable;
            }
            return observable.distinct(SmartRefreshPageSplitter.this.f80268d.a());
        }

        public void P8(j jVar) {
            s9.a aVar;
            if (SmartRefreshPageSplitter.this.f80266b != null) {
                SmartRefreshPageSplitter.this.f80266b.P8(jVar);
            }
            if (SmartRefreshPageSplitter.this.f80280p) {
                jVar.e();
                return;
            }
            c m11 = SmartRefreshPageSplitter.this.f80268d;
            if (SmartRefreshPageSplitter.this.f80278n != null) {
                aVar = SmartRefreshPageSplitter.this.f80278n;
            } else {
                aVar = SmartRefreshPageSplitter.this.f80276l.size() > 0 ? (s9.a) SmartRefreshPageSplitter.this.f80276l.get(SmartRefreshPageSplitter.this.f80276l.size() - 1) : null;
            }
            Observable subscribeOn = m11.b(aVar).doOnNext(SmartRefreshPageSplitter.this.f80285u).subscribeOn(Schedulers.io());
            subscribeOn.observeOn(AndroidSchedulers.mainThread());
            Observable.merge(Observable.just(SmartRefreshPageSplitter.this.f80276l), subscribeOn).flatMap(i.f61975b).compose(new h(this)).toList().observeOn(AndroidSchedulers.mainThread()).subscribe(SmartRefreshPageSplitter.this.p(false));
        }

        public void bf(j jVar) {
            if (SmartRefreshPageSplitter.this.f80266b != null) {
                SmartRefreshPageSplitter.this.f80266b.bf(jVar);
            }
            jVar.setNoMoreData(false);
            SmartRefreshPageSplitter.this.B();
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

    public interface d extends u6.f {
        RecyclerView Y0();

        SmartRefreshLayout t2();
    }

    public interface e {
        void onRetry();
    }

    public SmartRefreshPageSplitter(Builder<T> builder) {
        this.f80265a = builder.f80286a;
        this.f80268d = builder.f80288c;
        this.f80266b = builder.f80294i;
        this.f80269e = builder.f80289d;
        this.f80270f = builder.f80290e;
        this.f80271g = builder.f80292g;
        this.f80273i = builder.f80293h;
        this.f80272h = builder.f80292g;
        this.f80284t = builder.f80295j;
        this.f80274j = builder.f80287b;
        this.f80282r = builder.f80291f;
        s();
        t();
        r();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(List list) {
        List<T> list2 = this.f80277m;
        boolean z11 = true;
        if (list2 != null) {
            if (this.f80269e <= list2.size()) {
                z11 = false;
            }
            this.f80280p = z11;
            return;
        }
        if (this.f80269e <= list.size()) {
            z11 = false;
        }
        this.f80280p = z11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u() {
        i6.d.b("enter");
        b<T> bVar = this.f80284t;
        if (bVar != null) {
            bVar.Q();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(List list) {
        List<T> list2 = this.f80277m;
        boolean z11 = true;
        if (list2 != null) {
            if (this.f80272h) {
                boolean z12 = list2.size() >= this.f80269e;
                this.f80271g = z12;
                if (!z12 && list.size() < this.f80269e) {
                    z11 = false;
                }
                this.f80271g = z11;
            }
        } else if (this.f80272h) {
            if (list.size() < this.f80269e) {
                z11 = false;
            }
            this.f80271g = z11;
        }
        i6.d.b("enter");
        this.f80276l.clear();
        this.f80276l.addAll(list);
        this.f80279o.notifyDataSetChanged();
        if (list == null || list.isEmpty()) {
            this.f80265a.f6().i();
        } else {
            this.f80265a.f6().g();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(APIStatusErrorException aPIStatusErrorException) {
        List<T> list;
        if (!this.f80274j || (list = this.f80276l) == null || list.size() <= 0) {
            this.f80265a.f6().k();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(Throwable th2) {
        List<T> list;
        if (th2 instanceof NullPointerException) {
            this.f80265a.f6().i();
        } else if (!this.f80274j || (list = this.f80276l) == null || list.size() <= 0) {
            this.f80265a.f6().k();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(boolean z11) {
        if (z11) {
            this.f80267c.finishRefresh();
            this.f80267c.g(this.f80271g);
        } else {
            this.f80267c.w();
        }
        this.f80281q.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
        b<T> bVar = this.f80284t;
        if (bVar != null) {
            bVar.R(this.f80276l);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void z(View view) {
        e eVar = this.f80282r;
        if (eVar != null) {
            eVar.onRetry();
        } else {
            this.f80265a.f6().p();
            B();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void B() {
        c<T> cVar = this.f80268d;
        if (cVar != null) {
            cVar.c().compose(RxJavaHelper.t(this.f80265a)).doOnNext(this.f80285u).subscribe(p(true));
        }
    }

    public void C(T t11) {
        this.f80278n = t11;
    }

    public void D(List<T> list) {
        if (list != null) {
            this.f80277m = list;
        }
    }

    public void E(c<T> cVar) {
        this.f80268d = cVar;
    }

    public void F() {
        this.f80265a.f6().p();
        SmartRefreshLayout smartRefreshLayout = this.f80267c;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setNoMoreData(false);
        }
        B();
    }

    public final Observer<List<T>> p(boolean z11) {
        return EasySubscriber.create(new yp.b(this), new g(this), new yp.d(this), new yp.e(this), new yp.c(this, z11));
    }

    public List<T> q() {
        return this.f80276l;
    }

    public final void r() {
        this.f80265a.f6().setOnRetryClickListener(new yp.a(this));
    }

    public final void s() {
        SmartRefreshLayout t22 = this.f80265a.t2();
        this.f80267c = t22;
        t22.W(false);
        SmartRefreshFooter smartRefreshFooter = new SmartRefreshFooter(this.f80267c.getContext());
        this.f80283s = smartRefreshFooter;
        smartRefreshFooter.setFooterDividerVisible(this.f80273i);
        this.f80267c.h0(this.f80283s);
        this.f80267c.i(this.f80270f);
        this.f80267c.g(this.f80271g);
        this.f80267c.V(false);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(this.f80267c.getContext());
        this.f80281q = smartRefreshHeader;
        this.f80267c.j0(smartRefreshHeader);
        this.f80267c.e0(new a());
    }

    public void t() {
        this.f80275k = this.f80265a.Y0();
        ArrayList arrayList = new ArrayList();
        this.f80276l = arrayList;
        v9.a<T> aVar = new v9.a<>(arrayList);
        this.f80279o = aVar;
        this.f80275k.setAdapter(aVar);
    }
}
