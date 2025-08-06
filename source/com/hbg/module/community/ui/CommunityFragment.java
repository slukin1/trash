package com.hbg.module.community.ui;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.module.community.adapter.CommunityEmptyCommonBinder;
import com.hbg.module.community.adapter.CommunityInterestTagsBinder;
import com.hbg.module.community.adapter.CommunityRecommendFollowBinder;
import com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder;
import com.hbg.module.community.adapter.CommunityShareCommonBinder;
import com.hbg.module.community.adapter.CommunityTopicBinder;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import com.hbg.module.community.multiadapter.g;
import com.hbg.module.community.viewmodel.CommunityViewModel;
import com.hbg.module.content.R$attr;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gc.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.f;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import kotlin.l;
import ky.j;
import lc.c1;
import rd.s;
import se.d;

public final class CommunityFragment extends BaseFragment<c1> {
    public static final a E = new a((r) null);
    public List<LiveBannerData> A = new ArrayList();
    public boolean B;
    public boolean C;
    public HbgBaseApmProvider D;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList<Fragment> f17277p = new ArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    public CommunityViewModel f17278q;

    /* renamed from: r  reason: collision with root package name */
    public int f17279r = 5;

    /* renamed from: s  reason: collision with root package name */
    public int f17280s;

    /* renamed from: t  reason: collision with root package name */
    public String f17281t = "";

    /* renamed from: u  reason: collision with root package name */
    public Boolean f17282u = Boolean.FALSE;

    /* renamed from: v  reason: collision with root package name */
    public String f17283v = "";

    /* renamed from: w  reason: collision with root package name */
    public MultiTypeAdapter f17284w;

    /* renamed from: x  reason: collision with root package name */
    public List<Object> f17285x = new ArrayList();

    /* renamed from: y  reason: collision with root package name */
    public int f17286y = -1;

    /* renamed from: z  reason: collision with root package name */
    public boolean f17287z;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final CommunityFragment a(int i11, int i12, String str) {
            CommunityFragment communityFragment = new CommunityFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i11);
            bundle.putInt("from", i12);
            bundle.putString("symbolId", str);
            communityFragment.setArguments(bundle);
            return communityFragment;
        }
    }

    public static final class b implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17288b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17289c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFragment f17290d;

        public b(View view, long j11, CommunityFragment communityFragment) {
            this.f17288b = view;
            this.f17289c = j11;
            this.f17290d = communityFragment;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17288b) > this.f17289c || (this.f17288b instanceof Checkable)) {
                sVar.e(this.f17288b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17288b;
                if (!(this.f17290d.getActivity() == null || this.f17290d.wh() == null)) {
                    HbgBaseProvider wh2 = this.f17290d.wh();
                    if (!(wh2 != null && !wh2.j(this.f17290d.getActivity()))) {
                        if (x.b(this.f17290d.f17282u, Boolean.TRUE)) {
                            gc.b.d(gc.b.f19131a, (String) null, (TopicDetailInfo.HeaderInfo) null, (String) null, (String) null, 15, (Object) null);
                            nc.c.a("app_community_fbdj", MapsKt__MapsKt.j(l.a("pagename", "plazadiscover")));
                        } else {
                            gc.b.f();
                        }
                    }
                }
            }
            return true;
        }
    }

    public static final class c implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d10.l f17291b;

        public c(d10.l lVar) {
            this.f17291b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f17291b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f17291b.invoke(obj);
        }
    }

    public static final /* synthetic */ c1 Vh(CommunityFragment communityFragment) {
        return (c1) communityFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void ji(CommunityFragment communityFragment, View view) {
        communityFragment.li(-1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        this.f17279r = arguments != null ? arguments.getInt("type", this.f17279r) : this.f17279r;
        Bundle arguments2 = getArguments();
        this.f17280s = arguments2 != null ? arguments2.getInt("from", this.f17280s) : this.f17280s;
        Bundle arguments3 = getArguments();
        this.f17281t = String.valueOf(arguments3 != null ? arguments3.getString("symbolId") : null);
    }

    public void Eh() {
        super.Eh();
        d.w();
    }

    public void P8(j jVar) {
        super.P8(jVar);
        ki(2);
        nc.c.a("app_community_sl", (HashMap<?, ?>) null);
    }

    public void bf(j jVar) {
        super.bf(jVar);
        HbgBaseProvider wh2 = wh();
        boolean z11 = false;
        if (wh2 != null && wh2.n()) {
            z11 = true;
        }
        if (z11) {
            CommunityViewModel communityViewModel = this.f17278q;
            if (communityViewModel == null) {
                communityViewModel = null;
            }
            communityViewModel.s0();
        }
        li(1);
        nc.c.a("app_community_xl", (HashMap<?, ?>) null);
    }

    public final List<LiveBannerData> ci() {
        return this.A;
    }

    public final MultiTypeAdapter di() {
        MultiTypeAdapter multiTypeAdapter = this.f17284w;
        if (multiTypeAdapter != null) {
            return multiTypeAdapter;
        }
        return null;
    }

    public final List<Object> ei() {
        return this.f17285x;
    }

    public final int fi() {
        return this.f17286y;
    }

    /* renamed from: gi */
    public c1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return c1.K(layoutInflater, viewGroup, false);
    }

    public final void hi() {
        mi(new MultiTypeAdapter((List) null, 0, (g) null, 7, (r) null));
        di().h(CommunityFeedInfo.TopicListBean.class, new CommunityTopicBinder());
        CommunityRecommendFollowBinder communityRecommendFollowBinder = new CommunityRecommendFollowBinder();
        di().h(CommunityFeedInfo.ListBean.class, communityRecommendFollowBinder);
        CommunityEmptyCommonBinder communityEmptyCommonBinder = new CommunityEmptyCommonBinder();
        CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder = new CommunityReplyArticleCommonBinder();
        CommunityShareCommonBinder communityShareCommonBinder = new CommunityShareCommonBinder();
        CommunityInterestTagsBinder communityInterestTagsBinder = new CommunityInterestTagsBinder();
        communityEmptyCommonBinder.l0(new CommunityFragment$initListView$1(this));
        communityReplyArticleCommonBinder.l0(new CommunityFragment$initListView$2(this));
        communityRecommendFollowBinder.t(new CommunityFragment$initListView$3(this));
        communityEmptyCommonBinder.j0(new CommunityFragment$initListView$4(this));
        communityReplyArticleCommonBinder.j0(new CommunityFragment$initListView$5(this));
        communityRecommendFollowBinder.s(new CommunityFragment$initListView$6(this));
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
        di().f(Reflection.b(CommunityFeedInfo.ListBean.class)).a(communityEmptyCommonBinder, communityReplyArticleCommonBinder, communityRecommendFollowBinder, communityShareCommonBinder, communityInterestTagsBinder).b(CommunityFragment$initListView$9.INSTANCE);
        com.hbg.module.libkt.base.ext.b.c(((c1) uh()).F, 0.0f, 0, R$attr.kline_secondary_separator, 3, (Object) null);
        ((c1) uh()).F.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(getActivity()));
        di().setItems(this.f17285x);
        ((c1) uh()).F.setAdapter(di());
    }

    public final void ii() {
        ((c1) uh()).E.setOnRetryClickListener(new d(this));
        nc.c.a("app_community_fb", MapsKt__MapsKt.j(l.a("pagename", "communityplaza")));
        s sVar = s.f23381a;
        ImageView imageView = ((c1) uh()).C;
        imageView.setOnTouchListener(new b(imageView, 800, this));
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void initObservers() {
        CommunityViewModel communityViewModel = this.f17278q;
        if (communityViewModel == null) {
            communityViewModel = null;
        }
        communityViewModel.k0().observe(this, new c(new CommunityFragment$initObservers$1(this)));
        CommunityViewModel communityViewModel2 = this.f17278q;
        if (communityViewModel2 == null) {
            communityViewModel2 = null;
        }
        communityViewModel2.m0().observe(this, new c(new CommunityFragment$initObservers$2(this)));
        CommunityViewModel communityViewModel3 = this.f17278q;
        if (communityViewModel3 == null) {
            communityViewModel3 = null;
        }
        communityViewModel3.h0().observe(this, new c(new CommunityFragment$initObservers$3(this)));
        CommunityViewModel communityViewModel4 = this.f17278q;
        if (communityViewModel4 == null) {
            communityViewModel4 = null;
        }
        communityViewModel4.i0().observe(this, new c(new CommunityFragment$initObservers$4(this)));
        CommunityViewModel communityViewModel5 = this.f17278q;
        if (communityViewModel5 == null) {
            communityViewModel5 = null;
        }
        communityViewModel5.j0().observe(this, new c(new CommunityFragment$initObservers$5(this)));
        CommunityViewModel communityViewModel6 = this.f17278q;
        if (communityViewModel6 == null) {
            communityViewModel6 = null;
        }
        communityViewModel6.l0().observe(this, new c(new CommunityFragment$initObservers$6(this)));
        CommunityViewModel communityViewModel7 = this.f17278q;
        if (communityViewModel7 == null) {
            communityViewModel7 = null;
        }
        communityViewModel7.n0().observe(this, new c(new CommunityFragment$initObservers$7(this)));
        we.b.m("followStatus", (Class) null, 2, (Object) null).observe(this, new c(new CommunityFragment$initObservers$8(this)));
        we.c.a(this, new c(new CommunityFragment$initObservers$9(this)));
        we.c.b(this, new c(new CommunityFragment$initObservers$10(this)));
        we.b.m("communityRefreshPage", (Class) null, 2, (Object) null).observe(this, new c(new CommunityFragment$initObservers$11(this)));
        we.b.m("dynamicDel", (Class) null, 2, (Object) null).observe(this, new c(new CommunityFragment$initObservers$12(this)));
    }

    public void initView() {
        boolean z11 = true;
        if (!this.B) {
            this.B = true;
            HbgBaseApmProvider hbgBaseApmProvider = (HbgBaseApmProvider) b2.a.d().a("/provider/apm").navigation();
            this.D = hbgBaseApmProvider;
            if (hbgBaseApmProvider != null) {
                hbgBaseApmProvider.o("huobiapp_market_content_community_end");
            }
        }
        if (com.hbg.module.libkt.base.ext.b.e(getActivity())) {
            ((c1) uh()).B.q(requireActivity());
            ((c1) uh()).G.j0(new SmartRefreshHeader(getActivity()));
            SmartRefreshFooter smartRefreshFooter = new SmartRefreshFooter(getActivity());
            smartRefreshFooter.setFooterDividerVisible(false);
            smartRefreshFooter.setFooterBackgroundColor(getResources().getColor(17170445));
            ((c1) uh()).G.h0(smartRefreshFooter);
            ((c1) uh()).G.e0(this);
            this.f17278q = (CommunityViewModel) e.f19132a.a(this, CommunityViewModel.class);
            ((c1) uh()).E.b(1).setBackgroundDrawable((Drawable) null);
            initObservers();
            ii();
            HbgBaseProvider wh2 = wh();
            if (wh2 != null && wh2.n()) {
                CommunityViewModel communityViewModel = this.f17278q;
                if (communityViewModel == null) {
                    communityViewModel = null;
                }
                communityViewModel.s0();
            }
            nc.c.a("app_community_plaza", (HashMap<?, ?>) null);
            hi();
            li(-1);
            HbgBaseProvider wh3 = wh();
            if (wh3 == null || !wh3.n()) {
                z11 = false;
            }
            this.f17287z = z11;
        }
    }

    public final void ki(int i11) {
        if (i11 == -1) {
            Lh();
        }
        this.f17286y = i11;
        CommunityViewModel communityViewModel = this.f17278q;
        if (communityViewModel == null) {
            communityViewModel = null;
        }
        communityViewModel.q0(i11);
    }

    public final void li(int i11) {
        CommunityViewModel communityViewModel = null;
        if (i11 == -1) {
            BaseFragment.Oh(this, false, false, 1, (Object) null);
        }
        this.f17286y = i11;
        CommunityViewModel communityViewModel2 = this.f17278q;
        if (communityViewModel2 != null) {
            communityViewModel = communityViewModel2;
        }
        communityViewModel.o0(this.f17279r);
    }

    public final void mi(MultiTypeAdapter multiTypeAdapter) {
        this.f17284w = multiTypeAdapter;
    }

    public void onResume() {
        super.onResume();
        HbgBaseProvider wh2 = wh();
        boolean z11 = true;
        if (!(wh2 != null && wh2.n() == this.f17287z)) {
            CommunityViewModel communityViewModel = this.f17278q;
            if (communityViewModel == null) {
                communityViewModel = null;
            }
            communityViewModel.s0();
            HbgBaseProvider wh3 = wh();
            if (wh3 == null || !wh3.n()) {
                z11 = false;
            }
            this.f17287z = z11;
            li(-1);
        }
    }
}
