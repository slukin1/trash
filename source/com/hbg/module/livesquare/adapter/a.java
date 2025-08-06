package com.hbg.module.livesquare.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryData;
import com.hbg.lib.router.HbgRouter;
import com.hbg.module.libkt.base.ext.b;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import lc.q2;
import rd.s;

public final class a extends c<LiveCategoryData, c.a<q2>> {

    /* renamed from: f  reason: collision with root package name */
    public boolean f26439f = true;

    /* renamed from: com.hbg.module.livesquare.adapter.a$a  reason: collision with other inner class name */
    public static final class C0236a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26440b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f26441c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveCategoryData f26442d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26443e;

        public C0236a(View view, long j11, LiveCategoryData liveCategoryData, a aVar) {
            this.f26440b = view;
            this.f26441c = j11;
            this.f26442d = liveCategoryData;
            this.f26443e = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f26440b) > this.f26441c || (this.f26440b instanceof Checkable)) {
                sVar.e(this.f26440b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f26440b;
                Bundle bundle = new Bundle();
                bundle.putInt("selCategoryId", this.f26442d.getCategoryId());
                bundle.putInt("liveStatus", 2);
                HbgRouter.i(this.f26443e.f(), "/live/category_list", bundle);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public a(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public int getItemCount() {
        if (g().size() <= 4 || this.f26439f) {
            return super.getItemCount();
        }
        return 4;
    }

    public final boolean k() {
        return this.f26439f;
    }

    /* renamed from: l */
    public void onBindViewHolder(c.a<q2> aVar, int i11) {
        super.onBindViewHolder(aVar, i11);
        LiveCategoryData liveCategoryData = (LiveCategoryData) g().get(i11);
        aVar.e().M(liveCategoryData);
        if (b.x(liveCategoryData.getLogo())) {
            aVar.e().B.setVisibility(8);
        } else {
            aVar.e().B.setVisibility(0);
        }
        s sVar = s.f23381a;
        LinearLayout linearLayout = aVar.e().C;
        linearLayout.setOnClickListener(new C0236a(linearLayout, 800, liveCategoryData, this));
    }

    /* renamed from: m */
    public c.a<q2> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(q2.K(h(), viewGroup, false));
    }

    public final void n(boolean z11) {
        this.f26439f = z11;
    }
}
