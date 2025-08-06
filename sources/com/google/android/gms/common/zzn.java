package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.errorprone.annotations.CheckReturnValue;
import java.security.MessageDigest;

@CheckReturnValue
final class zzn {
    public static final zzl zza = new zzf(zzj.zze("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));
    public static final zzl zzb = new zzg(zzj.zze("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));
    public static final zzl zzc = new zzh(zzj.zze("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));
    public static final zzl zzd = new zzi(zzj.zze("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));
    private static volatile zzag zze;
    private static final Object zzf = new Object();
    private static Context zzg;

    public static zzx zza(String str, zzj zzj, boolean z11, boolean z12) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzh(str, zzj, z11, z12);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static zzx zzb(String str, boolean z11, boolean z12, boolean z13) {
        return zzi(str, z11, false, false, true);
    }

    public static zzx zzc(String str, boolean z11, boolean z12, boolean z13) {
        return zzi(str, z11, false, false, false);
    }

    public static /* synthetic */ String zzd(boolean z11, String str, zzj zzj) throws Exception {
        String str2 = true != (!z11 && zzh(str, zzj, true, false).zza) ? "not allowed" : "debug cert rejected";
        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-256");
        Preconditions.checkNotNull(zza2);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", new Object[]{str2, str, Hex.bytesToStringLowercase(zza2.digest(zzj.zzf())), Boolean.valueOf(z11), "12451000.false"});
    }

    public static synchronized void zze(Context context) {
        synchronized (zzn.class) {
            if (zzg != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzg = context.getApplicationContext();
            }
        }
    }

    public static boolean zzf() {
        boolean z11;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            zzj();
            z11 = zze.zzg();
        } catch (RemoteException | DynamiteModule.LoadingException e11) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
            z11 = false;
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th2;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return z11;
    }

    public static boolean zzg() {
        boolean z11;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            zzj();
            z11 = zze.zzi();
        } catch (RemoteException | DynamiteModule.LoadingException e11) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
            z11 = false;
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th2;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return z11;
    }

    private static zzx zzh(String str, zzj zzj, boolean z11, boolean z12) {
        try {
            zzj();
            Preconditions.checkNotNull(zzg);
            try {
                return zze.zzh(new zzs(str, zzj, z11, z12), ObjectWrapper.wrap(zzg.getPackageManager())) ? zzx.zzb() : new zzv(new zze(z11, str, zzj), (zzu) null);
            } catch (RemoteException e11) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
                return zzx.zzd("module call", e11);
            }
        } catch (DynamiteModule.LoadingException e12) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e12);
            return zzx.zzd("module init: ".concat(String.valueOf(e12.getMessage())), e12);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    private static zzx zzi(String str, boolean z11, boolean z12, boolean z13, boolean z14) {
        zzx zzx;
        zzq zzq;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(zzg);
            try {
                zzj();
                zzo zzo = new zzo(str, z11, false, ObjectWrapper.wrap(zzg), false, true);
                if (z14) {
                    zzq = zze.zze(zzo);
                } else {
                    zzq = zze.zzf(zzo);
                }
                if (zzq.zzb()) {
                    zzx = zzx.zzf(zzq.zzc());
                } else {
                    String zza2 = zzq.zza();
                    PackageManager.NameNotFoundException nameNotFoundException = zzq.zzd() == 4 ? new PackageManager.NameNotFoundException() : null;
                    if (zza2 == null) {
                        zza2 = "error checking package certificate";
                    }
                    zzx = zzx.zzg(zzq.zzc(), zzq.zzd(), zza2, nameNotFoundException);
                }
            } catch (DynamiteModule.LoadingException e11) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
                zzx = zzx.zzd("module init: ".concat(String.valueOf(e11.getMessage())), e11);
            }
        } catch (RemoteException e12) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e12);
            zzx = zzx.zzd("module call", e12);
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th2;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return zzx;
    }

    private static void zzj() throws DynamiteModule.LoadingException {
        if (zze == null) {
            Preconditions.checkNotNull(zzg);
            synchronized (zzf) {
                if (zze == null) {
                    zze = zzaf.zzb(DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            }
        }
    }
}
