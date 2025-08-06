package com.adjust.sdk;

import android.content.Context;
import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class PackageHandler implements IPackageHandler, IActivityPackageSender.ResponseDataCallbackSubscriber {
    private static final String PACKAGE_QUEUE_FILENAME = "AdjustIoPackageQueue";
    private static final String PACKAGE_QUEUE_NAME = "Package queue";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private IActivityPackageSender activityPackageSender;
    private BackoffStrategy backoffStrategy = AdjustFactory.getPackageHandlerBackoffStrategy();
    private BackoffStrategy backoffStrategyForInstallSession = AdjustFactory.getInstallSessionBackoffStrategy();
    private Context context;
    private boolean isRetrying = false;
    /* access modifiers changed from: private */
    public AtomicBoolean isSending;
    /* access modifiers changed from: private */
    public ILogger logger = AdjustFactory.getLogger();
    private List<ActivityPackage> packageQueue;
    private boolean paused;
    private long retryStartedAtTimeMilliSeconds;
    private ThreadScheduler scheduler = new SingleThreadCachedScheduler("PackageHandler");
    private double totalWaitTimeSeconds = 0.0d;

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            PackageHandler.this.initI();
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ActivityPackage f13922a;

        public b(ActivityPackage activityPackage) {
            this.f13922a = activityPackage;
        }

        public final void run() {
            PackageHandler.this.addI(this.f13922a);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public final void run() {
            PackageHandler.this.sendFirstI();
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ResponseData f13925a;

        public d(ResponseData responseData) {
            this.f13925a = responseData;
        }

        public final void run() {
            PackageHandler.this.sendNextI(this.f13925a.continueIn);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public final void run() {
            PackageHandler.this.logger.verbose("Package handler can send", new Object[0]);
            PackageHandler.this.isSending.set(false);
            PackageHandler.this.sendFirstPackage();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public final void run() {
            PackageHandler.this.flushI();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public final void run() {
            PackageHandler.this.logger.verbose("Package handler finished waiting to continue", new Object[0]);
            PackageHandler.this.isSending.set(false);
            PackageHandler.this.sendFirstPackage();
        }
    }

    public PackageHandler(IActivityHandler iActivityHandler, Context context2, boolean z11, IActivityPackageSender iActivityPackageSender) {
        init(iActivityHandler, context2, z11, iActivityPackageSender);
        this.scheduler.submit(new a());
    }

    /* access modifiers changed from: private */
    public void addI(ActivityPackage activityPackage) {
        if (this.isRetrying) {
            activityPackage.setWaitBeforeSendTimeSeconds(this.totalWaitTimeSeconds - (((double) (System.currentTimeMillis() - this.retryStartedAtTimeMilliSeconds)) / 1000.0d));
        }
        PackageBuilder.addLong(activityPackage.getParameters(), "enqueue_size", (long) this.packageQueue.size());
        this.packageQueue.add(activityPackage);
        this.logger.debug("Added package %d (%s)", Integer.valueOf(this.packageQueue.size()), activityPackage);
        this.logger.verbose("%s", activityPackage.getExtendedString());
        writePackageQueueI();
    }

    public static Boolean deletePackageQueue(Context context2) {
        return Boolean.valueOf(context2.deleteFile(PACKAGE_QUEUE_FILENAME));
    }

    public static void deleteState(Context context2) {
        deletePackageQueue(context2);
    }

    /* access modifiers changed from: private */
    public void flushI() {
        this.packageQueue.clear();
        writePackageQueueI();
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

    /* access modifiers changed from: private */
    public void initI() {
        this.isSending = new AtomicBoolean();
        readPackageQueueI();
    }

    private void readPackageQueueI() {
        try {
            this.packageQueue = (List) Util.readObject(this.context, PACKAGE_QUEUE_FILENAME, PACKAGE_QUEUE_NAME, List.class);
        } catch (Exception e11) {
            this.logger.error("Failed to read %s file (%s)", PACKAGE_QUEUE_NAME, e11.getMessage());
            this.packageQueue = null;
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            this.logger.debug("Package handler read %d packages", Integer.valueOf(list.size()));
            return;
        }
        this.packageQueue = new ArrayList();
    }

    /* access modifiers changed from: private */
    public void sendFirstI() {
        if (!this.packageQueue.isEmpty()) {
            if (this.paused) {
                this.logger.debug("Package handler is paused", new Object[0]);
            } else if (this.isSending.getAndSet(true)) {
                this.logger.verbose("Package handler is already sending", new Object[0]);
            } else {
                Map<String, String> generateSendingParametersI = generateSendingParametersI();
                ActivityPackage activityPackage = this.packageQueue.get(0);
                PackageBuilder.addLong(generateSendingParametersI, "retry_count", (long) activityPackage.getRetryCount());
                PackageBuilder.addLong(generateSendingParametersI, "first_error", (long) activityPackage.getFirstErrorCode());
                PackageBuilder.addLong(generateSendingParametersI, "last_error", (long) activityPackage.getLastErrorCode());
                PackageBuilder.addDouble(generateSendingParametersI, "wait_total", this.totalWaitTimeSeconds);
                PackageBuilder.addDouble(generateSendingParametersI, "wait_time", activityPackage.getWaitBeforeSendTimeSeconds());
                this.activityPackageSender.sendActivityPackage(activityPackage, generateSendingParametersI, this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendNextI(Long l11) {
        this.isRetrying = false;
        this.retryStartedAtTimeMilliSeconds = 0;
        if (this.packageQueue.isEmpty()) {
            this.totalWaitTimeSeconds = 0.0d;
            return;
        }
        this.packageQueue.remove(0);
        writePackageQueueI();
        if (l11 == null || l11.longValue() <= 0) {
            this.logger.verbose("Package handler can send", new Object[0]);
            this.isSending.set(false);
            sendFirstI();
            return;
        }
        g gVar = new g();
        this.logger.verbose("Waiting for %d seconds before continuing for next package in continue_in", Double.valueOf(((double) l11.longValue()) / 1000.0d));
        this.scheduler.schedule(gVar, l11.longValue());
    }

    private void writePackageQueueI() {
        Util.writeObject(this.packageQueue, this.context, PACKAGE_QUEUE_FILENAME, PACKAGE_QUEUE_NAME);
        this.logger.debug("Package handler wrote %d packages", Integer.valueOf(this.packageQueue.size()));
    }

    public void addPackage(ActivityPackage activityPackage) {
        this.scheduler.submit(new b(activityPackage));
    }

    public void flush() {
        this.scheduler.submit(new f());
    }

    public void init(IActivityHandler iActivityHandler, Context context2, boolean z11, IActivityPackageSender iActivityPackageSender) {
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.context = context2;
        this.paused = !z11;
        this.activityPackageSender = iActivityPackageSender;
    }

    public void onResponseDataCallback(ResponseData responseData) {
        this.logger.debug("Got response in PackageHandler", new Object[0]);
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler != null && responseData.trackingState == TrackingState.OPTED_OUT) {
            iActivityHandler.gotOptOutResponse();
        }
        if (!responseData.willRetry) {
            this.scheduler.submit(new d(responseData));
            if (iActivityHandler != null) {
                iActivityHandler.finishedTrackingActivity(responseData);
                return;
            }
            return;
        }
        if (!this.isRetrying) {
            this.isRetrying = true;
            this.retryStartedAtTimeMilliSeconds = System.currentTimeMillis();
        }
        writePackageQueueI();
        if (iActivityHandler != null) {
            iActivityHandler.finishedTrackingActivity(responseData);
        }
        e eVar = new e();
        Long l11 = responseData.retryIn;
        if (l11 != null) {
            this.scheduler.schedule(eVar, l11.longValue());
            return;
        }
        int increaseRetries = responseData.activityPackage.increaseRetries();
        long waitingTime = Util.getWaitingTime(increaseRetries, (responseData.activityPackage.getActivityKind() != ActivityKind.SESSION || SharedPreferencesManager.getDefaultInstance(this.context).getInstallTracked()) ? this.backoffStrategy : this.backoffStrategyForInstallSession);
        double d11 = ((double) waitingTime) / 1000.0d;
        String format = Util.SecondsDisplayFormat.format(d11);
        this.totalWaitTimeSeconds += d11;
        this.logger.verbose("Waiting for %s seconds before retrying %s for the %d time", format, responseData.activityPackage.getActivityKind().toString(), Integer.valueOf(increaseRetries));
        this.scheduler.schedule(eVar, waitingTime);
        ActivityPackage activityPackage = responseData.activityPackage;
        activityPackage.setWaitBeforeSendTimeSeconds(activityPackage.getWaitBeforeSendTimeSeconds() + d11);
    }

    public void pauseSending() {
        this.paused = true;
    }

    public void resumeSending() {
        this.paused = false;
    }

    public void sendFirstPackage() {
        this.scheduler.submit(new c());
    }

    public void teardown() {
        this.logger.verbose("PackageHandler teardown", new Object[0]);
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            list.clear();
        }
        this.scheduler = null;
        this.activityHandlerWeakRef = null;
        this.packageQueue = null;
        this.isSending = null;
        this.context = null;
        this.logger = null;
        this.backoffStrategy = null;
    }
}
