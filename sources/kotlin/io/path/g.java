package kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.jvm.internal.x;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f56751a = new g();

    /* renamed from: b  reason: collision with root package name */
    public static final Path f56752b = Paths.get("", new String[0]);

    /* renamed from: c  reason: collision with root package name */
    public static final Path f56753c = Paths.get("..", new String[0]);

    public final Path a(Path path, Path path2) {
        Path normalize = path2.normalize();
        Path normalize2 = path.normalize();
        Path relativize = normalize.relativize(normalize2);
        int min = Math.min(normalize.getNameCount(), normalize2.getNameCount());
        int i11 = 0;
        while (i11 < min) {
            Path name = normalize.getName(i11);
            Path path3 = f56753c;
            if (!x.b(name, path3)) {
                break;
            } else if (x.b(normalize2.getName(i11), path3)) {
                i11++;
            } else {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (!x.b(normalize2, normalize) && x.b(normalize, f56752b)) {
            return normalize2;
        }
        String obj = relativize.toString();
        return StringsKt__StringsJVMKt.v(obj, relativize.getFileSystem().getSeparator(), false, 2, (Object) null) ? relativize.getFileSystem().getPath(StringsKt___StringsKt.m1(obj, relativize.getFileSystem().getSeparator().length()), new String[0]) : relativize;
    }
}
