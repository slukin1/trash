package com.engagelab.privates.common;

import android.content.Context;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.https.HostVerifier;
import com.engagelab.privates.common.log.MTCommonLog;
import com.facebook.stetho.inspector.network.DecompressionHelper;
import com.google.common.net.HttpHeaders;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class i {
    public static int a(Context context, String str, String str2, byte[] bArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setReadTimeout(6000);
            httpURLConnection.setRequestProperty("Authorization", str2);
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Accept", "application/jason");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, DecompressionHelper.GZIP_ENCODING);
            httpURLConnection.setRequestProperty("content-type", "application/octet-stream");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
            httpURLConnection.setRequestProperty("X-App-Key", MTGlobal.getAppKey(context));
            httpURLConnection.setRequestProperty("Encrypt-Type", MTGlobal.getEncryptType() == 2 ? "SM4" : "");
            if (httpURLConnection instanceof HttpsURLConnection) {
                SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(instance.getSocketFactory());
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostVerifier(httpURLConnection.getURL().getHost()));
            }
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            httpURLConnection.disconnect();
            return responseCode;
        } catch (SocketTimeoutException e11) {
            MTCommonLog.w("HttpClient", "post socketTimeoutException:" + e11.getMessage());
            return -1;
        } catch (Throwable th2) {
            MTCommonLog.w("HttpClient", "post failed " + th2.getMessage());
            return -1;
        }
    }
}
