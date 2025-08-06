package com.jumio.commons.camera;

import com.fluttercandies.photo_manager.core.entity.a;
import gw.e;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class Frame implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f38962a;

    /* renamed from: b  reason: collision with root package name */
    public MetaData f38963b;

    public Frame(byte[] bArr, MetaData metaData) {
        this.f38962a = bArr;
        this.f38963b = metaData;
    }

    public static /* synthetic */ Frame copy$default(Frame frame, byte[] bArr, MetaData metaData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bArr = frame.f38962a;
        }
        if ((i11 & 2) != 0) {
            metaData = frame.f38963b;
        }
        return frame.copy(bArr, metaData);
    }

    public final byte[] component1() {
        return this.f38962a;
    }

    public final MetaData component2() {
        return this.f38963b;
    }

    public final Frame copy(byte[] bArr, MetaData metaData) {
        return new Frame(bArr, metaData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!x.b(Frame.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Frame frame = (Frame) obj;
        return Arrays.equals(this.f38962a, frame.f38962a) && x.b(this.f38963b, frame.f38963b);
    }

    public final byte[] getByteArray() {
        return this.f38962a;
    }

    public final MetaData getMetaData() {
        return this.f38963b;
    }

    public int hashCode() {
        return this.f38963b.hashCode() + (Arrays.hashCode(this.f38962a) * 31);
    }

    public final void setByteArray(byte[] bArr) {
        this.f38962a = bArr;
    }

    public final void setMetaData(MetaData metaData) {
        this.f38963b = metaData;
    }

    public String toString() {
        String arrays = Arrays.toString(this.f38962a);
        MetaData metaData = this.f38963b;
        return "Frame(byteArray=" + arrays + ", metaData=" + metaData + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Frame(byte[] bArr, MetaData metaData, int i11, r rVar) {
        this((i11 & 1) != 0 ? new byte[0] : bArr, metaData);
    }

    public Frame clone() {
        return (Frame) super.clone();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Frame(byte[] r13, com.jumio.commons.camera.Size r14, int r15, int r16, long r17, int r19, boolean r20, int r21, long r22, int r24, kotlin.jvm.internal.r r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000a
            byte[] r1 = new byte[r2]
            goto L_0x000b
        L_0x000a:
            r1 = r13
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0015
            com.jumio.commons.camera.Size r3 = new com.jumio.commons.camera.Size
            r3.<init>(r2, r2)
            goto L_0x0016
        L_0x0015:
            r3 = r14
        L_0x0016:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001c
            r4 = r2
            goto L_0x001d
        L_0x001c:
            r4 = r15
        L_0x001d:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0023
            r5 = r2
            goto L_0x0025
        L_0x0023:
            r5 = r16
        L_0x0025:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002c
            r6 = 0
            goto L_0x002e
        L_0x002c:
            r6 = r17
        L_0x002e:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r19
        L_0x0036:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r2 = r20
        L_0x003d:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0044
            r9 = 17
            goto L_0x0046
        L_0x0044:
            r9 = r21
        L_0x0046:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x004f
            long r10 = java.lang.System.currentTimeMillis()
            goto L_0x0051
        L_0x004f:
            r10 = r22
        L_0x0051:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r20 = r8
            r21 = r2
            r22 = r9
            r23 = r10
            r13.<init>(r14, r15, r16, r17, r18, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.Frame.<init>(byte[], com.jumio.commons.camera.Size, int, int, long, int, boolean, int, long, int, kotlin.jvm.internal.r):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Frame(byte[] bArr, Size size, int i11, int i12, long j11, int i13, boolean z11, int i14, long j12) {
        this(bArr, new MetaData(size, i11, i12, j11, i13, z11, i14, j12));
        byte[] bArr2 = bArr;
    }

    public static final class MetaData implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public Size f38964a;

        /* renamed from: b  reason: collision with root package name */
        public int f38965b;

        /* renamed from: c  reason: collision with root package name */
        public int f38966c;

        /* renamed from: d  reason: collision with root package name */
        public long f38967d;

        /* renamed from: e  reason: collision with root package name */
        public int f38968e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38969f;

        /* renamed from: g  reason: collision with root package name */
        public int f38970g;

        /* renamed from: h  reason: collision with root package name */
        public long f38971h;

        public MetaData() {
            this((Size) null, 0, 0, 0, 0, false, 0, 0, 255, (r) null);
        }

        public MetaData(Size size, int i11, int i12, long j11, int i13, boolean z11, int i14, long j12) {
            this.f38964a = size;
            this.f38965b = i11;
            this.f38966c = i12;
            this.f38967d = j11;
            this.f38968e = i13;
            this.f38969f = z11;
            this.f38970g = i14;
            this.f38971h = j12;
        }

        public static /* synthetic */ MetaData copy$default(MetaData metaData, Size size, int i11, int i12, long j11, int i13, boolean z11, int i14, long j12, int i15, Object obj) {
            MetaData metaData2 = metaData;
            int i16 = i15;
            return metaData.copy((i16 & 1) != 0 ? metaData2.f38964a : size, (i16 & 2) != 0 ? metaData2.f38965b : i11, (i16 & 4) != 0 ? metaData2.f38966c : i12, (i16 & 8) != 0 ? metaData2.f38967d : j11, (i16 & 16) != 0 ? metaData2.f38968e : i13, (i16 & 32) != 0 ? metaData2.f38969f : z11, (i16 & 64) != 0 ? metaData2.f38970g : i14, (i16 & 128) != 0 ? metaData2.f38971h : j12);
        }

        public final Size component1() {
            return this.f38964a;
        }

        public final int component2() {
            return this.f38965b;
        }

        public final int component3() {
            return this.f38966c;
        }

        public final long component4() {
            return this.f38967d;
        }

        public final int component5() {
            return this.f38968e;
        }

        public final boolean component6() {
            return this.f38969f;
        }

        public final int component7() {
            return this.f38970g;
        }

        public final long component8() {
            return this.f38971h;
        }

        public final MetaData copy(Size size, int i11, int i12, long j11, int i13, boolean z11, int i14, long j12) {
            return new MetaData(size, i11, i12, j11, i13, z11, i14, j12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!x.b(MetaData.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            MetaData metaData = (MetaData) obj;
            return x.b(this.f38964a, metaData.f38964a) && this.f38965b == metaData.f38965b && this.f38966c == metaData.f38966c && this.f38967d == metaData.f38967d && this.f38968e == metaData.f38968e && this.f38969f == metaData.f38969f && this.f38970g == metaData.f38970g && this.f38971h == metaData.f38971h;
        }

        public final int getImageFormat() {
            return this.f38970g;
        }

        public final int getIso() {
            return this.f38966c;
        }

        public final int getOrientation() {
            return this.f38968e;
        }

        public final int getRotation() {
            return this.f38965b;
        }

        public final long getShutterSpeed() {
            return this.f38967d;
        }

        public final Size getSize() {
            return this.f38964a;
        }

        public final long getTimeStamp() {
            return this.f38971h;
        }

        public int hashCode() {
            int a11 = a.a(this.f38967d);
            int a12 = e.a(this.f38969f);
            return a.a(this.f38971h) + ((((a12 + ((((a11 + (((((this.f38964a.hashCode() * 31) + this.f38965b) * 31) + this.f38966c) * 31)) * 31) + this.f38968e) * 31)) * 31) + this.f38970g) * 31);
        }

        public final boolean isPortrait() {
            return this.f38969f;
        }

        public final void setImageFormat(int i11) {
            this.f38970g = i11;
        }

        public final void setIso(int i11) {
            this.f38966c = i11;
        }

        public final void setOrientation(int i11) {
            this.f38968e = i11;
        }

        public final void setPortrait(boolean z11) {
            this.f38969f = z11;
        }

        public final void setRotation(int i11) {
            this.f38965b = i11;
        }

        public final void setShutterSpeed(long j11) {
            this.f38967d = j11;
        }

        public final void setSize(Size size) {
            this.f38964a = size;
        }

        public final void setTimeStamp(long j11) {
            this.f38971h = j11;
        }

        public String toString() {
            int i11 = this.f38965b;
            int i12 = this.f38966c;
            long j11 = this.f38967d;
            int i13 = this.f38968e;
            boolean z11 = this.f38969f;
            int i14 = this.f38970g;
            long j12 = this.f38971h;
            return "MetaData(rotation=" + i11 + ", iso=" + i12 + ", shutterSpeed=" + j11 + ", orientation=" + i13 + ", isPortrait=" + z11 + ", imageFormat=" + i14 + ")timeStamp=" + j12 + ")";
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ MetaData(com.jumio.commons.camera.Size r12, int r13, int r14, long r15, int r17, boolean r18, int r19, long r20, int r22, kotlin.jvm.internal.r r23) {
            /*
                r11 = this;
                r0 = r22
                r1 = r0 & 1
                r2 = 0
                if (r1 == 0) goto L_0x000d
                com.jumio.commons.camera.Size r1 = new com.jumio.commons.camera.Size
                r1.<init>(r2, r2)
                goto L_0x000e
            L_0x000d:
                r1 = r12
            L_0x000e:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0014
                r3 = r2
                goto L_0x0015
            L_0x0014:
                r3 = r13
            L_0x0015:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x001b
                r4 = r2
                goto L_0x001c
            L_0x001b:
                r4 = r14
            L_0x001c:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x0023
                r5 = 0
                goto L_0x0024
            L_0x0023:
                r5 = r15
            L_0x0024:
                r7 = r0 & 16
                if (r7 == 0) goto L_0x002a
                r7 = r2
                goto L_0x002c
            L_0x002a:
                r7 = r17
            L_0x002c:
                r8 = r0 & 32
                if (r8 == 0) goto L_0x0031
                goto L_0x0033
            L_0x0031:
                r2 = r18
            L_0x0033:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x003a
                r8 = 17
                goto L_0x003c
            L_0x003a:
                r8 = r19
            L_0x003c:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x0045
                long r9 = java.lang.System.currentTimeMillis()
                goto L_0x0047
            L_0x0045:
                r9 = r20
            L_0x0047:
                r12 = r11
                r13 = r1
                r14 = r3
                r15 = r4
                r16 = r5
                r18 = r7
                r19 = r2
                r20 = r8
                r21 = r9
                r12.<init>(r13, r14, r15, r16, r18, r19, r20, r21)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.Frame.MetaData.<init>(com.jumio.commons.camera.Size, int, int, long, int, boolean, int, long, int, kotlin.jvm.internal.r):void");
        }
    }
}
