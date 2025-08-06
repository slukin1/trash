package androidx.camera.video.internal.encoder;

import android.util.Size;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.i1;
import java.util.Objects;

public final class d extends i1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f6177a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6178b;

    /* renamed from: c  reason: collision with root package name */
    public final Timebase f6179c;

    /* renamed from: d  reason: collision with root package name */
    public final Size f6180d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6181e;

    /* renamed from: f  reason: collision with root package name */
    public final j1 f6182f;

    /* renamed from: g  reason: collision with root package name */
    public final int f6183g;

    /* renamed from: h  reason: collision with root package name */
    public final int f6184h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6185i;

    public static final class b extends i1.a {

        /* renamed from: a  reason: collision with root package name */
        public String f6186a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f6187b;

        /* renamed from: c  reason: collision with root package name */
        public Timebase f6188c;

        /* renamed from: d  reason: collision with root package name */
        public Size f6189d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f6190e;

        /* renamed from: f  reason: collision with root package name */
        public j1 f6191f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f6192g;

        /* renamed from: h  reason: collision with root package name */
        public Integer f6193h;

        /* renamed from: i  reason: collision with root package name */
        public Integer f6194i;

        public i1 a() {
            String str = "";
            if (this.f6186a == null) {
                str = str + " mimeType";
            }
            if (this.f6187b == null) {
                str = str + " profile";
            }
            if (this.f6188c == null) {
                str = str + " inputTimebase";
            }
            if (this.f6189d == null) {
                str = str + " resolution";
            }
            if (this.f6190e == null) {
                str = str + " colorFormat";
            }
            if (this.f6191f == null) {
                str = str + " dataSpace";
            }
            if (this.f6192g == null) {
                str = str + " frameRate";
            }
            if (this.f6193h == null) {
                str = str + " IFrameInterval";
            }
            if (this.f6194i == null) {
                str = str + " bitrate";
            }
            if (str.isEmpty()) {
                return new d(this.f6186a, this.f6187b.intValue(), this.f6188c, this.f6189d, this.f6190e.intValue(), this.f6191f, this.f6192g.intValue(), this.f6193h.intValue(), this.f6194i.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public i1.a b(int i11) {
            this.f6194i = Integer.valueOf(i11);
            return this;
        }

        public i1.a c(int i11) {
            this.f6190e = Integer.valueOf(i11);
            return this;
        }

        public i1.a d(j1 j1Var) {
            Objects.requireNonNull(j1Var, "Null dataSpace");
            this.f6191f = j1Var;
            return this;
        }

        public i1.a e(int i11) {
            this.f6192g = Integer.valueOf(i11);
            return this;
        }

        public i1.a f(int i11) {
            this.f6193h = Integer.valueOf(i11);
            return this;
        }

        public i1.a g(Timebase timebase) {
            Objects.requireNonNull(timebase, "Null inputTimebase");
            this.f6188c = timebase;
            return this;
        }

        public i1.a h(String str) {
            Objects.requireNonNull(str, "Null mimeType");
            this.f6186a = str;
            return this;
        }

        public i1.a i(int i11) {
            this.f6187b = Integer.valueOf(i11);
            return this;
        }

        public i1.a j(Size size) {
            Objects.requireNonNull(size, "Null resolution");
            this.f6189d = size;
            return this;
        }
    }

    public Timebase a() {
        return this.f6179c;
    }

    public int d() {
        return this.f6185i;
    }

    public int e() {
        return this.f6181e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        if (this.f6177a.equals(i1Var.getMimeType()) && this.f6178b == i1Var.i() && this.f6179c.equals(i1Var.a()) && this.f6180d.equals(i1Var.j()) && this.f6181e == i1Var.e() && this.f6182f.equals(i1Var.f()) && this.f6183g == i1Var.g() && this.f6184h == i1Var.h() && this.f6185i == i1Var.d()) {
            return true;
        }
        return false;
    }

    public j1 f() {
        return this.f6182f;
    }

    public int g() {
        return this.f6183g;
    }

    public String getMimeType() {
        return this.f6177a;
    }

    public int h() {
        return this.f6184h;
    }

    public int hashCode() {
        return ((((((((((((((((this.f6177a.hashCode() ^ 1000003) * 1000003) ^ this.f6178b) * 1000003) ^ this.f6179c.hashCode()) * 1000003) ^ this.f6180d.hashCode()) * 1000003) ^ this.f6181e) * 1000003) ^ this.f6182f.hashCode()) * 1000003) ^ this.f6183g) * 1000003) ^ this.f6184h) * 1000003) ^ this.f6185i;
    }

    public int i() {
        return this.f6178b;
    }

    public Size j() {
        return this.f6180d;
    }

    public String toString() {
        return "VideoEncoderConfig{mimeType=" + this.f6177a + ", profile=" + this.f6178b + ", inputTimebase=" + this.f6179c + ", resolution=" + this.f6180d + ", colorFormat=" + this.f6181e + ", dataSpace=" + this.f6182f + ", frameRate=" + this.f6183g + ", IFrameInterval=" + this.f6184h + ", bitrate=" + this.f6185i + "}";
    }

    public d(String str, int i11, Timebase timebase, Size size, int i12, j1 j1Var, int i13, int i14, int i15) {
        this.f6177a = str;
        this.f6178b = i11;
        this.f6179c = timebase;
        this.f6180d = size;
        this.f6181e = i12;
        this.f6182f = j1Var;
        this.f6183g = i13;
        this.f6184h = i14;
        this.f6185i = i15;
    }
}
