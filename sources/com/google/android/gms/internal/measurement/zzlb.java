package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkx;
import com.google.android.gms.internal.measurement.zzlb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzlb<MessageType extends zzlb<MessageType, BuilderType>, BuilderType extends zzkx<MessageType, BuilderType>> extends zzjk<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    public zznl zzc = zznl.zzc();
    private int zzd = -1;

    private final int zza(zzmt zzmt) {
        if (zzmt != null) {
            return zzmt.zza(this);
        }
        return zzmq.zza().zzb(getClass()).zza(this);
    }

    public static zzlb zzbC(Class cls) {
        Map map = zza;
        zzlb zzlb = (zzlb) map.get(cls);
        if (zzlb == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzlb = (zzlb) map.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (zzlb == null) {
            zzlb = (zzlb) ((zzlb) zznu.zze(cls)).zzl(6, (Object) null, (Object) null);
            if (zzlb != null) {
                map.put(cls, zzlb);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzlb;
    }

    public static zzlg zzbE() {
        return zzlc.zzf();
    }

    public static zzlh zzbF() {
        return zzlx.zzf();
    }

    public static zzlh zzbG(zzlh zzlh) {
        int size = zzlh.size();
        return zzlh.zze(size == 0 ? 10 : size + size);
    }

    public static zzli zzbH() {
        return zzmr.zze();
    }

    public static zzli zzbI(zzli zzli) {
        int size = zzli.size();
        return zzli.zzd(size == 0 ? 10 : size + size);
    }

    public static Object zzbK(Method method, Object obj, Object... objArr) {
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

    public static Object zzbL(zzmi zzmi, String str, Object[] objArr) {
        return new zzms(zzmi, str, objArr);
    }

    public static void zzbO(Class cls, zzlb zzlb) {
        zzlb.zzbN();
        zza.put(cls, zzlb);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzmq.zza().zzb(getClass()).zzj(this, (zzlb) obj);
    }

    public final int hashCode() {
        if (zzbR()) {
            return zzby();
        }
        int i11 = this.zzb;
        if (i11 != 0) {
            return i11;
        }
        int zzby = zzby();
        this.zzb = zzby;
        return zzby;
    }

    public final String toString() {
        return zzmk.zza(this, super.toString());
    }

    public final zzkx zzbA() {
        return (zzkx) zzl(5, (Object) null, (Object) null);
    }

    public final zzkx zzbB() {
        zzkx zzkx = (zzkx) zzl(5, (Object) null, (Object) null);
        zzkx.zzaB(this);
        return zzkx;
    }

    public final zzlb zzbD() {
        return (zzlb) zzl(4, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzmh zzbJ() {
        return (zzkx) zzl(5, (Object) null, (Object) null);
    }

    public final void zzbM() {
        zzmq.zza().zzb(getClass()).zzf(this);
        zzbN();
    }

    public final void zzbN() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzbP(int i11) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final void zzbQ(zzki zzki) throws IOException {
        zzmq.zza().zzb(getClass()).zzi(this, zzkj.zza(zzki));
    }

    public final boolean zzbR() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzmi zzbV() {
        return (zzlb) zzl(6, (Object) null, (Object) null);
    }

    public final int zzbu(zzmt zzmt) {
        if (zzbR()) {
            int zza2 = zza(zzmt);
            if (zza2 >= 0) {
                return zza2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
        }
        int i11 = this.zzd & Integer.MAX_VALUE;
        if (i11 != Integer.MAX_VALUE) {
            return i11;
        }
        int zza3 = zza(zzmt);
        if (zza3 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza3;
            return zza3;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza3);
    }

    public final int zzby() {
        return zzmq.zza().zzb(getClass()).zzb(this);
    }

    public final int zzbz() {
        int i11;
        if (zzbR()) {
            i11 = zza((zzmt) null);
            if (i11 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i11);
            }
        } else {
            i11 = this.zzd & Integer.MAX_VALUE;
            if (i11 == Integer.MAX_VALUE) {
                i11 = zza((zzmt) null);
                if (i11 >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i11;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i11);
                }
            }
        }
        return i11;
    }

    public abstract Object zzl(int i11, Object obj, Object obj2);
}
