package com.tencent.ugc.videobase.chain;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.frame.GLFrameBuffer;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.utils.DelayQueue;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import com.tencent.ugc.videobase.utils.Program;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class TXCGPUImageFilter {
    private static final float[] IDENTITY_MATRIX = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public static final String NO_FILTER_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
    public static final String NO_FILTER_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 textureTransform;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}";
    private static final String TAG = "TXCGPUImageFilter";
    private static final AtomicInteger sFilterCount = new AtomicInteger();
    public GLConstants.ColorRange mColorRange;
    public GLConstants.ColorSpace mColorSpace;
    public int mGLAttribPosition;
    public int mGLAttribTextureCoord;
    private final GLFrameBuffer mGLFrameBuffer;
    public int mGLUniformTexture;
    private boolean mIsInitialized;
    public final Size mOutputSize;
    private final Program mProgram;
    private int mProgramId;
    private final DelayQueue mRunOnDrawQueue;
    private float[] mTextureMatrix;
    public GLTexturePool mTexturePool;
    private int mUniformTextureTransform;

    public TXCGPUImageFilter() {
        this(NO_FILTER_VERTEX_SHADER, NO_FILTER_FRAGMENT_SHADER);
    }

    public static /* synthetic */ void lambda$runOnDrawAndWaitDone$4(Runnable runnable, CountDownLatch countDownLatch) {
        runnable.run();
        countDownLatch.countDown();
    }

    public static /* synthetic */ void lambda$setFloatOnDraw$0(TXCGPUImageFilter tXCGPUImageFilter, int i11, float f11) {
        GLES20.glUseProgram(tXCGPUImageFilter.getProgramId());
        GLES20.glUniform1f(i11, f11);
    }

    public static /* synthetic */ void lambda$setFloatVec2OnDraw$2(TXCGPUImageFilter tXCGPUImageFilter, int i11, float[] fArr) {
        GLES20.glUseProgram(tXCGPUImageFilter.getProgramId());
        GLES20.glUniform2fv(i11, 1, FloatBuffer.wrap(fArr));
    }

    public static /* synthetic */ void lambda$setFloatVec3OnDraw$1(TXCGPUImageFilter tXCGPUImageFilter, int i11, float[] fArr) {
        GLES20.glUseProgram(tXCGPUImageFilter.getProgramId());
        GLES20.glUniform3fv(i11, 1, FloatBuffer.wrap(fArr));
    }

    public static /* synthetic */ void lambda$setFloatVec4OnDraw$3(TXCGPUImageFilter tXCGPUImageFilter, int i11, float[] fArr) {
        GLES20.glUseProgram(tXCGPUImageFilter.getProgramId());
        GLES20.glUniform4fv(i11, 1, FloatBuffer.wrap(fArr));
    }

    public void afterDrawArrays() {
    }

    public void beforeDrawArrays(int i11) {
    }

    public int buildProgram() {
        return this.mProgram.build();
    }

    public boolean canBeSkipped() {
        return false;
    }

    public Size getOutputSize() {
        return this.mOutputSize;
    }

    public final int getProgramId() {
        return this.mProgramId;
    }

    public int getTarget() {
        return 3553;
    }

    public final void initialize(GLTexturePool gLTexturePool) {
        if (!this.mIsInitialized) {
            this.mGLFrameBuffer.initialize();
            this.mProgramId = buildProgram();
            this.mGLAttribPosition = GLES20.glGetAttribLocation(getProgramId(), "position");
            this.mGLUniformTexture = GLES20.glGetUniformLocation(getProgramId(), "inputImageTexture");
            this.mGLAttribTextureCoord = GLES20.glGetAttribLocation(getProgramId(), "inputTextureCoordinate");
            this.mUniformTextureTransform = GLES20.glGetUniformLocation(getProgramId(), "textureTransform");
            onInit(gLTexturePool);
            this.mIsInitialized = true;
            LiteavLog.d(TAG, "%s initialized, count: %d", this, Integer.valueOf(sFilterCount.incrementAndGet()));
        }
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public boolean isLessOrEqualZero(float f11) {
        return ((double) f11) < 1.0E-5d;
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.mIsInitialized) {
            GLES20.glUseProgram(getProgramId());
            runPendingOnDrawTasks();
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 0, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.mGLAttribTextureCoord, 2, 5126, false, 0, floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoord);
            if (i11 != -1) {
                GLES20.glActiveTexture(33984);
                OpenGlUtils.bindTexture(getTarget(), i11);
                GLES20.glUniform1i(this.mGLUniformTexture, 0);
            }
            if (gLTexture != null) {
                this.mGLFrameBuffer.attachTexture(gLTexture.getId());
                this.mGLFrameBuffer.bindToContext();
            } else {
                OpenGlUtils.bindFramebuffer(36160, 0);
            }
            float[] fArr = this.mTextureMatrix;
            if (fArr == null) {
                fArr = IDENTITY_MATRIX;
            }
            GLES20.glUniformMatrix4fv(this.mUniformTextureTransform, 1, false, fArr, 0);
            beforeDrawArrays(i11);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
            GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoord);
            afterDrawArrays();
            GLES20.glActiveTexture(33984);
            OpenGlUtils.bindTexture(getTarget(), 0);
            if (gLTexture != null) {
                this.mGLFrameBuffer.unbindFromContext();
                this.mGLFrameBuffer.detachTexture();
            }
        }
    }

    public void onFilterBeenSkipped() {
        if (this.mIsInitialized) {
            GLES20.glUseProgram(getProgramId());
            runPendingOnDrawTasks();
        }
    }

    public void onInit(GLTexturePool gLTexturePool) {
        this.mTexturePool = gLTexturePool;
    }

    public void onOutputSizeChanged(int i11, int i12) {
        Size size = this.mOutputSize;
        size.width = i11;
        size.height = i12;
    }

    public void onUninit() {
    }

    public final void runOnDraw(Runnable runnable) {
        this.mRunOnDrawQueue.add(runnable);
    }

    public void runOnDrawAndWaitDone(Runnable runnable) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mRunOnDrawQueue.add(e.a(runnable, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public void runPendingOnDrawTasks() {
        this.mRunOnDrawQueue.rerun();
    }

    public void setColorFormat(GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        this.mColorRange = colorRange;
        this.mColorSpace = colorSpace;
    }

    public void setFloatOnDraw(int i11, float f11) {
        runOnDraw(a.a(this, i11, f11));
    }

    public void setFloatVec2OnDraw(int i11, float[] fArr) {
        runOnDraw(c.a(this, i11, fArr));
    }

    public void setFloatVec3OnDraw(int i11, float[] fArr) {
        runOnDraw(b.a(this, i11, fArr));
    }

    public void setFloatVec4OnDraw(int i11, float[] fArr) {
        runOnDraw(d.a(this, i11, fArr));
    }

    public void setTextureTransform(float[] fArr) {
        this.mTextureMatrix = fArr;
    }

    public final void uninitialize() {
        if (this.mIsInitialized) {
            runPendingOnDrawTasks();
            onUninit();
            this.mIsInitialized = false;
            this.mGLFrameBuffer.uninitialize();
            int i11 = this.mProgramId;
            if (i11 != -1) {
                GLES20.glDeleteProgram(i11);
                this.mProgramId = -1;
            }
            LiteavLog.d(TAG, "%s uninitialized, count: %d", this, Integer.valueOf(sFilterCount.decrementAndGet()));
        }
    }

    public TXCGPUImageFilter(String str, String str2) {
        this.mOutputSize = new Size(-1, -1);
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mProgramId = -1;
        this.mGLFrameBuffer = new GLFrameBuffer();
        this.mRunOnDrawQueue = new DelayQueue();
        this.mProgram = new Program(str, str2);
    }
}
