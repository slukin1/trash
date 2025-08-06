package com.adjust.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.adjust.sdk.SystemLifecycle;
import com.adjust.sdk.network.ActivityPackageSender;
import com.adjust.sdk.network.UtilNetworking;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.adjust.sdk.scheduler.TimerCycle;
import com.adjust.sdk.scheduler.TimerOnce;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

public class ActivityHandler implements IActivityHandler, SystemLifecycle.SystemLifecycleCallback {
    private static final String ACTIVITY_STATE_NAME = "Activity state";
    private static final String ATTRIBUTION_NAME = "Attribution";
    private static long BACKGROUND_TIMER_INTERVAL = 0;
    private static final String BACKGROUND_TIMER_NAME = "Background timer";
    private static final String DELAY_START_TIMER_NAME = "Delay Start timer";
    private static long FOREGROUND_TIMER_INTERVAL = 0;
    private static final String FOREGROUND_TIMER_NAME = "Foreground timer";
    private static long FOREGROUND_TIMER_START = 0;
    private static final String GLOBAL_CALLBACK_PARAMETERS_NAME = "Global Callback parameters";
    private static final String GLOBAL_PARAMETERS_NAME = "Global parameters";
    private static final String GLOBAL_PARTNER_PARAMETERS_NAME = "Global Partner parameters";
    private static long SESSION_INTERVAL = 0;
    private static long SUBSESSION_INTERVAL = 0;
    private static final String TIME_TRAVEL = "Time travel!";
    /* access modifiers changed from: private */
    public ActivityState activityState;
    /* access modifiers changed from: private */
    public AdjustConfig adjustConfig;
    /* access modifiers changed from: private */
    public AdjustAttribution attribution;
    private IAttributionHandler attributionHandler;
    private TimerOnce backgroundTimer;
    private String basePath;
    private ArrayList<OnAdidReadListener> cachedAdidReadCallbacks = new ArrayList<>();
    private ArrayList<OnAttributionReadListener> cachedAttributionReadCallbacks = new ArrayList<>();
    private OnDeeplinkResolvedListener cachedDeeplinkResolutionCallback;
    private DeviceInfo deviceInfo;
    private ThreadExecutor executor;
    private TimerCycle foregroundTimer;
    private String gdprPath;
    private GlobalParameters globalParameters;
    private InstallReferrer installReferrer;
    /* access modifiers changed from: private */
    public InternalState internalState;
    /* access modifiers changed from: private */
    public ILogger logger;
    private IPackageHandler packageHandler;
    private IPurchaseVerificationHandler purchaseVerificationHandler;
    private ISdkClickHandler sdkClickHandler;
    private String subscriptionPath;
    private SystemLifecycle systemLifecycle;

    public class InternalState {
        public boolean enabled;
        public boolean firstLaunch;
        public boolean firstSdkStart;
        public Boolean foregroundOrElseBackground;
        public boolean offline;
        public boolean preinstallHasBeenRead;
        public boolean sessionResponseProcessed;

        public InternalState() {
        }

        public boolean hasFirstSdkStartNotOcurred() {
            return !this.firstSdkStart;
        }

        public boolean hasFirstSdkStartOcurred() {
            return this.firstSdkStart;
        }

        public boolean hasPreinstallBeenRead() {
            return this.preinstallHasBeenRead;
        }

        public boolean hasSessionResponseNotBeenProcessed() {
            return !this.sessionResponseProcessed;
        }

        public boolean isDisabled() {
            return !this.enabled;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public boolean isFirstLaunch() {
            return this.firstLaunch;
        }

        public boolean isInBackground() {
            Boolean bool = this.foregroundOrElseBackground;
            return bool != null && !bool.booleanValue();
        }

        public boolean isInForeground() {
            Boolean bool = this.foregroundOrElseBackground;
            return bool != null && bool.booleanValue();
        }

        public boolean isNotFirstLaunch() {
            return !this.firstLaunch;
        }

        public boolean isOffline() {
            return this.offline;
        }

        public boolean isOnline() {
            return !this.offline;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            ActivityHandler.this.sendReftagReferrerI();
        }
    }

    public class a0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnAttributionReadListener f13779a;

        public a0(OnAttributionReadListener onAttributionReadListener) {
            this.f13779a = onAttributionReadListener;
        }

        public final void run() {
            this.f13779a.onAttributionRead(ActivityHandler.this.attribution);
        }
    }

    public class a1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f13781a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f13782b;

        public a1(Uri uri, long j11) {
            this.f13781a = uri;
            this.f13782b = j11;
        }

        public final void run() {
            ActivityHandler.this.processDeeplinkI(this.f13781a, this.f13782b);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            ActivityHandler.this.sendPreinstallReferrerI();
        }
    }

    public class b0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdjustPlayStorePurchase f13785a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OnPurchaseVerificationFinishedListener f13786b;

        public b0(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
            this.f13785a = adjustPlayStorePurchase;
            this.f13786b = onPurchaseVerificationFinishedListener;
        }

        public final void run() {
            ActivityHandler.this.verifyPlayStorePurchaseI(this.f13785a, this.f13786b);
        }
    }

    public class b1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f13788a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13789b;

        public b1(ArrayList arrayList, String str) {
            this.f13788a = arrayList;
            this.f13789b = str;
        }

        public final void run() {
            Iterator it2 = this.f13788a.iterator();
            while (it2.hasNext()) {
                OnAdidReadListener onAdidReadListener = (OnAdidReadListener) it2.next();
                if (onAdidReadListener != null) {
                    onAdidReadListener.onAdidRead(this.f13789b);
                }
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReferrerDetails f13790a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13791b;

        public c(ReferrerDetails referrerDetails, String str) {
            this.f13790a = referrerDetails;
            this.f13791b = str;
        }

        public final void run() {
            ActivityHandler.this.sendInstallReferrerI(this.f13790a, this.f13791b);
        }
    }

    public class c0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdjustEvent f13793a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OnPurchaseVerificationFinishedListener f13794b;

        public c0(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
            this.f13793a = adjustEvent;
            this.f13794b = onPurchaseVerificationFinishedListener;
        }

        public final void run() {
            ActivityHandler.this.verifyAndTrackPlayStorePurchaseI(this.f13793a, this.f13794b);
        }
    }

    public class c1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f13796a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdjustAttribution f13797b;

        public c1(ArrayList arrayList, AdjustAttribution adjustAttribution) {
            this.f13796a = arrayList;
            this.f13797b = adjustAttribution;
        }

        public final void run() {
            Iterator it2 = this.f13796a.iterator();
            while (it2.hasNext()) {
                OnAttributionReadListener onAttributionReadListener = (OnAttributionReadListener) it2.next();
                if (onAttributionReadListener != null) {
                    onAttributionReadListener.onAttributionRead(this.f13797b);
                }
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EventResponseData f13798a;

        public d(EventResponseData eventResponseData) {
            this.f13798a = eventResponseData;
        }

        public final void run() {
            ActivityHandler.this.launchEventResponseTasksI(this.f13798a);
        }
    }

    public class d0 implements IRunActivityHandler {
        public d0() {
        }

        public final void run(ActivityHandler activityHandler) {
            activityHandler.setEnabledI(ActivityHandler.this.adjustConfig.startEnabled.booleanValue());
        }
    }

    public class d1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f13801a;

        public d1(boolean z11) {
            this.f13801a = z11;
        }

        public final void run() {
            ActivityHandler.this.setAskingAttributionI(this.f13801a);
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SdkClickResponseData f13803a;

        public e(SdkClickResponseData sdkClickResponseData) {
            this.f13803a = sdkClickResponseData;
        }

        public final void run() {
            ActivityHandler.this.launchSdkClickResponseTasksI(this.f13803a);
        }
    }

    public class e0 implements Runnable {
        public e0() {
        }

        public final void run() {
            ActivityHandler.this.foregroundTimerFired();
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f13806a;

        public f(SessionResponseData sessionResponseData) {
            this.f13806a = sessionResponseData;
        }

        public final void run() {
            ActivityHandler.this.launchSessionResponseTasksI(this.f13806a);
        }
    }

    public class f0 implements Runnable {
        public f0() {
        }

        public final void run() {
            ActivityHandler.this.backgroundTimerFired();
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AttributionResponseData f13809a;

        public g(AttributionResponseData attributionResponseData) {
            this.f13809a = attributionResponseData;
        }

        public final void run() {
            ActivityHandler.this.launchAttributionResponseTasksI(this.f13809a);
        }
    }

    public class g0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f13811a;

        public g0(boolean z11) {
            this.f13811a = z11;
        }

        public final void run() {
            ActivityHandler.this.setOfflineModeI(this.f13811a);
        }
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PurchaseVerificationResponseData f13813a;

        public h(PurchaseVerificationResponseData purchaseVerificationResponseData) {
            this.f13813a = purchaseVerificationResponseData;
        }

        public final void run() {
            ActivityHandler.this.launchPurchaseVerificationResponseTasksI(this.f13813a);
        }
    }

    public class h0 implements InstallReferrerReadListener {
        public h0() {
        }

        public final void onFail(String str) {
            ActivityHandler.this.logger.debug(str, new Object[0]);
        }

        public final void onInstallReferrerRead(ReferrerDetails referrerDetails, String str) {
            ActivityHandler.this.sendInstallReferrer(referrerDetails, str);
        }
    }

    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13816a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13817b;

        public i(String str, String str2) {
            this.f13816a = str;
            this.f13817b = str2;
        }

        public final void run() {
            ActivityHandler.this.addGlobalCallbackParameterI(this.f13816a, this.f13817b);
        }
    }

    public class i0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f13819a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdjustAttribution f13820b;

        public i0(ArrayList arrayList, AdjustAttribution adjustAttribution) {
            this.f13819a = arrayList;
            this.f13820b = adjustAttribution;
        }

        public final void run() {
            Iterator it2 = this.f13819a.iterator();
            while (it2.hasNext()) {
                OnAttributionReadListener onAttributionReadListener = (OnAttributionReadListener) it2.next();
                if (onAttributionReadListener != null) {
                    onAttributionReadListener.onAttributionRead(this.f13820b);
                }
            }
        }
    }

    public class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13821a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13822b;

        public j(String str, String str2) {
            this.f13821a = str;
            this.f13822b = str2;
        }

        public final void run() {
            ActivityHandler.this.addGlobalPartnerParameterI(this.f13821a, this.f13822b);
        }
    }

    public class j0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f13824a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13825b;

        public j0(ArrayList arrayList, String str) {
            this.f13824a = arrayList;
            this.f13825b = str;
        }

        public final void run() {
            Iterator it2 = this.f13824a.iterator();
            while (it2.hasNext()) {
                OnAdidReadListener onAdidReadListener = (OnAdidReadListener) it2.next();
                if (onAdidReadListener != null) {
                    onAdidReadListener.onAdidRead(this.f13825b);
                }
            }
        }
    }

    public class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdjustEvent f13826a;

        public k(AdjustEvent adjustEvent) {
            this.f13826a = adjustEvent;
        }

        public final void run() {
            if (ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred()) {
                ActivityHandler.this.logger.warn("Event tracked before first activity resumed.\nIf it was triggered in the Application class, it might timestamp or even send an install long before the user opens the app.\nPlease check https://github.com/adjust/android_sdk#can-i-trigger-an-event-at-application-launch for more information.", new Object[0]);
                ActivityHandler.this.startI();
            }
            ActivityHandler.this.trackEventI(this.f13826a);
        }
    }

    public class k0 implements Runnable {
        public k0() {
        }

        public final void run() {
            ReferrerDetails metaReferrer = Reflection.getMetaReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.adjustConfig.fbAppId, ActivityHandler.this.logger);
            if (metaReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(metaReferrer, Constants.REFERRER_API_META);
            }
        }
    }

    public class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13829a;

        public l(String str) {
            this.f13829a = str;
        }

        public final void run() {
            ActivityHandler.this.removeGlobalCallbackParameterI(this.f13829a);
        }
    }

    public class l0 implements Runnable {
        public l0() {
        }

        public final void run() {
            ReferrerDetails huaweiAdsReferrer = Reflection.getHuaweiAdsReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (huaweiAdsReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(huaweiAdsReferrer, Constants.REFERRER_API_HUAWEI_ADS);
            }
        }
    }

    public class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13832a;

        public m(String str) {
            this.f13832a = str;
        }

        public final void run() {
            ActivityHandler.this.removeGlobalPartnerParameterI(this.f13832a);
        }
    }

    public class m0 implements Runnable {
        public m0() {
        }

        public final void run() {
            ReferrerDetails huaweiAppGalleryReferrer = Reflection.getHuaweiAppGalleryReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (huaweiAppGalleryReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(huaweiAppGalleryReferrer, Constants.REFERRER_API_HUAWEI_APP_GALLERY);
            }
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public final void run() {
            ActivityHandler.this.removeGlobalCallbackParametersI();
        }
    }

    public class n0 implements Runnable {
        public n0() {
        }

        public final void run() {
            ReferrerDetails samsungReferrer = Reflection.getSamsungReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (samsungReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(samsungReferrer, Constants.REFERRER_API_SAMSUNG);
            }
        }
    }

    public class o implements Runnable {
        public o() {
        }

        public final void run() {
            ActivityHandler.this.removeGlobalPartnerParametersI();
        }
    }

    public class o0 implements Runnable {
        public o0() {
        }

        public final void run() {
            ReferrerDetails xiaomiReferrer = Reflection.getXiaomiReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (xiaomiReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(xiaomiReferrer, "xiaomi");
            }
        }
    }

    public class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f13839a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13840b;

        public p(boolean z11, String str) {
            this.f13839a = z11;
            this.f13840b = str;
        }

        public final void run() {
            if (!this.f13839a) {
                SharedPreferencesManager.getDefaultInstance(ActivityHandler.this.getContext()).savePushToken(this.f13840b);
            }
            if (!ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred()) {
                ActivityHandler.this.setPushTokenI(this.f13840b);
            }
        }
    }

    public class p0 implements Runnable {
        public p0() {
        }

        public final void run() {
            ReferrerDetails vivoReferrer = Reflection.getVivoReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (vivoReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(vivoReferrer, "vivo");
            }
        }
    }

    public class q implements Runnable {
        public q() {
        }

        public final void run() {
            ActivityHandler.this.gdprForgetMeI();
        }
    }

    public class q0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EventResponseData f13844a;

        public q0(EventResponseData eventResponseData) {
            this.f13844a = eventResponseData;
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null && ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener != null) {
                ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener.onEventTrackingSucceeded(this.f13844a.getSuccessResponseData());
            }
        }
    }

    public class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdjustThirdPartySharing f13846a;

        public r(AdjustThirdPartySharing adjustThirdPartySharing) {
            this.f13846a = adjustThirdPartySharing;
        }

        public final void run() {
            ActivityHandler.this.trackThirdPartySharingI(this.f13846a);
        }
    }

    public class r0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnIsEnabledListener f13848a;

        public r0(OnIsEnabledListener onIsEnabledListener) {
            this.f13848a = onIsEnabledListener;
        }

        public final void run() {
            this.f13848a.onIsEnabledRead(ActivityHandler.this.isEnabledI());
        }
    }

    public class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f13850a;

        public s(boolean z11) {
            this.f13850a = z11;
        }

        public final void run() {
            ActivityHandler.this.trackMeasurementConsentI(this.f13850a);
        }
    }

    public class s0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EventResponseData f13852a;

        public s0(EventResponseData eventResponseData) {
            this.f13852a = eventResponseData;
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null && ActivityHandler.this.adjustConfig.onEventTrackingFailedListener != null) {
                ActivityHandler.this.adjustConfig.onEventTrackingFailedListener.onEventTrackingFailed(this.f13852a.getFailureResponseData());
            }
        }
    }

    public class t implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdjustAdRevenue f13854a;

        public t(AdjustAdRevenue adjustAdRevenue) {
            this.f13854a = adjustAdRevenue;
        }

        public final void run() {
            ActivityHandler.this.trackAdRevenueI(this.f13854a);
        }
    }

    public class t0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnDeeplinkResolvedListener f13856a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SdkClickResponseData f13857b;

        public t0(OnDeeplinkResolvedListener onDeeplinkResolvedListener, SdkClickResponseData sdkClickResponseData) {
            this.f13856a = onDeeplinkResolvedListener;
            this.f13857b = sdkClickResponseData;
        }

        public final void run() {
            this.f13856a.onDeeplinkResolved(this.f13857b.resolvedDeeplink);
        }
    }

    public class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdjustPlayStoreSubscription f13858a;

        public u(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
            this.f13858a = adjustPlayStoreSubscription;
        }

        public final void run() {
            ActivityHandler.this.trackPlayStoreSubscriptionI(this.f13858a);
        }
    }

    public class u0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f13860a;

        public u0(SessionResponseData sessionResponseData) {
            this.f13860a = sessionResponseData;
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null && ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener != null) {
                ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener.onSessionTrackingSucceeded(this.f13860a.getSuccessResponseData());
            }
        }
    }

    public class v implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f13862a;

        public v(boolean z11) {
            this.f13862a = z11;
        }

        public final void run() {
            ActivityHandler.this.setEnabledI(this.f13862a);
        }
    }

    public class v0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f13864a;

        public v0(SessionResponseData sessionResponseData) {
            this.f13864a = sessionResponseData;
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null && ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener != null) {
                ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener.onSessionTrackingFailed(this.f13864a.getFailureResponseData());
            }
        }
    }

    public class w implements Runnable {
        public w() {
        }

        public final void run() {
            ActivityHandler.this.gotOptOutResponseI();
        }
    }

    public class w0 implements Runnable {
        public w0() {
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null && ActivityHandler.this.adjustConfig.onAttributionChangedListener != null) {
                ActivityHandler.this.adjustConfig.onAttributionChangedListener.onAttributionChanged(ActivityHandler.this.attribution);
            }
        }
    }

    public class x implements Runnable {
        public x() {
        }

        public final void run() {
            ActivityHandler.this.foregroundTimerFiredI();
        }
    }

    public class x0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PurchaseVerificationResponseData f13869a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdjustPurchaseVerificationResult f13870b;

        public x0(PurchaseVerificationResponseData purchaseVerificationResponseData, AdjustPurchaseVerificationResult adjustPurchaseVerificationResult) {
            this.f13869a = purchaseVerificationResponseData;
            this.f13870b = adjustPurchaseVerificationResult;
        }

        public final void run() {
            this.f13869a.activityPackage.getPurchaseVerificationCallback().onVerificationFinished(this.f13870b);
        }
    }

    public class y implements Runnable {
        public y() {
        }

        public final void run() {
            ActivityHandler.this.backgroundTimerFiredI();
        }
    }

    public class y0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f13872a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Intent f13873b;

        public y0(Intent intent, Uri uri) {
            this.f13872a = uri;
            this.f13873b = intent;
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null) {
                boolean z11 = true;
                if (ActivityHandler.this.adjustConfig.onDeferredDeeplinkResponseListener != null) {
                    z11 = ActivityHandler.this.adjustConfig.onDeferredDeeplinkResponseListener.launchReceivedDeeplink(this.f13872a);
                }
                if (z11) {
                    ActivityHandler.this.launchDeeplinkMain(this.f13873b, this.f13872a);
                }
            }
        }
    }

    public class z implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnAdidReadListener f13875a;

        public z(OnAdidReadListener onAdidReadListener) {
            this.f13875a = onAdidReadListener;
        }

        public final void run() {
            this.f13875a.onAdidRead(ActivityHandler.this.activityState.adid);
        }
    }

    public class z0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f13877a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f13878b;

        public z0(Uri uri, long j11) {
            this.f13877a = uri;
            this.f13878b = j11;
        }

        public final void run() {
            ActivityHandler.this.processDeeplinkI(this.f13877a, this.f13878b);
        }
    }

    private ActivityHandler(AdjustConfig adjustConfig2) {
        init(adjustConfig2);
        ILogger logger2 = AdjustFactory.getLogger();
        this.logger = logger2;
        logger2.lockLogLevel();
        this.executor = new SingleThreadCachedScheduler("ActivityHandler");
        InternalState internalState2 = new InternalState();
        this.internalState = internalState2;
        Boolean bool = adjustConfig2.startEnabled;
        internalState2.enabled = bool != null ? bool.booleanValue() : true;
        InternalState internalState3 = this.internalState;
        internalState3.offline = adjustConfig2.startOffline;
        internalState3.sessionResponseProcessed = false;
        internalState3.firstSdkStart = false;
        internalState3.preinstallHasBeenRead = false;
        this.executor.submit(new a(this));
    }

    /* access modifiers changed from: private */
    public void backgroundTimerFiredI() {
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
    }

    private void bootstrapLifecycleI() {
        SystemLifecycle singletonInstance = SystemLifecycle.getSingletonInstance();
        this.systemLifecycle = singletonInstance;
        Iterator<String> it2 = singletonInstance.logMessageList.iterator();
        while (it2.hasNext()) {
            this.logger.debug("Lifecycle: %s", it2.next());
        }
        this.systemLifecycle.overwriteCallback(this);
        if (!AdjustFactory.isSystemLifecycleBootstrapIgnored()) {
            this.internalState.foregroundOrElseBackground = this.systemLifecycle.foregroundOrElseBackgroundCached();
            if (this.internalState.isInForeground()) {
                onResumeI();
            }
        }
    }

    private boolean checkActivityStateI(ActivityState activityState2) {
        if (!this.internalState.hasFirstSdkStartNotOcurred()) {
            return true;
        }
        this.logger.error("Sdk did not yet start", new Object[0]);
        return false;
    }

    private boolean checkAdjustAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        if (adjustAdRevenue == null) {
            this.logger.error("Ad revenue object missing", new Object[0]);
            return false;
        } else if (adjustAdRevenue.isValid()) {
            return true;
        } else {
            this.logger.error("Ad revenue object not initialized correctly", new Object[0]);
            return false;
        }
    }

    private void checkAfterNewStartI() {
        checkAfterNewStartI(SharedPreferencesManager.getDefaultInstance(getContext()));
    }

    private void checkAttributionStateI() {
        if (checkActivityStateI(this.activityState)) {
            if (this.internalState.isFirstLaunch() && this.internalState.hasSessionResponseNotBeenProcessed()) {
                return;
            }
            if (this.attribution == null || this.activityState.askingAttribution) {
                this.attributionHandler.getAttribution();
            }
        }
    }

    private boolean checkEventI(AdjustEvent adjustEvent) {
        if (adjustEvent == null) {
            this.logger.error("Event missing", new Object[0]);
            return false;
        } else if (adjustEvent.isValid()) {
            return true;
        } else {
            this.logger.error("Event not initialized correctly", new Object[0]);
            return false;
        }
    }

    private void checkForInstallReferrerInfo(SdkClickResponseData sdkClickResponseData) {
        if (sdkClickResponseData.isInstallReferrer) {
            String str = sdkClickResponseData.referrerApi;
            boolean z11 = true;
            if (str != null && str.equalsIgnoreCase(Constants.REFERRER_API_HUAWEI_ADS)) {
                ActivityState activityState2 = this.activityState;
                activityState2.clickTimeHuawei = sdkClickResponseData.clickTime;
                activityState2.installBeginHuawei = sdkClickResponseData.installBegin;
                activityState2.installReferrerHuawei = sdkClickResponseData.installReferrer;
            } else {
                String str2 = sdkClickResponseData.referrerApi;
                if (str2 != null && str2.equalsIgnoreCase(Constants.REFERRER_API_HUAWEI_APP_GALLERY)) {
                    ActivityState activityState3 = this.activityState;
                    activityState3.clickTimeHuawei = sdkClickResponseData.clickTime;
                    activityState3.installBeginHuawei = sdkClickResponseData.installBegin;
                    activityState3.installReferrerHuaweiAppGallery = sdkClickResponseData.installReferrer;
                } else {
                    String str3 = sdkClickResponseData.referrerApi;
                    if (str3 != null && str3.equalsIgnoreCase(Constants.REFERRER_API_META)) {
                        ActivityState activityState4 = this.activityState;
                        activityState4.clickTimeMeta = sdkClickResponseData.clickTime;
                        activityState4.installReferrerMeta = sdkClickResponseData.installReferrer;
                        activityState4.isClickMeta = sdkClickResponseData.isClick;
                    } else {
                        String str4 = sdkClickResponseData.referrerApi;
                        if (str4 != null && str4.equalsIgnoreCase(Constants.REFERRER_API_SAMSUNG)) {
                            ActivityState activityState5 = this.activityState;
                            activityState5.clickTimeSamsung = sdkClickResponseData.clickTime;
                            activityState5.installBeginSamsung = sdkClickResponseData.installBegin;
                            activityState5.installReferrerSamsung = sdkClickResponseData.installReferrer;
                        } else {
                            String str5 = sdkClickResponseData.referrerApi;
                            if (str5 != null && str5.equalsIgnoreCase("xiaomi")) {
                                ActivityState activityState6 = this.activityState;
                                activityState6.clickTimeXiaomi = sdkClickResponseData.clickTime;
                                activityState6.installBeginXiaomi = sdkClickResponseData.installBegin;
                                activityState6.installReferrerXiaomi = sdkClickResponseData.installReferrer;
                                activityState6.clickTimeServerXiaomi = sdkClickResponseData.clickTimeServer;
                                activityState6.installBeginServerXiaomi = sdkClickResponseData.installBeginServer;
                                activityState6.installVersionXiaomi = sdkClickResponseData.installVersion;
                            } else {
                                String str6 = sdkClickResponseData.referrerApi;
                                if (str6 == null || !str6.equalsIgnoreCase("vivo")) {
                                    z11 = false;
                                }
                                ActivityState activityState7 = this.activityState;
                                if (z11) {
                                    activityState7.clickTimeVivo = sdkClickResponseData.clickTime;
                                    activityState7.installBeginVivo = sdkClickResponseData.installBegin;
                                    activityState7.installReferrerVivo = sdkClickResponseData.installReferrer;
                                    activityState7.installVersionVivo = sdkClickResponseData.installVersion;
                                } else {
                                    activityState7.clickTime = sdkClickResponseData.clickTime;
                                    activityState7.installBegin = sdkClickResponseData.installBegin;
                                    activityState7.installReferrer = sdkClickResponseData.installReferrer;
                                    activityState7.clickTimeServer = sdkClickResponseData.clickTimeServer;
                                    activityState7.installBeginServer = sdkClickResponseData.installBeginServer;
                                    activityState7.installVersion = sdkClickResponseData.installVersion;
                                    activityState7.googlePlayInstant = sdkClickResponseData.googlePlayInstant;
                                }
                            }
                        }
                    }
                }
            }
            writeActivityStateI();
        }
    }

    private void checkForPreinstallI() {
        ActivityState activityState2 = this.activityState;
        if (activityState2 != null && activityState2.enabled && !activityState2.isGdprForgotten) {
            sendPreinstallReferrerI();
            if (this.adjustConfig.isPreinstallTrackingEnabled && !this.internalState.hasPreinstallBeenRead()) {
                String str = this.deviceInfo.packageName;
                if (str == null || str.isEmpty()) {
                    this.logger.debug("Can't read preinstall payload, invalid package name", new Object[0]);
                    return;
                }
                SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
                long preinstallPayloadReadStatus = defaultInstance.getPreinstallPayloadReadStatus();
                if (PreinstallUtil.hasAllLocationsBeenRead(preinstallPayloadReadStatus)) {
                    this.internalState.preinstallHasBeenRead = true;
                    return;
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES, preinstallPayloadReadStatus)) {
                    String payloadFromSystemProperty = PreinstallUtil.getPayloadFromSystemProperty(this.deviceInfo.packageName, this.logger);
                    if (payloadFromSystemProperty == null || payloadFromSystemProperty.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemProperty, Constants.SYSTEM_PROPERTIES);
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_REFLECTION, preinstallPayloadReadStatus)) {
                    String payloadFromSystemPropertyReflection = PreinstallUtil.getPayloadFromSystemPropertyReflection(this.deviceInfo.packageName, this.logger);
                    if (payloadFromSystemPropertyReflection == null || payloadFromSystemPropertyReflection.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_REFLECTION, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyReflection, Constants.SYSTEM_PROPERTIES_REFLECTION);
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_PATH, preinstallPayloadReadStatus)) {
                    String payloadFromSystemPropertyFilePath = PreinstallUtil.getPayloadFromSystemPropertyFilePath(this.deviceInfo.packageName, this.logger);
                    if (payloadFromSystemPropertyFilePath == null || payloadFromSystemPropertyFilePath.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_PATH, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyFilePath, Constants.SYSTEM_PROPERTIES_PATH);
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION, preinstallPayloadReadStatus)) {
                    String payloadFromSystemPropertyFilePathReflection = PreinstallUtil.getPayloadFromSystemPropertyFilePathReflection(this.deviceInfo.packageName, this.logger);
                    if (payloadFromSystemPropertyFilePathReflection == null || payloadFromSystemPropertyFilePathReflection.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyFilePathReflection, Constants.SYSTEM_PROPERTIES_PATH_REFLECTION);
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER, preinstallPayloadReadStatus)) {
                    String payloadFromContentProviderDefault = PreinstallUtil.getPayloadFromContentProviderDefault(this.adjustConfig.context, this.deviceInfo.packageName, this.logger);
                    if (payloadFromContentProviderDefault == null || payloadFromContentProviderDefault.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromContentProviderDefault, Constants.CONTENT_PROVIDER);
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER_INTENT_ACTION, preinstallPayloadReadStatus)) {
                    List<String> payloadsFromContentProviderIntentAction = PreinstallUtil.getPayloadsFromContentProviderIntentAction(this.adjustConfig.context, this.deviceInfo.packageName, this.logger);
                    if (payloadsFromContentProviderIntentAction == null || payloadsFromContentProviderIntentAction.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER_INTENT_ACTION, preinstallPayloadReadStatus);
                    } else {
                        for (String sendPreinstallPayload : payloadsFromContentProviderIntentAction) {
                            this.sdkClickHandler.sendPreinstallPayload(sendPreinstallPayload, Constants.CONTENT_PROVIDER_INTENT_ACTION);
                        }
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER_NO_PERMISSION, preinstallPayloadReadStatus)) {
                    List<String> payloadsFromContentProviderNoPermission = PreinstallUtil.getPayloadsFromContentProviderNoPermission(this.adjustConfig.context, this.deviceInfo.packageName, this.logger);
                    if (payloadsFromContentProviderNoPermission == null || payloadsFromContentProviderNoPermission.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER_NO_PERMISSION, preinstallPayloadReadStatus);
                    } else {
                        for (String sendPreinstallPayload2 : payloadsFromContentProviderNoPermission) {
                            this.sdkClickHandler.sendPreinstallPayload(sendPreinstallPayload2, Constants.CONTENT_PROVIDER_NO_PERMISSION);
                        }
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.FILE_SYSTEM, preinstallPayloadReadStatus)) {
                    String payloadFromFileSystem = PreinstallUtil.getPayloadFromFileSystem(this.deviceInfo.packageName, this.adjustConfig.preinstallFilePath, this.logger);
                    if (payloadFromFileSystem == null || payloadFromFileSystem.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.FILE_SYSTEM, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromFileSystem, Constants.FILE_SYSTEM);
                    }
                }
                defaultInstance.setPreinstallPayloadReadStatus(preinstallPayloadReadStatus);
                this.internalState.preinstallHasBeenRead = true;
            }
        }
    }

    private Intent createDeeplinkIntentI(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        intent.setPackage(this.adjustConfig.context.getPackageName());
        return intent;
    }

    public static boolean deleteActivityState(Context context) {
        return context.deleteFile(Constants.ACTIVITY_STATE_FILENAME);
    }

    public static boolean deleteAttribution(Context context) {
        return context.deleteFile(Constants.ATTRIBUTION_FILENAME);
    }

    public static boolean deleteGlobalCallbackParameters(Context context) {
        return context.deleteFile(Constants.GLOBAL_CALLBACK_PARAMETERS_FILENAME);
    }

    public static boolean deleteGlobalPartnerParameters(Context context) {
        return context.deleteFile(Constants.GLOBAL_PARTNER_PARAMETERS_FILENAME);
    }

    public static void deleteState(Context context) {
        deleteActivityState(context);
        deleteAttribution(context);
        deleteGlobalCallbackParameters(context);
        deleteGlobalPartnerParameters(context);
        SharedPreferencesManager.getDefaultInstance(context).clear();
    }

    private void disableThirdPartySharingForCoppaEnabledI() {
        if (shouldDisableThirdPartySharingWhenCoppaEnabled()) {
            this.activityState.isThirdPartySharingDisabledForCoppa = true;
            writeActivityStateI();
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis()).buildThirdPartySharingPackage(new AdjustThirdPartySharing(Boolean.FALSE)));
            this.packageHandler.sendFirstPackage();
        }
    }

    private void endI() {
        if (!toSendI()) {
            pauseSendingI();
        }
        if (updateActivityStateI(System.currentTimeMillis())) {
            writeActivityStateI();
        }
    }

    /* access modifiers changed from: private */
    public void foregroundTimerFiredI() {
        if (!isEnabledI()) {
            stopForegroundTimerI();
            return;
        }
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
        if (updateActivityStateI(System.currentTimeMillis())) {
            writeActivityStateI();
        }
    }

    /* access modifiers changed from: private */
    public void gdprForgetMeI() {
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState2 = this.activityState;
            if (!activityState2.isGdprForgotten) {
                activityState2.isGdprForgotten = true;
                writeActivityStateI();
                PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
                packageBuilder.internalState = this.internalState;
                this.packageHandler.addPackage(packageBuilder.buildGdprPackage());
                SharedPreferencesManager.getDefaultInstance(getContext()).removeGdprForgetMe();
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    public static ActivityHandler getInstance(AdjustConfig adjustConfig2) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (adjustConfig2 == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
            return null;
        } else if (!adjustConfig2.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
            return null;
        } else {
            if (adjustConfig2.processName != null) {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) adjustConfig2.context.getSystemService("activity");
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it2.next();
                        if (next.pid == myPid) {
                            if (!next.processName.equalsIgnoreCase(adjustConfig2.processName)) {
                                AdjustFactory.getLogger().info("Skipping initialization in background process (%s)", next.processName);
                                return null;
                            }
                        }
                    }
                } else {
                    return null;
                }
            }
            return new ActivityHandler(adjustConfig2);
        }
    }

    /* access modifiers changed from: private */
    public void gotOptOutResponseI() {
        this.activityState.isGdprForgotten = true;
        writeActivityStateI();
        this.packageHandler.flush();
        setEnabledI(false);
    }

    private void handleAdidCallbackI() {
        ActivityState activityState2;
        this.cachedAdidReadCallbacks.addAll(this.adjustConfig.cachedAdidReadCallbacks);
        this.adjustConfig.cachedAdidReadCallbacks.clear();
        if (!this.cachedAdidReadCallbacks.isEmpty() && (activityState2 = this.activityState) != null && activityState2.adid != null) {
            ArrayList arrayList = new ArrayList(this.cachedAdidReadCallbacks);
            String str = this.activityState.adid;
            this.cachedAdidReadCallbacks.clear();
            new Handler(this.adjustConfig.context.getMainLooper()).post(new j0(arrayList, str));
        }
    }

    private void handleAttributionCallbackI() {
        this.cachedAttributionReadCallbacks.addAll(this.adjustConfig.cachedAttributionReadCallbacks);
        this.adjustConfig.cachedAttributionReadCallbacks.clear();
        if (!this.cachedAttributionReadCallbacks.isEmpty() && this.attribution != null) {
            ArrayList arrayList = new ArrayList(this.cachedAttributionReadCallbacks);
            AdjustAttribution adjustAttribution = this.attribution;
            this.cachedAttributionReadCallbacks.clear();
            new Handler(this.adjustConfig.context.getMainLooper()).post(new i0(arrayList, adjustAttribution));
        }
    }

    private boolean hasChangedStateI(boolean z11, boolean z12, String str, String str2) {
        if (z11 != z12) {
            return true;
        }
        if (z11) {
            this.logger.debug(str, new Object[0]);
        } else {
            this.logger.debug(str2, new Object[0]);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: initI */
    public void lambda$new$1() {
        String pushToken;
        SESSION_INTERVAL = AdjustFactory.getSessionInterval();
        SUBSESSION_INTERVAL = AdjustFactory.getSubsessionInterval();
        FOREGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        FOREGROUND_TIMER_START = AdjustFactory.getTimerStart();
        BACKGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        readAttributionI(this.adjustConfig.context);
        readActivityStateI(this.adjustConfig.context);
        this.globalParameters = new GlobalParameters();
        readGlobalCallbackParametersI(this.adjustConfig.context);
        readGlobalPartnerParametersI(this.adjustConfig.context);
        ActivityState activityState2 = this.activityState;
        if (activityState2 != null) {
            activityState2.setEventDeduplicationIdsMaxSize(this.adjustConfig.getEventDeduplicationIdsMaxSize());
        }
        AdjustConfig adjustConfig2 = this.adjustConfig;
        if (adjustConfig2.startEnabled != null) {
            adjustConfig2.preLaunchActions.preLaunchActionsArray.add(new d0());
        }
        if (this.internalState.hasFirstSdkStartOcurred()) {
            InternalState internalState2 = this.internalState;
            internalState2.enabled = this.activityState.enabled;
            internalState2.firstLaunch = false;
        } else {
            this.internalState.firstLaunch = true;
        }
        readConfigFile(this.adjustConfig.context);
        DeviceInfo deviceInfo2 = new DeviceInfo(this.adjustConfig);
        this.deviceInfo = deviceInfo2;
        deviceInfo2.reloadPlayIds(this.adjustConfig);
        if (this.deviceInfo.playAdId == null) {
            if (!Util.canReadPlayIds(this.adjustConfig)) {
                this.logger.info("Cannot read Google Play Services Advertising ID with COPPA or play store kids app enabled", new Object[0]);
            } else {
                this.logger.warn("Unable to get Google Play Services Advertising ID at start time", new Object[0]);
            }
            if (this.deviceInfo.androidId == null) {
                if (!Util.canReadNonPlayIds(this.adjustConfig)) {
                    this.logger.info("Cannot read non Play IDs with COPPA or play store kids app enabled", new Object[0]);
                } else {
                    this.logger.error("Unable to get any Device IDs. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
                }
            }
        } else {
            this.logger.info("Google Play Services Advertising ID read correctly at start time", new Object[0]);
        }
        String str = this.adjustConfig.defaultTracker;
        if (str != null) {
            this.logger.info("Default tracker: '%s'", str);
        }
        String str2 = this.adjustConfig.pushToken;
        if (str2 != null) {
            this.logger.info("Push token: '%s'", str2);
            if (this.internalState.hasFirstSdkStartOcurred()) {
                setPushToken(this.adjustConfig.pushToken, false);
            } else {
                SharedPreferencesManager.getDefaultInstance(getContext()).savePushToken(this.adjustConfig.pushToken);
            }
        } else if (this.internalState.hasFirstSdkStartOcurred() && (pushToken = SharedPreferencesManager.getDefaultInstance(getContext()).getPushToken()) != null) {
            setPushToken(pushToken, true);
        }
        if (this.cachedDeeplinkResolutionCallback == null) {
            this.cachedDeeplinkResolutionCallback = this.adjustConfig.cachedDeeplinkResolutionCallback;
        }
        handleAdidCallbackI();
        handleAttributionCallbackI();
        if (this.internalState.hasFirstSdkStartOcurred() && SharedPreferencesManager.getDefaultInstance(getContext()).getGdprForgetMe()) {
            gdprForgetMe();
        }
        this.foregroundTimer = new TimerCycle(new e0(), FOREGROUND_TIMER_START, FOREGROUND_TIMER_INTERVAL, FOREGROUND_TIMER_NAME);
        if (this.adjustConfig.isSendingInBackgroundEnabled) {
            this.logger.info("Send in background configured", new Object[0]);
            this.backgroundTimer = new TimerOnce(new f0(), BACKGROUND_TIMER_NAME);
        }
        AdjustConfig adjustConfig3 = this.adjustConfig;
        this.packageHandler = AdjustFactory.getPackageHandler(this, this.adjustConfig.context, toSendI(false), new ActivityPackageSender(adjustConfig3.urlStrategyDomains, adjustConfig3.useSubdomains, adjustConfig3.basePath, adjustConfig3.gdprPath, adjustConfig3.subscriptionPath, adjustConfig3.purchaseVerificationPath, this.deviceInfo.clientSdk, adjustConfig3.context));
        AdjustConfig adjustConfig4 = this.adjustConfig;
        this.attributionHandler = AdjustFactory.getAttributionHandler(this, toSendI(false), new ActivityPackageSender(adjustConfig4.urlStrategyDomains, adjustConfig4.useSubdomains, adjustConfig4.basePath, adjustConfig4.gdprPath, adjustConfig4.subscriptionPath, adjustConfig4.purchaseVerificationPath, this.deviceInfo.clientSdk, adjustConfig4.context));
        AdjustConfig adjustConfig5 = this.adjustConfig;
        this.sdkClickHandler = AdjustFactory.getSdkClickHandler(this, toSendI(true), new ActivityPackageSender(adjustConfig5.urlStrategyDomains, adjustConfig5.useSubdomains, adjustConfig5.basePath, adjustConfig5.gdprPath, adjustConfig5.subscriptionPath, adjustConfig5.purchaseVerificationPath, this.deviceInfo.clientSdk, adjustConfig5.context));
        AdjustConfig adjustConfig6 = this.adjustConfig;
        this.purchaseVerificationHandler = AdjustFactory.getPurchaseVerificationHandler(this, toSendI(true), new ActivityPackageSender(adjustConfig6.urlStrategyDomains, adjustConfig6.useSubdomains, adjustConfig6.basePath, adjustConfig6.gdprPath, adjustConfig6.subscriptionPath, adjustConfig6.purchaseVerificationPath, this.deviceInfo.clientSdk, adjustConfig6.context));
        this.installReferrer = new InstallReferrer(this.adjustConfig.context, new h0());
        preLaunchActionsI(this.adjustConfig.preLaunchActions.preLaunchActionsArray);
        sendReftagReferrerI();
        bootstrapLifecycleI();
    }

    /* access modifiers changed from: private */
    public boolean isEnabledI() {
        ActivityState activityState2 = this.activityState;
        return activityState2 != null ? activityState2.enabled : this.internalState.isEnabled();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r2 = r2.installReferrer;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isValidReferrerDetails(com.adjust.sdk.ReferrerDetails r2) {
        /*
            r1 = this;
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r2 = r2.installReferrer
            if (r2 != 0) goto L_0x0009
            return r0
        L_0x0009:
            int r2 = r2.length()
            if (r2 == 0) goto L_0x0010
            r0 = 1
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.ActivityHandler.isValidReferrerDetails(com.adjust.sdk.ReferrerDetails):boolean");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityLifecycle$0(boolean z11) {
        Boolean bool = this.internalState.foregroundOrElseBackground;
        if (bool == null || bool.booleanValue() != z11) {
            this.internalState.foregroundOrElseBackground = Boolean.valueOf(z11);
            if (z11) {
                onResumeI();
            } else {
                onPauseI();
            }
        }
    }

    private void launchAttributionListenerI(Handler handler) {
        if (this.adjustConfig.onAttributionChangedListener != null) {
            handler.post(new w0());
        }
    }

    /* access modifiers changed from: private */
    public void launchAttributionResponseTasksI(AttributionResponseData attributionResponseData) {
        updateAdidI(attributionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(attributionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        prepareDeeplinkI(attributionResponseData.deeplink, handler);
    }

    /* access modifiers changed from: private */
    public void launchDeeplinkMain(Intent intent, Uri uri) {
        if (!(this.adjustConfig.context.getPackageManager().queryIntentActivities(intent, 0).size() > 0)) {
            this.logger.error("Unable to open deferred deeplink (%s)", uri);
            return;
        }
        this.logger.info("Open deferred deeplink (%s)", uri);
        this.adjustConfig.context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void launchEventResponseTasksI(EventResponseData eventResponseData) {
        Runnable s0Var;
        updateAdidI(eventResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        boolean z11 = eventResponseData.success;
        if (z11 && this.adjustConfig.onEventTrackingSucceededListener != null) {
            this.logger.debug("Launching success event tracking listener", new Object[0]);
            s0Var = new q0(eventResponseData);
        } else if (!z11 && this.adjustConfig.onEventTrackingFailedListener != null) {
            this.logger.debug("Launching failed event tracking listener", new Object[0]);
            s0Var = new s0(eventResponseData);
        } else {
            return;
        }
        handler.post(s0Var);
    }

    /* access modifiers changed from: private */
    public void launchPurchaseVerificationResponseTasksI(PurchaseVerificationResponseData purchaseVerificationResponseData) {
        AdjustEvent adjustEvent;
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        JSONObject jSONObject = purchaseVerificationResponseData.jsonResponse;
        handler.post(new x0(purchaseVerificationResponseData, jSONObject == null ? new AdjustPurchaseVerificationResult("not_verified", 101, purchaseVerificationResponseData.message) : new AdjustPurchaseVerificationResult(UtilNetworking.extractJsonString(jSONObject, "verification_status"), UtilNetworking.extractJsonInt(jSONObject, "code"), UtilNetworking.extractJsonString(jSONObject, "message"))));
        ActivityPackage activityPackage = purchaseVerificationResponseData.activityPackage;
        if (activityPackage != null && (adjustEvent = activityPackage.event) != null) {
            trackEventI(adjustEvent);
        }
    }

    /* access modifiers changed from: private */
    public void launchSdkClickResponseTasksI(SdkClickResponseData sdkClickResponseData) {
        updateAdidI(sdkClickResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sdkClickResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        if (!TextUtils.isEmpty(sdkClickResponseData.resolvedDeeplink)) {
            OnDeeplinkResolvedListener onDeeplinkResolvedListener = this.cachedDeeplinkResolutionCallback;
            this.cachedDeeplinkResolutionCallback = null;
            if (onDeeplinkResolvedListener != null) {
                handler.post(new t0(onDeeplinkResolvedListener, sdkClickResponseData));
            }
        }
    }

    private void launchSessionResponseListenerI(SessionResponseData sessionResponseData, Handler handler) {
        Runnable v0Var;
        boolean z11 = sessionResponseData.success;
        if (z11 && this.adjustConfig.onSessionTrackingSucceededListener != null) {
            this.logger.debug("Launching success session tracking listener", new Object[0]);
            v0Var = new u0(sessionResponseData);
        } else if (!z11 && this.adjustConfig.onSessionTrackingFailedListener != null) {
            this.logger.debug("Launching failed session tracking listener", new Object[0]);
            v0Var = new v0(sessionResponseData);
        } else {
            return;
        }
        handler.post(v0Var);
    }

    /* access modifiers changed from: private */
    public void launchSessionResponseTasksI(SessionResponseData sessionResponseData) {
        this.logger.debug("Launching SessionResponse tasks", new Object[0]);
        updateAdidI(sessionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sessionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        if (this.attribution == null && !this.activityState.askingAttribution) {
            this.attributionHandler.getAttribution();
        }
        if (sessionResponseData.success) {
            SharedPreferencesManager.getDefaultInstance(getContext()).setInstallTracked();
        }
        launchSessionResponseListenerI(sessionResponseData, handler);
        this.internalState.sessionResponseProcessed = true;
    }

    private void pauseSendingI() {
        this.attributionHandler.pauseSending();
        this.packageHandler.pauseSending();
        if (!toSendI(true)) {
            this.sdkClickHandler.pauseSending();
            this.purchaseVerificationHandler.pauseSending();
            return;
        }
        this.sdkClickHandler.resumeSending();
        this.purchaseVerificationHandler.resumeSending();
    }

    private boolean pausedI() {
        return pausedI(false);
    }

    private void preLaunchActionsI(List<IRunActivityHandler> list) {
        if (list != null) {
            for (IRunActivityHandler run : list) {
                run.run(this);
            }
        }
    }

    private void prepareDeeplinkI(Uri uri, Handler handler) {
        if (uri != null) {
            this.logger.info("Deferred deeplink received (%s)", uri);
            handler.post(new y0(createDeeplinkIntentI(uri), uri));
        }
    }

    private void processCachedDeeplinkI() {
        if (checkActivityStateI(this.activityState)) {
            SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
            String deeplinkUrl = defaultInstance.getDeeplinkUrl();
            long deeplinkClickTime = defaultInstance.getDeeplinkClickTime();
            if (deeplinkUrl != null && deeplinkClickTime != -1) {
                processDeeplink(Uri.parse(deeplinkUrl), deeplinkClickTime);
                defaultInstance.removeDeeplink();
            }
        }
    }

    private void processCoppaComplianceI() {
        if (!this.adjustConfig.coppaComplianceEnabled) {
            resetThirdPartySharingCoppaActivityStateI();
        } else {
            disableThirdPartySharingForCoppaEnabledI();
        }
    }

    /* access modifiers changed from: private */
    public void processDeeplinkI(Uri uri, long j11) {
        if (isEnabledI()) {
            if (Util.isUrlFilteredOut(uri)) {
                ILogger iLogger = this.logger;
                iLogger.debug("Deeplink (" + uri.toString() + ") processing skipped", new Object[0]);
                return;
            }
            ActivityPackage buildDeeplinkSdkClickPackage = PackageFactory.buildDeeplinkSdkClickPackage(uri, j11, this.activityState, this.adjustConfig, this.deviceInfo, this.globalParameters, this.internalState);
            if (buildDeeplinkSdkClickPackage != null) {
                this.sdkClickHandler.sendSdkClick(buildDeeplinkSdkClickPackage);
            }
        }
    }

    private void processSessionI() {
        if (!this.activityState.isGdprForgotten) {
            long currentTimeMillis = System.currentTimeMillis();
            ActivityState activityState2 = this.activityState;
            long j11 = currentTimeMillis - activityState2.lastActivity;
            if (j11 < 0) {
                this.logger.error(TIME_TRAVEL, new Object[0]);
                this.activityState.lastActivity = currentTimeMillis;
                writeActivityStateI();
            } else if (j11 > SESSION_INTERVAL) {
                trackNewSessionI(currentTimeMillis);
                checkAfterNewStartI();
            } else if (j11 > SUBSESSION_INTERVAL) {
                int i11 = activityState2.subsessionCount + 1;
                activityState2.subsessionCount = i11;
                activityState2.sessionLength += j11;
                activityState2.lastActivity = currentTimeMillis;
                this.logger.verbose("Started subsession %d of session %d", Integer.valueOf(i11), Integer.valueOf(this.activityState.sessionCount));
                writeActivityStateI();
                checkForPreinstallI();
                this.installReferrer.startConnection();
                readInstallReferrerMeta();
                readInstallReferrerHuaweiAds();
                readInstallReferrerHuaweiAppGallery();
                readInstallReferrerSamsung();
                readInstallReferrerXiaomi();
                readInstallReferrerVivo();
            } else {
                this.logger.verbose("Time span since last activity too short for a new subsession", new Object[0]);
            }
        }
    }

    private void readActivityStateI(Context context) {
        try {
            this.activityState = (ActivityState) Util.readObject(context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME, ActivityState.class);
        } catch (Exception e11) {
            this.logger.error("Failed to read %s file (%s)", ACTIVITY_STATE_NAME, e11.getMessage());
            this.activityState = null;
        }
        if (this.activityState != null) {
            this.internalState.firstSdkStart = true;
        }
    }

    private void readAttributionI(Context context) {
        try {
            this.attribution = (AdjustAttribution) Util.readObject(context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME, AdjustAttribution.class);
        } catch (Exception e11) {
            this.logger.error("Failed to read %s file (%s)", ATTRIBUTION_NAME, e11.getMessage());
            this.attribution = null;
        }
    }

    private void readConfigFile(Context context) {
        try {
            InputStream open = context.getAssets().open("adjust_config.properties");
            Properties properties = new Properties();
            properties.load(open);
            this.logger.verbose("adjust_config.properties file read and loaded", new Object[0]);
            String property = properties.getProperty("defaultTracker");
            if (property != null) {
                this.adjustConfig.defaultTracker = property;
            }
        } catch (Exception e11) {
            this.logger.debug("%s file not found in this app", e11.getMessage());
        }
    }

    private void readGlobalCallbackParametersI(Context context) {
        try {
            this.globalParameters.callbackParameters = (Map) Util.readObject(context, Constants.GLOBAL_CALLBACK_PARAMETERS_FILENAME, GLOBAL_CALLBACK_PARAMETERS_NAME, Map.class);
        } catch (Exception e11) {
            this.logger.error("Failed to read %s file (%s)", GLOBAL_CALLBACK_PARAMETERS_NAME, e11.getMessage());
            this.globalParameters.callbackParameters = null;
        }
    }

    private void readGlobalPartnerParametersI(Context context) {
        try {
            this.globalParameters.partnerParameters = (Map) Util.readObject(context, Constants.GLOBAL_PARTNER_PARAMETERS_FILENAME, GLOBAL_PARTNER_PARAMETERS_NAME, Map.class);
        } catch (Exception e11) {
            this.logger.error("Failed to read %s file (%s)", GLOBAL_PARTNER_PARAMETERS_NAME, e11.getMessage());
            this.globalParameters.partnerParameters = null;
        }
    }

    private void readInstallReferrerHuaweiAds() {
        this.executor.submit(new l0());
    }

    private void readInstallReferrerHuaweiAppGallery() {
        this.executor.submit(new m0());
    }

    private void readInstallReferrerMeta() {
        this.executor.submit(new k0());
    }

    private void readInstallReferrerSamsung() {
        this.executor.submit(new n0());
    }

    private void readInstallReferrerVivo() {
        this.executor.submit(new p0());
    }

    private void readInstallReferrerXiaomi() {
        this.executor.submit(new o0());
    }

    private void resetThirdPartySharingCoppaActivityStateI() {
        ActivityState activityState2 = this.activityState;
        if (activityState2 != null && activityState2.isThirdPartySharingDisabledForCoppa) {
            activityState2.isThirdPartySharingDisabledForCoppa = false;
            writeActivityStateI();
        }
    }

    private void resumeSendingI() {
        this.attributionHandler.resumeSending();
        this.packageHandler.resumeSending();
        this.sdkClickHandler.resumeSending();
        this.purchaseVerificationHandler.resumeSending();
    }

    /* access modifiers changed from: private */
    public void sendInstallReferrerI(ReferrerDetails referrerDetails, String str) {
        if (isEnabledI() && isValidReferrerDetails(referrerDetails) && !Util.isEqualReferrerDetails(referrerDetails, str, this.activityState)) {
            this.sdkClickHandler.sendSdkClick(PackageFactory.buildInstallReferrerSdkClickPackage(referrerDetails, str, this.activityState, this.adjustConfig, this.deviceInfo, this.globalParameters, this.internalState));
        }
    }

    /* access modifiers changed from: private */
    public void sendPreinstallReferrerI() {
        String preinstallReferrer;
        if (isEnabledI() && !this.internalState.hasFirstSdkStartNotOcurred() && (preinstallReferrer = SharedPreferencesManager.getDefaultInstance(getContext()).getPreinstallReferrer()) != null && !preinstallReferrer.isEmpty()) {
            this.sdkClickHandler.sendPreinstallPayload(preinstallReferrer, Constants.SYSTEM_INSTALLER_REFERRER);
        }
    }

    /* access modifiers changed from: private */
    public void sendReftagReferrerI() {
        if (isEnabledI() && !this.internalState.hasFirstSdkStartNotOcurred()) {
            this.sdkClickHandler.sendReftagReferrers();
        }
    }

    /* access modifiers changed from: private */
    public void setAskingAttributionI(boolean z11) {
        this.activityState.askingAttribution = z11;
        writeActivityStateI();
    }

    /* access modifiers changed from: private */
    public void setEnabledI(boolean z11) {
        ActivityState activityState2;
        if (hasChangedStateI(isEnabledI(), z11, "Adjust already enabled", "Adjust already disabled")) {
            if (!z11 || (activityState2 = this.activityState) == null || !activityState2.isGdprForgotten) {
                InternalState internalState2 = this.internalState;
                internalState2.enabled = z11;
                if (internalState2.hasFirstSdkStartNotOcurred()) {
                    updateStatusI(!z11, "Handlers will start as paused due to the SDK being disabled", "Handlers will still start as paused", "Handlers will start as active due to the SDK being enabled");
                    return;
                }
                this.activityState.enabled = z11;
                writeActivityStateI();
                if (z11) {
                    SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
                    if (defaultInstance.getGdprForgetMe()) {
                        gdprForgetMeI();
                    } else {
                        processCoppaComplianceI();
                        for (AdjustThirdPartySharing trackThirdPartySharingI : this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray) {
                            trackThirdPartySharingI(trackThirdPartySharingI);
                        }
                        Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
                        if (bool != null) {
                            trackMeasurementConsentI(bool.booleanValue());
                        }
                        this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                        this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
                    }
                    if (!defaultInstance.getInstallTracked()) {
                        this.logger.debug("Detected that install was not tracked at enable time", new Object[0]);
                        trackNewSessionI(System.currentTimeMillis());
                    }
                    checkAfterNewStartI(defaultInstance);
                }
                updateStatusI(!z11, "Pausing handlers due to SDK being disabled", "Handlers remain paused", "Resuming handlers due to SDK being enabled");
                return;
            }
            this.logger.error("Re-enabling SDK not possible for forgotten user", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void setOfflineModeI(boolean z11) {
        String str;
        String str2;
        String str3;
        if (hasChangedStateI(this.internalState.isOffline(), z11, "Adjust already in offline mode", "Adjust already in online mode")) {
            InternalState internalState2 = this.internalState;
            internalState2.offline = z11;
            if (internalState2.hasFirstSdkStartNotOcurred()) {
                str = "Handlers will start paused due to SDK being offline";
                str2 = "Handlers will still start as paused";
                str3 = "Handlers will start as active due to SDK being online";
            } else {
                str = "Pausing handlers to put SDK offline mode";
                str2 = "Handlers remain paused";
                str3 = "Resuming handlers to put SDK in online mode";
            }
            updateStatusI(z11, str, str2, str3);
        }
    }

    /* access modifiers changed from: private */
    public void setPushTokenI(String str) {
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState2 = this.activityState;
            if (!activityState2.isGdprForgotten && str != null && !str.equals(activityState2.pushToken)) {
                this.activityState.pushToken = str;
                writeActivityStateI();
                PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
                packageBuilder.internalState = this.internalState;
                this.packageHandler.addPackage(packageBuilder.buildInfoPackage(Constants.PUSH));
                SharedPreferencesManager.getDefaultInstance(getContext()).removePushToken();
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    private boolean shouldDisableThirdPartySharingWhenCoppaEnabled() {
        if (this.activityState == null || !isEnabledI()) {
            return false;
        }
        ActivityState activityState2 = this.activityState;
        if (activityState2.isGdprForgotten) {
            return false;
        }
        return !activityState2.isThirdPartySharingDisabledForCoppa;
    }

    private boolean shouldProcessEventI(String str) {
        if (str != null && !str.isEmpty()) {
            if (this.activityState.eventDeduplicationIdExists(str)) {
                this.logger.info("Skipping duplicate event with deduplication ID '%s'", str);
                return false;
            }
            this.activityState.addDeduplicationId(str);
            this.logger.verbose("Added deduplication ID '%s'", str);
        }
        return true;
    }

    private void startBackgroundTimerI() {
        if (this.backgroundTimer != null && toSendI() && this.backgroundTimer.getFireIn() <= 0) {
            this.backgroundTimer.startIn(BACKGROUND_TIMER_INTERVAL);
        }
    }

    private void startFirstSessionI() {
        ActivityState activityState2 = new ActivityState();
        this.activityState = activityState2;
        this.internalState.firstSdkStart = true;
        activityState2.setEventDeduplicationIdsMaxSize(this.adjustConfig.getEventDeduplicationIdsMaxSize());
        updateHandlersStatusAndSendI();
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
        this.activityState.pushToken = defaultInstance.getPushToken();
        if (this.internalState.isEnabled()) {
            if (defaultInstance.getGdprForgetMe()) {
                gdprForgetMeI();
            } else {
                processCoppaComplianceI();
                for (AdjustThirdPartySharing trackThirdPartySharingI : this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray) {
                    trackThirdPartySharingI(trackThirdPartySharingI);
                }
                Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
                if (bool != null) {
                    trackMeasurementConsentI(bool.booleanValue());
                }
                this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
                this.activityState.sessionCount = 1;
                transferSessionPackageI(currentTimeMillis);
                checkAfterNewStartI(defaultInstance);
            }
        }
        this.activityState.resetSessionAttributes(currentTimeMillis);
        this.activityState.enabled = this.internalState.isEnabled();
        writeActivityStateI();
        defaultInstance.removePushToken();
        defaultInstance.removeGdprForgetMe();
        processCachedDeeplinkI();
    }

    private void startForegroundTimerI() {
        if (isEnabledI()) {
            this.foregroundTimer.start();
        }
    }

    /* access modifiers changed from: private */
    public void startI() {
        if (this.internalState.hasFirstSdkStartNotOcurred()) {
            AdjustSigner.onResume(this.adjustConfig.logger);
            startFirstSessionI();
            return;
        }
        for (AdjustThirdPartySharing trackThirdPartySharingI : this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray) {
            trackThirdPartySharingI(trackThirdPartySharingI);
        }
        Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
        if (bool != null) {
            trackMeasurementConsentI(bool.booleanValue());
        }
        this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        adjustConfig2.preLaunchActions.lastMeasurementConsentTracked = null;
        if (this.activityState.enabled) {
            AdjustSigner.onResume(adjustConfig2.logger);
            updateHandlersStatusAndSendI();
            processCoppaComplianceI();
            processSessionI();
            checkAttributionStateI();
            processCachedDeeplinkI();
        }
    }

    private void stopBackgroundTimerI() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce != null) {
            timerOnce.cancel();
        }
    }

    private void stopForegroundTimerI() {
        this.foregroundTimer.suspend();
    }

    private void teardownActivityStateS() {
        synchronized (ActivityState.class) {
            if (this.activityState != null) {
                this.activityState = null;
            }
        }
    }

    private void teardownAllGlobalParametersS() {
        synchronized (GlobalParameters.class) {
            if (this.globalParameters != null) {
                this.globalParameters = null;
            }
        }
    }

    private void teardownAttributionS() {
        synchronized (AdjustAttribution.class) {
            if (this.attribution != null) {
                this.attribution = null;
            }
        }
    }

    private boolean toSendI() {
        return toSendI(false);
    }

    /* access modifiers changed from: private */
    public void trackAdRevenueI(AdjustAdRevenue adjustAdRevenue) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && checkAdjustAdRevenue(adjustAdRevenue) && !this.activityState.isGdprForgotten) {
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildAdRevenuePackage(adjustAdRevenue));
            this.packageHandler.sendFirstPackage();
        }
    }

    /* access modifiers changed from: private */
    public void trackEventI(AdjustEvent adjustEvent) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && checkEventI(adjustEvent) && !this.activityState.isGdprForgotten && shouldProcessEventI(adjustEvent.deduplicationId)) {
            long currentTimeMillis = System.currentTimeMillis();
            this.activityState.eventCount++;
            updateActivityStateI(currentTimeMillis);
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, currentTimeMillis);
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildEventPackage(adjustEvent));
            this.packageHandler.sendFirstPackage();
            if (this.adjustConfig.isSendingInBackgroundEnabled && this.internalState.isInBackground()) {
                startBackgroundTimerI();
            }
            writeActivityStateI();
        }
    }

    /* access modifiers changed from: private */
    public void trackMeasurementConsentI(boolean z11) {
        if (!checkActivityStateI(this.activityState)) {
            this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = Boolean.valueOf(z11);
        } else if (isEnabledI() && !this.activityState.isGdprForgotten) {
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildMeasurementConsentPackage(z11));
            this.packageHandler.sendFirstPackage();
        }
    }

    private void trackNewSessionI(long j11) {
        ActivityState activityState2 = this.activityState;
        activityState2.sessionCount++;
        activityState2.lastInterval = j11 - activityState2.lastActivity;
        transferSessionPackageI(j11);
        this.activityState.resetSessionAttributes(j11);
        writeActivityStateI();
    }

    /* access modifiers changed from: private */
    public void trackPlayStoreSubscriptionI(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten) {
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildSubscriptionPackage(adjustPlayStoreSubscription));
            this.packageHandler.sendFirstPackage();
        }
    }

    /* access modifiers changed from: private */
    public void trackThirdPartySharingI(AdjustThirdPartySharing adjustThirdPartySharing) {
        if (!checkActivityStateI(this.activityState)) {
            this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray.add(adjustThirdPartySharing);
        } else if (!isEnabledI() || this.activityState.isGdprForgotten) {
        } else {
            if (this.adjustConfig.coppaComplianceEnabled) {
                this.logger.warn("Calling third party sharing API not allowed when COPPA enabled", new Object[0]);
                return;
            }
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
            packageBuilder.internalState = this.internalState;
            this.packageHandler.addPackage(packageBuilder.buildThirdPartySharingPackage(adjustThirdPartySharing));
            this.packageHandler.sendFirstPackage();
        }
    }

    private void transferSessionPackageI(long j11) {
        PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, j11);
        packageBuilder.internalState = this.internalState;
        this.packageHandler.addPackage(packageBuilder.buildSessionPackage());
        this.packageHandler.sendFirstPackage();
    }

    private boolean updateActivityStateI(long j11) {
        if (!checkActivityStateI(this.activityState)) {
            return false;
        }
        ActivityState activityState2 = this.activityState;
        long j12 = j11 - activityState2.lastActivity;
        if (j12 > SESSION_INTERVAL) {
            return false;
        }
        activityState2.lastActivity = j11;
        if (j12 < 0) {
            this.logger.error(TIME_TRAVEL, new Object[0]);
            return true;
        }
        activityState2.sessionLength += j12;
        activityState2.timeSpent += j12;
        return true;
    }

    private void updateAdidI(String str) {
        if (str != null) {
            if (!str.equals(this.activityState.adid)) {
                this.activityState.adid = str;
                writeActivityStateI();
            }
            if (!this.cachedAdidReadCallbacks.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.cachedAdidReadCallbacks);
                this.cachedAdidReadCallbacks.clear();
                new Handler(this.adjustConfig.context.getMainLooper()).post(new b1(arrayList, str));
            }
        }
    }

    private void updateHandlersStatusAndSendI() {
        if (!toSendI()) {
            pauseSendingI();
            return;
        }
        resumeSendingI();
        this.packageHandler.sendFirstPackage();
    }

    private void updateStatusI(boolean z11, String str, String str2, String str3) {
        if (z11) {
            this.logger.info(str, new Object[0]);
        } else if (!pausedI(false)) {
            this.logger.info(str3, new Object[0]);
        } else if (pausedI(true)) {
            this.logger.info(str2, new Object[0]);
        } else {
            ILogger iLogger = this.logger;
            iLogger.info(str2 + ", except the Sdk Click Handler", new Object[0]);
        }
        updateHandlersStatusAndSendI();
    }

    /* access modifiers changed from: private */
    public void verifyAndTrackPlayStorePurchaseI(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        if (onPurchaseVerificationFinishedListener == null) {
            this.logger.warn("Purchase verification aborted because verification callback is null", new Object[0]);
        } else if (this.adjustConfig.isDataResidency) {
            this.logger.warn("Purchase verification not available for data residency users right now", new Object[0]);
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 109, "Purchase verification not available for data residency users right now"));
        } else if (!checkActivityStateI(this.activityState)) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 102, "Purchase verification aborted because SDK is still not initialized"));
            this.logger.warn("Purchase verification aborted because SDK is still not initialized", new Object[0]);
        } else if (!isEnabledI()) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 103, "Purchase verification aborted because SDK is disabled"));
            this.logger.warn("Purchase verification aborted because SDK is disabled", new Object[0]);
        } else if (this.activityState.isGdprForgotten) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 104, "Purchase verification aborted because user is GDPR forgotten"));
            this.logger.warn("Purchase verification aborted because user is GDPR forgotten", new Object[0]);
        } else if (adjustEvent == null) {
            this.logger.warn("Purchase verification aborted because event instance is null", new Object[0]);
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 106, "Purchase verification aborted because event instance is null"));
        } else {
            ActivityPackage buildVerificationPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis()).buildVerificationPackage(adjustEvent, onPurchaseVerificationFinishedListener);
            if (buildVerificationPackage == null) {
                this.logger.warn("Purchase verification aborted because verification package is null", new Object[0]);
                onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 107, "Purchase verification aborted because verification package is null"));
                return;
            }
            buildVerificationPackage.event = adjustEvent;
            this.purchaseVerificationHandler.sendPurchaseVerificationPackage(buildVerificationPackage);
        }
    }

    /* access modifiers changed from: private */
    public void verifyPlayStorePurchaseI(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        if (onPurchaseVerificationFinishedListener == null) {
            this.logger.warn("Purchase verification aborted because verification callback is null", new Object[0]);
        } else if (this.adjustConfig.isDataResidency) {
            this.logger.warn("Purchase verification not available for data residency users right now", new Object[0]);
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 109, "Purchase verification not available for data residency users right now"));
        } else if (!checkActivityStateI(this.activityState)) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 102, "Purchase verification aborted because SDK is still not initialized"));
            this.logger.warn("Purchase verification aborted because SDK is still not initialized", new Object[0]);
        } else if (!isEnabledI()) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 103, "Purchase verification aborted because SDK is disabled"));
            this.logger.warn("Purchase verification aborted because SDK is disabled", new Object[0]);
        } else if (this.activityState.isGdprForgotten) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 104, "Purchase verification aborted because user is GDPR forgotten"));
            this.logger.warn("Purchase verification aborted because user is GDPR forgotten", new Object[0]);
        } else if (adjustPlayStorePurchase == null) {
            this.logger.warn("Purchase verification aborted because purchase instance is null", new Object[0]);
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 105, "Purchase verification aborted because purchase instance is null"));
        } else {
            PackageBuilder packageBuilder = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.globalParameters, System.currentTimeMillis());
            packageBuilder.internalState = this.internalState;
            ActivityPackage buildVerificationPackage = packageBuilder.buildVerificationPackage(adjustPlayStorePurchase, onPurchaseVerificationFinishedListener);
            if (buildVerificationPackage == null) {
                this.logger.warn("Purchase verification aborted because verification package is null", new Object[0]);
                onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 106, "Purchase verification aborted because verification package is null"));
                return;
            }
            this.purchaseVerificationHandler.sendPurchaseVerificationPackage(buildVerificationPackage);
        }
    }

    private void writeActivityStateI() {
        synchronized (ActivityState.class) {
            ActivityState activityState2 = this.activityState;
            if (activityState2 != null) {
                Util.writeObject(activityState2, this.adjustConfig.context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME);
            }
        }
    }

    private void writeAttributionI() {
        synchronized (AdjustAttribution.class) {
            AdjustAttribution adjustAttribution = this.attribution;
            if (adjustAttribution != null) {
                Util.writeObject(adjustAttribution, this.adjustConfig.context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME);
            }
        }
    }

    private void writeGlobalCallbackParametersI() {
        synchronized (GlobalParameters.class) {
            GlobalParameters globalParameters2 = this.globalParameters;
            if (globalParameters2 != null) {
                Util.writeObject(globalParameters2.callbackParameters, this.adjustConfig.context, Constants.GLOBAL_CALLBACK_PARAMETERS_FILENAME, GLOBAL_CALLBACK_PARAMETERS_NAME);
            }
        }
    }

    private void writeGlobalPartnerParametersI() {
        synchronized (GlobalParameters.class) {
            GlobalParameters globalParameters2 = this.globalParameters;
            if (globalParameters2 != null) {
                Util.writeObject(globalParameters2.partnerParameters, this.adjustConfig.context, Constants.GLOBAL_PARTNER_PARAMETERS_FILENAME, GLOBAL_PARTNER_PARAMETERS_NAME);
            }
        }
    }

    public void addGlobalCallbackParameter(String str, String str2) {
        this.executor.submit(new i(str, str2));
    }

    public void addGlobalCallbackParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Global Callback") && Util.isValidParameter(str2, "value", "Global Callback")) {
            GlobalParameters globalParameters2 = this.globalParameters;
            if (globalParameters2.callbackParameters == null) {
                globalParameters2.callbackParameters = new LinkedHashMap();
            }
            String str3 = this.globalParameters.callbackParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.globalParameters.callbackParameters.put(str, str2);
            writeGlobalCallbackParametersI();
        }
    }

    public void addGlobalPartnerParameter(String str, String str2) {
        this.executor.submit(new j(str, str2));
    }

    public void addGlobalPartnerParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Global Partner") && Util.isValidParameter(str2, "value", "Global Partner")) {
            GlobalParameters globalParameters2 = this.globalParameters;
            if (globalParameters2.partnerParameters == null) {
                globalParameters2.partnerParameters = new LinkedHashMap();
            }
            String str3 = this.globalParameters.partnerParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.globalParameters.partnerParameters.put(str, str2);
            writeGlobalPartnerParametersI();
        }
    }

    public void backgroundTimerFired() {
        this.executor.submit(new y());
    }

    public void finishedTrackingActivity(ResponseData responseData) {
        if (responseData instanceof SessionResponseData) {
            this.logger.debug("Finished tracking session", new Object[0]);
            this.attributionHandler.checkSessionResponse((SessionResponseData) responseData);
        } else if (responseData instanceof SdkClickResponseData) {
            SdkClickResponseData sdkClickResponseData = (SdkClickResponseData) responseData;
            checkForInstallReferrerInfo(sdkClickResponseData);
            this.attributionHandler.checkSdkClickResponse(sdkClickResponseData);
        } else if (responseData instanceof EventResponseData) {
            launchEventResponseTasks((EventResponseData) responseData);
        } else if (responseData instanceof PurchaseVerificationResponseData) {
            launchPurchaseVerificationResponseTasks((PurchaseVerificationResponseData) responseData);
        }
    }

    public void foregroundTimerFired() {
        this.executor.submit(new x());
    }

    public void gdprForgetMe() {
        this.executor.submit(new q());
    }

    public ActivityState getActivityState() {
        return this.activityState;
    }

    public void getAdid(OnAdidReadListener onAdidReadListener) {
        ActivityState activityState2 = this.activityState;
        if (activityState2 == null || activityState2.adid == null) {
            if (activityState2 == null) {
                this.logger.warn("SDK needs to be initialized before getting adid", new Object[0]);
            }
            this.cachedAdidReadCallbacks.add(onAdidReadListener);
            return;
        }
        new Handler(this.adjustConfig.context.getMainLooper()).post(new z(onAdidReadListener));
    }

    public AdjustConfig getAdjustConfig() {
        return this.adjustConfig;
    }

    public void getAttribution(OnAttributionReadListener onAttributionReadListener) {
        if (this.attribution != null) {
            new Handler(this.adjustConfig.context.getMainLooper()).post(new a0(onAttributionReadListener));
        } else {
            this.cachedAttributionReadCallbacks.add(onAttributionReadListener);
        }
    }

    public Context getContext() {
        return this.adjustConfig.context;
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public GlobalParameters getGlobalParameters() {
        return this.globalParameters;
    }

    public InternalState getInternalState() {
        return this.internalState;
    }

    public void gotOptOutResponse() {
        this.executor.submit(new w());
    }

    public void init(AdjustConfig adjustConfig2) {
        this.adjustConfig = adjustConfig2;
    }

    public void isEnabled(OnIsEnabledListener onIsEnabledListener) {
        this.executor.submit(new r0(onIsEnabledListener));
    }

    public void launchAttributionResponseTasks(AttributionResponseData attributionResponseData) {
        this.executor.submit(new g(attributionResponseData));
    }

    public void launchEventResponseTasks(EventResponseData eventResponseData) {
        this.executor.submit(new d(eventResponseData));
    }

    public void launchPurchaseVerificationResponseTasks(PurchaseVerificationResponseData purchaseVerificationResponseData) {
        this.executor.submit(new h(purchaseVerificationResponseData));
    }

    public void launchSdkClickResponseTasks(SdkClickResponseData sdkClickResponseData) {
        this.executor.submit(new e(sdkClickResponseData));
    }

    public void launchSessionResponseTasks(SessionResponseData sessionResponseData) {
        this.executor.submit(new f(sessionResponseData));
    }

    public void onActivityLifecycle(boolean z11) {
        this.executor.submit(new b(this, z11));
    }

    public void onPause() {
        onActivityLifecycle(false);
    }

    public void onPauseI() {
        stopForegroundTimerI();
        startBackgroundTimerI();
        this.logger.verbose("Subsession end", new Object[0]);
        endI();
    }

    public void onResume() {
        onActivityLifecycle(true);
    }

    public void onResumeI() {
        stopBackgroundTimerI();
        startForegroundTimerI();
        this.logger.verbose("Subsession start", new Object[0]);
        startI();
    }

    public void processAndResolveDeeplink(Uri uri, long j11, OnDeeplinkResolvedListener onDeeplinkResolvedListener) {
        this.cachedDeeplinkResolutionCallback = onDeeplinkResolvedListener;
        this.executor.submit(new a1(uri, j11));
    }

    public void processDeeplink(Uri uri, long j11) {
        this.executor.submit(new z0(uri, j11));
    }

    public void removeGlobalCallbackParameter(String str) {
        this.executor.submit(new l(str));
    }

    public void removeGlobalCallbackParameterI(String str) {
        if (Util.isValidParameter(str, "key", "Session Callback")) {
            Map<String, String> map = this.globalParameters.callbackParameters;
            if (map == null) {
                this.logger.warn("Session Callback parameters are not set", new Object[0]);
            } else if (map.remove(str) == null) {
                this.logger.warn("Key %s does not exist", str);
            } else {
                this.logger.debug("Key %s will be removed", str);
                writeGlobalCallbackParametersI();
            }
        }
    }

    public void removeGlobalCallbackParameters() {
        this.executor.submit(new n());
    }

    public void removeGlobalCallbackParametersI() {
        if (this.globalParameters.callbackParameters == null) {
            this.logger.warn("Session Callback parameters are not set", new Object[0]);
        }
        this.globalParameters.callbackParameters = null;
        writeGlobalCallbackParametersI();
    }

    public void removeGlobalPartnerParameter(String str) {
        this.executor.submit(new m(str));
    }

    public void removeGlobalPartnerParameterI(String str) {
        if (Util.isValidParameter(str, "key", "Session Partner")) {
            Map<String, String> map = this.globalParameters.partnerParameters;
            if (map == null) {
                this.logger.warn("Session Partner parameters are not set", new Object[0]);
            } else if (map.remove(str) == null) {
                this.logger.warn("Key %s does not exist", str);
            } else {
                this.logger.debug("Key %s will be removed", str);
                writeGlobalPartnerParametersI();
            }
        }
    }

    public void removeGlobalPartnerParameters() {
        this.executor.submit(new o());
    }

    public void removeGlobalPartnerParametersI() {
        if (this.globalParameters.partnerParameters == null) {
            this.logger.warn("Session Partner parameters are not set", new Object[0]);
        }
        this.globalParameters.partnerParameters = null;
        writeGlobalPartnerParametersI();
    }

    public void sendInstallReferrer(ReferrerDetails referrerDetails, String str) {
        this.executor.submit(new c(referrerDetails, str));
    }

    public void sendPreinstallReferrer() {
        this.executor.submit(new b());
    }

    public void sendReftagReferrer() {
        this.executor.submit(new a());
    }

    public void setAskingAttribution(boolean z11) {
        this.executor.submit(new d1(z11));
    }

    public void setEnabled(boolean z11) {
        this.executor.submit(new v(z11));
    }

    public void setOfflineMode(boolean z11) {
        this.executor.submit(new g0(z11));
    }

    public void setPushToken(String str, boolean z11) {
        this.executor.submit(new p(z11, str));
    }

    public void teardown() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce != null) {
            timerOnce.teardown();
        }
        TimerCycle timerCycle = this.foregroundTimer;
        if (timerCycle != null) {
            timerCycle.teardown();
        }
        ThreadExecutor threadExecutor = this.executor;
        if (threadExecutor != null) {
            threadExecutor.teardown();
        }
        IPackageHandler iPackageHandler = this.packageHandler;
        if (iPackageHandler != null) {
            iPackageHandler.teardown();
        }
        IAttributionHandler iAttributionHandler = this.attributionHandler;
        if (iAttributionHandler != null) {
            iAttributionHandler.teardown();
        }
        ISdkClickHandler iSdkClickHandler = this.sdkClickHandler;
        if (iSdkClickHandler != null) {
            iSdkClickHandler.teardown();
        }
        IPurchaseVerificationHandler iPurchaseVerificationHandler = this.purchaseVerificationHandler;
        if (iPurchaseVerificationHandler != null) {
            iPurchaseVerificationHandler.teardown();
        }
        GlobalParameters globalParameters2 = this.globalParameters;
        if (globalParameters2 != null) {
            Map<String, String> map = globalParameters2.callbackParameters;
            if (map != null) {
                map.clear();
            }
            Map<String, String> map2 = this.globalParameters.partnerParameters;
            if (map2 != null) {
                map2.clear();
            }
        }
        teardownActivityStateS();
        teardownAttributionS();
        teardownAllGlobalParametersS();
        this.packageHandler = null;
        this.logger = null;
        this.foregroundTimer = null;
        this.executor = null;
        this.backgroundTimer = null;
        this.internalState = null;
        this.deviceInfo = null;
        this.adjustConfig = null;
        this.attributionHandler = null;
        this.sdkClickHandler = null;
        this.purchaseVerificationHandler = null;
        this.globalParameters = null;
    }

    public void trackAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        this.executor.submit(new t(adjustAdRevenue));
    }

    public void trackEvent(AdjustEvent adjustEvent) {
        this.executor.submit(new k(adjustEvent));
    }

    public void trackMeasurementConsent(boolean z11) {
        this.executor.submit(new s(z11));
    }

    public void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        this.executor.submit(new u(adjustPlayStoreSubscription));
    }

    public void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing) {
        this.executor.submit(new r(adjustThirdPartySharing));
    }

    public boolean updateAttributionI(AdjustAttribution adjustAttribution) {
        if (adjustAttribution == null || this.activityState.askingAttribution) {
            return false;
        }
        if (!this.cachedAttributionReadCallbacks.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.cachedAttributionReadCallbacks);
            this.cachedAttributionReadCallbacks.clear();
            new Handler(this.adjustConfig.context.getMainLooper()).post(new c1(arrayList, adjustAttribution));
        }
        if (adjustAttribution.equals(this.attribution)) {
            return false;
        }
        this.attribution = adjustAttribution;
        writeAttributionI();
        return true;
    }

    public void verifyAndTrackPlayStorePurchase(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        this.executor.submit(new c0(adjustEvent, onPurchaseVerificationFinishedListener));
    }

    public void verifyPlayStorePurchase(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        this.executor.submit(new b0(adjustPlayStorePurchase, onPurchaseVerificationFinishedListener));
    }

    private void checkAfterNewStartI(SharedPreferencesManager sharedPreferencesManager) {
        String pushToken = sharedPreferencesManager.getPushToken();
        if (pushToken != null && !pushToken.equals(this.activityState.pushToken)) {
            setPushToken(pushToken, true);
        }
        if (sharedPreferencesManager.getRawReferrerArray() != null) {
            sendReftagReferrer();
        }
        checkForPreinstallI();
        this.installReferrer.startConnection();
        readInstallReferrerMeta();
        readInstallReferrerHuaweiAds();
        readInstallReferrerHuaweiAppGallery();
        readInstallReferrerSamsung();
        readInstallReferrerXiaomi();
        readInstallReferrerVivo();
    }

    private boolean pausedI(boolean z11) {
        return z11 ? this.internalState.isOffline() || !isEnabledI() : this.internalState.isOffline() || !isEnabledI();
    }

    private boolean toSendI(boolean z11) {
        if (pausedI(z11)) {
            return false;
        }
        if (this.adjustConfig.isSendingInBackgroundEnabled) {
            return true;
        }
        return this.internalState.isInForeground();
    }

    public boolean isEnabled() {
        return isEnabledI();
    }
}
