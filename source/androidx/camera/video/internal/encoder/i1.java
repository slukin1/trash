package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import android.util.Size;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.d;
import com.google.android.gms.common.Scopes;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class i1 implements n {

    @AutoValue.Builder
    public static abstract class a {
        public abstract i1 a();

        public abstract a b(int i11);

        public abstract a c(int i11);

        public abstract a d(j1 j1Var);

        public abstract a e(int i11);

        public abstract a f(int i11);

        public abstract a g(Timebase timebase);

        public abstract a h(String str);

        public abstract a i(int i11);

        public abstract a j(Size size);
    }

    public static a c() {
        return new d.b().i(-1).f(1).c(2130708361).d(j1.f6234a);
    }

    public abstract Timebase a();

    public MediaFormat b() {
        Size j11 = j();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(getMimeType(), j11.getWidth(), j11.getHeight());
        createVideoFormat.setInteger("color-format", e());
        createVideoFormat.setInteger("bitrate", d());
        createVideoFormat.setInteger("frame-rate", g());
        createVideoFormat.setInteger("i-frame-interval", h());
        if (i() != -1) {
            createVideoFormat.setInteger(Scopes.PROFILE, i());
        }
        j1 f11 = f();
        if (f11.c() != 0) {
            createVideoFormat.setInteger("color-standard", f11.c());
        }
        if (f11.d() != 0) {
            createVideoFormat.setInteger("color-transfer", f11.d());
        }
        if (f11.b() != 0) {
            createVideoFormat.setInteger("color-range", f11.b());
        }
        return createVideoFormat;
    }

    public abstract int d();

    public abstract int e();

    public abstract j1 f();

    public abstract int g();

    public abstract String getMimeType();

    public abstract int h();

    public abstract int i();

    public abstract Size j();
}
