package com.google.zxing.client.android;

import android.util.Log;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public final class HttpHelper {
    private static final Collection<String> REDIRECTOR_DOMAINS = new HashSet(Arrays.asList(new String[]{"amzn.to", "bit.ly", "bitly.com", "fb.me", "goo.gl", "is.gd", "j.mp", "lnkd.in", "ow.ly", "R.BEETAGG.COM", "r.beetagg.com", "SCN.BY", "su.pr", "t.co", "tinyurl.com", "tr.im"}));
    private static final String TAG = "HttpHelper";

    /* renamed from: com.google.zxing.client.android.HttpHelper$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$client$android$HttpHelper$ContentType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.zxing.client.android.HttpHelper$ContentType[] r0 = com.google.zxing.client.android.HttpHelper.ContentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$zxing$client$android$HttpHelper$ContentType = r0
                com.google.zxing.client.android.HttpHelper$ContentType r1 = com.google.zxing.client.android.HttpHelper.ContentType.HTML     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$zxing$client$android$HttpHelper$ContentType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.client.android.HttpHelper$ContentType r1 = com.google.zxing.client.android.HttpHelper.ContentType.JSON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$zxing$client$android$HttpHelper$ContentType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.client.android.HttpHelper$ContentType r1 = com.google.zxing.client.android.HttpHelper.ContentType.XML     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.HttpHelper.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ContentType {
        HTML,
        JSON,
        XML,
        TEXT
    }

    private HttpHelper() {
    }

    private static CharSequence consume(URLConnection uRLConnection, int i11) throws IOException {
        int read;
        String encoding = getEncoding(uRLConnection);
        StringBuilder sb2 = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(uRLConnection.getInputStream(), encoding);
        try {
            char[] cArr = new char[1024];
            while (sb2.length() < i11 && (read = inputStreamReader.read(cArr)) > 0) {
                sb2.append(cArr, 0, read);
            }
            inputStreamReader.close();
            return sb2;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static CharSequence downloadViaHttp(String str, ContentType contentType) throws IOException {
        return downloadViaHttp(str, contentType, Integer.MAX_VALUE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r1.indexOf("charset=");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getEncoding(java.net.URLConnection r1) {
        /*
            java.lang.String r0 = "Content-Type"
            java.lang.String r1 = r1.getHeaderField(r0)
            if (r1 == 0) goto L_0x0017
            java.lang.String r0 = "charset="
            int r0 = r1.indexOf(r0)
            if (r0 < 0) goto L_0x0017
            int r0 = r0 + 8
            java.lang.String r1 = r1.substring(r0)
            return r1
        L_0x0017:
            java.lang.String r1 = "UTF-8"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.HttpHelper.getEncoding(java.net.URLConnection):java.lang.String");
    }

    private static int safelyConnect(HttpURLConnection httpURLConnection) throws IOException {
        try {
            httpURLConnection.connect();
            try {
                return httpURLConnection.getResponseCode();
            } catch (IllegalArgumentException | NullPointerException | StringIndexOutOfBoundsException e11) {
                throw new IOException(e11);
            }
        } catch (RuntimeException e12) {
            throw new IOException(e12);
        }
    }

    private static HttpURLConnection safelyOpenConnection(URL url) throws IOException {
        try {
            URLConnection openConnection = url.openConnection();
            if (openConnection instanceof HttpURLConnection) {
                return (HttpURLConnection) openConnection;
            }
            throw new IOException();
        } catch (NullPointerException e11) {
            String str = TAG;
            Log.w(str, "Bad URI? " + url);
            throw new IOException(e11);
        }
    }

    public static URI unredirect(URI uri) throws IOException {
        if (!REDIRECTOR_DOMAINS.contains(uri.getHost())) {
            return uri;
        }
        HttpURLConnection safelyOpenConnection = safelyOpenConnection(uri.toURL());
        safelyOpenConnection.setInstanceFollowRedirects(false);
        safelyOpenConnection.setDoInput(false);
        safelyOpenConnection.setRequestMethod("HEAD");
        safelyOpenConnection.setRequestProperty("User-Agent", "ZXing (Android)");
        try {
            int safelyConnect = safelyConnect(safelyOpenConnection);
            if (safelyConnect != 307) {
                switch (safelyConnect) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                }
            }
            String headerField = safelyOpenConnection.getHeaderField(HttpHeaders.LOCATION);
            if (headerField != null) {
                try {
                    URI uri2 = new URI(headerField);
                    safelyOpenConnection.disconnect();
                    return uri2;
                } catch (URISyntaxException unused) {
                }
            }
            return uri;
        } finally {
            safelyOpenConnection.disconnect();
        }
    }

    public static CharSequence downloadViaHttp(String str, ContentType contentType, int i11) throws IOException {
        int i12 = AnonymousClass1.$SwitchMap$com$google$zxing$client$android$HttpHelper$ContentType[contentType.ordinal()];
        return downloadViaHttp(str, i12 != 1 ? i12 != 2 ? i12 != 3 ? "text/*,*/*" : "application/xml,text/*,*/*" : "application/json,text/*,*/*" : "application/xhtml+xml,text/html,text/*,*/*", i11);
    }

    /* JADX INFO: finally extract failed */
    private static CharSequence downloadViaHttp(String str, String str2, int i11) throws IOException {
        int i12 = 0;
        while (i12 < 5) {
            HttpURLConnection safelyOpenConnection = safelyOpenConnection(new URL(str));
            safelyOpenConnection.setInstanceFollowRedirects(true);
            safelyOpenConnection.setRequestProperty("Accept", str2);
            safelyOpenConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8,*");
            safelyOpenConnection.setRequestProperty("User-Agent", "ZXing (Android)");
            try {
                int safelyConnect = safelyConnect(safelyOpenConnection);
                if (safelyConnect == 200) {
                    CharSequence consume = consume(safelyOpenConnection, i11);
                    safelyOpenConnection.disconnect();
                    return consume;
                } else if (safelyConnect == 302) {
                    String headerField = safelyOpenConnection.getHeaderField(HttpHeaders.LOCATION);
                    if (headerField != null) {
                        i12++;
                        safelyOpenConnection.disconnect();
                        str = headerField;
                    } else {
                        throw new IOException("No Location");
                    }
                } else {
                    throw new IOException("Bad HTTP response: " + safelyConnect);
                }
            } catch (Throwable th2) {
                safelyOpenConnection.disconnect();
                throw th2;
            }
        }
        throw new IOException("Too many redirects");
    }
}
