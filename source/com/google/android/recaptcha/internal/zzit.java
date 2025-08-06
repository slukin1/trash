package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.internal.zzin;
import com.google.android.recaptcha.internal.zzit;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzit<MessageType extends zzit<MessageType, BuilderType>, BuilderType extends zzin<MessageType, BuilderType>> extends zzgf<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    public zzlm zzc = zzlm.zzc();
    private int zzd = -1;

    public static Object zzA(zzke zzke, String str, Object[] objArr) {
        return new zzkp(zzke, str, objArr);
    }

    public static void zzD(Class cls, zzit zzit) {
        zzit.zzC();
        zzb.put(cls, zzit);
    }

    public static final boolean zzF(zzit zzit, boolean z11) {
        byte byteValue = ((Byte) zzit.zzh(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzkn.zza().zzb(zzit.getClass()).zzl(zzit);
        if (z11) {
            zzit.zzh(2, true != zzl ? null : zzit, (Object) null);
        }
        return zzl;
    }

    private final int zzf(zzkr zzkr) {
        return zzkn.zza().zzb(getClass()).zza(this);
    }

    private static zzit zzg(zzit zzit) throws zzje {
        if (zzit == null || zzit.zzo()) {
            return zzit;
        }
        zzje zza = new zzlk(zzit).zza();
        zza.zzh(zzit);
        throw zza;
    }

    private static zzit zzi(zzit zzit, byte[] bArr, int i11, int i12, zzie zzie) throws zzje {
        zzit zzs = zzit.zzs();
        try {
            zzkr zzb2 = zzkn.zza().zzb(zzs.getClass());
            zzb2.zzi(zzs, bArr, 0, i12, new zzgj(zzie));
            zzb2.zzf(zzs);
            return zzs;
        } catch (zzje e11) {
            e = e11;
            if (e.zzl()) {
                e = new zzje((IOException) e);
            }
            e.zzh(zzs);
            throw e;
        } catch (zzlk e12) {
            zzje zza = e12.zza();
            zza.zzh(zzs);
            throw zza;
        } catch (IOException e13) {
            if (e13.getCause() instanceof zzje) {
                throw ((zzje) e13.getCause());
            }
            zzje zzje = new zzje(e13);
            zzje.zzh(zzs);
            throw zzje;
        } catch (IndexOutOfBoundsException unused) {
            zzje zzj = zzje.zzj();
            zzj.zzh(zzs);
            throw zzj;
        }
    }

    public static zzir zzq(zzke zzke, Object obj, zzke zzke2, zziw zziw, int i11, zzmb zzmb, Class cls) {
        return new zzir(zzke, "", (zzke) null, new zziq((zziw) null, i11, zzmb, false, false), cls);
    }

    public static zzit zzr(Class cls) {
        Map map = zzb;
        zzit zzit = (zzit) map.get(cls);
        if (zzit == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzit = (zzit) map.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (zzit == null) {
            zzit = (zzit) ((zzit) zzlv.zze(cls)).zzh(6, (Object) null, (Object) null);
            if (zzit != null) {
                map.put(cls, zzit);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzit;
    }

    public static zzit zzt(zzit zzit, InputStream inputStream) throws zzje {
        zzhc zzhc;
        int i11 = zzhc.zzd;
        if (inputStream == null) {
            byte[] bArr = zzjc.zzd;
            int length = bArr.length;
            zzhc = zzhc.zzH(bArr, 0, 0, false);
        } else {
            zzhc = new zzha(inputStream, 4096, (zzgz) null);
        }
        zzie zzie = zzie.zza;
        zzit zzs = zzit.zzs();
        try {
            zzkr zzb2 = zzkn.zza().zzb(zzs.getClass());
            zzb2.zzh(zzs, zzhd.zzq(zzhc), zzie);
            zzb2.zzf(zzs);
            zzg(zzs);
            return zzs;
        } catch (zzje e11) {
            e = e11;
            if (e.zzl()) {
                e = new zzje((IOException) e);
            }
            e.zzh(zzs);
            throw e;
        } catch (zzlk e12) {
            zzje zza = e12.zza();
            zza.zzh(zzs);
            throw zza;
        } catch (IOException e13) {
            if (e13.getCause() instanceof zzje) {
                throw ((zzje) e13.getCause());
            }
            zzje zzje = new zzje(e13);
            zzje.zzh(zzs);
            throw zzje;
        } catch (RuntimeException e14) {
            if (e14.getCause() instanceof zzje) {
                throw ((zzje) e14.getCause());
            }
            throw e14;
        }
    }

    public static zzit zzu(zzit zzit, byte[] bArr) throws zzje {
        zzit zzi = zzi(zzit, bArr, 0, bArr.length, zzie.zza);
        zzg(zzi);
        return zzi;
    }

    public static zziy zzv() {
        return zziu.zzf();
    }

    public static zzja zzw() {
        return zzjt.zzf();
    }

    public static zzjb zzx() {
        return zzko.zze();
    }

    public static zzjb zzy(zzjb zzjb) {
        int size = zzjb.size();
        return zzjb.zzd(size == 0 ? 10 : size + size);
    }

    public static Object zzz(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e11);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzkn.zza().zzb(getClass()).zzk(this, (zzit) obj);
    }

    public final int hashCode() {
        if (zzG()) {
            return zzm();
        }
        int i11 = this.zza;
        if (i11 != 0) {
            return i11;
        }
        int zzm = zzm();
        this.zza = zzm;
        return zzm;
    }

    public final String toString() {
        return zzkg.zza(this, super.toString());
    }

    public final void zzB() {
        zzkn.zza().zzb(getClass()).zzf(this);
        zzC();
    }

    public final void zzC() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzE(int i11) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean zzG() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzkd zzW() {
        return (zzin) zzh(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzkd zzX() {
        zzin zzin = (zzin) zzh(5, (Object) null, (Object) null);
        zzin.zzg(this);
        return zzin;
    }

    public final /* synthetic */ zzke zzY() {
        return (zzit) zzh(6, (Object) null, (Object) null);
    }

    public final int zza(zzkr zzkr) {
        if (zzG()) {
            int zza = zzkr.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i11 = this.zzd & Integer.MAX_VALUE;
        if (i11 != Integer.MAX_VALUE) {
            return i11;
        }
        int zza2 = zzkr.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    public final void zze(zzhh zzhh) throws IOException {
        zzkn.zza().zzb(getClass()).zzj(this, zzhi.zza(zzhh));
    }

    public abstract Object zzh(int i11, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public final int zzm() {
        return zzkn.zza().zzb(getClass()).zzb(this);
    }

    public final int zzn() {
        int i11;
        if (zzG()) {
            i11 = zzf((zzkr) null);
            if (i11 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i11);
            }
        } else {
            i11 = this.zzd & Integer.MAX_VALUE;
            if (i11 == Integer.MAX_VALUE) {
                i11 = zzf((zzkr) null);
                if (i11 >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i11;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i11);
                }
            }
        }
        return i11;
    }

    public final boolean zzo() {
        return zzF(this, true);
    }

    public final zzin zzp() {
        return (zzin) zzh(5, (Object) null, (Object) null);
    }

    public final zzit zzs() {
        return (zzit) zzh(4, (Object) null, (Object) null);
    }
}
