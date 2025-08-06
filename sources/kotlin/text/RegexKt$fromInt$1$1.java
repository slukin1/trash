package kotlin.text;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class RegexKt$fromInt$1$1 extends Lambda implements l<Enum<Object>, Boolean> {
    public final /* synthetic */ int $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RegexKt$fromInt$1$1(int i11) {
        super(1);
        this.$value = i11;
    }

    public final Boolean invoke(Enum<Object> enumR) {
        d dVar = (d) enumR;
        return Boolean.valueOf((this.$value & dVar.getMask()) == dVar.getValue());
    }
}
