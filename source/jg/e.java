package jg;

import com.huawei.secure.android.common.ssl.util.d;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class e implements X509TrustManager {

    /* renamed from: a  reason: collision with root package name */
    public List<X509TrustManager> f40539a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public X509Certificate[] f40540b;

    public e(InputStream inputStream, String str) throws IllegalArgumentException {
        a(inputStream, str);
    }

    public final void a(InputStream inputStream, String str) {
        if (inputStream == null || str == null) {
            throw new IllegalArgumentException("inputstream or trustPwd is null");
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            KeyStore instance2 = KeyStore.getInstance("bks");
            instance2.load(inputStream, str.toCharArray());
            instance.init(instance2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (int i11 = 0; i11 < trustManagers.length; i11++) {
                if (trustManagers[i11] instanceof X509TrustManager) {
                    this.f40539a.add((X509TrustManager) trustManagers[i11]);
                }
            }
        } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e11) {
            com.huawei.secure.android.common.ssl.util.e.d("SX509TM", "loadInputStream: exception : " + e11.getMessage());
        } finally {
            d.b(inputStream);
        }
        com.huawei.secure.android.common.ssl.util.e.b("SX509TM", "loadInputStream: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public void b(X509Certificate[] x509CertificateArr) {
        this.f40540b = x509CertificateArr;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        com.huawei.secure.android.common.ssl.util.e.e("SX509TM", "checkClientTrusted: ");
        for (X509TrustManager checkServerTrusted : this.f40539a) {
            try {
                checkServerTrusted.checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e11) {
                com.huawei.secure.android.common.ssl.util.e.d("SX509TM", "checkServerTrusted CertificateException" + e11.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        b(x509CertificateArr);
        com.huawei.secure.android.common.ssl.util.e.e("SX509TM", "checkServerTrusted begin,size=" + x509CertificateArr.length + ",authType=" + str);
        long currentTimeMillis = System.currentTimeMillis();
        int length = x509CertificateArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            X509Certificate x509Certificate = x509CertificateArr[i11];
            com.huawei.secure.android.common.ssl.util.e.b("SX509TM", "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            com.huawei.secure.android.common.ssl.util.e.b("SX509TM", "IssuerDN :" + x509Certificate.getIssuerDN());
            com.huawei.secure.android.common.ssl.util.e.b("SX509TM", "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.f40539a.size();
        int i12 = 0;
        while (i12 < size) {
            try {
                com.huawei.secure.android.common.ssl.util.e.e("SX509TM", "check server i=" + i12);
                X509TrustManager x509TrustManager = this.f40539a.get(i12);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    com.huawei.secure.android.common.ssl.util.e.e("SX509TM", "client root ca size=" + acceptedIssuers.length);
                    for (int i13 = 0; i13 < acceptedIssuers.length; i13++) {
                        com.huawei.secure.android.common.ssl.util.e.b("SX509TM", "client root ca getIssuerDN :" + acceptedIssuers[i13].getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                com.huawei.secure.android.common.ssl.util.e.e("SX509TM", "checkServerTrusted end, " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e11) {
                com.huawei.secure.android.common.ssl.util.e.d("SX509TM", "checkServerTrusted error :" + e11.getMessage() + " , time : " + i12);
                if (i12 == size - 1) {
                    if (x509CertificateArr.length > 0) {
                        com.huawei.secure.android.common.ssl.util.e.d("SX509TM", "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e11;
                }
                i12++;
            }
        }
        com.huawei.secure.android.common.ssl.util.e.b("SX509TM", "checkServerTrusted: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager acceptedIssuers : this.f40539a) {
                arrayList.addAll(Arrays.asList(acceptedIssuers.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e11) {
            com.huawei.secure.android.common.ssl.util.e.d("SX509TM", "getAcceptedIssuers exception : " + e11.getMessage());
            return new X509Certificate[0];
        }
    }
}
