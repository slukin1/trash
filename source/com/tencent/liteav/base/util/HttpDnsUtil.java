package com.tencent.liteav.base.util;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

@JNINamespace("liteav::dns")
public class HttpDnsUtil {
    private static final String TAG = "HttpDnsUtil";
    private static final List<String> WHITE_LIST_HOST;
    private static a mCustomHttpDNSCallback = null;
    private static boolean mEnableCustomHttpDNS = false;
    private static final Object mLock = new Object();
    private static final String sIPV4Regular = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
    private static Pattern sValidIPV4Pattern;

    public interface a {
        void a(String str, List<String> list);
    }

    public static class b extends SSLSocketFactory {

        /* renamed from: a  reason: collision with root package name */
        private HttpsURLConnection f21518a;

        public b(HttpsURLConnection httpsURLConnection) {
            this.f21518a = httpsURLConnection;
        }

        public final Socket createSocket() throws IOException {
            return null;
        }

        public final Socket createSocket(String str, int i11) throws IOException, UnknownHostException {
            return null;
        }

        public final Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException, UnknownHostException {
            return null;
        }

        public final Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
            return null;
        }

        public final Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
            return null;
        }

        public final Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
            String requestProperty = this.f21518a.getRequestProperty("Host");
            if (requestProperty != null) {
                str = requestProperty;
            }
            InetAddress inetAddress = socket.getInetAddress();
            if (z11) {
                socket.close();
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i11);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            if (Build.VERSION.SDK_INT >= 17) {
                LiteavLog.i(HttpDnsUtil.TAG, "Setting SNI hostname");
                sSLCertificateSocketFactory.setHostname(sSLSocket, str);
            } else {
                LiteavLog.d(HttpDnsUtil.TAG, "No documented SNI support on Android < 4.2, trying with reflection");
                try {
                    sSLSocket.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(sSLSocket, new Object[]{str});
                } catch (Exception e11) {
                    LiteavLog.w(HttpDnsUtil.TAG, "SNI not useable", e11);
                }
            }
            SSLSession session = sSLSocket.getSession();
            if (HttpsURLConnection.getDefaultHostnameVerifier().verify(str, session)) {
                LiteavLog.i(HttpDnsUtil.TAG, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
                return sSLSocket;
            }
            throw new SSLPeerUnverifiedException("Cannot verify hostname: ".concat(String.valueOf(str)));
        }

        public final String[] getDefaultCipherSuites() {
            return new String[0];
        }

        public final String[] getSupportedCipherSuites() {
            return new String[0];
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        WHITE_LIST_HOST = arrayList;
        arrayList.add("intl-sdklog.trtc.tencent-cloud.com");
        arrayList.add("trtc-client-log-overseas-1258344699.cos.ap-singapore.myqcloud.com");
        arrayList.add("inland-sdklog.trtc.tencent-cloud.com");
        arrayList.add("trtc-sdk-log-1258344699.cos.ap-guangzhou.myqcloud.com");
        arrayList.add("trtc-sdk-config-1258344699.file.myqcloud.com");
        arrayList.add("liteav.sdk.qcloud.com");
        arrayList.add("yun.tim.qq.com");
        arrayList.add("videoapi-sgp.im.qcloud.com");
        arrayList.add("sdkdc.live.qcloud.com");
        arrayList.add("mlvbdc.live.qcloud.com");
        arrayList.add("conf.sdk.qcloud.com");
        arrayList.add("speedtestint.trtc.tencent-cloud.com");
        arrayList.add("speedtest.trtc.tencent-cloud.com");
        arrayList.add("webrtc-signal-scheduler.tlivesource.com");
        arrayList.add("cloud.tim.qq.com");
        arrayList.add("livepull.myqcloud.com");
        arrayList.add("livepullipv6.myqcloud.com");
        arrayList.add("tcdns.myqcloud.com");
        arrayList.add("tcdnsipv6.myqcloud.com");
        arrayList.add("liteavapp.qcloud.com");
        arrayList.add("license.vod2.myqcloud.com");
        arrayList.add("license-test.vod2.myqcloud.com");
        arrayList.add("drm.vod2.myqcloud.com");
        arrayList.add("sdkconfig.tlivesource.com");
        arrayList.add("mlvbdc.live.tlivesource.com");
    }

    public static void applySniForHttpsConnection(HttpURLConnection httpURLConnection, final String str) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(new b(httpsURLConnection));
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() {
                public final boolean verify(String str, SSLSession sSLSession) {
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                }
            });
        }
    }

    public static HttpURLConnection createConnectionUseCustomHttpDNS(String str, String str2) throws Exception {
        String str3;
        String parseAddressUseCustomHttpDns = parseAddressUseCustomHttpDns(str2);
        if (TextUtils.isEmpty(parseAddressUseCustomHttpDns)) {
            return (HttpURLConnection) new URL(str).openConnection();
        }
        InetAddress byName = InetAddress.getByName(parseAddressUseCustomHttpDns);
        if (byName instanceof Inet4Address) {
            str3 = str.replaceFirst(str2, parseAddressUseCustomHttpDns);
        } else if (!(byName instanceof Inet6Address)) {
            return (HttpURLConnection) new URL(str).openConnection();
        } else {
            str3 = str.replaceFirst(str2, "[" + parseAddressUseCustomHttpDns + "]");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
        httpURLConnection.setRequestProperty("Host", str2);
        applySniForHttpsConnection(httpURLConnection, str2);
        LiteavLog.i(TAG, "create http conn use httpDns, original url: " + str + " , new url: " + str3);
        return httpURLConnection;
    }

    public static void enableCustomHttpDNS(boolean z11, a aVar) {
        synchronized (mLock) {
            mEnableCustomHttpDNS = z11;
            mCustomHttpDNSCallback = aVar;
        }
    }

    public static boolean isHostInWhiteList(String str) {
        return WHITE_LIST_HOST.contains(str);
    }

    public static boolean isIpAddress(String str) {
        if (str != null && !"".equals(str)) {
            if (sValidIPV4Pattern == null) {
                try {
                    sValidIPV4Pattern = Pattern.compile(sIPV4Regular, 2);
                } catch (Exception e11) {
                    LiteavLog.e(TAG, "Pattern.compile fail " + Log.getStackTraceString(e11));
                    return false;
                }
            }
            if (!sValidIPV4Pattern.matcher(str).matches() && !str.contains(":")) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static String parseAddressUseCustomHttpDns(String str) {
        if (!verifyCustomHttpDNS(str)) {
            return "";
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList();
        synchronized (mLock) {
            mCustomHttpDNSCallback.a(str, arrayList);
        }
        if (arrayList.size() <= 0) {
            return "";
        }
        String str2 = (String) arrayList.get(0);
        LiteavLog.i(TAG, "parse host: " + str + " and return ipAddress: " + str2 + " ,costTime: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        if (isHostInWhiteList(r5) == false) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        if (isIpAddress(r5) == false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        r5 = java.lang.System.getProperty("http.proxyHost");
        r0 = java.lang.System.getProperty("http.proxyPort");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r5 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        com.tencent.liteav.base.util.LiteavLog.w(TAG, "local proxy is on, don't use httpdns. proxyHost=" + r5 + " ,proxyPort=" + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean verifyCustomHttpDNS(java.lang.String r5) {
        /*
            java.lang.Object r0 = mLock
            monitor-enter(r0)
            boolean r1 = mEnableCustomHttpDNS     // Catch:{ all -> 0x004c }
            r2 = 0
            if (r1 == 0) goto L_0x004a
            com.tencent.liteav.base.util.HttpDnsUtil$a r1 = mCustomHttpDNSCallback     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x000d
            goto L_0x004a
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            boolean r0 = isHostInWhiteList(r5)
            if (r0 == 0) goto L_0x0015
            return r2
        L_0x0015:
            boolean r5 = isIpAddress(r5)
            if (r5 == 0) goto L_0x001c
            return r2
        L_0x001c:
            java.lang.String r5 = "http.proxyHost"
            java.lang.String r5 = java.lang.System.getProperty(r5)
            java.lang.String r0 = "http.proxyPort"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r5 == 0) goto L_0x0048
            if (r0 == 0) goto L_0x0048
            java.lang.String r1 = "HttpDnsUtil"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "local proxy is on, don't use httpdns. proxyHost="
            r3.<init>(r4)
            r3.append(r5)
            java.lang.String r5 = " ,proxyPort="
            r3.append(r5)
            r3.append(r0)
            java.lang.String r5 = r3.toString()
            com.tencent.liteav.base.util.LiteavLog.w(r1, r5)
            return r2
        L_0x0048:
            r5 = 1
            return r5
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return r2
        L_0x004c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.util.HttpDnsUtil.verifyCustomHttpDNS(java.lang.String):boolean");
    }
}
