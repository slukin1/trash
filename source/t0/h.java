package t0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.res.a;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class h extends j {

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f16524b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Constructor<?> f16525c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f16526d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f16527e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f16528f = false;

    public static boolean l(Object obj, String str, int i11, boolean z11) {
        o();
        try {
            return ((Boolean) f16526d.invoke(obj, new Object[]{str, Integer.valueOf(i11), Boolean.valueOf(z11)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static Typeface m(Object obj) {
        o();
        try {
            Object newInstance = Array.newInstance(f16524b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f16527e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static void o() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f16528f) {
            f16528f = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e11) {
                Log.e("TypefaceCompatApi21Impl", e11.getClass().getName(), e11);
                method2 = null;
                cls = null;
                method = null;
            }
            f16525c = constructor;
            f16524b = cls;
            f16526d = method;
            f16527e = method2;
        }
    }

    public static Object p() {
        o();
        try {
            return f16525c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    public Typeface b(Context context, a.c cVar, Resources resources, int i11) {
        Object p11 = p();
        a.d[] a11 = cVar.a();
        int length = a11.length;
        int i12 = 0;
        while (i12 < length) {
            a.d dVar = a11[i12];
            File e11 = k.e(context);
            if (e11 == null) {
                return null;
            }
            try {
                if (!k.c(e11, resources, dVar.b())) {
                    e11.delete();
                    return null;
                } else if (!l(p11, e11.getPath(), dVar.e(), dVar.f())) {
                    return null;
                } else {
                    e11.delete();
                    i12++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e11.delete();
            }
        }
        return m(p11);
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.b[] bVarArr, int i11) {
        FileInputStream fileInputStream;
        if (bVarArr.length < 1) {
            return null;
        }
        FontsContractCompat.b i12 = i(bVarArr, i11);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(i12.d(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File n11 = n(openFileDescriptor);
                if (n11 != null) {
                    if (n11.canRead()) {
                        Typeface createFromFile = Typeface.createFromFile(n11);
                        openFileDescriptor.close();
                        return createFromFile;
                    }
                }
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface d11 = super.d(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return d11;
            } catch (Throwable th2) {
                openFileDescriptor.close();
                throw th2;
            }
        } catch (IOException unused) {
            return null;
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
        throw th;
    }

    public final File n(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }
}
