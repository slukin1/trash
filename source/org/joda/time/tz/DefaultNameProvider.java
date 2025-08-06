package org.joda.time.tz;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DefaultNameProvider implements a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<Locale, Map<String, Map<String, Object>>> f25405a = c();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<Locale, Map<String, Map<Boolean, Object>>> f25406b = c();

    public String a(Locale locale, String str, String str2) {
        String[] e11 = e(locale, str, str2);
        if (e11 == null) {
            return null;
        }
        return e11[0];
    }

    public String b(Locale locale, String str, String str2) {
        String[] e11 = e(locale, str, str2);
        if (e11 == null) {
            return null;
        }
        return e11[1];
    }

    public final HashMap c() {
        return new HashMap(7);
    }

    public String d(Locale locale, String str, String str2, boolean z11) {
        String[] f11 = f(locale, str, str2, z11);
        if (f11 == null) {
            return null;
        }
        return f11[1];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ce, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String[] e(java.util.Locale r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            if (r10 == 0) goto L_0x00cd
            if (r11 == 0) goto L_0x00cd
            if (r12 != 0) goto L_0x000a
            goto L_0x00cd
        L_0x000a:
            java.util.HashMap<java.util.Locale, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>>> r1 = r9.f25405a     // Catch:{ all -> 0x00ca }
            java.lang.Object r1 = r1.get(r10)     // Catch:{ all -> 0x00ca }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x00ca }
            if (r1 != 0) goto L_0x001e
            java.util.HashMap<java.util.Locale, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>>> r1 = r9.f25405a     // Catch:{ all -> 0x00ca }
            java.util.HashMap r2 = r9.c()     // Catch:{ all -> 0x00ca }
            r1.put(r10, r2)     // Catch:{ all -> 0x00ca }
            r1 = r2
        L_0x001e:
            java.lang.Object r2 = r1.get(r11)     // Catch:{ all -> 0x00ca }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x00ca }
            if (r2 != 0) goto L_0x00c2
            java.util.HashMap r2 = r9.c()     // Catch:{ all -> 0x00ca }
            r1.put(r11, r2)     // Catch:{ all -> 0x00ca }
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00ca }
            java.text.DateFormatSymbols r1 = org.joda.time.a.d(r1)     // Catch:{ all -> 0x00ca }
            java.lang.String[][] r1 = r1.getZoneStrings()     // Catch:{ all -> 0x00ca }
            int r3 = r1.length     // Catch:{ all -> 0x00ca }
            r4 = 0
            r5 = r4
        L_0x003a:
            r6 = 5
            if (r5 >= r3) goto L_0x0050
            r7 = r1[r5]     // Catch:{ all -> 0x00ca }
            if (r7 == 0) goto L_0x004d
            int r8 = r7.length     // Catch:{ all -> 0x00ca }
            if (r8 != r6) goto L_0x004d
            r8 = r7[r4]     // Catch:{ all -> 0x00ca }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x00ca }
            if (r8 == 0) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            int r5 = r5 + 1
            goto L_0x003a
        L_0x0050:
            r7 = r0
        L_0x0051:
            java.text.DateFormatSymbols r10 = org.joda.time.a.d(r10)     // Catch:{ all -> 0x00ca }
            java.lang.String[][] r10 = r10.getZoneStrings()     // Catch:{ all -> 0x00ca }
            int r1 = r10.length     // Catch:{ all -> 0x00ca }
            r3 = r4
        L_0x005b:
            if (r3 >= r1) goto L_0x0071
            r5 = r10[r3]     // Catch:{ all -> 0x00ca }
            if (r5 == 0) goto L_0x006e
            int r8 = r5.length     // Catch:{ all -> 0x00ca }
            if (r8 != r6) goto L_0x006e
            r8 = r5[r4]     // Catch:{ all -> 0x00ca }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x00ca }
            if (r8 == 0) goto L_0x006e
            r0 = r5
            goto L_0x0071
        L_0x006e:
            int r3 = r3 + 1
            goto L_0x005b
        L_0x0071:
            if (r7 == 0) goto L_0x00c2
            if (r0 == 0) goto L_0x00c2
            r10 = 2
            r11 = r7[r10]     // Catch:{ all -> 0x00ca }
            java.lang.String[] r1 = new java.lang.String[r10]     // Catch:{ all -> 0x00ca }
            r3 = r0[r10]     // Catch:{ all -> 0x00ca }
            r1[r4] = r3     // Catch:{ all -> 0x00ca }
            r3 = 1
            r5 = r0[r3]     // Catch:{ all -> 0x00ca }
            r1[r3] = r5     // Catch:{ all -> 0x00ca }
            r2.put(r11, r1)     // Catch:{ all -> 0x00ca }
            r11 = r7[r10]     // Catch:{ all -> 0x00ca }
            r1 = 4
            r5 = r7[r1]     // Catch:{ all -> 0x00ca }
            boolean r11 = r11.equals(r5)     // Catch:{ all -> 0x00ca }
            r5 = 3
            if (r11 == 0) goto L_0x00b3
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            r11.<init>()     // Catch:{ all -> 0x00ca }
            r6 = r7[r1]     // Catch:{ all -> 0x00ca }
            r11.append(r6)     // Catch:{ all -> 0x00ca }
            java.lang.String r6 = "-Summer"
            r11.append(r6)     // Catch:{ all -> 0x00ca }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00ca }
            java.lang.String[] r10 = new java.lang.String[r10]     // Catch:{ all -> 0x00ca }
            r1 = r0[r1]     // Catch:{ all -> 0x00ca }
            r10[r4] = r1     // Catch:{ all -> 0x00ca }
            r0 = r0[r5]     // Catch:{ all -> 0x00ca }
            r10[r3] = r0     // Catch:{ all -> 0x00ca }
            r2.put(r11, r10)     // Catch:{ all -> 0x00ca }
            goto L_0x00c2
        L_0x00b3:
            r11 = r7[r1]     // Catch:{ all -> 0x00ca }
            java.lang.String[] r10 = new java.lang.String[r10]     // Catch:{ all -> 0x00ca }
            r1 = r0[r1]     // Catch:{ all -> 0x00ca }
            r10[r4] = r1     // Catch:{ all -> 0x00ca }
            r0 = r0[r5]     // Catch:{ all -> 0x00ca }
            r10[r3] = r0     // Catch:{ all -> 0x00ca }
            r2.put(r11, r10)     // Catch:{ all -> 0x00ca }
        L_0x00c2:
            java.lang.Object r10 = r2.get(r12)     // Catch:{ all -> 0x00ca }
            java.lang.String[] r10 = (java.lang.String[]) r10     // Catch:{ all -> 0x00ca }
            monitor-exit(r9)
            return r10
        L_0x00ca:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        L_0x00cd:
            monitor-exit(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DefaultNameProvider.e(java.util.Locale, java.lang.String, java.lang.String):java.lang.String[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a7, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String[] f(java.util.Locale r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            if (r9 == 0) goto L_0x00a6
            if (r10 == 0) goto L_0x00a6
            if (r11 != 0) goto L_0x000a
            goto L_0x00a6
        L_0x000a:
            java.util.HashMap<java.util.Locale, java.util.Map<java.lang.String, java.util.Map<java.lang.Boolean, java.lang.Object>>> r11 = r8.f25406b     // Catch:{ all -> 0x00a3 }
            java.lang.Object r11 = r11.get(r9)     // Catch:{ all -> 0x00a3 }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ all -> 0x00a3 }
            if (r11 != 0) goto L_0x001e
            java.util.HashMap<java.util.Locale, java.util.Map<java.lang.String, java.util.Map<java.lang.Boolean, java.lang.Object>>> r11 = r8.f25406b     // Catch:{ all -> 0x00a3 }
            java.util.HashMap r1 = r8.c()     // Catch:{ all -> 0x00a3 }
            r11.put(r9, r1)     // Catch:{ all -> 0x00a3 }
            r11 = r1
        L_0x001e:
            java.lang.Object r1 = r11.get(r10)     // Catch:{ all -> 0x00a3 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x00a3 }
            if (r1 != 0) goto L_0x0097
            java.util.HashMap r1 = r8.c()     // Catch:{ all -> 0x00a3 }
            r11.put(r10, r1)     // Catch:{ all -> 0x00a3 }
            java.util.Locale r11 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00a3 }
            java.text.DateFormatSymbols r11 = org.joda.time.a.d(r11)     // Catch:{ all -> 0x00a3 }
            java.lang.String[][] r11 = r11.getZoneStrings()     // Catch:{ all -> 0x00a3 }
            int r2 = r11.length     // Catch:{ all -> 0x00a3 }
            r3 = 0
            r4 = r3
        L_0x003a:
            r5 = 5
            if (r4 >= r2) goto L_0x0050
            r6 = r11[r4]     // Catch:{ all -> 0x00a3 }
            if (r6 == 0) goto L_0x004d
            int r7 = r6.length     // Catch:{ all -> 0x00a3 }
            if (r7 != r5) goto L_0x004d
            r7 = r6[r3]     // Catch:{ all -> 0x00a3 }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x00a3 }
            if (r7 == 0) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            int r4 = r4 + 1
            goto L_0x003a
        L_0x0050:
            r6 = r0
        L_0x0051:
            java.text.DateFormatSymbols r9 = org.joda.time.a.d(r9)     // Catch:{ all -> 0x00a3 }
            java.lang.String[][] r9 = r9.getZoneStrings()     // Catch:{ all -> 0x00a3 }
            int r11 = r9.length     // Catch:{ all -> 0x00a3 }
            r2 = r3
        L_0x005b:
            if (r2 >= r11) goto L_0x0071
            r4 = r9[r2]     // Catch:{ all -> 0x00a3 }
            if (r4 == 0) goto L_0x006e
            int r7 = r4.length     // Catch:{ all -> 0x00a3 }
            if (r7 != r5) goto L_0x006e
            r7 = r4[r3]     // Catch:{ all -> 0x00a3 }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x00a3 }
            if (r7 == 0) goto L_0x006e
            r0 = r4
            goto L_0x0071
        L_0x006e:
            int r2 = r2 + 1
            goto L_0x005b
        L_0x0071:
            if (r6 == 0) goto L_0x0097
            if (r0 == 0) goto L_0x0097
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00a3 }
            r10 = 2
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ all -> 0x00a3 }
            r2 = r0[r10]     // Catch:{ all -> 0x00a3 }
            r11[r3] = r2     // Catch:{ all -> 0x00a3 }
            r2 = 1
            r4 = r0[r2]     // Catch:{ all -> 0x00a3 }
            r11[r2] = r4     // Catch:{ all -> 0x00a3 }
            r1.put(r9, r11)     // Catch:{ all -> 0x00a3 }
            java.lang.Boolean r9 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a3 }
            java.lang.String[] r10 = new java.lang.String[r10]     // Catch:{ all -> 0x00a3 }
            r11 = 4
            r11 = r0[r11]     // Catch:{ all -> 0x00a3 }
            r10[r3] = r11     // Catch:{ all -> 0x00a3 }
            r11 = 3
            r11 = r0[r11]     // Catch:{ all -> 0x00a3 }
            r10[r2] = r11     // Catch:{ all -> 0x00a3 }
            r1.put(r9, r10)     // Catch:{ all -> 0x00a3 }
        L_0x0097:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x00a3 }
            java.lang.Object r9 = r1.get(r9)     // Catch:{ all -> 0x00a3 }
            java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ all -> 0x00a3 }
            monitor-exit(r8)
            return r9
        L_0x00a3:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        L_0x00a6:
            monitor-exit(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DefaultNameProvider.f(java.util.Locale, java.lang.String, java.lang.String, boolean):java.lang.String[]");
    }

    public String g(Locale locale, String str, String str2, boolean z11) {
        String[] f11 = f(locale, str, str2, z11);
        if (f11 == null) {
            return null;
        }
        return f11[0];
    }
}
