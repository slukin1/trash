package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    /* access modifiers changed from: private */
    public static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.getInstance();
    private static final Object zzb = new Object();
    private static Method zzc = null;
    private static Method zzd = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i11, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Context context2;
        Preconditions.checkNotNull(context, "Context must not be null");
        zza.verifyGooglePlayServicesIsAvailable(context, 11925000);
        synchronized (zzb) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                context2 = DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.providerinstaller.dynamite").getModuleContext();
            } catch (DynamiteModule.LoadingException e11) {
                Log.w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(e11.getMessage())));
                context2 = null;
            }
            if (context2 != null) {
                zzc(context2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                return;
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext != null) {
                try {
                    if (zzd == null) {
                        Class cls = Long.TYPE;
                        zzd = zzb(remoteContext, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[]{Context.class, cls, cls});
                    }
                    zzd.invoke((Object) null, new Object[]{context, Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2)});
                } catch (Exception e12) {
                    Log.w("ProviderInstaller", "Failed to report request stats: ".concat(String.valueOf(e12.getMessage())));
                }
            }
            if (remoteContext != null) {
                zzc(remoteContext, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
            } else {
                Log.e("ProviderInstaller", "Failed to get remote context");
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    private static Method zzb(Context context, String str, String str2, Class[] clsArr) throws ClassNotFoundException, NoSuchMethodException {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    private static void zzc(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        try {
            if (zzc == null) {
                zzc = zzb(context, str, "insertProvider", new Class[]{Context.class});
            }
            zzc.invoke((Object) null, new Object[]{context});
        } catch (Exception e11) {
            Throwable cause = e11.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e11.getMessage() : cause.getMessage())));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}
