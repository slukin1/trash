package com.facebook.internal.security;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import com.huochat.community.util.FileTool;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CertificateUtil {
    private static final String DELIMITER = ":";

    private CertificateUtil() {
    }

    public static String getCertificateHash(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            StringBuilder sb2 = new StringBuilder();
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_SHA1);
            for (Signature byteArray : signatureArr) {
                instance.update(byteArray.toByteArray());
                sb2.append(Base64.encodeToString(instance.digest(), 0));
                sb2.append(":");
            }
            if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
