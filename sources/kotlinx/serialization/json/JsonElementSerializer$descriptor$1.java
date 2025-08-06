package kotlinx.serialization.json;

import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.a;

public final class JsonElementSerializer$descriptor$1 extends Lambda implements l<a, Unit> {
    public static final JsonElementSerializer$descriptor$1 INSTANCE = new JsonElementSerializer$descriptor$1();

    public JsonElementSerializer$descriptor$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((a) obj);
        return Unit.f56620a;
    }

    public final void invoke(a aVar) {
        a aVar2 = aVar;
        a.b(aVar2, "JsonPrimitive", j.f(AnonymousClass1.INSTANCE), (List) null, false, 12, (Object) null);
        a.b(aVar2, "JsonNull", j.f(AnonymousClass2.INSTANCE), (List) null, false, 12, (Object) null);
        a.b(aVar2, "JsonLiteral", j.f(AnonymousClass3.INSTANCE), (List) null, false, 12, (Object) null);
        a.b(aVar2, "JsonObject", j.f(AnonymousClass4.INSTANCE), (List) null, false, 12, (Object) null);
        a.b(aVar2, "JsonArray", j.f(AnonymousClass5.INSTANCE), (List) null, false, 12, (Object) null);
    }
}
