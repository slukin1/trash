package com.huobi.woodpecker.net;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import com.huobi.woodpecker.WoodPeckerSDK;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import org.json.JSONObject;

public class NetUtils {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, JSONObject> f21152a = new HashMap<>();

    public static JSONObject a(X509Certificate x509Certificate) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("证书版本", String.valueOf(x509Certificate.getVersion()));
            jSONObject.put("证书序列号", x509Certificate.getSerialNumber().toString(16));
            jSONObject.put("证书生效日期", x509Certificate.getNotBefore());
            jSONObject.put("证书失效日期", x509Certificate.getNotAfter());
            jSONObject.put("证书拥有者", x509Certificate.getSubjectDN().getName());
            jSONObject.put("证书颁发者", x509Certificate.getIssuerDN().getName());
            jSONObject.put("证书签名算法", x509Certificate.getSigAlgName());
            jSONObject.put("证书公钥", x509Certificate.getPublicKey().toString());
            return jSONObject;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", str2);
            jSONObject.put("localTime", System.currentTimeMillis());
            jSONObject.put("localDate", new Date());
            jSONObject.put("isProxy", d());
            jSONObject.put("localIP", b());
            if (f21152a.get(str) != null) {
                jSONObject.put("sslInfo", f21152a.get(str));
            }
            return jSONObject.toString();
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static boolean d() {
        int i11;
        String str;
        Context e11 = WoodPeckerSDK.f().e();
        if (e11 == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            str = System.getProperty("http.proxyHost");
            String property = System.getProperty("http.proxyPort");
            if (property == null) {
                property = "-1";
            }
            i11 = Integer.parseInt(property);
        } else {
            String host = Proxy.getHost(e11);
            i11 = Proxy.getPort(e11);
            str = host;
        }
        if (TextUtils.isEmpty(str) || i11 == -1) {
            return false;
        }
        return true;
    }
}
