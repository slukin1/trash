package com.tencent.ugc.decoder;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.view.Surface;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.decoder.MediaCodecDecoder;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.egl.EGLCore;
import com.tencent.ugc.videobase.egl.EGLException;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFrameRenderer;
import com.tencent.ugc.videobase.frame.TextureHolderPool;
import com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.util.concurrent.TimeUnit;

public class MediaCodecOutputOESTextureDecoder extends MediaCodecDecoder implements SurfaceTexture.OnFrameAvailableListener {
    private EGLCore mEGLCore;
    private GLTexturePool mGLTexturePool;
    private int mOESTextureId = -1;
    private Surface mOutputSurface;
    private PixelFrameRenderer mPixelFrameRenderer;
    private SurfaceTexture mSurfaceTexture;
    private TextureHolderPool mTextureHolderPool;

    public MediaCodecOutputOESTextureDecoder(HardwareDecoderMediaFormatBuilder hardwareDecoderMediaFormatBuilder, Size size, boolean z11, MediaCodecDecoder.MediaCodecDecoderListener mediaCodecDecoderListener, CustomHandler customHandler) {
        super(hardwareDecoderMediaFormatBuilder, size, z11, mediaCodecDecoderListener, customHandler);
        this.mTAG = "MediaCodecOutputOESTextureDecoder";
    }

    private PixelFrame convertOESFrameToTexture2DFrame(PixelFrame pixelFrame) {
        int width = pixelFrame.getWidth();
        int height = pixelFrame.getHeight();
        PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRenderer;
        if (pixelFrameRenderer != null) {
            Size outputSize = pixelFrameRenderer.getOutputSize();
            if (!(outputSize.width == width && outputSize.height == height)) {
                this.mPixelFrameRenderer.uninitialize();
                this.mPixelFrameRenderer = null;
            }
        }
        if (this.mPixelFrameRenderer == null) {
            this.mPixelFrameRenderer = new PixelFrameRenderer(width, height);
        }
        if (this.mGLTexturePool == null) {
            this.mGLTexturePool = new GLTexturePool();
        }
        OpenGlUtils.glViewport(0, 0, width, height);
        GLTexture obtain = this.mGLTexturePool.obtain(width, height);
        obtain.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
        this.mPixelFrameRenderer.renderFrame(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, obtain);
        PixelFrame wrap = obtain.wrap(this.mEGLCore.getEglContext());
        GLES20.glFinish();
        obtain.release();
        pixelFrame.release();
        return wrap;
    }

    private boolean initializeGLComponents(Object obj) {
        if (this.mEGLCore != null) {
            LiteavLog.w(this.mTAG, "Decoder already started.");
            return true;
        }
        EGLCore eGLCore = new EGLCore();
        this.mEGLCore = eGLCore;
        try {
            eGLCore.initialize(obj, (Surface) null, 128, 128);
            this.mEGLCore.makeCurrent();
            this.mOESTextureId = OpenGlUtils.generateTextureOES();
            this.mTextureHolderPool = new TextureHolderPool(1);
            try {
                this.mSurfaceTexture = new SurfaceTexture(this.mOESTextureId);
                this.mOutputSurface = new Surface(this.mSurfaceTexture);
                this.mSurfaceTexture.setOnFrameAvailableListener(this);
                LiteavLog.i(this.mThrottlers.a("initGL"), this.mTAG, "initialize gl components", new Object[0]);
                return true;
            } catch (Surface.OutOfResourcesException e11) {
                LiteavLog.e(this.mThrottlers.a("surface"), this.mTAG, "create SurfaceTexture failed.", (Throwable) e11);
                MediaCodecDecoder.MediaCodecDecoderListener mediaCodecDecoderListener = this.mListener;
                if (mediaCodecDecoderListener != null) {
                    mediaCodecDecoderListener.onDecoderError();
                }
                return false;
            }
        } catch (EGLException e12) {
            LiteavLog.e(this.mThrottlers.a("initGL"), this.mTAG, "create EGLCore failed.", (Throwable) e12);
            MediaCodecDecoder.MediaCodecDecoderListener mediaCodecDecoderListener2 = this.mListener;
            if (mediaCodecDecoderListener2 != null) {
                mediaCodecDecoderListener2.onDecoderError();
            }
            return false;
        }
    }

    public static /* synthetic */ void lambda$onFrameAvailable$0(MediaCodecOutputOESTextureDecoder mediaCodecOutputOESTextureDecoder, SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = mediaCodecOutputOESTextureDecoder.mSurfaceTexture;
        if (surfaceTexture2 != null && surfaceTexture == surfaceTexture2) {
            mediaCodecOutputOESTextureDecoder.makeCurrent();
            TextureHolderPool.TextureHolder textureHolder = null;
            try {
                textureHolder = (TextureHolderPool.TextureHolder) mediaCodecOutputOESTextureDecoder.mTextureHolderPool.obtain();
            } catch (InterruptedException unused) {
                LiteavLog.w(mediaCodecOutputOESTextureDecoder.mTAG, "textureholderpool obtain interrupted.");
            }
            int i11 = mediaCodecOutputOESTextureDecoder.mOESTextureId;
            Size size = mediaCodecOutputOESTextureDecoder.mResolution;
            textureHolder.updateTexture(36197, i11, size.width, size.height);
            textureHolder.setColorFormat(GLConstants.ColorRange.VIDEO_RANGE, GLConstants.ColorSpace.BT601);
            PixelFrame wrap = textureHolder.wrap(mediaCodecOutputOESTextureDecoder.mEGLCore.getEglContext());
            if (wrap.getMatrix() == null) {
                wrap.setMatrix(new float[16]);
            }
            try {
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(wrap.getMatrix());
            } catch (Throwable th2) {
                LiteavLog.w(mediaCodecOutputOESTextureDecoder.mThrottlers.a("updateImage"), mediaCodecOutputOESTextureDecoder.mTAG, "updateTexImage exception: ".concat(String.valueOf(th2)), new Object[0]);
            }
            long millis = TimeUnit.NANOSECONDS.toMillis(surfaceTexture.getTimestamp());
            if (millis == 0) {
                millis = TimeUnit.MICROSECONDS.toMillis(mediaCodecOutputOESTextureDecoder.mBufferInfo.presentationTimeUs);
            }
            PixelFrame convertOESFrameToTexture2DFrame = mediaCodecOutputOESTextureDecoder.convertOESFrameToTexture2DFrame(wrap);
            convertOESFrameToTexture2DFrame.setTimestamp(millis);
            mediaCodecOutputOESTextureDecoder.mListener.onDecodeFrame(convertOESFrameToTexture2DFrame, false);
            textureHolder.release();
            convertOESFrameToTexture2DFrame.release();
        }
    }

    private boolean makeCurrent() {
        try {
            EGLCore eGLCore = this.mEGLCore;
            if (eGLCore == null) {
                return true;
            }
            eGLCore.makeCurrent();
            return true;
        } catch (EGLException e11) {
            LiteavLog.e(this.mThrottlers.a("makeCurrent"), this.mTAG, "makeCurrent failed.", (Throwable) e11);
            return false;
        }
    }

    private void uninitializeGLComponents() {
        LiteavLog.i(this.mTAG, "uninitialize gl components");
        if (makeCurrent()) {
            TextureHolderPool textureHolderPool = this.mTextureHolderPool;
            if (textureHolderPool != null) {
                textureHolderPool.destroy();
            }
            Surface surface = this.mOutputSurface;
            if (surface != null) {
                surface.release();
                this.mOutputSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
            GLTexturePool gLTexturePool = this.mGLTexturePool;
            if (gLTexturePool != null) {
                gLTexturePool.destroy();
                this.mGLTexturePool = null;
            }
            PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRenderer;
            if (pixelFrameRenderer != null) {
                pixelFrameRenderer.uninitialize();
                this.mPixelFrameRenderer = null;
            }
            OpenGlUtils.deleteTexture(this.mOESTextureId);
            this.mOESTextureId = -1;
            EGLCore.destroy(this.mEGLCore);
            this.mEGLCore = null;
        }
    }

    public boolean configureMediaCodec(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        MediaCodecWrapper.configure(mediaCodec, mediaFormat, this.mOutputSurface, (MediaCrypto) null, 0);
        String str = this.mTAG;
        LiteavLog.i(str, "configure mediacodec with " + this.mOutputSurface);
        return true;
    }

    public boolean handleOutputBuffer(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, int i11) {
        mediaCodec.releaseOutputBuffer(i11, true);
        if ((bufferInfo.flags & 4) == 0) {
            return true;
        }
        LiteavLog.i(this.mTAG, "meet end of stream.");
        MediaCodecDecoder.MediaCodecDecoderListener mediaCodecDecoderListener = this.mListener;
        if (mediaCodecDecoderListener == null) {
            return false;
        }
        mediaCodecDecoderListener.onDecodeFrame((PixelFrame) null, true);
        return false;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        runOnWorkThread(j.a(this, surfaceTexture));
    }

    public boolean start(Object obj) {
        return initializeGLComponents(obj);
    }

    public void stop() {
        super.stop();
        uninitializeGLComponents();
    }

    public void updateOutputSurface(MediaCodec mediaCodec) {
        if (Build.VERSION.SDK_INT >= 23) {
            mediaCodec.setOutputSurface(this.mOutputSurface);
        }
    }
}
