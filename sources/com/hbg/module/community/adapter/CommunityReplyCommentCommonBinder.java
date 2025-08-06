package com.hbg.module.community.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gc.d;
import lc.g3;
import rd.s;

public final class CommunityReplyCommentCommonBinder extends CommunityBaseCommonBinder<CommunityFeedInfo.ListBean, a> {

    public static final class a extends l {

        /* renamed from: c  reason: collision with root package name */
        public final g3 f17118c;

        /* renamed from: com.hbg.module.community.adapter.CommunityReplyCommentCommonBinder$a$a  reason: collision with other inner class name */
        public static final class C0123a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f17119b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f17120c;

            public C0123a(View view, long j11) {
                this.f17119b = view;
                this.f17120c = j11;
            }

            @SensorsDataInstrumented
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                s sVar = s.f23381a;
                if (currentTimeMillis - sVar.b(this.f17119b) > this.f17120c || (this.f17119b instanceof Checkable)) {
                    sVar.e(this.f17119b, currentTimeMillis);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public a(g3 g3Var) {
            super(g3Var.getRoot());
            this.f17118c = g3Var;
            s sVar = s.f23381a;
            View root = g3Var.getRoot();
            root.setOnClickListener(new C0123a(root, 800));
        }

        public final g3 c() {
            return this.f17118c;
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17121b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17122c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17123d;

        public b(View view, long j11, CommunityFeedInfo.ListBean listBean) {
            this.f17121b = view;
            this.f17122c = j11;
            this.f17123d = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17121b) > this.f17122c || (this.f17121b instanceof Checkable)) {
                sVar.e(this.f17121b, currentTimeMillis);
                b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(this.f17123d.getId())).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final void s0(CommunityFeedInfo.ListBean listBean, StatusType statusType) {
        Postcard a11 = b2.a.d().a("/content/DynamicDetail");
        CommunityFeedInfo.ListBean.ParentDynamic parentDynamic = listBean.getParentDynamic();
        a11.withString("dynamicId", String.valueOf(parentDynamic != null ? Integer.valueOf(parentDynamic.getId()) : null)).navigation();
    }

    public l Y(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new a(g3.K(layoutInflater, viewGroup, false));
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: r0 */
    public void N(a aVar, CommunityFeedInfo.ListBean listBean) {
        String userNickname = listBean.getParentDynamic().getUserNickname();
        boolean z11 = true;
        if (!(userNickname == null || userNickname.length() == 0)) {
            aVar.c().C.setVisibility(0);
            TextView textView = aVar.c().C;
            StringBuilder sb2 = new StringBuilder();
            sb2.append('@');
            CommunityFeedInfo.ListBean.ParentDynamic parentDynamic = listBean.getParentDynamic();
            sb2.append(parentDynamic != null ? parentDynamic.getUserNickname() : null);
            textView.setText(sb2.toString());
        } else {
            aVar.c().C.setVisibility(8);
        }
        String content = listBean.getParentDynamic().getContent();
        if (!(content == null || content.length() == 0)) {
            z11 = false;
        }
        if (!z11) {
            aVar.c().D.setVisibility(0);
            ExpandableTextView expandableTextView = aVar.c().D;
            CommunityFeedInfo.ListBean.ParentDynamic parentDynamic2 = listBean.getParentDynamic();
            expandableTextView.setContent((CharSequence) parentDynamic2 != null ? parentDynamic2.getContent() : null, (StatusType) null);
        } else {
            aVar.c().D.setVisibility(8);
        }
        d.e(aVar.c().D, new r(listBean), false, 0, 6, (Object) null);
        View a11 = aVar.a();
        if (a11 != null) {
            s sVar = s.f23381a;
            a11.setOnClickListener(new b(a11, 800, listBean));
        }
    }
}
