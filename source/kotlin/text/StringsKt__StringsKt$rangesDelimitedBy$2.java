package kotlin.text;

import d10.p;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

public final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List<String> $delimitersList;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$2(List<String> list, boolean z11) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((CharSequence) obj, ((Number) obj2).intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i11) {
        Pair N = StringsKt__StringsKt.Y(charSequence, this.$delimitersList, i11, this.$ignoreCase, false);
        if (N != null) {
            return l.a(N.getFirst(), Integer.valueOf(((String) N.getSecond()).length()));
        }
        return null;
    }
}
