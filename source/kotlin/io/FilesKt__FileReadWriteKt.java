package kotlin.io;

class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        kotlin.io.b.a(r0, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009e, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.io.File r9) {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r9)
            long r1 = r9.length()     // Catch:{ all -> 0x0098 }
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            java.lang.String r4 = "File "
            if (r3 > 0) goto L_0x0076
            int r1 = (int) r1
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x0098 }
            r3 = 0
            r5 = r1
            r6 = r3
        L_0x0018:
            if (r5 <= 0) goto L_0x0023
            int r7 = r0.read(r2, r6, r5)     // Catch:{ all -> 0x0098 }
            if (r7 < 0) goto L_0x0023
            int r5 = r5 - r7
            int r6 = r6 + r7
            goto L_0x0018
        L_0x0023:
            r7 = 0
            if (r5 <= 0) goto L_0x002b
            byte[] r2 = java.util.Arrays.copyOf(r2, r6)     // Catch:{ all -> 0x0098 }
            goto L_0x0058
        L_0x002b:
            int r5 = r0.read()     // Catch:{ all -> 0x0098 }
            r6 = -1
            if (r5 != r6) goto L_0x0033
            goto L_0x0058
        L_0x0033:
            kotlin.io.d r6 = new kotlin.io.d     // Catch:{ all -> 0x0098 }
            r8 = 8193(0x2001, float:1.1481E-41)
            r6.<init>(r8)     // Catch:{ all -> 0x0098 }
            r6.write(r5)     // Catch:{ all -> 0x0098 }
            r5 = 2
            kotlin.io.a.b(r0, r6, r3, r5, r7)     // Catch:{ all -> 0x0098 }
            int r5 = r6.size()     // Catch:{ all -> 0x0098 }
            int r5 = r5 + r1
            if (r5 < 0) goto L_0x005c
            byte[] r9 = r6.a()     // Catch:{ all -> 0x0098 }
            byte[] r2 = java.util.Arrays.copyOf(r2, r5)     // Catch:{ all -> 0x0098 }
            int r4 = r6.size()     // Catch:{ all -> 0x0098 }
            byte[] r2 = kotlin.collections.ArraysKt___ArraysJvmKt.e(r9, r2, r1, r3, r4)     // Catch:{ all -> 0x0098 }
        L_0x0058:
            kotlin.io.b.a(r0, r7)
            return r2
        L_0x005c:
            java.lang.OutOfMemoryError r1 = new java.lang.OutOfMemoryError     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r2.<init>()     // Catch:{ all -> 0x0098 }
            r2.append(r4)     // Catch:{ all -> 0x0098 }
            r2.append(r9)     // Catch:{ all -> 0x0098 }
            java.lang.String r9 = " is too big to fit in memory."
            r2.append(r9)     // Catch:{ all -> 0x0098 }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x0098 }
            r1.<init>(r9)     // Catch:{ all -> 0x0098 }
            throw r1     // Catch:{ all -> 0x0098 }
        L_0x0076:
            java.lang.OutOfMemoryError r3 = new java.lang.OutOfMemoryError     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r5.<init>()     // Catch:{ all -> 0x0098 }
            r5.append(r4)     // Catch:{ all -> 0x0098 }
            r5.append(r9)     // Catch:{ all -> 0x0098 }
            java.lang.String r9 = " is too big ("
            r5.append(r9)     // Catch:{ all -> 0x0098 }
            r5.append(r1)     // Catch:{ all -> 0x0098 }
            java.lang.String r9 = " bytes) to fit in memory."
            r5.append(r9)     // Catch:{ all -> 0x0098 }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x0098 }
            r3.<init>(r9)     // Catch:{ all -> 0x0098 }
            throw r3     // Catch:{ all -> 0x0098 }
        L_0x0098:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x009a }
        L_0x009a:
            r1 = move-exception
            kotlin.io.b.a(r0, r9)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.a(java.io.File):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        kotlin.io.b.a(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.io.File r2, java.nio.charset.Charset r3) {
        /*
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r2)
            r0.<init>(r1, r3)
            java.lang.String r2 = kotlin.io.g.c(r0)     // Catch:{ all -> 0x0013 }
            r3 = 0
            kotlin.io.b.a(r0, r3)
            return r2
        L_0x0013:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0015 }
        L_0x0015:
            r3 = move-exception
            kotlin.io.b.a(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.b(java.io.File, java.nio.charset.Charset):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        kotlin.io.b.a(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(java.io.File r1, byte[] r2) {
        /*
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r1)
            r0.write(r2)     // Catch:{ all -> 0x000f }
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x000f }
            r1 = 0
            kotlin.io.b.a(r0, r1)
            return
        L_0x000f:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0011 }
        L_0x0011:
            r2 = move-exception
            kotlin.io.b.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.c(java.io.File, byte[]):void");
    }
}
