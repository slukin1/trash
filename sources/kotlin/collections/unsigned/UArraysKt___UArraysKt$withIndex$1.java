package kotlin.collections.unsigned;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.o;
import kotlin.p;

final class UArraysKt___UArraysKt$withIndex$1 extends Lambda implements a<Iterator<? extends o>> {
    public final /* synthetic */ int[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$1(int[] iArr) {
        super(0);
        this.$this_withIndex = iArr;
    }

    public final Iterator<o> invoke() {
        return p.o(this.$this_withIndex);
    }
}
