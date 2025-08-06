package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.r;

public final class AccessDeniedException extends FileSystemException {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccessDeniedException(File file, File file2, String str, int i11, r rVar) {
        this(file, (i11 & 2) != 0 ? null : file2, (i11 & 4) != 0 ? null : str);
    }

    public AccessDeniedException(File file, File file2, String str) {
        super(file, file2, str);
    }
}
