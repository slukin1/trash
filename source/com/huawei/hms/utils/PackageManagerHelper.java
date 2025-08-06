package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.support.log.HMSLog;

public class PackageManagerHelper {

    /* renamed from: a  reason: collision with root package name */
    private final PackageManager f38613a;

    public enum PackageStates {
        ENABLED,
        DISABLED,
        NOT_INSTALLED,
        SPOOF
    }

    public PackageManagerHelper(Context context) {
        this.f38613a = context.getPackageManager();
    }

    private byte[] a(String str) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = this.f38613a.getPackageInfo(str, 64);
            if (!(packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0)) {
                return signatureArr[0].toByteArray();
            }
        } catch (AndroidException e11) {
            HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e11.getMessage());
        } catch (RuntimeException e12) {
            HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.", (Throwable) e12);
        }
        HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    public String getApplicationName(String str) {
        try {
            return this.f38613a.getApplicationLabel(this.f38613a.getApplicationInfo(str, 128)).toString();
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.e("PackageManagerHelper", "Failed to get application name for " + str);
            return null;
        }
    }

    public long getPackageFirstInstallTime(String str) {
        try {
            PackageInfo packageInfo = this.f38613a.getPackageInfo(str, 128);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
            return 0;
        } catch (AndroidException | RuntimeException unused) {
            return 0;
        }
    }

    public String getPackageSignature(String str) {
        byte[] a11 = a(str);
        if (a11 == null || a11.length == 0) {
            return null;
        }
        return HEX.encodeHexString(SHA256.digest(a11), true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getPackageSigningCertificate(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "PackageManagerHelper"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 >= r2) goto L_0x000d
            java.lang.String r8 = r7.getPackageSignature(r8)
            return r8
        L_0x000d:
            r1 = 0
            android.content.pm.PackageManager r2 = r7.f38613a     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            r3 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r8 = r2.getPackageInfo(r8, r3)     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            r4 = 0
            r3[r4] = r8     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            android.content.pm.SigningInfo r5 = r8.signingInfo     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            r6 = 1
            r3[r6] = r5     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            boolean r3 = com.huawei.hms.common.internal.Objects.isNull(r3)     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            if (r3 == 0) goto L_0x002d
            java.lang.String r8 = "packageInfo or packageInfo.signingInfo is null"
            com.huawei.hms.support.log.HMSLog.e(r0, r8)     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            return r1
        L_0x002d:
            android.content.pm.SigningInfo r8 = r8.signingInfo     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            android.content.pm.Signature[] r8 = r8.getApkContentsSigners()     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            r2[r4] = r8     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            r3 = r8[r4]     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            r2[r6] = r3     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            boolean r2 = com.huawei.hms.common.internal.Objects.isNull(r2)     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            if (r2 == 0) goto L_0x0047
            java.lang.String r8 = "get V3 signature is null"
            com.huawei.hms.support.log.HMSLog.e(r0, r8)     // Catch:{ AndroidException | RuntimeException -> 0x0056 }
            return r1
        L_0x0047:
            r8 = r8[r4]
            byte[] r8 = r8.toByteArray()
            byte[] r8 = com.huawei.hms.utils.SHA256.digest((byte[]) r8)
            java.lang.String r8 = com.huawei.hms.utils.HEX.encodeHexString(r8, r6)
            return r8
        L_0x0056:
            java.lang.String r8 = "getPackageSignatureV3 has exception"
            com.huawei.hms.support.log.HMSLog.e(r0, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.PackageManagerHelper.getPackageSigningCertificate(java.lang.String):java.lang.String");
    }

    public PackageStates getPackageStates(String str) {
        if (TextUtils.isEmpty(str)) {
            HMSLog.e("PackageManagerHelper", "servicePackageName is empty.");
            return PackageStates.NOT_INSTALLED;
        }
        try {
            if (this.f38613a.getApplicationInfo(str, 128).enabled) {
                return PackageStates.ENABLED;
            }
            return PackageStates.DISABLED;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.e("PackageManagerHelper", "in getPackageStates, getApplicationInfo threw an exception");
            return PackageStates.NOT_INSTALLED;
        }
    }

    public int getPackageVersionCode(String str) {
        try {
            PackageInfo packageInfo = this.f38613a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (AndroidException e11) {
            HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed " + e11);
            return 0;
        } catch (RuntimeException e12) {
            HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed", (Throwable) e12);
            return 0;
        }
    }

    public String getPackageVersionName(String str) {
        String str2;
        try {
            PackageInfo packageInfo = this.f38613a.getPackageInfo(str, 16);
            if (packageInfo == null || (str2 = packageInfo.versionName) == null) {
                return "";
            }
            return str2;
        } catch (AndroidException unused) {
            return "";
        } catch (RuntimeException e11) {
            HMSLog.e("PackageManagerHelper", "get getPackageVersionName failed", (Throwable) e11);
            return "";
        }
    }

    public boolean hasProvider(String str, String str2) {
        ProviderInfo[] providerInfoArr;
        try {
            PackageInfo packageInfo = this.f38613a.getPackageInfo(str, 8);
            if (!(packageInfo == null || (providerInfoArr = packageInfo.providers) == null)) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (str2.equals(providerInfo.authority)) {
                        return true;
                    }
                }
            }
        } catch (AndroidException | RuntimeException unused) {
        }
        return false;
    }

    public boolean isPackageFreshInstall(String str) {
        try {
            PackageInfo packageInfo = this.f38613a.getPackageInfo(str, 128);
            if (packageInfo == null || packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                return false;
            }
            return true;
        } catch (AndroidException | RuntimeException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: android.content.pm.PackageInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: android.content.pm.PackageInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: android.content.pm.PackageInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean verifyPackageArchive(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            java.lang.String r0 = "PackageManagerHelper"
            r1 = 0
            android.content.pm.PackageManager r2 = r4.f38613a     // Catch:{ Exception -> 0x000c }
            r3 = 64
            android.content.pm.PackageInfo r5 = r2.getPackageArchiveInfo(r5, r3)     // Catch:{ Exception -> 0x000c }
            goto L_0x0026
        L_0x000c:
            r5 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getPackageArchiveInfo Exception. "
            r2.append(r3)
            java.lang.String r5 = r5.getMessage()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            com.huawei.hms.support.log.HMSLog.e(r0, r5)
            r5 = r1
        L_0x0026:
            r2 = 0
            if (r5 == 0) goto L_0x0087
            android.content.pm.Signature[] r3 = r5.signatures
            int r3 = r3.length
            if (r3 <= 0) goto L_0x0087
            java.lang.String r3 = r5.packageName
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x0037
            return r2
        L_0x0037:
            android.content.pm.Signature[] r5 = r5.signatures     // Catch:{ IOException -> 0x0066, CertificateException -> 0x0064 }
            r5 = r5[r2]     // Catch:{ IOException -> 0x0066, CertificateException -> 0x0064 }
            byte[] r5 = r5.toByteArray()     // Catch:{ IOException -> 0x0066, CertificateException -> 0x0064 }
            java.io.InputStream r1 = com.huawei.hms.utils.IOUtils.toInputStream(r5)     // Catch:{ IOException -> 0x0066, CertificateException -> 0x0064 }
            java.lang.String r5 = "X.509"
            java.security.cert.CertificateFactory r5 = java.security.cert.CertificateFactory.getInstance(r5)     // Catch:{ IOException -> 0x0066, CertificateException -> 0x0064 }
            java.security.cert.Certificate r5 = r5.generateCertificate(r1)     // Catch:{ IOException -> 0x0066, CertificateException -> 0x0064 }
            byte[] r5 = r5.getEncoded()     // Catch:{ IOException -> 0x0066, CertificateException -> 0x0064 }
            byte[] r5 = com.huawei.hms.utils.SHA256.digest((byte[]) r5)     // Catch:{ IOException -> 0x0066, CertificateException -> 0x0064 }
            r6 = 1
            java.lang.String r5 = com.huawei.hms.utils.HEX.encodeHexString(r5, r6)     // Catch:{ IOException -> 0x0066, CertificateException -> 0x0064 }
            boolean r5 = r7.equalsIgnoreCase(r5)     // Catch:{ IOException -> 0x0066, CertificateException -> 0x0064 }
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r1)
            return r5
        L_0x0062:
            r5 = move-exception
            goto L_0x0083
        L_0x0064:
            r5 = move-exception
            goto L_0x0067
        L_0x0066:
            r5 = move-exception
        L_0x0067:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r6.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r7 = "Failed to get application signature certificate fingerprint."
            r6.append(r7)     // Catch:{ all -> 0x0062 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0062 }
            r6.append(r5)     // Catch:{ all -> 0x0062 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0062 }
            com.huawei.hms.support.log.HMSLog.e(r0, r5)     // Catch:{ all -> 0x0062 }
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r1)
            goto L_0x0087
        L_0x0083:
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r1)
            throw r5
        L_0x0087:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.PackageManagerHelper.verifyPackageArchive(java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
