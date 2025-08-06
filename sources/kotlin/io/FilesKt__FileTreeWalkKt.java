package kotlin.io;

import java.io.File;

class FilesKt__FileTreeWalkKt extends FilesKt__FileReadWriteKt {
    public static final e d(File file, FileWalkDirection fileWalkDirection) {
        return new e(file, fileWalkDirection);
    }

    public static final e e(File file) {
        return d(file, FileWalkDirection.BOTTOM_UP);
    }
}
