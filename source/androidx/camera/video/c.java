package androidx.camera.video;

import android.util.Range;
import androidx.camera.video.a;
import java.util.Objects;

public final class c extends a {

    /* renamed from: d  reason: collision with root package name */
    public final Range<Integer> f5912d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5913e;

    /* renamed from: f  reason: collision with root package name */
    public final int f5914f;

    /* renamed from: g  reason: collision with root package name */
    public final Range<Integer> f5915g;

    /* renamed from: h  reason: collision with root package name */
    public final int f5916h;

    public static final class b extends a.C0009a {

        /* renamed from: a  reason: collision with root package name */
        public Range<Integer> f5917a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f5918b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f5919c;

        /* renamed from: d  reason: collision with root package name */
        public Range<Integer> f5920d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f5921e;

        public a a() {
            String str = "";
            if (this.f5917a == null) {
                str = str + " bitrate";
            }
            if (this.f5918b == null) {
                str = str + " sourceFormat";
            }
            if (this.f5919c == null) {
                str = str + " source";
            }
            if (this.f5920d == null) {
                str = str + " sampleRate";
            }
            if (this.f5921e == null) {
                str = str + " channelCount";
            }
            if (str.isEmpty()) {
                return new c(this.f5917a, this.f5918b.intValue(), this.f5919c.intValue(), this.f5920d, this.f5921e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public a.C0009a b(Range<Integer> range) {
            Objects.requireNonNull(range, "Null bitrate");
            this.f5917a = range;
            return this;
        }

        public a.C0009a c(int i11) {
            this.f5921e = Integer.valueOf(i11);
            return this;
        }

        public a.C0009a d(Range<Integer> range) {
            Objects.requireNonNull(range, "Null sampleRate");
            this.f5920d = range;
            return this;
        }

        public a.C0009a e(int i11) {
            this.f5919c = Integer.valueOf(i11);
            return this;
        }

        public a.C0009a f(int i11) {
            this.f5918b = Integer.valueOf(i11);
            return this;
        }
    }

    public Range<Integer> b() {
        return this.f5912d;
    }

    public int c() {
        return this.f5916h;
    }

    public Range<Integer> d() {
        return this.f5915g;
    }

    public int e() {
        return this.f5914f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f5912d.equals(aVar.b()) && this.f5913e == aVar.f() && this.f5914f == aVar.e() && this.f5915g.equals(aVar.d()) && this.f5916h == aVar.c()) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f5913e;
    }

    public int hashCode() {
        return ((((((((this.f5912d.hashCode() ^ 1000003) * 1000003) ^ this.f5913e) * 1000003) ^ this.f5914f) * 1000003) ^ this.f5915g.hashCode()) * 1000003) ^ this.f5916h;
    }

    public String toString() {
        return "AudioSpec{bitrate=" + this.f5912d + ", sourceFormat=" + this.f5913e + ", source=" + this.f5914f + ", sampleRate=" + this.f5915g + ", channelCount=" + this.f5916h + "}";
    }

    public c(Range<Integer> range, int i11, int i12, Range<Integer> range2, int i13) {
        this.f5912d = range;
        this.f5913e = i11;
        this.f5914f = i12;
        this.f5915g = range2;
        this.f5916h = i13;
    }
}
