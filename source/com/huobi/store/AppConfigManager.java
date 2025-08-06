package com.huobi.store;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mmkv.MMKV;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import js.a;

public class AppConfigManager {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f81291a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final List<WeakReference<a>> f81292b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f81293c = true;

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, BusinessLine> f81294d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public static MMKV f81295e = null;

    public static void a() {
        if (f81295e == null) {
            if (MMKV.getRootDir() == null && f81293c) {
                Log.d("AppConfig", "You should Call MMKV.initialize() first.");
            }
            MMKV mmkvWithID = MMKV.mmkvWithID("app_config_data_new");
            f81295e = mmkvWithID;
            String[] allKeys = mmkvWithID.allKeys();
            if (allKeys != null && allKeys.length > 0) {
                for (String str : allKeys) {
                    String decodeString = f81295e.decodeString(str, "");
                    if (f81293c) {
                        Log.d("AppConfig", "static initializer() called mmkv key=" + str + "  value=" + decodeString);
                    }
                    if (!TextUtils.isEmpty(decodeString)) {
                        f81294d.put(Integer.valueOf(str), GsonHelper.a().fromJson(decodeString, BusinessLine.class));
                    }
                }
            }
            f81291a = true;
            if (f81293c) {
                Log.d("AppConfig", "static initializer() called initLocalConfig() called sucessed map.size=" + f81294d.size());
            }
        }
    }

    public static <T> int b(int i11, String str, int i12, Class<T> cls) {
        if (!f81291a) {
            a();
        }
        if (!f81291a) {
            throw new IllegalArgumentException("app config service not init!!");
        } else if (TextUtils.isEmpty(str)) {
            return i12;
        } else {
            ConcurrentHashMap<Integer, BusinessLine> concurrentHashMap = f81294d;
            if (!concurrentHashMap.containsKey(Integer.valueOf(i11))) {
                return i12;
            }
            return BusinessLineHelper.d(concurrentHashMap.get(Integer.valueOf(i11)), str, i12, cls);
        }
    }

    public static <T> T c(int i11, Class<T> cls) {
        if (!f81291a) {
            a();
        }
        if (!f81291a) {
            throw new IllegalArgumentException("app config service not init!!");
        } else if (cls == null) {
            return null;
        } else {
            ConcurrentHashMap<Integer, BusinessLine> concurrentHashMap = f81294d;
            if (!concurrentHashMap.containsKey(Integer.valueOf(i11))) {
                return null;
            }
            return BusinessLineHelper.a(concurrentHashMap.get(Integer.valueOf(i11)), cls);
        }
    }

    public static <T> T d(int i11, Type type) {
        if (!f81291a) {
            a();
        }
        if (!f81291a) {
            throw new IllegalArgumentException("app config service not init!!");
        } else if (type == null) {
            return null;
        } else {
            ConcurrentHashMap<Integer, BusinessLine> concurrentHashMap = f81294d;
            if (!concurrentHashMap.containsKey(Integer.valueOf(i11))) {
                return null;
            }
            return BusinessLineHelper.b(concurrentHashMap.get(Integer.valueOf(i11)), type);
        }
    }

    public static <T> String e(int i11, String str, String str2, Class<T> cls) {
        if (!f81291a) {
            a();
        }
        if (!f81291a) {
            throw new IllegalArgumentException("app config service not init!!");
        } else if (TextUtils.isEmpty(str)) {
            return str2;
        } else {
            ConcurrentHashMap<Integer, BusinessLine> concurrentHashMap = f81294d;
            if (!concurrentHashMap.containsKey(Integer.valueOf(i11))) {
                return str2;
            }
            return BusinessLineHelper.f(concurrentHashMap.get(Integer.valueOf(i11)), str, str2, cls);
        }
    }

    public static <T> boolean f(int i11, String str, boolean z11, Class<T> cls) {
        if (!f81291a) {
            a();
        }
        if (!f81291a) {
            throw new IllegalArgumentException("app config service not init!!");
        } else if (TextUtils.isEmpty(str)) {
            return z11;
        } else {
            ConcurrentHashMap<Integer, BusinessLine> concurrentHashMap = f81294d;
            if (!concurrentHashMap.containsKey(Integer.valueOf(i11))) {
                return z11;
            }
            return BusinessLineHelper.c(concurrentHashMap.get(Integer.valueOf(i11)), str, z11, cls);
        }
    }

    public static boolean g(int i11, String str) {
        if (!f81291a) {
            a();
        }
        if (f81291a) {
            return h(i11, str, false);
        }
        throw new IllegalArgumentException("app config service not init!!");
    }

    public static boolean h(int i11, String str, boolean z11) {
        if (!f81291a) {
            a();
        }
        if (f81291a) {
            return f(i11, str, z11, (Class) null);
        }
        throw new IllegalArgumentException("app config service not init!!");
    }

    public static int i(int i11, String str) {
        if (!f81291a) {
            a();
        }
        if (f81291a) {
            return j(i11, str, 0);
        }
        throw new IllegalArgumentException("app config service not init!!");
    }

    public static int j(int i11, String str, int i12) {
        if (!f81291a) {
            a();
        }
        if (f81291a) {
            return b(i11, str, i12, (Class) null);
        }
        throw new IllegalArgumentException("app config service not init!!");
    }

    public static <T> List<T> k(int i11, Class<T> cls) {
        if (!f81291a) {
            a();
        }
        if (!f81291a) {
            throw new IllegalArgumentException("app config service not init!!");
        } else if (cls == null) {
            return null;
        } else {
            ConcurrentHashMap<Integer, BusinessLine> concurrentHashMap = f81294d;
            if (!concurrentHashMap.containsKey(Integer.valueOf(i11))) {
                return null;
            }
            return BusinessLineHelper.e(concurrentHashMap.get(Integer.valueOf(i11)), cls);
        }
    }

    public static String l(int i11, String str, String str2) {
        if (!f81291a) {
            a();
        }
        if (f81291a) {
            return e(i11, str, str2, (Class) null);
        }
        throw new IllegalArgumentException("app config service not init!!");
    }

    public static void m(List<AppConfig> list) {
        if (list == null || list.isEmpty()) {
            Log.d("AppConfig", "initLoad() called with: 没有数据 jsonArray = [" + list + "]");
            return;
        }
        if (f81295e == null) {
            a();
        }
        for (AppConfig next : list) {
            f81294d.put(Integer.valueOf(next.number), next.data);
            f81295e.putString(String.valueOf(next.number), GsonHelper.a().toJson((Object) next.data));
        }
        BusinessLineHelper.f81296a.clear();
        BusinessLineHelper.f81297b.clear();
        f81291a = true;
        if (!f81294d.isEmpty()) {
            n();
        }
    }

    public static void n() {
        if (f81293c) {
            Log.d("AppConfig", "netChangeNotification() called");
        }
        for (WeakReference next : f81292b) {
            if (next.get() != null) {
                ((a) next.get()).a(f81294d.get(Integer.valueOf(((a) next.get()).getId())));
            }
        }
    }

    public static void o(a aVar) {
        if (f81293c) {
            Log.d("AppConfig", "registerOnChangeListener() called with: listener = [" + aVar + "]");
        }
        if (aVar != null) {
            for (WeakReference<a> weakReference : f81292b) {
                if (((a) weakReference.get()).getId() == aVar.getId()) {
                    if (f81293c) {
                        Log.d("AppConfig", "registerOnChangeListener() called with: 已经有id是 " + aVar.getId() + " 的 listener!!!");
                        return;
                    }
                    return;
                }
            }
            f81292b.add(new WeakReference(aVar));
        }
    }

    public static void p(boolean z11) {
        f81293c = z11;
    }
}
