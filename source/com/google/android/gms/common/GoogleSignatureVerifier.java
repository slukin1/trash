package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.Set;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@ShowFirstParty
@KeepForSdk
@CheckReturnValue
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zza;
    private static volatile Set zzb;
    private final Context zzc;
    private volatile String zzd;

    public GoogleSignatureVerifier(Context context) {
        this.zzc = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzn.zze(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    public static final zzj zza(PackageInfo packageInfo, zzj... zzjArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i11 = 0; i11 < zzjArr.length; i11++) {
                if (zzjArr[i11].equals(zzk)) {
                    return zzjArr[i11];
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zzb(android.content.pm.PackageInfo r4, boolean r5) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x002a
            if (r4 == 0) goto L_0x0028
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.android.vending"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x001a
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.google.android.gms"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x002a
        L_0x001a:
            android.content.pm.ApplicationInfo r5 = r4.applicationInfo
            if (r5 != 0) goto L_0x0020
        L_0x001e:
            r5 = r1
            goto L_0x002a
        L_0x0020:
            int r5 = r5.flags
            r5 = r5 & 129(0x81, float:1.81E-43)
            if (r5 == 0) goto L_0x001e
            r5 = r0
            goto L_0x002a
        L_0x0028:
            r2 = 0
            goto L_0x002b
        L_0x002a:
            r2 = r4
        L_0x002b:
            if (r4 == 0) goto L_0x0049
            android.content.pm.Signature[] r4 = r2.signatures
            if (r4 == 0) goto L_0x0049
            if (r5 == 0) goto L_0x003a
            com.google.android.gms.common.zzj[] r4 = com.google.android.gms.common.zzm.zza
            com.google.android.gms.common.zzj r4 = zza(r2, r4)
            goto L_0x0046
        L_0x003a:
            com.google.android.gms.common.zzj[] r4 = new com.google.android.gms.common.zzj[r0]
            com.google.android.gms.common.zzj[] r5 = com.google.android.gms.common.zzm.zza
            r5 = r5[r1]
            r4[r1] = r5
            com.google.android.gms.common.zzj r4 = zza(r2, r4)
        L_0x0046:
            if (r4 == 0) goto L_0x0049
            return r0
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zzb(android.content.pm.PackageInfo, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        r8 = r8.applicationInfo;
     */
    @android.annotation.SuppressLint({"PackageManagerGetSignatures"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.common.zzx zzc(java.lang.String r6, boolean r7, boolean r8) {
        /*
            r5 = this;
            java.lang.String r7 = "null pkg"
            if (r6 != 0) goto L_0x0009
            com.google.android.gms.common.zzx r6 = com.google.android.gms.common.zzx.zzc(r7)
            return r6
        L_0x0009:
            java.lang.String r8 = r5.zzd
            boolean r8 = r6.equals(r8)
            if (r8 != 0) goto L_0x0091
            boolean r8 = com.google.android.gms.common.zzn.zzg()
            r0 = 0
            if (r8 == 0) goto L_0x0023
            android.content.Context r7 = r5.zzc
            boolean r7 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r7)
            com.google.android.gms.common.zzx r7 = com.google.android.gms.common.zzn.zzb(r6, r7, r0, r0)
            goto L_0x007e
        L_0x0023:
            android.content.Context r8 = r5.zzc     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0085 }
            r1 = 64
            android.content.pm.PackageInfo r8 = r8.getPackageInfo(r6, r1)     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.Context r1 = r5.zzc
            boolean r1 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r1)
            if (r8 != 0) goto L_0x003c
            com.google.android.gms.common.zzx r7 = com.google.android.gms.common.zzx.zzc(r7)
            goto L_0x007e
        L_0x003c:
            android.content.pm.Signature[] r7 = r8.signatures
            if (r7 == 0) goto L_0x0077
            int r7 = r7.length
            r2 = 1
            if (r7 == r2) goto L_0x0045
            goto L_0x0077
        L_0x0045:
            com.google.android.gms.common.zzk r7 = new com.google.android.gms.common.zzk
            android.content.pm.Signature[] r3 = r8.signatures
            r3 = r3[r0]
            byte[] r3 = r3.toByteArray()
            r7.<init>(r3)
            java.lang.String r3 = r8.packageName
            com.google.android.gms.common.zzx r1 = com.google.android.gms.common.zzn.zza(r3, r7, r1, r0)
            boolean r4 = r1.zza
            if (r4 == 0) goto L_0x0075
            android.content.pm.ApplicationInfo r8 = r8.applicationInfo
            if (r8 == 0) goto L_0x0075
            int r8 = r8.flags
            r8 = r8 & 2
            if (r8 == 0) goto L_0x0075
            com.google.android.gms.common.zzx r7 = com.google.android.gms.common.zzn.zza(r3, r7, r0, r2)
            boolean r7 = r7.zza
            if (r7 == 0) goto L_0x0075
            java.lang.String r7 = "debuggable release cert app rejected"
            com.google.android.gms.common.zzx r7 = com.google.android.gms.common.zzx.zzc(r7)
            goto L_0x007e
        L_0x0075:
            r7 = r1
            goto L_0x007e
        L_0x0077:
            java.lang.String r7 = "single cert required"
            com.google.android.gms.common.zzx r7 = com.google.android.gms.common.zzx.zzc(r7)
        L_0x007e:
            boolean r8 = r7.zza
            if (r8 == 0) goto L_0x0084
            r5.zzd = r6
        L_0x0084:
            return r7
        L_0x0085:
            r7 = move-exception
            java.lang.String r8 = "no pkg "
            java.lang.String r6 = r8.concat(r6)
            com.google.android.gms.common.zzx r6 = com.google.android.gms.common.zzx.zzd(r6, r7)
            return r6
        L_0x0091:
            com.google.android.gms.common.zzx r6 = com.google.android.gms.common.zzx.zzb()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zzc(java.lang.String, boolean, boolean):com.google.android.gms.common.zzx");
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(String str) {
        zzx zzc2 = zzc(str, false, false);
        zzc2.zze();
        return zzc2.zza;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i11) {
        zzx zzx;
        int length;
        String[] packagesForUid = this.zzc.getPackageManager().getPackagesForUid(i11);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzx = null;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    Preconditions.checkNotNull(zzx);
                    break;
                }
                zzx = zzc(packagesForUid[i12], false, false);
                if (zzx.zza) {
                    break;
                }
                i12++;
            }
        } else {
            zzx = zzx.zzc("no pkgs");
        }
        zzx.zze();
        return zzx.zza;
    }
}
