package com.huobi.vulcan.utils.riskinfo;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huochat.community.util.FileTool;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignUtils {
    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.reset();
            instance.update(bArr);
            byte[] digest = instance.digest();
            for (int i11 = 0; i11 < digest.length; i11++) {
                if (Integer.toHexString(digest[i11] & 255).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(digest[i11] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i11] & 255));
                }
            }
        } catch (NoSuchAlgorithmException unused) {
        }
        return stringBuffer.toString();
    }

    public static String b(Context context) {
        try {
            return a(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }
}
