package androidx.camera.video;

import android.location.Location;
import androidx.camera.video.q;
import java.io.File;
import java.util.Objects;

public final class f extends q.b {

    /* renamed from: a  reason: collision with root package name */
    public final long f5943a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5944b;

    /* renamed from: c  reason: collision with root package name */
    public final Location f5945c;

    /* renamed from: d  reason: collision with root package name */
    public final File f5946d;

    public static final class b extends q.b.a {

        /* renamed from: a  reason: collision with root package name */
        public Long f5947a;

        /* renamed from: b  reason: collision with root package name */
        public Long f5948b;

        /* renamed from: c  reason: collision with root package name */
        public Location f5949c;

        /* renamed from: d  reason: collision with root package name */
        public File f5950d;

        public q.b c() {
            String str = "";
            if (this.f5947a == null) {
                str = str + " fileSizeLimit";
            }
            if (this.f5948b == null) {
                str = str + " durationLimitMillis";
            }
            if (this.f5950d == null) {
                str = str + " file";
            }
            if (str.isEmpty()) {
                return new f(this.f5947a.longValue(), this.f5948b.longValue(), this.f5949c, this.f5950d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public q.b.a d(File file) {
            Objects.requireNonNull(file, "Null file");
            this.f5950d = file;
            return this;
        }

        /* renamed from: e */
        public q.b.a a(long j11) {
            this.f5948b = Long.valueOf(j11);
            return this;
        }

        /* renamed from: f */
        public q.b.a b(long j11) {
            this.f5947a = Long.valueOf(j11);
            return this;
        }
    }

    public long a() {
        return this.f5944b;
    }

    public long b() {
        return this.f5943a;
    }

    public Location c() {
        return this.f5945c;
    }

    public File d() {
        return this.f5946d;
    }

    public boolean equals(Object obj) {
        Location location;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q.b)) {
            return false;
        }
        q.b bVar = (q.b) obj;
        if (this.f5943a != bVar.b() || this.f5944b != bVar.a() || ((location = this.f5945c) != null ? !location.equals(bVar.c()) : bVar.c() != null) || !this.f5946d.equals(bVar.d())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j11 = this.f5943a;
        long j12 = this.f5944b;
        int i11 = (((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        Location location = this.f5945c;
        return ((i11 ^ (location == null ? 0 : location.hashCode())) * 1000003) ^ this.f5946d.hashCode();
    }

    public String toString() {
        return "FileOutputOptionsInternal{fileSizeLimit=" + this.f5943a + ", durationLimitMillis=" + this.f5944b + ", location=" + this.f5945c + ", file=" + this.f5946d + "}";
    }

    public f(long j11, long j12, Location location, File file) {
        this.f5943a = j11;
        this.f5944b = j12;
        this.f5945c = location;
        this.f5946d = file;
    }
}
