package e2;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f15644a;

    /* renamed from: b  reason: collision with root package name */
    public int f15645b;

    /* renamed from: c  reason: collision with root package name */
    public int f15646c;

    /* renamed from: d  reason: collision with root package name */
    public long f15647d;

    /* renamed from: e  reason: collision with root package name */
    public String f15648e;

    /* renamed from: f  reason: collision with root package name */
    public String f15649f;

    /* renamed from: g  reason: collision with root package name */
    public String f15650g;

    /* renamed from: h  reason: collision with root package name */
    public int f15651h;

    /* renamed from: i  reason: collision with root package name */
    public b f15652i;

    public b() {
    }

    public boolean a(b bVar) {
        int i11 = this.f15645b;
        if (i11 != 1) {
            if (i11 != 15) {
                if (i11 != 12) {
                    if (i11 != 13) {
                        switch (i11) {
                            case 3:
                            case 4:
                                if (bVar.f15646c == this.f15646c) {
                                    return true;
                                }
                                return false;
                            case 5:
                            case 6:
                                break;
                            case 7:
                            case 8:
                                break;
                            default:
                                if (!bVar.f15648e.equals(this.f15648e) || !bVar.f15649f.equals(this.f15649f) || !bVar.f15650g.equals(this.f15650g)) {
                                    return false;
                                }
                                return true;
                        }
                    }
                } else if (!bVar.f15648e.equals(this.f15648e) || !bVar.f15649f.equals(this.f15649f)) {
                    return false;
                } else {
                    return true;
                }
            }
            if (bVar.f15647d == this.f15647d) {
                return true;
            }
            return false;
        }
        return bVar.f15648e.equals(this.f15648e);
    }

    public void b(int i11) {
        this.f15645b = 3;
        this.f15646c = i11;
        this.f15651h = Integer.MAX_VALUE & (3 + i11);
    }

    public void c(int i11, String str, String str2, String str3) {
        this.f15645b = i11;
        this.f15648e = str;
        this.f15649f = str2;
        this.f15650g = str3;
        if (!(i11 == 1 || i11 == 7 || i11 == 8)) {
            if (i11 == 12) {
                this.f15651h = (i11 + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
                return;
            } else if (i11 != 13) {
                this.f15651h = (i11 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
                return;
            }
        }
        this.f15651h = (i11 + str.hashCode()) & Integer.MAX_VALUE;
    }

    public b(int i11, b bVar) {
        this.f15644a = i11;
        this.f15645b = bVar.f15645b;
        this.f15646c = bVar.f15646c;
        this.f15647d = bVar.f15647d;
        this.f15648e = bVar.f15648e;
        this.f15649f = bVar.f15649f;
        this.f15650g = bVar.f15650g;
        this.f15651h = bVar.f15651h;
    }
}
