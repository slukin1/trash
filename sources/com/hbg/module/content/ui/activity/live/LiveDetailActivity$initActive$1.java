package com.hbg.module.content.ui.activity.live;

import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.UserActiveInfo;
import com.hbg.module.libkt.base.ext.b;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import nc.c;
import rd.s;

public final class LiveDetailActivity$initActive$1 extends Lambda implements l<UserActiveInfo, Unit> {
    public final /* synthetic */ LiveDetailActivity this$0;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18549b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18550c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18551d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserActiveInfo f18552e;

        public a(View view, long j11, LiveDetailActivity liveDetailActivity, UserActiveInfo userActiveInfo) {
            this.f18549b = view;
            this.f18550c = j11;
            this.f18551d = liveDetailActivity;
            this.f18552e = userActiveInfo;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18549b) > this.f18550c || (this.f18549b instanceof Checkable)) {
                sVar.e(this.f18549b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f18549b;
                c.a("APP_LIVE_reward_mbbclk", this.f18551d.K);
                BaseModuleConfig.a().k0(this.f18552e.activityUrl);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$initActive$1(LiveDetailActivity liveDetailActivity) {
        super(1);
        this.this$0 = liveDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((UserActiveInfo) obj);
        return Unit.f56620a;
    }

    public final void invoke(UserActiveInfo userActiveInfo) {
        Unit unit;
        if (userActiveInfo != null) {
            LiveDetailActivity liveDetailActivity = this.this$0;
            c.a("APP_LIVE_reward_mbb", liveDetailActivity.K);
            b.L(LiveDetailActivity.Ki(liveDetailActivity).O, userActiveInfo.entryUrl, 4.0f);
            LiveDetailActivity.Ki(liveDetailActivity).H1.setText(userActiveInfo.title);
            s sVar = s.f23381a;
            LinearLayout linearLayout = LiveDetailActivity.Ki(liveDetailActivity).T0;
            linearLayout.setOnClickListener(new a(linearLayout, 800, liveDetailActivity, userActiveInfo));
            LiveDetailActivity.Ki(liveDetailActivity).T0.setVisibility(0);
            unit = Unit.f56620a;
        } else {
            unit = null;
        }
        if (unit == null) {
            LiveDetailActivity.Ki(this.this$0).T0.setVisibility(8);
        }
    }
}
