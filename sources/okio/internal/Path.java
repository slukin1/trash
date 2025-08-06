package okio.internal;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.x;
import okio.Buffer;
import okio.ByteString;
import okio.Path;

/* renamed from: okio.internal.-Path  reason: invalid class name */
public final class Path {
    private static final ByteString ANY_SLASH;
    /* access modifiers changed from: private */
    public static final ByteString BACKSLASH;
    /* access modifiers changed from: private */
    public static final ByteString DOT;
    /* access modifiers changed from: private */
    public static final ByteString DOT_DOT;
    /* access modifiers changed from: private */
    public static final ByteString SLASH;

    static {
        ByteString.Companion companion = ByteString.Companion;
        SLASH = companion.encodeUtf8("/");
        BACKSLASH = companion.encodeUtf8("\\");
        ANY_SLASH = companion.encodeUtf8("/\\");
        DOT = companion.encodeUtf8(InstructionFileId.DOT);
        DOT_DOT = companion.encodeUtf8("..");
    }

    public static final int commonCompareTo(okio.Path path, okio.Path path2) {
        return path.getBytes$okio().compareTo(path2.getBytes$okio());
    }

    public static final boolean commonEquals(okio.Path path, Object obj) {
        return (obj instanceof okio.Path) && x.b(((okio.Path) obj).getBytes$okio(), path.getBytes$okio());
    }

    public static final int commonHashCode(okio.Path path) {
        return path.getBytes$okio().hashCode();
    }

    public static final boolean commonIsAbsolute(okio.Path path) {
        return rootLength(path) != -1;
    }

    public static final boolean commonIsRelative(okio.Path path) {
        return rootLength(path) == -1;
    }

    public static final boolean commonIsRoot(okio.Path path) {
        return rootLength(path) == path.getBytes$okio().size();
    }

    public static final String commonName(okio.Path path) {
        return path.nameBytes().utf8();
    }

    public static final ByteString commonNameBytes(okio.Path path) {
        int access$getIndexOfLastSlash = getIndexOfLastSlash(path);
        if (access$getIndexOfLastSlash != -1) {
            return ByteString.substring$default(path.getBytes$okio(), access$getIndexOfLastSlash + 1, 0, 2, (Object) null);
        }
        if (path.volumeLetter() == null || path.getBytes$okio().size() != 2) {
            return path.getBytes$okio();
        }
        return ByteString.EMPTY;
    }

    public static final okio.Path commonNormalized(okio.Path path) {
        return okio.Path.Companion.get(path.toString(), true);
    }

    public static final okio.Path commonParent(okio.Path path) {
        if (x.b(path.getBytes$okio(), DOT) || x.b(path.getBytes$okio(), SLASH) || x.b(path.getBytes$okio(), BACKSLASH) || lastSegmentIsDotDot(path)) {
            return null;
        }
        int access$getIndexOfLastSlash = getIndexOfLastSlash(path);
        if (access$getIndexOfLastSlash != 2 || path.volumeLetter() == null) {
            if (access$getIndexOfLastSlash == 1 && path.getBytes$okio().startsWith(BACKSLASH)) {
                return null;
            }
            if (access$getIndexOfLastSlash != -1 || path.volumeLetter() == null) {
                if (access$getIndexOfLastSlash == -1) {
                    return new okio.Path(DOT);
                }
                if (access$getIndexOfLastSlash == 0) {
                    return new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, 1, 1, (Object) null));
                }
                return new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, access$getIndexOfLastSlash, 1, (Object) null));
            } else if (path.getBytes$okio().size() == 2) {
                return null;
            } else {
                return new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, 2, 1, (Object) null));
            }
        } else if (path.getBytes$okio().size() == 3) {
            return null;
        } else {
            return new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, 3, 1, (Object) null));
        }
    }

    public static final okio.Path commonRelativeTo(okio.Path path, okio.Path path2) {
        if (x.b(path.getRoot(), path2.getRoot())) {
            List<ByteString> segmentsBytes = path.getSegmentsBytes();
            List<ByteString> segmentsBytes2 = path2.getSegmentsBytes();
            int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
            int i11 = 0;
            while (i11 < min && x.b(segmentsBytes.get(i11), segmentsBytes2.get(i11))) {
                i11++;
            }
            boolean z11 = true;
            if (i11 == min && path.getBytes$okio().size() == path2.getBytes$okio().size()) {
                return Path.Companion.get$default(okio.Path.Companion, InstructionFileId.DOT, false, 1, (Object) null);
            }
            if (segmentsBytes2.subList(i11, segmentsBytes2.size()).indexOf(DOT_DOT) != -1) {
                z11 = false;
            }
            if (z11) {
                Buffer buffer = new Buffer();
                ByteString access$getSlash = getSlash(path2);
                if (access$getSlash == null && (access$getSlash = getSlash(path)) == null) {
                    access$getSlash = toSlash(okio.Path.DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                for (int i12 = i11; i12 < size; i12++) {
                    buffer.write(DOT_DOT);
                    buffer.write(access$getSlash);
                }
                int size2 = segmentsBytes.size();
                while (i11 < size2) {
                    buffer.write(segmentsBytes.get(i11));
                    buffer.write(access$getSlash);
                    i11++;
                }
                return toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + path + " and " + path2).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + path + " and " + path2).toString());
    }

    public static final okio.Path commonResolve(okio.Path path, String str, boolean z11) {
        return commonResolve(path, toPath(new Buffer().writeUtf8(str), false), z11);
    }

    public static final okio.Path commonRoot(okio.Path path) {
        int access$rootLength = rootLength(path);
        if (access$rootLength == -1) {
            return null;
        }
        return new okio.Path(path.getBytes$okio().substring(0, access$rootLength));
    }

    public static final List<String> commonSegments(okio.Path path) {
        ArrayList<ByteString> arrayList = new ArrayList<>();
        int access$rootLength = rootLength(path);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(access$rootLength) == 92) {
            access$rootLength++;
        }
        int size = path.getBytes$okio().size();
        int i11 = access$rootLength;
        while (access$rootLength < size) {
            if (path.getBytes$okio().getByte(access$rootLength) == 47 || path.getBytes$okio().getByte(access$rootLength) == 92) {
                arrayList.add(path.getBytes$okio().substring(i11, access$rootLength));
                i11 = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i11 < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(i11, path.getBytes$okio().size()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList, 10));
        for (ByteString utf8 : arrayList) {
            arrayList2.add(utf8.utf8());
        }
        return arrayList2;
    }

    public static final List<ByteString> commonSegmentsBytes(okio.Path path) {
        ArrayList arrayList = new ArrayList();
        int access$rootLength = rootLength(path);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(access$rootLength) == 92) {
            access$rootLength++;
        }
        int size = path.getBytes$okio().size();
        int i11 = access$rootLength;
        while (access$rootLength < size) {
            if (path.getBytes$okio().getByte(access$rootLength) == 47 || path.getBytes$okio().getByte(access$rootLength) == 92) {
                arrayList.add(path.getBytes$okio().substring(i11, access$rootLength));
                i11 = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i11 < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(i11, path.getBytes$okio().size()));
        }
        return arrayList;
    }

    public static final okio.Path commonToPath(String str, boolean z11) {
        return toPath(new Buffer().writeUtf8(str), z11);
    }

    public static final String commonToString(okio.Path path) {
        return path.getBytes$okio().utf8();
    }

    public static final Character commonVolumeLetter(okio.Path path) {
        boolean z11 = false;
        if (ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1 || path.getBytes$okio().size() < 2 || path.getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c11 = (char) path.getBytes$okio().getByte(0);
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

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    /* access modifiers changed from: private */
    public static final int getIndexOfLastSlash(okio.Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null);
        if (lastIndexOf$default != -1) {
            return lastIndexOf$default;
        }
        return ByteString.lastIndexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, (Object) null);
    }

    private static /* synthetic */ void getSLASH$annotations() {
    }

    /* access modifiers changed from: private */
    public static final ByteString getSlash(okio.Path path) {
        ByteString bytes$okio = path.getBytes$okio();
        ByteString byteString = SLASH;
        if (ByteString.indexOf$default(bytes$okio, byteString, 0, 2, (Object) null) != -1) {
            return byteString;
        }
        ByteString bytes$okio2 = path.getBytes$okio();
        ByteString byteString2 = BACKSLASH;
        if (ByteString.indexOf$default(bytes$okio2, byteString2, 0, 2, (Object) null) != -1) {
            return byteString2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final boolean lastSegmentIsDotDot(okio.Path path) {
        if (!path.getBytes$okio().endsWith(DOT_DOT) || (path.getBytes$okio().size() != 2 && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, SLASH, 0, 1) && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, BACKSLASH, 0, 1))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final int rootLength(okio.Path path) {
        if (path.getBytes$okio().size() == 0) {
            return -1;
        }
        boolean z11 = false;
        if (path.getBytes$okio().getByte(0) == 47) {
            return 1;
        }
        if (path.getBytes$okio().getByte(0) == 92) {
            if (path.getBytes$okio().size() <= 2 || path.getBytes$okio().getByte(1) != 92) {
                return 1;
            }
            int indexOf = path.getBytes$okio().indexOf(BACKSLASH, 2);
            return indexOf == -1 ? path.getBytes$okio().size() : indexOf;
        } else if (path.getBytes$okio().size() <= 2 || path.getBytes$okio().getByte(1) != 58 || path.getBytes$okio().getByte(2) != 92) {
            return -1;
        } else {
            char c11 = (char) path.getBytes$okio().getByte(0);
            if ('a' <= c11 && c11 < '{') {
                return 3;
            }
            if ('A' <= c11 && c11 < '[') {
                z11 = true;
            }
            if (!z11) {
                return -1;
            }
            return 3;
        }
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        if (!x.b(byteString, BACKSLASH) || buffer.size() < 2 || buffer.getByte(1) != 58) {
            return false;
        }
        char c11 = (char) buffer.getByte(0);
        if (!('a' <= c11 && c11 < '{')) {
            if (!('A' <= c11 && c11 < '[')) {
                return false;
            }
        }
        return true;
    }

    public static final okio.Path toPath(Buffer buffer, boolean z11) {
        ByteString byteString;
        ByteString byteString2;
        Buffer buffer2 = buffer;
        Buffer buffer3 = new Buffer();
        ByteString byteString3 = null;
        int i11 = 0;
        while (true) {
            if (!buffer2.rangeEquals(0, SLASH)) {
                byteString = BACKSLASH;
                if (!buffer2.rangeEquals(0, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString3 == null) {
                byteString3 = toSlash(readByte);
            }
            i11++;
        }
        boolean z12 = i11 >= 2 && x.b(byteString3, byteString);
        if (z12) {
            buffer3.write(byteString3);
            buffer3.write(byteString3);
        } else if (i11 > 0) {
            buffer3.write(byteString3);
        } else {
            long indexOfElement = buffer2.indexOfElement(ANY_SLASH);
            if (byteString3 == null) {
                if (indexOfElement == -1) {
                    byteString3 = toSlash(okio.Path.DIRECTORY_SEPARATOR);
                } else {
                    byteString3 = toSlash(buffer2.getByte(indexOfElement));
                }
            }
            if (startsWithVolumeLetterAndColon(buffer2, byteString3)) {
                if (indexOfElement == 2) {
                    buffer3.write(buffer2, 3);
                } else {
                    buffer3.write(buffer2, 2);
                }
            }
        }
        boolean z13 = buffer3.size() > 0;
        ArrayList arrayList = new ArrayList();
        while (!buffer.exhausted()) {
            long indexOfElement2 = buffer2.indexOfElement(ANY_SLASH);
            if (indexOfElement2 == -1) {
                byteString2 = buffer.readByteString();
            } else {
                byteString2 = buffer2.readByteString(indexOfElement2);
                buffer.readByte();
            }
            ByteString byteString4 = DOT_DOT;
            if (x.b(byteString2, byteString4)) {
                if (!z13 || !arrayList.isEmpty()) {
                    if (!z11 || (!z13 && (arrayList.isEmpty() || x.b(CollectionsKt___CollectionsKt.m0(arrayList), byteString4)))) {
                        arrayList.add(byteString2);
                    } else if (!z12 || arrayList.size() != 1) {
                        Object unused = CollectionsKt__MutableCollectionsKt.I(arrayList);
                    }
                }
            } else if (!x.b(byteString2, DOT) && !x.b(byteString2, ByteString.EMPTY)) {
                arrayList.add(byteString2);
            }
        }
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (i12 > 0) {
                buffer3.write(byteString3);
            }
            buffer3.write((ByteString) arrayList.get(i12));
        }
        if (buffer3.size() == 0) {
            buffer3.write(DOT);
        }
        return new okio.Path(buffer3.readByteString());
    }

    /* access modifiers changed from: private */
    public static final ByteString toSlash(String str) {
        if (x.b(str, "/")) {
            return SLASH;
        }
        if (x.b(str, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }

    public static final okio.Path commonResolve(okio.Path path, ByteString byteString, boolean z11) {
        return commonResolve(path, toPath(new Buffer().write(byteString), false), z11);
    }

    private static final ByteString toSlash(byte b11) {
        if (b11 == 47) {
            return SLASH;
        }
        if (b11 == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + b11);
    }

    public static final okio.Path commonResolve(okio.Path path, Buffer buffer, boolean z11) {
        return commonResolve(path, toPath(buffer, false), z11);
    }

    public static final okio.Path commonResolve(okio.Path path, okio.Path path2, boolean z11) {
        if (path2.isAbsolute() || path2.volumeLetter() != null) {
            return path2;
        }
        ByteString slash = getSlash(path);
        if (slash == null && (slash = getSlash(path2)) == null) {
            slash = toSlash(okio.Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes$okio());
        if (buffer.size() > 0) {
            buffer.write(slash);
        }
        buffer.write(path2.getBytes$okio());
        return toPath(buffer, z11);
    }
}
