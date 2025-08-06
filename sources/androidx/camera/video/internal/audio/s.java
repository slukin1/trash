package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.a;

public final class s extends a {

    /* renamed from: b  reason: collision with root package name */
    public final int f6066b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6067c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6068d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6069e;

    public static final class b extends a.C0010a {

        /* renamed from: a  reason: collision with root package name */
        public Integer f6070a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f6071b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f6072c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f6073d;

        public a a() {
            String str = "";
            if (this.f6070a == null) {
                str = str + " audioSource";
            }
            if (this.f6071b == null) {
                str = str + " sampleRate";
            }
            if (this.f6072c == null) {
                str = str + " channelCount";
            }
            if (this.f6073d == null) {
                str = str + " audioFormat";
            }
            if (str.isEmpty()) {
                return new s(this.f6070a.intValue(), this.f6071b.intValue(), this.f6072c.intValue(), this.f6073d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public a.C0010a c(int i11) {
            this.f6073d = Integer.valueOf(i11);
            return this;
        }

        public a.C0010a d(int i11) {
            this.f6070a = Integer.valueOf(i11);
            return this;
        }

        public a.C0010a e(int i11) {
            this.f6072c = Integer.valueOf(i11);
            return this;
        }

        public a.C0010a f(int i11) {
            this.f6071b = Integer.valueOf(i11);
            return this;
        }
    }

    public int b() {
        return this.f6069e;
    }

    public int c() {
        return this.f6066b;
    }

    public int e() {
        return this.f6068d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f6066b == aVar.c() && this.f6067c == aVar.f() && this.f6068d == aVar.e() && this.f6069e == aVar.b()) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f6067c;
    }

    public int hashCode() {
        return ((((((this.f6066b ^ 1000003) * 1000003) ^ this.f6067c) * 1000003) ^ this.f6068d) * 1000003) ^ this.f6069e;
    }

    public String toString() {
        return "AudioSettings{audioSource=" + this.f6066b + ", sampleRate=" + this.f6067c + ", channelCount=" + this.f6068d + ", audioFormat=" + this.f6069e + "}";
    }

    public s(int i11, int i12, int i13, int i14) {
        this.f6066b = i11;
        this.f6067c = i12;
        this.f6068d = i13;
        this.f6069e = i14;
    }
}
