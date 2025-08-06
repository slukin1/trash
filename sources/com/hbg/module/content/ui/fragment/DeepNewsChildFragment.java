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
import com.hbg.module.content.adapter.g;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import i6.d;
import kotlin.f;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import ky.j;
import lc.i2;

public final class DeepNewsChildFragment extends BaseFragment<i2> {

    /* renamed from: x  reason: collision with root package name */
    public static final a f18731x = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public g f18732p;

    /* renamed from: q  reason: collision with root package name */
    public long f18733q;

    /* renamed from: r  reason: collision with root package name */
    public int f18734r = 20;

    /* renamed from: s  reason: collision with root package name */
    public Integer f18735s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f18736t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f18737u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f18738v;

    /* renamed from: w  reason: collision with root package name */
    public HbgBaseApmProvider f18739w;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final DeepNewsChildFragment a(int i11) {
            DeepNewsChildFragment deepNewsChildFragment = new DeepNewsChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", i11);
            deepNewsChildFragment.setArguments(bundle);
            return deepNewsChildFragment;
        }
    }

    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DeepNewsChildFragment f18740a;

        public b(DeepNewsChildFragment deepNewsChildFragment) {
            this.f18740a = deepNewsChildFragment;
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            int findLastVisibleItemPosition;
            super.onScrolled(recyclerView, i11, i12);
            g Zh = this.f18740a.Zh();
            if (Zh != null) {
                DeepNewsChildFragment deepNewsChildFragment = this.f18740a;
                if (Zh.getItemCount() > 0 && (recyclerView.getLayoutManager() instanceof LinearLayoutManager) && (findLastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition()) >= Zh.getItemCount() - (deepNewsChildFragment.ci() / 2) && !DeepNewsChildFragment.Th(deepNewsChildFragment).E.L() && !deepNewsChildFragment.Yh()) {
                    d.c("ray01", "lastP " + findLastVisibleItemPosition + " count " + Zh.getItemCount() + "  1 getPreLoadNewsList mIsLoadMoreNews " + deepNewsChildFragment.Yh());
                    deepNewsChildFragment.bi();
                }
            }
        }
    }

    public static final class c implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f18741b;

        public c(l lVar) {
            this.f18741b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f18741b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f18741b.invoke(obj);
        }
    }

    public static final /* synthetic */ i2 Th(DeepNewsChildFragment deepNewsChildFragment) {
        return (i2) deepNewsChildFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void ei(DeepNewsChildFragment deepNewsChildFragment, View view) {
        deepNewsChildFragment.ai();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        this.f18735s = arguments != null ? Integer.valueOf(arguments.getInt("id")) : null;
    }

    public void Fh() {
        super.Fh();
        if (isVisible()) {
            nc.c.a("app_news_article_show", MapsKt__MapsKt.j(kotlin.l.a("categoryId", this.f18735s)));
        }
    }

    public void P8(j jVar) {
        d.c("ray01", "onLoadMore mIsLoadMoreNews " + this.f18736t);
        if (!this.f18736t) {
            this.f18736t = true;
            d.c("ray01", "onLoadMore getNewsList " + this.f18736t);
            ai();
        }
    }

    public final Integer Wh() {
        return this.f18735s;
    }

    public final long Xh() {
        return this.f18733q;
    }

    public final boolean Yh() {
        return this.f18736t;
    }

    public final g Zh() {
        return this.f18732p;
    }

    public final void ai() {
        Integer num = this.f18735s;
        if (num != null) {
            RequestExtKt.d(v7.b.a().getDeepNewsList(this.f18733q, this.f18734r, num.intValue()), new DeepNewsChildFragment$getNewsList$1$1(this), new DeepNewsChildFragment$getNewsList$1$2(this), (MutableLiveData) null, 4, (Object) null);
        }
    }

    public void bf(j jVar) {
        this.f18733q = 0;
        ((i2) uh()).E.setNoMoreData(false);
        ai();
    }

    public final void bi() {
        Integer num = this.f18735s;
        if (num != null) {
            int intValue = num.intValue();
            this.f18736t = true;
            d.c("ray01", "2 getPreLoadNewsList mIsLoadMoreNews " + this.f18736t);
            RequestExtKt.d(v7.b.a().getDeepNewsList(this.f18733q, this.f18734r, intValue), new DeepNewsChildFragment$getPreLoadNewsList$1$1(this), new DeepNewsChildFragment$getPreLoadNewsList$1$2(this), (MutableLiveData) null, 4, (Object) null);
        }
    }

    public final int ci() {
        return this.f18734r;
    }

    /* renamed from: di */
    public i2 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return i2.K(layoutInflater, viewGroup, false);
    }

    public final void fi(long j11) {
        this.f18733q = j11;
    }

    public final void gi(boolean z11) {
        this.f18736t = z11;
    }

    public final void initListener() {
        ((i2) uh()).C.setOnRetryClickListener(new a(this));
        ((i2) uh()).D.addOnScrollListener(new b(this));
    }

    public void initView() {
        Integer num;
        if (!this.f18737u && (num = this.f18735s) != null && num.intValue() == -1) {
            this.f18737u = true;
            HbgBaseApmProvider hbgBaseApmProvider = (HbgBaseApmProvider) b2.a.d().a("/provider/apm").navigation();
            this.f18739w = hbgBaseApmProvider;
            if (hbgBaseApmProvider != null) {
                hbgBaseApmProvider.o("huobiapp_market_content_deep_end");
            }
        }
        ((i2) uh()).E.j0(new SmartRefreshHeader(getActivity()));
        SmartRefreshFooter smartRefreshFooter = new SmartRefreshFooter(getActivity());
        smartRefreshFooter.setFooterDividerVisible(false);
        smartRefreshFooter.setFooterBackgroundColor(getResources().getColor(17170445));
        ((i2) uh()).E.h0(smartRefreshFooter);
        ((i2) uh()).E.e0(this);
        if (com.hbg.module.libkt.base.ext.b.e(getActivity())) {
            g gVar = new g(getActivity());
            this.f18732p = gVar;
            gVar.setHasStableIds(true);
        }
        ((i2) uh()).D.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(getActivity()));
        ((i2) uh()).D.setAdapter(this.f18732p);
        initListener();
        ((i2) uh()).C.g();
        Lh();
        ai();
        we.b.m("pageVisible", (Class) null, 2, (Object) null).observe(this, new c(new DeepNewsChildFragment$initView$1(this)));
    }
}
