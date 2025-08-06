package com.jumio.core.cdn;

import com.jumio.ale.swig.AESGCMInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import jumio.core.o;
import kotlin.jvm.internal.x;
import kotlin.text.b;

public final class CDNEncryptedEntry implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f39074a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39075b;

    /* renamed from: c  reason: collision with root package name */
    public final String f39076c;

    /* renamed from: d  reason: collision with root package name */
    public final String f39077d;

    /* renamed from: e  reason: collision with root package name */
    public final CDNCache f39078e;

    public CDNEncryptedEntry(String str, String str2, String str3, String str4, CDNCache cDNCache) {
        this.f39074a = str;
        this.f39075b = str2;
        this.f39076c = str3;
        this.f39077d = str4;
        this.f39078e = cDNCache;
    }

    public static /* synthetic */ CDNEncryptedEntry copy$default(CDNEncryptedEntry cDNEncryptedEntry, String str, String str2, String str3, String str4, CDNCache cDNCache, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cDNEncryptedEntry.f39074a;
        }
        if ((i11 & 2) != 0) {
            str2 = cDNEncryptedEntry.f39075b;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = cDNEncryptedEntry.f39076c;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            str4 = cDNEncryptedEntry.f39077d;
        }
        String str7 = str4;
        if ((i11 & 16) != 0) {
            cDNCache = cDNEncryptedEntry.f39078e;
        }
        return cDNEncryptedEntry.copy(str, str5, str6, str7, cDNCache);
    }

    public static /* synthetic */ ByteBuffer load$default(CDNEncryptedEntry cDNEncryptedEntry, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = 0;
        }
        return cDNEncryptedEntry.load(j11);
    }

    public final String component1() {
        return this.f39074a;
    }

    public final String component2() {
        return this.f39075b;
    }

    public final String component3() {
        return this.f39076c;
    }

    public final String component4() {
        return this.f39077d;
    }

    public final CDNEncryptedEntry copy(String str, String str2, String str3, String str4, CDNCache cDNCache) {
        return new CDNEncryptedEntry(str, str2, str3, str4, cDNCache);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CDNEncryptedEntry)) {
            return false;
        }
        CDNEncryptedEntry cDNEncryptedEntry = (CDNEncryptedEntry) obj;
        return x.b(this.f39074a, cDNEncryptedEntry.f39074a) && x.b(this.f39075b, cDNEncryptedEntry.f39075b) && x.b(this.f39076c, cDNEncryptedEntry.f39076c) && x.b(this.f39077d, cDNEncryptedEntry.f39077d) && x.b(this.f39078e, cDNEncryptedEntry.f39078e);
    }

    public final String getIv() {
        return this.f39076c;
    }

    public final String getKey() {
        return this.f39075b;
    }

    public final String getName() {
        return this.f39074a;
    }

    public final AESGCMInputStream getStream() {
        CDNCache cDNCache = this.f39078e;
        String str = this.f39077d;
        String str2 = this.f39074a;
        InputStream inputStream = cDNCache.get(str + "/" + str2);
        if (inputStream == null) {
            return null;
        }
        String str3 = this.f39075b;
        Charset charset = b.f56908b;
        return new AESGCMInputStream(inputStream, str3.getBytes(charset), this.f39076c.getBytes(charset));
    }

    public final String getType() {
        return this.f39077d;
    }

    public int hashCode() {
        return this.f39078e.hashCode() + o.a(this.f39077d, o.a(this.f39076c, o.a(this.f39075b, this.f39074a.hashCode() * 31, 31), 31), 31);
    }

    public final boolean isAssetFile() {
        CDNCache cDNCache = this.f39078e;
        String str = this.f39077d;
        String str2 = this.f39074a;
        return cDNCache.isAssetFile(str + "/" + str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        kotlin.io.b.a(r2, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0057, code lost:
        throw r14;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[SYNTHETIC, Splitter:B:23:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.nio.ByteBuffer load(long r13) {
        /*
            r12 = this;
            long r0 = android.os.SystemClock.uptimeMillis()
            com.jumio.ale.swig.AESGCMInputStream r2 = r12.getStream()     // Catch:{ Exception -> 0x007e }
            r3 = 0
            if (r2 == 0) goto L_0x0058
            r4 = 8192(0x2000, float:1.14794E-41)
            boolean r5 = r2 instanceof java.io.BufferedInputStream     // Catch:{ Exception -> 0x007e }
            if (r5 == 0) goto L_0x0014
            java.io.BufferedInputStream r2 = (java.io.BufferedInputStream) r2     // Catch:{ Exception -> 0x007e }
            goto L_0x001a
        L_0x0014:
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x007e }
            r5.<init>(r2, r4)     // Catch:{ Exception -> 0x007e }
            r2 = r5
        L_0x001a:
            com.jumio.core.extraction.util.ByteBufferOutputStream r4 = new com.jumio.core.extraction.util.ByteBufferOutputStream     // Catch:{ all -> 0x0051 }
            r4.<init>()     // Catch:{ all -> 0x0051 }
            r5 = 16384(0x4000, float:2.2959E-41)
            byte[] r6 = new byte[r5]     // Catch:{ all -> 0x0051 }
        L_0x0023:
            r7 = 0
            int r8 = r2.read(r6, r7, r5)     // Catch:{ all -> 0x0051 }
            r9 = -1
            if (r8 == r9) goto L_0x003e
            long r10 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0051 }
            long r10 = r10 - r0
            int r10 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r10 < 0) goto L_0x003a
            r10 = 0
            int r10 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x003e
        L_0x003a:
            r4.write(r6, r7, r8)     // Catch:{ all -> 0x0051 }
            goto L_0x0023
        L_0x003e:
            if (r8 != r9) goto L_0x0049
            java.nio.ByteBuffer r13 = r4.toDirectByteBuffer()     // Catch:{ all -> 0x0051 }
            kotlin.io.b.a(r2, r3)     // Catch:{ Exception -> 0x007e }
            r3 = r13
            goto L_0x0058
        L_0x0049:
            java.util.concurrent.TimeoutException r13 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0051 }
            java.lang.String r14 = "CipherInputStream buffered read timed out"
            r13.<init>(r14)     // Catch:{ all -> 0x0051 }
            throw r13     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r14 = move-exception
            kotlin.io.b.a(r2, r13)     // Catch:{ Exception -> 0x007e }
            throw r14     // Catch:{ Exception -> 0x007e }
        L_0x0058:
            if (r3 == 0) goto L_0x0076
            long r13 = android.os.SystemClock.uptimeMillis()
            long r13 = r13 - r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "loadEncFile duration: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            java.lang.String r14 = "CDNEncryptedEntry"
            com.jumio.commons.log.Log.v((java.lang.String) r14, (java.lang.String) r13)
            return r3
        L_0x0076:
            java.lang.Exception r13 = new java.lang.Exception     // Catch:{ Exception -> 0x007e }
            java.lang.String r14 = "CDNEncryptedEntry: stream should not be null!"
            r13.<init>(r14)     // Catch:{ Exception -> 0x007e }
            throw r13     // Catch:{ Exception -> 0x007e }
        L_0x007e:
            r13 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r13)
            com.jumio.core.cdn.CDNCache r13 = r12.f39078e
            java.lang.String r14 = r12.f39077d
            java.lang.String r0 = r12.f39074a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            java.lang.String r14 = "/"
            r1.append(r14)
            r1.append(r0)
            java.lang.String r14 = r1.toString()
            r13.remove(r14)
            java.lang.Exception r13 = new java.lang.Exception
            java.lang.String r14 = "Could not load file"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.cdn.CDNEncryptedEntry.load(long):java.nio.ByteBuffer");
    }

    public String toString() {
        String str = this.f39074a;
        String str2 = this.f39075b;
        String str3 = this.f39076c;
        String str4 = this.f39077d;
        CDNCache cDNCache = this.f39078e;
        return "CDNEncryptedEntry(name=" + str + ", key=" + str2 + ", iv=" + str3 + ", type=" + str4 + ", cache=" + cDNCache + ")";
    }
}
