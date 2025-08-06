package kotlinx.serialization.json.internal;

import com.sumsub.sns.internal.fingerprint.infoproviders.q;
import kotlin.KotlinNothingValueException;
import kotlin.text.o;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.json.a;
import kotlinx.serialization.modules.d;

public final class v extends AbstractDecoder {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractJsonLexer f57938a;

    /* renamed from: b  reason: collision with root package name */
    public final d f57939b;

    public v(AbstractJsonLexer abstractJsonLexer, a aVar) {
        this.f57938a = abstractJsonLexer;
        this.f57939b = aVar.a();
    }

    public byte H() {
        AbstractJsonLexer abstractJsonLexer = this.f57938a;
        String s11 = abstractJsonLexer.s();
        try {
            return o.a(s11);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "UByte" + "' for input '" + s11 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public d a() {
        return this.f57939b;
    }

    public long h() {
        AbstractJsonLexer abstractJsonLexer = this.f57938a;
        String s11 = abstractJsonLexer.s();
        try {
            return o.g(s11);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "ULong" + "' for input '" + s11 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public short m() {
        AbstractJsonLexer abstractJsonLexer = this.f57938a;
        String s11 = abstractJsonLexer.s();
        try {
            return o.j(s11);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "UShort" + "' for input '" + s11 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public int u() {
        AbstractJsonLexer abstractJsonLexer = this.f57938a;
        String s11 = abstractJsonLexer.s();
        try {
            return o.d(s11);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "UInt" + "' for input '" + s11 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public int w(f fVar) {
        throw new IllegalStateException(q.f34641a.toString());
    }
}
