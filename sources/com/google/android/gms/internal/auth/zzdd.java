package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

public final class zzdd implements zzcl {
    private static final Map zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    public static zzdd zza(Context context, String str, Runnable runnable) {
        zzdd zzdd;
        if (!zzcc.zzb()) {
            synchronized (zzdd.class) {
                zzdd = (zzdd) zza.get((Object) null);
                if (zzdd == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th2) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th2;
                    }
                }
            }
            return zzdd;
        }
        throw null;
    }

    public static synchronized void zzc() {
        synchronized (zzdd.class) {
            Map map = zza;
            Iterator it2 = map.values().iterator();
            if (!it2.hasNext()) {
                map.clear();
            } else {
                SharedPreferences sharedPreferences = ((zzdd) it2.next()).zzb;
                throw null;
            }
        }
    }

    public final Object zzb(String str) {
        throw null;
    }
}
