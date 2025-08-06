package com.hbg.module.content.ui.activity.live;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.LiveGroupUserListData;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.content.adapter.l;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import kotlin.jvm.internal.r;
import ky.j;
import lc.y1;
import ny.d;
import u6.g;

public final class GroupUserFragment extends BaseFragment<y1> {

    /* renamed from: x  reason: collision with root package name */
    public static final a f18391x = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public String f18392p;

    /* renamed from: q  reason: collision with root package name */
    public SmartRefreshLayout f18393q;

    /* renamed from: r  reason: collision with root package name */
    public SmartRefreshHeader f18394r;

    /* renamed from: s  reason: collision with root package name */
    public SmartRefreshFooter f18395s;

    /* renamed from: t  reason: collision with root package name */
    public l f18396t;

    /* renamed from: u  reason: collision with root package name */
    public int f18397u;

    /* renamed from: v  reason: collision with root package name */
    public final int f18398v = 1;

    /* renamed from: w  reason: collision with root package name */
    public int f18399w = 1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final GroupUserFragment a(String str, int i11) {
            GroupUserFragment groupUserFragment = new GroupUserFragment();
            Bundle bundle = new Bundle();
            bundle.putString("groupId", str);
            bundle.putInt("currentUserRole", i11);
            groupUserFragment.setArguments(bundle);
            return groupUserFragment;
        }
    }

    public static final class b implements d {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupUserFragment f18400b;

        public b(GroupUserFragment groupUserFragment) {
            this.f18400b = groupUserFragment;
        }

        public void P8(j jVar) {
            this.f18400b.ai(false);
        }

        public void bf(j jVar) {
            this.f18400b.ai(true);
        }
    }

    public static final class c extends BaseSubscriber<LiveGroupUserListData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f18401b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GroupUserFragment f18402c;

        public c(boolean z11, GroupUserFragment groupUserFragment) {
            this.f18401b = z11;
            this.f18402c = groupUserFragment;
        }

        /* renamed from: a */
        public void onNext(LiveGroupUserListData liveGroupUserListData) {
            super.onNext(liveGroupUserListData);
            if (this.f18401b) {
                this.f18402c.f18396t.a(0, liveGroupUserListData.getListData());
                this.f18402c.f18393q.finishRefresh();
            } else {
                this.f18402c.f18396t.a(1, liveGroupUserListData.getListData());
                this.f18402c.f18393q.w();
            }
            if (liveGroupUserListData.getPageNum() >= liveGroupUserListData.getPageAll()) {
                this.f18402c.f18393q.setNoMoreData(true);
            }
            GroupUserFragment groupUserFragment = this.f18402c;
            groupUserFragment.f18399w = groupUserFragment.f18399w + 1;
            GroupUserFragment.Th(this.f18402c).C.g();
        }

        public void onError(Throwable th2) {
            if (this.f18401b) {
                this.f18402c.f18393q.finishRefresh();
            } else {
                this.f18402c.f18393q.w();
            }
            GroupUserFragment.Th(this.f18402c).C.i();
        }
    }

    public static final /* synthetic */ y1 Th(GroupUserFragment groupUserFragment) {
        return (y1) groupUserFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void Zh(GroupUserFragment groupUserFragment, View view) {
        GroupUserSearchDialog.f18435f.a(groupUserFragment.requireActivity().getSupportFragmentManager(), groupUserFragment.f18392p, groupUserFragment.f18397u);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        String string;
        super.Ah();
        Bundle arguments = getArguments();
        if (!(arguments == null || (string = arguments.getString("groupId")) == null)) {
            this.f18392p = string;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            this.f18397u = arguments2.getInt("currentUserRole");
        }
    }

    /* renamed from: Yh */
    public y1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return y1.K(layoutInflater, viewGroup, false);
    }

    public final void ai(boolean z11) {
        if (z11) {
            this.f18399w = this.f18398v;
            this.f18393q.setNoMoreData(false);
        }
        v7.b.a().getLiveGroupUserList(this.f18392p, this.f18399w, 30).b().compose(RxJavaHelper.t((g) null)).subscribe(new c(z11, this));
    }

    public void initView() {
        ((y1) uh()).C.p();
        SmartRefreshLayout smartRefreshLayout = ((y1) uh()).D;
        this.f18393q = smartRefreshLayout;
        smartRefreshLayout.i(true);
        this.f18393q.g(true);
        this.f18393q.V(false);
        this.f18394r = new SmartRefreshHeader(getContext());
        this.f18393q.j0(this.f18394r);
        this.f18395s = new SmartRefreshFooter(getContext());
        this.f18393q.h0(this.f18395s);
        int i11 = this.f18397u;
        if (i11 == 2 || i11 == 3) {
            ((y1) uh()).B.setVisibility(0);
        } else {
            ((y1) uh()).B.setVisibility(8);
        }
        this.f18393q.e0(new b(this));
        ((y1) uh()).B.setOnClickListener(new f(this));
        ai(true);
        String str = this.f18392p;
        this.f18396t = str != null ? new l(requireActivity(), str, this.f18397u) : null;
        ((y1) uh()).E.setAdapter(this.f18396t);
        ((y1) uh()).E.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(requireActivity()));
    }
}
