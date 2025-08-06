package h2;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeFilterable;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import i2.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class h extends SerializeFilterable implements k {

    /* renamed from: j  reason: collision with root package name */
    public final f[] f15920j;

    /* renamed from: k  reason: collision with root package name */
    public final f[] f15921k;

    /* renamed from: l  reason: collision with root package name */
    public o f15922l;

    public h(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public void A(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.f14276j.f14303c;
        }
        jSONSerializer.f14277k.w(str, false);
        String str2 = this.f15922l.f15928b;
        if (str2 == null) {
            Class cls = obj.getClass();
            if (TypeUtils.U(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        jSONSerializer.F(str2);
    }

    public boolean B(JSONSerializer jSONSerializer, Object obj, int i11) {
        IdentityHashMap<Object, n> identityHashMap;
        n nVar = jSONSerializer.f14283q;
        int i12 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (nVar == null || (nVar.f15926d & i12) != 0 || (i11 & i12) != 0 || (identityHashMap = jSONSerializer.f14282p) == null || !identityHashMap.containsKey(obj)) {
            return false;
        }
        jSONSerializer.H(obj);
        return true;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        x(jSONSerializer, obj, obj2, type, i11, false);
    }

    public boolean q(JSONSerializer jSONSerializer, String str) {
        List<i> list = jSONSerializer.f14313g;
        if (list != null) {
            for (i c11 : list) {
                if (!c11.c(str)) {
                    return false;
                }
            }
        }
        List<i> list2 = this.f14313g;
        if (list2 == null) {
            return true;
        }
        for (i c12 : list2) {
            if (!c12.c(str)) {
                return false;
            }
        }
        return true;
    }

    public f r(String str) {
        if (str == null) {
            return null;
        }
        int i11 = 0;
        int length = this.f15921k.length - 1;
        while (i11 <= length) {
            int i12 = (i11 + length) >>> 1;
            int compareTo = this.f15921k[i12].f15904b.f15962b.compareTo(str);
            if (compareTo < 0) {
                i11 = i12 + 1;
            } else if (compareTo <= 0) {
                return this.f15921k[i12];
            } else {
                length = i12 - 1;
            }
        }
        return null;
    }

    public Object s(Object obj, String str) {
        f r11 = r(str);
        if (r11 != null) {
            try {
                return r11.b(obj);
            } catch (InvocationTargetException e11) {
                throw new JSONException("getFieldValue error." + str, e11);
            } catch (IllegalAccessException e12) {
                throw new JSONException("getFieldValue error." + str, e12);
            }
        } else {
            throw new JSONException("field not found. " + str);
        }
    }

    public List<Object> t(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.f15921k.length);
        for (f b11 : this.f15921k) {
            arrayList.add(b11.b(obj));
        }
        return arrayList;
    }

    public Map<String, Object> u(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f15921k.length);
        for (f fVar : this.f15921k) {
            linkedHashMap.put(fVar.f15904b.f15962b, fVar.b(obj));
        }
        return linkedHashMap;
    }

    public int v(Object obj) throws Exception {
        int i11 = 0;
        for (f c11 : this.f15921k) {
            if (c11.c(obj) != null) {
                i11++;
            }
        }
        return i11;
    }

    public boolean w(JSONSerializer jSONSerializer, int i11) {
        int i12 = SerializerFeature.BeanToArray.mask;
        return ((this.f15922l.f15933g & i12) == 0 && !jSONSerializer.f14277k.f14328j && (i11 & i12) == 0) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0154, code lost:
        if ((r7.f15922l.f15933g & r3) == 0) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x02b5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x02b6, code lost:
        r1 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x02e8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x02e9, code lost:
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x02f0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x02f1, code lost:
        r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0318, code lost:
        r1 = r1 + ", fieldName : " + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0332, code lost:
        r1 = r1 + ", " + r0.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c5, code lost:
        if (r10.f15976p != false) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00f3, code lost:
        if (r8.z(r11, r9) != false) goto L_0x0296;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x02e8 A[ExcHandler: all (th java.lang.Throwable), PHI: r20 
      PHI: (r20v2 h2.n) = (r20v0 h2.n), (r20v3 h2.n), (r20v3 h2.n), (r20v3 h2.n), (r20v3 h2.n), (r20v3 h2.n), (r20v3 h2.n), (r20v3 h2.n) binds: [B:221:0x02c6, B:55:0x00b9, B:56:?, B:66:0x00d3, B:83:0x00fe, B:74:0x00e9, B:59:0x00c3, B:60:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:66:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x02f0 A[ExcHandler: all (th java.lang.Throwable), PHI: r14 
      PHI: (r14v2 h2.n) = (r14v3 h2.n), (r14v3 h2.n), (r14v0 h2.n) binds: [B:52:0x00b1, B:53:?, B:20:0x004c] A[DONT_GENERATE, DONT_INLINE], Splitter:B:20:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0318 A[Catch:{ all -> 0x0350 }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0332 A[Catch:{ all -> 0x0350 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x(com.alibaba.fastjson.serializer.JSONSerializer r25, java.lang.Object r26, java.lang.Object r27, java.lang.reflect.Type r28, int r29, boolean r30) throws java.io.IOException {
        /*
            r24 = this;
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r0 = r29
            com.alibaba.fastjson.serializer.SerializeWriter r12 = r8.f14277k
            if (r9 != 0) goto L_0x0014
            r12.H()
            return
        L_0x0014:
            boolean r1 = r7.B(r8, r9, r0)
            if (r1 == 0) goto L_0x001b
            return
        L_0x001b:
            boolean r1 = r12.f14326h
            if (r1 == 0) goto L_0x0022
            h2.f[] r1 = r7.f15921k
            goto L_0x0024
        L_0x0022:
            h2.f[] r1 = r7.f15920j
        L_0x0024:
            r13 = r1
            h2.n r14 = r8.f14283q
            h2.o r1 = r7.f15922l
            int r5 = r1.f15933g
            r1 = r25
            r2 = r14
            r3 = r26
            r4 = r27
            r6 = r29
            r1.C(r2, r3, r4, r5, r6)
            boolean r15 = r7.w(r8, r0)
            if (r15 == 0) goto L_0x0040
            r0 = 91
            goto L_0x0042
        L_0x0040:
            r0 = 123(0x7b, float:1.72E-43)
        L_0x0042:
            if (r15 == 0) goto L_0x0047
            r1 = 93
            goto L_0x0049
        L_0x0047:
            r1 = 125(0x7d, float:1.75E-43)
        L_0x0049:
            r6 = r1
            if (r30 != 0) goto L_0x004f
            r12.append(r0)     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
        L_0x004f:
            int r0 = r13.length     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            if (r0 <= 0) goto L_0x0060
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            boolean r0 = r12.n(r0)     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            if (r0 == 0) goto L_0x0060
            r25.x()     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            r25.A()     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
        L_0x0060:
            h2.o r0 = r7.f15922l     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            int r0 = r0.f15933g     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            int r1 = r1.mask     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            r0 = r0 & r1
            r5 = 1
            if (r0 != 0) goto L_0x0072
            boolean r0 = r8.z(r11, r9)     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            if (r0 == 0) goto L_0x0081
        L_0x0072:
            java.lang.Class r0 = r26.getClass()     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            if (r0 == r11) goto L_0x0081
            h2.o r0 = r7.f15922l     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            java.lang.String r0 = r0.f15929c     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            r7.A(r8, r0, r9)     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            r0 = r5
            goto L_0x0082
        L_0x0081:
            r0 = 0
        L_0x0082:
            r3 = 44
            if (r0 == 0) goto L_0x0088
            r0 = r3
            goto L_0x0089
        L_0x0088:
            r0 = 0
        L_0x0089:
            boolean r1 = r12.f14325g     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            if (r1 == 0) goto L_0x0094
            boolean r1 = r12.f14324f     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            if (r1 != 0) goto L_0x0094
            r16 = r5
            goto L_0x0096
        L_0x0094:
            r16 = 0
        L_0x0096:
            char r0 = r7.z(r8, r9, r0)     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            if (r0 != r3) goto L_0x009e
            r0 = r5
            goto L_0x009f
        L_0x009e:
            r0 = 0
        L_0x009f:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            boolean r17 = r12.n(r1)     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreNonFieldGetter     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            boolean r18 = r12.n(r1)     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            r19 = r0
            r2 = 0
        L_0x00ae:
            int r0 = r13.length     // Catch:{ Exception -> 0x02f3, all -> 0x02f0 }
            if (r2 >= r0) goto L_0x02b9
            r1 = r13[r2]     // Catch:{ Exception -> 0x02b5, all -> 0x02f0 }
            i2.a r10 = r1.f15904b     // Catch:{ Exception -> 0x02b5, all -> 0x02f0 }
            java.lang.reflect.Field r0 = r10.f15964d     // Catch:{ Exception -> 0x02b5, all -> 0x02f0 }
            r20 = r14
            java.lang.String r14 = r10.f15962b     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            r21 = r13
            java.lang.Class<?> r13 = r10.f15966f     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r17 == 0) goto L_0x00cd
            if (r0 == 0) goto L_0x00cd
            boolean r3 = r10.f15976p     // Catch:{ Exception -> 0x00c9, all -> 0x02e8 }
            if (r3 == 0) goto L_0x00cd
            goto L_0x0296
        L_0x00c9:
            r0 = move-exception
            r1 = r9
            goto L_0x02ed
        L_0x00cd:
            if (r18 == 0) goto L_0x00d3
            if (r0 != 0) goto L_0x00d3
            goto L_0x0296
        L_0x00d3:
            boolean r0 = r7.f(r8, r9, r14)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r0 == 0) goto L_0x0296
            java.lang.String r0 = r10.f15972l     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            boolean r0 = r7.q(r8, r0)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r0 != 0) goto L_0x00e3
            goto L_0x0296
        L_0x00e3:
            h2.o r0 = r7.f15922l     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            java.lang.String r0 = r0.f15929c     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r0 == 0) goto L_0x00f7
            boolean r0 = r14.equals(r0)     // Catch:{ Exception -> 0x00c9, all -> 0x02e8 }
            if (r0 == 0) goto L_0x00f7
            boolean r0 = r8.z(r11, r9)     // Catch:{ Exception -> 0x00c9, all -> 0x02e8 }
            if (r0 == 0) goto L_0x00f7
            goto L_0x0296
        L_0x00f7:
            java.lang.Object r0 = r1.c(r9)     // Catch:{ InvocationTargetException -> 0x00fc }
            goto L_0x0107
        L_0x00fc:
            r0 = move-exception
            r3 = r0
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            boolean r0 = r12.n(r0)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r0 == 0) goto L_0x0295
            r0 = 0
        L_0x0107:
            boolean r3 = r7.e(r8, r9, r14, r0)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r3 != 0) goto L_0x010f
            goto L_0x0296
        L_0x010f:
            java.lang.String r3 = r7.o(r8, r9, r14, r0)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            h2.c r4 = r1.f15910h     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            r11 = r1
            r1 = r24
            r22 = r2
            r2 = r25
            r9 = r3
            r29 = r13
            r13 = 44
            r3 = r4
            r4 = r26
            r5 = r14
            r23 = r6
            r6 = r0
            java.lang.Object r1 = r1.p(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r1 != 0) goto L_0x0140
            if (r15 != 0) goto L_0x0140
            boolean r2 = r11.f15905c     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != 0) goto L_0x0140
            int r2 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            boolean r2 = r12.m(r2)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != 0) goto L_0x0140
        L_0x013c:
            r2 = 1
            r4 = 0
            goto L_0x029e
        L_0x0140:
            if (r1 == 0) goto L_0x01e3
            boolean r2 = r12.f14330l     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != 0) goto L_0x0156
            int r2 = r10.f15970j     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            int r3 = r3.mask     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            r2 = r2 & r3
            if (r2 != 0) goto L_0x0156
            h2.o r2 = r7.f15922l     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            int r2 = r2.f15933g     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            r2 = r2 & r3
            if (r2 == 0) goto L_0x01e3
        L_0x0156:
            java.lang.Class<?> r2 = r10.f15966f     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            java.lang.Class r3 = java.lang.Byte.TYPE     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != r3) goto L_0x016b
            boolean r3 = r1 instanceof java.lang.Byte     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r3 == 0) goto L_0x016b
            r3 = r1
            java.lang.Byte r3 = (java.lang.Byte) r3     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            byte r3 = r3.byteValue()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r3 != 0) goto L_0x016b
            goto L_0x01f6
        L_0x016b:
            java.lang.Class r3 = java.lang.Short.TYPE     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != r3) goto L_0x017d
            boolean r3 = r1 instanceof java.lang.Short     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r3 == 0) goto L_0x017d
            r3 = r1
            java.lang.Short r3 = (java.lang.Short) r3     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            short r3 = r3.shortValue()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r3 != 0) goto L_0x017d
        L_0x017c:
            goto L_0x013c
        L_0x017d:
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != r3) goto L_0x0190
            boolean r3 = r1 instanceof java.lang.Integer     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r3 == 0) goto L_0x0190
            r3 = r1
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r3 != 0) goto L_0x0190
            goto L_0x01f6
        L_0x0190:
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != r3) goto L_0x01a6
            boolean r3 = r1 instanceof java.lang.Long     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r3 == 0) goto L_0x01a6
            r3 = r1
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            long r3 = r3.longValue()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x01a6
            goto L_0x013c
        L_0x01a6:
            java.lang.Class r3 = java.lang.Float.TYPE     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != r3) goto L_0x01bb
            boolean r3 = r1 instanceof java.lang.Float     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r3 == 0) goto L_0x01bb
            r3 = r1
            java.lang.Float r3 = (java.lang.Float) r3     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            float r3 = r3.floatValue()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x01bb
            goto L_0x01f6
        L_0x01bb:
            java.lang.Class r3 = java.lang.Double.TYPE     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != r3) goto L_0x01d1
            boolean r3 = r1 instanceof java.lang.Double     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r3 == 0) goto L_0x01d1
            r3 = r1
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            double r3 = r3.doubleValue()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x01d1
            goto L_0x017c
        L_0x01d1:
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != r3) goto L_0x01e3
            boolean r2 = r1 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 == 0) goto L_0x01e3
            r2 = r1
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != 0) goto L_0x01e3
            goto L_0x01f6
        L_0x01e3:
            if (r19 == 0) goto L_0x0206
            boolean r2 = r10.f15980t     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 == 0) goto L_0x01f8
            boolean r2 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 == 0) goto L_0x01f8
            r2 = r1
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 != 0) goto L_0x01f8
        L_0x01f6:
            goto L_0x013c
        L_0x01f8:
            r12.write((int) r13)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            boolean r2 = r12.n(r2)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r2 == 0) goto L_0x0206
            r25.A()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
        L_0x0206:
            if (r9 == r14) goto L_0x0216
            if (r15 != 0) goto L_0x020f
            r2 = 1
            r12.w(r9, r2)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            goto L_0x0210
        L_0x020f:
            r2 = 1
        L_0x0210:
            r8.E(r1)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
        L_0x0213:
            r4 = 0
            goto L_0x0292
        L_0x0216:
            r2 = 1
            if (r0 == r1) goto L_0x0222
            if (r15 != 0) goto L_0x021e
            r11.e(r8)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
        L_0x021e:
            r8.E(r1)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            goto L_0x0213
        L_0x0222:
            if (r15 != 0) goto L_0x0237
            boolean r0 = r10.f15980t     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r0 != 0) goto L_0x0237
            if (r16 == 0) goto L_0x0232
            char[] r0 = r10.f15977q     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            int r3 = r0.length     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            r4 = 0
            r12.write((char[]) r0, (int) r4, (int) r3)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            goto L_0x0238
        L_0x0232:
            r4 = 0
            r11.e(r8)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            goto L_0x0238
        L_0x0237:
            r4 = 0
        L_0x0238:
            if (r15 != 0) goto L_0x028f
            d2.b r0 = r10.e()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r5 = r29
            if (r5 != r3) goto L_0x0277
            if (r0 == 0) goto L_0x024e
            java.lang.Class r0 = r0.serializeUsing()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            java.lang.Class<java.lang.Void> r3 = java.lang.Void.class
            if (r0 != r3) goto L_0x0277
        L_0x024e:
            if (r1 != 0) goto L_0x0269
            int r0 = r12.f14322d     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            int r1 = r1.mask     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0263
            int r0 = r11.f15906d     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            r0 = r0 & r1
            if (r0 == 0) goto L_0x025f
            goto L_0x0263
        L_0x025f:
            r12.H()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            goto L_0x0292
        L_0x0263:
            java.lang.String r0 = ""
            r12.K(r0)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            goto L_0x0292
        L_0x0269:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            boolean r0 = r12.f14324f     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r0 == 0) goto L_0x0273
            r12.M(r1)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            goto L_0x0292
        L_0x0273:
            r12.L(r1, r4)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            goto L_0x0292
        L_0x0277:
            boolean r0 = r10.f15980t     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r0 == 0) goto L_0x028b
            boolean r0 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r0 == 0) goto L_0x028b
            r0 = r1
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            int r0 = r0.size()     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            if (r0 != 0) goto L_0x028b
            r19 = r4
            goto L_0x029e
        L_0x028b:
            r11.f(r8, r1)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
            goto L_0x0292
        L_0x028f:
            r11.f(r8, r1)     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
        L_0x0292:
            r19 = r2
            goto L_0x029e
        L_0x0295:
            throw r3     // Catch:{ Exception -> 0x02b1, all -> 0x02e8 }
        L_0x0296:
            r22 = r2
            r2 = r5
            r23 = r6
            r4 = 0
            r13 = 44
        L_0x029e:
            int r0 = r22 + 1
            r9 = r26
            r10 = r27
            r11 = r28
            r5 = r2
            r3 = r13
            r14 = r20
            r13 = r21
            r6 = r23
            r2 = r0
            goto L_0x00ae
        L_0x02b1:
            r0 = move-exception
            r1 = r26
            goto L_0x02ed
        L_0x02b5:
            r0 = move-exception
            r1 = r26
            goto L_0x02f5
        L_0x02b9:
            r23 = r6
            r21 = r13
            r20 = r14
            r4 = 0
            r13 = r3
            r1 = r26
            if (r19 == 0) goto L_0x02c6
            r4 = r13
        L_0x02c6:
            r7.y(r8, r1, r4)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
            r2 = r21
            int r0 = r2.length     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
            if (r0 <= 0) goto L_0x02dc
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
            boolean r0 = r12.n(r0)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
            if (r0 == 0) goto L_0x02dc
            r25.s()     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
            r25.A()     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
        L_0x02dc:
            if (r30 != 0) goto L_0x02e3
            r2 = r23
            r12.append(r2)     // Catch:{ Exception -> 0x02ec, all -> 0x02e8 }
        L_0x02e3:
            r2 = r20
            r8.f14283q = r2
            return
        L_0x02e8:
            r0 = move-exception
            r2 = r20
            goto L_0x0351
        L_0x02ec:
            r0 = move-exception
        L_0x02ed:
            r2 = r20
            goto L_0x02f6
        L_0x02f0:
            r0 = move-exception
            r2 = r14
            goto L_0x0351
        L_0x02f3:
            r0 = move-exception
            r1 = r9
        L_0x02f5:
            r2 = r14
        L_0x02f6:
            java.lang.String r3 = "write javaBean error"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0350 }
            r4.<init>()     // Catch:{ all -> 0x0350 }
            r4.append(r3)     // Catch:{ all -> 0x0350 }
            java.lang.String r3 = ", class "
            r4.append(r3)     // Catch:{ all -> 0x0350 }
            java.lang.Class r1 = r26.getClass()     // Catch:{ all -> 0x0350 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0350 }
            r4.append(r1)     // Catch:{ all -> 0x0350 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0350 }
            r3 = r27
            if (r3 == 0) goto L_0x032c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0350 }
            r4.<init>()     // Catch:{ all -> 0x0350 }
            r4.append(r1)     // Catch:{ all -> 0x0350 }
            java.lang.String r1 = ", fieldName : "
            r4.append(r1)     // Catch:{ all -> 0x0350 }
            r4.append(r3)     // Catch:{ all -> 0x0350 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0350 }
        L_0x032c:
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0350 }
            if (r3 == 0) goto L_0x034a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0350 }
            r3.<init>()     // Catch:{ all -> 0x0350 }
            r3.append(r1)     // Catch:{ all -> 0x0350 }
            java.lang.String r1 = ", "
            r3.append(r1)     // Catch:{ all -> 0x0350 }
            java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x0350 }
            r3.append(r1)     // Catch:{ all -> 0x0350 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0350 }
        L_0x034a:
            com.alibaba.fastjson.JSONException r3 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0350 }
            r3.<init>(r1, r0)     // Catch:{ all -> 0x0350 }
            throw r3     // Catch:{ all -> 0x0350 }
        L_0x0350:
            r0 = move-exception
        L_0x0351:
            r8.f14283q = r2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.h.x(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    public char y(JSONSerializer jSONSerializer, Object obj, char c11) {
        List<AfterFilter> list = jSONSerializer.f14308b;
        if (list != null) {
            for (AfterFilter f11 : list) {
                c11 = f11.f(jSONSerializer, obj, c11);
            }
        }
        List<AfterFilter> list2 = this.f14308b;
        if (list2 != null) {
            for (AfterFilter f12 : list2) {
                c11 = f12.f(jSONSerializer, obj, c11);
            }
        }
        return c11;
    }

    public char z(JSONSerializer jSONSerializer, Object obj, char c11) {
        List<BeforeFilter> list = jSONSerializer.f14307a;
        if (list != null) {
            for (BeforeFilter f11 : list) {
                c11 = f11.f(jSONSerializer, obj, c11);
            }
        }
        List<BeforeFilter> list2 = this.f14307a;
        if (list2 != null) {
            for (BeforeFilter f12 : list2) {
                c11 = f12.f(jSONSerializer, obj, c11);
            }
        }
        return c11;
    }

    public h(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.b(cls, map, (PropertyNamingStrategy) null));
    }

    public h(o oVar) {
        f[] fVarArr;
        this.f15922l = oVar;
        this.f15921k = new f[oVar.f15932f.length];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            fVarArr = this.f15921k;
            if (i12 >= fVarArr.length) {
                break;
            }
            fVarArr[i12] = new f(oVar.f15927a, oVar.f15932f[i12]);
            i12++;
        }
        a[] aVarArr = oVar.f15931e;
        if (aVarArr == oVar.f15932f) {
            this.f15920j = fVarArr;
            return;
        }
        this.f15920j = new f[aVarArr.length];
        while (true) {
            f[] fVarArr2 = this.f15920j;
            if (i11 < fVarArr2.length) {
                fVarArr2[i11] = r(oVar.f15931e[i11].f15962b);
                i11++;
            } else {
                return;
            }
        }
    }
}
