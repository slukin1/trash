package com.hbg.module.content.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.GiftUser;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import lc.k4;
import rd.s;

public final class i extends c<GiftUser, c.a<k4>> {

    /* renamed from: f  reason: collision with root package name */
    public int f17883f;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17884b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17885c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ GiftUser f17886d;

        public a(View view, long j11, GiftUser giftUser) {
            this.f17884b = view;
            this.f17885c = j11;
            this.f17886d = giftUser;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17884b) > this.f17885c || (this.f17884b instanceof Checkable)) {
                sVar.e(this.f17884b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f17884b;
                b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f17886d.uidUnique).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public i(FragmentActivity fragmentActivity, int i11) {
        super(fragmentActivity);
        this.f17883f = i11;
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    /* renamed from: k */
    public void onBindViewHolder(c.a<k4> aVar, int i11) {
        super.onBindViewHolder(aVar, i11);
        GiftUser giftUser = (GiftUser) g().get(i11);
        aVar.e().N(Integer.valueOf(this.f17883f));
        aVar.e().M(giftUser);
        s sVar = s.f23381a;
        LinearLayout linearLayout = aVar.e().B;
        linearLayout.setOnClickListener(new a(linearLayout, 800, giftUser));
    }

    /* renamed from: l */
    public c.a<k4> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(k4.K(h(), viewGroup, false));
    }
}
