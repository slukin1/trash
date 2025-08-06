package com.iproov.sdk.p035try;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.iproov.sdk.try.case  reason: invalid class name and invalid package */
public final class Ccase {
    /* renamed from: do  reason: not valid java name */
    public static /* synthetic */ String[] m2125do(String str, String[] strArr, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            strArr = null;
        }
        return m2124do(str, strArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        kotlin.io.b.a(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        throw r2;
     */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String[] m2124do(java.lang.String r8, java.lang.String[] r9) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException | NoSuchElementException -> 0x0058 }
            java.lang.Process r8 = r1.exec(r8, r9)     // Catch:{ IOException | NoSuchElementException -> 0x0058 }
            java.io.InputStream r9 = r8.getInputStream()     // Catch:{ all -> 0x0053 }
            java.util.Scanner r1 = new java.util.Scanner     // Catch:{ all -> 0x0053 }
            r1.<init>(r9)     // Catch:{ all -> 0x0053 }
            java.lang.String r9 = "\\A"
            java.util.Scanner r9 = r1.useDelimiter(r9)     // Catch:{ all -> 0x004c }
            java.lang.String r2 = r9.next()     // Catch:{ all -> 0x004c }
            java.lang.String r9 = "\n"
            java.lang.String[] r3 = new java.lang.String[]{r9}     // Catch:{ all -> 0x004c }
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            java.util.List r9 = kotlin.text.StringsKt__StringsKt.L0(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004c }
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ all -> 0x004c }
            java.lang.Object[] r9 = r9.toArray(r3)     // Catch:{ all -> 0x004c }
            if (r9 == 0) goto L_0x0044
            java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ all -> 0x004c }
            kotlin.io.b.a(r1, r0)     // Catch:{ all -> 0x0053 }
            int r1 = r9.length     // Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x003c
            r2 = 1
        L_0x003c:
            if (r2 == 0) goto L_0x003f
            r9 = r0
        L_0x003f:
            r8.destroy()     // Catch:{ IOException | NoSuchElementException -> 0x0058 }
            r0 = r9
            goto L_0x0058
        L_0x0044:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException     // Catch:{ all -> 0x004c }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T>"
            r9.<init>(r2)     // Catch:{ all -> 0x004c }
            throw r9     // Catch:{ all -> 0x004c }
        L_0x004c:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x004e }
        L_0x004e:
            r2 = move-exception
            kotlin.io.b.a(r1, r9)     // Catch:{ all -> 0x0053 }
            throw r2     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r9 = move-exception
            r8.destroy()     // Catch:{ IOException | NoSuchElementException -> 0x0058 }
            throw r9     // Catch:{ IOException | NoSuchElementException -> 0x0058 }
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p035try.Ccase.m2124do(java.lang.String, java.lang.String[]):java.lang.String[]");
    }

    /* renamed from: do  reason: not valid java name */
    public static final boolean m2122do(String str, String str2) {
        return new File(str, str2).exists();
    }

    /* renamed from: do  reason: not valid java name */
    public static final boolean m2123do(List<Boolean> list) {
        T t11;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (((Boolean) t11).booleanValue()) {
                break;
            }
        }
        Boolean bool = (Boolean) t11;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
