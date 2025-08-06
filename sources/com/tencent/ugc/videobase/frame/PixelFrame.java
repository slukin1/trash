package com.tencent.ugc.videobase.frame;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.utils.MemoryAllocator;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.ByteBuffer;
import java.util.Collection;

@JNINamespace("liteav::ugc")
public class PixelFrame extends RefCounted {
    public ByteBuffer mBuffer;
    public GLConstants.ColorRange mColorRange;
    public GLConstants.ColorSpace mColorSpace;
    public byte[] mData;
    public Object mGLContext;
    public int mHeight;
    private boolean mIsMirrorHorizontal;
    private boolean mIsMirrorVertical;
    private float[] mMatrix;
    public FrameMetaData mMetaData;
    public GLConstants.PixelBufferType mPixelBufferType;
    public GLConstants.PixelFormatType mPixelFormatType;
    private k mRotation;
    public int mTextureId;
    private long mTimestamp;
    public int mWidth;

    public PixelFrame() {
        super((IRecycler) null);
        this.mTimestamp = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
    }

    public static PixelFrame createFromBitmap(Bitmap bitmap) {
        int width = (bitmap.getWidth() / 2) * 2;
        int height = (bitmap.getHeight() / 2) * 2;
        if (!(width == 0 || height == 0 || (bitmap.getWidth() % 2 == 0 && bitmap.getHeight() % 2 == 0))) {
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
        }
        ByteBuffer allocateDirectBuffer = MemoryAllocator.allocateDirectBuffer(bitmap.getWidth() * 4 * bitmap.getHeight());
        if (allocateDirectBuffer == null) {
            return null;
        }
        bitmap.copyPixelsToBuffer(allocateDirectBuffer);
        allocateDirectBuffer.position(0);
        PixelFrame pixelFrame = new PixelFrame();
        pixelFrame.setBuffer(allocateDirectBuffer);
        pixelFrame.setWidth(bitmap.getWidth());
        pixelFrame.setHeight(bitmap.getHeight());
        pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.BYTE_BUFFER);
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
        return this.mPixelBufferType.getValue();
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

    public GLConstants.PixelBufferType getPixelBufferType() {
        return this.mPixelBufferType;
    }

    public GLConstants.PixelFormatType getPixelFormatType() {
        return this.mPixelFormatType;
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
        GLConstants.PixelBufferType pixelBufferType = this.mPixelBufferType;
        if (pixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D && this.mTextureId == -1) {
            return false;
        }
        if (pixelBufferType == GLConstants.PixelBufferType.BYTE_BUFFER && this.mBuffer == null) {
            return false;
        }
        return (pixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY && this.mData == null) ? false : true;
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
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
    }

    public int retain() {
        return super.retain();
    }

    public void setBuffer(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }

    public void setColorFormat(GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        this.mColorRange = colorRange;
        this.mColorSpace = colorSpace;
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

    public void setPixelBufferType(GLConstants.PixelBufferType pixelBufferType) {
        this.mPixelBufferType = pixelBufferType;
    }

    public void setPixelFormatType(GLConstants.PixelFormatType pixelFormatType) {
        this.mPixelFormatType = pixelFormatType;
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
        super((IRecycler) null);
        this.mTimestamp = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        copy(pixelFrame);
    }

    public PixelFrame(int i11, int i12, int i13, int i14, int i15) {
        this((IRecycler<PixelFrame>) null, i11, i12, i13, GLConstants.PixelBufferType.fromInteger(i14), GLConstants.PixelFormatType.fromInteger(i15));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PixelFrame(IRecycler<PixelFrame> iRecycler, int i11, int i12, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
        this(iRecycler, i11, i12, pixelFormatType == GLConstants.PixelFormatType.RGBA ? i11 * i12 * 4 : ((i11 * i12) * 3) / 2, pixelBufferType, pixelFormatType);
    }

    public PixelFrame(IRecycler<PixelFrame> iRecycler, int i11, int i12, int i13, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
        super(iRecycler);
        this.mTimestamp = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mWidth = i11;
        this.mHeight = i12;
        this.mPixelFormatType = pixelFormatType;
        this.mPixelBufferType = pixelBufferType;
        if (pixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY) {
            this.mData = MemoryAllocator.allocateByteArray(i13);
        } else {
            this.mBuffer = MemoryAllocator.allocateDirectBuffer(i13);
        }
    }

    public PixelFrame(IRecycler<? extends PixelFrame> iRecycler) {
        super(iRecycler);
        this.mTimestamp = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
    }
}
