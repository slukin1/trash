package io.flutter.plugins.firebase.crashlytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.FlutterFirebaseCrashlyticsInternal;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FlutterFirebaseCrashlyticsPlugin implements FlutterFirebasePlugin, FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final String TAG = "FLTFirebaseCrashlytics";
    private MethodChannel channel;

    private Task<Map<String, Object>> checkForUnsentReports() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new i(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private void crash() {
        new Handler(Looper.myLooper()).postDelayed(d.f55208b, 50);
    }

    private Task<Void> deleteUnsentReports() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new g(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task<Map<String, Object>> didCrashOnPreviousExecution() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new h(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private StackTraceElement generateStackTraceElement(Map<String, String> map) {
        try {
            String str = map.get("file");
            String str2 = map.get(Constants.LINE);
            String str3 = map.get(Constants.CLASS);
            String str4 = map.get("method");
            if (str3 == null) {
                str3 = "";
            }
            Objects.requireNonNull(str2);
            return new StackTraceElement(str3, str4, str, Integer.parseInt(str2));
        } catch (Exception unused) {
            Log.e(TAG, "Unable to generate stack trace element from Dart error.");
            return null;
        }
    }

    private SharedPreferences getCrashlyticsSharedPrefs(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    private void initInstance(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/firebase_crashlytics");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_crashlytics", this);
    }

    /* access modifiers changed from: private */
    public boolean isCrashlyticsCollectionEnabled(FirebaseApp firebaseApp) {
        SharedPreferences crashlyticsSharedPrefs = getCrashlyticsSharedPrefs(firebaseApp.getApplicationContext());
        if (crashlyticsSharedPrefs.contains("firebase_crashlytics_collection_enabled")) {
            return crashlyticsSharedPrefs.getBoolean("firebase_crashlytics_collection_enabled", true);
        }
        if (!firebaseApp.isDataCollectionDefaultEnabled()) {
            return false;
        }
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkForUnsentReports$0(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new HashMap<String, Object>(((Boolean) Tasks.await(FirebaseCrashlytics.getInstance().checkForUnsentReports())).booleanValue()) {
                public final /* synthetic */ boolean val$unsentReports;

                {
                    this.val$unsentReports = r2;
                    put(Constants.UNSENT_REPORTS, Boolean.valueOf(r2));
                }
            });
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$crash$1() {
        throw new FirebaseCrashlyticsTestCrash();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteUnsentReports$2(TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseCrashlytics.getInstance().deleteUnsentReports();
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$didCrashOnPreviousExecution$3(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new HashMap<String, Object>(FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution()) {
                public final /* synthetic */ boolean val$didCrashOnPreviousExecution;

                {
                    this.val$didCrashOnPreviousExecution = r2;
                    put(Constants.DID_CRASH_ON_PREVIOUS_EXECUTION, Boolean.valueOf(r2));
                }
            });
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$didReinitializeFirebaseCore$12(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getPluginConstantsForFirebaseApp$11(TaskCompletionSource taskCompletionSource, FirebaseApp firebaseApp) {
        try {
            taskCompletionSource.setResult(new HashMap<String, Object>(firebaseApp) {
                public final /* synthetic */ FirebaseApp val$firebaseApp;

                {
                    this.val$firebaseApp = r3;
                    if (r3.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                        put(Constants.IS_CRASHLYTICS_COLLECTION_ENABLED, Boolean.valueOf(FlutterFirebaseCrashlyticsPlugin.this.isCrashlyticsCollectionEnabled(FirebaseApp.getInstance())));
                    }
                }
            });
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$log$5(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get("message");
            Objects.requireNonNull(obj);
            FirebaseCrashlytics.getInstance().log((String) obj);
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onMethodCall$10(MethodChannel.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
            return;
        }
        Exception exception = task.getException();
        result.error("firebase_crashlytics", exception != null ? exception.getMessage() : "An unknown error occurred", (Object) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$recordError$4(Map map, TaskCompletionSource taskCompletionSource) {
        FlutterError flutterError;
        try {
            FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
            Object obj = map.get(Constants.EXCEPTION);
            Objects.requireNonNull(obj);
            String str = (String) obj;
            String str2 = (String) map.get(Constants.REASON);
            Object obj2 = map.get("information");
            Objects.requireNonNull(obj2);
            String str3 = (String) obj2;
            Object obj3 = map.get("fatal");
            Objects.requireNonNull(obj3);
            boolean booleanValue = ((Boolean) obj3).booleanValue();
            Object obj4 = map.get(Constants.BUILD_ID);
            Objects.requireNonNull(obj4);
            String str4 = (String) obj4;
            if (str4.length() > 0) {
                FlutterFirebaseCrashlyticsInternal.setFlutterBuildId(str4);
            }
            if (str2 != null) {
                instance.setCustomKey(Constants.FLUTTER_ERROR_REASON, "thrown " + str2);
                flutterError = new FlutterError(str + ". Error thrown " + str2 + InstructionFileId.DOT);
            } else {
                flutterError = new FlutterError(str);
            }
            instance.setCustomKey(Constants.FLUTTER_ERROR_EXCEPTION, str);
            ArrayList arrayList = new ArrayList();
            Object obj5 = map.get(Constants.STACK_TRACE_ELEMENTS);
            Objects.requireNonNull(obj5);
            for (Map generateStackTraceElement : (List) obj5) {
                StackTraceElement generateStackTraceElement2 = generateStackTraceElement(generateStackTraceElement);
                if (generateStackTraceElement2 != null) {
                    arrayList.add(generateStackTraceElement2);
                }
            }
            flutterError.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            if (!str3.isEmpty()) {
                instance.log(str3);
            }
            if (booleanValue) {
                FlutterFirebaseCrashlyticsInternal.recordFatalException(flutterError);
            } else {
                instance.recordException(flutterError);
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendUnsentReports$6(TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseCrashlytics.getInstance().sendUnsentReports();
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setCrashlyticsCollectionEnabled$7(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get(Constants.ENABLED);
            Objects.requireNonNull(obj);
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled((Boolean) obj);
            taskCompletionSource.setResult(new HashMap<String, Object>() {
                {
                    put(Constants.IS_CRASHLYTICS_COLLECTION_ENABLED, Boolean.valueOf(FlutterFirebaseCrashlyticsPlugin.this.isCrashlyticsCollectionEnabled(FirebaseApp.getInstance())));
                }
            });
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setCustomKey$9(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get("key");
            Objects.requireNonNull(obj);
            Object obj2 = map.get("value");
            Objects.requireNonNull(obj2);
            FirebaseCrashlytics.getInstance().setCustomKey((String) obj, (String) obj2);
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUserIdentifier$8(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get(Constants.IDENTIFIER);
            Objects.requireNonNull(obj);
            FirebaseCrashlytics.getInstance().setUserId((String) obj);
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    private Task<Void> log(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new b(map, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task<Void> recordError(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new k(this, map, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task<Void> sendUnsentReports() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new f(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task<Map<String, Object>> setCrashlyticsCollectionEnabled(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new l(this, map, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task<Void> setCustomKey(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new c(map, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task<Void> setUserIdentifier(Map<String, Object> map) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new m(map, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public Task<Void> didReinitializeFirebaseCore() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new e(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new j(this, taskCompletionSource, firebaseApp));
        return taskCompletionSource.getTask();
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
            this.channel = null;
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Task task;
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2094964816:
                if (str.equals("Crashlytics#didCrashOnPreviousExecution")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1437158995:
                if (str.equals("Crashlytics#recordError")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1025128541:
                if (str.equals("Crashlytics#checkForUnsentReports")) {
                    c11 = 2;
                    break;
                }
                break;
            case -424770276:
                if (str.equals("Crashlytics#sendUnsentReports")) {
                    c11 = 3;
                    break;
                }
                break;
            case -108157790:
                if (str.equals("Crashlytics#setCrashlyticsCollectionEnabled")) {
                    c11 = 4;
                    break;
                }
                break;
            case 28093114:
                if (str.equals("Crashlytics#log")) {
                    c11 = 5;
                    break;
                }
                break;
            case 108415030:
                if (str.equals("Crashlytics#setCustomKey")) {
                    c11 = 6;
                    break;
                }
                break;
            case 213629529:
                if (str.equals("Crashlytics#deleteUnsentReports")) {
                    c11 = 7;
                    break;
                }
                break;
            case 679831756:
                if (str.equals("Crashlytics#setUserIdentifier")) {
                    c11 = 8;
                    break;
                }
                break;
            case 1219454365:
                if (str.equals("Crashlytics#crash")) {
                    c11 = 9;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                task = didCrashOnPreviousExecution();
                break;
            case 1:
                task = recordError((Map) methodCall.arguments());
                break;
            case 2:
                task = checkForUnsentReports();
                break;
            case 3:
                task = sendUnsentReports();
                break;
            case 4:
                task = setCrashlyticsCollectionEnabled((Map) methodCall.arguments());
                break;
            case 5:
                task = log((Map) methodCall.arguments());
                break;
            case 6:
                task = setCustomKey((Map) methodCall.arguments());
                break;
            case 7:
                task = deleteUnsentReports();
                break;
            case 8:
                task = setUserIdentifier((Map) methodCall.arguments());
                break;
            case 9:
                crash();
                return;
            default:
                result.notImplemented();
                return;
        }
        task.addOnCompleteListener(new a(result));
    }
}
