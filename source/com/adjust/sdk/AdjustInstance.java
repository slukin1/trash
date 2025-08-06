package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;
import com.adjust.sdk.scheduler.AsyncTaskExecutor;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import java.util.ArrayList;
import java.util.List;

public class AdjustInstance {
    private IActivityHandler activityHandler;
    private String basePath;
    private ArrayList<OnAdidReadListener> cachedAdidReadCallbacks = new ArrayList<>();
    private ArrayList<OnAttributionReadListener> cachedAttributionReadCallbacks = new ArrayList<>();
    private OnDeeplinkResolvedListener cachedDeeplinkResolutionCallback;
    private String gdprPath;
    private PreLaunchActions preLaunchActions = new PreLaunchActions();
    private String purchaseVerificationPath;
    private String pushToken;
    private Boolean startEnabled = null;
    private boolean startOffline = false;
    private String subscriptionPath;

    public static class PreLaunchActions {
        public Boolean lastMeasurementConsentTracked = null;
        public List<IRunActivityHandler> preLaunchActionsArray = new ArrayList();
        public List<AdjustThirdPartySharing> preLaunchAdjustThirdPartySharingArray = new ArrayList();
    }

    public class a extends AsyncTaskExecutor<Void, Uri> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f13881a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OnLastDeeplinkReadListener f13882b;

        public a(Context context, OnLastDeeplinkReadListener onLastDeeplinkReadListener) {
            this.f13881a = context;
            this.f13882b = onLastDeeplinkReadListener;
        }

        public final Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            try {
                return Uri.parse(AdjustInstance.this.getCachedDeeplink(this.f13881a));
            } catch (Exception unused) {
                return null;
            }
        }

        public final void onPostExecute(Object obj) {
            this.f13882b.onLastDeeplinkRead((Uri) obj);
        }
    }

    public class b extends AsyncTaskExecutor<Context, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnIsEnabledListener f13884a;

        public b(OnIsEnabledListener onIsEnabledListener) {
            this.f13884a = onIsEnabledListener;
        }

        public final Object doInBackground(Object[] objArr) {
            return Boolean.valueOf(Util.isEnabledFromActivityStateFile(((Context[]) objArr)[0]));
        }

        public final void onPostExecute(Object obj) {
            this.f13884a.onIsEnabledRead(((Boolean) obj).booleanValue());
        }
    }

    public class c implements IRunActivityHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13885a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13886b;

        public c(String str, String str2) {
            this.f13885a = str;
            this.f13886b = str2;
        }

        public final void run(ActivityHandler activityHandler) {
            activityHandler.addGlobalCallbackParameterI(this.f13885a, this.f13886b);
        }
    }

    public class d implements IRunActivityHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13887a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13888b;

        public d(String str, String str2) {
            this.f13887a = str;
            this.f13888b = str2;
        }

        public final void run(ActivityHandler activityHandler) {
            activityHandler.addGlobalPartnerParameterI(this.f13887a, this.f13888b);
        }
    }

    public class e implements IRunActivityHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13889a;

        public e(String str) {
            this.f13889a = str;
        }

        public final void run(ActivityHandler activityHandler) {
            activityHandler.removeGlobalCallbackParameterI(this.f13889a);
        }
    }

    public class f implements IRunActivityHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13890a;

        public f(String str) {
            this.f13890a = str;
        }

        public final void run(ActivityHandler activityHandler) {
            activityHandler.removeGlobalPartnerParameterI(this.f13890a);
        }
    }

    public class g implements IRunActivityHandler {
        public final void run(ActivityHandler activityHandler) {
            activityHandler.removeGlobalCallbackParametersI();
        }
    }

    public class h implements IRunActivityHandler {
        public final void run(ActivityHandler activityHandler) {
            activityHandler.removeGlobalPartnerParametersI();
        }
    }

    public class i extends AsyncTaskExecutor<Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnSdkVersionReadListener f13891a;

        public i(OnSdkVersionReadListener onSdkVersionReadListener) {
            this.f13891a = onSdkVersionReadListener;
        }

        public final Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            return Util.getSdkVersion();
        }

        public final void onPostExecute(Object obj) {
            this.f13891a.onSdkVersionRead((String) obj);
        }
    }

    public class j implements InstallReferrerReadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnGooglePlayInstallReferrerReadListener f13892a;

        public j(OnGooglePlayInstallReferrerReadListener onGooglePlayInstallReferrerReadListener) {
            this.f13892a = onGooglePlayInstallReferrerReadListener;
        }

        public final void onFail(String str) {
            this.f13892a.onFail(str);
        }

        public final void onInstallReferrerRead(ReferrerDetails referrerDetails, String str) {
            this.f13892a.onInstallReferrerRead(new GooglePlayInstallReferrerDetails(referrerDetails));
        }
    }

    private void cacheDeeplink(Uri uri, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).cacheDeeplink(uri);
    }

    private boolean checkActivityHandler(String str) {
        return checkActivityHandler(str, false);
    }

    /* access modifiers changed from: private */
    public String getCachedDeeplink(Context context) {
        return SharedPreferencesManager.getDefaultInstance(context).getCachedDeeplink();
    }

    private boolean isInstanceEnabled() {
        Boolean bool = this.startEnabled;
        return bool == null || bool.booleanValue();
    }

    private void saveDeeplink(Uri uri, long j11, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).saveDeeplink(uri, j11);
    }

    private void saveGdprForgetMe(Context context) {
        SharedPreferencesManager.getDefaultInstance(context).setGdprForgetMe();
    }

    private void savePreinstallReferrer(String str, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).savePreinstallReferrer(str);
    }

    private void savePushToken(String str, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).savePushToken(str);
    }

    private void saveRawReferrer(String str, long j11, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).saveRawReferrer(str, j11);
    }

    private void setSendingReferrersAsNotSent(Context context) {
        new SingleThreadCachedScheduler("AdjustInstance").submit(new c(context));
    }

    public void addGlobalCallbackParameter(String str, String str2) {
        if (checkActivityHandler("adding global callback parameter", true)) {
            this.activityHandler.addGlobalCallbackParameter(str, str2);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new c(str, str2));
        }
    }

    public void addGlobalPartnerParameter(String str, String str2) {
        if (checkActivityHandler("adding global partner parameter", true)) {
            this.activityHandler.addGlobalPartnerParameter(str, str2);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new d(str, str2));
        }
    }

    public void disable() {
        this.startEnabled = Boolean.FALSE;
        if (checkActivityHandler(false, "enabled mode", "disabled mode")) {
            this.activityHandler.setEnabled(false);
        }
    }

    public void enable() {
        this.startEnabled = Boolean.TRUE;
        if (checkActivityHandler(true, "enabled mode", "disabled mode")) {
            this.activityHandler.setEnabled(true);
        }
    }

    public void gdprForgetMe(Context context) {
        saveGdprForgetMe(context);
        if (checkActivityHandler("gdpr", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.gdprForgetMe();
        }
    }

    public void getAdid(OnAdidReadListener onAdidReadListener) {
        if (!checkActivityHandler("getAdid")) {
            this.cachedAdidReadCallbacks.add(onAdidReadListener);
        } else {
            this.activityHandler.getAdid(onAdidReadListener);
        }
    }

    public void getAmazonAdId(Context context, OnAmazonAdIdReadListener onAmazonAdIdReadListener) {
        DeviceInfo.getFireAdvertisingIdBypassConditions(context.getContentResolver(), onAmazonAdIdReadListener);
    }

    public void getAttribution(OnAttributionReadListener onAttributionReadListener) {
        if (!checkActivityHandler("getAttribution")) {
            this.cachedAttributionReadCallbacks.add(onAttributionReadListener);
        } else {
            this.activityHandler.getAttribution(onAttributionReadListener);
        }
    }

    public void getGooglePlayInstallReferrer(Context context, OnGooglePlayInstallReferrerReadListener onGooglePlayInstallReferrerReadListener) {
        new InstallReferrer(context, new j(onGooglePlayInstallReferrerReadListener)).startConnection();
    }

    public void getLastDeeplink(Context context, OnLastDeeplinkReadListener onLastDeeplinkReadListener) {
        new a(context, onLastDeeplinkReadListener).execute(new Void[0]);
    }

    public void getSdkVersion(OnSdkVersionReadListener onSdkVersionReadListener) {
        new i(onSdkVersionReadListener).execute(new Void[0]);
    }

    public void initSdk(AdjustConfig adjustConfig) {
        if (!AdjustSigner.isPresent()) {
            AdjustFactory.getLogger().error("Missing signature library, SDK can't be initialised", new Object[0]);
        } else if (adjustConfig == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
        } else if (!adjustConfig.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
        } else if (this.activityHandler != null) {
            AdjustFactory.getLogger().error("Adjust already initialized", new Object[0]);
        } else {
            adjustConfig.preLaunchActions = this.preLaunchActions;
            adjustConfig.pushToken = this.pushToken;
            adjustConfig.startEnabled = this.startEnabled;
            adjustConfig.startOffline = this.startOffline;
            adjustConfig.basePath = this.basePath;
            adjustConfig.gdprPath = this.gdprPath;
            adjustConfig.subscriptionPath = this.subscriptionPath;
            adjustConfig.purchaseVerificationPath = this.purchaseVerificationPath;
            adjustConfig.cachedDeeplinkResolutionCallback = this.cachedDeeplinkResolutionCallback;
            adjustConfig.cachedAdidReadCallbacks = this.cachedAdidReadCallbacks;
            adjustConfig.cachedAttributionReadCallbacks = this.cachedAttributionReadCallbacks;
            this.activityHandler = AdjustFactory.getActivityHandler(adjustConfig);
            setSendingReferrersAsNotSent(adjustConfig.context);
        }
    }

    public void isEnabled(Context context, OnIsEnabledListener onIsEnabledListener) {
        if (!checkActivityHandler("isEnabled")) {
            new b(onIsEnabledListener).execute(context);
            return;
        }
        this.activityHandler.isEnabled(onIsEnabledListener);
    }

    public void onPause() {
        if (checkActivityHandler("onPause")) {
            this.activityHandler.onPause();
        }
    }

    public void onResume() {
        if (checkActivityHandler("onResume")) {
            this.activityHandler.onResume();
        }
    }

    public void processAndResolveDeeplink(AdjustDeeplink adjustDeeplink, Context context, OnDeeplinkResolvedListener onDeeplinkResolvedListener) {
        if (adjustDeeplink == null || !adjustDeeplink.isValid()) {
            AdjustFactory.getLogger().warn("Skipping deeplink processing (null or empty)", new Object[0]);
        } else if (onDeeplinkResolvedListener == null) {
            processDeeplink(adjustDeeplink, context);
        } else {
            cacheDeeplink(adjustDeeplink.url, context);
            long currentTimeMillis = System.currentTimeMillis();
            if (!checkActivityHandler("processAndResolveDeeplink", true)) {
                saveDeeplink(adjustDeeplink.url, currentTimeMillis, context);
                this.cachedDeeplinkResolutionCallback = onDeeplinkResolvedListener;
                return;
            }
            this.activityHandler.processAndResolveDeeplink(adjustDeeplink.url, currentTimeMillis, onDeeplinkResolvedListener);
        }
    }

    public void processDeeplink(AdjustDeeplink adjustDeeplink, Context context) {
        if (adjustDeeplink == null || !adjustDeeplink.isValid()) {
            AdjustFactory.getLogger().warn("Skipping deeplink processing (null or empty)", new Object[0]);
            return;
        }
        cacheDeeplink(adjustDeeplink.url, context);
        long currentTimeMillis = System.currentTimeMillis();
        if (!checkActivityHandler("processDeeplink", true)) {
            saveDeeplink(adjustDeeplink.url, currentTimeMillis, context);
        } else {
            this.activityHandler.processDeeplink(adjustDeeplink.url, currentTimeMillis);
        }
    }

    public void removeGlobalCallbackParameter(String str) {
        if (checkActivityHandler("removing global callback parameter", true)) {
            this.activityHandler.removeGlobalCallbackParameter(str);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new e(str));
        }
    }

    public void removeGlobalCallbackParameters() {
        if (checkActivityHandler("resetting global callback parameters", true)) {
            this.activityHandler.removeGlobalCallbackParameters();
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new g());
        }
    }

    public void removeGlobalPartnerParameter(String str) {
        if (checkActivityHandler("removing global partner parameter", true)) {
            this.activityHandler.removeGlobalPartnerParameter(str);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new f(str));
        }
    }

    public void removeGlobalPartnerParameters() {
        if (checkActivityHandler("resetting global partner parameters", true)) {
            this.activityHandler.removeGlobalPartnerParameters();
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new h());
        }
    }

    public void sendPreinstallReferrer(String str, Context context) {
        if (str == null || str.length() == 0) {
            AdjustFactory.getLogger().warn("Skipping SYSTEM_INSTALLER_REFERRER preinstall referrer processing (null or empty)", new Object[0]);
            return;
        }
        savePreinstallReferrer(str, context);
        if (checkActivityHandler("preinstall referrer", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.sendPreinstallReferrer();
        }
    }

    public void sendReferrer(String str, Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            AdjustFactory.getLogger().warn("Skipping INSTALL_REFERRER intent referrer processing (null or empty)", new Object[0]);
            return;
        }
        saveRawReferrer(str, currentTimeMillis, context);
        if (checkActivityHandler(Constants.REFERRER, true) && this.activityHandler.isEnabled()) {
            this.activityHandler.sendReftagReferrer();
        }
    }

    public void setPushToken(String str, Context context) {
        savePushToken(str, context);
        if (checkActivityHandler("push token", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.setPushToken(str, true);
        }
    }

    public void setTestOptions(AdjustTestOptions adjustTestOptions) {
        String str = adjustTestOptions.basePath;
        if (str != null) {
            this.basePath = str;
        }
        String str2 = adjustTestOptions.gdprPath;
        if (str2 != null) {
            this.gdprPath = str2;
        }
        String str3 = adjustTestOptions.subscriptionPath;
        if (str3 != null) {
            this.subscriptionPath = str3;
        }
        String str4 = adjustTestOptions.purchaseVerificationPath;
        if (str4 != null) {
            this.purchaseVerificationPath = str4;
        }
        String str5 = adjustTestOptions.baseUrl;
        if (str5 != null) {
            AdjustFactory.setBaseUrl(str5);
        }
        String str6 = adjustTestOptions.gdprUrl;
        if (str6 != null) {
            AdjustFactory.setGdprUrl(str6);
        }
        String str7 = adjustTestOptions.subscriptionUrl;
        if (str7 != null) {
            AdjustFactory.setSubscriptionUrl(str7);
        }
        String str8 = adjustTestOptions.purchaseVerificationUrl;
        if (str8 != null) {
            AdjustFactory.setPurchaseVerificationUrl(str8);
        }
        Long l11 = adjustTestOptions.timerIntervalInMilliseconds;
        if (l11 != null) {
            AdjustFactory.setTimerInterval(l11.longValue());
        }
        if (adjustTestOptions.timerStartInMilliseconds != null) {
            AdjustFactory.setTimerStart(adjustTestOptions.timerIntervalInMilliseconds.longValue());
        }
        Long l12 = adjustTestOptions.sessionIntervalInMilliseconds;
        if (l12 != null) {
            AdjustFactory.setSessionInterval(l12.longValue());
        }
        Long l13 = adjustTestOptions.subsessionIntervalInMilliseconds;
        if (l13 != null) {
            AdjustFactory.setSubsessionInterval(l13.longValue());
        }
        Boolean bool = adjustTestOptions.tryInstallReferrer;
        if (bool != null) {
            AdjustFactory.setTryInstallReferrer(bool.booleanValue());
        }
        if (adjustTestOptions.noBackoffWait != null) {
            BackoffStrategy backoffStrategy = BackoffStrategy.NO_WAIT;
            AdjustFactory.setPackageHandlerBackoffStrategy(backoffStrategy);
            AdjustFactory.setSdkClickBackoffStrategy(backoffStrategy);
        }
        Boolean bool2 = adjustTestOptions.ignoreSystemLifecycleBootstrap;
        if (bool2 != null) {
            AdjustFactory.setIgnoreSystemLifecycleBootstrap(bool2.booleanValue());
        }
    }

    public void switchBackToOnlineMode() {
        if (!checkActivityHandler(false, "offline mode", "online mode")) {
            this.startOffline = false;
        } else {
            this.activityHandler.setOfflineMode(false);
        }
    }

    public void switchToOfflineMode() {
        if (!checkActivityHandler(true, "offline mode", "online mode")) {
            this.startOffline = true;
        } else {
            this.activityHandler.setOfflineMode(true);
        }
    }

    public void teardown() {
        if (checkActivityHandler("teardown")) {
            this.activityHandler.teardown();
            this.activityHandler = null;
        }
    }

    public void trackAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        if (checkActivityHandler("trackAdRevenue")) {
            this.activityHandler.trackAdRevenue(adjustAdRevenue);
        }
    }

    public void trackEvent(AdjustEvent adjustEvent) {
        if (checkActivityHandler("trackEvent")) {
            this.activityHandler.trackEvent(adjustEvent);
        }
    }

    public void trackMeasurementConsent(boolean z11) {
        if (!checkActivityHandler("measurement consent", true)) {
            this.preLaunchActions.lastMeasurementConsentTracked = Boolean.valueOf(z11);
            return;
        }
        this.activityHandler.trackMeasurementConsent(z11);
    }

    public void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (checkActivityHandler("trackPlayStoreSubscription")) {
            this.activityHandler.trackPlayStoreSubscription(adjustPlayStoreSubscription);
        }
    }

    public void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing) {
        if (!checkActivityHandler("third party sharing", true)) {
            this.preLaunchActions.preLaunchAdjustThirdPartySharingArray.add(adjustThirdPartySharing);
        } else {
            this.activityHandler.trackThirdPartySharing(adjustThirdPartySharing);
        }
    }

    public void verifyAndTrackPlayStorePurchase(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        if (checkActivityHandler("verifyAndTrack")) {
            this.activityHandler.verifyAndTrackPlayStorePurchase(adjustEvent, onPurchaseVerificationFinishedListener);
        } else if (onPurchaseVerificationFinishedListener != null) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 100, "SDK needs to be initialized before making purchase verification request"));
        }
    }

    public void verifyPlayStorePurchase(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        if (!checkActivityHandler("verifyPurchase")) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 100, "SDK needs to be initialized before making purchase verification request"));
        } else {
            this.activityHandler.verifyPlayStorePurchase(adjustPlayStorePurchase, onPurchaseVerificationFinishedListener);
        }
    }

    private boolean checkActivityHandler(String str, boolean z11) {
        if (this.activityHandler != null) {
            return true;
        }
        if (str == null) {
            AdjustFactory.getLogger().error("Adjust not initialized correctly", new Object[0]);
            return false;
        }
        if (z11) {
            AdjustFactory.getLogger().warn("Adjust not initialized, but %s saved for launch", str);
        } else {
            AdjustFactory.getLogger().warn("Adjust not initialized, can't perform %s", str);
        }
        return false;
    }

    private boolean checkActivityHandler(boolean z11, String str, String str2) {
        return z11 ? checkActivityHandler(str, true) : checkActivityHandler(str2, true);
    }
}
