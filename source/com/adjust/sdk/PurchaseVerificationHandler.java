package com.adjust.sdk;

import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseVerificationHandler implements IPurchaseVerificationHandler {
    private static final double MILLISECONDS_TO_SECONDS_DIVISOR = 1000.0d;
    private static final String SCHEDULED_EXECUTOR_SOURCE = "PurchaseVerificationHandler";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
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
        public final /* synthetic */ ActivityPackage f13930a;

        public a(ActivityPackage activityPackage) {
            this.f13930a = activityPackage;
        }

        public final void run() {
            PurchaseVerificationHandler.this.packageQueue.add(this.f13930a);
            PurchaseVerificationHandler.this.logger.debug("Added purchase_verification %d", Integer.valueOf(PurchaseVerificationHandler.this.packageQueue.size()));
            PurchaseVerificationHandler.this.logger.verbose("%s", this.f13930a.getExtendedString());
            PurchaseVerificationHandler.this.sendNextPurchaseVerificationPackage();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            PurchaseVerificationHandler.this.sendNextPurchaseVerificationPackageI();
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ActivityPackage f13933a;

        public c(ActivityPackage activityPackage) {
            this.f13933a = activityPackage;
        }

        public final void run() {
            PurchaseVerificationHandler.this.sendPurchaseVerificationPackageI(this.f13933a);
            PurchaseVerificationHandler.this.sendNextPurchaseVerificationPackage();
        }
    }

    public PurchaseVerificationHandler(IActivityHandler iActivityHandler, boolean z11, IActivityPackageSender iActivityPackageSender) {
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

    private void retrySendingI(ActivityPackage activityPackage, Long l11) {
        if (l11 == null || l11.longValue() <= 0) {
            int increaseRetries = activityPackage.increaseRetries();
            this.logger.error("Retrying purchase_verification package for the %d time", Integer.valueOf(increaseRetries));
        } else {
            this.lastPackageRetryInMilli = l11.longValue();
        }
        sendPurchaseVerificationPackage(activityPackage);
    }

    /* access modifiers changed from: private */
    public void sendNextPurchaseVerificationPackage() {
        this.scheduler.submit(new b());
    }

    /* access modifiers changed from: private */
    public void sendNextPurchaseVerificationPackageI() {
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler.getActivityState() != null && !iActivityHandler.getActivityState().isGdprForgotten && !this.paused && !this.packageQueue.isEmpty()) {
            ActivityPackage remove = this.packageQueue.remove(0);
            int retries = remove.getRetries();
            c cVar = new c(remove);
            long waitTime = waitTime(retries);
            if (waitTime > 0) {
                this.scheduler.schedule(cVar, waitTime);
            } else {
                cVar.run();
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendPurchaseVerificationPackageI(ActivityPackage activityPackage) {
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        ResponseData sendActivityPackageSync = this.activityPackageSender.sendActivityPackageSync(activityPackage, generateSendingParametersI());
        if (sendActivityPackageSync instanceof PurchaseVerificationResponseData) {
            PurchaseVerificationResponseData purchaseVerificationResponseData = (PurchaseVerificationResponseData) sendActivityPackageSync;
            if (purchaseVerificationResponseData.willRetry) {
                retrySendingI(activityPackage, sendActivityPackageSync.retryIn);
                return;
            }
            this.lastPackageRetryInMilli = 0;
            if (iActivityHandler != null) {
                if (purchaseVerificationResponseData.trackingState == TrackingState.OPTED_OUT) {
                    iActivityHandler.gotOptOutResponse();
                } else {
                    iActivityHandler.finishedTrackingActivity(purchaseVerificationResponseData);
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
        this.logger.verbose("Waiting for %s seconds before retrying purchase_verification for the %d time", format, Integer.valueOf(i11));
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
        sendNextPurchaseVerificationPackage();
    }

    public void sendPurchaseVerificationPackage(ActivityPackage activityPackage) {
        this.scheduler.submit(new a(activityPackage));
    }

    public void teardown() {
        this.logger.verbose("PurchaseVerificationHandler teardown", new Object[0]);
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
