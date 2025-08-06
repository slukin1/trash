package org.cybergarage.http;

import com.huochat.community.network.domain.DomainTool;
import java.net.URL;

public class HTTP {

    /* renamed from: a  reason: collision with root package name */
    public static int f59803a = 524288;

    public static final String a(String str, String str2) {
        try {
            URL url = new URL(str);
            return String.valueOf(url.getProtocol()) + "://" + url.getHost() + ":" + url.getPort() + g(str2);
        } catch (Exception unused) {
            return "";
        }
    }

    public static final int b() {
        return f59803a;
    }

    public static final String c(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception unused) {
            return "";
        }
    }

    public static final int d(String str) {
        try {
            int port = new URL(str).getPort();
            if (port <= 0) {
                return 80;
            }
            return port;
        } catch (Exception unused) {
            return 80;
        }
    }

    public static final String e(String str, int i11) {
        return DomainTool.DOMAIN_PREFIX_HTTP + str + ":" + i11;
    }

    public static final boolean f(String str) {
        try {
            new URL(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final String g(String str) {
        return h(str, true);
    }

    public static final String h(String str, boolean z11) {
        if (f(str)) {
            try {
                URL url = new URL(str);
                String path = url.getPath();
                if (z11) {
                    String query = url.getQuery();
                    if (!query.equals("")) {
                        path = String.valueOf(path) + "?" + query;
                    }
                }
                return path.endsWith("/") ? path.substring(0, path.length() - 1) : path;
            } catch (Exception unused) {
                return str;
            }
        } else if (str.length() <= 0 || str.charAt(0) == '/') {
            return str;
        } else {
            return "/" + str;
        }
    }
}
