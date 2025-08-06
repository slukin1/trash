package kotlin.text;

import d10.p;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

public final class StringsKt__StringsKt$rangesDelimitedBy$1 extends Lambda implements p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ char[] $delimiters;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$1(char[] cArr, boolean z11) {
        super(2);
        this.$delimiters = cArr;
        this.$ignoreCase = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((CharSequence) obj, ((Number) obj2).intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i11) {
        int h02 = StringsKt__StringsKt.h0(charSequence, this.$delimiters, i11, this.$ignoreCase);
        if (h02 < 0) {
            return null;
        }
        return l.a(Integer.valueOf(h02), 1);
    }
}
