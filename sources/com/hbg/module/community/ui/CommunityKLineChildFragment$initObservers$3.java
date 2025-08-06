package com.hbg.module.community.ui;

import android.view.View;
import android.widget.Checkable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.hbg.core.bean.CommonPkData;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.module.community.adapter.k;
import com.hbg.module.content.R$id;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import gc.b;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import nc.c;
import rd.s;

public final class CommunityKLineChildFragment$initObservers$3 extends Lambda implements l<CommunityFeedInfo, Unit> {
    public final /* synthetic */ CommunityKLineChildFragment this$0;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17304b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17305c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f17306d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityKLineChildFragment f17307e;

        public a(View view, long j11, HashMap hashMap, CommunityKLineChildFragment communityKLineChildFragment) {
            this.f17304b = view;
            this.f17305c = j11;
            this.f17306d = hashMap;
            this.f17307e = communityKLineChildFragment;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17304b) > this.f17305c || (this.f17304b instanceof Checkable)) {
                sVar.e(this.f17304b, currentTimeMillis);
                if (wf.a.f40622a.e()) {
                    c.a("app_kLine_commentTab_publish_click", this.f17306d);
                    b.d(b.f19131a, (String) null, (TopicDetailInfo.HeaderInfo) null, this.f17307e.f17295s, this.f17307e.f17296t, 3, (Object) null);
                } else {
                    b.f();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityKLineChildFragment$initObservers$3(CommunityKLineChildFragment communityKLineChildFragment) {
        super(1);
        this.this$0 = communityKLineChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommunityFeedInfo) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommunityFeedInfo communityFeedInfo) {
        if (communityFeedInfo != null && ((communityFeedInfo.getTopic() != null && communityFeedInfo.getTopic().size() != 0) || (communityFeedInfo.getList() != null && communityFeedInfo.getList().size() != 0))) {
            CommunityKLineChildFragment.Th(this.this$0).B.g();
            if (this.this$0.ci() == 1 || this.this$0.ci() == -1) {
                this.this$0.bi().clear();
                CommunityFeedInfo.TopicListBean topicListBean = new CommunityFeedInfo.TopicListBean();
                if (communityFeedInfo.getTopic() != null && communityFeedInfo.getTopic().size() > 0) {
                    topicListBean.setTopic(communityFeedInfo.getTopic());
                    topicListBean.setFrom(1);
                    this.this$0.bi().add(topicListBean);
                }
                if (communityFeedInfo.getVote() != null) {
                    CommonPkData vote = communityFeedInfo.getVote();
                    topicListBean.setHasVote(true);
                    this.this$0.bi().add(vote);
                }
                if (communityFeedInfo.getList() != null && communityFeedInfo.getList().size() > 0) {
                    this.this$0.bi().addAll(communityFeedInfo.getList());
                }
            }
            this.this$0.ai().notifyDataSetChanged();
        } else if (this.this$0.ci() == 1 || this.this$0.ci() == -1) {
            CommunityKLineChildFragment.Th(this.this$0).B.i();
            HashMap hashMap = new HashMap();
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, this.this$0.f17295s);
            hashMap.put("TransPair_current_id", this.this$0.f17295s);
            hashMap.put("markets_kline_class", k.a(this.this$0.f17297u, this.this$0.f17298v));
            c.a("app_kLine_commentTab_publish_show", hashMap);
            try {
                s sVar = s.f23381a;
                View findViewById = CommunityKLineChildFragment.Th(this.this$0).B.findViewById(R$id.tvPublish);
                findViewById.setOnClickListener(new a(findViewById, 800, hashMap, this.this$0));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        CommunityKLineChildFragment.Th(this.this$0).D.finishRefresh();
        CommunityKLineChildFragment.Th(this.this$0).D.w();
        this.this$0.sh();
    }
}
