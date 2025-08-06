package okio;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class Path implements Comparable<Path> {
    public static final Companion Companion = new Companion((r) null);
    public static final String DIRECTORY_SEPARATOR = File.separator;
    private final ByteString bytes;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            return companion.get(str, z11);
        }

        public final Path get(File file) {
            return get$default(this, file, false, 1, (Object) null);
        }

        public final Path get(String str) {
            return get$default(this, str, false, 1, (Object) null);
        }

        public final Path get(String str, boolean z11) {
            return okio.internal.Path.commonToPath(str, z11);
        }

        public final Path get(java.nio.file.Path path) {
            return get$default(this, path, false, 1, (Object) null);
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            return companion.get(file, z11);
        }

        public final Path get(File file, boolean z11) {
            return get(file.toString(), z11);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            return companion.get(path, z11);
        }

        public final Path get(java.nio.file.Path path, boolean z11) {
            return get(path.toString(), z11);
        }
    }

    public Path(ByteString byteString) {
        this.bytes = byteString;
    }

    public static final Path get(File file) {
        return Companion.get(file);
    }

    public static final Path get(File file, boolean z11) {
        return Companion.get(file, z11);
    }

    public static final Path get(String str) {
        return Companion.get(str);
    }

    public static final Path get(String str, boolean z11) {
        return Companion.get(str, z11);
    }

    public static final Path get(java.nio.file.Path path) {
        return Companion.get(path);
    }

    public static final Path get(java.nio.file.Path path, boolean z11) {
        return Companion.get(path, z11);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return path.resolve(str, z11);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Path) && x.b(((Path) obj).getBytes$okio(), getBytes$okio());
    }

    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    public final Path getRoot() {
        int access$rootLength = okio.internal.Path.rootLength(this);
        if (access$rootLength == -1) {
            return null;
        }
        return new Path(getBytes$okio().substring(0, access$rootLength));
    }

    public final List<String> getSegments() {
        ArrayList<ByteString> arrayList = new ArrayList<>();
        int access$rootLength = okio.internal.Path.rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes$okio().size() && getBytes$okio().getByte(access$rootLength) == 92) {
            access$rootLength++;
        }
        int size = getBytes$okio().size();
        int i11 = access$rootLength;
        while (access$rootLength < size) {
            if (getBytes$okio().getByte(access$rootLength) == 47 || getBytes$okio().getByte(access$rootLength) == 92) {
                arrayList.add(getBytes$okio().substring(i11, access$rootLength));
                i11 = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i11 < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i11, getBytes$okio().size()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList, 10));
        for (ByteString utf8 : arrayList) {
            arrayList2.add(utf8.utf8());
        }
        return arrayList2;
    }

    public final List<ByteString> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int access$rootLength = okio.internal.Path.rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes$okio().size() && getBytes$okio().getByte(access$rootLength) == 92) {
            access$rootLength++;
        }
        int size = getBytes$okio().size();
        int i11 = access$rootLength;
        while (access$rootLength < size) {
            if (getBytes$okio().getByte(access$rootLength) == 47 || getBytes$okio().getByte(access$rootLength) == 92) {
                arrayList.add(getBytes$okio().substring(i11, access$rootLength));
                i11 = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i11 < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i11, getBytes$okio().size()));
        }
        return arrayList;
    }

    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    public final boolean isAbsolute() {
        return okio.internal.Path.rootLength(this) != -1;
    }

    public final boolean isRelative() {
        return okio.internal.Path.rootLength(this) == -1;
    }

    public final boolean isRoot() {
        return okio.internal.Path.rootLength(this) == getBytes$okio().size();
    }

    public final String name() {
        return nameBytes().utf8();
    }

    public final ByteString nameBytes() {
        int access$getIndexOfLastSlash = okio.internal.Path.getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash != -1) {
            return ByteString.substring$default(getBytes$okio(), access$getIndexOfLastSlash + 1, 0, 2, (Object) null);
        }
        if (volumeLetter() == null || getBytes$okio().size() != 2) {
            return getBytes$okio();
        }
        return ByteString.EMPTY;
    }

    public final Path normalized() {
        return Companion.get(toString(), true);
    }

    public final Path parent() {
        Path path;
        if (x.b(getBytes$okio(), okio.internal.Path.DOT) || x.b(getBytes$okio(), okio.internal.Path.SLASH) || x.b(getBytes$okio(), okio.internal.Path.BACKSLASH) || okio.internal.Path.lastSegmentIsDotDot(this)) {
            return null;
        }
        int access$getIndexOfLastSlash = okio.internal.Path.getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash != 2 || volumeLetter() == null) {
            if (access$getIndexOfLastSlash == 1 && getBytes$okio().startsWith(okio.internal.Path.BACKSLASH)) {
                return null;
            }
            if (access$getIndexOfLastSlash != -1 || volumeLetter() == null) {
                if (access$getIndexOfLastSlash == -1) {
                    return new Path(okio.internal.Path.DOT);
                }
                if (access$getIndexOfLastSlash != 0) {
                    return new Path(ByteString.substring$default(getBytes$okio(), 0, access$getIndexOfLastSlash, 1, (Object) null));
                }
                path = new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, (Object) null));
            } else if (getBytes$okio().size() == 2) {
                return null;
            } else {
                path = new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, (Object) null));
            }
        } else if (getBytes$okio().size() == 3) {
            return null;
        } else {
            path = new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, (Object) null));
        }
        return path;
    }

    public final Path relativeTo(Path path) {
        if (x.b(getRoot(), path.getRoot())) {
            List<ByteString> segmentsBytes = getSegmentsBytes();
            List<ByteString> segmentsBytes2 = path.getSegmentsBytes();
            int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
            int i11 = 0;
            while (i11 < min && x.b(segmentsBytes.get(i11), segmentsBytes2.get(i11))) {
                i11++;
            }
            boolean z11 = true;
            if (i11 == min && getBytes$okio().size() == path.getBytes$okio().size()) {
                return Companion.get$default(Companion, InstructionFileId.DOT, false, 1, (Object) null);
            }
            if (segmentsBytes2.subList(i11, segmentsBytes2.size()).indexOf(okio.internal.Path.DOT_DOT) != -1) {
                z11 = false;
            }
            if (z11) {
                Buffer buffer = new Buffer();
                ByteString access$getSlash = okio.internal.Path.getSlash(path);
                if (access$getSlash == null && (access$getSlash = okio.internal.Path.getSlash(this)) == null) {
                    access$getSlash = okio.internal.Path.toSlash(DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                for (int i12 = i11; i12 < size; i12++) {
                    buffer.write(okio.internal.Path.DOT_DOT);
                    buffer.write(access$getSlash);
                }
                int size2 = segmentsBytes.size();
                while (i11 < size2) {
                    buffer.write(segmentsBytes.get(i11));
                    buffer.write(access$getSlash);
                    i11++;
                }
                return okio.internal.Path.toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + path).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + path).toString());
    }

    public final Path resolve(Path path) {
        return okio.internal.Path.commonResolve(this, path, false);
    }

    public final File toFile() {
        return new File(toString());
    }

    public final java.nio.file.Path toNioPath() {
        return Paths.get(toString(), new String[0]);
    }

    public String toString() {
        return getBytes$okio().utf8();
    }

    public final Character volumeLetter() {
        boolean z11 = false;
        if (ByteString.indexOf$default(getBytes$okio(), okio.internal.Path.SLASH, 0, 2, (Object) null) != -1 || getBytes$okio().size() < 2 || getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c11 = (char) getBytes$okio().getByte(0);
        if (!('a' <= c11 && c11 < '{')) {
            if ('A' <= c11 && c11 < '[') {
                z11 = true;
            }
            if (!z11) {
                return null;
            }
        }
        return Character.valueOf(c11);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return path.resolve(byteString, z11);
    }

    public int compareTo(Path path) {
        return getBytes$okio().compareTo(path.getBytes$okio());
    }

    public final Path resolve(Path path, boolean z11) {
        return okio.internal.Path.commonResolve(this, path, z11);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return path.resolve(path2, z11);
    }

    public final Path resolve(String str) {
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().writeUtf8(str), false), false);
    }

    public final Path resolve(ByteString byteString) {
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().write(byteString), false), false);
    }

    public final Path resolve(String str, boolean z11) {
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().writeUtf8(str), false), z11);
    }

    public final Path resolve(ByteString byteString, boolean z11) {
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().write(byteString), false), z11);
    }
}
