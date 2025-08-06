package com.hbg.module.community.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.module.community.adapter.CommunityEmptyCommonBinder;
import com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder;
import com.hbg.module.community.adapter.CommunityShareCommonBinder;
import com.hbg.module.community.adapter.w;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import com.hbg.module.community.multiadapter.g;
import com.hbg.module.content.R$attr;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.f;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import ky.j;
import lc.g2;
import se.d;

public final class PersonalCenterChildFragment extends BaseFragment<g2> {

    /* renamed from: x  reason: collision with root package name */
    public static final a f17480x = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public int f17481p = 1;

    /* renamed from: q  reason: collision with root package name */
    public String f17482q = "";

    /* renamed from: r  reason: collision with root package name */
    public String f17483r = "";

    /* renamed from: s  reason: collision with root package name */
    public long f17484s;

    /* renamed from: t  reason: collision with root package name */
    public List<CommunityFeedInfo.ListBean> f17485t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    public MultiTypeAdapter f17486u;

    /* renamed from: v  reason: collision with root package name */
    public int f17487v;

    /* renamed from: w  reason: collision with root package name */
    public w f17488w;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final PersonalCenterChildFragment a(PersonalCenterInfo.TabInfo tabInfo, String str, int i11) {
            PersonalCenterChildFragment personalCenterChildFragment = new PersonalCenterChildFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", tabInfo.getTitle());
            bundle.putInt("id", tabInfo.getId());
            bundle.putString("uidUnique", str);
            bundle.putInt("isSelf", i11);
            personalCenterChildFragment.setArguments(bundle);
            return personalCenterChildFragment;
        }
    }

    public static final class b implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f17489b;

        public b(l lVar) {
            this.f17489b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f17489b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f17489b.invoke(obj);
        }
    }

    public static final /* synthetic */ g2 Th(PersonalCenterChildFragment personalCenterChildFragment) {
        return (g2) personalCenterChildFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void bi(PersonalCenterChildFragment personalCenterChildFragment, View view) {
        personalCenterChildFragment.Yh(personalCenterChildFragment.f17483r, personalCenterChildFragment.f17481p, 0, 20, false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Eh() {
        super.Eh();
        d.w();
    }

    public void P8(j jVar) {
        super.P8(jVar);
        Yh(this.f17483r, this.f17481p, this.f17484s, 20, true);
    }

    public final void Yh(String str, int i11, long j11, int i12, boolean z11) {
        Lh();
        RequestExtKt.d(v7.b.a().a0(str, i11, j11, i12), new PersonalCenterChildFragment$getDynamicListInfo$1(this, z11), new PersonalCenterChildFragment$getDynamicListInfo$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final void Zh() {
        if (this.f17487v == 1 && this.f17481p == 1) {
            RequestExtKt.d(v7.b.a().getTaskList(), new PersonalCenterChildFragment$getTaskList$1(this), new PersonalCenterChildFragment$getTaskList$2(this), (MutableLiveData) null, 4, (Object) null);
        }
    }

    /* renamed from: ai */
    public g2 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return g2.K(layoutInflater, viewGroup, false);
    }

    public void bf(j jVar) {
        super.bf(jVar);
        Yh(this.f17483r, this.f17481p, 0, 20, false);
        Zh();
    }

    public void initView() {
        we.b.m("dynamicDel", (Class) null, 2, (Object) null).observe(this, new b(new PersonalCenterChildFragment$initView$1(this)));
    }

    public void onResume() {
        super.onResume();
        if (isVisible() && !TextUtils.isEmpty(this.f17483r)) {
            Yh(this.f17483r, this.f17481p, 0, 20, false);
            Zh();
        }
    }

    public void zh() {
        super.zh();
        Bundle arguments = getArguments();
        MultiTypeAdapter multiTypeAdapter = null;
        String string = arguments != null ? arguments.getString("title") : null;
        String str = "";
        if (string == null) {
            string = str;
        }
        this.f17482q = string;
        this.f17481p = arguments != null ? arguments.getInt("id") : 1;
        String string2 = arguments != null ? arguments.getString("uidUnique") : null;
        if (string2 != null) {
            str = string2;
        }
        this.f17483r = str;
        this.f17487v = arguments != null ? arguments.getInt("isSelf") : 0;
        com.hbg.module.libkt.base.ext.b.c(((g2) uh()).D, 0.0f, 0, R$attr.kline_secondary_separator, 3, (Object) null);
        ((g2) uh()).D.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(getActivity()));
        this.f17486u = new MultiTypeAdapter((List) null, 0, (g) null, 7, (r) null);
        CommunityEmptyCommonBinder communityEmptyCommonBinder = new CommunityEmptyCommonBinder();
        CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder = new CommunityReplyArticleCommonBinder();
        CommunityShareCommonBinder communityShareCommonBinder = new CommunityShareCommonBinder();
        int i11 = this.f17481p;
        communityEmptyCommonBinder.m0(i11);
        communityReplyArticleCommonBinder.m0(i11);
        communityEmptyCommonBinder.k0(true);
        communityReplyArticleCommonBinder.k0(true);
        communityShareCommonBinder.k0(true);
        communityEmptyCommonBinder.l0(new PersonalCenterChildFragment$initBefore$2(this));
        communityReplyArticleCommonBinder.l0(new PersonalCenterChildFragment$initBefore$3(this));
        communityEmptyCommonBinder.j0(new PersonalCenterChildFragment$initBefore$4(this));
        communityReplyArticleCommonBinder.j0(new PersonalCenterChildFragment$initBefore$5(this));
        HbgBaseProvider wh2 = wh();
        if (wh2 != null) {
            communityEmptyCommonBinder.h0(wh2);
            communityReplyArticleCommonBinder.h0(wh2);
            communityShareCommonBinder.h0(wh2);
        }
        HbgBaseShareProvider xh2 = xh();
        if (xh2 != null) {
            communityEmptyCommonBinder.i0(xh2);
            communityReplyArticleCommonBinder.i0(xh2);
            communityShareCommonBinder.i0(xh2);
        }
        MultiTypeAdapter multiTypeAdapter2 = this.f17486u;
        if (multiTypeAdapter2 == null) {
            multiTypeAdapter2 = null;
        }
        multiTypeAdapter2.f(Reflection.b(CommunityFeedInfo.ListBean.class)).a(communityEmptyCommonBinder, communityReplyArticleCommonBinder, communityShareCommonBinder).b(PersonalCenterChildFragment$initBefore$8.INSTANCE);
        ((g2) uh()).G.j0(new SmartRefreshHeader(getActivity()));
        ((g2) uh()).G.h0(new SmartRefreshFooter(getActivity()));
        ((g2) uh()).G.b0(this);
        ((g2) uh()).G.e0(this);
        ((g2) uh()).D.setHasFixedSize(true);
        ((g2) uh()).D.setItemAnimator((RecyclerView.ItemAnimator) null);
        RecyclerView recyclerView = ((g2) uh()).D;
        MultiTypeAdapter multiTypeAdapter3 = this.f17486u;
        if (multiTypeAdapter3 != null) {
            multiTypeAdapter = multiTypeAdapter3;
        }
        recyclerView.setAdapter(multiTypeAdapter);
        ((g2) uh()).D.setNestedScrollingEnabled(true);
        ((g2) uh()).F.setOnRetryClickListener(new m(this));
        ((g2) uh()).G.setNoMoreData(true);
        Yh(this.f17483r, this.f17481p, 0, 20, false);
    }
}
