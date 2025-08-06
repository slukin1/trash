package androidx.appcompat.app;

public class l {

    /* renamed from: d  reason: collision with root package name */
    public static l f3943d;

    /* renamed from: a  reason: collision with root package name */
    public long f3944a;

    /* renamed from: b  reason: collision with root package name */
    public long f3945b;

    /* renamed from: c  reason: collision with root package name */
    public int f3946c;

    public static l b() {
        if (f3943d == null) {
            f3943d = new l();
        }
        return f3943d;
    }

    public void a(long j11, double d11, double d12) {
        float f11 = ((float) (j11 - 946728000000L)) / 8.64E7f;
        float f12 = (0.01720197f * f11) + 6.24006f;
        double d13 = (double) f12;
        double sin = (Math.sin(d13) * 0.03341960161924362d) + d13 + (Math.sin((double) (2.0f * f12)) * 3.4906598739326E-4d) + (Math.sin((double) (f12 * 3.0f)) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d14 = (-d12) / 360.0d;
        double round = ((double) (((float) Math.round(((double) (f11 - 9.0E-4f)) - d14)) + 9.0E-4f)) + d14 + (Math.sin(d13) * 0.0053d) + (Math.sin(2.0d * sin) * -0.0069d);
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d15 = 0.01745329238474369d * d11;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d15) * Math.sin(asin))) / (Math.cos(d15) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f3946c = 1;
            this.f3944a = -1;
            this.f3945b = -1;
        } else if (sin2 <= -1.0d) {
            this.f3946c = 0;
            this.f3944a = -1;
            this.f3945b = -1;
        } else {
            double acos = (double) ((float) (Math.acos(sin2) / 6.283185307179586d));
            this.f3944a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            this.f3945b = round2;
            if (round2 >= j11 || this.f3944a <= j11) {
                this.f3946c = 1;
            } else {
                this.f3946c = 0;
            }
        }
    }
}
