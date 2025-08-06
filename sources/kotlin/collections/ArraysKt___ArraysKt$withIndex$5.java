package kotlin.collections;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;

final class ArraysKt___ArraysKt$withIndex$5 extends Lambda implements a<Iterator<? extends Long>> {
    public final /* synthetic */ long[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$5(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    public final Iterator<Long> invoke() {
        return i.g(this.$this_withIndex);
    }
}
