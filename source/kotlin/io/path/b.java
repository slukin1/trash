package kotlin.io.path;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f56738a = new b();

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002c, code lost:
        if (java.nio.file.Files.isDirectory(r6, (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(new java.nio.file.LinkOption[]{java.nio.file.LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.io.path.CopyActionResult a(java.nio.file.Path r5, java.nio.file.Path r6, boolean r7) {
        /*
            r4 = this;
            kotlin.io.path.e r0 = kotlin.io.path.e.f56742a
            java.nio.file.LinkOption[] r7 = r0.a(r7)
            int r0 = r7.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r7, r0)
            java.nio.file.LinkOption[] r0 = (java.nio.file.LinkOption[]) r0
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.nio.file.LinkOption[] r0 = (java.nio.file.LinkOption[]) r0
            boolean r0 = java.nio.file.Files.isDirectory(r5, r0)
            if (r0 == 0) goto L_0x002e
            r0 = 1
            java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r0]
            r2 = 0
            java.nio.file.LinkOption r3 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r1[r2] = r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r0)
            java.nio.file.LinkOption[] r0 = (java.nio.file.LinkOption[]) r0
            boolean r0 = java.nio.file.Files.isDirectory(r6, r0)
            if (r0 != 0) goto L_0x003f
        L_0x002e:
            int r0 = r7.length
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r0)
            java.nio.file.CopyOption[] r7 = (java.nio.file.CopyOption[]) r7
            int r0 = r7.length
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r0)
            java.nio.file.CopyOption[] r7 = (java.nio.file.CopyOption[]) r7
            java.nio.file.Files.copy(r5, r6, r7)
        L_0x003f:
            kotlin.io.path.CopyActionResult r5 = kotlin.io.path.CopyActionResult.CONTINUE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.b.a(java.nio.file.Path, java.nio.file.Path, boolean):kotlin.io.path.CopyActionResult");
    }
}
