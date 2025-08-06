package com.huobi.index.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexRecommendLive;
import com.huobi.index.ui.j1;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.r;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;
import we.b;

public class NewsRecommendLiveHandler implements c {

    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f74414a = -1;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IndexRecommendLive f74415b;

        public a(IndexRecommendLive indexRecommendLive) {
            this.f74415b = indexRecommendLive;
        }

        public final boolean a(View view, RecyclerView recyclerView) {
            if (view != null && view.getLeft() >= recyclerView.getLeft() && view.getRight() <= recyclerView.getRight()) {
                return true;
            }
            return false;
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                    if (a(layoutManager.findViewByPosition(findFirstVisibleItemPosition), recyclerView) && findFirstVisibleItemPosition != this.f74414a) {
                        try {
                            this.f74414a = findFirstVisibleItemPosition;
                            LiveDetailBean liveDetailBean = this.f74415b.liveInfoList.get(findFirstVisibleItemPosition);
                            if (liveDetailBean != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("recom_base_info", liveDetailBean.recom_base_info);
                                hashMap.put("liveid", liveDetailBean.f70249id);
                                hashMap.put("title", liveDetailBean.title);
                                hashMap.put("recome_type", "homediscover");
                                g.g("app_community_livecard_view", hashMap);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void d(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("recome_type", "homediscover");
        g.g("app_community_livecard_click", hashMap);
        b.l("home_tab_change", Integer.class).g(3);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, HomeFeedInfoItem homeFeedInfoItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tvTitle);
        textView.setText(textView.getContext().getResources().getString(R.string.n_live));
        RecyclerView recyclerView = (RecyclerView) e11.b(R.id.rvList);
        com.hbg.module.libkt.utils.r.f24939a.g((LinearLayout) e11.b(R.id.llTitleMore), a0.f74431b, 800);
        IndexRecommendLive l11 = homeFeedInfoItem.l();
        if (l11 != null) {
            recyclerView.setLayoutManager(com.hbg.module.libkt.base.ext.b.m(recyclerView.getContext()));
            recyclerView.addOnScrollListener(new a(l11));
            recyclerView.setAdapter(new j1(l11.liveInfoList));
        }
    }

    public int getResId() {
        return R.layout.item_recommend_live;
    }
}
