package kotlinx.serialization;

import d10.a;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.d0;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.b;
import kotlinx.serialization.descriptors.d;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;

public final class PolymorphicSerializer$descriptor$2 extends Lambda implements a<f> {
    public final /* synthetic */ PolymorphicSerializer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PolymorphicSerializer$descriptor$2(PolymorphicSerializer<T> polymorphicSerializer) {
        super(0);
        this.this$0 = polymorphicSerializer;
    }

    public final f invoke() {
        final PolymorphicSerializer<T> polymorphicSerializer = this.this$0;
        return b.c(SerialDescriptorsKt.c("kotlinx.serialization.Polymorphic", d.a.f57628a, new f[0], new l<kotlinx.serialization.descriptors.a, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((kotlinx.serialization.descriptors.a) obj);
                return Unit.f56620a;
            }

            public final void invoke(kotlinx.serialization.descriptors.a aVar) {
                kotlinx.serialization.descriptors.a.b(aVar, "type", h10.a.I(d0.f56774a).getDescriptor(), (List) null, false, 12, (Object) null);
                kotlinx.serialization.descriptors.a.b(aVar, "value", SerialDescriptorsKt.d("kotlinx.serialization.Polymorphic<" + polymorphicSerializer.e().f() + '>', h.a.f57645a, new f[0], (l) null, 8, (Object) null), (List) null, false, 12, (Object) null);
                aVar.h(polymorphicSerializer.f57594b);
            }
        }), this.this$0.e());
    }
}
