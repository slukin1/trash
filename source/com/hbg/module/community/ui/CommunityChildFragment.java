package com.hbg.module.community.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.adapter.CommunityEmptyCommonBinder;
import com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder;
import com.hbg.module.community.adapter.CommunityReplyCommentCommonBinder;
import com.hbg.module.community.adapter.CommunityTopicBinder;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
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
import kotlin.Unit;
import kotlin.f;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import lc.e1;

public final class CommunityChildFragment extends BaseFragment<e1> {

    /* renamed from: w  reason: collision with root package name */
    public static final a f17267w = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public MultiTypeAdapter f17268p;

    /* renamed from: q  reason: collision with root package name */
    public CommunityViewModel f17269q;

    /* renamed from: r  reason: collision with root package name */
    public List<Object> f17270r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public d10.a<Unit> f17271s;

    /* renamed from: t  reason: collision with root package name */
    public l<? super Boolean, Unit> f17272t;

    /* renamed from: u  reason: collision with root package name */
    public int f17273u = -1;

    /* renamed from: v  reason: collision with root package name */
    public boolean f17274v;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommunityChildFragment f17275a;

        public b(CommunityChildFragment communityChildFragment) {
            this.f17275a = communityChildFragment;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            if (i11 == 0) {
                if (this.f17275a.getActivity() != null) {
                    com.bumptech.glide.a.y(this.f17275a.getActivity()).u();
                }
            } else if (this.f17275a.getActivity() != null) {
                com.bumptech.glide.a.y(this.f17275a.getActivity()).t();
            }
        }
    }

    public static final class c implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f17276b;

        public c(l lVar) {
            this.f17276b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f17276b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f17276b.invoke(obj);
        }
    }

    public static final /* synthetic */ e1 Sh(CommunityChildFragment communityChildFragment) {
        return (e1) communityChildFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void ai(CommunityChildFragment communityChildFragment, View view) {
        communityChildFragment.ci(-1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final MultiTypeAdapter Th() {
        MultiTypeAdapter multiTypeAdapter = this.f17268p;
        if (multiTypeAdapter != null) {
            return multiTypeAdapter;
        }
        return null;
    }

    public final CommunityViewModel Uh() {
        CommunityViewModel communityViewModel = this.f17269q;
        if (communityViewModel != null) {
            return communityViewModel;
        }
        return null;
    }

    public final List<Object> Vh() {
        return this.f17270r;
    }

    public final int Wh() {
        return this.f17273u;
    }

    public final l<Boolean, Unit> Xh() {
        return this.f17272t;
    }

    public final d10.a<Unit> Yh() {
        return this.f17271s;
    }

    /* renamed from: Zh */
    public e1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return e1.K(layoutInflater, viewGroup, false);
    }

    public final void bi() {
        di(new MultiTypeAdapter((List) null, 0, (g) null, 7, (r) null));
        Th().h(CommunityFeedInfo.TopicListBean.class, new CommunityTopicBinder());
        CommunityEmptyCommonBinder communityEmptyCommonBinder = new CommunityEmptyCommonBinder();
        CommunityReplyCommentCommonBinder communityReplyCommentCommonBinder = new CommunityReplyCommentCommonBinder();
        CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder = new CommunityReplyArticleCommonBinder();
        communityEmptyCommonBinder.l0(new CommunityChildFragment$initListView$1(this));
        communityReplyCommentCommonBinder.l0(new CommunityChildFragment$initListView$2(this));
        communityReplyArticleCommonBinder.l0(new CommunityChildFragment$initListView$3(this));
        communityEmptyCommonBinder.j0(new CommunityChildFragment$initListView$4(this));
        communityReplyCommentCommonBinder.j0(new CommunityChildFragment$initListView$5(this));
        communityReplyArticleCommonBinder.j0(new CommunityChildFragment$initListView$6(this));
        HbgBaseProvider wh2 = wh();
        if (wh2 != null) {
            communityEmptyCommonBinder.h0(wh2);
            communityReplyCommentCommonBinder.h0(wh2);
            communityReplyArticleCommonBinder.h0(wh2);
        }
        HbgBaseShareProvider xh2 = xh();
        if (xh2 != null) {
            communityEmptyCommonBinder.i0(xh2);
            communityReplyCommentCommonBinder.i0(xh2);
            communityReplyArticleCommonBinder.i0(xh2);
        }
        Th().f(Reflection.b(CommunityFeedInfo.ListBean.class)).a(communityEmptyCommonBinder, communityReplyCommentCommonBinder, communityReplyArticleCommonBinder).b(CommunityChildFragment$initListView$9.INSTANCE);
        com.hbg.module.libkt.base.ext.b.c(((e1) uh()).C, 0.0f, 0, R$attr.kline_secondary_separator, 3, (Object) null);
        ((e1) uh()).C.addOnScrollListener(new b(this));
        ((e1) uh()).C.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(getActivity()));
        Th().setItems(this.f17270r);
        ((e1) uh()).C.setAdapter(Th());
    }

    public final void ci(int i11) {
        if (i11 == -1) {
            Lh();
        }
        this.f17273u = i11;
        ei((CommunityViewModel) e.f19132a.a(this, CommunityViewModel.class));
        Uh().p0(this.f17273u);
    }

    public final void di(MultiTypeAdapter multiTypeAdapter) {
        this.f17268p = multiTypeAdapter;
    }

    public final void ei(CommunityViewModel communityViewModel) {
        this.f17269q = communityViewModel;
    }

    public final void initData() {
        ei((CommunityViewModel) e.f19132a.a(this, CommunityViewModel.class));
        Uh().j0().observe(this, new c(new CommunityChildFragment$initData$1(this)));
        Uh().l0().observe(this, new c(new CommunityChildFragment$initData$2(this)));
        Uh().n0().observe(this, new c(new CommunityChildFragment$initData$3(this)));
        ((e1) uh()).B.setOnRetryClickListener(new c(this));
        we.b.m("followStatus", (Class) null, 2, (Object) null).observe(this, new c(new CommunityChildFragment$initData$5(this)));
        we.c.b(this, new c(new CommunityChildFragment$initData$6(this)));
    }

    public void initView() {
        if (com.hbg.module.libkt.base.ext.b.e(getActivity())) {
            nc.c.a("app_community_plaza", (HashMap<?, ?>) null);
            Kh((HbgBaseShareProvider) b2.a.d().a("/provider/share/h5").navigation());
            Jh((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());
            bi();
            initData();
            ci(-1);
            we.b.m("dynamicDel", (Class) null, 2, (Object) null).observe(this, new c(new CommunityChildFragment$initView$1(this)));
        }
    }

    public void onResume() {
        super.onResume();
        Jh((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());
        if (!this.f17274v) {
            HbgBaseProvider wh2 = wh();
            boolean z11 = false;
            if (wh2 != null && wh2.n()) {
                z11 = true;
            }
            if (z11) {
                this.f17274v = true;
                ci(-1);
            }
        }
    }
}
