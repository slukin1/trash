package com.hbg.module.community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import com.hbg.module.content.R$string;
import com.hbg.module.content.adapter.q;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.utils.r;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import kotlin.l;
import lc.i5;

public final class CommunityRecommendLiveBinder extends ItemViewBinder<CommunityFeedInfo.RecommendLiveBean, ItemViewBinder.a<i5>> {

    /* renamed from: e  reason: collision with root package name */
    public HbgBaseProvider f17091e;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17092b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17093c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityRecommendLiveBinder f17094d;

        public a(View view, long j11, CommunityRecommendLiveBinder communityRecommendLiveBinder) {
            this.f17092b = view;
            this.f17093c = j11;
            this.f17094d = communityRecommendLiveBinder;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f17092b) > this.f17093c || (this.f17092b instanceof Checkable)) {
                rVar.e(this.f17092b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f17092b;
                SensorsDataHelper.track("app_community_livecard_click", MapsKt__MapsKt.j(l.a("recome_type", "plazadiscover")));
                HbgBaseProvider q11 = this.f17094d.q();
                if (q11 != null) {
                    q11.p(2);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f17095a = -1;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.RecommendLiveBean f17096b;

        public b(CommunityFeedInfo.RecommendLiveBean recommendLiveBean) {
            this.f17096b = recommendLiveBean;
        }

        public final boolean a(View view, RecyclerView recyclerView) {
            if (view != null && view.getLeft() >= recyclerView.getLeft() && view.getRight() <= recyclerView.getRight()) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
            r8 = (androidx.recyclerview.widget.LinearLayoutManager) r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onScrolled(androidx.recyclerview.widget.RecyclerView r7, int r8, int r9) {
            /*
                r6 = this;
                super.onScrolled(r7, r8, r9)
                androidx.recyclerview.widget.RecyclerView$LayoutManager r8 = r7.getLayoutManager()
                boolean r9 = r8 instanceof androidx.recyclerview.widget.LinearLayoutManager
                if (r9 == 0) goto L_0x0063
                androidx.recyclerview.widget.LinearLayoutManager r8 = (androidx.recyclerview.widget.LinearLayoutManager) r8
                int r9 = r8.findFirstVisibleItemPosition()
                int r0 = r8.findLastVisibleItemPosition()
                if (r9 > r0) goto L_0x0063
            L_0x0017:
                android.view.View r1 = r8.findViewByPosition(r9)
                boolean r1 = r6.a(r1, r7)
                if (r1 == 0) goto L_0x005e
                int r1 = r6.f17095a
                if (r9 == r1) goto L_0x005e
                r6.f17095a = r9
                com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$RecommendLiveBean r1 = r6.f17096b
                java.util.ArrayList<com.hbg.lib.network.hbg.core.bean.LiveDetailBean> r1 = r1.lives
                java.lang.Object r1 = r1.get(r9)
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r1 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r1
                r2 = 3
                kotlin.Pair[] r2 = new kotlin.Pair[r2]
                r3 = 0
                java.lang.String r4 = r1.recom_base_info
                java.lang.String r5 = "recom_base_info"
                kotlin.Pair r4 = kotlin.l.a(r5, r4)
                r2[r3] = r4
                java.lang.String r1 = r1.f70249id
                java.lang.String r3 = "liveid"
                kotlin.Pair r1 = kotlin.l.a(r3, r1)
                r3 = 1
                r2[r3] = r1
                r1 = 2
                java.lang.String r3 = "recome_type"
                java.lang.String r4 = "plazadiscover"
                kotlin.Pair r3 = kotlin.l.a(r3, r4)
                r2[r1] = r3
                java.util.HashMap r1 = kotlin.collections.MapsKt__MapsKt.j(r2)
                java.lang.String r2 = "app_community_livecard_view"
                com.hbg.module.libkt.helper.SensorsDataHelper.track(r2, r1)
            L_0x005e:
                if (r9 == r0) goto L_0x0063
                int r9 = r9 + 1
                goto L_0x0017
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.adapter.CommunityRecommendLiveBinder.b.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
        }
    }

    public final HbgBaseProvider q() {
        return this.f17091e;
    }

    /* renamed from: r */
    public void c(ItemViewBinder.a<i5> aVar, CommunityFeedInfo.RecommendLiveBean recommendLiveBean, boolean z11, int i11) {
        this.f17091e = (HbgBaseProvider) b2.a.d().a("/provider/content").navigation();
        Context context = aVar.e().B.getContext();
        aVar.e().D.setText(context.getResources().getString(R$string.n_live));
        r rVar = r.f24939a;
        LinearLayout linearLayout = aVar.e().B;
        linearLayout.setOnClickListener(new a(linearLayout, 800, this));
        aVar.e().C.setLayoutManager(com.hbg.module.libkt.base.ext.b.m(context));
        aVar.e().C.addOnScrollListener(new b(recommendLiveBean));
        q qVar = new q((FragmentActivity) context);
        qVar.j(recommendLiveBean.lives);
        aVar.e().C.setAdapter(qVar);
    }

    /* renamed from: s */
    public ItemViewBinder.a<i5> m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ItemViewBinder.a<>(i5.K(layoutInflater, viewGroup, false));
    }
}
