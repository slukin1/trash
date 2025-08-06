package kotlinx.serialization;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.a;

public final class ContextualSerializer$descriptor$1 extends Lambda implements l<a, Unit> {
    public final /* synthetic */ ContextualSerializer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextualSerializer$descriptor$1(ContextualSerializer<T> contextualSerializer) {
        super(1);
        this.this$0 = contextualSerializer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((a) obj);
        return Unit.f56620a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getDescriptor();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(kotlinx.serialization.descriptors.a r2) {
        /*
            r1 = this;
            kotlinx.serialization.ContextualSerializer<T> r0 = r1.this$0
            kotlinx.serialization.b r0 = r0.f57590b
            if (r0 == 0) goto L_0x0013
            kotlinx.serialization.descriptors.f r0 = r0.getDescriptor()
            if (r0 == 0) goto L_0x0013
            java.util.List r0 = r0.getAnnotations()
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 != 0) goto L_0x001a
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x001a:
            r2.h(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.ContextualSerializer$descriptor$1.invoke(kotlinx.serialization.descriptors.a):void");
    }
}
