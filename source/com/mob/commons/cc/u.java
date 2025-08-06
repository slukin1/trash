package com.mob.commons.cc;

import com.mob.commons.cc.z;
import com.mob.commons.s;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, Class<?>> f27150a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, HashMap<String, String[][]>> f27151b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<Class<?>, t<?>> f27152c = new HashMap<>();

    static {
        HashMap<String, Class<?>> hashMap = new HashMap<>();
        f27150a = hashMap;
        hashMap.put(s.a("003?diKei"), Integer.TYPE);
        hashMap.put(s.a("006^dcdkdgff.gf"), Double.TYPE);
        hashMap.put("long", Long.TYPE);
        hashMap.put(s.a("0055efWg]dk=di"), Float.TYPE);
        hashMap.put("boolean", Boolean.TYPE);
        hashMap.put("short", Short.TYPE);
        hashMap.put("byte", Byte.TYPE);
        hashMap.put(s.a("004chd)dj"), Character.TYPE);
        hashMap.put("void", Void.TYPE);
    }

    public u() {
        Class<z.a> cls = z.a.class;
        a(cls, cls);
    }

    private boolean b(Class<?> cls, Class<?> cls2) {
        Class<Float> cls3 = Float.class;
        Class<Long> cls4 = Long.class;
        Class<Integer> cls5 = Integer.class;
        Class<Character> cls6 = Character.class;
        Class<Short> cls7 = Short.class;
        Class<Byte> cls8 = Byte.class;
        return (cls == Byte.TYPE && cls2 == cls8) || (cls == Short.TYPE && (cls2 == cls7 || cls2 == cls8 || cls2 == cls6)) || ((cls == Character.TYPE && (cls2 == cls6 || cls2 == cls7 || cls2 == cls8)) || ((cls == Integer.TYPE && (cls2 == cls5 || cls2 == cls7 || cls2 == cls8 || cls2 == cls6)) || ((cls == Long.TYPE && (cls2 == cls4 || cls2 == cls5 || cls2 == cls7 || cls2 == cls8 || cls2 == cls6)) || ((cls == Float.TYPE && (cls2 == cls3 || cls2 == cls4 || cls2 == cls5 || cls2 == cls7 || cls2 == cls8 || cls2 == cls6)) || ((cls == Double.TYPE && (cls2 == Double.class || cls2 == cls3 || cls2 == cls4 || cls2 == cls5 || cls2 == cls7 || cls2 == cls8 || cls2 == cls6)) || (cls == Boolean.TYPE && cls2 == Boolean.class))))));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:33|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r14.f27151b.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e4, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e5, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e8, code lost:
        throw r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00dd */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(byte[] r15) throws java.lang.Throwable {
        /*
            r14 = this;
            java.lang.String r0 = "+"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r15)
            java.io.InputStreamReader r15 = new java.io.InputStreamReader
            java.lang.String r3 = "utf-8"
            r15.<init>(r2, r3)
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r2.<init>(r15)
            java.lang.String r15 = r2.readLine()     // Catch:{ all -> 0x00dd }
            r3 = 0
            r4 = r3
        L_0x001e:
            if (r15 == 0) goto L_0x00d9
            r5 = 2
            r6 = 0
            java.lang.String r7 = r15.substring(r6, r5)     // Catch:{ all -> 0x00dd }
            java.lang.String r15 = r15.substring(r5)     // Catch:{ all -> 0x00dd }
            java.lang.String r8 = ":P"
            boolean r8 = r8.equals(r7)     // Catch:{ all -> 0x00dd }
            java.lang.String r9 = "#"
            if (r8 == 0) goto L_0x0041
            java.lang.String[] r15 = r15.split(r9)     // Catch:{ all -> 0x00dd }
            java.util.List r15 = java.util.Arrays.asList(r15)     // Catch:{ all -> 0x00dd }
            r1.addAll(r15)     // Catch:{ all -> 0x00dd }
            goto L_0x00d3
        L_0x0041:
            java.lang.String r8 = ":C"
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x00dd }
            if (r7 == 0) goto L_0x0069
            int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ all -> 0x00dd }
            java.lang.Object r15 = r1.get(r15)     // Catch:{ all -> 0x00dd }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x00dd }
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String[][]>> r4 = r14.f27151b     // Catch:{ all -> 0x00dd }
            java.lang.Object r4 = r4.get(r15)     // Catch:{ all -> 0x00dd }
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch:{ all -> 0x00dd }
            if (r4 != 0) goto L_0x00d3
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00dd }
            r4.<init>()     // Catch:{ all -> 0x00dd }
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String[][]>> r5 = r14.f27151b     // Catch:{ all -> 0x00dd }
            r5.put(r15, r4)     // Catch:{ all -> 0x00dd }
            goto L_0x00d3
        L_0x0069:
            java.lang.String[] r15 = r15.split(r9)     // Catch:{ all -> 0x00dd }
            r7 = r15[r6]     // Catch:{ all -> 0x00dd }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ all -> 0x00dd }
            java.lang.Object r7 = r1.get(r7)     // Catch:{ all -> 0x00dd }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00dd }
            r8 = 1
            r9 = r15[r8]     // Catch:{ all -> 0x00dd }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x00dd }
            java.lang.String[][] r9 = new java.lang.String[r9][]     // Catch:{ all -> 0x00dd }
        L_0x0082:
            int r10 = r15.length     // Catch:{ all -> 0x00dd }
            if (r5 >= r10) goto L_0x00d0
            r10 = r15[r5]     // Catch:{ all -> 0x00dd }
            boolean r10 = r10.startsWith(r0)     // Catch:{ all -> 0x00dd }
            if (r10 == 0) goto L_0x008f
            r10 = r0
            goto L_0x0090
        L_0x008f:
            r10 = r3
        L_0x0090:
            r11 = r15[r5]     // Catch:{ all -> 0x00dd }
            int r11 = r11.length()     // Catch:{ all -> 0x00dd }
            if (r11 <= r8) goto L_0x00c5
            r11 = r15[r5]     // Catch:{ all -> 0x00dd }
            java.lang.String r11 = r11.substring(r8)     // Catch:{ all -> 0x00dd }
            java.lang.String r12 = ","
            java.lang.String[] r11 = r11.split(r12)     // Catch:{ all -> 0x00dd }
            int r12 = r11.length     // Catch:{ all -> 0x00dd }
            int r12 = r12 + r8
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ all -> 0x00dd }
            r12[r6] = r10     // Catch:{ all -> 0x00dd }
            r10 = r6
        L_0x00ab:
            int r13 = r11.length     // Catch:{ all -> 0x00dd }
            if (r10 >= r13) goto L_0x00c0
            int r13 = r10 + 1
            r10 = r11[r10]     // Catch:{ all -> 0x00dd }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ all -> 0x00dd }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ all -> 0x00dd }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00dd }
            r12[r13] = r10     // Catch:{ all -> 0x00dd }
            r10 = r13
            goto L_0x00ab
        L_0x00c0:
            int r10 = r5 + -2
            r9[r10] = r12     // Catch:{ all -> 0x00dd }
            goto L_0x00cd
        L_0x00c5:
            int r11 = r5 + -2
            java.lang.String[] r12 = new java.lang.String[r8]     // Catch:{ all -> 0x00dd }
            r12[r6] = r10     // Catch:{ all -> 0x00dd }
            r9[r11] = r12     // Catch:{ all -> 0x00dd }
        L_0x00cd:
            int r5 = r5 + 1
            goto L_0x0082
        L_0x00d0:
            r4.put(r7, r9)     // Catch:{ all -> 0x00dd }
        L_0x00d3:
            java.lang.String r15 = r2.readLine()     // Catch:{ all -> 0x00dd }
            goto L_0x001e
        L_0x00d9:
            r2.close()
            goto L_0x00e3
        L_0x00dd:
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String[][]>> r15 = r14.f27151b     // Catch:{ all -> 0x00e4 }
            r15.clear()     // Catch:{ all -> 0x00e4 }
            goto L_0x00d9
        L_0x00e3:
            return
        L_0x00e4:
            r15 = move-exception
            r2.close()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.cc.u.a(byte[]):void");
    }

    public void a(Class<?> cls, Class<? extends t<?>> cls2) {
        try {
            t tVar = (t) cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (this.f27152c.get(cls) == null) {
                this.f27152c.put(cls, tVar);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(Object obj, Class<?> cls, String str, Object[] objArr, s sVar) throws Throwable {
        t tVar = null;
        Class<?> cls2 = cls;
        while (tVar == null && cls2 != null && cls2 != Object.class) {
            tVar = this.f27152c.get(cls2);
            cls2 = cls2.getSuperclass();
        }
        if (tVar == null) {
            return false;
        }
        boolean[] zArr = new boolean[1];
        Object[] objArr2 = new Object[1];
        Throwable[] thArr = new Throwable[1];
        boolean a11 = tVar.a(obj, cls, str, objArr, zArr, objArr2, thArr);
        if (a11) {
            if (thArr[0] != null) {
                throw thArr[0];
            } else if (!zArr[0]) {
                sVar.a(objArr2[0]);
            }
        }
        return a11;
    }

    public boolean[] a(Class<?>[] clsArr, Object[] objArr, boolean[] zArr) {
        zArr[0] = true;
        if (clsArr.length != objArr.length) {
            return null;
        }
        boolean[] zArr2 = new boolean[clsArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Object obj = objArr[i11];
            if (obj != null) {
                Class<?> cls = clsArr[i11];
                if (!cls.isInterface() || !(obj instanceof z)) {
                    Class<?> cls2 = obj.getClass();
                    if (!b(cls, cls2) && !cls.isAssignableFrom(cls2)) {
                        return null;
                    }
                    zArr2[i11] = false;
                } else {
                    zArr2[i11] = true;
                    zArr[0] = false;
                }
            }
        }
        return zArr2;
    }

    public Object[] a(s sVar, Class<?>[] clsArr, Object[] objArr, boolean[] zArr) {
        Object[] objArr2 = new Object[zArr.length];
        for (int i11 = 0; i11 < zArr.length; i11++) {
            if (objArr[i11] != null) {
                if (zArr[i11]) {
                    objArr2[i11] = sVar.a(objArr[i11], true, clsArr[i11]);
                } else {
                    objArr2[i11] = objArr[i11];
                }
            }
        }
        return objArr2;
    }

    public Constructor a(Class<?> cls, Object[] objArr, boolean[][] zArr) throws Throwable {
        String[][] strArr;
        boolean z11;
        boolean[] zArr2;
        boolean[] a11;
        HashMap hashMap = this.f27151b.get(cls.getName());
        if (hashMap == null || (strArr = (String[][]) hashMap.get(s.a("006%iedi-eEdiWi4ig"))) == null) {
            return null;
        }
        for (String[] strArr2 : strArr) {
            if (strArr2.length - 1 == objArr.length) {
                int length = objArr.length;
                Class[] clsArr = new Class[length];
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z11 = false;
                        break;
                    }
                    int i12 = i11 + 1;
                    clsArr[i11] = a(strArr2[i12]);
                    if (clsArr[i11] == null) {
                        z11 = true;
                        break;
                    }
                    i11 = i12;
                }
                if (!z11 && (a11 = a((Class<?>[]) clsArr, objArr, zArr2)) != null) {
                    zArr[0] = a11;
                    zArr[1] = (zArr2 = new boolean[1]);
                    return cls.getDeclaredConstructor(clsArr);
                }
            }
        }
        return null;
    }

    public Method a(Class<?> cls, String str, boolean z11, Object[] objArr, boolean[][] zArr) throws Throwable {
        String[][] strArr;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean[] zArr2;
        boolean[] a11;
        String str2 = str;
        Object[] objArr2 = objArr;
        HashMap hashMap = this.f27151b.get(cls.getName());
        if (hashMap == null || (strArr = (String[][]) hashMap.get(str2)) == null) {
            return null;
        }
        for (String[] strArr2 : strArr) {
            if (strArr2[0] != null) {
                z13 = z11;
                z12 = true;
            } else {
                z13 = z11;
                z12 = false;
            }
            if ((z13 == z12) && strArr2.length - 1 == objArr2.length) {
                int length = objArr2.length;
                Class[] clsArr = new Class[length];
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z14 = false;
                        break;
                    }
                    int i12 = i11 + 1;
                    clsArr[i11] = a(strArr2[i12]);
                    if (clsArr[i11] == null) {
                        z14 = true;
                        break;
                    }
                    i11 = i12;
                }
                if (!z14 && (a11 = a((Class<?>[]) clsArr, objArr2, zArr2)) != null) {
                    zArr[0] = a11;
                    zArr[1] = (zArr2 = new boolean[1]);
                    return cls.getDeclaredMethod(str2, clsArr);
                }
            }
            Class<?> cls2 = cls;
        }
        return null;
    }

    private Class<?> a(String str) {
        Class<?> cls = f27150a.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
