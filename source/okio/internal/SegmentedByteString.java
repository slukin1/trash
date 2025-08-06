package okio.internal;

import d10.q;
import kotlin.Unit;
import okio.Buffer;
import okio.ByteString;
import okio.C0892SegmentedByteString;
import okio.Segment;

/* renamed from: okio.internal.-SegmentedByteString  reason: invalid class name */
public final class SegmentedByteString {
    public static final int binarySearch(int[] iArr, int i11, int i12, int i13) {
        int i14 = i13 - 1;
        while (i12 <= i14) {
            int i15 = (i12 + i14) >>> 1;
            int i16 = iArr[i15];
            if (i16 < i11) {
                i12 = i15 + 1;
            } else if (i16 <= i11) {
                return i15;
            } else {
                i14 = i15 - 1;
            }
        }
        return (-i12) - 1;
    }

    public static final void commonCopyInto(C0892SegmentedByteString segmentedByteString, int i11, byte[] bArr, int i12, int i13) {
        int i14;
        long j11 = (long) i13;
        okio.SegmentedByteString.checkOffsetAndCount((long) segmentedByteString.size(), (long) i11, j11);
        okio.SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i12, j11);
        int i15 = i13 + i11;
        int segment = segment(segmentedByteString, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i16 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i15, (segmentedByteString.getDirectory$okio()[segment] - i14) + i14) - i11;
            int i17 = i16 + (i11 - i14);
            byte[] unused = ArraysKt___ArraysJvmKt.e(segmentedByteString.getSegments$okio()[segment], bArr, i12, i17, i17 + min);
            i12 += min;
            i11 += min;
            segment++;
        }
    }

    public static final boolean commonEquals(C0892SegmentedByteString segmentedByteString, Object obj) {
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(C0892SegmentedByteString segmentedByteString) {
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(C0892SegmentedByteString segmentedByteString) {
        int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = segmentedByteString.getSegments$okio().length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            int i14 = segmentedByteString.getDirectory$okio()[length + i11];
            int i15 = segmentedByteString.getDirectory$okio()[i11];
            byte[] bArr = segmentedByteString.getSegments$okio()[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        segmentedByteString.setHashCode$okio(i12);
        return i12;
    }

    public static final byte commonInternalGet(C0892SegmentedByteString segmentedByteString, int i11) {
        int i12;
        okio.SegmentedByteString.checkOffsetAndCount((long) segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], (long) i11, 1);
        int segment = segment(segmentedByteString, i11);
        if (segment == 0) {
            i12 = 0;
        } else {
            i12 = segmentedByteString.getDirectory$okio()[segment - 1];
        }
        return segmentedByteString.getSegments$okio()[segment][(i11 - i12) + segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(C0892SegmentedByteString segmentedByteString, int i11, ByteString byteString, int i12, int i13) {
        int i14;
        if (i11 < 0 || i11 > segmentedByteString.size() - i13) {
            return false;
        }
        int i15 = i13 + i11;
        int segment = segment(segmentedByteString, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i16 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i15, (segmentedByteString.getDirectory$okio()[segment] - i14) + i14) - i11;
            if (!byteString.rangeEquals(i12, segmentedByteString.getSegments$okio()[segment], i16 + (i11 - i14), min)) {
                return false;
            }
            i12 += min;
            i11 += min;
            segment++;
        }
        return true;
    }

    public static final ByteString commonSubstring(C0892SegmentedByteString segmentedByteString, int i11, int i12) {
        int resolveDefaultParameter = okio.SegmentedByteString.resolveDefaultParameter((ByteString) segmentedByteString, i12);
        int i13 = 0;
        if (i11 >= 0) {
            if (resolveDefaultParameter <= segmentedByteString.size()) {
                int i14 = resolveDefaultParameter - i11;
                if (!(i14 >= 0)) {
                    throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i11).toString());
                } else if (i11 == 0 && resolveDefaultParameter == segmentedByteString.size()) {
                    return segmentedByteString;
                } else {
                    if (i11 == resolveDefaultParameter) {
                        return ByteString.EMPTY;
                    }
                    int segment = segment(segmentedByteString, i11);
                    int segment2 = segment(segmentedByteString, resolveDefaultParameter - 1);
                    byte[][] bArr = (byte[][]) ArraysKt___ArraysJvmKt.j(segmentedByteString.getSegments$okio(), segment, segment2 + 1);
                    int[] iArr = new int[(bArr.length * 2)];
                    if (segment <= segment2) {
                        int i15 = 0;
                        int i16 = segment;
                        while (true) {
                            iArr[i15] = Math.min(segmentedByteString.getDirectory$okio()[i16] - i11, i14);
                            int i17 = i15 + 1;
                            iArr[i15 + bArr.length] = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i16];
                            if (i16 == segment2) {
                                break;
                            }
                            i16++;
                            i15 = i17;
                        }
                    }
                    if (segment != 0) {
                        i13 = segmentedByteString.getDirectory$okio()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i11 - i13);
                    return new C0892SegmentedByteString(bArr, iArr);
                }
            } else {
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + segmentedByteString.size() + ')').toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex=" + i11 + " < 0").toString());
        }
    }

    public static final byte[] commonToByteArray(C0892SegmentedByteString segmentedByteString) {
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            int i14 = segmentedByteString.getDirectory$okio()[length + i11];
            int i15 = segmentedByteString.getDirectory$okio()[i11];
            int i16 = i15 - i12;
            byte[] unused = ArraysKt___ArraysJvmKt.e(segmentedByteString.getSegments$okio()[i11], bArr, i13, i14, i14 + i16);
            i13 += i16;
            i11++;
            i12 = i15;
        }
        return bArr;
    }

    public static final void commonWrite(C0892SegmentedByteString segmentedByteString, Buffer buffer, int i11, int i12) {
        int i13;
        int i14 = i11 + i12;
        int segment = segment(segmentedByteString, i11);
        while (i11 < i14) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i15 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i14, (segmentedByteString.getDirectory$okio()[segment] - i13) + i13) - i11;
            int i16 = i15 + (i11 - i13);
            Segment segment2 = new Segment(segmentedByteString.getSegments$okio()[segment], i16, i16 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                segment3.prev.push(segment2);
            }
            i11 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) i12));
    }

    public static final void forEachSegment(C0892SegmentedByteString segmentedByteString, q<? super byte[], ? super Integer, ? super Integer, Unit> qVar) {
        int length = segmentedByteString.getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = segmentedByteString.getDirectory$okio()[length + i11];
            int i14 = segmentedByteString.getDirectory$okio()[i11];
            qVar.invoke(segmentedByteString.getSegments$okio()[i11], Integer.valueOf(i13), Integer.valueOf(i14 - i12));
            i11++;
            i12 = i14;
        }
    }

    public static final int segment(C0892SegmentedByteString segmentedByteString, int i11) {
        int binarySearch = binarySearch(segmentedByteString.getDirectory$okio(), i11 + 1, 0, segmentedByteString.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    private static final void forEachSegment(C0892SegmentedByteString segmentedByteString, int i11, int i12, q<? super byte[], ? super Integer, ? super Integer, Unit> qVar) {
        int i13;
        int segment = segment(segmentedByteString, i11);
        while (i11 < i12) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i14 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i12, (segmentedByteString.getDirectory$okio()[segment] - i13) + i13) - i11;
            qVar.invoke(segmentedByteString.getSegments$okio()[segment], Integer.valueOf(i14 + (i11 - i13)), Integer.valueOf(min));
            i11 += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(C0892SegmentedByteString segmentedByteString, int i11, byte[] bArr, int i12, int i13) {
        int i14;
        if (i11 < 0 || i11 > segmentedByteString.size() - i13 || i12 < 0 || i12 > bArr.length - i13) {
            return false;
        }
        int i15 = i13 + i11;
        int segment = segment(segmentedByteString, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i16 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i15, (segmentedByteString.getDirectory$okio()[segment] - i14) + i14) - i11;
            if (!okio.SegmentedByteString.arrayRangeEquals(segmentedByteString.getSegments$okio()[segment], i16 + (i11 - i14), bArr, i12, min)) {
                return false;
            }
            i12 += min;
            i11 += min;
            segment++;
        }
        return true;
    }
}
