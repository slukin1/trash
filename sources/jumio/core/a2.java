package jumio.core;

import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.x;

public final class a2 implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final List<JumioDocumentType> f56124a;

    /* renamed from: b  reason: collision with root package name */
    public final JumioDocumentVariant f56125b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56126c = true;

    public a2(List<? extends JumioDocumentType> list, JumioDocumentVariant jumioDocumentVariant) {
        this.f56124a = list;
        this.f56125b = jumioDocumentVariant;
    }

    public final List<JumioDocumentType> a() {
        if (this.f56126c) {
            return this.f56124a;
        }
        return null;
    }

    public final JumioDocumentVariant b() {
        if (this.f56126c) {
            return this.f56125b;
        }
        return null;
    }

    public final void c() {
        this.f56126c = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a2)) {
            return false;
        }
        a2 a2Var = (a2) obj;
        return x.b(this.f56124a, a2Var.f56124a) && this.f56125b == a2Var.f56125b;
    }

    public final int hashCode() {
        List<JumioDocumentType> list = this.f56124a;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        JumioDocumentVariant jumioDocumentVariant = this.f56125b;
        if (jumioDocumentVariant != null) {
            i11 = jumioDocumentVariant.hashCode();
        }
        return hashCode + i11;
    }

    public final String toString() {
        List<JumioDocumentType> list = this.f56124a;
        JumioDocumentVariant jumioDocumentVariant = this.f56125b;
        return "PhysicalDocumentFilter(types=" + list + ", variant=" + jumioDocumentVariant + ")";
    }
}
