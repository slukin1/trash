package kotlin.collections.unsigned;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.q;
import kotlin.r;

final class UArraysKt___UArraysKt$withIndex$2 extends Lambda implements a<Iterator<? extends q>> {
    public final /* synthetic */ long[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$2(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    public final Iterator<q> invoke() {
        return r.o(this.$this_withIndex);
    }
}
