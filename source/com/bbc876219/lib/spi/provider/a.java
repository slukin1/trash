package com.bbc876219.lib.spi.provider;

import android.text.TextUtils;
import com.bbc876219.lib.spi.provider.utils.HookMethodEnum;
import com.bbc876219.lib.spi.provider.utils.ProcessUtils;
import com.bbc876219.lib.utils.reflection.ReflectionUtils;
import com.bbc876219.lib.zlog.Log;
import com.google.common.collect.ImmutableMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, ImmutableMap<Class<?>, b>> f63197a = new HashMap<>();

    /* renamed from: com.bbc876219.lib.spi.provider.a$a  reason: collision with other inner class name */
    public static class C0696a {

        /* renamed from: m  reason: collision with root package name */
        public static String f63198m = ProcessUtils.a();

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f63199a;

        /* renamed from: b  reason: collision with root package name */
        public int f63200b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f63201c;

        /* renamed from: d  reason: collision with root package name */
        public String f63202d;

        /* renamed from: e  reason: collision with root package name */
        public int f63203e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63204f;

        /* renamed from: g  reason: collision with root package name */
        public Object f63205g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f63206h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f63207i;

        /* renamed from: j  reason: collision with root package name */
        public Class[] f63208j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f63209k;

        /* renamed from: l  reason: collision with root package name */
        public String[] f63210l;

        public boolean a(String str) {
            String[] strArr = this.f63201c;
            if (strArr != null && strArr.length > 0) {
                for (String equals : strArr) {
                    if (equals.equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean b() {
            String[] strArr = this.f63201c;
            return strArr != null && strArr.length > 0;
        }

        public boolean c() {
            if (!((f3.a) a.e(f3.a.class)).b()) {
                return !this.f63209k;
            }
            return true;
        }

        public boolean d() {
            Class cls = f3.a.class;
            String[] strArr = this.f63210l;
            if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(f63198m)) {
                return true;
            }
            for (String str : this.f63210l) {
                if (f63198m.endsWith(str)) {
                    return true;
                }
                if (str.contains(":")) {
                    if (str.equals(":main") && f63198m.equals(Boolean.valueOf(((f3.a) a.e(cls)).c()))) {
                        return true;
                    }
                    if ((((f3.a) a.e(cls)).a().getPackageName() + str).equals(f63198m)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public String toString() {
            return "HookMethod{cla=" + this.f63199a + ", sdk=" + this.f63200b + ", points=" + Arrays.toString(this.f63201c) + ", appids='" + this.f63202d + '\'' + ", index=" + this.f63203e + ", isCacheIns=" + this.f63204f + ", isHookBefore=" + this.f63206h + ", isHookAfter=" + this.f63207i + ", onlyDebug=" + this.f63209k + ", isRunInDebug=" + c() + ", processName=" + f63198m + ", process=" + Arrays.toString(this.f63210l) + ", isRunInProcess=" + d() + ", isHookAfter=" + this.f63207i + ", ins=" + this.f63205g + ", dependencies=" + Arrays.toString(this.f63208j) + '}';
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f63211a;

        /* renamed from: b  reason: collision with root package name */
        public String f63212b;

        /* renamed from: c  reason: collision with root package name */
        public int f63213c;

        /* renamed from: d  reason: collision with root package name */
        public String f63214d;

        /* renamed from: e  reason: collision with root package name */
        public Object f63215e;
    }

    public static void a(C0696a aVar, Object obj) {
        if (aVar.f63204f && obj != null) {
            aVar.f63205g = obj;
        }
    }

    public static <T> void b(String str, List<T> list, C0696a aVar) {
        if (aVar.b() || TextUtils.isEmpty(str)) {
            list.add(aVar.f63205g);
        } else if (aVar.a(str)) {
            list.add(aVar.f63205g);
        }
    }

    public static <T> void c(String str, List<T> list, C0696a aVar) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        if (!aVar.f63204f || aVar.f63205g == null) {
            Object d11 = d(str, aVar, (Object) null);
            a(aVar, d11);
            if (d11 != null) {
                list.add(d11);
                return;
            }
            return;
        }
        b(str, list, aVar);
    }

    public static Object d(String str, C0696a aVar, Object obj) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        if (aVar.b() || TextUtils.isEmpty(str)) {
            Constructor<?> declaredConstructor = aVar.f63199a.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } else if (!aVar.a(str)) {
            return obj;
        } else {
            Constructor<?> declaredConstructor2 = aVar.f63199a.getDeclaredConstructor(new Class[0]);
            declaredConstructor2.setAccessible(true);
            return declaredConstructor2.newInstance(new Object[0]);
        }
    }

    public static <T> T e(Class<T> cls) {
        b bVar = ServiceCollection.serviceclasses.get(cls);
        if (bVar != null) {
            return g(cls, bVar);
        }
        Log.h("ServiceProvider", cls.getName() + "不能从ServiceCollection获取到实现类的实例,因为这个app里没有ServiceDesc对象");
        h();
        if (!f63197a.isEmpty()) {
            for (ImmutableMap next : f63197a.values()) {
                if (((b) next.get(cls)) != null) {
                    return g(cls, (b) next.get(cls));
                }
            }
        }
        return f(cls);
    }

    public static <T> T f(Class<T> cls) {
        Log.h("ServiceProvider", "getDefIns() called with: key = [" + cls + "]");
        return null;
    }

    public static <T> T g(Class<T> cls, b bVar) {
        if (TextUtils.isEmpty(bVar.f63214d) || bVar.f63214d.contains(ServiceCollection.AppId)) {
            int i11 = bVar.f63213c;
            if (i11 <= 0 || i11 >= ServiceCollection.SdkVersin) {
                T t11 = bVar.f63215e;
                if (t11 != null) {
                    return t11;
                }
                Class<?> cls2 = bVar.f63211a;
                if (cls2 != null) {
                    try {
                        T newInstance = cls2.newInstance();
                        bVar.f63215e = newInstance;
                        return newInstance;
                    } catch (Exception e11) {
                        Log.i("ServiceProvider", bVar.f63211a.getName() + " could not be initialized\n", e11);
                    }
                }
                if (!TextUtils.isEmpty(bVar.f63212b)) {
                    try {
                        Class<?> cls3 = Class.forName(bVar.f63212b);
                        bVar.f63211a = cls3;
                        T newInstance2 = cls3.newInstance();
                        bVar.f63215e = newInstance2;
                        return newInstance2;
                    } catch (Throwable th2) {
                        Log.i("ServiceProvider", bVar.f63212b + " could not be initialized\n", th2);
                    }
                }
                return f(cls);
            }
            Log.h("ServiceProvider", cls.getName() + "不能获取到实现类的实例,因为这个实现不支持这个app:" + bVar.f63213c + "   |   " + ServiceCollection.SdkVersin);
            return f(cls);
        }
        Log.h("ServiceProvider", cls.getName() + "不能获取到实现类的实例,因为这个实现不支持这个app:" + bVar.f63214d + "   |   " + ServiceCollection.AppId);
        return f(cls);
    }

    public static void h() {
        Set<String> set = ServiceCollection.dynamicCollection;
        if (set != null && !set.isEmpty() && f63197a.isEmpty()) {
            for (String next : ServiceCollection.dynamicCollection) {
                Class<?> a11 = ReflectionUtils.a(next);
                if (a11 != null) {
                    try {
                        ImmutableMap immutableMap = (ImmutableMap) ReflectionUtils.f(a11, "serviceclasses");
                        if (immutableMap != null) {
                            f63197a.put(next, immutableMap);
                        }
                    } catch (NoSuchFieldException e11) {
                        e11.printStackTrace();
                    } catch (IllegalAccessException e12) {
                        e12.printStackTrace();
                    }
                }
            }
        }
    }

    public static <T> List<T> i(Class<T> cls) {
        return j(cls, "", HookMethodEnum.HOOK_ALL);
    }

    public static <T> List<T> j(Class<T> cls, String str, HookMethodEnum hookMethodEnum) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        if (cls == null) {
            return arrayList;
        }
        int i11 = 0;
        if (!TextUtils.isEmpty(str)) {
            String str2 = cls.getName() + ".class||" + str;
            if (ServiceCollection.keyList.containsKey(str2)) {
                List<C0696a> list = ServiceCollection.keyList.get(str2);
                Log.b("ServiceProvider", "list() called with: newkey = [" + str2 + "], classes.size = [" + list.size() + "]");
                try {
                    list = k(list, hookMethodEnum);
                } catch (Exception e11) {
                    Log.d("ServiceProvider", "sortIndexList", e11);
                }
                while (i11 < list.size()) {
                    C0696a aVar = list.get(i11);
                    try {
                        Log.b("ServiceProvider", "implclass [" + aVar + "]");
                        if (aVar.f63200b >= ServiceCollection.SdkVersin && ((TextUtils.isEmpty(aVar.f63202d) || aVar.f63202d.contains(ServiceCollection.AppId)) && aVar.d() && aVar.c())) {
                            c(str, arrayList, aVar);
                        }
                    } catch (Exception e12) {
                        Log.d("ServiceProvider", aVar.f63199a.getName() + " could not be initialized\n", e12);
                    }
                    i11++;
                }
            }
            return arrayList;
        }
        if (ServiceCollection.keyList.containsKey(cls)) {
            List<C0696a> list2 = ServiceCollection.keyList.get(cls);
            try {
                list2 = k(list2, hookMethodEnum);
            } catch (Exception e13) {
                Log.d("ServiceProvider", "sortIndexList", e13);
            }
            while (i11 < list2.size()) {
                C0696a aVar2 = list2.get(i11);
                try {
                    if (aVar2.f63200b >= ServiceCollection.SdkVersin && ((TextUtils.isEmpty(aVar2.f63202d) || aVar2.f63202d.contains(ServiceCollection.AppId)) && aVar2.d() && aVar2.c())) {
                        c(str, arrayList, aVar2);
                    }
                } catch (Exception e14) {
                    Log.d("ServiceProvider", aVar2.f63199a.getName() + " could not be initialized\n", e14);
                }
                i11++;
            }
        } else if (ServiceCollection.serviceclasses.containsKey(cls)) {
            arrayList.add(e(cls));
        }
        l(currentTimeMillis, "List( key=" + cls.getName() + "  ,hookPoint=" + str + ")", 10);
        return arrayList;
    }

    public static List<C0696a> k(List<C0696a> list, HookMethodEnum hookMethodEnum) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            C0696a aVar = list.get(i11);
            if ((hookMethodEnum != HookMethodEnum.HOOK_AFTER || aVar.f63207i) && (hookMethodEnum != HookMethodEnum.HOOK_BEFORE || aVar.f63206h)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static void l(long j11, String str, int i11) {
        long currentTimeMillis = System.currentTimeMillis() - j11;
        if (currentTimeMillis > ((long) i11)) {
            Log.c("ServiceProvider", str + "statisCost=" + currentTimeMillis + "ms");
        }
    }
}
