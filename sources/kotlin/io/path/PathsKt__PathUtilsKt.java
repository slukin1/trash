package kotlin.io.path;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        kotlin.io.b.a(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<java.nio.file.Path> o(java.nio.file.Path r1, java.lang.String r2) throws java.io.IOException {
        /*
            java.nio.file.DirectoryStream r1 = java.nio.file.Files.newDirectoryStream(r1, r2)
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r1)     // Catch:{ all -> 0x000d }
            r0 = 0
            kotlin.io.b.a(r1, r0)
            return r2
        L_0x000d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x000f }
        L_0x000f:
            r0 = move-exception
            kotlin.io.b.a(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.o(java.nio.file.Path, java.lang.String):java.util.List");
    }

    public static /* synthetic */ List p(Path path, String str, int i11, Object obj) throws IOException {
        if ((i11 & 1) != 0) {
            str = "*";
        }
        return o(path, str);
    }

    public static final Path q(Path path, Path path2) {
        try {
            return g.f56751a.a(path, path2);
        } catch (IllegalArgumentException e11) {
            throw new IllegalArgumentException(e11.getMessage() + "\nthis path: " + path + "\nbase path: " + path2, e11);
        }
    }
}
