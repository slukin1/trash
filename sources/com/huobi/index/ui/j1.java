package com.huobi.index.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.libkt.custom.blur.BlurView;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.hbg.module.libkt.utils.m;
import com.hbg.module.libkt.utils.r;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.d0;
import kotlin.l;
import pro.huobi.R;

public final class j1 extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public final List<LiveDetailBean> f73909a;

    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final LinearLayout f73910a;

        /* renamed from: b  reason: collision with root package name */
        public final RelativeLayout f73911b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f73912c;

        /* renamed from: d  reason: collision with root package name */
        public final LinearLayout f73913d;

        /* renamed from: e  reason: collision with root package name */
        public final SafeLottieView f73914e;

        /* renamed from: f  reason: collision with root package name */
        public final ImageView f73915f;

        /* renamed from: g  reason: collision with root package name */
        public final TextView f73916g;

        /* renamed from: h  reason: collision with root package name */
        public final TextView f73917h;

        /* renamed from: i  reason: collision with root package name */
        public final ImageView f73918i;

        /* renamed from: j  reason: collision with root package name */
        public final TextView f73919j;

        /* renamed from: k  reason: collision with root package name */
        public final BlurView f73920k;

        public a(View view) {
            super(view);
            this.f73910a = (LinearLayout) view.findViewById(R.id.root);
            this.f73911b = (RelativeLayout) view.findViewById(R.id.rlRoot);
            this.f73912c = (ImageView) view.findViewById(R.id.ivCover);
            this.f73913d = (LinearLayout) view.findViewById(R.id.llLiveHint);
            this.f73914e = (SafeLottieView) view.findViewById(R.id.ivLivePlaying);
            this.f73915f = (ImageView) view.findViewById(R.id.ivLiveIcon);
            this.f73916g = (TextView) view.findViewById(R.id.tvLiveType);
            this.f73917h = (TextView) view.findViewById(R.id.tvTitle);
            this.f73918i = (ImageView) view.findViewById(R.id.ivAvatar);
            this.f73919j = (TextView) view.findViewById(R.id.tvNickname);
            this.f73920k = (BlurView) view.findViewById(R.id.blurView);
        }

        public final BlurView e() {
            return this.f73920k;
        }

        public final ImageView f() {
            return this.f73918i;
        }

        public final ImageView g() {
            return this.f73912c;
        }

        public final ImageView h() {
            return this.f73915f;
        }

        public final SafeLottieView i() {
            return this.f73914e;
        }

        public final LinearLayout j() {
            return this.f73913d;
        }

        public final RelativeLayout k() {
            return this.f73911b;
        }

        public final LinearLayout l() {
            return this.f73910a;
        }

        public final TextView m() {
            return this.f73916g;
        }

        public final TextView n() {
            return this.f73919j;
        }

        public final TextView o() {
            return this.f73917h;
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f73922b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f73923c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ j1 f73924d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveSpeaker f73925e;

        public b(View view, long j11, j1 j1Var, LiveSpeaker liveSpeaker) {
            this.f73922b = view;
            this.f73923c = j11;
            this.f73924d = j1Var;
            this.f73925e = liveSpeaker;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f73922b) > this.f73923c || (this.f73922b instanceof Checkable)) {
                rVar.e(this.f73922b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f73922b;
                j1 j1Var = this.f73924d;
                LiveSpeaker liveSpeaker = this.f73925e;
                j1Var.g(liveSpeaker != null ? liveSpeaker.uidUnique : null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f73926b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f73927c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ j1 f73928d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveSpeaker f73929e;

        public c(View view, long j11, j1 j1Var, LiveSpeaker liveSpeaker) {
            this.f73926b = view;
            this.f73927c = j11;
            this.f73928d = j1Var;
            this.f73929e = liveSpeaker;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f73926b) > this.f73927c || (this.f73926b instanceof Checkable)) {
                rVar.e(this.f73926b, currentTimeMillis);
                TextView textView = (TextView) this.f73926b;
                j1 j1Var = this.f73928d;
                LiveSpeaker liveSpeaker = this.f73929e;
                j1Var.g(liveSpeaker != null ? liveSpeaker.uidUnique : null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f73930b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f73931c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f73932d;

        public d(View view, long j11, LiveDetailBean liveDetailBean) {
            this.f73930b = view;
            this.f73931c = j11;
            this.f73932d = liveDetailBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f73930b) > this.f73931c || (this.f73930b instanceof Checkable)) {
                rVar.e(this.f73930b, currentTimeMillis);
                Pair[] pairArr = new Pair[4];
                LiveDetailBean liveDetailBean = this.f73932d;
                String str = null;
                pairArr[0] = l.a("recom_base_info", liveDetailBean != null ? liveDetailBean.recom_base_info : null);
                int i11 = 1;
                pairArr[1] = l.a("recome_type", "homediscover");
                LiveDetailBean liveDetailBean2 = this.f73932d;
                pairArr[2] = l.a("liveid", liveDetailBean2 != null ? liveDetailBean2.f70249id : null);
                LiveDetailBean liveDetailBean3 = this.f73932d;
                pairArr[3] = l.a("title", liveDetailBean3 != null ? liveDetailBean3.title : null);
                SensorsDataHelper.track("app_community_live_click", MapsKt__MapsKt.j(pairArr));
                Postcard a11 = b2.a.d().a("/live/room");
                LiveDetailBean liveDetailBean4 = this.f73932d;
                if (liveDetailBean4 != null) {
                    str = liveDetailBean4.f70249id;
                }
                Postcard withString = a11.withString("liveId", String.valueOf(str));
                LiveDetailBean liveDetailBean5 = this.f73932d;
                if (liveDetailBean5 != null) {
                    i11 = liveDetailBean5.status;
                }
                withString.withInt("liveStatus", i11).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public j1(List<? extends LiveDetailBean> list) {
        this.f73909a = list;
    }

    public final int c() {
        return NightHelper.e().g() ? R.drawable.icon_user_default_n : R.drawable.icon_user_default;
    }

    public final int d() {
        return NightHelper.e().g() ? R.drawable.icon_image_default_n : R.drawable.icon_image_default;
    }

    /* renamed from: e */
    public void onBindViewHolder(a aVar, int i11) {
        List<LiveSpeaker> list;
        if (i11 == 0) {
            aVar.l().setPadding(m.a(16), 0, m.a(10), 0);
        } else if (i11 == getItemCount() - 1) {
            aVar.l().setPadding(0, 0, m.a(16), 0);
        } else {
            aVar.l().setPadding(0, 0, m.a(10), 0);
        }
        aVar.e().f(aVar.k());
        Context context = aVar.itemView.getContext();
        List<LiveDetailBean> list2 = this.f73909a;
        String str = null;
        LiveDetailBean liveDetailBean = list2 != null ? list2.get(i11) : null;
        com.hbg.module.libkt.base.ext.b.M(aVar.g(), liveDetailBean != null ? liveDetailBean.coverImageUrl : null, 8.0f, d());
        LinearLayout j11 = aVar.j();
        Integer valueOf = liveDetailBean != null ? Integer.valueOf(liveDetailBean.status) : null;
        int i12 = R.drawable.bg_live_playback_tips;
        if (valueOf != null && valueOf.intValue() == 1) {
            aVar.i().setVisibility(8);
            aVar.h().setImageResource(R.drawable.ic_live_appointment);
            aVar.h().setVisibility(0);
            String string = context.getResources().getString(R.string.n_content_live_play_time);
            String h11 = DateTimeUtils.h(liveDetailBean.startTime, "MM-dd HH:mm");
            String e11 = he.b.e(String.valueOf(liveDetailBean.appointedNum));
            d0 d0Var = d0.f56774a;
            aVar.m().setText(String.format(string, Arrays.copyOf(new Object[]{h11, e11}, 2)));
        } else if (valueOf != null && valueOf.intValue() == 2) {
            aVar.i().setVisibility(0);
            aVar.h().setVisibility(8);
            TextView m11 = aVar.m();
            d0 d0Var2 = d0.f56774a;
            m11.setText(String.format(context.getString(R.string.n_content_live_watch), Arrays.copyOf(new Object[]{he.b.e(liveDetailBean.onlineNum)}, 1)));
            i12 = R.drawable.bg_live_broadcast_tips;
        } else {
            aVar.i().setVisibility(8);
            aVar.h().setImageResource(R.drawable.ic_live_playback);
            aVar.h().setVisibility(0);
            TextView m12 = aVar.m();
            d0 d0Var3 = d0.f56774a;
            String string2 = context.getString(R.string.n_content_live_watched);
            Object[] objArr = new Object[1];
            objArr[0] = he.b.e(liveDetailBean != null ? liveDetailBean.onlineNum : null);
            m12.setText(String.format(string2, Arrays.copyOf(objArr, 1)));
        }
        j11.setBackgroundResource(i12);
        aVar.o().setText(liveDetailBean != null ? liveDetailBean.title : null);
        if (!com.hbg.module.libkt.base.ext.b.w(liveDetailBean != null ? liveDetailBean.speakerList : null)) {
            LiveSpeaker liveSpeaker = (liveDetailBean == null || (list = liveDetailBean.speakerList) == null) ? null : list.get(0);
            com.hbg.module.libkt.base.ext.b.K(aVar.f(), liveSpeaker != null ? liveSpeaker.avatar : null, c());
            TextView n11 = aVar.n();
            if (liveSpeaker != null) {
                str = liveSpeaker.nickname;
            }
            n11.setText(str);
            r rVar = r.f24939a;
            ImageView f11 = aVar.f();
            LiveSpeaker liveSpeaker2 = liveSpeaker;
            f11.setOnClickListener(new b(f11, 800, this, liveSpeaker2));
            TextView n12 = aVar.n();
            n12.setOnClickListener(new c(n12, 800, this, liveSpeaker2));
        }
        r rVar2 = r.f24939a;
        View view = aVar.itemView;
        view.setOnClickListener(new d(view, 800, liveDetailBean));
    }

    /* renamed from: f */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(View.inflate(viewGroup.getContext(), R.layout.item_index_recommend_live_item, (ViewGroup) null));
    }

    public final void g(String str) {
        b2.a.d().a("/content/PersonalCenter").withString("uidUnique", str).navigation();
    }

    public int getItemCount() {
        List<LiveDetailBean> list = this.f73909a;
        if (list == null) {
            return 0;
        }
        if (list.size() > 5) {
            return 5;
        }
        return this.f73909a.size();
    }
}
