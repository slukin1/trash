package com.sumsub.sns.internal.core.data.model;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.remote.c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class f {
    public static final Map<String, String> a(Map<String, String> map, g gVar) {
        g.c I;
        List<String> h11;
        LinkedHashMap linkedHashMap;
        g.c I2;
        List<String> i11;
        List<String> list = null;
        if (!(gVar == null || (I2 = gVar.I()) == null || (i11 = I2.i()) == null)) {
            if (!(!i11.isEmpty())) {
                i11 = null;
            }
            if (i11 != null) {
                linkedHashMap = new LinkedHashMap();
                for (Map.Entry next : map.entrySet()) {
                    if (i11.contains(next.getKey())) {
                        linkedHashMap.put(next.getKey(), next.getValue());
                    }
                }
                return linkedHashMap;
            }
        }
        if (gVar == null || (I = gVar.I()) == null || (h11 = I.h()) == null) {
            return map;
        }
        if (!h11.isEmpty()) {
            list = h11;
        }
        if (list == null) {
            return map;
        }
        linkedHashMap = new LinkedHashMap();
        for (Map.Entry next2 : map.entrySet()) {
            if (!list.contains(next2.getKey())) {
                linkedHashMap.put(next2.getKey(), next2.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final String b(e eVar, String str) {
        Object C;
        if (str == null || (C = eVar.C()) == null) {
            return null;
        }
        List<String> L0 = StringsKt__StringsKt.L0(str, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null);
        if (L0.isEmpty()) {
            return null;
        }
        for (String str2 : L0) {
            if (C instanceof Map) {
                C = ((Map) C).get(str2);
            }
            if (C instanceof String) {
                return (String) C;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x002a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <A, B> java.util.Map<A, B> c(com.sumsub.sns.internal.core.data.model.e r8, java.lang.String r9) {
        /*
            java.util.Map r8 = r8.C()
            r0 = 0
            if (r8 == 0) goto L_0x000c
            java.lang.Object r8 = r8.get(r9)
            goto L_0x000d
        L_0x000c:
            r8 = r0
        L_0x000d:
            boolean r9 = r8 instanceof java.util.Map
            if (r9 == 0) goto L_0x0014
            java.util.Map r8 = (java.util.Map) r8
            goto L_0x0015
        L_0x0014:
            r8 = r0
        L_0x0015:
            java.lang.String r9 = "B"
            java.lang.String r1 = "A"
            r2 = 0
            r3 = 1
            if (r8 == 0) goto L_0x005e
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x002a:
            boolean r5 = r8.hasNext()
            if (r5 == 0) goto L_0x005f
            java.lang.Object r5 = r8.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            r7 = 3
            kotlin.jvm.internal.x.f(r7, r1)
            boolean r6 = r6 instanceof java.lang.Object
            if (r6 == 0) goto L_0x004f
            java.lang.Object r6 = r5.getValue()
            kotlin.jvm.internal.x.f(r7, r9)
            boolean r6 = r6 instanceof java.lang.Object
            if (r6 == 0) goto L_0x004f
            r6 = r3
            goto L_0x0050
        L_0x004f:
            r6 = r2
        L_0x0050:
            if (r6 == 0) goto L_0x002a
            java.lang.Object r6 = r5.getKey()
            java.lang.Object r5 = r5.getValue()
            r4.put(r6, r5)
            goto L_0x002a
        L_0x005e:
            r4 = r0
        L_0x005f:
            if (r4 == 0) goto L_0x0069
            boolean r8 = r4.isEmpty()
            r8 = r8 ^ r3
            if (r8 != r3) goto L_0x0069
            r2 = r3
        L_0x0069:
            if (r2 == 0) goto L_0x006c
            goto L_0x006d
        L_0x006c:
            r4 = r0
        L_0x006d:
            if (r4 == 0) goto L_0x00ac
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Set r2 = r4.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x007c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00a8
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            r5 = 2
            kotlin.jvm.internal.x.f(r5, r1)
            if (r4 != 0) goto L_0x0093
            goto L_0x009c
        L_0x0093:
            java.lang.Object r3 = r3.getValue()
            kotlin.jvm.internal.x.f(r5, r9)
            if (r3 != 0) goto L_0x009e
        L_0x009c:
            r3 = r0
            goto L_0x00a2
        L_0x009e:
            kotlin.Pair r3 = kotlin.l.a(r4, r3)
        L_0x00a2:
            if (r3 == 0) goto L_0x007c
            r8.add(r3)
            goto L_0x007c
        L_0x00a8:
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r8)
        L_0x00ac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.c(com.sumsub.sns.internal.core.data.model.e, java.lang.String):java.util.Map");
    }

    public static /* synthetic */ void c(e eVar) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x005f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean d(com.sumsub.sns.internal.core.data.model.e r9, java.lang.String r10) {
        /*
            r0 = 1
            java.util.Map r1 = r9.E()     // Catch:{ Exception -> 0x00b5 }
            r2 = 0
            if (r1 == 0) goto L_0x00ae
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r4 = "steps"
            r5 = 0
            r3[r5] = r4     // Catch:{ Exception -> 0x00b5 }
            r3[r0] = r10     // Catch:{ Exception -> 0x00b5 }
            r10 = 2
            java.lang.String r4 = "documentSelectorMode"
            r3[r10] = r4     // Catch:{ Exception -> 0x00b5 }
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.n(r3)     // Catch:{ Exception -> 0x00b5 }
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x00b5 }
            r3.<init>()     // Catch:{ Exception -> 0x00b5 }
            r3.element = r1     // Catch:{ Exception -> 0x00b5 }
            int r1 = r10.size()     // Catch:{ Exception -> 0x00b5 }
            int r1 = r1 - r0
            kotlin.ranges.h r1 = kotlin.ranges.RangesKt___RangesKt.o(r5, r1)     // Catch:{ Exception -> 0x00b5 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00b5 }
        L_0x002f:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x00b5 }
            if (r4 == 0) goto L_0x009a
            r4 = r1
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4     // Catch:{ Exception -> 0x00b5 }
            int r4 = r4.a()     // Catch:{ Exception -> 0x00b5 }
            T r5 = r3.element     // Catch:{ Exception -> 0x00b5 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r4 = r10.get(r4)     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ Exception -> 0x00b5 }
            boolean r5 = r4 instanceof java.util.Map     // Catch:{ Exception -> 0x00b5 }
            if (r5 == 0) goto L_0x004f
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x00b5 }
            goto L_0x0050
        L_0x004f:
            r4 = r2
        L_0x0050:
            if (r4 == 0) goto L_0x00ae
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b5 }
            r5.<init>()     // Catch:{ Exception -> 0x00b5 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ Exception -> 0x00b5 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00b5 }
        L_0x005f:
            boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x00b5 }
            if (r6 == 0) goto L_0x0090
            java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x00b5 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ Exception -> 0x00b5 }
            boolean r8 = r7 instanceof java.lang.String     // Catch:{ Exception -> 0x00b5 }
            if (r8 != 0) goto L_0x0074
            r7 = r2
        L_0x0074:
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00b5 }
            if (r7 != 0) goto L_0x0079
            goto L_0x0084
        L_0x0079:
            java.lang.Object r6 = r6.getValue()     // Catch:{ Exception -> 0x00b5 }
            boolean r8 = r6 instanceof java.lang.Object     // Catch:{ Exception -> 0x00b5 }
            if (r8 != 0) goto L_0x0082
            r6 = r2
        L_0x0082:
            if (r6 != 0) goto L_0x0086
        L_0x0084:
            r6 = r2
            goto L_0x008a
        L_0x0086:
            kotlin.Pair r6 = kotlin.l.a(r7, r6)     // Catch:{ Exception -> 0x00b5 }
        L_0x008a:
            if (r6 == 0) goto L_0x005f
            r5.add(r6)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x005f
        L_0x0090:
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.s(r5)     // Catch:{ Exception -> 0x00b5 }
            if (r4 != 0) goto L_0x0097
            goto L_0x00ae
        L_0x0097:
            r3.element = r4     // Catch:{ Exception -> 0x00b5 }
            goto L_0x002f
        L_0x009a:
            T r1 = r3.element     // Catch:{ Exception -> 0x00b5 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r10)     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ Exception -> 0x00b5 }
            boolean r1 = r10 instanceof java.lang.String     // Catch:{ Exception -> 0x00b5 }
            if (r1 != 0) goto L_0x00ab
            goto L_0x00ac
        L_0x00ab:
            r2 = r10
        L_0x00ac:
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00b5 }
        L_0x00ae:
            java.lang.String r10 = "disabled"
            boolean r0 = kotlin.jvm.internal.x.b(r2, r10)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00d4
        L_0x00b5:
            r10 = move-exception
            com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r2 = com.sumsub.sns.internal.log.c.a(r9)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Can't parse documentSelectorMode "
            r3.append(r4)
            java.util.Map r9 = r9.E()
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            com.sumsub.sns.internal.log.b.b(r1, r2, r9, r10)
        L_0x00d4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.d(com.sumsub.sns.internal.core.data.model.e, java.lang.String):boolean");
    }

    public static /* synthetic */ void e(e eVar) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0080 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0053 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean f(com.sumsub.sns.internal.core.data.model.e r10) {
        /*
            r0 = 0
            java.util.Map r1 = r10.E()     // Catch:{ Exception -> 0x00a9 }
            if (r1 == 0) goto L_0x00c8
            java.lang.String r2 = "disableStepsScreen"
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r2)     // Catch:{ Exception -> 0x00a9 }
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x00a9 }
            r3.<init>()     // Catch:{ Exception -> 0x00a9 }
            r3.element = r1     // Catch:{ Exception -> 0x00a9 }
            int r1 = r2.size()     // Catch:{ Exception -> 0x00a9 }
            int r1 = r1 + -1
            kotlin.ranges.h r1 = kotlin.ranges.RangesKt___RangesKt.o(r0, r1)     // Catch:{ Exception -> 0x00a9 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00a9 }
        L_0x0022:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x00a9 }
            r5 = 0
            if (r4 == 0) goto L_0x008e
            r4 = r1
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4     // Catch:{ Exception -> 0x00a9 }
            int r4 = r4.a()     // Catch:{ Exception -> 0x00a9 }
            T r6 = r3.element     // Catch:{ Exception -> 0x00a9 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r4 = r6.get(r4)     // Catch:{ Exception -> 0x00a9 }
            boolean r6 = r4 instanceof java.util.Map     // Catch:{ Exception -> 0x00a9 }
            if (r6 == 0) goto L_0x0043
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0044
        L_0x0043:
            r4 = r5
        L_0x0044:
            if (r4 == 0) goto L_0x00a2
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a9 }
            r6.<init>()     // Catch:{ Exception -> 0x00a9 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ Exception -> 0x00a9 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00a9 }
        L_0x0053:
            boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x00a9 }
            if (r7 == 0) goto L_0x0084
            java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x00a9 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r8 = r7.getKey()     // Catch:{ Exception -> 0x00a9 }
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x00a9 }
            if (r9 != 0) goto L_0x0068
            r8 = r5
        L_0x0068:
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00a9 }
            if (r8 != 0) goto L_0x006d
            goto L_0x0078
        L_0x006d:
            java.lang.Object r7 = r7.getValue()     // Catch:{ Exception -> 0x00a9 }
            boolean r9 = r7 instanceof java.lang.Object     // Catch:{ Exception -> 0x00a9 }
            if (r9 != 0) goto L_0x0076
            r7 = r5
        L_0x0076:
            if (r7 != 0) goto L_0x007a
        L_0x0078:
            r7 = r5
            goto L_0x007e
        L_0x007a:
            kotlin.Pair r7 = kotlin.l.a(r8, r7)     // Catch:{ Exception -> 0x00a9 }
        L_0x007e:
            if (r7 == 0) goto L_0x0053
            r6.add(r7)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0053
        L_0x0084:
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.s(r6)     // Catch:{ Exception -> 0x00a9 }
            if (r4 != 0) goto L_0x008b
            goto L_0x00a2
        L_0x008b:
            r3.element = r4     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0022
        L_0x008e:
            T r1 = r3.element     // Catch:{ Exception -> 0x00a9 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r2)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x00a9 }
            boolean r2 = r1 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x00a9 }
            if (r2 != 0) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r5 = r1
        L_0x00a0:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x00a9 }
        L_0x00a2:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00a9 }
            boolean r0 = kotlin.jvm.internal.x.b(r5, r1)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00c8
        L_0x00a9:
            r1 = move-exception
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r3 = com.sumsub.sns.internal.log.c.a(r10)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Can't parse "
            r4.append(r5)
            java.util.Map r10 = r10.E()
            r4.append(r10)
            java.lang.String r10 = r4.toString()
            com.sumsub.sns.internal.log.b.b(r2, r3, r10, r1)
        L_0x00c8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.f(com.sumsub.sns.internal.core.data.model.e):boolean");
    }

    public static /* synthetic */ void g(e eVar) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0080 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0053 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean h(com.sumsub.sns.internal.core.data.model.e r10) {
        /*
            r0 = 0
            java.util.Map r1 = r10.E()     // Catch:{ Exception -> 0x00a9 }
            if (r1 == 0) goto L_0x00c8
            java.lang.String r2 = "disableTemporarilyDeclinedStatusScreen"
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r2)     // Catch:{ Exception -> 0x00a9 }
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x00a9 }
            r3.<init>()     // Catch:{ Exception -> 0x00a9 }
            r3.element = r1     // Catch:{ Exception -> 0x00a9 }
            int r1 = r2.size()     // Catch:{ Exception -> 0x00a9 }
            int r1 = r1 + -1
            kotlin.ranges.h r1 = kotlin.ranges.RangesKt___RangesKt.o(r0, r1)     // Catch:{ Exception -> 0x00a9 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00a9 }
        L_0x0022:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x00a9 }
            r5 = 0
            if (r4 == 0) goto L_0x008e
            r4 = r1
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4     // Catch:{ Exception -> 0x00a9 }
            int r4 = r4.a()     // Catch:{ Exception -> 0x00a9 }
            T r6 = r3.element     // Catch:{ Exception -> 0x00a9 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r4 = r6.get(r4)     // Catch:{ Exception -> 0x00a9 }
            boolean r6 = r4 instanceof java.util.Map     // Catch:{ Exception -> 0x00a9 }
            if (r6 == 0) goto L_0x0043
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0044
        L_0x0043:
            r4 = r5
        L_0x0044:
            if (r4 == 0) goto L_0x00a2
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a9 }
            r6.<init>()     // Catch:{ Exception -> 0x00a9 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ Exception -> 0x00a9 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00a9 }
        L_0x0053:
            boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x00a9 }
            if (r7 == 0) goto L_0x0084
            java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x00a9 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r8 = r7.getKey()     // Catch:{ Exception -> 0x00a9 }
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x00a9 }
            if (r9 != 0) goto L_0x0068
            r8 = r5
        L_0x0068:
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00a9 }
            if (r8 != 0) goto L_0x006d
            goto L_0x0078
        L_0x006d:
            java.lang.Object r7 = r7.getValue()     // Catch:{ Exception -> 0x00a9 }
            boolean r9 = r7 instanceof java.lang.Object     // Catch:{ Exception -> 0x00a9 }
            if (r9 != 0) goto L_0x0076
            r7 = r5
        L_0x0076:
            if (r7 != 0) goto L_0x007a
        L_0x0078:
            r7 = r5
            goto L_0x007e
        L_0x007a:
            kotlin.Pair r7 = kotlin.l.a(r8, r7)     // Catch:{ Exception -> 0x00a9 }
        L_0x007e:
            if (r7 == 0) goto L_0x0053
            r6.add(r7)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0053
        L_0x0084:
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.s(r6)     // Catch:{ Exception -> 0x00a9 }
            if (r4 != 0) goto L_0x008b
            goto L_0x00a2
        L_0x008b:
            r3.element = r4     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0022
        L_0x008e:
            T r1 = r3.element     // Catch:{ Exception -> 0x00a9 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r2)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x00a9 }
            boolean r2 = r1 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x00a9 }
            if (r2 != 0) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r5 = r1
        L_0x00a0:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x00a9 }
        L_0x00a2:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00a9 }
            boolean r0 = kotlin.jvm.internal.x.b(r5, r1)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00c8
        L_0x00a9:
            r1 = move-exception
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r3 = com.sumsub.sns.internal.log.c.a(r10)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Can't parse disableTemporarilyDeclinedStatusScreen "
            r4.append(r5)
            java.util.Map r10 = r10.E()
            r4.append(r10)
            java.lang.String r10 = r4.toString()
            com.sumsub.sns.internal.log.b.b(r2, r3, r10, r1)
        L_0x00c8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.h(com.sumsub.sns.internal.core.data.model.e):boolean");
    }

    public static /* synthetic */ void i(e eVar) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0073 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.lang.String> j(com.sumsub.sns.internal.core.data.model.e r6) {
        /*
            java.util.Map r6 = r6.C()
            r0 = 0
            if (r6 == 0) goto L_0x000e
            java.lang.String r1 = "idDocErrors"
            java.lang.Object r6 = r6.get(r1)
            goto L_0x000f
        L_0x000e:
            r6 = r0
        L_0x000f:
            boolean r1 = r6 instanceof java.util.Map
            if (r1 == 0) goto L_0x0016
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x0017
        L_0x0016:
            r6 = r0
        L_0x0017:
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0055
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0028:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = r6.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x0046
            java.lang.Object r5 = r4.getValue()
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x0046
            r5 = r2
            goto L_0x0047
        L_0x0046:
            r5 = r1
        L_0x0047:
            if (r5 == 0) goto L_0x0028
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r3.put(r5, r4)
            goto L_0x0028
        L_0x0055:
            r3 = r0
        L_0x0056:
            if (r3 == 0) goto L_0x0060
            boolean r6 = r3.isEmpty()
            r6 = r6 ^ r2
            if (r6 != r2) goto L_0x0060
            r1 = r2
        L_0x0060:
            if (r1 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r3 = r0
        L_0x0064:
            if (r3 == 0) goto L_0x00aa
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Set r1 = r3.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0073:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00a6
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            boolean r4 = r3 instanceof java.lang.String
            if (r4 != 0) goto L_0x0088
            r3 = r0
        L_0x0088:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x008d
            goto L_0x009a
        L_0x008d:
            java.lang.Object r2 = r2.getValue()
            boolean r4 = r2 instanceof java.lang.String
            if (r4 != 0) goto L_0x0096
            r2 = r0
        L_0x0096:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x009c
        L_0x009a:
            r2 = r0
            goto L_0x00a0
        L_0x009c:
            kotlin.Pair r2 = kotlin.l.a(r3, r2)
        L_0x00a0:
            if (r2 == 0) goto L_0x0073
            r6.add(r2)
            goto L_0x0073
        L_0x00a6:
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r6)
        L_0x00aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.j(com.sumsub.sns.internal.core.data.model.e):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0073 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.lang.String> k(com.sumsub.sns.internal.core.data.model.e r6) {
        /*
            java.util.Map r6 = r6.C()
            r0 = 0
            if (r6 == 0) goto L_0x000e
            java.lang.String r1 = "genders"
            java.lang.Object r6 = r6.get(r1)
            goto L_0x000f
        L_0x000e:
            r6 = r0
        L_0x000f:
            boolean r1 = r6 instanceof java.util.Map
            if (r1 == 0) goto L_0x0016
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x0017
        L_0x0016:
            r6 = r0
        L_0x0017:
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0055
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0028:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = r6.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x0046
            java.lang.Object r5 = r4.getValue()
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x0046
            r5 = r2
            goto L_0x0047
        L_0x0046:
            r5 = r1
        L_0x0047:
            if (r5 == 0) goto L_0x0028
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r3.put(r5, r4)
            goto L_0x0028
        L_0x0055:
            r3 = r0
        L_0x0056:
            if (r3 == 0) goto L_0x0060
            boolean r6 = r3.isEmpty()
            r6 = r6 ^ r2
            if (r6 != r2) goto L_0x0060
            r1 = r2
        L_0x0060:
            if (r1 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r3 = r0
        L_0x0064:
            if (r3 == 0) goto L_0x00aa
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Set r1 = r3.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0073:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00a6
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            boolean r4 = r3 instanceof java.lang.String
            if (r4 != 0) goto L_0x0088
            r3 = r0
        L_0x0088:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x008d
            goto L_0x009a
        L_0x008d:
            java.lang.Object r2 = r2.getValue()
            boolean r4 = r2 instanceof java.lang.String
            if (r4 != 0) goto L_0x0096
            r2 = r0
        L_0x0096:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x009c
        L_0x009a:
            r2 = r0
            goto L_0x00a0
        L_0x009c:
            kotlin.Pair r2 = kotlin.l.a(r3, r2)
        L_0x00a0:
            if (r2 == 0) goto L_0x0073
            r6.add(r2)
            goto L_0x0073
        L_0x00a6:
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r6)
        L_0x00aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.k(com.sumsub.sns.internal.core.data.model.e):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0073 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.lang.String> l(com.sumsub.sns.internal.core.data.model.e r6) {
        /*
            java.util.Map r6 = r6.C()
            r0 = 0
            if (r6 == 0) goto L_0x000e
            java.lang.String r1 = "languages"
            java.lang.Object r6 = r6.get(r1)
            goto L_0x000f
        L_0x000e:
            r6 = r0
        L_0x000f:
            boolean r1 = r6 instanceof java.util.Map
            if (r1 == 0) goto L_0x0016
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x0017
        L_0x0016:
            r6 = r0
        L_0x0017:
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0055
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0028:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = r6.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x0046
            java.lang.Object r5 = r4.getValue()
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x0046
            r5 = r2
            goto L_0x0047
        L_0x0046:
            r5 = r1
        L_0x0047:
            if (r5 == 0) goto L_0x0028
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r3.put(r5, r4)
            goto L_0x0028
        L_0x0055:
            r3 = r0
        L_0x0056:
            if (r3 == 0) goto L_0x0060
            boolean r6 = r3.isEmpty()
            r6 = r6 ^ r2
            if (r6 != r2) goto L_0x0060
            r1 = r2
        L_0x0060:
            if (r1 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r3 = r0
        L_0x0064:
            if (r3 == 0) goto L_0x00aa
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Set r1 = r3.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0073:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00a6
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            boolean r4 = r3 instanceof java.lang.String
            if (r4 != 0) goto L_0x0088
            r3 = r0
        L_0x0088:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x008d
            goto L_0x009a
        L_0x008d:
            java.lang.Object r2 = r2.getValue()
            boolean r4 = r2 instanceof java.lang.String
            if (r4 != 0) goto L_0x0096
            r2 = r0
        L_0x0096:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x009c
        L_0x009a:
            r2 = r0
            goto L_0x00a0
        L_0x009c:
            kotlin.Pair r2 = kotlin.l.a(r3, r2)
        L_0x00a0:
            if (r2 == 0) goto L_0x0073
            r6.add(r2)
            goto L_0x0073
        L_0x00a6:
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r6)
        L_0x00aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.l(com.sumsub.sns.internal.core.data.model.e):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0080 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0053 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean m(com.sumsub.sns.internal.core.data.model.e r10) {
        /*
            r0 = 0
            java.util.Map r1 = r10.E()     // Catch:{ Exception -> 0x00a9 }
            if (r1 == 0) goto L_0x00c8
            java.lang.String r2 = "livenessSaveMode"
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r2)     // Catch:{ Exception -> 0x00a9 }
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x00a9 }
            r3.<init>()     // Catch:{ Exception -> 0x00a9 }
            r3.element = r1     // Catch:{ Exception -> 0x00a9 }
            int r1 = r2.size()     // Catch:{ Exception -> 0x00a9 }
            int r1 = r1 + -1
            kotlin.ranges.h r1 = kotlin.ranges.RangesKt___RangesKt.o(r0, r1)     // Catch:{ Exception -> 0x00a9 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00a9 }
        L_0x0022:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x00a9 }
            r5 = 0
            if (r4 == 0) goto L_0x008e
            r4 = r1
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4     // Catch:{ Exception -> 0x00a9 }
            int r4 = r4.a()     // Catch:{ Exception -> 0x00a9 }
            T r6 = r3.element     // Catch:{ Exception -> 0x00a9 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r4 = r6.get(r4)     // Catch:{ Exception -> 0x00a9 }
            boolean r6 = r4 instanceof java.util.Map     // Catch:{ Exception -> 0x00a9 }
            if (r6 == 0) goto L_0x0043
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0044
        L_0x0043:
            r4 = r5
        L_0x0044:
            if (r4 == 0) goto L_0x00a2
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a9 }
            r6.<init>()     // Catch:{ Exception -> 0x00a9 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ Exception -> 0x00a9 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00a9 }
        L_0x0053:
            boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x00a9 }
            if (r7 == 0) goto L_0x0084
            java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x00a9 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r8 = r7.getKey()     // Catch:{ Exception -> 0x00a9 }
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x00a9 }
            if (r9 != 0) goto L_0x0068
            r8 = r5
        L_0x0068:
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00a9 }
            if (r8 != 0) goto L_0x006d
            goto L_0x0078
        L_0x006d:
            java.lang.Object r7 = r7.getValue()     // Catch:{ Exception -> 0x00a9 }
            boolean r9 = r7 instanceof java.lang.Object     // Catch:{ Exception -> 0x00a9 }
            if (r9 != 0) goto L_0x0076
            r7 = r5
        L_0x0076:
            if (r7 != 0) goto L_0x007a
        L_0x0078:
            r7 = r5
            goto L_0x007e
        L_0x007a:
            kotlin.Pair r7 = kotlin.l.a(r8, r7)     // Catch:{ Exception -> 0x00a9 }
        L_0x007e:
            if (r7 == 0) goto L_0x0053
            r6.add(r7)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0053
        L_0x0084:
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.s(r6)     // Catch:{ Exception -> 0x00a9 }
            if (r4 != 0) goto L_0x008b
            goto L_0x00a2
        L_0x008b:
            r3.element = r4     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0022
        L_0x008e:
            T r1 = r3.element     // Catch:{ Exception -> 0x00a9 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r2)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x00a9 }
            boolean r2 = r1 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x00a9 }
            if (r2 != 0) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r5 = r1
        L_0x00a0:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x00a9 }
        L_0x00a2:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00a9 }
            boolean r0 = kotlin.jvm.internal.x.b(r5, r1)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00c8
        L_0x00a9:
            r1 = move-exception
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r3 = com.sumsub.sns.internal.log.c.a(r10)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Can't parse livenessSaveMode "
            r4.append(r5)
            java.util.Map r10 = r10.E()
            r4.append(r10)
            java.lang.String r10 = r4.toString()
            com.sumsub.sns.internal.log.b.b(r2, r3, r10, r1)
        L_0x00c8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.m(com.sumsub.sns.internal.core.data.model.e):boolean");
    }

    public static /* synthetic */ void n(e eVar) {
    }

    public static final Map<String, c> o(e eVar) {
        Map<String, c> B = eVar.B();
        if (B == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.d(B.size()));
        for (Map.Entry entry : B.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((c) entry.getValue()).h());
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0073 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.lang.String> p(com.sumsub.sns.internal.core.data.model.e r6) {
        /*
            java.util.Map r6 = r6.C()
            r0 = 0
            if (r6 == 0) goto L_0x000e
            java.lang.String r1 = "idDocWarnings"
            java.lang.Object r6 = r6.get(r1)
            goto L_0x000f
        L_0x000e:
            r6 = r0
        L_0x000f:
            boolean r1 = r6 instanceof java.util.Map
            if (r1 == 0) goto L_0x0016
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x0017
        L_0x0016:
            r6 = r0
        L_0x0017:
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0055
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0028:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = r6.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x0046
            java.lang.Object r5 = r4.getValue()
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x0046
            r5 = r2
            goto L_0x0047
        L_0x0046:
            r5 = r1
        L_0x0047:
            if (r5 == 0) goto L_0x0028
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r3.put(r5, r4)
            goto L_0x0028
        L_0x0055:
            r3 = r0
        L_0x0056:
            if (r3 == 0) goto L_0x0060
            boolean r6 = r3.isEmpty()
            r6 = r6 ^ r2
            if (r6 != r2) goto L_0x0060
            r1 = r2
        L_0x0060:
            if (r1 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r3 = r0
        L_0x0064:
            if (r3 == 0) goto L_0x00aa
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Set r1 = r3.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0073:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00a6
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            boolean r4 = r3 instanceof java.lang.String
            if (r4 != 0) goto L_0x0088
            r3 = r0
        L_0x0088:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x008d
            goto L_0x009a
        L_0x008d:
            java.lang.Object r2 = r2.getValue()
            boolean r4 = r2 instanceof java.lang.String
            if (r4 != 0) goto L_0x0096
            r2 = r0
        L_0x0096:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x009c
        L_0x009a:
            r2 = r0
            goto L_0x00a0
        L_0x009c:
            kotlin.Pair r2 = kotlin.l.a(r3, r2)
        L_0x00a0:
            if (r2 == 0) goto L_0x0073
            r6.add(r2)
            goto L_0x0073
        L_0x00a6:
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r6)
        L_0x00aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.p(com.sumsub.sns.internal.core.data.model.e):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0080 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0053 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean b(com.sumsub.sns.internal.core.data.model.e r10) {
        /*
            r0 = 0
            java.util.Map r1 = r10.E()     // Catch:{ Exception -> 0x00a9 }
            if (r1 == 0) goto L_0x00c8
            java.lang.String r2 = "disableFinalStateStatusScreen"
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r2)     // Catch:{ Exception -> 0x00a9 }
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x00a9 }
            r3.<init>()     // Catch:{ Exception -> 0x00a9 }
            r3.element = r1     // Catch:{ Exception -> 0x00a9 }
            int r1 = r2.size()     // Catch:{ Exception -> 0x00a9 }
            int r1 = r1 + -1
            kotlin.ranges.h r1 = kotlin.ranges.RangesKt___RangesKt.o(r0, r1)     // Catch:{ Exception -> 0x00a9 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00a9 }
        L_0x0022:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x00a9 }
            r5 = 0
            if (r4 == 0) goto L_0x008e
            r4 = r1
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4     // Catch:{ Exception -> 0x00a9 }
            int r4 = r4.a()     // Catch:{ Exception -> 0x00a9 }
            T r6 = r3.element     // Catch:{ Exception -> 0x00a9 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r4 = r6.get(r4)     // Catch:{ Exception -> 0x00a9 }
            boolean r6 = r4 instanceof java.util.Map     // Catch:{ Exception -> 0x00a9 }
            if (r6 == 0) goto L_0x0043
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0044
        L_0x0043:
            r4 = r5
        L_0x0044:
            if (r4 == 0) goto L_0x00a2
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a9 }
            r6.<init>()     // Catch:{ Exception -> 0x00a9 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ Exception -> 0x00a9 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00a9 }
        L_0x0053:
            boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x00a9 }
            if (r7 == 0) goto L_0x0084
            java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x00a9 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r8 = r7.getKey()     // Catch:{ Exception -> 0x00a9 }
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x00a9 }
            if (r9 != 0) goto L_0x0068
            r8 = r5
        L_0x0068:
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00a9 }
            if (r8 != 0) goto L_0x006d
            goto L_0x0078
        L_0x006d:
            java.lang.Object r7 = r7.getValue()     // Catch:{ Exception -> 0x00a9 }
            boolean r9 = r7 instanceof java.lang.Object     // Catch:{ Exception -> 0x00a9 }
            if (r9 != 0) goto L_0x0076
            r7 = r5
        L_0x0076:
            if (r7 != 0) goto L_0x007a
        L_0x0078:
            r7 = r5
            goto L_0x007e
        L_0x007a:
            kotlin.Pair r7 = kotlin.l.a(r8, r7)     // Catch:{ Exception -> 0x00a9 }
        L_0x007e:
            if (r7 == 0) goto L_0x0053
            r6.add(r7)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0053
        L_0x0084:
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.s(r6)     // Catch:{ Exception -> 0x00a9 }
            if (r4 != 0) goto L_0x008b
            goto L_0x00a2
        L_0x008b:
            r3.element = r4     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0022
        L_0x008e:
            T r1 = r3.element     // Catch:{ Exception -> 0x00a9 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r2)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x00a9 }
            boolean r2 = r1 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x00a9 }
            if (r2 != 0) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r5 = r1
        L_0x00a0:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x00a9 }
        L_0x00a2:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00a9 }
            boolean r0 = kotlin.jvm.internal.x.b(r5, r1)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00c8
        L_0x00a9:
            r1 = move-exception
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r3 = com.sumsub.sns.internal.log.c.a(r10)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Can't parse disableFinalStateStatusScreen "
            r4.append(r5)
            java.util.Map r10 = r10.E()
            r4.append(r10)
            java.lang.String r10 = r4.toString()
            com.sumsub.sns.internal.log.b.b(r2, r3, r10, r1)
        L_0x00c8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.b(com.sumsub.sns.internal.core.data.model.e):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r1 = r1.l().f();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.util.List<com.sumsub.sns.internal.core.data.model.j>> a(com.sumsub.sns.internal.core.data.model.remote.a r23) {
        /*
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            com.sumsub.sns.internal.ff.a r1 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r2 = r1.l()
            boolean r2 = r2.g()
            r3 = 0
            if (r2 == 0) goto L_0x0022
            com.sumsub.sns.internal.ff.core.a r1 = r1.l()
            java.lang.String r1 = r1.f()
            if (r1 == 0) goto L_0x0022
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>(r1)
            goto L_0x0023
        L_0x0022:
            r2 = r3
        L_0x0023:
            java.util.Map r1 = r23.b()
            if (r1 == 0) goto L_0x00ee
            java.util.Set r1 = r1.entrySet()
            if (r1 == 0) goto L_0x00ee
            java.util.Iterator r1 = r1.iterator()
            if (r1 == 0) goto L_0x00ee
        L_0x0035:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00ee
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.Object r6 = r4.getKey()
            java.lang.String r6 = (java.lang.String) r6
            if (r2 == 0) goto L_0x0053
            org.json.JSONObject r7 = r2.optJSONObject(r6)
            goto L_0x0054
        L_0x0053:
            r7 = r3
        L_0x0054:
            java.lang.Object r4 = r4.getValue()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x005e:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x00e9
            java.lang.Object r8 = r4.next()
            com.sumsub.sns.internal.core.data.model.remote.h r8 = (com.sumsub.sns.internal.core.data.model.remote.h) r8
            if (r7 == 0) goto L_0x0075
            java.lang.String r9 = r8.k()
            org.json.JSONObject r9 = r7.optJSONObject(r9)
            goto L_0x0076
        L_0x0075:
            r9 = r3
        L_0x0076:
            if (r9 == 0) goto L_0x00cf
            java.util.List r10 = r8.i()
            if (r10 == 0) goto L_0x00cd
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = kotlin.collections.CollectionsKt__IterablesKt.u(r10, r12)
            r11.<init>(r12)
            java.util.Iterator r10 = r10.iterator()
        L_0x008d:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x00d3
            java.lang.Object r12 = r10.next()
            r13 = r12
            com.sumsub.sns.internal.core.data.model.h$d r13 = (com.sumsub.sns.internal.core.data.model.h.d) r13
            com.sumsub.sns.internal.core.data.model.FieldName r12 = r13.q()
            if (r12 == 0) goto L_0x00a5
            java.lang.String r12 = r12.getValue()
            goto L_0x00a6
        L_0x00a5:
            r12 = r3
        L_0x00a6:
            org.json.JSONArray r12 = r9.optJSONArray(r12)
            if (r12 == 0) goto L_0x00b3
            java.util.List r12 = com.sumsub.sns.internal.core.theme.c.b(r12)
            r18 = r12
            goto L_0x00b5
        L_0x00b3:
            r18 = r3
        L_0x00b5:
            if (r18 == 0) goto L_0x00c9
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 103(0x67, float:1.44E-43)
            r22 = 0
            com.sumsub.sns.internal.core.data.model.h$d r13 = com.sumsub.sns.internal.core.data.model.h.d.a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
        L_0x00c9:
            r11.add(r13)
            goto L_0x008d
        L_0x00cd:
            r11 = r3
            goto L_0x00d3
        L_0x00cf:
            java.util.List r11 = r8.i()
        L_0x00d3:
            com.sumsub.sns.internal.core.data.model.j r9 = new com.sumsub.sns.internal.core.data.model.j
            java.lang.String r10 = r8.k()
            java.lang.String r12 = r8.g()
            com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType r8 = r8.e()
            r9.<init>(r10, r12, r8, r11)
            r5.add(r9)
            goto L_0x005e
        L_0x00e9:
            r0.put(r6, r5)
            goto L_0x0035
        L_0x00ee:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.a(com.sumsub.sns.internal.core.data.model.remote.a):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0080 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0053 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean d(com.sumsub.sns.internal.core.data.model.e r10) {
        /*
            r0 = 0
            java.util.Map r1 = r10.E()     // Catch:{ Exception -> 0x00a9 }
            if (r1 == 0) goto L_0x00c8
            java.lang.String r2 = "disablePendingScreen"
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r2)     // Catch:{ Exception -> 0x00a9 }
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x00a9 }
            r3.<init>()     // Catch:{ Exception -> 0x00a9 }
            r3.element = r1     // Catch:{ Exception -> 0x00a9 }
            int r1 = r2.size()     // Catch:{ Exception -> 0x00a9 }
            int r1 = r1 + -1
            kotlin.ranges.h r1 = kotlin.ranges.RangesKt___RangesKt.o(r0, r1)     // Catch:{ Exception -> 0x00a9 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00a9 }
        L_0x0022:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x00a9 }
            r5 = 0
            if (r4 == 0) goto L_0x008e
            r4 = r1
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4     // Catch:{ Exception -> 0x00a9 }
            int r4 = r4.a()     // Catch:{ Exception -> 0x00a9 }
            T r6 = r3.element     // Catch:{ Exception -> 0x00a9 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r4 = r6.get(r4)     // Catch:{ Exception -> 0x00a9 }
            boolean r6 = r4 instanceof java.util.Map     // Catch:{ Exception -> 0x00a9 }
            if (r6 == 0) goto L_0x0043
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0044
        L_0x0043:
            r4 = r5
        L_0x0044:
            if (r4 == 0) goto L_0x00a2
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a9 }
            r6.<init>()     // Catch:{ Exception -> 0x00a9 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ Exception -> 0x00a9 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00a9 }
        L_0x0053:
            boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x00a9 }
            if (r7 == 0) goto L_0x0084
            java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x00a9 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r8 = r7.getKey()     // Catch:{ Exception -> 0x00a9 }
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x00a9 }
            if (r9 != 0) goto L_0x0068
            r8 = r5
        L_0x0068:
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00a9 }
            if (r8 != 0) goto L_0x006d
            goto L_0x0078
        L_0x006d:
            java.lang.Object r7 = r7.getValue()     // Catch:{ Exception -> 0x00a9 }
            boolean r9 = r7 instanceof java.lang.Object     // Catch:{ Exception -> 0x00a9 }
            if (r9 != 0) goto L_0x0076
            r7 = r5
        L_0x0076:
            if (r7 != 0) goto L_0x007a
        L_0x0078:
            r7 = r5
            goto L_0x007e
        L_0x007a:
            kotlin.Pair r7 = kotlin.l.a(r8, r7)     // Catch:{ Exception -> 0x00a9 }
        L_0x007e:
            if (r7 == 0) goto L_0x0053
            r6.add(r7)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0053
        L_0x0084:
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.s(r6)     // Catch:{ Exception -> 0x00a9 }
            if (r4 != 0) goto L_0x008b
            goto L_0x00a2
        L_0x008b:
            r3.element = r4     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0022
        L_0x008e:
            T r1 = r3.element     // Catch:{ Exception -> 0x00a9 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r2)     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x00a9 }
            boolean r2 = r1 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x00a9 }
            if (r2 != 0) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r5 = r1
        L_0x00a0:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x00a9 }
        L_0x00a2:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00a9 }
            boolean r0 = kotlin.jvm.internal.x.b(r5, r1)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00c8
        L_0x00a9:
            r1 = move-exception
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r3 = com.sumsub.sns.internal.log.c.a(r10)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Can't parse disablePendingScreen "
            r4.append(r5)
            java.util.Map r10 = r10.E()
            r4.append(r10)
            java.lang.String r10 = r4.toString()
            com.sumsub.sns.internal.log.b.b(r2, r3, r10, r1)
        L_0x00c8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.d(com.sumsub.sns.internal.core.data.model.e):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0073 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.lang.String> a(com.sumsub.sns.internal.core.data.model.e r6) {
        /*
            java.util.Map r6 = r6.C()
            r0 = 0
            if (r6 == 0) goto L_0x000e
            java.lang.String r1 = "countries"
            java.lang.Object r6 = r6.get(r1)
            goto L_0x000f
        L_0x000e:
            r6 = r0
        L_0x000f:
            boolean r1 = r6 instanceof java.util.Map
            if (r1 == 0) goto L_0x0016
            java.util.Map r6 = (java.util.Map) r6
            goto L_0x0017
        L_0x0016:
            r6 = r0
        L_0x0017:
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0055
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0028:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = r6.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x0046
            java.lang.Object r5 = r4.getValue()
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x0046
            r5 = r2
            goto L_0x0047
        L_0x0046:
            r5 = r1
        L_0x0047:
            if (r5 == 0) goto L_0x0028
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r3.put(r5, r4)
            goto L_0x0028
        L_0x0055:
            r3 = r0
        L_0x0056:
            if (r3 == 0) goto L_0x0060
            boolean r6 = r3.isEmpty()
            r6 = r6 ^ r2
            if (r6 != r2) goto L_0x0060
            r1 = r2
        L_0x0060:
            if (r1 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r3 = r0
        L_0x0064:
            if (r3 == 0) goto L_0x00aa
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Set r1 = r3.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0073:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00a6
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            boolean r4 = r3 instanceof java.lang.String
            if (r4 != 0) goto L_0x0088
            r3 = r0
        L_0x0088:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x008d
            goto L_0x009a
        L_0x008d:
            java.lang.Object r2 = r2.getValue()
            boolean r4 = r2 instanceof java.lang.String
            if (r4 != 0) goto L_0x0096
            r2 = r0
        L_0x0096:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x009c
        L_0x009a:
            r2 = r0
            goto L_0x00a0
        L_0x009c:
            kotlin.Pair r2 = kotlin.l.a(r3, r2)
        L_0x00a0:
            if (r2 == 0) goto L_0x0073
            r6.add(r2)
            goto L_0x0073
        L_0x00a6:
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r6)
        L_0x00aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.a(com.sumsub.sns.internal.core.data.model.e):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0091 A[Catch:{ Exception -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0064 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean a(com.sumsub.sns.internal.core.data.model.e r8, java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            java.util.Map r1 = r8.E()     // Catch:{ Exception -> 0x00ba }
            r2 = 0
            if (r1 == 0) goto L_0x00b3
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x00ba }
            java.lang.String r4 = "steps"
            r3[r0] = r4     // Catch:{ Exception -> 0x00ba }
            r4 = 1
            r3[r4] = r9     // Catch:{ Exception -> 0x00ba }
            r9 = 2
            if (r10 == 0) goto L_0x0018
            java.lang.String r10 = "backsideInstructionsScreen"
            goto L_0x001a
        L_0x0018:
            java.lang.String r10 = "introScreen"
        L_0x001a:
            r3[r9] = r10     // Catch:{ Exception -> 0x00ba }
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.n(r3)     // Catch:{ Exception -> 0x00ba }
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x00ba }
            r10.<init>()     // Catch:{ Exception -> 0x00ba }
            r10.element = r1     // Catch:{ Exception -> 0x00ba }
            int r1 = r9.size()     // Catch:{ Exception -> 0x00ba }
            int r1 = r1 - r4
            kotlin.ranges.h r1 = kotlin.ranges.RangesKt___RangesKt.o(r0, r1)     // Catch:{ Exception -> 0x00ba }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00ba }
        L_0x0034:
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x00ba }
            if (r3 == 0) goto L_0x009f
            r3 = r1
            kotlin.collections.IntIterator r3 = (kotlin.collections.IntIterator) r3     // Catch:{ Exception -> 0x00ba }
            int r3 = r3.a()     // Catch:{ Exception -> 0x00ba }
            T r4 = r10.element     // Catch:{ Exception -> 0x00ba }
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x00ba }
            java.lang.Object r3 = r9.get(r3)     // Catch:{ Exception -> 0x00ba }
            java.lang.Object r3 = r4.get(r3)     // Catch:{ Exception -> 0x00ba }
            boolean r4 = r3 instanceof java.util.Map     // Catch:{ Exception -> 0x00ba }
            if (r4 == 0) goto L_0x0054
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x00ba }
            goto L_0x0055
        L_0x0054:
            r3 = r2
        L_0x0055:
            if (r3 == 0) goto L_0x00b3
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x00ba }
            r4.<init>()     // Catch:{ Exception -> 0x00ba }
            java.util.Set r3 = r3.entrySet()     // Catch:{ Exception -> 0x00ba }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x00ba }
        L_0x0064:
            boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x00ba }
            if (r5 == 0) goto L_0x0095
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x00ba }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ Exception -> 0x00ba }
            java.lang.Object r6 = r5.getKey()     // Catch:{ Exception -> 0x00ba }
            boolean r7 = r6 instanceof java.lang.String     // Catch:{ Exception -> 0x00ba }
            if (r7 != 0) goto L_0x0079
            r6 = r2
        L_0x0079:
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00ba }
            if (r6 != 0) goto L_0x007e
            goto L_0x0089
        L_0x007e:
            java.lang.Object r5 = r5.getValue()     // Catch:{ Exception -> 0x00ba }
            boolean r7 = r5 instanceof java.lang.Object     // Catch:{ Exception -> 0x00ba }
            if (r7 != 0) goto L_0x0087
            r5 = r2
        L_0x0087:
            if (r5 != 0) goto L_0x008b
        L_0x0089:
            r5 = r2
            goto L_0x008f
        L_0x008b:
            kotlin.Pair r5 = kotlin.l.a(r6, r5)     // Catch:{ Exception -> 0x00ba }
        L_0x008f:
            if (r5 == 0) goto L_0x0064
            r4.add(r5)     // Catch:{ Exception -> 0x00ba }
            goto L_0x0064
        L_0x0095:
            java.util.Map r3 = kotlin.collections.MapsKt__MapsKt.s(r4)     // Catch:{ Exception -> 0x00ba }
            if (r3 != 0) goto L_0x009c
            goto L_0x00b3
        L_0x009c:
            r10.element = r3     // Catch:{ Exception -> 0x00ba }
            goto L_0x0034
        L_0x009f:
            T r10 = r10.element     // Catch:{ Exception -> 0x00ba }
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Exception -> 0x00ba }
            java.lang.Object r9 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r9)     // Catch:{ Exception -> 0x00ba }
            java.lang.Object r9 = r10.get(r9)     // Catch:{ Exception -> 0x00ba }
            boolean r10 = r9 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x00ba }
            if (r10 != 0) goto L_0x00b0
            goto L_0x00b1
        L_0x00b0:
            r2 = r9
        L_0x00b1:
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x00ba }
        L_0x00b3:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00ba }
            boolean r0 = kotlin.jvm.internal.x.b(r2, r9)     // Catch:{ Exception -> 0x00ba }
            goto L_0x00d9
        L_0x00ba:
            r9 = move-exception
            com.sumsub.sns.internal.log.a r10 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r1 = com.sumsub.sns.internal.log.c.a(r8)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Can't parse showIntroScreen "
            r2.append(r3)
            java.util.Map r8 = r8.E()
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            com.sumsub.sns.internal.log.b.b(r10, r1, r8, r9)
        L_0x00d9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.a(com.sumsub.sns.internal.core.data.model.e, java.lang.String, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x005f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean a(com.sumsub.sns.internal.core.data.model.e r9, java.lang.String r10) {
        /*
            r0 = 0
            java.util.Map r1 = r9.E()     // Catch:{ Exception -> 0x00b5 }
            r2 = 0
            if (r1 == 0) goto L_0x00ae
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r4 = "steps"
            r3[r0] = r4     // Catch:{ Exception -> 0x00b5 }
            r4 = 1
            r3[r4] = r10     // Catch:{ Exception -> 0x00b5 }
            r10 = 2
            java.lang.String r5 = "allowManualUpload"
            r3[r10] = r5     // Catch:{ Exception -> 0x00b5 }
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.n(r3)     // Catch:{ Exception -> 0x00b5 }
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x00b5 }
            r3.<init>()     // Catch:{ Exception -> 0x00b5 }
            r3.element = r1     // Catch:{ Exception -> 0x00b5 }
            int r1 = r10.size()     // Catch:{ Exception -> 0x00b5 }
            int r1 = r1 - r4
            kotlin.ranges.h r1 = kotlin.ranges.RangesKt___RangesKt.o(r0, r1)     // Catch:{ Exception -> 0x00b5 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00b5 }
        L_0x002f:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x00b5 }
            if (r4 == 0) goto L_0x009a
            r4 = r1
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4     // Catch:{ Exception -> 0x00b5 }
            int r4 = r4.a()     // Catch:{ Exception -> 0x00b5 }
            T r5 = r3.element     // Catch:{ Exception -> 0x00b5 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r4 = r10.get(r4)     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ Exception -> 0x00b5 }
            boolean r5 = r4 instanceof java.util.Map     // Catch:{ Exception -> 0x00b5 }
            if (r5 == 0) goto L_0x004f
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x00b5 }
            goto L_0x0050
        L_0x004f:
            r4 = r2
        L_0x0050:
            if (r4 == 0) goto L_0x00ae
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b5 }
            r5.<init>()     // Catch:{ Exception -> 0x00b5 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ Exception -> 0x00b5 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00b5 }
        L_0x005f:
            boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x00b5 }
            if (r6 == 0) goto L_0x0090
            java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x00b5 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ Exception -> 0x00b5 }
            boolean r8 = r7 instanceof java.lang.String     // Catch:{ Exception -> 0x00b5 }
            if (r8 != 0) goto L_0x0074
            r7 = r2
        L_0x0074:
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00b5 }
            if (r7 != 0) goto L_0x0079
            goto L_0x0084
        L_0x0079:
            java.lang.Object r6 = r6.getValue()     // Catch:{ Exception -> 0x00b5 }
            boolean r8 = r6 instanceof java.lang.Object     // Catch:{ Exception -> 0x00b5 }
            if (r8 != 0) goto L_0x0082
            r6 = r2
        L_0x0082:
            if (r6 != 0) goto L_0x0086
        L_0x0084:
            r6 = r2
            goto L_0x008a
        L_0x0086:
            kotlin.Pair r6 = kotlin.l.a(r7, r6)     // Catch:{ Exception -> 0x00b5 }
        L_0x008a:
            if (r6 == 0) goto L_0x005f
            r5.add(r6)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x005f
        L_0x0090:
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.s(r5)     // Catch:{ Exception -> 0x00b5 }
            if (r4 != 0) goto L_0x0097
            goto L_0x00ae
        L_0x0097:
            r3.element = r4     // Catch:{ Exception -> 0x00b5 }
            goto L_0x002f
        L_0x009a:
            T r1 = r3.element     // Catch:{ Exception -> 0x00b5 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r10)     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ Exception -> 0x00b5 }
            boolean r1 = r10 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x00b5 }
            if (r1 != 0) goto L_0x00ab
            goto L_0x00ac
        L_0x00ab:
            r2 = r10
        L_0x00ac:
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x00b5 }
        L_0x00ae:
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00b5 }
            boolean r0 = kotlin.jvm.internal.x.b(r2, r10)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00d4
        L_0x00b5:
            r10 = move-exception
            com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r2 = com.sumsub.sns.internal.log.c.a(r9)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Can't parse allowManualUpload "
            r3.append(r4)
            java.util.Map r9 = r9.E()
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            com.sumsub.sns.internal.log.b.b(r1, r2, r9, r10)
        L_0x00d4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.f.a(com.sumsub.sns.internal.core.data.model.e, java.lang.String):boolean");
    }
}
