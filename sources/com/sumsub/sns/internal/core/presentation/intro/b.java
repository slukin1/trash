package com.sumsub.sns.internal.core.presentation.intro;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import java.util.Map;
import kotlin.jvm.internal.r;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final b.c f33860a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Object> f33861b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33862c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33863d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, Object> f33864e;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001b, code lost:
        r4 = kotlin.collections.MapsKt__MapsKt.y(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(com.sumsub.sns.internal.core.data.source.dynamic.b.c r17, java.util.Map<java.lang.String, ? extends java.lang.Object> r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, boolean r22) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r19
            r3 = r21
            r16.<init>()
            r0.f33860a = r1
            r4 = r18
            r0.f33861b = r4
            r0.f33862c = r2
            r0.f33863d = r3
            java.util.Map r4 = r16.b()
            if (r4 == 0) goto L_0x0021
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.y(r4)
            if (r4 != 0) goto L_0x0026
        L_0x0021:
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
        L_0x0026:
            r0.f33864e = r4
            com.sumsub.sns.internal.core.presentation.intro.f r5 = new com.sumsub.sns.internal.core.presentation.intro.f
            r6 = r20
            r5.<init>(r2, r3, r6)
            if (r22 == 0) goto L_0x0036
            com.sumsub.sns.internal.core.presentation.intro.e r1 = com.sumsub.sns.internal.core.presentation.intro.d.b(r5, r1)
            goto L_0x003a
        L_0x0036:
            com.sumsub.sns.internal.core.presentation.intro.e r1 = com.sumsub.sns.internal.core.presentation.intro.d.a((com.sumsub.sns.internal.core.presentation.intro.f) r5, (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r1)
        L_0x003a:
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L_0x0147
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.sumsub.sns.internal.core.presentation.intro.c r3 = r1.o()
            r5 = 3
            r6 = 4
            java.lang.String r7 = "text"
            java.lang.String r8 = "header"
            java.lang.String r9 = "image"
            r10 = 2
            r11 = 1
            r12 = 0
            java.lang.String r13 = "type"
            if (r3 == 0) goto L_0x0087
            kotlin.Pair[] r14 = new kotlin.Pair[r6]
            java.lang.String r15 = "single"
            kotlin.Pair r15 = kotlin.l.a(r13, r15)
            r14[r12] = r15
            java.lang.String r15 = r3.d()
            kotlin.Pair r15 = kotlin.l.a(r9, r15)
            r14[r11] = r15
            java.lang.String r15 = r3.f()
            kotlin.Pair r15 = kotlin.l.a(r8, r15)
            r14[r10] = r15
            java.lang.String r3 = r3.e()
            kotlin.Pair r3 = kotlin.l.a(r7, r3)
            r14[r5] = r3
            java.util.Map r3 = kotlin.collections.MapsKt__MapsKt.l(r14)
            r2.add(r3)
        L_0x0087:
            com.sumsub.sns.internal.core.presentation.intro.c r3 = r1.k()
            if (r3 == 0) goto L_0x00bc
            kotlin.Pair[] r14 = new kotlin.Pair[r6]
            java.lang.String r15 = "do"
            kotlin.Pair r15 = kotlin.l.a(r13, r15)
            r14[r12] = r15
            java.lang.String r15 = r3.d()
            kotlin.Pair r15 = kotlin.l.a(r9, r15)
            r14[r11] = r15
            java.lang.String r15 = r3.f()
            kotlin.Pair r15 = kotlin.l.a(r8, r15)
            r14[r10] = r15
            java.lang.String r3 = r3.e()
            kotlin.Pair r3 = kotlin.l.a(r7, r3)
            r14[r5] = r3
            java.util.Map r3 = kotlin.collections.MapsKt__MapsKt.l(r14)
            r2.add(r3)
        L_0x00bc:
            com.sumsub.sns.internal.core.presentation.intro.c r3 = r1.l()
            if (r3 == 0) goto L_0x00f1
            kotlin.Pair[] r6 = new kotlin.Pair[r6]
            java.lang.String r14 = "dont"
            kotlin.Pair r14 = kotlin.l.a(r13, r14)
            r6[r12] = r14
            java.lang.String r14 = r3.d()
            kotlin.Pair r14 = kotlin.l.a(r9, r14)
            r6[r11] = r14
            java.lang.String r14 = r3.f()
            kotlin.Pair r14 = kotlin.l.a(r8, r14)
            r6[r10] = r14
            java.lang.String r3 = r3.e()
            kotlin.Pair r3 = kotlin.l.a(r7, r3)
            r6[r5] = r3
            java.util.Map r3 = kotlin.collections.MapsKt__MapsKt.l(r6)
            r2.add(r3)
        L_0x00f1:
            java.lang.String r3 = r1.n()
            if (r3 == 0) goto L_0x010c
            kotlin.Pair[] r5 = new kotlin.Pair[r10]
            kotlin.Pair r6 = kotlin.l.a(r13, r9)
            r5[r12] = r6
            kotlin.Pair r3 = kotlin.l.a(r9, r3)
            r5[r11] = r3
            java.util.Map r3 = kotlin.collections.MapsKt__MapsKt.l(r5)
            r2.add(r3)
        L_0x010c:
            java.lang.String r3 = r1.m()
            if (r3 == 0) goto L_0x0127
            kotlin.Pair[] r5 = new kotlin.Pair[r10]
            kotlin.Pair r6 = kotlin.l.a(r13, r8)
            r5[r12] = r6
            kotlin.Pair r3 = kotlin.l.a(r8, r3)
            r5[r11] = r3
            java.util.Map r3 = kotlin.collections.MapsKt__MapsKt.l(r5)
            r2.add(r3)
        L_0x0127:
            java.lang.String r3 = r1.q()
            if (r3 == 0) goto L_0x0142
            kotlin.Pair[] r5 = new kotlin.Pair[r10]
            kotlin.Pair r6 = kotlin.l.a(r13, r7)
            r5[r12] = r6
            kotlin.Pair r3 = kotlin.l.a(r7, r3)
            r5[r11] = r3
            java.util.Map r3 = kotlin.collections.MapsKt__MapsKt.l(r5)
            r2.add(r3)
        L_0x0142:
            java.lang.String r3 = "contentBlocks"
            r4.put(r3, r2)
        L_0x0147:
            java.lang.String r2 = "title"
            boolean r3 = r4.containsKey(r2)
            if (r3 == 0) goto L_0x0151
            if (r22 == 0) goto L_0x015e
        L_0x0151:
            java.lang.String r3 = r1.r()
            if (r3 == 0) goto L_0x015e
            java.lang.String r3 = r1.r()
            r4.put(r2, r3)
        L_0x015e:
            java.lang.String r2 = "subtitle"
            boolean r3 = r4.containsKey(r2)
            if (r3 == 0) goto L_0x0168
            if (r22 == 0) goto L_0x0175
        L_0x0168:
            java.lang.String r3 = r1.p()
            if (r3 == 0) goto L_0x0175
            java.lang.String r3 = r1.p()
            r4.put(r2, r3)
        L_0x0175:
            java.lang.String r2 = "actionTitle"
            boolean r3 = r4.containsKey(r2)
            if (r3 == 0) goto L_0x017f
            if (r22 == 0) goto L_0x018c
        L_0x017f:
            java.lang.String r3 = r1.j()
            if (r3 == 0) goto L_0x018c
            java.lang.String r1 = r1.j()
            r4.put(r2, r1)
        L_0x018c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.intro.b.<init>(com.sumsub.sns.internal.core.data.source.dynamic.b$c, java.util.Map, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    public final String a() {
        Object obj = c().get("actionTitle");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0083 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> b() {
        /*
            r10 = this;
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r0 = r10.f33860a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "sns_step_"
            r1.append(r2)
            java.lang.String r2 = r10.f33862c
            r1.append(r2)
            r2 = 95
            r1.append(r2)
            java.lang.String r2 = r10.f33863d
            r1.append(r2)
            java.lang.String r2 = "_instructions_definitionKey"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = r0.a((java.lang.String) r1)
            r0 = 0
            if (r2 == 0) goto L_0x00d4
            java.util.Map<java.lang.String, java.lang.Object> r1 = r10.f33861b
            if (r1 == 0) goto L_0x00d4
            r8 = 1
            char[] r3 = new char[r8]
            r4 = 46
            r9 = 0
            r3[r9] = r4
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            java.util.List r2 = kotlin.text.StringsKt__StringsKt.K0(r2, r3, r4, r5, r6, r7)
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r3.element = r1
            int r1 = r2.size()
            int r1 = r1 - r8
            kotlin.ranges.h r1 = kotlin.ranges.RangesKt___RangesKt.o(r9, r1)
            java.util.Iterator r1 = r1.iterator()
        L_0x0053:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00be
            r4 = r1
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4
            int r4 = r4.a()
            T r5 = r3.element
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r4 = r2.get(r4)
            java.lang.Object r4 = r5.get(r4)
            boolean r5 = r4 instanceof java.util.Map
            if (r5 == 0) goto L_0x0073
            java.util.Map r4 = (java.util.Map) r4
            goto L_0x0074
        L_0x0073:
            r4 = r0
        L_0x0074:
            if (r4 == 0) goto L_0x00d4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0083:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00b4
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getKey()
            boolean r8 = r7 instanceof java.lang.String
            if (r8 != 0) goto L_0x0098
            r7 = r0
        L_0x0098:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L_0x009d
            goto L_0x00a8
        L_0x009d:
            java.lang.Object r6 = r6.getValue()
            boolean r8 = r6 instanceof java.lang.Object
            if (r8 != 0) goto L_0x00a6
            r6 = r0
        L_0x00a6:
            if (r6 != 0) goto L_0x00aa
        L_0x00a8:
            r6 = r0
            goto L_0x00ae
        L_0x00aa:
            kotlin.Pair r6 = kotlin.l.a(r7, r6)
        L_0x00ae:
            if (r6 == 0) goto L_0x0083
            r5.add(r6)
            goto L_0x0083
        L_0x00b4:
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.s(r5)
            if (r4 != 0) goto L_0x00bb
            goto L_0x00d4
        L_0x00bb:
            r3.element = r4
            goto L_0x0053
        L_0x00be:
            T r1 = r3.element
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r2)
            java.lang.Object r1 = r1.get(r2)
            boolean r2 = kotlin.jvm.internal.TypeIntrinsics.l(r1)
            if (r2 != 0) goto L_0x00d1
            goto L_0x00d2
        L_0x00d1:
            r0 = r1
        L_0x00d2:
            java.util.Map r0 = (java.util.Map) r0
        L_0x00d4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.intro.b.b():java.util.Map");
    }

    public final Map<String, Object> c() {
        return this.f33864e;
    }

    public final String d() {
        Object obj = c().get(MessengerShareContentUtility.SUBTITLE);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final String e() {
        Object obj = c().get("title");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final boolean f() {
        if (e0.f32018a.getInstructionsViewHandler() == null) {
            Object obj = this.f33864e.get("title");
            String str = obj instanceof String ? (String) obj : null;
            if (str == null || StringsKt__StringsJVMKt.z(str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(b.c cVar, Map map, String str, String str2, String str3, boolean z11, int i11, r rVar) {
        this(cVar, map, str, str2, str3, (i11 & 32) != 0 ? false : z11);
    }
}
