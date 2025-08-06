package com.mob.tools.network;

import android.os.Build;
import com.mob.commons.s;
import com.mob.tools.utils.ReflectHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class HttpConnectionImpl implements HttpConnection {

    /* renamed from: a  reason: collision with root package name */
    private Object f27913a;

    static {
        ReflectHelper.importClassNoThrow("org.apache.http.HttpResponse", (String) null);
        ReflectHelper.importClassNoThrow("org.apache.http.Header", (String) null);
    }

    public HttpConnectionImpl(Object obj) {
        this.f27913a = obj;
    }

    public InputStream getErrorStream() throws IOException {
        return getInputStream();
    }

    public Map<String, List<String>> getHeaderFields() throws IOException {
        try {
            HashMap hashMap = new HashMap();
            Object invokeInstanceMethod = ReflectHelper.invokeInstanceMethod(this.f27913a, "getAllHeaders", new Object[0]);
            if (invokeInstanceMethod != null) {
                int intValue = ((Integer) ReflectHelper.getInstanceField(invokeInstanceMethod, s.a("006gfeYej%ih"))).intValue();
                Object[] objArr = new Object[intValue];
                System.arraycopy(invokeInstanceMethod, 0, objArr, 0, intValue);
                for (int i11 = 0; i11 < intValue; i11++) {
                    Object obj = objArr[i11];
                    String str = (String) ReflectHelper.invokeInstanceMethod(obj, s.a("007Tej5fi%egQdKdf(f"), new Object[0]);
                    String str2 = (String) ReflectHelper.invokeInstanceMethod(obj, "getValue", new Object[0]);
                    if (str2 == null) {
                        str2 = "";
                    }
                    hashMap.put(str, Arrays.asList(str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                }
            }
            return hashMap;
        } catch (Throwable th2) {
            if (Build.VERSION.SDK_INT < 9) {
                throw new IOException(th2.getMessage());
            }
            throw new IOException(th2);
        }
    }

    public InputStream getInputStream() throws IOException {
        try {
            return (InputStream) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(this.f27913a, "getEntity", new Object[0]), "getContent", new Object[0]);
        } catch (Throwable th2) {
            if (Build.VERSION.SDK_INT < 9) {
                throw new IOException(th2.getMessage());
            }
            throw new IOException(th2);
        }
    }

    public int getResponseCode() throws IOException {
        try {
            return ((Integer) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(this.f27913a, "getStatusLine", new Object[0]), "getStatusCode", new Object[0])).intValue();
        } catch (Throwable th2) {
            if (Build.VERSION.SDK_INT < 9) {
                throw new IOException(th2.getMessage());
            }
            throw new IOException(th2);
        }
    }
}
