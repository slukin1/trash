package com.tencent.tpns.baseapi.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CacheHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, SharedPreferences> f49845a = new ConcurrentHashMap();

    /* renamed from: com.tencent.tpns.baseapi.core.a.a$a  reason: collision with other inner class name */
    public static class C0630a {

        /* renamed from: a  reason: collision with root package name */
        private static Handler f49848a;

        /* renamed from: b  reason: collision with root package name */
        private static final Object f49849b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private static final LinkedList<Runnable> f49850c = new LinkedList<>();

        /* renamed from: d  reason: collision with root package name */
        private static boolean f49851d = true;

        /* renamed from: e  reason: collision with root package name */
        private static final Object f49852e = new Object();

        /* renamed from: com.tencent.tpns.baseapi.core.a.a$a$a  reason: collision with other inner class name */
        public static class C0631a extends Handler {
            public C0631a(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    CommonWorkingThread.getInstance().execute(new TTask() {
                        public void TRun() {
                            C0630a.c();
                        }
                    });
                }
            }
        }

        private static Handler b() {
            if (f49848a == null) {
                synchronized (f49849b) {
                    if (f49848a == null) {
                        f49848a = new C0631a(Looper.getMainLooper());
                    }
                }
            }
            return f49848a;
        }

        /* access modifiers changed from: private */
        public static void c() {
            LinkedList linkedList;
            try {
                System.currentTimeMillis();
                synchronized (f49852e) {
                    synchronized (f49849b) {
                        LinkedList<Runnable> linkedList2 = f49850c;
                        linkedList = (LinkedList) linkedList2.clone();
                        linkedList2.clear();
                        Handler b11 = b();
                        if (b11 != null) {
                            b11.removeMessages(1);
                        }
                    }
                    if (linkedList.size() > 0) {
                        Iterator it2 = linkedList.iterator();
                        while (it2.hasNext()) {
                            ((Runnable) it2.next()).run();
                        }
                    }
                }
            } catch (Throwable th2) {
                TBaseLogger.w("Sp", "sp commit task error, " + th2.getMessage());
            }
        }

        public static void a(Runnable runnable, boolean z11) {
            try {
                Handler b11 = b();
                if (b11 != null) {
                    synchronized (f49849b) {
                        f49850c.add(runnable);
                        if (!z11 || !f49851d) {
                            b11.sendEmptyMessage(1);
                        } else {
                            b11.sendEmptyMessageDelayed(1, 100);
                        }
                    }
                }
            } catch (Throwable th2) {
                TBaseLogger.w("Sp", "sp task add queue failed, " + th2.getMessage());
            }
        }
    }

    private static void b(Context context, String str) {
    }

    public static void b(Context context, CacheHelper.Key<?>... keyArr) {
        if (keyArr != null && keyArr.length > 0) {
            a(context, false, keyArr);
        }
    }

    private static SharedPreferences c(Context context, String str) {
        Context context2 = TGlobalHelper.getContext(context);
        if (context2 == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            context2.getSharedPreferences(str, 4);
        }
        return context2.getSharedPreferences(str, 0);
    }

    /* access modifiers changed from: private */
    public static SharedPreferences d(Context context, String str) {
        Context context2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, SharedPreferences> map = f49845a;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences != null || (context2 = TGlobalHelper.getContext(context)) == null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context2.getSharedPreferences(str, 0);
        map.put(str, sharedPreferences2);
        b(context2, str);
        return sharedPreferences2;
    }

    public static void a(Context context, CacheHelper.Key<?>... keyArr) {
        if (keyArr != null && keyArr.length > 0) {
            if (a()) {
                TBaseLogger.d("Sp", "main thread, async sp set");
                a(context, true, keyArr);
                return;
            }
            b(context, keyArr);
        }
    }

    public static <T> T b(Context context, CacheHelper.Key<T> key) {
        T a11 = a(d(context, key.file), key.name, key.value);
        if (a11 == null && key.multiProcess) {
            a11 = a(c(context, key.file), key.name, key.value);
        }
        if (a11 == null) {
            return null;
        }
        key.set(a11);
        return a11;
    }

    /* access modifiers changed from: private */
    public static <T> void b(SharedPreferences.Editor editor, String str, T t11) {
        if (editor == null) {
            return;
        }
        if (t11 == null) {
            editor.remove(str);
        } else if (t11 instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t11).booleanValue());
        } else if (t11 instanceof String) {
            editor.putString(str, (String) t11);
        } else if (t11 instanceof Integer) {
            editor.putInt(str, ((Integer) t11).intValue());
        } else if (t11 instanceof Long) {
            editor.putLong(str, ((Long) t11).longValue());
        } else if (t11 instanceof Float) {
            editor.putFloat(str, ((Float) t11).floatValue());
        }
    }

    private static boolean a() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th2) {
            TBaseLogger.w("Sp", "[isMainThread] failed:" + th2.getMessage());
            return true;
        }
    }

    private static void a(final Context context, boolean z11, final CacheHelper.Key<?>... keyArr) {
        try {
            AnonymousClass1 r02 = new TTask() {
                public void TRun() {
                    SharedPreferences a11;
                    try {
                        HashMap hashMap = new HashMap();
                        for (CacheHelper.Key key : keyArr) {
                            SharedPreferences.Editor editor = (SharedPreferences.Editor) hashMap.get(key.file);
                            if (editor == null && (a11 = a.d(context, key.file)) != null) {
                                editor = a11.edit();
                                hashMap.put(key.file, editor);
                            }
                            a.b(editor, key.name, key.value);
                        }
                        for (String str : hashMap.keySet()) {
                            SharedPreferences.Editor editor2 = (SharedPreferences.Editor) hashMap.get(str);
                            if (editor2 != null && !editor2.commit()) {
                                TBaseLogger.w("Sp", "sp commit failed, sp_file: " + str);
                            }
                        }
                    } catch (Throwable th2) {
                        TBaseLogger.w("Sp", "sp commit failed, " + th2.getMessage());
                    }
                }
            };
            if (z11) {
                C0630a.a(r02, false);
            } else {
                r02.run();
            }
        } catch (Throwable unused) {
        }
    }

    public static <T> T a(Context context, CacheHelper.Key<T> key) {
        T b11 = b(context, key);
        if (b11 != null) {
            return b11;
        }
        return key.value;
    }

    private static <T> T a(SharedPreferences sharedPreferences, String str, T t11) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                if (t11 instanceof Boolean) {
                    return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t11).booleanValue()));
                }
                if (t11 instanceof String) {
                    return sharedPreferences.getString(str, (String) t11);
                }
                if (t11 instanceof Integer) {
                    return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) t11).intValue()));
                }
                if (t11 instanceof Long) {
                    return Long.valueOf(sharedPreferences.getLong(str, ((Long) t11).longValue()));
                }
                if (t11 instanceof Float) {
                    return Float.valueOf(sharedPreferences.getFloat(str, ((Float) t11).floatValue()));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
