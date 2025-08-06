package kotlinx.serialization.json.internal;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import kotlin.KotlinNothingValueException;
import kotlinx.serialization.descriptors.f;

public final class w {
    public static final JsonDecodingException a(Number number, String str, String str2) {
        return e(-1, k(number, str, str2));
    }

    public static final JsonEncodingException b(Number number, String str) {
        return new JsonEncodingException("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + i(str, 0, 1, (Object) null));
    }

    public static final JsonEncodingException c(Number number, String str, String str2) {
        return new JsonEncodingException(k(number, str, str2));
    }

    public static final JsonEncodingException d(f fVar) {
        return new JsonEncodingException("Value of type '" + fVar.h() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + fVar.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonDecodingException e(int i11, String str) {
        if (i11 >= 0) {
            str = "Unexpected JSON token at offset " + i11 + l.f34627b + str;
        }
        return new JsonDecodingException(str);
    }

    public static final JsonDecodingException f(int i11, String str, CharSequence charSequence) {
        return e(i11, str + "\nJSON input: " + h(charSequence, i11));
    }

    public static final JsonDecodingException g(String str, String str2) {
        return e(-1, "Encountered an unknown key '" + str + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + i(str2, 0, 1, (Object) null));
    }

    public static final CharSequence h(CharSequence charSequence, int i11) {
        if (charSequence.length() < 200) {
            return charSequence;
        }
        String str = ".....";
        if (i11 == -1) {
            int length = charSequence.length() - 60;
            if (length <= 0) {
                return charSequence;
            }
            return str + charSequence.subSequence(length, charSequence.length()).toString();
        }
        int i12 = i11 - 30;
        int i13 = i11 + 30;
        String str2 = i12 <= 0 ? "" : str;
        if (i13 >= charSequence.length()) {
            str = "";
        }
        return str2 + charSequence.subSequence(RangesKt___RangesKt.d(i12, 0), RangesKt___RangesKt.g(i13, charSequence.length())).toString() + str;
    }

    public static /* synthetic */ CharSequence i(CharSequence charSequence, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = -1;
        }
        return h(charSequence, i11);
    }

    public static final Void j(AbstractJsonLexer abstractJsonLexer, Number number) {
        AbstractJsonLexer.y(abstractJsonLexer, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    public static final String k(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + i(str2, 0, 1, (Object) null);
    }
}
