package com.hbg.module.livesquare.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.GridLayoutManager;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.network.hbg.core.bean.LiveSquareContentData;
import com.hbg.lib.network.hbg.core.bean.LiveSquareSubData;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.livesquare.adapter.CategoryListAdapter;
import com.hbg.module.livesquare.viewmodel.LiveListViewModel;
import com.hbg.module.livesquare.viewmodel.LivePlaybackViewModel;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.f;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import ky.j;
import lc.u1;

public final class LiveCategoryListFragment extends BaseFragment<u1> {

    /* renamed from: v  reason: collision with root package name */
    public static final a f26573v = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public LiveListViewModel f26574p;

    /* renamed from: q  reason: collision with root package name */
    public LivePlaybackViewModel f26575q;

    /* renamed from: r  reason: collision with root package name */
    public ArrayList<LiveSquareBaseData> f26576r = new ArrayList<>();

    /* renamed from: s  reason: collision with root package name */
    public int f26577s = 2;

    /* renamed from: t  reason: collision with root package name */
    public int f26578t = -1;

    /* renamed from: u  reason: collision with root package name */
    public CategoryListAdapter f26579u;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveCategoryListFragment f26580a;

        public b(LiveCategoryListFragment liveCategoryListFragment) {
            this.f26580a = liveCategoryListFragment;
        }

        public int getSpanSize(int i11) {
            if (this.f26580a.Vh() == null || this.f26580a.Vh().getItemViewType(i11) == 4) {
                return 1;
            }
            return 2;
        }
    }

    public static final class c implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f26581b;

        public c(l lVar) {
            this.f26581b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f26581b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f26581b.invoke(obj);
        }
    }

    public static final /* synthetic */ u1 Sh(LiveCategoryListFragment liveCategoryListFragment) {
        return (u1) liveCategoryListFragment.uh();
    }

    public static /* synthetic */ void Zh(LiveCategoryListFragment liveCategoryListFragment, List list, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z11 = true;
        }
        liveCategoryListFragment.Yh(list, i11, z11);
    }

    @SensorsDataInstrumented
    public static final void bi(LiveCategoryListFragment liveCategoryListFragment, View view) {
        LiveListViewModel liveListViewModel = liveCategoryListFragment.f26574p;
        if (liveListViewModel != null) {
            liveListViewModel.i0(liveCategoryListFragment.f26578t);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        this.f26578t = arguments != null ? arguments.getInt("selCategoryId") : -1;
    }

    public void P8(j jVar) {
        super.P8(jVar);
        LivePlaybackViewModel livePlaybackViewModel = this.f26575q;
        if (livePlaybackViewModel != null) {
            livePlaybackViewModel.i0(this.f26577s, this.f26578t);
        }
    }

    public final ArrayList<LiveSquareBaseData> Uh() {
        return this.f26576r;
    }

    public final CategoryListAdapter Vh() {
        return this.f26579u;
    }

    public final int Wh() {
        return this.f26577s;
    }

    /* renamed from: Xh */
    public u1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return u1.K(layoutInflater, viewGroup, false);
    }

    public final void Yh(List<? extends LiveSquareBaseData> list, int i11, boolean z11) {
        if (!com.hbg.module.libkt.base.ext.b.w(list)) {
            if (z11) {
                LiveSquareBaseData liveSquareBaseData = new LiveSquareBaseData();
                liveSquareBaseData.setModuleType(i11);
                liveSquareBaseData.setViewType(2);
                this.f26576r.add(liveSquareBaseData);
            }
            int i12 = 0;
            if (list != null) {
                for (LiveSquareBaseData liveSquareBaseData2 : list) {
                    liveSquareBaseData2.setModuleType(i11);
                    int i13 = 3;
                    if (i11 == 5) {
                        i13 = 8;
                    } else if ((list.size() > 1 || !z11) && (i12 != 0 || !z11)) {
                        i13 = 4;
                    }
                    liveSquareBaseData2.setViewType(i13);
                    liveSquareBaseData2.setRealPos(i12);
                    i12++;
                    this.f26576r.add(liveSquareBaseData2);
                }
            }
        }
    }

    public final void ai() {
        MutableLiveData<VmState<LiveSquareSubData>> h02;
        MutableLiveData<VmState<LiveSquareContentData>> h03;
        this.f26574p = (LiveListViewModel) new ViewModelProvider(this).a(LiveListViewModel.class);
        this.f26575q = (LivePlaybackViewModel) new ViewModelProvider(this).a(LivePlaybackViewModel.class);
        LiveListViewModel liveListViewModel = this.f26574p;
        if (!(liveListViewModel == null || (h03 = liveListViewModel.h0()) == null)) {
            h03.observe(this, new c(new LiveCategoryListFragment$initVM$1(this)));
        }
        LivePlaybackViewModel livePlaybackViewModel = this.f26575q;
        if (livePlaybackViewModel != null && (h02 = livePlaybackViewModel.h0()) != null) {
            h02.observe(this, new c(new LiveCategoryListFragment$initVM$2(this)));
        }
    }

    public void bf(j jVar) {
        super.bf(jVar);
        this.f26577s = 2;
        LiveListViewModel liveListViewModel = this.f26574p;
        if (liveListViewModel != null) {
            liveListViewModel.i0(this.f26578t);
        }
    }

    public final void ci(int i11) {
        this.f26577s = i11;
    }

    public void initView() {
        ((u1) uh()).C.j0(new SmartRefreshHeader(requireContext()));
        ((u1) uh()).C.h0(new SmartRefreshFooter(requireContext()));
        ((u1) uh()).C.e0(this);
        this.f26579u = new CategoryListAdapter(requireActivity());
        GridLayoutManager k11 = com.hbg.module.libkt.base.ext.b.k(requireContext(), 2);
        ((u1) uh()).D.setLayoutManager(k11);
        ((u1) uh()).D.setAdapter(this.f26579u);
        k11.t(new b(this));
        ai();
        ((u1) uh()).B.setOnRetryClickListener(new c(this));
        ((u1) uh()).B.p();
        LiveListViewModel liveListViewModel = this.f26574p;
        if (liveListViewModel != null) {
            liveListViewModel.i0(this.f26578t);
        }
    }
}
