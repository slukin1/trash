package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.BuildConfig;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CrashlyticsCore {
    public static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    public static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    public static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    public static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 3;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    public static final int MAX_STACK_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin";
    public static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    private static final String ON_DEMAND_DROPPED_KEY = "com.crashlytics.on-demand.dropped-exceptions";
    private static final String ON_DEMAND_RECORDED_KEY = "com.crashlytics.on-demand.recorded-exceptions";
    private final AnalyticsEventLogger analyticsEventLogger;
    private final FirebaseApp app;
    private final CrashlyticsBackgroundWorker backgroundWorker;
    public final BreadcrumbSource breadcrumbSource;
    private final Context context;
    /* access modifiers changed from: private */
    public CrashlyticsController controller;
    private final ExecutorService crashHandlerExecutor;
    private CrashlyticsFileMarker crashMarker;
    private final DataCollectionArbiter dataCollectionArbiter;
    private boolean didCrashOnPreviousExecution;
    private final FileStore fileStore;
    private final IdManager idManager;
    /* access modifiers changed from: private */
    public CrashlyticsFileMarker initializationMarker;
    private final CrashlyticsNativeComponent nativeComponent;
    private final OnDemandCounter onDemandCounter = new OnDemandCounter();
    private final CrashlyticsAppQualitySessionsSubscriber sessionsSubscriber;
    private final long startTime = System.currentTimeMillis();

    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager2, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter2, BreadcrumbSource breadcrumbSource2, AnalyticsEventLogger analyticsEventLogger2, FileStore fileStore2, ExecutorService executorService, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber) {
        this.app = firebaseApp;
        this.dataCollectionArbiter = dataCollectionArbiter2;
        this.context = firebaseApp.getApplicationContext();
        this.idManager = idManager2;
        this.nativeComponent = crashlyticsNativeComponent;
        this.breadcrumbSource = breadcrumbSource2;
        this.analyticsEventLogger = analyticsEventLogger2;
        this.crashHandlerExecutor = executorService;
        this.fileStore = fileStore2;
        this.backgroundWorker = new CrashlyticsBackgroundWorker(executorService);
        this.sessionsSubscriber = crashlyticsAppQualitySessionsSubscriber;
    }

    private void checkForPreviousCrash() {
        try {
            this.didCrashOnPreviousExecution = Boolean.TRUE.equals((Boolean) Utils.awaitEvenIfOnMainThread(this.backgroundWorker.submit(new Callable<Boolean>() {
                public Boolean call() throws Exception {
                    return Boolean.valueOf(CrashlyticsCore.this.controller.didCrashOnPreviousExecution());
                }
            })));
        } catch (Exception unused) {
            this.didCrashOnPreviousExecution = false;
        }
    }

    /* access modifiers changed from: private */
    public Task<Void> doBackgroundInitialization(SettingsProvider settingsProvider) {
        markInitializationStarted();
        try {
            this.breadcrumbSource.registerBreadcrumbHandler(new d(this));
            this.controller.saveVersionControlInfo();
            if (!settingsProvider.getSettingsSync().featureFlagData.collectReports) {
                Logger.getLogger().d("Collection of crash reports disabled in Crashlytics settings.");
                return Tasks.forException(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.controller.finalizeSessions(settingsProvider)) {
                Logger.getLogger().w("Previous sessions could not be finalized.");
            }
            Task<Void> submitAllReports = this.controller.submitAllReports(settingsProvider.getSettingsAsync());
            markInitializationComplete();
            return submitAllReports;
        } catch (Exception e11) {
            Logger.getLogger().e("Crashlytics encountered a problem during asynchronous initialization.", e11);
            return Tasks.forException(e11);
        } finally {
            markInitializationComplete();
        }
    }

    private void finishInitSynchronously(final SettingsProvider settingsProvider) {
        Future<?> submit = this.crashHandlerExecutor.submit(new Runnable() {
            public void run() {
                Task unused = CrashlyticsCore.this.doBackgroundInitialization(settingsProvider);
            }
        });
        Logger.getLogger().d("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e11) {
            Logger.getLogger().e("Crashlytics was interrupted during initialization.", e11);
        } catch (ExecutionException e12) {
            Logger.getLogger().e("Crashlytics encountered a problem during initialization.", e12);
        } catch (TimeoutException e13) {
            Logger.getLogger().e("Crashlytics timed out during initialization.", e13);
        }
    }

    public static String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static boolean isBuildIdValid(String str, boolean z11) {
        if (!z11) {
            Logger.getLogger().v("Configured not to require a build ID.");
            return true;
        } else if (!TextUtils.isEmpty(str)) {
            return true;
        } else {
            Log.e(Logger.TAG, InstructionFileId.DOT);
            Log.e(Logger.TAG, ".     |  | ");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".   \\ |  | /");
            Log.e(Logger.TAG, ".    \\    /");
            Log.e(Logger.TAG, ".     \\  /");
            Log.e(Logger.TAG, ".      \\/");
            Log.e(Logger.TAG, InstructionFileId.DOT);
            Log.e(Logger.TAG, MISSING_BUILD_ID_MSG);
            Log.e(Logger.TAG, InstructionFileId.DOT);
            Log.e(Logger.TAG, ".      /\\");
            Log.e(Logger.TAG, ".     /  \\");
            Log.e(Logger.TAG, ".    /    \\");
            Log.e(Logger.TAG, ".   / |  | \\");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, InstructionFileId.DOT);
            return false;
        }
    }

    public Task<Boolean> checkForUnsentReports() {
        return this.controller.checkForUnsentReports();
    }

    public Task<Void> deleteUnsentReports() {
        return this.controller.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.didCrashOnPreviousExecution;
    }

    public boolean didPreviousInitializationFail() {
        return this.initializationMarker.isPresent();
    }

    public Task<Void> doBackgroundInitializationAsync(final SettingsProvider settingsProvider) {
        return Utils.callTask(this.crashHandlerExecutor, new Callable<Task<Void>>() {
            public Task<Void> call() throws Exception {
                return CrashlyticsCore.this.doBackgroundInitialization(settingsProvider);
            }
        });
    }

    public CrashlyticsController getController() {
        return this.controller;
    }

    public void log(String str) {
        this.controller.writeToLog(System.currentTimeMillis() - this.startTime, str);
    }

    public void logException(Throwable th2) {
        this.controller.writeNonFatalException(Thread.currentThread(), th2);
    }

    public void logFatalException(Throwable th2) {
        Logger logger = Logger.getLogger();
        logger.d("Recorded on-demand fatal events: " + this.onDemandCounter.getRecordedOnDemandExceptions());
        Logger logger2 = Logger.getLogger();
        logger2.d("Dropped on-demand fatal events: " + this.onDemandCounter.getDroppedOnDemandExceptions());
        this.controller.setInternalKey(ON_DEMAND_RECORDED_KEY, Integer.toString(this.onDemandCounter.getRecordedOnDemandExceptions()));
        this.controller.setInternalKey(ON_DEMAND_DROPPED_KEY, Integer.toString(this.onDemandCounter.getDroppedOnDemandExceptions()));
        this.controller.logFatalException(Thread.currentThread(), th2);
    }

    public void markInitializationComplete() {
        this.backgroundWorker.submit(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                try {
                    boolean remove = CrashlyticsCore.this.initializationMarker.remove();
                    if (!remove) {
                        Logger.getLogger().w("Initialization marker file was not properly removed.");
                    }
                    return Boolean.valueOf(remove);
                } catch (Exception e11) {
                    Logger.getLogger().e("Problem encountered deleting Crashlytics initialization marker.", e11);
                    return Boolean.FALSE;
                }
            }
        });
    }

    public void markInitializationStarted() {
        this.backgroundWorker.checkRunningOnThread();
        this.initializationMarker.create();
        Logger.getLogger().v("Initialization marker file was created.");
    }

    public boolean onPreExecute(AppData appData, SettingsProvider settingsProvider) {
        SettingsProvider settingsProvider2 = settingsProvider;
        if (isBuildIdValid(appData.buildId, CommonUtils.getBooleanResourceValue(this.context, CRASHLYTICS_REQUIRE_BUILD_ID, true))) {
            String clsuuid = new CLSUUID(this.idManager).toString();
            try {
                this.crashMarker = new CrashlyticsFileMarker(CRASH_MARKER_FILE_NAME, this.fileStore);
                this.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, this.fileStore);
                UserMetadata userMetadata = new UserMetadata(clsuuid, this.fileStore, this.backgroundWorker);
                LogFileManager logFileManager = new LogFileManager(this.fileStore);
                MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
                SessionReportingCoordinator create = SessionReportingCoordinator.create(this.context, this.idManager, this.fileStore, appData, logFileManager, userMetadata, middleOutFallbackStrategy, settingsProvider, this.onDemandCounter, this.sessionsSubscriber);
                Context context2 = this.context;
                CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = this.backgroundWorker;
                IdManager idManager2 = this.idManager;
                DataCollectionArbiter dataCollectionArbiter2 = this.dataCollectionArbiter;
                FileStore fileStore2 = this.fileStore;
                CrashlyticsFileMarker crashlyticsFileMarker = this.crashMarker;
                String str = clsuuid;
                Context context3 = context2;
                CrashlyticsBackgroundWorker crashlyticsBackgroundWorker2 = crashlyticsBackgroundWorker;
                IdManager idManager3 = idManager2;
                DataCollectionArbiter dataCollectionArbiter3 = dataCollectionArbiter2;
                FileStore fileStore3 = fileStore2;
                CrashlyticsFileMarker crashlyticsFileMarker2 = crashlyticsFileMarker;
                AppData appData2 = appData;
                this.controller = new CrashlyticsController(context3, crashlyticsBackgroundWorker2, idManager3, dataCollectionArbiter3, fileStore3, crashlyticsFileMarker2, appData2, userMetadata, logFileManager, create, this.nativeComponent, this.analyticsEventLogger, this.sessionsSubscriber);
                boolean didPreviousInitializationFail = didPreviousInitializationFail();
                checkForPreviousCrash();
                this.controller.enableExceptionHandling(str, Thread.getDefaultUncaughtExceptionHandler(), settingsProvider2);
                if (!didPreviousInitializationFail || !CommonUtils.canTryConnection(this.context)) {
                    Logger.getLogger().d("Successfully configured exception handler.");
                    return true;
                }
                Logger.getLogger().d("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                finishInitSynchronously(settingsProvider2);
                return false;
            } catch (Exception e11) {
                Logger.getLogger().e("Crashlytics was not started due to an exception during initialization", e11);
                this.controller = null;
                return false;
            }
        } else {
            throw new IllegalStateException(MISSING_BUILD_ID_MSG);
        }
    }

    public Task<Void> sendUnsentReports() {
        return this.controller.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(Boolean bool) {
        this.dataCollectionArbiter.setCrashlyticsDataCollectionEnabled(bool);
    }

    public void setCustomKey(String str, String str2) {
        this.controller.setCustomKey(str, str2);
    }

    public void setCustomKeys(Map<String, String> map) {
        this.controller.setCustomKeys(map);
    }

    public void setInternalKey(String str, String str2) {
        this.controller.setInternalKey(str, str2);
    }

    public void setUserId(String str) {
        this.controller.setUserId(str);
    }
}
