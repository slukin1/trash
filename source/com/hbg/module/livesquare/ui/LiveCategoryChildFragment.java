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
import com.hbg.lib.network.hbg.core.bean.LiveCategoryListData;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.livesquare.adapter.CategoryListAdapter;
import com.hbg.module.livesquare.viewmodel.CategoryListViewModel;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import kotlin.f;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import ky.j;
import lc.s1;

public final class LiveCategoryChildFragment extends BaseFragment<s1> {

    /* renamed from: u  reason: collision with root package name */
    public static final a f26562u = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public int f26563p = -1;

    /* renamed from: q  reason: collision with root package name */
    public int f26564q = 2;

    /* renamed from: r  reason: collision with root package name */
    public CategoryListViewModel f26565r;

    /* renamed from: s  reason: collision with root package name */
    public int f26566s = 1;

    /* renamed from: t  reason: collision with root package name */
    public CategoryListAdapter f26567t;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final LiveCategoryChildFragment a(int i11, int i12) {
            LiveCategoryChildFragment liveCategoryChildFragment = new LiveCategoryChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("selCategoryId", i11);
            bundle.putInt("liveStatus", i12);
            liveCategoryChildFragment.setArguments(bundle);
            return liveCategoryChildFragment;
        }
    }

    public static final class b extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveCategoryChildFragment f26568a;

        public b(LiveCategoryChildFragment liveCategoryChildFragment) {
            this.f26568a = liveCategoryChildFragment;
        }

        public int getSpanSize(int i11) {
            if (this.f26568a.f26567t == null || this.f26568a.f26567t.getItemViewType(i11) == 4) {
                return 1;
            }
            return 2;
        }
    }

    public static final class c implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f26569b;

        public c(l lVar) {
            this.f26569b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f26569b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f26569b.invoke(obj);
        }
    }

    public static final /* synthetic */ s1 Th(LiveCategoryChildFragment liveCategoryChildFragment) {
        return (s1) liveCategoryChildFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void ai(LiveCategoryChildFragment liveCategoryChildFragment, View view) {
        liveCategoryChildFragment.Xh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        this.f26563p = arguments != null ? arguments.getInt("selCategoryId") : -1;
        Bundle arguments2 = getArguments();
        this.f26564q = arguments2 != null ? arguments2.getInt("liveStatus") : 2;
    }

    public void P8(j jVar) {
        super.P8(jVar);
        Xh();
    }

    public final void Xh() {
        CategoryListViewModel categoryListViewModel = this.f26565r;
        if (categoryListViewModel != null) {
            categoryListViewModel.i0(this.f26563p, this.f26564q, this.f26566s);
        }
    }

    /* renamed from: Yh */
    public s1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return s1.K(layoutInflater, viewGroup, false);
    }

    public final void Zh() {
        MutableLiveData<VmState<LiveCategoryListData>> h02;
        CategoryListViewModel categoryListViewModel = (CategoryListViewModel) new ViewModelProvider(this).a(CategoryListViewModel.class);
        this.f26565r = categoryListViewModel;
        if (categoryListViewModel != null && (h02 = categoryListViewModel.h0()) != null) {
            h02.observe(this, new c(new LiveCategoryChildFragment$initVM$1(this)));
        }
    }

    public void bf(j jVar) {
        super.bf(jVar);
        this.f26566s = 1;
        ((s1) uh()).C.g(true);
        Xh();
    }

    public void initView() {
        Zh();
        ((s1) uh()).C.j0(new SmartRefreshHeader(requireContext()));
        ((s1) uh()).C.h0(new SmartRefreshFooter(requireContext()));
        ((s1) uh()).C.e0(this);
        GridLayoutManager k11 = com.hbg.module.libkt.base.ext.b.k(requireContext(), 2);
        ((s1) uh()).D.setLayoutManager(k11);
        this.f26567t = new CategoryListAdapter(requireActivity());
        ((s1) uh()).D.setAdapter(this.f26567t);
        k11.t(new b(this));
        ((s1) uh()).B.setOnRetryClickListener(new b(this));
        ((s1) uh()).B.g();
        Lh();
        Xh();
    }
}
