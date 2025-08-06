package com.hbg.module.content.ui.activity.live;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import cn.sharesdk.framework.InnerShareParams;
import com.airbnb.lottie.LottieAnimationView;
import com.google.gson.Gson;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveGroup;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.module.content.R$anim;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.helper.live.HbgLiveHelper;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.hbg.module.content.utls.l;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager;
import com.hbg.module.huobi.im.gift.bean.CusMsgPrimeBox;
import com.hbg.module.huobi.im.gift.bean.IntegralChangeBean;
import com.hbg.module.huobi.im.gift.d;
import com.hbg.module.huobi.im.group.ui.active.RewardsAnim;
import com.hbg.module.huobi.im.group.ui.barrage.LiveListener;
import com.hbg.module.huobi.im.group.ui.barrage.TUIBarrageButton;
import com.hbg.module.huobi.im.group.ui.barrage.TUIBarrageDisplayView;
import com.hbg.module.huobi.im.group.ui.barrage.b;
import com.hbg.module.huobi.im.utils.MessageBusinessID;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.utils.event.bean.LiveRedpacketBean;
import com.hbg.module.libkt.utils.event.bean.RedpacketRefreshStatus;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.common.IMLog;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.d0;

public final class FullScreenLiveActivity extends BaseActivity<lc.i> implements com.hbg.module.content.helper.live.g {
    public com.hbg.module.content.adapter.j A;
    public boolean B;
    public com.hbg.module.content.utls.l C;
    public LiveRedpacketBean D;
    public PopupWindow E;

    /* renamed from: i  reason: collision with root package name */
    public int f18338i = 2;

    /* renamed from: j  reason: collision with root package name */
    public LiveDetailBean f18339j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f18340k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f18341l = true;

    /* renamed from: m  reason: collision with root package name */
    public AlphaAnimation f18342m;

    /* renamed from: n  reason: collision with root package name */
    public AlphaAnimation f18343n;

    /* renamed from: o  reason: collision with root package name */
    public Runnable f18344o = new d(this);

    /* renamed from: p  reason: collision with root package name */
    public final int f18345p = 60;

    /* renamed from: q  reason: collision with root package name */
    public final int f18346q = 3600;

    /* renamed from: r  reason: collision with root package name */
    public boolean f18347r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f18348s = true;

    /* renamed from: t  reason: collision with root package name */
    public final Intent f18349t = new Intent();

    /* renamed from: u  reason: collision with root package name */
    public final HashMap<String, Object> f18350u = new HashMap<>();

    /* renamed from: v  reason: collision with root package name */
    public Animation f18351v;

    /* renamed from: w  reason: collision with root package name */
    public Animation f18352w;

    /* renamed from: x  reason: collision with root package name */
    public TUIBarrageButton f18353x;

    /* renamed from: y  reason: collision with root package name */
    public b.e f18354y;

    /* renamed from: z  reason: collision with root package name */
    public LiveListener f18355z;

    public static final class a implements l.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18356a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18357b;

        /* renamed from: com.hbg.module.content.ui.activity.live.FullScreenLiveActivity$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0127a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f18358a;

            /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            static {
                /*
                    com.hbg.module.libkt.utils.event.bean.RedpacketRefreshStatus[] r0 = com.hbg.module.libkt.utils.event.bean.RedpacketRefreshStatus.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.hbg.module.libkt.utils.event.bean.RedpacketRefreshStatus r1 = com.hbg.module.libkt.utils.event.bean.RedpacketRefreshStatus.ANIMATION_AND_REFRESH     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.hbg.module.libkt.utils.event.bean.RedpacketRefreshStatus r1 = com.hbg.module.libkt.utils.event.bean.RedpacketRefreshStatus.ONLY_COUNTDOWN_REFRESH     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.hbg.module.libkt.utils.event.bean.RedpacketRefreshStatus r1 = com.hbg.module.libkt.utils.event.bean.RedpacketRefreshStatus.VISIBILITY_GONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    f18358a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.live.FullScreenLiveActivity.a.C0127a.<clinit>():void");
            }
        }

        public a(FullScreenLiveActivity fullScreenLiveActivity, FullScreenLiveActivity fullScreenLiveActivity2) {
            this.f18356a = fullScreenLiveActivity;
            this.f18357b = fullScreenLiveActivity2;
        }

        public void a(boolean z11) {
            PopupWindow Dh;
            if (z11 && (Dh = this.f18356a.E) != null) {
                Dh.dismiss();
            }
        }

        public void b(boolean z11) {
            if (z11) {
                this.f18356a.Sh();
            }
        }

        public void c(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str != null) {
                    Log.d("redPacketQueue.currentPacket", "callback:---" + str);
                }
                try {
                    LiveRedpacketBean liveRedpacketBean = (LiveRedpacketBean) new Gson().fromJson(str, LiveRedpacketBean.class);
                    RedpacketRefreshStatus calcRefreshStatus = liveRedpacketBean.calcRefreshStatus(this.f18356a.D);
                    FullScreenLiveActivity fullScreenLiveActivity = this.f18356a;
                    FullScreenLiveActivity fullScreenLiveActivity2 = this.f18357b;
                    fullScreenLiveActivity.D = liveRedpacketBean;
                    FullScreenLiveActivity.Fh(fullScreenLiveActivity).P(liveRedpacketBean);
                    FullScreenLiveActivity.Fh(fullScreenLiveActivity).Q(sd.a.c(liveRedpacketBean.getCountdown()) ? 0 : 1);
                    int i11 = C0127a.f18358a[calcRefreshStatus.ordinal()];
                    if (i11 == 1) {
                        FullScreenLiveActivity.Fh(fullScreenLiveActivity).f19193z0.setVisibility(0);
                        FullScreenLiveActivity.Fh(fullScreenLiveActivity).f19193z0.startAnimation(AnimationUtils.loadAnimation(fullScreenLiveActivity2, R$anim.small_redpacket_fade_in_anim_fullscreen));
                    } else if (i11 == 2) {
                        FullScreenLiveActivity.Fh(fullScreenLiveActivity).f19193z0.setVisibility(0);
                    } else if (i11 == 3) {
                        FullScreenLiveActivity.Fh(fullScreenLiveActivity).f19193z0.setVisibility(8);
                    }
                } catch (Throwable th2) {
                    String message = th2.getMessage();
                    if (message != null) {
                        Log.e("onCurrentPacketChange", message);
                    }
                }
            }
        }

        public void d(boolean z11) {
        }
    }

    public static final class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18359a;

        public b(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18359a = fullScreenLiveActivity;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f18359a.Oh() == 3) {
                FullScreenLiveActivity.Fh(this.f18359a).f19174b0.setVisibility(8);
            }
            FullScreenLiveActivity.Fh(this.f18359a).f19175c0.setVisibility(8);
            FullScreenLiveActivity.Fh(this.f18359a).Z.setVisibility(8);
            FullScreenLiveActivity.Fh(this.f18359a).D0.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class c extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18360b;

        public c(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18360b = fullScreenLiveActivity;
        }

        public void onViewClick(View view) {
            TUIBarrageButton Ch;
            HbgBaseProvider fg2 = this.f18360b.fg();
            boolean z11 = true;
            if (fg2 == null || !fg2.j(this.f18360b)) {
                z11 = false;
            }
            if (z11 && (Ch = this.f18360b.f18353x) != null) {
                Ch.h(this.f18360b);
            }
        }
    }

    public static final class d implements d.C0140d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18361a;

        public d(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18361a = fullScreenLiveActivity;
        }

        public void a(CusMsgPrimeBox cusMsgPrimeBox) {
            nc.c.a("APP_LIVE_livestart_box", this.f18361a.f18350u);
            FullScreenLiveActivity.Fh(this.f18361a).P.setVisibility(0);
        }
    }

    public static final class e implements d.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18362a;

        public e(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18362a = fullScreenLiveActivity;
        }

        public void a(RewardsAnim rewardsAnim) {
            TUIBarrageDisplayView displayView;
            TUIBarrageButton Ch = this.f18362a.f18353x;
            if (Ch != null && (displayView = Ch.getDisplayView()) != null) {
                displayView.m(rewardsAnim);
            }
        }
    }

    public static final class f implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18363a;

        public f(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18363a = fullScreenLiveActivity;
        }

        public void a(IntegralChangeBean integralChangeBean) {
            Integer type = integralChangeBean.getType();
            Integer integral = integralChangeBean.getIntegral();
            if (type != null && type.intValue() == 1) {
                rd.j f11 = rd.j.f();
                d0 d0Var = d0.f56774a;
                f11.g(String.format(this.f18363a.getResources().getString(R$string.n_live_like_coin_rewards), Arrays.copyOf(new Object[]{String.valueOf(integral)}, 1)));
            } else if (type != null && type.intValue() == 5) {
                rd.j f12 = rd.j.f();
                d0 d0Var2 = d0.f56774a;
                f12.g(String.format(this.f18363a.getResources().getString(R$string.n_live_watch_coin_rewards), Arrays.copyOf(new Object[]{String.valueOf(integral)}, 1)));
            } else if (type != null && type.intValue() == 6) {
                rd.j f13 = rd.j.f();
                d0 d0Var3 = d0.f56774a;
                f13.g(String.format(this.f18363a.getResources().getString(R$string.n_live_send_gift_coin_rewards), Arrays.copyOf(new Object[]{String.valueOf(integral)}, 1)));
            }
        }
    }

    public static final class g implements com.hbg.module.huobi.im.gift.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18364a;

        public g(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18364a = fullScreenLiveActivity;
        }

        public void a() {
        }

        public void b(String str, int i11) {
            if (i11 == 1) {
                FullScreenLiveActivity.Fh(this.f18364a).O.setVisibility(0);
            } else {
                FullScreenLiveActivity.Fh(this.f18364a).O.setVisibility(8);
            }
        }
    }

    public static final class h extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18365b;

        public h(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18365b = fullScreenLiveActivity;
        }

        public void onViewClick(View view) {
            FullScreenLiveActivity.Fh(this.f18365b).B0.setText(this.f18365b.getResources().getString(com.hbg.module.content.R$string.n_live_p_480));
            if (HbgLiveHelper.f18227a.j(1, false)) {
                FullScreenLiveActivity.Fh(this.f18365b).S.getRoot().setVisibility(8);
                FullScreenLiveActivity.Fh(this.f18365b).R.getRoot().setVisibility(0);
            }
            FullScreenLiveActivity.Fh(this.f18365b).U.getRoot().setVisibility(8);
        }
    }

    public static final class i extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18366b;

        public i(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18366b = fullScreenLiveActivity;
        }

        public void onViewClick(View view) {
            FullScreenLiveActivity.Fh(this.f18366b).B0.setText(this.f18366b.getResources().getString(com.hbg.module.content.R$string.n_live_p_720));
            if (HbgLiveHelper.f18227a.j(2, false)) {
                FullScreenLiveActivity.Fh(this.f18366b).S.getRoot().setVisibility(8);
                FullScreenLiveActivity.Fh(this.f18366b).R.getRoot().setVisibility(0);
            }
            FullScreenLiveActivity.Fh(this.f18366b).U.getRoot().setVisibility(8);
        }
    }

    public static final class j extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18367b;

        public j(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18367b = fullScreenLiveActivity;
        }

        public void onViewClick(View view) {
            FullScreenLiveActivity.Fh(this.f18367b).B0.setText(this.f18367b.getResources().getString(com.hbg.module.content.R$string.n_live_p_1080));
            if (HbgLiveHelper.f18227a.j(3, false)) {
                FullScreenLiveActivity.Fh(this.f18367b).S.getRoot().setVisibility(8);
                FullScreenLiveActivity.Fh(this.f18367b).R.getRoot().setVisibility(0);
            }
            FullScreenLiveActivity.Fh(this.f18367b).U.getRoot().setVisibility(8);
        }
    }

    public static final class k implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18368b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18369c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18370d;

        public k(View view, long j11, FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18368b = view;
            this.f18369c = j11;
            this.f18370d = fullScreenLiveActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18368b) > this.f18369c || (this.f18368b instanceof Checkable)) {
                sVar.e(this.f18368b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18368b;
                nc.c.a("APP_LIVE_livestart_boxclk", this.f18370d.f18350u);
                FullScreenLiveActivity.Fh(this.f18370d).B.setVisibility(8);
                this.f18370d.Ph().putExtra("workType", 6);
                this.f18370d.finish();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class l implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18371b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18372c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18373d;

        public l(View view, long j11, FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18371b = view;
            this.f18372c = j11;
            this.f18373d = fullScreenLiveActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18371b) > this.f18372c || (this.f18371b instanceof Checkable)) {
                sVar.e(this.f18371b, currentTimeMillis);
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f18371b;
                this.f18373d.Ph().putExtra("workType", 8);
                this.f18373d.finish();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class m implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18374b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18375c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18376d;

        public m(View view, long j11, FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18374b = view;
            this.f18375c = j11;
            this.f18376d = fullScreenLiveActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18374b) > this.f18375c || (this.f18374b instanceof Checkable)) {
                sVar.e(this.f18374b, currentTimeMillis);
                TextView textView = (TextView) this.f18374b;
                this.f18376d.Ph().putExtra("workType", 9);
                this.f18376d.finish();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class n extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18377b;

        public n(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18377b = fullScreenLiveActivity;
        }

        public void onViewClick(View view) {
            this.f18377b.Ph().putExtra("workType", 3);
            this.f18377b.finish();
        }
    }

    public static final class o extends LiveListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18378a;

        public o(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18378a = fullScreenLiveActivity;
        }

        public void a(TUIBarrageMessage tUIBarrageMessage) {
            super.a(tUIBarrageMessage);
            this.f18378a.finish();
        }

        public void c(TUIBarrageMessage tUIBarrageMessage) {
            super.c(tUIBarrageMessage);
            try {
                if (TextUtils.equals(MessageBusinessID.MSG_BUSINESS_ID_LIVE_KICK.getValue(), tUIBarrageMessage.businessID)) {
                    Map map = (Map) tUIBarrageMessage.data.get(InnerShareParams.EXT_INFO);
                    String str = (String) map.get("groupId");
                    String str2 = (String) map.get("remove_account");
                    LiveDetailBean Nh = this.f18378a.Nh();
                    if (TextUtils.equals(str, Nh != null ? Nh.groupChatInteractive : null) && TextUtils.equals(str2, md.a.f22950a.i())) {
                        ToastUtil.toastShortMessage(this.f18378a.getString(com.hbg.module.content.R$string.n_live_im_kickout));
                        this.f18378a.finish();
                    }
                }
            } catch (Exception e11) {
                IMLog.e("LiveDetailBarrage:onReceiveKick", e11.getMessage());
            }
        }

        public void f(TUIBarrageMessage tUIBarrageMessage) {
            Map map;
            TUIBarrageDisplayView displayView;
            TUIBarrageButton Ch;
            TUIBarrageDisplayView displayView2;
            super.f(tUIBarrageMessage);
            try {
                if (TextUtils.equals(MessageBusinessID.MSG_BUSINESS_ID_LIVE_MSG_DEL.getValue(), tUIBarrageMessage.businessID)) {
                    Map map2 = (Map) tUIBarrageMessage.data.get(InnerShareParams.EXT_INFO);
                    String str = (String) map2.get("groupId");
                    int doubleValue = (int) ((Double) map2.get("msgSeq")).doubleValue();
                    LiveDetailBean Nh = this.f18378a.Nh();
                    if (TextUtils.equals(str, Nh != null ? Nh.groupChatInteractive : null) && (Ch = this.f18378a.f18353x) != null && (displayView2 = Ch.getDisplayView()) != null) {
                        displayView2.n(doubleValue);
                    }
                } else if (TextUtils.equals(MessageBusinessID.MSG_BUSINESS_ID_DELETE_USER_MESSAGE.getValue(), tUIBarrageMessage.businessID) && (map = (Map) tUIBarrageMessage.data.get(InnerShareParams.EXT_INFO)) != null) {
                    FullScreenLiveActivity fullScreenLiveActivity = this.f18378a;
                    List list = (List) map.get("msgSeqList");
                    TUIBarrageButton Ch2 = fullScreenLiveActivity.f18353x;
                    if (Ch2 != null && (displayView = Ch2.getDisplayView()) != null) {
                        displayView.o(list);
                    }
                }
            } catch (Exception e11) {
                IMLog.e("LiveDetailBarrage:onReceiveMsgDel:", e11.getMessage());
            }
        }
    }

    public static final class p extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18379b;

        public p(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18379b = fullScreenLiveActivity;
        }

        public void onViewClick(View view) {
            this.f18379b.bb();
        }
    }

    public static final class q extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18380b;

        public q(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18380b = fullScreenLiveActivity;
        }

        public void onViewClick(View view) {
            nc.c.a("APP_LIVE_group_getinto", this.f18380b.f18350u);
            this.f18380b.Ph().putExtra("workType", 2);
            this.f18380b.finish();
        }
    }

    public static final class r extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18381b;

        public r(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18381b = fullScreenLiveActivity;
        }

        public void onViewClick(View view) {
            this.f18381b.Ph().putExtra("workType", 1);
            this.f18381b.finish();
        }
    }

    public static final class s extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18382b;

        public s(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18382b = fullScreenLiveActivity;
        }

        public void onViewClick(View view) {
            HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
            if (hbgLiveHelper.s()) {
                FullScreenLiveActivity.Fh(this.f18382b).I.setImageResource(R$drawable.icon_live_play);
                hbgLiveHelper.x();
                return;
            }
            FullScreenLiveActivity.Fh(this.f18382b).I.setImageResource(R$drawable.icon_live_pause);
            hbgLiveHelper.y();
        }
    }

    public static final class t implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FullScreenLiveActivity f18383a;

        public t(FullScreenLiveActivity fullScreenLiveActivity) {
            this.f18383a = fullScreenLiveActivity;
        }

        public void onProgressChanged(SeekBar seekBar, int i11, boolean z11) {
            if (z11) {
                HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
                if (!hbgLiveHelper.s()) {
                    hbgLiveHelper.I();
                }
                hbgLiveHelper.D(i11);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            this.f18383a.f18347r = true;
            Handler Gh = this.f18383a.Zf();
            if (Gh != null) {
                Gh.removeCallbacks(this.f18383a.f18344o);
            }
            FullScreenLiveActivity.Fh(this.f18383a).f19174b0.clearAnimation();
            FullScreenLiveActivity.Fh(this.f18383a).f19175c0.clearAnimation();
            FullScreenLiveActivity.Fh(this.f18383a).Z.clearAnimation();
            FullScreenLiveActivity.Fh(this.f18383a).D0.clearAnimation();
            FullScreenLiveActivity.Fh(this.f18383a).f19174b0.setVisibility(0);
            FullScreenLiveActivity.Fh(this.f18383a).f19175c0.setVisibility(0);
            FullScreenLiveActivity.Fh(this.f18383a).Z.setVisibility(0);
            FullScreenLiveActivity.Fh(this.f18383a).D0.setVisibility(0);
        }

        @SensorsDataInstrumented
        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f18383a.f18347r = false;
            Handler Gh = this.f18383a.Zf();
            if (Gh != null) {
                Gh.postDelayed(this.f18383a.f18344o, 3000);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
        }
    }

    public static final /* synthetic */ lc.i Fh(FullScreenLiveActivity fullScreenLiveActivity) {
        return (lc.i) fullScreenLiveActivity.Yf();
    }

    public static final void Uh(FullScreenLiveActivity fullScreenLiveActivity) {
        fullScreenLiveActivity.Th();
    }

    public static /* synthetic */ void Wh(FullScreenLiveActivity fullScreenLiveActivity, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        fullScreenLiveActivity.Vh(z11);
    }

    public static final void Xh(FullScreenLiveActivity fullScreenLiveActivity, String str) {
        if (sd.a.c(str)) {
            ((lc.i) fullScreenLiveActivity.Yf()).f19186n0.setText(fullScreenLiveActivity.getResources().getString(com.hbg.module.content.R$string.n_live_chart_tips));
        } else {
            ((lc.i) fullScreenLiveActivity.Yf()).f19186n0.setText(str);
        }
    }

    @SensorsDataInstrumented
    public static final void bi(FullScreenLiveActivity fullScreenLiveActivity, View view) {
        ((lc.i) fullScreenLiveActivity.Yf()).U.getRoot().setVisibility(8);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void ci(FullScreenLiveActivity fullScreenLiveActivity, View view) {
        ((lc.i) fullScreenLiveActivity.Yf()).J.clearAnimation();
        if (fullScreenLiveActivity.f18351v != null) {
            ((lc.i) fullScreenLiveActivity.Yf()).J.startAnimation(fullScreenLiveActivity.f18351v);
        }
        ((lc.i) fullScreenLiveActivity.Yf()).f19192y0.clearAnimation();
        if (fullScreenLiveActivity.f18352w != null) {
            ((lc.i) fullScreenLiveActivity.Yf()).f19192y0.startAnimation(fullScreenLiveActivity.f18352w);
        }
        HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
        hbgLiveHelper.u();
        ((lc.i) fullScreenLiveActivity.Yf()).M.d();
        ((lc.i) fullScreenLiveActivity.Yf()).M(hbgLiveHelper.n());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void B7(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
        ((lc.i) Yf()).R.getRoot().setVisibility(0);
        ((lc.i) Yf()).T.getRoot().setVisibility(8);
        ((lc.i) Yf()).S.getRoot().setVisibility(8);
    }

    public void Bb(V2TXLivePlayer v2TXLivePlayer, boolean z11, Bundle bundle) {
        ((lc.i) Yf()).R.getRoot().setVisibility(8);
        ((lc.i) Yf()).T.getRoot().setVisibility(8);
        ((lc.i) Yf()).S.getRoot().setVisibility(8);
    }

    public void J3(int i11) {
        if (i11 > 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                ((lc.i) Yf()).M.d();
            }
        }
        ((lc.i) Yf()).M(HbgLiveHelper.f18227a.n());
    }

    public final void Lh() {
        LiveListener liveListener = this.f18355z;
        if (liveListener != null) {
            md.a.f22950a.c(liveListener);
        }
    }

    public final l.b Mh() {
        return new a(this, this);
    }

    public final LiveDetailBean Nh() {
        return this.f18339j;
    }

    public void O9() {
        ((lc.i) Yf()).M(HbgLiveHelper.f18227a.n());
    }

    public final int Oh() {
        return this.f18338i;
    }

    public final Intent Ph() {
        return this.f18349t;
    }

    public final String Qh(int i11) {
        String valueOf = String.valueOf(i11 / this.f18346q);
        if (valueOf.length() < 2) {
            valueOf = '0' + valueOf;
        }
        int i12 = this.f18346q;
        int i13 = i11 - ((i11 / i12) * i12);
        String valueOf2 = String.valueOf(i13 / this.f18345p);
        if (valueOf2.length() < 2) {
            valueOf2 = '0' + valueOf2;
        }
        int i14 = this.f18345p;
        String valueOf3 = String.valueOf(i13 - ((i13 / i14) * i14));
        if (valueOf3.length() < 2) {
            valueOf3 = '0' + valueOf3;
        }
        return valueOf + ':' + valueOf2 + ':' + valueOf3;
    }

    /* renamed from: Rh */
    public lc.i Og() {
        return lc.i.K(getLayoutInflater());
    }

    public void S7() {
        ((lc.i) Yf()).R.getRoot().setVisibility(8);
        ((lc.i) Yf()).S.getRoot().setVisibility(8);
        ((lc.i) Yf()).T.getRoot().setVisibility(8);
        ((lc.i) Yf()).I.setImageResource(R$drawable.icon_live_pause);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        r0 = r0.k();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Sh() {
        /*
            r4 = this;
            com.hbg.module.libkt.provider.HbgBaseProvider r0 = r4.fg()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.j(r4)
            if (r0 != r2) goto L_0x000f
            r1 = r2
        L_0x000f:
            if (r1 == 0) goto L_0x0042
            com.hbg.module.content.utls.l r0 = r4.C
            if (r0 == 0) goto L_0x0020
            rj.b r0 = r0.k()
            if (r0 == 0) goto L_0x0020
            java.lang.String r1 = "redPacketGrap.loadAlertView()"
            r0.I(r1)
        L_0x0020:
            com.hbg.module.content.utls.l r0 = r4.C
            if (r0 == 0) goto L_0x0031
            rj.b r0 = r0.k()
            if (r0 == 0) goto L_0x0031
            java.lang.String r1 = "grap.xml"
            android.view.View r0 = r0.D(r1, r4)
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            com.hbg.module.content.utls.q r1 = com.hbg.module.content.utls.q.f18949a
            android.view.Window r3 = r4.getWindow()
            android.view.View r3 = r3.peekDecorView()
            android.widget.PopupWindow r0 = r1.c(r4, r3, r0, r2)
            r4.E = r0
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.live.FullScreenLiveActivity.Sh():void");
    }

    public void Ta(V2TXLivePlayer v2TXLivePlayer, boolean z11, Bundle bundle) {
        ((lc.i) Yf()).R.getRoot().setVisibility(8);
        ((lc.i) Yf()).T.getRoot().setVisibility(8);
        ((lc.i) Yf()).S.getRoot().setVisibility(8);
    }

    public final void Th() {
        if (this.f18343n == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
            this.f18343n = alphaAnimation;
            alphaAnimation.setDuration(300);
            AlphaAnimation alphaAnimation2 = this.f18343n;
            if (alphaAnimation2 != null) {
                alphaAnimation2.setAnimationListener(new b(this));
            }
        }
        if (this.f18338i == 3) {
            ((lc.i) Yf()).f19174b0.clearAnimation();
            ((lc.i) Yf()).f19174b0.startAnimation(this.f18343n);
        }
        ((lc.i) Yf()).f19175c0.clearAnimation();
        ((lc.i) Yf()).f19175c0.startAnimation(this.f18343n);
        ((lc.i) Yf()).Z.clearAnimation();
        ((lc.i) Yf()).Z.startAnimation(this.f18343n);
        ((lc.i) Yf()).D0.clearAnimation();
        ((lc.i) Yf()).D0.startAnimation(this.f18343n);
    }

    public void V6(int i11, int i12) {
        ((lc.i) Yf()).f19176d0.setMax(i11);
        ((lc.i) Yf()).f19184l0.setText(Qh(i11));
        ((lc.i) Yf()).f19176d0.setProgress(i12);
        ((lc.i) Yf()).f19191x0.setText(Qh(i12));
    }

    public final void Vh(boolean z11) {
        TUIBarrageDisplayView displayView;
        TUIBarrageDisplayView displayView2;
        LiveDetailBean liveDetailBean = this.f18339j;
        TUIBarrageDisplayView tUIBarrageDisplayView = null;
        if (!sd.a.c(liveDetailBean != null ? liveDetailBean.groupChatInteractive : null)) {
            md.a aVar = md.a.f22950a;
            LiveDetailBean liveDetailBean2 = this.f18339j;
            String str = liveDetailBean2 != null ? liveDetailBean2.groupChatInteractive : null;
            LiveDetailBean liveDetailBean3 = this.f18339j;
            this.f18353x = (TUIBarrageButton) aVar.d(this, str, liveDetailBean3 != null ? liveDetailBean3.messageFromServer : 0, z11);
            c cVar = new c(this);
            this.f18354y = cVar;
            TUIBarrageButton tUIBarrageButton = this.f18353x;
            if (tUIBarrageButton != null) {
                tUIBarrageButton.setSendHideListener(cVar);
            }
            TUIBarrageButton tUIBarrageButton2 = this.f18353x;
            if (((tUIBarrageButton2 == null || (displayView2 = tUIBarrageButton2.getDisplayView()) == null) ? null : displayView2.getParent()) != null) {
                TUIBarrageButton tUIBarrageButton3 = this.f18353x;
                ViewGroup viewGroup = (ViewGroup) ((tUIBarrageButton3 == null || (displayView = tUIBarrageButton3.getDisplayView()) == null) ? null : displayView.getParent());
                TUIBarrageButton tUIBarrageButton4 = this.f18353x;
                viewGroup.removeView(tUIBarrageButton4 != null ? tUIBarrageButton4.getDisplayView() : null);
            }
            ((lc.i) Yf()).E0.removeAllViews();
            LinearLayout linearLayout = ((lc.i) Yf()).E0;
            TUIBarrageButton tUIBarrageButton5 = this.f18353x;
            if (tUIBarrageButton5 != null) {
                tUIBarrageDisplayView = tUIBarrageButton5.getDisplayView();
            }
            linearLayout.addView(tUIBarrageDisplayView);
            ((lc.i) Yf()).E0.setGravity(80);
        }
        if (this.f18338i == 2) {
            ((lc.i) Yf()).C.setOnClickListener(new c(this));
        }
    }

    public void X8(V2TXLivePlayer v2TXLivePlayer, int i11, String str, Bundle bundle) {
    }

    public final void Yh() {
        LiveGiftLandscapeManager liveGiftLandscapeManager = LiveGiftLandscapeManager.f19698a;
        LiveDetailBean liveDetailBean = this.f18339j;
        String str = null;
        liveGiftLandscapeManager.x(liveDetailBean != null ? liveDetailBean.f70249id : null);
        LiveDetailBean liveDetailBean2 = this.f18339j;
        if (liveDetailBean2 != null) {
            str = liveDetailBean2.groupChatInteractive;
        }
        liveGiftLandscapeManager.u(str);
        liveGiftLandscapeManager.q(this);
        liveGiftLandscapeManager.p(this);
        liveGiftLandscapeManager.w(((lc.i) Yf()).Q);
        liveGiftLandscapeManager.v(((lc.i) Yf()).W, ((lc.i) Yf()).V);
        liveGiftLandscapeManager.y(new FullScreenLiveActivity$initGiftManager$1(this));
        liveGiftLandscapeManager.z(new FullScreenLiveActivity$initGiftManager$2(this));
        com.hbg.module.huobi.im.gift.d.f19724a.u().put(getLocalClassName(), new d(this));
        liveGiftLandscapeManager.j().put(getLocalClassName(), new e(this));
        liveGiftLandscapeManager.h().put(getLocalClassName(), new f(this));
        liveGiftLandscapeManager.B(new g(this));
    }

    public final void Zh() {
        if (this.A == null) {
            this.A = new com.hbg.module.content.adapter.j(this);
            ((lc.i) Yf()).f19180h0.setLayoutManager(com.hbg.module.libkt.base.ext.b.m(this));
            ((lc.i) Yf()).f19180h0.setAdapter(this.A);
            com.hbg.module.libkt.base.ext.b.f(((lc.i) Yf()).f19180h0);
        }
        LiveDetailBean liveDetailBean = this.f18339j;
        if (!com.hbg.module.libkt.base.ext.b.w(liveDetailBean != null ? liveDetailBean.giftTopUser : null)) {
            com.hbg.module.content.adapter.j jVar = this.A;
            if (jVar != null) {
                jVar.a(0, this.f18339j.giftTopUser);
            }
            ((lc.i) Yf()).f19177e0.setVisibility(0);
            return;
        }
        ((lc.i) Yf()).f19177e0.setVisibility(8);
    }

    public final void ai() {
        ((lc.i) Yf()).U.E.setOnClickListener(new a(this));
        ((lc.i) Yf()).U.C.setOnClickListener(new h(this));
        ((lc.i) Yf()).U.D.setOnClickListener(new i(this));
        ((lc.i) Yf()).U.B.setOnClickListener(new j(this));
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.postDelayed(this.f18344o, 3000);
        }
    }

    public void bb() {
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.removeCallbacks(this.f18344o);
        }
        fi();
    }

    public void da() {
        ((lc.i) Yf()).S.getRoot().setVisibility(8);
        ((lc.i) Yf()).T.getRoot().setVisibility(8);
        if (!this.f18347r) {
            ((lc.i) Yf()).R.getRoot().setVisibility(0);
        }
    }

    public final void di() {
        LiveDetailBean liveDetailBean = this.f18339j;
        if (sd.a.c(liveDetailBean != null ? liveDetailBean.mediaUrl : null)) {
            ((lc.i) Yf()).T.B.setText(getResources().getString(com.hbg.module.content.R$string.n_live_finish_wait_vod));
            ((lc.i) Yf()).T.getRoot().setVisibility(0);
            return;
        }
        ((lc.i) Yf()).I.setOnClickListener(new s(this));
        ((lc.i) Yf()).f19174b0.setVisibility(0);
        ((lc.i) Yf()).f19176d0.setOnSeekBarChangeListener(new t(this));
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.postDelayed(this.f18344o, 3000);
        }
    }

    public final void ei() {
        int i11;
        LinearLayout linearLayout = ((lc.i) Yf()).Y;
        if (this.f18348s) {
            ((lc.i) Yf()).L.setImageResource(R$drawable.icon_live_show_chart);
            i11 = 8;
        } else {
            ((lc.i) Yf()).L.setImageResource(R$drawable.icon_live_close_chart);
            i11 = 0;
        }
        linearLayout.setVisibility(i11);
        this.f18348s = !this.f18348s;
    }

    public void f4() {
        ((lc.i) Yf()).S.getRoot().setVisibility(0);
        ((lc.i) Yf()).T.getRoot().setVisibility(8);
        ((lc.i) Yf()).R.getRoot().setVisibility(8);
    }

    public final void fi() {
        if (((lc.i) Yf()).f19174b0.getVisibility() == 0) {
            ((lc.i) Yf()).f19174b0.clearAnimation();
            ((lc.i) Yf()).f19175c0.clearAnimation();
            ((lc.i) Yf()).Z.clearAnimation();
            ((lc.i) Yf()).D0.clearAnimation();
            ((lc.i) Yf()).f19174b0.setVisibility(0);
            ((lc.i) Yf()).f19175c0.setVisibility(0);
            ((lc.i) Yf()).Z.setVisibility(0);
            ((lc.i) Yf()).D0.setVisibility(0);
        } else {
            if (this.f18342m == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                this.f18342m = alphaAnimation;
                alphaAnimation.setDuration(300);
            }
            if (this.f18338i == 3) {
                ((lc.i) Yf()).f19174b0.clearAnimation();
                ((lc.i) Yf()).f19174b0.setVisibility(0);
                ((lc.i) Yf()).f19174b0.startAnimation(this.f18342m);
            }
            ((lc.i) Yf()).f19175c0.clearAnimation();
            ((lc.i) Yf()).f19175c0.setVisibility(0);
            ((lc.i) Yf()).f19175c0.startAnimation(this.f18342m);
            ((lc.i) Yf()).Z.clearAnimation();
            ((lc.i) Yf()).Z.setVisibility(0);
            ((lc.i) Yf()).Z.startAnimation(this.f18342m);
            ((lc.i) Yf()).D0.clearAnimation();
            ((lc.i) Yf()).D0.setVisibility(0);
            ((lc.i) Yf()).D0.startAnimation(this.f18342m);
        }
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.postDelayed(this.f18344o, 3000);
        }
    }

    public void finish() {
        setResult(-1, this.f18349t);
        super.finish();
    }

    public final void gi() {
        ((lc.i) Yf()).U.getRoot().setVisibility(((lc.i) Yf()).U.getRoot().getVisibility() == 0 ? 8 : 0);
    }

    public void ic(V2TXLivePlayer v2TXLivePlayer, int i11, String str, Bundle bundle) {
        if (i11 == -8) {
            ((lc.i) Yf()).T.getRoot().setVisibility(8);
            ((lc.i) Yf()).R.getRoot().setVisibility(8);
            ((lc.i) Yf()).S.getRoot().setVisibility(0);
        } else if (i11 != 0) {
            ((lc.i) Yf()).T.getRoot().setVisibility(8);
            ((lc.i) Yf()).R.getRoot().setVisibility(8);
            ((lc.i) Yf()).S.getRoot().setVisibility(0);
        }
    }

    public void initView() {
        LiveGroup liveGroup;
        List<LiveSpeaker> list;
        LiveSpeaker liveSpeaker;
        List<LiveSpeaker> list2;
        LiveSpeaker liveSpeaker2;
        List<LiveSpeaker> list3;
        LiveSpeaker liveSpeaker3;
        List<LiveSpeaker> list4;
        List<LiveSpeaker> list5;
        LiveSpeaker liveSpeaker4;
        super.initView();
        this.f18350u.put("state", Integer.valueOf(this.f18338i));
        HashMap<String, Object> hashMap = this.f18350u;
        LiveDetailBean liveDetailBean = this.f18339j;
        String str = null;
        hashMap.put("liveid", liveDetailBean != null ? liveDetailBean.f70249id : null);
        this.f18350u.put(VineCardUtils.PLAYER_CARD, 2);
        HashMap<String, Object> hashMap2 = this.f18350u;
        LiveDetailBean liveDetailBean2 = this.f18339j;
        hashMap2.put("title", liveDetailBean2 != null ? liveDetailBean2.title : null);
        HashMap<String, Object> hashMap3 = this.f18350u;
        LiveDetailBean liveDetailBean3 = this.f18339j;
        hashMap3.put("upid", (liveDetailBean3 == null || (list5 = liveDetailBean3.speakerList) == null || (liveSpeaker4 = list5.get(0)) == null) ? null : liveSpeaker4.showId);
        nc.c.a("APP_LIVE_notice_exposure", this.f18350u);
        HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
        TXCloudVideoView o11 = hbgLiveHelper.o();
        if (o11 != null) {
            ((ViewGroup) o11.getParent()).removeView(o11);
            ((lc.i) Yf()).f19179g0.addView(o11, 0);
        }
        hbgLiveHelper.E(this);
        ((lc.i) Yf()).f19189v0.append(":");
        ((lc.i) Yf()).O(this);
        ((lc.i) Yf()).M(this.f18339j);
        lc.i iVar = (lc.i) Yf();
        LiveDetailBean liveDetailBean4 = this.f18339j;
        iVar.R((liveDetailBean4 == null || (list4 = liveDetailBean4.speakerList) == null) ? null : list4.get(0));
        ((lc.i) Yf()).N(Integer.valueOf(this.f18338i));
        AvatarView avatarView = ((lc.i) Yf()).D;
        LiveDetailBean liveDetailBean5 = this.f18339j;
        AvatarView x11 = AvatarView.x(avatarView, (liveDetailBean5 == null || (list3 = liveDetailBean5.speakerList) == null || (liveSpeaker3 = list3.get(0)) == null) ? null : liveSpeaker3.avatar, 0, 2, (Object) null);
        LiveDetailBean liveDetailBean6 = this.f18339j;
        String str2 = (liveDetailBean6 == null || (list2 = liveDetailBean6.speakerList) == null || (liveSpeaker2 = list2.get(0)) == null) ? null : liveSpeaker2.uidUnique;
        LiveDetailBean liveDetailBean7 = this.f18339j;
        x11.z(str2, (liveDetailBean7 == null || (list = liveDetailBean7.speakerList) == null || (liveSpeaker = list.get(0)) == null) ? null : liveSpeaker.showId);
        if (!hbgLiveHelper.s()) {
            if (this.f18340k) {
                ((lc.i) Yf()).S.getRoot().setVisibility(0);
            } else {
                ((lc.i) Yf()).R.getRoot().setVisibility(0);
            }
        }
        this.f18351v = AnimationUtils.loadAnimation(this, R$anim.live_praise);
        this.f18352w = AnimationUtils.loadAnimation(this, R$anim.live_praise_text);
        ((lc.i) Yf()).M.f(Integer.valueOf(R$drawable.icon_expression_01), Integer.valueOf(R$drawable.icon_expression_02), Integer.valueOf(R$drawable.icon_expression_03), Integer.valueOf(R$drawable.icon_expression_04), Integer.valueOf(R$drawable.icon_expression_05), Integer.valueOf(R$drawable.icon_expression_06));
        ((lc.i) Yf()).J.setOnClickListener(new b(this));
        ((lc.i) Yf()).S.B.setOnClickListener(new n(this));
        ((lc.i) Yf()).U.F.setVisibility(0);
        ((lc.i) Yf()).U.G.setVisibility(0);
        Wh(this, false, 1, (Object) null);
        Yh();
        rd.s sVar = rd.s.f23381a;
        ImageView imageView = ((lc.i) Yf()).P;
        imageView.setOnClickListener(new k(imageView, 800, this));
        hbgLiveHelper.J();
        if (this.f18338i == 2) {
            LiveDetailBean liveDetailBean8 = this.f18339j;
            if (liveDetailBean8 != null && liveDetailBean8.hasBox == 1) {
                nc.c.a("APP_LIVE_livestart_box", this.f18350u);
                ((lc.i) Yf()).P.setVisibility(0);
            }
            LiveDetailBean liveDetailBean9 = this.f18339j;
            if (liveDetailBean9 != null && liveDetailBean9.giftStatus == 1) {
                ((lc.i) Yf()).O.setVisibility(0);
                LottieAnimationView lottieAnimationView = ((lc.i) Yf()).O;
                lottieAnimationView.setOnClickListener(new l(lottieAnimationView, 800, this));
            } else {
                ((lc.i) Yf()).O.setVisibility(8);
            }
            hbgLiveHelper.w();
            int m11 = hbgLiveHelper.m();
            if (m11 == 1) {
                ((lc.i) Yf()).B0.setText(getResources().getString(com.hbg.module.content.R$string.n_live_p_480));
                ((lc.i) Yf()).U.C.setChecked(true);
            } else if (m11 == 2) {
                ((lc.i) Yf()).B0.setText(getResources().getString(com.hbg.module.content.R$string.n_live_p_720));
                ((lc.i) Yf()).U.D.setChecked(true);
            } else if (m11 == 3) {
                ((lc.i) Yf()).B0.setText(getResources().getString(com.hbg.module.content.R$string.n_live_p_1080));
                ((lc.i) Yf()).U.B.setChecked(true);
            }
            ((lc.i) Yf()).B0.setVisibility(0);
            if (this.f18355z == null) {
                this.f18355z = new o(this);
            }
            Lh();
            ai();
        } else {
            ((lc.i) Yf()).B0.setVisibility(8);
            di();
        }
        ((lc.i) Yf()).f19179g0.setOnClickListener(new p(this));
        LiveDetailBean liveDetailBean10 = this.f18339j;
        if (!(liveDetailBean10 == null || (liveGroup = liveDetailBean10.liveGroup) == null)) {
            str = liveGroup.groupId;
        }
        if (sd.a.c(str)) {
            ((lc.i) Yf()).G.setVisibility(8);
        } else {
            ((lc.i) Yf()).G.setOnClickListener(new q(this));
        }
        ((lc.i) Yf()).K.setOnClickListener(new r(this));
        TextView textView = ((lc.i) Yf()).C0;
        textView.setOnClickListener(new m(textView, 800, this));
        Zh();
    }

    public void oh() {
        com.hbg.module.content.utls.l lVar;
        super.oh();
        HbgBaseProvider fg2 = fg();
        this.B = fg2 != null ? fg2.n() : false;
        HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
        if (hbgLiveHelper.n() == null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("liveData");
            if (serializableExtra != null) {
                this.f18339j = (LiveDetailBean) serializableExtra;
            }
        } else {
            this.f18339j = hbgLiveHelper.n();
        }
        LiveDetailBean liveDetailBean = this.f18339j;
        this.f18338i = liveDetailBean != null ? liveDetailBean.status : 2;
        this.f18340k = getIntent().getBooleanExtra("isNetworkError", false);
        WeakReference<com.hbg.module.content.utls.l> a11 = com.hbg.module.content.utls.l.f18918c.a();
        if (!(a11 == null || (lVar = (com.hbg.module.content.utls.l) a11.get()) == null)) {
            this.C = lVar;
            lVar.m(Mh());
        }
        Serializable serializableExtra2 = getIntent().getSerializableExtra("redpacketBeans");
        if (serializableExtra2 != null) {
            this.D = (LiveRedpacketBean) serializableExtra2;
        }
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().getDecorView().setSystemUiVisibility(2);
        super.onCreate(bundle);
    }

    public void onDestroy() {
        com.hbg.module.huobi.im.gift.d.f19724a.u().remove(getLocalClassName());
        LiveGiftLandscapeManager.f19698a.s();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (com.hbg.module.libkt.base.ext.b.e(this)) {
            HbgLiveHelper.f18227a.x();
        }
    }

    public void onPlayEnd() {
        ((lc.i) Yf()).I.setImageResource(R$drawable.icon_live_play);
    }

    public void onResume() {
        super.onResume();
        HbgBaseProvider fg2 = fg();
        if (fg2 != null && fg2.n()) {
            LiveDetailBean liveDetailBean = this.f18339j;
            if ((liveDetailBean != null && liveDetailBean.status == 2) && !this.B) {
                this.B = true;
                Vh(true);
            }
        }
        rd.m.f23375a.c(true);
        if (this.f18341l) {
            this.f18341l = false;
        } else {
            HbgLiveHelper.f18227a.y();
        }
        md.a.f22950a.k(this);
    }

    public void onStart() {
        super.onStart();
        rd.j.f().j(((lc.i) Yf()).N, (View) null);
    }
}
