package kotlin.text;

import d10.l;
import kotlin.jvm.internal.Lambda;

final class StringsKt__IndentKt$prependIndent$1 extends Lambda implements l<String, String> {
    public final /* synthetic */ String $indent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__IndentKt$prependIndent$1(String str) {
        super(1);
        this.$indent = str;
    }

    public final String invoke(String str) {
        if (!StringsKt__StringsJVMKt.z(str)) {
            return this.$indent + str;
        } else if (str.length() < this.$indent.length()) {
            return this.$indent;
        } else {
            return str;
        }
    }
}
