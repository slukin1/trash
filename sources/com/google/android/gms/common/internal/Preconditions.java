package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.zzb;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.FormatMethod;
import com.google.errorprone.annotations.FormatString;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@KeepForSdk
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static void checkArgument(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    @KeepForSdk
    public static double checkArgumentInRange(double d11, double d12, double d13, String str) {
        if (d11 < d12) {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d12), Double.valueOf(d13)));
        } else if (d11 <= d13) {
            return d11;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d12), Double.valueOf(d13)));
        }
    }

    @KeepForSdk
    public static void checkHandlerThread(Handler handler) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            throw new IllegalStateException("Must be called on " + name2 + " thread, but got " + name + InstructionFileId.DOT);
        }
    }

    @KeepForSdk
    public static void checkMainThread() {
        checkMainThread("Must be called on the main application thread");
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    @KeepForSdk
    public static void checkNotGoogleApiHandlerThread() {
        checkNotGoogleApiHandlerThread("Must not be called on GoogleApiHandler thread.");
    }

    @KeepForSdk
    public static void checkNotMainThread() {
        checkNotMainThread("Must not be called on the main application thread");
    }

    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static <T> T checkNotNull(T t11) {
        Objects.requireNonNull(t11, "null reference");
        return t11;
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static int checkNotZero(int i11) {
        if (i11 != 0) {
            return i11;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    @KeepForSdk
    public static void checkState(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static String zza(String str, Object... objArr) {
        int indexOf;
        StringBuilder sb2 = new StringBuilder(str.length() + 48);
        int i11 = 0;
        int i12 = 0;
        while (i11 < 3 && (indexOf = str.indexOf("%s", i12)) != -1) {
            sb2.append(str.substring(i12, indexOf));
            sb2.append(objArr[i11]);
            i12 = indexOf + 2;
            i11++;
        }
        sb2.append(str.substring(i12));
        if (i11 < 3) {
            sb2.append(" [");
            sb2.append(objArr[i11]);
            for (int i13 = i11 + 1; i13 < 3; i13++) {
                sb2.append(", ");
                sb2.append(objArr[i13]);
            }
            sb2.append("]");
        }
        return sb2.toString();
    }

    @KeepForSdk
    public static void checkArgument(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void checkMainThread(String str) {
        if (!zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    public static void checkNotGoogleApiHandlerThread(String str) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            String name = myLooper.getThread().getName();
            if (name == "GoogleApiHandler" || (name != null && name.equals("GoogleApiHandler"))) {
                throw new IllegalStateException(str);
            }
        }
    }

    @KeepForSdk
    public static void checkNotMainThread(String str) {
        if (zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static <T> T checkNotNull(T t11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static int checkNotZero(int i11, Object obj) {
        if (i11 != 0) {
            return i11;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    public static void checkState(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void checkArgument(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static long checkNotZero(long j11) {
        if (j11 != 0) {
            return j11;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    @FormatMethod
    @KeepForSdk
    public static void checkState(boolean z11, @FormatString String str, Object... objArr) {
        if (!z11) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    @KeepForSdk
    public static float checkArgumentInRange(float f11, float f12, float f13, String str) {
        if (f11 < f12) {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f12), Float.valueOf(f13)));
        } else if (f11 <= f13) {
            return f11;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f12), Float.valueOf(f13)));
        }
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static long checkNotZero(long j11, Object obj) {
        if (j11 != 0) {
            return j11;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    public static void checkHandlerThread(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static int checkArgumentInRange(int i11, int i12, int i13, String str) {
        if (i11 < i12) {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i12), Integer.valueOf(i13)));
        } else if (i11 <= i13) {
            return i11;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i12), Integer.valueOf(i13)));
        }
    }

    @KeepForSdk
    public static long checkArgumentInRange(long j11, long j12, long j13, String str) {
        if (j11 < j12) {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j12), Long.valueOf(j13)));
        } else if (j11 <= j13) {
            return j11;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j12), Long.valueOf(j13)));
        }
    }
}
