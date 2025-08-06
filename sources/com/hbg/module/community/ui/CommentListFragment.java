package com.hbg.module.community.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.content.adapter.CommentListAdapter;
import com.hbg.module.content.utls.comment.CommentExtKt;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huochat.community.base.CommunityConstants;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.HashMap;
import kotlin.jvm.internal.r;
import ky.j;
import lc.a1;
import rd.s;

public final class CommentListFragment extends BaseFragment<a1> implements CommentListAdapter.a {

    /* renamed from: w  reason: collision with root package name */
    public static final a f17254w = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public String f17255p = "";

    /* renamed from: q  reason: collision with root package name */
    public String f17256q = BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP;

    /* renamed from: r  reason: collision with root package name */
    public String f17257r;

    /* renamed from: s  reason: collision with root package name */
    public HashMap<String, Object> f17258s;

    /* renamed from: t  reason: collision with root package name */
    public CommentListAdapter f17259t;

    /* renamed from: u  reason: collision with root package name */
    public int f17260u = 1;

    /* renamed from: v  reason: collision with root package name */
    public String f17261v = "0";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements rc.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommentListFragment f17262a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f17263b;

        public b(CommentListFragment commentListFragment, long j11) {
            this.f17262a = commentListFragment;
            this.f17263b = j11;
        }

        public void a(CommentInfo commentInfo, int i11) {
            if (commentInfo != null) {
                CommentListFragment commentListFragment = this.f17262a;
                long j11 = this.f17263b;
                CommentListFragment.Th(commentListFragment).B.g();
                CommentListAdapter Sh = commentListFragment.f17259t;
                if (Sh != null) {
                    Sh.H(0, commentInfo);
                }
                we.c.o(2, j11, (String) null, i11, 0, (CommentInfo) null, false, false, (String) null, 500, (Object) null);
            }
            this.f17262a.sh();
        }

        public void b() {
            this.f17262a.Mh(true);
            nc.c.a("app_community_tzxqsrfb", this.f17262a.f17258s);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17264b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17265c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentListFragment f17266d;

        public c(View view, long j11, CommentListFragment commentListFragment) {
            this.f17264b = view;
            this.f17265c = j11;
            this.f17266d = commentListFragment;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17264b) > this.f17265c || (this.f17264b instanceof Checkable)) {
                sVar.e(this.f17264b, currentTimeMillis);
                TextView textView = (TextView) this.f17264b;
                this.f17266d.Yh();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final /* synthetic */ a1 Th(CommentListFragment commentListFragment) {
        return (a1) commentListFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void bi(CommentListFragment commentListFragment, View view) {
        commentListFragment.f17260u = 1;
        commentListFragment.f17261v = "0";
        commentListFragment.Zh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f17257r = arguments.getString("symbols");
            this.f17255p = arguments.getString(CommunityConstants.TOPIC_ID);
        }
        this.f17255p = "1182";
        this.f17256q = "4";
    }

    public void J7(int i11) {
        nc.c.a("app_community_tzxqplzk", this.f17258s);
    }

    public void P8(j jVar) {
        super.P8(jVar);
        Zh();
    }

    public void Q3(int i11) {
        nc.c.a("app_community_dz", this.f17258s);
    }

    public final void Yh() {
        long j11;
        nc.c.a("app_community_xqpl", this.f17258s);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HbgBaseProvider wh2 = wh();
            boolean z11 = true;
            if (wh2 == null || !wh2.j(activity)) {
                z11 = false;
            }
            if (z11) {
                try {
                    String str = this.f17255p;
                    j11 = (str != null ? Long.valueOf(Long.parseLong(str)) : null).longValue();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    j11 = 0;
                }
                CommentExtKt.e(activity, this.f17255p, this.f17256q, "", new b(this, j11), (String) null, (String) null, (String) null, 112, (Object) null);
            }
        }
    }

    public final void Zh() {
        RequestExtKt.d(v7.b.a().getCommentList(this.f17255p, this.f17256q, (String) null, this.f17261v, 20, 1), new CommentListFragment$getCommentList$1(this), new CommentListFragment$getCommentList$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    /* renamed from: ai */
    public a1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return a1.K(layoutInflater, viewGroup, false);
    }

    public void be(int i11) {
        nc.c.a("app_community_sc", this.f17258s);
    }

    public void bf(j jVar) {
        super.bf(jVar);
        this.f17260u = 1;
        this.f17261v = "0";
        ((a1) uh()).D.setNoMoreData(false);
        Zh();
    }

    public void initView() {
        CommentListAdapter commentListAdapter = new CommentListAdapter(getActivity(), this.f17255p, this.f17256q, this.f17257r, false, (String) null, 48, (r) null);
        this.f17259t = commentListAdapter;
        commentListAdapter.S(this);
        ((a1) uh()).C.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(getContext()));
        ((a1) uh()).C.setAdapter(this.f17259t);
        com.hbg.module.libkt.base.ext.b.f(((a1) uh()).C);
        ((a1) uh()).D.j0(new SmartRefreshHeader(getContext()));
        ((a1) uh()).D.h0(new SmartRefreshFooter(getContext()));
        ((a1) uh()).D.e0(this);
        ((a1) uh()).B.setOnRetryClickListener(new b(this));
        s sVar = s.f23381a;
        TextView textView = ((a1) uh()).E;
        textView.setOnClickListener(new c(textView, 800, this));
        Zh();
    }

    public void j7(int i11) {
        nc.c.a("app_community_xqpl", this.f17258s);
    }
}
