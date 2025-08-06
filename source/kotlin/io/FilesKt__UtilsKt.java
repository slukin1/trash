package kotlin.io;

import java.io.File;
import java.util.Iterator;

class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public static boolean f(File file) {
        Iterator it2 = FilesKt__FileTreeWalkKt.e(file).iterator();
        while (true) {
            boolean z11 = true;
            while (true) {
                if (!it2.hasNext()) {
                    return z11;
                }
                File file2 = (File) it2.next();
                if (file2.delete() || !file2.exists()) {
                    if (z11) {
                    }
                }
                z11 = false;
            }
        }
    }

    public static String g(File file) {
        return StringsKt__StringsKt.X0(file.getName(), '.', "");
    }
}
