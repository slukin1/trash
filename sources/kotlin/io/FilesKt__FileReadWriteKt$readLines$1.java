package kotlin.io;

import d10.l;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class FilesKt__FileReadWriteKt$readLines$1 extends Lambda implements l<String, Unit> {
    public final /* synthetic */ ArrayList<String> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilesKt__FileReadWriteKt$readLines$1(ArrayList<String> arrayList) {
        super(1);
        this.$result = arrayList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.f56620a;
    }

    public final void invoke(String str) {
        this.$result.add(str);
    }
}
