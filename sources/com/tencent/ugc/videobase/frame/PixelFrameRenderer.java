package com.tencent.ugc.videobase.frame;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.filter.TXCGPUImageOESInputFilter;
import com.tencent.ugc.videobase.filter.TXCGPUImageRGBAInputFilter;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import com.tencent.ugc.videobase.yuv.TXCGPUImageI420InputFilter;
import com.tencent.ugc.videobase.yuv.TXCGPUImageNV12InputFilter;
import com.tencent.ugc.videobase.yuv.TXCGPUImageNV21InputFilter;
import com.tencent.ugc.videobase.yuv.TXCGPUImageYUVInputFilter;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class PixelFrameRenderer {
    private static final float[] OES_TEXTURE_COORDS_NO_ROTATION = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] OES_TEXTURE_COORDS_ROTATED_180 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private static final float[] OES_TEXTURE_COORDS_ROTATE_LEFT = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    private static final float[] OES_TEXTURE_COORDS_ROTATE_RIGHT = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static final String TAG = "PixelFrameRenderer";
    private final FloatBuffer mCubeVerticesBuffer;
    private GLFrameBuffer mFrameBufferForClear;
    private PixelFrame mFrameParams = null;
    private final FloatBuffer mInputTextureCoordsBuffer;
    private TXCGPUImageFilter mNormalFilter = null;
    private TXCGPUImageOESInputFilter mOesInputFilter = null;
    private int mOutFrameHeight;
    private int mOutFrameWidth;
    private final TXCGPUImageFilter[] mRawDataInputFilter = new TXCGPUImageFilter[GLConstants.PixelFormatType.values().length];
    private GLConstants.GLScaleType mScaleType;

    /* renamed from: com.tencent.ugc.videobase.frame.PixelFrameRenderer$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50856a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tencent.liteav.base.util.k[] r0 = com.tencent.liteav.base.util.k.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50856a = r0
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50856a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50856a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f50856a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.NORMAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videobase.frame.PixelFrameRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    public PixelFrameRenderer(int i11, int i12) {
        this.mOutFrameWidth = i11;
        this.mOutFrameHeight = i12;
        float[] fArr = GLConstants.CUBE_VERTICES_ARRAYS;
        this.mCubeVerticesBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        this.mInputTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
    }

    private float addDistance(float f11, float f12) {
        return f11 == 0.0f ? f12 : 1.0f - f12;
    }

    private void clearTexture(GLTexture gLTexture) {
        if (this.mFrameBufferForClear == null) {
            GLFrameBuffer gLFrameBuffer = new GLFrameBuffer();
            this.mFrameBufferForClear = gLFrameBuffer;
            gLFrameBuffer.initialize();
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        if (gLTexture == null) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClear(16640);
            return;
        }
        this.mFrameBufferForClear.attachTexture(gLTexture.getId());
        this.mFrameBufferForClear.bindToContext();
        GLES20.glClear(16640);
        this.mFrameBufferForClear.unbindFromContext();
        this.mFrameBufferForClear.detachTexture();
    }

    private void destroyGLComponents() {
        TXCGPUImageOESInputFilter tXCGPUImageOESInputFilter = this.mOesInputFilter;
        if (tXCGPUImageOESInputFilter != null) {
            tXCGPUImageOESInputFilter.uninitialize();
            this.mOesInputFilter = null;
        }
        TXCGPUImageFilter tXCGPUImageFilter = this.mNormalFilter;
        if (tXCGPUImageFilter != null) {
            tXCGPUImageFilter.uninitialize();
            this.mNormalFilter = null;
        }
        GLFrameBuffer gLFrameBuffer = this.mFrameBufferForClear;
        if (gLFrameBuffer != null) {
            gLFrameBuffer.uninitialize();
            this.mFrameBufferForClear = null;
        }
        int i11 = 0;
        while (true) {
            TXCGPUImageFilter[] tXCGPUImageFilterArr = this.mRawDataInputFilter;
            if (i11 < tXCGPUImageFilterArr.length) {
                if (tXCGPUImageFilterArr[i11] != null) {
                    tXCGPUImageFilterArr[i11].uninitialize();
                    this.mRawDataInputFilter[i11] = null;
                }
                i11++;
            } else {
                LiteavLog.i(TAG, "uninitialize GL components");
                return;
            }
        }
    }

    private static float flip(float f11) {
        return f11 == 0.0f ? 1.0f : 0.0f;
    }

    private void initNormalFilter() {
        if (this.mNormalFilter == null) {
            TXCGPUImageFilter tXCGPUImageFilter = new TXCGPUImageFilter();
            this.mNormalFilter = tXCGPUImageFilter;
            tXCGPUImageFilter.initialize((GLTexturePool) null);
        }
    }

    private static void initOESTextureCoordsBuffer(float[] fArr, k kVar, boolean z11, boolean z12) {
        float[] fArr2 = OES_TEXTURE_COORDS_NO_ROTATION;
        if (kVar != null) {
            int i11 = AnonymousClass1.f50856a[kVar.ordinal()];
            if (i11 == 1) {
                fArr2 = OES_TEXTURE_COORDS_ROTATE_RIGHT;
            } else if (i11 == 2) {
                fArr2 = OES_TEXTURE_COORDS_ROTATED_180;
            } else if (i11 == 3) {
                fArr2 = OES_TEXTURE_COORDS_ROTATE_LEFT;
            }
        }
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        if (z11) {
            fArr[0] = flip(fArr[0]);
            fArr[2] = flip(fArr[2]);
            fArr[4] = flip(fArr[4]);
            fArr[6] = flip(fArr[6]);
        }
        if (z12) {
            fArr[1] = flip(fArr[1]);
            fArr[3] = flip(fArr[3]);
            fArr[5] = flip(fArr[5]);
            fArr[7] = flip(fArr[7]);
        }
    }

    private boolean isIncompatible(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType) {
        return (gLScaleType == this.mScaleType && pixelFrame.getWidth() == this.mFrameParams.getWidth() && pixelFrame.getHeight() == this.mFrameParams.getHeight() && pixelFrame.getPixelBufferType() == this.mFrameParams.getPixelBufferType() && pixelFrame.getPixelFormatType() == this.mFrameParams.getPixelFormatType() && pixelFrame.isMirrorHorizontal() == this.mFrameParams.isMirrorHorizontal() && pixelFrame.isMirrorVertical() == this.mFrameParams.isMirrorVertical() && pixelFrame.getRotation() == this.mFrameParams.getRotation()) ? false : true;
    }

    private void recalcCubeAndTextureCoordinates() {
        PixelFrame pixelFrame = this.mFrameParams;
        if (pixelFrame != null) {
            boolean z11 = pixelFrame.getRotation() == k.ROTATION_90 || this.mFrameParams.getRotation() == k.ROTATION_270;
            float width = (float) this.mFrameParams.getWidth();
            float height = (float) this.mFrameParams.getHeight();
            float max = Math.max((((float) this.mOutFrameWidth) * 1.0f) / width, (((float) this.mOutFrameHeight) * 1.0f) / height);
            float round = (((float) Math.round(width * max)) * 1.0f) / ((float) this.mOutFrameWidth);
            float round2 = (((float) Math.round(height * max)) * 1.0f) / ((float) this.mOutFrameHeight);
            float[] fArr = GLConstants.CUBE_VERTICES_ARRAYS;
            float[] fArr2 = new float[8];
            if (this.mFrameParams.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
                initOESTextureCoordsBuffer(fArr2, this.mFrameParams.getRotation(), this.mFrameParams.isMirrorHorizontal(), this.mFrameParams.isMirrorVertical());
            } else {
                OpenGlUtils.initTextureCoordsBuffer(fArr2, this.mFrameParams.getRotation(), this.mFrameParams.isMirrorHorizontal(), this.mFrameParams.isMirrorVertical());
            }
            GLConstants.GLScaleType gLScaleType = this.mScaleType;
            if (gLScaleType == GLConstants.GLScaleType.CENTER_CROP) {
                float f11 = (1.0f - (z11 ? 1.0f / round2 : 1.0f / round)) / 2.0f;
                float f12 = (1.0f - (z11 ? 1.0f / round : 1.0f / round2)) / 2.0f;
                fArr2[0] = addDistance(fArr2[0], f11);
                fArr2[1] = addDistance(fArr2[1], f12);
                fArr2[2] = addDistance(fArr2[2], f11);
                fArr2[3] = addDistance(fArr2[3], f12);
                fArr2[4] = addDistance(fArr2[4], f11);
                fArr2[5] = addDistance(fArr2[5], f12);
                fArr2[6] = addDistance(fArr2[6], f11);
                fArr2[7] = addDistance(fArr2[7], f12);
            } else if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
                fArr = new float[]{fArr[0] / round2, fArr[1] / round, fArr[2] / round2, fArr[3] / round, fArr[4] / round2, fArr[5] / round, fArr[6] / round2, fArr[7] / round};
            }
            this.mCubeVerticesBuffer.clear();
            this.mCubeVerticesBuffer.put(fArr).position(0);
            this.mInputTextureCoordsBuffer.clear();
            this.mInputTextureCoordsBuffer.put(fArr2).position(0);
        }
    }

    private void renderRgbaData(GLTexture gLTexture, Buffer buffer) {
        int ordinal = GLConstants.PixelFormatType.RGBA.ordinal();
        TXCGPUImageFilter[] tXCGPUImageFilterArr = this.mRawDataInputFilter;
        if (tXCGPUImageFilterArr[ordinal] == null) {
            tXCGPUImageFilterArr[ordinal] = new TXCGPUImageRGBAInputFilter();
            this.mRawDataInputFilter[ordinal].initialize((GLTexturePool) null);
        }
        TXCGPUImageRGBAInputFilter tXCGPUImageRGBAInputFilter = (TXCGPUImageRGBAInputFilter) this.mRawDataInputFilter[ordinal];
        tXCGPUImageRGBAInputFilter.onOutputSizeChanged(this.mOutFrameWidth, this.mOutFrameHeight);
        OpenGlUtils.glViewport(0, 0, this.mOutFrameWidth, this.mOutFrameHeight);
        if (this.mFrameParams.getRotation() == k.ROTATION_90 || this.mFrameParams.getRotation() == k.ROTATION_270) {
            tXCGPUImageRGBAInputFilter.loadRgbaData(buffer, this.mFrameParams.getHeight(), this.mFrameParams.getWidth());
        } else {
            tXCGPUImageRGBAInputFilter.loadRgbaData(buffer, this.mFrameParams.getWidth(), this.mFrameParams.getHeight());
        }
        tXCGPUImageRGBAInputFilter.onDraw(-1, gLTexture, this.mCubeVerticesBuffer, this.mInputTextureCoordsBuffer);
    }

    private void renderTexture2DInput(GLTexture gLTexture, int i11) {
        initNormalFilter();
        OpenGlUtils.glViewport(0, 0, this.mOutFrameWidth, this.mOutFrameHeight);
        this.mNormalFilter.onOutputSizeChanged(this.mOutFrameWidth, this.mOutFrameHeight);
        this.mNormalFilter.onDraw(i11, gLTexture, this.mCubeVerticesBuffer, this.mInputTextureCoordsBuffer);
    }

    private void renderTextureOesInput(GLTexture gLTexture, int i11, float[] fArr) {
        if (this.mOesInputFilter == null) {
            TXCGPUImageOESInputFilter tXCGPUImageOESInputFilter = new TXCGPUImageOESInputFilter();
            this.mOesInputFilter = tXCGPUImageOESInputFilter;
            tXCGPUImageOESInputFilter.initialize((GLTexturePool) null);
        }
        OpenGlUtils.glViewport(0, 0, this.mOutFrameWidth, this.mOutFrameHeight);
        this.mOesInputFilter.setTextureTransform(fArr);
        this.mOesInputFilter.onOutputSizeChanged(this.mOutFrameWidth, this.mOutFrameHeight);
        this.mOesInputFilter.onDraw(i11, gLTexture, this.mCubeVerticesBuffer, this.mInputTextureCoordsBuffer);
    }

    private void renderYuvData(GLConstants.PixelFormatType pixelFormatType, GLTexture gLTexture, ByteBuffer byteBuffer, GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        int ordinal = pixelFormatType.ordinal();
        TXCGPUImageFilter[] tXCGPUImageFilterArr = this.mRawDataInputFilter;
        if (tXCGPUImageFilterArr[ordinal] == null) {
            if (pixelFormatType == GLConstants.PixelFormatType.I420) {
                tXCGPUImageFilterArr[ordinal] = new TXCGPUImageI420InputFilter();
            } else if (pixelFormatType == GLConstants.PixelFormatType.NV21) {
                tXCGPUImageFilterArr[ordinal] = new TXCGPUImageNV21InputFilter();
            } else {
                tXCGPUImageFilterArr[ordinal] = new TXCGPUImageNV12InputFilter();
            }
            this.mRawDataInputFilter[ordinal].setColorFormat(colorRange, colorSpace);
            this.mRawDataInputFilter[ordinal].initialize((GLTexturePool) null);
        }
        TXCGPUImageYUVInputFilter tXCGPUImageYUVInputFilter = (TXCGPUImageYUVInputFilter) this.mRawDataInputFilter[ordinal];
        tXCGPUImageYUVInputFilter.onOutputSizeChanged(this.mOutFrameWidth, this.mOutFrameHeight);
        OpenGlUtils.glViewport(0, 0, this.mOutFrameWidth, this.mOutFrameHeight);
        if (this.mFrameParams.getRotation() == k.ROTATION_90 || this.mFrameParams.getRotation() == k.ROTATION_270) {
            tXCGPUImageYUVInputFilter.loadYuvDataToTexture(byteBuffer, this.mFrameParams.getHeight(), this.mFrameParams.getWidth());
        } else {
            tXCGPUImageYUVInputFilter.loadYuvDataToTexture(byteBuffer, this.mFrameParams.getWidth(), this.mFrameParams.getHeight());
        }
        tXCGPUImageYUVInputFilter.onDraw(-1, gLTexture, this.mCubeVerticesBuffer, this.mInputTextureCoordsBuffer);
    }

    public Size getOutputSize() {
        return new Size(this.mOutFrameWidth, this.mOutFrameHeight);
    }

    public void renderFrame(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType, GLTexture gLTexture) {
        if (pixelFrame == null || !pixelFrame.isFrameDataValid()) {
            LiteavLog.w(TAG, "renderFrame: pixelFrame is not valid");
            return;
        }
        if (gLTexture != null) {
            gLTexture.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
        }
        if (this.mFrameParams == null || isIncompatible(pixelFrame, gLScaleType)) {
            this.mScaleType = gLScaleType;
            this.mFrameParams = new PixelFrame(pixelFrame);
            destroyGLComponents();
            recalcCubeAndTextureCoordinates();
        }
        if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
            clearTexture(gLTexture);
        }
        if (this.mFrameParams.getPixelBufferType() == GLConstants.PixelBufferType.BYTE_BUFFER) {
            if (this.mFrameParams.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                renderYuvData(this.mFrameParams.getPixelFormatType(), gLTexture, pixelFrame.getBuffer(), pixelFrame.getColorRange(), pixelFrame.getColorSpace());
                return;
            }
            renderRgbaData(gLTexture, pixelFrame.getBuffer());
        } else if (this.mFrameParams.getPixelBufferType() == GLConstants.PixelBufferType.BYTE_ARRAY) {
            if (this.mFrameParams.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                renderYuvData(this.mFrameParams.getPixelFormatType(), gLTexture, ByteBuffer.wrap(pixelFrame.getData()), pixelFrame.getColorRange(), pixelFrame.getColorSpace());
                return;
            }
            renderRgbaData(gLTexture, ByteBuffer.wrap(pixelFrame.getData()));
        } else if (this.mFrameParams.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
            renderTextureOesInput(gLTexture, pixelFrame.getTextureId(), pixelFrame.getMatrix());
        } else if (this.mFrameParams.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D) {
            renderTexture2DInput(gLTexture, pixelFrame.getTextureId());
        }
    }

    public void setOutputSize(int i11, int i12) {
        if (this.mOutFrameWidth != i11 || this.mOutFrameHeight != i12) {
            this.mOutFrameWidth = i11;
            this.mOutFrameHeight = i12;
            recalcCubeAndTextureCoordinates();
        }
    }

    public void uninitialize() {
        this.mFrameParams = null;
        destroyGLComponents();
    }
}
