package com.jumio.commons.utils;

import java.io.File;
import java.io.FilenameFilter;

public final class FileUtil {
    public static final FileUtil INSTANCE = new FileUtil();

    public static final class a implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public final String f38985a = "tmp_";

        public final boolean accept(File file, String str) {
            return StringsKt__StringsJVMKt.M(str, this.f38985a, false, 2, (Object) null);
        }
    }

    public final boolean deleteFile(String str) {
        return new File(str).delete();
    }

    public final boolean deleteFilesRecursive(String str) {
        return FilesKt__UtilsKt.f(new File(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        kotlin.io.b.a(r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
        kotlin.io.b.a(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0057, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] readFile(java.lang.String r7, com.jumio.core.models.AuthorizationModel.SessionKey r8) throws java.lang.Exception {
        /*
            r6 = this;
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "r"
            r0.<init>(r7, r1)
            long r1 = r0.length()     // Catch:{ all -> 0x0051 }
            int r7 = (int) r1     // Catch:{ all -> 0x0051 }
            long r3 = (long) r7     // Catch:{ all -> 0x0051 }
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0049
            javax.crypto.CipherInputStream r1 = new javax.crypto.CipherInputStream     // Catch:{ all -> 0x0051 }
            java.nio.channels.FileChannel r2 = r0.getChannel()     // Catch:{ all -> 0x0051 }
            java.io.InputStream r2 = java.nio.channels.Channels.newInputStream(r2)     // Catch:{ all -> 0x0051 }
            javax.crypto.Cipher r8 = r8.getDecryptCipher()     // Catch:{ all -> 0x0051 }
            r1.<init>(r2, r8)     // Catch:{ all -> 0x0051 }
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0042 }
            r8 = 2048(0x800, float:2.87E-42)
            byte[] r8 = new byte[r8]     // Catch:{ all -> 0x0042 }
            r2 = 0
            r3 = r2
        L_0x002a:
            int r4 = r1.read(r8)     // Catch:{ all -> 0x0042 }
            r5 = -1
            if (r4 == r5) goto L_0x0036
            java.lang.System.arraycopy(r8, r2, r7, r3, r4)     // Catch:{ all -> 0x0042 }
            int r3 = r3 + r4
            goto L_0x002a
        L_0x0036:
            byte[] r7 = com.jumio.core.util.ByteArrayUtilKt.trim(r7, r3)     // Catch:{ all -> 0x0042 }
            r8 = 0
            kotlin.io.b.a(r1, r8)     // Catch:{ all -> 0x0051 }
            kotlin.io.b.a(r0, r8)
            return r7
        L_0x0042:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r8 = move-exception
            kotlin.io.b.a(r1, r7)     // Catch:{ all -> 0x0051 }
            throw r8     // Catch:{ all -> 0x0051 }
        L_0x0049:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0051 }
            java.lang.String r8 = "File size >= 2 GB"
            r7.<init>(r8)     // Catch:{ all -> 0x0051 }
            throw r7     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r8 = move-exception
            kotlin.io.b.a(r0, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.FileUtil.readFile(java.lang.String, com.jumio.core.models.AuthorizationModel$SessionKey):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        kotlin.io.b.a(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean saveToFile(byte[] r3, java.io.File r4, com.jumio.core.models.AuthorizationModel.SessionKey r5) {
        /*
            r2 = this;
            javax.crypto.CipherOutputStream r0 = new javax.crypto.CipherOutputStream     // Catch:{ Exception -> 0x0020 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0020 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0020 }
            javax.crypto.Cipher r4 = r5.getEncryptCipher()     // Catch:{ Exception -> 0x0020 }
            r0.<init>(r1, r4)     // Catch:{ Exception -> 0x0020 }
            r4 = 0
            r0.write(r3)     // Catch:{ all -> 0x0019 }
            kotlin.Unit r3 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0019 }
            kotlin.io.b.a(r0, r4)     // Catch:{ Exception -> 0x0020 }
            r3 = 1
            goto L_0x0021
        L_0x0019:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001b }
        L_0x001b:
            r4 = move-exception
            kotlin.io.b.a(r0, r3)     // Catch:{ Exception -> 0x0020 }
            throw r4     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            r3 = 0
        L_0x0021:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.FileUtil.saveToFile(byte[], java.io.File, com.jumio.core.models.AuthorizationModel$SessionKey):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        kotlin.io.b.a(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean saveToFile(java.io.InputStream r4, java.io.File r5, com.jumio.core.models.AuthorizationModel.SessionKey r6) {
        /*
            r3 = this;
            r0 = 0
            javax.crypto.CipherOutputStream r1 = new javax.crypto.CipherOutputStream     // Catch:{ Exception -> 0x0020 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0020 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0020 }
            javax.crypto.Cipher r5 = r6.getEncryptCipher()     // Catch:{ Exception -> 0x0020 }
            r1.<init>(r2, r5)     // Catch:{ Exception -> 0x0020 }
            r5 = 2
            r6 = 0
            kotlin.io.a.b(r4, r1, r0, r5, r6)     // Catch:{ all -> 0x0019 }
            kotlin.io.b.a(r1, r6)     // Catch:{ Exception -> 0x0020 }
            r0 = 1
            goto L_0x0020
        L_0x0019:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x001b }
        L_0x001b:
            r5 = move-exception
            kotlin.io.b.a(r1, r4)     // Catch:{ Exception -> 0x0020 }
            throw r5     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.FileUtil.saveToFile(java.io.InputStream, java.io.File, com.jumio.core.models.AuthorizationModel$SessionKey):boolean");
    }
}
