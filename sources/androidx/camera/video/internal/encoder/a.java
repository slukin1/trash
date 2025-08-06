package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.c;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.Scopes;
import com.google.auto.value.AutoValue;
import java.util.Objects;

@AutoValue
public abstract class a implements n {

    @AutoValue.Builder
    /* renamed from: androidx.camera.video.internal.encoder.a$a  reason: collision with other inner class name */
    public static abstract class C0013a {
        public abstract a a();

        public a b() {
            a a11 = a();
            if (!Objects.equals(a11.getMimeType(), MimeTypes.AUDIO_AAC) || a11.f() != -1) {
                return a11;
            }
            throw new IllegalArgumentException("Encoder mime set to AAC, but no AAC profile was provided.");
        }

        public abstract C0013a c(int i11);

        public abstract C0013a d(int i11);

        public abstract C0013a e(Timebase timebase);

        public abstract C0013a f(String str);

        public abstract C0013a g(int i11);

        public abstract C0013a h(int i11);
    }

    public static C0013a c() {
        return new c.b().g(-1);
    }

    public abstract Timebase a();

    public MediaFormat b() {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(getMimeType(), g(), e());
        createAudioFormat.setInteger("bitrate", d());
        if (f() != -1) {
            if (getMimeType().equals(MimeTypes.AUDIO_AAC)) {
                createAudioFormat.setInteger("aac-profile", f());
            } else {
                createAudioFormat.setInteger(Scopes.PROFILE, f());
            }
        }
        return createAudioFormat;
    }

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract String getMimeType();
}
