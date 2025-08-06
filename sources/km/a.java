package km;

import android.text.TextUtils;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f76231a;

    public static class b implements Comparator<HttpCookie> {
        public b() {
        }

        /* renamed from: a */
        public int compare(HttpCookie httpCookie, HttpCookie httpCookie2) {
            if (httpCookie == httpCookie2) {
                return 0;
            }
            if (httpCookie == null) {
                return -1;
            }
            if (httpCookie2 == null) {
                return 1;
            }
            if (!httpCookie.getName().equals(httpCookie2.getName())) {
                return 0;
            }
            String a11 = a.f(httpCookie.getPath());
            String a12 = a.f(httpCookie2.getPath());
            if (a11.startsWith(a12)) {
                return -1;
            }
            return a12.startsWith(a11) ? 1 : 0;
        }
    }

    public a(b bVar) {
        this.f76231a = bVar;
    }

    public static boolean c(String str, int i11) {
        if (!str.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            return str.equalsIgnoreCase(Integer.toString(i11));
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        String num = Integer.toString(i11);
        for (String equals : split) {
            if (equals.equals(num)) {
                return true;
            }
        }
        return false;
    }

    public static int e(URI uri) {
        int port = uri.getPort();
        if (port != -1) {
            return port;
        }
        if (com.adjust.sdk.Constants.SCHEME.equals(uri.getScheme())) {
            return PsExtractor.SYSTEM_HEADER_START_CODE;
        }
        return 80;
    }

    public static String f(String str) {
        if (str == null) {
            str = "";
        }
        if (str.endsWith("/")) {
            return str;
        }
        return str + "/";
    }

    public static boolean g(URI uri, HttpCookie httpCookie) {
        return f(uri.getPath()).startsWith(f(httpCookie.getPath()));
    }

    public void b(URI uri, List<String> list) {
        for (String parse : list) {
            for (HttpCookie next : HttpCookie.parse(parse)) {
                if (next.getPath() == null) {
                    next.setPath(f(uri.getPath()));
                } else if (!g(uri, next)) {
                }
                if (next.getDomain() == null) {
                    next.setDomain(uri.getHost());
                }
                String portlist = next.getPortlist();
                int e11 = e(uri);
                if (TextUtils.isEmpty(portlist) || c(portlist, e11)) {
                    this.f76231a.a(uri, next);
                }
            }
        }
    }

    public List<String> d(URI uri) {
        boolean equalsIgnoreCase = com.adjust.sdk.Constants.SCHEME.equalsIgnoreCase(uri.getScheme());
        ArrayList arrayList = new ArrayList();
        for (HttpCookie next : this.f76231a.b(uri)) {
            if (g(uri, next) && (equalsIgnoreCase || !next.getSecure())) {
                String portlist = next.getPortlist();
                int e11 = e(uri);
                if (TextUtils.isEmpty(portlist) || c(portlist, e11)) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(h(arrayList));
        return arrayList2;
    }

    public final String h(List<HttpCookie> list) {
        Collections.sort(list, new b());
        StringBuilder sb2 = new StringBuilder();
        int i11 = 1;
        for (HttpCookie next : list) {
            if (next.getVersion() < i11) {
                i11 = next.getVersion();
            }
        }
        if (i11 == 1) {
            sb2.append("$Version=\"1\"; ");
        }
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (i12 != 0) {
                sb2.append("; ");
            }
            sb2.append(list.get(i12).toString());
        }
        return sb2.toString();
    }
}
