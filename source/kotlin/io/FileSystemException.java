package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.r;

public class FileSystemException extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileSystemException(File file2, File file3, String str, int i11, r rVar) {
        this(file2, (i11 & 2) != 0 ? null : file3, (i11 & 4) != 0 ? null : str);
    }

    public final File getFile() {
        return this.file;
    }

    public final File getOther() {
        return this.other;
    }

    public final String getReason() {
        return this.reason;
    }

    public FileSystemException(File file2, File file3, String str) {
        super(c.b(file2, file3, str));
        this.file = file2;
        this.other = file3;
        this.reason = str;
    }
}
