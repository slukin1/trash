package com.adjust.sdk;

import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class SdkClickHandler implements ISdkClickHandler {
    private static final double MILLISECONDS_TO_SECONDS_DIVISOR = 1000.0d;
    private static final String SCHEDULED_EXECUTOR_SOURCE = "SdkClickHandler";
    private static final String SOURCE_INSTALL_REFERRER = "install_referrer";
    private static final String SOURCE_REFTAG = "reftag";
    /* access modifiers changed from: private */
    public WeakReference<IActivityHandler> activityHandlerWeakRef;
    private IActivityPackageSender activityPackageSender;
    private BackoffStrategy backoffStrategy;
    private long lastPackageRetryInMilli = 0;
    /* access modifiers changed from: private */
    public ILogger logger;
    /* access modifiers changed from: private */
    public List<ActivityPackage> packageQueue;
    private boolean paused;
    private ThreadScheduler scheduler;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ActivityPackage f13936a;

        public a(ActivityPackage activityPackage) {
            this.f13936a = activityPackage;
        }

        public final void run() {
            SdkClickHandler.this.packageQueue.add(this.f13936a);
            SdkClickHandler.this.logger.debug("Added sdk_click %d", Integer.valueOf(SdkClickHandler.this.packageQueue.size()));
            SdkClickHandler.this.logger.verbose("%s", this.f13936a.getExtendedString());
            SdkClickHandler.this.sendNextSdkClick();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) SdkClickHandler.this.activityHandlerWeakRef.get();
            SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext());
            try {
                JSONArray rawReferrerArray = defaultInstance.getRawReferrerArray();
                boolean z11 = false;
                for (int i11 = 0; i11 < rawReferrerArray.length(); i11++) {
                    JSONArray jSONArray = rawReferrerArray.getJSONArray(i11);
                    if (jSONArray.optInt(2, -1) == 0) {
                        String optString = jSONArray.optString(0, (String) null);
                        long optLong = jSONArray.optLong(1, -1);
                        jSONArray.put(2, 1);
                        SdkClickHandler.this.sendSdkClick(PackageFactory.buildReftagSdkClickPackage(optString, optLong, iActivityHandler.getActivityState(), iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getGlobalParameters(), iActivityHandler.getInternalState()));
                        z11 = true;
                    }
                }
                if (z11) {
                    defaultInstance.saveRawReferrerArray(rawReferrerArray);
                }
            } catch (JSONException e11) {
                SdkClickHandler.this.logger.error("Send saved raw referrers error (%s)", e11.getMessage());
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13939a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13940b;

        public c(String str, String str2) {
            this.f13939a = str;
            this.f13940b = str2;
        }

        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) SdkClickHandler.this.activityHandlerWeakRef.get();
            if (iActivityHandler != null) {
                SdkClickHandler.this.sendSdkClick(PackageFactory.buildPreinstallSdkClickPackage(this.f13939a, this.f13940b, iActivityHandler.getActivityState(), iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getGlobalParameters()));
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public final void run() {
            SdkClickHandler.this.sendNextSdkClickI();
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ActivityPackage f13943a;

        public e(ActivityPackage activityPackage) {
            this.f13943a = activityPackage;
        }

        public final void run() {
            SdkClickHandler.this.sendSdkClickI(this.f13943a);
            SdkClickHandler.this.sendNextSdkClick();
        }
    }

    public SdkClickHandler(IActivityHandler iActivityHandler, boolean z11, IActivityPackageSender iActivityPackageSender) {
        init(iActivityHandler, z11, iActivityPackageSender);
        this.logger = AdjustFactory.getLogger();
        this.backoffStrategy = AdjustFactory.getSdkClickBackoffStrategy();
        this.scheduler = new SingleThreadCachedScheduler(SCHEDULED_EXECUTOR_SOURCE);
    }

    private Map<String, String> generateSendingParametersI() {
        HashMap hashMap = new HashMap();
        PackageBuilder.addString(hashMap, "sent_at", Util.dateFormatter.format(Long.valueOf(System.currentTimeMillis())));
        int size = this.packageQueue.size() - 1;
        if (size > 0) {
            PackageBuilder.addLong(hashMap, "queue_size", (long) size);
        }
        return hashMap;
    }

    private void logErrorMessageI(ActivityPackage activityPackage, String str, Throwable th2) {
        this.logger.error(Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th2)), new Object[0]);
    }

    private void retrySendingI(ActivityPackage activityPackage, Long l11) {
        if (l11 == null || l11.longValue() <= 0) {
            int increaseRetries = activityPackage.increaseRetries();
            this.logger.error("Retrying sdk_click package for the %d time", Integer.valueOf(increaseRetries));
        } else {
            this.lastPackageRetryInMilli = l11.longValue();
        }
        sendSdkClick(activityPackage);
    }

    /* access modifiers changed from: private */
    public void sendNextSdkClick() {
        this.scheduler.submit(new d());
    }

    /* access modifiers changed from: private */
    public void sendNextSdkClickI() {
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler.getActivityState() != null && !iActivityHandler.getActivityState().isGdprForgotten && !this.paused && !this.packageQueue.isEmpty()) {
            ActivityPackage remove = this.packageQueue.remove(0);
            int retries = remove.getRetries();
            e eVar = new e(remove);
            long waitTime = waitTime(retries);
            if (waitTime > 0) {
                this.scheduler.schedule(eVar, waitTime);
            } else {
                eVar.run();
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendSdkClickI(ActivityPackage activityPackage) {
        String str;
        Boolean bool;
        Boolean bool2;
        String str2;
        long j11;
        String str3;
        long j12;
        long j13;
        String str4;
        ActivityPackage activityPackage2 = activityPackage;
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        String str5 = activityPackage.getParameters().get("source");
        boolean z11 = str5 != null && str5.equals("reftag");
        String str6 = activityPackage.getParameters().get("raw_referrer");
        if (!z11 || SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext()).getRawReferrer(str6, activityPackage.getClickTimeInMilliseconds()) != null) {
            boolean z12 = str5 != null && str5.equals("install_referrer");
            long j14 = -1;
            if (z12) {
                j14 = activityPackage.getClickTimeInSeconds();
                j12 = activityPackage.getInstallBeginTimeInSeconds();
                str3 = activityPackage.getParameters().get(Constants.REFERRER);
                j11 = activityPackage.getClickTimeServerInSeconds();
                long installBeginTimeServerInSeconds = activityPackage.getInstallBeginTimeServerInSeconds();
                String installVersion = activityPackage.getInstallVersion();
                Boolean googlePlayInstant = activityPackage.getGooglePlayInstant();
                Boolean isClick = activityPackage.getIsClick();
                str = activityPackage.getParameters().get("referrer_api");
                j13 = installBeginTimeServerInSeconds;
                str2 = installVersion;
                bool2 = googlePlayInstant;
                bool = isClick;
            } else {
                j13 = -1;
                j11 = -1;
                str3 = null;
                str2 = null;
                bool2 = null;
                bool = null;
                str = null;
                j12 = -1;
            }
            long j15 = j13;
            boolean z13 = str5 != null && str5.equals(Constants.PREINSTALL);
            ResponseData sendActivityPackageSync = this.activityPackageSender.sendActivityPackageSync(activityPackage2, generateSendingParametersI());
            if (sendActivityPackageSync instanceof SdkClickResponseData) {
                SdkClickResponseData sdkClickResponseData = (SdkClickResponseData) sendActivityPackageSync;
                if (sdkClickResponseData.willRetry) {
                    retrySendingI(activityPackage2, sdkClickResponseData.retryIn);
                    return;
                }
                boolean z14 = z13;
                this.lastPackageRetryInMilli = 0;
                if (iActivityHandler != null) {
                    if (sdkClickResponseData.trackingState == TrackingState.OPTED_OUT) {
                        iActivityHandler.gotOptOutResponse();
                        return;
                    }
                    if (z11) {
                        SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext()).removeRawReferrer(str6, activityPackage.getClickTimeInMilliseconds());
                    }
                    if (z12) {
                        sdkClickResponseData.clickTime = j14;
                        sdkClickResponseData.installBegin = j12;
                        sdkClickResponseData.installReferrer = str3;
                        sdkClickResponseData.clickTimeServer = j11;
                        sdkClickResponseData.installBeginServer = j15;
                        sdkClickResponseData.installVersion = str2;
                        sdkClickResponseData.googlePlayInstant = bool2;
                        sdkClickResponseData.isClick = bool;
                        sdkClickResponseData.referrerApi = str;
                        sdkClickResponseData.isInstallReferrer = true;
                    }
                    if (z14 && (str4 = activityPackage.getParameters().get("found_location")) != null && !str4.isEmpty()) {
                        SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext());
                        if (Constants.SYSTEM_INSTALLER_REFERRER.equalsIgnoreCase(str4)) {
                            defaultInstance.removePreinstallReferrer();
                        } else {
                            defaultInstance.setPreinstallPayloadReadStatus(PreinstallUtil.markAsRead(str4, defaultInstance.getPreinstallPayloadReadStatus()));
                        }
                    }
                    iActivityHandler.finishedTrackingActivity(sdkClickResponseData);
                }
            }
        }
    }

    private long waitTime(int i11) {
        long j11 = this.lastPackageRetryInMilli;
        if (j11 > 0) {
            return j11;
        }
        if (i11 <= 0) {
            return 0;
        }
        long waitingTime = Util.getWaitingTime(i11, this.backoffStrategy);
        String format = Util.SecondsDisplayFormat.format(((double) waitingTime) / MILLISECONDS_TO_SECONDS_DIVISOR);
        this.logger.verbose("Waiting for %s seconds before retrying sdk_click for the %d time", format, Integer.valueOf(i11));
        return waitingTime;
    }

    public void init(IActivityHandler iActivityHandler, boolean z11, IActivityPackageSender iActivityPackageSender) {
        this.paused = !z11;
        this.packageQueue = new ArrayList();
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.activityPackageSender = iActivityPackageSender;
    }

    public void pauseSending() {
        this.paused = true;
    }

    public void resumeSending() {
        this.paused = false;
        sendNextSdkClick();
    }

    public void sendPreinstallPayload(String str, String str2) {
        this.scheduler.submit(new c(str, str2));
    }

    public void sendReftagReferrers() {
        this.scheduler.submit(new b());
    }

    public void sendSdkClick(ActivityPackage activityPackage) {
        this.scheduler.submit(new a(activityPackage));
    }

    public void teardown() {
        this.logger.verbose("SdkClickHandler teardown", new Object[0]);
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            list.clear();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.logger = null;
        this.packageQueue = null;
        this.backoffStrategy = null;
        this.scheduler = null;
    }
}
