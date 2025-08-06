package kotlin.text;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class Regex$special$$inlined$fromInt$1 extends Lambda implements l<RegexOption, Boolean> {
    public final /* synthetic */ int $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Regex$special$$inlined$fromInt$1(int i11) {
        super(1);
        this.$value = i11;
    }

    public final Boolean invoke(RegexOption regexOption) {
        d dVar = regexOption;
        return Boolean.valueOf((this.$value & dVar.getMask()) == dVar.getValue());
    }
}
