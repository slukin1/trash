package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.core.util.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ImageWriterCompatApi26Impl {
    private static final String TAG = "ImageWriterCompatApi26";
    private static Method sNewInstanceMethod;

    static {
        Class<ImageWriter> cls = ImageWriter.class;
        try {
            Class cls2 = Integer.TYPE;
            sNewInstanceMethod = cls.getMethod("newInstance", new Class[]{Surface.class, cls2, cls2});
        } catch (NoSuchMethodException e11) {
            Log.i(TAG, "Unable to initialize via reflection.", e11);
        }
    }

    private ImageWriterCompatApi26Impl() {
    }

    public static ImageWriter newInstance(Surface surface, int i11, int i12) {
        Throwable th2 = null;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return (ImageWriter) h.g(sNewInstanceMethod.invoke((Object) null, new Object[]{surface, Integer.valueOf(i11), Integer.valueOf(i12)}));
            } catch (IllegalAccessException | InvocationTargetException e11) {
                th2 = e11;
            }
        }
        throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", th2);
    }
}
