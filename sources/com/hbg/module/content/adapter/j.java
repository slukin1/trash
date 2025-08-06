package com.hbg.module.content.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.GiftUser;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import lc.m4;
import rd.s;

public final class j extends c<GiftUser, c.a<m4>> {

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17887b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17888c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ GiftUser f17889d;

        public a(View view, long j11, GiftUser giftUser) {
            this.f17887b = view;
            this.f17888c = j11;
            this.f17889d = giftUser;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17887b) > this.f17888c || (this.f17887b instanceof Checkable)) {
                sVar.e(this.f17887b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17887b;
                b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f17889d.uidUnique).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public j(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    /* renamed from: k */
    public void onBindViewHolder(c.a<m4> aVar, int i11) {
        super.onBindViewHolder(aVar, i11);
        GiftUser giftUser = (GiftUser) g().get(i11);
        aVar.e().M(giftUser);
        s sVar = s.f23381a;
        ImageView imageView = aVar.e().B;
        imageView.setOnClickListener(new a(imageView, 800, giftUser));
    }

    /* renamed from: l */
    public c.a<m4> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(m4.K(h(), viewGroup, false));
    }
}
