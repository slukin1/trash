package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.BuildIdInfo;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.inject.Deferred;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.FirebaseSessions;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class FirebaseCrashlytics {
    public static final int APP_EXCEPTION_CALLBACK_TIMEOUT_MS = 500;
    public static final String FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN = "clx";
    public static final String LEGACY_CRASH_ANALYTICS_ORIGIN = "crash";
    public final CrashlyticsCore core;

    private FirebaseCrashlytics(CrashlyticsCore crashlyticsCore) {
        this.core = crashlyticsCore;
    }

    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        Objects.requireNonNull(firebaseCrashlytics, "FirebaseCrashlytics component is not present.");
        return firebaseCrashlytics;
    }

    public static FirebaseCrashlytics init(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseSessions firebaseSessions, Deferred<CrashlyticsNativeComponent> deferred, Deferred<AnalyticsConnector> deferred2) {
        Context applicationContext = firebaseApp.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        Logger logger = Logger.getLogger();
        logger.i("Initializing Firebase Crashlytics " + CrashlyticsCore.getVersion() + " for " + packageName);
        FileStore fileStore = new FileStore(applicationContext);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        IdManager idManager = new IdManager(applicationContext, packageName, firebaseInstallationsApi, dataCollectionArbiter);
        CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy = new CrashlyticsNativeComponentDeferredProxy(deferred);
        AnalyticsDeferredProxy analyticsDeferredProxy = new AnalyticsDeferredProxy(deferred2);
        ExecutorService buildSingleThreadExecutorService = ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler");
        CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber = new CrashlyticsAppQualitySessionsSubscriber(dataCollectionArbiter, fileStore);
        firebaseSessions.register(crashlyticsAppQualitySessionsSubscriber);
        BreadcrumbSource deferredBreadcrumbSource = analyticsDeferredProxy.getDeferredBreadcrumbSource();
        AnalyticsEventLogger analyticsEventLogger = analyticsDeferredProxy.getAnalyticsEventLogger();
        CrashlyticsCore crashlyticsCore = r4;
        CrashlyticsCore crashlyticsCore2 = new CrashlyticsCore(firebaseApp, idManager, crashlyticsNativeComponentDeferredProxy, dataCollectionArbiter, deferredBreadcrumbSource, analyticsEventLogger, fileStore, buildSingleThreadExecutorService, crashlyticsAppQualitySessionsSubscriber);
        String applicationId = firebaseApp.getOptions().getApplicationId();
        String mappingFileId = CommonUtils.getMappingFileId(applicationContext);
        List<BuildIdInfo> buildIdInfo = CommonUtils.getBuildIdInfo(applicationContext);
        Logger logger2 = Logger.getLogger();
        logger2.d("Mapping file ID is: " + mappingFileId);
        for (BuildIdInfo next : buildIdInfo) {
            Logger.getLogger().d(String.format("Build id for %s on %s: %s", new Object[]{next.getLibraryName(), next.getArch(), next.getBuildId()}));
        }
        final CrashlyticsCore crashlyticsCore3 = crashlyticsCore;
        IdManager idManager2 = idManager;
        try {
            AppData create = AppData.create(applicationContext, idManager, applicationId, mappingFileId, buildIdInfo, new DevelopmentPlatformProvider(applicationContext));
            Logger logger3 = Logger.getLogger();
            logger3.v("Installer package name is: " + create.installerPackageName);
            ExecutorService buildSingleThreadExecutorService2 = ExecutorUtils.buildSingleThreadExecutorService("com.google.firebase.crashlytics.startup");
            final SettingsController create2 = SettingsController.create(applicationContext, applicationId, idManager2, new HttpRequestFactory(), create.versionCode, create.versionName, fileStore, dataCollectionArbiter);
            create2.loadSettingsData(buildSingleThreadExecutorService2).continueWith(buildSingleThreadExecutorService2, new Continuation<Void, Object>() {
                public Object then(Task<Void> task) throws Exception {
                    if (task.isSuccessful()) {
                        return null;
                    }
                    Logger.getLogger().e("Error fetching settings.", task.getException());
                    return null;
                }
            });
            final boolean onPreExecute = crashlyticsCore3.onPreExecute(create, create2);
            Tasks.call(buildSingleThreadExecutorService2, new Callable<Void>() {
                public Void call() throws Exception {
                    if (!onPreExecute) {
                        return null;
                    }
                    crashlyticsCore3.doBackgroundInitializationAsync(create2);
                    return null;
                }
            });
            return new FirebaseCrashlytics(crashlyticsCore3);
        } catch (PackageManager.NameNotFoundException e11) {
            Logger.getLogger().e("Error retrieving app package info.", e11);
            return null;
        }
    }

    public Task<Boolean> checkForUnsentReports() {
        return this.core.checkForUnsentReports();
    }

    public void deleteUnsentReports() {
        this.core.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.core.didCrashOnPreviousExecution();
    }

    public void log(String str) {
        this.core.log(str);
    }

    public void recordException(Throwable th2) {
        if (th2 == null) {
            Logger.getLogger().w("A null value was passed to recordException. Ignoring.");
        } else {
            this.core.logException(th2);
        }
    }

    public void sendUnsentReports() {
        this.core.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(boolean z11) {
        this.core.setCrashlyticsCollectionEnabled(Boolean.valueOf(z11));
    }

    public void setCustomKey(String str, boolean z11) {
        this.core.setCustomKey(str, Boolean.toString(z11));
    }

    public void setCustomKeys(CustomKeysAndValues customKeysAndValues) {
        this.core.setCustomKeys(customKeysAndValues.keysAndValues);
    }

    public void setUserId(String str) {
        this.core.setUserId(str);
    }

    public void setCrashlyticsCollectionEnabled(Boolean bool) {
        this.core.setCrashlyticsCollectionEnabled(bool);
    }

    public void setCustomKey(String str, double d11) {
        this.core.setCustomKey(str, Double.toString(d11));
    }

    public void setCustomKey(String str, float f11) {
        this.core.setCustomKey(str, Float.toString(f11));
    }

    public void setCustomKey(String str, int i11) {
        this.core.setCustomKey(str, Integer.toString(i11));
    }

    public void setCustomKey(String str, long j11) {
        this.core.setCustomKey(str, Long.toString(j11));
    }

    public void setCustomKey(String str, String str2) {
        this.core.setCustomKey(str, str2);
    }
}
