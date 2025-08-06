package kotlinx.serialization.internal;

import kotlinx.serialization.descriptors.f;

public abstract class NamedValueDecoder extends TaggedDecoder<String> {
    public String b0(String str, String str2) {
        if (str.length() == 0) {
            return str2;
        }
        return str + '.' + str2;
    }

    public String c0(f fVar, int i11) {
        return fVar.f(i11);
    }

    /* renamed from: d0 */
    public final String X(f fVar, int i11) {
        return e0(c0(fVar, i11));
    }

    public final String e0(String str) {
        String str2 = (String) W();
        if (str2 == null) {
            str2 = "";
        }
        return b0(str2, str);
    }
}
