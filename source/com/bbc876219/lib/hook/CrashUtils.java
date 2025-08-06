package com.bbc876219.lib.hook;

import android.content.Context;
import android.os.BaseBundle;
import android.os.DeadObjectException;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.widget.Toast;
import com.bbc876219.lib.task.TaskManager;
import com.bbc876219.lib.task.Worker;
import com.bbc876219.lib.zlog.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

public class CrashUtils {

    public static class a extends Worker {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f15597c;

        public a(Context context) {
            this.f15597c = context;
        }

        public void a() {
            Toast.makeText(this.f15597c.getApplicationContext(), "This is a crash report for the TooLargeException, Please check the log for details", 1).show();
        }
    }

    public static int a(String str, Object obj) {
        Parcel obtain = Parcel.obtain();
        obtain.writeValue(obj);
        int dataPosition = obtain.dataPosition();
        obtain.recycle();
        Log.b("CrashUtils", "key = " + str + ",value=" + obj + ",size=" + dataPosition);
        return dataPosition;
    }

    public static void b(Context context, BaseBundle baseBundle) {
        if (baseBundle != null) {
            try {
                Field declaredField = BaseBundle.class.getDeclaredField("mMap");
                declaredField.setAccessible(true);
                long j11 = 0;
                ArrayMap arrayMap = (ArrayMap) declaredField.get(baseBundle);
                for (int i11 = 0; i11 < arrayMap.size(); i11++) {
                    long a11 = (long) a((String) arrayMap.keyAt(i11), arrayMap.valueAt(i11));
                    j11 += a11;
                    Log.b("CrashUtils", "dumpStats--> key = " + ((String) arrayMap.keyAt(i11)) + ", byteCount = " + a11);
                }
                Log.b("CrashUtils", "binder proxy total size = " + j11);
                if (context != null && j11 >= 204800) {
                    Log.c("CrashUtils", "This is a crash report for the TooLargeException, Please check the log for details");
                    TaskManager.g(new a(context));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static boolean c(Throwable th2) {
        if (th2 instanceof Exception) {
            Exception exc = (Exception) th2;
            if ((exc instanceof DeadObjectException) || (exc instanceof UndeclaredThrowableException) || (exc instanceof InvocationTargetException) || (exc instanceof RemoteException)) {
                return true;
            }
        }
        if (!(th2 instanceof RuntimeException)) {
            return false;
        }
        RuntimeException runtimeException = (RuntimeException) th2;
        Throwable cause = runtimeException.getCause();
        String message = runtimeException.getMessage();
        if (!TextUtils.isEmpty(message) && message.contains("Package manager has died")) {
            return true;
        }
        if (cause == null) {
            return false;
        }
        if (!(cause instanceof DeadObjectException) && !(cause instanceof UndeclaredThrowableException) && !(cause instanceof InvocationTargetException) && !(cause instanceof RemoteException)) {
            return false;
        }
        return true;
    }

    public static void d(String str) {
        Log.c("CrashUtils", "logException: " + str);
    }

    public static void e(Throwable th2) {
        Log.d("CrashUtils", "logException: ", th2);
    }
}
