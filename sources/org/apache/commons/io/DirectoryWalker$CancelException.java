package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

public class DirectoryWalker$CancelException extends IOException {
    private static final long serialVersionUID = 1347339620135041008L;
    private final int depth;
    private final File file;

    public DirectoryWalker$CancelException(File file2, int i11) {
        this("Operation Cancelled", file2, i11);
    }

    public int getDepth() {
        return this.depth;
    }

    public File getFile() {
        return this.file;
    }

    public DirectoryWalker$CancelException(String str, File file2, int i11) {
        super(str);
        this.file = file2;
        this.depth = i11;
    }
}
