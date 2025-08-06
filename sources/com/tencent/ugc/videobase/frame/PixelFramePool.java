package com.tencent.ugc.videobase.frame;

import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.frame.FramePool;
import java.nio.ByteBuffer;

public class PixelFramePool extends FramePool<PixelFrame> {

    public static class a implements FramePool.Key {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f50852a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f50853b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final GLConstants.PixelBufferType f50854c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final GLConstants.PixelFormatType f50855d;

        public a(int i11, int i12, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
            this.f50852a = i11;
            this.f50853b = i12;
            this.f50854c = pixelBufferType;
            this.f50855d = pixelFormatType;
        }

        public final boolean equals(Object obj) {
            if (a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f50852a == aVar.f50852a && this.f50853b == aVar.f50853b && this.f50854c == aVar.f50854c && this.f50855d == aVar.f50855d) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.f50852a * 10001) + this.f50853b) << 2) + this.f50854c.ordinal()) << 2) + this.f50855d.ordinal();
        }
    }

    public static class b extends PixelFrame {
        public /* synthetic */ b(IRecycler iRecycler, int i11, int i12, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, byte b11) {
            this(iRecycler, i11, i12, pixelBufferType, pixelFormatType);
        }

        public final void setBuffer(ByteBuffer byteBuffer) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }

        public final void setData(byte[] bArr) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Data");
        }

        public final void setHeight(int i11) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its height");
        }

        public final void setPixelBufferType(GLConstants.PixelBufferType pixelBufferType) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its buffer type");
        }

        public final void setPixelFormatType(GLConstants.PixelFormatType pixelFormatType) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its format type");
        }

        public final void setWidth(int i11) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its width");
        }

        private b(IRecycler<PixelFrame> iRecycler, int i11, int i12, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
            super(iRecycler, i11, i12, pixelBufferType, pixelFormatType);
        }
    }

    public void destroyInstance(PixelFrame pixelFrame) {
    }

    public PixelFrame obtain(int i11, int i12, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
        PixelFrame pixelFrame = (PixelFrame) super.obtain(new a(i11, i12, pixelBufferType, pixelFormatType));
        pixelFrame.reset();
        return pixelFrame;
    }

    public PixelFrame createInstance(IRecycler<PixelFrame> iRecycler, FramePool.Key key) {
        a aVar = (a) key;
        return new b(iRecycler, aVar.f50852a, aVar.f50853b, aVar.f50854c, aVar.f50855d, (byte) 0);
    }

    public FramePool.Key keyForObject(PixelFrame pixelFrame) {
        return new a(pixelFrame.getWidth(), pixelFrame.getHeight(), pixelFrame.getPixelBufferType(), pixelFrame.getPixelFormatType());
    }
}
