package g3;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import com.bbc876219.lib.hook.CrashUtils;
import com.bbc876219.lib.task.TaskManager;
import com.bbc876219.lib.task.Worker;
import com.bbc876219.lib.zlog.Log;
import com.iproov.sdk.bridge.OptionsBridge;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class a implements InvocationHandler {

    /* renamed from: b  reason: collision with root package name */
    public Object f15823b;

    /* renamed from: g3.a$a  reason: collision with other inner class name */
    public class C0082a extends Worker {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object[] f15824c;

        public C0082a(Object[] objArr) {
            this.f15824c = objArr;
        }

        public void a() {
            a.this.b(this.f15824c);
        }
    }

    public a(Object obj) {
        this.f15823b = obj;
    }

    public final void b(Object[] objArr) {
        String str;
        Bundle bundle = objArr[1];
        Bundle bundle2 = objArr[2];
        Activity c11 = c(objArr[0]);
        if (Build.VERSION.SDK_INT >= 21) {
            CrashUtils.b(c11, bundle);
            CrashUtils.b(c11, bundle2);
            return;
        }
        String str2 = OptionsBridge.NULL_VALUE;
        if (bundle == null) {
            str = str2;
        } else {
            str = bundle.toString();
        }
        if (bundle2 != null) {
            str2 = bundle2.toString();
        }
        Log.b("ActivityManagerServiceP", "stateBundleMessage=" + str + ",persistentStateBundleMessage=" + str2);
    }

    public final Activity c(Object obj) {
        try {
            Object obj2 = b.f15827b;
            Activity activity = (Activity) b.f15826a.getDeclaredMethod("getActivity", new Class[]{Class.forName("android.os.IBinder")}).invoke(obj2, new Object[]{obj});
            Log.b("ActivityManagerServiceP", activity.toString() + "call activityStopped");
            return activity;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        android.util.Log.d("ActivityManagerServiceP", "invoke() called with: , method = [" + method + "], args = [" + objArr + "]");
        if ("isTopOfTask".equals(method.getName()) || "unbindService".equals(method.getName()) || "finishReceiver".equals(method.getName()) || "publishService".equals(method.getName()) || "serviceDoneExecuting".equals(method.getName())) {
            try {
                return method.invoke(this.f15823b, objArr);
            } catch (Throwable th2) {
                CrashUtils.e(th2);
                return Boolean.FALSE;
            }
        } else if ("bindService".equals(method.getName())) {
            try {
                return method.invoke(this.f15823b, objArr);
            } catch (Throwable th3) {
                CrashUtils.e(th3);
                return 0;
            }
        } else if ("getRunningAppProcesses".equals(method.getName()) || "getTasks".equals(method.getName())) {
            try {
                return method.invoke(this.f15823b, objArr);
            } catch (Throwable th4) {
                if (CrashUtils.c(th4)) {
                    CrashUtils.e(th4);
                    return new ArrayList();
                }
                throw th4;
            }
        } else if ("removeContentProvider".equals(method.getName()) || "reportSizeConfigurations".equals(method.getName()) || "reportAssistContextExtras".equals(method.getName()) || "getMemoryInfo".equals(method.getName())) {
            try {
                return method.invoke(this.f15823b, objArr);
            } catch (Throwable th5) {
                if (CrashUtils.c(th5)) {
                    CrashUtils.e(th5);
                    return null;
                }
                throw th5;
            }
        } else {
            if ("activityStopped".equals(method.getName())) {
                TaskManager.f(new C0082a(objArr));
            }
            return method.invoke(this.f15823b, objArr);
        }
    }
}
