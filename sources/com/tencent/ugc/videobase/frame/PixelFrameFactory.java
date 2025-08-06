package com.tencent.ugc.videobase.frame;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.egl.EGLCore;
import com.tencent.ugc.videobase.egl.EGLException;
import com.tencent.ugc.videobase.utils.MemoryAllocator;
import java.nio.ByteBuffer;

@JNINamespace("liteav::ugc")
public class PixelFrameFactory {
    private EGLContext mCallerEGLContext = EGL14.EGL_NO_CONTEXT;
    private EGLDisplay mCallerEGLDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLSurface mCallerEGLDrawSurface;
    private EGLSurface mCallerEGLReadSurface;
    private GLTexturePool mGLTexturePool;
    private final Size mLastFrameSize;
    private PixelFrameRenderer mPixelFrameRenderer;
    private EGLCore mRenderEGLCore;
    private Object mSharedEGLContext = null;
    private final String mTAG = ("PixelFrameFactory_" + hashCode());
    private final b mThrottlers;

    public PixelFrameFactory() {
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        this.mCallerEGLReadSurface = eGLSurface;
        this.mCallerEGLDrawSurface = eGLSurface;
        this.mLastFrameSize = new Size();
        this.mThrottlers = new b();
    }

    private PixelFrame copyTexture(PixelFrame pixelFrame) {
        if (this.mGLTexturePool == null) {
            this.mGLTexturePool = new GLTexturePool();
        }
        GLTexture obtain = this.mGLTexturePool.obtain(pixelFrame.getWidth(), pixelFrame.getHeight());
        obtain.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
        if (!(this.mLastFrameSize.width == pixelFrame.getWidth() && this.mLastFrameSize.height == pixelFrame.getHeight())) {
            PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRenderer;
            if (pixelFrameRenderer != null) {
                pixelFrameRenderer.uninitialize();
                this.mPixelFrameRenderer = null;
            }
            this.mLastFrameSize.width = pixelFrame.getWidth();
            this.mLastFrameSize.height = pixelFrame.getHeight();
        }
        if (this.mPixelFrameRenderer == null) {
            this.mPixelFrameRenderer = new PixelFrameRenderer(pixelFrame.getWidth(), pixelFrame.getHeight());
        }
        this.mPixelFrameRenderer.renderFrame(pixelFrame, GLConstants.GLScaleType.FILL, obtain);
        PixelFrame wrap = obtain.wrap(pixelFrame.getGLContext());
        obtain.release();
        return wrap;
    }

    private PixelFrame deepCopyDataToPixelFrame(PixelFrame pixelFrame, Object obj) {
        if (obj instanceof byte[]) {
            byte[] allocateByteArray = MemoryAllocator.allocateByteArray(((byte[]) obj).length);
            if (allocateByteArray == null) {
                return null;
            }
            System.arraycopy(obj, 0, allocateByteArray, 0, allocateByteArray.length);
            pixelFrame.setData(allocateByteArray);
        } else if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            ByteBuffer allocateDirectBuffer = MemoryAllocator.allocateDirectBuffer(byteBuffer.capacity());
            if (allocateDirectBuffer == null) {
                return null;
            }
            byteBuffer.rewind();
            allocateDirectBuffer.put(byteBuffer);
            allocateDirectBuffer.rewind();
            pixelFrame.setBuffer(allocateDirectBuffer);
        }
        pixelFrame.retain();
        return pixelFrame;
    }

    private PixelFrame deepCopyTextureToPixelFrame(PixelFrame pixelFrame, Object obj) {
        saveCallerEGLContext();
        GLES20.glFinish();
        if (!CommonUtil.equals(this.mSharedEGLContext, obj)) {
            uninitOpenGLComponents();
            initRenderEGLContext(obj);
        }
        if (!makeCurrent()) {
            LiteavLog.e(this.mThrottlers.a("makeCurrent"), this.mTAG, "use origin texture when makeCurrent error", new Object[0]);
            pixelFrame.retain();
            return pixelFrame;
        }
        PixelFrame copyTexture = copyTexture(pixelFrame);
        GLES20.glFinish();
        restoreCallerEGLContext();
        return copyTexture;
    }

    private void initRenderEGLContext(Object obj) {
        if (this.mRenderEGLCore == null) {
            LiteavLog.i(this.mTAG, "initRenderEGLContext");
            this.mSharedEGLContext = obj;
            EGLCore eGLCore = new EGLCore();
            this.mRenderEGLCore = eGLCore;
            try {
                eGLCore.initialize(obj, (Surface) null, 128, 128);
            } catch (EGLException e11) {
                this.mRenderEGLCore = null;
                LiteavLog.e(this.mThrottlers.a("initEGLCore"), this.mTAG, "create EGLCore failed.", (Throwable) e11);
            }
        }
    }

    private boolean makeCurrent() {
        EGLCore eGLCore = this.mRenderEGLCore;
        if (eGLCore == null) {
            LiteavLog.e(this.mThrottlers.a("makeCurrentNull"), this.mTAG, "makeCurrent on mEGLCore is null", new Object[0]);
            return false;
        }
        try {
            eGLCore.makeCurrent();
            return true;
        } catch (EGLException e11) {
            LiteavLog.e(this.mThrottlers.a("makeCurrentError"), this.mTAG, "make current failed.", (Throwable) e11);
            return false;
        }
    }

    private void restoreCallerEGLContext() {
        if (!CommonUtil.equals(this.mCallerEGLContext, EGL14.EGL_NO_CONTEXT)) {
            EGL14.eglMakeCurrent(this.mCallerEGLDisplay, this.mCallerEGLDrawSurface, this.mCallerEGLReadSurface, this.mCallerEGLContext);
            return;
        }
        EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eglGetCurrentDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
    }

    private void saveCallerEGLContext() {
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        if (CommonUtil.equals(this.mCallerEGLContext, EGL14.EGL_NO_CONTEXT) || !CommonUtil.equals(eglGetCurrentContext, this.mCallerEGLContext)) {
            this.mCallerEGLContext = eglGetCurrentContext;
            this.mCallerEGLDisplay = EGL14.eglGetCurrentDisplay();
            this.mCallerEGLReadSurface = EGL14.eglGetCurrentSurface(12378);
            this.mCallerEGLDrawSurface = EGL14.eglGetCurrentSurface(12377);
        }
    }

    private PixelFrame shallowCopyDataToPixelFrame(PixelFrame pixelFrame, Object obj) {
        if (obj instanceof byte[]) {
            pixelFrame.setData((byte[]) obj);
        } else if (obj instanceof ByteBuffer) {
            pixelFrame.setBuffer((ByteBuffer) obj);
        }
        pixelFrame.retain();
        return pixelFrame;
    }

    public synchronized PixelFrame create(int i11, int i12, long j11, int i13, int i14, int i15, Object obj, Object obj2, boolean z11) {
        PixelFrame pixelFrame;
        PixelFrame pixelFrame2 = new PixelFrame();
        pixelFrame2.setWidth(i11);
        pixelFrame2.setHeight(i12);
        pixelFrame2.setTimestamp(j11);
        pixelFrame2.setGLContext(obj);
        pixelFrame2.setTextureId(i15);
        pixelFrame2.setPixelBufferType(GLConstants.PixelBufferType.fromInteger(i13));
        pixelFrame2.setPixelFormatType(GLConstants.PixelFormatType.fromInteger(i14));
        if (pixelFrame2.getPixelBufferType() != GLConstants.PixelBufferType.BYTE_ARRAY) {
            if (pixelFrame2.getPixelBufferType() != GLConstants.PixelBufferType.BYTE_BUFFER) {
                pixelFrame = deepCopyTextureToPixelFrame(pixelFrame2, obj);
            }
        }
        if (z11) {
            pixelFrame = deepCopyDataToPixelFrame(pixelFrame2, obj2);
        } else {
            pixelFrame = shallowCopyDataToPixelFrame(pixelFrame2, obj2);
        }
        return pixelFrame;
    }

    public synchronized void release(PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            pixelFrame.release();
        }
    }

    public synchronized void uninitOpenGLComponents() {
        if (this.mRenderEGLCore != null) {
            LiteavLog.i(this.mTAG, "uninitOpenGLComponents");
            if (makeCurrent()) {
                GLTexturePool gLTexturePool = this.mGLTexturePool;
                if (gLTexturePool != null) {
                    gLTexturePool.evictAll();
                    this.mGLTexturePool.destroy();
                    this.mGLTexturePool = null;
                }
                PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRenderer;
                if (pixelFrameRenderer != null) {
                    pixelFrameRenderer.uninitialize();
                    this.mPixelFrameRenderer = null;
                }
            }
            EGLCore.destroy(this.mRenderEGLCore);
            this.mRenderEGLCore = null;
        }
    }
}
