package androidx.camera.video;

import androidx.camera.video.f;
import androidx.camera.video.t;
import androidx.core.util.h;
import com.google.auto.value.AutoValue;
import java.io.File;

public final class q extends t {

    /* renamed from: b  reason: collision with root package name */
    public final b f6337b;

    public static final class a extends t.a<q, a> {

        /* renamed from: b  reason: collision with root package name */
        public final b.a f6338b;

        public a(File file) {
            super(new f.b());
            h.h(file, "File can't be null.");
            b.a aVar = (b.a) this.f6353a;
            this.f6338b = aVar;
            aVar.d(file);
        }

        public /* bridge */ /* synthetic */ Object a(long j11) {
            return super.a(j11);
        }

        public /* bridge */ /* synthetic */ Object b(long j11) {
            return super.b(j11);
        }

        public q c() {
            return new q(this.f6338b.c());
        }
    }

    @AutoValue
    public static abstract class b extends t.b {

        @AutoValue.Builder
        public static abstract class a extends t.b.a<a> {
            public abstract b c();

            public abstract a d(File file);
        }

        public abstract File d();
    }

    public q(b bVar) {
        super(bVar);
        this.f6337b = bVar;
    }

    public File d() {
        return this.f6337b.d();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        return this.f6337b.equals(((q) obj).f6337b);
    }

    public int hashCode() {
        return this.f6337b.hashCode();
    }

    public String toString() {
        return this.f6337b.toString().replaceFirst("FileOutputOptionsInternal", "FileOutputOptions");
    }
}
