package androidx.camera.video;

import android.util.Range;
import androidx.camera.video.w1;
import java.util.Objects;

public final class n extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final y f6319d;

    /* renamed from: e  reason: collision with root package name */
    public final Range<Integer> f6320e;

    /* renamed from: f  reason: collision with root package name */
    public final Range<Integer> f6321f;

    /* renamed from: g  reason: collision with root package name */
    public final int f6322g;

    public static final class b extends w1.a {

        /* renamed from: a  reason: collision with root package name */
        public y f6323a;

        /* renamed from: b  reason: collision with root package name */
        public Range<Integer> f6324b;

        /* renamed from: c  reason: collision with root package name */
        public Range<Integer> f6325c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f6326d;

        public w1 a() {
            String str = "";
            if (this.f6323a == null) {
                str = str + " qualitySelector";
            }
            if (this.f6324b == null) {
                str = str + " frameRate";
            }
            if (this.f6325c == null) {
                str = str + " bitrate";
            }
            if (this.f6326d == null) {
                str = str + " aspectRatio";
            }
            if (str.isEmpty()) {
                return new n(this.f6323a, this.f6324b, this.f6325c, this.f6326d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public w1.a b(int i11) {
            this.f6326d = Integer.valueOf(i11);
            return this;
        }

        public w1.a c(Range<Integer> range) {
            Objects.requireNonNull(range, "Null bitrate");
            this.f6325c = range;
            return this;
        }

        public w1.a d(Range<Integer> range) {
            Objects.requireNonNull(range, "Null frameRate");
            this.f6324b = range;
            return this;
        }

        public w1.a e(y yVar) {
            Objects.requireNonNull(yVar, "Null qualitySelector");
            this.f6323a = yVar;
            return this;
        }

        public b() {
        }

        public b(w1 w1Var) {
            this.f6323a = w1Var.e();
            this.f6324b = w1Var.d();
            this.f6325c = w1Var.c();
            this.f6326d = Integer.valueOf(w1Var.b());
        }
    }

    public int b() {
        return this.f6322g;
    }

    public Range<Integer> c() {
        return this.f6321f;
    }

    public Range<Integer> d() {
        return this.f6320e;
    }

    public y e() {
        return this.f6319d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w1)) {
            return false;
        }
        w1 w1Var = (w1) obj;
        if (!this.f6319d.equals(w1Var.e()) || !this.f6320e.equals(w1Var.d()) || !this.f6321f.equals(w1Var.c()) || this.f6322g != w1Var.b()) {
            return false;
        }
        return true;
    }

    public w1.a f() {
        return new b(this);
    }

    public int hashCode() {
        return ((((((this.f6319d.hashCode() ^ 1000003) * 1000003) ^ this.f6320e.hashCode()) * 1000003) ^ this.f6321f.hashCode()) * 1000003) ^ this.f6322g;
    }

    public String toString() {
        return "VideoSpec{qualitySelector=" + this.f6319d + ", frameRate=" + this.f6320e + ", bitrate=" + this.f6321f + ", aspectRatio=" + this.f6322g + "}";
    }

    public n(y yVar, Range<Integer> range, Range<Integer> range2, int i11) {
        this.f6319d = yVar;
        this.f6320e = range;
        this.f6321f = range2;
        this.f6322g = i11;
    }
}
