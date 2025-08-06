package androidx.camera.video;

import android.location.Location;
import androidx.core.util.h;

public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    public final b f6352a;

    public static abstract class a<T extends t, B> {

        /* renamed from: a  reason: collision with root package name */
        public final b.a<?> f6353a;

        public a(b.a<?> aVar) {
            this.f6353a = aVar;
            aVar.b(0);
            aVar.a(0);
        }

        public B a(long j11) {
            h.b(j11 >= 0, "The specified duration limit can't be negative.");
            this.f6353a.a(j11);
            return this;
        }

        public B b(long j11) {
            h.b(j11 >= 0, "The specified file size limit can't be negative.");
            this.f6353a.b(j11);
            return this;
        }
    }

    public static abstract class b {

        public static abstract class a<B> {
            public abstract B a(long j11);

            public abstract B b(long j11);
        }

        public abstract long a();

        public abstract long b();

        public abstract Location c();
    }

    public t(b bVar) {
        this.f6352a = bVar;
    }

    public long a() {
        return this.f6352a.a();
    }

    public long b() {
        return this.f6352a.b();
    }

    public Location c() {
        return this.f6352a.c();
    }
}
