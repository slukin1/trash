package io.flutter.plugins.firebase.core;

import androidx.annotation.Keep;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

@Keep
public class FlutterFirebasePluginRegistry {
    private static final Map<String, FlutterFirebasePlugin> registeredPlugins = new WeakHashMap();

    public static Task<Void> didReinitializeFirebaseCore() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new i(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public static Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new j(firebaseApp, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$didReinitializeFirebaseCore$1(TaskCompletionSource taskCompletionSource) {
        try {
            for (Map.Entry<String, FlutterFirebasePlugin> value : registeredPlugins.entrySet()) {
                Tasks.await(((FlutterFirebasePlugin) value.getValue()).didReinitializeFirebaseCore());
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getPluginConstantsForFirebaseApp$0(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        try {
            Map<String, FlutterFirebasePlugin> map = registeredPlugins;
            HashMap hashMap = new HashMap(map.size());
            for (Map.Entry next : map.entrySet()) {
                hashMap.put((String) next.getKey(), Tasks.await(((FlutterFirebasePlugin) next.getValue()).getPluginConstantsForFirebaseApp(firebaseApp)));
            }
            taskCompletionSource.setResult(hashMap);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    public static void registerPlugin(String str, FlutterFirebasePlugin flutterFirebasePlugin) {
        registeredPlugins.put(str, flutterFirebasePlugin);
    }
}
