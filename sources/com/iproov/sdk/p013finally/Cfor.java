package com.iproov.sdk.p013finally;

import android.content.Context;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.InvalidOptionsException;
import com.iproov.sdk.core.exception.NetworkException;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.p033throws.Cbreak;
import com.iproov.sdk.p033throws.Cthis;
import com.sumsub.sns.internal.fingerprint.signalproviders.f;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import com.xiaomi.mipush.sdk.Constants;
import e7.s;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.finally.for  reason: invalid class name and invalid package */
class Cfor {
    /* renamed from: do  reason: not valid java name */
    public static OkHttpClient.Builder m615do(Context context, Cextends.Ccatch catchR) throws IProovException {
        X509TrustManager x509TrustManager;
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load((InputStream) null, (char[]) null);
            m616do(context, instance, catchR.m1485do());
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance2.init(instance);
            TrustManager[] trustManagers = instance2.getTrustManagers();
            int length = trustManagers.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    x509TrustManager = null;
                    break;
                }
                TrustManager trustManager = trustManagers[i11];
                if (trustManager instanceof X509TrustManager) {
                    x509TrustManager = (X509TrustManager) trustManager;
                    break;
                }
                i11++;
            }
            if (x509TrustManager != null) {
                SSLContext instance3 = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
                instance3.init((KeyManager[]) null, trustManagers, (SecureRandom) null);
                return new OkHttpClient.Builder().sslSocketFactory(instance3.getSocketFactory(), x509TrustManager);
            }
            throw new NetworkException(context, "Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (Exception e11) {
            e11.printStackTrace();
            throw new NetworkException(context, e11.getLocalizedMessage());
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static void m616do(Context context, KeyStore keyStore, List<Cextends.Cfor> list) throws CertificateException, IProovException {
        InputStream inputStream;
        int i11 = 0;
        while (i11 < list.size()) {
            Cextends.Cfor forR = list.get(i11);
            if (forR instanceof Cextends.Cfor.Cif) {
                inputStream = new BufferedInputStream(context.getResources().openRawResource(Integer.valueOf(((Cextends.Cfor.Cif) forR).m1511do()).intValue()));
            } else if (forR instanceof Cextends.Cfor.Cdo) {
                inputStream = new ByteArrayInputStream(((Cextends.Cfor.Cdo) forR).m1510do());
            } else {
                throw new InvalidOptionsException(context, "Certificate must be of type Integer (raw resource id) or Byte array (contents of certificate in der format)");
            }
            try {
                Collection<? extends Certificate> generateCertificates = CertificateFactory.getInstance("X.509").generateCertificates(inputStream);
                if (!generateCertificates.isEmpty()) {
                    int i12 = 0;
                    for (Certificate certificate : generateCertificates) {
                        keyStore.setCertificateEntry("ca" + i11 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i12, certificate);
                        i12++;
                        Objects.toString(((X509Certificate) certificate).getSubjectDN());
                    }
                    i11++;
                } else {
                    throw new InvalidOptionsException(context, "Certificate file appears to be empty or not valid");
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                throw new InvalidOptionsException(context, e11.getLocalizedMessage());
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static void m618do(JSONObject jSONObject, Cthis thisR) throws JSONException {
        new HashMap();
        jSONObject.put("F", thisR.f2087do);
        jSONObject.put("A", thisR.f2094if);
        jSONObject.put("a", thisR.f2092for);
        jSONObject.put("c", thisR.f2100new);
        jSONObject.put("e", thisR.f2115try);
        jSONObject.put("hMedian", thisR.f2081case);
        jSONObject.put("hoMedian", thisR.f2088else);
        jSONObject.put("i", thisR.f2093goto);
        double d11 = 1.0d;
        jSONObject.put("qi", thisR.f2111this ? 1.0d : 0.0d);
        jSONObject.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, thisR.f2080break);
        jSONObject.put("qn", thisR.f2082catch ? 1.0d : 0.0d);
        jSONObject.put(s.f70071a, thisR.f2083class);
        jSONObject.put("so", thisR.f2084const);
        jSONObject.put("t", thisR.f2090final);
        jSONObject.put("qt", thisR.f2108super ? 1.0d : 0.0d);
        jSONObject.put(f.f34662a, thisR.f2112throw);
        jSONObject.put("z", thisR.f2117while);
        jSONObject.put("vo", thisR.f2096import);
        jSONObject.put(TtmlNode.VERTICAL, thisR.f2099native ? 1.0d : 0.0d);
        jSONObject.put("tc", thisR.f2104public ? 1.0d : 0.0d);
        jSONObject.put("tf", thisR.f2105return ? 1.0d : 0.0d);
        jSONObject.put("sd", thisR.f2106static);
        jSONObject.put("su", thisR.f2109switch ? 1.0d : 0.0d);
        if (!thisR.f2113throws) {
            d11 = 0.0d;
        }
        jSONObject.put("sl", d11);
        jSONObject.put(TtmlNode.TAG_P, thisR.f2086default);
        m619do(jSONObject, "sa", thisR.f2089extends);
        m619do(jSONObject, "sb", thisR.f2091finally);
        m619do(jSONObject, "eb", thisR.f2101package);
        m619do(jSONObject, "mm", thisR.f2102private);
        m619do(jSONObject, "cs", thisR.f2079abstract);
        m619do(jSONObject, "sm", thisR.f2085continue);
        m619do(jSONObject, "cc", thisR.f2107strictfp);
        m619do(jSONObject, UserDataStore.STATE, thisR.f2116volatile);
        m619do(jSONObject, UserDataStore.CITY, thisR.f2098interface);
        m619do(jSONObject, "gc", thisR.f2103protected);
        m619do(jSONObject, "wb", thisR.f2114transient);
        m619do(jSONObject, "dr", thisR.f2095implements);
        m619do(jSONObject, "ma", thisR.f2097instanceof);
        m619do(jSONObject, "sf", thisR.f2110synchronized);
    }

    /* renamed from: do  reason: not valid java name */
    private static void m619do(JSONObject jSONObject, String str, Double d11) throws JSONException {
        if (d11 != null && !d11.isNaN() && !d11.isInfinite()) {
            jSONObject.put(str, d11);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static void m617do(JSONObject jSONObject, Cbreak breakR) throws JSONException {
        m618do(jSONObject, breakR.f2027do);
        jSONObject.put(CrashHianalyticsData.TIME, breakR.f2029if);
        jSONObject.put("state", breakR.f2028for);
        Float f11 = breakR.f2030new;
        if (f11 != null) {
            jSONObject.put("sLux", f11);
        }
    }
}
