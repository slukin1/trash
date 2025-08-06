package kotlin.collections;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

final class CollectionsKt___CollectionsKt$withIndex$1 extends Lambda implements a<Iterator<Object>> {
    public final /* synthetic */ Iterable<Object> $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionsKt___CollectionsKt$withIndex$1(Iterable<Object> iterable) {
        super(0);
        this.$this_withIndex = iterable;
    }

    public final Iterator<Object> invoke() {
        return this.$this_withIndex.iterator();
    }
}
