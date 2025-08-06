package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements VideoDecoderOutputBufferRenderer {
    private final Renderer renderer;

    public static final class Renderer implements GLSurfaceView.Renderer {
        private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n";
        private static final String[] TEXTURE_UNIFORMS = {"y_tex", "u_tex", "v_tex"};
        private static final FloatBuffer TEXTURE_VERTICES = GlUtil.createBuffer(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
        private static final String VERTEX_SHADER = "varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n";
        private static final float[] kColorConversion2020 = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
        private static final float[] kColorConversion601 = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
        private static final float[] kColorConversion709 = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
        private int colorMatrixLocation;
        private final AtomicReference<VideoDecoderOutputBuffer> pendingOutputBufferReference = new AtomicReference<>();
        private final int[] previousStrides = new int[3];
        private final int[] previousWidths = new int[3];
        private int program;
        private VideoDecoderOutputBuffer renderedOutputBuffer;
        private final GLSurfaceView surfaceView;
        private final int[] texLocations = new int[3];
        private final FloatBuffer[] textureCoords = new FloatBuffer[3];
        private final int[] yuvTextures = new int[3];

        public Renderer(GLSurfaceView gLSurfaceView) {
            this.surfaceView = gLSurfaceView;
            for (int i11 = 0; i11 < 3; i11++) {
                int[] iArr = this.previousWidths;
                this.previousStrides[i11] = -1;
                iArr[i11] = -1;
            }
        }

        private void setupTextures() {
            GLES20.glGenTextures(3, this.yuvTextures, 0);
            for (int i11 = 0; i11 < 3; i11++) {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.program, TEXTURE_UNIFORMS[i11]), i11);
                GLES20.glActiveTexture(33984 + i11);
                GLES20.glBindTexture(3553, this.yuvTextures[i11]);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            GlUtil.checkGlError();
        }

        public void onDrawFrame(GL10 gl10) {
            VideoDecoderOutputBuffer andSet = this.pendingOutputBufferReference.getAndSet((Object) null);
            if (andSet != null || this.renderedOutputBuffer != null) {
                if (andSet != null) {
                    VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.renderedOutputBuffer;
                    if (videoDecoderOutputBuffer != null) {
                        videoDecoderOutputBuffer.release();
                    }
                    this.renderedOutputBuffer = andSet;
                }
                VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (VideoDecoderOutputBuffer) Assertions.checkNotNull(this.renderedOutputBuffer);
                float[] fArr = kColorConversion709;
                int i11 = videoDecoderOutputBuffer2.colorspace;
                if (i11 == 1) {
                    fArr = kColorConversion601;
                } else if (i11 == 3) {
                    fArr = kColorConversion2020;
                }
                GLES20.glUniformMatrix3fv(this.colorMatrixLocation, 1, false, fArr, 0);
                int[] iArr = (int[]) Assertions.checkNotNull(videoDecoderOutputBuffer2.yuvStrides);
                ByteBuffer[] byteBufferArr = (ByteBuffer[]) Assertions.checkNotNull(videoDecoderOutputBuffer2.yuvPlanes);
                int i12 = 0;
                while (i12 < 3) {
                    int i13 = i12 == 0 ? videoDecoderOutputBuffer2.height : (videoDecoderOutputBuffer2.height + 1) / 2;
                    GLES20.glActiveTexture(33984 + i12);
                    GLES20.glBindTexture(3553, this.yuvTextures[i12]);
                    GLES20.glPixelStorei(3317, 1);
                    GLES20.glTexImage2D(3553, 0, 6409, iArr[i12], i13, 0, 6409, 5121, byteBufferArr[i12]);
                    i12++;
                }
                int[] iArr2 = new int[3];
                iArr2[0] = videoDecoderOutputBuffer2.width;
                int i14 = (iArr2[0] + 1) / 2;
                iArr2[2] = i14;
                iArr2[1] = i14;
                for (int i15 = 0; i15 < 3; i15++) {
                    if (this.previousWidths[i15] != iArr2[i15] || this.previousStrides[i15] != iArr[i15]) {
                        Assertions.checkState(iArr[i15] != 0);
                        float f11 = ((float) iArr2[i15]) / ((float) iArr[i15]);
                        this.textureCoords[i15] = GlUtil.createBuffer(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f11, 0.0f, f11, 1.0f});
                        GLES20.glVertexAttribPointer(this.texLocations[i15], 2, 5126, false, 0, this.textureCoords[i15]);
                        this.previousWidths[i15] = iArr2[i15];
                        this.previousStrides[i15] = iArr[i15];
                    }
                }
                GLES20.glClear(16384);
                GLES20.glDrawArrays(5, 0, 4);
                GlUtil.checkGlError();
            }
        }

        public void onSurfaceChanged(GL10 gl10, int i11, int i12) {
            GLES20.glViewport(0, 0, i11, i12);
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            int compileProgram = GlUtil.compileProgram(VERTEX_SHADER, FRAGMENT_SHADER);
            this.program = compileProgram;
            GLES20.glUseProgram(compileProgram);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.program, "in_pos");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, TEXTURE_VERTICES);
            this.texLocations[0] = GLES20.glGetAttribLocation(this.program, "in_tc_y");
            GLES20.glEnableVertexAttribArray(this.texLocations[0]);
            this.texLocations[1] = GLES20.glGetAttribLocation(this.program, "in_tc_u");
            GLES20.glEnableVertexAttribArray(this.texLocations[1]);
            this.texLocations[2] = GLES20.glGetAttribLocation(this.program, "in_tc_v");
            GLES20.glEnableVertexAttribArray(this.texLocations[2]);
            GlUtil.checkGlError();
            this.colorMatrixLocation = GLES20.glGetUniformLocation(this.program, "mColorConversion");
            GlUtil.checkGlError();
            setupTextures();
            GlUtil.checkGlError();
        }

        public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
            VideoDecoderOutputBuffer andSet = this.pendingOutputBufferReference.getAndSet(videoDecoderOutputBuffer);
            if (andSet != null) {
                andSet.release();
            }
            this.surfaceView.requestRender();
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    @Deprecated
    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.renderer.setOutputBuffer(videoDecoderOutputBuffer);
    }

    public VideoDecoderGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Renderer renderer2 = new Renderer(this);
        this.renderer = renderer2;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(renderer2);
        setRenderMode(0);
    }
}
