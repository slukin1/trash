package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.huochat.community.util.FileTool;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public final class af {
    private static String AFInAppEventParameterName(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i11])});
        }
        String obj = formatter.toString();
        formatter.close();
        return obj;
    }

    public static String AFInAppEventType(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return AFInAppEventParameterName(instance.digest());
        } catch (Exception e11) {
            StringBuilder sb2 = new StringBuilder("Error turning ");
            sb2.append(str.substring(0, 6));
            sb2.append(".. to MD5");
            AFLogger.AFInAppEventType(sb2.toString(), (Throwable) e11);
            return null;
        }
    }

    public static String AFKeystoreWrapper(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA1);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return AFInAppEventParameterName(instance.digest());
        } catch (Exception e11) {
            StringBuilder sb2 = new StringBuilder("Error turning ");
            sb2.append(str.substring(0, 6));
            sb2.append(".. to SHA1");
            AFLogger.AFInAppEventType(sb2.toString(), (Throwable) e11);
            return null;
        }
    }

    public static String values(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            return values(instance.digest());
        } catch (Exception e11) {
            StringBuilder sb2 = new StringBuilder("Error turning ");
            sb2.append(str.substring(0, 6));
            sb2.append(".. to SHA-256");
            AFLogger.AFInAppEventType(sb2.toString(), (Throwable) e11);
            return null;
        }
    }

    private static String values(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            sb2.append(Integer.toString((b11 & 255) + 256, 16).substring(1));
        }
        return sb2.toString();
    }

    public static String values(String str, String str2) {
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            return values(instance.doFinal(str.getBytes())).toLowerCase();
        } catch (InvalidKeyException | NoSuchAlgorithmException e11) {
            AFLogger.AFInAppEventParameterName(e11.getMessage(), e11);
            return e11.getMessage();
        }
    }
}
