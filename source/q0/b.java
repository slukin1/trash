package q0;

import android.content.LocusId;
import android.os.Build;
import androidx.core.util.h;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f16376a;

    /* renamed from: b  reason: collision with root package name */
    public final LocusId f16377b;

    public static class a {
        public static LocusId a(String str) {
            return new LocusId(str);
        }

        public static String b(LocusId locusId) {
            return locusId.getId();
        }
    }

    public b(String str) {
        this.f16376a = (String) h.k(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f16377b = a.a(str);
        } else {
            this.f16377b = null;
        }
    }

    public static b c(LocusId locusId) {
        h.h(locusId, "locusId cannot be null");
        return new b((String) h.k(a.b(locusId), "id cannot be empty"));
    }

    public final String a() {
        int length = this.f16376a.length();
        return length + "_chars";
    }

    public LocusId b() {
        return this.f16377b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.f16376a;
        if (str != null) {
            return str.equals(bVar.f16376a);
        }
        if (bVar.f16376a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f16376a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocusIdCompat[" + a() + "]";
    }
}
