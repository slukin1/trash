package androidx.camera.video;

import android.annotation.SuppressLint;
import androidx.camera.video.g;
import androidx.camera.video.w1;
import androidx.core.util.Consumer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.auto.value.AutoValue;
import java.util.Objects;

@AutoValue
public abstract class r {

    @AutoValue.Builder
    public static abstract class a {
        public abstract r a();

        public a b(Consumer<w1.a> consumer) {
            w1.a f11 = c().f();
            consumer.accept(f11);
            f(f11.a());
            return this;
        }

        @SuppressLint({"KotlinPropertyAccess"})
        public abstract w1 c();

        public abstract a d(a aVar);

        public abstract a e(int i11);

        public abstract a f(w1 w1Var);
    }

    public static a a() {
        return new g.b().e(-1).d(a.a().a()).f(w1.a().a());
    }

    public static String e(int i11) {
        return i11 != 1 ? MimeTypes.AUDIO_AAC : MimeTypes.AUDIO_VORBIS;
    }

    public static int f(int i11) {
        return Objects.equals(e(i11), MimeTypes.AUDIO_AAC) ? 2 : -1;
    }

    public static int g(int i11) {
        return i11 != 1 ? 0 : 1;
    }

    public static String h(int i11) {
        return i11 != 1 ? "video/avc" : "video/x-vnd.on2.vp8";
    }

    public abstract a b();

    public abstract int c();

    public abstract w1 d();

    public abstract a i();
}
