package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ExoPlaybackException extends Exception implements Bundleable {
    public static final Bundleable.Creator<ExoPlaybackException> CREATOR = b.f65848a;
    private static final int FIELD_CAUSE_CLASS_NAME = 8;
    private static final int FIELD_CAUSE_MESSAGE = 9;
    private static final int FIELD_IS_RECOVERABLE = 7;
    private static final int FIELD_MESSAGE = 0;
    private static final int FIELD_RENDERER_FORMAT = 4;
    private static final int FIELD_RENDERER_FORMAT_SUPPORT = 5;
    private static final int FIELD_RENDERER_INDEX = 3;
    private static final int FIELD_RENDERER_NAME = 2;
    private static final int FIELD_TIME_STAMP_MS = 6;
    private static final int FIELD_TYPE = 1;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    private final Throwable cause;
    public final boolean isRecoverable;
    public final MediaPeriodId mediaPeriodId;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final long timestampMs;
    public final int type;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private ExoPlaybackException(int i11, Throwable th2) {
        this(i11, th2, (String) null, (String) null, -1, (Format) null, 4, false);
    }

    public static ExoPlaybackException createForRemote(String str) {
        return new ExoPlaybackException(3, str);
    }

    public static ExoPlaybackException createForRenderer(Exception exc) {
        return new ExoPlaybackException(1, exc, (String) null, (String) null, -1, (Format) null, 4, false);
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, (Throwable) iOException);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, (Throwable) runtimeException);
    }

    private static RemoteException createRemoteException(String str) {
        return new RemoteException(str);
    }

    private static Throwable createThrowable(Class<?> cls, String str) throws Exception {
        return (Throwable) cls.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
    }

    private static String deriveMessage(int i11, String str, String str2, int i12, Format format, int i13) {
        String str3;
        if (i11 == 0) {
            str3 = "Source error";
        } else if (i11 != 1) {
            str3 = i11 != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            String valueOf = String.valueOf(format);
            String formatSupportString = C.getFormatSupportString(i13);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 53 + valueOf.length() + String.valueOf(formatSupportString).length());
            sb2.append(str2);
            sb2.append(" error, index=");
            sb2.append(i12);
            sb2.append(", format=");
            sb2.append(valueOf);
            sb2.append(", format_supported=");
            sb2.append(formatSupportString);
            str3 = sb2.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        String valueOf2 = String.valueOf(str3);
        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 2 + String.valueOf(str).length());
        sb3.append(valueOf2);
        sb3.append(l.f34627b);
        sb3.append(str);
        return sb3.toString();
    }

    /* access modifiers changed from: private */
    public static ExoPlaybackException fromBundle(Bundle bundle) {
        int i11 = bundle.getInt(keyForField(1), 2);
        String string = bundle.getString(keyForField(2));
        int i12 = bundle.getInt(keyForField(3), -1);
        Format format = (Format) bundle.getParcelable(keyForField(4));
        int i13 = bundle.getInt(keyForField(5), 4);
        long j11 = bundle.getLong(keyForField(6), SystemClock.elapsedRealtime());
        boolean z11 = bundle.getBoolean(keyForField(7), false);
        String string2 = bundle.getString(keyForField(0));
        if (string2 == null) {
            string2 = deriveMessage(i11, (String) null, string, i12, format, i13);
        }
        String str = string2;
        String string3 = bundle.getString(keyForField(8));
        String string4 = bundle.getString(keyForField(9));
        Throwable th2 = null;
        if (!TextUtils.isEmpty(string3)) {
            try {
                Class<?> cls = Class.forName(string3, true, ExoPlaybackException.class.getClassLoader());
                if (Throwable.class.isAssignableFrom(cls)) {
                    th2 = createThrowable(cls, string4);
                }
            } catch (Throwable unused) {
                th2 = createRemoteException(string4);
            }
        }
        return new ExoPlaybackException(str, th2, i11, string, i12, format, i13, (MediaPeriodId) null, j11, z11);
    }

    private static String keyForField(int i11) {
        return Integer.toString(i11, 36);
    }

    public ExoPlaybackException copyWithMediaPeriodId(MediaPeriodId mediaPeriodId2) {
        return new ExoPlaybackException((String) Util.castNonNull(getMessage()), this.cause, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, mediaPeriodId2, this.timestampMs, this.isRecoverable);
    }

    public Exception getRendererException() {
        boolean z11 = true;
        if (this.type != 1) {
            z11 = false;
        }
        Assertions.checkState(z11);
        return (Exception) Assertions.checkNotNull(this.cause);
    }

    public IOException getSourceException() {
        Assertions.checkState(this.type == 0);
        return (IOException) Assertions.checkNotNull(this.cause);
    }

    public RuntimeException getUnexpectedException() {
        Assertions.checkState(this.type == 2);
        return (RuntimeException) Assertions.checkNotNull(this.cause);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(keyForField(0), getMessage());
        bundle.putInt(keyForField(1), this.type);
        bundle.putString(keyForField(2), this.rendererName);
        bundle.putInt(keyForField(3), this.rendererIndex);
        bundle.putParcelable(keyForField(4), this.rendererFormat);
        bundle.putInt(keyForField(5), this.rendererFormatSupport);
        bundle.putLong(keyForField(6), this.timestampMs);
        bundle.putBoolean(keyForField(7), this.isRecoverable);
        if (this.cause != null) {
            bundle.putString(keyForField(8), this.cause.getClass().getName());
            bundle.putString(keyForField(9), this.cause.getMessage());
        }
        return bundle;
    }

    private ExoPlaybackException(int i11, String str) {
        this(i11, (Throwable) null, str, (String) null, -1, (Format) null, 4, false);
    }

    public static ExoPlaybackException createForRenderer(Throwable th2, String str, int i11, Format format, int i12) {
        return createForRenderer(th2, str, i11, format, i12, false);
    }

    private ExoPlaybackException(int i11, Throwable th2, String str, String str2, int i12, Format format, int i13, boolean z11) {
        this(deriveMessage(i11, str, str2, i12, format, i13), th2, i11, str2, i12, format, i13, (MediaPeriodId) null, SystemClock.elapsedRealtime(), z11);
    }

    public static ExoPlaybackException createForRenderer(Throwable th2, String str, int i11, Format format, int i12, boolean z11) {
        if (format == null) {
            i12 = 4;
        }
        return new ExoPlaybackException(1, th2, (String) null, str, i11, format, i12, z11);
    }

    private ExoPlaybackException(String str, Throwable th2, int i11, String str2, int i12, Format format, int i13, MediaPeriodId mediaPeriodId2, long j11, boolean z11) {
        super(str, th2);
        boolean z12 = true;
        if (z11 && i11 != 1) {
            z12 = false;
        }
        Assertions.checkArgument(z12);
        this.type = i11;
        this.cause = th2;
        this.rendererName = str2;
        this.rendererIndex = i12;
        this.rendererFormat = format;
        this.rendererFormatSupport = i13;
        this.mediaPeriodId = mediaPeriodId2;
        this.timestampMs = j11;
        this.isRecoverable = z11;
    }
}
