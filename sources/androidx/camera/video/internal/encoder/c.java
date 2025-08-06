package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.a;
import java.util.Objects;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public final String f6162a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6163b;

    /* renamed from: c  reason: collision with root package name */
    public final Timebase f6164c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6165d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6166e;

    /* renamed from: f  reason: collision with root package name */
    public final int f6167f;

    public static final class b extends a.C0013a {

        /* renamed from: a  reason: collision with root package name */
        public String f6168a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f6169b;

        /* renamed from: c  reason: collision with root package name */
        public Timebase f6170c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f6171d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f6172e;

        /* renamed from: f  reason: collision with root package name */
        public Integer f6173f;

        public a a() {
            String str = "";
            if (this.f6168a == null) {
                str = str + " mimeType";
            }
            if (this.f6169b == null) {
                str = str + " profile";
            }
            if (this.f6170c == null) {
                str = str + " inputTimebase";
            }
            if (this.f6171d == null) {
                str = str + " bitrate";
            }
            if (this.f6172e == null) {
                str = str + " sampleRate";
            }
            if (this.f6173f == null) {
                str = str + " channelCount";
            }
            if (str.isEmpty()) {
                return new c(this.f6168a, this.f6169b.intValue(), this.f6170c, this.f6171d.intValue(), this.f6172e.intValue(), this.f6173f.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public a.C0013a c(int i11) {
            this.f6171d = Integer.valueOf(i11);
            return this;
        }

        public a.C0013a d(int i11) {
            this.f6173f = Integer.valueOf(i11);
            return this;
        }

        public a.C0013a e(Timebase timebase) {
            Objects.requireNonNull(timebase, "Null inputTimebase");
            this.f6170c = timebase;
            return this;
        }

        public a.C0013a f(String str) {
            Objects.requireNonNull(str, "Null mimeType");
            this.f6168a = str;
            return this;
        }

        public a.C0013a g(int i11) {
            this.f6169b = Integer.valueOf(i11);
            return this;
        }

        public a.C0013a h(int i11) {
            this.f6172e = Integer.valueOf(i11);
            return this;
        }
    }

    public Timebase a() {
        return this.f6164c;
    }

    public int d() {
        return this.f6165d;
    }

    public int e() {
        return this.f6167f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f6162a.equals(aVar.getMimeType()) && this.f6163b == aVar.f() && this.f6164c.equals(aVar.a()) && this.f6165d == aVar.d() && this.f6166e == aVar.g() && this.f6167f == aVar.e()) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f6163b;
    }

    public int g() {
        return this.f6166e;
    }

    public String getMimeType() {
        return this.f6162a;
    }

    public int hashCode() {
        return ((((((((((this.f6162a.hashCode() ^ 1000003) * 1000003) ^ this.f6163b) * 1000003) ^ this.f6164c.hashCode()) * 1000003) ^ this.f6165d) * 1000003) ^ this.f6166e) * 1000003) ^ this.f6167f;
    }

    public String toString() {
        return "AudioEncoderConfig{mimeType=" + this.f6162a + ", profile=" + this.f6163b + ", inputTimebase=" + this.f6164c + ", bitrate=" + this.f6165d + ", sampleRate=" + this.f6166e + ", channelCount=" + this.f6167f + "}";
    }

    public c(String str, int i11, Timebase timebase, int i12, int i13, int i14) {
        this.f6162a = str;
        this.f6163b = i11;
        this.f6164c = timebase;
        this.f6165d = i12;
        this.f6166e = i13;
        this.f6167f = i14;
    }
}
