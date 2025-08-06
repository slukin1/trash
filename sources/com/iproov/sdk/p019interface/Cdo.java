package com.iproov.sdk.p019interface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.iproov.sdk.interface.do  reason: invalid class name and invalid package */
public class Cdo {
    @SuppressLint({"HardwareIds"})
    /* renamed from: do  reason: not valid java name */
    public static String m1095do(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        try {
            return m1096do(string + "iProov");
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static String m1096do(String str) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(str.getBytes());
        byte[] digest = instance.digest();
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : digest) {
            String hexString = Integer.toHexString(b11 & 255);
            while (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }
}
