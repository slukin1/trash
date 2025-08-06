package com.huobi.domain.ca;

import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.xiaomi.mipush.sdk.Constants;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CertificateUtil {
    public static String a(X509Certificate x509Certificate) {
        try {
            String name = x509Certificate.getSubjectDN().getName();
            int indexOf = name.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (indexOf >= 0) {
                name = name.substring(0, indexOf);
            }
            int indexOf2 = name.indexOf("*.");
            if (indexOf2 >= 0) {
                return name.substring(indexOf2 + 2);
            }
            return name;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static void b(X509Certificate x509Certificate) {
        try {
            StringBuilder sb2 = new StringBuilder();
            String valueOf = String.valueOf(x509Certificate.getVersion());
            sb2.append("证书版本:");
            sb2.append(valueOf);
            sb2.append("\n");
            String bigInteger = x509Certificate.getSerialNumber().toString(16);
            sb2.append("证书序列号:");
            sb2.append(bigInteger);
            sb2.append("\n");
            Date notBefore = x509Certificate.getNotBefore();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String format = simpleDateFormat.format(notBefore);
            sb2.append("证书生效日期:");
            sb2.append(format);
            sb2.append("\n");
            String format2 = simpleDateFormat.format(x509Certificate.getNotAfter());
            sb2.append("证书失效日期:");
            sb2.append(format2);
            sb2.append("\n");
            String name = x509Certificate.getSubjectDN().getName();
            sb2.append("证书拥有者:");
            sb2.append(name);
            sb2.append("\n");
            String a11 = a(x509Certificate);
            sb2.append("域名:");
            sb2.append(a11);
            sb2.append("\n");
            String name2 = x509Certificate.getIssuerDN().getName();
            sb2.append("证书颁发者:");
            sb2.append(name2);
            sb2.append("\n");
            String sigAlgName = x509Certificate.getSigAlgName();
            sb2.append("证书签名算法:");
            sb2.append(sigAlgName);
            sb2.append("\n");
            String obj = x509Certificate.getPublicKey().toString();
            sb2.append("证书公钥:");
            sb2.append(obj);
            sb2.append("\n");
            LogAndWoodRecorder.a("DOMAIN_TEST", "证书信息：" + sb2);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
