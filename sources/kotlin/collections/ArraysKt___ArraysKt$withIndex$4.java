package kotlin.collections;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;

final class ArraysKt___ArraysKt$withIndex$4 extends Lambda implements a<Iterator<? extends Integer>> {
    public final /* synthetic */ int[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$4(int[] iArr) {
        super(0);
        this.$this_withIndex = iArr;
    }

    public final Iterator<Integer> invoke() {
        return i.f(this.$this_withIndex);
    }
}
