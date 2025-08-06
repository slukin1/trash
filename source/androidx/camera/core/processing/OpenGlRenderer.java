package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.core.util.h;
import com.google.auto.value.AutoValue;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class OpenGlRenderer {
    private static final String DEFAULT_FRAGMENT_SHADER;
    private static final String DEFAULT_VERTEX_SHADER;
    private static final String HDR_FRAGMENT_SHADER;
    private static final String HDR_VERTEX_SHADER;
    private static final OutputSurface NO_OUTPUT_SURFACE = OutputSurface.of(EGL14.EGL_NO_SURFACE, 0, 0);
    private static final int PIXEL_STRIDE = 4;
    private static final int SIZEOF_FLOAT = 4;
    private static final String TAG = "OpenGlRenderer";
    private static final FloatBuffer TEX_BUF;
    private static final float[] TEX_COORDS;
    private static final String VAR_TEXTURE = "sTexture";
    private static final String VAR_TEXTURE_COORD = "vTextureCoord";
    private static final FloatBuffer VERTEX_BUF;
    private static final float[] VERTEX_COORDS;
    private Surface mCurrentSurface;
    private EGLConfig mEglConfig;
    private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;
    private EGLDisplay mEglDisplay = EGL14.EGL_NO_DISPLAY;
    private int mExternalTextureId = -1;
    private Thread mGlThread;
    private final AtomicBoolean mInitialized = new AtomicBoolean(false);
    public final Map<Surface, OutputSurface> mOutputSurfaceMap = new HashMap();
    private int mPositionLoc = -1;
    private int mProgramHandle = -1;
    private EGLSurface mTempSurface = EGL14.EGL_NO_SURFACE;
    private int mTexCoordLoc = -1;
    private int mTexMatrixLoc = -1;

    @AutoValue
    public static abstract class OutputSurface {
        public static OutputSurface of(EGLSurface eGLSurface, int i11, int i12) {
            return new AutoValue_OpenGlRenderer_OutputSurface(eGLSurface, i11, i12);
        }

        public abstract EGLSurface getEglSurface();

        public abstract int getHeight();

        public abstract int getWidth();
    }

    static {
        Locale locale = Locale.US;
        DEFAULT_VERTEX_SHADER = String.format(locale, "uniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 %s;\nvoid main() {\n    gl_Position = aPosition;\n    %s = (uTexMatrix * aTextureCoord).xy;\n}\n", new Object[]{VAR_TEXTURE_COORD, VAR_TEXTURE_COORD});
        HDR_VERTEX_SHADER = String.format(locale, "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nuniform mat4 uTexMatrix;\nout vec2 %s;\nvoid main() {\n  gl_Position = aPosition;\n  %s = (uTexMatrix * aTextureCoord).xy;\n}\n", new Object[]{VAR_TEXTURE_COORD, VAR_TEXTURE_COORD});
        DEFAULT_FRAGMENT_SHADER = String.format(locale, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 %s;\nuniform samplerExternalOES %s;\nvoid main() {\n    gl_FragColor = texture2D(%s, %s);\n}\n", new Object[]{VAR_TEXTURE_COORD, VAR_TEXTURE, VAR_TEXTURE, VAR_TEXTURE_COORD});
        HDR_FRAGMENT_SHADER = String.format(locale, "#version 300 es\n#extension GL_OES_EGL_image_external : require\n#extension GL_EXT_YUV_target : require\nprecision mediump float;\nuniform __samplerExternal2DY2YEXT %s;\nin vec2 %s;\nout vec4 outColor;\n\nvec3 yuvToRgb(vec3 yuv) {\n  const vec3 yuvOffset = vec3(0.0625, 0.5, 0.5);\n  const mat3 yuvToRgbColorTransform = mat3(\n    1.1689f, 1.1689f, 1.1689f,\n    0.0000f, -0.1881f, 2.1502f,\n    1.6853f, -0.6530f, 0.0000f\n  );\n  return clamp(yuvToRgbColorTransform * (yuv - yuvOffset), 0.0, 1.0);\n}\n\nvoid main() {\n  vec3 srcYuv = texture(%s, %s).xyz;\n  outColor = vec4(yuvToRgb(srcYuv), 1.0);\n}", new Object[]{VAR_TEXTURE, VAR_TEXTURE_COORD, VAR_TEXTURE, VAR_TEXTURE_COORD});
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        VERTEX_COORDS = fArr;
        VERTEX_BUF = createFloatBuffer(fArr);
        float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TEX_COORDS = fArr2;
        TEX_BUF = createFloatBuffer(fArr2);
    }

    private static void checkEglErrorOrLog(String str) {
        try {
            checkEglErrorOrThrow(str);
        } catch (IllegalStateException e11) {
            Logger.e(TAG, e11.toString(), e11);
        }
    }

    private static void checkEglErrorOrThrow(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    private static void checkGlErrorOrThrow(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            throw new IllegalStateException(str + ": GL error 0x" + Integer.toHexString(glGetError));
        }
    }

    private void checkGlThreadOrThrow() {
        h.j(this.mGlThread == Thread.currentThread(), "Method call must be called on the GL thread.");
    }

    private void checkInitializedOrThrow(boolean z11) {
        h.j(z11 == this.mInitialized.get(), z11 ? "OpenGlRenderer is not initialized" : "OpenGlRenderer is already initialized");
    }

    private static void checkLocationOrThrow(int i11, String str) {
        if (i11 < 0) {
            throw new IllegalStateException("Unable to locate '" + str + "' in program");
        }
    }

    private void createEglContext(DynamicRange dynamicRange) {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEglDisplay = eglGetDisplay;
        if (!Objects.equals(eglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(this.mEglDisplay, iArr, 0, iArr, 1)) {
                int i11 = dynamicRange.is10BitHdr() ? 10 : 8;
                int i12 = 3;
                int[] iArr2 = {12324, i11, 12323, i11, 12322, i11, 12321, dynamicRange.is10BitHdr() ? 2 : 8, 12325, 0, 12326, 0, 12352, dynamicRange.is10BitHdr() ? 64 : 4, 12610, !dynamicRange.is10BitHdr(), 12339, 5, 12344};
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.mEglDisplay, iArr2, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    int[] iArr3 = new int[3];
                    iArr3[0] = 12440;
                    if (!dynamicRange.is10BitHdr()) {
                        i12 = 2;
                    }
                    iArr3[1] = i12;
                    iArr3[2] = 12344;
                    EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEglDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr3, 0);
                    checkEglErrorOrThrow("eglCreateContext");
                    this.mEglConfig = eGLConfig;
                    this.mEglContext = eglCreateContext;
                    int[] iArr4 = new int[1];
                    EGL14.eglQueryContext(this.mEglDisplay, eglCreateContext, 12440, iArr4, 0);
                    Log.d(TAG, "EGLContext created, client version " + iArr4[0]);
                    return;
                }
                throw new IllegalStateException("Unable to find a suitable EGLConfig");
            }
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            throw new IllegalStateException("Unable to initialize EGL14");
        }
        throw new IllegalStateException("Unable to get EGL14 display");
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    private OutputSurface createOutputSurfaceInternal(Surface surface) {
        try {
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLConfig eGLConfig = this.mEglConfig;
            Objects.requireNonNull(eGLConfig);
            EGLConfig eGLConfig2 = eGLConfig;
            EGLSurface createWindowSurface = createWindowSurface(eGLDisplay, eGLConfig, surface);
            Size surfaceSize = getSurfaceSize(createWindowSurface);
            return OutputSurface.of(createWindowSurface, surfaceSize.getWidth(), surfaceSize.getHeight());
        } catch (IllegalArgumentException | IllegalStateException e11) {
            Logger.w(TAG, "Failed to create EGL surface: " + e11.getMessage(), e11);
            return null;
        }
    }

    private static EGLSurface createPBufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i11, int i12) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, i11, 12374, i12, 12344}, 0);
        checkEglErrorOrThrow("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createProgram(androidx.camera.core.DynamicRange r8, androidx.camera.core.processing.ShaderProvider r9) {
        /*
            r7 = this;
            java.lang.String r0 = "glAttachShader"
            r1 = 35633(0x8b31, float:4.9932E-41)
            r2 = -1
            boolean r3 = r8.is10BitHdr()     // Catch:{ IllegalStateException -> 0x0075, IllegalArgumentException -> 0x0073 }
            if (r3 == 0) goto L_0x000f
            java.lang.String r3 = HDR_VERTEX_SHADER     // Catch:{ IllegalStateException -> 0x0075, IllegalArgumentException -> 0x0073 }
            goto L_0x0011
        L_0x000f:
            java.lang.String r3 = DEFAULT_VERTEX_SHADER     // Catch:{ IllegalStateException -> 0x0075, IllegalArgumentException -> 0x0073 }
        L_0x0011:
            int r1 = loadShader(r1, r3)     // Catch:{ IllegalStateException -> 0x0075, IllegalArgumentException -> 0x0073 }
            int r8 = r7.loadFragmentShader(r8, r9)     // Catch:{ IllegalStateException -> 0x006f, IllegalArgumentException -> 0x006d }
            int r9 = android.opengl.GLES20.glCreateProgram()     // Catch:{ IllegalStateException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.String r3 = "glCreateProgram"
            checkGlErrorOrThrow(r3)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            android.opengl.GLES20.glAttachShader(r9, r1)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            checkGlErrorOrThrow(r0)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            android.opengl.GLES20.glAttachShader(r9, r8)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            checkGlErrorOrThrow(r0)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            android.opengl.GLES20.glLinkProgram(r9)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            r0 = 1
            int[] r3 = new int[r0]     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            r4 = 35714(0x8b82, float:5.0046E-41)
            r5 = 0
            android.opengl.GLES20.glGetProgramiv(r9, r4, r3, r5)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            r3 = r3[r5]     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            if (r3 != r0) goto L_0x0042
            r7.mProgramHandle = r9     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            return
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            r3.<init>()     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            java.lang.String r4 = "Could not link program: "
            r3.append(r4)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            java.lang.String r4 = android.opengl.GLES20.glGetProgramInfoLog(r9)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            r3.append(r4)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            java.lang.String r3 = r3.toString()     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            r0.<init>(r3)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            throw r0     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
        L_0x005d:
            r0 = move-exception
            goto L_0x0060
        L_0x005f:
            r0 = move-exception
        L_0x0060:
            r6 = r9
            r9 = r8
            r8 = r0
            r0 = r6
            goto L_0x0079
        L_0x0065:
            r9 = move-exception
            goto L_0x0068
        L_0x0067:
            r9 = move-exception
        L_0x0068:
            r0 = r2
            r6 = r9
            r9 = r8
            r8 = r6
            goto L_0x0079
        L_0x006d:
            r8 = move-exception
            goto L_0x0070
        L_0x006f:
            r8 = move-exception
        L_0x0070:
            r9 = r2
            r0 = r9
            goto L_0x0079
        L_0x0073:
            r8 = move-exception
            goto L_0x0076
        L_0x0075:
            r8 = move-exception
        L_0x0076:
            r9 = r2
            r0 = r9
            r1 = r0
        L_0x0079:
            if (r1 == r2) goto L_0x007e
            android.opengl.GLES20.glDeleteShader(r1)
        L_0x007e:
            if (r9 == r2) goto L_0x0083
            android.opengl.GLES20.glDeleteShader(r9)
        L_0x0083:
            if (r0 == r2) goto L_0x0088
            android.opengl.GLES20.glDeleteProgram(r0)
        L_0x0088:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.processing.OpenGlRenderer.createProgram(androidx.camera.core.DynamicRange, androidx.camera.core.processing.ShaderProvider):void");
    }

    private void createTempSurface() {
        EGLDisplay eGLDisplay = this.mEglDisplay;
        EGLConfig eGLConfig = this.mEglConfig;
        Objects.requireNonNull(eGLConfig);
        EGLConfig eGLConfig2 = eGLConfig;
        this.mTempSurface = createPBufferSurface(eGLDisplay, eGLConfig, 1, 1);
    }

    private void createTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlErrorOrThrow("glGenTextures");
        int i11 = iArr[0];
        GLES20.glBindTexture(36197, i11);
        checkGlErrorOrThrow("glBindTexture " + i11);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlErrorOrThrow("glTexParameter");
        this.mExternalTextureId = i11;
    }

    private static EGLSurface createWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Surface surface) {
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, new int[]{12344}, 0);
        checkEglErrorOrThrow("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    private static void deleteFbo(int i11) {
        GLES20.glDeleteFramebuffers(1, new int[]{i11}, 0);
        checkGlErrorOrThrow("glDeleteFramebuffers");
    }

    private static void deleteTexture(int i11) {
        GLES20.glDeleteTextures(1, new int[]{i11}, 0);
        checkGlErrorOrThrow("glDeleteTextures");
    }

    private static int generateFbo() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        checkGlErrorOrThrow("glGenFramebuffers");
        return iArr[0];
    }

    private static int generateTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlErrorOrThrow("glGenTextures");
        return iArr[0];
    }

    private String getGlExtensionsBeforeInitialized(DynamicRange dynamicRange) {
        String str = "";
        checkInitializedOrThrow(false);
        try {
            createEglContext(dynamicRange);
            createTempSurface();
            makeCurrent(this.mTempSurface);
            String glGetString = GLES20.glGetString(7939);
            if (glGetString != null) {
                str = glGetString;
            }
            return str;
        } catch (IllegalStateException e11) {
            Logger.w(TAG, "Failed to get GL extensions: " + e11.getMessage(), e11);
            return str;
        } finally {
            releaseInternal();
        }
    }

    private OutputSurface getOutSurfaceOrThrow(Surface surface) {
        h.j(this.mOutputSurfaceMap.containsKey(surface), "The surface is not registered.");
        OutputSurface outputSurface = this.mOutputSurfaceMap.get(surface);
        Objects.requireNonNull(outputSurface);
        return outputSurface;
    }

    private Size getSurfaceSize(EGLSurface eGLSurface) {
        return new Size(querySurface(this.mEglDisplay, eGLSurface, 12375), querySurface(this.mEglDisplay, eGLSurface, 12374));
    }

    private int loadFragmentShader(DynamicRange dynamicRange, ShaderProvider shaderProvider) {
        if (shaderProvider == ShaderProvider.DEFAULT) {
            return loadShader(35632, dynamicRange.is10BitHdr() ? HDR_FRAGMENT_SHADER : DEFAULT_FRAGMENT_SHADER);
        }
        try {
            String createFragmentShader = shaderProvider.createFragmentShader(VAR_TEXTURE, VAR_TEXTURE_COORD);
            if (createFragmentShader != null && createFragmentShader.contains(VAR_TEXTURE_COORD) && createFragmentShader.contains(VAR_TEXTURE)) {
                return loadShader(35632, createFragmentShader);
            }
            throw new IllegalArgumentException("Invalid fragment shader");
        } catch (Throwable th2) {
            if (th2 instanceof IllegalArgumentException) {
                throw th2;
            }
            throw new IllegalArgumentException("Unable to compile fragment shader", th2);
        }
    }

    private void loadLocations() {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
        this.mPositionLoc = glGetAttribLocation;
        checkLocationOrThrow(glGetAttribLocation, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
        this.mTexCoordLoc = glGetAttribLocation2;
        checkLocationOrThrow(glGetAttribLocation2, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        this.mTexMatrixLoc = glGetUniformLocation;
        checkLocationOrThrow(glGetUniformLocation, "uTexMatrix");
    }

    private static int loadShader(int i11, String str) {
        int glCreateShader = GLES20.glCreateShader(i11);
        checkGlErrorOrThrow("glCreateShader type=" + i11);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Logger.w(TAG, "Could not compile shader: " + str);
        GLES20.glDeleteShader(glCreateShader);
        throw new IllegalStateException("Could not compile shader type " + i11 + ":" + GLES20.glGetShaderInfoLog(glCreateShader));
    }

    private void makeCurrent(EGLSurface eGLSurface) {
        h.g(this.mEglDisplay);
        h.g(this.mEglContext);
        if (!EGL14.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
            throw new IllegalStateException("eglMakeCurrent failed");
        }
    }

    private static int querySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i11) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(eGLDisplay, eGLSurface, i11, iArr, 0);
        return iArr[0];
    }

    private void releaseInternal() {
        int i11 = this.mProgramHandle;
        if (i11 != -1) {
            GLES20.glDeleteProgram(i11);
            this.mProgramHandle = -1;
        }
        if (!Objects.equals(this.mEglDisplay, EGL14.EGL_NO_DISPLAY)) {
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            for (OutputSurface next : this.mOutputSurfaceMap.values()) {
                if (!Objects.equals(next.getEglSurface(), EGL14.EGL_NO_SURFACE) && !EGL14.eglDestroySurface(this.mEglDisplay, next.getEglSurface())) {
                    checkEglErrorOrLog("eglDestroySurface");
                }
            }
            this.mOutputSurfaceMap.clear();
            if (!Objects.equals(this.mTempSurface, EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.mEglDisplay, this.mTempSurface);
                this.mTempSurface = EGL14.EGL_NO_SURFACE;
            }
            if (!Objects.equals(this.mEglContext, EGL14.EGL_NO_CONTEXT)) {
                EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
                this.mEglContext = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEglDisplay);
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        }
        this.mEglConfig = null;
        this.mProgramHandle = -1;
        this.mTexMatrixLoc = -1;
        this.mPositionLoc = -1;
        this.mTexCoordLoc = -1;
        this.mExternalTextureId = -1;
        this.mCurrentSurface = null;
        this.mGlThread = null;
    }

    private void removeOutputSurfaceInternal(Surface surface, boolean z11) {
        OutputSurface outputSurface;
        if (this.mCurrentSurface == surface) {
            this.mCurrentSurface = null;
            makeCurrent(this.mTempSurface);
        }
        if (z11) {
            outputSurface = this.mOutputSurfaceMap.remove(surface);
        } else {
            outputSurface = this.mOutputSurfaceMap.put(surface, NO_OUTPUT_SURFACE);
        }
        if (outputSurface != null && outputSurface != NO_OUTPUT_SURFACE) {
            try {
                EGL14.eglDestroySurface(this.mEglDisplay, outputSurface.getEglSurface());
            } catch (RuntimeException e11) {
                Logger.w(TAG, "Failed to destroy EGL surface: " + e11.getMessage(), e11);
            }
        }
    }

    private void useAndConfigureProgram() {
        GLES20.glUseProgram(this.mProgramHandle);
        checkGlErrorOrThrow("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mExternalTextureId);
        GLES20.glEnableVertexAttribArray(this.mPositionLoc);
        checkGlErrorOrThrow("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mPositionLoc, 2, 5126, false, 0, VERTEX_BUF);
        checkGlErrorOrThrow("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.mTexCoordLoc);
        checkGlErrorOrThrow("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mTexCoordLoc, 2, 5126, false, 0, TEX_BUF);
        checkGlErrorOrThrow("glVertexAttribPointer");
    }

    public int getTextureName() {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        return this.mExternalTextureId;
    }

    public void init(DynamicRange dynamicRange, ShaderProvider shaderProvider) {
        checkInitializedOrThrow(false);
        try {
            if (dynamicRange.is10BitHdr() && !getGlExtensionsBeforeInitialized(dynamicRange).contains("GL_EXT_YUV_target")) {
                Log.w(TAG, "Device does not support GL_EXT_YUV_target. Fallback to SDR.");
                dynamicRange = DynamicRange.SDR;
            }
            createEglContext(dynamicRange);
            createTempSurface();
            makeCurrent(this.mTempSurface);
            createProgram(dynamicRange, shaderProvider);
            loadLocations();
            createTexture();
            useAndConfigureProgram();
            this.mGlThread = Thread.currentThread();
            this.mInitialized.set(true);
        } catch (IllegalArgumentException | IllegalStateException e11) {
            releaseInternal();
            throw e11;
        }
    }

    public void registerOutputSurface(Surface surface) {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        if (!this.mOutputSurfaceMap.containsKey(surface)) {
            this.mOutputSurfaceMap.put(surface, NO_OUTPUT_SURFACE);
        }
    }

    public void release() {
        if (this.mInitialized.getAndSet(false)) {
            checkGlThreadOrThrow();
            releaseInternal();
        }
    }

    public void render(long j11, float[] fArr, Surface surface) {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        OutputSurface outSurfaceOrThrow = getOutSurfaceOrThrow(surface);
        if (outSurfaceOrThrow == NO_OUTPUT_SURFACE) {
            outSurfaceOrThrow = createOutputSurfaceInternal(surface);
            if (outSurfaceOrThrow != null) {
                this.mOutputSurfaceMap.put(surface, outSurfaceOrThrow);
            } else {
                return;
            }
        }
        if (surface != this.mCurrentSurface) {
            makeCurrent(outSurfaceOrThrow.getEglSurface());
            this.mCurrentSurface = surface;
            GLES20.glViewport(0, 0, outSurfaceOrThrow.getWidth(), outSurfaceOrThrow.getHeight());
            GLES20.glScissor(0, 0, outSurfaceOrThrow.getWidth(), outSurfaceOrThrow.getHeight());
        }
        GLES20.glUniformMatrix4fv(this.mTexMatrixLoc, 1, false, fArr, 0);
        checkGlErrorOrThrow("glUniformMatrix4fv");
        GLES20.glDrawArrays(5, 0, 4);
        checkGlErrorOrThrow("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID(this.mEglDisplay, outSurfaceOrThrow.getEglSurface(), j11);
        if (!EGL14.eglSwapBuffers(this.mEglDisplay, outSurfaceOrThrow.getEglSurface())) {
            Logger.w(TAG, "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
            removeOutputSurfaceInternal(surface, false);
        }
    }

    public Bitmap snapshot(Size size, float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(size.getWidth() * size.getHeight() * 4);
        snapshot(allocateDirect, size, fArr);
        Bitmap createBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), Bitmap.Config.ARGB_8888);
        allocateDirect.rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(createBitmap, allocateDirect, size.getWidth() * 4);
        return createBitmap;
    }

    public void unregisterOutputSurface(Surface surface) {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        removeOutputSurfaceInternal(surface, true);
    }

    private void snapshot(ByteBuffer byteBuffer, Size size, float[] fArr) {
        h.b(byteBuffer.capacity() == (size.getWidth() * size.getHeight()) * 4, "ByteBuffer capacity is not equal to width * height * 4.");
        h.b(byteBuffer.isDirect(), "ByteBuffer is not direct.");
        int generateTexture = generateTexture();
        GLES20.glActiveTexture(33985);
        checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(3553, generateTexture);
        checkGlErrorOrThrow("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, size.getWidth(), size.getHeight(), 0, 6407, 5121, (Buffer) null);
        checkGlErrorOrThrow("glTexImage2D");
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int generateFbo = generateFbo();
        GLES20.glBindFramebuffer(36160, generateFbo);
        checkGlErrorOrThrow("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, generateTexture, 0);
        checkGlErrorOrThrow("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(36197, this.mExternalTextureId);
        checkGlErrorOrThrow("glBindTexture");
        this.mCurrentSurface = null;
        GLES20.glViewport(0, 0, size.getWidth(), size.getHeight());
        GLES20.glScissor(0, 0, size.getWidth(), size.getHeight());
        GLES20.glUniformMatrix4fv(this.mTexMatrixLoc, 1, false, fArr, 0);
        checkGlErrorOrThrow("glUniformMatrix4fv");
        GLES20.glDrawArrays(5, 0, 4);
        checkGlErrorOrThrow("glDrawArrays");
        GLES20.glReadPixels(0, 0, size.getWidth(), size.getHeight(), 6408, 5121, byteBuffer);
        checkGlErrorOrThrow("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        deleteTexture(generateTexture);
        deleteFbo(generateFbo);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mExternalTextureId);
    }
}
