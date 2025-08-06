package kotlinx.serialization.internal;

import d10.a;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.i;

public final class ObjectSerializer$descriptor$2 extends Lambda implements a<f> {
    public final /* synthetic */ String $serialName;
    public final /* synthetic */ ObjectSerializer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObjectSerializer$descriptor$2(String str, ObjectSerializer<T> objectSerializer) {
        super(0);
        this.$serialName = str;
        this.this$0 = objectSerializer;
    }

    public final f invoke() {
        final ObjectSerializer<T> objectSerializer = this.this$0;
        return SerialDescriptorsKt.c(this.$serialName, i.d.f57650a, new f[0], new l<kotlinx.serialization.descriptors.a, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((kotlinx.serialization.descriptors.a) obj);
                return Unit.f56620a;
            }

            public final void invoke(kotlinx.serialization.descriptors.a aVar) {
                aVar.h(objectSerializer.f57665b);
            }
        });
    }
}
