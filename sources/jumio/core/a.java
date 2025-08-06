package jumio.core;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import com.jumio.commons.log.Log;
import com.jumio.core.network.TrustManagerInterface;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Lambda;

public final class a implements TrustManagerInterface {

    /* renamed from: a  reason: collision with root package name */
    public final X509TrustManager f56108a;

    /* renamed from: b  reason: collision with root package name */
    public String f56109b = "";

    /* renamed from: c  reason: collision with root package name */
    public d10.a<Boolean> f56110c = C0658a.f56112a;

    /* renamed from: d  reason: collision with root package name */
    public final byte[][] f56111d = {q2.a("fbe3018031f9586bcbf41727e417b7d1c45c2f47f93be372a17b96b50757d5a2"), q2.a("7f4296fc5b6a4e3b35d3c369623e364ab1af381d8fa7121533c9d6c633ea2461"), q2.a("36abc32656acfc645c61b71613c4bf21c787f5cabbee48348d58597803d7abc9"), q2.a("f7ecded5c66047d28ed6466b543c40e0743abe81d109254dcf845d4c2c7853c5"), q2.a("2b071c59a0a0ae76b0eadb2bad23bad4580b69c3601b630c2eaf0613afa83f92")};

    /* renamed from: jumio.core.a$a  reason: collision with other inner class name */
    public static final class C0658a extends Lambda implements d10.a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0658a f56112a = new C0658a();

        public C0658a() {
            super(0);
        }

        public final Object invoke() {
            return Boolean.TRUE;
        }
    }

    public a() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        this.f56108a = (X509TrustManager) instance.getTrustManagers()[0];
    }

    public final void a(X509Certificate[] x509CertificateArr) throws CertificateException {
        boolean z11;
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(x509CertificateArr[x509CertificateArr.length - 1].getPublicKey().getEncoded());
        byte[][] bArr = this.f56111d;
        int length = bArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                z11 = false;
                break;
            } else if (MessageDigest.isEqual(digest, bArr[i11])) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            X509Certificate x509Certificate = x509CertificateArr[0];
            try {
                x509Certificate.checkValidity();
            } catch (CertificateNotYetValidException e11) {
                try {
                    Log.w("JumioTrustManager", "SSL Certificate is not yet valid", (Throwable) e11);
                } catch (Exception e12) {
                    throw new CertificateException("SSL Certificate match error", e12);
                }
            }
            String name = x509Certificate.getSubjectDN().getName();
            StringBuilder sb2 = new StringBuilder();
            for (int i12 = 0; i12 < name.length(); i12++) {
                char charAt = name.charAt(i12);
                if (!CharsKt__CharJVMKt.c(charAt)) {
                    sb2.append(charAt);
                }
            }
            if (!StringsKt__StringsKt.P(sb2.toString(), "CN=" + this.f56109b, true)) {
                throw new CertificateException("Certificate pinning failed");
            }
            return;
        }
        throw new CertificateException("Certificate pinning failed");
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.f56108a.checkClientTrusted(x509CertificateArr, str);
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr.length >= 2) {
            if (Build.VERSION.SDK_INT >= 24) {
                new X509TrustManagerExtensions(this.f56108a).checkServerTrusted(x509CertificateArr, str, this.f56109b);
            } else {
                this.f56108a.checkServerTrusted(x509CertificateArr, str);
            }
            if (this.f56110c.invoke().booleanValue()) {
                a(x509CertificateArr);
                return;
            }
            return;
        }
        throw new CertificateException("SSL Certificate Chain is not sufficient");
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return this.f56108a.getAcceptedIssuers();
    }

    public final String getHostname() {
        return this.f56109b;
    }

    public final d10.a<Boolean> getKeyPinning() {
        return this.f56110c;
    }

    public final void setHostname(String str) {
        this.f56109b = str;
    }

    public final void setKeyPinning(d10.a<Boolean> aVar) {
        this.f56110c = aVar;
    }
}
