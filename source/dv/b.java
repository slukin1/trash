package dv;

import android.os.Build;
import com.google.common.net.HttpHeaders;
import com.huobi.woodpecker.kalle.Headers;
import com.huobi.woodpecker.kalle.RequestMethod;
import com.huobi.woodpecker.kalle.k;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import xu.c;

public class b implements xu.b {

    /* renamed from: dv.b$b  reason: collision with other inner class name */
    public static class C0184b {
        public b a() {
            return new b(this);
        }

        public C0184b() {
        }
    }

    public static C0184b c() {
        return new C0184b();
    }

    public c a(k kVar) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(kVar.l().toString());
        Proxy i11 = kVar.i();
        if (i11 == null) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection(i11);
        }
        httpURLConnection.setConnectTimeout(kVar.e());
        httpURLConnection.setReadTimeout(kVar.j());
        httpURLConnection.setInstanceFollowRedirects(false);
        if (httpURLConnection instanceof HttpsURLConnection) {
            SSLSocketFactory k11 = kVar.k();
            if (k11 != null) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(k11);
            }
            HostnameVerifier g11 = kVar.g();
            if (g11 != null) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(g11);
            }
        }
        RequestMethod h11 = kVar.h();
        httpURLConnection.setRequestMethod(h11.toString());
        httpURLConnection.setDoInput(true);
        boolean b11 = b(h11);
        httpURLConnection.setDoOutput(b11);
        Headers c11 = kVar.c();
        if (b11) {
            long s11 = c11.s();
            if (s11 <= 2147483647L) {
                httpURLConnection.setFixedLengthStreamingMode((int) s11);
            } else if (Build.VERSION.SDK_INT >= 19) {
                httpURLConnection.setFixedLengthStreamingMode(s11);
            } else {
                httpURLConnection.setChunkedStreamingMode(262144);
            }
        }
        c11.H(HttpHeaders.CONNECTION, Build.VERSION.SDK_INT > 19 ? c11.q(HttpHeaders.CONNECTION).get(0) : "close");
        for (Map.Entry next : Headers.C(c11).entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        httpURLConnection.connect();
        return new a(httpURLConnection);
    }

    public final boolean b(RequestMethod requestMethod) {
        boolean allowBody = requestMethod.allowBody();
        if (Build.VERSION.SDK_INT < 21) {
            return allowBody && requestMethod != RequestMethod.DELETE;
        }
        return allowBody;
    }

    public b(C0184b bVar) {
    }
}
