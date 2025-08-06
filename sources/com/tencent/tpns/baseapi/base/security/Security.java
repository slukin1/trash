package com.tencent.tpns.baseapi.base.security;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.Md5;
import java.io.File;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import net.sf.scuba.smartcards.ISO7816;

public class Security {
    private static final String TAG = "Security";
    private static boolean loadedTpnsSecuritySo = false;
    public static final String tpnsSecurityLibFullName = "libxgVipSecurity.so";
    private static final String tpnsSecurityLibName = "xgVipSecurity";

    static {
        try {
            System.loadLibrary(tpnsSecurityLibName);
            loadedTpnsSecuritySo = true;
        } catch (Throwable th2) {
            TBaseLogger.e(TAG, "can not load library,error:", th2);
            loadedTpnsSecuritySo = false;
        }
    }

    public static boolean checkTpnsSecurityLibSo(Context context) {
        if (loadedTpnsSecuritySo) {
            return true;
        }
        if (context != null) {
            String str = "";
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context.getDir("lib", 0).getParentFile().getAbsolutePath());
                String str2 = File.separator;
                sb2.append(str2);
                sb2.append("lib");
                sb2.append(str2);
                sb2.append(tpnsSecurityLibFullName);
                str = sb2.toString();
                System.load(str);
                loadedTpnsSecuritySo = true;
            } catch (Throwable th2) {
                loadedTpnsSecuritySo = false;
                TBaseLogger.e(TAG, "can not load library from " + str + ",error:" + th2);
            }
        }
        return loadedTpnsSecuritySo;
    }

    public static byte[] decryptSrvData(byte[] bArr) {
        TBaseLogger.ii(TAG, "---decrypt---");
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    byte[] doDecryptSrvData = doDecryptSrvData(bArr);
                    if (doDecryptSrvData != null) {
                        return doDecryptSrvData;
                    }
                    TBaseLogger.ee(TAG, ">> decryptSrvData: decrypt failed!");
                    return null;
                }
            } catch (Throwable th2) {
                TBaseLogger.e(TAG, ">> decryptSrvData: throwable", th2);
                return null;
            }
        }
        TBaseLogger.ee(TAG, ">> decryptSrvData: encData is empty");
        return null;
    }

    public static native byte[] doDecryptSrvData(byte[] bArr);

    public static native byte[] doEncryptSrvData(byte[] bArr);

    public static byte[] encryptSrvData(byte[] bArr) {
        TBaseLogger.ii(TAG, "---encrypt---");
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    byte[] doEncryptSrvData = doEncryptSrvData(bArr);
                    if (doEncryptSrvData != null) {
                        return doEncryptSrvData;
                    }
                    TBaseLogger.ee(TAG, ">> encryptSrvData: encrypt failed!");
                    return null;
                }
            } catch (Throwable th2) {
                TBaseLogger.e(TAG, ">> encryptSrvData: throwable", th2);
                return null;
            }
        }
        TBaseLogger.ee(TAG, ">> encryptSrvData: input text is empty");
        return null;
    }

    public static native String generateLocalSocketServieNameNative(Object obj);

    public static native String getBusinessDeviceIdNative(Object obj);

    public static native String getEncryptAPKSignatureNative(Object obj);

    public static String getEncryptAPKSignatureV2(Context context) {
        String str;
        try {
            String packageResourcePath = context.getPackageResourcePath();
            ArrayList arrayList = new ArrayList();
            JarFile jarFile = new JarFile(new File(packageResourcePath));
            JarEntry jarEntry = jarFile.getJarEntry("AndroidManifest.xml");
            InputStream inputStream = jarFile.getInputStream(jarEntry);
            byte[] bArr = new byte[8192];
            for (int i11 = 0; i11 != -1; i11 = inputStream.read(bArr, 0, 8192)) {
            }
            inputStream.close();
            for (Certificate encoded : jarEntry.getCertificates()) {
                arrayList.add(toCharsString(encoded.getEncoded()));
            }
            str = (String) arrayList.get(0);
        } catch (Throwable unused) {
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            return Md5.md5(str);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static native byte[] oiSymmetryDecrypt2Byte(byte[] bArr);

    public static native byte[] oiSymmetryEncrypt2Byte(String str);

    private static String toCharsString(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i11 = 0; i11 < length; i11++) {
            byte b11 = bArr[i11];
            int i12 = (b11 >> 4) & 15;
            int i13 = i11 * 2;
            cArr[i13] = (char) (i12 >= 10 ? (i12 + 97) - 10 : i12 + 48);
            byte b12 = b11 & 15;
            cArr[i13 + 1] = (char) (b12 >= 10 ? (b12 + 97) - 10 : b12 + ISO7816.INS_DECREASE);
        }
        return new String(cArr);
    }
}
