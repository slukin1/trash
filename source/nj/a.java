package nj;

import com.huobi.domain.ca.CertificateUtil;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f47632a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static X509TrustManager f47633b;

    /* renamed from: c  reason: collision with root package name */
    public static X509TrustManager f47634c;

    /* renamed from: nj.a$a  reason: collision with other inner class name */
    public static final class C0578a implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            for (X509Certificate b11 : x509CertificateArr) {
                CertificateUtil.b(b11);
            }
            a.f47632a.a().checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            for (X509Certificate b11 : x509CertificateArr) {
                CertificateUtil.b(b11);
            }
            a.f47632a.a().checkServerTrusted(x509CertificateArr, str);
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public final X509TrustManager a() {
        if (f47633b == null) {
            f47633b = Platform.Companion.get().platformTrustManager();
        }
        return f47633b;
    }

    public final X509TrustManager b() {
        if (f47634c == null) {
            f47634c = new C0578a();
        }
        return f47634c;
    }

    public final SSLSocketFactory c(X509TrustManager x509TrustManager) {
        try {
            SSLContext newSSLContext = Platform.Companion.get().newSSLContext();
            newSSLContext.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return newSSLContext.getSocketFactory();
        } catch (GeneralSecurityException e11) {
            throw new AssertionError("No System TLS", e11);
        }
    }
}
