package org.cybergarage.http;

import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.jumio.commons.log.LogUtils;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.xiaomi.mipush.sdk.Constants;
import e20.a;
import e20.b;
import e20.e;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;
import org.cybergarage.net.HostInterface;
import org.cybergarage.util.Debug;
import org.cybergarage.util.StringUtil;

public class HTTPPacket {

    /* renamed from: a  reason: collision with root package name */
    public String f59804a;

    /* renamed from: b  reason: collision with root package name */
    public String f59805b = "";

    /* renamed from: c  reason: collision with root package name */
    public Vector f59806c = new Vector();

    /* renamed from: d  reason: collision with root package name */
    public byte[] f59807d = new byte[0];

    /* renamed from: e  reason: collision with root package name */
    public InputStream f59808e = null;

    public HTTPPacket() {
        j0("1.1");
        X((InputStream) null);
    }

    public boolean A() {
        return this.f59807d.length > 0;
    }

    public boolean B() {
        return this.f59808e != null;
    }

    public boolean C() {
        return E(HttpHeaders.CONTENT_RANGE) || E(HttpHeaders.RANGE);
    }

    public boolean D() {
        return this.f59805b.length() > 0;
    }

    public boolean E(String str) {
        return q(str) != null;
    }

    public boolean F() {
        return E(HttpHeaders.TRANSFER_ENCODING);
    }

    public void G() {
        c0("");
        c();
        W(new byte[0], false);
        X((InputStream) null);
    }

    public boolean H() {
        String x11;
        if (F() && (x11 = x()) != null) {
            return x11.equalsIgnoreCase("Chunked");
        }
        return false;
    }

    public boolean I() {
        String e11;
        if (z() && (e11 = e()) != null) {
            return e11.equalsIgnoreCase("close");
        }
        return false;
    }

    public boolean J() {
        String e11;
        if (z() && (e11 = e()) != null) {
            return e11.equalsIgnoreCase("Keep-Alive");
        }
        return false;
    }

    public boolean K(e eVar) {
        G();
        return N(eVar);
    }

    public final String L(BufferedInputStream bufferedInputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1];
        try {
            int read = bufferedInputStream.read(bArr);
            while (true) {
                if (read <= 0) {
                    break;
                } else if (bArr[0] == 10) {
                    break;
                } else {
                    if (bArr[0] != 13) {
                        byteArrayOutputStream.write(bArr[0]);
                    }
                    read = bufferedInputStream.read(bArr);
                }
            }
        } catch (InterruptedIOException unused) {
        } catch (IOException e11) {
            Debug.d(e11);
        }
        return byteArrayOutputStream.toString();
    }

    public void M(HTTPPacket hTTPPacket) {
        c0(hTTPPacket.n());
        c();
        int u11 = hTTPPacket.u();
        for (int i11 = 0; i11 < u11; i11++) {
            a(hTTPPacket.p(i11));
        }
        V(hTTPPacket.f());
    }

    public boolean N(e eVar) {
        return O(eVar.b());
    }

    public boolean O(InputStream inputStream) {
        return P(inputStream, false);
    }

    public boolean P(InputStream inputStream, boolean z11) {
        long j11;
        long j12;
        long j13;
        char c11;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            String L = L(bufferedInputStream);
            if (L != null) {
                if (L.length() > 0) {
                    c0(L);
                    boolean z12 = true;
                    if (new HTTPStatus(L).b() == 100) {
                        String L2 = L(bufferedInputStream);
                        while (true) {
                            if (L2 == null) {
                                break;
                            } else if (L2.length() <= 0) {
                                break;
                            } else {
                                b bVar = new b(L2);
                                if (bVar.g()) {
                                    d0(bVar);
                                }
                                L2 = L(bufferedInputStream);
                            }
                        }
                        String L3 = L(bufferedInputStream);
                        if (L3 == null || L3.length() <= 0) {
                            return true;
                        }
                        c0(L3);
                    }
                    String L4 = L(bufferedInputStream);
                    while (true) {
                        if (L4 == null) {
                            break;
                        } else if (L4.length() <= 0) {
                            break;
                        } else {
                            b bVar2 = new b(L4);
                            if (bVar2.g()) {
                                d0(bVar2);
                            }
                            L4 = L(bufferedInputStream);
                        }
                    }
                    if (z11) {
                        U("", false);
                        return true;
                    }
                    boolean H = H();
                    if (H) {
                        try {
                            String L5 = L(bufferedInputStream);
                            if (L5 != null) {
                                j11 = Long.parseLong(L5.trim(), 16);
                            }
                        } catch (Exception unused) {
                        }
                        j11 = 0;
                    } else {
                        j11 = h();
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (0 < j11) {
                        long b11 = (long) HTTP.b();
                        byte[] bArr = new byte[((int) (j11 > b11 ? b11 : j11))];
                        long j14 = 0;
                        while (true) {
                            if (j14 >= j11) {
                                break;
                            }
                            long j15 = j11 - j14;
                            try {
                                int read = bufferedInputStream.read(bArr, 0, (int) (b11 < j15 ? b11 : j15));
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                                j14 += (long) read;
                            } catch (Exception e11) {
                                Debug.d(e11);
                            }
                        }
                        if (H) {
                            long j16 = 0;
                            do {
                                j13 = (long) 2;
                                long skip = bufferedInputStream.skip(j13 - j16);
                                if (skip < 0) {
                                    break;
                                }
                                j16 += skip;
                                break;
                                break;
                            } while (j16 < j13);
                            try {
                                break;
                                String L6 = L(bufferedInputStream);
                                c11 = 16;
                                try {
                                    j12 = Long.parseLong(new String(L6.getBytes(), 0, L6.length() - 2), 16);
                                    z12 = true;
                                } catch (Exception unused2) {
                                    char c12 = c11;
                                    z12 = true;
                                    j12 = 0;
                                }
                            } catch (Exception unused3) {
                                c11 = 16;
                                char c122 = c11;
                                z12 = true;
                                j12 = 0;
                            }
                        } else {
                            j12 = 0;
                            z12 = true;
                        }
                    }
                    W(byteArrayOutputStream.toByteArray(), false);
                    return z12;
                }
            }
            return false;
        } catch (Exception e12) {
            Debug.d(e12);
            return false;
        }
    }

    public void Q(int i11) {
        R("max-age", i11);
    }

    public void R(String str, int i11) {
        e0(HttpHeaders.CACHE_CONTROL, String.valueOf(str) + ContainerUtils.KEY_VALUE_DELIMITER + Integer.toString(i11));
    }

    public void S(String str) {
        e0(HttpHeaders.CONNECTION, str);
    }

    public void T(String str) {
        U(str, true);
    }

    public void U(String str, boolean z11) {
        W(str.getBytes(), z11);
    }

    public void V(byte[] bArr) {
        W(bArr, true);
    }

    public void W(byte[] bArr, boolean z11) {
        this.f59807d = bArr;
        if (z11) {
            Y((long) bArr.length);
        }
    }

    public void X(InputStream inputStream) {
        this.f59808e = inputStream;
    }

    public void Y(long j11) {
        h0("Content-Length", j11);
    }

    public void Z(long j11, long j12, long j13) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(String.valueOf("" + "bytes ") + Long.toString(j11) + Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        sb2.append(Long.toString(j12));
        sb2.append("/");
        StringBuilder sb3 = new StringBuilder(String.valueOf(sb2.toString()));
        sb3.append(0 < j13 ? Long.toString(j13) : "*");
        e0(HttpHeaders.CONTENT_RANGE, sb3.toString());
    }

    public void a(b bVar) {
        this.f59806c.add(bVar);
    }

    public void a0(String str) {
        e0("Content-Type", str);
    }

    public void b(String str, String str2) {
        this.f59806c.add(new b(str, str2));
    }

    public void b0(Calendar calendar) {
        e0(HttpHeaders.DATE, new a(calendar).b());
    }

    public void c() {
        this.f59806c.clear();
        this.f59806c = new Vector();
    }

    public final void c0(String str) {
        this.f59805b = str;
    }

    public String d() {
        String lowerCase;
        int indexOf;
        String m11 = m();
        if (m11 == null || (indexOf = lowerCase.indexOf("charset")) < 0) {
            return "";
        }
        int i11 = indexOf + 7 + 1;
        String str = new String((lowerCase = m11.toLowerCase()).getBytes(), i11, lowerCase.length() - i11);
        if (str.length() < 0) {
            return "";
        }
        if (str.charAt(0) == '\"') {
            str = str.substring(1, str.length() - 1);
        }
        if (str.length() < 0) {
            return "";
        }
        return str.charAt(str.length() - 1) == '\"' ? str.substring(0, str.length() - 1) : str;
    }

    public void d0(b bVar) {
        e0(bVar.b(), bVar.c());
    }

    public String e() {
        return s(HttpHeaders.CONNECTION);
    }

    public void e0(String str, String str2) {
        b q11 = q(str);
        if (q11 != null) {
            q11.i(str2);
        } else {
            b(str, str2);
        }
    }

    public byte[] f() {
        return this.f59807d;
    }

    public void f0(String str) {
        if (HostInterface.g(str)) {
            str = "[" + str + "]";
        }
        e0("HOST", str);
    }

    public InputStream g() {
        return this.f59808e;
    }

    public void g0(String str, int i11) {
        if (HostInterface.g(str)) {
            str = "[" + str + "]";
        }
        e0("HOST", String.valueOf(str) + ":" + Integer.toString(i11));
    }

    public long h() {
        return t("Content-Length");
    }

    public void h0(String str, long j11) {
        e0(str, Long.toString(j11));
    }

    public long[] i() {
        long[] jArr = {0, 0, 0};
        if (!C()) {
            return jArr;
        }
        String s11 = s(HttpHeaders.CONTENT_RANGE);
        if (s11.length() <= 0) {
            s11 = s(HttpHeaders.RANGE);
        }
        if (s11.length() <= 0) {
            return jArr;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(s11, " =");
        if (!stringTokenizer.hasMoreTokens()) {
            return jArr;
        }
        stringTokenizer.nextToken(" ");
        if (!stringTokenizer.hasMoreTokens()) {
            return jArr;
        }
        try {
            jArr[0] = Long.parseLong(stringTokenizer.nextToken(" -"));
        } catch (NumberFormatException unused) {
        }
        if (!stringTokenizer.hasMoreTokens()) {
            return jArr;
        }
        try {
            jArr[1] = Long.parseLong(stringTokenizer.nextToken("-/"));
        } catch (NumberFormatException unused2) {
        }
        if (!stringTokenizer.hasMoreTokens()) {
            return jArr;
        }
        try {
            jArr[2] = Long.parseLong(stringTokenizer.nextToken("/"));
        } catch (NumberFormatException unused3) {
        }
        return jArr;
    }

    public void i0(String str) {
        e0(HttpHeaders.SERVER, str);
    }

    public long j() {
        return i()[0];
    }

    public void j0(String str) {
        this.f59804a = str;
    }

    public long k() {
        return i()[1];
    }

    public String l() {
        String d11 = d();
        if (d11 == null || d11.length() <= 0) {
            return new String(this.f59807d);
        }
        try {
            return new String(this.f59807d, d11);
        } catch (Exception e11) {
            Debug.d(e11);
            return new String(this.f59807d);
        }
    }

    public String m() {
        return s("Content-Type");
    }

    public String n() {
        return this.f59805b;
    }

    public String o(int i11) {
        StringTokenizer stringTokenizer = new StringTokenizer(this.f59805b, " ");
        String str = "";
        for (int i12 = 0; i12 <= i11; i12++) {
            if (!stringTokenizer.hasMoreTokens()) {
                return "";
            }
            str = stringTokenizer.nextToken();
        }
        return str;
    }

    public b p(int i11) {
        return (b) this.f59806c.get(i11);
    }

    public b q(String str) {
        int u11 = u();
        for (int i11 = 0; i11 < u11; i11++) {
            b p11 = p(i11);
            if (p11.b().equalsIgnoreCase(str)) {
                return p11;
            }
        }
        return null;
    }

    public String r() {
        StringBuffer stringBuffer = new StringBuffer();
        int u11 = u();
        for (int i11 = 0; i11 < u11; i11++) {
            b p11 = p(i11);
            stringBuffer.append(String.valueOf(p11.b()) + l.f34627b + p11.c() + LogUtils.NEW_LINE);
        }
        return stringBuffer.toString();
    }

    public String s(String str) {
        b q11 = q(str);
        if (q11 == null) {
            return "";
        }
        return q11.c();
    }

    public long t(String str) {
        b q11 = q(str);
        if (q11 == null) {
            return 0;
        }
        return StringUtil.b(q11.c());
    }

    public int u() {
        return this.f59806c.size();
    }

    public String v(String str) {
        return w(str, "\"", "\"");
    }

    public String w(String str, String str2, String str3) {
        String s11 = s(str);
        if (s11.startsWith(str2)) {
            s11 = s11.substring(1, s11.length());
        }
        return s11.endsWith(str3) ? s11.substring(0, s11.length() - 1) : s11;
    }

    public String x() {
        return s(HttpHeaders.TRANSFER_ENCODING);
    }

    public String y() {
        return this.f59804a;
    }

    public boolean z() {
        return E(HttpHeaders.CONNECTION);
    }
}
