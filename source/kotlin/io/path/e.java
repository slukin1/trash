package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f56742a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final LinkOption[] f56743b = {LinkOption.NOFOLLOW_LINKS};

    /* renamed from: c  reason: collision with root package name */
    public static final LinkOption[] f56744c = new LinkOption[0];

    /* renamed from: d  reason: collision with root package name */
    public static final Set<FileVisitOption> f56745d = SetsKt__SetsKt.d();

    /* renamed from: e  reason: collision with root package name */
    public static final Set<FileVisitOption> f56746e = SetsKt__SetsJVMKt.c(FileVisitOption.FOLLOW_LINKS);

    public final LinkOption[] a(boolean z11) {
        return z11 ? f56744c : f56743b;
    }

    public final Set<FileVisitOption> b(boolean z11) {
        return z11 ? f56746e : f56745d;
    }
}
