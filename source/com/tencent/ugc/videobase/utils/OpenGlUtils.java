package com.tencent.ugc.videobase.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.videobase.base.GLConstants;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

@JNINamespace("liteav::ugc")
public class OpenGlUtils {
    private static final String TAG = "OpenGlUtils";

    /* renamed from: com.tencent.ugc.videobase.utils.OpenGlUtils$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50870a;

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
                f50870a = r0
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50870a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50870a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f50870a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.NORMAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videobase.utils.OpenGlUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public static void attachTextureToFrameBuffer(int i11, int i12) {
        GLES20.glBindFramebuffer(36160, i12);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i11, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public static void bindFramebuffer(int i11, int i12) {
        GLES20.glBindFramebuffer(i11, i12);
    }

    public static void bindTexture(int i11, int i12) {
        GLES20.glBindTexture(i11, i12);
    }

    public static void checkGlError(String str) {
    }

    public static void convertYuvFormat(GLConstants.PixelFormatType pixelFormatType, Object obj, GLConstants.PixelFormatType pixelFormatType2, Object obj2, int i11, int i12) {
        boolean z11;
        int value = pixelFormatType.getValue();
        int value2 = pixelFormatType2.getValue();
        boolean z12 = obj instanceof ByteBuffer;
        if (z12 && (obj2 instanceof ByteBuffer)) {
            z11 = nativeConvertYuvFormatBufferToBuffer(value, (ByteBuffer) obj, value2, (ByteBuffer) obj2, i11, i12);
        } else if (z12 && (obj2 instanceof byte[])) {
            z11 = nativeConvertYuvFormatBufferToArray(value, (ByteBuffer) obj, value2, (byte[]) obj2, i11, i12);
        } else if (!(obj instanceof byte[]) || !(obj2 instanceof ByteBuffer)) {
            z11 = nativeConvertYuvFormatArrayToArray(value, (byte[]) obj, value2, (byte[]) obj2, i11, i12);
        } else {
            z11 = nativeConvertYuvFormatArrayToBuffer(value, (byte[]) obj, value2, (ByteBuffer) obj2, i11, i12);
        }
        if (!z11) {
            throw new IllegalArgumentException("Do not support " + pixelFormatType + " to " + pixelFormatType2);
        }
    }

    public static FloatBuffer createNormalCubeVerticesBuffer() {
        float[] fArr = GLConstants.CUBE_VERTICES_ARRAYS;
        return (FloatBuffer) ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).position(0);
    }

    public static int createTexture(int i11, int i12, int i13, int i14) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        LiteavLog.d(TAG, "glGenTextures textureId: " + iArr[0]);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, i13, i11, i12, 0, i14, 5121, (Buffer) null);
        return iArr[0];
    }

    public static FloatBuffer createTextureCoordsBuffer(k kVar, boolean z11, boolean z12) {
        float[] fArr = GLConstants.TEXTURE_COORDS_NO_ROTATION;
        float[] fArr2 = new float[fArr.length];
        initTextureCoordsBuffer(fArr2, kVar, z11, z12);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr2).position(0);
        return asFloatBuffer;
    }

    public static void deleteFrameBuffer(int i11) {
        if (i11 != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i11}, 0);
        }
    }

    public static void deleteShaderId(int i11) {
        if (i11 != -1) {
            GLES20.glDeleteShader(i11);
        }
    }

    public static void deleteTexture(int i11) {
        if (i11 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i11}, 0);
        }
    }

    public static void detachTextureFromFrameBuffer(int i11) {
        GLES20.glBindFramebuffer(36160, i11);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private static float flip(float f11) {
        return f11 == 0.0f ? 1.0f : 0.0f;
    }

    public static int generateFrameBufferId() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        return iArr[0];
    }

    public static int generateTextureOES() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public static Object getCurrentContext() {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
            return EGL14.eglGetCurrentContext();
        }
        return ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
    }

    public static long getGLContextNativeHandle(Object obj) {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 17 || !(obj instanceof android.opengl.EGLContext)) {
            return 0;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
            return ((android.opengl.EGLContext) obj).getNativeHandle();
        }
        return (long) ((android.opengl.EGLContext) obj).getHandle();
    }

    public static int getGLErrorCount() {
        int i11 = 0;
        while (GLES20.glGetError() != 0) {
            i11++;
        }
        return i11;
    }

    public static void glViewport(int i11, int i12, int i13, int i14) {
        GLES20.glViewport(i11, i12, i13, i14);
    }

    public static void initTextureCoordsBuffer(float[] fArr, k kVar, boolean z11, boolean z12) {
        float[] fArr2 = GLConstants.TEXTURE_COORDS_NO_ROTATION;
        if (kVar != null) {
            int i11 = AnonymousClass1.f50870a[kVar.ordinal()];
            if (i11 == 1) {
                fArr2 = GLConstants.TEXTURE_COORDS_ROTATE_RIGHT;
            } else if (i11 == 2) {
                fArr2 = GLConstants.TEXTURE_COORDS_ROTATED_180;
            } else if (i11 == 3) {
                fArr2 = GLConstants.TEXTURE_COORDS_ROTATE_LEFT;
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

    public static boolean isNoGLContext(Object obj) {
        if (obj instanceof EGLContext) {
            return obj.equals(EGL10.EGL_NO_CONTEXT);
        }
        if (!(obj instanceof android.opengl.EGLContext) || getGLContextNativeHandle(obj) != 0) {
            return false;
        }
        return true;
    }

    public static int loadTexture(Bitmap bitmap, int i11, boolean z11) {
        int[] iArr = new int[1];
        if (i11 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            LiteavLog.d(TAG, "glGenTextures textureId: " + iArr[0]);
            bindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            bindTexture(3553, i11);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i11;
        }
        if (z11) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static void loadYuv420DataToTextures(ByteBuffer byteBuffer, int i11, int i12, int i13, int[] iArr) {
        if (byteBuffer.isDirect()) {
            nativeLoadYuv420ByteBufferToTextures(byteBuffer, i11, i12, i13, iArr);
        } else {
            nativeLoadYuv420ByteArrayToTextures(byteBuffer.array(), i11, i12, i13, iArr);
        }
    }

    private static native boolean nativeConvertYuvFormatArrayToArray(int i11, byte[] bArr, int i12, byte[] bArr2, int i13, int i14);

    private static native boolean nativeConvertYuvFormatArrayToBuffer(int i11, byte[] bArr, int i12, ByteBuffer byteBuffer, int i13, int i14);

    private static native boolean nativeConvertYuvFormatBufferToArray(int i11, ByteBuffer byteBuffer, int i12, byte[] bArr, int i13, int i14);

    private static native boolean nativeConvertYuvFormatBufferToBuffer(int i11, ByteBuffer byteBuffer, int i12, ByteBuffer byteBuffer2, int i13, int i14);

    public static native void nativeCopyDataFromByteArrayToByteBuffer(byte[] bArr, ByteBuffer byteBuffer, int i11);

    public static native void nativeCopyDataFromByteBufferToByteArray(ByteBuffer byteBuffer, byte[] bArr, int i11);

    public static native void nativeCopyDataFromByteBufferToByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i11);

    public static native void nativeCopyYuvFromByteBufferToByteBuffer(ByteBuffer byteBuffer, int i11, ByteBuffer byteBuffer2, int i12, int i13, int i14, int i15);

    private static native void nativeLoadYuv420ByteArrayToTextures(byte[] bArr, int i11, int i12, int i13, int[] iArr);

    private static native void nativeLoadYuv420ByteBufferToTextures(ByteBuffer byteBuffer, int i11, int i12, int i13, int[] iArr);

    public static void readPixels(int i11, int i12, int i13, int i14, Object obj) {
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            buffer.position(0);
            GLES20.glReadPixels(i11, i12, i13, i14, 6408, 5121, buffer);
        } else if (obj instanceof byte[]) {
            GLES20.glReadPixels(i11, i12, i13, i14, 6408, 5121, ByteBuffer.wrap((byte[]) obj));
        } else {
            LiteavLog.e(TAG, "read pixels failed due to unsupport object. ".concat(String.valueOf(obj)));
        }
    }

    public static Point reverseMappingPoint(GLConstants.GLScaleType gLScaleType, k kVar, Point point, Size size, Size size2) {
        float f11 = (((float) size2.width) * 1.0f) / ((float) size.width);
        float f12 = (((float) size2.height) * 1.0f) / ((float) size.height);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (-size.width)) / 2.0f, ((float) (-size.height)) / 2.0f);
        if (gLScaleType == GLConstants.GLScaleType.CENTER_CROP) {
            float min = Math.min(f11, f12);
            matrix.postScale(min, min);
        } else if (gLScaleType == GLConstants.GLScaleType.FILL) {
            matrix.postScale(f11, f12);
        } else if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
            float max = Math.max(f11, f12);
            matrix.postScale(max, max);
        }
        matrix.postRotate((float) (360 - kVar.mValue));
        if (kVar == k.ROTATION_90 || kVar == k.ROTATION_270) {
            matrix.postTranslate(((float) size2.height) / 2.0f, ((float) size2.width) / 2.0f);
        } else {
            matrix.postTranslate(((float) size2.width) / 2.0f, ((float) size2.height) / 2.0f);
        }
        float[] fArr = new float[2];
        matrix.mapPoints(fArr, new float[]{(float) point.x, (float) point.y});
        return new Point((int) fArr[0], (int) fArr[1]);
    }

    public static int loadTexture(int i11, Buffer buffer, int i12, int i13, int i14) {
        int i15 = i14;
        int[] iArr = new int[1];
        if (i15 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            LiteavLog.d(TAG, "glGenTextures textureId: " + iArr[0]);
            bindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, i11, i12, i13, 0, i11, 5121, buffer);
        } else {
            bindTexture(3553, i15);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, i12, i13, i11, 5121, buffer);
            iArr[0] = i15;
        }
        return iArr[0];
    }
}
