package kotlin.collections;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements l<Object, Integer> {
    public final /* synthetic */ Comparable<Object> $key;
    public final /* synthetic */ l<Object, Comparable<Object>> $selector;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(l<Object, Comparable<Object>> lVar, Comparable<Object> comparable) {
        super(1);
        this.$selector = lVar;
        this.$key = comparable;
    }

    public final Integer invoke(Object obj) {
        return Integer.valueOf(ComparisonsKt__ComparisonsKt.a(this.$selector.invoke(obj), this.$key));
    }
}
