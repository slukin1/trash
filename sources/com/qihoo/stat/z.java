package com.qihoo.stat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public class z {

    /* renamed from: a  reason: collision with root package name */
    public static String f28859a = "QHttp";

    public static String a(Context context, String str, String str2) {
        try {
            HttpPost httpPost = new HttpPost(str);
            httpPost.setEntity(new ByteArrayEntity(b0.a(str2.getBytes())));
            HttpResponse execute = c(context).execute(httpPost);
            if (execute.getStatusLine() != null) {
                execute.getStatusLine().getStatusCode();
                return EntityUtils.toString(execute.getEntity());
            }
        } catch (Exception e11) {
            g0.b(f28859a, e11);
        } catch (Error e12) {
            g0.a(f28859a, e12);
        }
        return "";
    }

    public static HttpHost b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
            return new HttpHost("10.0.0.172", 80);
        }
        if (lowerCase.startsWith("cmwap")) {
            return new HttpHost("10.0.0.172", 80);
        }
        if (lowerCase.startsWith("ctwap")) {
            return new HttpHost("10.0.0.200", 80);
        }
        return null;
    }

    public static HttpClient c(Context context) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 60000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 60000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 204800);
        HttpClientParams.setRedirecting(basicHttpParams, true);
        HttpHost b11 = b(d(context));
        if (b11 != null) {
            basicHttpParams.setParameter("http.route.default-proxy", b11);
        }
        return new DefaultHttpClient(basicHttpParams);
    }

    public static String d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                return activeNetworkInfo.getExtraInfo();
            }
        } catch (Exception e11) {
            String str = f28859a;
            g0.c(str, "ex: " + e11.toString());
        }
        return "";
    }
}
