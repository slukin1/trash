package jumio.core;

import com.huobi.finance.bean.FinanceRecordItem;
import com.jumio.ale.swig.ALECore;
import com.jumio.ale.swig.ALEHeader;
import com.jumio.ale.swig.ALEInputStream;
import com.jumio.ale.swig.ALEOutputStream;
import com.jumio.ale.swig.ALERequest;
import com.jumio.commons.log.Log;
import com.sumsub.sns.internal.core.analytics.d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class c implements d1 {

    /* renamed from: a  reason: collision with root package name */
    public final ALECore f56140a;

    /* renamed from: b  reason: collision with root package name */
    public final String f56141b;

    /* renamed from: c  reason: collision with root package name */
    public ALERequest f56142c;

    public c(ALECore aLECore, String str) {
        this.f56140a = aLECore;
        this.f56141b = str;
    }

    public final ALEOutputStream a(OutputStream outputStream, int i11, String str) throws Exception {
        try {
            this.f56142c = this.f56140a.createRequest();
            Log.d("Network/ALE", "encrypting plaintext");
            ALEHeader aLEHeader = new ALEHeader();
            aLEHeader.add("Content-Type", str);
            aLEHeader.add("Authorization", this.f56141b);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            ALERequest aLERequest = this.f56142c;
            if (aLERequest == null) {
                aLERequest = null;
            }
            return new ALEOutputStream(bufferedOutputStream, aLERequest, aLEHeader, i11);
        } catch (Exception e11) {
            throw new Exception(e11.getMessage());
        }
    }

    public final String a(InputStream inputStream) throws d, t2 {
        String str;
        Log.d("Network/ALE", "decrypting response stream");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ALERequest aLERequest = this.f56142c;
        ALERequest aLERequest2 = null;
        if (aLERequest == null) {
            aLERequest = null;
        }
        ALEInputStream aLEInputStream = new ALEInputStream(bufferedInputStream, aLERequest);
        ALERequest aLERequest3 = this.f56142c;
        if (aLERequest3 == null) {
            aLERequest3 = null;
        }
        Log.v("Network/ALE", "Response: " + (aLERequest3.isVerified() ? FinanceRecordItem.STATE_VALID : "invalid"));
        ALERequest aLERequest4 = this.f56142c;
        if (aLERequest4 == null) {
            aLERequest4 = null;
        }
        Log.v("Network/ALE", "Error code: " + aLERequest4.getErrorCode());
        ALERequest aLERequest5 = this.f56142c;
        if (aLERequest5 == null) {
            aLERequest5 = null;
        }
        Log.v("Network/ALE", "Key update: " + (aLERequest5.isKeyUpdate() ? "true" : d.f31895b));
        try {
            str = a(aLEInputStream);
        } catch (IOException unused) {
            str = "";
        }
        try {
            ALERequest aLERequest6 = this.f56142c;
            if (aLERequest6 == null) {
                aLERequest6 = null;
            }
            if (!aLERequest6.isVerified()) {
                ALERequest aLERequest7 = this.f56142c;
                if (aLERequest7 == null) {
                    aLERequest7 = null;
                }
                if (aLERequest7.getErrorCode() != 0) {
                    ALERequest aLERequest8 = this.f56142c;
                    if (aLERequest8 == null) {
                        aLERequest8 = null;
                    }
                    int errorCode = aLERequest8.getErrorCode();
                    ALERequest aLERequest9 = this.f56142c;
                    if (aLERequest9 != null) {
                        aLERequest2 = aLERequest9;
                    }
                    throw new t2(errorCode, "Response returned " + aLERequest2.getErrorCode());
                }
                throw new t2(0, "Response not verified");
            }
            ALERequest aLERequest10 = this.f56142c;
            if (aLERequest10 != null) {
                aLERequest2 = aLERequest10;
            }
            if (!aLERequest2.isKeyUpdate()) {
                return str;
            }
            throw new d();
        } finally {
            a();
        }
    }

    public final void a() {
        ALECore aLECore = this.f56140a;
        ALERequest aLERequest = this.f56142c;
        if (aLERequest == null) {
            aLERequest = null;
        }
        aLECore.destroyRequest(aLERequest);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        kotlin.io.b.a(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(com.jumio.ale.swig.ALEInputStream r5) throws java.io.IOException {
        /*
            java.io.StringWriter r0 = new java.io.StringWriter
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            char[] r1 = new char[r1]
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x002c }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x002c }
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x002c }
            r3.<init>(r5, r4)     // Catch:{ all -> 0x002c }
            r2.<init>(r3)     // Catch:{ all -> 0x002c }
        L_0x0015:
            int r3 = r2.read(r1)     // Catch:{ all -> 0x002c }
            r4 = -1
            if (r3 == r4) goto L_0x0021
            r4 = 0
            r0.write(r1, r4, r3)     // Catch:{ all -> 0x002c }
            goto L_0x0015
        L_0x0021:
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x002c }
            r1 = 0
            kotlin.io.b.a(r5, r1)
            java.lang.String r5 = r0.toString()
            return r5
        L_0x002c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x002e }
        L_0x002e:
            r1 = move-exception
            kotlin.io.b.a(r5, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.c.a(com.jumio.ale.swig.ALEInputStream):java.lang.String");
    }
}
