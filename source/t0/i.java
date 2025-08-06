package t0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.a;
import androidx.core.provider.FontsContractCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

public class i extends j {

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?> f16529b;

    /* renamed from: c  reason: collision with root package name */
    public static final Constructor<?> f16530c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f16531d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f16532e;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e11) {
            Log.e("TypefaceCompatApi24Impl", e11.getClass().getName(), e11);
            cls = null;
            method2 = null;
            method = null;
        }
        f16530c = constructor;
        f16529b = cls;
        f16531d = method;
        f16532e = method2;
    }

    public static boolean l(Object obj, ByteBuffer byteBuffer, int i11, int i12, boolean z11) {
        try {
            return ((Boolean) f16531d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i11), null, Integer.valueOf(i12), Boolean.valueOf(z11)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface m(Object obj) {
        try {
            Object newInstance = Array.newInstance(f16529b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f16532e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean n() {
        Method method = f16531d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    public static Object o() {
        try {
            return f16530c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Typeface b(Context context, a.c cVar, Resources resources, int i11) {
        Object o11 = o();
        if (o11 == null) {
            return null;
        }
        for (a.d dVar : cVar.a()) {
            ByteBuffer b11 = k.b(context, resources, dVar.b());
            if (b11 == null || !l(o11, b11, dVar.c(), dVar.e(), dVar.f())) {
                return null;
            }
        }
        return m(o11);
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.b[] bVarArr, int i11) {
        Object o11 = o();
        if (o11 == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat.b bVar : bVarArr) {
            Uri d11 = bVar.d();
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(d11);
            if (byteBuffer == null) {
                byteBuffer = k.f(context, cancellationSignal, d11);
                simpleArrayMap.put(d11, byteBuffer);
            }
            if (byteBuffer == null || !l(o11, byteBuffer, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface m11 = m(o11);
        if (m11 == null) {
            return null;
        }
        return Typeface.create(m11, i11);
    }
}
