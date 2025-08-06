package com.tencent.ugc.videobase.frame;

import com.tencent.ugc.videobase.base.GLConstants;

public class TextureHolderPool extends LimitedFramePool<TextureHolder> {

    public static class TextureHolder extends GLTexture {
        /* access modifiers changed from: private */
        public GLConstants.ColorRange mColorRange;
        /* access modifiers changed from: private */
        public GLConstants.ColorSpace mColorSpace;
        private int mHeight = 0;
        private FrameMetaData mMetaData;
        private int mTarget = 3553;
        private int mTextureId = -1;
        private int mWidth = 0;

        public TextureHolder(IRecycler<? extends GLTexture> iRecycler) {
            super(iRecycler);
        }

        /* access modifiers changed from: private */
        public int getTarget() {
            return this.mTarget;
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

        public void reset() {
            this.mTextureId = -1;
            this.mTarget = 3553;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mMetaData = null;
        }

        public void setColorFormat(GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
            this.mColorRange = colorRange;
            this.mColorSpace = colorSpace;
        }

        public void setMetaData(FrameMetaData frameMetaData) {
            this.mMetaData = frameMetaData;
        }

        public void updateTexture(int i11, int i12, int i13, int i14) {
            this.mTarget = i11;
            this.mTextureId = i12;
            this.mWidth = i13;
            this.mHeight = i14;
        }

        public PixelFrame wrap(Object obj) {
            a aVar = new a(this, obj, (byte) 0);
            aVar.setColorFormat(this.mColorRange, this.mColorSpace);
            aVar.retain();
            return aVar;
        }
    }

    public static class a extends PixelFrame {

        /* renamed from: b  reason: collision with root package name */
        private static final IRecycler<a> f50857b = c.a();

        /* renamed from: a  reason: collision with root package name */
        private final TextureHolder f50858a;

        public /* synthetic */ a(TextureHolder textureHolder, Object obj, byte b11) {
            this(textureHolder, obj);
        }

        public final void setTextureId(int i11) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }

        private a(TextureHolder textureHolder, Object obj) {
            super((IRecycler<? extends PixelFrame>) f50857b);
            textureHolder.retain();
            this.mWidth = textureHolder.getWidth();
            this.mHeight = textureHolder.getHeight();
            this.f50858a = textureHolder;
            this.mTextureId = textureHolder.getId();
            this.mColorRange = textureHolder.mColorRange;
            this.mColorSpace = textureHolder.mColorSpace;
            this.mGLContext = obj;
            if (textureHolder.getTarget() == 3553) {
                this.mPixelBufferType = GLConstants.PixelBufferType.TEXTURE_2D;
            } else if (textureHolder.getTarget() == 36197) {
                this.mPixelBufferType = GLConstants.PixelBufferType.TEXTURE_OES;
            }
            this.mPixelFormatType = GLConstants.PixelFormatType.RGBA;
        }
    }

    public TextureHolderPool(int i11) {
        super(i11);
    }

    public void destroyInstance(TextureHolder textureHolder) {
    }

    public TextureHolder createInstance(IRecycler<TextureHolder> iRecycler) {
        return new TextureHolder(iRecycler);
    }
}
