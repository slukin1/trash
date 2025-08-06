package com.tencent.liteav.videobase.frame;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import com.tencent.liteav.videobase.utils.e;
import java.nio.ByteBuffer;
import java.util.Collection;

@JNINamespace("liteav::video")
public class PixelFrame extends j {
    public ByteBuffer mBuffer;
    private GLConstants.ColorRange mColorRange;
    private GLConstants.ColorSpace mColorSpace;
    public ConsumerChainTimestamp mConsumerChainTimestamp;
    public byte[] mData;
    public Object mGLContext;
    public int mHeight;
    private boolean mIsMirrorHorizontal;
    private boolean mIsMirrorVertical;
    private float[] mMatrix;
    public FrameMetaData mMetaData;
    public GLConstants.a mPixelBufferType;
    public GLConstants.PixelFormatType mPixelFormatType;
    public ProducerChainTimestamp mProducerChainTimestamp;
    private k mRotation;
    public int mTextureId;
    private long mTimestamp;
    public int mWidth;

    public PixelFrame() {
        super((g) null);
        this.mTimestamp = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
    }

    public static PixelFrame createFromBitmap(Bitmap bitmap) {
        int width = (bitmap.getWidth() / 2) * 2;
        int height = (bitmap.getHeight() / 2) * 2;
        if (!(width == 0 || height == 0 || (bitmap.getWidth() % 2 == 0 && bitmap.getHeight() % 2 == 0))) {
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
        }
        ByteBuffer b11 = e.b(bitmap.getWidth() * 4 * bitmap.getHeight());
        if (b11 == null) {
            return null;
        }
        bitmap.copyPixelsToBuffer(b11);
        b11.position(0);
        PixelFrame pixelFrame = new PixelFrame();
        pixelFrame.setBuffer(b11);
        pixelFrame.setWidth(bitmap.getWidth());
        pixelFrame.setHeight(bitmap.getHeight());
        pixelFrame.setPixelBufferType(GLConstants.a.BYTE_BUFFER);
        pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
        return pixelFrame;
    }

    private int getColorRangeValue() {
        return this.mColorRange.getValue();
    }

    private int getColorSpaceValue() {
        return this.mColorSpace.getValue();
    }

    private int getPixelBufferTypeValue() {
        return this.mPixelBufferType.mValue;
    }

    private int getPixelFormatTypeValue() {
        return this.mPixelFormatType.getValue();
    }

    private int getRotationValue() {
        return this.mRotation.mValue;
    }

    public static void releasePixelFrames(Collection<PixelFrame> collection) {
        if (collection != null) {
            for (PixelFrame next : collection) {
                if (next != null) {
                    next.release();
                }
            }
            collection.clear();
        }
    }

    public void copy(PixelFrame pixelFrame) {
        this.mTimestamp = pixelFrame.mTimestamp;
        this.mWidth = pixelFrame.mWidth;
        this.mHeight = pixelFrame.mHeight;
        this.mPixelBufferType = pixelFrame.mPixelBufferType;
        this.mPixelFormatType = pixelFrame.mPixelFormatType;
        this.mRotation = pixelFrame.mRotation;
        this.mIsMirrorHorizontal = pixelFrame.mIsMirrorHorizontal;
        this.mIsMirrorVertical = pixelFrame.mIsMirrorVertical;
        if (pixelFrame.mMatrix != null) {
            this.mMatrix = new float[16];
            float[] matrix = pixelFrame.getMatrix();
            float[] fArr = this.mMatrix;
            System.arraycopy(matrix, 0, fArr, 0, fArr.length);
        }
        this.mMatrix = pixelFrame.mMatrix;
        this.mData = pixelFrame.mData;
        this.mBuffer = pixelFrame.mBuffer;
        this.mTextureId = pixelFrame.mTextureId;
        this.mGLContext = pixelFrame.mGLContext;
        this.mMetaData = pixelFrame.mMetaData;
        this.mConsumerChainTimestamp = pixelFrame.mConsumerChainTimestamp;
        this.mProducerChainTimestamp = pixelFrame.mProducerChainTimestamp;
        this.mColorSpace = pixelFrame.mColorSpace;
        this.mColorRange = pixelFrame.mColorRange;
    }

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public GLConstants.ColorRange getColorRange() {
        return this.mColorRange;
    }

    public GLConstants.ColorSpace getColorSpace() {
        return this.mColorSpace;
    }

    public ConsumerChainTimestamp getConsumerChainTimestamp() {
        if (this.mConsumerChainTimestamp == null) {
            this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
        }
        return this.mConsumerChainTimestamp;
    }

    public byte[] getData() {
        return this.mData;
    }

    public Object getGLContext() {
        return this.mGLContext;
    }

    public long getGLContextNativeHandle() {
        return OpenGlUtils.getGLContextNativeHandle(this.mGLContext);
    }

    public int getHeight() {
        return this.mHeight;
    }

    public float[] getMatrix() {
        return this.mMatrix;
    }

    public FrameMetaData getMetaData() {
        return this.mMetaData;
    }

    public GLConstants.a getPixelBufferType() {
        return this.mPixelBufferType;
    }

    public GLConstants.PixelFormatType getPixelFormatType() {
        return this.mPixelFormatType;
    }

    public ProducerChainTimestamp getProducerChainTimestamp() {
        if (this.mProducerChainTimestamp == null) {
            this.mProducerChainTimestamp = new ProducerChainTimestamp();
        }
        return this.mProducerChainTimestamp;
    }

    public k getRotation() {
        return this.mRotation;
    }

    public int getTextureId() {
        return this.mTextureId;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean hasTransformParams() {
        return this.mRotation != k.NORMAL || this.mIsMirrorHorizontal || this.mIsMirrorVertical || this.mMatrix != null;
    }

    public boolean isFrameDataValid() {
        GLConstants.a aVar = this.mPixelBufferType;
        if (aVar == GLConstants.a.TEXTURE_2D && this.mTextureId == -1) {
            return false;
        }
        if (aVar == GLConstants.a.BYTE_BUFFER && this.mBuffer == null) {
            return false;
        }
        return (aVar == GLConstants.a.BYTE_ARRAY && this.mData == null) ? false : true;
    }

    public boolean isMirrorHorizontal() {
        return this.mIsMirrorHorizontal;
    }

    public boolean isMirrorVertical() {
        return this.mIsMirrorVertical;
    }

    public void postRotate(k kVar) {
        if (kVar == k.ROTATION_90 || kVar == k.ROTATION_270) {
            swapWidthHeight();
        }
        setRotation(k.a((this.mRotation.mValue + kVar.mValue) % 360));
    }

    public void release() {
        super.release();
    }

    public void reset() {
        this.mTimestamp = 0;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mMetaData = null;
        this.mProducerChainTimestamp = null;
        this.mConsumerChainTimestamp = null;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
    }

    public int retain() {
        return super.retain();
    }

    public void setBuffer(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }

    public void setColorRange(GLConstants.ColorRange colorRange) {
        this.mColorRange = colorRange;
    }

    public void setColorSpace(GLConstants.ColorSpace colorSpace) {
        this.mColorSpace = colorSpace;
    }

    public void setConsumerChainTimestamp(ConsumerChainTimestamp consumerChainTimestamp) {
        this.mConsumerChainTimestamp = consumerChainTimestamp;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setGLContext(Object obj) {
        this.mGLContext = obj;
    }

    public void setHeight(int i11) {
        this.mHeight = i11;
    }

    public void setMatrix(float[] fArr) {
        this.mMatrix = fArr;
    }

    public void setMetaData(FrameMetaData frameMetaData) {
        this.mMetaData = frameMetaData;
    }

    public void setMirrorHorizontal(boolean z11) {
        this.mIsMirrorHorizontal = z11;
    }

    public void setMirrorVertical(boolean z11) {
        this.mIsMirrorVertical = z11;
    }

    public void setPixelBufferType(GLConstants.a aVar) {
        this.mPixelBufferType = aVar;
    }

    public void setPixelFormatType(GLConstants.PixelFormatType pixelFormatType) {
        this.mPixelFormatType = pixelFormatType;
    }

    public void setProducerChainTimestamp(ProducerChainTimestamp producerChainTimestamp) {
        this.mProducerChainTimestamp = producerChainTimestamp;
    }

    public void setRotation(k kVar) {
        this.mRotation = kVar;
    }

    public void setTextureId(int i11) {
        this.mTextureId = i11;
    }

    public void setTimestamp(long j11) {
        this.mTimestamp = j11;
    }

    public void setWidth(int i11) {
        this.mWidth = i11;
    }

    public void swapWidthHeight() {
        int i11 = this.mWidth;
        this.mWidth = this.mHeight;
        this.mHeight = i11;
    }

    public PixelFrame(PixelFrame pixelFrame) {
        super((g) null);
        this.mTimestamp = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
        copy(pixelFrame);
    }

    public PixelFrame(int i11, int i12, int i13, int i14, int i15) {
        this((g<PixelFrame>) null, i11, i12, i13, GLConstants.a.a(i14), GLConstants.PixelFormatType.a(i15));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PixelFrame(g<PixelFrame> gVar, int i11, int i12, GLConstants.a aVar, GLConstants.PixelFormatType pixelFormatType) {
        this(gVar, i11, i12, pixelFormatType == GLConstants.PixelFormatType.RGBA ? i11 * i12 * 4 : ((i11 * i12) * 3) / 2, aVar, pixelFormatType);
    }

    public PixelFrame(g<PixelFrame> gVar, int i11, int i12, int i13, GLConstants.a aVar, GLConstants.PixelFormatType pixelFormatType) {
        super(gVar);
        this.mTimestamp = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
        this.mWidth = i11;
        this.mHeight = i12;
        this.mPixelFormatType = pixelFormatType;
        this.mPixelBufferType = aVar;
        if (aVar == GLConstants.a.BYTE_ARRAY) {
            this.mData = e.a(i13);
        } else {
            this.mBuffer = e.b(i13);
        }
    }

    public PixelFrame(g<? extends PixelFrame> gVar) {
        super(gVar);
        this.mTimestamp = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
    }
}
