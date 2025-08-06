package ty;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class c implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public String f40585a;

    public c(String str) {
        this.f40585a = str;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f40585a) || !(obj instanceof c)) {
            return false;
        }
        String str = ((c) obj).f40585a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f40585a.equals(str);
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f40585a, sSLSession);
    }
}
