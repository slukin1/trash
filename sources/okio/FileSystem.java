package okio;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.sequences.g;
import okio.Path;
import okio.internal.ResourceFileSystem;

public abstract class FileSystem {
    public static final Companion Companion = new Companion((r) null);
    public static final FileSystem RESOURCES = new ResourceFileSystem(ResourceFileSystem.class.getClassLoader(), false, (FileSystem) null, 4, (r) null);
    public static final FileSystem SYSTEM;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(Path.Companion, System.getProperty("java.io.tmpdir"), false, 1, (Object) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final FileSystem get(java.nio.file.FileSystem fileSystem) {
            return new NioFileSystemWrappingFileSystem(fileSystem);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a  */
    /* renamed from: -write$default  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object m3231write$default(okio.FileSystem r1, okio.Path r2, boolean r3, d10.l r4, int r5, java.lang.Object r6) throws java.io.IOException {
        /*
            if (r6 != 0) goto L_0x003b
            r5 = r5 & 2
            if (r5 == 0) goto L_0x0007
            r3 = 0
        L_0x0007:
            okio.Sink r1 = r1.sink(r2, r3)
            okio.BufferedSink r1 = okio.Okio.buffer((okio.Sink) r1)
            r2 = 0
            r3 = 1
            java.lang.Object r4 = r4.invoke(r1)     // Catch:{ all -> 0x0023 }
            kotlin.jvm.internal.InlineMarker.b(r3)
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ all -> 0x001e }
            goto L_0x001f
        L_0x001e:
            r2 = move-exception
        L_0x001f:
            kotlin.jvm.internal.InlineMarker.a(r3)
            goto L_0x0037
        L_0x0023:
            r4 = move-exception
            kotlin.jvm.internal.InlineMarker.b(r3)
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ all -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r1 = move-exception
            kotlin.ExceptionsKt__ExceptionsKt.a(r4, r1)
        L_0x0031:
            kotlin.jvm.internal.InlineMarker.a(r3)
            r0 = r4
            r4 = r2
            r2 = r0
        L_0x0037:
            if (r2 != 0) goto L_0x003a
            return r4
        L_0x003a:
            throw r2
        L_0x003b:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Super calls with default arguments not supported in this target, function: write"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.FileSystem.m3231write$default(okio.FileSystem, okio.Path, boolean, d10.l, int, java.lang.Object):java.lang.Object");
    }

    static {
        FileSystem fileSystem;
        try {
            Class.forName("java.nio.file.Files");
            fileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            fileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = fileSystem;
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return fileSystem.appendingSink(path, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            fileSystem.createDirectories(path, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            fileSystem.createDirectory(path, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            fileSystem.delete(path, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            fileSystem.deleteRecursively(path, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
    }

    public static final FileSystem get(java.nio.file.FileSystem fileSystem) {
        return Companion.get(fileSystem);
    }

    public static /* synthetic */ g listRecursively$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return fileSystem.listRecursively(path, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z11, boolean z12, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            return fileSystem.openReadWrite(path, z11, z12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return fileSystem.sink(path, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
    /* renamed from: -read  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T m3232read(okio.Path r4, d10.l<? super okio.BufferedSource, ? extends T> r5) throws java.io.IOException {
        /*
            r3 = this;
            okio.Source r4 = r3.source(r4)
            okio.BufferedSource r4 = okio.Okio.buffer((okio.Source) r4)
            r0 = 0
            r1 = 1
            java.lang.Object r5 = r5.invoke(r4)     // Catch:{ all -> 0x001c }
            kotlin.jvm.internal.InlineMarker.b(r1)
            if (r4 == 0) goto L_0x0018
            r4.close()     // Catch:{ all -> 0x0017 }
            goto L_0x0018
        L_0x0017:
            r0 = move-exception
        L_0x0018:
            kotlin.jvm.internal.InlineMarker.a(r1)
            goto L_0x0030
        L_0x001c:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.b(r1)
            if (r4 == 0) goto L_0x002a
            r4.close()     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r4 = move-exception
            kotlin.ExceptionsKt__ExceptionsKt.a(r5, r4)
        L_0x002a:
            kotlin.jvm.internal.InlineMarker.a(r1)
            r2 = r0
            r0 = r5
            r5 = r2
        L_0x0030:
            if (r0 != 0) goto L_0x0033
            return r5
        L_0x0033:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.FileSystem.m3232read(okio.Path, d10.l):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
    /* renamed from: -write  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T m3233write(okio.Path r3, boolean r4, d10.l<? super okio.BufferedSink, ? extends T> r5) throws java.io.IOException {
        /*
            r2 = this;
            okio.Sink r3 = r2.sink(r3, r4)
            okio.BufferedSink r3 = okio.Okio.buffer((okio.Sink) r3)
            r4 = 0
            r0 = 1
            java.lang.Object r5 = r5.invoke(r3)     // Catch:{ all -> 0x001c }
            kotlin.jvm.internal.InlineMarker.b(r0)
            if (r3 == 0) goto L_0x0018
            r3.close()     // Catch:{ all -> 0x0017 }
            goto L_0x0018
        L_0x0017:
            r4 = move-exception
        L_0x0018:
            kotlin.jvm.internal.InlineMarker.a(r0)
            goto L_0x0030
        L_0x001c:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.b(r0)
            if (r3 == 0) goto L_0x002a
            r3.close()     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r3 = move-exception
            kotlin.ExceptionsKt__ExceptionsKt.a(r5, r3)
        L_0x002a:
            kotlin.jvm.internal.InlineMarker.a(r0)
            r1 = r5
            r5 = r4
            r4 = r1
        L_0x0030:
            if (r4 != 0) goto L_0x0033
            return r5
        L_0x0033:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.FileSystem.m3233write(okio.Path, boolean, d10.l):java.lang.Object");
    }

    public final Sink appendingSink(Path path) throws IOException {
        return appendingSink(path, false);
    }

    public abstract Sink appendingSink(Path path, boolean z11) throws IOException;

    public abstract void atomicMove(Path path, Path path2) throws IOException;

    public abstract Path canonicalize(Path path) throws IOException;

    public void copy(Path path, Path path2) throws IOException {
        okio.internal.FileSystem.commonCopy(this, path, path2);
    }

    public final void createDirectories(Path path, boolean z11) throws IOException {
        okio.internal.FileSystem.commonCreateDirectories(this, path, z11);
    }

    public final void createDirectory(Path path) throws IOException {
        createDirectory(path, false);
    }

    public abstract void createDirectory(Path path, boolean z11) throws IOException;

    public abstract void createSymlink(Path path, Path path2) throws IOException;

    public final void delete(Path path) throws IOException {
        delete(path, false);
    }

    public abstract void delete(Path path, boolean z11) throws IOException;

    public void deleteRecursively(Path path, boolean z11) throws IOException {
        okio.internal.FileSystem.commonDeleteRecursively(this, path, z11);
    }

    public final boolean exists(Path path) throws IOException {
        return okio.internal.FileSystem.commonExists(this, path);
    }

    public abstract List<Path> list(Path path) throws IOException;

    public abstract List<Path> listOrNull(Path path);

    public g<Path> listRecursively(Path path, boolean z11) {
        return okio.internal.FileSystem.commonListRecursively(this, path, z11);
    }

    public final FileMetadata metadata(Path path) throws IOException {
        return okio.internal.FileSystem.commonMetadata(this, path);
    }

    public abstract FileMetadata metadataOrNull(Path path) throws IOException;

    public abstract FileHandle openReadOnly(Path path) throws IOException;

    public final FileHandle openReadWrite(Path path) throws IOException {
        return openReadWrite(path, false, false);
    }

    public abstract FileHandle openReadWrite(Path path, boolean z11, boolean z12) throws IOException;

    public final Sink sink(Path path) throws IOException {
        return sink(path, false);
    }

    public abstract Sink sink(Path path, boolean z11) throws IOException;

    public abstract Source source(Path path) throws IOException;

    public final void createDirectories(Path path) throws IOException {
        createDirectories(path, false);
    }

    public final void deleteRecursively(Path path) throws IOException {
        deleteRecursively(path, false);
    }

    public final g<Path> listRecursively(Path path) {
        return listRecursively(path, false);
    }
}
