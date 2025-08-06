package le;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final float f25310a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f25311a;

        /* renamed from: b  reason: collision with root package name */
        public final int f25312b;

        /* renamed from: c  reason: collision with root package name */
        public final float f25313c;

        public a(int i11, int i12, float f11) {
            this.f25311a = i11;
            this.f25312b = i12;
            this.f25313c = f11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f25311a != aVar.f25311a || this.f25312b != aVar.f25312b) {
                return false;
            }
            if (Float.compare(aVar.f25313c, this.f25313c) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11 = ((this.f25311a * 31) + this.f25312b) * 31;
            float f11 = this.f25313c;
            return i11 + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0);
        }

        public String toString() {
            return "Size{width=" + this.f25311a + ", height=" + this.f25312b + ", scaleFactor=" + this.f25313c + '}';
        }
    }

    public g(float f11) {
        this.f25310a = f11;
    }

    public final int a(float f11) {
        return (int) Math.ceil((double) (f11 / this.f25310a));
    }

    public boolean b(int i11, int i12) {
        return a((float) i12) == 0 || a((float) i11) == 0;
    }

    public final int c(int i11) {
        int i12 = i11 % 64;
        return i12 == 0 ? i11 : (i11 - i12) + 64;
    }

    public a d(int i11, int i12) {
        float f11 = (float) i11;
        int c11 = c(a(f11));
        float f12 = f11 / ((float) c11);
        return new a(c11, (int) Math.ceil((double) (((float) i12) / f12)), f12);
    }
}
