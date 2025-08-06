package kotlin.collections.unsigned;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.t;
import kotlin.u;

final class UArraysKt___UArraysKt$withIndex$4 extends Lambda implements a<Iterator<? extends t>> {
    public final /* synthetic */ short[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$4(short[] sArr) {
        super(0);
        this.$this_withIndex = sArr;
    }

    public final Iterator<t> invoke() {
        return u.o(this.$this_withIndex);
    }
}
