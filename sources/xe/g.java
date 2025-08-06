package xe;

import kotlin.jvm.internal.x;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public String f26369a;

    /* renamed from: b  reason: collision with root package name */
    public String f26370b;

    /* renamed from: c  reason: collision with root package name */
    public int f26371c;

    /* renamed from: d  reason: collision with root package name */
    public int f26372d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26373e;

    public g(String str, String str2, int i11, int i12, boolean z11) {
        this.f26369a = str;
        this.f26370b = str2;
        this.f26371c = i11;
        this.f26372d = i12;
        this.f26373e = z11;
    }

    public final String a() {
        return this.f26370b;
    }

    public final String b() {
        return this.f26369a;
    }

    public final boolean c() {
        return this.f26373e;
    }

    public final int d() {
        return this.f26371c;
    }

    public final int e() {
        return this.f26372d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return x.b(this.f26369a, gVar.f26369a) && x.b(this.f26370b, gVar.f26370b) && this.f26371c == gVar.f26371c && this.f26372d == gVar.f26372d && this.f26373e == gVar.f26373e;
    }

    public int hashCode() {
        int hashCode = this.f26369a.hashCode() * 31;
        String str = this.f26370b;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f26371c) * 31) + this.f26372d) * 31;
        boolean z11 = this.f26373e;
        if (z11) {
            z11 = true;
        }
        return hashCode2 + (z11 ? 1 : 0);
    }

    public String toString() {
        return "PraiseNum(commentId=" + this.f26369a + ", childId=" + this.f26370b + ", num=" + this.f26371c + ", status=" + this.f26372d + ", fromDetail=" + this.f26373e + ')';
    }
}
