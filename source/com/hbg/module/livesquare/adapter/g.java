package com.hbg.module.livesquare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$drawable;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import he.c;
import kotlin.Pair;
import kotlin.jvm.internal.x;
import kotlin.l;
import lc.s5;
import rd.s;

public final class g extends he.c<RecommendSpeakerList.RecommendSpeakerBean, c.a<s5>> {

    /* renamed from: f  reason: collision with root package name */
    public boolean f26458f = true;

    /* renamed from: g  reason: collision with root package name */
    public HbgBaseProvider f26459g;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26460b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f26461c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f26462d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendSpeakerList.RecommendSpeakerBean f26463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f26464f;

        public a(View view, long j11, g gVar, RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean, int i11) {
            this.f26460b = view;
            this.f26461c = j11;
            this.f26462d = gVar;
            this.f26463e = recommendSpeakerBean;
            this.f26464f = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f26460b) > this.f26461c || (this.f26460b instanceof Checkable)) {
                sVar.e(this.f26460b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f26460b;
                HbgBaseProvider k11 = this.f26462d.f26459g;
                if (k11 != null && k11.j(this.f26462d.f())) {
                    IHbgApi a11 = v7.b.a();
                    Pair[] pairArr = new Pair[2];
                    pairArr[0] = l.a("type", Integer.valueOf(this.f26463e.getFocusStatus() == 0 ? 1 : 0));
                    pairArr[1] = l.a("uidUnique", this.f26463e.getUidUnique());
                    a11.requestCommunityAttention(MapsKt__MapsKt.l(pairArr)).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new c(this.f26463e, this.f26462d, this.f26464f));
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26465b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f26466c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RecommendSpeakerList.RecommendSpeakerBean f26467d;

        public b(View view, long j11, RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean) {
            this.f26465b = view;
            this.f26466c = j11;
            this.f26467d = recommendSpeakerBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f26465b) > this.f26466c || (this.f26465b instanceof Checkable)) {
                sVar.e(this.f26465b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f26465b;
                if (this.f26467d.getHasLive() == 1 && !sd.a.c(this.f26467d.getLiveId())) {
                    b2.a.d().a("/live/room").withString("liveId", this.f26467d.getLiveId()).navigation();
                } else if (!sd.a.c(this.f26467d.getUidUnique()) || !sd.a.c(this.f26467d.getAccount())) {
                    b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f26467d.getUidUnique()).withString(Constants.FLAG_ACCOUNT, this.f26467d.getAccount()).navigation();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c extends BaseSubscriber<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecommendSpeakerList.RecommendSpeakerBean f26468b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f26469c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f26470d;

        public c(RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean, g gVar, int i11) {
            this.f26468b = recommendSpeakerBean;
            this.f26469c = gVar;
            this.f26470d = i11;
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean = this.f26468b;
            int i11 = 1;
            if (recommendSpeakerBean.getFocusStatus() == 0) {
                RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean2 = this.f26468b;
                recommendSpeakerBean2.setFansNum(recommendSpeakerBean2.getFansNum() + 1);
            } else {
                RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean3 = this.f26468b;
                recommendSpeakerBean3.setFansNum(recommendSpeakerBean3.getFansNum() - 1);
                i11 = 0;
            }
            recommendSpeakerBean.setFocusStatus(i11);
            this.f26469c.notifyItemChanged(this.f26470d);
            String uidUnique = this.f26468b.getUidUnique();
            if (uidUnique == null) {
                uidUnique = "";
            }
            we.c.q(uidUnique, this.f26468b.getFocusStatus());
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                HuobiToastUtil.i(((APIStatusErrorException) th2).getErrMsg());
            } else {
                HuobiToastUtil.g(R$string.n_service_error);
            }
        }
    }

    public g(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /* renamed from: l */
    public void onBindViewHolder(c.a<s5> aVar, int i11) {
        super.onBindViewHolder(aVar, i11);
        RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean = (RecommendSpeakerList.RecommendSpeakerBean) g().get(i11);
        aVar.e().M(recommendSpeakerBean);
        if (i11 == 0) {
            aVar.e().I.setText((CharSequence) null);
            aVar.e().I.setBackgroundResource(R$drawable.icon_speaker_rank_1st);
        } else if (i11 == 1) {
            aVar.e().I.setText((CharSequence) null);
            aVar.e().I.setBackgroundResource(R$drawable.icon_speaker_rank_2nd);
        } else if (i11 != 2) {
            aVar.e().I.setText(String.valueOf(i11 + 1));
            aVar.e().I.setBackgroundResource(0);
        } else {
            aVar.e().I.setText((CharSequence) null);
            aVar.e().I.setBackgroundResource(R$drawable.icon_speaker_rank_3rd);
        }
        aVar.e().B.s(recommendSpeakerBean.getHasLive(), -1, recommendSpeakerBean.getUidUnique(), recommendSpeakerBean.getAccount(), recommendSpeakerBean.getLiveId(), i11).w(recommendSpeakerBean.getAvatar(), R$drawable.icon_community_user_header);
        s sVar = s.f23381a;
        LinearLayout linearLayout = aVar.e().D;
        linearLayout.setOnClickListener(new a(linearLayout, 800, this, recommendSpeakerBean, i11));
        LinearLayout linearLayout2 = aVar.e().E;
        linearLayout2.setOnClickListener(new b(linearLayout2, 800, recommendSpeakerBean));
    }

    /* renamed from: m */
    public c.a<s5> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        this.f26459g = (HbgBaseProvider) b2.a.d().a("/provider/content").navigation();
        return new c.a<>(s5.K(h(), viewGroup, false));
    }

    public final void n(String str, int i11) {
        int size = g().size();
        for (int i12 = 0; i12 < size; i12++) {
            if (x.b(((RecommendSpeakerList.RecommendSpeakerBean) g().get(i12)).getUidUnique(), str)) {
                ((RecommendSpeakerList.RecommendSpeakerBean) g().get(i12)).setFocusStatus(i11);
                notifyItemChanged(i12);
                return;
            }
        }
    }
}
