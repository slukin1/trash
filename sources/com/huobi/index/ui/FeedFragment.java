package com.huobi.index.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.v;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.common.airdrop.view.AirdropView;
import com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.community.ui.DynamicDetailActivity;
import com.hbg.module.huobi.im.utils.DateUtils;
import com.hbg.module.libkt.custom.MarqueeTextView;
import com.huobi.home.ui.HomeFragment;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.presenter.FeedPresenter;
import com.huobi.index.viewhandler.IndexContractHandler;
import com.huobi.utils.HomeHelper;
import com.huobi.utils.HomeSensorsHelper;
import com.huobi.utils.RecyclerViewExposeUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import kotlin.l;
import pro.huobi.R;
import rd.s;
import sl.f0;

public final class FeedFragment extends BaseFragment<FeedPresenter, FeedPresenter.a> implements FeedPresenter.a {
    public static final a H = new a((r) null);
    public static boolean I;
    public LinearLayout A;
    public LinearLayout B;
    public MarqueeTextView C;
    public TextView D;
    public ImageView E;
    public AirdropView F;
    public boolean G;

    /* renamed from: l  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f73499l;

    /* renamed from: m  reason: collision with root package name */
    public ConsecutiveScrollerLayout f73500m;

    /* renamed from: n  reason: collision with root package name */
    public int f73501n = 1;

    /* renamed from: o  reason: collision with root package name */
    public long f73502o;

    /* renamed from: p  reason: collision with root package name */
    public long f73503p;

    /* renamed from: q  reason: collision with root package name */
    public long f73504q;

    /* renamed from: r  reason: collision with root package name */
    public final long f73505r = 60000;

    /* renamed from: s  reason: collision with root package name */
    public long f73506s;

    /* renamed from: t  reason: collision with root package name */
    public LoadingLayout f73507t;

    /* renamed from: u  reason: collision with root package name */
    public ConstraintLayout f73508u;

    /* renamed from: v  reason: collision with root package name */
    public View f73509v;

    /* renamed from: w  reason: collision with root package name */
    public ImageView f73510w;

    /* renamed from: x  reason: collision with root package name */
    public ImageView f73511x;

    /* renamed from: y  reason: collision with root package name */
    public ImageView f73512y;

    /* renamed from: z  reason: collision with root package name */
    public ImageView f73513z;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final FeedFragment a(int i11) {
            Bundle bundle = new Bundle();
            FeedFragment feedFragment = new FeedFragment();
            bundle.putInt("tabType", i11);
            feedFragment.setArguments(bundle);
            return feedFragment;
        }

        public final void b(boolean z11) {
            FeedFragment.I = z11;
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f73514b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f73515c;

        public b(View view, long j11) {
            this.f73514b = view;
            this.f73515c = j11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            com.hbg.module.libkt.utils.r rVar = com.hbg.module.libkt.utils.r.f24939a;
            if (currentTimeMillis - rVar.b(this.f73514b) > this.f73515c || (this.f73514b instanceof Checkable)) {
                rVar.e(this.f73514b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f73514b;
                gs.g.g("app_community_kxcard_click", MapsKt__MapsKt.j(l.a("recome_type", "homediscover")));
                we.b.l("home_tab_change", Integer.TYPE).g(2);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements MarqueeTextView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List<NewFlashInformation> f73516a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FeedFragment f73517b;

        public c(List<NewFlashInformation> list, FeedFragment feedFragment) {
            this.f73516a = list;
            this.f73517b = feedFragment;
        }

        public void a(int i11) {
            NewFlashInformation newFlashInformation = this.f73516a.get(i11);
            TextView Jh = this.f73517b.D;
            if (Jh != null) {
                Jh.setText(DateUtils.f(this.f73517b.getContext(), newFlashInformation.getIssueTime()));
            }
            gs.g.g("app_community_kxcard_view", MapsKt__MapsKt.j(l.a("recom_base_info", newFlashInformation.recom_base_info), l.a("recome_type", "homediscover")));
        }

        public void onItemClick(int i11) {
            NewFlashInformation newFlashInformation = this.f73516a.get(i11);
            FeedFragment feedFragment = this.f73517b;
            NewFlashInformation newFlashInformation2 = newFlashInformation;
            gs.g.g("app_community_kx_click", MapsKt__MapsKt.j(l.a("recom_base_info", newFlashInformation2.recom_base_info), l.a("recome_type", "homediscover"), l.a("contentid", Long.valueOf(newFlashInformation2.getId())), l.a("title", newFlashInformation2.getTitle())));
            DynamicDetailActivity.a.d(DynamicDetailActivity.H, newFlashInformation2.getDynamicId(), newFlashInformation2.getId(), feedFragment.requireContext(), false, false, 16, (Object) null);
        }
    }

    public static final class d implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f73518b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f73519c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FeedFragment f73520d;

        public d(View view, long j11, FeedFragment feedFragment) {
            this.f73518b = view;
            this.f73519c = j11;
            this.f73520d = feedFragment;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f73518b) > this.f73519c || (this.f73518b instanceof Checkable)) {
                sVar.e(this.f73518b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f73518b;
                if (this.f73520d.getActivity() != null && BaseModuleConfig.a().m0(this.f73520d.getActivity())) {
                    if (wf.a.f40622a.e()) {
                        gc.b.d(gc.b.f19131a, (String) null, (TopicDetailInfo.HeaderInfo) null, (String) null, (String) null, 15, (Object) null);
                        Pair[] pairArr = new Pair[1];
                        if (this.f73520d.f73501n == 1) {
                            str = "homediscover";
                        } else {
                            str = this.f73520d.f73501n == 4 ? "homefollow" : "";
                        }
                        pairArr[0] = l.a("pagename", str);
                        gs.g.i("app_community_fbdj", MapsKt__MapsKt.j(pairArr));
                    } else {
                        gc.b.f();
                    }
                }
            }
            return true;
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f73521b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f73522c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FeedFragment f73523d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveBannerData f73524e;

        public e(View view, long j11, FeedFragment feedFragment, LiveBannerData liveBannerData) {
            this.f73521b = view;
            this.f73522c = j11;
            this.f73523d = feedFragment;
            this.f73524e = liveBannerData;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            com.hbg.module.libkt.utils.r rVar = com.hbg.module.libkt.utils.r.f24939a;
            if (currentTimeMillis - rVar.b(this.f73521b) > this.f73522c || (this.f73521b instanceof Checkable)) {
                rVar.e(this.f73521b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f73521b;
                if (com.hbg.module.libkt.base.ext.b.e(this.f73523d.getActivity())) {
                    Intent intent = new Intent();
                    intent.putExtra("url", this.f73524e.getUrl());
                    intent.setClass(this.f73523d.getActivity(), HBBaseWebActivity.class);
                    this.f73523d.getActivity().startActivity(intent);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d10.l f73525b;

        public f(d10.l lVar) {
            this.f73525b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f73525b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f73525b.invoke(obj);
        }
    }

    public static final class g implements f0.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FeedFragment f73526b;

        public g(FeedFragment feedFragment) {
            this.f73526b = feedFragment;
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f73526b.f73503p == 0) {
                this.f73526b.f73503p = currentTimeMillis;
                this.f73526b.bi();
            } else if (currentTimeMillis - this.f73526b.f73503p > 1000) {
                this.f73526b.f73503p = currentTimeMillis;
                this.f73526b.bi();
            }
        }
    }

    @SensorsDataInstrumented
    public static final void Th(FeedFragment feedFragment, View view) {
        if (feedFragment.yh() != null) {
            ((FeedPresenter) feedFragment.yh()).g0(v.a(feedFragment), feedFragment.f73501n, 0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Vh(FeedFragment feedFragment, View view, int i11, int i12, int i13) {
        i6.d.c("ray22", " scrollY : " + i11 + " oldScrollY : " + i12);
        EasyRecyclerView<s9.a> easyRecyclerView = feedFragment.f73499l;
        if (easyRecyclerView != null && easyRecyclerView.getLayoutManager() != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) feedFragment.f73499l.getLayoutManager();
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            int itemCount = linearLayoutManager.getItemCount();
            i6.d.c("ray22", " lastVisibleItem : " + findLastCompletelyVisibleItemPosition + "count : " + itemCount + "---scrollState=" + i13);
            int i14 = itemCount - findLastCompletelyVisibleItemPosition;
            long currentTimeMillis = System.currentTimeMillis();
            if (i11 - i12 > 1 && i14 < 14 && itemCount > 5) {
                long j11 = feedFragment.f73502o;
                if (j11 == 0) {
                    feedFragment.f73502o = currentTimeMillis;
                    ((FeedPresenter) feedFragment.yh()).i0(2, feedFragment.f73501n);
                    gs.g.g("app_news_rechome_nrkpsl", HomeSensorsHelper.b(feedFragment.f73501n));
                } else if (currentTimeMillis - j11 > 1000) {
                    feedFragment.f73502o = currentTimeMillis;
                    ((FeedPresenter) feedFragment.yh()).i0(2, feedFragment.f73501n);
                    gs.g.g("app_news_rechome_nrkpsl", HomeSensorsHelper.b(feedFragment.f73501n));
                }
            }
        }
    }

    public static final void Xh(FeedFragment feedFragment, boolean z11, int i11) {
        Log.i("ItemExpose", "visible=" + z11 + "---position=" + i11);
        HomeHelper.m(feedFragment.f73499l, i11);
    }

    public void F9(ArrayList<LiveBannerData> arrayList) {
        ImageView imageView;
        ConstraintLayout constraintLayout = this.f73508u;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        View view = this.f73509v;
        if (view != null) {
            view.setVisibility(0);
        }
        int i11 = 4;
        if (arrayList.size() <= 4) {
            i11 = arrayList.size();
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 == 0) {
                imageView = this.f73510w;
            } else if (i12 == 1) {
                imageView = this.f73511x;
            } else if (i12 != 2) {
                imageView = this.f73513z;
            } else {
                imageView = this.f73512y;
            }
            Zh(imageView, arrayList.get(i12));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = (r0 = r0.f0()).f73305g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H8() {
        /*
            r6 = this;
            com.hbg.lib.common.mvp.BaseFragmentPresenter r0 = r6.yh()
            com.huobi.index.presenter.FeedPresenter r0 = (com.huobi.index.presenter.FeedPresenter) r0
            if (r0 == 0) goto L_0x0015
            com.huobi.index.helper.data.NewFeedModule r0 = r0.f0()
            if (r0 == 0) goto L_0x0015
            com.hbg.lib.network.hbg.core.bean.NewFeed r0 = r0.f73305g
            if (r0 == 0) goto L_0x0015
            java.util.List<com.hbg.lib.network.hbg.core.bean.NewFlashInformation> r0 = r0.newsflashList
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            boolean r1 = com.hbg.module.libkt.base.ext.b.w(r0)
            if (r1 != 0) goto L_0x0080
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r0.iterator()
        L_0x0025:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0039
            java.lang.Object r3 = r2.next()
            com.hbg.lib.network.hbg.core.bean.NewFlashInformation r3 = (com.hbg.lib.network.hbg.core.bean.NewFlashInformation) r3
            java.lang.String r3 = r3.getTitle()
            r1.add(r3)
            goto L_0x0025
        L_0x0039:
            android.widget.LinearLayout r2 = r6.B
            if (r2 == 0) goto L_0x0049
            com.hbg.module.libkt.utils.r r3 = com.hbg.module.libkt.utils.r.f24939a
            r3 = 800(0x320, double:3.953E-321)
            com.huobi.index.ui.FeedFragment$b r5 = new com.huobi.index.ui.FeedFragment$b
            r5.<init>(r2, r3)
            r2.setOnClickListener(r5)
        L_0x0049:
            com.hbg.module.libkt.custom.MarqueeTextView r2 = r6.C
            if (r2 == 0) goto L_0x0050
            r2.setDatas(r1)
        L_0x0050:
            android.widget.TextView r1 = r6.D
            r2 = 0
            if (r1 != 0) goto L_0x0056
            goto L_0x006b
        L_0x0056:
            android.content.Context r3 = r6.getContext()
            java.lang.Object r4 = r0.get(r2)
            com.hbg.lib.network.hbg.core.bean.NewFlashInformation r4 = (com.hbg.lib.network.hbg.core.bean.NewFlashInformation) r4
            long r4 = r4.getIssueTime()
            java.lang.String r3 = com.hbg.module.huobi.im.utils.DateUtils.f(r3, r4)
            r1.setText(r3)
        L_0x006b:
            com.hbg.module.libkt.custom.MarqueeTextView r1 = r6.C
            if (r1 == 0) goto L_0x0077
            com.huobi.index.ui.FeedFragment$c r3 = new com.huobi.index.ui.FeedFragment$c
            r3.<init>(r0, r6)
            r1.setMarqueeListener(r3)
        L_0x0077:
            android.widget.LinearLayout r0 = r6.A
            if (r0 != 0) goto L_0x007c
            goto L_0x008a
        L_0x007c:
            r0.setVisibility(r2)
            goto L_0x008a
        L_0x0080:
            android.widget.LinearLayout r0 = r6.A
            if (r0 != 0) goto L_0x0085
            goto L_0x008a
        L_0x0085:
            r1 = 8
            r0.setVisibility(r1)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.ui.FeedFragment.H8():void");
    }

    /* renamed from: Nh */
    public FeedPresenter xh() {
        return new FeedPresenter();
    }

    public final int Oh() {
        return this.f73501n;
    }

    public final EasyRecyclerView<s9.a> Ph() {
        return this.f73499l;
    }

    /* renamed from: Qh */
    public FeedPresenter.a zh() {
        return this;
    }

    public final void Rh(boolean z11) {
        AirdropView airdropView;
        if (this.G != z11) {
            this.G = z11;
            if (z11) {
                gs.g.i("app_community_homepage_find_tab", new HashMap());
            }
        }
        if (this.f73501n == 1 && (airdropView = this.F) != null) {
            airdropView.s(z11);
        }
    }

    public final void Sh() {
        LoadingLayout loadingLayout = this.f73507t;
        if (loadingLayout == null) {
            loadingLayout = null;
        }
        loadingLayout.setOnRetryClickListener(new a(this));
    }

    public final void Uh() {
        ConsecutiveScrollerLayout consecutiveScrollerLayout = this.f73500m;
        if (consecutiveScrollerLayout != null) {
            consecutiveScrollerLayout.setOnVerticalScrollChangeListener(new b(this));
        }
    }

    public final void Wh() {
        ((FeedPresenter) yh()).c0().observe(getViewLifecycleOwner(), new f(new FeedFragment$initObserver$1(this)));
        ((FeedPresenter) yh()).d0().observe(getViewLifecycleOwner(), new f(new FeedFragment$initObserver$2(this)));
    }

    public final boolean Yh() {
        if (getParentFragment() instanceof IndexFragment) {
            return ((IndexFragment) getParentFragment()).Ek();
        }
        if (getParentFragment() instanceof HomeFragment) {
            return ((HomeFragment) getParentFragment()).ji();
        }
        return true;
    }

    public final void Zh(ImageView imageView, LiveBannerData liveBannerData) {
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        com.hbg.module.libkt.base.ext.b.B(imageView, liveBannerData.getImgUrl());
        if (imageView != null) {
            com.hbg.module.libkt.utils.r rVar = com.hbg.module.libkt.utils.r.f24939a;
            imageView.setOnClickListener(new e(imageView, 800, this, liveBannerData));
        }
    }

    public void afterInit() {
        super.afterInit();
        Log.i("yananf", "----afterInit");
    }

    public final void ai(int i11) {
        v9.a adapter;
        List c11;
        int i12 = 0;
        if (i11 == 0) {
            ConsecutiveScrollerLayout consecutiveScrollerLayout = this.f73500m;
            if (consecutiveScrollerLayout != null) {
                consecutiveScrollerLayout.scrollTo(0, 0);
            }
            EasyRecyclerView<s9.a> easyRecyclerView = this.f73499l;
            if (easyRecyclerView != null) {
                easyRecyclerView.scrollToPosition(0);
            }
        }
        if (this.f73501n == 1) {
            EasyRecyclerView<s9.a> easyRecyclerView2 = this.f73499l;
            if (!(easyRecyclerView2 == null || (adapter = easyRecyclerView2.getAdapter()) == null || (c11 = adapter.c()) == null)) {
                i12 = c11.size();
            }
            if (i12 > 0) {
                if (yh() != null) {
                    ((FeedPresenter) yh()).i0(i11, this.f73501n);
                }
            } else if (yh() != null) {
                ((FeedPresenter) yh()).g0(v.a(this), this.f73501n, i11);
            }
        } else if (yh() != null) {
            ((FeedPresenter) yh()).i0(i11, this.f73501n);
        }
    }

    public final void bi() {
        EasyRecyclerView<s9.a> easyRecyclerView;
        if (!Yh() && (easyRecyclerView = this.f73499l) != null && easyRecyclerView.getAdapter() != null && HomeHelper.b(this.f73499l).booleanValue()) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f73499l.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            List c11 = this.f73499l.getAdapter().c();
            if (c11 != null && (!c11.isEmpty()) && findLastVisibleItemPosition < c11.size() && findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                while (true) {
                    HomeFeedInfoItem homeFeedInfoItem = findLastVisibleItemPosition < c11.size() ? (HomeFeedInfoItem) c11.get(findLastVisibleItemPosition) : null;
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f73499l.findViewHolderForAdapterPosition(findLastVisibleItemPosition);
                    if (findViewHolderForAdapterPosition != null) {
                        HomeFeedInfoItem homeFeedInfoItem2 = (HomeFeedInfoItem) c11.get(findLastVisibleItemPosition);
                        if (homeFeedInfoItem != null && homeFeedInfoItem.f73156g == 100 && findLastVisibleItemPosition < c11.size()) {
                            new IndexContractHandler().h(findViewHolderForAdapterPosition.itemView, homeFeedInfoItem2);
                        }
                    }
                    if (findLastVisibleItemPosition != findFirstVisibleItemPosition) {
                        findLastVisibleItemPosition--;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void ci() {
        if (getParentFragment() instanceof IndexFragment) {
            ((IndexFragment) getParentFragment()).Wl();
            ((IndexFragment) getParentFragment()).Nl();
        } else if (getParentFragment() instanceof HomeFragment) {
            ((HomeFragment) getParentFragment()).ti();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void di(List<? extends s9.a> list, int i11, int i12, boolean z11) {
        if (list != null && (!list.isEmpty())) {
            List<s9.a> dataList = this.f73499l.getDataList();
            EasyRecyclerView<s9.a> easyRecyclerView = this.f73499l;
            if (easyRecyclerView == null || easyRecyclerView.getAdapter() == null || dataList == null || !(!dataList.isEmpty())) {
                this.f73499l.setData(list);
            } else {
                int size = dataList.size();
                if (i11 == 0) {
                    if (this.f73501n == 1) {
                        this.f73499l.getAdapter().notifyItemRangeChanged(0, i12);
                    } else {
                        this.f73499l.getAdapter().notifyDataSetChanged();
                    }
                } else if (size <= i12 || z11) {
                    this.f73499l.getAdapter().notifyDataSetChanged();
                } else {
                    this.f73499l.getAdapter().notifyItemRangeChanged(size - i12, size);
                }
            }
        }
        ci();
    }

    public final void ei() {
        int i11 = this.f73501n;
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 5) {
            f0 g11 = f0.g();
            g11.e("HOME_FEED" + this.f73501n, new g(this));
            f0.g().i();
        }
    }

    public final void fi(int i11) {
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = this.f73504q;
        if (j11 == 0 || currentTimeMillis - j11 >= this.f73505r * ((long) 3)) {
            this.f73504q = currentTimeMillis;
            if (yh() != null) {
                ((FeedPresenter) yh()).i0(i11, this.f73501n);
            }
            gs.g.g("app_recome_tab_click", HomeSensorsHelper.b(this.f73501n));
        }
    }

    public void finishLoading() {
        ci();
    }

    public final void gi() {
        int i11 = this.f73501n;
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 5) {
            f0 g11 = f0.g();
            g11.j("HOME_FEED" + this.f73501n);
            f0.g().n();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void initView() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f73501n = ((Integer) arguments.get("tabType")).intValue();
        }
        AirdropView airdropView = (AirdropView) this.f67460i.b(R.id.airdropView);
        this.F = airdropView;
        int i11 = this.f73501n;
        if (i11 == 4) {
            ((FeedPresenter) yh()).j0();
        } else if (i11 == 1 && airdropView != null) {
            airdropView.q(requireActivity());
        }
        LoadingLayout loadingLayout = (LoadingLayout) this.f67460i.b(R.id.contentLoadingView);
        this.f73507t = loadingLayout;
        if (loadingLayout == null) {
            loadingLayout = null;
        }
        loadingLayout.p();
        LoadingLayout loadingLayout2 = this.f73507t;
        if (loadingLayout2 == null) {
            loadingLayout2 = null;
        }
        loadingLayout2.setVisibility(0);
        Wh();
        ((FeedPresenter) yh()).g0(v.a(this), this.f73501n, 0);
        this.f73500m = (ConsecutiveScrollerLayout) this.f67460i.b(R.id.scrollerLayout);
        EasyRecyclerView<s9.a> easyRecyclerView = (EasyRecyclerView) this.f67460i.b(R.id.index_information_rv);
        this.f73499l = easyRecyclerView;
        com.hbg.module.libkt.base.ext.b.c(easyRecyclerView, 0.0f, 0, R.attr.kline_secondary_separator, 3, (Object) null);
        ImageView imageView = (ImageView) this.f67460i.b(R.id.btnPublished);
        this.E = imageView;
        if (imageView != null) {
            s sVar = s.f23381a;
            imageView.setOnTouchListener(new d(imageView, 800, this));
        }
        this.A = (LinearLayout) this.f67460i.b(R.id.llHomeRecommendNews);
        this.B = (LinearLayout) this.f67460i.b(R.id.llMoreNewsFlash);
        this.C = (MarqueeTextView) this.f67460i.b(R.id.mtvTitles);
        this.D = (TextView) this.f67460i.b(R.id.tvNewsTime);
        Uh();
        this.f73504q = System.currentTimeMillis();
        Sh();
        new RecyclerViewExposeUtil().f(this.f73499l, new c(this));
        EasyRecyclerView<s9.a> easyRecyclerView2 = this.f73499l;
        if (easyRecyclerView2 != null) {
            easyRecyclerView2.setItemAnimator((RecyclerView.ItemAnimator) null);
        }
        this.f73508u = (ConstraintLayout) this.f67460i.b(R.id.clRank);
        this.f73509v = this.f67460i.b(R.id.vRankLine);
        this.f73510w = (ImageView) this.f67460i.b(R.id.ivRank01);
        this.f73511x = (ImageView) this.f67460i.b(R.id.ivRank02);
        this.f73512y = (ImageView) this.f67460i.b(R.id.ivRank03);
        this.f73513z = (ImageView) this.f67460i.b(R.id.ivRank04);
        we.c.b(this, new f(new FeedFragment$initView$4(this)));
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initView();
    }

    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (this.f73501n == 1 && yh() != null) {
            ((FeedPresenter) yh()).k0();
        }
        i6.d.i("feedFragment---onHiddenChanged=hidden=" + z11);
    }

    public void onStart() {
        super.onStart();
        i6.d.i("feedFragment---onStart");
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f73501n == 1) {
            long j11 = this.f73506s;
            if (j11 > 0 && Math.abs(currentTimeMillis - j11) >= this.f73505r * ((long) 10)) {
                ((FeedPresenter) yh()).i0(0, this.f73501n);
                this.f73506s = currentTimeMillis;
            }
        }
    }

    public void onStop() {
        super.onStop();
        if (this.f73501n == 1 && yh() != null) {
            ((FeedPresenter) yh()).k0();
        }
        i6.d.i("feedFragment---onStop");
        if (this.f73501n == 1) {
            this.f73506s = System.currentTimeMillis();
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home_feed, viewGroup, false);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        i6.d.i("feedFragment---onVisibleChangedFinal visible:" + z11 + "  tabType:" + this.f73501n);
        MarqueeTextView marqueeTextView = this.C;
        if (marqueeTextView != null) {
            marqueeTextView.i(z11);
        }
        if (z11) {
            ei();
        } else {
            gi();
        }
    }
}
