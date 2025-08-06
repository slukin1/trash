package jumio.core;

import kotlin.jvm.internal.x;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final String f56239a;

    /* renamed from: b  reason: collision with root package name */
    public final String f56240b;

    /* renamed from: c  reason: collision with root package name */
    public final String f56241c;

    public l(String str, String str2, String str3) {
        this.f56239a = str;
        this.f56240b = str2;
        this.f56241c = str3;
    }

    public final String a() {
        return this.f56240b;
    }

    public final String b() {
        return this.f56241c;
    }

    public final String c() {
        return this.f56239a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return x.b(this.f56239a, lVar.f56239a) && x.b(this.f56240b, lVar.f56240b) && x.b(this.f56241c, lVar.f56241c);
    }

    public final int hashCode() {
        return this.f56241c.hashCode() + o.a(this.f56240b, this.f56239a.hashCode() * 31, 31);
    }

    public final String toString() {
        String str = this.f56239a;
        String str2 = this.f56240b;
        String str3 = this.f56241c;
        return "BackendSettings(url=" + str + ", aleKeyId=" + str2 + ", alePublicKey=" + str3 + ")";
    }
}
