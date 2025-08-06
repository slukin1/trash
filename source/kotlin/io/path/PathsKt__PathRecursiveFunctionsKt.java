package kotlin.io.path;

import d10.q;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;

class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56736a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f56737b;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|5|6|(2:7|8)|9|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
        static {
            /*
                kotlin.io.path.CopyActionResult[] r0 = kotlin.io.path.CopyActionResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                kotlin.io.path.CopyActionResult r2 = kotlin.io.path.CopyActionResult.CONTINUE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                kotlin.io.path.CopyActionResult r3 = kotlin.io.path.CopyActionResult.TERMINATE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.io.path.CopyActionResult r3 = kotlin.io.path.CopyActionResult.SKIP_SUBTREE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f56736a = r0
                kotlin.io.path.OnErrorResult[] r0 = kotlin.io.path.OnErrorResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.io.path.OnErrorResult r3 = kotlin.io.path.OnErrorResult.TERMINATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                kotlin.io.path.OnErrorResult r1 = kotlin.io.path.OnErrorResult.SKIP_SUBTREE     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                f56737b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.a.<clinit>():void");
        }
    }

    public static final FileVisitResult c(q<? super a, ? super Path, ? super Path, ? extends CopyActionResult> qVar, Path path, Path path2, q<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> qVar2, Path path3, BasicFileAttributes basicFileAttributes) {
        try {
            return m((CopyActionResult) qVar.invoke(b.f56738a, path3, d(path, path2, path3)));
        } catch (Exception e11) {
            return e(qVar2, path, path2, path3, e11);
        }
    }

    public static final Path d(Path path, Path path2, Path path3) {
        return path2.resolve(PathsKt__PathUtilsKt.q(path3, path));
    }

    public static final FileVisitResult e(q<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> qVar, Path path, Path path2, Path path3, Exception exc) {
        return n((OnErrorResult) qVar.invoke(path3, d(path, path2, path3), exc));
    }

    public static final void f(Path path) {
        List<Exception> g11 = g(path);
        if (!g11.isEmpty()) {
            FileSystemException fileSystemException = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
            for (Exception a11 : g11) {
                ExceptionsKt__ExceptionsKt.a(fileSystemException, a11);
            }
            throw fileSystemException;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        kotlin.io.b.a(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<java.lang.Exception> g(java.nio.file.Path r7) {
        /*
            kotlin.io.path.ExceptionsCollector r0 = new kotlin.io.path.ExceptionsCollector
            r1 = 0
            r2 = 1
            r3 = 0
            r0.<init>(r1, r2, r3)
            java.nio.file.Path r4 = r7.getParent()
            if (r4 == 0) goto L_0x0037
            java.nio.file.DirectoryStream r5 = java.nio.file.Files.newDirectoryStream(r4)     // Catch:{ all -> 0x0013 }
            goto L_0x0014
        L_0x0013:
            r5 = r3
        L_0x0014:
            if (r5 == 0) goto L_0x0037
            boolean r6 = r5 instanceof java.nio.file.SecureDirectoryStream     // Catch:{ all -> 0x0030 }
            if (r6 == 0) goto L_0x0028
            r0.f(r4)     // Catch:{ all -> 0x0030 }
            r2 = r5
            java.nio.file.SecureDirectoryStream r2 = (java.nio.file.SecureDirectoryStream) r2     // Catch:{ all -> 0x0030 }
            java.nio.file.Path r4 = r7.getFileName()     // Catch:{ all -> 0x0030 }
            i(r2, r4, r0)     // Catch:{ all -> 0x0030 }
            goto L_0x0029
        L_0x0028:
            r1 = r2
        L_0x0029:
            kotlin.Unit r2 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0030 }
            kotlin.io.b.a(r5, r3)
            r2 = r1
            goto L_0x0037
        L_0x0030:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            kotlin.io.b.a(r5, r7)
            throw r0
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            k(r7, r0)
        L_0x003c:
            java.util.List r7 = r0.d()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.g(java.nio.file.Path):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.b.a(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void h(java.nio.file.SecureDirectoryStream<java.nio.file.Path> r4, java.nio.file.Path r5, kotlin.io.path.ExceptionsCollector r6) {
        /*
            r0 = 1
            r1 = 0
            java.nio.file.LinkOption[] r0 = new java.nio.file.LinkOption[r0]     // Catch:{ NoSuchFileException -> 0x0010 }
            r2 = 0
            java.nio.file.LinkOption r3 = java.nio.file.LinkOption.NOFOLLOW_LINKS     // Catch:{ NoSuchFileException -> 0x0010 }
            r0[r2] = r3     // Catch:{ NoSuchFileException -> 0x0010 }
            java.nio.file.SecureDirectoryStream r4 = r4.newDirectoryStream(r5, r0)     // Catch:{ NoSuchFileException -> 0x0010 }
            goto L_0x0011
        L_0x000e:
            r4 = move-exception
            goto L_0x0038
        L_0x0010:
            r4 = r1
        L_0x0011:
            if (r4 == 0) goto L_0x003b
            java.util.Iterator r5 = r4.iterator()     // Catch:{ all -> 0x0031 }
        L_0x0017:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x0031 }
            java.nio.file.Path r0 = (java.nio.file.Path) r0     // Catch:{ all -> 0x0031 }
            java.nio.file.Path r0 = r0.getFileName()     // Catch:{ all -> 0x0031 }
            i(r4, r0, r6)     // Catch:{ all -> 0x0031 }
            goto L_0x0017
        L_0x002b:
            kotlin.Unit r5 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0031 }
            kotlin.io.b.a(r4, r1)     // Catch:{ Exception -> 0x000e }
            goto L_0x003b
        L_0x0031:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r0 = move-exception
            kotlin.io.b.a(r4, r5)     // Catch:{ Exception -> 0x000e }
            throw r0     // Catch:{ Exception -> 0x000e }
        L_0x0038:
            r6.a(r4)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.h(java.nio.file.SecureDirectoryStream, java.nio.file.Path, kotlin.io.path.ExceptionsCollector):void");
    }

    public static final void i(SecureDirectoryStream<Path> secureDirectoryStream, Path path, ExceptionsCollector exceptionsCollector) {
        exceptionsCollector.b(path);
        try {
            if (l(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
                int e11 = exceptionsCollector.e();
                h(secureDirectoryStream, path, exceptionsCollector);
                if (e11 == exceptionsCollector.e()) {
                    try {
                        secureDirectoryStream.deleteDirectory(path);
                        Unit unit = Unit.f56620a;
                    } catch (NoSuchFileException unused) {
                    }
                }
            } else {
                secureDirectoryStream.deleteFile(path);
                Unit unit2 = Unit.f56620a;
            }
        } catch (Exception e12) {
            exceptionsCollector.a(e12);
        }
        exceptionsCollector.c(path);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.b.a(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002b, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void j(java.nio.file.Path r3, kotlin.io.path.ExceptionsCollector r4) {
        /*
            r0 = 0
            java.nio.file.DirectoryStream r3 = java.nio.file.Files.newDirectoryStream(r3)     // Catch:{ NoSuchFileException -> 0x0008 }
            goto L_0x0009
        L_0x0006:
            r3 = move-exception
            goto L_0x002c
        L_0x0008:
            r3 = r0
        L_0x0009:
            if (r3 == 0) goto L_0x002f
            java.util.Iterator r1 = r3.iterator()     // Catch:{ all -> 0x0025 }
        L_0x000f:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x001f
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0025 }
            java.nio.file.Path r2 = (java.nio.file.Path) r2     // Catch:{ all -> 0x0025 }
            k(r2, r4)     // Catch:{ all -> 0x0025 }
            goto L_0x000f
        L_0x001f:
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0025 }
            kotlin.io.b.a(r3, r0)     // Catch:{ Exception -> 0x0006 }
            goto L_0x002f
        L_0x0025:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r1 = move-exception
            kotlin.io.b.a(r3, r0)     // Catch:{ Exception -> 0x0006 }
            throw r1     // Catch:{ Exception -> 0x0006 }
        L_0x002c:
            r4.a(r3)
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.j(java.nio.file.Path, kotlin.io.path.ExceptionsCollector):void");
    }

    public static final void k(Path path, ExceptionsCollector exceptionsCollector) {
        try {
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                int e11 = exceptionsCollector.e();
                j(path, exceptionsCollector);
                if (e11 == exceptionsCollector.e()) {
                    Files.deleteIfExists(path);
                    return;
                }
                return;
            }
            Files.deleteIfExists(path);
        } catch (Exception e12) {
            exceptionsCollector.a(e12);
        }
    }

    public static final boolean l(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) {
        Boolean bool;
        try {
            bool = Boolean.valueOf(((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))).readAttributes().isDirectory());
        } catch (NoSuchFileException unused) {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final FileVisitResult m(CopyActionResult copyActionResult) {
        int i11 = a.f56736a[copyActionResult.ordinal()];
        if (i11 == 1) {
            return FileVisitResult.CONTINUE;
        }
        if (i11 == 2) {
            return FileVisitResult.TERMINATE;
        }
        if (i11 == 3) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final FileVisitResult n(OnErrorResult onErrorResult) {
        int i11 = a.f56737b[onErrorResult.ordinal()];
        if (i11 == 1) {
            return FileVisitResult.TERMINATE;
        }
        if (i11 == 2) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
