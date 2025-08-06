package kotlinx.serialization.modules;

import d10.l;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.b;

public final class SerializersModuleCollector$contextual$1 extends Lambda implements l<List<? extends b<?>>, b<?>> {
    public final /* synthetic */ b<T> $serializer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerializersModuleCollector$contextual$1(b<T> bVar) {
        super(1);
        this.$serializer = bVar;
    }

    public final b<?> invoke(List<? extends b<?>> list) {
        return this.$serializer;
    }
}
