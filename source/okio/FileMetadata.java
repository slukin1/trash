package okio;

import d10.l;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.reflect.c;
import kotlin.reflect.d;

public final class FileMetadata {
    private final Long createdAtMillis;
    private final Map<c<?>, Object> extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;
    private final Long lastAccessedAtMillis;
    private final Long lastModifiedAtMillis;
    private final Long size;
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, (Path) null, (Long) null, (Long) null, (Long) null, (Long) null, (Map) null, 255, (r) null);
    }

    public FileMetadata(boolean z11, boolean z12, Path path, Long l11, Long l12, Long l13, Long l14, Map<c<?>, ? extends Object> map) {
        this.isRegularFile = z11;
        this.isDirectory = z12;
        this.symlinkTarget = path;
        this.size = l11;
        this.createdAtMillis = l12;
        this.lastModifiedAtMillis = l13;
        this.lastAccessedAtMillis = l14;
        this.extras = MapsKt__MapsKt.u(map);
    }

    public static /* synthetic */ FileMetadata copy$default(FileMetadata fileMetadata, boolean z11, boolean z12, Path path, Long l11, Long l12, Long l13, Long l14, Map map, int i11, Object obj) {
        FileMetadata fileMetadata2 = fileMetadata;
        int i12 = i11;
        return fileMetadata.copy((i12 & 1) != 0 ? fileMetadata2.isRegularFile : z11, (i12 & 2) != 0 ? fileMetadata2.isDirectory : z12, (i12 & 4) != 0 ? fileMetadata2.symlinkTarget : path, (i12 & 8) != 0 ? fileMetadata2.size : l11, (i12 & 16) != 0 ? fileMetadata2.createdAtMillis : l12, (i12 & 32) != 0 ? fileMetadata2.lastModifiedAtMillis : l13, (i12 & 64) != 0 ? fileMetadata2.lastAccessedAtMillis : l14, (i12 & 128) != 0 ? fileMetadata2.extras : map);
    }

    public final FileMetadata copy(boolean z11, boolean z12, Path path, Long l11, Long l12, Long l13, Long l14, Map<c<?>, ? extends Object> map) {
        return new FileMetadata(z11, z12, path, l11, l12, l13, l14, map);
    }

    public final <T> T extra(c<? extends T> cVar) {
        Object obj = this.extras.get(cVar);
        if (obj == null) {
            return null;
        }
        return d.a(cVar, obj);
    }

    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public final Map<c<?>, Object> getExtras() {
        return this.extras;
    }

    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.isRegularFile) {
            arrayList.add("isRegularFile");
        }
        if (this.isDirectory) {
            arrayList.add("isDirectory");
        }
        if (this.size != null) {
            arrayList.add("byteCount=" + this.size);
        }
        if (this.createdAtMillis != null) {
            arrayList.add("createdAt=" + this.createdAtMillis);
        }
        if (this.lastModifiedAtMillis != null) {
            arrayList.add("lastModifiedAt=" + this.lastModifiedAtMillis);
        }
        if (this.lastAccessedAtMillis != null) {
            arrayList.add("lastAccessedAt=" + this.lastAccessedAtMillis);
        }
        if (!this.extras.isEmpty()) {
            arrayList.add("extras=" + this.extras);
        }
        return CollectionsKt___CollectionsKt.k0(arrayList, ", ", "FileMetadata(", ")", 0, (CharSequence) null, (l) null, 56, (Object) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FileMetadata(boolean r10, boolean r11, okio.Path r12, java.lang.Long r13, java.lang.Long r14, java.lang.Long r15, java.lang.Long r16, java.util.Map r17, int r18, kotlin.jvm.internal.r r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r2 = r11
        L_0x0010:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0017
            r3 = r4
            goto L_0x0018
        L_0x0017:
            r3 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r4
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r4
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r4
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r4 = r16
        L_0x0034:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003d
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.h()
            goto L_0x003f
        L_0x003d:
            r0 = r17
        L_0x003f:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r4
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.FileMetadata.<init>(boolean, boolean, okio.Path, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.util.Map, int, kotlin.jvm.internal.r):void");
    }
}
