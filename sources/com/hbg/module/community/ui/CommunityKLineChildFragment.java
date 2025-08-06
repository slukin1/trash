package com.hbg.module.community.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.network.hbg.core.bean.CommonPkData;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;
import com.hbg.module.community.adapter.CommunityEmptyCommonBinder;
import com.hbg.module.community.adapter.CommunityRecommendFollowBinder;
import com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder;
import com.hbg.module.community.adapter.CommunityShareCommonBinder;
import com.hbg.module.community.adapter.CommunityTopicBinder;
import com.hbg.module.community.adapter.CommunityVoteBinder;
import com.hbg.module.community.adapter.k;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import com.hbg.module.community.multiadapter.MutableTypes;
import com.hbg.module.community.multiadapter.g;
import com.hbg.module.community.viewmodel.CommunityViewModel;
import com.hbg.module.content.R$attr;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import gc.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.f;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import ky.j;
import lc.y0;
import nc.c;
import se.d;

public final class CommunityKLineChildFragment extends BaseFragment<y0> {
    public static final a D = new a((r) null);
    public List<Object> A = new ArrayList();
    public int B = -1;
    public boolean C;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList<Fragment> f17292p = new ArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    public CommunityViewModel f17293q;

    /* renamed from: r  reason: collision with root package name */
    public int f17294r = 1;

    /* renamed from: s  reason: collision with root package name */
    public String f17295s = "";

    /* renamed from: t  reason: collision with root package name */
    public String f17296t = "";

    /* renamed from: u  reason: collision with root package name */
    public String f17297u = "";

    /* renamed from: v  reason: collision with root package name */
    public boolean f17298v;

    /* renamed from: w  reason: collision with root package name */
    public String f17299w = "";

    /* renamed from: x  reason: collision with root package name */
    public Boolean f17300x = Boolean.FALSE;

    /* renamed from: y  reason: collision with root package name */
    public String f17301y = "";

    /* renamed from: z  reason: collision with root package name */
    public MultiTypeAdapter f17302z;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final CommunityKLineChildFragment a(int i11, String str, String str2, String str3, boolean z11, String str4) {
            CommunityKLineChildFragment communityKLineChildFragment = new CommunityKLineChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i11);
            bundle.putString("symbolId", str);
            bundle.putString("symbolName", str2);
            bundle.putString("tradeType", str3);
            bundle.putBoolean("isGrid", z11);
            bundle.putString("plateId", str4);
            communityKLineChildFragment.setArguments(bundle);
            return communityKLineChildFragment;
        }
    }

    public static final class b implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f17303b;

        public b(l lVar) {
            this.f17303b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f17303b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f17303b.invoke(obj);
        }
    }

    public static final /* synthetic */ y0 Th(CommunityKLineChildFragment communityKLineChildFragment) {
        return (y0) communityKLineChildFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void gi(CommunityKLineChildFragment communityKLineChildFragment, View view) {
        communityKLineChildFragment.ji(-1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        this.f17294r = arguments != null ? arguments.getInt("type", this.f17294r) : this.f17294r;
        Bundle arguments2 = getArguments();
        String str = null;
        this.f17295s = String.valueOf(arguments2 != null ? arguments2.getString("symbolId") : null);
        Bundle arguments3 = getArguments();
        this.f17297u = String.valueOf(arguments3 != null ? arguments3.getString("tradeType") : null);
        Bundle arguments4 = getArguments();
        this.f17298v = arguments4 != null ? arguments4.getBoolean("isGrid") : false;
        Bundle arguments5 = getArguments();
        this.f17296t = String.valueOf(arguments5 != null ? arguments5.getString("symbolName") : null);
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            str = arguments6.getString("plateId");
        }
        this.f17299w = String.valueOf(str);
    }

    public void Eh() {
        super.Eh();
        d.w();
    }

    public void P8(j jVar) {
        super.P8(jVar);
        hi(2);
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", this.f17295s);
        hashMap.put("markets_kline_class", k.a(this.f17297u, this.f17298v));
        c.a("app_community_sl", hashMap);
    }

    public final MultiTypeAdapter ai() {
        MultiTypeAdapter multiTypeAdapter = this.f17302z;
        if (multiTypeAdapter != null) {
            return multiTypeAdapter;
        }
        return null;
    }

    public void bf(j jVar) {
        super.bf(jVar);
        HbgBaseProvider wh2 = wh();
        boolean z11 = false;
        if (wh2 != null && wh2.n()) {
            z11 = true;
        }
        if (z11) {
            CommunityViewModel communityViewModel = this.f17293q;
            if (communityViewModel == null) {
                communityViewModel = null;
            }
            communityViewModel.s0();
        }
        ji(1);
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", this.f17295s);
        hashMap.put("markets_kline_class", k.a(this.f17297u, this.f17298v));
        c.a("app_community_xl", hashMap);
    }

    public final List<Object> bi() {
        return this.A;
    }

    public final int ci() {
        return this.B;
    }

    /* renamed from: di */
    public y0 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return y0.K(layoutInflater, viewGroup, false);
    }

    public final void ei() {
        ki(new MultiTypeAdapter((List) null, 0, (g) null, 7, (r) null));
        CommunityTopicBinder communityTopicBinder = new CommunityTopicBinder();
        communityTopicBinder.o(this.f17295s);
        communityTopicBinder.p(this.f17297u);
        communityTopicBinder.n(this.f17298v);
        ai().h(CommunityFeedInfo.TopicListBean.class, communityTopicBinder);
        CommunityVoteBinder communityVoteBinder = new CommunityVoteBinder();
        communityVoteBinder.o(this.f17295s);
        communityVoteBinder.p(this.f17297u);
        communityVoteBinder.n(this.f17298v);
        ai().h(CommonPkData.class, communityVoteBinder);
        CommunityRecommendFollowBinder communityRecommendFollowBinder = new CommunityRecommendFollowBinder();
        communityRecommendFollowBinder.o(this.f17295s);
        communityRecommendFollowBinder.p(this.f17297u);
        communityRecommendFollowBinder.n(this.f17298v);
        ai().h(CommunityFeedInfo.ListBean.class, communityRecommendFollowBinder);
        CommunityEmptyCommonBinder communityEmptyCommonBinder = new CommunityEmptyCommonBinder();
        communityEmptyCommonBinder.o(this.f17295s);
        communityEmptyCommonBinder.p(this.f17297u);
        communityEmptyCommonBinder.n(this.f17298v);
        CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder = new CommunityReplyArticleCommonBinder();
        communityReplyArticleCommonBinder.o(this.f17295s);
        communityReplyArticleCommonBinder.p(this.f17297u);
        communityReplyArticleCommonBinder.n(this.f17298v);
        CommunityShareCommonBinder communityShareCommonBinder = new CommunityShareCommonBinder();
        communityShareCommonBinder.o(this.f17295s);
        communityShareCommonBinder.p(this.f17297u);
        communityShareCommonBinder.n(this.f17298v);
        communityEmptyCommonBinder.l0(new CommunityKLineChildFragment$initListView$1(this));
        communityReplyArticleCommonBinder.l0(new CommunityKLineChildFragment$initListView$2(this));
        communityRecommendFollowBinder.t(new CommunityKLineChildFragment$initListView$3(this));
        communityEmptyCommonBinder.j0(new CommunityKLineChildFragment$initListView$4(this));
        communityReplyArticleCommonBinder.j0(new CommunityKLineChildFragment$initListView$5(this));
        communityRecommendFollowBinder.s(new CommunityKLineChildFragment$initListView$6(this));
        HbgBaseProvider wh2 = wh();
        if (wh2 != null) {
            communityReplyArticleCommonBinder.h0(wh2);
            communityEmptyCommonBinder.h0(wh2);
            communityShareCommonBinder.h0(wh2);
        }
        HbgBaseShareProvider xh2 = xh();
        if (xh2 != null) {
            communityReplyArticleCommonBinder.i0(xh2);
            communityEmptyCommonBinder.i0(xh2);
            communityShareCommonBinder.i0(xh2);
        }
        ai().f(Reflection.b(CommunityFeedInfo.ListBean.class)).a(communityEmptyCommonBinder, communityReplyArticleCommonBinder, communityRecommendFollowBinder, communityShareCommonBinder).b(CommunityKLineChildFragment$initListView$9.INSTANCE);
        com.hbg.module.libkt.base.ext.b.c(((y0) uh()).C, 0.0f, 0, R$attr.kline_secondary_separator, 3, (Object) null);
        ((y0) uh()).C.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(getActivity()));
        ai().setItems(this.A);
        ((y0) uh()).C.setAdapter(ai());
        for (com.hbg.module.community.multiadapter.f next : ((MutableTypes) ai().c()).d()) {
            if (next.b() instanceof CommunityBaseCommonBinder) {
                ((CommunityBaseCommonBinder) next.b()).g0(2);
            }
        }
    }

    public final void fi() {
        ((y0) uh()).B.setOnRetryClickListener(new e(this));
    }

    public final void hi(int i11) {
        if (i11 == -1) {
            Lh();
        }
        this.B = i11;
        CommunityViewModel communityViewModel = this.f17293q;
        if (communityViewModel == null) {
            communityViewModel = null;
        }
        communityViewModel.r0(i11, this.f17295s, this.f17299w, this.f17294r);
    }

    public final void ii() {
        ((y0) uh()).D.t();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void initObservers() {
        CommunityViewModel communityViewModel = this.f17293q;
        if (communityViewModel == null) {
            communityViewModel = null;
        }
        communityViewModel.k0().observe(this, new b(new CommunityKLineChildFragment$initObservers$1(this)));
        CommunityViewModel communityViewModel2 = this.f17293q;
        if (communityViewModel2 == null) {
            communityViewModel2 = null;
        }
        communityViewModel2.i0().observe(this, new b(new CommunityKLineChildFragment$initObservers$2(this)));
        CommunityViewModel communityViewModel3 = this.f17293q;
        if (communityViewModel3 == null) {
            communityViewModel3 = null;
        }
        communityViewModel3.j0().observe(this, new b(new CommunityKLineChildFragment$initObservers$3(this)));
        CommunityViewModel communityViewModel4 = this.f17293q;
        if (communityViewModel4 == null) {
            communityViewModel4 = null;
        }
        communityViewModel4.l0().observe(this, new b(new CommunityKLineChildFragment$initObservers$4(this)));
        CommunityViewModel communityViewModel5 = this.f17293q;
        if (communityViewModel5 == null) {
            communityViewModel5 = null;
        }
        communityViewModel5.n0().observe(this, new b(new CommunityKLineChildFragment$initObservers$5(this)));
        we.b.m("followStatus", (Class) null, 2, (Object) null).observe(this, new b(new CommunityKLineChildFragment$initObservers$6(this)));
        we.c.a(this, new b(new CommunityKLineChildFragment$initObservers$7(this)));
        we.c.b(this, new b(new CommunityKLineChildFragment$initObservers$8(this)));
        we.b.m("communityRefreshPage", (Class) null, 2, (Object) null).observe(this, new b(new CommunityKLineChildFragment$initObservers$9(this)));
        we.b.m("dynamicDel", (Class) null, 2, (Object) null).observe(this, new b(new CommunityKLineChildFragment$initObservers$10(this)));
    }

    public void initView() {
        if (com.hbg.module.libkt.base.ext.b.e(getActivity())) {
            ((y0) uh()).D.j0(new SmartRefreshHeader(getActivity()));
            SmartRefreshFooter smartRefreshFooter = new SmartRefreshFooter(getActivity());
            boolean z11 = false;
            smartRefreshFooter.setFooterDividerVisible(false);
            smartRefreshFooter.setFooterBackgroundColor(getResources().getColor(17170445));
            ((y0) uh()).D.h0(smartRefreshFooter);
            ((y0) uh()).D.e0(this);
            this.f17293q = (CommunityViewModel) e.f19132a.a(this, CommunityViewModel.class);
            HbgBaseProvider wh2 = wh();
            if (wh2 != null && wh2.n()) {
                CommunityViewModel communityViewModel = this.f17293q;
                if (communityViewModel == null) {
                    communityViewModel = null;
                }
                communityViewModel.s0();
            }
            ei();
            initObservers();
            fi();
            ji(-1);
            HbgBaseProvider wh3 = wh();
            if (wh3 != null && wh3.n()) {
                z11 = true;
            }
            this.C = z11;
        }
    }

    public final void ji(int i11) {
        CommunityViewModel communityViewModel = null;
        if (i11 == -1) {
            BaseFragment.Oh(this, false, false, 1, (Object) null);
        }
        this.B = i11;
        CommunityViewModel communityViewModel2 = this.f17293q;
        if (communityViewModel2 != null) {
            communityViewModel = communityViewModel2;
        }
        communityViewModel.r0(i11, this.f17295s, this.f17299w, this.f17294r);
    }

    public final void ki(MultiTypeAdapter multiTypeAdapter) {
        this.f17302z = multiTypeAdapter;
    }

    public void onResume() {
        super.onResume();
        HbgBaseProvider wh2 = wh();
        boolean z11 = true;
        if (!(wh2 != null && wh2.n() == this.C)) {
            CommunityViewModel communityViewModel = this.f17293q;
            if (communityViewModel == null) {
                communityViewModel = null;
            }
            communityViewModel.s0();
            HbgBaseProvider wh3 = wh();
            if (wh3 == null || !wh3.n()) {
                z11 = false;
            }
            this.C = z11;
            ji(-1);
        }
    }
}
