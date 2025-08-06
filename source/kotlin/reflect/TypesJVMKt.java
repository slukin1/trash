package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.sequences.g;
import okhttp3.HttpUrl;

public final class TypesJVMKt {
    public static final String b(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            return cls.getName();
        }
        g g11 = SequencesKt__SequencesKt.g(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
        return ((Class) SequencesKt___SequencesKt.r(g11)).getName() + StringsKt__StringsJVMKt.C(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, SequencesKt___SequencesKt.i(g11));
    }
}
