package io.flutter.plugins.firebase.core;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlutterFirebaseCorePlugin implements FlutterPlugin, GeneratedAndroidFirebaseCore.FirebaseCoreHostApi, GeneratedAndroidFirebaseCore.FirebaseAppHostApi {
    private Context applicationContext;
    private boolean coreInitialized = false;

    private Task<GeneratedAndroidFirebaseCore.PigeonInitializeResponse> firebaseAppToMap(FirebaseApp firebaseApp) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new d(this, firebaseApp, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private GeneratedAndroidFirebaseCore.PigeonFirebaseOptions firebaseOptionsToMap(FirebaseOptions firebaseOptions) {
        GeneratedAndroidFirebaseCore.PigeonFirebaseOptions.Builder builder = new GeneratedAndroidFirebaseCore.PigeonFirebaseOptions.Builder();
        builder.setApiKey(firebaseOptions.getApiKey());
        builder.setAppId(firebaseOptions.getApplicationId());
        if (firebaseOptions.getGcmSenderId() != null) {
            builder.setMessagingSenderId(firebaseOptions.getGcmSenderId());
        }
        if (firebaseOptions.getProjectId() != null) {
            builder.setProjectId(firebaseOptions.getProjectId());
        }
        builder.setDatabaseURL(firebaseOptions.getDatabaseUrl());
        builder.setStorageBucket(firebaseOptions.getStorageBucket());
        builder.setTrackingId(firebaseOptions.getGaTrackingId());
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$delete$7(String str, TaskCompletionSource taskCompletionSource) {
        try {
            try {
                FirebaseApp.getInstance(str).delete();
            } catch (IllegalStateException unused) {
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$firebaseAppToMap$0(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        try {
            GeneratedAndroidFirebaseCore.PigeonInitializeResponse.Builder builder = new GeneratedAndroidFirebaseCore.PigeonInitializeResponse.Builder();
            builder.setName(firebaseApp.getName());
            builder.setOptions(firebaseOptionsToMap(firebaseApp.getOptions()));
            builder.setIsAutomaticDataCollectionEnabled(Boolean.valueOf(firebaseApp.isDataCollectionDefaultEnabled()));
            builder.setPluginConstants((Map) Tasks.await(FlutterFirebasePluginRegistry.getPluginConstantsForFirebaseApp(firebaseApp)));
            taskCompletionSource.setResult(builder.build());
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$initializeApp$2(io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.PigeonFirebaseOptions r3, java.lang.String r4, com.google.android.gms.tasks.TaskCompletionSource r5) {
        /*
            r2 = this;
            com.google.firebase.FirebaseOptions$Builder r0 = new com.google.firebase.FirebaseOptions$Builder     // Catch:{ Exception -> 0x0058 }
            r0.<init>()     // Catch:{ Exception -> 0x0058 }
            java.lang.String r1 = r3.getApiKey()     // Catch:{ Exception -> 0x0058 }
            com.google.firebase.FirebaseOptions$Builder r0 = r0.setApiKey(r1)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r1 = r3.getAppId()     // Catch:{ Exception -> 0x0058 }
            com.google.firebase.FirebaseOptions$Builder r0 = r0.setApplicationId(r1)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r1 = r3.getDatabaseURL()     // Catch:{ Exception -> 0x0058 }
            com.google.firebase.FirebaseOptions$Builder r0 = r0.setDatabaseUrl(r1)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r1 = r3.getMessagingSenderId()     // Catch:{ Exception -> 0x0058 }
            com.google.firebase.FirebaseOptions$Builder r0 = r0.setGcmSenderId(r1)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r1 = r3.getProjectId()     // Catch:{ Exception -> 0x0058 }
            com.google.firebase.FirebaseOptions$Builder r0 = r0.setProjectId(r1)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r1 = r3.getStorageBucket()     // Catch:{ Exception -> 0x0058 }
            com.google.firebase.FirebaseOptions$Builder r0 = r0.setStorageBucket(r1)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r3 = r3.getTrackingId()     // Catch:{ Exception -> 0x0058 }
            com.google.firebase.FirebaseOptions$Builder r3 = r0.setGaTrackingId(r3)     // Catch:{ Exception -> 0x0058 }
            com.google.firebase.FirebaseOptions r3 = r3.build()     // Catch:{ Exception -> 0x0058 }
            android.os.Looper.prepare()     // Catch:{ Exception -> 0x0044 }
        L_0x0044:
            android.content.Context r0 = r2.applicationContext     // Catch:{ Exception -> 0x0058 }
            com.google.firebase.FirebaseApp r3 = com.google.firebase.FirebaseApp.initializeApp(r0, r3, r4)     // Catch:{ Exception -> 0x0058 }
            com.google.android.gms.tasks.Task r3 = r2.firebaseAppToMap(r3)     // Catch:{ Exception -> 0x0058 }
            java.lang.Object r3 = com.google.android.gms.tasks.Tasks.await(r3)     // Catch:{ Exception -> 0x0058 }
            io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$PigeonInitializeResponse r3 = (io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.PigeonInitializeResponse) r3     // Catch:{ Exception -> 0x0058 }
            r5.setResult(r3)     // Catch:{ Exception -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r3 = move-exception
            r5.setException(r3)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin.lambda$initializeApp$2(io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$PigeonFirebaseOptions, java.lang.String, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeCore$3(TaskCompletionSource taskCompletionSource) {
        try {
            if (!this.coreInitialized) {
                this.coreInitialized = true;
            } else {
                Tasks.await(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
            }
            List<FirebaseApp> apps = FirebaseApp.getApps(this.applicationContext);
            ArrayList arrayList = new ArrayList(apps.size());
            for (FirebaseApp firebaseAppToMap : apps) {
                arrayList.add((GeneratedAndroidFirebaseCore.PigeonInitializeResponse) Tasks.await(firebaseAppToMap(firebaseAppToMap)));
            }
            taskCompletionSource.setResult(arrayList);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$listenToResponse$1(GeneratedAndroidFirebaseCore.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
        } else {
            result.error(task.getException());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$optionsFromResource$4(TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseOptions fromResource = FirebaseOptions.fromResource(this.applicationContext);
            if (fromResource == null) {
                taskCompletionSource.setResult(null);
            } else {
                taskCompletionSource.setResult(firebaseOptionsToMap(fromResource));
            }
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setAutomaticDataCollectionEnabled$5(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseApp.getInstance(str).setDataCollectionDefaultEnabled(bool);
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setAutomaticResourceManagementEnabled$6(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseApp.getInstance(str).setAutomaticResourceManagementEnabled(bool.booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    private <T> void listenToResponse(TaskCompletionSource<T> taskCompletionSource, GeneratedAndroidFirebaseCore.Result<T> result) {
        taskCompletionSource.getTask().addOnCompleteListener(new a(result));
    }

    public void delete(String str, GeneratedAndroidFirebaseCore.Result<Void> result) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new f(str, taskCompletionSource));
        listenToResponse(taskCompletionSource, result);
    }

    public void initializeApp(String str, GeneratedAndroidFirebaseCore.PigeonFirebaseOptions pigeonFirebaseOptions, GeneratedAndroidFirebaseCore.Result<GeneratedAndroidFirebaseCore.PigeonInitializeResponse> result) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new e(this, pigeonFirebaseOptions, str, taskCompletionSource));
        listenToResponse(taskCompletionSource, result);
    }

    public void initializeCore(GeneratedAndroidFirebaseCore.Result<List<GeneratedAndroidFirebaseCore.PigeonInitializeResponse>> result) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new b(this, taskCompletionSource));
        listenToResponse(taskCompletionSource, result);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.CC.h(flutterPluginBinding.getBinaryMessenger(), this);
        GeneratedAndroidFirebaseCore.FirebaseAppHostApi.CC.h(flutterPluginBinding.getBinaryMessenger(), this);
        this.applicationContext = flutterPluginBinding.getApplicationContext();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.applicationContext = null;
        GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.CC.h(flutterPluginBinding.getBinaryMessenger(), (GeneratedAndroidFirebaseCore.FirebaseCoreHostApi) null);
        GeneratedAndroidFirebaseCore.FirebaseAppHostApi.CC.h(flutterPluginBinding.getBinaryMessenger(), (GeneratedAndroidFirebaseCore.FirebaseAppHostApi) null);
    }

    public void optionsFromResource(GeneratedAndroidFirebaseCore.Result<GeneratedAndroidFirebaseCore.PigeonFirebaseOptions> result) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new c(this, taskCompletionSource));
        listenToResponse(taskCompletionSource, result);
    }

    public void setAutomaticDataCollectionEnabled(String str, Boolean bool, GeneratedAndroidFirebaseCore.Result<Void> result) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new g(str, bool, taskCompletionSource));
        listenToResponse(taskCompletionSource, result);
    }

    public void setAutomaticResourceManagementEnabled(String str, Boolean bool, GeneratedAndroidFirebaseCore.Result<Void> result) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new h(str, bool, taskCompletionSource));
        listenToResponse(taskCompletionSource, result);
    }
}
