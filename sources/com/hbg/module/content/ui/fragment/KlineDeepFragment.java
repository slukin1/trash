package com.hbg.module.content.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.module.content.adapter.n;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import d10.q;
import i6.d;
import kotlin.Unit;
import kotlin.f;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import ky.j;
import lc.o1;

public final class KlineDeepFragment extends BaseFragment<o1> {
    public static final a C = new a((r) null);
    public l<? super Boolean, Unit> A;
    public d10.a<Boolean> B;

    /* renamed from: p  reason: collision with root package name */
    public n f18749p;

    /* renamed from: q  reason: collision with root package name */
    public long f18750q;

    /* renamed from: r  reason: collision with root package name */
    public int f18751r;

    /* renamed from: s  reason: collision with root package name */
    public int f18752s = 20;

    /* renamed from: t  reason: collision with root package name */
    public String f18753t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f18754u;

    /* renamed from: v  reason: collision with root package name */
    public d10.a<Unit> f18755v;

    /* renamed from: w  reason: collision with root package name */
    public d10.a<Unit> f18756w;

    /* renamed from: x  reason: collision with root package name */
    public q<? super Integer, ? super Boolean, ? super Boolean, Unit> f18757x;

    /* renamed from: y  reason: collision with root package name */
    public d10.a<Unit> f18758y;

    /* renamed from: z  reason: collision with root package name */
    public d10.a<Unit> f18759z;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final KlineDeepFragment a(String str) {
            KlineDeepFragment klineDeepFragment = new KlineDeepFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            klineDeepFragment.setArguments(bundle);
            return klineDeepFragment;
        }
    }

    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ KlineDeepFragment f18760a;

        public b(KlineDeepFragment klineDeepFragment) {
            this.f18760a = klineDeepFragment;
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            int findLastVisibleItemPosition;
            super.onScrolled(recyclerView, i11, i12);
            n ai2 = this.f18760a.ai();
            if (ai2 != null) {
                KlineDeepFragment klineDeepFragment = this.f18760a;
                if (ai2.getItemCount() > 0 && (recyclerView.getLayoutManager() instanceof LinearLayoutManager) && (findLastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition()) >= ai2.getItemCount() - (klineDeepFragment.di() / 2)) {
                    d10.a<Boolean> gi2 = klineDeepFragment.gi();
                    boolean z11 = true;
                    if (gi2 == null || !gi2.invoke().booleanValue()) {
                        z11 = false;
                    }
                    if (!z11 && !klineDeepFragment.Zh()) {
                        d.c("ray01", "lastP " + findLastVisibleItemPosition + " count " + ai2.getItemCount() + "  1 getPreLoadNewsList mIsLoadMoreNews " + klineDeepFragment.Zh());
                        klineDeepFragment.ci();
                    }
                }
            }
        }
    }

    public static final class c implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f18761b;

        public c(l lVar) {
            this.f18761b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f18761b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f18761b.invoke(obj);
        }
    }

    public static final /* synthetic */ o1 Sh(KlineDeepFragment klineDeepFragment) {
        return (o1) klineDeepFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void fi(KlineDeepFragment klineDeepFragment, View view) {
        klineDeepFragment.bi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        this.f18753t = arguments != null ? arguments.getString("id") : null;
    }

    public void P8(j jVar) {
        d.c("ray01", "onLoadMore mIsLoadMoreNews " + this.f18754u);
        if (!this.f18754u) {
            this.f18754u = true;
            d.c("ray01", "onLoadMore getNewsList " + this.f18754u);
            bi();
        }
    }

    public final d10.a<Unit> Th() {
        return this.f18755v;
    }

    public final q<Integer, Boolean, Boolean, Unit> Uh() {
        return this.f18757x;
    }

    public final d10.a<Unit> Vh() {
        return this.f18758y;
    }

    public final d10.a<Unit> Wh() {
        return this.f18759z;
    }

    public final d10.a<Unit> Xh() {
        return this.f18756w;
    }

    public final long Yh() {
        return this.f18750q;
    }

    public final boolean Zh() {
        return this.f18754u;
    }

    public final n ai() {
        return this.f18749p;
    }

    public void bf(j jVar) {
        this.f18750q = 0;
        this.f18751r = 0;
        l<? super Boolean, Unit> lVar = this.A;
        if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        bi();
    }

    public final void bi() {
        String str = this.f18753t;
        if (str != null) {
            RequestExtKt.d(v7.b.a().getKlineDeepNewsList(this.f18750q, this.f18752s, str, this.f18751r), new KlineDeepFragment$getNewsList$1$1(this), new KlineDeepFragment$getNewsList$1$2(this), (MutableLiveData) null, 4, (Object) null);
        }
    }

    public final void ci() {
        String str = this.f18753t;
        if (str != null) {
            this.f18754u = true;
            d.c("ray01", "2 getPreLoadNewsList mIsLoadMoreNews " + this.f18754u);
            RequestExtKt.d(v7.b.a().getKlineDeepNewsList(this.f18750q, this.f18752s, str, this.f18751r), new KlineDeepFragment$getPreLoadNewsList$1$1(this), new KlineDeepFragment$getPreLoadNewsList$1$2(this), (MutableLiveData) null, 4, (Object) null);
        }
    }

    public final int di() {
        return this.f18752s;
    }

    /* renamed from: ei */
    public o1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return o1.K(layoutInflater, viewGroup, false);
    }

    public final d10.a<Boolean> gi() {
        return this.B;
    }

    public final void hi(int i11) {
        this.f18751r = i11;
    }

    public final void ii(long j11) {
        this.f18750q = j11;
    }

    public final void initListener() {
        ((o1) uh()).B.setOnRetryClickListener(new e(this));
        ((o1) uh()).C.addOnScrollListener(new b(this));
    }

    public void initView() {
        ((o1) uh()).D.j0(new SmartRefreshHeader(getActivity()));
        SmartRefreshFooter smartRefreshFooter = new SmartRefreshFooter(getActivity());
        smartRefreshFooter.setFooterDividerVisible(false);
        smartRefreshFooter.setFooterBackgroundColor(getResources().getColor(17170445));
        ((o1) uh()).D.h0(smartRefreshFooter);
        ((o1) uh()).D.e0(this);
        this.f18756w = new KlineDeepFragment$initView$1(this);
        this.A = new KlineDeepFragment$initView$2(this);
        this.f18755v = new KlineDeepFragment$initView$3(this);
        this.f18757x = new KlineDeepFragment$initView$4(this);
        this.f18758y = new KlineDeepFragment$initView$5(this);
        this.f18759z = new KlineDeepFragment$initView$6(this);
        this.B = new KlineDeepFragment$initView$7(this);
        if (com.hbg.module.libkt.base.ext.b.e(getActivity())) {
            n nVar = new n(getActivity());
            this.f18749p = nVar;
            nVar.setHasStableIds(true);
        }
        ((o1) uh()).C.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(getActivity()));
        ((o1) uh()).C.setAdapter(this.f18749p);
        initListener();
        ((o1) uh()).B.g();
        Lh();
        bi();
        we.b.m("pageVisible", (Class) null, 2, (Object) null).observe(this, new c(new KlineDeepFragment$initView$8(this)));
    }

    public final void ji(boolean z11) {
        this.f18754u = z11;
    }
}
