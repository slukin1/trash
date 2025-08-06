package com.mob.commons.cc;

import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.mob.commons.cc.x;
import com.mob.commons.s;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public int f27166a;

    /* renamed from: b  reason: collision with root package name */
    public String f27167b;

    /* renamed from: c  reason: collision with root package name */
    public int f27168c;

    /* renamed from: d  reason: collision with root package name */
    public String f27169d;

    /* renamed from: e  reason: collision with root package name */
    public String f27170e;

    /* renamed from: f  reason: collision with root package name */
    public String f27171f;

    /* renamed from: g  reason: collision with root package name */
    public int f27172g;

    /* renamed from: h  reason: collision with root package name */
    public String f27173h;

    /* renamed from: i  reason: collision with root package name */
    public int f27174i;

    /* renamed from: j  reason: collision with root package name */
    public int f27175j;

    /* renamed from: k  reason: collision with root package name */
    public int f27176k;

    /* renamed from: l  reason: collision with root package name */
    public String f27177l;

    /* renamed from: m  reason: collision with root package name */
    public Object[] f27178m;

    /* renamed from: n  reason: collision with root package name */
    public String f27179n;

    /* renamed from: o  reason: collision with root package name */
    public String[] f27180o;

    /* renamed from: p  reason: collision with root package name */
    public String f27181p;

    /* renamed from: q  reason: collision with root package name */
    public Object f27182q;

    /* renamed from: r  reason: collision with root package name */
    public int f27183r;

    /* renamed from: s  reason: collision with root package name */
    public int f27184s;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f27185a;

        /* renamed from: b  reason: collision with root package name */
        public s f27186b;

        /* renamed from: c  reason: collision with root package name */
        public List<Object> f27187c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f27188d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27189e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<y> f27190f;

        /* renamed from: g  reason: collision with root package name */
        public ArrayList<Object> f27191g;

        public Object a() {
            return this.f27186b.a();
        }

        public Object b(String str) {
            return this.f27186b.a(str);
        }

        public void a(Object obj) {
            this.f27186b.a(obj);
        }

        public void b(String str, Object obj) {
            this.f27186b.a(str, obj);
        }

        public Class<?> a(String str) {
            return this.f27186b.b(str);
        }

        public void a(String str, Class<?> cls) {
            this.f27186b.a(str, cls);
        }

        public void a(String str, Object obj) {
            this.f27186b.b(str, obj);
        }
    }

    public y(int i11) {
        this.f27166a = i11;
    }

    public void a(x.a aVar) throws Throwable {
        int i11 = 0;
        switch (this.f27166a) {
            case 1:
                this.f27173h = (String) aVar.b();
                aVar.a();
                return;
            case 2:
                this.f27182q = aVar.b();
                return;
            case 3:
                this.f27173h = (String) aVar.b();
                return;
            case 4:
                this.f27176k = ((Integer) aVar.b()).intValue();
                return;
            case 5:
                this.f27176k = ((Integer) aVar.b()).intValue();
                return;
            case 6:
                this.f27184s = ((Integer) aVar.b()).intValue();
                return;
            case 7:
                this.f27183r = ((Integer) aVar.b()).intValue();
                return;
            case 9:
                this.f27173h = (String) aVar.b();
                return;
            case 10:
                this.f27169d = (String) aVar.b();
                this.f27170e = (String) aVar.b();
                return;
            case 11:
                this.f27177l = (String) aVar.b();
                return;
            case 12:
                this.f27181p = (String) aVar.b();
                this.f27174i = ((Integer) aVar.b()).intValue();
                return;
            case 13:
                this.f27179n = (String) aVar.b();
                this.f27177l = (String) aVar.b();
                return;
            case 14:
                this.f27179n = (String) aVar.b();
                this.f27181p = (String) aVar.b();
                this.f27174i = ((Integer) aVar.b()).intValue();
                return;
            case 16:
                this.f27174i = ((Integer) aVar.b()).intValue();
                return;
            case 17:
                this.f27179n = (String) aVar.b();
                return;
            case 18:
                this.f27179n = (String) aVar.b();
                this.f27174i = ((Integer) aVar.b()).intValue();
                return;
            case 19:
                this.f27173h = (String) aVar.b();
                return;
            case 20:
                this.f27171f = (String) aVar.b();
                return;
            case 21:
                this.f27171f = (String) aVar.b();
                int intValue = ((Integer) aVar.b()).intValue();
                this.f27172g = intValue;
                this.f27172g = intValue + aVar.c();
                return;
            case 22:
                this.f27171f = (String) aVar.b();
                int intValue2 = ((Integer) aVar.b()).intValue();
                this.f27172g = intValue2;
                this.f27172g = intValue2 + aVar.c();
                return;
            case 24:
                this.f27177l = (String) aVar.b();
                return;
            case 26:
                this.f27179n = (String) aVar.b();
                this.f27177l = (String) aVar.b();
                return;
            case 27:
                this.f27179n = (String) aVar.b();
                return;
            case 29:
                this.f27173h = (String) aVar.b();
                this.f27174i = ((Integer) aVar.b()).intValue();
                int intValue3 = ((Integer) aVar.b()).intValue();
                this.f27175j = intValue3;
                this.f27175j = intValue3 + aVar.c();
                return;
            case 31:
                this.f27173h = (String) aVar.b();
                this.f27174i = ((Integer) aVar.b()).intValue();
                return;
            case 32:
                this.f27174i = ((Integer) aVar.b()).intValue();
                return;
            case 35:
                this.f27169d = (String) aVar.b();
                this.f27170e = (String) aVar.b();
                return;
            case 36:
                int intValue4 = ((Integer) aVar.b()).intValue();
                this.f27180o = new String[intValue4];
                while (i11 < intValue4) {
                    this.f27180o[i11] = (String) aVar.b();
                    aVar.a();
                    i11++;
                }
                return;
            case 37:
                int intValue5 = ((Integer) aVar.b()).intValue();
                this.f27178m = new Object[intValue5];
                while (i11 < intValue5) {
                    this.f27178m[i11] = aVar.b();
                    i11++;
                }
                return;
            case 38:
                int intValue6 = ((Integer) aVar.b()).intValue();
                this.f27180o = new String[intValue6];
                while (i11 < intValue6) {
                    this.f27180o[i11] = (String) aVar.b();
                    i11++;
                }
                return;
            default:
                return;
        }
    }

    public void b(Object obj, s sVar) throws Throwable {
        Object a11 = sVar.a();
        if (obj instanceof Map) {
            ((Map) obj).put(this.f27177l, a11);
            return;
        }
        Class cls = obj.getClass();
        while (cls != null) {
            Field field = null;
            try {
                field = cls.getDeclaredField(this.f27177l);
            } catch (Throwable unused) {
            }
            if (field == null || Modifier.isStatic(field.getModifiers())) {
                cls = cls.getSuperclass();
            } else {
                field.setAccessible(true);
                field.set(obj, a11);
                return;
            }
        }
        y yVar = new y(12);
        yVar.f27167b = this.f27167b;
        yVar.f27168c = this.f27168c;
        yVar.f27181p = "set" + Character.toUpperCase(this.f27177l.charAt(0)) + this.f27177l.substring(1);
        yVar.f27174i = 1;
        yVar.a(obj, new Object[]{a11}, sVar);
    }

    public y() {
    }

    public void b(Class<?> cls, s sVar) throws Throwable {
        Field field;
        Object a11 = sVar.a();
        Class<? super Object> cls2 = cls;
        while (cls2 != null) {
            try {
                field = cls2.getDeclaredField(this.f27177l);
            } catch (Throwable unused) {
                field = null;
            }
            if (field == null || !Modifier.isStatic(field.getModifiers())) {
                cls2 = cls2.getSuperclass();
            } else {
                field.setAccessible(true);
                field.set((Object) null, a11);
                return;
            }
        }
        y yVar = new y(14);
        yVar.f27167b = this.f27167b;
        yVar.f27168c = this.f27168c;
        yVar.f27179n = this.f27179n;
        yVar.f27181p = "set" + Character.toUpperCase(this.f27177l.charAt(0)) + this.f27177l.substring(1);
        yVar.f27174i = 1;
        yVar.a(cls2, new Object[]{a11}, sVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: type inference failed for: r8v23, types: [int] */
    /* JADX WARNING: type inference failed for: r8v25, types: [int] */
    /* JADX WARNING: type inference failed for: r8v27, types: [int] */
    /* JADX WARNING: type inference failed for: r8v29, types: [int] */
    /* JADX WARNING: type inference failed for: r8v31, types: [int] */
    /* JADX WARNING: type inference failed for: r8v33, types: [int] */
    /* JADX WARNING: type inference failed for: r8v35, types: [int] */
    /* JADX WARNING: type inference failed for: r8v37, types: [int] */
    /* JADX WARNING: type inference failed for: r8v39, types: [int] */
    /* JADX WARNING: type inference failed for: r8v41, types: [int] */
    /* JADX WARNING: type inference failed for: r8v43 */
    /* JADX WARNING: type inference failed for: r8v44 */
    /* JADX WARNING: type inference failed for: r8v45 */
    /* JADX WARNING: type inference failed for: r8v46 */
    /* JADX WARNING: type inference failed for: r8v47 */
    /* JADX WARNING: type inference failed for: r8v48 */
    /* JADX WARNING: type inference failed for: r8v49 */
    /* JADX WARNING: type inference failed for: r8v50 */
    /* JADX WARNING: type inference failed for: r8v51 */
    /* JADX WARNING: type inference failed for: r8v52 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:423|424) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        r1.b(r2[r8], r19.a());
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:424:?, code lost:
        r2 = java.lang.Double.valueOf(java.lang.Double.parseDouble(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:425:0x0b24, code lost:
        r3 = new java.math.BigDecimal(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:430:?, code lost:
        r2 = java.lang.Long.valueOf(java.lang.Long.parseLong(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:431:0x0b3c, code lost:
        r3 = new java.math.BigInteger(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:433:0x0b41, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0028, code lost:
        r2 = r0.f27178m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002b, code lost:
        if (r8 >= r2.length) goto L_0x0ed7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:725:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:726:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        r1.a(r2[r8]);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
        r2 = r0.f27180o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        if (r8 >= r2.length) goto L_0x0ed7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:423:0x0b1b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:429:0x0b33 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0a55  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0a6e  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0a81 A[LOOP:13: B:399:0x0a7e->B:401:0x0a81, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0a8e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.mob.commons.cc.y.a r19) throws java.lang.Throwable {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            int r2 = r0.f27166a
            java.lang.String r3 = " is not entry"
            r4 = 26
            java.lang.String r5 = "Bad operator at line: "
            java.lang.String r6 = ")"
            java.lang.String r7 = "("
            r8 = 0
            r9 = 1
            switch(r2) {
                case 1: goto L_0x0ece;
                case 2: goto L_0x0ec8;
                case 3: goto L_0x0ebe;
                case 4: goto L_0x0550;
                case 5: goto L_0x0516;
                case 6: goto L_0x04d6;
                case 7: goto L_0x04ba;
                case 8: goto L_0x03ba;
                case 9: goto L_0x03af;
                case 10: goto L_0x03a2;
                case 11: goto L_0x0397;
                case 12: goto L_0x037b;
                case 13: goto L_0x036e;
                case 14: goto L_0x0350;
                case 15: goto L_0x032e;
                case 16: goto L_0x02f7;
                case 17: goto L_0x02d3;
                case 18: goto L_0x0296;
                case 19: goto L_0x028b;
                case 20: goto L_0x0015;
                case 21: goto L_0x0279;
                case 22: goto L_0x0273;
                case 23: goto L_0x020b;
                case 24: goto L_0x0200;
                case 25: goto L_0x01de;
                case 26: goto L_0x01d1;
                case 27: goto L_0x01af;
                case 28: goto L_0x019e;
                case 29: goto L_0x0136;
                case 30: goto L_0x0132;
                case 31: goto L_0x00c9;
                case 32: goto L_0x0067;
                case 33: goto L_0x005d;
                case 34: goto L_0x0053;
                case 35: goto L_0x0046;
                case 36: goto L_0x0035;
                case 37: goto L_0x0028;
                case 38: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0ed7
        L_0x0017:
            java.lang.String[] r2 = r0.f27180o
            int r3 = r2.length
        L_0x001a:
            if (r8 >= r3) goto L_0x0ed7
            r4 = r2[r8]
            java.lang.Object r4 = r1.b(r4)
            r1.a((java.lang.Object) r4)
            int r8 = r8 + 1
            goto L_0x001a
        L_0x0028:
            java.lang.Object[] r2 = r0.f27178m
            int r3 = r2.length
            if (r8 >= r3) goto L_0x0ed7
            r2 = r2[r8]
            r1.a((java.lang.Object) r2)
            int r8 = r8 + 1
            goto L_0x0028
        L_0x0035:
            java.lang.String[] r2 = r0.f27180o
            int r3 = r2.length
            if (r8 >= r3) goto L_0x0ed7
            r2 = r2[r8]
            java.lang.Object r3 = r19.a()
            r1.b(r2, r3)
            int r8 = r8 + 1
            goto L_0x0035
        L_0x0046:
            java.lang.String r2 = r0.f27170e     // Catch:{ all -> 0x0ed7 }
            java.lang.String r3 = r0.f27169d     // Catch:{ all -> 0x0ed7 }
            java.lang.Class r3 = r1.a((java.lang.String) r3)     // Catch:{ all -> 0x0ed7 }
            r1.a((java.lang.String) r2, (java.lang.Class<?>) r3)     // Catch:{ all -> 0x0ed7 }
            goto L_0x0ed7
        L_0x0053:
            com.mob.commons.cc.s r2 = r1.f27186b
            com.mob.commons.cc.s r2 = r2.c()
            r1.f27186b = r2
            goto L_0x0ed7
        L_0x005d:
            com.mob.commons.cc.s r2 = r1.f27186b
            com.mob.commons.cc.s r2 = r2.b()
            r1.f27186b = r2
            goto L_0x0ed7
        L_0x0067:
            java.lang.Object r2 = r19.a()
            boolean r3 = r2 instanceof com.mob.commons.cc.z
            if (r3 == 0) goto L_0x0096
            com.mob.commons.cc.z r2 = (com.mob.commons.cc.z) r2
            int r3 = r0.f27174i
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = r8
        L_0x0076:
            int r5 = r0.f27174i
            if (r4 >= r5) goto L_0x0083
            java.lang.Object r5 = r19.a()
            r3[r4] = r5
            int r4 = r4 + 1
            goto L_0x0076
        L_0x0083:
            java.util.LinkedList r2 = r2.b(r3)
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x0ed7
            java.lang.Object r2 = r2.get(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0096:
            boolean r3 = r2 instanceof java.lang.reflect.Method
            if (r3 == 0) goto L_0x00a5
            com.mob.commons.cc.s r1 = r1.f27186b
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2
            int r3 = r0.f27174i
            r1.a((java.lang.reflect.Method) r2, (int) r3)
            goto L_0x0ed7
        L_0x00a5:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "at line: "
            r2.append(r3)
            java.lang.String r3 = r0.f27167b
            r2.append(r3)
            r2.append(r7)
            int r3 = r0.f27168c
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00c9:
            java.lang.String r2 = r0.f27173h
            java.lang.Object r2 = r1.b(r2)
            boolean r3 = r2 instanceof com.mob.commons.cc.z
            if (r3 == 0) goto L_0x00fa
            com.mob.commons.cc.z r2 = (com.mob.commons.cc.z) r2
            int r3 = r0.f27174i
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = r8
        L_0x00da:
            int r5 = r0.f27174i
            if (r4 >= r5) goto L_0x00e7
            java.lang.Object r5 = r19.a()
            r3[r4] = r5
            int r4 = r4 + 1
            goto L_0x00da
        L_0x00e7:
            java.util.LinkedList r2 = r2.b(r3)
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x0ed7
            java.lang.Object r2 = r2.get(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x00fa:
            boolean r3 = r2 instanceof java.lang.reflect.Method
            if (r3 == 0) goto L_0x0109
            com.mob.commons.cc.s r1 = r1.f27186b
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2
            int r3 = r0.f27174i
            r1.a((java.lang.reflect.Method) r2, (int) r3)
            goto L_0x0ed7
        L_0x0109:
            java.lang.NoSuchMethodException r1 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r0.f27173h
            r2.append(r3)
            java.lang.String r3 = " at line: "
            r2.append(r3)
            java.lang.String r3 = r0.f27167b
            r2.append(r3)
            r2.append(r7)
            int r3 = r0.f27168c
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0132:
            r1.f27189e = r9
            goto L_0x0ed7
        L_0x0136:
            int r2 = r1.f27185a
            int r3 = r0.f27175j
            if (r3 <= 0) goto L_0x013f
            r1.f27185a = r3
            goto L_0x0165
        L_0x013f:
            int r3 = r2 + 1
            r4 = r3
            r5 = r9
            r3 = r2
        L_0x0144:
            if (r5 <= 0) goto L_0x0165
            java.util.ArrayList<com.mob.commons.cc.y> r6 = r1.f27190f
            java.lang.Object r6 = r6.get(r4)
            com.mob.commons.cc.y r6 = (com.mob.commons.cc.y) r6
            int r6 = r6.f27166a
            r7 = 29
            if (r6 != r7) goto L_0x0157
            int r5 = r5 + 1
            goto L_0x015d
        L_0x0157:
            r7 = 30
            if (r6 != r7) goto L_0x015d
            int r5 = r5 + -1
        L_0x015d:
            if (r5 != 0) goto L_0x0162
            r1.f27185a = r4
            r3 = r4
        L_0x0162:
            int r4 = r4 + 1
            goto L_0x0144
        L_0x0165:
            int r15 = r2 + 1
            if (r15 != r3) goto L_0x017c
            java.lang.String r10 = r0.f27173h
            int r11 = r0.f27174i
            java.util.ArrayList<com.mob.commons.cc.y> r12 = r1.f27190f
            java.util.ArrayList<java.lang.Object> r13 = r1.f27191g
            com.mob.commons.cc.s r2 = r1.f27186b
            r14 = r15
            r15 = r3
            r16 = r2
            com.mob.commons.cc.z r2 = com.mob.commons.cc.z.a(r10, r11, r12, r13, r14, r15, r16)
            goto L_0x0190
        L_0x017c:
            com.mob.commons.cc.z r2 = new com.mob.commons.cc.z
            java.lang.String r11 = r0.f27173h
            int r12 = r0.f27174i
            java.util.ArrayList<com.mob.commons.cc.y> r13 = r1.f27190f
            java.util.ArrayList<java.lang.Object> r14 = r1.f27191g
            com.mob.commons.cc.s r4 = r1.f27186b
            r10 = r2
            r16 = r3
            r17 = r4
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
        L_0x0190:
            java.lang.String r3 = r0.f27173h
            if (r3 == 0) goto L_0x0199
            r1.b(r3, r2)
            goto L_0x0ed7
        L_0x0199:
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x019e:
            java.util.List<java.lang.Object> r2 = r1.f27187c
            if (r2 == 0) goto L_0x01a9
            java.lang.Object r3 = r19.a()
            r2.add(r3)
        L_0x01a9:
            r1.f27188d = r9
            r1.f27189e = r9
            goto L_0x0ed7
        L_0x01af:
            java.lang.String r2 = r0.f27179n
            java.lang.Class r2 = r1.a((java.lang.String) r2)
            com.mob.commons.cc.y r3 = new com.mob.commons.cc.y
            r3.<init>(r4)
            java.lang.String r4 = r0.f27167b
            r3.f27167b = r4
            int r4 = r0.f27168c
            r3.f27168c = r4
            java.lang.Object r4 = r19.a()
            java.lang.String r4 = (java.lang.String) r4
            r3.f27177l = r4
            com.mob.commons.cc.s r1 = r1.f27186b
            r3.b((java.lang.Class<?>) r2, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x01d1:
            java.lang.String r2 = r0.f27179n
            java.lang.Class r2 = r1.a((java.lang.String) r2)
            com.mob.commons.cc.s r1 = r1.f27186b
            r0.b((java.lang.Class<?>) r2, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x01de:
            java.lang.Object r2 = r19.a()
            com.mob.commons.cc.y r3 = new com.mob.commons.cc.y
            r4 = 24
            r3.<init>(r4)
            java.lang.String r4 = r0.f27167b
            r3.f27167b = r4
            int r4 = r0.f27168c
            r3.f27168c = r4
            java.lang.Object r4 = r19.a()
            java.lang.String r4 = (java.lang.String) r4
            r3.f27177l = r4
            com.mob.commons.cc.s r1 = r1.f27186b
            r3.b((java.lang.Object) r2, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x0200:
            java.lang.Object r2 = r19.a()
            com.mob.commons.cc.s r1 = r1.f27186b
            r0.b((java.lang.Object) r2, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x020b:
            java.lang.Object r2 = r19.a()
            java.lang.Object r4 = r19.a()
            java.lang.Object r1 = r19.a()
            boolean r5 = r2 instanceof java.util.List
            if (r5 == 0) goto L_0x022f
            java.util.List r2 = (java.util.List) r2
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r3 = r4.intValue()
            if (r3 >= 0) goto L_0x022a
            int r4 = r2.size()
            int r3 = r3 + r4
        L_0x022a:
            r2.set(r3, r1)
            goto L_0x0ed7
        L_0x022f:
            boolean r5 = r2 instanceof java.util.Map
            if (r5 == 0) goto L_0x023a
            java.util.Map r2 = (java.util.Map) r2
            r2.put(r4, r1)
            goto L_0x0ed7
        L_0x023a:
            java.lang.Class r5 = r2.getClass()
            boolean r5 = r5.isArray()
            if (r5 == 0) goto L_0x0256
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r3 = r4.intValue()
            if (r3 >= 0) goto L_0x0251
            int r4 = java.lang.reflect.Array.getLength(r2)
            int r3 = r3 + r4
        L_0x0251:
            java.lang.reflect.Array.set(r2, r3, r1)
            goto L_0x0ed7
        L_0x0256:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getName()
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            r1.<init>(r2)
            throw r1
        L_0x0273:
            int r2 = r0.f27172g
            r1.f27185a = r2
            goto L_0x0ed7
        L_0x0279:
            java.lang.Object r2 = r19.a()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0ed7
            int r2 = r0.f27172g
            r1.f27185a = r2
            goto L_0x0ed7
        L_0x028b:
            java.lang.String r2 = r0.f27173h
            java.lang.Object r3 = r19.a()
            r1.a((java.lang.String) r2, (java.lang.Object) r3)
            goto L_0x0ed7
        L_0x0296:
            java.lang.String r2 = r0.f27179n
            java.lang.Class r2 = r1.a((java.lang.String) r2)
            com.mob.commons.cc.y r3 = new com.mob.commons.cc.y
            r4 = 14
            r3.<init>(r4)
            java.lang.String r4 = r0.f27167b
            r3.f27167b = r4
            int r4 = r0.f27168c
            r3.f27168c = r4
            java.lang.String r4 = r0.f27179n
            r3.f27179n = r4
            java.lang.Object r4 = r19.a()
            java.lang.String r4 = (java.lang.String) r4
            r3.f27181p = r4
            int r4 = r0.f27174i
            r3.f27174i = r4
            int r4 = r0.f27174i
            java.lang.Object[] r4 = new java.lang.Object[r4]
        L_0x02bf:
            int r5 = r0.f27174i
            if (r8 >= r5) goto L_0x02cc
            java.lang.Object r5 = r19.a()
            r4[r8] = r5
            int r8 = r8 + 1
            goto L_0x02bf
        L_0x02cc:
            com.mob.commons.cc.s r1 = r1.f27186b
            r3.a((java.lang.Class<?>) r2, (java.lang.Object[]) r4, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x02d3:
            java.lang.String r2 = r0.f27179n
            java.lang.Class r2 = r1.a((java.lang.String) r2)
            com.mob.commons.cc.y r3 = new com.mob.commons.cc.y
            r4 = 13
            r3.<init>(r4)
            java.lang.String r4 = r0.f27167b
            r3.f27167b = r4
            int r4 = r0.f27168c
            r3.f27168c = r4
            java.lang.Object r4 = r19.a()
            java.lang.String r4 = (java.lang.String) r4
            r3.f27177l = r4
            com.mob.commons.cc.s r1 = r1.f27186b
            r3.a((java.lang.Class<?>) r2, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x02f7:
            java.lang.Object r2 = r19.a()
            com.mob.commons.cc.y r3 = new com.mob.commons.cc.y
            r4 = 12
            r3.<init>(r4)
            java.lang.String r4 = r0.f27167b
            r3.f27167b = r4
            int r4 = r0.f27168c
            r3.f27168c = r4
            java.lang.Object r4 = r19.a()
            java.lang.String r4 = (java.lang.String) r4
            r3.f27181p = r4
            int r4 = r0.f27174i
            r3.f27174i = r4
            int r4 = r0.f27174i
            java.lang.Object[] r4 = new java.lang.Object[r4]
        L_0x031a:
            int r5 = r0.f27174i
            if (r8 >= r5) goto L_0x0327
            java.lang.Object r5 = r19.a()
            r4[r8] = r5
            int r8 = r8 + 1
            goto L_0x031a
        L_0x0327:
            com.mob.commons.cc.s r1 = r1.f27186b
            r3.a((java.lang.Object) r2, (java.lang.Object[]) r4, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x032e:
            java.lang.Object r2 = r19.a()
            com.mob.commons.cc.y r3 = new com.mob.commons.cc.y
            r4 = 11
            r3.<init>(r4)
            java.lang.String r4 = r0.f27167b
            r3.f27167b = r4
            int r4 = r0.f27168c
            r3.f27168c = r4
            java.lang.Object r4 = r19.a()
            java.lang.String r4 = (java.lang.String) r4
            r3.f27177l = r4
            com.mob.commons.cc.s r1 = r1.f27186b
            r3.a((java.lang.Object) r2, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x0350:
            java.lang.String r2 = r0.f27179n
            java.lang.Class r2 = r1.a((java.lang.String) r2)
            int r3 = r0.f27174i
            java.lang.Object[] r3 = new java.lang.Object[r3]
        L_0x035a:
            int r4 = r0.f27174i
            if (r8 >= r4) goto L_0x0367
            java.lang.Object r4 = r19.a()
            r3[r8] = r4
            int r8 = r8 + 1
            goto L_0x035a
        L_0x0367:
            com.mob.commons.cc.s r1 = r1.f27186b
            r0.a((java.lang.Class<?>) r2, (java.lang.Object[]) r3, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x036e:
            java.lang.String r2 = r0.f27179n
            java.lang.Class r2 = r1.a((java.lang.String) r2)
            com.mob.commons.cc.s r1 = r1.f27186b
            r0.a((java.lang.Class<?>) r2, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x037b:
            java.lang.Object r2 = r19.a()
            int r3 = r0.f27174i
            java.lang.Object[] r3 = new java.lang.Object[r3]
        L_0x0383:
            int r4 = r0.f27174i
            if (r8 >= r4) goto L_0x0390
            java.lang.Object r4 = r19.a()
            r3[r8] = r4
            int r8 = r8 + 1
            goto L_0x0383
        L_0x0390:
            com.mob.commons.cc.s r1 = r1.f27186b
            r0.a((java.lang.Object) r2, (java.lang.Object[]) r3, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x0397:
            java.lang.Object r2 = r19.a()
            com.mob.commons.cc.s r1 = r1.f27186b
            r0.a((java.lang.Object) r2, (com.mob.commons.cc.s) r1)
            goto L_0x0ed7
        L_0x03a2:
            java.lang.String r2 = r0.f27170e     // Catch:{ all -> 0x0ed7 }
            java.lang.String r3 = r0.f27169d     // Catch:{ all -> 0x0ed7 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0ed7 }
            r1.a((java.lang.String) r2, (java.lang.Class<?>) r3)     // Catch:{ all -> 0x0ed7 }
            goto L_0x0ed7
        L_0x03af:
            java.lang.String r2 = r0.f27173h
            java.lang.Class r2 = r1.a((java.lang.String) r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x03ba:
            java.lang.Object r2 = r19.a()
            java.lang.Object r4 = r19.a()
            boolean r5 = r2 instanceof java.util.List
            if (r5 == 0) goto L_0x0405
            java.util.List r2 = (java.util.List) r2
            boolean r3 = r4 instanceof com.mob.commons.cc.aa
            if (r3 == 0) goto L_0x03f2
            com.mob.commons.cc.aa r4 = (com.mob.commons.cc.aa) r4
            java.lang.Number[] r3 = r4.b()
            r4 = r3[r8]
            int r4 = r4.intValue()
            if (r4 >= 0) goto L_0x03df
            int r5 = r2.size()
            int r4 = r4 + r5
        L_0x03df:
            r3 = r3[r9]
            int r3 = r3.intValue()
            if (r3 >= 0) goto L_0x03ec
            int r5 = r2.size()
            int r3 = r3 + r5
        L_0x03ec:
            java.util.List r2 = r2.subList(r4, r3)
            goto L_0x0498
        L_0x03f2:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r3 = r4.intValue()
            if (r3 >= 0) goto L_0x03ff
            int r4 = r2.size()
            int r3 = r3 + r4
        L_0x03ff:
            java.lang.Object r2 = r2.get(r3)
            goto L_0x0498
        L_0x0405:
            boolean r5 = r2 instanceof java.util.Map
            if (r5 == 0) goto L_0x0411
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r2 = r2.get(r4)
            goto L_0x0498
        L_0x0411:
            java.lang.Class r5 = r2.getClass()
            boolean r5 = r5.isArray()
            if (r5 == 0) goto L_0x045f
            boolean r3 = r4 instanceof com.mob.commons.cc.aa
            if (r3 == 0) goto L_0x044d
            int r3 = java.lang.reflect.Array.getLength(r2)
            com.mob.commons.cc.aa r4 = (com.mob.commons.cc.aa) r4
            java.lang.Number[] r4 = r4.b()
            r5 = r4[r8]
            int r5 = r5.intValue()
            if (r5 >= 0) goto L_0x0432
            int r5 = r5 + r3
        L_0x0432:
            r4 = r4[r9]
            int r4 = r4.intValue()
            if (r4 >= 0) goto L_0x043b
            int r4 = r4 + r3
        L_0x043b:
            java.lang.Class r3 = r2.getClass()
            java.lang.Class r3 = r3.getComponentType()
            int r4 = r4 - r5
            java.lang.Object r3 = java.lang.reflect.Array.newInstance(r3, r4)
            java.lang.System.arraycopy(r2, r5, r3, r8, r4)
            r2 = r3
            goto L_0x0498
        L_0x044d:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r3 = r4.intValue()
            if (r3 >= 0) goto L_0x045a
            int r4 = java.lang.reflect.Array.getLength(r2)
            int r3 = r3 + r4
        L_0x045a:
            java.lang.Object r2 = java.lang.reflect.Array.get(r2, r3)
            goto L_0x0498
        L_0x045f:
            boolean r5 = r2 instanceof java.lang.String
            if (r5 == 0) goto L_0x049d
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = r4 instanceof com.mob.commons.cc.aa
            if (r3 == 0) goto L_0x047c
            com.mob.commons.cc.aa r4 = (com.mob.commons.cc.aa) r4
            java.lang.Number[] r3 = r4.b()
            r4 = r3[r8]
            int r4 = r4.intValue()
            r3 = r3[r9]
            int r3 = r3.intValue()
            goto L_0x0486
        L_0x047c:
            int r3 = r2.length()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
        L_0x0486:
            if (r4 >= 0) goto L_0x048d
            int r5 = r2.length()
            int r4 = r4 + r5
        L_0x048d:
            if (r3 >= 0) goto L_0x0494
            int r5 = r2.length()
            int r3 = r3 + r5
        L_0x0494:
            java.lang.String r2 = r2.substring(r4, r3)
        L_0x0498:
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x049d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getName()
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            r1.<init>(r2)
            throw r1
        L_0x04ba:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
        L_0x04bf:
            int r3 = r0.f27183r
            if (r8 >= r3) goto L_0x04d1
            java.lang.Object r3 = r19.a()
            java.lang.Object r4 = r19.a()
            r2.put(r3, r4)
            int r8 = r8 + 1
            goto L_0x04bf
        L_0x04d1:
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x04d6:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r3 = r0.f27184s
            if (r3 != r9) goto L_0x0503
            java.lang.Object r3 = r19.a()
            if (r3 == 0) goto L_0x04ff
            java.lang.Class r4 = r3.getClass()
            boolean r4 = r4.isArray()
            if (r4 == 0) goto L_0x04ff
            int r4 = java.lang.reflect.Array.getLength(r3)
        L_0x04f3:
            if (r8 >= r4) goto L_0x0511
            java.lang.Object r5 = java.lang.reflect.Array.get(r3, r8)
            r2.add(r5)
            int r8 = r8 + 1
            goto L_0x04f3
        L_0x04ff:
            r2.add(r3)
            goto L_0x0511
        L_0x0503:
            int r3 = r0.f27184s
            if (r8 >= r3) goto L_0x0511
            java.lang.Object r3 = r19.a()
            r2.add(r3)
            int r8 = r8 + 1
            goto L_0x0503
        L_0x0511:
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0516:
            java.lang.Object r2 = r19.a()
            int r3 = r0.f27176k
            if (r3 != r4) goto L_0x052e
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r2 = r2 ^ r9
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x052e:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = r0.f27167b
            r2.append(r3)
            r2.append(r7)
            int r3 = r0.f27168c
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0550:
            java.lang.Object r2 = r19.a()
            java.lang.Object r3 = r19.a()
            int r4 = r0.f27176k
            switch(r4) {
                case 12: goto L_0x0e81;
                case 13: goto L_0x0e41;
                case 14: goto L_0x0e0d;
                case 15: goto L_0x0dd9;
                case 16: goto L_0x0da5;
                case 17: goto L_0x0d71;
                case 18: goto L_0x0ae9;
                case 19: goto L_0x0ada;
                case 20: goto L_0x09d2;
                case 21: goto L_0x08f3;
                case 22: goto L_0x0816;
                case 23: goto L_0x0739;
                case 24: goto L_0x065c;
                case 25: goto L_0x057f;
                default: goto L_0x055d;
            }
        L_0x055d:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = r0.f27167b
            r2.append(r3)
            r2.append(r7)
            int r3 = r0.f27168c
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x057f:
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L_0x063a
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x063a
            boolean r4 = r2 instanceof java.lang.Double
            if (r4 != 0) goto L_0x0624
            boolean r4 = r3 instanceof java.lang.Double
            if (r4 == 0) goto L_0x0591
            goto L_0x0624
        L_0x0591:
            boolean r4 = r2 instanceof java.lang.Float
            if (r4 != 0) goto L_0x060e
            boolean r4 = r3 instanceof java.lang.Float
            if (r4 == 0) goto L_0x059b
            goto L_0x060e
        L_0x059b:
            boolean r4 = r2 instanceof java.lang.Long
            if (r4 != 0) goto L_0x05f8
            boolean r4 = r3 instanceof java.lang.Long
            if (r4 == 0) goto L_0x05a4
            goto L_0x05f8
        L_0x05a4:
            boolean r4 = r2 instanceof java.lang.Integer
            if (r4 != 0) goto L_0x05e2
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x05ad
            goto L_0x05e2
        L_0x05ad:
            boolean r4 = r2 instanceof java.lang.Short
            if (r4 != 0) goto L_0x05cc
            boolean r4 = r3 instanceof java.lang.Short
            if (r4 == 0) goto L_0x05b6
            goto L_0x05cc
        L_0x05b6:
            java.lang.Number r2 = (java.lang.Number) r2
            byte r2 = r2.byteValue()
            java.lang.Number r3 = (java.lang.Number) r3
            byte r3 = r3.byteValue()
            int r2 = r2 % r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x05cc:
            java.lang.Number r2 = (java.lang.Number) r2
            short r2 = r2.shortValue()
            java.lang.Number r3 = (java.lang.Number) r3
            short r3 = r3.shortValue()
            int r2 = r2 % r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x05e2:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            int r2 = r2 % r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x05f8:
            java.lang.Number r2 = (java.lang.Number) r2
            long r4 = r2.longValue()
            java.lang.Number r3 = (java.lang.Number) r3
            long r2 = r3.longValue()
            long r4 = r4 % r2
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x060e:
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r2 = r2 % r3
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0624:
            java.lang.Number r2 = (java.lang.Number) r2
            double r4 = r2.doubleValue()
            java.lang.Number r3 = (java.lang.Number) r3
            double r2 = r3.doubleValue()
            double r4 = r4 % r2
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x063a:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = r0.f27167b
            r2.append(r3)
            r2.append(r7)
            int r3 = r0.f27168c
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x065c:
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0717
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0717
            boolean r4 = r2 instanceof java.lang.Double
            if (r4 != 0) goto L_0x0701
            boolean r4 = r3 instanceof java.lang.Double
            if (r4 == 0) goto L_0x066e
            goto L_0x0701
        L_0x066e:
            boolean r4 = r2 instanceof java.lang.Float
            if (r4 != 0) goto L_0x06eb
            boolean r4 = r3 instanceof java.lang.Float
            if (r4 == 0) goto L_0x0678
            goto L_0x06eb
        L_0x0678:
            boolean r4 = r2 instanceof java.lang.Long
            if (r4 != 0) goto L_0x06d5
            boolean r4 = r3 instanceof java.lang.Long
            if (r4 == 0) goto L_0x0681
            goto L_0x06d5
        L_0x0681:
            boolean r4 = r2 instanceof java.lang.Integer
            if (r4 != 0) goto L_0x06bf
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x068a
            goto L_0x06bf
        L_0x068a:
            boolean r4 = r2 instanceof java.lang.Short
            if (r4 != 0) goto L_0x06a9
            boolean r4 = r3 instanceof java.lang.Short
            if (r4 == 0) goto L_0x0693
            goto L_0x06a9
        L_0x0693:
            java.lang.Number r2 = (java.lang.Number) r2
            byte r2 = r2.byteValue()
            java.lang.Number r3 = (java.lang.Number) r3
            byte r3 = r3.byteValue()
            int r2 = r2 / r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x06a9:
            java.lang.Number r2 = (java.lang.Number) r2
            short r2 = r2.shortValue()
            java.lang.Number r3 = (java.lang.Number) r3
            short r3 = r3.shortValue()
            int r2 = r2 / r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x06bf:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            int r2 = r2 / r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x06d5:
            java.lang.Number r2 = (java.lang.Number) r2
            long r4 = r2.longValue()
            java.lang.Number r3 = (java.lang.Number) r3
            long r2 = r3.longValue()
            long r4 = r4 / r2
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x06eb:
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r2 = r2 / r3
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0701:
            java.lang.Number r2 = (java.lang.Number) r2
            double r4 = r2.doubleValue()
            java.lang.Number r3 = (java.lang.Number) r3
            double r2 = r3.doubleValue()
            double r4 = r4 / r2
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0717:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = r0.f27167b
            r2.append(r3)
            r2.append(r7)
            int r3 = r0.f27168c
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0739:
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L_0x07f4
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x07f4
            boolean r4 = r2 instanceof java.lang.Double
            if (r4 != 0) goto L_0x07de
            boolean r4 = r3 instanceof java.lang.Double
            if (r4 == 0) goto L_0x074b
            goto L_0x07de
        L_0x074b:
            boolean r4 = r2 instanceof java.lang.Float
            if (r4 != 0) goto L_0x07c8
            boolean r4 = r3 instanceof java.lang.Float
            if (r4 == 0) goto L_0x0755
            goto L_0x07c8
        L_0x0755:
            boolean r4 = r2 instanceof java.lang.Long
            if (r4 != 0) goto L_0x07b2
            boolean r4 = r3 instanceof java.lang.Long
            if (r4 == 0) goto L_0x075e
            goto L_0x07b2
        L_0x075e:
            boolean r4 = r2 instanceof java.lang.Integer
            if (r4 != 0) goto L_0x079c
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x0767
            goto L_0x079c
        L_0x0767:
            boolean r4 = r2 instanceof java.lang.Short
            if (r4 != 0) goto L_0x0786
            boolean r4 = r3 instanceof java.lang.Short
            if (r4 == 0) goto L_0x0770
            goto L_0x0786
        L_0x0770:
            java.lang.Number r2 = (java.lang.Number) r2
            byte r2 = r2.byteValue()
            java.lang.Number r3 = (java.lang.Number) r3
            byte r3 = r3.byteValue()
            int r2 = r2 * r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0786:
            java.lang.Number r2 = (java.lang.Number) r2
            short r2 = r2.shortValue()
            java.lang.Number r3 = (java.lang.Number) r3
            short r3 = r3.shortValue()
            int r2 = r2 * r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x079c:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            int r2 = r2 * r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x07b2:
            java.lang.Number r2 = (java.lang.Number) r2
            long r4 = r2.longValue()
            java.lang.Number r3 = (java.lang.Number) r3
            long r2 = r3.longValue()
            long r4 = r4 * r2
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x07c8:
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r2 = r2 * r3
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x07de:
            java.lang.Number r2 = (java.lang.Number) r2
            double r4 = r2.doubleValue()
            java.lang.Number r3 = (java.lang.Number) r3
            double r2 = r3.doubleValue()
            double r4 = r4 * r2
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x07f4:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = r0.f27167b
            r2.append(r3)
            r2.append(r7)
            int r3 = r0.f27168c
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0816:
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L_0x08d1
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x08d1
            boolean r4 = r2 instanceof java.lang.Double
            if (r4 != 0) goto L_0x08bb
            boolean r4 = r3 instanceof java.lang.Double
            if (r4 == 0) goto L_0x0828
            goto L_0x08bb
        L_0x0828:
            boolean r4 = r2 instanceof java.lang.Float
            if (r4 != 0) goto L_0x08a5
            boolean r4 = r3 instanceof java.lang.Float
            if (r4 == 0) goto L_0x0832
            goto L_0x08a5
        L_0x0832:
            boolean r4 = r2 instanceof java.lang.Long
            if (r4 != 0) goto L_0x088f
            boolean r4 = r3 instanceof java.lang.Long
            if (r4 == 0) goto L_0x083b
            goto L_0x088f
        L_0x083b:
            boolean r4 = r2 instanceof java.lang.Integer
            if (r4 != 0) goto L_0x0879
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x0844
            goto L_0x0879
        L_0x0844:
            boolean r4 = r2 instanceof java.lang.Short
            if (r4 != 0) goto L_0x0863
            boolean r4 = r3 instanceof java.lang.Short
            if (r4 == 0) goto L_0x084d
            goto L_0x0863
        L_0x084d:
            java.lang.Number r2 = (java.lang.Number) r2
            byte r2 = r2.byteValue()
            java.lang.Number r3 = (java.lang.Number) r3
            byte r3 = r3.byteValue()
            int r2 = r2 - r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0863:
            java.lang.Number r2 = (java.lang.Number) r2
            short r2 = r2.shortValue()
            java.lang.Number r3 = (java.lang.Number) r3
            short r3 = r3.shortValue()
            int r2 = r2 - r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0879:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            int r2 = r2 - r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x088f:
            java.lang.Number r2 = (java.lang.Number) r2
            long r4 = r2.longValue()
            java.lang.Number r3 = (java.lang.Number) r3
            long r2 = r3.longValue()
            long r4 = r4 - r2
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x08a5:
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r2 = r2 - r3
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x08bb:
            java.lang.Number r2 = (java.lang.Number) r2
            double r4 = r2.doubleValue()
            java.lang.Number r3 = (java.lang.Number) r3
            double r2 = r3.doubleValue()
            double r4 = r4 - r2
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x08d1:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = r0.f27167b
            r2.append(r3)
            r2.append(r7)
            int r3 = r0.f27168c
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x08f3:
            java.lang.String r4 = "null"
            if (r2 != 0) goto L_0x08f8
            r2 = r4
        L_0x08f8:
            if (r3 != 0) goto L_0x08fb
            r3 = r4
        L_0x08fb:
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L_0x09b6
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x09b6
            boolean r4 = r2 instanceof java.lang.Double
            if (r4 != 0) goto L_0x09a0
            boolean r4 = r3 instanceof java.lang.Double
            if (r4 == 0) goto L_0x090d
            goto L_0x09a0
        L_0x090d:
            boolean r4 = r2 instanceof java.lang.Float
            if (r4 != 0) goto L_0x098a
            boolean r4 = r3 instanceof java.lang.Float
            if (r4 == 0) goto L_0x0917
            goto L_0x098a
        L_0x0917:
            boolean r4 = r2 instanceof java.lang.Long
            if (r4 != 0) goto L_0x0974
            boolean r4 = r3 instanceof java.lang.Long
            if (r4 == 0) goto L_0x0920
            goto L_0x0974
        L_0x0920:
            boolean r4 = r2 instanceof java.lang.Integer
            if (r4 != 0) goto L_0x095e
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x0929
            goto L_0x095e
        L_0x0929:
            boolean r4 = r2 instanceof java.lang.Short
            if (r4 != 0) goto L_0x0948
            boolean r4 = r3 instanceof java.lang.Short
            if (r4 == 0) goto L_0x0932
            goto L_0x0948
        L_0x0932:
            java.lang.Number r2 = (java.lang.Number) r2
            byte r2 = r2.byteValue()
            java.lang.Number r3 = (java.lang.Number) r3
            byte r3 = r3.byteValue()
            int r2 = r2 + r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0948:
            java.lang.Number r2 = (java.lang.Number) r2
            short r2 = r2.shortValue()
            java.lang.Number r3 = (java.lang.Number) r3
            short r3 = r3.shortValue()
            int r2 = r2 + r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x095e:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            int r2 = r2 + r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0974:
            java.lang.Number r2 = (java.lang.Number) r2
            long r4 = r2.longValue()
            java.lang.Number r3 = (java.lang.Number) r3
            long r2 = r3.longValue()
            long r4 = r4 + r2
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x098a:
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r2 = r2 + r3
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x09a0:
            java.lang.Number r2 = (java.lang.Number) r2
            double r4 = r2.doubleValue()
            java.lang.Number r3 = (java.lang.Number) r3
            double r2 = r3.doubleValue()
            double r4 = r4 + r2
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x09b6:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r4.append(r2)
            java.lang.String r2 = java.lang.String.valueOf(r3)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x09d2:
            boolean r1 = r2 instanceof java.util.Collection
            if (r1 == 0) goto L_0x09ea
            boolean r1 = r3 instanceof java.util.Collection
            if (r1 == 0) goto L_0x09e3
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Collection r3 = (java.util.Collection) r3
            r2.addAll(r3)
            goto L_0x0ed7
        L_0x09e3:
            java.util.Collection r2 = (java.util.Collection) r2
            r2.add(r3)
            goto L_0x0ed7
        L_0x09ea:
            boolean r1 = r2 instanceof java.util.Map
            if (r1 == 0) goto L_0x09fb
            boolean r1 = r3 instanceof java.util.Map
            if (r1 == 0) goto L_0x09fb
            java.util.Map r2 = (java.util.Map) r2
            java.util.Map r3 = (java.util.Map) r3
            r2.putAll(r3)
            goto L_0x0ed7
        L_0x09fb:
            boolean r1 = r3 instanceof java.lang.String
            if (r1 == 0) goto L_0x0a0e
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "utf-8"
            byte[] r3 = r3.getBytes(r4)
            r1.<init>(r3)
        L_0x0a0c:
            r3 = r9
            goto L_0x0a51
        L_0x0a0e:
            boolean r1 = r3 instanceof byte[]
            if (r1 == 0) goto L_0x0a1a
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            byte[] r3 = (byte[]) r3
            r1.<init>(r3)
            goto L_0x0a0c
        L_0x0a1a:
            boolean r1 = r3 instanceof java.io.File
            if (r1 == 0) goto L_0x0a26
            java.io.FileInputStream r1 = new java.io.FileInputStream
            java.io.File r3 = (java.io.File) r3
            r1.<init>(r3)
            goto L_0x0a0c
        L_0x0a26:
            boolean r1 = r3 instanceof java.io.InputStream
            if (r1 == 0) goto L_0x0a2f
            r1 = r3
            java.io.InputStream r1 = (java.io.InputStream) r1
            r3 = r8
            goto L_0x0a51
        L_0x0a2f:
            boolean r1 = r3 instanceof java.io.Serializable
            if (r1 == 0) goto L_0x0ab8
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream
            r4.<init>(r1)
            r4.writeObject(r3)
            r4.flush()
            r4.close()
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            byte[] r1 = r1.toByteArray()
            r3.<init>(r1)
            r1 = r3
            goto L_0x0a0c
        L_0x0a51:
            boolean r4 = r2 instanceof java.io.File
            if (r4 == 0) goto L_0x0a6e
            java.io.File r2 = (java.io.File) r2
            java.io.File r4 = r2.getParentFile()
            boolean r4 = r4.exists()
            if (r4 != 0) goto L_0x0a68
            java.io.File r4 = r2.getParentFile()
            r4.mkdirs()
        L_0x0a68:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream
            r4.<init>(r2, r9)
            goto L_0x0a76
        L_0x0a6e:
            boolean r3 = r2 instanceof java.io.OutputStream
            if (r3 == 0) goto L_0x0a96
            r4 = r2
            java.io.OutputStream r4 = (java.io.OutputStream) r4
            r3 = r8
        L_0x0a76:
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]
            int r5 = r1.read(r2)
        L_0x0a7e:
            r6 = -1
            if (r5 == r6) goto L_0x0a89
            r4.write(r2, r8, r5)
            int r5 = r1.read(r2)
            goto L_0x0a7e
        L_0x0a89:
            r4.flush()
            if (r3 == 0) goto L_0x0a91
            r1.close()
        L_0x0a91:
            r4.close()
            goto L_0x0ed7
        L_0x0a96:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = r0.f27167b
            r2.append(r3)
            r2.append(r7)
            int r3 = r0.f27168c
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0ab8:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = r0.f27167b
            r2.append(r3)
            r2.append(r7)
            int r3 = r0.f27168c
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0ada:
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r2 = r3.isInstance(r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0ae9:
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0afe
            if (r2 != 0) goto L_0x0af5
            r2 = 0
            goto L_0x0af9
        L_0x0af5:
            java.lang.String r2 = java.lang.String.valueOf(r2)
        L_0x0af9:
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0afe:
            java.lang.Class<java.lang.Number> r4 = java.lang.Number.class
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0b47
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "."
            boolean r3 = r2.contains(r3)
            if (r3 == 0) goto L_0x0b2a
            float r3 = java.lang.Float.parseFloat(r2)     // Catch:{ all -> 0x0b1b }
            java.lang.Float r2 = java.lang.Float.valueOf(r3)     // Catch:{ all -> 0x0b1b }
            goto L_0x0b42
        L_0x0b1b:
            double r3 = java.lang.Double.parseDouble(r2)     // Catch:{ all -> 0x0b24 }
            java.lang.Double r2 = java.lang.Double.valueOf(r3)     // Catch:{ all -> 0x0b24 }
            goto L_0x0b42
        L_0x0b24:
            java.math.BigDecimal r3 = new java.math.BigDecimal
            r3.<init>(r2)
            goto L_0x0b41
        L_0x0b2a:
            int r3 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0b33 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0b33 }
            goto L_0x0b42
        L_0x0b33:
            long r3 = java.lang.Long.parseLong(r2)     // Catch:{ all -> 0x0b3c }
            java.lang.Long r2 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0b3c }
            goto L_0x0b42
        L_0x0b3c:
            java.math.BigInteger r3 = new java.math.BigInteger
            r3.<init>(r2)
        L_0x0b41:
            r2 = r3
        L_0x0b42:
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0b47:
            java.lang.Class<java.lang.Double> r4 = java.lang.Double.class
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0d64
            java.lang.Class r4 = java.lang.Double.TYPE
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0b59
            goto L_0x0d64
        L_0x0b59:
            java.lang.Class<java.lang.Float> r4 = java.lang.Float.class
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0d4f
            java.lang.Class r4 = java.lang.Float.TYPE
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0b6b
            goto L_0x0d4f
        L_0x0b6b:
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0d3a
            java.lang.Class r4 = java.lang.Integer.TYPE
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0b7d
            goto L_0x0d3a
        L_0x0b7d:
            java.lang.Class<java.lang.Long> r4 = java.lang.Long.class
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0d25
            java.lang.Class r4 = java.lang.Long.TYPE
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0b8f
            goto L_0x0d25
        L_0x0b8f:
            java.lang.Class<java.lang.Short> r4 = java.lang.Short.class
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0d10
            java.lang.Class r4 = java.lang.Short.TYPE
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0ba1
            goto L_0x0d10
        L_0x0ba1:
            java.lang.Class<java.lang.Character> r4 = java.lang.Character.class
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0c73
            java.lang.Class r4 = java.lang.Character.TYPE
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0bb3
            goto L_0x0c73
        L_0x0bb3:
            java.lang.Class<java.lang.Byte> r4 = java.lang.Byte.class
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0c5e
            java.lang.Class r4 = java.lang.Byte.TYPE
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0bc5
            goto L_0x0c5e
        L_0x0bc5:
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0c27
            if (r2 != 0) goto L_0x0bd6
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0bd6:
            boolean r3 = r2 instanceof java.lang.Number
            if (r3 == 0) goto L_0x0bf6
            java.lang.String r2 = r2.toString()
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            double r2 = r2.doubleValue()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0bed
            r8 = r9
        L_0x0bed:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0bf6:
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x0c17
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.trim()
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r3 = "004iDdjdg,f"
            java.lang.String r3 = com.mob.commons.s.a((java.lang.String) r3)
            boolean r2 = r2.equals(r3)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0c17:
            boolean r3 = r2 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x0c20
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0c20:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0c27:
            java.lang.Class<java.math.BigInteger> r4 = java.math.BigInteger.class
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0c3d
            java.math.BigInteger r3 = new java.math.BigInteger
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3.<init>(r2)
            r1.a((java.lang.Object) r3)
            goto L_0x0ed7
        L_0x0c3d:
            java.lang.Class<java.math.BigDecimal> r4 = java.math.BigDecimal.class
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0c53
            java.math.BigDecimal r3 = new java.math.BigDecimal
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3.<init>(r2)
            r1.a((java.lang.Object) r3)
            goto L_0x0ed7
        L_0x0c53:
            java.lang.Class r3 = (java.lang.Class) r3
            java.lang.Object r2 = r3.cast(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0c5e:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            byte r2 = r2.byteValue()
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0c73:
            boolean r3 = r2 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x0c87
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            char r2 = (char) r2
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0c87:
            boolean r3 = r2 instanceof java.lang.Long
            if (r3 == 0) goto L_0x0c9c
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            int r2 = (int) r2
            char r2 = (char) r2
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0c9c:
            boolean r3 = r2 instanceof java.lang.Short
            if (r3 == 0) goto L_0x0cb0
            java.lang.Short r2 = (java.lang.Short) r2
            short r2 = r2.shortValue()
            char r2 = (char) r2
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0cb0:
            boolean r3 = r2 instanceof java.lang.Byte
            if (r3 == 0) goto L_0x0cc4
            java.lang.Byte r2 = (java.lang.Byte) r2
            byte r2 = r2.byteValue()
            char r2 = (char) r2
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0cc4:
            boolean r3 = r2 instanceof java.lang.Double
            if (r3 == 0) goto L_0x0cd9
            java.lang.Double r2 = (java.lang.Double) r2
            double r2 = r2.doubleValue()
            int r2 = (int) r2
            char r2 = (char) r2
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0cd9:
            boolean r3 = r2 instanceof java.lang.Float
            if (r3 == 0) goto L_0x0cee
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            int r2 = (int) r2
            char r2 = (char) r2
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0cee:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = r0.f27167b
            r2.append(r3)
            r2.append(r7)
            int r3 = r0.f27168c
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0d10:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            short r2 = r2.shortValue()
            java.lang.Short r2 = java.lang.Short.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0d25:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            long r2 = r2.longValue()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0d3a:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            int r2 = r2.intValue()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0d4f:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            float r2 = r2.floatValue()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0d64:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0d71:
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0d93
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0d93
            java.lang.Number r2 = (java.lang.Number) r2
            double r4 = r2.doubleValue()
            java.lang.Number r3 = (java.lang.Number) r3
            double r2 = r3.doubleValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0d8a
            r8 = r9
        L_0x0d8a:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0d93:
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r2.compareTo(r3)
            if (r2 < 0) goto L_0x0d9c
            r8 = r9
        L_0x0d9c:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0da5:
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0dc7
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0dc7
            java.lang.Number r2 = (java.lang.Number) r2
            double r4 = r2.doubleValue()
            java.lang.Number r3 = (java.lang.Number) r3
            double r2 = r3.doubleValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0dbe
            r8 = r9
        L_0x0dbe:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0dc7:
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r2.compareTo(r3)
            if (r2 > 0) goto L_0x0dd0
            r8 = r9
        L_0x0dd0:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0dd9:
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0dfb
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0dfb
            java.lang.Number r2 = (java.lang.Number) r2
            double r4 = r2.doubleValue()
            java.lang.Number r3 = (java.lang.Number) r3
            double r2 = r3.doubleValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0df2
            r8 = r9
        L_0x0df2:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0dfb:
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r2.compareTo(r3)
            if (r2 <= 0) goto L_0x0e04
            r8 = r9
        L_0x0e04:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0e0d:
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0e2f
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0e2f
            java.lang.Number r2 = (java.lang.Number) r2
            double r4 = r2.doubleValue()
            java.lang.Number r3 = (java.lang.Number) r3
            double r2 = r3.doubleValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0e26
            r8 = r9
        L_0x0e26:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0e2f:
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r2.compareTo(r3)
            if (r2 >= 0) goto L_0x0e38
            r8 = r9
        L_0x0e38:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0e41:
            if (r2 != 0) goto L_0x0e53
            if (r3 != 0) goto L_0x0e4c
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0e4c:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0e53:
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0e74
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0e74
            java.lang.Number r2 = (java.lang.Number) r2
            double r4 = r2.doubleValue()
            java.lang.Number r3 = (java.lang.Number) r3
            double r2 = r3.doubleValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0e6c
            r8 = r9
        L_0x0e6c:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0e74:
            boolean r2 = r2.equals(r3)
            r2 = r2 ^ r9
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0e81:
            if (r2 != 0) goto L_0x0e91
            if (r3 != 0) goto L_0x0e8b
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0e8b:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0e91:
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0eb2
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L_0x0eb2
            java.lang.Number r2 = (java.lang.Number) r2
            double r4 = r2.doubleValue()
            java.lang.Number r3 = (java.lang.Number) r3
            double r2 = r3.doubleValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0eaa
            r8 = r9
        L_0x0eaa:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0eb2:
            boolean r2 = r2.equals(r3)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0ebe:
            java.lang.String r2 = r0.f27173h
            java.lang.Object r2 = r1.b(r2)
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0ec8:
            java.lang.Object r2 = r0.f27182q
            r1.a((java.lang.Object) r2)
            goto L_0x0ed7
        L_0x0ece:
            java.lang.String r2 = r0.f27173h
            java.lang.Object r3 = r19.a()
            r1.b(r2, r3)
        L_0x0ed7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.cc.y.a(com.mob.commons.cc.y$a):void");
    }

    public void a(Object obj, s sVar) throws Throwable {
        if (obj instanceof Map) {
            sVar.a(((Map) obj).get(this.f27177l));
        } else if (!s.a("006gfe>ej1ih").equals(this.f27177l) || !obj.getClass().isArray()) {
            Class cls = obj.getClass();
            while (cls != null) {
                Field field = null;
                try {
                    field = cls.getDeclaredField(this.f27177l);
                } catch (Throwable unused) {
                }
                if (field == null || Modifier.isStatic(field.getModifiers())) {
                    cls = cls.getSuperclass();
                } else {
                    field.setAccessible(true);
                    sVar.a(field.get(obj));
                    return;
                }
            }
            y yVar = new y(12);
            yVar.f27167b = this.f27167b;
            yVar.f27168c = this.f27168c;
            yVar.f27181p = s.a("0039ej>fi") + Character.toUpperCase(this.f27177l.charAt(0)) + this.f27177l.substring(1);
            yVar.f27174i = 0;
            yVar.a(obj, new Object[0], sVar);
        } else {
            sVar.a((Object) Integer.valueOf(Array.getLength(obj)));
        }
    }

    public void a(Class<?> cls, s sVar) throws Throwable {
        Class<? super Object> cls2;
        Field field;
        while (true) {
            Class<? super Object> cls3 = cls;
            if (cls3 == null) {
                y yVar = new y(14);
                yVar.f27167b = this.f27167b;
                yVar.f27168c = this.f27168c;
                yVar.f27179n = this.f27179n;
                yVar.f27181p = s.a("003Qej(fi") + Character.toUpperCase(this.f27177l.charAt(0)) + this.f27177l.substring(1);
                yVar.f27174i = 1;
                yVar.a((Class<?>) cls3, new Object[0], sVar);
                return;
            } else if (Constants.CLASS.equals(this.f27177l)) {
                sVar.a((Object) cls3);
                return;
            } else if (!cls3.equals(x.class) || !s.a("007+ddGfAdjfididk'e").equals(this.f27177l)) {
                if (cls3.isEnum()) {
                    Object[] enumConstants = cls3.getEnumConstants();
                    if (enumConstants != null) {
                        for (Object obj : enumConstants) {
                            if (((Enum) obj).name().equals(this.f27177l)) {
                                sVar.a(obj);
                                return;
                            }
                        }
                        cls2 = cls3;
                        continue;
                    } else {
                        cls2 = cls3;
                        continue;
                    }
                } else {
                    try {
                        field = cls3.getDeclaredField(this.f27177l);
                    } catch (Throwable unused) {
                        field = null;
                    }
                    if (field == null || !Modifier.isStatic(field.getModifiers())) {
                        cls2 = cls3.getSuperclass();
                    } else {
                        field.setAccessible(true);
                        sVar.a(field.get((Object) null));
                        return;
                    }
                }
                cls3 = cls2;
            } else {
                sVar.a((Object) 70);
                return;
            }
        }
    }

    public void a(Class<?> cls, Object[] objArr, s sVar) throws Throwable {
        Class[] parameterTypes;
        boolean[] zArr;
        boolean[] a11;
        Map map;
        List list;
        Class<?> cls2 = cls;
        Object[] objArr2 = objArr;
        s sVar2 = sVar;
        if (ChainInfo.CHAIN_TYPE_NEW.equals(this.f27181p)) {
            if (List.class.isAssignableFrom(cls2) && objArr2.length == 1 && objArr2[0] != null && objArr2[0].getClass().isArray()) {
                int length = Array.getLength(objArr2[0]);
                if (cls2.equals(List.class)) {
                    list = new ArrayList(length);
                } else {
                    list = (List) cls.newInstance();
                }
                for (int i11 = 0; i11 < length; i11++) {
                    list.add(Array.get(objArr2[0], i11));
                }
                sVar2.a((Object) list);
            } else if (Map.class.isAssignableFrom(cls2) && objArr2.length == 1 && objArr2[0] != null) {
                if (cls2.equals(Map.class)) {
                    map = new HashMap();
                } else {
                    map = (Map) cls.newInstance();
                }
                if (objArr2[0] instanceof Map) {
                    map.putAll((Map) objArr2[0]);
                } else {
                    Class<?> cls3 = Class.forName("org.json.JSONObject");
                    a(map, a(objArr2[0], cls3), cls3, Class.forName("org.json.JSONArray"));
                }
                sVar2.a((Object) map);
            } else if (!cls2.equals(aa.class)) {
                boolean[][] zArr2 = new boolean[2][];
                Constructor a12 = sVar.g().a(cls2, objArr2, zArr2);
                if (a12 != null) {
                    Object[] a13 = !zArr2[1][0] ? sVar.g().a(sVar2, a12.getParameterTypes(), objArr2, zArr2[0]) : objArr2;
                    a12.setAccessible(true);
                    sVar2.a(a12.newInstance(a13));
                    return;
                }
                for (Constructor constructor : cls.getDeclaredConstructors()) {
                    Class[] parameterTypes2 = constructor.getParameterTypes();
                    boolean[] zArr3 = new boolean[1];
                    boolean[] a14 = sVar.g().a((Class<?>[]) parameterTypes2, objArr2, zArr3);
                    if (a14 != null) {
                        Object[] a15 = !zArr3[0] ? sVar.g().a(sVar2, parameterTypes2, objArr2, a14) : objArr2;
                        constructor.setAccessible(true);
                        sVar2.a(constructor.newInstance(a15));
                        return;
                    }
                }
                throw new NoSuchMethodException("method name: new at line: " + this.f27167b + "(" + this.f27168c + ")");
            } else if (objArr2.length == 2) {
                sVar2.a((Object) new aa((Number) objArr2[0], (Number) objArr2[1], (Number) null));
            } else if (objArr2.length == 3) {
                sVar2.a((Object) new aa((Number) objArr2[0], (Number) objArr2[1], (Number) objArr2[2]));
            } else {
                throw new NoSuchMethodException("method name: new at line: " + this.f27167b + "(" + this.f27168c + ")");
            }
        } else if (!"fromJson".equals(this.f27181p) || !Map.class.isAssignableFrom(cls2) || objArr2.length != 1 || objArr2[0] == null) {
            if (cls2.equals(Array.class)) {
                if (this.f27181p.equals(s.a("011ef%fgeeAeTfi8idecf")) && objArr2.length == 2 && (objArr2[1] instanceof Integer)) {
                    sVar2.a(Array.newInstance((Class) objArr2[0], ((Integer) objArr2[1]).intValue()));
                    return;
                } else if ("copy".equals(this.f27181p)) {
                    int i12 = this.f27174i;
                    if (i12 == 5) {
                        System.arraycopy(objArr2[0], Integer.parseInt(String.valueOf(objArr2[1])), objArr2[2], Integer.parseInt(String.valueOf(objArr2[3])), Integer.parseInt(String.valueOf(objArr2[44])));
                        return;
                    } else if (i12 == 2) {
                        System.arraycopy(objArr2[0], 0, objArr2[1], 0, Math.min(Array.getLength(objArr2[0]), Array.getLength(objArr2[1])));
                        return;
                    } else {
                        throw new NoSuchMethodException("method name: copy at line: " + this.f27167b + "(" + this.f27168c + ")");
                    }
                }
            } else if ("quit".equals(this.f27181p) && cls2.equals(x.class)) {
                sVar.e();
                return;
            }
            if (!sVar.g().a((Object) null, cls, this.f27181p, objArr, sVar)) {
                Class<?> cls4 = cls2;
                while (cls4 != null) {
                    boolean[][] zArr4 = new boolean[2][];
                    boolean[][] zArr5 = zArr4;
                    Method a16 = sVar.g().a(cls4, this.f27181p, true, objArr, zArr4);
                    if (a16 != null) {
                        Object[] a17 = !zArr5[1][0] ? sVar.g().a(sVar2, a16.getParameterTypes(), objArr2, zArr5[0]) : objArr2;
                        a16.setAccessible(true);
                        if (a16.getReturnType() == Void.TYPE) {
                            a16.invoke((Object) null, a17);
                            return;
                        } else {
                            sVar2.a(a16.invoke((Object) null, a17));
                            return;
                        }
                    } else {
                        cls4 = cls4.getSuperclass();
                    }
                }
                while (cls2 != null) {
                    Method[] declaredMethods = cls2.getDeclaredMethods();
                    int length2 = declaredMethods.length;
                    int i13 = 0;
                    while (i13 < length2) {
                        Method method = declaredMethods[i13];
                        if (!method.getName().equals(this.f27181p) || !Modifier.isStatic(method.getModifiers()) || (a11 = sVar.g().a((Class<?>[]) parameterTypes, objArr2, zArr)) == null) {
                            i13++;
                        } else {
                            Object[] a18 = !(zArr = new boolean[1])[0] ? sVar.g().a(sVar2, (parameterTypes = method.getParameterTypes()), objArr2, a11) : objArr2;
                            method.setAccessible(true);
                            if (method.getReturnType() == Void.TYPE) {
                                method.invoke((Object) null, a18);
                                return;
                            } else {
                                sVar2.a(method.invoke((Object) null, a18));
                                return;
                            }
                        }
                    }
                    cls2 = cls2.getSuperclass();
                }
                throw new NoSuchMethodException("method name: " + this.f27181p + " at line: " + this.f27167b + "(" + this.f27168c + ")");
            }
        } else {
            this.f27181p = ChainInfo.CHAIN_TYPE_NEW;
            a(cls, objArr, sVar);
        }
    }

    private Object a(Object obj, Class<?> cls) throws Throwable {
        if (obj instanceof ByteArrayOutputStream) {
            return a((Object) ((ByteArrayOutputStream) obj).toByteArray(), cls);
        }
        if (obj instanceof byte[]) {
            return a((Object) new String((byte[]) obj, "utf-8"), cls);
        }
        if ((obj instanceof StringBuffer) || (obj instanceof StringBuilder)) {
            return a((Object) obj.toString(), cls);
        }
        if (obj instanceof String) {
            return cls.getConstructor(new Class[]{String.class}).newInstance(new Object[]{obj});
        } else if (obj.getClass().equals(cls)) {
            return obj;
        } else {
            throw new ClassCastException("Failed to cast " + obj + " to be " + cls.getName() + " at line: " + this.f27167b + "(" + this.f27168c + ")");
        }
    }

    private void a(Map map, Object obj, Class<?> cls, Class<?> cls2) throws Throwable {
        Field declaredField = cls.getDeclaredField("nameValuePairs");
        declaredField.setAccessible(true);
        Field declaredField2 = cls.getDeclaredField("NULL");
        declaredField2.setAccessible(true);
        Object obj2 = declaredField2.get((Object) null);
        for (Map.Entry entry : ((Map) declaredField.get(obj)).entrySet()) {
            map.put(entry.getKey(), a(entry.getValue(), obj2, cls, cls2));
        }
    }

    private Object a(Object obj, Object obj2, Class<?> cls, Class<?> cls2) throws Throwable {
        if (obj == null || obj2.equals(obj)) {
            return null;
        }
        if (obj.getClass().equals(cls)) {
            HashMap hashMap = new HashMap();
            a((Map) hashMap, obj, cls, cls2);
            return hashMap;
        } else if (!obj.getClass().equals(cls2)) {
            return obj;
        } else {
            Field declaredField = cls2.getDeclaredField("values");
            declaredField.setAccessible(true);
            ArrayList arrayList = new ArrayList();
            for (Object a11 : (List) declaredField.get(obj)) {
                arrayList.add(a(a11, obj2, cls, cls2));
            }
            return arrayList;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v60, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v65, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v36 */
    /* JADX WARNING: type inference failed for: r3v44, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r3v47, types: [java.util.Collection] */
    /* JADX WARNING: type inference failed for: r3v53, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v58 */
    /* JADX WARNING: type inference failed for: r3v59 */
    /* JADX WARNING: type inference failed for: r0v125, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r3v130 */
    /* JADX WARNING: type inference failed for: r3v131 */
    /* JADX WARNING: type inference failed for: r3v132 */
    /* JADX WARNING: type inference failed for: r3v133 */
    /* JADX WARNING: type inference failed for: r3v134 */
    /* JADX WARNING: type inference failed for: r3v135 */
    /* JADX WARNING: type inference failed for: r3v136 */
    /* JADX WARNING: type inference failed for: r3v137 */
    /* JADX WARNING: type inference failed for: r3v138 */
    /* JADX WARNING: type inference failed for: r3v139 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.Object r18, java.lang.Object[] r19, com.mob.commons.cc.s r20) throws java.lang.Throwable {
        /*
            r17 = this;
            r1 = r17
            r8 = r18
            r0 = r19
            r9 = r20
            boolean r2 = r8 instanceof java.util.Map
            r10 = 2
            r11 = 1
            r12 = 0
            if (r2 == 0) goto L_0x010d
            r2 = r8
            java.util.Map r2 = (java.util.Map) r2
            java.lang.String r3 = r1.f27181p
            java.lang.Object r3 = r2.get(r3)
            if (r3 == 0) goto L_0x003c
            boolean r2 = r3 instanceof com.mob.commons.cc.z
            if (r2 == 0) goto L_0x0032
            com.mob.commons.cc.z r3 = (com.mob.commons.cc.z) r3
            java.util.LinkedList r0 = r3.b(r0)
            int r2 = r0.size()
            if (r2 <= 0) goto L_0x0031
            java.lang.Object r0 = r0.get(r12)
            r9.a((java.lang.Object) r0)
        L_0x0031:
            return
        L_0x0032:
            boolean r2 = r3 instanceof java.lang.reflect.Method
            if (r2 == 0) goto L_0x085f
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            r9.a((java.lang.reflect.Method) r3, (java.lang.Object[]) r0)
            return
        L_0x003c:
            java.lang.String r3 = "005j>djdkeiec"
            java.lang.String r3 = com.mob.commons.s.a((java.lang.String) r3)
            java.lang.String r4 = r1.f27181p
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0058
            java.lang.String r3 = "0115dg.eKfi)d(ef6f8gldjdkeiec"
            java.lang.String r3 = com.mob.commons.s.a((java.lang.String) r3)
            java.lang.String r4 = r1.f27181p
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00cb
        L_0x0058:
            int r3 = r0.length
            if (r3 != r11) goto L_0x00cb
            r3 = r0[r12]
            if (r3 == 0) goto L_0x00cb
            r2 = r0[r12]
            boolean r2 = r2 instanceof java.lang.Class
            if (r2 == 0) goto L_0x006e
            java.lang.Class[] r2 = new java.lang.Class[r11]
            r0 = r0[r12]
            java.lang.Class r0 = (java.lang.Class) r0
            r2[r12] = r0
            goto L_0x0085
        L_0x006e:
            r2 = r0[r12]
            boolean r2 = r2 instanceof java.util.List
            if (r2 == 0) goto L_0x0099
            r0 = r0[r12]
            java.util.List r0 = (java.util.List) r0
            int r2 = r0.size()
            java.lang.Class[] r2 = new java.lang.Class[r2]
            java.lang.Object[] r0 = r0.toArray(r2)
            r2 = r0
            java.lang.Class[] r2 = (java.lang.Class[]) r2
        L_0x0085:
            java.lang.String r0 = "005j@djdkeiec"
            java.lang.String r0 = com.mob.commons.s.a((java.lang.String) r0)
            java.lang.String r3 = r1.f27181p
            boolean r0 = r0.equals(r3)
            java.lang.Object r0 = r9.a(r8, r0, r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x0099:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "method name: "
            r2.append(r3)
            java.lang.String r3 = r1.f27181p
            r2.append(r3)
            java.lang.String r3 = " at line: "
            r2.append(r3)
            java.lang.String r3 = r1.f27167b
            r2.append(r3)
            java.lang.String r3 = "("
            r2.append(r3)
            int r3 = r1.f27168c
            r2.append(r3)
            java.lang.String r3 = ")"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x00cb:
            java.lang.String r3 = "iterator"
            java.lang.String r4 = r1.f27181p
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00e4
            int r3 = r0.length
            if (r3 != 0) goto L_0x00e4
            java.util.Set r0 = r2.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r9.a((java.lang.Object) r0)
            return
        L_0x00e4:
            java.lang.String r2 = "toJson"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            int r2 = r0.length
            if (r2 != 0) goto L_0x085f
            java.lang.String r0 = "org.json.JSONObject"
            java.lang.Class r0 = java.lang.Class.forName(r0)
            java.lang.Class[] r2 = new java.lang.Class[r11]
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            r2[r12] = r3
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r2)
            java.lang.Object[] r2 = new java.lang.Object[r11]
            r2[r12] = r8
            java.lang.Object r0 = r0.newInstance(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x010d:
            boolean r2 = r8 instanceof com.mob.commons.cc.z
            if (r2 == 0) goto L_0x0144
            r2 = r8
            com.mob.commons.cc.z r2 = (com.mob.commons.cc.z) r2
            java.lang.String r3 = "004ifIfiDi"
            java.lang.String r3 = com.mob.commons.s.a((java.lang.String) r3)
            java.lang.String r4 = r1.f27181p
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x012a
            com.mob.commons.cc.z$a r0 = r2.a(r0)
            r9.a((java.lang.Object) r0)
            return
        L_0x012a:
            java.lang.String r3 = "008cMdgdjdjecdiEe-ej"
            java.lang.String r3 = com.mob.commons.s.a((java.lang.String) r3)
            java.lang.String r4 = r1.f27181p
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x085f
            java.lang.String r0 = r1.f27167b
            int r3 = r1.f27168c
            com.mob.commons.cc.z r0 = r2.a(r9, r0, r3)
            r9.a((java.lang.Object) r0)
            return
        L_0x0144:
            boolean r2 = r8 instanceof java.lang.reflect.Method
            if (r2 == 0) goto L_0x0193
            java.lang.String r2 = "004if4fi(i"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0173
            com.mob.commons.cc.z$a r2 = new com.mob.commons.cc.z$a
            r2.<init>()
            com.mob.commons.cc.s r3 = r20.b()
            r4 = r8
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4     // Catch:{ all -> 0x016c }
            r3.a((java.lang.reflect.Method) r4, (java.lang.Object[]) r0)     // Catch:{ all -> 0x016c }
            java.lang.Object r0 = r3.a()     // Catch:{ all -> 0x016c }
            r2.f27199b = r0     // Catch:{ all -> 0x016c }
            goto L_0x016f
        L_0x016c:
            r0 = move-exception
            r2.f27198a = r0
        L_0x016f:
            r9.a((java.lang.Object) r2)
            return
        L_0x0173:
            java.lang.String r2 = "0133fi.fiQfdQccf fifidiff1gf"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            int r2 = r0.length
            if (r2 != r11) goto L_0x085f
            r2 = r8
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2
            r0 = r0[r12]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2.setAccessible(r0)
            return
        L_0x0193:
            boolean r2 = r8 instanceof java.util.Collection
            if (r2 == 0) goto L_0x01d4
            r2 = r8
            java.util.Collection r2 = (java.util.Collection) r2
            int r3 = r2.size()
            java.lang.String r4 = "toArray"
            java.lang.String r5 = r1.f27181p
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x085f
            int r4 = r0.length
            if (r4 != r11) goto L_0x085f
            r4 = r0[r12]
            if (r4 == 0) goto L_0x085f
            r4 = r0[r12]
            boolean r4 = r4 instanceof java.lang.Class
            if (r4 == 0) goto L_0x085f
            r0 = r0[r12]
            java.lang.Class r0 = (java.lang.Class) r0
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r3)
            java.util.Iterator r2 = r2.iterator()
        L_0x01c1:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01d0
            java.lang.Object r3 = r2.next()
            java.lang.reflect.Array.set(r0, r12, r3)
            int r12 = r12 + r11
            goto L_0x01c1
        L_0x01d0:
            r9.a((java.lang.Object) r0)
            return
        L_0x01d4:
            java.lang.Class r2 = r18.getClass()
            boolean r2 = r2.isArray()
            if (r2 == 0) goto L_0x029a
            java.lang.String r2 = "iterator"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0208
            int r2 = r0.length
            if (r2 != 0) goto L_0x0208
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r2 = java.lang.reflect.Array.getLength(r18)
        L_0x01f4:
            if (r12 >= r2) goto L_0x0200
            java.lang.Object r3 = java.lang.reflect.Array.get(r8, r12)
            r0.add(r3)
            int r12 = r12 + 1
            goto L_0x01f4
        L_0x0200:
            java.util.Iterator r0 = r0.iterator()
            r9.a((java.lang.Object) r0)
            return
        L_0x0208:
            java.lang.String r2 = "toList"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x022e
            int r2 = r0.length
            if (r2 != 0) goto L_0x022e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r2 = java.lang.reflect.Array.getLength(r18)
        L_0x021e:
            if (r12 >= r2) goto L_0x022a
            java.lang.Object r3 = java.lang.reflect.Array.get(r8, r12)
            r0.add(r3)
            int r12 = r12 + 1
            goto L_0x021e
        L_0x022a:
            r9.a((java.lang.Object) r0)
            return
        L_0x022e:
            java.lang.Class r2 = r18.getClass()
            java.lang.Class r2 = r2.getComponentType()
            java.lang.Class r3 = java.lang.Byte.TYPE
            if (r2 != r3) goto L_0x085f
            java.lang.String r2 = "003!dfdchi"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x025f
            int r2 = r0.length
            if (r2 != 0) goto L_0x025f
            r0 = r8
            byte[] r0 = (byte[]) r0
            int r2 = r0.length
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            r3.<init>(r0, r12, r2)
            java.lang.String r0 = r1.a((java.io.InputStream) r3)
            r3.close()
            r9.a((java.lang.Object) r0)
            return
        L_0x025f:
            java.lang.String r2 = "hex"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0277
            int r2 = r0.length
            if (r2 != 0) goto L_0x0277
            r0 = r8
            byte[] r0 = (byte[]) r0
            java.lang.String r0 = r1.a((byte[]) r0)
            r9.a((java.lang.Object) r0)
            return
        L_0x0277:
            java.lang.String r2 = "sha"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            int r2 = r0.length
            if (r2 != r11) goto L_0x085f
            r2 = r8
            byte[] r2 = (byte[]) r2
            r0 = r0[r12]
            java.lang.String r0 = (java.lang.String) r0
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)
            r0.update(r2)
            byte[] r0 = r0.digest()
            r9.a((java.lang.Object) r0)
            return
        L_0x029a:
            java.lang.Class<java.util.Iterator> r2 = java.util.Iterator.class
            java.lang.Class r3 = r18.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x02e5
            java.lang.String r2 = "hasNext"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x02bf
            r0 = r8
            java.util.Iterator r0 = (java.util.Iterator) r0
            boolean r0 = r0.hasNext()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r9.a((java.lang.Object) r0)
            return
        L_0x02bf:
            java.lang.String r2 = "next"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x02d4
            r0 = r8
            java.util.Iterator r0 = (java.util.Iterator) r0
            java.lang.Object r0 = r0.next()
            r9.a((java.lang.Object) r0)
            return
        L_0x02d4:
            java.lang.String r2 = "remove"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            r0 = r8
            java.util.Iterator r0 = (java.util.Iterator) r0
            r0.remove()
            return
        L_0x02e5:
            boolean r2 = r8 instanceof com.mob.commons.cc.aa.a
            if (r2 == 0) goto L_0x031d
            java.lang.String r2 = "hasNext"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0305
            int r2 = r0.length
            if (r2 != 0) goto L_0x0305
            r0 = r8
            com.mob.commons.cc.aa$a r0 = (com.mob.commons.cc.aa.a) r0
            boolean r0 = r0.a()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r9.a((java.lang.Object) r0)
            return
        L_0x0305:
            java.lang.String r2 = "next"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            int r2 = r0.length
            if (r2 != 0) goto L_0x085f
            r0 = r8
            com.mob.commons.cc.aa$a r0 = (com.mob.commons.cc.aa.a) r0
            java.lang.Number r0 = r0.b()
            r9.a((java.lang.Object) r0)
            return
        L_0x031d:
            boolean r2 = r8 instanceof com.mob.commons.cc.aa
            if (r2 == 0) goto L_0x0391
            java.lang.String r2 = "iterator"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0339
            int r2 = r0.length
            if (r2 != 0) goto L_0x0339
            r0 = r8
            com.mob.commons.cc.aa r0 = (com.mob.commons.cc.aa) r0
            com.mob.commons.cc.aa$a r0 = r0.a()
            r9.a((java.lang.Object) r0)
            return
        L_0x0339:
            java.lang.String r2 = "isInRange"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0359
            int r2 = r0.length
            if (r2 != r11) goto L_0x0359
            r2 = r8
            com.mob.commons.cc.aa r2 = (com.mob.commons.cc.aa) r2
            r0 = r0[r12]
            java.lang.Number r0 = (java.lang.Number) r0
            boolean r0 = r2.a(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r9.a((java.lang.Object) r0)
            return
        L_0x0359:
            java.lang.String r2 = "contains"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0379
            int r2 = r0.length
            if (r2 != r11) goto L_0x0379
            r2 = r8
            com.mob.commons.cc.aa r2 = (com.mob.commons.cc.aa) r2
            r0 = r0[r12]
            java.lang.Number r0 = (java.lang.Number) r0
            boolean r0 = r2.b(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r9.a((java.lang.Object) r0)
            return
        L_0x0379:
            java.lang.String r2 = "boundary"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            int r2 = r0.length
            if (r2 != 0) goto L_0x085f
            r0 = r8
            com.mob.commons.cc.aa r0 = (com.mob.commons.cc.aa) r0
            java.lang.Number[] r0 = r0.b()
            r9.a((java.lang.Object) r0)
            return
        L_0x0391:
            boolean r2 = r8 instanceof java.lang.String
            if (r2 == 0) goto L_0x06dc
            java.lang.String r2 = "getBytes"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x03c5
            int r2 = r0.length
            if (r2 != 0) goto L_0x03ad
            r0 = r8
            java.lang.String r0 = (java.lang.String) r0
            byte[] r0 = r0.getBytes()
            r9.a((java.lang.Object) r0)
            return
        L_0x03ad:
            int r2 = r0.length
            if (r2 != r11) goto L_0x085f
            r2 = r0[r12]
            boolean r2 = r2 instanceof java.lang.String
            if (r2 == 0) goto L_0x085f
            r2 = r8
            java.lang.String r2 = (java.lang.String) r2
            r0 = r0[r12]
            java.lang.String r0 = (java.lang.String) r0
            byte[] r0 = r2.getBytes(r0)
            r9.a((java.lang.Object) r0)
            return
        L_0x03c5:
            java.lang.String r2 = "input"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x03fe
            int r2 = r0.length
            if (r2 != 0) goto L_0x03de
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r2 = r8
            java.lang.String r2 = (java.lang.String) r2
            r0.<init>(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x03de:
            int r2 = r0.length
            if (r2 != r11) goto L_0x085f
            r2 = r0[r12]
            boolean r2 = r2 instanceof com.mob.commons.cc.z
            if (r2 == 0) goto L_0x085f
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r3 = r8
            java.lang.String r3 = (java.lang.String) r3
            r2.<init>(r3)
            r0 = r0[r12]
            com.mob.commons.cc.z r0 = (com.mob.commons.cc.z) r0
            java.lang.Object[] r3 = new java.lang.Object[r11]
            r3[r12] = r2
            r0.b(r3)
            r2.close()
            return
        L_0x03fe:
            java.lang.String r2 = "output"
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x043a
            int r2 = r0.length
            if (r2 != 0) goto L_0x0417
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r2 = r8
            java.lang.String r2 = (java.lang.String) r2
            r0.<init>(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x0417:
            int r2 = r0.length
            if (r2 != r11) goto L_0x085f
            r2 = r0[r12]
            boolean r2 = r2 instanceof com.mob.commons.cc.z
            if (r2 == 0) goto L_0x085f
            java.io.FileOutputStream r2 = new java.io.FileOutputStream
            r3 = r8
            java.lang.String r3 = (java.lang.String) r3
            r2.<init>(r3)
            r0 = r0[r12]
            com.mob.commons.cc.z r0 = (com.mob.commons.cc.z) r0
            java.lang.Object[] r3 = new java.lang.Object[r11]
            r3[r12] = r2
            r0.b(r3)
            r2.flush()
            r2.close()
            return
        L_0x043a:
            java.lang.String r2 = "012?djYfd<dcgcdjdkdfgcdi<gf"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            r3 = 0
            if (r2 == 0) goto L_0x0490
            int r2 = r0.length
            if (r2 != 0) goto L_0x044f
            java.lang.String r3 = "utf-8"
            goto L_0x0458
        L_0x044f:
            int r2 = r0.length
            if (r2 != r11) goto L_0x0458
            r2 = r0[r12]
            java.lang.String r3 = java.lang.String.valueOf(r2)
        L_0x0458:
            if (r3 == 0) goto L_0x085f
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r2 = r8
            java.lang.String r2 = (java.lang.String) r2
            r0.<init>(r2)
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]
            int r5 = r0.read(r4)
        L_0x046f:
            r6 = -1
            if (r5 == r6) goto L_0x047a
            r2.write(r4, r12, r5)
            int r5 = r0.read(r4)
            goto L_0x046f
        L_0x047a:
            r0.close()
            r2.flush()
            r2.close()
            java.lang.String r0 = new java.lang.String
            byte[] r2 = r2.toByteArray()
            r0.<init>(r2, r3)
            r9.a((java.lang.Object) r0)
            return
        L_0x0490:
            java.lang.String r2 = "011QfgdjdiUif5fcdkgcdi]gf"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r4 = r1.f27181p
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x04d3
            int r2 = r0.length
            if (r2 != r11) goto L_0x04aa
            r2 = r0[r12]
            java.lang.String r3 = java.lang.String.valueOf(r2)
            java.lang.String r2 = "utf-8"
            goto L_0x04bb
        L_0x04aa:
            int r2 = r0.length
            if (r2 != r10) goto L_0x04ba
            r2 = r0[r12]
            java.lang.String r3 = java.lang.String.valueOf(r2)
            r2 = r0[r11]
            java.lang.String r2 = java.lang.String.valueOf(r2)
            goto L_0x04bb
        L_0x04ba:
            r2 = r3
        L_0x04bb:
            if (r3 == 0) goto L_0x085f
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r3)
            r3 = r8
            java.lang.String r3 = (java.lang.String) r3
            byte[] r2 = r3.getBytes(r2)
            r0.write(r2)
            r0.flush()
            r0.close()
            return
        L_0x04d3:
            java.lang.String r2 = "009)djTfdTdcfedi%ef+fi"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r4 = r1.f27181p
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x057b
            java.lang.String r2 = "utf-8"
            int r4 = r0.length
            if (r4 != 0) goto L_0x04f4
            java.io.FileInputStream r4 = new java.io.FileInputStream
            r5 = r8
            java.lang.String r5 = (java.lang.String) r5
            r4.<init>(r5)
            r16 = r4
            r4 = r3
            r3 = r16
            goto L_0x0544
        L_0x04f4:
            int r4 = r0.length
            if (r4 != r11) goto L_0x0523
            r4 = r0[r12]
            boolean r4 = r4 instanceof java.lang.String
            if (r4 == 0) goto L_0x0510
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
            r2.<init>(r4)
            r4 = r0[r12]
            java.lang.String r4 = (java.lang.String) r4
            r16 = r3
            r3 = r2
            r2 = r4
            r4 = r16
            goto L_0x0544
        L_0x0510:
            r4 = r0[r12]
            boolean r4 = r4 instanceof com.mob.commons.cc.z
            if (r4 == 0) goto L_0x0543
            java.io.FileInputStream r3 = new java.io.FileInputStream
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
            r3.<init>(r4)
            r4 = r0[r12]
            com.mob.commons.cc.z r4 = (com.mob.commons.cc.z) r4
            goto L_0x0544
        L_0x0523:
            int r4 = r0.length
            if (r4 != r10) goto L_0x0543
            r4 = r0[r12]
            boolean r4 = r4 instanceof java.lang.String
            if (r4 == 0) goto L_0x0543
            r4 = r0[r11]
            boolean r4 = r4 instanceof com.mob.commons.cc.z
            if (r4 == 0) goto L_0x0543
            java.io.FileInputStream r3 = new java.io.FileInputStream
            r2 = r8
            java.lang.String r2 = (java.lang.String) r2
            r3.<init>(r2)
            r2 = r0[r12]
            java.lang.String r2 = (java.lang.String) r2
            r4 = r0[r11]
            com.mob.commons.cc.z r4 = (com.mob.commons.cc.z) r4
            goto L_0x0544
        L_0x0543:
            r4 = r3
        L_0x0544:
            if (r3 == 0) goto L_0x085f
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r3, r2)
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r2.<init>(r0)
            java.lang.String r0 = r2.readLine()
            if (r4 != 0) goto L_0x0569
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x055b:
            if (r0 == 0) goto L_0x0565
            r3.add(r0)
            java.lang.String r0 = r2.readLine()
            goto L_0x055b
        L_0x0565:
            r9.a((java.lang.Object) r3)
            goto L_0x0577
        L_0x0569:
            if (r0 == 0) goto L_0x0577
            java.lang.Object[] r3 = new java.lang.Object[r11]
            r3[r12] = r0
            r4.b(r3)
            java.lang.String r0 = r2.readLine()
            goto L_0x0569
        L_0x0577:
            r2.close()
            return
        L_0x057b:
            java.lang.String r2 = "010CfgdjdiNifJfedi6ef]fi"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r4 = r1.f27181p
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0615
            java.lang.String r2 = "utf-8"
            int r4 = r0.length
            if (r4 < r11) goto L_0x05dd
            int r4 = r0.length
            if (r4 != r10) goto L_0x059b
            r4 = r0[r11]
            boolean r4 = r4 instanceof java.lang.String
            if (r4 == 0) goto L_0x059b
            r2 = r0[r11]
            java.lang.String r2 = (java.lang.String) r2
        L_0x059b:
            r4 = r0[r12]
            boolean r4 = r4 instanceof java.lang.String
            if (r4 == 0) goto L_0x05ac
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = r0[r12]
            r3.add(r4)
            goto L_0x05dd
        L_0x05ac:
            r4 = r0[r12]
            boolean r4 = r4 instanceof java.util.Collection
            if (r4 == 0) goto L_0x05b7
            r3 = r0[r12]
            java.util.Collection r3 = (java.util.Collection) r3
            goto L_0x05dd
        L_0x05b7:
            r4 = r0[r12]
            java.lang.Class r4 = r4.getClass()
            boolean r4 = r4.isArray()
            if (r4 == 0) goto L_0x05dd
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = r0[r12]
            int r4 = java.lang.reflect.Array.getLength(r4)
            r5 = r12
        L_0x05cf:
            if (r5 >= r4) goto L_0x05dd
            r6 = r0[r12]
            java.lang.Object r6 = java.lang.reflect.Array.get(r6, r5)
            r3.add(r6)
            int r5 = r5 + 1
            goto L_0x05cf
        L_0x05dd:
            if (r3 == 0) goto L_0x085f
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
            r0.<init>(r4)
            java.util.Iterator r3 = r3.iterator()
        L_0x05eb:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x060e
            java.lang.Object r4 = r3.next()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "\r\n"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            byte[] r4 = r4.getBytes(r2)
            r0.write(r4)
            goto L_0x05eb
        L_0x060e:
            r0.flush()
            r0.close()
            return
        L_0x0615:
            java.lang.String r2 = "004fMei,fc"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r4 = r1.f27181p
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x068b
            int r2 = r0.length
            if (r2 != 0) goto L_0x0635
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()
            r2 = r8
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Process r0 = r0.exec(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x0635:
            int r2 = r0.length
            if (r2 == r11) goto L_0x063b
            int r2 = r0.length
            if (r2 != r10) goto L_0x085f
        L_0x063b:
            r2 = r0[r12]
            boolean r2 = r2 instanceof java.lang.String[]
            if (r2 == 0) goto L_0x0646
            r2 = r0[r12]
            java.lang.String[] r2 = (java.lang.String[]) r2
            goto L_0x066d
        L_0x0646:
            r2 = r0[r12]
            boolean r2 = r2 instanceof java.util.List
            if (r2 == 0) goto L_0x066c
            r2 = r0[r12]
            java.util.List r2 = (java.util.List) r2
            int r4 = r2.size()
            java.lang.String[] r5 = new java.lang.String[r4]
            r6 = r12
        L_0x0657:
            if (r6 >= r4) goto L_0x066a
            java.lang.Object r7 = r2.get(r6)
            if (r7 != 0) goto L_0x0661
            r7 = r3
            goto L_0x0665
        L_0x0661:
            java.lang.String r7 = java.lang.String.valueOf(r7)
        L_0x0665:
            r5[r6] = r7
            int r6 = r6 + 1
            goto L_0x0657
        L_0x066a:
            r2 = r5
            goto L_0x066d
        L_0x066c:
            r2 = r3
        L_0x066d:
            int r4 = r0.length
            if (r4 != r10) goto L_0x067a
            r4 = r0[r11]
            boolean r4 = r4 instanceof java.io.File
            if (r4 == 0) goto L_0x067a
            r3 = r0[r11]
            java.io.File r3 = (java.io.File) r3
        L_0x067a:
            if (r2 == 0) goto L_0x085f
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Process r0 = r0.exec(r4, r2, r3)
            r9.a((java.lang.Object) r0)
            return
        L_0x068b:
            java.lang.String r2 = "007PefdjdkdffkVf$ei"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            int r2 = r0.length
            if (r2 != 0) goto L_0x085f
            r0 = r8
            java.lang.String r0 = (java.lang.String) r0
            int r2 = r0.length()
            int r3 = r2 % 2
            if (r3 != r11) goto L_0x06bf
            int r2 = r2 + 1
            int r3 = r2 / 2
            byte[] r3 = new byte[r3]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "0"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            goto L_0x06c3
        L_0x06bf:
            int r3 = r2 / 2
            byte[] r3 = new byte[r3]
        L_0x06c3:
            r4 = r12
        L_0x06c4:
            if (r12 >= r2) goto L_0x06d8
            int r5 = r12 + 2
            java.lang.String r6 = r0.substring(r12, r5)
            r7 = 16
            int r6 = java.lang.Integer.parseInt(r6, r7)
            byte r6 = (byte) r6
            r3[r4] = r6
            int r4 = r4 + r11
            r12 = r5
            goto L_0x06c4
        L_0x06d8:
            r9.a((java.lang.Object) r3)
            return
        L_0x06dc:
            boolean r2 = r8 instanceof java.io.InputStream
            if (r2 == 0) goto L_0x076d
            java.lang.String r2 = "017iTdkfl<didSeeWej(dgYiRelQiHdj6fd3df"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x06fd
            int r2 = r0.length
            if (r2 != 0) goto L_0x06fd
            java.io.DataInputStream r0 = new java.io.DataInputStream
            r2 = r8
            java.io.InputStream r2 = (java.io.InputStream) r2
            r0.<init>(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x06fd:
            java.lang.String r2 = "021iVdkfjdgefef>fVdjJf%dceeVejXdg iCel!i8dj>fdKdf"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x071a
            int r2 = r0.length
            if (r2 != 0) goto L_0x071a
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            r2 = r8
            java.io.InputStream r2 = (java.io.InputStream) r2
            r0.<init>(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x071a:
            java.lang.String r2 = "017i?dkidijeeglee=ejWdgDi4el+i$dj@fdJdf"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0737
            int r2 = r0.length
            if (r2 != 0) goto L_0x0737
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream
            r2 = r8
            java.io.InputStream r2 = (java.io.InputStream) r2
            r0.<init>(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x0737:
            java.lang.String r2 = "019i9dkghffhgUfci:ee+ej'dgOiGel+i<dj4fdDdf"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0754
            int r2 = r0.length
            if (r2 != 0) goto L_0x0754
            java.io.ObjectInputStream r0 = new java.io.ObjectInputStream
            r2 = r8
            java.io.InputStream r2 = (java.io.InputStream) r2
            r0.<init>(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x0754:
            java.lang.String r2 = "003=dfdchi"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            int r2 = r0.length
            if (r2 != 0) goto L_0x085f
            r2 = r8
            java.io.InputStream r2 = (java.io.InputStream) r2
            r1.a((java.io.InputStream) r2)
            goto L_0x085f
        L_0x076d:
            boolean r2 = r8 instanceof java.io.OutputStream
            if (r2 == 0) goto L_0x07e5
            java.lang.String r2 = "018iXdkflGdid-ghdg[ij_dg+iFel1i+dj(fd)df"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x078e
            int r2 = r0.length
            if (r2 != 0) goto L_0x078e
            java.io.DataOutputStream r0 = new java.io.DataOutputStream
            r2 = r8
            java.io.OutputStream r2 = (java.io.OutputStream) r2
            r0.<init>(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x078e:
            java.lang.String r2 = "022i6dkfjdgefefUf:dj fLdcghdgOij)dgTiIel(i+djBfd@df"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x07ab
            int r2 = r0.length
            if (r2 != 0) goto L_0x07ab
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream
            r2 = r8
            java.io.OutputStream r2 = (java.io.OutputStream) r2
            r0.<init>(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x07ab:
            java.lang.String r2 = "018i)dkidijeeglghdg[ijMdgAiFel5iIdj:fd>df"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x07c8
            int r2 = r0.length
            if (r2 != 0) goto L_0x07c8
            java.util.zip.GZIPOutputStream r0 = new java.util.zip.GZIPOutputStream
            r2 = r8
            java.io.OutputStream r2 = (java.io.OutputStream) r2
            r0.<init>(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x07c8:
            java.lang.String r2 = "020iWdkghffhg?fci0ghdg>ijVdgLiMelDiVdj*fd_df"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            int r2 = r0.length
            if (r2 != 0) goto L_0x085f
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream
            r2 = r8
            java.io.OutputStream r2 = (java.io.OutputStream) r2
            r0.<init>(r2)
            r9.a((java.lang.Object) r0)
            return
        L_0x07e5:
            boolean r2 = r8 instanceof java.lang.Class
            if (r2 == 0) goto L_0x0819
            java.lang.String r2 = "006NdidfCjGdkdjEi"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            int r2 = r0.length
            if (r2 != 0) goto L_0x0805
            r0 = r8
            java.lang.Class r0 = (java.lang.Class) r0
            java.lang.String r2 = r0.getSimpleName()
            r9.a((java.lang.String) r2, (java.lang.Class<?>) r0)
            return
        L_0x0805:
            int r2 = r0.length
            if (r2 != r11) goto L_0x085f
            r2 = r0[r12]
            boolean r2 = r2 instanceof java.lang.String
            if (r2 == 0) goto L_0x085f
            r0 = r0[r12]
            java.lang.String r0 = (java.lang.String) r0
            r2 = r8
            java.lang.Class r2 = (java.lang.Class) r2
            r9.a((java.lang.String) r0, (java.lang.Class<?>) r2)
            return
        L_0x0819:
            boolean r2 = r8 instanceof java.lang.Throwable
            if (r2 == 0) goto L_0x0833
            java.lang.String r2 = "005ih-djdkfg"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            int r2 = r0.length
            if (r2 == 0) goto L_0x082f
            goto L_0x085f
        L_0x082f:
            r0 = r8
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0833:
            java.lang.Class<java.lang.reflect.AccessibleObject> r2 = java.lang.reflect.AccessibleObject.class
            java.lang.Class r3 = r18.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x085f
            java.lang.String r2 = "013%fi>fi6fdQccf4fifidiff>gf"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x085f
            int r2 = r0.length
            if (r2 != r11) goto L_0x085f
            r2 = r8
            java.lang.reflect.AccessibleObject r2 = (java.lang.reflect.AccessibleObject) r2
            r0 = r0[r12]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2.setAccessible(r0)
            return
        L_0x085f:
            java.lang.String r2 = "004g6dk%c$eh"
            java.lang.String r2 = com.mob.commons.s.a((java.lang.String) r2)
            java.lang.String r3 = r1.f27181p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x089b
            int r2 = r0.length
            if (r2 <= 0) goto L_0x089b
            r2 = r0[r12]
            boolean r2 = r2 instanceof com.mob.commons.cc.z
            if (r2 == 0) goto L_0x089b
            monitor-enter(r18)
            r2 = r0[r12]     // Catch:{ all -> 0x0898 }
            com.mob.commons.cc.z r2 = (com.mob.commons.cc.z) r2     // Catch:{ all -> 0x0898 }
            int r3 = r0.length     // Catch:{ all -> 0x0898 }
            int r3 = r3 - r11
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0898 }
            int r5 = r0.length     // Catch:{ all -> 0x0898 }
            if (r5 <= r11) goto L_0x0885
            java.lang.System.arraycopy(r0, r11, r4, r12, r3)     // Catch:{ all -> 0x0898 }
        L_0x0885:
            java.util.LinkedList r0 = r2.b(r4)     // Catch:{ all -> 0x0898 }
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0898 }
            if (r2 != 0) goto L_0x0896
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x0898 }
            r9.a((java.lang.Object) r0)     // Catch:{ all -> 0x0898 }
        L_0x0896:
            monitor-exit(r18)     // Catch:{ all -> 0x0898 }
            return
        L_0x0898:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x0898 }
            throw r0
        L_0x089b:
            java.lang.Class r13 = r18.getClass()
            com.mob.commons.cc.u r2 = r20.g()
            java.lang.String r5 = r1.f27181p
            r3 = r18
            r4 = r13
            r6 = r19
            r7 = r20
            boolean r2 = r2.a((java.lang.Object) r3, (java.lang.Class<?>) r4, (java.lang.String) r5, (java.lang.Object[]) r6, (com.mob.commons.cc.s) r7)
            if (r2 == 0) goto L_0x08b3
            return
        L_0x08b3:
            r14 = r13
        L_0x08b4:
            if (r14 == 0) goto L_0x08f9
            boolean[][] r15 = new boolean[r10][]
            com.mob.commons.cc.u r2 = r20.g()
            java.lang.String r4 = r1.f27181p
            r5 = 0
            r3 = r14
            r6 = r19
            r7 = r15
            java.lang.reflect.Method r2 = r2.a((java.lang.Class<?>) r3, (java.lang.String) r4, (boolean) r5, (java.lang.Object[]) r6, (boolean[][]) r7)
            if (r2 == 0) goto L_0x08f4
            r3 = r15[r11]
            boolean r3 = r3[r12]
            if (r3 != 0) goto L_0x08dd
            com.mob.commons.cc.u r3 = r20.g()
            java.lang.Class[] r4 = r2.getParameterTypes()
            r5 = r15[r12]
            java.lang.Object[] r0 = r3.a(r9, r4, r0, r5)
        L_0x08dd:
            r2.setAccessible(r11)
            java.lang.Class r3 = r2.getReturnType()
            java.lang.Class r4 = java.lang.Void.TYPE
            if (r3 != r4) goto L_0x08ec
            r2.invoke(r8, r0)
            goto L_0x08f3
        L_0x08ec:
            java.lang.Object r0 = r2.invoke(r8, r0)
            r9.a((java.lang.Object) r0)
        L_0x08f3:
            return
        L_0x08f4:
            java.lang.Class r14 = r14.getSuperclass()
            goto L_0x08b4
        L_0x08f9:
            if (r13 == 0) goto L_0x0956
            java.lang.reflect.Method[] r2 = r13.getDeclaredMethods()
            int r3 = r2.length
            r4 = r12
        L_0x0901:
            if (r4 >= r3) goto L_0x0951
            r5 = r2[r4]
            java.lang.String r6 = r5.getName()
            java.lang.String r7 = r1.f27181p
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x094e
            int r6 = r5.getModifiers()
            boolean r6 = java.lang.reflect.Modifier.isStatic(r6)
            if (r6 != 0) goto L_0x094e
            java.lang.Class[] r6 = r5.getParameterTypes()
            boolean[] r7 = new boolean[r11]
            com.mob.commons.cc.u r10 = r20.g()
            boolean[] r10 = r10.a((java.lang.Class<?>[]) r6, (java.lang.Object[]) r0, (boolean[]) r7)
            if (r10 == 0) goto L_0x094e
            boolean r2 = r7[r12]
            if (r2 != 0) goto L_0x0937
            com.mob.commons.cc.u r2 = r20.g()
            java.lang.Object[] r0 = r2.a(r9, r6, r0, r10)
        L_0x0937:
            r5.setAccessible(r11)
            java.lang.Class r2 = r5.getReturnType()
            java.lang.Class r3 = java.lang.Void.TYPE
            if (r2 != r3) goto L_0x0946
            r5.invoke(r8, r0)
            goto L_0x094d
        L_0x0946:
            java.lang.Object r0 = r5.invoke(r8, r0)
            r9.a((java.lang.Object) r0)
        L_0x094d:
            return
        L_0x094e:
            int r4 = r4 + 1
            goto L_0x0901
        L_0x0951:
            java.lang.Class r13 = r13.getSuperclass()
            goto L_0x08f9
        L_0x0956:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "method name: "
            r2.append(r3)
            java.lang.String r3 = r1.f27181p
            r2.append(r3)
            java.lang.String r3 = " at line: "
            r2.append(r3)
            java.lang.String r3 = r1.f27167b
            r2.append(r3)
            java.lang.String r3 = "("
            r2.append(r3)
            int r3 = r1.f27168c
            r2.append(r3)
            java.lang.String r3 = ")"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.cc.y.a(java.lang.Object, java.lang.Object[], com.mob.commons.cc.s):void");
    }

    private String a(InputStream inputStream) throws Throwable {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        MessageDigest instance = MessageDigest.getInstance(s.a("003+hcflhi"));
        int read = inputStream.read(bArr);
        while (read != -1) {
            instance.update(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        return a(instance.digest());
    }

    private String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < length; i11++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i11])}));
        }
        return stringBuffer.toString();
    }
}
