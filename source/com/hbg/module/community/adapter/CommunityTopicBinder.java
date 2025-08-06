package com.hbg.module.community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import com.hbg.module.community.multiadapter.g;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.provider.HbgBaseContentProvider;
import com.hbg.module.libkt.utils.m;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.l;
import lc.u3;
import nc.c;
import rd.s;

public final class CommunityTopicBinder extends ItemViewBinder<CommunityFeedInfo.TopicListBean, ItemViewBinder.a<u3>> {

    /* renamed from: e  reason: collision with root package name */
    public MultiTypeAdapter f17152e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayoutManager f17153f;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17154b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17155c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityTopicBinder f17156d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemViewBinder.a f17157e;

        public a(View view, long j11, CommunityTopicBinder communityTopicBinder, ItemViewBinder.a aVar) {
            this.f17154b = view;
            this.f17155c = j11;
            this.f17156d = communityTopicBinder;
            this.f17157e = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17154b) > this.f17155c || (this.f17154b instanceof Checkable)) {
                sVar.e(this.f17154b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f17154b;
                Pair[] pairArr = new Pair[2];
                String j11 = this.f17156d.j();
                if (j11 == null) {
                    j11 = "";
                }
                pairArr[0] = l.a("TransPair_current_id", j11);
                pairArr[1] = l.a("markets_kline_class", k.a(this.f17156d.k(), this.f17156d.l()));
                c.a("app_community_htgd", MapsKt__MapsKt.j(pairArr));
                try {
                    ((HbgBaseContentProvider) b2.a.d().a("/provider/content/jump").navigation()).l(this.f17157e.itemView.getContext(), 0, "");
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: q */
    public void c(ItemViewBinder.a<u3> aVar, CommunityFeedInfo.TopicListBean topicListBean, boolean z11, int i11) {
        Context context = aVar.e().getRoot().getContext();
        if (this.f17152e == null) {
            this.f17153f = b.t(context);
            aVar.e().C.setLayoutManager(this.f17153f);
            this.f17152e = new MultiTypeAdapter((List) null, 0, (g) null, 7, (r) null);
            CommunityTopicItemBinder communityTopicItemBinder = new CommunityTopicItemBinder();
            communityTopicItemBinder.o(j());
            communityTopicItemBinder.p(k());
            MultiTypeAdapter multiTypeAdapter = this.f17152e;
            if (multiTypeAdapter != null) {
                multiTypeAdapter.h(CommunityFeedInfo.Topic.class, communityTopicItemBinder);
            }
        }
        MultiTypeAdapter multiTypeAdapter2 = this.f17152e;
        int i12 = 0;
        if (multiTypeAdapter2 != null) {
            multiTypeAdapter2.setItems(topicListBean.getTopic().size() > 5 ? topicListBean.getTopic().subList(0, 5) : topicListBean.getTopic());
        }
        aVar.e().B.setVisibility(topicListBean.getFrom() == 1 ? 8 : 0);
        View root = aVar.e().getRoot();
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (topicListBean.getFrom() != 1) {
            i12 = m.a(16);
        }
        marginLayoutParams.topMargin = i12;
        root.setLayoutParams(layoutParams);
        aVar.e().C.setAdapter(this.f17152e);
        s sVar = s.f23381a;
        LinearLayout linearLayout = aVar.e().B;
        linearLayout.setOnClickListener(new a(linearLayout, 800, this, aVar));
    }

    /* renamed from: r */
    public ItemViewBinder.a<u3> m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ItemViewBinder.a<>(u3.K(layoutInflater, viewGroup, false));
    }
}
