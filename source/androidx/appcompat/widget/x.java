package androidx.appcompat.widget;

public class x {

    /* renamed from: a  reason: collision with root package name */
    public int f4699a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f4700b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f4701c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f4702d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f4703e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f4704f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4705g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4706h = false;

    public int a() {
        return this.f4705g ? this.f4699a : this.f4700b;
    }

    public int b() {
        return this.f4699a;
    }

    public int c() {
        return this.f4700b;
    }

    public int d() {
        return this.f4705g ? this.f4700b : this.f4699a;
    }

    public void e(int i11, int i12) {
        this.f4706h = false;
        if (i11 != Integer.MIN_VALUE) {
            this.f4703e = i11;
            this.f4699a = i11;
        }
        if (i12 != Integer.MIN_VALUE) {
            this.f4704f = i12;
            this.f4700b = i12;
        }
    }

    public void f(boolean z11) {
        if (z11 != this.f4705g) {
            this.f4705g = z11;
            if (!this.f4706h) {
                this.f4699a = this.f4703e;
                this.f4700b = this.f4704f;
            } else if (z11) {
                int i11 = this.f4702d;
                if (i11 == Integer.MIN_VALUE) {
                    i11 = this.f4703e;
                }
                this.f4699a = i11;
                int i12 = this.f4701c;
                if (i12 == Integer.MIN_VALUE) {
                    i12 = this.f4704f;
                }
                this.f4700b = i12;
            } else {
                int i13 = this.f4701c;
                if (i13 == Integer.MIN_VALUE) {
                    i13 = this.f4703e;
                }
                this.f4699a = i13;
                int i14 = this.f4702d;
                if (i14 == Integer.MIN_VALUE) {
                    i14 = this.f4704f;
                }
                this.f4700b = i14;
            }
        }
    }

    public void g(int i11, int i12) {
        this.f4701c = i11;
        this.f4702d = i12;
        this.f4706h = true;
        if (this.f4705g) {
            if (i12 != Integer.MIN_VALUE) {
                this.f4699a = i12;
            }
            if (i11 != Integer.MIN_VALUE) {
                this.f4700b = i11;
                return;
            }
            return;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f4699a = i11;
        }
        if (i12 != Integer.MIN_VALUE) {
            this.f4700b = i12;
        }
    }
}
