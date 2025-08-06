package com.kakao.util.helper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import hg.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Utility {

    /* renamed from: a  reason: collision with root package name */
    public static final String f25155a = "com.kakao.util.helper.Utility";

    public static int a(Context context) {
        return d(context).versionCode;
    }

    public static String b(Context context) {
        PackageInfo e11 = e(context, 64);
        if (e11 == null) {
            return null;
        }
        Signature[] signatureArr = e11.signatures;
        int length = signatureArr.length;
        int i11 = 0;
        while (i11 < length) {
            Signature signature = signatureArr[i11];
            try {
                MessageDigest instance = MessageDigest.getInstance(a.f40503a);
                instance.update(signature.toByteArray());
                return Base64.encodeToString(instance.digest(), 2);
            } catch (NoSuchAlgorithmException e12) {
                String str = f25155a;
                Log.w(str, "Unable to get MessageDigest. signature=" + signature, e12);
                i11++;
            }
        }
        return null;
    }

    public static String c(Context context, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return bundle.getString(str);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static PackageInfo d(Context context) {
        return e(context, 0);
    }

    public static PackageInfo e(Context context, int i11) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i11);
        } catch (PackageManager.NameNotFoundException e11) {
            Log.w(f25155a, "Unable to get PackageInfo", e11);
            return null;
        }
    }
}
