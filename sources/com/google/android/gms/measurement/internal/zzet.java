package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpe;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.xiaomi.mipush.sdk.Constants;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzet extends zzgx {
    /* access modifiers changed from: private */
    public char zza = 0;
    /* access modifiers changed from: private */
    public long zzb = -1;
    private String zzc;
    private final zzer zzd = new zzer(this, 6, false, false);
    private final zzer zze = new zzer(this, 6, true, false);
    private final zzer zzf = new zzer(this, 6, false, true);
    private final zzer zzg = new zzer(this, 5, false, false);
    private final zzer zzh = new zzer(this, 5, true, false);
    private final zzer zzi = new zzer(this, 5, false, true);
    private final zzer zzj = new zzer(this, 4, false, false);
    private final zzer zzk = new zzer(this, 3, false, false);
    private final zzer zzl = new zzer(this, 2, false, false);

    public zzet(zzgd zzgd) {
        super(zzgd);
    }

    public static Object zzn(String str) {
        if (str == null) {
            return null;
        }
        return new zzes(str);
    }

    public static String zzo(boolean z11, String str, Object obj, Object obj2, Object obj3) {
        String zzp = zzp(z11, obj);
        String zzp2 = zzp(z11, obj2);
        String zzp3 = zzp(z11, obj3);
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            str2 = l.f34627b;
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zzp)) {
            sb2.append(str2);
            sb2.append(zzp);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(zzp2)) {
            sb2.append(str2);
            sb2.append(zzp2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(zzp3)) {
            sb2.append(str3);
            sb2.append(zzp3);
        }
        return sb2.toString();
    }

    public static String zzp(boolean z11, Object obj) {
        String className;
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i11 = 0;
        if (obj instanceof Long) {
            if (!z11) {
                return obj.toString();
            }
            Long l11 = (Long) obj;
            if (Math.abs(l11.longValue()) < 100) {
                return obj.toString();
            }
            char charAt = obj.toString().charAt(0);
            String valueOf = String.valueOf(Math.abs(l11.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 4.0d);
            StringBuilder sb2 = new StringBuilder();
            if (charAt == '-') {
                str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            sb2.append(str);
            sb2.append(round);
            sb2.append("...");
            sb2.append(str);
            sb2.append(round2);
            return sb2.toString();
        } else if (obj instanceof Boolean) {
            return obj.toString();
        } else {
            if (obj instanceof Throwable) {
                Throwable th2 = (Throwable) obj;
                StringBuilder sb3 = new StringBuilder(z11 ? th2.getClass().getName() : th2.toString());
                String zzq = zzq(zzgd.class.getCanonicalName());
                StackTraceElement[] stackTrace = th2.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i11];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzq(className).equals(zzq)) {
                        sb3.append(l.f34627b);
                        sb3.append(stackTraceElement);
                        break;
                    }
                    i11++;
                }
                return sb3.toString();
            } else if (obj instanceof zzes) {
                return ((zzes) obj).zza;
            } else {
                if (z11) {
                    return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
                }
                return obj.toString();
            }
        }
    }

    public static String zzq(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            return str.substring(0, lastIndexOf);
        }
        zzpe.zzc();
        if (((Boolean) zzeg.zzay.zza((Object) null)).booleanValue()) {
            return "";
        }
        return str;
    }

    public final zzer zzc() {
        return this.zzk;
    }

    public final zzer zzd() {
        return this.zzd;
    }

    public final zzer zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return false;
    }

    public final zzer zzh() {
        return this.zze;
    }

    public final zzer zzi() {
        return this.zzj;
    }

    public final zzer zzj() {
        return this.zzl;
    }

    public final zzer zzk() {
        return this.zzg;
    }

    public final zzer zzl() {
        return this.zzi;
    }

    public final zzer zzm() {
        return this.zzh;
    }

    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    public final String zzr() {
        String str;
        synchronized (this) {
            if (this.zzc == null) {
                if (this.zzt.zzy() != null) {
                    this.zzc = this.zzt.zzy();
                } else {
                    this.zzc = this.zzt.zzf().zzn();
                }
            }
            Preconditions.checkNotNull(this.zzc);
            str = this.zzc;
        }
        return str;
    }

    public final void zzu(int i11, boolean z11, boolean z12, String str, Object obj, Object obj2, Object obj3) {
        if (!z11 && Log.isLoggable(zzr(), i11)) {
            Log.println(i11, zzr(), zzo(false, str, obj, obj2, obj3));
        }
        if (!z12 && i11 >= 5) {
            Preconditions.checkNotNull(str);
            zzga zzo = this.zzt.zzo();
            if (zzo == null) {
                Log.println(6, zzr(), "Scheduler not set. Not logging error/warn");
            } else if (!zzo.zzy()) {
                Log.println(6, zzr(), "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i11 >= 9) {
                    i11 = 8;
                }
                zzo.zzp(new zzeq(this, i11, str, obj, obj2, obj3));
            }
        }
    }
}
