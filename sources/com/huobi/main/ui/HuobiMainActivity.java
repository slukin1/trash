package com.huobi.main.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.blankj.utilcode.util.PermissionUtils;
import com.engagelab.privates.core.api.MTCorePrivatesApi;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.hbg.lib.common.animation.DampingInterpolator;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.VibrateManager;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.m0;
import com.hbg.lib.core.util.n;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.core.webview.trace.WebviewTracer;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.CommunityUserPermissions;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationShare;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.ClosePathFloatView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.RedPoint.AbsRedPointNodeImp;
import com.hbg.module.huobi.im.RedPoint.a;
import com.hbg.module.kline.KLineHelper;
import com.huobi.BuildConfig;
import com.huobi.account.widget.NftHexagonView;
import com.huobi.apm.TimeMonitorManager;
import com.huobi.app.GrayConfigHelper;
import com.huobi.app.H5CacheServiceHelper;
import com.huobi.app.rms.HBRMSManager;
import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import com.huobi.app.rms.bean.HBRMSResourceType;
import com.huobi.app.util.StartAppUtil;
import com.huobi.coupon.handler.CouponExperienceRequestHelper;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.entity.UpdateResponse;
import com.huobi.finance.ui.CurrencyChooseActivity;
import com.huobi.google.GooglePlayUtil;
import com.huobi.index.helper.KLineShareHelper;
import com.huobi.lifecycle.OnBackgroundStatusChangedEvent;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.controller.KillProcessProxy;
import com.huobi.main.bean.RemoteSkinBean;
import com.huobi.main.helper.AssetProfitRateHelper;
import com.huobi.main.helper.NewAccountTabRedDotHelper;
import com.huobi.main.navigator.ShackUtils;
import com.huobi.main.presenter.HuobiMainPresenter;
import com.huobi.main.trade.ui.SymbolSelectionFragment;
import com.huobi.otc.widget.OtcOrderReminder;
import com.huobi.share.bean.PreviewItem;
import com.huobi.share.helper.CaptureShareHelper;
import com.huobi.store.AppConfigManager;
import com.huobi.trade.ui.TradeGuideDialogFragment;
import com.huobi.utils.AutoUploadLogHelper;
import com.huobi.utils.HomeHelper;
import com.huobi.utils.UpgradeUtil;
import com.huobi.utils.a0;
import com.huobi.utils.k0;
import com.huobi.utils.l0;
import com.huobi.utils.q0;
import com.huobi.utils.z;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.radiogroup.RadioContainer;
import com.huobi.view.radiogroup.RadioGroupContainer;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fo.o;
import fo.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nc.b;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import pro.huobi.R;
import qh.p0;
import rl.q;
import rx.Observable;
import rx.schedulers.Schedulers;
import tg.r;
import vp.i0;
import yl.x;

public class HuobiMainActivity extends BaseActivity<HuobiMainPresenter, HuobiMainPresenter.j> implements HuobiMainPresenter.j, ShackUtils.a {
    public static boolean Y = false;
    public View A;
    public View B;
    public View C;
    public int D = 0;
    public boolean E;
    public TextView F;
    public TextView G;
    public AutoUploadLogHelper H;
    public TradeGuideDialogFragment I;
    public boolean J;
    public boolean K;
    public p L;
    public HuobiKeyboardHelper M;
    public ValueAnimator N;
    public LottieAnimationView O;
    public LottieAnimationView P;
    public LottieAnimationView Q;
    public FrameLayout R;
    public FrameLayout S;
    public View T;
    public RadioGroupContainer.OnCheckedChangeListener U = new fo.d(this);
    public long V = 0;
    public SymbolSelectionFragment.f W = new k();
    public AbsRedPointNodeImp X = new b();

    /* renamed from: b  reason: collision with root package name */
    public long f77898b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f77899c;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroupContainer f77900d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f77901e;

    /* renamed from: f  reason: collision with root package name */
    public CheckBox f77902f;

    /* renamed from: g  reason: collision with root package name */
    public CheckBox f77903g;

    /* renamed from: h  reason: collision with root package name */
    public CheckBox f77904h;

    /* renamed from: i  reason: collision with root package name */
    public CheckBox f77905i;

    /* renamed from: j  reason: collision with root package name */
    public CheckBox f77906j;

    /* renamed from: k  reason: collision with root package name */
    public CheckBox f77907k;

    /* renamed from: l  reason: collision with root package name */
    public CheckBox f77908l;

    /* renamed from: m  reason: collision with root package name */
    public CheckBox f77909m;

    /* renamed from: n  reason: collision with root package name */
    public CheckBox f77910n;

    /* renamed from: o  reason: collision with root package name */
    public CheckBox f77911o;

    /* renamed from: p  reason: collision with root package name */
    public CheckBox f77912p;

    /* renamed from: q  reason: collision with root package name */
    public CheckBox f77913q;

    /* renamed from: r  reason: collision with root package name */
    public CheckBox f77914r;

    /* renamed from: s  reason: collision with root package name */
    public CheckBox f77915s;

    /* renamed from: t  reason: collision with root package name */
    public NftHexagonView f77916t;

    /* renamed from: u  reason: collision with root package name */
    public RadioContainer f77917u;

    /* renamed from: v  reason: collision with root package name */
    public RadioContainer f77918v;

    /* renamed from: w  reason: collision with root package name */
    public com.huobi.trade.ui.j f77919w;

    /* renamed from: x  reason: collision with root package name */
    public View f77920x;

    /* renamed from: y  reason: collision with root package name */
    public View f77921y;

    /* renamed from: z  reason: collision with root package name */
    public View f77922z;

    public class a implements PermissionUtils.e {
        public a() {
        }

        public void onDenied() {
            HuobiMainActivity.this.oi();
        }

        public void onGranted() {
            HuobiMainActivity.this.oi();
        }
    }

    public class b extends AbsRedPointNodeImp {
        public b() {
        }

        public boolean a() {
            return UpgradeUtil.b();
        }

        public int b() {
            return 0;
        }
    }

    public class c implements Animator.AnimatorListener {
        public c() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            Log.d("Home", "10.0 引导动画结束");
            HuobiMainActivity.this.S.setVisibility(0);
            HuobiMainActivity huobiMainActivity = HuobiMainActivity.this;
            huobiMainActivity.guideTranslate(huobiMainActivity.S);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            Log.d("Home", "10.0 引导动画开始");
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f77926a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f77926a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f77926a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f77926a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f77926a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.C2C     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f77926a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f77926a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.main.ui.HuobiMainActivity.d.<clinit>():void");
        }
    }

    public class e implements HBWebView.b {
        public e() {
        }

        public boolean a() {
            return DomainSwitcher.A().V() != null && DomainSwitcher.A().V().request_again == 1;
        }

        public String b(String str) {
            return DomainSwitcher.A().q(str);
        }

        public boolean c() {
            H5CacheServiceHelper.H5CacheConfig h5CacheConfig = (H5CacheServiceHelper.H5CacheConfig) AppConfigManager.c(MgtConfigNumber.H5_CACHE_CONFIG.number, H5CacheServiceHelper.H5CacheConfig.class);
            if (h5CacheConfig == null || h5CacheConfig.switchSuffixDomain < 0) {
                return false;
            }
            String h11 = ku.b.e().h(HuobiMainActivity.this.getApplicationContext());
            if (TextUtils.isEmpty(h11) || h11.length() <= 3) {
                return false;
            }
            try {
                if (Integer.parseInt(h11.substring(h11.length() - 3), 16) <= h5CacheConfig.switchSuffixDomain) {
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }

        public String d(String str) {
            WoodPeckerSDK.f().g().c("WebChangeDomainDynamicReloadRequest", str, "");
            WebviewTracer.f("WebChangeDomainDynamicReloadRequest");
            return DomainSwitcher.A().q(str);
        }
    }

    public class f implements b.a {

        public class a extends BaseSubscriber<NewFlashInformationShare> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(NewFlashInformationShare newFlashInformationShare) {
                super.onNext(newFlashInformationShare);
            }
        }

        public f() {
        }

        public void a(Context context, NewFlashInformation newFlashInformation) {
            if (newFlashInformation != null) {
                String str = null;
                try {
                    if (!com.hbg.module.libkt.base.ext.b.w(newFlashInformation.getImages())) {
                        str = newFlashInformation.getImages().get(0).getImage();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                PreviewItem previewItem = new PreviewItem();
                previewItem.setTitle(newFlashInformation.getTitle());
                previewItem.setContent(newFlashInformation.getContent());
                previewItem.setIssueTime(newFlashInformation.getIssueTime());
                previewItem.setRaiseNumber(newFlashInformation.getBullVote());
                previewItem.setDownNumber(newFlashInformation.getBadVote());
                previewItem.setShareImg(str);
                previewItem.setId(newFlashInformation.getId());
                yl.a.i(context, previewItem);
            }
            v7.b.a().S0(newFlashInformation.getId(), m0.a()).b().compose(RxJavaHelper.t(HuobiMainActivity.this.getUI())).subscribe(new a());
        }
    }

    public class g extends EasySubscriber<androidx.core.util.c<Bitmap, Float>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f77930b;

        public g(String str) {
            this.f77930b = str;
        }

        /* renamed from: a */
        public void onNext(androidx.core.util.c<Bitmap, Float> cVar) {
            super.onNext(cVar);
            if (cVar != null && cVar.f8468a != null && cVar.f8469b != null) {
                PreviewItem previewItem = new PreviewItem();
                previewItem.setIssueTime(DateTimeUtils.v());
                previewItem.setBmp((Bitmap) cVar.f8468a);
                KLineShareHelper.c(previewItem, this.f77930b);
            }
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public class h implements a.C0138a {
        public h() {
        }

        public void a(com.hbg.module.huobi.im.RedPoint.a aVar) {
            int b11 = aVar.b();
            if (!aVar.a()) {
                HuobiMainActivity.this.F.setVisibility(8);
                HuobiMainActivity.this.f77921y.setVisibility(8);
            } else if (b11 > 0) {
                HuobiMainActivity.this.f77921y.setVisibility(8);
                if (b11 > 99) {
                    HuobiMainActivity.this.F.setText("99+");
                } else {
                    TextView wh2 = HuobiMainActivity.this.F;
                    wh2.setText(b11 + "");
                }
                HuobiMainActivity.this.F.setVisibility(0);
            } else {
                HuobiMainActivity.this.F.setVisibility(8);
                HuobiMainActivity.this.f77921y.setVisibility(0);
            }
        }
    }

    public class i implements ClosePathFloatView.d {
        public i() {
        }

        public void a() {
            is.a.o("5160", (Map<String, Object>) null, "0");
        }

        public void onCloseClick() {
            is.a.o("5161", (Map<String, Object>) null, "0");
        }

        public void onShow() {
            is.a.o("5240", (Map<String, Object>) null, "0");
        }
    }

    public class j implements Animation.AnimationListener {
        public j() {
        }

        public void onAnimationEnd(Animation animation) {
            Log.d("Home", "onAnimationEnd");
            HuobiMainActivity.this.R.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
            Log.d("Home", "onAnimationRepeat");
        }

        public void onAnimationStart(Animation animation) {
            Log.d("Home", "onAnimationStart");
        }
    }

    public class k implements SymbolSelectionFragment.f {
        public k() {
        }

        public void a(TradeType tradeType, String str, Object obj) {
            switch (d.f77926a[tradeType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    ((HuobiMainPresenter) HuobiMainActivity.this.getPresenter()).K0(str, tradeType);
                    break;
                case 5:
                    if (!(obj instanceof ContractCurrencyInfo)) {
                        if (obj instanceof SwapCurrencyInfo) {
                            ((HuobiMainPresenter) HuobiMainActivity.this.getPresenter()).L0((SwapCurrencyInfo) obj, tradeType);
                            break;
                        }
                    } else {
                        ((HuobiMainPresenter) HuobiMainActivity.this.getPresenter()).f0((ContractCurrencyInfo) obj, tradeType);
                        break;
                    }
                    break;
                case 6:
                    if (obj instanceof FutureContractInfo) {
                        ((HuobiMainPresenter) HuobiMainActivity.this.getPresenter()).s0((FutureContractInfo) obj, tradeType);
                        break;
                    }
                    break;
            }
            boolean z11 = true;
            boolean z12 = TradeType.PRO == tradeType && com.hbg.lib.core.util.b.c().f();
            boolean z13 = TradeType.MARGIN == tradeType && com.hbg.lib.core.util.b.c().f();
            if (TradeType.SUPERMARGIN != tradeType || !com.hbg.lib.core.util.b.c().f()) {
                z11 = false;
            }
            if (z12 || z13 || z11) {
                HuobiMainActivity.this.f77920x.setVisibility(8);
            } else {
                HuobiMainActivity.this.f77920x.setVisibility(0);
            }
        }
    }

    public class l implements AppLinkData.CompletionHandler {
        public l() {
        }

        public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onDeferredAppLinkDataFetched --> appLinkData:");
            sb2.append(appLinkData != null ? appLinkData.toString() : "");
            Log.d("HuobiMainActivity", sb2.toString());
            if (appLinkData != null) {
                Uri targetUri = appLinkData.getTargetUri();
                if (HuobiMainActivity.this.Gh(targetUri)) {
                    zn.a.d().v(targetUri);
                    zn.a.d().c();
                    Log.d("HuobiMainActivity", "Facebook Deferred Deep Linking Target url: " + targetUri);
                }
            }
        }
    }

    public class m extends BaseSubscriber<CommunityUserPermissions> {
        public m() {
        }

        /* renamed from: a */
        public void onNext(CommunityUserPermissions communityUserPermissions) {
            super.onNext(communityUserPermissions);
            if (communityUserPermissions != null) {
                r.x().A0(communityUserPermissions.getIsSuper(), communityUserPermissions.getIsMute(), communityUserPermissions.getUidUnique());
                wf.a aVar = wf.a.f40622a;
                boolean z11 = false;
                aVar.i(communityUserPermissions.getIsPublish() == 1);
                aVar.k(communityUserPermissions.getPublishTips());
                if (communityUserPermissions.getIsLiveShare() == 1) {
                    z11 = true;
                }
                aVar.h(z11);
                aVar.j(communityUserPermissions.getPublishRedirectUrl());
            }
        }
    }

    public static /* synthetic */ androidx.core.util.c Sh(View view, Integer num) {
        Float f11;
        float height;
        int width;
        Bitmap f12 = CaptureShareHelper.f(view);
        try {
            if (f12.getWidth() == 0) {
                height = (float) PixelUtils.f();
                width = PixelUtils.g();
            } else {
                height = (float) f12.getHeight();
                width = f12.getWidth();
            }
            f11 = Float.valueOf(height / ((float) width));
        } catch (Throwable th2) {
            i6.d.g(th2);
            f11 = null;
        }
        return new androidx.core.util.c(f12, f11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Th(FragmentActivity fragmentActivity, View view, String str) {
        Observable.just(1).map(new fo.e(view)).subscribeOn(Schedulers.io()).subscribe(new g(str));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Uh(int i11) {
        if (i11 == 1) {
            startActivity(k0.p(this));
            this.I.dismiss();
        } else if (i11 == 2) {
            if (r.x().F0()) {
                CurrencyChooseActivity.ph(this, (String) null, "3", (String) null, false);
            } else {
                Intent intent = new Intent(this, CurrencyChooseActivity.class);
                intent.putExtra("KEY_JUMP_FOR", "3");
                rn.c.i().d(this, new JumpTarget(intent, (Intent) null));
            }
            this.I.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vh() {
        this.I = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wh(Object obj) {
        hi();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Xh(View view) {
        KillProcessProxy.d(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void Yh(View view, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View childAt = ((RadioContainer) view).getChildAt(0);
        childAt.setScaleX(floatValue);
        childAt.setScaleY(floatValue);
        childAt.setPivotX((float) (childAt.getWidth() / 2));
        childAt.setPivotY((float) childAt.getHeight());
        childAt.invalidate();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zh(RadioGroupContainer radioGroupContainer, View view, int i11, int i12) {
        Class<HuobiMainActivity> cls = HuobiMainActivity.class;
        if (this.D != i11) {
            this.D = i11;
            if (view instanceof RadioContainer) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.86f});
                this.N = ofFloat;
                ofFloat.addUpdateListener(new fo.a(view));
                this.N.setInterpolator(new DampingInterpolator());
                this.N.setDuration(400);
                this.N.start();
            }
            HashMap hashMap = new HashMap();
            i6.d.e("HuobiMainActivity", "caoxianjin, OnCheckedChangeListener, mCheckedId:" + this.D);
            switch (this.D) {
                case R.id.main_account_tab:
                    hashMap.put("button_name", "me");
                    this.f77920x.setVisibility(0);
                    startActivity(k0.b(this));
                    gs.g.i("main_Me_tab", (HashMap) null);
                    n.o().n();
                    break;
                case R.id.main_balance_tab:
                    hashMap.put("button_name", "assets");
                    Intent putExtra = new Intent(this, cls).putExtra("navigator_action", k0.r());
                    rn.c.i().d(this, new JumpTarget(k0.c(this), putExtra));
                    break;
                case R.id.main_cc_tab:
                    hashMap.put("button_name", "trade");
                    if (com.hbg.lib.core.util.b.c().f()) {
                        this.f77920x.setVisibility(8);
                    }
                    startActivity(new Intent(this, cls).putExtra("navigator_action", k0.w()));
                    break;
                case R.id.main_contract_tab:
                    this.f77920x.setVisibility(0);
                    hashMap.put("button_name", "contracts");
                    startActivity(new Intent(this, cls).putExtra("navigator_action", k0.f()));
                    break;
                case R.id.main_home_tab:
                    this.f77920x.setVisibility(0);
                    startActivity(k0.h(this));
                    hashMap.put("button_name", "home");
                    break;
                case R.id.main_market_tab:
                    this.f77920x.setVisibility(0);
                    startActivity(k0.n(this));
                    hashMap.put("button_name", "markets");
                    break;
            }
            if (hashMap.size() > 0) {
                gs.g.i("appclick_tab", hashMap);
                Y = true;
            }
            VibrateManager.a(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ai() {
        x.n().t(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ci(boolean z11, String str, HBDialogFragment hBDialogFragment) {
        if (!z11) {
            hBDialogFragment.dismiss();
        } else {
            ((HuobiMainPresenter) getPresenter()).k0(str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void di(String str, HBDialogFragment hBDialogFragment) {
        ((HuobiMainPresenter) getPresenter()).k0(str);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void fi(View view) {
        guideCloseTranslate(this.S);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Gb() {
        if (this.f77922z.getVisibility() == 0) {
            gs.g.i("app_assets_bottom_RedDot_click", (HashMap) null);
            return;
        }
        TextView textView = this.G;
        if (textView != null && textView.getVisibility() == 0) {
            gs.g.i("app_assets_bottom_PL_click", (HashMap) null);
        }
    }

    public final boolean Gh(Uri uri) {
        return uri != null && !TextUtils.isEmpty(uri.toString()) && !Jh();
    }

    public void Hd(String str, String str2) {
        try {
            new DialogUtils.b.d(this, R.style.CustomDialog_DayTheme).C0(str2).T0(true).P0(getString(R.string.string_btn_ok)).Q0(o.f54728a).o0(true).n0(true).j0().show(getSupportFragmentManager(), "");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void Hh() {
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.N = null;
        }
    }

    /* renamed from: Ih */
    public HuobiMainPresenter createPresenter() {
        return new HuobiMainPresenter();
    }

    public void Jc() {
        this.X.c();
    }

    public final boolean Jh() {
        boolean l11 = SP.l("key_facebook_deep_link_welfare_center", false);
        if (!l11) {
            SP.y("key_facebook_deep_link_welfare_center", true);
        }
        return l11;
    }

    public final void Kh() {
        FacebookSdk.setAutoInitEnabled(true);
        AppLinkData.fetchDeferredAppLinkData(this, new l());
    }

    public HuobiMainPresenter Lh() {
        return (HuobiMainPresenter) getPresenter();
    }

    /* renamed from: Mh */
    public HuobiMainPresenter.j getUI() {
        return this;
    }

    public final void Nh() {
        if (r.x().F0()) {
            v7.b.a().getCommunityUserPermissions().b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new m());
        }
    }

    public final void Oh(Fragment fragment, int i11, int i12, Intent intent) {
        fragment.onActivityResult(i11, i12, intent);
        List<Fragment> B0 = fragment.getChildFragmentManager().B0();
        if (B0 != null) {
            for (Fragment next : B0) {
                if (next != null) {
                    Oh(next, i11, i12, intent);
                }
            }
        }
    }

    public void Pe(boolean z11) {
    }

    public final void Ph() {
        nc.b.b(new f());
        KLineHelper.m(new fo.b(this));
    }

    public final void Qh() {
        TradeGuideDialogFragment tradeGuideDialogFragment = new TradeGuideDialogFragment();
        this.I = tradeGuideDialogFragment;
        tradeGuideDialogFragment.sh(new fo.c(this));
        this.I.setDialogDismissListener(new fo.l(this));
    }

    public boolean Rh() {
        return this.E;
    }

    public void V5(int i11) {
        this.f77900d.setOnSelelctChangeListner((RadioGroupContainer.OnCheckedChangeListener) null);
        this.f77900d.setCheckedId(i11);
        HbgDialogManager.A().u();
        this.D = i11;
        if (i11 == R.id.main_cc_tab) {
            boolean z11 = true;
            boolean z12 = TradeType.PRO == ((HuobiMainPresenter) getPresenter()).i0() && com.hbg.lib.core.util.b.c().f();
            boolean z13 = TradeType.MARGIN == ((HuobiMainPresenter) getPresenter()).i0() && com.hbg.lib.core.util.b.c().f();
            if (TradeType.SUPERMARGIN != ((HuobiMainPresenter) getPresenter()).i0() || !com.hbg.lib.core.util.b.c().f()) {
                z11 = false;
            }
            if (z12 || z13 || z11) {
                this.f77920x.setVisibility(8);
            } else {
                this.f77920x.setVisibility(0);
            }
        } else if (i11 == R.id.main_contract_tab) {
            this.f77920x.setVisibility(0);
            com.huobi.main.helper.l.c().b();
        } else {
            this.f77920x.setVisibility(0);
            com.huobi.main.helper.l.c().b();
        }
        this.f77900d.setOnSelelctChangeListner(this.U);
    }

    public void addEvent() {
        this.f77900d.setOnSelelctChangeListner(this.U);
        ((ClosePathFloatView) this.viewFinder.b(R.id.id_close_path_float_view)).setCallback(new i());
    }

    public void ag() {
        p0.n().D(this, this.f77912p);
    }

    public void attachBaseContext(Context context) {
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiMainActivity attachBaseContext start                      ");
        super.attachBaseContext(context);
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiMainActivity attachBaseContext end                      ");
    }

    public int getContentView() {
        return R.layout.activity_main;
    }

    public final void gi() {
        TimeMonitorManager.a().b("index_banner_consume").c();
        TimeMonitorManager.a().b("index_fixed_symbols_consume").c();
        TimeMonitorManager.a().b("index_operation_consume").c();
        TimeMonitorManager.a().b("index_rank_consume").c();
        TimeMonitorManager.a().b("index_announcement_consume").c();
        TimeMonitorManager.a().b("index_biz_consume").c();
        TimeMonitorManager.a().b("index_earn_consume").c();
    }

    public void guideCloseTranslate(View view) {
        Log.d("Home", "guideCloseTranslate");
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.3f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(400);
        animationSet.setAnimationListener(new j());
        view.startAnimation(animationSet);
    }

    public void guideTranslate(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.3f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(400);
        view.startAnimation(animationSet);
    }

    public final void hi() {
        int i11 = 0;
        boolean k11 = SP.k("couponChoose", "hasNewCoupon9", false);
        boolean k12 = SP.k("couponChoose", "hasNewCoupon9,12", false);
        View view = this.B;
        if (!k11 && !k12) {
            i11 = 8;
        }
        view.setVisibility(i11);
    }

    public final void ii() {
        if (Build.VERSION.SDK_INT < 23 || PermissionUtils.u("android.permission.READ_PHONE_STATE")) {
            oi();
        } else {
            PermissionUtils.z("android.permission.READ_PHONE_STATE").o(new a()).B();
        }
    }

    public void initView() {
        hideStatusBar();
        removeWinBg();
        LogAndWoodRecorder.c("DEVICE_INFO", "\n{\n    系统版本：" + Build.VERSION.RELEASE + "\n    设备型号：" + Build.MODEL + "\n    制造商：" + Build.MANUFACTURER + "\n    App版本：" + "10.54.0" + "\n    WebUrl：" + a0.j() + "\n    Api域名：" + DomainSwitcher.r() + "\n}\n");
        this.f77900d = (RadioGroupContainer) this.viewFinder.b(R.id.main_tab);
        this.f77917u = (RadioContainer) this.viewFinder.b(R.id.main_cc_tab);
        this.f77918v = (RadioContainer) this.viewFinder.b(R.id.main_contract_tab);
        this.f77920x = this.viewFinder.b(R.id.tab_line);
        this.f77921y = this.viewFinder.b(R.id.v_setting_count_dot);
        this.f77922z = this.viewFinder.b(R.id.v_assert_count_dot);
        this.A = this.viewFinder.b(R.id.v_market_count_dot);
        this.B = this.viewFinder.b(R.id.v_trade_count_dot);
        this.C = this.viewFinder.b(R.id.v_contract_count_dot);
        this.O = (LottieAnimationView) this.viewFinder.b(R.id.lottie_guide_first);
        this.P = (LottieAnimationView) this.viewFinder.b(R.id.lottie_guide_middle);
        this.Q = (LottieAnimationView) this.viewFinder.b(R.id.lottie_guide_end);
        this.R = (FrameLayout) this.viewFinder.b(R.id.lottie_guide_fl);
        this.S = (FrameLayout) this.viewFinder.b(R.id.home_guide_fl);
        this.T = this.viewFinder.b(R.id.home_guide_text);
        hi();
        we.b.l("tradeCouponPoint", Object.class).observe(this, new fo.j(this));
        GooglePlayUtil.b(this, new fo.g(this));
        this.L = new p(this);
        getSupportFragmentManager().r1(this.L, false);
        if (gj.d.n().E()) {
            this.f77918v.setVisibility(0);
        } else {
            this.f77918v.setVisibility(8);
        }
        if (HomeHelper.j()) {
            this.viewFinder.b(R.id.main_account_tab).setVisibility(8);
        }
        this.M = new HuobiKeyboardHelper().attach(this);
        this.f77901e = (ImageView) this.viewFinder.b(R.id.ivMask);
        CheckBox checkBox = (CheckBox) this.viewFinder.b(R.id.main_index_cb);
        this.f77902f = checkBox;
        checkBox.setTag(Integer.valueOf(R.drawable.tab_bg_home));
        CheckBox checkBox2 = (CheckBox) this.viewFinder.b(R.id.main_index_cb_bg);
        this.f77903g = checkBox2;
        checkBox2.setTag(Integer.valueOf(R.drawable.tab_bg_feed_top_bg));
        CheckBox checkBox3 = (CheckBox) this.viewFinder.b(R.id.main_index_cb_icon);
        this.f77904h = checkBox3;
        checkBox3.setTag(Integer.valueOf(R.drawable.tab_bg_feed_top_icon));
        this.f77905i = (CheckBox) this.viewFinder.b(R.id.main_index_txt_cb);
        this.f77906j = (CheckBox) this.viewFinder.b(R.id.main_market_cb);
        this.f77907k = (CheckBox) this.viewFinder.b(R.id.main_market_txt_cb);
        this.f77908l = (CheckBox) this.viewFinder.b(R.id.main_trade_cb);
        this.f77909m = (CheckBox) this.viewFinder.b(R.id.main_trade_txt_cb);
        this.f77910n = (CheckBox) this.viewFinder.b(R.id.main_contract_cb);
        this.f77911o = (CheckBox) this.viewFinder.b(R.id.main_contract_txt_cb);
        this.f77912p = (CheckBox) this.viewFinder.b(R.id.main_balance_cb);
        this.f77913q = (CheckBox) this.viewFinder.b(R.id.main_balance_txt_cb);
        this.f77914r = (CheckBox) this.viewFinder.b(R.id.main_account_tab_checkbox);
        this.f77915s = (CheckBox) this.viewFinder.b(R.id.main_account_tab_txt_checkbox);
        this.f77916t = (NftHexagonView) this.viewFinder.b(R.id.main_account_tab_checkbox_iv);
        this.F = (TextView) this.viewFinder.b(R.id.msgUnreadCount);
        this.f77899c = (RelativeLayout) this.viewFinder.b(R.id.rootView);
        com.hbg.module.huobi.im.RedPoint.b.a().h(new h());
        PrintStream printStream = System.out;
        printStream.println("RegistrationId===>>> " + MTCorePrivatesApi.getRegistrationId(this) + ", UserId == " + MTCorePrivatesApi.getUserId(this));
    }

    public void j4(double d11) {
    }

    public void ji(com.huobi.trade.ui.j jVar) {
        this.f77919w = jVar;
    }

    public void k4() {
        int f11 = ConfigPreferences.f("config_username", "config_first_update_v10_user");
        boolean l11 = SP.l("key_new_home_guide", true);
        if (f11 == 1 && l11 && HomeHelper.j()) {
            this.Q.addAnimatorListener(new c());
            this.R.setOnClickListener(fo.i.f54719b);
            this.T.setOnClickListener(new fo.h(this));
            this.R.setVisibility(0);
            this.O.playAnimation();
            this.P.playAnimation();
            this.Q.playAnimation();
            SP.y("key_new_home_guide", false);
        }
    }

    public void k5(UpdateResponse updateResponse) {
        eh.h.z(this, updateResponse);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r1.G;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k6(boolean r2) {
        /*
            r1 = this;
            android.view.View r0 = r1.f77922z
            if (r2 == 0) goto L_0x0010
            android.widget.TextView r2 = r1.G
            if (r2 == 0) goto L_0x000e
            int r2 = r2.getVisibility()
            if (r2 == 0) goto L_0x0010
        L_0x000e:
            r2 = 0
            goto L_0x0012
        L_0x0010:
            r2 = 8
        L_0x0012:
            r0.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.main.ui.HuobiMainActivity.k6(boolean):void");
    }

    public void ka(boolean z11) {
        this.A.setVisibility(z11 ? 0 : 8);
    }

    public void ki(boolean z11) {
        ViewUtil.m(this.f77920x, z11);
    }

    public void l4() {
        TextView textView = this.G;
        if (textView != null) {
            textView.setVisibility(8);
        }
        AssetProfitRateHelper.a().b();
    }

    public void li() {
        if (!n.o().p() && com.huobi.main.helper.f.c().b() && this.f77914r != null && Rh()) {
            n.o().I(this.f77914r);
            com.huobi.main.helper.f.c().j();
        }
    }

    public final void mi() {
        HuobiMainPresenter huobiMainPresenter = (HuobiMainPresenter) getPresenter();
        if (huobiMainPresenter != null && huobiMainPresenter.h0() != null) {
            Class<?> cls = huobiMainPresenter.h0().getClass();
            if (huobiMainPresenter.h0() != null && i0.class.isAssignableFrom(cls)) {
                OtcOrderReminder.e().c(this);
            }
        }
    }

    public void ni() {
        int b11 = yl.n.b();
        int b12 = yl.n.b();
        if (b12 != 1) {
            if (b12 == 2 && !SP.l("sp_key_trade_guide_transfer", false)) {
                Qh();
                this.I.th(getSupportFragmentManager(), "tradeGuide", b11);
                SP.y("sp_key_trade_guide_transfer", true);
            }
        } else if (!SP.l("sp_key_trade_guide_otc", false)) {
            Qh();
            this.I.th(getSupportFragmentManager(), "tradeGuide", b11);
            SP.y("sp_key_trade_guide_otc", true);
        }
    }

    public final void oi() {
        if (!ri()) {
            String b11 = z.b();
            if (!StringUtils.r(b11)) {
                pi(b11);
            } else {
                z.c(bh.j.c(), new fo.k(this));
            }
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        for (int i13 = 0; i13 < supportFragmentManager.B0().size(); i13++) {
            Fragment fragment = supportFragmentManager.B0().get(i13);
            if (fragment != null) {
                Oh(fragment, i11, i12, intent);
            }
        }
    }

    public void onBackPressed() {
        HuobiKeyboardHelper huobiKeyboardHelper = this.M;
        if (huobiKeyboardHelper == null || !huobiKeyboardHelper.isKeyboardShowing()) {
            com.huobi.trade.ui.j jVar = this.f77919w;
            if (jVar == null || !jVar.X5()) {
                int i11 = this.D;
                if (i11 == R.id.main_home_tab) {
                    if (System.currentTimeMillis() - this.V > 3000) {
                        HuobiToastUtil.s(R.string.n_exit_application);
                        this.V = System.currentTimeMillis();
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.MAIN");
                        intent.setFlags(268435456);
                        intent.addCategory("android.intent.category.HOME");
                        startActivity(intent);
                    } catch (Exception unused) {
                        KillProcessProxy.c(this);
                    }
                } else if (i11 == R.id.main_market_tab || i11 == R.id.main_cc_tab || i11 == R.id.main_contract_tab || i11 == R.id.main_balance_tab || i11 == R.id.main_account_tab) {
                    startActivity(k0.h(this));
                }
            }
        } else {
            this.M.hideKeyboard();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onBackgroundStatusChanged(OnBackgroundStatusChangedEvent onBackgroundStatusChangedEvent) {
        if (onBackgroundStatusChangedEvent.a() == OnBackgroundStatusChangedEvent.STATUS.FOREGROUND) {
            zn.a.d().c();
            CouponExperienceRequestHelper.getInstance().requestCouponExperience();
        } else if (onBackgroundStatusChangedEvent.a() == OnBackgroundStatusChangedEvent.STATUS.BACKGROUND) {
            this.f77898b = System.currentTimeMillis();
            CouponExperienceRequestHelper.getInstance().stopCouponExperienceLoop();
        }
    }

    public void onCreate(Bundle bundle) {
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiMainActivity onCreate start                      ");
        HashMap hashMap = new HashMap();
        hashMap.put("Step_Home_td", Long.valueOf(System.currentTimeMillis() - StartAppUtil.f42186d));
        hashMap.put("Step_Home_ts", Long.valueOf(System.currentTimeMillis()));
        ah.a.c().g("appStartTime", hashMap);
        if (bundle != null) {
            bundle.putParcelable("android:support:fragments", (Parcelable) null);
        }
        if (NightHelper.e().g()) {
            setTheme(R.style.ActivityKlineNight);
        } else {
            setTheme(R.style.ActivityKlineLight);
        }
        super.onCreate(bundle);
        SP.o("couponChoose", "currentId");
        EventBus.d().p(this);
        LiteReHelper.a().c(false);
        x.n().x(new fo.f(this));
        gi();
        AutoUploadLogHelper autoUploadLogHelper = new AutoUploadLogHelper();
        this.H = autoUploadLogHelper;
        autoUploadLogHelper.L(this);
        Ph();
        dh.g.d().s();
        if (dh.g.d().o()) {
            dh.g.d().r();
        }
        PhoneUtils.v();
        Nh();
        if (!TextUtils.isEmpty(yl.o.b("huobi_first_start", getApplicationContext(), "starttag"))) {
            TimeMonitorManager.a().b("app_cold_launch_time").a("app_cold_launch_time", "app_cold_launch_tag_home_oncreate", true);
        } else {
            Context applicationContext = getApplicationContext();
            yl.o.z("huobi_first_start", applicationContext, "starttag", System.currentTimeMillis() + "");
            TimeMonitorManager.a().b("app_cold_launch_time").a("app_cold_launch_time", "app_cold_launch_tag_home_oncreate", false);
            Log.d("TimeMonitor", "onCreate: 首次启动,不打点了,正常结速,但不上报");
        }
        dd.b.f22740a.e();
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiMainActivity onCreate end                      ");
        sn.c.a().b();
        NewAccountTabRedDotHelper.f().g();
        tg.h.c();
        com.hbg.module.huobi.im.RedPoint.b.a().b().f(this.X);
        GrayConfigHelper.f();
        LegalCurrencyConfigUtil.X(false).compose(RxJavaHelper.s()).subscribe(new BaseSubscriber());
        HBWebView.setErrorListener(new e());
        Log.d("BUILD_ID", "" + BuildConfig.f40904a);
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
        Hh();
        AutoUploadLogHelper autoUploadLogHelper = this.H;
        if (autoUploadLogHelper != null) {
            autoUploadLogHelper.K();
        }
        if (this.L != null) {
            getSupportFragmentManager().O1(this.L);
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ((HuobiMainPresenter) getPresenter()).l0(intent);
    }

    public void onPause() {
        super.onPause();
        this.E = false;
        com.huobi.main.helper.l.c().b();
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        rl.p.e().i(getApplication());
        CouponExperienceRequestHelper.getInstance().requestCouponExperience();
    }

    public void onResume() {
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiMainActivity onResume start                      ");
        super.onResume();
        Nh();
        qi();
        this.E = true;
        int i11 = this.D;
        if (i11 == R.id.main_home_tab || i11 == R.id.main_cc_tab || i11 == R.id.main_contract_tab) {
            ((HuobiMainPresenter) getPresenter()).g0();
        }
        if (this.D == R.id.main_home_tab) {
            ((HuobiMainPresenter) getPresenter()).d0(true);
        }
        Pe(UpgradeUtil.c());
        Jc();
        com.huobi.main.helper.l.c().e(this, this.W);
        zn.a.d().c();
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HuobiMainActivity onResume end                      ");
        Kh();
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        super.onStart();
        ii();
        mi();
        q0.d().c(this);
    }

    public void onStop() {
        super.onStop();
        OtcOrderReminder.e().d(this);
    }

    public final void pi(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("DownloadChannel", ChannelUtils.a());
            if (str != null) {
                jSONObject.put("$gaid", str);
            }
            String a11 = l0.a();
            if (StringUtils.q(a11)) {
                jSONObject.put("$oaid", a11);
            }
            SensorsDataAPI.sharedInstance().trackAppInstall(jSONObject);
            i6.d.c("SensorsDataAPI", "SensorsDataAPI.sharedInstance().trackAppInstall is called.");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void q9(boolean z11) {
        this.C.setVisibility(z11 ? 0 : 8);
    }

    public final void qi() {
        RemoteSkinBean.RemoteTabBarBean.TabBarBean tabBarBean;
        ColorStateList colorStateList;
        Drawable drawable;
        HuobiMainActivity huobiMainActivity;
        BufferedReader bufferedReader;
        Throwable th2;
        boolean y11 = gj.d.n().y();
        List<HBRMSResourceInfoModel> K2 = HBRMSManager.z().K(HBRMSResourceType.Skin);
        if (!com.hbg.module.libkt.base.ext.b.w(K2)) {
            StringBuilder sb2 = new StringBuilder();
            File file = new File(K2.get(0).getResourcePath() + "/config.json");
            if (file.exists()) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                        sb2.append("\n");
                    }
                    bufferedReader.close();
                } catch (Exception e11) {
                    e11.printStackTrace();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                RemoteSkinBean remoteSkinBean = (RemoteSkinBean) rd.d.f23353a.b(sb2.toString(), RemoteSkinBean.class);
                boolean g11 = NightHelper.e().g();
                if (remoteSkinBean != null) {
                    Log.d("HuobiMainActivity", "skin--首页tab开始设置动态皮肤--mRemoteSkinHasSet:" + this.K);
                    if (!this.K) {
                        ColorStateList colorStateList2 = ContextCompat.getColorStateList(this, R.color.color_grey_orange);
                        Drawable drawable2 = ContextCompat.getDrawable(this, R.color.baseColorTabbarNavigation);
                        this.f77901e.setVisibility(8);
                        this.f77920x.setBackground(ContextCompat.getDrawable(this, R.color.baseColorPrimarySeparator));
                        RemoteSkinBean.RemoteTabBarBean tabbar = remoteSkinBean.getTabbar();
                        if (tabbar != null) {
                            if (g11) {
                                tabBarBean = tabbar.getNight();
                            } else {
                                tabBarBean = tabbar.getLight();
                            }
                            String background = tabBarBean.getBackground();
                            RemoteSkinBean.RemoteTabBarBean.TabBarBean.TabBarItem home = tabBarBean.getHome();
                            RemoteSkinBean.RemoteTabBarBean.TabBarBean.TabBarItem market = tabBarBean.getMarket();
                            RemoteSkinBean.RemoteTabBarBean.TabBarBean.TabBarItem trade = tabBarBean.getTrade();
                            RemoteSkinBean.RemoteTabBarBean.TabBarBean.TabBarItem balance = tabBarBean.getBalance();
                            RemoteSkinBean.RemoteTabBarBean.TabBarBean.TabBarItem contract = tabBarBean.getContract();
                            RemoteSkinBean.RemoteTabBarBean.TabBarBean.TabBarItem account = tabBarBean.getAccount();
                            RemoteSkinBean.RemoteTabBarBean.TabBarBean.TabRocketItem rocket = tabBarBean.getRocket();
                            String icon = home.getIcon();
                            String icon_selected = home.getIcon_selected();
                            String title_color = home.getTitle_color();
                            String title_color_selected = home.getTitle_color_selected();
                            String icon2 = market.getIcon();
                            String icon_selected2 = market.getIcon_selected();
                            String title_color2 = market.getTitle_color();
                            String title_color_selected2 = market.getTitle_color_selected();
                            Drawable drawable3 = drawable2;
                            String icon3 = trade.getIcon();
                            String icon_selected3 = trade.getIcon_selected();
                            String str = background;
                            String title_color3 = trade.getTitle_color();
                            String title_color_selected3 = trade.getTitle_color_selected();
                            String str2 = title_color3;
                            String icon4 = contract.getIcon();
                            String icon_selected4 = contract.getIcon_selected();
                            String title_color4 = contract.getTitle_color();
                            String title_color_selected4 = contract.getTitle_color_selected();
                            String str3 = title_color4;
                            String icon5 = balance.getIcon();
                            String icon_selected5 = balance.getIcon_selected();
                            String title_color5 = balance.getTitle_color();
                            String title_color_selected5 = balance.getTitle_color_selected();
                            String str4 = title_color5;
                            String icon6 = account.getIcon();
                            String icon_selected6 = account.getIcon_selected();
                            String title_color6 = account.getTitle_color();
                            String title_color_selected6 = account.getTitle_color_selected();
                            String rocket_icon = rocket.getRocket_icon();
                            String rocket_bg = rocket.getRocket_bg();
                            String str5 = rocket_icon;
                            Drawable b11 = com.huobi.main.helper.a.c().b(R.drawable.tab_bg_home, icon_selected, icon);
                            ColorStateList a11 = com.huobi.main.helper.a.c().a(colorStateList2, title_color, title_color_selected);
                            Drawable b12 = com.huobi.main.helper.a.c().b(R.drawable.tab_bg_market, icon_selected2, icon2);
                            ColorStateList a12 = com.huobi.main.helper.a.c().a(colorStateList2, title_color2, title_color_selected2);
                            Drawable b13 = com.huobi.main.helper.a.c().b(R.drawable.tab_bg_coin2coin, icon_selected3, icon3);
                            ColorStateList a13 = com.huobi.main.helper.a.c().a(colorStateList2, str2, title_color_selected3);
                            Drawable b14 = com.huobi.main.helper.a.c().b(R.drawable.tab_bg_contract, icon_selected4, icon4);
                            ColorStateList a14 = com.huobi.main.helper.a.c().a(colorStateList2, str3, title_color_selected4);
                            Drawable b15 = com.huobi.main.helper.a.c().b(R.drawable.tab_bg_balance, icon_selected5, icon5);
                            ColorStateList a15 = com.huobi.main.helper.a.c().a(colorStateList2, str4, title_color_selected5);
                            Drawable b16 = com.huobi.main.helper.a.c().b(R.drawable.tab_bg_zhanghu, icon_selected6, icon6);
                            ColorStateList a16 = com.huobi.main.helper.a.c().a(colorStateList2, title_color6, title_color_selected6);
                            Drawable b17 = com.huobi.main.helper.a.c().b(R.drawable.tab_bg_feed_top_icon, str5, icon);
                            ColorStateList colorStateList3 = a16;
                            Drawable b18 = com.huobi.main.helper.a.c().b(R.drawable.tab_bg_feed_top_bg, rocket_bg, icon);
                            if (b17 == null) {
                                b17 = getResources().getDrawable(R.drawable.tab_bg_feed_top_icon);
                            }
                            if (b18 == null) {
                                b18 = getResources().getDrawable(R.drawable.tab_bg_feed_top_bg);
                            }
                            if (!TextUtils.isEmpty(str)) {
                                huobiMainActivity = this;
                                drawable = b16;
                                colorStateList = a15;
                                huobiMainActivity.f77900d.setBackground(com.huobi.main.helper.a.c().e(getResources(), str));
                            } else {
                                huobiMainActivity = this;
                                colorStateList = a15;
                                drawable = b16;
                                huobiMainActivity.f77900d.setBackground(drawable3);
                            }
                            huobiMainActivity.f77902f.setButtonDrawable(b11);
                            huobiMainActivity.f77902f.setTag(Integer.valueOf(R.drawable.tab_bg_home));
                            huobiMainActivity.f77905i.setTextColor(a11);
                            huobiMainActivity.f77904h.setButtonDrawable(b17);
                            huobiMainActivity.f77904h.setTag(Integer.valueOf(R.drawable.tab_bg_feed_top_icon));
                            huobiMainActivity.f77903g.setButtonDrawable(b18);
                            huobiMainActivity.f77903g.setTag(Integer.valueOf(R.drawable.tab_bg_feed_top_bg));
                            huobiMainActivity.f77906j.setButtonDrawable(b12);
                            huobiMainActivity.f77907k.setTextColor(a12);
                            huobiMainActivity.f77908l.setButtonDrawable(b13);
                            huobiMainActivity.f77909m.setTextColor(a13);
                            huobiMainActivity.f77910n.setButtonDrawable(b14);
                            huobiMainActivity.f77911o.setTextColor(a14);
                            huobiMainActivity.f77912p.setButtonDrawable(b15);
                            huobiMainActivity.f77913q.setTextColor(colorStateList);
                            huobiMainActivity.f77914r.setButtonDrawable(drawable);
                            huobiMainActivity.f77915s.setTextColor(colorStateList3);
                            huobiMainActivity.K = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (y11 && !this.J) {
                    ColorStateList colorStateList4 = ContextCompat.getColorStateList(this, R.color.color_main_tab_new_year);
                    this.f77900d.setBackgroundResource(R.drawable.main_bottom_new_year);
                    this.f77901e.setVisibility(0);
                    this.f77902f.setButtonDrawable(R.drawable.tab_bg_home_new_year);
                    this.f77902f.setTag(Integer.valueOf(R.drawable.tab_bg_home_new_year));
                    this.f77905i.setTextColor(colorStateList4);
                    this.f77906j.setButtonDrawable(R.drawable.tab_bg_market_new_year);
                    this.f77907k.setTextColor(colorStateList4);
                    this.f77908l.setButtonDrawable(R.drawable.tab_bg_coin2coin_new_year);
                    this.f77909m.setTextColor(colorStateList4);
                    this.f77910n.setButtonDrawable(R.drawable.tab_bg_contract_new_year);
                    this.f77911o.setTextColor(colorStateList4);
                    this.f77912p.setButtonDrawable(R.drawable.tab_bg_balance_new_year);
                    this.f77913q.setTextColor(colorStateList4);
                    this.f77914r.setButtonDrawable(R.drawable.tab_bg_zhanghu_new_year);
                    this.f77915s.setTextColor(colorStateList4);
                    this.f77920x.setBackground(ContextCompat.getDrawable(this, R.color.color_main_tab_new_year_divider));
                    i6.d.b("new year true");
                } else if (!y11 && this.J) {
                    ColorStateList colorStateList5 = ContextCompat.getColorStateList(this, R.color.color_grey_orange);
                    this.f77900d.setBackground(ContextCompat.getDrawable(this, R.color.baseColorTabbarNavigation));
                    this.f77902f.setButtonDrawable(R.drawable.tab_bg_home);
                    this.f77902f.setTag(Integer.valueOf(R.drawable.tab_bg_home));
                    this.f77905i.setTextColor(colorStateList5);
                    this.f77906j.setButtonDrawable(R.drawable.tab_bg_market);
                    this.f77907k.setTextColor(colorStateList5);
                    this.f77908l.setButtonDrawable(R.drawable.tab_bg_coin2coin);
                    this.f77909m.setTextColor(colorStateList5);
                    this.f77910n.setButtonDrawable(R.drawable.tab_bg_contract);
                    this.f77911o.setTextColor(colorStateList5);
                    this.f77912p.setButtonDrawable(R.drawable.tab_bg_balance);
                    this.f77913q.setTextColor(colorStateList5);
                    this.f77914r.setButtonDrawable(R.drawable.tab_bg_zhanghu);
                    this.f77915s.setTextColor(colorStateList5);
                    this.f77920x.setBackground(ContextCompat.getDrawable(this, R.color.baseColorPrimarySeparator));
                    i6.d.b("new year false");
                }
                this.J = gj.d.n().y();
                s4();
                return;
            }
            return;
        }
        return;
        throw th2;
    }

    public void recreate() {
        super.recreate();
        i6.d.e("HuobiMainActivity", "recreate");
        k0.H(TradeType.PRO);
        q.b().f((String) null, -1);
    }

    public final boolean ri() {
        boolean l11 = SP.l("activated", false);
        if (!l11) {
            SP.y("activated", true);
        }
        return l11;
    }

    public void s4() {
        String d11 = com.huobi.main.helper.f.c().d();
        if (TextUtils.isEmpty(d11) || !d11.startsWith("http")) {
            this.f77916t.setVisibility(4);
            this.f77914r.setVisibility(0);
            return;
        }
        this.f77916t.g(d11, true);
        li();
        this.f77916t.setVisibility(0);
        this.f77914r.setVisibility(4);
    }

    public void setPossiblyResize() {
    }

    public boolean t9() {
        return this.f77918v.getVisibility() == 0;
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void vg(String str) {
        if (this.D != R.id.main_balance_tab) {
            TextView textView = this.G;
            if (textView == null) {
                TextView textView2 = new TextView(getBaseContext());
                this.G = textView2;
                textView2.setTextSize(0, getResources().getDimension(R.dimen.dimen_9));
                this.G.setPadding(getResources().getDimensionPixelSize(R.dimen.dimen_4), 0, getResources().getDimensionPixelSize(R.dimen.dimen_4), 0);
                this.G.setText(str);
                this.G.setTextColor(getResources().getColor(R.color.white));
                this.G.setBackgroundResource(R.drawable.shape_message_count);
                this.G.setHeight((int) getResources().getDimension(R.dimen.dimen_14));
                this.G.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.dimen_32);
                if (HomeHelper.j()) {
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = (int) getResources().getDimension(R.dimen.dimen_3);
                } else {
                    int g11 = i6.n.g(getBaseContext());
                    layoutParams.leftMargin = ((g11 * 4) / 6) + (g11 / 12) + ((int) getResources().getDimension(R.dimen.dimen_3));
                }
                this.f77899c.addView(this.G, layoutParams);
            } else {
                textView.setText(str);
                this.G.setVisibility(0);
            }
            k6(false);
        }
    }

    public void x8(int i11) {
        this.f77917u.setVisibility(i11);
    }

    public void zf(String str, boolean z11, String str2, String str3) {
        int i11;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            boolean equals = "upgrade".equals(str);
            int i12 = R.string.string_btn_cancel;
            if (equals) {
                i11 = R.string.app_upgrade_ok;
                i12 = R.string.app_upgrade_cancel;
            } else {
                i11 = "action".equals(str) ? R.string.string_notify_action_ok : R.string.string_btn_ok;
            }
            DialogUtils.c0(this, str2, str3, getString(i12), getString(i11), new fo.n(this, z11, str), new fo.m(this, str));
        }
    }
}
