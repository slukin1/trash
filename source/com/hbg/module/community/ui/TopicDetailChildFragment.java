package com.hbg.module.community.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.adapter.CommunityEmptyCommonBinder;
import com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder;
import com.hbg.module.community.adapter.CommunityShareCommonBinder;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import com.hbg.module.community.multiadapter.g;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.huochat.community.base.CommunityConstants;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.f;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;
import ky.j;
import lc.k2;
import org.json.JSONObject;

public final class TopicDetailChildFragment extends BaseFragment<k2> {

    /* renamed from: x  reason: collision with root package name */
    public static final a f17537x = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public int f17538p = 1;

    /* renamed from: q  reason: collision with root package name */
    public String f17539q = "";

    /* renamed from: r  reason: collision with root package name */
    public int f17540r = -1;

    /* renamed from: s  reason: collision with root package name */
    public long f17541s;

    /* renamed from: t  reason: collision with root package name */
    public int f17542t;

    /* renamed from: u  reason: collision with root package name */
    public List<CommunityFeedInfo.ListBean> f17543u = new ArrayList();

    /* renamed from: v  reason: collision with root package name */
    public MultiTypeAdapter f17544v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f17545w;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final TopicDetailChildFragment a(int i11, int i12) {
            TopicDetailChildFragment topicDetailChildFragment = new TopicDetailChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("tabId", i11);
            bundle.putInt(CommunityConstants.TOPIC_ID, i12);
            topicDetailChildFragment.setArguments(bundle);
            return topicDetailChildFragment;
        }
    }

    public static final class b implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f17546b;

        public b(l lVar) {
            this.f17546b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f17546b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f17546b.invoke(obj);
        }
    }

    public static final /* synthetic */ k2 Th(TopicDetailChildFragment topicDetailChildFragment) {
        return (k2) topicDetailChildFragment.uh();
    }

    public static /* synthetic */ void Xh(TopicDetailChildFragment topicDetailChildFragment, int i11, int i12, long j11, int i13, int i14, Object obj) {
        if ((i14 & 8) != 0) {
            i13 = 1;
        }
        topicDetailChildFragment.Wh(i11, i12, j11, i13);
    }

    @SensorsDataInstrumented
    public static final void Zh(TopicDetailChildFragment topicDetailChildFragment, View view) {
        Xh(topicDetailChildFragment, topicDetailChildFragment.f17540r, topicDetailChildFragment.f17538p, 0, 0, 8, (Object) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void P8(j jVar) {
        super.P8(jVar);
        Wh(this.f17540r, this.f17538p, this.f17541s, 2);
    }

    public final void Wh(int i11, int i12, long j11, int i13) {
        d9.a<List<CommunityFeedInfo.ListBean>> aVar;
        Lh();
        HashMap hashMap = new HashMap();
        JSONObject presetProperties = SensorsDataAPI.sharedInstance().getPresetProperties();
        if (presetProperties != null) {
            Iterator<String> keys = presetProperties.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = presetProperties.opt(next);
                if (opt != null) {
                    hashMap.put(new Regex("\\$").replace((CharSequence) next, ""), opt);
                }
            }
        }
        hashMap.put("frompage", "huobi_pro");
        hashMap.put("orgpage", "topic");
        if (i13 == 1) {
            this.f17542t = 0;
        } else {
            this.f17542t += 20;
        }
        Map l11 = MapsKt__MapsKt.l(kotlin.l.a("requestId", UUID.randomUUID().toString()), kotlin.l.a(CommunityConstants.TOPIC_ID, Integer.valueOf(i11)), kotlin.l.a("actionType", Integer.valueOf(i13)), kotlin.l.a("requestNum", 20), kotlin.l.a("lastTime", Long.valueOf(j11)), kotlin.l.a("realtimeFeastures", hashMap), kotlin.l.a("showNum", Integer.valueOf(this.f17542t)));
        if (i12 == 1) {
            aVar = v7.b.a().getTopicDetailNewestList(l11);
        } else {
            aVar = v7.b.a().getTopicDetailHotList(l11);
        }
        RequestExtKt.d(aVar, new TopicDetailChildFragment$getDynamicListInfo$1(this, i13), new TopicDetailChildFragment$getDynamicListInfo$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    /* renamed from: Yh */
    public k2 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return k2.K(layoutInflater, viewGroup, false);
    }

    public final void ai() {
        ((k2) uh()).D.t();
    }

    public void bf(j jVar) {
        super.bf(jVar);
        ((k2) uh()).D.g(true);
        ((k2) uh()).D.setNoMoreData(false);
        Xh(this, this.f17540r, this.f17538p, 0, 0, 8, (Object) null);
    }

    public void initView() {
        we.b.m("dynamicDel", (Class) null, 2, (Object) null).observe(this, new b(new TopicDetailChildFragment$initView$1(this)));
        we.b.m("followStatus", (Class) null, 2, (Object) null).observe(this, new b(new TopicDetailChildFragment$initView$2(this)));
    }

    public void zh() {
        super.zh();
        Bundle arguments = getArguments();
        MultiTypeAdapter multiTypeAdapter = null;
        String string = arguments != null ? arguments.getString("title") : null;
        if (string == null) {
            string = "";
        }
        this.f17539q = string;
        boolean z11 = true;
        this.f17538p = arguments != null ? arguments.getInt("tabId") : 1;
        this.f17540r = arguments != null ? arguments.getInt(CommunityConstants.TOPIC_ID) : -1;
        ((k2) uh()).B.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(getActivity()));
        this.f17544v = new MultiTypeAdapter((List) null, 0, (g) null, 7, (r) null);
        CommunityEmptyCommonBinder communityEmptyCommonBinder = new CommunityEmptyCommonBinder();
        CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder = new CommunityReplyArticleCommonBinder();
        CommunityShareCommonBinder communityShareCommonBinder = new CommunityShareCommonBinder();
        int i11 = this.f17538p;
        communityEmptyCommonBinder.m0(i11);
        communityReplyArticleCommonBinder.m0(i11);
        communityEmptyCommonBinder.l0(new TopicDetailChildFragment$initBefore$2(this));
        communityReplyArticleCommonBinder.l0(new TopicDetailChildFragment$initBefore$3(this));
        communityEmptyCommonBinder.j0(new TopicDetailChildFragment$initBefore$4(this));
        communityReplyArticleCommonBinder.j0(new TopicDetailChildFragment$initBefore$5(this));
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
        MultiTypeAdapter multiTypeAdapter2 = this.f17544v;
        if (multiTypeAdapter2 == null) {
            multiTypeAdapter2 = null;
        }
        multiTypeAdapter2.f(Reflection.b(CommunityFeedInfo.ListBean.class)).a(communityEmptyCommonBinder, communityReplyArticleCommonBinder, communityShareCommonBinder).b(TopicDetailChildFragment$initBefore$8.INSTANCE);
        ((k2) uh()).D.j0(new SmartRefreshHeader(getActivity()));
        ((k2) uh()).D.h0(new SmartRefreshFooter(getActivity()));
        ((k2) uh()).D.b0(this);
        ((k2) uh()).D.e0(this);
        ((k2) uh()).B.setHasFixedSize(true);
        ((k2) uh()).B.setItemAnimator((RecyclerView.ItemAnimator) null);
        RecyclerView recyclerView = ((k2) uh()).B;
        MultiTypeAdapter multiTypeAdapter3 = this.f17544v;
        if (multiTypeAdapter3 != null) {
            multiTypeAdapter = multiTypeAdapter3;
        }
        recyclerView.setAdapter(multiTypeAdapter);
        ((k2) uh()).B.setNestedScrollingEnabled(true);
        ((k2) uh()).C.setOnRetryClickListener(new q(this));
        HbgBaseProvider wh3 = wh();
        if (wh3 == null || !wh3.n()) {
            z11 = false;
        }
        this.f17545w = z11;
        Xh(this, this.f17540r, this.f17538p, 0, 0, 8, (Object) null);
    }
}
