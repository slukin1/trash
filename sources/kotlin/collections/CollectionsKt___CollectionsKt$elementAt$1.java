package kotlin.collections;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class CollectionsKt___CollectionsKt$elementAt$1 extends Lambda implements l<Integer, T> {
    public final /* synthetic */ int $index;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionsKt___CollectionsKt$elementAt$1(int i11) {
        super(1);
        this.$index = i11;
    }

    public final T invoke(int i11) {
        throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.$index + '.');
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
