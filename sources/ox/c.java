package ox;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f29163a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29164b;

    public c(int i11, int i12) {
        this.f29163a = i11;
        this.f29164b = i12;
    }

    public int a() {
        return this.f29164b;
    }

    public int b() {
        return this.f29163a;
    }

    public c c(float f11) {
        return new c((int) (((float) this.f29163a) * f11), (int) (((float) this.f29164b) * f11));
    }

    public c d(int i11) {
        return new c(this.f29163a / i11, this.f29164b / i11);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(9);
        sb2.append(this.f29163a);
        sb2.append("x");
        sb2.append(this.f29164b);
        return sb2.toString();
    }

    public c(int i11, int i12, int i13) {
        if (i13 % 180 == 0) {
            this.f29163a = i11;
            this.f29164b = i12;
            return;
        }
        this.f29163a = i12;
        this.f29164b = i11;
    }
}
