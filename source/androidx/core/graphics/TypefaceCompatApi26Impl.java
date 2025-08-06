package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.a;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import t0.h;
import t0.k;

public class TypefaceCompatApi26Impl extends h {

    /* renamed from: g  reason: collision with root package name */
    public final Class<?> f8362g;

    /* renamed from: h  reason: collision with root package name */
    public final Constructor<?> f8363h;

    /* renamed from: i  reason: collision with root package name */
    public final Method f8364i;

    /* renamed from: j  reason: collision with root package name */
    public final Method f8365j;

    /* renamed from: k  reason: collision with root package name */
    public final Method f8366k;

    /* renamed from: l  reason: collision with root package name */
    public final Method f8367l;

    /* renamed from: m  reason: collision with root package name */
    public final Method f8368m;

    public TypefaceCompatApi26Impl() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> z11 = z();
            constructor = A(z11);
            method4 = w(z11);
            method3 = x(z11);
            method2 = B(z11);
            method = v(z11);
            Class<?> cls2 = z11;
            method5 = y(z11);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e11) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e11.getClass().getName(), e11);
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f8362g = cls;
        this.f8363h = constructor;
        this.f8364i = method4;
        this.f8365j = method3;
        this.f8366k = method2;
        this.f8367l = method;
        this.f8368m = method5;
    }

    private Object p() {
        try {
            return this.f8363h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Constructor<?> A(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    public Method B(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    public Typeface b(Context context, a.c cVar, Resources resources, int i11) {
        if (!u()) {
            return super.b(context, cVar, resources, i11);
        }
        Object p11 = p();
        if (p11 == null) {
            return null;
        }
        for (a.d dVar : cVar.a()) {
            if (!r(context, p11, dVar.a(), dVar.c(), dVar.e(), dVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d()))) {
                q(p11);
                return null;
            }
        }
        if (!t(p11)) {
            return null;
        }
        return m(p11);
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.b[] bVarArr, int i11) {
        Typeface m11;
        ParcelFileDescriptor openFileDescriptor;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!u()) {
            FontsContractCompat.b i12 = i(bVarArr, i11);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(i12.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(i12.e()).setItalic(i12.f()).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            Map<Uri, ByteBuffer> h11 = k.h(context, bVarArr, cancellationSignal);
            Object p11 = p();
            if (p11 == null) {
                return null;
            }
            boolean z11 = false;
            for (FontsContractCompat.b bVar : bVarArr) {
                ByteBuffer byteBuffer = h11.get(bVar.d());
                if (byteBuffer != null) {
                    if (!s(p11, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                        q(p11);
                        return null;
                    }
                    z11 = true;
                }
            }
            if (!z11) {
                q(p11);
                return null;
            } else if (t(p11) && (m11 = m(p11)) != null) {
                return Typeface.create(m11, i11);
            } else {
                return null;
            }
        }
        throw th;
    }

    public Typeface e(Context context, Resources resources, int i11, String str, int i12) {
        if (!u()) {
            return super.e(context, resources, i11, str, i12);
        }
        Object p11 = p();
        if (p11 == null) {
            return null;
        }
        if (!r(context, p11, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            q(p11);
            return null;
        } else if (!t(p11)) {
            return null;
        } else {
            return m(p11);
        }
    }

    public Typeface m(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f8362g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f8368m.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void q(Object obj) {
        try {
            this.f8367l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean r(Context context, Object obj, String str, int i11, int i12, int i13, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f8364i.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean s(Object obj, ByteBuffer byteBuffer, int i11, int i12, int i13) {
        try {
            return ((Boolean) this.f8365j.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i11), null, Integer.valueOf(i12), Integer.valueOf(i13)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean t(Object obj) {
        try {
            return ((Boolean) this.f8366k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean u() {
        if (this.f8364i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f8364i != null;
    }

    public Method v(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    public Method w(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    public Method x(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    public Method y(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class<?> z() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }
}
