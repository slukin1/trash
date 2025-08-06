package u;

import java.util.Objects;

public final class a extends c {

    /* renamed from: h  reason: collision with root package name */
    public final int f16560h;

    /* renamed from: i  reason: collision with root package name */
    public final int f16561i;

    /* renamed from: j  reason: collision with root package name */
    public final int f16562j;

    /* renamed from: k  reason: collision with root package name */
    public final String f16563k;

    public a(int i11, int i12, int i13, String str) {
        this.f16560h = i11;
        this.f16561i = i12;
        this.f16562j = i13;
        Objects.requireNonNull(str, "Null description");
        this.f16563k = str;
    }

    public String f() {
        return this.f16563k;
    }

    public int g() {
        return this.f16560h;
    }

    public int h() {
        return this.f16561i;
    }

    public int i() {
        return this.f16562j;
    }
}
