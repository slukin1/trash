package kotlin.text;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

final class StringsKt___StringsKt$withIndex$1 extends Lambda implements a<Iterator<? extends Character>> {
    public final /* synthetic */ CharSequence $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt___StringsKt$withIndex$1(CharSequence charSequence) {
        super(0);
        this.$this_withIndex = charSequence;
    }

    public final Iterator<Character> invoke() {
        return StringsKt__StringsKt.i0(this.$this_withIndex);
    }
}
