package kotlinx.serialization;

import d10.l;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.a;

public final class SealedClassSerializer$descriptor$2$1$elementDescriptor$1 extends Lambda implements l<a, Unit> {
    public final /* synthetic */ SealedClassSerializer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SealedClassSerializer$descriptor$2$1$elementDescriptor$1(SealedClassSerializer<T> sealedClassSerializer) {
        super(1);
        this.this$0 = sealedClassSerializer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((a) obj);
        return Unit.f56620a;
    }

    public final void invoke(a aVar) {
        for (Map.Entry entry : this.this$0.f57600e.entrySet()) {
            a.b(aVar, (String) entry.getKey(), ((b) entry.getValue()).getDescriptor(), (List) null, false, 12, (Object) null);
        }
    }
}
