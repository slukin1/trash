package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.c;
import kotlin.sequences.g;
import okio.FileMetadata;
import okio.Path;

/* renamed from: okio.internal.-FileSystem  reason: invalid class name */
public final class FileSystem {
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e1, code lost:
        if (r0 != false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e3, code lost:
        if (r14 != 0) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e5, code lost:
        r6.addLast(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ec, code lost:
        r13 = r12;
        r12 = r11;
        r11 = r6;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0130, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0131, code lost:
        r11 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0132, code lost:
        r11.removeLast();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0135, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f9 A[Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0129 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object collectRecursively(kotlin.sequences.SequenceScope<? super okio.Path> r17, okio.FileSystem r18, kotlin.collections.ArrayDeque<okio.Path> r19, okio.Path r20, boolean r21, boolean r22, kotlin.coroutines.c<? super kotlin.Unit> r23) {
        /*
            r0 = r17
            r1 = r20
            r2 = r22
            r3 = r23
            boolean r4 = r3 instanceof okio.internal.FileSystem$collectRecursively$1
            if (r4 == 0) goto L_0x001b
            r4 = r3
            okio.internal.-FileSystem$collectRecursively$1 r4 = (okio.internal.FileSystem$collectRecursively$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.label = r5
            goto L_0x0020
        L_0x001b:
            okio.internal.-FileSystem$collectRecursively$1 r4 = new okio.internal.-FileSystem$collectRecursively$1
            r4.<init>(r3)
        L_0x0020:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r6 = r4.label
            r7 = 0
            r8 = 3
            r9 = 2
            r10 = 1
            if (r6 == 0) goto L_0x007f
            if (r6 == r10) goto L_0x0061
            if (r6 == r9) goto L_0x0041
            if (r6 != r8) goto L_0x0039
            kotlin.k.b(r3)
            goto L_0x0150
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0041:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r6 = r4.L$3
            okio.Path r6 = (okio.Path) r6
            java.lang.Object r11 = r4.L$2
            kotlin.collections.ArrayDeque r11 = (kotlin.collections.ArrayDeque) r11
            java.lang.Object r12 = r4.L$1
            okio.FileSystem r12 = (okio.FileSystem) r12
            java.lang.Object r13 = r4.L$0
            kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
            kotlin.k.b(r3)     // Catch:{ all -> 0x005e }
            goto L_0x00f3
        L_0x005e:
            r0 = move-exception
            goto L_0x0132
        L_0x0061:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$3
            okio.Path r2 = (okio.Path) r2
            java.lang.Object r6 = r4.L$2
            kotlin.collections.ArrayDeque r6 = (kotlin.collections.ArrayDeque) r6
            java.lang.Object r11 = r4.L$1
            okio.FileSystem r11 = (okio.FileSystem) r11
            java.lang.Object r12 = r4.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.k.b(r3)
            r16 = r2
            r2 = r0
            r0 = r1
            r1 = r16
            goto L_0x00a8
        L_0x007f:
            kotlin.k.b(r3)
            if (r2 != 0) goto L_0x009f
            r4.L$0 = r0
            r3 = r18
            r4.L$1 = r3
            r6 = r19
            r4.L$2 = r6
            r4.L$3 = r1
            r11 = r21
            r4.Z$0 = r11
            r4.Z$1 = r2
            r4.label = r10
            java.lang.Object r12 = r0.b(r1, r4)
            if (r12 != r5) goto L_0x00a5
            return r5
        L_0x009f:
            r3 = r18
            r6 = r19
            r11 = r21
        L_0x00a5:
            r12 = r0
            r0 = r11
            r11 = r3
        L_0x00a8:
            java.util.List r3 = r11.listOrNull(r1)
            if (r3 != 0) goto L_0x00b2
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x00b2:
            boolean r13 = r3.isEmpty()
            r13 = r13 ^ r10
            if (r13 == 0) goto L_0x013a
            r13 = r1
            r14 = r7
        L_0x00bb:
            if (r0 == 0) goto L_0x00db
            boolean r15 = r6.contains(r13)
            if (r15 != 0) goto L_0x00c4
            goto L_0x00db
        L_0x00c4:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "symlink cycle at "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x00db:
            okio.Path r15 = symlinkTarget(r11, r13)
            if (r15 != 0) goto L_0x0136
            if (r0 != 0) goto L_0x00e5
            if (r14 != 0) goto L_0x013a
        L_0x00e5:
            r6.addLast(r13)
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0130 }
            r13 = r12
            r12 = r11
            r11 = r6
            r6 = r1
            r1 = r0
            r0 = r2
            r2 = r3
        L_0x00f3:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x0129
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x005e }
            okio.Path r3 = (okio.Path) r3     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0103
            r14 = r10
            goto L_0x0104
        L_0x0103:
            r14 = r7
        L_0x0104:
            r4.L$0 = r13     // Catch:{ all -> 0x005e }
            r4.L$1 = r12     // Catch:{ all -> 0x005e }
            r4.L$2 = r11     // Catch:{ all -> 0x005e }
            r4.L$3 = r6     // Catch:{ all -> 0x005e }
            r4.L$4 = r2     // Catch:{ all -> 0x005e }
            r4.Z$0 = r1     // Catch:{ all -> 0x005e }
            r4.Z$1 = r0     // Catch:{ all -> 0x005e }
            r4.label = r9     // Catch:{ all -> 0x005e }
            r17 = r13
            r18 = r12
            r19 = r11
            r20 = r3
            r21 = r1
            r22 = r14
            r23 = r4
            java.lang.Object r3 = collectRecursively(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x005e }
            if (r3 != r5) goto L_0x00f3
            return r5
        L_0x0129:
            r11.removeLast()
            r2 = r0
            r1 = r6
            r12 = r13
            goto L_0x013a
        L_0x0130:
            r0 = move-exception
            r11 = r6
        L_0x0132:
            r11.removeLast()
            throw r0
        L_0x0136:
            int r14 = r14 + 1
            r13 = r15
            goto L_0x00bb
        L_0x013a:
            if (r2 == 0) goto L_0x0153
            r0 = 0
            r4.L$0 = r0
            r4.L$1 = r0
            r4.L$2 = r0
            r4.L$3 = r0
            r4.L$4 = r0
            r4.label = r8
            java.lang.Object r0 = r12.b(r1, r4)
            if (r0 != r5) goto L_0x0150
            return r5
        L_0x0150:
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        L_0x0153:
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.collectRecursively(kotlin.sequences.SequenceScope, okio.FileSystem, kotlin.collections.ArrayDeque, okio.Path, boolean, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[Catch:{ all -> 0x001f, all -> 0x0026, all -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0039 A[SYNTHETIC, Splitter:B:25:0x0039] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void commonCopy(okio.FileSystem r2, okio.Path r3, okio.Path r4) throws java.io.IOException {
        /*
            okio.Source r3 = r2.source(r3)
            okio.Sink r2 = r2.sink(r4)     // Catch:{ all -> 0x003a }
            okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x003a }
            r4 = 0
            long r0 = r2.writeAll(r3)     // Catch:{ all -> 0x001f }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x001d
            r2.close()     // Catch:{ all -> 0x001b }
            goto L_0x001d
        L_0x001b:
            r2 = move-exception
            goto L_0x002c
        L_0x001d:
            r2 = r4
            goto L_0x002c
        L_0x001f:
            r0 = move-exception
            if (r2 == 0) goto L_0x002a
            r2.close()     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r2 = move-exception
            kotlin.ExceptionsKt__ExceptionsKt.a(r0, r2)     // Catch:{ all -> 0x003a }
        L_0x002a:
            r2 = r0
            r0 = r4
        L_0x002c:
            if (r2 != 0) goto L_0x0039
            r0.longValue()     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0046
            r3.close()     // Catch:{ all -> 0x0037 }
            goto L_0x0046
        L_0x0037:
            r4 = move-exception
            goto L_0x0046
        L_0x0039:
            throw r2     // Catch:{ all -> 0x003a }
        L_0x003a:
            r2 = move-exception
            if (r3 == 0) goto L_0x0045
            r3.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r3 = move-exception
            kotlin.ExceptionsKt__ExceptionsKt.a(r2, r3)
        L_0x0045:
            r4 = r2
        L_0x0046:
            if (r4 != 0) goto L_0x0049
            return
        L_0x0049:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.commonCopy(okio.FileSystem, okio.Path, okio.Path):void");
    }

    public static final void commonCreateDirectories(okio.FileSystem fileSystem, Path path, boolean z11) throws IOException {
        ArrayDeque arrayDeque = new ArrayDeque();
        Path path2 = path;
        while (path2 != null && !fileSystem.exists(path2)) {
            arrayDeque.addFirst(path2);
            path2 = path2.parent();
        }
        if (!z11 || !arrayDeque.isEmpty()) {
            Iterator it2 = arrayDeque.iterator();
            while (it2.hasNext()) {
                fileSystem.createDirectory((Path) it2.next());
            }
            return;
        }
        throw new IOException(path + " already exists.");
    }

    public static final void commonDeleteRecursively(okio.FileSystem fileSystem, Path path, boolean z11) throws IOException {
        Iterator it2 = SequencesKt__SequenceBuilderKt.b(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, path, (c<? super FileSystem$commonDeleteRecursively$sequence$1>) null)).iterator();
        while (it2.hasNext()) {
            fileSystem.delete((Path) it2.next(), z11 && !it2.hasNext());
        }
    }

    public static final boolean commonExists(okio.FileSystem fileSystem, Path path) throws IOException {
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final g<Path> commonListRecursively(okio.FileSystem fileSystem, Path path, boolean z11) throws IOException {
        return SequencesKt__SequenceBuilderKt.b(new FileSystem$commonListRecursively$1(path, fileSystem, z11, (c<? super FileSystem$commonListRecursively$1>) null));
    }

    public static final FileMetadata commonMetadata(okio.FileSystem fileSystem, Path path) throws IOException {
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final Path symlinkTarget(okio.FileSystem fileSystem, Path path) throws IOException {
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        return path.parent().resolve(symlinkTarget);
    }
}
