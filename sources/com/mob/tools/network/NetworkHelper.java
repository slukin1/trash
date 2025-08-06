package com.mob.tools.network;

import android.content.Context;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.cdn.CDNDownload;
import com.luck.picture.lib.config.PictureMimeType;
import com.mob.commons.l;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.EverythingKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ReflectHelper;
import com.sumsub.sns.internal.core.analytics.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class NetworkHelper implements EverythingKeeper {
    public static int connectionTimeout = 0;
    private static boolean followRedirects = true;
    public static int readTimout;
    public boolean instanceFollowRedirects = followRedirects;

    public static class NetworkTimeOut implements PublicMemberKeeper {
        public int connectionTimeout;
        public int readTimout;
    }

    public static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private Object f27951a;

        /* renamed from: b  reason: collision with root package name */
        private String f27952b;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object invoke(java.lang.Object r10, java.lang.reflect.Method r11, java.lang.Object[] r12) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Class<java.lang.String> r10 = java.lang.String.class
                java.lang.String r11 = r11.getName()
                java.lang.String r0 = "018ejheSgjgf)i<fkGhgk1heflfihkJkh]fe"
                java.lang.String r0 = com.mob.commons.l.a((java.lang.String) r0)
                boolean r0 = r11.equals(r0)
                if (r0 == 0) goto L_0x0014
                goto L_0x015f
            L_0x0014:
                java.lang.String r0 = "018ejheCgjgnGhSflff'h$flheflfihkBkhRfe"
                java.lang.String r0 = com.mob.commons.l.a((java.lang.String) r0)
                boolean r0 = r11.equals(r0)
                r1 = 0
                if (r0 == 0) goto L_0x0119
                r11 = r12[r1]
                java.lang.Object[] r11 = (java.lang.Object[]) r11
                r0 = 1
                r12 = r12[r0]
                java.lang.String r12 = (java.lang.String) r12
                if (r11 == 0) goto L_0x0111
                int r2 = r11.length
                if (r2 != r0) goto L_0x0057
                r10 = r11[r1]     // Catch:{ all -> 0x004d }
                java.lang.Class r10 = r10.getClass()     // Catch:{ all -> 0x004d }
                java.lang.String r12 = "013ejheEgjimHfi)fkfefk=k+ge"
                java.lang.String r12 = com.mob.commons.l.a((java.lang.String) r12)     // Catch:{ all -> 0x004d }
                java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ all -> 0x004d }
                java.lang.reflect.Method r10 = r10.getDeclaredMethod(r12, r2)     // Catch:{ all -> 0x004d }
                r10.setAccessible(r0)     // Catch:{ all -> 0x004d }
                r11 = r11[r1]     // Catch:{ all -> 0x004d }
                java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ all -> 0x004d }
                r10.invoke(r11, r12)     // Catch:{ all -> 0x004d }
                goto L_0x015f
            L_0x004d:
                r10 = move-exception
                com.mob.tools.log.NLog r11 = com.mob.tools.MobLog.getInstance()
                r11.e((java.lang.Throwable) r10)
                goto L_0x015f
            L_0x0057:
                java.lang.Object r2 = r9.f27951a
                if (r2 == 0) goto L_0x0109
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 17
                r4 = 2
                if (r2 < r3) goto L_0x00c9
                java.lang.String r2 = "030:jiFf ffZfLgkfnQghk:fnhkhk>i9fniijkhjjlheflfihkZkYje-fgfLglWhYfl"
                java.lang.String r2 = com.mob.commons.l.a((java.lang.String) r2)     // Catch:{ all -> 0x00bf }
                java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x00bf }
                java.lang.String r3 = "android.net.http.X509TrustManagerExtensions"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x00bf }
                java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x00bf }
                r5[r1] = r2     // Catch:{ all -> 0x00bf }
                java.lang.reflect.Constructor r2 = r3.getConstructor(r5)     // Catch:{ all -> 0x00bf }
                java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ all -> 0x00bf }
                java.lang.Object r5 = r9.f27951a     // Catch:{ all -> 0x00bf }
                r3[r1] = r5     // Catch:{ all -> 0x00bf }
                java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ all -> 0x00bf }
                java.lang.String r3 = "0345ji0fMff)fHfnhk+heLfiflfk.kDgefnKehXfl8kWfniijkhjjlgf.h.fl[k'fkghfk.efkh"
                java.lang.String r3 = com.mob.commons.l.a((java.lang.String) r3)     // Catch:{ all -> 0x00bf }
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x00bf }
                java.lang.Object r3 = java.lang.reflect.Array.newInstance(r3, r1)     // Catch:{ all -> 0x00bf }
                java.lang.Class r5 = r2.getClass()     // Catch:{ all -> 0x00bf }
                java.lang.String r6 = "018ejheEgjgn-hFflff$h@flheflfihkGkh@fe"
                java.lang.String r6 = com.mob.commons.l.a((java.lang.String) r6)     // Catch:{ all -> 0x00bf }
                r7 = 3
                java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ all -> 0x00bf }
                java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x00bf }
                r8[r1] = r3     // Catch:{ all -> 0x00bf }
                r8[r0] = r10     // Catch:{ all -> 0x00bf }
                r8[r4] = r10     // Catch:{ all -> 0x00bf }
                java.lang.reflect.Method r10 = r5.getDeclaredMethod(r6, r8)     // Catch:{ all -> 0x00bf }
                r10.setAccessible(r0)     // Catch:{ all -> 0x00bf }
                java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch:{ all -> 0x00bf }
                r3[r1] = r11     // Catch:{ all -> 0x00bf }
                r3[r0] = r12     // Catch:{ all -> 0x00bf }
                java.lang.String r11 = r9.f27952b     // Catch:{ all -> 0x00bf }
                r3[r4] = r11     // Catch:{ all -> 0x00bf }
                r10.invoke(r2, r3)     // Catch:{ all -> 0x00bf }
                goto L_0x015f
            L_0x00bf:
                r10 = move-exception
                com.mob.tools.log.NLog r11 = com.mob.tools.MobLog.getInstance()
                r11.e((java.lang.Throwable) r10)
                goto L_0x015f
            L_0x00c9:
                java.lang.String r2 = "034[ji)fOff.f;fnhkThe)fiflfk7k3gefnQeh>fl7kEfniijkhjjlgf!hNfl+k0fkghfk.efkh"
                java.lang.String r2 = com.mob.commons.l.a((java.lang.String) r2)     // Catch:{ all -> 0x0100 }
                java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0100 }
                java.lang.Object r2 = java.lang.reflect.Array.newInstance(r2, r1)     // Catch:{ all -> 0x0100 }
                java.lang.Object r3 = r9.f27951a     // Catch:{ all -> 0x0100 }
                java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x0100 }
                java.lang.String r5 = "018ejheCgjgn4h_flffPh[flheflfihk[khMfe"
                java.lang.String r5 = com.mob.commons.l.a((java.lang.String) r5)     // Catch:{ all -> 0x0100 }
                java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ all -> 0x0100 }
                java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x0100 }
                r6[r1] = r2     // Catch:{ all -> 0x0100 }
                r6[r0] = r10     // Catch:{ all -> 0x0100 }
                java.lang.reflect.Method r10 = r3.getDeclaredMethod(r5, r6)     // Catch:{ all -> 0x0100 }
                r10.setAccessible(r0)     // Catch:{ all -> 0x0100 }
                java.lang.Object r2 = r9.f27951a     // Catch:{ all -> 0x0100 }
                java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x0100 }
                r3[r1] = r11     // Catch:{ all -> 0x0100 }
                r3[r0] = r12     // Catch:{ all -> 0x0100 }
                r10.invoke(r2, r3)     // Catch:{ all -> 0x0100 }
                goto L_0x015f
            L_0x0100:
                r10 = move-exception
                com.mob.tools.log.NLog r11 = com.mob.tools.MobLog.getInstance()
                r11.e((java.lang.Throwable) r10)
                goto L_0x015f
            L_0x0109:
                java.security.cert.CertificateException r10 = new java.security.cert.CertificateException
                java.lang.String r11 = "there were one more certificates but no trust manager found."
                r10.<init>(r11)
                throw r10
            L_0x0111:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                java.lang.String r11 = "there were no certificates."
                r10.<init>(r11)
                throw r10
            L_0x0119:
                java.lang.String r10 = "018%glThk?hf>eehlkhTfegghkhkfi(h7flhk"
                java.lang.String r10 = com.mob.commons.l.a((java.lang.String) r10)
                boolean r10 = r11.equals(r10)
                if (r10 == 0) goto L_0x013d
                java.lang.String r10 = "0344jiCfYffJf,fnhkShe4fiflfkJkYgefnIeh flFk=fniijkhjjlgf;h.fl(k4fkghfk9efkh"
                java.lang.String r10 = com.mob.commons.l.a((java.lang.String) r10)     // Catch:{ all -> 0x0134 }
                java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x0134 }
                java.lang.Object r10 = java.lang.reflect.Array.newInstance(r10, r1)     // Catch:{ all -> 0x0134 }
                return r10
            L_0x0134:
                r10 = move-exception
                com.mob.tools.log.NLog r11 = com.mob.tools.MobLog.getInstance()
                r11.e((java.lang.Throwable) r10)
                goto L_0x015f
            L_0x013d:
                java.lang.String r10 = "008jfBhkHjJgffmfe;h"
                java.lang.String r10 = com.mob.commons.l.a((java.lang.String) r10)
                boolean r10 = r11.equals(r10)
                if (r10 == 0) goto L_0x0152
                int r10 = r9.hashCode()
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
                return r10
            L_0x0152:
                java.lang.String r10 = "toString"
                boolean r10 = r11.equals(r10)
                if (r10 == 0) goto L_0x015f
                java.lang.String r10 = r9.toString()
                return r10
            L_0x015f:
                r10 = 0
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.a.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }

        private a(String str) {
            try {
                this.f27952b = str;
                Method declaredMethod = Class.forName(l.a("033-jiGf1ff;fTgkfn_ghk3fnhkhk'i[fnheflfihk3k3je4fgf=gl,hZflieXfek;fmflge")).getDeclaredMethod(l.a("011Ggl$hkPgg5gDhk^kfgeh"), new Class[]{String.class});
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke((Object) null, new Object[]{l.a("0047iijkhjjl")});
                Class<?> cls = Class.forName(l.a("022ZjiJfIff+f9fnhkOheLfiflfk9k5gefnkeHh(gegn(kHfmfl'h"));
                Method method = invoke.getClass().getMethod(l.a("004;fkTg5fkSk"), new Class[]{cls});
                method.setAccessible(true);
                method.invoke(invoke, new Object[]{null});
                Method method2 = invoke.getClass().getMethod(l.a("016OglNhk)heflfihkJk9je?fgf]glEhYflhk"), new Class[0]);
                method2.setAccessible(true);
                Object[] objArr = (Object[]) method2.invoke(invoke, new Object[0]);
                if (objArr == null || objArr.length == 0) {
                    throw new NoSuchAlgorithmException("no trust manager found.");
                }
                this.f27951a = objArr[0];
            } catch (Exception e11) {
                NLog instance = MobLog.getInstance();
                instance.d("failed to initialize the standard trust manager: " + e11.getMessage(), new Object[0]);
                this.f27951a = null;
            }
        }
    }

    @Deprecated
    public static String checkHttpRequestUrl(String str) {
        return NetCommunicator.checkHttpRequestUrl(str);
    }

    private HttpURLConnection getConnection(String str, NetworkTimeOut networkTimeOut) throws Throwable {
        Object obj;
        boolean z11;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        String a11 = l.a("012Jfh'hkjNfmfehefmgjThgNhk");
        try {
            obj = ReflectHelper.getInstanceField(httpURLConnection, a11);
        } catch (Throwable unused) {
            obj = null;
        }
        if (obj == null) {
            a11 = "PERMITTED_USER_METHODS";
            try {
                obj = ReflectHelper.getStaticField("HttpURLConnection", a11);
            } catch (Throwable unused2) {
            }
            z11 = true;
        } else {
            z11 = false;
        }
        if (obj != null) {
            String[] strArr = (String[]) obj;
            String[] strArr2 = new String[(strArr.length + 1)];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[strArr.length] = l.a("005(inhfhegfhm");
            if (z11) {
                ReflectHelper.setStaticField("HttpURLConnection", a11, strArr2);
            } else {
                ReflectHelper.setInstanceField(httpURLConnection, a11, strArr2);
            }
        }
        System.setProperty("http.keepAlive", d.f31895b);
        if (httpURLConnection instanceof HttpsURLConnection) {
            X509HostnameVerifier x509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SSLContext instance = SSLContext.getInstance(l.a("0036hehggn"));
            TrustManager[] trustManagerArr = new TrustManager[0];
            try {
                trustManagerArr = new TrustManager[]{(TrustManager) getTrustManager(httpsURLConnection.getURL().getHost())};
            } catch (Throwable th2) {
                MobLog.getInstance().e(th2);
            }
            instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(x509HostnameVerifier);
        }
        int i11 = networkTimeOut == null ? connectionTimeout : networkTimeOut.connectionTimeout;
        if (i11 > 0) {
            httpURLConnection.setConnectTimeout(i11);
        }
        int i12 = networkTimeOut == null ? readTimout : networkTimeOut.readTimout;
        if (i12 > 0) {
            httpURLConnection.setReadTimeout(i12);
        }
        return httpURLConnection;
    }

    @Deprecated
    private HTTPPart getDataPostHttpPart(HttpURLConnection httpURLConnection, String str, byte[] bArr) throws Throwable {
        ByteArrayPart byteArrayPart = new ByteArrayPart();
        byteArrayPart.append(bArr);
        return byteArrayPart;
    }

    @Deprecated
    private HTTPPart getFilePostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2) throws Throwable {
        String uuid = UUID.randomUUID().toString();
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
        MultiPart multiPart = new MultiPart();
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            Iterator<KVPair<String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                KVPair next = it2.next();
                stringPart.append("--").append(uuid).append(LogUtils.NEW_LINE);
                stringPart.append("Content-Disposition: form-data; name=\"").append(next.name).append("\"\r\n\r\n");
                stringPart.append((String) next.value).append(LogUtils.NEW_LINE);
            }
        }
        multiPart.append(stringPart);
        Iterator<KVPair<String>> it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            KVPair next2 = it3.next();
            StringPart stringPart2 = new StringPart();
            File file = new File((String) next2.value);
            stringPart2.append("--").append(uuid).append(LogUtils.NEW_LINE);
            stringPart2.append("Content-Disposition: form-data; name=\"").append(next2.name).append("\"; filename=\"").append(file.getName()).append("\"\r\n");
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor((String) next2.value);
            if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                if (((String) next2.value).toLowerCase().endsWith("jpg") || ((String) next2.value).toLowerCase().endsWith("jpeg")) {
                    contentTypeFor = "image/jpeg";
                } else if (((String) next2.value).toLowerCase().endsWith("png")) {
                    contentTypeFor = PictureMimeType.PNG_Q;
                } else if (((String) next2.value).toLowerCase().endsWith("gif")) {
                    contentTypeFor = "image/gif";
                } else {
                    FileInputStream fileInputStream = null;
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream((String) next2.value);
                        try {
                            contentTypeFor = URLConnection.guessContentTypeFromStream(fileInputStream2);
                            v.a(fileInputStream2);
                            if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                                contentTypeFor = "application/octet-stream";
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            v.a(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        v.a(fileInputStream);
                        throw th;
                    }
                }
            }
            stringPart2.append("Content-Type: ").append(contentTypeFor).append("\r\n\r\n");
            multiPart.append(stringPart2);
            FilePart filePart = new FilePart();
            filePart.setFile((String) next2.value);
            multiPart.append(filePart);
            StringPart stringPart3 = new StringPart();
            stringPart3.append(LogUtils.NEW_LINE);
            multiPart.append(stringPart3);
        }
        StringPart stringPart4 = new StringPart();
        stringPart4.append("--").append(uuid).append("--\r\n");
        multiPart.append(stringPart4);
        return multiPart;
    }

    @Deprecated
    private HTTPPart getTextPostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList) throws Throwable {
        httpURLConnection.setRequestProperty("Content-Type", l.a("033flliVfkAefkUfkfmAgn=gkjmhihihijmghfmflfhjmfiflHihge8fmfe6h,fe"));
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            stringPart.append(requestParamsToUrl(kvPairsToObjHashMap(arrayList)));
        }
        return stringPart;
    }

    public static Object getTrustManager(String str) throws Throwable {
        Class<?> cls = Class.forName(l.a("030IjiXf9ffUf.gkfnFghk<fnhkhkVi7fniijkhjjlheflfihkBk,jeWfgf glEh$fl"));
        a aVar = new a(str);
        return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{cls}, aVar);
    }

    private static boolean isRedirects(HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection.getResponseCode() == 301 || httpURLConnection.getResponseCode() == 302 || httpURLConnection.getResponseCode() == 304 || httpURLConnection.getResponseCode() == 307 || httpURLConnection.getResponseCode() == 308) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return false;
        }
    }

    @Deprecated
    private HashMap<String, Object> kvPairsToObjHashMap(ArrayList<KVPair<String>> arrayList) throws Throwable {
        if (arrayList == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<KVPair<String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            KVPair next = it2.next();
            hashMap.put(next.name, next.value);
        }
        return hashMap;
    }

    @Deprecated
    private HashMap<String, String> kvPairsToStrHashMap(ArrayList<KVPair<String>> arrayList) throws Throwable {
        if (arrayList == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<KVPair<String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            KVPair next = it2.next();
            hashMap.put(next.name, next.value);
        }
        return hashMap;
    }

    private String requestParamsToUrl(HashMap<String, Object> hashMap) throws Throwable {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : hashMap.entrySet()) {
            String urlEncode = Data.urlEncode((String) next.getKey(), "utf-8");
            String urlEncode2 = next.getValue() == null ? "" : Data.urlEncode(String.valueOf(next.getValue()), "utf-8");
            if (sb2.length() > 0) {
                sb2.append('&');
            }
            sb2.append(urlEncode);
            sb2.append('=');
            sb2.append(urlEncode2);
        }
        return sb2.toString();
    }

    private void setHeader(URLConnection uRLConnection, HashMap<String, String> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry next : hashMap.entrySet()) {
                uRLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public void download(String str, final OutputStream outputStream, NetworkTimeOut networkTimeOut) throws Throwable {
        final byte[] bArr = new byte[1024];
        rawGet(str, (RawNetworkCallback) new RawNetworkCallback() {
            public void onResponse(InputStream inputStream) throws Throwable {
                int read = inputStream.read(bArr);
                while (read != -1) {
                    outputStream.write(bArr, 0, read);
                    read = inputStream.read(bArr);
                }
            }
        }, networkTimeOut);
        outputStream.flush();
    }

    public String downloadCache(Context context, String str, String str2, boolean z11, NetworkTimeOut networkTimeOut) throws Throwable {
        return downloadCache(context, str, str2, z11, networkTimeOut, (FileDownloadListener) null);
    }

    @Deprecated
    public String httpGet(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        return httpGetNew(str, kvPairsToObjHashMap(arrayList), kvPairsToStrHashMap(arrayList2), networkTimeOut);
    }

    public String httpGetNew(String str, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2, NetworkTimeOut networkTimeOut) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2;
        MobLog.getInstance().d(String.format("hgt: %s", new Object[]{str}) + "\n" + String.format("hd: %s", new Object[]{hashMap2}), new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (hashMap != null) {
            String requestParamsToUrl = requestParamsToUrl(hashMap);
            if (requestParamsToUrl.length() > 0) {
                str = str + "?" + requestParamsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        setHeader(connection, hashMap2);
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        int responseCode = connection.getResponseCode();
        BufferedReader bufferedReader3 = null;
        if (responseCode == 200) {
            StringBuilder sb2 = new StringBuilder();
            try {
                inputStreamReader2 = new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8"));
                try {
                    bufferedReader2 = new BufferedReader(inputStreamReader2);
                } catch (Throwable th2) {
                    th = th2;
                    v.a(bufferedReader3, inputStreamReader2);
                    throw th;
                }
                try {
                    for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                        if (sb2.length() > 0) {
                            sb2.append(10);
                        }
                        sb2.append(readLine);
                    }
                    v.a(bufferedReader2, inputStreamReader2);
                    connection.disconnect();
                    String sb3 = sb2.toString();
                    MobLog.getInstance().d("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                    return sb3;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader3 = bufferedReader2;
                    v.a(bufferedReader3, inputStreamReader2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader2 = null;
                v.a(bufferedReader3, inputStreamReader2);
                throw th;
            }
        } else {
            StringBuilder sb4 = new StringBuilder();
            try {
                inputStreamReader = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Throwable th5) {
                    th = th5;
                    v.a(bufferedReader3, inputStreamReader);
                    throw th;
                }
                try {
                    for (String readLine2 = bufferedReader.readLine(); readLine2 != null; readLine2 = bufferedReader.readLine()) {
                        if (sb4.length() > 0) {
                            sb4.append(10);
                        }
                        sb4.append(readLine2);
                    }
                    v.a(bufferedReader, inputStreamReader);
                    connection.disconnect();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(l.a("005h-flflfmfl"), sb4.toString());
                    hashMap3.put(l.a("006ShkCkfkLfihk"), Integer.valueOf(responseCode));
                    throw new Throwable(HashonHelper.fromHashMap(hashMap3));
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader3 = bufferedReader;
                    v.a(bufferedReader3, inputStreamReader);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                inputStreamReader = null;
                v.a(bufferedReader3, inputStreamReader);
                throw th;
            }
        }
    }

    @Deprecated
    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        return httpPostNew(str, kvPairsToObjHashMap(arrayList), kvPairsToStrHashMap(arrayList2), networkTimeOut);
    }

    @Deprecated
    public String httpPostFiles(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i11, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap hashMap = new HashMap();
        httpPost(str, arrayList, arrayList2, arrayList3, i11, (HttpResponseCallback) new HttpResponseCallback() {
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                BufferedReader bufferedReader;
                InputStreamReader inputStreamReader2;
                int responseCode = httpConnection.getResponseCode();
                BufferedReader bufferedReader2 = null;
                if (responseCode == 200 || responseCode < 300) {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                        } catch (Throwable th2) {
                            th = th2;
                            v.a(bufferedReader2, inputStreamReader);
                            throw th;
                        }
                        try {
                            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                                if (sb2.length() > 0) {
                                    sb2.append(10);
                                }
                                sb2.append(readLine);
                            }
                            v.a(bufferedReader, inputStreamReader);
                            hashMap.put("resp", sb2.toString());
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader2 = bufferedReader;
                            v.a(bufferedReader2, inputStreamReader);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamReader = null;
                        v.a(bufferedReader2, inputStreamReader);
                        throw th;
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    try {
                        inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                            try {
                                for (String readLine2 = bufferedReader3.readLine(); readLine2 != null; readLine2 = bufferedReader3.readLine()) {
                                    if (sb3.length() > 0) {
                                        sb3.append(10);
                                    }
                                    sb3.append(readLine2);
                                }
                                v.a(bufferedReader3, inputStreamReader2);
                                HashMap hashMap = new HashMap();
                                hashMap.put(l.a("005hGflflfmfl"), sb3.toString());
                                hashMap.put(l.a("006Zhk;kfk(fihk"), Integer.valueOf(responseCode));
                                new HashonHelper();
                                throw new Throwable(HashonHelper.fromHashMap(hashMap));
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader2 = bufferedReader3;
                                v.a(bufferedReader2, inputStreamReader2);
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            v.a(bufferedReader2, inputStreamReader2);
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        inputStreamReader2 = null;
                        v.a(bufferedReader2, inputStreamReader2);
                        throw th;
                    }
                }
            }
        }, networkTimeOut);
        return (String) hashMap.get("resp");
    }

    @Deprecated
    public String httpPostFilesChecked(String str, ArrayList<KVPair<String>> arrayList, byte[] bArr, ArrayList<KVPair<String>> arrayList2, int i11, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap hashMap = new HashMap();
        httpPost(str, arrayList, bArr, arrayList2, i11, (HttpResponseCallback) new HttpResponseCallback() {
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                BufferedReader bufferedReader;
                InputStreamReader inputStreamReader2;
                int responseCode = httpConnection.getResponseCode();
                BufferedReader bufferedReader2 = null;
                if (responseCode == 200 || responseCode < 300) {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                        } catch (Throwable th2) {
                            th = th2;
                            v.a(bufferedReader2, inputStreamReader);
                            throw th;
                        }
                        try {
                            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                                if (sb2.length() > 0) {
                                    sb2.append(10);
                                }
                                sb2.append(readLine);
                            }
                            v.a(bufferedReader, inputStreamReader);
                            hashMap.put("resp", sb2.toString());
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader2 = bufferedReader;
                            v.a(bufferedReader2, inputStreamReader);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamReader = null;
                        v.a(bufferedReader2, inputStreamReader);
                        throw th;
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    try {
                        inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                            try {
                                for (String readLine2 = bufferedReader3.readLine(); readLine2 != null; readLine2 = bufferedReader3.readLine()) {
                                    if (sb3.length() > 0) {
                                        sb3.append(10);
                                    }
                                    sb3.append(readLine2);
                                }
                                v.a(bufferedReader3, inputStreamReader2);
                                HashMap hashMap = new HashMap();
                                hashMap.put(l.a("005hYflflfmfl"), sb3.toString());
                                hashMap.put(l.a("006^hk8kfk?fihk"), Integer.valueOf(responseCode));
                                new HashonHelper();
                                throw new Throwable(HashonHelper.fromHashMap(hashMap));
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader2 = bufferedReader3;
                                v.a(bufferedReader2, inputStreamReader2);
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            v.a(bufferedReader2, inputStreamReader2);
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        inputStreamReader2 = null;
                        v.a(bufferedReader2, inputStreamReader2);
                        throw th;
                    }
                }
            }
        }, networkTimeOut);
        return (String) hashMap.get("resp");
    }

    public String httpPostNew(String str, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2, NetworkTimeOut networkTimeOut) throws Throwable {
        OutputStream outputStream;
        InputStream inputStream;
        Throwable th2;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2;
        String str2 = str;
        HashMap<String, Object> hashMap3 = hashMap;
        HashMap<String, String> hashMap4 = hashMap2;
        long currentTimeMillis = System.currentTimeMillis();
        NLog instance = MobLog.getInstance();
        instance.d("hpt: " + str2 + "\nhd: " + hashMap4, new Object[0]);
        HttpURLConnection connection = getConnection(str2, networkTimeOut);
        connection.setDoOutput(true);
        setHeader(connection, hashMap4);
        connection.setRequestProperty(l.a("010HgffmKgghek4fkfmBg"), "Keep-Alive");
        connection.setRequestProperty("Content-Type", l.a("033flliGfk3efkPfkfm1gn_gkjmhihihijmghfmflfhjmfifl2ihge]fmfeEhEfe"));
        StringPart stringPart = new StringPart();
        if (hashMap3 != null) {
            stringPart.append(requestParamsToUrl(hashMap3));
        }
        connection.setFixedLengthStreamingMode((int) stringPart.b());
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        try {
            outputStream = connection.getOutputStream();
            try {
                InputStream inputStream2 = stringPart.toInputStream();
                try {
                    byte[] bArr = new byte[65536];
                    for (int read = inputStream2.read(bArr); read > 0; read = inputStream2.read(bArr)) {
                        outputStream.write(bArr, 0, read);
                    }
                    outputStream.flush();
                    int responseCode = connection.getResponseCode();
                    if (responseCode == 200 || responseCode < 300) {
                        StringBuilder sb2 = new StringBuilder();
                        try {
                            InputStreamReader inputStreamReader3 = new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8"));
                            try {
                                BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader3);
                                try {
                                    for (String readLine = bufferedReader3.readLine(); readLine != null; readLine = bufferedReader3.readLine()) {
                                        if (sb2.length() > 0) {
                                            sb2.append(10);
                                        }
                                        sb2.append(readLine);
                                    }
                                    v.a(bufferedReader3, inputStreamReader3);
                                    String sb3 = sb2.toString();
                                    connection.disconnect();
                                    v.a(inputStream2, outputStream);
                                    NLog instance2 = MobLog.getInstance();
                                    instance2.d("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                                    return sb3;
                                } catch (Throwable th3) {
                                    BufferedReader bufferedReader4 = bufferedReader3;
                                    th2 = th3;
                                    inputStreamReader = inputStreamReader3;
                                    bufferedReader = bufferedReader4;
                                    v.a(bufferedReader, inputStreamReader);
                                    throw th2;
                                }
                            } catch (Throwable th4) {
                                th2 = th4;
                                inputStreamReader = inputStreamReader3;
                                bufferedReader = null;
                                v.a(bufferedReader, inputStreamReader);
                                throw th2;
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                            inputStreamReader = null;
                            bufferedReader = null;
                            v.a(bufferedReader, inputStreamReader);
                            throw th2;
                        }
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        try {
                            inputStreamReader2 = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                            try {
                                bufferedReader2 = new BufferedReader(inputStreamReader2);
                                for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
                                    if (sb4.length() > 0) {
                                        sb4.append(10);
                                    }
                                    sb4.append(readLine2);
                                }
                                v.a(bufferedReader2, inputStreamReader2);
                                HashMap hashMap5 = new HashMap();
                                hashMap5.put(l.a("005hFflflfmfl"), sb4.toString());
                                hashMap5.put(l.a("006AhkNkfk)fihk"), Integer.valueOf(responseCode));
                                throw new Throwable(HashonHelper.fromHashMap(hashMap5));
                            } catch (Throwable th6) {
                                th = th6;
                                bufferedReader2 = null;
                                v.a(bufferedReader2, inputStreamReader2);
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            bufferedReader2 = null;
                            inputStreamReader2 = null;
                            v.a(bufferedReader2, inputStreamReader2);
                            throw th;
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    inputStream = inputStream2;
                    connection.disconnect();
                    v.a(inputStream, outputStream);
                    NLog instance3 = MobLog.getInstance();
                    instance3.d("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                inputStream = null;
                connection.disconnect();
                v.a(inputStream, outputStream);
                NLog instance32 = MobLog.getInstance();
                instance32.d("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                throw th;
            }
        } catch (Throwable th10) {
            th = th10;
            inputStream = null;
            outputStream = null;
            connection.disconnect();
            v.a(inputStream, outputStream);
            NLog instance322 = MobLog.getInstance();
            instance322.d("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b3, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r6.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b7, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void httpPostWithBytes(java.lang.String r18, byte[] r19, java.util.HashMap<java.lang.String, java.lang.String> r20, int r21, com.mob.tools.network.HttpResponseCallback r22, com.mob.tools.network.NetworkHelper.NetworkTimeOut r23) throws java.lang.Throwable {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r22
            java.lang.String r3 = "use time: "
            long r4 = java.lang.System.currentTimeMillis()
            com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "hpt: "
            r7.append(r8)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r8 = 0
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r6.d(r7, r9)
            r6 = r23
            java.net.HttpURLConnection r6 = r1.getConnection(r0, r6)
            r7 = 1
            r6.setDoOutput(r7)
            if (r21 < 0) goto L_0x0036
            r6.setChunkedStreamingMode(r8)
        L_0x0036:
            r0 = r20
            r1.setHeader(r6, r0)
            java.lang.String r0 = "010Dgffm!gghekTfkfm_g"
            java.lang.String r0 = com.mob.commons.l.a((java.lang.String) r0)
            java.lang.String r9 = "Keep-Alive"
            r6.setRequestProperty(r0, r9)
            java.lang.String r0 = "Content-Type"
            java.lang.String r9 = "application/octet-stream"
            r6.setRequestProperty(r0, r9)
            boolean r0 = r1.instanceFollowRedirects
            r6.setInstanceFollowRedirects(r0)
            r6.connect()
            r10 = 2
            r11 = 4
            java.io.OutputStream r13 = r6.getOutputStream()     // Catch:{ all -> 0x00f5 }
            java.lang.String r0 = com.mob.commons.u.a()     // Catch:{ all -> 0x00f2 }
            if (r0 != 0) goto L_0x0063
            java.lang.String r0 = ""
        L_0x0063:
            java.lang.String r14 = "utf-8"
            byte[] r0 = r0.getBytes(r14)     // Catch:{ all -> 0x00f2 }
            java.io.ByteArrayOutputStream r14 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00f2 }
            r14.<init>()     // Catch:{ all -> 0x00f2 }
            java.io.DataOutputStream r15 = new java.io.DataOutputStream     // Catch:{ all -> 0x00ef }
            r15.<init>(r14)     // Catch:{ all -> 0x00ef }
            int r12 = r0.length     // Catch:{ all -> 0x00ec }
            r15.writeInt(r12)     // Catch:{ all -> 0x00ec }
            r15.write(r0)     // Catch:{ all -> 0x00ec }
            r0 = r19
            r15.write(r0)     // Catch:{ all -> 0x00ec }
            r15.flush()     // Catch:{ all -> 0x00ec }
            byte[] r0 = r14.toByteArray()     // Catch:{ all -> 0x00ec }
            java.io.ByteArrayInputStream r12 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x00ec }
            r12.<init>(r0)     // Catch:{ all -> 0x00ec }
            r0 = 65536(0x10000, float:9.18355E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00ea }
            int r16 = r12.read(r0)     // Catch:{ all -> 0x00ea }
            r9 = r16
        L_0x0095:
            if (r9 <= 0) goto L_0x009f
            r13.write(r0, r8, r9)     // Catch:{ all -> 0x00ea }
            int r9 = r12.read(r0)     // Catch:{ all -> 0x00ea }
            goto L_0x0095
        L_0x009f:
            r13.flush()     // Catch:{ all -> 0x00ea }
            if (r2 == 0) goto L_0x00b8
            com.mob.tools.network.HttpConnectionImpl23 r0 = new com.mob.tools.network.HttpConnectionImpl23     // Catch:{ all -> 0x00b0 }
            r0.<init>(r6)     // Catch:{ all -> 0x00b0 }
            r2.onResponse(r0)     // Catch:{ all -> 0x00b0 }
            r6.disconnect()     // Catch:{ all -> 0x00ea }
            goto L_0x00bb
        L_0x00b0:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            r0 = move-exception
            r2 = r0
            r6.disconnect()     // Catch:{ all -> 0x00ea }
            throw r2     // Catch:{ all -> 0x00ea }
        L_0x00b8:
            r6.disconnect()     // Catch:{ all -> 0x00ea }
        L_0x00bb:
            r6.disconnect()
            java.io.Closeable[] r0 = new java.io.Closeable[r11]
            r0[r8] = r12
            r0[r7] = r13
            r0[r10] = r15
            r2 = 3
            r0[r2] = r14
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r4
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r8]
            r0.d(r2, r3)
            return
        L_0x00ea:
            r0 = move-exception
            goto L_0x00fa
        L_0x00ec:
            r0 = move-exception
            r12 = 0
            goto L_0x00fa
        L_0x00ef:
            r0 = move-exception
            r12 = 0
            goto L_0x00f9
        L_0x00f2:
            r0 = move-exception
            r12 = 0
            goto L_0x00f8
        L_0x00f5:
            r0 = move-exception
            r12 = 0
            r13 = 0
        L_0x00f8:
            r14 = 0
        L_0x00f9:
            r15 = 0
        L_0x00fa:
            r6.disconnect()
            java.io.Closeable[] r2 = new java.io.Closeable[r11]
            r2[r8] = r12
            r2[r7] = r13
            r2[r10] = r15
            r6 = 3
            r2[r6] = r14
            com.mob.commons.v.a((java.io.Closeable[]) r2)
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r3)
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r4
            r6.append(r9)
            java.lang.String r3 = r6.toString()
            java.lang.Object[] r4 = new java.lang.Object[r8]
            r2.d(r3, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.httpPostWithBytes(java.lang.String, byte[], java.util.HashMap, int, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    @Deprecated
    public String httpPut(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        return httpPut(str, kvPairsToObjHashMap(arrayList), kVPair, arrayList2, networkTimeOut, (OnReadListener) null);
    }

    @Deprecated
    public String jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap hashMap = new HashMap();
        jsonPost(str, arrayList, arrayList2, networkTimeOut, (HttpResponseCallback) new HttpResponseCallback() {
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                BufferedReader bufferedReader;
                InputStreamReader inputStreamReader2;
                int responseCode = httpConnection.getResponseCode();
                BufferedReader bufferedReader2 = null;
                if (responseCode == 200 || responseCode == 201) {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                        } catch (Throwable th2) {
                            th = th2;
                            v.a(bufferedReader2, inputStreamReader);
                            throw th;
                        }
                        try {
                            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                                if (sb2.length() > 0) {
                                    sb2.append(10);
                                }
                                sb2.append(readLine);
                            }
                            v.a(bufferedReader, inputStreamReader);
                            hashMap.put(l.a("003LflVhXhk"), sb2.toString());
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader2 = bufferedReader;
                            v.a(bufferedReader2, inputStreamReader);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamReader = null;
                        v.a(bufferedReader2, inputStreamReader);
                        throw th;
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    try {
                        inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                            try {
                                for (String readLine2 = bufferedReader3.readLine(); readLine2 != null; readLine2 = bufferedReader3.readLine()) {
                                    if (sb3.length() > 0) {
                                        sb3.append(10);
                                    }
                                    sb3.append(readLine2);
                                }
                                v.a(bufferedReader3, inputStreamReader2);
                                HashMap hashMap = new HashMap();
                                hashMap.put(l.a("005h)flflfmfl"), sb3.toString());
                                hashMap.put(l.a("006.hk7kfkHfihk"), Integer.valueOf(responseCode));
                                new HashonHelper();
                                throw new Throwable(HashonHelper.fromHashMap(hashMap));
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader2 = bufferedReader3;
                                v.a(bufferedReader2, inputStreamReader2);
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            v.a(bufferedReader2, inputStreamReader2);
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        inputStreamReader2 = null;
                        v.a(bufferedReader2, inputStreamReader2);
                        throw th;
                    }
                }
            }
        });
        if (hashMap.containsKey(l.a("003Lfl*h.hk"))) {
            return (String) hashMap.get(l.a("003]fl5hShk"));
        }
        return null;
    }

    @Deprecated
    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, kvPairsToStrHashMap(arrayList), rawNetworkCallback, networkTimeOut);
    }

    @Deprecated
    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawPost(str, arrayList, hTTPPart, 0, httpResponseCallback, networkTimeOut);
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String downloadCache(android.content.Context r20, java.lang.String r21, java.lang.String r22, boolean r23, com.mob.tools.network.NetworkHelper.NetworkTimeOut r24, com.mob.tools.network.FileDownloadListener r25) throws java.lang.Throwable {
        /*
            r19 = this;
            r8 = r19
            r0 = r20
            r1 = r21
            r4 = r22
            long r6 = java.lang.System.currentTimeMillis()
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "downloading: "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            r2.i((java.lang.String) r3)
            java.lang.String r9 = "use time: "
            if (r23 == 0) goto L_0x0074
            java.lang.String r2 = com.mob.tools.utils.ResHelper.getCachePath(r0, r4)
            java.lang.String r3 = com.mob.tools.utils.Data.MD5((java.lang.String) r21)
            java.io.File r5 = new java.io.File
            r5.<init>(r2, r3)
            if (r23 == 0) goto L_0x0074
            boolean r2 = r5.exists()
            if (r2 == 0) goto L_0x0074
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r6
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.i((java.lang.String) r1)
            if (r25 == 0) goto L_0x006f
            r0 = 100
            long r1 = r5.length()
            long r3 = r5.length()
            r20 = r25
            r21 = r0
            r22 = r1
            r24 = r3
            r20.onProgress(r21, r22, r24)
        L_0x006f:
            java.lang.String r0 = r5.getAbsolutePath()
            return r0
        L_0x0074:
            r10 = r24
            java.net.HttpURLConnection r11 = r8.getConnection(r1, r10)
            boolean r2 = r8.instanceFollowRedirects
            r11.setInstanceFollowRedirects(r2)
            r11.connect()
            int r2 = r11.getResponseCode()
            r3 = 200(0xc8, float:2.8E-43)
            r14 = 1
            r15 = 0
            if (r2 != r3) goto L_0x02d8
            java.util.Map r2 = r11.getHeaderFields()
            if (r2 == 0) goto L_0x00e8
            java.lang.String r3 = "Content-Disposition"
            java.lang.Object r3 = r2.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x00e8
            int r10 = r3.size()
            if (r10 <= 0) goto L_0x00e8
            java.lang.Object r3 = r3.get(r15)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r10 = ";"
            java.lang.String[] r3 = r3.split(r10)
            int r10 = r3.length
            r12 = r15
            r16 = 0
        L_0x00b2:
            if (r12 >= r10) goto L_0x00ea
            r13 = r3[r12]
            java.lang.String r5 = r13.trim()
            java.lang.String r15 = "filename"
            boolean r5 = r5.startsWith(r15)
            if (r5 == 0) goto L_0x00e4
            java.lang.String r5 = "="
            java.lang.String[] r5 = r13.split(r5)
            r5 = r5[r14]
            java.lang.String r13 = "\""
            boolean r15 = r5.startsWith(r13)
            if (r15 == 0) goto L_0x00e2
            boolean r13 = r5.endsWith(r13)
            if (r13 == 0) goto L_0x00e2
            int r13 = r5.length()
            int r13 = r13 - r14
            java.lang.String r16 = r5.substring(r14, r13)
            goto L_0x00e4
        L_0x00e2:
            r16 = r5
        L_0x00e4:
            int r12 = r12 + 1
            r15 = 0
            goto L_0x00b2
        L_0x00e8:
            r16 = 0
        L_0x00ea:
            if (r16 != 0) goto L_0x0179
            java.lang.String r3 = com.mob.tools.utils.Data.MD5((java.lang.String) r21)
            if (r2 == 0) goto L_0x017b
            java.lang.String r5 = "Content-Type"
            java.lang.Object r2 = r2.get(r5)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x017b
            int r5 = r2.size()
            if (r5 <= 0) goto L_0x017b
            r5 = 0
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x010e
            java.lang.String r2 = ""
            goto L_0x0112
        L_0x010e:
            java.lang.String r2 = r2.trim()
        L_0x0112:
            java.lang.String r5 = "image/"
            boolean r5 = r2.startsWith(r5)
            if (r5 == 0) goto L_0x013e
            r1 = 6
            java.lang.String r1 = r2.substring(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            java.lang.String r3 = "."
            r2.append(r3)
            java.lang.String r3 = "jpeg"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0136
            java.lang.String r1 = "jpg"
        L_0x0136:
            r2.append(r1)
            java.lang.String r16 = r2.toString()
            goto L_0x0179
        L_0x013e:
            r2 = 47
            int r2 = r1.lastIndexOf(r2)
            if (r2 <= 0) goto L_0x014c
            int r2 = r2 + r14
            java.lang.String r1 = r1.substring(r2)
            goto L_0x014d
        L_0x014c:
            r1 = 0
        L_0x014d:
            if (r1 == 0) goto L_0x017b
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x017b
            r2 = 46
            int r2 = r1.lastIndexOf(r2)
            if (r2 <= 0) goto L_0x017b
            int r5 = r1.length()
            int r5 = r5 - r2
            r10 = 10
            if (r5 >= r10) goto L_0x017b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r1 = r1.substring(r2)
            r5.append(r1)
            java.lang.String r16 = r5.toString()
        L_0x0179:
            r3 = r16
        L_0x017b:
            java.lang.String r0 = com.mob.tools.utils.ResHelper.getCachePath(r0, r4)
            java.io.File r10 = new java.io.File
            r10.<init>(r0, r3)
            if (r23 == 0) goto L_0x01c6
            boolean r0 = r10.exists()
            if (r0 == 0) goto L_0x01c6
            r11.disconnect()
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r6
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.i((java.lang.String) r1)
            if (r25 == 0) goto L_0x01c1
            r0 = 100
            long r1 = r10.length()
            long r3 = r10.length()
            r20 = r25
            r21 = r0
            r22 = r1
            r24 = r3
            r20.onProgress(r21, r22, r24)
        L_0x01c1:
            java.lang.String r0 = r10.getAbsolutePath()
            return r0
        L_0x01c6:
            java.io.File r0 = r10.getParentFile()
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x01d7
            java.io.File r0 = r10.getParentFile()
            r0.mkdirs()
        L_0x01d7:
            boolean r0 = r10.exists()
            if (r0 == 0) goto L_0x01e0
            r10.delete()
        L_0x01e0:
            if (r25 == 0) goto L_0x01f6
            boolean r0 = r25.isCanceled()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x01f6
            boolean r0 = r10.exists()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x01f1
            r10.delete()     // Catch:{ all -> 0x01f3 }
        L_0x01f1:
            r1 = 0
            return r1
        L_0x01f3:
            r0 = move-exception
            goto L_0x02ce
        L_0x01f6:
            java.io.InputStream r12 = r11.getInputStream()     // Catch:{ all -> 0x02bc }
            int r13 = r11.getContentLength()     // Catch:{ all -> 0x02b6 }
            java.io.FileOutputStream r15 = new java.io.FileOutputStream     // Catch:{ all -> 0x02b6 }
            r15.<init>(r10)     // Catch:{ all -> 0x02b6 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x02b2 }
            int r0 = r12.read(r4)     // Catch:{ all -> 0x02b2 }
            r1 = 0
        L_0x020c:
            if (r0 <= 0) goto L_0x0245
            r2 = 0
            r15.write(r4, r2, r0)     // Catch:{ all -> 0x02b2 }
            int r5 = r1 + r0
            if (r25 == 0) goto L_0x0233
            if (r13 > 0) goto L_0x021b
            r0 = 100
            goto L_0x021e
        L_0x021b:
            int r0 = r5 * 100
            int r0 = r0 / r13
        L_0x021e:
            r1 = r0
            long r2 = (long) r5
            r17 = r15
            long r14 = (long) r13
            r0 = r25
            r8 = r4
            r18 = r5
            r4 = r14
            r0.onProgress(r1, r2, r4)     // Catch:{ all -> 0x02b0 }
            boolean r0 = r25.isCanceled()     // Catch:{ all -> 0x02b0 }
            if (r0 == 0) goto L_0x0238
            goto L_0x0247
        L_0x0233:
            r8 = r4
            r18 = r5
            r17 = r15
        L_0x0238:
            int r0 = r12.read(r8)     // Catch:{ all -> 0x02b0 }
            r4 = r8
            r15 = r17
            r1 = r18
            r14 = 1
            r8 = r19
            goto L_0x020c
        L_0x0245:
            r17 = r15
        L_0x0247:
            if (r25 == 0) goto L_0x027e
            boolean r0 = r25.isCanceled()     // Catch:{ all -> 0x02b0 }
            if (r0 == 0) goto L_0x0269
            boolean r0 = r10.exists()     // Catch:{ all -> 0x02b0 }
            if (r0 == 0) goto L_0x0258
            r10.delete()     // Catch:{ all -> 0x02b0 }
        L_0x0258:
            r17.flush()     // Catch:{ all -> 0x02b0 }
            r1 = 2
            java.io.Closeable[] r0 = new java.io.Closeable[r1]     // Catch:{ all -> 0x01f3 }
            r1 = 0
            r0[r1] = r12     // Catch:{ all -> 0x01f3 }
            r1 = 1
            r0[r1] = r17     // Catch:{ all -> 0x01f3 }
            com.mob.commons.v.a((java.io.Closeable[]) r0)     // Catch:{ all -> 0x01f3 }
            r1 = 0
            return r1
        L_0x0269:
            r0 = 100
            long r1 = r10.length()     // Catch:{ all -> 0x02b0 }
            long r3 = r10.length()     // Catch:{ all -> 0x02b0 }
            r20 = r25
            r21 = r0
            r22 = r1
            r24 = r3
            r20.onProgress(r21, r22, r24)     // Catch:{ all -> 0x02b0 }
        L_0x027e:
            r17.flush()     // Catch:{ all -> 0x02b0 }
            r1 = 2
            java.io.Closeable[] r0 = new java.io.Closeable[r1]     // Catch:{ all -> 0x01f3 }
            r1 = 0
            r0[r1] = r12     // Catch:{ all -> 0x01f3 }
            r1 = 1
            r0[r1] = r17     // Catch:{ all -> 0x01f3 }
            com.mob.commons.v.a((java.io.Closeable[]) r0)     // Catch:{ all -> 0x01f3 }
            r11.disconnect()
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r6
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.i((java.lang.String) r1)
            java.lang.String r0 = r10.getAbsolutePath()
            return r0
        L_0x02b0:
            r0 = move-exception
            goto L_0x02ba
        L_0x02b2:
            r0 = move-exception
            r17 = r15
            goto L_0x02ba
        L_0x02b6:
            r0 = move-exception
            r1 = 0
            r17 = r1
        L_0x02ba:
            r13 = r12
            goto L_0x02c1
        L_0x02bc:
            r0 = move-exception
            r1 = 0
            r13 = r1
            r17 = r13
        L_0x02c1:
            r1 = 2
            java.io.Closeable[] r1 = new java.io.Closeable[r1]     // Catch:{ all -> 0x01f3 }
            r2 = 0
            r1[r2] = r13     // Catch:{ all -> 0x01f3 }
            r2 = 1
            r1[r2] = r17     // Catch:{ all -> 0x01f3 }
            com.mob.commons.v.a((java.io.Closeable[]) r1)     // Catch:{ all -> 0x01f3 }
            throw r0     // Catch:{ all -> 0x01f3 }
        L_0x02ce:
            boolean r1 = r10.exists()
            if (r1 == 0) goto L_0x02d7
            r10.delete()
        L_0x02d7:
            throw r0
        L_0x02d8:
            r1 = 0
            boolean r3 = isRedirects(r11)
            if (r3 == 0) goto L_0x02fa
            java.lang.String r1 = "008PhgfmVefk+fkfm]g"
            java.lang.String r1 = com.mob.commons.l.a((java.lang.String) r1)
            java.lang.String r3 = r11.getHeaderField(r1)
            r1 = r19
            r2 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            java.lang.String r0 = r1.downloadCache(r2, r3, r4, r5, r6, r7)
            return r0
        L_0x02fa:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0372 }
            java.io.InputStream r4 = r11.getErrorStream()     // Catch:{ all -> 0x0372 }
            java.lang.String r5 = "utf-8"
            java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch:{ all -> 0x0372 }
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0372 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x036f }
            r4.<init>(r3)     // Catch:{ all -> 0x036f }
            java.lang.String r1 = r4.readLine()     // Catch:{ all -> 0x036c }
        L_0x0317:
            if (r1 == 0) goto L_0x032f
            int r5 = r0.length()     // Catch:{ all -> 0x036c }
            if (r5 <= 0) goto L_0x0325
            r5 = 10
            r0.append(r5)     // Catch:{ all -> 0x036c }
            goto L_0x0327
        L_0x0325:
            r5 = 10
        L_0x0327:
            r0.append(r1)     // Catch:{ all -> 0x036c }
            java.lang.String r1 = r4.readLine()     // Catch:{ all -> 0x036c }
            goto L_0x0317
        L_0x032f:
            r1 = 2
            java.io.Closeable[] r1 = new java.io.Closeable[r1]
            r5 = 0
            r1[r5] = r4
            r4 = 1
            r1[r4] = r3
            com.mob.commons.v.a((java.io.Closeable[]) r1)
            r11.disconnect()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r3 = "005h+flflfmfl"
            java.lang.String r3 = com.mob.commons.l.a((java.lang.String) r3)
            java.lang.String r0 = r0.toString()
            r1.put(r3, r0)
            java.lang.String r0 = "006_hkDkfk(fihk"
            java.lang.String r0 = com.mob.commons.l.a((java.lang.String) r0)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.put(r0, r2)
            java.lang.Throwable r0 = new java.lang.Throwable
            com.mob.tools.utils.HashonHelper r2 = new com.mob.tools.utils.HashonHelper
            r2.<init>()
            java.lang.String r1 = com.mob.tools.utils.HashonHelper.fromHashMap(r1)
            r0.<init>(r1)
            throw r0
        L_0x036c:
            r0 = move-exception
            r13 = r4
            goto L_0x0375
        L_0x036f:
            r0 = move-exception
            r13 = r1
            goto L_0x0375
        L_0x0372:
            r0 = move-exception
            r3 = r1
            r13 = r3
        L_0x0375:
            r1 = 2
            java.io.Closeable[] r1 = new java.io.Closeable[r1]
            r2 = 0
            r1[r2] = r13
            r2 = 1
            r1[r2] = r3
            com.mob.commons.v.a((java.io.Closeable[]) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.downloadCache(android.content.Context, java.lang.String, java.lang.String, boolean, com.mob.tools.network.NetworkHelper$NetworkTimeOut, com.mob.tools.network.FileDownloadListener):java.lang.String");
    }

    public String httpGet(String str, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) throws Throwable {
        NetworkTimeOut networkTimeOut = new NetworkTimeOut();
        networkTimeOut.readTimout = CDNDownload.DEFAULT_TIMEOUT;
        networkTimeOut.connectionTimeout = 10000;
        return httpGetNew(str, hashMap, hashMap2, networkTimeOut);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00aa, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ae, code lost:
        throw r6;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void httpPost(java.lang.String r6, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r7, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r8, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r9, int r10, com.mob.tools.network.HttpResponseCallback r11, com.mob.tools.network.NetworkHelper.NetworkTimeOut r12) throws java.lang.Throwable {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "httpPost: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r2.i((java.lang.String) r3)
            java.net.HttpURLConnection r12 = r5.getConnection(r6, r12)
            r2 = 1
            r12.setDoOutput(r2)
            java.lang.String r3 = "010Rgffm+gghekJfkfm_g"
            java.lang.String r3 = com.mob.commons.l.a((java.lang.String) r3)
            java.lang.String r4 = "Keep-Alive"
            r12.setRequestProperty(r3, r4)
            if (r8 == 0) goto L_0x0041
            int r3 = r8.size()
            if (r3 <= 0) goto L_0x0041
            com.mob.tools.network.HTTPPart r6 = r5.getFilePostHTTPPart(r12, r6, r7, r8)
            if (r10 < 0) goto L_0x004d
            r12.setChunkedStreamingMode(r10)
            goto L_0x004d
        L_0x0041:
            com.mob.tools.network.HTTPPart r6 = r5.getTextPostHTTPPart(r12, r6, r7)
            long r7 = r6.b()
            int r7 = (int) r7
            r12.setFixedLengthStreamingMode(r7)
        L_0x004d:
            if (r9 == 0) goto L_0x0069
            java.util.Iterator r7 = r9.iterator()
        L_0x0053:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0069
            java.lang.Object r8 = r7.next()
            com.mob.tools.network.KVPair r8 = (com.mob.tools.network.KVPair) r8
            java.lang.String r9 = r8.name
            T r8 = r8.value
            java.lang.String r8 = (java.lang.String) r8
            r12.setRequestProperty(r9, r8)
            goto L_0x0053
        L_0x0069:
            boolean r7 = r5.instanceFollowRedirects
            r12.setInstanceFollowRedirects(r7)
            r12.connect()
            r7 = 2
            r8 = 0
            r9 = 0
            java.io.OutputStream r10 = r12.getOutputStream()     // Catch:{ all -> 0x00d2 }
            java.io.InputStream r8 = r6.toInputStream()     // Catch:{ all -> 0x00d0 }
            r6 = 65536(0x10000, float:9.18355E-41)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x00d0 }
            int r3 = r8.read(r6)     // Catch:{ all -> 0x00d0 }
        L_0x0084:
            if (r3 <= 0) goto L_0x008e
            r10.write(r6, r9, r3)     // Catch:{ all -> 0x00d0 }
            int r3 = r8.read(r6)     // Catch:{ all -> 0x00d0 }
            goto L_0x0084
        L_0x008e:
            r10.flush()     // Catch:{ all -> 0x00d0 }
            java.io.Closeable[] r6 = new java.io.Closeable[r7]
            r6[r9] = r8
            r6[r2] = r10
            com.mob.commons.v.a((java.io.Closeable[]) r6)
            if (r11 == 0) goto L_0x00af
            com.mob.tools.network.HttpConnectionImpl23 r6 = new com.mob.tools.network.HttpConnectionImpl23     // Catch:{ all -> 0x00a8 }
            r6.<init>(r12)     // Catch:{ all -> 0x00a8 }
            r11.onResponse(r6)     // Catch:{ all -> 0x00a8 }
            r12.disconnect()
            goto L_0x00b2
        L_0x00a8:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00aa }
        L_0x00aa:
            r6 = move-exception
            r12.disconnect()
            throw r6
        L_0x00af:
            r12.disconnect()
        L_0x00b2:
            com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "use time: "
            r7.append(r8)
            long r8 = java.lang.System.currentTimeMillis()
            long r8 = r8 - r0
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.i((java.lang.String) r7)
            return
        L_0x00d0:
            r6 = move-exception
            goto L_0x00d4
        L_0x00d2:
            r6 = move-exception
            r10 = r8
        L_0x00d4:
            java.io.Closeable[] r7 = new java.io.Closeable[r7]
            r7[r9] = r8
            r7[r2] = r10
            com.mob.commons.v.a((java.io.Closeable[]) r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.httpPost(java.lang.String, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, int, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String httpPut(java.lang.String r7, java.util.HashMap<java.lang.String, java.lang.Object> r8, com.mob.tools.network.KVPair<java.lang.String> r9, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r10, com.mob.tools.network.NetworkHelper.NetworkTimeOut r11, com.mob.tools.network.OnReadListener r12) throws java.lang.Throwable {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "httpPut: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r2.i((java.lang.String) r3)
            if (r8 == 0) goto L_0x003c
            java.lang.String r8 = r6.requestParamsToUrl(r8)
            int r2 = r8.length()
            if (r2 <= 0) goto L_0x003c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r7 = "?"
            r2.append(r7)
            r2.append(r8)
            java.lang.String r7 = r2.toString()
        L_0x003c:
            java.net.HttpURLConnection r7 = r6.getConnection(r7, r11)
            r8 = 1
            r7.setDoOutput(r8)
            r11 = 0
            r7.setChunkedStreamingMode(r11)
            java.lang.String r2 = "PUT"
            r7.setRequestMethod(r2)
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/octet-stream"
            r7.setRequestProperty(r2, r3)
            java.util.HashMap r10 = r6.kvPairsToStrHashMap(r10)
            r6.setHeader(r7, r10)
            boolean r10 = r6.instanceFollowRedirects
            r7.setInstanceFollowRedirects(r10)
            r7.connect()
            r10 = 2
            r2 = 0
            java.io.OutputStream r3 = r7.getOutputStream()     // Catch:{ all -> 0x0196 }
            com.mob.tools.network.FilePart r4 = new com.mob.tools.network.FilePart     // Catch:{ all -> 0x0194 }
            r4.<init>()     // Catch:{ all -> 0x0194 }
            if (r12 == 0) goto L_0x0073
            r4.setOnReadListener(r12)     // Catch:{ all -> 0x0194 }
        L_0x0073:
            T r9 = r9.value     // Catch:{ all -> 0x0194 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0194 }
            r4.setFile((java.lang.String) r9)     // Catch:{ all -> 0x0194 }
            java.io.InputStream r9 = r4.toInputStream()     // Catch:{ all -> 0x0194 }
            r12 = 65536(0x10000, float:9.18355E-41)
            byte[] r12 = new byte[r12]     // Catch:{ all -> 0x0191 }
            int r4 = r9.read(r12)     // Catch:{ all -> 0x0191 }
        L_0x0086:
            if (r4 <= 0) goto L_0x0090
            r3.write(r12, r11, r4)     // Catch:{ all -> 0x0191 }
            int r4 = r9.read(r12)     // Catch:{ all -> 0x0191 }
            goto L_0x0086
        L_0x0090:
            r3.flush()     // Catch:{ all -> 0x0191 }
            java.io.Closeable[] r12 = new java.io.Closeable[r10]
            r12[r11] = r9
            r12[r8] = r3
            com.mob.commons.v.a((java.io.Closeable[]) r12)
            int r9 = r7.getResponseCode()
            r12 = 200(0xc8, float:2.8E-43)
            r3 = 10
            java.lang.String r4 = "utf-8"
            if (r9 == r12) goto L_0x0124
            r12 = 201(0xc9, float:2.82E-43)
            if (r9 != r12) goto L_0x00ae
            goto L_0x0124
        L_0x00ae:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x0118 }
            java.io.InputStream r7 = r7.getErrorStream()     // Catch:{ all -> 0x0118 }
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r4)     // Catch:{ all -> 0x0118 }
            r0.<init>(r7, r1)     // Catch:{ all -> 0x0118 }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x0116 }
            r7.<init>(r0)     // Catch:{ all -> 0x0116 }
            java.lang.String r1 = r7.readLine()     // Catch:{ all -> 0x0113 }
        L_0x00c9:
            if (r1 == 0) goto L_0x00dc
            int r2 = r12.length()     // Catch:{ all -> 0x0113 }
            if (r2 <= 0) goto L_0x00d4
            r12.append(r3)     // Catch:{ all -> 0x0113 }
        L_0x00d4:
            r12.append(r1)     // Catch:{ all -> 0x0113 }
            java.lang.String r1 = r7.readLine()     // Catch:{ all -> 0x0113 }
            goto L_0x00c9
        L_0x00dc:
            java.io.Closeable[] r10 = new java.io.Closeable[r10]
            r10[r11] = r7
            r10[r8] = r0
            com.mob.commons.v.a((java.io.Closeable[]) r10)
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.lang.String r8 = "005h*flflfmfl"
            java.lang.String r8 = com.mob.commons.l.a((java.lang.String) r8)
            java.lang.String r10 = r12.toString()
            r7.put(r8, r10)
            java.lang.String r8 = "0069hk%kfk5fihk"
            java.lang.String r8 = com.mob.commons.l.a((java.lang.String) r8)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r7.put(r8, r9)
            java.lang.Throwable r8 = new java.lang.Throwable
            com.mob.tools.utils.HashonHelper r9 = new com.mob.tools.utils.HashonHelper
            r9.<init>()
            java.lang.String r7 = com.mob.tools.utils.HashonHelper.fromHashMap(r7)
            r8.<init>(r7)
            throw r8
        L_0x0113:
            r9 = move-exception
            r2 = r7
            goto L_0x011a
        L_0x0116:
            r9 = move-exception
            goto L_0x011a
        L_0x0118:
            r9 = move-exception
            r0 = r2
        L_0x011a:
            java.io.Closeable[] r7 = new java.io.Closeable[r10]
            r7[r11] = r2
            r7[r8] = r0
            com.mob.commons.v.a((java.io.Closeable[]) r7)
            throw r9
        L_0x0124:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.io.InputStreamReader r12 = new java.io.InputStreamReader     // Catch:{ all -> 0x0185 }
            java.io.InputStream r5 = r7.getInputStream()     // Catch:{ all -> 0x0185 }
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)     // Catch:{ all -> 0x0185 }
            r12.<init>(r5, r4)     // Catch:{ all -> 0x0185 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0183 }
            r4.<init>(r12)     // Catch:{ all -> 0x0183 }
            java.lang.String r2 = r4.readLine()     // Catch:{ all -> 0x0180 }
        L_0x013f:
            if (r2 == 0) goto L_0x0152
            int r5 = r9.length()     // Catch:{ all -> 0x0180 }
            if (r5 <= 0) goto L_0x014a
            r9.append(r3)     // Catch:{ all -> 0x0180 }
        L_0x014a:
            r9.append(r2)     // Catch:{ all -> 0x0180 }
            java.lang.String r2 = r4.readLine()     // Catch:{ all -> 0x0180 }
            goto L_0x013f
        L_0x0152:
            java.io.Closeable[] r10 = new java.io.Closeable[r10]
            r10[r11] = r4
            r10[r8] = r12
            com.mob.commons.v.a((java.io.Closeable[]) r10)
            r7.disconnect()
            java.lang.String r7 = r9.toString()
            com.mob.tools.log.NLog r8 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "use time: "
            r9.append(r10)
            long r10 = java.lang.System.currentTimeMillis()
            long r10 = r10 - r0
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.i((java.lang.String) r9)
            return r7
        L_0x0180:
            r7 = move-exception
            r2 = r4
            goto L_0x0187
        L_0x0183:
            r7 = move-exception
            goto L_0x0187
        L_0x0185:
            r7 = move-exception
            r12 = r2
        L_0x0187:
            java.io.Closeable[] r9 = new java.io.Closeable[r10]
            r9[r11] = r2
            r9[r8] = r12
            com.mob.commons.v.a((java.io.Closeable[]) r9)
            throw r7
        L_0x0191:
            r7 = move-exception
            r2 = r9
            goto L_0x0198
        L_0x0194:
            r7 = move-exception
            goto L_0x0198
        L_0x0196:
            r7 = move-exception
            r3 = r2
        L_0x0198:
            java.io.Closeable[] r9 = new java.io.Closeable[r10]
            r9[r11] = r2
            r9[r8] = r3
            com.mob.commons.v.a((java.io.Closeable[]) r9)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.httpPut(java.lang.String, java.util.HashMap, com.mob.tools.network.KVPair, java.util.ArrayList, com.mob.tools.network.NetworkHelper$NetworkTimeOut, com.mob.tools.network.OnReadListener):java.lang.String");
    }

    @Deprecated
    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, kvPairsToStrHashMap(arrayList), httpResponseCallback, networkTimeOut);
    }

    @Deprecated
    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, int i11, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawPost(str, kvPairsToStrHashMap(arrayList), hTTPPart, 0, httpResponseCallback, networkTimeOut);
    }

    public void rawGet(String str, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, (HashMap<String, String>) new HashMap(), rawNetworkCallback, networkTimeOut);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r7.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rawPost(java.lang.String r7, java.util.HashMap<java.lang.String, java.lang.String> r8, com.mob.tools.network.HTTPPart r9, int r10, com.mob.tools.network.HttpResponseCallback r11, com.mob.tools.network.NetworkHelper.NetworkTimeOut r12) throws java.lang.Throwable {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "hptr: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r2.d(r3, r5)
            java.net.HttpURLConnection r7 = r6.getConnection(r7, r12)
            r12 = 1
            r7.setDoOutput(r12)
            if (r10 < 0) goto L_0x002c
            r7.setChunkedStreamingMode(r4)
        L_0x002c:
            r6.setHeader(r7, r8)
            boolean r8 = r6.instanceFollowRedirects
            r7.setInstanceFollowRedirects(r8)
            r7.connect()
            r8 = 2
            r10 = 0
            java.io.OutputStream r2 = r7.getOutputStream()     // Catch:{ all -> 0x0099 }
            java.io.InputStream r10 = r9.toInputStream()     // Catch:{ all -> 0x0097 }
            r9 = 65536(0x10000, float:9.18355E-41)
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x0097 }
            int r3 = r10.read(r9)     // Catch:{ all -> 0x0097 }
        L_0x0049:
            if (r3 <= 0) goto L_0x0053
            r2.write(r9, r4, r3)     // Catch:{ all -> 0x0097 }
            int r3 = r10.read(r9)     // Catch:{ all -> 0x0097 }
            goto L_0x0049
        L_0x0053:
            r2.flush()     // Catch:{ all -> 0x0097 }
            java.io.Closeable[] r8 = new java.io.Closeable[r8]
            r8[r4] = r10
            r8[r12] = r2
            com.mob.commons.v.a((java.io.Closeable[]) r8)
            if (r11 == 0) goto L_0x0074
            com.mob.tools.network.HttpConnectionImpl23 r8 = new com.mob.tools.network.HttpConnectionImpl23     // Catch:{ all -> 0x006d }
            r8.<init>(r7)     // Catch:{ all -> 0x006d }
            r11.onResponse(r8)     // Catch:{ all -> 0x006d }
            r7.disconnect()
            goto L_0x0077
        L_0x006d:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x006f }
        L_0x006f:
            r8 = move-exception
            r7.disconnect()
            throw r8
        L_0x0074:
            r7.disconnect()
        L_0x0077:
            com.mob.tools.log.NLog r7 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "use time: "
            r8.append(r9)
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r0
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r4]
            r7.d(r8, r9)
            return
        L_0x0097:
            r7 = move-exception
            goto L_0x009b
        L_0x0099:
            r7 = move-exception
            r2 = r10
        L_0x009b:
            java.io.Closeable[] r8 = new java.io.Closeable[r8]
            r8[r4] = r10
            r8[r12] = r2
            com.mob.commons.v.a((java.io.Closeable[]) r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.rawPost(java.lang.String, java.util.HashMap, com.mob.tools.network.HTTPPart, int, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004d, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        com.mob.commons.v.a(r8);
        r7.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rawGet(java.lang.String r7, java.util.HashMap<java.lang.String, java.lang.String> r8, com.mob.tools.network.RawNetworkCallback r9, com.mob.tools.network.NetworkHelper.NetworkTimeOut r10) throws java.lang.Throwable {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "rawGet: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r2.d(r3, r5)
            java.net.HttpURLConnection r7 = r6.getConnection(r7, r10)
            r6.setHeader(r7, r8)
            boolean r8 = r6.instanceFollowRedirects
            r7.setInstanceFollowRedirects(r8)
            r7.connect()
            int r8 = r7.getResponseCode()
            r2 = 1
            r3 = 200(0xc8, float:2.8E-43)
            if (r8 != r3) goto L_0x007c
            if (r9 == 0) goto L_0x0059
            java.io.InputStream r8 = r7.getInputStream()
            r9.onResponse(r8)     // Catch:{ all -> 0x004b }
            java.io.Closeable[] r9 = new java.io.Closeable[r2]
            r9[r4] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r9)
            r7.disconnect()
            goto L_0x005c
        L_0x004b:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x004d }
        L_0x004d:
            r9 = move-exception
            java.io.Closeable[] r10 = new java.io.Closeable[r2]
            r10[r4] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r10)
            r7.disconnect()
            throw r9
        L_0x0059:
            r7.disconnect()
        L_0x005c:
            com.mob.tools.log.NLog r7 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "use time: "
            r8.append(r9)
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r0
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r4]
            r7.d(r8, r9)
            goto L_0x0094
        L_0x007c:
            boolean r0 = isRedirects(r7)
            if (r0 == 0) goto L_0x0095
            java.lang.String r8 = "008:hgfm+efk3fkfm.g"
            java.lang.String r8 = com.mob.commons.l.a((java.lang.String) r8)
            java.lang.String r7 = r7.getHeaderField(r8)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r6.rawGet((java.lang.String) r7, (java.util.HashMap<java.lang.String, java.lang.String>) r8, (com.mob.tools.network.RawNetworkCallback) r9, (com.mob.tools.network.NetworkHelper.NetworkTimeOut) r10)
        L_0x0094:
            return
        L_0x0095:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r10 = 2
            r0 = 0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x0103 }
            java.io.InputStream r3 = r7.getErrorStream()     // Catch:{ all -> 0x0103 }
            java.lang.String r5 = "utf-8"
            java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch:{ all -> 0x0103 }
            r1.<init>(r3, r5)     // Catch:{ all -> 0x0103 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0101 }
            r3.<init>(r1)     // Catch:{ all -> 0x0101 }
            java.lang.String r0 = r3.readLine()     // Catch:{ all -> 0x00fe }
        L_0x00b4:
            if (r0 == 0) goto L_0x00c9
            int r5 = r9.length()     // Catch:{ all -> 0x00fe }
            if (r5 <= 0) goto L_0x00c1
            r5 = 10
            r9.append(r5)     // Catch:{ all -> 0x00fe }
        L_0x00c1:
            r9.append(r0)     // Catch:{ all -> 0x00fe }
            java.lang.String r0 = r3.readLine()     // Catch:{ all -> 0x00fe }
            goto L_0x00b4
        L_0x00c9:
            java.io.Closeable[] r10 = new java.io.Closeable[r10]
            r10[r4] = r3
            r10[r2] = r1
            com.mob.commons.v.a((java.io.Closeable[]) r10)
            r7.disconnect()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.lang.String r10 = "005hKflflfmfl"
            java.lang.String r10 = com.mob.commons.l.a((java.lang.String) r10)
            java.lang.String r9 = r9.toString()
            r7.put(r10, r9)
            java.lang.String r9 = "006'hk7kfk1fihk"
            java.lang.String r9 = com.mob.commons.l.a((java.lang.String) r9)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.put(r9, r8)
            java.lang.Throwable r8 = new java.lang.Throwable
            java.lang.String r7 = com.mob.tools.utils.HashonHelper.fromHashMap(r7)
            r8.<init>(r7)
            throw r8
        L_0x00fe:
            r7 = move-exception
            r0 = r3
            goto L_0x0105
        L_0x0101:
            r7 = move-exception
            goto L_0x0105
        L_0x0103:
            r7 = move-exception
            r1 = r0
        L_0x0105:
            java.io.Closeable[] r8 = new java.io.Closeable[r10]
            r8[r4] = r0
            r8[r2] = r1
            com.mob.commons.v.a((java.io.Closeable[]) r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.rawGet(java.lang.String, java.util.HashMap, com.mob.tools.network.RawNetworkCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    @Deprecated
    private void jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut, HttpResponseCallback httpResponseCallback) throws Throwable {
        HashMap hashMap = new HashMap();
        Iterator<KVPair<String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            KVPair next = it2.next();
            hashMap.put(next.name, next.value);
        }
        jsonPost(str, (HashMap<String, Object>) hashMap, arrayList2, networkTimeOut, httpResponseCallback);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009e, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009f, code lost:
        r7.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a2, code lost:
        throw r8;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void jsonPost(java.lang.String r7, java.util.HashMap<java.lang.String, java.lang.Object> r8, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r9, com.mob.tools.network.NetworkHelper.NetworkTimeOut r10, com.mob.tools.network.HttpResponseCallback r11) throws java.lang.Throwable {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "jsonPost: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r2.i((java.lang.String) r3)
            java.net.HttpURLConnection r7 = r6.getConnection(r7, r10)
            r10 = 1
            r7.setDoOutput(r10)
            r2 = 0
            r7.setChunkedStreamingMode(r2)
            java.lang.String r3 = "content-type"
            java.lang.String r4 = "application/json"
            r7.setRequestProperty(r3, r4)
            if (r9 == 0) goto L_0x004b
            java.util.Iterator r9 = r9.iterator()
        L_0x0035:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L_0x004b
            java.lang.Object r3 = r9.next()
            com.mob.tools.network.KVPair r3 = (com.mob.tools.network.KVPair) r3
            java.lang.String r4 = r3.name
            T r3 = r3.value
            java.lang.String r3 = (java.lang.String) r3
            r7.setRequestProperty(r4, r3)
            goto L_0x0035
        L_0x004b:
            com.mob.tools.network.StringPart r9 = new com.mob.tools.network.StringPart
            r9.<init>()
            if (r8 == 0) goto L_0x005e
            com.mob.tools.utils.HashonHelper r3 = new com.mob.tools.utils.HashonHelper
            r3.<init>()
            java.lang.String r8 = com.mob.tools.utils.HashonHelper.fromHashMap(r8)
            r9.append(r8)
        L_0x005e:
            boolean r8 = r6.instanceFollowRedirects
            r7.setInstanceFollowRedirects(r8)
            r7.connect()
            r8 = 2
            r3 = 0
            java.io.OutputStream r4 = r7.getOutputStream()     // Catch:{ all -> 0x00c6 }
            java.io.InputStream r3 = r9.toInputStream()     // Catch:{ all -> 0x00c4 }
            r9 = 65536(0x10000, float:9.18355E-41)
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x00c4 }
            int r5 = r3.read(r9)     // Catch:{ all -> 0x00c4 }
        L_0x0078:
            if (r5 <= 0) goto L_0x0082
            r4.write(r9, r2, r5)     // Catch:{ all -> 0x00c4 }
            int r5 = r3.read(r9)     // Catch:{ all -> 0x00c4 }
            goto L_0x0078
        L_0x0082:
            r4.flush()     // Catch:{ all -> 0x00c4 }
            java.io.Closeable[] r8 = new java.io.Closeable[r8]
            r8[r2] = r3
            r8[r10] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r8)
            if (r11 == 0) goto L_0x00a3
            com.mob.tools.network.HttpConnectionImpl23 r8 = new com.mob.tools.network.HttpConnectionImpl23     // Catch:{ all -> 0x009c }
            r8.<init>(r7)     // Catch:{ all -> 0x009c }
            r11.onResponse(r8)     // Catch:{ all -> 0x009c }
            r7.disconnect()
            goto L_0x00a6
        L_0x009c:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x009e }
        L_0x009e:
            r8 = move-exception
            r7.disconnect()
            throw r8
        L_0x00a3:
            r7.disconnect()
        L_0x00a6:
            com.mob.tools.log.NLog r7 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "use time: "
            r8.append(r9)
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r0
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.i((java.lang.String) r8)
            return
        L_0x00c4:
            r7 = move-exception
            goto L_0x00c8
        L_0x00c6:
            r7 = move-exception
            r4 = r3
        L_0x00c8:
            java.io.Closeable[] r8 = new java.io.Closeable[r8]
            r8[r2] = r3
            r8[r10] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.jsonPost(java.lang.String, java.util.HashMap, java.util.ArrayList, com.mob.tools.network.NetworkHelper$NetworkTimeOut, com.mob.tools.network.HttpResponseCallback):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.InputStream} */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0092, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
        com.mob.commons.v.a(r9);
        r8.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009d, code lost:
        throw r10;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rawPost(java.lang.String r8, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r9, com.mob.tools.network.HTTPPart r10, com.mob.tools.network.RawNetworkCallback r11, com.mob.tools.network.NetworkHelper.NetworkTimeOut r12) throws java.lang.Throwable {
        /*
            r7 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "rawpost: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r2.i((java.lang.String) r3)
            java.net.HttpURLConnection r8 = r7.getConnection(r8, r12)
            r12 = 1
            r8.setDoOutput(r12)
            r2 = 0
            r8.setChunkedStreamingMode(r2)
            if (r9 == 0) goto L_0x0044
            java.util.Iterator r9 = r9.iterator()
        L_0x002e:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L_0x0044
            java.lang.Object r3 = r9.next()
            com.mob.tools.network.KVPair r3 = (com.mob.tools.network.KVPair) r3
            java.lang.String r4 = r3.name
            T r3 = r3.value
            java.lang.String r3 = (java.lang.String) r3
            r8.setRequestProperty(r4, r3)
            goto L_0x002e
        L_0x0044:
            boolean r9 = r7.instanceFollowRedirects
            r8.setInstanceFollowRedirects(r9)
            r8.connect()
            r9 = 2
            r3 = 0
            java.io.OutputStream r4 = r8.getOutputStream()     // Catch:{ all -> 0x0141 }
            java.io.InputStream r10 = r10.toInputStream()     // Catch:{ all -> 0x013f }
            r5 = 65536(0x10000, float:9.18355E-41)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x013c }
            int r6 = r10.read(r5)     // Catch:{ all -> 0x013c }
        L_0x005e:
            if (r6 <= 0) goto L_0x0068
            r4.write(r5, r2, r6)     // Catch:{ all -> 0x013c }
            int r6 = r10.read(r5)     // Catch:{ all -> 0x013c }
            goto L_0x005e
        L_0x0068:
            r4.flush()     // Catch:{ all -> 0x013c }
            java.io.Closeable[] r5 = new java.io.Closeable[r9]
            r5[r2] = r10
            r5[r12] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r5)
            int r10 = r8.getResponseCode()
            r4 = 200(0xc8, float:2.8E-43)
            if (r10 != r4) goto L_0x00bf
            if (r11 == 0) goto L_0x009e
            java.io.InputStream r9 = r8.getInputStream()
            r11.onResponse(r9)     // Catch:{ all -> 0x0090 }
            java.io.Closeable[] r10 = new java.io.Closeable[r12]
            r10[r2] = r9
            com.mob.commons.v.a((java.io.Closeable[]) r10)
            r8.disconnect()
            goto L_0x00a1
        L_0x0090:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0092 }
        L_0x0092:
            r10 = move-exception
            java.io.Closeable[] r11 = new java.io.Closeable[r12]
            r11[r2] = r9
            com.mob.commons.v.a((java.io.Closeable[]) r11)
            r8.disconnect()
            throw r10
        L_0x009e:
            r8.disconnect()
        L_0x00a1:
            com.mob.tools.log.NLog r8 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "use time: "
            r9.append(r10)
            long r10 = java.lang.System.currentTimeMillis()
            long r10 = r10 - r0
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.i((java.lang.String) r9)
            return
        L_0x00bf:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x0130 }
            java.io.InputStream r1 = r8.getErrorStream()     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = "utf-8"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)     // Catch:{ all -> 0x0130 }
            r0.<init>(r1, r4)     // Catch:{ all -> 0x0130 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x012e }
            r1.<init>(r0)     // Catch:{ all -> 0x012e }
            java.lang.String r3 = r1.readLine()     // Catch:{ all -> 0x012b }
        L_0x00dc:
            if (r3 == 0) goto L_0x00f1
            int r4 = r11.length()     // Catch:{ all -> 0x012b }
            if (r4 <= 0) goto L_0x00e9
            r4 = 10
            r11.append(r4)     // Catch:{ all -> 0x012b }
        L_0x00e9:
            r11.append(r3)     // Catch:{ all -> 0x012b }
            java.lang.String r3 = r1.readLine()     // Catch:{ all -> 0x012b }
            goto L_0x00dc
        L_0x00f1:
            java.io.Closeable[] r9 = new java.io.Closeable[r9]
            r9[r2] = r1
            r9[r12] = r0
            com.mob.commons.v.a((java.io.Closeable[]) r9)
            r8.disconnect()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r9 = "005h$flflfmfl"
            java.lang.String r9 = com.mob.commons.l.a((java.lang.String) r9)
            java.lang.String r11 = r11.toString()
            r8.put(r9, r11)
            java.lang.String r9 = "006^hk>kfkFfihk"
            java.lang.String r9 = com.mob.commons.l.a((java.lang.String) r9)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r8.put(r9, r10)
            java.lang.Throwable r9 = new java.lang.Throwable
            com.mob.tools.utils.HashonHelper r10 = new com.mob.tools.utils.HashonHelper
            r10.<init>()
            java.lang.String r8 = com.mob.tools.utils.HashonHelper.fromHashMap(r8)
            r9.<init>(r8)
            throw r9
        L_0x012b:
            r8 = move-exception
            r3 = r1
            goto L_0x0132
        L_0x012e:
            r8 = move-exception
            goto L_0x0132
        L_0x0130:
            r8 = move-exception
            r0 = r3
        L_0x0132:
            java.io.Closeable[] r9 = new java.io.Closeable[r9]
            r9[r2] = r3
            r9[r12] = r0
            com.mob.commons.v.a((java.io.Closeable[]) r9)
            throw r8
        L_0x013c:
            r8 = move-exception
            r3 = r10
            goto L_0x0143
        L_0x013f:
            r8 = move-exception
            goto L_0x0143
        L_0x0141:
            r8 = move-exception
            r4 = r3
        L_0x0143:
            java.io.Closeable[] r9 = new java.io.Closeable[r9]
            r9[r2] = r3
            r9[r12] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.rawPost(java.lang.String, java.util.ArrayList, com.mob.tools.network.HTTPPart, com.mob.tools.network.RawNetworkCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a7, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a8, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ab, code lost:
        throw r6;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void httpPost(java.lang.String r6, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r7, byte[] r8, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r9, int r10, com.mob.tools.network.HttpResponseCallback r11, com.mob.tools.network.NetworkHelper.NetworkTimeOut r12) throws java.lang.Throwable {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "httpPost: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r2.i((java.lang.String) r3)
            java.net.HttpURLConnection r12 = r5.getConnection(r6, r12)
            r2 = 1
            r12.setDoOutput(r2)
            java.lang.String r3 = "010ZgffmNgghek_fkfmXg"
            java.lang.String r3 = com.mob.commons.l.a((java.lang.String) r3)
            java.lang.String r4 = "Keep-Alive"
            r12.setRequestProperty(r3, r4)
            if (r8 == 0) goto L_0x003e
            int r3 = r8.length
            if (r3 <= 0) goto L_0x003e
            com.mob.tools.network.HTTPPart r6 = r5.getDataPostHttpPart(r12, r6, r8)
            if (r10 < 0) goto L_0x004a
            r12.setChunkedStreamingMode(r10)
            goto L_0x004a
        L_0x003e:
            com.mob.tools.network.HTTPPart r6 = r5.getTextPostHTTPPart(r12, r6, r7)
            long r7 = r6.b()
            int r7 = (int) r7
            r12.setFixedLengthStreamingMode(r7)
        L_0x004a:
            if (r9 == 0) goto L_0x0066
            java.util.Iterator r7 = r9.iterator()
        L_0x0050:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0066
            java.lang.Object r8 = r7.next()
            com.mob.tools.network.KVPair r8 = (com.mob.tools.network.KVPair) r8
            java.lang.String r9 = r8.name
            T r8 = r8.value
            java.lang.String r8 = (java.lang.String) r8
            r12.setRequestProperty(r9, r8)
            goto L_0x0050
        L_0x0066:
            boolean r7 = r5.instanceFollowRedirects
            r12.setInstanceFollowRedirects(r7)
            r12.connect()
            r7 = 2
            r8 = 0
            r9 = 0
            java.io.OutputStream r10 = r12.getOutputStream()     // Catch:{ all -> 0x00cf }
            java.io.InputStream r8 = r6.toInputStream()     // Catch:{ all -> 0x00cd }
            r6 = 65536(0x10000, float:9.18355E-41)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x00cd }
            int r3 = r8.read(r6)     // Catch:{ all -> 0x00cd }
        L_0x0081:
            if (r3 <= 0) goto L_0x008b
            r10.write(r6, r9, r3)     // Catch:{ all -> 0x00cd }
            int r3 = r8.read(r6)     // Catch:{ all -> 0x00cd }
            goto L_0x0081
        L_0x008b:
            r10.flush()     // Catch:{ all -> 0x00cd }
            java.io.Closeable[] r6 = new java.io.Closeable[r7]
            r6[r9] = r8
            r6[r2] = r10
            com.mob.commons.v.a((java.io.Closeable[]) r6)
            if (r11 == 0) goto L_0x00ac
            com.mob.tools.network.HttpConnectionImpl23 r6 = new com.mob.tools.network.HttpConnectionImpl23     // Catch:{ all -> 0x00a5 }
            r6.<init>(r12)     // Catch:{ all -> 0x00a5 }
            r11.onResponse(r6)     // Catch:{ all -> 0x00a5 }
            r12.disconnect()
            goto L_0x00af
        L_0x00a5:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r6 = move-exception
            r12.disconnect()
            throw r6
        L_0x00ac:
            r12.disconnect()
        L_0x00af:
            com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "use time: "
            r7.append(r8)
            long r8 = java.lang.System.currentTimeMillis()
            long r8 = r8 - r0
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.i((java.lang.String) r7)
            return
        L_0x00cd:
            r6 = move-exception
            goto L_0x00d1
        L_0x00cf:
            r6 = move-exception
            r10 = r8
        L_0x00d1:
            java.io.Closeable[] r7 = new java.io.Closeable[r7]
            r7[r9] = r8
            r7[r2] = r10
            com.mob.commons.v.a((java.io.Closeable[]) r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.httpPost(java.lang.String, java.util.ArrayList, byte[], java.util.ArrayList, int, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    public void rawGet(String str, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, (HashMap<String, String>) new HashMap(), httpResponseCallback, networkTimeOut);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0057, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0058, code lost:
        r7.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005b, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rawGet(java.lang.String r7, java.util.HashMap<java.lang.String, java.lang.String> r8, com.mob.tools.network.HttpResponseCallback r9, com.mob.tools.network.NetworkHelper.NetworkTimeOut r10) throws java.lang.Throwable {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "rawGet: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r2.d(r3, r5)
            java.net.HttpURLConnection r7 = r6.getConnection(r7, r10)
            r6.setHeader(r7, r8)
            boolean r8 = r6.instanceFollowRedirects
            r7.setInstanceFollowRedirects(r8)
            r7.connect()
            boolean r8 = isRedirects(r7)
            if (r8 == 0) goto L_0x0047
            java.lang.String r8 = "008Lhgfm(efkLfkfm-g"
            java.lang.String r8 = com.mob.commons.l.a((java.lang.String) r8)
            java.lang.String r7 = r7.getHeaderField(r8)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r6.rawGet((java.lang.String) r7, (java.util.HashMap<java.lang.String, java.lang.String>) r8, (com.mob.tools.network.HttpResponseCallback) r9, (com.mob.tools.network.NetworkHelper.NetworkTimeOut) r10)
            goto L_0x005f
        L_0x0047:
            if (r9 == 0) goto L_0x005c
            com.mob.tools.network.HttpConnectionImpl23 r8 = new com.mob.tools.network.HttpConnectionImpl23     // Catch:{ all -> 0x0055 }
            r8.<init>(r7)     // Catch:{ all -> 0x0055 }
            r9.onResponse(r8)     // Catch:{ all -> 0x0055 }
            r7.disconnect()
            goto L_0x005f
        L_0x0055:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r8 = move-exception
            r7.disconnect()
            throw r8
        L_0x005c:
            r7.disconnect()
        L_0x005f:
            com.mob.tools.log.NLog r7 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "use time: "
            r8.append(r9)
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r0
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r4]
            r7.d(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.rawGet(java.lang.String, java.util.HashMap, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    @Deprecated
    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, int i11, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap hashMap = new HashMap();
        httpPost(str, arrayList, i11, (HttpResponseCallback) new HttpResponseCallback() {
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                BufferedReader bufferedReader;
                InputStreamReader inputStreamReader2;
                int responseCode = httpConnection.getResponseCode();
                BufferedReader bufferedReader2 = null;
                if (responseCode == 200 || responseCode < 300) {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                        } catch (Throwable th2) {
                            th = th2;
                            v.a(bufferedReader2, inputStreamReader);
                            throw th;
                        }
                        try {
                            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                                if (sb2.length() > 0) {
                                    sb2.append(10);
                                }
                                sb2.append(readLine);
                            }
                            v.a(bufferedReader, inputStreamReader);
                            hashMap.put("resp", sb2.toString());
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader2 = bufferedReader;
                            v.a(bufferedReader2, inputStreamReader);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamReader = null;
                        v.a(bufferedReader2, inputStreamReader);
                        throw th;
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    try {
                        inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                            try {
                                for (String readLine2 = bufferedReader3.readLine(); readLine2 != null; readLine2 = bufferedReader3.readLine()) {
                                    if (sb3.length() > 0) {
                                        sb3.append(10);
                                    }
                                    sb3.append(readLine2);
                                }
                                v.a(bufferedReader3, inputStreamReader2);
                                HashMap hashMap = new HashMap();
                                hashMap.put(l.a("005hLflflfmfl"), sb3.toString());
                                hashMap.put(l.a("006.hk,kfk,fihk"), Integer.valueOf(responseCode));
                                new HashonHelper();
                                throw new Throwable(HashonHelper.fromHashMap(hashMap));
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader2 = bufferedReader3;
                                v.a(bufferedReader2, inputStreamReader2);
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            v.a(bufferedReader2, inputStreamReader2);
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        inputStreamReader2 = null;
                        v.a(bufferedReader2, inputStreamReader2);
                        throw th;
                    }
                }
            }
        }, networkTimeOut);
        return (String) hashMap.get("resp");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0094, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0095, code lost:
        r7.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0098, code lost:
        throw r8;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void httpPost(java.lang.String r7, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r8, int r9, com.mob.tools.network.HttpResponseCallback r10, com.mob.tools.network.NetworkHelper.NetworkTimeOut r11) throws java.lang.Throwable {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.mob.tools.log.NLog r9 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "httpPost: "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r9.i((java.lang.String) r2)
            java.net.HttpURLConnection r7 = r6.getConnection(r7, r11)
            r9 = 1
            r7.setDoOutput(r9)
            java.lang.String r11 = "010NgffmYgghekZfkfmCg"
            java.lang.String r11 = com.mob.commons.l.a((java.lang.String) r11)
            java.lang.String r2 = "Keep-Alive"
            r7.setRequestProperty(r11, r2)
            if (r8 == 0) goto L_0x004b
            java.util.Iterator r8 = r8.iterator()
        L_0x0035:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x004b
            java.lang.Object r11 = r8.next()
            com.mob.tools.network.KVPair r11 = (com.mob.tools.network.KVPair) r11
            java.lang.String r2 = r11.name
            T r11 = r11.value
            java.lang.String r11 = (java.lang.String) r11
            r7.setRequestProperty(r2, r11)
            goto L_0x0035
        L_0x004b:
            com.mob.tools.network.StringPart r8 = new com.mob.tools.network.StringPart
            r8.<init>()
            r11 = 0
            r8.append(r11)
            boolean r2 = r6.instanceFollowRedirects
            r7.setInstanceFollowRedirects(r2)
            r7.connect()
            r2 = 2
            r3 = 0
            java.io.OutputStream r4 = r7.getOutputStream()     // Catch:{ all -> 0x00bc }
            java.io.InputStream r11 = r8.toInputStream()     // Catch:{ all -> 0x00ba }
            r8 = 65536(0x10000, float:9.18355E-41)
            byte[] r8 = new byte[r8]     // Catch:{ all -> 0x00ba }
            int r5 = r11.read(r8)     // Catch:{ all -> 0x00ba }
        L_0x006e:
            if (r5 <= 0) goto L_0x0078
            r4.write(r8, r3, r5)     // Catch:{ all -> 0x00ba }
            int r5 = r11.read(r8)     // Catch:{ all -> 0x00ba }
            goto L_0x006e
        L_0x0078:
            r4.flush()     // Catch:{ all -> 0x00ba }
            java.io.Closeable[] r8 = new java.io.Closeable[r2]
            r8[r3] = r11
            r8[r9] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r8)
            if (r10 == 0) goto L_0x0099
            com.mob.tools.network.HttpConnectionImpl23 r8 = new com.mob.tools.network.HttpConnectionImpl23     // Catch:{ all -> 0x0092 }
            r8.<init>(r7)     // Catch:{ all -> 0x0092 }
            r10.onResponse(r8)     // Catch:{ all -> 0x0092 }
            r7.disconnect()
            goto L_0x009c
        L_0x0092:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0094 }
        L_0x0094:
            r8 = move-exception
            r7.disconnect()
            throw r8
        L_0x0099:
            r7.disconnect()
        L_0x009c:
            com.mob.tools.log.NLog r7 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "use time: "
            r8.append(r9)
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r0
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.i((java.lang.String) r8)
            return
        L_0x00ba:
            r7 = move-exception
            goto L_0x00be
        L_0x00bc:
            r7 = move-exception
            r4 = r11
        L_0x00be:
            java.io.Closeable[] r8 = new java.io.Closeable[r2]
            r8[r3] = r11
            r8[r9] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.httpPost(java.lang.String, java.util.ArrayList, int, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }
}
