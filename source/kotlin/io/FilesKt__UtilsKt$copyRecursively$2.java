package kotlin.io;

import d10.p;
import java.io.File;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class FilesKt__UtilsKt$copyRecursively$2 extends Lambda implements p<File, IOException, Unit> {
    public final /* synthetic */ p<File, IOException, OnErrorAction> $onError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilesKt__UtilsKt$copyRecursively$2(p<? super File, ? super IOException, ? extends OnErrorAction> pVar) {
        super(2);
        this.$onError = pVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((File) obj, (IOException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(File file, IOException iOException) {
        if (this.$onError.invoke(file, iOException) == OnErrorAction.TERMINATE) {
            throw new TerminateException(file);
        }
    }
}
