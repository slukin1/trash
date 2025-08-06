package com.huobi.vulcan.utils.riskinfo;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class CertUtils {
    public static String a() {
        String str = "";
        try {
            KeyStore instance = KeyStore.getInstance("AndroidCAStore");
            instance.load((InputStream) null, (char[]) null);
            Enumeration<String> aliases = instance.aliases();
            while (aliases.hasMoreElements()) {
                String nextElement = aliases.nextElement();
                String str2 = !nextElement.startsWith("system") ? "u_" : "s_";
                try {
                    Certificate certificate = instance.getCertificate(nextElement);
                    if (certificate instanceof X509Certificate) {
                        String lowerCase = ((X509Certificate) certificate).getIssuerDN().getName().toLowerCase();
                        if (lowerCase.contains("portswigger")) {
                            str = str + str2 + "burpsuite,";
                        } else if (lowerCase.contains("charles proxy")) {
                            str = str + str2 + "charles,";
                        } else if (lowerCase.contains("httpcanary")) {
                            str = str + str2 + "httpcanary,";
                        } else if (lowerCase.contains("packet capture")) {
                            str = str + str2 + "packetcapture,";
                        } else if (lowerCase.contains("littleproxy-mitm")) {
                            str = str + str2 + "androidhttpcapture,";
                        } else if (lowerCase.contains("fiddler")) {
                            str = str + str2 + "fiddler,";
                        }
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
        return str.length() > 1 ? str.substring(0, str.length() - 1) : str;
    }
}
