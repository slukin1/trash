package okio;

import java.util.Arrays;
import kotlin.jvm.internal.r;

public final class Segment {
    public static final Companion Companion = new Companion((r) null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        Segment segment = this.prev;
        int i11 = 0;
        if (!(segment != this)) {
            throw new IllegalStateException("cannot compact".toString());
        } else if (segment.owner) {
            int i12 = this.limit - this.pos;
            int i13 = 8192 - this.prev.limit;
            if (!this.prev.shared) {
                i11 = this.prev.pos;
            }
            if (i12 <= i13 + i11) {
                writeTo(this.prev, i12);
                pop();
                SegmentPool.recycle(this);
            }
        }
    }

    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        this.prev.next = this.next;
        this.next.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i11) {
        Segment segment;
        if (i11 > 0 && i11 <= this.limit - this.pos) {
            if (i11 >= 1024) {
                segment = sharedCopy();
            } else {
                segment = SegmentPool.take();
                byte[] bArr = this.data;
                byte[] bArr2 = segment.data;
                int i12 = this.pos;
                byte[] unused = ArraysKt___ArraysJvmKt.g(bArr, bArr2, 0, i12, i12 + i11, 2, (Object) null);
            }
            segment.limit = segment.pos + i11;
            this.pos += i11;
            this.prev.push(segment);
            return segment;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        return new Segment(Arrays.copyOf(bArr, bArr.length), this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment segment, int i11) {
        if (segment.owner) {
            int i12 = segment.limit;
            if (i12 + i11 > 8192) {
                if (!segment.shared) {
                    int i13 = segment.pos;
                    if ((i12 + i11) - i13 <= 8192) {
                        byte[] bArr = segment.data;
                        byte[] unused = ArraysKt___ArraysJvmKt.g(bArr, bArr, 0, i13, i12, 2, (Object) null);
                        segment.limit -= segment.pos;
                        segment.pos = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.data;
            byte[] bArr3 = segment.data;
            int i14 = segment.limit;
            int i15 = this.pos;
            byte[] unused2 = ArraysKt___ArraysJvmKt.e(bArr2, bArr3, i14, i15, i15 + i11);
            segment.limit += i11;
            this.pos += i11;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public Segment(byte[] bArr, int i11, int i12, boolean z11, boolean z12) {
        this.data = bArr;
        this.pos = i11;
        this.limit = i12;
        this.shared = z11;
        this.owner = z12;
    }
}
