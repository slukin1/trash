package jumio.core;

import java.io.Serializable;
import kotlin.jvm.internal.x;

public final class j2 implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f56227a;

    /* renamed from: b  reason: collision with root package name */
    public final String f56228b;

    public j2() {
        this(0);
    }

    public j2(String str, String str2) {
        this.f56227a = str;
        this.f56228b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j2)) {
            return false;
        }
        j2 j2Var = (j2) obj;
        return x.b(this.f56227a, j2Var.f56227a) && x.b(this.f56228b, j2Var.f56228b);
    }

    public final int hashCode() {
        return this.f56228b.hashCode() + (this.f56227a.hashCode() * 31);
    }

    public final String toString() {
        String str = this.f56227a;
        String str2 = this.f56228b;
        return "RejectReasonDetail(label=" + str + ", reasonDetailCode=" + str2 + ")";
    }

    public /* synthetic */ j2(int i11) {
        this("", "");
    }
}
