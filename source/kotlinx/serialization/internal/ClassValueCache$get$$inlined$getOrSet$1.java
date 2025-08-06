package kotlinx.serialization.internal;

import d10.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.c;
import kotlinx.serialization.b;

public final class ClassValueCache$get$$inlined$getOrSet$1 extends Lambda implements a<T> {
    public final /* synthetic */ c $key$inlined;
    public final /* synthetic */ ClassValueCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClassValueCache$get$$inlined$getOrSet$1(ClassValueCache classValueCache, c cVar) {
        super(0);
        this.this$0 = classValueCache;
        this.$key$inlined = cVar;
    }

    public final T invoke() {
        return new l((b) this.this$0.b().invoke(this.$key$inlined));
    }
}
