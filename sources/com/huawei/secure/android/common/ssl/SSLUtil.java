package com.huawei.secure.android.common.ssl;

import android.os.Build;
import com.huawei.secure.android.common.ssl.util.e;
import com.huochat.community.util.FileTool;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public abstract class SSLUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f38640a = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f38641b = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f38642c = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", FileTool.HASH_TYPE_MD5, "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static boolean a(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return b(sSLSocket, f38642c);
    }

    public static boolean b(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        int length = enabledCipherSuites.length;
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= length) {
                break;
            }
            String str = enabledCipherSuites[i11];
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length2 = strArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length2) {
                    z11 = false;
                    break;
                } else if (upperCase.contains(strArr[i12].toUpperCase(Locale.ENGLISH))) {
                    break;
                } else {
                    i12++;
                }
            }
            if (!z11) {
                arrayList.add(str);
            }
            i11++;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static void c(SSLSocket sSLSocket) {
        if (sSLSocket != null && !g(sSLSocket)) {
            a(sSLSocket);
        }
    }

    public static void d(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 29) {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
            }
            if (i11 >= 16 && i11 < 29) {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
            } else if (i11 < 16) {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1"});
            }
        }
    }

    public static boolean e(SSLSocket sSLSocket, String[] strArr) {
        if (!(sSLSocket == null || strArr == null)) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e11) {
                e.d("SSLUtil", "setEnabledProtocols: exception : " + e11.getMessage());
            }
        }
        return false;
    }

    public static SSLContext f() throws NoSuchAlgorithmException {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            return SSLContext.getInstance("TLSv1.3");
        }
        if (i11 >= 16) {
            return SSLContext.getInstance("TLSv1.2");
        }
        return SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
    }

    public static boolean g(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT > 19) {
            return h(sSLSocket, f38641b);
        }
        return h(sSLSocket, f38640a);
    }

    public static boolean h(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (asList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }
}
