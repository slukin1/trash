package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.stats.zzb;
import com.google.android.gms.internal.stats.zzc;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@ShowFirstParty
@KeepForSdk
public class WakeLock {
    private static final long zzb = TimeUnit.DAYS.toMillis(366);
    private static volatile ScheduledExecutorService zzc = null;
    private static final Object zzd = new Object();
    private static volatile zzd zze = new zzb();
    public zzb zza;
    private final Object zzf = new Object();
    private final PowerManager.WakeLock zzg;
    private int zzh = 0;
    private Future<?> zzi;
    private long zzj;
    private final Set<zze> zzk = new HashSet();
    private boolean zzl = true;
    private int zzm;
    private Clock zzn = DefaultClock.getInstance();
    private WorkSource zzo;
    private final String zzp;
    private final String zzq;
    private final Context zzr;
    private final Map<String, zzc> zzs = new HashMap();
    private AtomicInteger zzt = new AtomicInteger(0);
    private final ScheduledExecutorService zzu;

    @KeepForSdk
    public WakeLock(Context context, int i11, String str) {
        String str2;
        String packageName = context.getPackageName();
        Preconditions.checkNotNull(context, "WakeLock: context must not be null");
        Preconditions.checkNotEmpty(str, "WakeLock: wakeLockName must not be empty");
        this.zzr = context.getApplicationContext();
        this.zzq = str;
        this.zza = null;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "*gcore*:".concat(valueOf);
            } else {
                str2 = new String("*gcore*:");
            }
            this.zzp = str2;
        } else {
            this.zzp = str;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i11, str);
            this.zzg = newWakeLock;
            if (WorkSourceUtil.hasWorkSourcePermission(context)) {
                WorkSource fromPackage = WorkSourceUtil.fromPackage(context, Strings.isEmptyOrWhitespace(packageName) ? context.getPackageName() : packageName);
                this.zzo = fromPackage;
                if (fromPackage != null) {
                    zze(newWakeLock, fromPackage);
                }
            }
            ScheduledExecutorService scheduledExecutorService = zzc;
            if (scheduledExecutorService == null) {
                synchronized (zzd) {
                    scheduledExecutorService = zzc;
                    if (scheduledExecutorService == null) {
                        zzh.zza();
                        scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        zzc = scheduledExecutorService;
                    }
                }
            }
            this.zzu = scheduledExecutorService;
            return;
        }
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("expected a non-null reference", 0, 29);
        throw new zzi(sb2.toString());
    }

    public static /* synthetic */ void zza(WakeLock wakeLock) {
        synchronized (wakeLock.zzf) {
            if (wakeLock.isHeld()) {
                Log.e("WakeLock", String.valueOf(wakeLock.zzp).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                wakeLock.zzc();
                if (wakeLock.isHeld()) {
                    wakeLock.zzh = 1;
                    wakeLock.zzd(0);
                }
            }
        }
    }

    private final String zzb(String str) {
        if (this.zzl) {
            TextUtils.isEmpty((CharSequence) null);
        }
        return null;
    }

    private final void zzc() {
        if (!this.zzk.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.zzk);
            this.zzk.clear();
            if (arrayList.size() > 0) {
                zze zze2 = (zze) arrayList.get(0);
                throw null;
            }
        }
    }

    private final void zzd(int i11) {
        synchronized (this.zzf) {
            if (isHeld()) {
                if (this.zzl) {
                    int i12 = this.zzh - 1;
                    this.zzh = i12;
                    if (i12 > 0) {
                        return;
                    }
                } else {
                    this.zzh = 0;
                }
                zzc();
                for (zzc zzc2 : this.zzs.values()) {
                    zzc2.zza = 0;
                }
                this.zzs.clear();
                Future<?> future = this.zzi;
                if (future != null) {
                    future.cancel(false);
                    this.zzi = null;
                    this.zzj = 0;
                }
                this.zzm = 0;
                if (this.zzg.isHeld()) {
                    try {
                        this.zzg.release();
                        if (this.zza != null) {
                            this.zza = null;
                        }
                    } catch (RuntimeException e11) {
                        if (e11.getClass().equals(RuntimeException.class)) {
                            Log.e("WakeLock", String.valueOf(this.zzp).concat(" failed to release!"), e11);
                            if (this.zza != null) {
                                this.zza = null;
                            }
                            return;
                        }
                        throw e11;
                    } catch (Throwable th2) {
                        if (this.zza != null) {
                            this.zza = null;
                        }
                        throw th2;
                    }
                } else {
                    Log.e("WakeLock", String.valueOf(this.zzp).concat(" should be held!"));
                }
            }
        }
    }

    private static void zze(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e11) {
            Log.wtf("WakeLock", e11.toString());
        }
    }

    @KeepForSdk
    public void acquire(long j11) {
        this.zzt.incrementAndGet();
        long j12 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, zzb), 1);
        if (j11 > 0) {
            max = Math.min(j11, max);
        }
        synchronized (this.zzf) {
            if (!isHeld()) {
                this.zza = zzb.zza(false, (zzc) null);
                this.zzg.acquire();
                this.zzn.elapsedRealtime();
            }
            this.zzh++;
            this.zzm++;
            zzb((String) null);
            zzc zzc2 = this.zzs.get((Object) null);
            if (zzc2 == null) {
                zzc2 = new zzc((zzb) null);
                this.zzs.put((Object) null, zzc2);
            }
            zzc2.zza++;
            long elapsedRealtime = this.zzn.elapsedRealtime();
            if (Long.MAX_VALUE - elapsedRealtime > max) {
                j12 = elapsedRealtime + max;
            }
            if (j12 > this.zzj) {
                this.zzj = j12;
                Future<?> future = this.zzi;
                if (future != null) {
                    future.cancel(false);
                }
                this.zzi = this.zzu.schedule(new zza(this), max, TimeUnit.MILLISECONDS);
            }
        }
    }

    @KeepForSdk
    public boolean isHeld() {
        boolean z11;
        synchronized (this.zzf) {
            z11 = this.zzh > 0;
        }
        return z11;
    }

    @KeepForSdk
    public void release() {
        if (this.zzt.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.zzp).concat(" release without a matched acquire!"));
        }
        synchronized (this.zzf) {
            zzb((String) null);
            if (this.zzs.containsKey((Object) null)) {
                zzc zzc2 = this.zzs.get((Object) null);
                if (zzc2 != null) {
                    int i11 = zzc2.zza - 1;
                    zzc2.zza = i11;
                    if (i11 == 0) {
                        this.zzs.remove((Object) null);
                    }
                }
            } else {
                Log.w("WakeLock", String.valueOf(this.zzp).concat(" counter does not exist"));
            }
            zzd(0);
        }
    }

    @KeepForSdk
    public void setReferenceCounted(boolean z11) {
        synchronized (this.zzf) {
            this.zzl = z11;
        }
    }
}
