package kotlin.io.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kotlin.jvm.internal.x;

public final class h {
    public static final boolean c(f fVar) {
        for (f c11 = fVar.c(); c11 != null; c11 = c11.c()) {
            if (c11.b() == null || fVar.b() == null) {
                try {
                    if (Files.isSameFile(c11.d(), fVar.d())) {
                        return true;
                    }
                } catch (IOException | SecurityException unused) {
                    continue;
                }
            } else if (x.b(c11.b(), fVar.b())) {
                return true;
            }
        }
        return false;
    }

    public static final Object d(Path path, LinkOption[] linkOptionArr) {
        try {
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length);
            return Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length)).fileKey();
        } catch (Throwable unused) {
            return null;
        }
    }
}
