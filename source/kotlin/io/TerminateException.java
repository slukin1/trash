package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.r;

final class TerminateException extends FileSystemException {
    public TerminateException(File file) {
        super(file, (File) null, (String) null, 6, (r) null);
    }
}
