package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final char f58943a = File.separatorChar;

    /* renamed from: b  reason: collision with root package name */
    public static final String f58944b;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0033, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0036, code lost:
        throw r2;
     */
    static {
        /*
            char r0 = java.io.File.separatorChar
            f58943a = r0
            org.apache.commons.io.output.StringBuilderWriter r0 = new org.apache.commons.io.output.StringBuilderWriter
            r1 = 4
            r0.<init>((int) r1)
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ all -> 0x002b }
            r1.<init>(r0)     // Catch:{ all -> 0x002b }
            r1.println()     // Catch:{ all -> 0x001f }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x001f }
            f58944b = r2     // Catch:{ all -> 0x001f }
            r1.close()     // Catch:{ all -> 0x002b }
            r0.close()
            return
        L_0x001f:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r3 = move-exception
            r1.close()     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch:{ all -> 0x002b }
        L_0x002a:
            throw r3     // Catch:{ all -> 0x002b }
        L_0x002b:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002d }
        L_0x002d:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0032 }
            goto L_0x0036
        L_0x0032:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0036:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.IOUtils.<clinit>():void");
    }

    public static int a(InputStream inputStream, OutputStream outputStream) throws IOException {
        long c11 = c(inputStream, outputStream);
        if (c11 > 2147483647L) {
            return -1;
        }
        return (int) c11;
    }

    public static long b(InputStream inputStream, OutputStream outputStream, int i11) throws IOException {
        return d(inputStream, outputStream, new byte[i11]);
    }

    public static long c(InputStream inputStream, OutputStream outputStream) throws IOException {
        return b(inputStream, outputStream, 4096);
    }

    public static long d(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j11 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j11;
            }
            outputStream.write(bArr, 0, read);
            j11 += (long) read;
        }
    }

    public static void e(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }
}
