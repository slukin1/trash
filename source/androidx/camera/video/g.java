package androidx.camera.video;

import androidx.camera.video.r;
import java.util.Objects;

public final class g extends r {

    /* renamed from: a  reason: collision with root package name */
    public final w1 f5953a;

    /* renamed from: b  reason: collision with root package name */
    public final a f5954b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5955c;

    public static final class b extends r.a {

        /* renamed from: a  reason: collision with root package name */
        public w1 f5956a;

        /* renamed from: b  reason: collision with root package name */
        public a f5957b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f5958c;

        public r a() {
            String str = "";
            if (this.f5956a == null) {
                str = str + " videoSpec";
            }
            if (this.f5957b == null) {
                str = str + " audioSpec";
            }
            if (this.f5958c == null) {
                str = str + " outputFormat";
            }
            if (str.isEmpty()) {
                return new g(this.f5956a, this.f5957b, this.f5958c.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public w1 c() {
            w1 w1Var = this.f5956a;
            if (w1Var != null) {
                return w1Var;
            }
            throw new IllegalStateException("Property \"videoSpec\" has not been set");
        }

        public r.a d(a aVar) {
            Objects.requireNonNull(aVar, "Null audioSpec");
            this.f5957b = aVar;
            return this;
        }

        public r.a e(int i11) {
            this.f5958c = Integer.valueOf(i11);
            return this;
        }

        public r.a f(w1 w1Var) {
            Objects.requireNonNull(w1Var, "Null videoSpec");
            this.f5956a = w1Var;
            return this;
        }

        public b() {
        }

        public b(r rVar) {
            this.f5956a = rVar.d();
            this.f5957b = rVar.b();
            this.f5958c = Integer.valueOf(rVar.c());
        }
    }

    public a b() {
        return this.f5954b;
    }

    public int c() {
        return this.f5955c;
    }

    public w1 d() {
        return this.f5953a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (!this.f5953a.equals(rVar.d()) || !this.f5954b.equals(rVar.b()) || this.f5955c != rVar.c()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.f5953a.hashCode() ^ 1000003) * 1000003) ^ this.f5954b.hashCode()) * 1000003) ^ this.f5955c;
    }

    public r.a i() {
        return new b(this);
    }

    public String toString() {
        return "MediaSpec{videoSpec=" + this.f5953a + ", audioSpec=" + this.f5954b + ", outputFormat=" + this.f5955c + "}";
    }

    public g(w1 w1Var, a aVar, int i11) {
        this.f5953a = w1Var;
        this.f5954b = aVar;
        this.f5955c = i11;
    }
}
