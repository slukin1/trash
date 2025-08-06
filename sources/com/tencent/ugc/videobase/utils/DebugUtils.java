package com.tencent.ugc.videobase.utils;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.videobase.frame.GLTexture;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DebugUtils {
    private static final String TAG = "DebugUtils";

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String dump(float[] fArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        for (float append : fArr) {
            sb2.append(append);
            sb2.append(", ");
        }
        sb2.append(']');
        return sb2.toString();
    }

    public static String getStack(boolean z11) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length < 4) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 1; i11 < stackTrace.length; i11++) {
            sb2.append("[");
            sb2.append(stackTrace[i11].getClassName());
            sb2.append(":");
            sb2.append(stackTrace[i11].getMethodName());
            if (z11) {
                sb2.append("(");
                sb2.append(stackTrace[i11].getLineNumber());
                sb2.append(")]\n");
            } else {
                sb2.append("]\n");
            }
        }
        return sb2.toString();
    }

    public static String getStackAsComment() {
        String[] split = getStack(true).split("\n");
        StringBuilder sb2 = new StringBuilder();
        for (String append : split) {
            sb2.append("// ");
            sb2.append(append);
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public static boolean saveBmpToFile(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null || file == null) {
            LiteavLog.e(TAG, "bmp or file is null");
            return false;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return writeToFile(byteArrayOutputStream.toByteArray(), file);
    }

    public static void saveImage(File file, GLTexture gLTexture, int i11, int i12) {
        OpenGlUtils.generateFrameBufferId();
        saveImage(file, gLTexture.getId(), i11, i12);
    }

    public static boolean writeToFile(byte[] bArr, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                closeQuietly(fileOutputStream2);
                return true;
            } catch (IOException unused) {
                fileOutputStream = fileOutputStream2;
                closeQuietly(fileOutputStream);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException unused2) {
            closeQuietly(fileOutputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public static void saveImage(File file, int i11, int i12, int i13) {
        int generateFrameBufferId = OpenGlUtils.generateFrameBufferId();
        OpenGlUtils.attachTextureToFrameBuffer(i11, generateFrameBufferId);
        OpenGlUtils.bindFramebuffer(36160, generateFrameBufferId);
        ByteBuffer order = ByteBuffer.allocateDirect(i12 * i13 * 4).order(ByteOrder.nativeOrder());
        GLES20.glReadPixels(0, 0, i12, i13, 6408, 5121, order);
        Bitmap createBitmap = Bitmap.createBitmap(i12, i13, Bitmap.Config.ARGB_8888);
        order.position(0);
        createBitmap.copyPixelsFromBuffer(order);
        saveBmpToFile(createBitmap, file, Bitmap.CompressFormat.PNG);
        OpenGlUtils.bindFramebuffer(36160, 0);
        OpenGlUtils.detachTextureFromFrameBuffer(generateFrameBufferId);
        OpenGlUtils.deleteFrameBuffer(generateFrameBufferId);
    }
}
