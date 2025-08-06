package com.tencent.ugc.videobase.frame;

import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.frame.FramePool;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class GLTexturePool extends FramePool<GLTexture> {
    /* access modifiers changed from: private */
    public static final AtomicInteger sTextureCount = new AtomicInteger();

    public static class PooledGLTexture extends GLTexture {
        private static final String TAG = "GLTexture";
        private GLConstants.ColorRange mColorRange;
        private GLConstants.ColorSpace mColorSpace;
        private final int mHeight;
        private FrameMetaData mMetaData;
        private int mTextureId;
        private final int mWidth;

        /* access modifiers changed from: private */
        public void initialize() {
            this.mTextureId = OpenGlUtils.createTexture(this.mWidth, this.mHeight, 6408, 6408);
            GLTexturePool.sTextureCount.incrementAndGet();
        }

        /* access modifiers changed from: private */
        public void uninitialize() {
            OpenGlUtils.deleteTexture(this.mTextureId);
            this.mTextureId = -1;
            GLTexturePool.sTextureCount.getAndDecrement();
        }

        public GLConstants.ColorRange getColorRange() {
            return this.mColorRange;
        }

        public GLConstants.ColorSpace getColorSpace() {
            return this.mColorSpace;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getId() {
            return this.mTextureId;
        }

        public FrameMetaData getMetaData() {
            return this.mMetaData;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public void release() {
            super.release();
        }

        public void reset() {
            this.mMetaData = null;
        }

        public void setColorFormat(GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
            this.mColorRange = colorRange;
            this.mColorSpace = colorSpace;
        }

        public void setMetaData(FrameMetaData frameMetaData) {
            this.mMetaData = frameMetaData;
        }

        public PixelFrame wrap(Object obj) {
            TextureFrame textureFrame = new TextureFrame(this, obj);
            textureFrame.setColorFormat(this.mColorRange, this.mColorSpace);
            textureFrame.retain();
            return textureFrame;
        }

        private PooledGLTexture(IRecycler<GLTexture> iRecycler, int i11, int i12) {
            super(iRecycler);
            this.mTextureId = -1;
            this.mWidth = i11;
            this.mHeight = i12;
        }
    }

    public static class TextureFrame extends PixelFrame {
        private static final IRecycler<TextureFrame> RECYCLER = b.a();
        private final GLTexture mTexture;

        public static void releaseTextureFrames(Collection<TextureFrame> collection) {
            if (collection != null) {
                for (TextureFrame next : collection) {
                    if (next != null) {
                        next.release();
                    }
                }
                collection.clear();
            }
        }

        public GLTexture getGLTexture() {
            return this.mTexture;
        }

        public void setTextureId(int i11) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }

        private TextureFrame(GLTexture gLTexture, Object obj) {
            super((IRecycler<? extends PixelFrame>) RECYCLER);
            gLTexture.retain();
            this.mWidth = gLTexture.getWidth();
            this.mHeight = gLTexture.getHeight();
            this.mTexture = gLTexture;
            this.mTextureId = gLTexture.getId();
            this.mGLContext = obj;
            this.mPixelBufferType = GLConstants.PixelBufferType.TEXTURE_2D;
            this.mPixelFormatType = GLConstants.PixelFormatType.RGBA;
            this.mMetaData = gLTexture.getMetaData();
            this.mColorRange = gLTexture.getColorRange();
            this.mColorSpace = gLTexture.getColorSpace();
        }
    }

    public static class a implements FramePool.Key {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f50849a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f50850b;

        public a(int i11, int i12) {
            this.f50849a = i11;
            this.f50850b = i12;
        }

        public final boolean equals(Object obj) {
            if (obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f50849a == aVar.f50849a && this.f50850b == aVar.f50850b) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.f50849a * 37213) + this.f50850b;
        }
    }

    public void destroy() {
        super.destroy();
    }

    public void evictAll() {
        super.evictAll();
    }

    public GLTexture obtain(int i11, int i12) {
        GLTexture gLTexture = (GLTexture) super.obtain(new a(i11, i12));
        gLTexture.reset();
        return gLTexture;
    }

    public GLTexture createInstance(IRecycler<GLTexture> iRecycler, FramePool.Key key) {
        a aVar = (a) key;
        PooledGLTexture pooledGLTexture = new PooledGLTexture(iRecycler, aVar.f50849a, aVar.f50850b);
        pooledGLTexture.initialize();
        return pooledGLTexture;
    }

    public void destroyInstance(GLTexture gLTexture) {
        ((PooledGLTexture) gLTexture).uninitialize();
    }

    public FramePool.Key keyForObject(GLTexture gLTexture) {
        return new a(gLTexture.getWidth(), gLTexture.getHeight());
    }
}
