package kotlinx.serialization.internal;

import kotlinx.serialization.descriptors.f;

public abstract class NamedValueEncoder extends TaggedEncoder<String> {
    public String d0(String str, String str2) {
        if (str.length() == 0) {
            return str2;
        }
        return str + '.' + str2;
    }

    public String e0(f fVar, int i11) {
        return fVar.f(i11);
    }

    /* renamed from: f0 */
    public final String a0(f fVar, int i11) {
        return g0(e0(fVar, i11));
    }

    public final String g0(String str) {
        String str2 = (String) Z();
        if (str2 == null) {
            str2 = "";
        }
        return d0(str2, str);
    }
}
