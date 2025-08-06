package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Class<?>, Service> f37542a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<Class<?>, Object> f37543b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<Class<?>, Service> f37544c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<Class<?>, Object> f37545d = new HashMap();

    public d(List<Service> list, Context context) {
        a(list, context);
    }

    private Object a(AGConnectInstance aGConnectInstance, Service service) {
        StringBuilder sb2;
        String str;
        if (service.getInstance() != null) {
            return service.getInstance();
        }
        Class<?> type = service.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor a11 = a((Class) type, Context.class, AGConnectInstance.class);
            if (a11 != null) {
                return a11.newInstance(new Object[]{aGConnectInstance.getContext(), aGConnectInstance});
            }
            Constructor a12 = a((Class) type, Context.class);
            if (a12 == null) {
                return type.newInstance();
            }
            return a12.newInstance(new Object[]{aGConnectInstance.getContext()});
        } catch (InstantiationException e11) {
            sb2 = new StringBuilder();
            sb2.append("Instantiate service exception ");
            str = e11.getLocalizedMessage();
            sb2.append(str);
            Log.e("AGC_ServiceRepository", sb2.toString());
            return null;
        } catch (InvocationTargetException e12) {
            sb2 = new StringBuilder();
            sb2.append("Instantiate service exception ");
            str = e12.getLocalizedMessage();
            sb2.append(str);
            Log.e("AGC_ServiceRepository", sb2.toString());
            return null;
        } catch (IllegalAccessException e13) {
            sb2 = new StringBuilder();
            sb2.append("Instantiate service exception ");
            str = e13.getLocalizedMessage();
            sb2.append(str);
            Log.e("AGC_ServiceRepository", sb2.toString());
            return null;
        }
    }

    private static Constructor a(Class cls, Class... clsArr) {
        boolean z11 = false;
        for (Constructor constructor : cls.getDeclaredConstructors()) {
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i11 = 0; i11 < clsArr.length; i11++) {
                    z11 = parameterTypes[i11] == clsArr[i11];
                }
                if (z11) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private void a(String str, Exception exc) {
        Log.e("AGC_ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cause message:");
        sb2.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
        Log.e("AGC_ServiceRepository", sb2.toString());
    }

    public <T> T a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t11;
        Service service = this.f37544c.get(cls);
        if (service == null && (service = f37542a.get(cls)) != null) {
            return f37543b.get(cls);
        }
        if (service == null) {
            return null;
        }
        if (service.isSingleton() && (t11 = this.f37545d.get(cls)) != null) {
            return t11;
        }
        T a11 = a(aGConnectInstance, service);
        if (a11 != null && service.isSingleton()) {
            this.f37545d.put(cls, a11);
        }
        return a11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062 A[Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b A[Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<com.huawei.agconnect.core.Service> r8, android.content.Context r9) {
        /*
            r7 = this;
            java.lang.String r0 = "AGC_ServiceRepository"
            java.lang.String r1 = "addService start"
            android.util.Log.d(r0, r1)
            if (r8 != 0) goto L_0x000a
            return
        L_0x000a:
            java.util.Iterator r8 = r8.iterator()
        L_0x000e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x008c
            java.lang.Object r1 = r8.next()
            com.huawei.agconnect.core.Service r1 = (com.huawei.agconnect.core.Service) r1
            boolean r2 = r1.isSharedInstance()
            if (r2 == 0) goto L_0x002f
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r2 = f37542a
            java.lang.Class r3 = r1.getInterface()
            boolean r2 = r2.containsKey(r3)
            if (r2 != 0) goto L_0x0038
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r2 = f37542a
            goto L_0x0031
        L_0x002f:
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r2 = r7.f37544c
        L_0x0031:
            java.lang.Class r3 = r1.getInterface()
            r2.put(r3, r1)
        L_0x0038:
            boolean r2 = r1.isAutoCreated()
            if (r2 == 0) goto L_0x000e
            java.lang.Class r2 = r1.getType()
            if (r2 == 0) goto L_0x000e
            java.util.Map<java.lang.Class<?>, java.lang.Object> r2 = f37543b
            java.lang.Class r3 = r1.getInterface()
            boolean r2 = r2.containsKey(r3)
            if (r2 != 0) goto L_0x000e
            java.lang.Class r2 = r1.getType()     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
            java.lang.reflect.Constructor r2 = a((java.lang.Class) r2, (java.lang.Class[]) r4)     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
            if (r2 == 0) goto L_0x006b
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
            r3[r6] = r9     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
            java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
            goto L_0x0073
        L_0x006b:
            java.lang.Class r2 = r1.getType()     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
            java.lang.Object r2 = r2.newInstance()     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
        L_0x0073:
            java.util.Map<java.lang.Class<?>, java.lang.Object> r3 = f37543b     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
            java.lang.Class r1 = r1.getInterface()     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
            r3.put(r1, r2)     // Catch:{ IllegalAccessException -> 0x0085, InstantiationException -> 0x0081, InvocationTargetException -> 0x007d }
            goto L_0x000e
        L_0x007d:
            r1 = move-exception
            java.lang.String r2 = "TargetException"
            goto L_0x0088
        L_0x0081:
            r1 = move-exception
            java.lang.String r2 = "InstantiationException"
            goto L_0x0088
        L_0x0085:
            r1 = move-exception
            java.lang.String r2 = "AccessException"
        L_0x0088:
            r7.a((java.lang.String) r2, (java.lang.Exception) r1)
            goto L_0x000e
        L_0x008c:
            java.lang.String r8 = "addService end"
            android.util.Log.d(r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.core.a.d.a(java.util.List, android.content.Context):void");
    }
}
