package com.hbg.module.content.ui.activity.live;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.GiftUser;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveEndRecommendData;
import com.hbg.lib.network.hbg.core.bean.LiveGroup;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.LiveUserRole;
import com.hbg.lib.network.hbg.core.bean.RecommendTrader;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.content.R$anim;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.content.custom.FloatView;
import com.hbg.module.content.custom.LiveInfoDialog;
import com.hbg.module.content.custom.LiveMoreControllerDialog;
import com.hbg.module.content.helper.live.HbgLiveHelper;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.hbg.module.content.ui.activity.live.edgeengine.CornerView;
import com.hbg.module.content.ui.activity.live.edgeengine.DepositButton;
import com.hbg.module.content.ui.activity.live.edgeengine.EngineDialogFragment;
import com.hbg.module.content.ui.activity.live.edgeengine.GiftPanelAbility;
import com.hbg.module.content.ui.activity.live.rank.GiftRankDialog;
import com.hbg.module.content.utls.a;
import com.hbg.module.content.utls.l;
import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.hbg.module.huobi.im.gift.bean.CusMsgPrimeBox;
import com.hbg.module.huobi.im.gift.bean.IntegralChangeBean;
import com.hbg.module.huobi.im.gift.d;
import com.hbg.module.huobi.im.group.ui.active.RewardsAnim;
import com.hbg.module.huobi.im.group.ui.barrage.LiveListener;
import com.hbg.module.huobi.im.group.ui.barrage.TUIBarrageButton;
import com.hbg.module.huobi.im.group.ui.barrage.TUIBarrageDisplayView;
import com.hbg.module.huobi.im.group.ui.barrage.b;
import com.hbg.module.huobi.im.manager.ActiveViewManager;
import com.hbg.module.huobi.im.utils.ImJumpUtils;
import com.hbg.module.huobi.im.utils.LiveErrorCode;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.hbg.module.libkt.utils.event.bean.Financial;
import com.hbg.module.libkt.utils.event.bean.GiftBean;
import com.hbg.module.libkt.utils.event.bean.GiftDataInfo;
import com.hbg.module.libkt.utils.event.bean.GiftGroup;
import com.hbg.module.libkt.utils.event.bean.GiftPanelInfo;
import com.hbg.module.libkt.utils.event.bean.LiveRedpacketBean;
import com.hbg.module.libkt.utils.event.bean.RedpacketRefreshStatus;
import com.hbg.module.livesquare.dialog.LiveGetFreeGiftDialogFragment;
import com.hbg.module.livesquare.dialog.LiveSelfAwardDialog;
import com.hbg.module.livesquare.utils.LiveTrackUtils;
import com.huobi.framework.im.common.ImCommonCallback;
import com.huobi.framework.im.common.ImManager;
import com.huobi.utils.ReviewManger;
import com.huobi.view.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.common.IMLog;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.n1;
import org.json.JSONArray;
import org.json.JSONObject;

@Route(path = "/live/room")
public final class LiveDetailActivity extends BaseActivity<lc.m> implements com.hbg.module.content.helper.live.g {
    public static final a E0 = new a((kotlin.jvm.internal.r) null);
    public static int F0 = 1;
    public Runnable A = new f1(this);
    public PopupWindow A0;
    public Runnable B = new k1(this);
    public RecommendTrader B0;
    public Runnable C = new z0(this);
    public LiveSelfAwardDialog C0;
    public Runnable D = new c1(this);
    public FloatView D0;
    public boolean E;
    public boolean F;
    public boolean G = true;
    public boolean H;
    public boolean I;
    public boolean J = true;
    public final HashMap<String, Object> K = new HashMap<>();
    public long L;
    public Animation M;
    public Animation N;
    public Animation O;
    public Animation P;
    public Animation Q;
    public Animation R;
    public Animation S;
    public Animation T;
    public b.e U;
    public TUIBarrageButton V;
    public boolean W;
    public LiveListener X;
    public TextView Y;
    public TextView Z;

    /* renamed from: a0  reason: collision with root package name */
    public TextView f18450a0;

    /* renamed from: b0  reason: collision with root package name */
    public TextView f18451b0;

    /* renamed from: c0  reason: collision with root package name */
    public TXVodPlayer f18452c0;

    /* renamed from: d0  reason: collision with root package name */
    public com.hbg.module.livesquare.adapter.b f18453d0;

    /* renamed from: e0  reason: collision with root package name */
    public com.hbg.module.content.adapter.o f18454e0;

    /* renamed from: f0  reason: collision with root package name */
    public LiveSpeaker f18455f0;

    /* renamed from: g0  reason: collision with root package name */
    public int f18456g0 = 2;

    /* renamed from: h0  reason: collision with root package name */
    public rj.b f18457h0;

    /* renamed from: i  reason: collision with root package name */
    public final String f18458i = "live_detail_never_show";

    /* renamed from: i0  reason: collision with root package name */
    public EngineDialogFragment f18459i0;

    /* renamed from: j  reason: collision with root package name */
    public int f18460j = 1;

    /* renamed from: j0  reason: collision with root package name */
    public int f18461j0 = 1;

    /* renamed from: k  reason: collision with root package name */
    public String f18462k = "";

    /* renamed from: k0  reason: collision with root package name */
    public GiftBean f18463k0;

    /* renamed from: l  reason: collision with root package name */
    public int f18464l;

    /* renamed from: l0  reason: collision with root package name */
    public boolean f18465l0;

    /* renamed from: m  reason: collision with root package name */
    public LiveDetailBean f18466m;

    /* renamed from: m0  reason: collision with root package name */
    public boolean f18467m0;

    /* renamed from: n  reason: collision with root package name */
    public TranslateAnimation f18468n;

    /* renamed from: n0  reason: collision with root package name */
    public com.hbg.module.content.adapter.j f18469n0;

    /* renamed from: o  reason: collision with root package name */
    public TranslateAnimation f18470o;

    /* renamed from: p  reason: collision with root package name */
    public TranslateAnimation f18471p;

    /* renamed from: q  reason: collision with root package name */
    public TranslateAnimation f18472q;

    /* renamed from: r  reason: collision with root package name */
    public AlphaAnimation f18473r;

    /* renamed from: s  reason: collision with root package name */
    public AlphaAnimation f18474s;

    /* renamed from: t  reason: collision with root package name */
    public AlphaAnimation f18475t;

    /* renamed from: t0  reason: collision with root package name */
    public String f18476t0;

    /* renamed from: u  reason: collision with root package name */
    public AlphaAnimation f18477u;

    /* renamed from: u0  reason: collision with root package name */
    public LiveGetFreeGiftDialogFragment f18478u0;

    /* renamed from: v  reason: collision with root package name */
    public AlphaAnimation f18479v;

    /* renamed from: v0  reason: collision with root package name */
    public com.hbg.module.content.adapter.t f18480v0;

    /* renamed from: w  reason: collision with root package name */
    public AlphaAnimation f18481w;

    /* renamed from: w0  reason: collision with root package name */
    public com.hbg.module.content.utls.l f18482w0;

    /* renamed from: x  reason: collision with root package name */
    public Animation f18483x;

    /* renamed from: x0  reason: collision with root package name */
    public CountDownTimer f18484x0;

    /* renamed from: y  reason: collision with root package name */
    public final int f18485y = 60;

    /* renamed from: y0  reason: collision with root package name */
    public boolean f18486y0;

    /* renamed from: z  reason: collision with root package name */
    public final int f18487z = 3600;

    /* renamed from: z0  reason: collision with root package name */
    public LiveRedpacketBean f18488z0;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }
    }

    public static final class a0 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18489b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18490c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18491d;

        public a0(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18489b = view;
            this.f18490c = j11;
            this.f18491d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18489b) > this.f18490c || (this.f18489b instanceof Checkable)) {
                sVar.e(this.f18489b, currentTimeMillis);
                TextView textView = (TextView) this.f18489b;
                this.f18491d.rj();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class a1 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18492b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18493c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f18494d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18495e;

        public a1(View view, long j11, String str, LiveDetailActivity liveDetailActivity) {
            this.f18492b = view;
            this.f18493c = j11;
            this.f18494d = str;
            this.f18495e = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18492b) > this.f18493c || (this.f18492b instanceof Checkable)) {
                sVar.e(this.f18492b, currentTimeMillis);
                TextView textView = (TextView) this.f18492b;
                if (!sd.a.c(this.f18494d)) {
                    LiveDetailActivity liveDetailActivity = this.f18495e;
                    liveDetailActivity.Wl(this.f18494d, liveDetailActivity.getString(R$string.n_live_noti));
                    this.f18495e.wj("APP_LIVE_livestart_topannouncementclk");
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18496a;

        public b(LiveDetailActivity liveDetailActivity) {
            this.f18496a = liveDetailActivity;
        }

        public void onAnimationEnd(Animation animation) {
            LiveDetailActivity.Ki(this.f18496a).I0.C.setVisibility(8);
            LiveDetailActivity.Ki(this.f18496a).I0.D.setVisibility(8);
            LiveDetailActivity.Ki(this.f18496a).I0.E.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class b0 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18497b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18498c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18499d;

        public b0(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18497b = view;
            this.f18498c = j11;
            this.f18499d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18497b) > this.f18498c || (this.f18497b instanceof Checkable)) {
                sVar.e(this.f18497b, currentTimeMillis);
                TextView textView = (TextView) this.f18497b;
                GiftRankDialog.a aVar = GiftRankDialog.f18674e;
                FragmentManager supportFragmentManager = this.f18499d.getSupportFragmentManager();
                String Sj = this.f18499d.Sj();
                LiveDetailBean Hi = this.f18499d.f18466m;
                aVar.a(supportFragmentManager, Sj, Hi != null ? Hi.groupChatInteractive : null, this.f18499d.f18464l);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b1 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18500b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18501c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18502d;

        public b1(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18500b = view;
            this.f18501c = j11;
            this.f18502d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18500b) > this.f18501c || (this.f18500b instanceof Checkable)) {
                sVar.e(this.f18500b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18500b;
                this.f18502d.ek();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18503a;

        public c(LiveDetailActivity liveDetailActivity) {
            this.f18503a = liveDetailActivity;
        }

        public void onAnimationEnd(Animation animation) {
            LiveDetailActivity.Ki(this.f18503a).f19208d2.setVisibility(8);
            LiveDetailActivity.Ki(this.f18503a).Y1.setVisibility(8);
            LiveDetailActivity.Ki(this.f18503a).K2.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class c0 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18504b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18505c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18506d;

        public c0(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18504b = view;
            this.f18505c = j11;
            this.f18506d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18504b) > this.f18505c || (this.f18504b instanceof Checkable)) {
                sVar.e(this.f18504b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18504b;
                nc.c.a("APP_LIVE_livestart_boxclk", this.f18506d.K);
                ActiveViewManager e11 = ActiveViewManager.e();
                LiveDetailActivity liveDetailActivity = this.f18506d;
                BaseModuleConfig.a a11 = BaseModuleConfig.a();
                e11.n(2, liveDetailActivity, a11.k("live/lucky-box?liveId=" + this.f18506d.Sj()), 1);
                LiveDetailActivity.Ki(this.f18506d).H.setVisibility(8);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c1 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18507b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18508c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f18509d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18510e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18511f;

        public c1(View view, long j11, int i11, String str, LiveDetailActivity liveDetailActivity) {
            this.f18507b = view;
            this.f18508c = j11;
            this.f18509d = i11;
            this.f18510e = str;
            this.f18511f = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18507b) > this.f18508c || (this.f18507b instanceof Checkable)) {
                sVar.e(this.f18507b, currentTimeMillis);
                TextView textView = (TextView) this.f18507b;
                int i11 = this.f18509d;
                if (i11 == 1) {
                    BaseModuleConfig.a().k0(this.f18510e);
                } else if (i11 == 2) {
                    ImJumpUtils.a(this.f18511f, BaseModuleConfig.a().k(this.f18510e));
                } else if (i11 == 3) {
                    ImJumpUtils.b(this.f18511f, this.f18510e);
                }
                this.f18511f.wj("APP_LIVE_livestart_jump");
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements l.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18512a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18513b;

        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f18514a;

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
                    f18514a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.live.LiveDetailActivity.d.a.<clinit>():void");
            }
        }

        public d(LiveDetailActivity liveDetailActivity, LiveDetailActivity liveDetailActivity2) {
            this.f18512a = liveDetailActivity;
            this.f18513b = liveDetailActivity2;
        }

        public void a(boolean z11) {
            PopupWindow Bi;
            if (z11 && (Bi = this.f18512a.A0) != null) {
                Bi.dismiss();
            }
        }

        public void b(boolean z11) {
            if (z11) {
                this.f18512a.ak();
            }
        }

        public void c(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str != null) {
                    Log.d("redPacketQueue.currentPacket", "callback:---" + str);
                }
                try {
                    LiveRedpacketBean liveRedpacketBean = (LiveRedpacketBean) new Gson().fromJson(str, LiveRedpacketBean.class);
                    RedpacketRefreshStatus calcRefreshStatus = liveRedpacketBean.calcRefreshStatus(this.f18512a.f18488z0);
                    LiveDetailActivity liveDetailActivity = this.f18512a;
                    LiveDetailActivity liveDetailActivity2 = this.f18513b;
                    liveDetailActivity.f18488z0 = liveRedpacketBean;
                    LiveDetailActivity.Ki(liveDetailActivity).Q(liveRedpacketBean);
                    LiveDetailActivity.Ki(liveDetailActivity).S(sd.a.c(liveRedpacketBean.getCountdown()) ? 0 : 1);
                    int i11 = a.f18514a[calcRefreshStatus.ordinal()];
                    if (i11 == 1) {
                        LiveDetailActivity.Ki(liveDetailActivity).f19254u2.setVisibility(0);
                        LiveDetailActivity.Ki(liveDetailActivity).f19254u2.startAnimation(AnimationUtils.loadAnimation(liveDetailActivity2, R$anim.small_redpacket_fade_in_anim));
                    } else if (i11 == 2) {
                        LiveDetailActivity.Ki(liveDetailActivity).f19254u2.setVisibility(0);
                    } else if (i11 == 3) {
                        LiveDetailActivity.Ki(liveDetailActivity).f19254u2.setVisibility(8);
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
            if (z11) {
                this.f18512a.Dj();
            }
        }
    }

    public static final class d0 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18515b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18516c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18517d;

        public d0(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18515b = view;
            this.f18516c = j11;
            this.f18517d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18515b) > this.f18516c || (this.f18515b instanceof Checkable)) {
                sVar.e(this.f18515b, currentTimeMillis);
                we.c.A(0, 1, (Object) null);
                this.f18517d.Zj();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d1 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18518b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18519c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18520d;

        public d1(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18518b = view;
            this.f18519c = j11;
            this.f18520d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18518b) > this.f18519c || (this.f18518b instanceof Checkable)) {
                sVar.e(this.f18518b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18518b;
                nc.c.a("app_live_trader_buttonmore", MapsKt__MapsKt.j(kotlin.l.a("uid", BaseModuleConfig.a().getUid()), kotlin.l.a("liveId", this.f18520d.Sj())));
                LiveMoreControllerDialog.a aVar = LiveMoreControllerDialog.f18019f;
                FragmentManager supportFragmentManager = this.f18520d.getSupportFragmentManager();
                String Sj = this.f18520d.Sj();
                RecommendTrader Si = this.f18520d.B0;
                aVar.a(supportFragmentManager, Sj, Si != null ? Integer.valueOf(Si.f70265id) : null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e extends BaseSubscriber<LiveUserRole> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18521b;

        public e(LiveDetailActivity liveDetailActivity) {
            this.f18521b = liveDetailActivity;
        }

        /* renamed from: a */
        public void onNext(LiveUserRole liveUserRole) {
            super.onNext(liveUserRole);
            this.f18521b.f18464l = liveUserRole.getRole();
            this.f18521b.Xl();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public static final class e0 implements d.C0140d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18522a;

        public static final class a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f18523b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f18524c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ LiveDetailActivity f18525d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CusMsgPrimeBox f18526e;

            public a(View view, long j11, LiveDetailActivity liveDetailActivity, CusMsgPrimeBox cusMsgPrimeBox) {
                this.f18523b = view;
                this.f18524c = j11;
                this.f18525d = liveDetailActivity;
                this.f18526e = cusMsgPrimeBox;
            }

            @SensorsDataInstrumented
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                rd.s sVar = rd.s.f23381a;
                if (currentTimeMillis - sVar.b(this.f18523b) > this.f18524c || (this.f18523b instanceof Checkable)) {
                    sVar.e(this.f18523b, currentTimeMillis);
                    RoundTextView roundTextView = (RoundTextView) this.f18523b;
                    nc.c.a("APP_LIVE_livestart_boxbubbleclk", this.f18525d.K);
                    Intent intent = new Intent();
                    String landingUrl = this.f18526e.getLandingUrl();
                    boolean z11 = true;
                    if (landingUrl == null || !StringsKt__StringsJVMKt.M(landingUrl, "/", false, 2, (Object) null)) {
                        z11 = false;
                    }
                    if (z11) {
                        CusMsgPrimeBox cusMsgPrimeBox = this.f18526e;
                        cusMsgPrimeBox.setLandingUrl(StringsKt__StringsJVMKt.I(cusMsgPrimeBox.getLandingUrl(), "/", "", false, 4, (Object) null));
                    }
                    intent.putExtra("url", BaseModuleConfig.a().k(this.f18526e.getLandingUrl()));
                    intent.setClass(this.f18525d, HBBaseWebActivity.class);
                    this.f18525d.startActivity(intent);
                    LiveDetailActivity.Ki(this.f18525d).H.setVisibility(8);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public e0(LiveDetailActivity liveDetailActivity) {
            this.f18522a = liveDetailActivity;
        }

        public static final void c(LiveDetailActivity liveDetailActivity) {
            LiveDetailActivity.Ki(liveDetailActivity).H.setVisibility(8);
        }

        public void a(CusMsgPrimeBox cusMsgPrimeBox) {
            if (this.f18522a.O == null) {
                LiveDetailActivity liveDetailActivity = this.f18522a;
                liveDetailActivity.O = AnimationUtils.loadAnimation(liveDetailActivity, R$anim.prime_pop_show);
                Animation Ni = this.f18522a.O;
                if (Ni != null) {
                    Ni.setInterpolator(new LinearOutSlowInInterpolator());
                }
            }
            nc.c.a("APP_LIVE_livestart_box", this.f18522a.K);
            nc.c.a("APP_LIVE_livestart_boxbubble", this.f18522a.K);
            LiveDetailActivity.Ki(this.f18522a).E0.setVisibility(0);
            LiveDetailActivity.Ki(this.f18522a).H.setVisibility(0);
            com.hbg.module.libkt.base.ext.b.J(LiveDetailActivity.Ki(this.f18522a).Z, cusMsgPrimeBox.getLogo());
            LiveDetailActivity.Ki(this.f18522a).P1.setText(cusMsgPrimeBox.getCurrency());
            try {
                LiveDetailActivity.Ki(this.f18522a).Z1.setText(String.valueOf(cusMsgPrimeBox.getParticipants()));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            rd.s sVar = rd.s.f23381a;
            RoundTextView roundTextView = LiveDetailActivity.Ki(this.f18522a).W1;
            roundTextView.setOnClickListener(new a(roundTextView, 800, this.f18522a, cusMsgPrimeBox));
            LiveDetailActivity.Ki(this.f18522a).H.startAnimation(this.f18522a.O);
            Handler Li = this.f18522a.Zf();
            if (Li != null) {
                Li.postDelayed(new v1(this.f18522a), 10000);
            }
        }
    }

    public static final class e1 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18527b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18528c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RecommendTrader f18529d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18530e;

        public e1(View view, long j11, RecommendTrader recommendTrader, LiveDetailActivity liveDetailActivity) {
            this.f18527b = view;
            this.f18528c = j11;
            this.f18529d = recommendTrader;
            this.f18530e = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18527b) > this.f18528c || (this.f18527b instanceof Checkable)) {
                sVar.e(this.f18527b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18527b;
                Postcard a11 = b2.a.d().a("/webView/index");
                BaseModuleConfig.a a12 = BaseModuleConfig.a();
                a11.withString("url", a12.k("tradingbot/h5/futures/trader-detail?login=1&userSign=" + this.f18529d.userSign)).navigation(this.f18530e);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18531a;

        public f(LiveDetailActivity liveDetailActivity) {
            this.f18531a = liveDetailActivity;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f18531a.f18460j == 2) {
                LiveDetailActivity.Ki(this.f18531a).f19263x2.setVisibility(8);
            } else if (this.f18531a.f18460j == 3) {
                LiveDetailActivity.Ki(this.f18531a).f19225j1.setVisibility(8);
            }
            LiveDetailActivity.Ki(this.f18531a).f19206d0.setVisibility(8);
            LiveDetailActivity.Ki(this.f18531a).E2.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class f0 implements d.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18532a;

        public f0(LiveDetailActivity liveDetailActivity) {
            this.f18532a = liveDetailActivity;
        }

        public void a(RecommendTrader recommendTrader) {
            LiveDetailBean Hi = this.f18532a.f18466m;
            if (Hi != null) {
                Hi.recommendTrader = recommendTrader;
            }
            this.f18532a.B0 = recommendTrader;
            this.f18532a.Xl();
        }

        public void onClose() {
            LiveDetailBean Hi = this.f18532a.f18466m;
            if (Hi != null) {
                Hi.recommendTrader = null;
            }
            this.f18532a.B0 = null;
            LiveDetailActivity.Ki(this.f18532a).f19222i1.setVisibility(8);
            LiveDetailActivity.Ki(this.f18532a).f19203c0.setVisibility(8);
        }
    }

    public static final class f1 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18533b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18534c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18535d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendTrader f18536e;

        public f1(View view, long j11, LiveDetailActivity liveDetailActivity, RecommendTrader recommendTrader) {
            this.f18533b = view;
            this.f18534c = j11;
            this.f18535d = liveDetailActivity;
            this.f18536e = recommendTrader;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18533b) > this.f18534c || (this.f18533b instanceof Checkable)) {
                sVar.e(this.f18533b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f18533b;
                boolean z11 = true;
                nc.c.a("app_live_trader_contentclick", MapsKt__MapsKt.j(kotlin.l.a("uid", BaseModuleConfig.a().getUid()), kotlin.l.a("liveId", this.f18535d.Sj())));
                HbgBaseProvider fg2 = this.f18535d.fg();
                if (fg2 == null || !fg2.j(this.f18535d)) {
                    z11 = false;
                }
                if (z11) {
                    LiveDetailActivity.Wj(this.f18535d, Integer.valueOf(this.f18536e.f70265id), 0, 2, (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements ITXVodPlayListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18537a;

        public g(LiveDetailActivity liveDetailActivity) {
            this.f18537a = liveDetailActivity;
        }

        public void onNetStatus(TXVodPlayer tXVodPlayer, Bundle bundle) {
        }

        public void onPlayEvent(TXVodPlayer tXVodPlayer, int i11, Bundle bundle) {
            if (i11 == 2004) {
                LiveDetailActivity.Ki(this.f18537a).S.setVisibility(8);
            } else if (i11 == 2006) {
                LiveDetailActivity.Ki(this.f18537a).S.setVisibility(0);
            }
        }
    }

    public static final class g0 implements d.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18538a;

        public g0(LiveDetailActivity liveDetailActivity) {
            this.f18538a = liveDetailActivity;
        }

        public void a(RewardsAnim rewardsAnim) {
            TUIBarrageDisplayView displayView;
            TUIBarrageButton ui2 = this.f18538a.V;
            if (ui2 != null && (displayView = ui2.getDisplayView()) != null) {
                displayView.m(rewardsAnim);
            }
        }
    }

    public static final class g1 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18539b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18540c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18541d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendTrader f18542e;

        public g1(View view, long j11, LiveDetailActivity liveDetailActivity, RecommendTrader recommendTrader) {
            this.f18539b = view;
            this.f18540c = j11;
            this.f18541d = liveDetailActivity;
            this.f18542e = recommendTrader;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18539b) > this.f18540c || (this.f18539b instanceof Checkable)) {
                sVar.e(this.f18539b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18539b;
                boolean z11 = true;
                nc.c.a("app_live_trader_buttonclick", MapsKt__MapsKt.j(kotlin.l.a("uid", BaseModuleConfig.a().getUid()), kotlin.l.a("liveId", this.f18541d.Sj())));
                HbgBaseProvider fg2 = this.f18541d.fg();
                if (fg2 == null || !fg2.j(this.f18541d)) {
                    z11 = false;
                }
                if (z11) {
                    LiveDetailActivity.Wj(this.f18541d, Integer.valueOf(this.f18542e.f70265id), 0, 2, (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class h extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18543b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f18544c;

        public h(LiveDetailActivity liveDetailActivity, LiveDetailBean liveDetailBean) {
            this.f18543b = liveDetailActivity;
            this.f18544c = liveDetailBean;
        }

        public void onViewClick(View view) {
            nc.c.a("APP_LIVE_group_getinto", this.f18543b.K);
            HbgBaseProvider fg2 = this.f18543b.fg();
            boolean z11 = false;
            if (fg2 != null && fg2.j(this.f18543b)) {
                z11 = true;
            }
            if (z11) {
                LiveGroup liveGroup = this.f18544c.liveGroup;
                if (liveGroup.type == 1 || liveGroup.hasJion == 1) {
                    this.f18543b.I = true;
                    if (Build.VERSION.SDK_INT < 23 || (Settings.canDrawOverlays(this.f18543b) && HbgLiveHelper.f18227a.s())) {
                        this.f18543b.Fl();
                    }
                    dd.b bVar = dd.b.f22740a;
                    LiveDetailActivity liveDetailActivity = this.f18543b;
                    LiveGroup liveGroup2 = this.f18544c.liveGroup;
                    dd.b.k(bVar, liveDetailActivity, liveGroup2.groupId, liveGroup2.title, (String) null, 8, (Object) null);
                    return;
                }
                b2.a.d().a("/webView/index").withString("url", BaseModuleConfig.a().k("live/community/privateGroup?groupId=" + this.f18544c.liveGroup.groupId)).navigation(this.f18543b);
            }
        }
    }

    public static final class h0 implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18545a;

        public h0(LiveDetailActivity liveDetailActivity) {
            this.f18545a = liveDetailActivity;
        }

        public void a(IntegralChangeBean integralChangeBean) {
            Integer type = integralChangeBean.getType();
            Integer integral = integralChangeBean.getIntegral();
            this.f18545a.zl("updateUserIntegral()");
            com.hbg.module.content.helper.live.f fVar = com.hbg.module.content.helper.live.f.f18246a;
            Integer allIntegral = integralChangeBean.getAllIntegral();
            fVar.j(allIntegral != null ? allIntegral.intValue() : -1);
            if (type != null && type.intValue() == 1) {
                rd.j f11 = rd.j.f();
                kotlin.jvm.internal.d0 d0Var = kotlin.jvm.internal.d0.f56774a;
                f11.g(String.format(this.f18545a.getResources().getString(R$string.n_live_like_coin_rewards), Arrays.copyOf(new Object[]{String.valueOf(integral)}, 1)));
            } else if (type != null && type.intValue() == 2) {
                rd.j f12 = rd.j.f();
                kotlin.jvm.internal.d0 d0Var2 = kotlin.jvm.internal.d0.f56774a;
                f12.g(String.format(this.f18545a.getResources().getString(R$string.n_content_ugc_send_msg_hot_coin), Arrays.copyOf(new Object[]{String.valueOf(integral)}, 1)));
            } else if (type != null && type.intValue() == 5) {
                rd.j f13 = rd.j.f();
                kotlin.jvm.internal.d0 d0Var3 = kotlin.jvm.internal.d0.f56774a;
                f13.g(String.format(this.f18545a.getResources().getString(R$string.n_live_watch_coin_rewards), Arrays.copyOf(new Object[]{String.valueOf(integral)}, 1)));
            } else if (type != null && type.intValue() == 6) {
                rd.j f14 = rd.j.f();
                kotlin.jvm.internal.d0 d0Var4 = kotlin.jvm.internal.d0.f56774a;
                f14.g(String.format(this.f18545a.getResources().getString(R$string.n_live_send_gift_coin_rewards), Arrays.copyOf(new Object[]{String.valueOf(integral)}, 1)));
            }
            Integer allIntegral2 = integralChangeBean.getAllIntegral();
            int intValue = allIntegral2 != null ? allIntegral2.intValue() : 0;
            Integer unlockIntegral = integralChangeBean.getUnlockIntegral();
            if (intValue >= (unlockIntegral != null ? unlockIntegral.intValue() : 0)) {
                this.f18545a.Pl(2);
                if (this.f18545a.T == null) {
                    this.f18545a.T = new ScaleAnimation(0.9f, 1.05f, 0.9f, 1.05f, 1, 0.5f, 1, 0.5f);
                    Animation Fi = this.f18545a.T;
                    if (Fi != null) {
                        Fi.setRepeatMode(2);
                    }
                    Animation Fi2 = this.f18545a.T;
                    if (Fi2 != null) {
                        Fi2.setRepeatCount(-1);
                    }
                    Animation Fi3 = this.f18545a.T;
                    if (Fi3 != null) {
                        Fi3.setDuration(600);
                    }
                }
                LiveDetailActivity.Ki(this.f18545a).f19212f0.clearAnimation();
                com.hbg.module.libkt.base.ext.b.J(LiveDetailActivity.Ki(this.f18545a).f19212f0, integralChangeBean.getIntegralUrl());
                LiveDetailActivity.Ki(this.f18545a).f19212f0.setVisibility(0);
                LiveDetailActivity.Ki(this.f18545a).f19212f0.startAnimation(this.f18545a.T);
                LiveDetailActivity.Ki(this.f18545a).D0.setVisibility(8);
            }
        }
    }

    public static final class i extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18546a;

        public static final class a extends CountDownTimer {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LiveDetailActivity f18547a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(LiveDetailActivity liveDetailActivity) {
                super(5000, 1000);
                this.f18547a = liveDetailActivity;
            }

            public void onFinish() {
                this.f18547a.Cj();
            }

            public void onTick(long j11) {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(LiveDetailActivity liveDetailActivity) {
            super(60000, 1000);
            this.f18546a = liveDetailActivity;
        }

        public void onFinish() {
            this.f18546a.rl();
            new a(this.f18546a).start();
        }

        public void onTick(long j11) {
        }
    }

    public static final class i0 implements d.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18548a;

        public i0(LiveDetailActivity liveDetailActivity) {
            this.f18548a = liveDetailActivity;
        }

        public void onHide() {
            IMLog.d("onSuccessHideListener", "优惠券抖动HIDE");
            LiveDetailActivity.Ki(this.f18548a).V.startAnimation(AnimationUtils.loadAnimation(this.f18548a, R$anim.im_anim_coupon_scale));
        }
    }

    public static final class j extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18554b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f18555c;

        public j(LiveDetailActivity liveDetailActivity, LiveDetailBean liveDetailBean) {
            this.f18554b = liveDetailActivity;
            this.f18555c = liveDetailBean;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
            r2 = r2.liveGroup;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewClick(android.view.View r8) {
            /*
                r7 = this;
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r8 = r7.f18554b
                java.util.HashMap r8 = r8.K
                java.lang.String r0 = "APP_LIVE_group_getinto"
                nc.c.a(r0, r8)
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r8 = r7.f18554b
                com.hbg.module.libkt.provider.HbgBaseProvider r8 = r8.fg()
                r0 = 0
                r1 = 1
                if (r8 == 0) goto L_0x001e
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r2 = r7.f18554b
                boolean r8 = r8.j(r2)
                if (r8 != r1) goto L_0x001e
                r0 = r1
            L_0x001e:
                if (r0 == 0) goto L_0x009f
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r8 = r7.f18555c
                com.hbg.lib.network.hbg.core.bean.LiveGroup r8 = r8.liveGroup
                int r0 = r8.type
                if (r0 == r1) goto L_0x006c
                int r8 = r8.hasJion
                if (r8 != r1) goto L_0x002d
                goto L_0x006c
            L_0x002d:
                b2.a r8 = b2.a.d()
                java.lang.String r0 = "/webView/index"
                com.alibaba.android.arouter.facade.Postcard r8 = r8.a(r0)
                com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "live/community/privateGroup?groupId="
                r1.append(r2)
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r2 = r7.f18554b
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r2 = r2.f18466m
                if (r2 == 0) goto L_0x0054
                com.hbg.lib.network.hbg.core.bean.LiveGroup r2 = r2.liveGroup
                if (r2 == 0) goto L_0x0054
                java.lang.String r2 = r2.groupId
                goto L_0x0055
            L_0x0054:
                r2 = 0
            L_0x0055:
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r0 = r0.k(r1)
                java.lang.String r1 = "url"
                com.alibaba.android.arouter.facade.Postcard r8 = r8.withString(r1, r0)
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r0 = r7.f18554b
                r8.navigation(r0)
                goto L_0x009f
            L_0x006c:
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r8 = r7.f18554b
                r8.I = r1
                int r8 = android.os.Build.VERSION.SDK_INT
                r0 = 23
                if (r8 < r0) goto L_0x0087
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r8 = r7.f18554b
                boolean r8 = android.provider.Settings.canDrawOverlays(r8)
                if (r8 == 0) goto L_0x008c
                com.hbg.module.content.helper.live.HbgLiveHelper r8 = com.hbg.module.content.helper.live.HbgLiveHelper.f18227a
                boolean r8 = r8.s()
                if (r8 == 0) goto L_0x008c
            L_0x0087:
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r8 = r7.f18554b
                r8.Fl()
            L_0x008c:
                dd.b r0 = dd.b.f22740a
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r1 = r7.f18554b
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r8 = r7.f18555c
                com.hbg.lib.network.hbg.core.bean.LiveGroup r8 = r8.liveGroup
                java.lang.String r2 = r8.groupId
                java.lang.String r3 = r8.title
                r4 = 0
                r5 = 8
                r6 = 0
                dd.b.k(r0, r1, r2, r3, r4, r5, r6)
            L_0x009f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.live.LiveDetailActivity.j.onViewClick(android.view.View):void");
        }
    }

    public static final class j0 implements com.hbg.module.huobi.im.gift.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18556a;

        public j0(LiveDetailActivity liveDetailActivity) {
            this.f18556a = liveDetailActivity;
        }

        public void a() {
            this.f18556a.jk();
        }

        public void b(String str, int i11) {
            if (i11 == 1 && this.f18556a.f18456g0 == 2) {
                this.f18556a.f18456g0 = 1;
                this.f18556a.yk();
                return;
            }
            this.f18556a.f18456g0 = 2;
            LiveDetailActivity.Ki(this.f18556a).f19247s1.setVisibility(8);
            this.f18556a.Zj();
        }
    }

    public static final class k implements com.hbg.module.content.utls.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f18557a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18558b;

        public k(LiveDetailBean liveDetailBean, LiveDetailActivity liveDetailActivity) {
            this.f18557a = liveDetailBean;
            this.f18558b = liveDetailActivity;
        }

        public void a() {
            this.f18557a.status = 2;
            this.f18558b.initData();
        }

        public void b(long j11) {
            a.C0128a.a(this, j11);
        }
    }

    public static final class k0 implements d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18559a;

        public k0(LiveDetailActivity liveDetailActivity) {
            this.f18559a = liveDetailActivity;
        }

        public void a(String str, String str2, String str3) {
            LiveDetailBean Hi = this.f18559a.f18466m;
            if (com.hbg.module.libkt.base.ext.b.w(Hi != null ? Hi.giftTopUser : null)) {
                GiftUser giftUser = new GiftUser();
                giftUser.avatar = str;
                giftUser.nickname = str2;
                giftUser.uidUnique = str3;
                com.hbg.module.content.adapter.j Ai = this.f18559a.f18469n0;
                if (Ai != null) {
                    Ai.a(1, CollectionsKt__CollectionsKt.g(giftUser));
                }
            }
        }
    }

    public static final class l extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18560b;

        public l(LiveDetailActivity liveDetailActivity) {
            this.f18560b = liveDetailActivity;
        }

        public void onViewClick(View view) {
            this.f18560b.bb();
        }
    }

    public static final class l0 implements d.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18561a;

        public l0(LiveDetailActivity liveDetailActivity) {
            this.f18561a = liveDetailActivity;
        }

        public void a(Map<?, ?> map) {
            rj.b k11;
            com.hbg.module.content.utls.l Ii = this.f18561a.f18482w0;
            if (Ii != null && (k11 = Ii.k()) != null) {
                k11.I("redPacketQueue.addSinglePacket('" + new Gson().toJson((Object) map) + "')");
            }
        }

        public void b(String str) {
        }

        public void c(String str) {
            rj.b k11;
            com.hbg.module.content.utls.l Ii = this.f18561a.f18482w0;
            if (Ii != null && (k11 = Ii.k()) != null) {
                k11.I("redPacketQueue.deletePacket('" + str + "')");
            }
        }

        public void d(String str, String str2, String str3) {
            d.h.a.a(this, str, str2, str3);
        }
    }

    public static final class m implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18562b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18563c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18564d;

        public m(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18562b = view;
            this.f18563c = j11;
            this.f18564d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            LiveSpeaker Ri;
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18562b) > this.f18563c || (this.f18562b instanceof Checkable)) {
                sVar.e(this.f18562b, currentTimeMillis);
                TextView textView = (TextView) this.f18562b;
                HbgBaseProvider fg2 = this.f18564d.fg();
                if ((fg2 != null && fg2.j(this.f18564d)) && (Ri = this.f18564d.f18455f0) != null) {
                    RequestExtKt.d(v7.b.a().requestCommunityAttention(MapsKt__MapsKt.l(kotlin.l.a("type", 1), kotlin.l.a("uidUnique", Ri.uidUnique))), new LiveDetailActivity$initData$1$8$1$1(Ri, this.f18564d), LiveDetailActivity$initData$1$8$1$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class m0 extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18565b;

        public m0(LiveDetailActivity liveDetailActivity) {
            this.f18565b = liveDetailActivity;
        }

        public void onViewClick(View view) {
            this.f18565b.Rj();
        }
    }

    public static final class n implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18566b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18567c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18568d;

        public n(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18566b = view;
            this.f18567c = j11;
            this.f18568d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            LiveSpeaker Ri;
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18566b) > this.f18567c || (this.f18566b instanceof Checkable)) {
                sVar.e(this.f18566b, currentTimeMillis);
                TextView textView = (TextView) this.f18566b;
                HbgBaseProvider fg2 = this.f18568d.fg();
                if ((fg2 != null && fg2.j(this.f18568d)) && (Ri = this.f18568d.f18455f0) != null) {
                    RequestExtKt.d(v7.b.a().requestCommunityAttention(MapsKt__MapsKt.l(kotlin.l.a("type", 1), kotlin.l.a("uidUnique", Ri.uidUnique))), new LiveDetailActivity$initData$1$13$1$1(Ri, this.f18568d), LiveDetailActivity$initData$1$13$1$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class n0 extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18569b;

        public n0(LiveDetailActivity liveDetailActivity) {
            this.f18569b = liveDetailActivity;
        }

        public void onViewClick(View view) {
            LiveDetailActivity.Ki(this.f18569b).L0.getRoot().setVisibility(8);
            this.f18569b.Rj();
        }
    }

    public static final class o extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GiftDataInfo f18570a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18571b;

        public o(GiftDataInfo giftDataInfo, LiveDetailActivity liveDetailActivity) {
            this.f18570a = giftDataInfo;
            this.f18571b = liveDetailActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
            r6 = r2.get(r6);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPageSelected(int r6) {
            /*
                r5 = this;
                java.lang.String r0 = ""
                super.onPageSelected(r6)
                r1 = 0
                com.hbg.module.libkt.utils.event.bean.GiftDataInfo r2 = r5.f18570a     // Catch:{ Exception -> 0x002e }
                java.util.ArrayList r2 = r2.getGiftGroups()     // Catch:{ Exception -> 0x002e }
                boolean r2 = com.hbg.module.libkt.base.ext.b.w(r2)     // Catch:{ Exception -> 0x002e }
                if (r2 == 0) goto L_0x0013
                goto L_0x002e
            L_0x0013:
                com.hbg.module.libkt.utils.event.bean.GiftDataInfo r2 = r5.f18570a     // Catch:{ Exception -> 0x002e }
                java.util.ArrayList r2 = r2.getGiftGroups()     // Catch:{ Exception -> 0x002e }
                if (r2 == 0) goto L_0x002d
                java.lang.Object r6 = r2.get(r6)     // Catch:{ Exception -> 0x002e }
                com.hbg.module.libkt.utils.event.bean.GiftGroup r6 = (com.hbg.module.libkt.utils.event.bean.GiftGroup) r6     // Catch:{ Exception -> 0x002e }
                if (r6 == 0) goto L_0x002d
                int r6 = r6.getGroupId()     // Catch:{ Exception -> 0x002e }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x002e }
                r0 = r6
                goto L_0x002e
            L_0x002d:
                r0 = r1
            L_0x002e:
                r6 = 6
                kotlin.Pair[] r6 = new kotlin.Pair[r6]
                r2 = 0
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r3 = r5.f18571b
                int r3 = r3.f18460j
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.String r4 = "state"
                kotlin.Pair r3 = kotlin.l.a(r4, r3)
                r6[r2] = r3
                r2 = 1
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r3 = r5.f18571b
                java.lang.String r3 = r3.Sj()
                java.lang.String r4 = "liveid"
                kotlin.Pair r3 = kotlin.l.a(r4, r3)
                r6[r2] = r3
                r2 = 2
                java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
                java.lang.String r4 = "player"
                kotlin.Pair r3 = kotlin.l.a(r4, r3)
                r6[r2] = r3
                r2 = 3
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r3 = r5.f18571b
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r3 = r3.f18466m
                if (r3 == 0) goto L_0x006c
                java.lang.String r3 = r3.title
                goto L_0x006d
            L_0x006c:
                r3 = r1
            L_0x006d:
                java.lang.String r4 = "title"
                kotlin.Pair r3 = kotlin.l.a(r4, r3)
                r6[r2] = r3
                r2 = 4
                com.hbg.module.content.ui.activity.live.LiveDetailActivity r3 = r5.f18571b
                com.hbg.lib.network.hbg.core.bean.LiveSpeaker r3 = r3.f18455f0
                if (r3 == 0) goto L_0x0080
                java.lang.String r1 = r3.showId
            L_0x0080:
                java.lang.String r3 = "upid"
                kotlin.Pair r1 = kotlin.l.a(r3, r1)
                r6[r2] = r1
                r1 = 5
                java.lang.String r2 = "gift"
                kotlin.Pair r0 = kotlin.l.a(r2, r0)
                r6[r1] = r0
                java.util.HashMap r6 = kotlin.collections.MapsKt__MapsKt.j(r6)
                java.lang.String r0 = "APP_LIVE_reward_teb"
                nc.c.a(r0, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.live.LiveDetailActivity.o.onPageSelected(int):void");
        }
    }

    public static final class o0 extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18572b;

        public o0(LiveDetailActivity liveDetailActivity) {
            this.f18572b = liveDetailActivity;
        }

        public void onViewClick(View view) {
            HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
            if (hbgLiveHelper.s()) {
                LiveDetailActivity.Ki(this.f18572b).f19255v0.setImageResource(R$drawable.icon_live_play);
                hbgLiveHelper.x();
                return;
            }
            LiveDetailActivity.Ki(this.f18572b).f19255v0.setImageResource(R$drawable.icon_live_pause);
            hbgLiveHelper.y();
        }
    }

    public static final class p implements com.hbg.module.content.adapter.r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18575a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f18576b;

        public p(LiveDetailActivity liveDetailActivity, LiveDetailBean liveDetailBean) {
            this.f18575a = liveDetailActivity;
            this.f18576b = liveDetailBean;
        }

        public void a(boolean z11) {
            ArrayList<String> l11;
            int i11 = 0;
            if (z11) {
                LiveDetailActivity.Ki(this.f18575a).G2.setVisibility(0);
                LiveDetailActivity.Ki(this.f18575a).L2.setVisibility(8);
                LiveDetailActivity.Ki(this.f18575a).f19246r2.setBackgroundResource(R$drawable.sister_slide_btn_sel);
                com.hbg.module.content.helper.live.f.f18246a.h(this.f18576b.sisterGroupList.size());
                return;
            }
            LiveDetailActivity.Ki(this.f18575a).G2.setVisibility(8);
            LiveDetailActivity.Ki(this.f18575a).L2.setVisibility(0);
            LiveDetailActivity.Ki(this.f18575a).f19246r2.setBackgroundResource(R$drawable.sister_slide_btn);
            com.hbg.module.content.helper.live.f fVar = com.hbg.module.content.helper.live.f.f18246a;
            com.hbg.module.content.adapter.t Qi = this.f18575a.f18480v0;
            if (!(Qi == null || (l11 = Qi.l()) == null)) {
                i11 = l11.size();
            }
            fVar.h(i11);
        }
    }

    public static final class p0 implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18577a;

        public p0(LiveDetailActivity liveDetailActivity) {
            this.f18577a = liveDetailActivity;
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
            this.f18577a.E = true;
            Handler Li = this.f18577a.Zf();
            if (Li != null) {
                Li.removeCallbacks(this.f18577a.A);
            }
            LiveDetailActivity.Ki(this.f18577a).f19225j1.clearAnimation();
            LiveDetailActivity.Ki(this.f18577a).f19206d0.clearAnimation();
            LiveDetailActivity.Ki(this.f18577a).E2.clearAnimation();
            LiveDetailActivity.Ki(this.f18577a).f19225j1.setVisibility(0);
            LiveDetailActivity.Ki(this.f18577a).f19206d0.setVisibility(0);
            LiveDetailActivity.Ki(this.f18577a).E2.setVisibility(0);
        }

        @SensorsDataInstrumented
        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f18577a.E = false;
            Handler Li = this.f18577a.Zf();
            if (Li != null) {
                Li.postDelayed(this.f18577a.A, 3000);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
        }
    }

    public static final class q extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18578b;

        public q(LiveDetailActivity liveDetailActivity) {
            this.f18578b = liveDetailActivity;
        }

        public void onViewClick(View view) {
            Handler Li = this.f18578b.Zf();
            if (Li != null) {
                Li.removeCallbacks(this.f18578b.B);
            }
            LiveDetailActivity.Ki(this.f18578b).I0.E.clearAnimation();
            LiveDetailActivity.Ki(this.f18578b).I0.C.clearAnimation();
            LiveDetailActivity.Ki(this.f18578b).I0.D.clearAnimation();
            Handler Li2 = this.f18578b.Zf();
            if (Li2 != null) {
                Li2.post(this.f18578b.B);
            }
        }
    }

    public static final class q0 implements ImCommonCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18579a;

        public q0(LiveDetailActivity liveDetailActivity) {
            this.f18579a = liveDetailActivity;
        }

        public void onFailed(int i11, String str) {
            if (i11 == LiveErrorCode.LIVE_USER_IM_KICK.getCode()) {
                ToastUtil.toastShortMessage(this.f18579a.getString(R$string.n_im_kick_out));
                this.f18579a.finish();
            } else if (i11 == LiveErrorCode.LIVE_USER_IM_BLACK.getCode()) {
                ToastUtil.toastShortMessage(this.f18579a.getString(R$string.n_im_block_done));
                this.f18579a.finish();
            }
        }

        public void onSuccess() {
        }
    }

    public static final class r extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18580b;

        public r(LiveDetailActivity liveDetailActivity) {
            this.f18580b = liveDetailActivity;
        }

        public static final void b(LiveDetailActivity liveDetailActivity) {
            LiveDetailActivity.Ki(liveDetailActivity).I0.B.setVisibility(0);
            liveDetailActivity.nl();
            LiveDetailActivity.Ki(liveDetailActivity).I0.E.setVisibility(0);
            LiveDetailActivity.Ki(liveDetailActivity).I0.C.setVisibility(0);
            LiveDetailActivity.Ki(liveDetailActivity).I0.D.setVisibility(0);
        }

        public void onViewClick(View view) {
            LiveDetailActivity.Ki(this.f18580b).I0.B.setVisibility(4);
            LiveDetailActivity.Ki(this.f18580b).I0.E.setVisibility(4);
            LiveDetailActivity.Ki(this.f18580b).I0.C.setVisibility(4);
            LiveDetailActivity.Ki(this.f18580b).I0.D.setVisibility(4);
            Handler Li = this.f18580b.Zf();
            if (Li != null) {
                Li.postDelayed(new u1(this.f18580b), 10);
            }
            Handler Li2 = this.f18580b.Zf();
            if (Li2 != null) {
                Li2.postDelayed(this.f18580b.B, 4000);
            }
        }
    }

    public static final class r0 implements cf.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f18581a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18582b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f18583c;

        public r0(View view, LiveDetailActivity liveDetailActivity, LiveDetailBean liveDetailBean) {
            this.f18581a = view;
            this.f18582b = liveDetailActivity;
            this.f18583c = liveDetailBean;
        }

        public void a(boolean z11) {
            int i11;
            View q11;
            int i12;
            int i13;
            TextView textView = (TextView) this.f18581a.findViewById(R$id.tvName);
            LiveSpeaker Ri = this.f18582b.f18455f0;
            String str = null;
            textView.setText(Ri != null ? Ri.nickname : null);
            ((TextView) this.f18581a.findViewById(R$id.tvTitle)).setText(this.f18583c.title);
            SpannableString spannableString = new SpannableString("  " + this.f18583c.introduction);
            Drawable drawable = this.f18582b.getResources().getDrawable(R$drawable.icon_quotation_marks_left);
            int i14 = 0;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableString.setSpan(new com.hbg.module.content.utls.f(drawable, 2), 0, 1, 33);
            ((TextView) this.f18581a.findViewById(R$id.tvDesc)).setText(spannableString);
            LinearLayout linearLayout = (LinearLayout) this.f18581a.findViewById(R$id.llPop);
            TextView textView2 = (TextView) this.f18581a.findViewById(R$id.tvPop);
            LinearLayout linearLayout2 = (LinearLayout) this.f18581a.findViewById(R$id.llPlayTime);
            int i15 = this.f18583c.status;
            if (i15 == 1) {
                linearLayout.setBackgroundResource(R$color.color_live_appointment);
                kotlin.jvm.internal.d0 d0Var = kotlin.jvm.internal.d0.f56774a;
                textView2.setText(String.format(this.f18582b.getResources().getString(R$string.n_content_live_appointment), Arrays.copyOf(new Object[]{he.b.e(String.valueOf(this.f18583c.appointedNum))}, 1)));
                ((TextView) this.f18581a.findViewById(R$id.tvPlayTime)).setText(String.format(this.f18582b.getResources().getString(R$string.n_live_start_playing_time), Arrays.copyOf(new Object[]{new SimpleDateFormat("MM-dd HH:mm ").format(new Date(this.f18583c.startTime))}, 1)));
                i11 = 0;
            } else {
                if (i15 == 2) {
                    i12 = R$color.color_live_playing;
                } else {
                    i12 = R$color.color_live_playback;
                }
                linearLayout.setBackgroundResource(i12);
                kotlin.jvm.internal.d0 d0Var2 = kotlin.jvm.internal.d0.f56774a;
                Resources resources = this.f18582b.getResources();
                if (this.f18583c.status == 2) {
                    i13 = R$string.n_content_live_watch;
                } else {
                    i13 = R$string.n_content_live_watched;
                }
                textView2.setText(String.format(resources.getString(i13), Arrays.copyOf(new Object[]{he.b.e(this.f18583c.onlineNum)}, 1)));
                i11 = 8;
            }
            linearLayout2.setVisibility(i11);
            String k11 = BaseModuleConfig.a().k("live/detail/h5?id=" + StringUtils.b(this.f18583c.f70249id));
            HbgBaseShareProvider gg2 = this.f18582b.gg();
            if (!(gg2 == null || (q11 = gg2.q(this.f18582b, this.f18581a)) == null)) {
                LiveDetailActivity liveDetailActivity = this.f18582b;
                LiveDetailBean liveDetailBean = this.f18583c;
                int i16 = R$id.llShareView;
                LinearLayout linearLayout3 = (LinearLayout) q11.findViewById(i16);
                HbgBaseShareProvider gg3 = liveDetailActivity.gg();
                if (gg3 != null) {
                    View findViewById = q11.findViewById(i16);
                    String str2 = liveDetailBean.f70249id;
                    String str3 = liveDetailBean.coverImageUrl;
                    String str4 = liveDetailBean.title;
                    LiveSpeaker Ri2 = liveDetailActivity.f18455f0;
                    if (Ri2 != null) {
                        str = Ri2.nickname;
                    }
                    String str5 = str;
                    int measuredWidth = linearLayout3 != null ? linearLayout3.getMeasuredWidth() : 0;
                    if (linearLayout3 != null) {
                        i14 = linearLayout3.getMeasuredHeight();
                    }
                    gg3.h(liveDetailActivity, findViewById, str2, k11, str3, str4, str5, measuredWidth, i14);
                }
            }
            Integer valueOf = Integer.valueOf(this.f18583c.status);
            LiveDetailBean liveDetailBean2 = this.f18583c;
            LiveTrackUtils.d(valueOf, liveDetailBean2.f70249id, liveDetailBean2.title, this.f18582b.Sj());
        }
    }

    public static final class s extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18584b;

        public s(LiveDetailActivity liveDetailActivity) {
            this.f18584b = liveDetailActivity;
        }

        public void onViewClick(View view) {
            this.f18584b.yl(R$string.n_live_p_480, 1);
        }
    }

    public static final class s0 implements qd.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18585a;

        public s0(LiveDetailActivity liveDetailActivity) {
            this.f18585a = liveDetailActivity;
        }

        public void a(int i11) {
            Log.d("LiveDetailActivity", "refreshPanelHeight -- height:" + i11);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) LiveDetailActivity.Ki(this.f18585a).P0.getLayoutParams();
            if (i11 != 0) {
                layoutParams.bottomMargin = ((int) (((float) i11) * (((float) com.hbg.module.libkt.base.ext.c.c()) / 750.0f))) + com.hbg.module.libkt.base.ext.c.a(16.0f);
            } else {
                layoutParams.bottomMargin = com.hbg.module.libkt.base.ext.c.a(320.0f);
            }
        }
    }

    public static final class t extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18589b;

        public t(LiveDetailActivity liveDetailActivity) {
            this.f18589b = liveDetailActivity;
        }

        public void onViewClick(View view) {
            this.f18589b.yl(R$string.n_live_p_720, 2);
        }
    }

    public static final class t0 extends IUIKitCallback<GroupInfo> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18590a;

        public t0(LiveDetailActivity liveDetailActivity) {
            this.f18590a = liveDetailActivity;
        }

        /* renamed from: a */
        public void onSuccess(GroupInfo groupInfo) {
            try {
                HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
                LiveDetailBean n11 = hbgLiveHelper.n();
                LiveGroup liveGroup = n11 != null ? n11.liveGroup : null;
                if (liveGroup != null) {
                    liveGroup.userCount = String.valueOf(groupInfo != null ? groupInfo.getMemberCount() : 0);
                }
                LiveDetailActivity.Ki(this.f18590a).M(hbgLiveHelper.n());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        public void onError(String str, int i11, String str2) {
        }
    }

    public static final class u extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18591b;

        public u(LiveDetailActivity liveDetailActivity) {
            this.f18591b = liveDetailActivity;
        }

        public void onViewClick(View view) {
            this.f18591b.yl(R$string.n_live_p_1080, 3);
        }
    }

    public static final class u0 implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18592b;

        public u0(LiveDetailActivity liveDetailActivity) {
            this.f18592b = liveDetailActivity;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            JSONArray jSONArray;
            com.hbg.module.content.adapter.t Qi = this.f18592b.f18480v0;
            if (Qi != null) {
                jSONArray = null;
                for (String str : Qi.l()) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    jSONArray.put(str);
                }
            } else {
                jSONArray = null;
            }
            JSONObject jSONObject = new JSONObject();
            GiftBean zi2 = this.f18592b.f18463k0;
            jSONObject.put("giftId", zi2 != null ? zi2.getGiftId() : null);
            jSONObject.put("giftNum", this.f18592b.f18461j0 - 1);
            jSONObject.put("cid", this.f18592b.Sj());
            jSONObject.put("type", 1);
            if (jSONArray != null) {
                jSONObject.put("sisterGroupUniqueUidList", jSONArray);
            }
            this.f18592b.zl("sendGift('" + jSONObject + "')");
            this.f18592b.f18461j0 = 1;
            this.f18592b.f18463k0 = null;
            LiveDetailActivity.Ki(this.f18592b).f19243q1.setVisibility(8);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static final class v implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18593b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18594c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18595d;

        public v(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18593b = view;
            this.f18594c = j11;
            this.f18595d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18593b) > this.f18594c || (this.f18593b instanceof Checkable)) {
                sVar.e(this.f18593b, currentTimeMillis);
                Handler Li = this.f18595d.Zf();
                if (Li != null) {
                    Li.removeCallbacks(this.f18595d.C);
                }
                LiveDetailActivity.Ki(this.f18595d).K2.clearAnimation();
                LiveDetailActivity.Ki(this.f18595d).f19208d2.clearAnimation();
                LiveDetailActivity.Ki(this.f18595d).Y1.clearAnimation();
                Handler Li2 = this.f18595d.Zf();
                if (Li2 != null) {
                    Li2.post(this.f18595d.C);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class v0 implements androidx.lifecycle.z, kotlin.jvm.internal.u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d10.l f18596b;

        public v0(d10.l lVar) {
            this.f18596b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof androidx.lifecycle.z) || !(obj instanceof kotlin.jvm.internal.u)) {
                return false;
            }
            return kotlin.jvm.internal.x.b(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f18596b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f18596b.invoke(obj);
        }
    }

    public static final class w implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18597b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18598c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18599d;

        public w(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18597b = view;
            this.f18598c = j11;
            this.f18599d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18597b) > this.f18598c || (this.f18597b instanceof Checkable)) {
                sVar.e(this.f18597b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18597b;
                LiveDetailActivity.Ki(this.f18599d).f19249t0.setVisibility(4);
                LiveDetailActivity.Ki(this.f18599d).K2.setVisibility(4);
                LiveDetailActivity.Ki(this.f18599d).f19208d2.setVisibility(4);
                LiveDetailActivity.Ki(this.f18599d).Y1.setVisibility(4);
                Handler Li = this.f18599d.Zf();
                if (Li != null) {
                    Li.postDelayed(new y(this.f18599d), 10);
                }
                Handler Li2 = this.f18599d.Zf();
                if (Li2 != null) {
                    Li2.postDelayed(this.f18599d.C, 4000);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class w0 extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18600b;

        public w0(LiveDetailActivity liveDetailActivity) {
            this.f18600b = liveDetailActivity;
        }

        public void onViewClick(View view) {
            this.f18600b.startActivity(new Intent(view != null ? view.getContext() : null, LiveDetailActivity.class));
            FloatView Pj = this.f18600b.Pj();
            if (Pj != null) {
                Pj.m();
            }
        }
    }

    public static final class x implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18601b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18602c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18603d;

        public x(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18601b = view;
            this.f18602c = j11;
            this.f18603d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18601b) > this.f18602c || (this.f18601b instanceof Checkable)) {
                sVar.e(this.f18601b, currentTimeMillis);
                RoundTextView roundTextView = (RoundTextView) this.f18601b;
                nc.c.a("app_livehouse_plazeclick", this.f18603d.K);
                b2.a.d().a("/content/Index").withString("type", "2").navigation();
                this.f18603d.finish();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class x0 extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18604b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f18605c;

        public x0(View view, View view2) {
            this.f18604b = view;
            this.f18605c = view2;
        }

        public void onViewClick(View view) {
            this.f18604b.setVisibility(8);
            this.f18605c.setVisibility(0);
            HbgLiveHelper.f18227a.B();
        }
    }

    public static final class y implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18606b;

        public y(LiveDetailActivity liveDetailActivity) {
            this.f18606b = liveDetailActivity;
        }

        public final void run() {
            LiveDetailActivity.Ki(this.f18606b).f19249t0.setVisibility(0);
            this.f18606b.ol();
            LiveDetailActivity.Ki(this.f18606b).K2.setVisibility(0);
            LiveDetailActivity.Ki(this.f18606b).f19208d2.setVisibility(0);
            LiveDetailActivity.Ki(this.f18606b).Y1.setVisibility(0);
        }
    }

    public static final class y0 implements com.hbg.module.content.helper.live.g {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18607b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f18608c;

        public y0(View view, View view2) {
            this.f18607b = view;
            this.f18608c = view2;
        }

        public void B7(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
            this.f18607b.setVisibility(0);
            this.f18608c.setVisibility(8);
        }

        public void Bb(V2TXLivePlayer v2TXLivePlayer, boolean z11, Bundle bundle) {
            this.f18607b.setVisibility(8);
            this.f18608c.setVisibility(8);
        }

        public void J3(int i11) {
        }

        public void O9() {
        }

        public void S7() {
            this.f18607b.setVisibility(8);
            this.f18608c.setVisibility(8);
        }

        public void Ta(V2TXLivePlayer v2TXLivePlayer, boolean z11, Bundle bundle) {
            this.f18607b.setVisibility(8);
            this.f18608c.setVisibility(8);
        }

        public void V6(int i11, int i12) {
        }

        public void X8(V2TXLivePlayer v2TXLivePlayer, int i11, String str, Bundle bundle) {
        }

        public void bb() {
        }

        public void da() {
            this.f18607b.setVisibility(0);
            this.f18608c.setVisibility(8);
        }

        public void f4() {
            this.f18607b.setVisibility(8);
            this.f18608c.setVisibility(0);
        }

        public void ic(V2TXLivePlayer v2TXLivePlayer, int i11, String str, Bundle bundle) {
            this.f18607b.setVisibility(8);
            this.f18608c.setVisibility(0);
        }

        public void onPlayEnd() {
        }
    }

    public static final class z implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18609b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18610c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18611d;

        public z(View view, long j11, LiveDetailActivity liveDetailActivity) {
            this.f18609b = view;
            this.f18610c = j11;
            this.f18611d = liveDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18609b) > this.f18610c || (this.f18609b instanceof Checkable)) {
                sVar.e(this.f18609b, currentTimeMillis);
                TextView textView = (TextView) this.f18609b;
                this.f18611d.rj();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class z0 implements LiveGetFreeGiftDialogFragment.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18612a;

        public z0(LiveDetailActivity liveDetailActivity) {
            this.f18612a = liveDetailActivity;
        }

        public void a() {
            TUIBarrageButton ui2;
            HbgBaseProvider fg2 = this.f18612a.fg();
            boolean z11 = true;
            if (fg2 == null || !fg2.j(this.f18612a)) {
                z11 = false;
            }
            if (z11 && (ui2 = this.f18612a.V) != null) {
                ui2.h(this.f18612a);
            }
        }

        public void b() {
            this.f18612a.Ll();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.l();
     */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Ak(com.hbg.module.content.ui.activity.live.LiveDetailActivity r4, com.hbg.lib.network.hbg.core.bean.LiveDetailBean r5, android.view.View r6) {
        /*
            com.hbg.module.content.adapter.t r0 = r4.f18480v0
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.util.ArrayList r0 = r0.l()
            if (r0 == 0) goto L_0x0010
            int r0 = r0.size()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            java.util.ArrayList<com.hbg.lib.network.hbg.core.bean.SisterBean> r2 = r5.sisterGroupList
            int r2 = r2.size()
            r3 = 8
            if (r0 != r2) goto L_0x0051
            x1.a r5 = r4.Yf()
            lc.m r5 = (lc.m) r5
            android.view.View r5 = r5.G2
            r5.setVisibility(r3)
            x1.a r5 = r4.Yf()
            lc.m r5 = (lc.m) r5
            android.view.View r5 = r5.L2
            r5.setVisibility(r1)
            x1.a r5 = r4.Yf()
            lc.m r5 = (lc.m) r5
            android.widget.TextView r5 = r5.f19246r2
            int r0 = com.hbg.module.content.R$drawable.sister_slide_btn
            r5.setBackgroundResource(r0)
            com.hbg.module.content.adapter.t r5 = r4.f18480v0
            if (r5 == 0) goto L_0x004b
            java.util.ArrayList r5 = r5.l()
            if (r5 == 0) goto L_0x004b
            r5.clear()
        L_0x004b:
            com.hbg.module.content.helper.live.f r5 = com.hbg.module.content.helper.live.f.f18246a
            r5.h(r1)
            goto L_0x00ae
        L_0x0051:
            x1.a r0 = r4.Yf()
            lc.m r0 = (lc.m) r0
            android.view.View r0 = r0.G2
            r0.setVisibility(r1)
            x1.a r0 = r4.Yf()
            lc.m r0 = (lc.m) r0
            android.view.View r0 = r0.L2
            r0.setVisibility(r3)
            x1.a r0 = r4.Yf()
            lc.m r0 = (lc.m) r0
            android.widget.TextView r0 = r0.f19246r2
            int r1 = com.hbg.module.content.R$drawable.sister_slide_btn_sel
            r0.setBackgroundResource(r1)
            com.hbg.module.content.adapter.t r0 = r4.f18480v0
            if (r0 == 0) goto L_0x0081
            java.util.ArrayList r0 = r0.l()
            if (r0 == 0) goto L_0x0081
            r0.clear()
        L_0x0081:
            java.util.ArrayList<com.hbg.lib.network.hbg.core.bean.SisterBean> r0 = r5.sisterGroupList
            java.util.Iterator r0 = r0.iterator()
        L_0x0087:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a3
            java.lang.Object r1 = r0.next()
            com.hbg.lib.network.hbg.core.bean.SisterBean r1 = (com.hbg.lib.network.hbg.core.bean.SisterBean) r1
            com.hbg.module.content.adapter.t r2 = r4.f18480v0
            if (r2 == 0) goto L_0x0087
            java.util.ArrayList r2 = r2.l()
            if (r2 == 0) goto L_0x0087
            java.lang.String r1 = r1.uniqueUid
            r2.add(r1)
            goto L_0x0087
        L_0x00a3:
            com.hbg.module.content.helper.live.f r0 = com.hbg.module.content.helper.live.f.f18246a
            java.util.ArrayList<com.hbg.lib.network.hbg.core.bean.SisterBean> r5 = r5.sisterGroupList
            int r5 = r5.size()
            r0.h(r5)
        L_0x00ae:
            com.hbg.module.content.adapter.t r4 = r4.f18480v0
            if (r4 == 0) goto L_0x00b5
            r4.notifyDataSetChanged()
        L_0x00b5:
            com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.live.LiveDetailActivity.Ak(com.hbg.module.content.ui.activity.live.LiveDetailActivity, com.hbg.lib.network.hbg.core.bean.LiveDetailBean, android.view.View):void");
    }

    public static final void Ck(View view) {
        view.setVisibility(8);
    }

    @SensorsDataInstrumented
    public static final void Gl(LiveDetailActivity liveDetailActivity, View view) {
        HbgLiveHelper.f18227a.A();
        FloatView floatView = liveDetailActivity.D0;
        if (floatView != null) {
            floatView.m();
        }
        liveDetailActivity.J = false;
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Hj(LiveDetailActivity liveDetailActivity, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(liveDetailActivity) || liveDetailActivity.f18460j == 1) {
            liveDetailActivity.finish();
            return;
        }
        DialogUtils.c0(liveDetailActivity, liveDetailActivity.getResources().getString(R$string.n_live_perm_title), liveDetailActivity.getResources().getString(R$string.n_live_perm_tips), liveDetailActivity.getResources().getString(R$string.n_cancel), liveDetailActivity.getResources().getString(R$string.n_otc_confirm_open), new o0(liveDetailActivity), new p0(liveDetailActivity));
    }

    @SensorsDataInstrumented
    public static final void Hk(LiveDetailActivity liveDetailActivity, View view) {
        ((lc.m) liveDetailActivity.Yf()).N0.getRoot().setVisibility(8);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Hl(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Ij(LiveDetailActivity liveDetailActivity, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        liveDetailActivity.finish();
    }

    @SensorsDataInstrumented
    public static final void Il(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Jj(LiveDetailActivity liveDetailActivity, HBDialogFragment hBDialogFragment) {
        liveDetailActivity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + liveDetailActivity.getPackageName())), 200);
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        liveDetailActivity.finish();
    }

    public static final /* synthetic */ lc.m Ki(LiveDetailActivity liveDetailActivity) {
        return (lc.m) liveDetailActivity.Yf();
    }

    public static final void Kj(LiveDetailActivity liveDetailActivity, HBDialogFragment hBDialogFragment) {
        liveDetailActivity.G = false;
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        liveDetailActivity.finish();
    }

    public static final void Kl(LiveDetailActivity liveDetailActivity) {
        liveDetailActivity.f18478u0 = null;
    }

    @SensorsDataInstrumented
    public static final void Lk(LiveDetailActivity liveDetailActivity, View view) {
        ((lc.m) liveDetailActivity.Yf()).f19261x0.clearAnimation();
        if (liveDetailActivity.M != null) {
            ((lc.m) liveDetailActivity.Yf()).f19261x0.startAnimation(liveDetailActivity.M);
        }
        ((lc.m) liveDetailActivity.Yf()).f19226j2.clearAnimation();
        if (liveDetailActivity.N != null) {
            ((lc.m) liveDetailActivity.Yf()).f19226j2.startAnimation(liveDetailActivity.N);
        }
        nc.c.a("APP_LIVE_livestart_fabulous", liveDetailActivity.K);
        HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
        hbgLiveHelper.u();
        ((lc.m) liveDetailActivity.Yf()).B0.d();
        ((lc.m) liveDetailActivity.Yf()).M(hbgLiveHelper.n());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Mk(LiveDetailActivity liveDetailActivity, View view) {
        liveDetailActivity.wl(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Ml(LiveDetailActivity liveDetailActivity) {
        ((lc.m) liveDetailActivity.Yf()).f19248s2.setVisibility(8);
    }

    public static final void Nk(LiveDetailActivity liveDetailActivity) {
        int[] iArr = new int[2];
        try {
            ((lc.m) liveDetailActivity.Yf()).H0.getLocationOnScreen(iArr);
            com.hbg.module.huobi.im.gift.d dVar = com.hbg.module.huobi.im.gift.d.f19724a;
            dVar.O((float) iArr[0]);
            dVar.P((float) iArr[1]);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static final void Nl() {
        we.c.z(1);
    }

    public static final boolean Ok(LiveDetailActivity liveDetailActivity) {
        int i11;
        LiveDetailBean liveDetailBean = liveDetailActivity.f18466m;
        if ((liveDetailBean != null && liveDetailBean.hasGift == 1) && (i11 = liveDetailActivity.f18460j) == 1) {
            Pair[] pairArr = new Pair[7];
            pairArr[0] = kotlin.l.a("state", Integer.valueOf(i11));
            pairArr[1] = kotlin.l.a("liveid", liveDetailActivity.f18462k);
            pairArr[2] = kotlin.l.a(VineCardUtils.PLAYER_CARD, 2);
            LiveDetailBean liveDetailBean2 = liveDetailActivity.f18466m;
            Integer num = null;
            pairArr[3] = kotlin.l.a("title", liveDetailBean2 != null ? liveDetailBean2.title : null);
            LiveSpeaker liveSpeaker = liveDetailActivity.f18455f0;
            pairArr[4] = kotlin.l.a("upid", liveSpeaker != null ? liveSpeaker.showId : null);
            pairArr[5] = kotlin.l.a("roundid", "");
            CusMsgGiftSend j11 = com.hbg.module.huobi.im.gift.d.f19724a.j();
            if (j11 != null) {
                num = j11.getRule();
            }
            pairArr[6] = kotlin.l.a("lotterytype", num);
            nc.c.a("APP_LIVE_notice_myprize", MapsKt__MapsKt.j(pairArr));
        }
        return false;
    }

    public static final void Pk(LiveDetailActivity liveDetailActivity) {
        if (((lc.m) liveDetailActivity.Yf()).f19229k2.getLeft() == 0) {
            int[] iArr = new int[2];
            ((lc.m) liveDetailActivity.Yf()).W.getLocationOnScreen(iArr);
            ((lc.m) liveDetailActivity.Yf()).f19229k2.setLeft(iArr[0] - PixelUtils.a(14.0f));
            ((lc.m) liveDetailActivity.Yf()).f19229k2.setRight(iArr[0]);
            Log.d("live_redpacket", String.valueOf(((lc.m) liveDetailActivity.Yf()).f19229k2.getLeft()));
        }
    }

    @SensorsDataInstrumented
    public static final void Qk(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void Ql(LiveDetailActivity liveDetailActivity, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 1;
        }
        liveDetailActivity.Pl(i11);
    }

    public static final boolean Tl(View view, MotionEvent motionEvent) {
        return true;
    }

    public static /* synthetic */ void Wj(LiveDetailActivity liveDetailActivity, Integer num, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        liveDetailActivity.Vj(num, i11);
    }

    public static final void Wk(LiveDetailActivity liveDetailActivity, Object obj) {
        liveDetailActivity.Ol(1);
    }

    public static final void Xk(LiveDetailActivity liveDetailActivity, Object obj) {
        liveDetailActivity.Ol(2);
    }

    public static final void Yl(LiveDetailActivity liveDetailActivity) {
        ((lc.m) liveDetailActivity.Yf()).f19222i1.setVisibility(8);
    }

    public static final void Zk(LiveDetailActivity liveDetailActivity, Object obj) {
        liveDetailActivity.Ll();
    }

    public static final void cl(LiveDetailActivity liveDetailActivity) {
        liveDetailActivity.I = true;
        liveDetailActivity.Fl();
    }

    public static final void dk(LiveDetailActivity liveDetailActivity) {
        liveDetailActivity.ck();
    }

    public static final void dl(LiveDetailActivity liveDetailActivity) {
        TUIBarrageButton tUIBarrageButton;
        HbgBaseProvider fg2 = liveDetailActivity.fg();
        boolean z11 = true;
        if (fg2 == null || !fg2.j(liveDetailActivity)) {
            z11 = false;
        }
        if (z11 && (tUIBarrageButton = liveDetailActivity.V) != null) {
            tUIBarrageButton.h(liveDetailActivity);
        }
    }

    public static final void el(LiveDetailActivity liveDetailActivity) {
        Handler Zf;
        b2.a.d().a("/webView/index").withString("url", BaseModuleConfig.a().k("topic/welfare/h5/package")).navigation(liveDetailActivity);
        if ((Build.VERSION.SDK_INT < 23 || (Settings.canDrawOverlays(liveDetailActivity) && liveDetailActivity.f18460j != 1)) && liveDetailActivity.J && (Zf = liveDetailActivity.Zf()) != null) {
            Zf.postDelayed(new x0(liveDetailActivity), 1000);
        }
    }

    public static final void fl(LiveDetailActivity liveDetailActivity) {
        liveDetailActivity.I = true;
        liveDetailActivity.Fl();
    }

    public static final void gk(LiveDetailActivity liveDetailActivity) {
        liveDetailActivity.fk();
    }

    public static final void hk(LiveDetailActivity liveDetailActivity) {
        liveDetailActivity.ek();
    }

    public static final void ik(LiveDetailActivity liveDetailActivity) {
        liveDetailActivity.bk();
    }

    @SensorsDataInstrumented
    public static final void lk(LiveDetailActivity liveDetailActivity, View view) {
        TXVodPlayer tXVodPlayer = liveDetailActivity.f18452c0;
        boolean z11 = true;
        if (tXVodPlayer == null || !tXVodPlayer.isPlaying()) {
            z11 = false;
        }
        if (z11) {
            TXVodPlayer tXVodPlayer2 = liveDetailActivity.f18452c0;
            if (tXVodPlayer2 != null) {
                tXVodPlayer2.pause();
            }
            ((lc.m) liveDetailActivity.Yf()).S.setVisibility(0);
        } else {
            TXVodPlayer tXVodPlayer3 = liveDetailActivity.f18452c0;
            if (tXVodPlayer3 != null) {
                tXVodPlayer3.resume();
            }
            ((lc.m) liveDetailActivity.Yf()).S.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void nk(LiveDetailActivity liveDetailActivity, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        liveDetailActivity.mk(z11);
    }

    public static final void ok(LiveDetailActivity liveDetailActivity, String str) {
        if (sd.a.c(str)) {
            ((lc.m) liveDetailActivity.Yf()).S1.setText(liveDetailActivity.getResources().getString(R$string.n_live_chart_tips));
        } else {
            ((lc.m) liveDetailActivity.Yf()).S1.setText(str);
        }
    }

    @SensorsDataInstrumented
    public static final void pk(LiveDetailActivity liveDetailActivity, View view) {
        TUIBarrageButton tUIBarrageButton;
        HbgBaseProvider fg2 = liveDetailActivity.fg();
        boolean z11 = true;
        if (fg2 == null || !fg2.j(liveDetailActivity)) {
            z11 = false;
        }
        if (z11 && (tUIBarrageButton = liveDetailActivity.V) != null) {
            tUIBarrageButton.h(liveDetailActivity);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void qk(LiveDetailActivity liveDetailActivity) {
        ((lc.m) liveDetailActivity.Yf()).F0.getRoot().setVisibility(0);
        ((lc.m) liveDetailActivity.Yf()).F0.getRoot().startAnimation(liveDetailActivity.f18483x);
    }

    public static final void rk(LiveDetailActivity liveDetailActivity) {
        float scrollY = ((float) ((lc.m) liveDetailActivity.Yf()).N.getScrollY()) / (((float) ((lc.m) liveDetailActivity.Yf()).f19265y1.getHeight()) / 3.0f);
        if (scrollY > 1.0f) {
            scrollY = 1.0f;
        } else if (scrollY < 0.0f) {
            scrollY = 0.0f;
        }
        ((lc.m) liveDetailActivity.Yf()).f19265y1.setAlpha(((float) 1) - scrollY);
    }

    @SensorsDataInstrumented
    public static final void sk(LiveDetailActivity liveDetailActivity, LiveDetailBean liveDetailBean, View view) {
        String string = liveDetailActivity.getResources().getString(R$string.n_contract_trade_reminder_text);
        String str = liveDetailBean.archiveAlert;
        if (str == null) {
            str = "";
        }
        DialogUtils.b0(liveDetailActivity, string, str, (String) null, liveDetailActivity.getResources().getString(R$string.n_cancel), liveDetailActivity.getResources().getString(R$string.n_live_recover), s0.f18700a, new m0(liveDetailActivity));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void tj(HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public static final void tk(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.sh();
    }

    public static final boolean tl(LiveDetailActivity liveDetailActivity) {
        int i11;
        LiveDetailBean liveDetailBean = liveDetailActivity.f18466m;
        if ((liveDetailBean != null && liveDetailBean.hasGift == 1) && (i11 = liveDetailActivity.f18460j) == 1) {
            Pair[] pairArr = new Pair[7];
            pairArr[0] = kotlin.l.a("state", Integer.valueOf(i11));
            pairArr[1] = kotlin.l.a("liveid", liveDetailActivity.f18462k);
            pairArr[2] = kotlin.l.a(VineCardUtils.PLAYER_CARD, 2);
            LiveDetailBean liveDetailBean2 = liveDetailActivity.f18466m;
            Integer num = null;
            pairArr[3] = kotlin.l.a("title", liveDetailBean2 != null ? liveDetailBean2.title : null);
            LiveSpeaker liveSpeaker = liveDetailActivity.f18455f0;
            pairArr[4] = kotlin.l.a("upid", liveSpeaker != null ? liveSpeaker.showId : null);
            pairArr[5] = kotlin.l.a("roundid", "");
            CusMsgGiftSend j11 = com.hbg.module.huobi.im.gift.d.f19724a.j();
            if (j11 != null) {
                num = j11.getRule();
            }
            pairArr[6] = kotlin.l.a("lotterytype", num);
            nc.c.a("APP_LIVE_notice_myprize", MapsKt__MapsKt.j(pairArr));
        }
        return false;
    }

    public static final void uj(LiveDetailActivity liveDetailActivity, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        liveDetailActivity.sh();
        IHbgApi a11 = v7.b.a();
        LiveDetailBean liveDetailBean = liveDetailActivity.f18466m;
        RequestExtKt.d(a11.K0(liveDetailBean != null ? liveDetailBean.f70249id : null), new LiveDetailActivity$cancelAppointment$2$1(liveDetailActivity), new LiveDetailActivity$cancelAppointment$2$2(liveDetailActivity), (MutableLiveData) null, 4, (Object) null);
    }

    public static final void uk(LiveDetailActivity liveDetailActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        RequestExtKt.c(v7.b.a().w0(liveDetailActivity.f18462k), new LiveDetailActivity$initData$1$12$2$1(liveDetailActivity), new LiveDetailActivity$initData$1$12$2$2(liveDetailActivity), (MutableLiveData) null);
    }

    public static final void wk(LiveDetailActivity liveDetailActivity, Object obj) {
        String obj2 = obj.toString();
        liveDetailActivity.f18476t0 = obj2;
        LiveGetFreeGiftDialogFragment liveGetFreeGiftDialogFragment = liveDetailActivity.f18478u0;
        if (liveGetFreeGiftDialogFragment != null) {
            liveGetFreeGiftDialogFragment.wh(obj2);
        }
    }

    public static final void xk(LiveDetailActivity liveDetailActivity, Object obj) {
        GiftDataInfo data;
        GiftPanelInfo giftPanelInfo = (GiftPanelInfo) new Gson().fromJson(obj.toString(), GiftPanelInfo.class);
        if (giftPanelInfo.getCode() == 200 && giftPanelInfo.getData() != null && (data = giftPanelInfo.getData()) != null) {
            com.hbg.module.content.helper.live.f.f18246a.i(data.getIntegral());
            if (!com.hbg.module.libkt.base.ext.b.w(data.getGiftGroups())) {
                liveDetailActivity.f18465l0 = true;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Iterator<GiftGroup> it2 = data.getGiftGroups().iterator();
                while (it2.hasNext()) {
                    GiftGroup next = it2.next();
                    arrayList.add(new TabData(next.getGroupName(), 0, next.getGroupId(), 2, (kotlin.jvm.internal.r) null));
                    arrayList2.add(GiftListFragment.f18384u.a(next));
                }
                he.a aVar = new he.a((FragmentActivity) liveDetailActivity);
                ((lc.m) liveDetailActivity.Yf()).Q2.setAdapter(aVar);
                aVar.a(arrayList2);
                if (arrayList.size() > 0) {
                    ((lc.m) liveDetailActivity.Yf()).Q2.registerOnPageChangeCallback(new o(data, liveDetailActivity));
                    liveDetailActivity.Fk(((lc.m) liveDetailActivity.Yf()).J, ((lc.m) liveDetailActivity.Yf()).Q2, arrayList);
                    ((lc.m) liveDetailActivity.Yf()).Q2.setOffscreenPageLimit(arrayList.size());
                }
            }
        }
    }

    public static /* synthetic */ void xl(LiveDetailActivity liveDetailActivity, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        liveDetailActivity.wl(z11);
    }

    public static final void zk(LiveDetailActivity liveDetailActivity) {
        ((lc.m) liveDetailActivity.Yf()).F2.getLocationOnScreen(new int[2]);
    }

    public final void Aj() {
        ((lc.m) Yf()).f19207d1.setVisibility(8);
        if ((GlobalAppConfig.c() - ConfigPreferences.g("live_notice_config", "LIVE_NOTICE_VERSION", 0)) / 1000 >= 2) {
            SP.a("live_notice_config");
            ConfigPreferences.k("live_notice_config", "LIVE_NOTICE_VERSION", GlobalAppConfig.c());
        }
        ConfigPreferences.n("live_notice_config", "LIVE_NOTICE_CLOSED" + this.f18462k, true);
    }

    public final void Al() {
        Cj();
        com.hbg.module.content.utls.q.f18949a.f(this, this.f18482w0, ((lc.m) Yf()).f19235m2, ((lc.m) Yf()).f19232l2);
    }

    public void B7(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
        ((lc.m) Yf()).J0.getRoot().setVisibility(0);
        ((lc.m) Yf()).M0.getRoot().setVisibility(8);
        ((lc.m) Yf()).L0.getRoot().setVisibility(8);
    }

    public void Bb(V2TXLivePlayer v2TXLivePlayer, boolean z11, Bundle bundle) {
        int i11 = this.f18460j;
        nc.c.a(i11 != 1 ? i11 != 2 ? "APP_LIVE_livestart_replay" : "APP_LIVE_livestart_player" : "APP_LIVE_livestart_exposure", this.K);
        ((lc.m) Yf()).f19230l0.setVisibility(8);
        ((lc.m) Yf()).J0.getRoot().setVisibility(8);
        ((lc.m) Yf()).M0.getRoot().setVisibility(8);
        ((lc.m) Yf()).L0.getRoot().setVisibility(8);
    }

    public final void Bj() {
        if (this.f18477u == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
            this.f18477u = alphaAnimation;
            alphaAnimation.setDuration(300);
        }
        ((lc.m) Yf()).K2.startAnimation(this.f18477u);
        ((lc.m) Yf()).f19208d2.startAnimation(this.f18477u);
        ((lc.m) Yf()).Y1.startAnimation(this.f18477u);
    }

    public final void Bk(View view, int[] iArr) {
        View view2 = view;
        int[] iArr2 = new int[2];
        view.clearAnimation();
        view2.setVisibility(8);
        ((lc.m) Yf()).J2.getLocationOnScreen(iArr2);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, (float) iArr[0], 0, (float) iArr2[0], 0, (float) iArr[1], 0, (float) iArr2[1]);
        translateAnimation.setDuration(700);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.3f, 1.0f, 0.3f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(700);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(600);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        view2.startAnimation(animationSet);
        view2.setVisibility(0);
        view2.postDelayed(new v0(view2), 700);
    }

    public final void Bl(boolean z11) {
        this.f18486y0 = z11;
    }

    public final void Cj() {
        ((lc.m) Yf()).R(2);
        ((lc.m) Yf()).f19238n2.startAnimation(AnimationUtils.loadAnimation(this, R$anim.redpacket_tips_out));
    }

    public final void Cl(LiveSelfAwardDialog liveSelfAwardDialog) {
        this.C0 = liveSelfAwardDialog;
    }

    public final void Dj() {
        rj.b k11;
        ((lc.m) Yf()).f19232l2.setVisibility(8);
        com.hbg.module.content.utls.l lVar = this.f18482w0;
        if (lVar != null && (k11 = lVar.k()) != null) {
            k11.I("redPacket.closeSendView()");
        }
    }

    public final void Dk() {
        if (this.f18469n0 == null) {
            this.f18469n0 = new com.hbg.module.content.adapter.j(this);
            ((lc.m) Yf()).A1.setLayoutManager(com.hbg.module.libkt.base.ext.b.m(this));
            ((lc.m) Yf()).A1.setAdapter(this.f18469n0);
            com.hbg.module.libkt.base.ext.b.f(((lc.m) Yf()).A1);
        }
        LiveDetailBean liveDetailBean = this.f18466m;
        if (!com.hbg.module.libkt.base.ext.b.w(liveDetailBean != null ? liveDetailBean.giftTopUser : null)) {
            com.hbg.module.content.adapter.j jVar = this.f18469n0;
            if (jVar != null) {
                jVar.a(0, this.f18466m.giftTopUser);
            }
            ((lc.m) Yf()).f19250t1.setVisibility(0);
            return;
        }
        ((lc.m) Yf()).f19250t1.setVisibility(8);
    }

    public final void Dl() {
        LiveDetailBean liveDetailBean = this.f18466m;
        if (liveDetailBean != null) {
            n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.v.a(this), kotlinx.coroutines.v0.b(), (CoroutineStart) null, new LiveDetailActivity$shareLive$1$1(this, liveDetailBean, (kotlin.coroutines.c<? super LiveDetailActivity$shareLive$1$1>) null), 2, (Object) null);
        }
    }

    public final void Ej() {
        ((lc.m) Yf()).f19243q1.setVisibility(0);
        int i11 = this.f18461j0;
        if (i11 < 10) {
            ((lc.m) Yf()).f19200b0.setVisibility(8);
            ((lc.m) Yf()).f19197a0.setImageResource(Uj(this.f18461j0));
        } else if (i11 < 100) {
            ((lc.m) Yf()).f19197a0.setImageResource(Uj(this.f18461j0 / 10));
            ((lc.m) Yf()).f19200b0.setImageResource(Uj(this.f18461j0 % 10));
            ((lc.m) Yf()).f19200b0.setVisibility(0);
        }
        this.f18461j0++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.liveGroup;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ek() {
        /*
            r4 = this;
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r0 = r4.f18466m
            if (r0 == 0) goto L_0x000b
            com.hbg.lib.network.hbg.core.bean.LiveGroup r0 = r0.liveGroup
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.groupId
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            boolean r0 = sd.a.c(r0)
            if (r0 == 0) goto L_0x0024
            x1.a r0 = r4.Yf()
            lc.m r0 = (lc.m) r0
            lc.e6 r0 = r0.I0
            android.view.View r0 = r0.getRoot()
            r1 = 8
            r0.setVisibility(r1)
            goto L_0x0070
        L_0x0024:
            android.os.Handler r0 = r4.Zf()
            if (r0 == 0) goto L_0x002f
            java.lang.Runnable r1 = r4.B
            r0.removeCallbacks(r1)
        L_0x002f:
            x1.a r0 = r4.Yf()
            lc.m r0 = (lc.m) r0
            lc.e6 r0 = r0.I0
            android.view.View r0 = r0.E
            com.hbg.module.content.ui.activity.live.LiveDetailActivity$q r1 = new com.hbg.module.content.ui.activity.live.LiveDetailActivity$q
            r1.<init>(r4)
            r0.setOnClickListener(r1)
            x1.a r0 = r4.Yf()
            lc.m r0 = (lc.m) r0
            lc.e6 r0 = r0.I0
            android.widget.ImageView r0 = r0.B
            com.hbg.module.content.ui.activity.live.LiveDetailActivity$r r1 = new com.hbg.module.content.ui.activity.live.LiveDetailActivity$r
            r1.<init>(r4)
            r0.setOnClickListener(r1)
            x1.a r0 = r4.Yf()
            lc.m r0 = (lc.m) r0
            lc.e6 r0 = r0.I0
            android.widget.LinearLayout r0 = r0.C
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0070
            android.os.Handler r0 = r4.Zf()
            if (r0 == 0) goto L_0x0070
            java.lang.Runnable r1 = r4.B
            r2 = 4000(0xfa0, double:1.9763E-320)
            r0.postDelayed(r1, r2)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.live.LiveDetailActivity.Ek():void");
    }

    public final void El() {
        if (((lc.m) Yf()).f19225j1.getVisibility() == 0) {
            ((lc.m) Yf()).f19225j1.clearAnimation();
            ((lc.m) Yf()).f19206d0.clearAnimation();
            ((lc.m) Yf()).E2.clearAnimation();
            ((lc.m) Yf()).f19225j1.setVisibility(0);
            ((lc.m) Yf()).f19206d0.setVisibility(0);
            ((lc.m) Yf()).E2.setVisibility(0);
        } else {
            if (this.f18479v == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                this.f18479v = alphaAnimation;
                alphaAnimation.setDuration(300);
            }
            int i11 = this.f18460j;
            if (i11 == 2) {
                ((lc.m) Yf()).f19263x2.clearAnimation();
                ((lc.m) Yf()).f19263x2.setVisibility(0);
                ((lc.m) Yf()).f19263x2.startAnimation(this.f18479v);
            } else if (i11 == 3) {
                ((lc.m) Yf()).f19225j1.clearAnimation();
                ((lc.m) Yf()).f19225j1.setVisibility(0);
                ((lc.m) Yf()).f19225j1.startAnimation(this.f18479v);
            }
            ((lc.m) Yf()).f19206d0.clearAnimation();
            ((lc.m) Yf()).f19206d0.setVisibility(0);
            ((lc.m) Yf()).f19206d0.startAnimation(this.f18479v);
            ((lc.m) Yf()).E2.clearAnimation();
            ((lc.m) Yf()).E2.setVisibility(0);
            ((lc.m) Yf()).E2.startAnimation(this.f18479v);
        }
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.postDelayed(this.A, 3000);
        }
    }

    public final l.b Fj() {
        return new d(this, this);
    }

    public final void Fk(CoIndicator coIndicator, ViewPager2 viewPager2, ArrayList<TabData> arrayList) {
        ne.b.m(this, arrayList, coIndicator, viewPager2, 1, 14.0f, 14.0f, R$color.white, R$color.live_gift_tab_unsel_color, (ne.c) null, 512, (Object) null);
    }

    public final void Fl() {
        TXCloudVideoView o11;
        HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
        if (!hbgLiveHelper.t() && (o11 = hbgLiveHelper.o()) != null) {
            this.D0 = new FloatView(this);
            View inflate = LayoutInflater.from(this).inflate(R$layout.float_live_view, (ViewGroup) null);
            inflate.findViewById(R$id.vClick).setOnClickListener(new w0(this));
            ((ImageView) inflate.findViewById(R$id.ivClose)).setOnClickListener(new o1(this));
            View findViewById = inflate.findViewById(R$id.layLoading);
            View findViewById2 = inflate.findViewById(R$id.layRetry);
            findViewById.setOnClickListener(c0.f18622b);
            findViewById2.setOnClickListener(d0.f18626b);
            ((TextView) findViewById2.findViewById(R$id.tvRetry)).setOnClickListener(new x0(findViewById2, findViewById));
            ((ViewGroup) o11.getParent()).removeView(o11);
            ((RelativeLayout) inflate.findViewById(R$id.rlVideo)).addView(o11, 0);
            FloatView floatView = this.D0;
            if (floatView != null) {
                floatView.addView(inflate);
            }
            FloatView floatView2 = this.D0;
            if (floatView2 != null) {
                floatView2.d();
            }
            hbgLiveHelper.H(true);
            hbgLiveHelper.E(new y0(findViewById, findViewById2));
        }
    }

    public final void Gj() {
        DialogUtils.b0(this, getResources().getString(R$string.n_live_leave_home), (CharSequence) null, (String) null, getResources().getString(R$string.n_live_exit_miniplayer), getResources().getString(R$string.n_contract_alert_close), new n0(this), new r0(this)).setCanceledOnTouchOutside(true);
    }

    public final void Gk() {
        if (!this.H) {
            ((lc.m) Yf()).J0.getRoot().setVisibility(0);
        }
        ((lc.m) Yf()).N0.E.setOnClickListener(new q1(this));
        ((lc.m) Yf()).N0.C.setOnClickListener(new s(this));
        ((lc.m) Yf()).N0.D.setOnClickListener(new t(this));
        ((lc.m) Yf()).N0.B.setOnClickListener(new u(this));
        HbgLiveHelper.f18227a.F();
        Dk();
    }

    public final void Ik() {
        this.f18482w0 = new com.hbg.module.content.utls.l(this);
        com.hbg.module.content.utls.l.f18918c.b(new WeakReference(this.f18482w0));
        rj.b k11 = this.f18482w0.k();
        if (k11 != null) {
            k11.I("redPacket.setLiveId(" + this.f18462k + ')');
        }
        this.f18482w0.m(Fj());
    }

    public void J3(int i11) {
        if (i11 > 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                ((lc.m) Yf()).B0.d();
            }
        }
        ((lc.m) Yf()).M(HbgLiveHelper.f18227a.n());
    }

    public final void Jk() {
        Handler Zf;
        nc.c.a("app_livehouse_plazeshow", this.K);
        Handler Zf2 = Zf();
        if (Zf2 != null) {
            Zf2.removeCallbacks(this.C);
        }
        ((lc.m) Yf()).K0.setVisibility(0);
        rd.s sVar = rd.s.f23381a;
        View view = ((lc.m) Yf()).K2;
        view.setOnClickListener(new v(view, 800, this));
        ImageView imageView = ((lc.m) Yf()).f19249t0;
        imageView.setOnClickListener(new w(imageView, 800, this));
        RoundTextView roundTextView = ((lc.m) Yf()).Y1;
        roundTextView.setOnClickListener(new x(roundTextView, 800, this));
        if (((lc.m) Yf()).f19208d2.getVisibility() == 0 && (Zf = Zf()) != null) {
            Zf.postDelayed(this.C, 4000);
        }
    }

    public final void Jl() {
        FragmentTransaction q11 = getSupportFragmentManager().q();
        LiveGetFreeGiftDialogFragment liveGetFreeGiftDialogFragment = this.f18478u0;
        if ((liveGetFreeGiftDialogFragment != null ? q11.s(liveGetFreeGiftDialogFragment) : null) == null) {
            this.f18478u0 = new LiveGetFreeGiftDialogFragment();
        }
        LiveGetFreeGiftDialogFragment liveGetFreeGiftDialogFragment2 = this.f18478u0;
        if (liveGetFreeGiftDialogFragment2 != null) {
            liveGetFreeGiftDialogFragment2.setDialogDismissListener(new k0(this));
        }
        LiveGetFreeGiftDialogFragment liveGetFreeGiftDialogFragment3 = this.f18478u0;
        if (liveGetFreeGiftDialogFragment3 != null) {
            liveGetFreeGiftDialogFragment3.xh(new z0(this));
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("live_free_bean", Nj());
        bundle.putString("liveIntegralList", this.f18476t0);
        if (this.f18476t0 == null) {
            zl("requestIntroduce()");
            Unit unit = Unit.f56620a;
        }
        this.f18478u0.setArguments(bundle);
        q11.e(this.f18478u0, "LiveGetFreeGiftDialog");
        q11.k();
    }

    public final void Kk() {
        int m11 = HbgLiveHelper.f18227a.m();
        if (m11 == 1) {
            ((lc.m) Yf()).f19263x2.setText(getResources().getString(R$string.n_live_p_480));
            ((lc.m) Yf()).N0.C.setChecked(true);
        } else if (m11 == 2) {
            ((lc.m) Yf()).f19263x2.setText(getResources().getString(R$string.n_live_p_720));
            ((lc.m) Yf()).N0.D.setChecked(true);
        } else if (m11 == 3) {
            ((lc.m) Yf()).f19263x2.setText(getResources().getString(R$string.n_live_p_1080));
            ((lc.m) Yf()).N0.B.setChecked(true);
        }
    }

    public final void Lj() {
        Gj();
    }

    public final void Ll() {
        ((lc.m) Yf()).f19260w2.setVisibility(8);
        HbgBaseProvider fg2 = fg();
        if (fg2 != null && fg2.j(this)) {
            nc.c.a("APP_LIVE_reward_entranceclk", this.K);
            nc.c.a("APP_LIVE_reward_panel", this.K);
            ((lc.m) Yf()).f19212f0.clearAnimation();
            ((lc.m) Yf()).f19212f0.setVisibility(8);
            ((lc.m) Yf()).D0.setVisibility(0);
            if (this.P == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this, R$anim.gift_panel_show);
                this.P = loadAnimation;
                if (loadAnimation != null) {
                    loadAnimation.setInterpolator(new LinearOutSlowInInterpolator());
                }
            }
            ((lc.m) Yf()).G.setVisibility(0);
            if (SPUtil.g("sisterShowPop", true)) {
                LiveDetailBean liveDetailBean = this.f18466m;
                if (!com.hbg.module.libkt.base.ext.b.w(liveDetailBean != null ? liveDetailBean.sisterGroupList : null)) {
                    String string = getResources().getString(R$string.n_live_gift_select_guests_to_send_gifts);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                    String string2 = getResources().getString(R$string.n_live_gift_select_guests_to_send_gifts_key);
                    String str = string;
                    String str2 = string2;
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R$color.color_2483FF)), StringsKt__StringsKt.g0(str, str2, 0, false, 6, (Object) null), StringsKt__StringsKt.g0(str, str2, 0, false, 6, (Object) null) + string2.length(), 34);
                    ((lc.m) Yf()).f19248s2.setText(spannableStringBuilder);
                    ((lc.m) Yf()).f19248s2.setVisibility(0);
                    Handler Zf = Zf();
                    if (Zf != null) {
                        Zf.postDelayed(new i1(this), 2000);
                    }
                    SPUtil.r("sisterShowPop", false);
                }
            }
            Handler Zf2 = Zf();
            if (Zf2 != null) {
                Zf2.postDelayed(l1.f18655b, 200);
            }
            ((lc.m) Yf()).G.startAnimation(this.P);
            rd.j.f().n();
        }
    }

    public final View Mj() {
        rj.b bVar = this.f18457h0;
        if (bVar != null) {
            return bVar.E("live_gift_panel_asset.xml", this, false, (com.alibaba.fastjson.JSONObject) null);
        }
        return null;
    }

    public final GiftBean Nj() {
        ArrayList<Fragment> c11;
        if (!(((lc.m) Yf()).Q2.getAdapter() instanceof he.a) || (c11 = ((he.a) ((lc.m) Yf()).Q2.getAdapter()).c()) == null || c11.size() <= ((lc.m) Yf()).Q2.getCurrentItem()) {
            return null;
        }
        Fragment fragment = c11.get(((lc.m) Yf()).Q2.getCurrentItem());
        if (!(fragment instanceof GiftListFragment)) {
            return null;
        }
        GiftListFragment giftListFragment = (GiftListFragment) fragment;
        if (giftListFragment.Th() == null) {
            return null;
        }
        for (GiftBean next : giftListFragment.Th()) {
            if (next.getLabel() == 1) {
                return next;
            }
        }
        return null;
    }

    public void O9() {
        ((lc.m) Yf()).M(HbgLiveHelper.f18227a.n());
        Dk();
    }

    public final void Oj() {
        IHbgApi a11 = v7.b.a();
        LiveDetailBean liveDetailBean = this.f18466m;
        a11.getUserRole(liveDetailBean != null ? liveDetailBean.groupChatInteractive : null).b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new e(this));
    }

    public final void Ol(int i11) {
        if (i11 == 2) {
            SPUtil.r(this.f18458i, true);
        }
        EngineDialogFragment engineDialogFragment = this.f18459i0;
        if (engineDialogFragment != null) {
            engineDialogFragment.sh(i11);
        }
        EngineDialogFragment engineDialogFragment2 = this.f18459i0;
        if (engineDialogFragment2 != null) {
            engineDialogFragment2.show(getSupportFragmentManager(), "giftPanel");
        }
    }

    public final FloatView Pj() {
        return this.D0;
    }

    public final void Pl(int i11) {
        int i12;
        TextView textView = ((lc.m) Yf()).f19260w2;
        Resources resources = getResources();
        if (i11 == 1) {
            i12 = R$string.n_content_live_reward_participation;
        } else {
            i12 = R$string.n_content_live_reward_unlock_freegift;
        }
        textView.setText(resources.getString(i12));
        ((lc.m) Yf()).f19260w2.setVisibility(0);
    }

    public final boolean Qj() {
        return this.f18486y0;
    }

    public final void Rj() {
        sh();
        RequestExtKt.d(v7.b.a().getLiveDetail(this.f18462k), new LiveDetailActivity$getLiveData$1(this), new LiveDetailActivity$getLiveData$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final void Rk(String str) {
        if (sd.a.c(str)) {
            ((lc.m) Yf()).M0.B.setText(getResources().getString(R$string.n_live_finish_wait_vod));
            ((lc.m) Yf()).M0.getRoot().setVisibility(0);
            ((lc.m) Yf()).f19225j1.clearAnimation();
            ((lc.m) Yf()).f19225j1.setVisibility(8);
            ((lc.m) Yf()).E2.clearAnimation();
            ((lc.m) Yf()).E2.setVisibility(8);
            ((lc.m) Yf()).f19206d0.clearAnimation();
            ((lc.m) Yf()).f19206d0.setVisibility(8);
            ((lc.m) Yf()).f19262x1.setOnClickListener((View.OnClickListener) null);
            bk();
            HbgLiveHelper.f18227a.k();
            return;
        }
        HbgLiveHelper.f18227a.F();
        if (!this.H) {
            ((lc.m) Yf()).J0.getRoot().setVisibility(0);
        }
        ((lc.m) Yf()).f19255v0.setOnClickListener(new o0(this));
        ((lc.m) Yf()).f19225j1.setVisibility(0);
        ((lc.m) Yf()).f19231l1.setOnSeekBarChangeListener(new p0(this));
    }

    public final void Rl() {
        LiveInfoDialog.a aVar = LiveInfoDialog.f18016d;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        LiveDetailBean liveDetailBean = this.f18466m;
        String str = null;
        String str2 = liveDetailBean != null ? liveDetailBean.introduction : null;
        if (liveDetailBean != null) {
            str = liveDetailBean.title;
        }
        aVar.a(supportFragmentManager, str2, str);
    }

    public void S7() {
        ((lc.m) Yf()).f19230l0.setVisibility(8);
        ((lc.m) Yf()).J0.getRoot().setVisibility(8);
        ((lc.m) Yf()).L0.getRoot().setVisibility(8);
        ((lc.m) Yf()).M0.getRoot().setVisibility(8);
        ((lc.m) Yf()).f19255v0.setImageResource(R$drawable.icon_live_pause);
    }

    public final String Sj() {
        return this.f18462k;
    }

    public final void Sk() {
        LiveDetailBean liveDetailBean;
        String str;
        if (!this.W && (liveDetailBean = this.f18466m) != null && (str = liveDetailBean.groupChatInteractive) != null) {
            this.W = true;
            md.a.f22950a.l(System.currentTimeMillis() / ((long) 1000));
            ImManager.INSTANCE.joinChatGroup(str, new q0(this));
        }
    }

    public final void Sl(LiveEndRecommendData liveEndRecommendData) {
        if (com.hbg.module.libkt.base.ext.b.e(this) && liveEndRecommendData != null) {
            if (this.f18454e0 == null) {
                this.f18454e0 = new com.hbg.module.content.adapter.o(this);
            }
            boolean z11 = false;
            ((lc.m) Yf()).O0.getRoot().setVisibility(0);
            ViewPager viewPager = (ViewPager) ((lc.m) Yf()).O0.getRoot().findViewById(R$id.vpRecommend);
            LinearLayout linearLayout = (LinearLayout) ((lc.m) Yf()).O0.getRoot();
            viewPager.setAdapter(this.f18454e0);
            com.hbg.module.content.adapter.o oVar = this.f18454e0;
            if (oVar != null) {
                oVar.g(liveEndRecommendData.listData);
            }
            linearLayout.setOnTouchListener(e0.f18629b);
            viewPager.setOffscreenPageLimit(3);
            viewPager.setCurrentItem(0);
            List<LiveDetailBean> list = liveEndRecommendData.listData;
            if (list != null) {
                if (list.size() == 1) {
                    z11 = true;
                }
                vj(z11);
            }
        }
    }

    public void Ta(V2TXLivePlayer v2TXLivePlayer, boolean z11, Bundle bundle) {
        ((lc.m) Yf()).J0.getRoot().setVisibility(8);
        ((lc.m) Yf()).M0.getRoot().setVisibility(8);
        ((lc.m) Yf()).L0.getRoot().setVisibility(8);
    }

    public final LiveSelfAwardDialog Tj() {
        return this.C0;
    }

    public final void Tk() {
        sh();
        RequestExtKt.d(v7.b.a().v0(this.f18462k), new LiveDetailActivity$liveAppointment$1(this), new LiveDetailActivity$liveAppointment$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final int Uj(int i11) {
        switch (i11) {
            case 0:
                return R$drawable.icon_live_0;
            case 1:
                return R$drawable.icon_live_1;
            case 2:
                return R$drawable.icon_live_2;
            case 3:
                return R$drawable.icon_live_3;
            case 4:
                return R$drawable.icon_live_4;
            case 5:
                return R$drawable.icon_live_5;
            case 6:
                return R$drawable.icon_live_6;
            case 7:
                return R$drawable.icon_live_7;
            case 8:
                return R$drawable.icon_live_8;
            default:
                return R$drawable.icon_live_9;
        }
    }

    public final void Uk(View view, LiveDetailBean liveDetailBean) {
        cf.a.d(cf.a.f26395a, (ImageView) view.findViewById(R$id.ivPic), liveDetailBean.coverImageUrl, new r0(view, this, liveDetailBean), false, 8, (Object) null);
    }

    public final void Ul(String str, int i11, String str2, String str3, int i12) {
        if (com.hbg.module.libkt.base.ext.b.e(this)) {
            try {
                Handler Zf = Zf();
                if (Zf != null) {
                    Zf.removeCallbacks(this.D);
                }
                Handler Zf2 = Zf();
                if (Zf2 != null) {
                    Zf2.postDelayed(this.D, (long) (i11 * 1000));
                }
                int i13 = 0;
                ((lc.m) Yf()).S0.setVisibility(0);
                ((lc.m) Yf()).f19217g2.setText(str);
                rd.s sVar = rd.s.f23381a;
                TextView textView = ((lc.m) Yf()).f19217g2;
                textView.setOnClickListener(new a1(textView, 800, str, this));
                TextView textView2 = ((lc.m) Yf()).X1;
                if (sd.a.c(str2)) {
                    i13 = 8;
                }
                textView2.setVisibility(i13);
                if (sd.a.c(str3)) {
                    ((lc.m) Yf()).f19221i0.setImageResource(R$drawable.icon_live_notice);
                } else {
                    com.hbg.module.libkt.base.ext.b.B(((lc.m) Yf()).f19221i0, str3);
                }
                ImageView imageView = ((lc.m) Yf()).X;
                imageView.setOnClickListener(new b1(imageView, 800, this));
                TextView textView3 = ((lc.m) Yf()).X1;
                textView3.setOnClickListener(new c1(textView3, 800, i12, str2, this));
                wj("APP_LIVE_livestart_topannouncement");
            } catch (Exception e11) {
                IMLog.e("LiveDetailBarrage:showLiveNoticeView", e11.getMessage());
            }
        }
    }

    public void V6(int i11, int i12) {
        ((lc.m) Yf()).f19231l1.setMax(i11);
        ((lc.m) Yf()).I1.setText(Xj(i11));
        ((lc.m) Yf()).f19231l1.setProgress(i12);
        ((lc.m) Yf()).f19223i2.setText(Xj(i12));
    }

    public final void Vj(Integer num, int i11) {
        sh();
        RequestExtKt.d(v7.b.a().getRecommendDetail(String.valueOf(num), this.f18462k), new LiveDetailActivity$getRecommendInfo$1(this, num, i11), new LiveDetailActivity$getRecommendInfo$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final void Vk() {
        we.c.c(this, new h0(this));
        we.c.l(this, new i0(this));
    }

    public final void Vl() {
        ((lc.m) Yf()).N0.getRoot().setVisibility(((lc.m) Yf()).N0.getRoot().getVisibility() == 0 ? 8 : 0);
    }

    public final void Wl(String str, String str2) {
        LiveInfoDialog.f18016d.a(getSupportFragmentManager(), str, str2);
    }

    public void X8(V2TXLivePlayer v2TXLivePlayer, int i11, String str, Bundle bundle) {
    }

    public final String Xj(int i11) {
        String valueOf = String.valueOf(i11 / this.f18487z);
        if (valueOf.length() < 2) {
            valueOf = '0' + valueOf;
        }
        int i12 = this.f18487z;
        int i13 = i11 - ((i11 / i12) * i12);
        String valueOf2 = String.valueOf(i13 / this.f18485y);
        if (valueOf2.length() < 2) {
            valueOf2 = '0' + valueOf2;
        }
        int i14 = this.f18485y;
        String valueOf3 = String.valueOf(i13 - ((i13 / i14) * i14));
        if (valueOf3.length() < 2) {
            valueOf3 = '0' + valueOf3;
        }
        return valueOf + ':' + valueOf2 + ':' + valueOf3;
    }

    public final void Xl() {
        int i11;
        int i12 = this.f18464l;
        if (i12 == 2 || i12 == 3) {
            ((lc.m) Yf()).f19236n0.setVisibility(0);
            ((lc.m) Yf()).f19267z0.setVisibility(8);
            ((lc.m) Yf()).f19203c0.setVisibility(8);
            ((lc.m) Yf()).f19222i1.setVisibility(8);
            rd.s sVar = rd.s.f23381a;
            ImageView imageView = ((lc.m) Yf()).f19236n0;
            imageView.setOnClickListener(new d1(imageView, 800, this));
            return;
        }
        RecommendTrader recommendTrader = this.B0;
        if (recommendTrader != null) {
            com.hbg.module.libkt.base.ext.b.K(((lc.m) Yf()).A0, recommendTrader.imgUrl, R$drawable.icon_default_avatar);
            rd.s sVar2 = rd.s.f23381a;
            ImageView imageView2 = ((lc.m) Yf()).A0;
            imageView2.setOnClickListener(new e1(imageView2, 800, recommendTrader, this));
            ((lc.m) Yf()).f19269z2.setText(recommendTrader.nickname);
            TextView textView = ((lc.m) Yf()).B2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(recommendTrader.winRate > 0.0d ? "+" : "");
            sb2.append(com.hbg.module.libkt.base.ext.b.g(Double.valueOf(recommendTrader.winRate * ((double) 100)), 4));
            sb2.append('%');
            textView.setText(sb2.toString());
            TextView textView2 = ((lc.m) Yf()).B2;
            if (recommendTrader.winRate > 0.0d) {
                if (com.hbg.lib.core.util.w.l()) {
                    i11 = getResources().getColor(R$color.live_bg_integral_free_tips);
                } else {
                    i11 = getResources().getColor(R$color.topic_symbol_color);
                }
            } else if (com.hbg.lib.core.util.w.l()) {
                i11 = getResources().getColor(R$color.topic_symbol_color);
            } else {
                i11 = getResources().getColor(R$color.live_bg_integral_free_tips);
            }
            textView2.setTextColor(i11);
            ((lc.m) Yf()).f19266y2.setText(recommendTrader.totalProfit);
            ((lc.m) Yf()).Q1.setText(String.valueOf(recommendTrader.copyUserNum));
            ((lc.m) Yf()).f19236n0.setVisibility(8);
            ((lc.m) Yf()).f19267z0.setVisibility(0);
            ((lc.m) Yf()).f19203c0.setVisibility(0);
            ((lc.m) Yf()).f19222i1.setVisibility(0);
            nc.c.a("app_live_trader_contentshow", MapsKt__MapsKt.j(kotlin.l.a("uid", BaseModuleConfig.a().getUid()), kotlin.l.a("liveId", this.f18462k)));
            Handler Zf = Zf();
            if (Zf != null) {
                Zf.postDelayed(new d1(this), 5000);
            }
            RelativeLayout relativeLayout = ((lc.m) Yf()).f19245r1;
            RecommendTrader recommendTrader2 = recommendTrader;
            relativeLayout.setOnClickListener(new f1(relativeLayout, 800, this, recommendTrader2));
            ImageView imageView3 = ((lc.m) Yf()).f19203c0;
            imageView3.setOnClickListener(new g1(imageView3, 800, this, recommendTrader2));
        }
    }

    /* renamed from: Yj */
    public lc.m Og() {
        return lc.m.K(getLayoutInflater());
    }

    public final void Yk() {
        we.c.e(this, new v0(new LiveDetailActivity$observeIntegralGiftInfo$1(this)));
        we.c.i(this, new j0(this));
        we.c.d(this, new v0(LiveDetailActivity$observeIntegralGiftInfo$3.INSTANCE));
    }

    public final void Zj() {
        if (this.Q == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R$anim.gift_panel_hide);
            this.Q = loadAnimation;
            if (loadAnimation != null) {
                loadAnimation.setInterpolator(new FastOutLinearInInterpolator());
            }
        }
        ((lc.m) Yf()).G.startAnimation(this.Q);
        ((lc.m) Yf()).G.setVisibility(8);
    }

    public final void Zl() {
        Intent intent = new Intent(this, FullScreenLiveActivity.class);
        intent.putExtra("liveData", this.f18466m);
        intent.putExtra("redpacketBeans", this.f18488z0);
        if (((lc.m) Yf()).L0.getRoot().getVisibility() == 0) {
            intent.putExtra("isNetworkError", true);
        }
        startActivityForResult(intent, 101);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r0 = r0.k();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ak() {
        /*
            r8 = this;
            com.hbg.module.libkt.provider.HbgBaseProvider r0 = r8.fg()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.j(r8)
            if (r0 != r1) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r1 = r2
        L_0x0010:
            if (r1 == 0) goto L_0x004b
            com.hbg.module.content.utls.l r0 = r8.f18482w0
            if (r0 == 0) goto L_0x0021
            rj.b r0 = r0.k()
            if (r0 == 0) goto L_0x0021
            java.lang.String r1 = "redPacketGrap.loadAlertView()"
            r0.I(r1)
        L_0x0021:
            com.hbg.module.content.utls.l r0 = r8.f18482w0
            if (r0 == 0) goto L_0x0032
            rj.b r0 = r0.k()
            if (r0 == 0) goto L_0x0032
            java.lang.String r1 = "grap.xml"
            android.view.View r0 = r0.D(r1, r8)
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            r4 = r0
            com.hbg.module.content.utls.q r1 = com.hbg.module.content.utls.q.f18949a
            x1.a r0 = r8.Yf()
            lc.m r0 = (lc.m) r0
            android.view.View r3 = r0.getRoot()
            r5 = 0
            r6 = 8
            r7 = 0
            r2 = r8
            android.widget.PopupWindow r0 = com.hbg.module.content.utls.q.d(r1, r2, r3, r4, r5, r6, r7)
            r8.A0 = r0
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.live.LiveDetailActivity.ak():void");
    }

    public final void al() {
        we.c.k(this, new v0(new LiveDetailActivity$observeRewardGifts$1(this)));
    }

    public void bb() {
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.removeCallbacks(this.A);
        }
        El();
    }

    public final void bk() {
        if (((lc.m) Yf()).f19206d0.getVisibility() == 0) {
            if (this.f18481w == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
                this.f18481w = alphaAnimation;
                alphaAnimation.setDuration(300);
                AlphaAnimation alphaAnimation2 = this.f18481w;
                if (alphaAnimation2 != null) {
                    alphaAnimation2.setAnimationListener(new f(this));
                }
            }
            int i11 = this.f18460j;
            if (i11 == 2) {
                ((lc.m) Yf()).f19263x2.clearAnimation();
                ((lc.m) Yf()).f19263x2.startAnimation(this.f18481w);
            } else if (i11 == 3) {
                ((lc.m) Yf()).f19225j1.clearAnimation();
                ((lc.m) Yf()).f19225j1.startAnimation(this.f18481w);
            }
            ((lc.m) Yf()).f19206d0.clearAnimation();
            ((lc.m) Yf()).f19206d0.startAnimation(this.f18481w);
            ((lc.m) Yf()).E2.clearAnimation();
            ((lc.m) Yf()).E2.startAnimation(this.f18481w);
        }
    }

    public final void bl() {
        we.c.m(this, new v0(new LiveDetailActivity$observeUpdateGroupId$1(this)));
    }

    public final void ck() {
        yj();
    }

    public void da() {
        ((lc.m) Yf()).L0.getRoot().setVisibility(8);
        ((lc.m) Yf()).M0.getRoot().setVisibility(8);
        if (!this.E) {
            ((lc.m) Yf()).J0.getRoot().setVisibility(0);
        }
    }

    public final void ek() {
        ((lc.m) Yf()).S0.setVisibility(8);
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.removeCallbacks(this.D);
        }
    }

    public void f4() {
        ((lc.m) Yf()).L0.getRoot().setVisibility(0);
        ((lc.m) Yf()).M0.getRoot().setVisibility(8);
        ((lc.m) Yf()).J0.getRoot().setVisibility(8);
    }

    public final void fk() {
        zj();
    }

    public final void gl() {
        EngineDialogFragment engineDialogFragment = this.f18459i0;
        if (engineDialogFragment != null) {
            engineDialogFragment.dismiss();
        }
    }

    public final void hl() {
        EngineDialogFragment engineDialogFragment = this.f18459i0;
        if (engineDialogFragment != null) {
            engineDialogFragment.dismiss();
        }
        com.hbg.module.content.helper.live.f.f18246a.d();
    }

    public void ic(V2TXLivePlayer v2TXLivePlayer, int i11, String str, Bundle bundle) {
        if (i11 == -8) {
            ((lc.m) Yf()).M0.getRoot().setVisibility(8);
            ((lc.m) Yf()).J0.getRoot().setVisibility(8);
            ((lc.m) Yf()).L0.getRoot().setVisibility(0);
        } else if (i11 != 0) {
            ((lc.m) Yf()).M0.getRoot().setVisibility(8);
            ((lc.m) Yf()).J0.getRoot().setVisibility(8);
            ((lc.m) Yf()).L0.getRoot().setVisibility(0);
        }
    }

    public final void il() {
        String currency;
        EngineDialogFragment engineDialogFragment = this.f18459i0;
        if (engineDialogFragment != null) {
            engineDialogFragment.dismiss();
        }
        nc.c.a("APP_LIVE_reward_recharge", this.K);
        Financial a11 = com.hbg.module.content.helper.live.f.f18246a.a();
        if (a11 != null && (currency = a11.getCurrency()) != null) {
            BaseModuleConfig.a a12 = BaseModuleConfig.a();
            a12.k0("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/deposit?coin=" + currency);
        }
    }

    public final void initData() {
        String str;
        rj.b k11;
        LiveDetailBean liveDetailBean = this.f18466m;
        if (liveDetailBean != null && liveDetailBean != null) {
            LiveDetailBean.LiveNotification liveNotification = liveDetailBean.liveNotification;
            if (liveNotification != null) {
                Ul(liveNotification.content, liveNotification.showTime, liveNotification.jumpUrl, liveNotification.avatar, liveNotification.jumpType);
            }
            we.c.v(liveDetailBean);
            this.K.put("state", Integer.valueOf(this.f18460j));
            this.K.put("liveid", liveDetailBean.f70249id);
            this.K.put(VineCardUtils.PLAYER_CARD, 2);
            this.K.put("title", liveDetailBean.title);
            String str2 = null;
            int i11 = 0;
            if (!com.hbg.module.libkt.base.ext.b.w(liveDetailBean.speakerList)) {
                List<LiveSpeaker> list = liveDetailBean.speakerList;
                LiveSpeaker liveSpeaker = list != null ? list.get(0) : null;
                this.f18455f0 = liveSpeaker;
                this.K.put("upid", liveSpeaker != null ? liveSpeaker.showId : null);
            }
            Jk();
            ((lc.m) Yf()).M(liveDetailBean);
            this.f18460j = liveDetailBean.status;
            ((lc.m) Yf()).O(Integer.valueOf(liveDetailBean.status));
            ((lc.m) Yf()).N(liveDetailBean.liveGroup);
            if (this.f18455f0 != null) {
                ((lc.m) Yf()).T(this.f18455f0);
            }
            ((lc.m) Yf()).f19213f1.setVisibility(8);
            boolean z11 = true;
            if (!com.hbg.module.libkt.base.ext.b.w(liveDetailBean.redpacketList)) {
                HashMap j11 = MapsKt__MapsKt.j(kotlin.l.a("redpacketList", liveDetailBean.redpacketList), kotlin.l.a("serverTime", Long.valueOf(liveDetailBean.currentTime)));
                try {
                    com.hbg.module.content.utls.l lVar = this.f18482w0;
                    if (!(lVar == null || (k11 = lVar.k()) == null)) {
                        k11.I("redPacketQueue.addPacketList('" + new Gson().toJson((Object) j11) + "')");
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            LiveDetailBean liveDetailBean2 = this.f18466m;
            Integer valueOf = liveDetailBean2 != null ? Integer.valueOf(liveDetailBean2.redpacketStatus) : null;
            if (valueOf == null || valueOf.intValue() != 1) {
                Cj();
            } else if (this.f18484x0 == null) {
                ul();
                this.f18484x0 = new i(this).start();
            }
            if (liveDetailBean.status == 1) {
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ((lc.m) Yf()).f19234m1.getLayoutParams();
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) ((lc.m) Yf()).f19265y1.getLayoutParams();
                AvatarView avatarView = ((lc.m) Yf()).P;
                LiveSpeaker liveSpeaker2 = this.f18455f0;
                AvatarView x11 = AvatarView.x(avatarView, liveSpeaker2 != null ? liveSpeaker2.avatar : null, 0, 2, (Object) null);
                LiveSpeaker liveSpeaker3 = this.f18455f0;
                x11.z(liveSpeaker3 != null ? liveSpeaker3.uidUnique : null, liveSpeaker3 != null ? liveSpeaker3.showId : null);
                if (!sd.a.c(liveDetailBean.backgroundUrl) || !sd.a.c(liveDetailBean.coverVideoUrl)) {
                    if (sd.a.c(liveDetailBean.coverVideoUrl)) {
                        com.hbg.module.libkt.base.ext.b.L(((lc.m) Yf()).R, liveDetailBean.backgroundUrl, 0.0f);
                        ((lc.m) Yf()).D2.setVisibility(0);
                        ((lc.m) Yf()).D2.setBackgroundResource(R$drawable.appointment_gradient_bg);
                    } else {
                        ((lc.m) Yf()).D2.setVisibility(8);
                    }
                    this.Y = ((lc.m) Yf()).B.C;
                    this.Z = ((lc.m) Yf()).B.D;
                    this.f18450a0 = ((lc.m) Yf()).B.E;
                    this.f18451b0 = ((lc.m) Yf()).B.F;
                    if (!sd.a.c(liveDetailBean.coverVideoUrl)) {
                        kk();
                    }
                    layoutParams2.H = "H,75:97";
                    str = "H," + com.hbg.module.libkt.base.ext.c.c() + ':' + (((com.hbg.module.libkt.base.ext.c.c() / 75) * 97) - (com.hbg.module.libkt.base.ext.c.d(Float.valueOf(44.0f)) + com.hbg.module.libkt.utils.o.f24912a.b(this)));
                } else {
                    com.hbg.module.libkt.base.ext.b.z(((lc.m) Yf()).R, liveDetailBean.coverImageUrl);
                    ((lc.m) Yf()).D2.setBackgroundResource(R$drawable.appointment_alpha_bg);
                    this.Y = ((lc.m) Yf()).E.C;
                    this.Z = ((lc.m) Yf()).E.D;
                    this.f18450a0 = ((lc.m) Yf()).E.E;
                    this.f18451b0 = ((lc.m) Yf()).E.F;
                    layoutParams2.H = "H,75:44";
                    str = "H," + com.hbg.module.libkt.base.ext.c.c() + ':' + (((com.hbg.module.libkt.base.ext.c.c() / 75) * 44) - (com.hbg.module.libkt.base.ext.c.d(Float.valueOf(44.0f)) + com.hbg.module.libkt.utils.o.f24912a.b(this)));
                }
                layoutParams.H = str;
                ((lc.m) Yf()).f19237n1.setVisibility(0);
                ((lc.m) Yf()).f19210e1.setVisibility(8);
                this.f18483x = AnimationUtils.loadAnimation(this, R$anim.anim_enter_from_bottom);
                LiveGroup liveGroup = liveDetailBean.liveGroup;
                if (sd.a.c(liveGroup != null ? liveGroup.groupId : null)) {
                    ((lc.m) Yf()).F0.getRoot().setVisibility(8);
                } else {
                    Handler Zf = Zf();
                    if (Zf != null) {
                        Zf.postDelayed(new g1(this), 1000);
                    }
                    ((lc.m) Yf()).F0.D.setOnClickListener(new j(this, liveDetailBean));
                }
                LiveSpeaker liveSpeaker4 = this.f18455f0;
                if (liveSpeaker4 != null) {
                    str2 = liveSpeaker4.introduction;
                }
                if (sd.a.c(str2)) {
                    ((lc.m) Yf()).O1.setVisibility(8);
                    ((lc.m) Yf()).N1.setVisibility(8);
                } else {
                    ((lc.m) Yf()).O1.setVisibility(0);
                    ((lc.m) Yf()).N1.setVisibility(0);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(liveDetailBean.introduction);
                if (!com.hbg.module.libkt.base.ext.b.w(liveDetailBean.introductionImages)) {
                    arrayList.addAll(liveDetailBean.introductionImages);
                }
                if (this.f18453d0 == null) {
                    this.f18453d0 = new com.hbg.module.livesquare.adapter.b(this);
                }
                ((lc.m) Yf()).f19268z1.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(this));
                ((lc.m) Yf()).f19268z1.setAdapter(this.f18453d0);
                com.hbg.module.livesquare.adapter.b bVar = this.f18453d0;
                if (bVar != null) {
                    bVar.a(0, arrayList);
                }
                long j12 = liveDetailBean.startTime - liveDetailBean.currentTime;
                if (j12 <= 1000) {
                    liveDetailBean.status = 2;
                    initData();
                } else {
                    com.hbg.module.content.utls.b.a(this, j12, this.Y, this.Z, this.f18450a0, this.f18451b0, new k(liveDetailBean, this));
                }
                ((lc.m) Yf()).N.getViewTreeObserver().addOnScrollChangedListener(new g0(this));
                rd.s sVar = rd.s.f23381a;
                TextView textView = ((lc.m) Yf()).M1;
                textView.setOnClickListener(new m(textView, 800, this));
                return;
            }
            jk();
            Kk();
            ((lc.m) Yf()).f19205c2.setSelected(true);
            AvatarView avatarView2 = ((lc.m) Yf()).T;
            LiveSpeaker liveSpeaker5 = this.f18455f0;
            AvatarView x12 = AvatarView.x(avatarView2, liveSpeaker5 != null ? liveSpeaker5.avatar : null, 0, 2, (Object) null);
            LiveSpeaker liveSpeaker6 = this.f18455f0;
            x12.z(liveSpeaker6 != null ? liveSpeaker6.uidUnique : null, liveSpeaker6 != null ? liveSpeaker6.showId : null);
            this.M = AnimationUtils.loadAnimation(this, R$anim.live_praise);
            this.N = AnimationUtils.loadAnimation(this, R$anim.live_praise_text);
            ((lc.m) Yf()).f19262x1.setOnClickListener(new l(this));
            ((lc.m) Yf()).f19237n1.setVisibility(8);
            ((lc.m) Yf()).f19210e1.setVisibility(0);
            HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
            hbgLiveHelper.L(liveDetailBean);
            ((lc.m) Yf()).I0.D.setOnClickListener(new h(this, liveDetailBean));
            Sk();
            nk(this, false, 1, (Object) null);
            hbgLiveHelper.J();
            if (liveDetailBean.status == 2) {
                if (liveDetailBean.giftStatus == 1) {
                    this.f18456g0 = 1;
                    yk();
                } else {
                    this.f18456g0 = 2;
                    ((lc.m) Yf()).f19247s1.setVisibility(8);
                }
                if (liveDetailBean.hasBox == 1) {
                    nc.c.a("APP_LIVE_livestart_box", this.K);
                    ((lc.m) Yf()).E0.setVisibility(0);
                }
                RecommendTrader recommendTrader = liveDetailBean.recommendTrader;
                if (recommendTrader != null) {
                    this.B0 = recommendTrader;
                }
                if (this.X == null) {
                    this.X = new LiveDetailActivity$initData$1$11(this);
                }
                qj();
                Gk();
            } else {
                ((lc.m) Yf()).f19263x2.setVisibility(8);
                Rk(liveDetailBean.mediaUrl);
            }
            if (!this.H) {
                if (liveDetailBean.isCanPlay()) {
                    ((lc.m) Yf()).L.setVisibility(8);
                    TXCloudVideoView tXCloudVideoView = new TXCloudVideoView((Context) this);
                    tXCloudVideoView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    tXCloudVideoView.setBackgroundColor(getResources().getColor(R$color.transparent));
                    ((lc.m) Yf()).f19262x1.addView(tXCloudVideoView, 0);
                    hbgLiveHelper.p(this, tXCloudVideoView, liveDetailBean, this);
                } else {
                    if (1 == liveDetailBean.archiveRecover) {
                        AppCompatTextView appCompatTextView = ((lc.m) Yf()).f19244q2;
                        String str3 = liveDetailBean.archiveShowText;
                        if (str3 == null) {
                            str3 = "";
                        }
                        appCompatTextView.setText(str3);
                        ((lc.m) Yf()).f19244q2.setVisibility(0);
                        ((lc.m) Yf()).f19264y0.setVisibility(8);
                    } else {
                        ((lc.m) Yf()).f19244q2.setVisibility(8);
                        ((lc.m) Yf()).f19264y0.setVisibility(0);
                        ((lc.m) Yf()).f19264y0.setOnClickListener(new s1(this, liveDetailBean));
                    }
                    ((lc.m) Yf()).L.setVisibility(0);
                }
            }
            if (liveDetailBean.status == 2) {
                hbgLiveHelper.w();
                if (!ReviewManger.a()) {
                    if (!ConfigPreferences.c("live_notice_config", "LIVE_NOTICE_CLOSED" + this.f18462k, false)) {
                        z11 = false;
                    }
                }
                LinearLayout linearLayout = ((lc.m) Yf()).f19207d1;
                if (z11) {
                    i11 = 8;
                } else {
                    ((lc.m) Yf()).f19207d1.startAnimation(AnimationUtils.loadAnimation(this, R$anim.live_notice_show));
                }
                linearLayout.setVisibility(i11);
            }
            Handler Zf2 = Zf();
            if (Zf2 != null) {
                Zf2.postDelayed(this.A, 3000);
            }
            Ek();
            rd.s sVar2 = rd.s.f23381a;
            TextView textView2 = ((lc.m) Yf()).f19220h2;
            textView2.setOnClickListener(new n(textView2, 800, this));
        }
    }

    public void initView() {
        String str;
        List<LiveSpeaker> list;
        super.initView();
        Ik();
        Qg(true);
        this.L = System.currentTimeMillis();
        com.hbg.module.libkt.utils.o oVar = com.hbg.module.libkt.utils.o.f24912a;
        oVar.d(this, ((lc.m) Yf()).O2);
        oVar.d(this, ((lc.m) Yf()).G0.D);
        oVar.d(this, ((lc.m) Yf()).I2);
        String f02 = BaseModuleConfig.a().f0();
        if (f02 != null) {
            md.a.f22950a.n(f02);
        }
        ((lc.m) Yf()).G.setOnClickListener(b0.f18618b);
        this.K.put("state", Integer.valueOf(this.f18460j));
        HashMap<String, Object> hashMap = this.K;
        LiveDetailBean liveDetailBean = this.f18466m;
        hashMap.put("liveid", liveDetailBean != null ? liveDetailBean.f70249id : null);
        this.K.put(VineCardUtils.PLAYER_CARD, 2);
        HashMap<String, Object> hashMap2 = this.K;
        LiveDetailBean liveDetailBean2 = this.f18466m;
        hashMap2.put("title", liveDetailBean2 != null ? liveDetailBean2.title : null);
        LiveDetailBean liveDetailBean3 = this.f18466m;
        if (!com.hbg.module.libkt.base.ext.b.w(liveDetailBean3 != null ? liveDetailBean3.speakerList : null)) {
            LiveDetailBean liveDetailBean4 = this.f18466m;
            LiveSpeaker liveSpeaker = (liveDetailBean4 == null || (list = liveDetailBean4.speakerList) == null) ? null : list.get(0);
            this.f18455f0 = liveSpeaker;
            this.K.put("upid", liveSpeaker != null ? liveSpeaker.showId : null);
        }
        nc.c.a("APP_LIVE_notice_exposure", this.K);
        ((lc.m) Yf()).f19199a2.append(":");
        ((lc.m) Yf()).P(this);
        ((lc.m) Yf()).O(Integer.valueOf(this.f18460j));
        ((lc.m) Yf()).G0.B.setOnClickListener(new m0(this));
        HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
        if (hbgLiveHelper.o() == null) {
            Rj();
        } else {
            ((lc.m) Yf()).f19230l0.setVisibility(8);
            LiveDetailBean n11 = hbgLiveHelper.n();
            this.f18466m = n11;
            if (!(n11 == null || (str = n11.f70249id) == null)) {
                this.f18462k = str;
            }
            this.H = true;
            TXCloudVideoView o11 = hbgLiveHelper.o();
            if (o11 != null) {
                ((ViewGroup) o11.getParent()).removeView(o11);
                ((lc.m) Yf()).f19262x1.addView(o11, 0);
            }
            initData();
        }
        ((lc.m) Yf()).L0.B.setOnClickListener(new n0(this));
        ((lc.m) Yf()).B0.f(Integer.valueOf(R$drawable.icon_expression_01), Integer.valueOf(R$drawable.icon_expression_02), Integer.valueOf(R$drawable.icon_expression_03), Integer.valueOf(R$drawable.icon_expression_04), Integer.valueOf(R$drawable.icon_expression_05), Integer.valueOf(R$drawable.icon_expression_06));
        ((lc.m) Yf()).f19261x0.setOnClickListener(new h1(this));
        rd.s sVar = rd.s.f23381a;
        TextView textView = ((lc.m) Yf()).K1;
        textView.setOnClickListener(new z(textView, 800, this));
        TextView textView2 = ((lc.m) Yf()).L1;
        textView2.setOnClickListener(new a0(textView2, 800, this));
        RequestExtKt.d(v7.b.a().p0(this.f18462k), LiveDetailActivity$initView$10.INSTANCE, LiveDetailActivity$initView$11.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        TextView textView3 = ((lc.m) Yf()).A2;
        textView3.setOnClickListener(new b0(textView3, 800, this));
        ImageView imageView = ((lc.m) Yf()).E0;
        imageView.setOnClickListener(new c0(imageView, 800, this));
        View view = ((lc.m) Yf()).P2;
        view.setOnClickListener(new d0(view, 800, this));
        ((lc.m) Yf()).f19243q1.setOnClickListener(new p1(this));
        com.hbg.module.huobi.im.gift.d dVar = com.hbg.module.huobi.im.gift.d.f19724a;
        dVar.L(this);
        dVar.H(this);
        dVar.u().put(getLocalClassName(), new e0(this));
        dVar.w().put(getLocalClassName(), new f0(this));
        dVar.v().put(getLocalClassName(), new g0(this));
        dVar.t().put(getLocalClassName(), new h0(this));
        dVar.W(new i0(this));
        dVar.a0(new j0(this));
        dVar.U(new k0(this));
        dVar.Z(new l0(this));
        ((lc.m) Yf()).H0.addView(dVar.C());
        ((lc.m) Yf()).R0.addView(dVar.o());
        ((lc.m) Yf()).Q0.addView(dVar.n());
        ((lc.m) Yf()).H0.post(new b1(this));
        we.b.m("liveStatus", (Class) null, 2, (Object) null).observe(this, new v0(LiveDetailActivity$initView$25.INSTANCE));
        Looper.myQueue().addIdleHandler(new l0(this));
        ((lc.m) Yf()).W.getViewTreeObserver().addOnDrawListener(new f0(this));
    }

    public final void jk() {
        RequestExtKt.d(v7.b.a().getActivityStatus(1, this.f18462k), new LiveDetailActivity$initActive$1(this), LiveDetailActivity$initActive$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void jl() {
        if (Nj() != null) {
            EngineDialogFragment engineDialogFragment = this.f18459i0;
            if (engineDialogFragment != null) {
                engineDialogFragment.dismiss();
            }
            Zj();
            Jl();
        }
    }

    public final void kk() {
        TXVodPlayer tXVodPlayer = new TXVodPlayer(this);
        this.f18452c0 = tXVodPlayer;
        tXVodPlayer.setPlayerView(((lc.m) Yf()).C2);
        TXVodPlayer tXVodPlayer2 = this.f18452c0;
        if (tXVodPlayer2 != null) {
            tXVodPlayer2.setRenderMode(1);
        }
        TXVodPlayer tXVodPlayer3 = this.f18452c0;
        if (tXVodPlayer3 != null) {
            LiveDetailBean liveDetailBean = this.f18466m;
            tXVodPlayer3.startVodPlay(liveDetailBean != null ? liveDetailBean.coverVideoUrl : null);
        }
        ((lc.m) Yf()).C2.setOnClickListener(new w0(this));
        TXVodPlayer tXVodPlayer4 = this.f18452c0;
        if (tXVodPlayer4 != null) {
            tXVodPlayer4.setVodListener(new g(this));
        }
    }

    public final void kl(boolean z11) {
    }

    public final void ll() {
        String currency;
        EngineDialogFragment engineDialogFragment = this.f18459i0;
        if (engineDialogFragment != null) {
            engineDialogFragment.dismiss();
        }
        Financial a11 = com.hbg.module.content.helper.live.f.f18246a.a();
        if (a11 != null && (currency = a11.getCurrency()) != null) {
            BaseModuleConfig.a a12 = BaseModuleConfig.a();
            a12.k0("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/transfer?coin=" + currency + "&account=5");
        }
    }

    public final void mk(boolean z11) {
        TUIBarrageDisplayView displayView;
        TUIBarrageDisplayView displayView2;
        TUIBarrageDisplayView displayView3;
        TUIBarrageDisplayView displayView4;
        TUIBarrageDisplayView displayView5;
        TUIBarrageDisplayView displayView6;
        LiveDetailBean liveDetailBean = this.f18466m;
        String str = null;
        if (!sd.a.c(liveDetailBean != null ? liveDetailBean.groupChatInteractive : null)) {
            boolean z12 = false;
            if (z11) {
                TUIBarrageButton tUIBarrageButton = this.V;
                if (((tUIBarrageButton == null || (displayView6 = tUIBarrageButton.getDisplayView()) == null) ? null : displayView6.getParent()) != null) {
                    TUIBarrageButton tUIBarrageButton2 = this.V;
                    ViewGroup viewGroup = (ViewGroup) ((tUIBarrageButton2 == null || (displayView5 = tUIBarrageButton2.getDisplayView()) == null) ? null : displayView5.getParent());
                    TUIBarrageButton tUIBarrageButton3 = this.V;
                    viewGroup.removeView(tUIBarrageButton3 != null ? tUIBarrageButton3.getDisplayView() : null);
                }
                String f02 = BaseModuleConfig.a().f0();
                if (f02 != null) {
                    md.a.f22950a.n(f02);
                }
                System.out.println("requestIMUserSig = " + md.a.f22950a.i());
                this.W = false;
                Sk();
            }
            md.a aVar = md.a.f22950a;
            LiveDetailBean liveDetailBean2 = this.f18466m;
            String str2 = liveDetailBean2 != null ? liveDetailBean2.groupChatInteractive : null;
            LiveDetailBean liveDetailBean3 = this.f18466m;
            this.V = (TUIBarrageButton) aVar.d(this, str2, liveDetailBean3 != null ? liveDetailBean3.messageFromServer : 0, z11);
            u0 u0Var = new u0(this);
            this.U = u0Var;
            TUIBarrageButton tUIBarrageButton4 = this.V;
            if (tUIBarrageButton4 != null) {
                tUIBarrageButton4.setSendHideListener(u0Var);
            }
            TUIBarrageButton tUIBarrageButton5 = this.V;
            if (((tUIBarrageButton5 == null || (displayView4 = tUIBarrageButton5.getDisplayView()) == null) ? null : displayView4.getParent()) != null) {
                TUIBarrageButton tUIBarrageButton6 = this.V;
                ViewGroup viewGroup2 = (ViewGroup) ((tUIBarrageButton6 == null || (displayView3 = tUIBarrageButton6.getDisplayView()) == null) ? null : displayView3.getParent());
                TUIBarrageButton tUIBarrageButton7 = this.V;
                viewGroup2.removeView(tUIBarrageButton7 != null ? tUIBarrageButton7.getDisplayView() : null);
            }
            ((lc.m) Yf()).F2.removeAllViews();
            LinearLayout linearLayout = ((lc.m) Yf()).F2;
            TUIBarrageButton tUIBarrageButton8 = this.V;
            linearLayout.addView(tUIBarrageButton8 != null ? tUIBarrageButton8.getDisplayView() : null);
            LiveDetailBean liveDetailBean4 = this.f18466m;
            if (liveDetailBean4 != null) {
                boolean z13 = true;
                if (liveDetailBean4 != null && liveDetailBean4.presenterList != null) {
                    LiveDetailBean liveDetailBean5 = this.f18466m;
                    Iterator<LiveSpeaker> it2 = (liveDetailBean5 != null ? liveDetailBean5.presenterList : null).iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (TextUtils.equals(it2.next().showId, md.a.f22950a.i())) {
                                z12 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                LiveDetailBean liveDetailBean6 = this.f18466m;
                if (!(liveDetailBean6 == null || liveDetailBean6.speakerList == null)) {
                    LiveDetailBean liveDetailBean7 = this.f18466m;
                    Iterator<LiveSpeaker> it3 = (liveDetailBean7 != null ? liveDetailBean7.speakerList : null).iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (TextUtils.equals(it3.next().showId, md.a.f22950a.i())) {
                                break;
                            }
                        } else {
                            z13 = z12;
                            break;
                        }
                    }
                    z12 = z13;
                }
            }
            TUIBarrageButton tUIBarrageButton9 = this.V;
            if (!(tUIBarrageButton9 == null || (displayView2 = tUIBarrageButton9.getDisplayView()) == null)) {
                displayView2.setCurrUserManager(z12);
            }
            TUIBarrageButton tUIBarrageButton10 = this.V;
            if (!(tUIBarrageButton10 == null || (displayView = tUIBarrageButton10.getDisplayView()) == null)) {
                displayView.setLiveDetailBean(this.f18466m);
            }
            com.hbg.module.huobi.im.gift.d dVar = com.hbg.module.huobi.im.gift.d.f19724a;
            LiveDetailBean liveDetailBean8 = this.f18466m;
            dVar.T(liveDetailBean8 != null ? liveDetailBean8.f70249id : null);
            LiveDetailBean liveDetailBean9 = this.f18466m;
            dVar.Q(liveDetailBean9 != null ? liveDetailBean9.groupChatInteractive : null);
            LiveDetailBean liveDetailBean10 = this.f18466m;
            if (liveDetailBean10 != null) {
                str = liveDetailBean10.proceedRedPotId;
            }
            dVar.X(str);
            LiveDetailBean liveDetailBean11 = this.f18466m;
            dVar.Y(liveDetailBean11 != null ? liveDetailBean11.redPotIdIsExposure : 2);
        }
        ((lc.m) Yf()).S1.setOnClickListener(new r1(this));
    }

    public final void ml() {
        if (this.f18473r == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
            this.f18473r = alphaAnimation;
            alphaAnimation.setDuration(300);
        }
        ((lc.m) Yf()).I0.E.startAnimation(this.f18473r);
        ((lc.m) Yf()).I0.C.startAnimation(this.f18473r);
        ((lc.m) Yf()).I0.D.startAnimation(this.f18473r);
    }

    public final void nl() {
        if (this.f18468n == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, (((lc.m) Yf()).f19258w0.getX() - ((lc.m) Yf()).I0.B.getX()) - ((float) com.hbg.module.libkt.base.ext.c.a(15.0f)), 0, 0.0f, 0, 0.0f, 0, 0.0f);
            this.f18468n = translateAnimation;
            translateAnimation.setDuration(300);
        }
        ml();
        ((lc.m) Yf()).I0.getRoot().startAnimation(this.f18468n);
    }

    public void oh() {
        super.oh();
        HbgBaseProvider fg2 = fg();
        this.f18467m0 = fg2 != null ? fg2.n() : false;
        this.f18460j = getIntent().getIntExtra("liveStatus", 1);
        String stringExtra = getIntent().getStringExtra("liveId");
        if (stringExtra != null) {
            this.f18462k = stringExtra;
        }
        if (!sd.a.c(this.f18462k)) {
            HbgLiveHelper.f18227a.A();
            we.b.m("floatEvent", (Class) null, 2, (Object) null).g(new xe.d(0));
        }
    }

    public final void ol() {
        if (this.f18471p == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, (((lc.m) Yf()).f19258w0.getX() - ((lc.m) Yf()).f19249t0.getX()) - ((float) com.hbg.module.libkt.base.ext.c.a(15.0f)), 0, 0.0f, 0, 0.0f, 0, 0.0f);
            this.f18471p = translateAnimation;
            translateAnimation.setDuration(300);
        }
        pl();
        ((lc.m) Yf()).K0.startAnimation(this.f18471p);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        Handler Zf;
        LiveGroup liveGroup;
        LiveGroup liveGroup2;
        Handler Zf2;
        LiveGroup liveGroup3;
        LiveGroup liveGroup4;
        LiveGroup liveGroup5;
        String landingUrl;
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            if (i11 == 101) {
                boolean z11 = true;
                this.F = true;
                String str = null;
                nk(this, false, 1, (Object) null);
                Kk();
                HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
                TXCloudVideoView o11 = hbgLiveHelper.o();
                if (o11 != null) {
                    ((ViewGroup) o11.getParent()).removeView(o11);
                    ((lc.m) Yf()).f19262x1.addView(o11, 0);
                    if (hbgLiveHelper.s()) {
                        ((lc.m) Yf()).f19230l0.setVisibility(8);
                        ((lc.m) Yf()).J0.getRoot().setVisibility(8);
                        ((lc.m) Yf()).L0.getRoot().setVisibility(8);
                        ((lc.m) Yf()).M0.getRoot().setVisibility(8);
                    }
                }
                if (intent != null) {
                    switch (intent.getIntExtra("workType", 0)) {
                        case 1:
                            Dl();
                            return;
                        case 2:
                            HbgBaseProvider fg2 = fg();
                            if (fg2 != null && fg2.j(this)) {
                                LiveDetailBean liveDetailBean = this.f18466m;
                                if (!((liveDetailBean == null || (liveGroup5 = liveDetailBean.liveGroup) == null || liveGroup5.type != 1) ? false : true)) {
                                    if (liveDetailBean == null || (liveGroup4 = liveDetailBean.liveGroup) == null || liveGroup4.hasJion != 1) {
                                        z11 = false;
                                    }
                                    if (!z11) {
                                        Postcard a11 = b2.a.d().a("/webView/index");
                                        BaseModuleConfig.a a12 = BaseModuleConfig.a();
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("live/community/privateGroup?groupId=");
                                        LiveDetailBean liveDetailBean2 = this.f18466m;
                                        if (!(liveDetailBean2 == null || (liveGroup3 = liveDetailBean2.liveGroup) == null)) {
                                            str = liveGroup3.groupId;
                                        }
                                        sb2.append(str);
                                        a11.withString("url", a12.k(sb2.toString())).navigation(this);
                                        return;
                                    }
                                }
                                if ((Build.VERSION.SDK_INT < 23 || (Settings.canDrawOverlays(this) && hbgLiveHelper.s())) && (Zf2 = Zf()) != null) {
                                    Zf2.postDelayed(new j1(this), 1000);
                                }
                                dd.b bVar = dd.b.f22740a;
                                LiveDetailBean liveDetailBean3 = this.f18466m;
                                String str2 = (liveDetailBean3 == null || (liveGroup2 = liveDetailBean3.liveGroup) == null) ? null : liveGroup2.groupId;
                                if (!(liveDetailBean3 == null || (liveGroup = liveDetailBean3.liveGroup) == null)) {
                                    str = liveGroup.title;
                                }
                                dd.b.k(bVar, this, str2, str, (String) null, 8, (Object) null);
                                return;
                            }
                            return;
                        case 3:
                            ((lc.m) Yf()).L0.getRoot().setVisibility(8);
                            Rj();
                            return;
                        case 4:
                            Rl();
                            return;
                        case 5:
                            Handler Zf3 = Zf();
                            if (Zf3 != null) {
                                Zf3.postDelayed(new e1(this), 500);
                                return;
                            }
                            return;
                        case 6:
                            ActiveViewManager.e().n(2, this, BaseModuleConfig.a().k("live/lucky-box?liveId=" + this.f18462k), 1);
                            ((lc.m) Yf()).H.setVisibility(8);
                            ((lc.m) Yf()).E0.setVisibility(0);
                            return;
                        case 7:
                            CusMsgPrimeBox cusMsgPrimeBox = (CusMsgPrimeBox) intent.getParcelableExtra("primePopData");
                            Intent intent2 = new Intent();
                            if (cusMsgPrimeBox == null || (landingUrl = cusMsgPrimeBox.getLandingUrl()) == null || !StringsKt__StringsJVMKt.M(landingUrl, "/", false, 2, (Object) null)) {
                                z11 = false;
                            }
                            if (z11) {
                                cusMsgPrimeBox.setLandingUrl(StringsKt__StringsJVMKt.I(cusMsgPrimeBox.getLandingUrl(), "/", "", false, 4, (Object) null));
                            }
                            BaseModuleConfig.a a13 = BaseModuleConfig.a();
                            if (cusMsgPrimeBox != null) {
                                str = cusMsgPrimeBox.getLandingUrl();
                            }
                            intent2.putExtra("url", a13.k(str));
                            intent2.setClass(this, HBBaseWebActivity.class);
                            startActivity(intent2);
                            ((lc.m) Yf()).H.setVisibility(8);
                            ((lc.m) Yf()).E0.setVisibility(0);
                            return;
                        case 8:
                            Ll();
                            return;
                        case 9:
                            GiftRankDialog.a aVar = GiftRankDialog.f18674e;
                            FragmentManager supportFragmentManager = getSupportFragmentManager();
                            String str3 = this.f18462k;
                            LiveDetailBean liveDetailBean4 = this.f18466m;
                            if (liveDetailBean4 != null) {
                                str = liveDetailBean4.groupChatInteractive;
                            }
                            aVar.a(supportFragmentManager, str3, str, this.f18464l);
                            return;
                        default:
                            return;
                    }
                }
            } else if (i11 == 200) {
                finish();
            }
        } else if (i11 == 200) {
            finish();
        } else if (i11 == 201 && (Zf = Zf()) != null) {
            Zf.postDelayed(new y0(this), 2000);
        }
    }

    public void onBackPressed() {
        if (((lc.m) Yf()).M.b()) {
            ((lc.m) Yf()).M.a();
        } else {
            super.onBackPressed();
        }
    }

    public void onDestroy() {
        String str;
        super.onDestroy();
        rj.b bVar = this.f18457h0;
        if (bVar != null) {
            bVar.B();
        }
        com.hbg.module.content.utls.l lVar = this.f18482w0;
        if (lVar != null) {
            lVar.l();
        }
        com.hbg.module.content.helper.live.f.f18246a.e();
        ActiveViewManager.e().m(2);
        ActiveViewManager.e().m(1);
        rd.m.f23375a.e();
        com.hbg.module.huobi.im.gift.d.f19724a.J(this);
        md.a.f22950a.j();
        ((lc.m) Yf()).C2.onDestroy();
        TXVodPlayer tXVodPlayer = this.f18452c0;
        if (tXVodPlayer != null) {
            tXVodPlayer.stopPlay(true);
        }
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.removeCallbacks(this.D);
        }
        int i11 = this.f18460j;
        if (i11 == 1) {
            nc.c.a("APP_LIVE_notice_out", this.K);
        } else if (i11 == 2) {
            nc.c.a("APP_LIVE_livestart_signout", this.K);
        }
        this.K.put("liveTime", String.valueOf((System.currentTimeMillis() - this.L) / ((long) 1000)));
        nc.c.a("APP_LIVE_livestart_userplayer", this.K);
        LiveDetailBean liveDetailBean = this.f18466m;
        if (!(liveDetailBean == null || (str = liveDetailBean.groupChatInteractive) == null)) {
            ImManager.INSTANCE.quitChatGroup(str);
        }
        ql();
        RequestExtKt.d(v7.b.a().k0(this.f18462k), LiveDetailActivity$onDestroy$2.INSTANCE, LiveDetailActivity$onDestroy$3.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return super.onKeyDown(i11, keyEvent);
        }
        Gj();
        return false;
    }

    public void onPlayEnd() {
        ((lc.m) Yf()).f19255v0.setImageResource(R$drawable.icon_live_play);
    }

    public void onResume() {
        LiveGroup liveGroup;
        String str;
        String str2;
        super.onResume();
        HbgBaseProvider fg2 = fg();
        if (fg2 != null && fg2.n()) {
            LiveDetailBean liveDetailBean = this.f18466m;
            if (liveDetailBean != null && liveDetailBean.status == 2) {
                if (!this.f18467m0) {
                    this.f18467m0 = true;
                    mk(true);
                }
                if (!this.f18465l0) {
                    zl("requestGiftList('{\"type\":\"1\",\"cid\":\"" + this.f18462k + "\"}')");
                }
                zl("updateBalance()");
            }
        }
        rd.m.f23375a.c(false);
        ActiveViewManager.e().l(new s0(this));
        TXVodPlayer tXVodPlayer = this.f18452c0;
        if (tXVodPlayer != null) {
            tXVodPlayer.resume();
        }
        md.a.f22950a.k(this);
        HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
        if (hbgLiveHelper.t()) {
            FloatView floatView = this.D0;
            if (floatView != null) {
                floatView.m();
            }
            hbgLiveHelper.H(false);
        }
        if (this.I) {
            this.I = false;
            if (hbgLiveHelper.o() == null) {
                TXVodPlayer tXVodPlayer2 = this.f18452c0;
                if (tXVodPlayer2 != null) {
                    tXVodPlayer2.stopPlay(true);
                }
                Rj();
            } else {
                ((lc.m) Yf()).f19230l0.setVisibility(8);
                LiveDetailBean n11 = hbgLiveHelper.n();
                this.f18466m = n11;
                if (!(n11 == null || (str2 = n11.f70249id) == null)) {
                    this.f18462k = str2;
                }
                this.H = true;
                TXCloudVideoView o11 = hbgLiveHelper.o();
                if (o11 != null) {
                    ((ViewGroup) o11.getParent()).removeView(o11);
                    ((lc.m) Yf()).f19262x1.addView(o11, 0);
                }
                we.b.m("floatEvent", (Class) null, 2, (Object) null).g(new xe.d(1));
                initData();
            }
        } else {
            hbgLiveHelper.y();
        }
        hbgLiveHelper.E(this);
        if (this.f18460j == 2) {
            qj();
        }
        LiveDetailBean liveDetailBean2 = this.f18466m;
        if (!((liveDetailBean2 != null ? liveDetailBean2.status : 1) <= 1 || liveDetailBean2 == null || (liveGroup = liveDetailBean2.liveGroup) == null || (str = liveGroup.groupId) == null)) {
            try {
                ImManager.INSTANCE.getGroupChatManager().getGroupInfo(str, new t0(this));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        com.hbg.module.content.utls.l lVar = this.f18482w0;
        if (lVar != null && lVar != null) {
            lVar.m(Fj());
        }
    }

    public void onStart() {
        super.onStart();
        rd.j.f().k(((lc.m) Yf()).K, ((lc.m) Yf()).f19247s1, ((lc.m) Yf()).G);
    }

    public void onStop() {
        super.onStop();
        TXVodPlayer tXVodPlayer = this.f18452c0;
        if (tXVodPlayer != null) {
            tXVodPlayer.pause();
        }
    }

    public final void pl() {
        if (this.f18475t == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
            this.f18475t = alphaAnimation;
            alphaAnimation.setDuration(300);
        }
        ((lc.m) Yf()).K2.startAnimation(this.f18475t);
        ((lc.m) Yf()).f19208d2.startAnimation(this.f18475t);
        ((lc.m) Yf()).Y1.startAnimation(this.f18475t);
    }

    public final void qj() {
        LiveListener liveListener = this.X;
        if (liveListener != null) {
            md.a.f22950a.c(liveListener);
        }
    }

    public final void ql() {
        HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
        if (!hbgLiveHelper.s() || !this.G || (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this))) {
            hbgLiveHelper.A();
        } else {
            Fl();
        }
    }

    public final void rj() {
        nc.c.a("APP_LIVE_notice_success", this.K);
        HbgBaseProvider fg2 = fg();
        boolean z11 = true;
        if (fg2 != null && fg2.j(this)) {
            LiveDetailBean liveDetailBean = this.f18466m;
            if (liveDetailBean == null || liveDetailBean.appointed != 0) {
                z11 = false;
            }
            if (z11) {
                Tk();
            } else {
                sj();
            }
        }
    }

    public final void rl() {
        if (!this.f18486y0 && F0 != 2) {
            ((lc.m) Yf()).R(1);
            F0 = 2;
            ((lc.m) Yf()).f19238n2.startAnimation(AnimationUtils.loadAnimation(this, R$anim.redpacket_tips_in));
        }
    }

    public final void sj() {
        DialogUtils.c0(this, getResources().getString(R$string.n_live_cancel_prepare_hint_dialog), (String) null, getResources().getString(R$string.n_cancel), getResources().getString(R$string.n_confirm), t0.f18704a, new q0(this));
    }

    public final void sl() {
        HbgBaseProvider fg2 = fg();
        if ((fg2 != null ? Boolean.valueOf(fg2.j(this)) : null).booleanValue()) {
            sh();
            RequestExtKt.d(v7.b.a().getWiningInfoList(this.f18462k), new LiveDetailActivity$openWiningWindow$1(this), new LiveDetailActivity$openWiningWindow$2(this), (MutableLiveData) null, 4, (Object) null);
            Looper.myQueue().addIdleHandler(new a0(this));
        }
    }

    public final void ul() {
        BaseModuleConfig.a a11 = BaseModuleConfig.a();
        if (a11.a()) {
            TextView textView = ((lc.m) Yf()).f19242p2;
            kotlin.jvm.internal.d0 d0Var = kotlin.jvm.internal.d0.f56774a;
            String string = getString(R$string.n_redpacket_send_tips_login);
            Object[] objArr = new Object[1];
            objArr[0] = sd.a.c(a11.j0()) ? a11.getUid() : a11.j0();
            textView.setText(String.format(string, Arrays.copyOf(objArr, 1)));
            Log.d("openRedpacketTips", "avatar_url: " + a11.getAvatar());
            g6.b c11 = g6.b.c();
            ImageView imageView = ((lc.m) Yf()).f19240o2;
            String avatar = a11.getAvatar();
            int i11 = R$drawable.account_user_image;
            c11.j(imageView, avatar, i11, g6.b.c().e(i11), (tx.a) null);
            return;
        }
        ((lc.m) Yf()).f19242p2.setText(getString(R$string.n_redpacket_send_tips));
        ((lc.m) Yf()).f19240o2.setImageDrawable(getDrawable(R$drawable.icon_community_user_header));
    }

    public final void vj(boolean z11) {
        int dip2px = ScreenUtil.dip2px(15.0f);
        int dip2px2 = ScreenUtil.dip2px(8.0f);
        ViewPager viewPager = (ViewPager) ((lc.m) Yf()).O0.getRoot().findViewById(R$id.vpRecommend);
        if (z11) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ScreenUtil.dip2px(90.0f));
            layoutParams.setMargins(dip2px, dip2px2, dip2px, 0);
            viewPager.setLayoutParams(layoutParams);
            viewPager.setPageMargin(ScreenUtil.dip2px(0.0f));
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, ScreenUtil.dip2px(90.0f));
        layoutParams2.setMargins(dip2px, dip2px2, ScreenUtil.dip2px(37.0f), 0);
        viewPager.setLayoutParams(layoutParams2);
        viewPager.setPageMargin(ScreenUtil.dip2px(16.0f));
    }

    public final void vk() {
        this.f18457h0 = new rj.b(this, "liveGift");
        this.f18459i0 = new EngineDialogFragment(this.f18457h0);
        rj.b bVar = this.f18457h0;
        if (bVar != null) {
            bVar.t("onEvent", GiftPanelAbility.class);
        }
        rj.b bVar2 = this.f18457h0;
        if (bVar2 != null) {
            bVar2.A("DepositButton", DepositButton.class);
        }
        rj.b bVar3 = this.f18457h0;
        if (bVar3 != null) {
            bVar3.A("CornerView", CornerView.class);
        }
        rj.b bVar4 = this.f18457h0;
        if (bVar4 != null) {
            bVar4.H();
        }
        rj.b bVar5 = this.f18457h0;
        if (bVar5 != null) {
            bVar5.s("activity", new WeakReference(this));
        }
        rj.b bVar6 = this.f18457h0;
        if (bVar6 != null) {
            bVar6.v("integralList", new m1(this));
        }
        rj.b bVar7 = this.f18457h0;
        if (bVar7 != null) {
            bVar7.v("giftList", new n1(this));
        }
    }

    public final void vl(RecommendTrader recommendTrader) {
        LiveDetailBean liveDetailBean = this.f18466m;
        if (liveDetailBean != null) {
            liveDetailBean.recommendTrader = recommendTrader;
        }
        this.B0 = recommendTrader;
    }

    public final void wj(String str) {
        LiveDetailBean liveDetailBean = this.f18466m;
        if (liveDetailBean != null) {
            List<LiveSpeaker> list = liveDetailBean.speakerList;
            LiveTrackUtils.g(str, liveDetailBean.f70249id, liveDetailBean.title, (list == null || list.size() <= 0) ? null : liveDetailBean.speakerList.get(0).showId);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        if (((r5 != null ? r5.getUnlockIntegral() : 0) * r2) > r1.c()) goto L_0x00cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void wl(boolean r18) {
        /*
            r17 = this;
            r0 = r17
            com.hbg.module.content.helper.live.f r1 = com.hbg.module.content.helper.live.f.f18246a
            int r2 = r1.b()
            r3 = 1
            if (r2 != 0) goto L_0x000d
            r2 = r3
            goto L_0x0011
        L_0x000d:
            int r2 = r1.b()
        L_0x0011:
            r4 = 0
            if (r18 == 0) goto L_0x00db
            com.hbg.module.libkt.utils.event.bean.GiftBean r5 = r0.f18463k0
            if (r5 == 0) goto L_0x001d
            int r5 = r5.getLabel()
            goto L_0x001e
        L_0x001d:
            r5 = r4
        L_0x001e:
            java.lang.String r6 = "0"
            if (r5 <= r3) goto L_0x0048
            com.hbg.module.libkt.utils.event.bean.Financial r5 = r1.a()
            if (r5 == 0) goto L_0x002d
            double r7 = r5.getBalance()
            goto L_0x002f
        L_0x002d:
            r7 = 0
        L_0x002f:
            com.hbg.module.libkt.utils.event.bean.GiftBean r5 = r0.f18463k0
            if (r5 == 0) goto L_0x0039
            java.lang.String r5 = r5.getAmount()
            if (r5 != 0) goto L_0x003a
        L_0x0039:
            r5 = r6
        L_0x003a:
            double r9 = java.lang.Double.parseDouble(r5)
            double r11 = (double) r2
            double r9 = r9 * r11
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x0067
            we.c.r()
            return
        L_0x0048:
            com.hbg.module.libkt.utils.event.bean.GiftBean r5 = r0.f18463k0
            if (r5 == 0) goto L_0x0051
            int r5 = r5.getLeftIntegral()
            goto L_0x0052
        L_0x0051:
            r5 = r4
        L_0x0052:
            if (r5 > 0) goto L_0x00cd
            com.hbg.module.libkt.utils.event.bean.GiftBean r5 = r0.f18463k0
            if (r5 == 0) goto L_0x005d
            int r5 = r5.getUnlockIntegral()
            goto L_0x005e
        L_0x005d:
            r5 = r4
        L_0x005e:
            int r5 = r5 * r2
            int r2 = r1.c()
            if (r5 <= r2) goto L_0x0067
            goto L_0x00cd
        L_0x0067:
            com.hbg.module.libkt.utils.event.bean.GiftBean r2 = r0.f18463k0
            if (r2 == 0) goto L_0x0073
            int r2 = r2.getLabel()
            if (r2 != r3) goto L_0x0073
            r2 = r3
            goto L_0x0074
        L_0x0073:
            r2 = r4
        L_0x0074:
            if (r2 == 0) goto L_0x00ae
            int r2 = r1.c()
            com.hbg.module.libkt.utils.event.bean.GiftBean r5 = r0.f18463k0
            if (r5 == 0) goto L_0x0083
            int r5 = r5.getUnlockIntegral()
            goto L_0x0084
        L_0x0083:
            r5 = r4
        L_0x0084:
            int r2 = r2 - r5
            r1.i(r2)
            int r2 = r1.c()
            com.hbg.module.libkt.utils.event.bean.GiftBean r5 = r0.f18463k0
            if (r5 == 0) goto L_0x0095
            int r5 = r5.getUnlockIntegral()
            goto L_0x0096
        L_0x0095:
            r5 = r4
        L_0x0096:
            if (r2 >= r5) goto L_0x00db
            com.hbg.module.libkt.utils.event.bean.GiftBean r2 = r0.f18463k0
            if (r2 != 0) goto L_0x009d
            goto L_0x00db
        L_0x009d:
            if (r2 == 0) goto L_0x00a9
            int r5 = r2.getUnlockIntegral()
            int r1 = r1.c()
            int r5 = r5 - r1
            goto L_0x00aa
        L_0x00a9:
            r5 = r4
        L_0x00aa:
            r2.setLeftIntegral(r5)
            goto L_0x00db
        L_0x00ae:
            com.hbg.module.libkt.utils.event.bean.Financial r1 = r1.a()
            if (r1 == 0) goto L_0x00db
            double r7 = r1.getBalance()
            com.hbg.module.libkt.utils.event.bean.GiftBean r2 = r0.f18463k0
            if (r2 == 0) goto L_0x00c4
            java.lang.String r2 = r2.getAmount()
            if (r2 != 0) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            r6 = r2
        L_0x00c4:
            double r5 = java.lang.Double.parseDouble(r6)
            double r7 = r7 - r5
            r1.setBalance(r7)
            goto L_0x00db
        L_0x00cd:
            android.content.res.Resources r1 = r17.getResources()
            int r2 = com.hbg.module.content.R$string.n_live_gift_coin_insufficient
            java.lang.String r1 = r1.getString(r2)
            com.hbg.lib.widgets.utils.HuobiToastUtil.i(r1)
            return
        L_0x00db:
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            android.widget.ImageView r1 = r1.f19218h0
            com.hbg.module.libkt.utils.event.bean.GiftBean r2 = r0.f18463k0
            r5 = 0
            if (r2 == 0) goto L_0x00ed
            java.lang.String r2 = r2.getUrlPng()
            goto L_0x00ee
        L_0x00ed:
            r2 = r5
        L_0x00ee:
            com.hbg.module.libkt.base.ext.b.B(r1, r2)
            r17.Ej()
            com.hbg.module.huobi.im.group.ui.active.RewardsAnim r1 = new com.hbg.module.huobi.im.group.ui.active.RewardsAnim
            com.hbg.lib.core.BaseModuleConfig$a r2 = com.hbg.lib.core.BaseModuleConfig.a()
            java.lang.String r7 = r2.getAvatar()
            com.hbg.lib.core.BaseModuleConfig$a r2 = com.hbg.lib.core.BaseModuleConfig.a()
            java.lang.String r8 = r2.j0()
            com.hbg.module.libkt.utils.event.bean.GiftBean r2 = r0.f18463k0
            if (r2 == 0) goto L_0x0110
            java.lang.String r2 = r2.getGiftId()
            r9 = r2
            goto L_0x0111
        L_0x0110:
            r9 = r5
        L_0x0111:
            com.hbg.module.libkt.utils.event.bean.GiftBean r2 = r0.f18463k0
            if (r2 == 0) goto L_0x011b
            java.lang.String r2 = r2.getGiftName()
            r10 = r2
            goto L_0x011c
        L_0x011b:
            r10 = r5
        L_0x011c:
            int r2 = r0.f18461j0
            int r11 = r2 + -1
            com.hbg.module.libkt.utils.event.bean.GiftBean r2 = r0.f18463k0
            if (r2 == 0) goto L_0x012a
            java.lang.String r2 = r2.getUrlPng()
            r12 = r2
            goto L_0x012b
        L_0x012a:
            r12 = r5
        L_0x012b:
            r13 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r4)
            r15 = 0
            r16 = 1
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            com.hbg.module.libkt.utils.event.bean.GiftBean r2 = r0.f18463k0
            r6 = 3
            if (r2 == 0) goto L_0x0144
            int r2 = r2.getLabel()
            if (r2 != r6) goto L_0x0144
            r2 = r3
            goto L_0x0145
        L_0x0144:
            r2 = r4
        L_0x0145:
            if (r2 == 0) goto L_0x0180
            com.hbg.module.content.adapter.t r1 = r0.f18480v0
            if (r1 == 0) goto L_0x0156
            java.util.ArrayList r1 = r1.l()
            if (r1 == 0) goto L_0x0156
            int r1 = r1.size()
            goto L_0x0157
        L_0x0156:
            r1 = r4
        L_0x0157:
            if (r1 != 0) goto L_0x015b
        L_0x0159:
            r1 = r3
            goto L_0x0169
        L_0x015b:
            com.hbg.module.content.adapter.t r1 = r0.f18480v0
            if (r1 == 0) goto L_0x0159
            java.util.ArrayList r1 = r1.l()
            if (r1 == 0) goto L_0x0159
            int r1 = r1.size()
        L_0x0169:
            r2 = r4
        L_0x016a:
            if (r2 >= r1) goto L_0x0189
            rd.j r7 = rd.j.f()
            com.hbg.module.libkt.utils.event.bean.GiftBean r8 = r0.f18463k0
            if (r8 == 0) goto L_0x0179
            java.lang.String r8 = r8.getUrlJson()
            goto L_0x017a
        L_0x0179:
            r8 = r5
        L_0x017a:
            r7.h(r8)
            int r2 = r2 + 1
            goto L_0x016a
        L_0x0180:
            com.hbg.module.huobi.im.manager.ActiveViewManager r2 = com.hbg.module.huobi.im.manager.ActiveViewManager.e()
            com.hbg.module.huobi.im.gift.LiveGiftShowType r7 = com.hbg.module.huobi.im.gift.LiveGiftShowType.LIVE_GIFT_USER_SEND
            r2.i(r1, r7)
        L_0x0189:
            r1 = 9
            kotlin.Pair[] r1 = new kotlin.Pair[r1]
            int r2 = r0.f18460j
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r7 = "state"
            kotlin.Pair r2 = kotlin.l.a(r7, r2)
            r1[r4] = r2
            java.lang.String r2 = r0.f18462k
            java.lang.String r7 = "liveid"
            kotlin.Pair r2 = kotlin.l.a(r7, r2)
            r1[r3] = r2
            r2 = 2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            java.lang.String r8 = "player"
            kotlin.Pair r7 = kotlin.l.a(r8, r7)
            r1[r2] = r7
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r7 = r0.f18466m
            if (r7 == 0) goto L_0x01b9
            java.lang.String r7 = r7.title
            goto L_0x01ba
        L_0x01b9:
            r7 = r5
        L_0x01ba:
            java.lang.String r8 = "title"
            kotlin.Pair r7 = kotlin.l.a(r8, r7)
            r1[r6] = r7
            r7 = 4
            com.hbg.lib.network.hbg.core.bean.LiveSpeaker r8 = r0.f18455f0
            if (r8 == 0) goto L_0x01ca
            java.lang.String r8 = r8.showId
            goto L_0x01cb
        L_0x01ca:
            r8 = r5
        L_0x01cb:
            java.lang.String r9 = "upid"
            kotlin.Pair r8 = kotlin.l.a(r9, r8)
            r1[r7] = r8
            r7 = 5
            java.lang.String r8 = "roundid"
            java.lang.String r9 = ""
            kotlin.Pair r8 = kotlin.l.a(r8, r9)
            r1[r7] = r8
            r7 = 6
            com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r8 = r8.j()
            if (r8 == 0) goto L_0x01ec
            java.lang.Integer r8 = r8.getRule()
            goto L_0x01ed
        L_0x01ec:
            r8 = r5
        L_0x01ed:
            java.lang.String r9 = "lotterytype"
            kotlin.Pair r8 = kotlin.l.a(r9, r8)
            r1[r7] = r8
            r7 = 7
            com.hbg.module.libkt.utils.event.bean.GiftBean r8 = r0.f18463k0
            if (r8 == 0) goto L_0x0202
            int r5 = r8.getLabel()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        L_0x0202:
            java.lang.String r8 = "gift"
            kotlin.Pair r5 = kotlin.l.a(r8, r5)
            r1[r7] = r5
            r5 = 8
            com.hbg.module.libkt.utils.event.bean.GiftBean r7 = r0.f18463k0
            if (r7 == 0) goto L_0x0218
            int r7 = r7.getLabel()
            if (r7 != r6) goto L_0x0218
            r7 = r3
            goto L_0x0219
        L_0x0218:
            r7 = r4
        L_0x0219:
            if (r7 != 0) goto L_0x0221
            int r7 = r0.f18461j0
            if (r7 <= r2) goto L_0x0221
            r6 = r2
            goto L_0x0227
        L_0x0221:
            int r7 = r0.f18461j0
            if (r7 <= r2) goto L_0x0226
            goto L_0x0227
        L_0x0226:
            r6 = r3
        L_0x0227:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.String r6 = "giveclk"
            kotlin.Pair r2 = kotlin.l.a(r6, r2)
            r1[r5] = r2
            java.util.HashMap r1 = kotlin.collections.MapsKt__MapsKt.j(r1)
            java.lang.String r2 = "APP_LIVE_reward_give"
            nc.c.a(r2, r1)
            android.view.animation.Animation r1 = r0.R
            if (r1 != 0) goto L_0x024e
            int r1 = com.hbg.module.content.R$anim.gift_combo_scale
            android.view.animation.Animation r1 = android.view.animation.AnimationUtils.loadAnimation(r0, r1)
            r0.R = r1
            if (r1 != 0) goto L_0x024b
            goto L_0x024e
        L_0x024b:
            r1.setFillAfter(r3)
        L_0x024e:
            android.view.animation.Animation r1 = r0.S
            if (r1 != 0) goto L_0x0260
            int r1 = com.hbg.module.content.R$anim.gift_combo_num_anim
            android.view.animation.Animation r1 = android.view.animation.AnimationUtils.loadAnimation(r0, r1)
            r0.S = r1
            if (r1 != 0) goto L_0x025d
            goto L_0x0260
        L_0x025d:
            r1.setFillAfter(r3)
        L_0x0260:
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.C0
            r1.removeAllAnimatorListeners()
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.C0
            r1.cancelAnimation()
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.C0
            r1.clearAnimation()
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            android.widget.ImageView r1 = r1.f19218h0
            r1.clearAnimation()
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            android.widget.LinearLayout r1 = r1.W0
            r1.clearAnimation()
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.C0
            r1.setVisibility(r4)
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.C0
            int r2 = com.hbg.module.content.R$raw.huobi_live_gift_batter_bg_blue
            r1.setAnimation((int) r2)
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.C0
            com.hbg.module.content.ui.activity.live.LiveDetailActivity$u0 r2 = new com.hbg.module.content.ui.activity.live.LiveDetailActivity$u0
            r2.<init>(r0)
            r1.addAnimatorListener(r2)
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.C0
            android.view.animation.Animation r2 = r0.R
            r1.startAnimation(r2)
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            android.widget.ImageView r1 = r1.f19218h0
            android.view.animation.Animation r2 = r0.R
            r1.startAnimation(r2)
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.C0
            r1.playAnimation()
            x1.a r1 = r17.Yf()
            lc.m r1 = (lc.m) r1
            android.widget.LinearLayout r1 = r1.W0
            android.view.animation.Animation r2 = r0.S
            r1.startAnimation(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.live.LiveDetailActivity.wl(boolean):void");
    }

    public final void xj() {
        if (this.f18474s == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
            this.f18474s = alphaAnimation;
            alphaAnimation.setDuration(300);
        }
        ((lc.m) Yf()).I0.E.startAnimation(this.f18474s);
        ((lc.m) Yf()).I0.C.startAnimation(this.f18474s);
        ((lc.m) Yf()).I0.D.startAnimation(this.f18474s);
    }

    public final void yj() {
        if (this.f18470o == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (((lc.m) Yf()).f19258w0.getX() - ((lc.m) Yf()).I0.B.getX()) - ((float) com.hbg.module.libkt.base.ext.c.a(15.0f)), 0, 0.0f, 0, 0.0f);
            this.f18470o = translateAnimation;
            translateAnimation.setDuration(300);
            TranslateAnimation translateAnimation2 = this.f18470o;
            if (translateAnimation2 != null) {
                translateAnimation2.setAnimationListener(new b(this));
            }
        }
        xj();
        ((lc.m) Yf()).I0.getRoot().startAnimation(this.f18470o);
    }

    public final void yk() {
        nc.c.a("APP_LIVE_reward_entrance", this.K);
        ((lc.m) Yf()).f19247s1.setVisibility(0);
        boolean z11 = true;
        Ql(this, 0, 1, (Object) null);
        Vk();
        Yk();
        bl();
        al();
        vk();
        HbgBaseProvider fg2 = fg();
        if (fg2 == null || !fg2.n()) {
            z11 = false;
        }
        if (z11) {
            zl("requestGiftList('{\"type\":\"1\",\"cid\":\"" + this.f18462k + "\"}')");
        }
        ((lc.m) Yf()).f19259w1.addView(Mj());
        ((lc.m) Yf()).F2.postDelayed(new a1(this), 2000);
        LiveDetailBean liveDetailBean = this.f18466m;
        if (liveDetailBean == null) {
            return;
        }
        if (com.hbg.module.libkt.base.ext.b.w(liveDetailBean.sisterGroupList)) {
            ((lc.m) Yf()).I.setVisibility(8);
            return;
        }
        if (this.f18480v0 == null) {
            this.f18480v0 = new com.hbg.module.content.adapter.t(this, new p(this, liveDetailBean));
        }
        ((lc.m) Yf()).B1.setLayoutManager(com.hbg.module.libkt.base.ext.b.m(this));
        ((lc.m) Yf()).B1.setAdapter(this.f18480v0);
        com.hbg.module.content.adapter.t tVar = this.f18480v0;
        if (tVar != null) {
            tVar.a(0, liveDetailBean.sisterGroupList);
        }
        ((lc.m) Yf()).f19228k1.setOnClickListener(new t1(this, liveDetailBean));
        ((lc.m) Yf()).I.setVisibility(0);
    }

    public final void yl(int i11, int i12) {
        ((lc.m) Yf()).f19263x2.setText(getResources().getString(i11));
        if (HbgLiveHelper.f18227a.j(i12, false)) {
            ((lc.m) Yf()).L0.getRoot().setVisibility(8);
            ((lc.m) Yf()).J0.getRoot().setVisibility(0);
        }
        ((lc.m) Yf()).N0.getRoot().setVisibility(8);
    }

    public final void zj() {
        if (this.f18472q == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (((lc.m) Yf()).f19258w0.getX() - ((lc.m) Yf()).f19249t0.getX()) - ((float) com.hbg.module.libkt.base.ext.c.a(15.0f)), 0, 0.0f, 0, 0.0f);
            this.f18472q = translateAnimation;
            translateAnimation.setDuration(300);
            TranslateAnimation translateAnimation2 = this.f18472q;
            if (translateAnimation2 != null) {
                translateAnimation2.setAnimationListener(new c(this));
            }
        }
        Bj();
        ((lc.m) Yf()).K0.startAnimation(this.f18472q);
    }

    public final void zl(String str) {
        rj.b bVar = this.f18457h0;
        if (bVar != null) {
            bVar.I(str);
        }
    }
}
