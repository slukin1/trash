package androidx.camera.video;

public final class d extends b {

    /* renamed from: b  reason: collision with root package name */
    public final int f5928b;

    /* renamed from: c  reason: collision with root package name */
    public final double f5929c;

    /* renamed from: d  reason: collision with root package name */
    public final Throwable f5930d;

    public d(int i11, double d11, Throwable th2) {
        this.f5928b = i11;
        this.f5929c = d11;
        this.f5930d = th2;
    }

    public double a() {
        return this.f5929c;
    }

    public int b() {
        return this.f5928b;
    }

    public Throwable c() {
        return this.f5930d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f5928b == bVar.b() && Double.doubleToLongBits(this.f5929c) == Double.doubleToLongBits(bVar.a())) {
            Throwable th2 = this.f5930d;
            if (th2 == null) {
                if (bVar.c() == null) {
                    return true;
                }
            } else if (th2.equals(bVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int doubleToLongBits = (((this.f5928b ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f5929c) >>> 32) ^ Double.doubleToLongBits(this.f5929c)))) * 1000003;
        Throwable th2 = this.f5930d;
        return doubleToLongBits ^ (th2 == null ? 0 : th2.hashCode());
    }

    public String toString() {
        return "AudioStats{audioState=" + this.f5928b + ", audioAmplitudeInternal=" + this.f5929c + ", errorCause=" + this.f5930d + "}";
    }
}
