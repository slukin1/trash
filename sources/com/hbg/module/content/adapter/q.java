package com.hbg.module.content.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.hbg.module.libkt.utils.m;
import com.hbg.module.libkt.utils.r;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.d0;
import kotlin.l;
import lc.k5;

public final class q extends he.c<LiveDetailBean, c.a<k5>> {

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17927b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17928c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ q f17929d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveSpeaker f17930e;

        public a(View view, long j11, q qVar, LiveSpeaker liveSpeaker) {
            this.f17927b = view;
            this.f17928c = j11;
            this.f17929d = qVar;
            this.f17930e = liveSpeaker;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f17927b) > this.f17928c || (this.f17927b instanceof Checkable)) {
                rVar.e(this.f17927b, currentTimeMillis);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f17927b;
                q qVar = this.f17929d;
                LiveSpeaker liveSpeaker = this.f17930e;
                qVar.p(liveSpeaker != null ? liveSpeaker.uidUnique : null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17931b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17932c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ q f17933d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveSpeaker f17934e;

        public b(View view, long j11, q qVar, LiveSpeaker liveSpeaker) {
            this.f17931b = view;
            this.f17932c = j11;
            this.f17933d = qVar;
            this.f17934e = liveSpeaker;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f17931b) > this.f17932c || (this.f17931b instanceof Checkable)) {
                rVar.e(this.f17931b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17931b;
                q qVar = this.f17933d;
                LiveSpeaker liveSpeaker = this.f17934e;
                qVar.p(liveSpeaker != null ? liveSpeaker.uidUnique : null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17935b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17936c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f17937d;

        public c(View view, long j11, LiveDetailBean liveDetailBean) {
            this.f17935b = view;
            this.f17936c = j11;
            this.f17937d = liveDetailBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f17935b) > this.f17936c || (this.f17935b instanceof Checkable)) {
                rVar.e(this.f17935b, currentTimeMillis);
                SensorsDataHelper.track("app_community_live_click", MapsKt__MapsKt.j(l.a("recom_base_info", this.f17937d.recom_base_info), l.a("recome_type", "plazadiscover"), l.a("liveid", this.f17937d.f70249id), l.a("title", this.f17937d.title)));
                b2.a.d().a("/live/room").withString("liveId", this.f17937d.f70249id).withInt("liveStatus", this.f17937d.status).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public q(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public final int l() {
        if (NightHelper.e().g()) {
            return R$drawable.icon_user_default_n;
        }
        return R$drawable.icon_user_default;
    }

    public final int m() {
        if (NightHelper.e().g()) {
            return R$drawable.icon_image_default_n;
        }
        return R$drawable.icon_image_default;
    }

    /* renamed from: n */
    public void onBindViewHolder(c.a<k5> aVar, int i11) {
        int i12;
        super.onBindViewHolder(aVar, i11);
        if (i11 == 0) {
            aVar.e().L.setPadding(m.a(16), 0, m.a(10), 0);
        } else if (i11 == getItemCount() - 1) {
            aVar.e().L.setPadding(0, 0, m.a(16), 0);
        } else {
            aVar.e().L.setPadding(0, 0, m.a(10), 0);
        }
        aVar.e().B.f(aVar.e().K);
        LiveDetailBean liveDetailBean = (LiveDetailBean) g().get(i11);
        Context context = aVar.e().O.getContext();
        com.hbg.module.libkt.base.ext.b.M(aVar.e().F, liveDetailBean.coverImageUrl, 8.0f, m());
        LinearLayout linearLayout = aVar.e().J;
        int i13 = liveDetailBean.status;
        if (i13 == 1) {
            aVar.e().H.setVisibility(8);
            aVar.e().G.setImageResource(R$drawable.ic_live_appointment);
            aVar.e().G.setVisibility(0);
            String string = context.getResources().getString(R$string.n_content_live_play_time);
            String h11 = DateTimeUtils.h(liveDetailBean.startTime, "MM-dd HH:mm");
            String e11 = he.b.e(String.valueOf(liveDetailBean.appointedNum));
            d0 d0Var = d0.f56774a;
            aVar.e().M.setText(String.format(string, Arrays.copyOf(new Object[]{h11, e11}, 2)));
            i12 = R$drawable.bg_live_playback_tips;
        } else if (i13 != 2) {
            aVar.e().H.setVisibility(8);
            aVar.e().G.setImageResource(R$drawable.ic_live_playback);
            aVar.e().G.setVisibility(0);
            AppCompatTextView appCompatTextView = aVar.e().M;
            d0 d0Var2 = d0.f56774a;
            appCompatTextView.setText(String.format(context.getString(R$string.n_content_live_watched), Arrays.copyOf(new Object[]{he.b.e(liveDetailBean.onlineNum)}, 1)));
            i12 = R$drawable.bg_live_playback_tips;
        } else {
            aVar.e().H.setVisibility(0);
            aVar.e().G.setVisibility(8);
            AppCompatTextView appCompatTextView2 = aVar.e().M;
            d0 d0Var3 = d0.f56774a;
            appCompatTextView2.setText(String.format(context.getString(R$string.n_content_live_watch), Arrays.copyOf(new Object[]{he.b.e(liveDetailBean.onlineNum)}, 1)));
            i12 = R$drawable.bg_live_broadcast_tips;
        }
        linearLayout.setBackgroundResource(i12);
        aVar.e().O.setText(liveDetailBean.title);
        if (!com.hbg.module.libkt.base.ext.b.w(liveDetailBean.speakerList)) {
            List<LiveSpeaker> list = liveDetailBean.speakerList;
            String str = null;
            LiveSpeaker liveSpeaker = list != null ? list.get(0) : null;
            com.hbg.module.libkt.base.ext.b.K(aVar.e().E, liveSpeaker != null ? liveSpeaker.avatar : null, l());
            AppCompatTextView appCompatTextView3 = aVar.e().N;
            if (liveSpeaker != null) {
                str = liveSpeaker.nickname;
            }
            appCompatTextView3.setText(str);
            r rVar = r.f24939a;
            AppCompatImageView appCompatImageView = aVar.e().E;
            LiveSpeaker liveSpeaker2 = liveSpeaker;
            appCompatImageView.setOnClickListener(new a(appCompatImageView, 800, this, liveSpeaker2));
            AppCompatTextView appCompatTextView4 = aVar.e().N;
            appCompatTextView4.setOnClickListener(new b(appCompatTextView4, 800, this, liveSpeaker2));
        }
        r rVar2 = r.f24939a;
        View view = aVar.itemView;
        view.setOnClickListener(new c(view, 800, liveDetailBean));
    }

    /* renamed from: o */
    public c.a<k5> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(k5.K(h(), viewGroup, false));
    }

    public final void p(String str) {
        b2.a.d().a("/content/PersonalCenter").withString("uidUnique", str).navigation();
    }
}
