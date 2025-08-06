package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import okio.Path;
import okio.internal.ZipEntry;

public final class ZipFileSystem extends FileSystem {
    private static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    private final String comment;
    private final Map<Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }
    }

    public ZipFileSystem(Path path, FileSystem fileSystem2, Map<Path, ZipEntry> map, String str) {
        this.zipPath = path;
        this.fileSystem = fileSystem2;
        this.entries = map;
        this.comment = str;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    public Sink appendingSink(Path path, boolean z11) {
        throw new IOException("zip file systems are read-only");
    }

    public void atomicMove(Path path, Path path2) {
        throw new IOException("zip file systems are read-only");
    }

    public Path canonicalize(Path path) {
        Path canonicalizeInternal = canonicalizeInternal(path);
        if (this.entries.containsKey(canonicalizeInternal)) {
            return canonicalizeInternal;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    public void createDirectory(Path path, boolean z11) {
        throw new IOException("zip file systems are read-only");
    }

    public void createSymlink(Path path, Path path2) {
        throw new IOException("zip file systems are read-only");
    }

    public void delete(Path path, boolean z11) {
        throw new IOException("zip file systems are read-only");
    }

    public List<Path> list(Path path) {
        return list(path, true);
    }

    public List<Path> listOrNull(Path path) {
        return list(path, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0080 A[SYNTHETIC, Splitter:B:33:0x0080] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okio.FileMetadata metadataOrNull(okio.Path r14) {
        /*
            r13 = this;
            okio.Path r14 = r13.canonicalizeInternal(r14)
            java.util.Map<okio.Path, okio.internal.ZipEntry> r0 = r13.entries
            java.lang.Object r14 = r0.get(r14)
            okio.internal.ZipEntry r14 = (okio.internal.ZipEntry) r14
            r0 = 0
            if (r14 != 0) goto L_0x0010
            return r0
        L_0x0010:
            okio.FileMetadata r12 = new okio.FileMetadata
            boolean r1 = r14.isDirectory()
            r2 = r1 ^ 1
            boolean r3 = r14.isDirectory()
            r4 = 0
            boolean r1 = r14.isDirectory()
            if (r1 == 0) goto L_0x0025
            r5 = r0
            goto L_0x002e
        L_0x0025:
            long r5 = r14.getSize()
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            r5 = r1
        L_0x002e:
            r6 = 0
            java.lang.Long r7 = r14.getLastModifiedAtMillis()
            r8 = 0
            r9 = 0
            r10 = 128(0x80, float:1.794E-43)
            r11 = 0
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            long r1 = r14.getOffset()
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0047
            return r12
        L_0x0047:
            okio.FileSystem r1 = r13.fileSystem
            okio.Path r2 = r13.zipPath
            okio.FileHandle r1 = r1.openReadOnly(r2)
            long r2 = r14.getOffset()     // Catch:{ all -> 0x0081 }
            okio.Source r14 = r1.source(r2)     // Catch:{ all -> 0x0081 }
            okio.BufferedSource r14 = okio.Okio.buffer((okio.Source) r14)     // Catch:{ all -> 0x0081 }
            okio.FileMetadata r2 = okio.internal.ZipFilesKt.readLocalHeader(r14, r12)     // Catch:{ all -> 0x0069 }
            if (r14 == 0) goto L_0x0067
            r14.close()     // Catch:{ all -> 0x0065 }
            goto L_0x0067
        L_0x0065:
            r14 = move-exception
            goto L_0x0076
        L_0x0067:
            r14 = r0
            goto L_0x0076
        L_0x0069:
            r2 = move-exception
            if (r14 == 0) goto L_0x0074
            r14.close()     // Catch:{ all -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r14 = move-exception
            kotlin.ExceptionsKt__ExceptionsKt.a(r2, r14)     // Catch:{ all -> 0x0081 }
        L_0x0074:
            r14 = r2
            r2 = r0
        L_0x0076:
            if (r14 != 0) goto L_0x0080
            if (r1 == 0) goto L_0x008e
            r1.close()     // Catch:{ all -> 0x007e }
            goto L_0x008e
        L_0x007e:
            r0 = move-exception
            goto L_0x008e
        L_0x0080:
            throw r14     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r14 = move-exception
            if (r1 == 0) goto L_0x008c
            r1.close()     // Catch:{ all -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r1 = move-exception
            kotlin.ExceptionsKt__ExceptionsKt.a(r14, r1)
        L_0x008c:
            r2 = r0
            r0 = r14
        L_0x008e:
            if (r0 != 0) goto L_0x0091
            return r2
        L_0x0091:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ZipFileSystem.metadataOrNull(okio.Path):okio.FileMetadata");
    }

    public FileHandle openReadOnly(Path path) {
        throw new UnsupportedOperationException("not implemented yet!");
    }

    public FileHandle openReadWrite(Path path, boolean z11, boolean z12) {
        throw new IOException("zip entries are not writable");
    }

    public Sink sink(Path path, boolean z11) {
        throw new IOException("zip file systems are read-only");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okio.Source source(okio.Path r8) throws java.io.IOException {
        /*
            r7 = this;
            okio.Path r0 = r7.canonicalizeInternal(r8)
            java.util.Map<okio.Path, okio.internal.ZipEntry> r1 = r7.entries
            java.lang.Object r0 = r1.get(r0)
            okio.internal.ZipEntry r0 = (okio.internal.ZipEntry) r0
            if (r0 == 0) goto L_0x006f
            okio.FileSystem r8 = r7.fileSystem
            okio.Path r1 = r7.zipPath
            okio.FileHandle r8 = r8.openReadOnly(r1)
            r1 = 0
            long r2 = r0.getOffset()     // Catch:{ all -> 0x002b }
            okio.Source r2 = r8.source(r2)     // Catch:{ all -> 0x002b }
            okio.BufferedSource r2 = okio.Okio.buffer((okio.Source) r2)     // Catch:{ all -> 0x002b }
            if (r8 == 0) goto L_0x0039
            r8.close()     // Catch:{ all -> 0x0029 }
            goto L_0x0039
        L_0x0029:
            r1 = move-exception
            goto L_0x0039
        L_0x002b:
            r2 = move-exception
            if (r8 == 0) goto L_0x0036
            r8.close()     // Catch:{ all -> 0x0032 }
            goto L_0x0036
        L_0x0032:
            r8 = move-exception
            kotlin.ExceptionsKt__ExceptionsKt.a(r2, r8)
        L_0x0036:
            r6 = r2
            r2 = r1
            r1 = r6
        L_0x0039:
            if (r1 != 0) goto L_0x006e
            okio.internal.ZipFilesKt.skipLocalHeader(r2)
            int r8 = r0.getCompressionMethod()
            r1 = 1
            if (r8 != 0) goto L_0x004f
            okio.internal.FixedLengthSource r8 = new okio.internal.FixedLengthSource
            long r3 = r0.getSize()
            r8.<init>(r2, r3, r1)
            goto L_0x006d
        L_0x004f:
            okio.InflaterSource r8 = new okio.InflaterSource
            okio.internal.FixedLengthSource r3 = new okio.internal.FixedLengthSource
            long r4 = r0.getCompressedSize()
            r3.<init>(r2, r4, r1)
            java.util.zip.Inflater r2 = new java.util.zip.Inflater
            r2.<init>(r1)
            r8.<init>((okio.Source) r3, (java.util.zip.Inflater) r2)
            okio.internal.FixedLengthSource r1 = new okio.internal.FixedLengthSource
            long r2 = r0.getSize()
            r0 = 0
            r1.<init>(r8, r2, r0)
            r8 = r1
        L_0x006d:
            return r8
        L_0x006e:
            throw r1
        L_0x006f:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "no such file: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ZipFileSystem.source(okio.Path):okio.Source");
    }

    private final List<Path> list(Path path, boolean z11) {
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry != null) {
            return CollectionsKt___CollectionsKt.I0(zipEntry.getChildren());
        }
        if (!z11) {
            return null;
        }
        throw new IOException("not a directory: " + path);
    }
}
