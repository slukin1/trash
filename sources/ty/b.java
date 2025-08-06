package ty;

import android.annotation.TargetApi;
import com.ta.a.e.h;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

@TargetApi(24)
public class b extends X509ExtendedTrustManager {

    /* renamed from: a  reason: collision with root package name */
    public static TrustManager[] f40584a;

    public static synchronized TrustManager[] a() {
        TrustManager[] trustManagerArr;
        synchronized (b.class) {
            if (f40584a == null) {
                f40584a = new TrustManager[]{new b()};
            }
            trustManagerArr = f40584a;
        }
        return trustManagerArr;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        h.e("UtExtendTrustManager", "checkClientTrusted1");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        int i11 = 0;
        h.e("UtExtendTrustManager", "checkServerTrusted1");
        if (x509CertificateArr == null || x509CertificateArr.length <= 0) {
            throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
        }
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init((KeyStore) null);
            if (instance.getTrustManagers() != null) {
                TrustManager[] trustManagers = instance.getTrustManagers();
                int length = trustManagers.length;
                while (i11 < length) {
                    try {
                        ((X509TrustManager) trustManagers[i11]).checkServerTrusted(x509CertificateArr, str);
                        i11++;
                    } catch (CertificateException e11) {
                        Throwable th2 = e11;
                        while (th2 != null) {
                            if (!(th2 instanceof CertificateExpiredException) && !(th2 instanceof CertificateNotYetValidException)) {
                                th2 = th2.getCause();
                            } else {
                                return;
                            }
                        }
                        throw e11;
                    }
                }
            }
        } catch (NoSuchAlgorithmException e12) {
            throw new CertificateException(e12);
        } catch (KeyStoreException e13) {
            throw new CertificateException(e13);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        h.e("UtExtendTrustManager", "checkClientTrusted2");
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            throw new IllegalArgumentException("parameter is not used");
        } else if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("parameter is not used");
        } else {
            try {
                x509CertificateArr[0].checkValidity();
            } catch (Exception unused) {
                throw new CertificateException("Certificate not valid or trusted.");
            }
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        h.e("UtExtendTrustManager", "checkClientTrusted3");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        h.e("UtExtendTrustManager", "checkServerTrusted2");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        h.e("UtExtendTrustManager", "checkServerTrusted3");
    }
}
