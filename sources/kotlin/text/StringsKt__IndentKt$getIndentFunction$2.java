package kotlin.text;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class StringsKt__IndentKt$getIndentFunction$2 extends Lambda implements l<String, String> {
    public final /* synthetic */ String $indent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__IndentKt$getIndentFunction$2(String str) {
        super(1);
        this.$indent = str;
    }

    public final String invoke(String str) {
        return this.$indent + str;
    }
}
