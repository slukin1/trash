package com.sumsub.sentry.android;

import android.content.Context;
import java.io.File;
import java.nio.charset.Charset;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f30275a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static String f30276b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f30277c = "SNS_INSTALLATION";

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f30278d = Charset.forName("UTF-8");

    public final String a() {
        return f30276b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        kotlin.io.b.a(r0, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(java.io.File r3) throws java.io.IOException {
        /*
            r2 = this;
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r3)
            java.util.UUID r3 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x001e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x001e }
            java.nio.charset.Charset r1 = f30278d     // Catch:{ all -> 0x001e }
            byte[] r1 = r3.getBytes(r1)     // Catch:{ all -> 0x001e }
            r0.write(r1)     // Catch:{ all -> 0x001e }
            r0.flush()     // Catch:{ all -> 0x001e }
            r1 = 0
            kotlin.io.b.a(r0, r1)
            return r3
        L_0x001e:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r1 = move-exception
            kotlin.io.b.a(r0, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.android.e.b(java.io.File):java.lang.String");
    }

    public final void a(String str) {
        f30276b = str;
    }

    public final synchronized String a(Context context) throws RuntimeException {
        if (f30276b == null) {
            File file = new File(context.getFilesDir(), f30277c);
            try {
                if (!file.exists()) {
                    String b11 = b(file);
                    f30276b = b11;
                    return b11;
                }
                f30276b = a(file);
            } catch (Throwable th2) {
                throw new RuntimeException(th2);
            }
        }
        return f30276b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        kotlin.io.b.a(r0, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.io.File r4) throws java.io.IOException {
        /*
            r3 = this;
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "r"
            r0.<init>(r4, r1)
            long r1 = r0.length()     // Catch:{ all -> 0x001d }
            int r4 = (int) r1     // Catch:{ all -> 0x001d }
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x001d }
            r0.readFully(r4)     // Catch:{ all -> 0x001d }
            java.nio.charset.Charset r1 = f30278d     // Catch:{ all -> 0x001d }
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x001d }
            r2.<init>(r4, r1)     // Catch:{ all -> 0x001d }
            r4 = 0
            kotlin.io.b.a(r0, r4)
            return r2
        L_0x001d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x001f }
        L_0x001f:
            r1 = move-exception
            kotlin.io.b.a(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.android.e.a(java.io.File):java.lang.String");
    }
}
