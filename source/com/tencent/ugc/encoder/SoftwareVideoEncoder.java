package com.tencent.ugc.encoder;

import android.view.Surface;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.encoder.VideoEncoderInterface;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.egl.EGLCore;
import com.tencent.ugc.videobase.egl.EGLException;
import com.tencent.ugc.videobase.frame.FrameMetaData;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFrameRenderer;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import com.tencent.ugc.videobase.videobase.ConvertParams;
import com.tencent.ugc.videobase.videobase.FrameConverter;

public class SoftwareVideoEncoder implements VideoEncoderInterface, FrameConverter.FrameConvertListener {
    private EGLCore mEGLCore;
    private VideoEncodeParams mEncodeParams;
    private final SoftwareEncoderWrapper mEncodeWrapper = new SoftwareEncoderWrapper();
    private FrameConverter mFrameConverter;
    private GLTexturePool mGLTexturePool;
    private PixelFrameRenderer mPixelFrameRenderer;
    private final String mTAG = ("SoftwareVideoEncoder_" + hashCode());
    private final b mThrottlers = new b();

    private boolean initOpenGLComponents(Object obj) {
        if (this.mEncodeParams == null) {
            return false;
        }
        EGLCore eGLCore = new EGLCore();
        this.mEGLCore = eGLCore;
        try {
            eGLCore.initialize(obj, (Surface) null, 128, 128);
            this.mPixelFrameRenderer = new PixelFrameRenderer(this.mEncodeParams.getWidth(), this.mEncodeParams.getHeight());
            this.mGLTexturePool = new GLTexturePool();
            FrameConverter frameConverter = new FrameConverter();
            this.mFrameConverter = frameConverter;
            frameConverter.initialize(this.mGLTexturePool);
            this.mFrameConverter.addListener(new ConvertParams(this.mEncodeParams.getWidth(), this.mEncodeParams.getHeight()), GLConstants.PixelBufferType.BYTE_BUFFER, GLConstants.PixelFormatType.I420, 0, this);
            return true;
        } catch (EGLException e11) {
            this.mEGLCore = null;
            LiteavLog.e(this.mThrottlers.a("initGL"), this.mTAG, "initializeEGL failed.", (Throwable) e11);
            return false;
        }
    }

    private void uninitializeOpenGLComponents() {
        if (this.mEGLCore != null) {
            LiteavLog.i(this.mThrottlers.a("uninitGL"), this.mTAG, "uninitializeOpenGLComponents", new Object[0]);
            try {
                this.mEGLCore.makeCurrent();
                this.mFrameConverter.removeListener(0, this);
                this.mFrameConverter.uninitialize();
                PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRenderer;
                if (pixelFrameRenderer != null) {
                    pixelFrameRenderer.uninitialize();
                    this.mPixelFrameRenderer = null;
                }
                GLTexturePool gLTexturePool = this.mGLTexturePool;
                if (gLTexturePool != null) {
                    gLTexturePool.evictAll();
                    this.mGLTexturePool.destroy();
                    this.mGLTexturePool = null;
                }
            } catch (EGLException e11) {
                LiteavLog.e(this.mThrottlers.a("unintError"), this.mTAG, "makeCurrent failed.", (Throwable) e11);
            }
            EGLCore.destroy(this.mEGLCore);
            this.mEGLCore = null;
        }
    }

    public void encodeFrame(PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
            FrameMetaData metaData = pixelFrame.getMetaData();
            if (metaData != null) {
                pixelFrame2.postRotate(metaData.getEncodeRotation());
            }
            if (this.mEGLCore != null || initOpenGLComponents(pixelFrame2.getGLContext())) {
                try {
                    this.mEGLCore.makeCurrent();
                    GLTexture obtain = this.mGLTexturePool.obtain(this.mEncodeParams.getWidth(), this.mEncodeParams.getHeight());
                    obtain.setColorFormat(pixelFrame2.getColorRange(), pixelFrame2.getColorSpace());
                    obtain.setMetaData(metaData);
                    OpenGlUtils.glViewport(0, 0, obtain.getWidth(), obtain.getHeight());
                    this.mPixelFrameRenderer.renderFrame(pixelFrame2, GLConstants.GLScaleType.CENTER_CROP, obtain);
                    this.mFrameConverter.processFrame(pixelFrame2.getTimestamp(), obtain);
                    obtain.release();
                } catch (EGLException e11) {
                    LiteavLog.e(this.mThrottlers.a("makeCurrentError"), this.mTAG, "makeCurrent failed.", (Throwable) e11);
                }
            }
        }
    }

    public void initialize() {
        this.mEncodeWrapper.initialize();
    }

    public boolean isInputQueueFull() {
        return this.mEncodeWrapper.isInputQueueFull();
    }

    public void onFrameConverted(int i11, PixelFrame pixelFrame) {
        this.mEncodeWrapper.encodeFrame(pixelFrame);
    }

    public void signalEndOfStream() {
        this.mEncodeWrapper.signalEndOfStream();
    }

    public boolean start(VideoEncodeParams videoEncodeParams, VideoEncoderInterface.VideoEncoderListener videoEncoderListener) {
        LiteavLog.i(this.mTAG, "Start: ".concat(String.valueOf(videoEncodeParams)));
        this.mEncodeParams = new VideoEncodeParams(videoEncodeParams);
        this.mEncodeWrapper.start(videoEncodeParams, videoEncoderListener);
        return true;
    }

    public void stopSync(long j11) {
        this.mEncodeParams = null;
        this.mEncodeWrapper.stopSync(j11);
        uninitializeOpenGLComponents();
    }

    public void uninitialize() {
        this.mEncodeWrapper.uninitialize();
    }
}
