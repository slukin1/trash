package kotlinx.serialization;

import d10.a;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.d0;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.d;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;

public final class SealedClassSerializer$descriptor$2 extends Lambda implements a<f> {
    public final /* synthetic */ String $serialName;
    public final /* synthetic */ SealedClassSerializer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SealedClassSerializer$descriptor$2(String str, SealedClassSerializer<T> sealedClassSerializer) {
        super(0);
        this.$serialName = str;
        this.this$0 = sealedClassSerializer;
    }

    public final f invoke() {
        final SealedClassSerializer<T> sealedClassSerializer = this.this$0;
        return SerialDescriptorsKt.c(this.$serialName, d.b.f57629a, new f[0], new l<kotlinx.serialization.descriptors.a, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((kotlinx.serialization.descriptors.a) obj);
                return Unit.f56620a;
            }

            public final void invoke(kotlinx.serialization.descriptors.a aVar) {
                kotlinx.serialization.descriptors.a.b(aVar, "type", h10.a.I(d0.f56774a).getDescriptor(), (List) null, false, 12, (Object) null);
                kotlinx.serialization.descriptors.a.b(aVar, "value", SerialDescriptorsKt.c("kotlinx.serialization.Sealed<" + sealedClassSerializer.e().f() + '>', h.a.f57645a, new f[0], new SealedClassSerializer$descriptor$2$1$elementDescriptor$1(sealedClassSerializer)), (List) null, false, 12, (Object) null);
                aVar.h(sealedClassSerializer.f57597b);
            }
        });
    }
}
