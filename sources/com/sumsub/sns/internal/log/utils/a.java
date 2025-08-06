package com.sumsub.sns.internal.log.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import kotlin.jvm.internal.r;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final File f34909a;

    /* renamed from: b  reason: collision with root package name */
    public final Random f34910b;

    public a(File file, Random random) {
        this.f34909a = file;
        this.f34910b = random;
    }

    public final File a() {
        return this.f34909a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        kotlin.io.b.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] b() {
        /*
            r8 = this;
            java.io.File r0 = r8.f34909a
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.io.FileInputStream r0 = new java.io.FileInputStream
            java.io.File r2 = r8.f34909a
            r0.<init>(r2)
            int r2 = r8.a((java.io.InputStream) r0)     // Catch:{ all -> 0x0035 }
            byte[] r2 = r8.a((int) r2, (java.io.InputStream) r0)     // Catch:{ all -> 0x0035 }
            java.util.zip.CRC32 r3 = new java.util.zip.CRC32     // Catch:{ all -> 0x0035 }
            r3.<init>()     // Catch:{ all -> 0x0035 }
            r3.update(r2)     // Catch:{ all -> 0x0035 }
            long r4 = r8.b(r0)     // Catch:{ all -> 0x0035 }
            long r6 = r3.getValue()     // Catch:{ all -> 0x0035 }
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x0031
            kotlin.io.b.a(r0, r1)
            return r1
        L_0x0031:
            kotlin.io.b.a(r0, r1)
            return r2
        L_0x0035:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0037 }
        L_0x0037:
            r2 = move-exception
            kotlin.io.b.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.log.utils.a.b():byte[]");
    }

    public final long c(InputStream inputStream) throws IOException {
        long read = (long) inputStream.read();
        if (read >= 0) {
            long read2 = (long) inputStream.read();
            if (read2 >= 0) {
                long read3 = (long) inputStream.read();
                if (read3 >= 0) {
                    long read4 = (long) inputStream.read();
                    if (read4 >= 0) {
                        return read + (read2 << 8) + (read3 << 16) + (read4 << 24);
                    }
                    throw new IOException();
                }
                throw new IOException();
            }
            throw new IOException();
        }
        throw new IOException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0075, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0076, code lost:
        kotlin.io.b.a(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0079, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(byte[] r6) {
        /*
            r5 = this;
            java.io.File r0 = r5.f34909a
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x000d
            java.io.File r0 = r5.f34909a
            r0.delete()
        L_0x000d:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r2 = r5.f34909a
            java.io.File r2 = r2.getAbsoluteFile()
            r1.append(r2)
            java.lang.String r2 = "_random_"
            r1.append(r2)
            java.util.Random r2 = r5.f34910b
            long r2 = r2.nextLong()
            r1.append(r2)
            java.lang.String r2 = ".tmp"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.io.File r1 = r5.f34909a
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x0042
            r0.delete()
        L_0x0042:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream
            r1.<init>(r0)
            r2 = 0
            int r3 = r6.length     // Catch:{ all -> 0x0073 }
            r5.a((int) r3, (java.io.OutputStream) r1)     // Catch:{ all -> 0x0073 }
            r5.a((byte[]) r6, (java.io.OutputStream) r1)     // Catch:{ all -> 0x0073 }
            java.util.zip.CRC32 r3 = new java.util.zip.CRC32     // Catch:{ all -> 0x0073 }
            r3.<init>()     // Catch:{ all -> 0x0073 }
            r3.update(r6)     // Catch:{ all -> 0x0073 }
            long r3 = r3.getValue()     // Catch:{ all -> 0x0073 }
            r5.a((long) r3, (java.io.OutputStream) r1)     // Catch:{ all -> 0x0073 }
            r1.flush()     // Catch:{ all -> 0x0073 }
            java.io.FileDescriptor r6 = r1.getFD()     // Catch:{ all -> 0x0073 }
            r6.sync()     // Catch:{ all -> 0x0073 }
            kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0073 }
            kotlin.io.b.a(r1, r2)
            java.io.File r6 = r5.f34909a
            r0.renameTo(r6)
            return
        L_0x0073:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r0 = move-exception
            kotlin.io.b.a(r1, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.log.utils.a.a(byte[]):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(File file, Random random, int i11, r rVar) {
        this(file, (i11 & 2) != 0 ? new Random() : random);
    }

    public final long b(InputStream inputStream) throws IOException {
        return c(inputStream) + (c(inputStream) << 32);
    }

    public final void a(byte b11, OutputStream outputStream) throws IOException {
        outputStream.write(b11);
    }

    public final void a(int i11, OutputStream outputStream) throws IOException {
        a((byte) (i11 & 255), outputStream);
        a((byte) ((i11 >> 8) & 255), outputStream);
        a((byte) ((i11 >> 16) & 255), outputStream);
        a((byte) ((i11 >> 24) & 255), outputStream);
    }

    public final void a(long j11, OutputStream outputStream) throws IOException {
        a((byte) ((int) (j11 & 255)), outputStream);
        a((byte) ((int) ((j11 >> 8) & 255)), outputStream);
        a((byte) ((int) ((j11 >> 16) & 255)), outputStream);
        a((byte) ((int) ((j11 >> 24) & 255)), outputStream);
        a((byte) ((int) ((j11 >> 32) & 255)), outputStream);
        a((byte) ((int) ((j11 >> 40) & 255)), outputStream);
        a((byte) ((int) ((j11 >> 48) & 255)), outputStream);
        a((byte) ((int) ((j11 >> 56) & 255)), outputStream);
    }

    public final void a(byte[] bArr, OutputStream outputStream) throws IOException {
        outputStream.write(bArr);
    }

    public final int a(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read >= 0) {
            int read2 = inputStream.read();
            if (read2 >= 0) {
                int read3 = inputStream.read();
                if (read3 >= 0) {
                    int read4 = inputStream.read();
                    if (read4 >= 0) {
                        return read + (read2 << 8) + (read3 << 16) + (read4 << 24);
                    }
                    throw new IOException();
                }
                throw new IOException();
            }
            throw new IOException();
        }
        throw new IOException();
    }

    public final byte[] a(int i11, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[i11];
        int i12 = 0;
        while (i12 < i11) {
            int read = inputStream.read(bArr, i12, i11 - i12);
            if (read > 0) {
                i12 += read;
            } else if (read >= 0) {
                Thread.yield();
            } else {
                throw new IOException();
            }
        }
        return bArr;
    }
}
