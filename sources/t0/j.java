package t0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.a;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

public class j {
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Long, a.c> f16533a = new ConcurrentHashMap<>();

    public class a implements c<FontsContractCompat.b> {
        public a() {
        }

        /* renamed from: c */
        public int a(FontsContractCompat.b bVar) {
            return bVar.e();
        }

        /* renamed from: d */
        public boolean b(FontsContractCompat.b bVar) {
            return bVar.f();
        }
    }

    public class b implements c<a.d> {
        public b() {
        }

        /* renamed from: c */
        public int a(a.d dVar) {
            return dVar.e();
        }

        /* renamed from: d */
        public boolean b(a.d dVar) {
            return dVar.f();
        }
    }

    public interface c<T> {
        int a(T t11);

        boolean b(T t11);
    }

    public static <T> T g(T[] tArr, int i11, c<T> cVar) {
        return h(tArr, (i11 & 1) == 0 ? 400 : 700, (i11 & 2) != 0, cVar);
    }

    public static <T> T h(T[] tArr, int i11, boolean z11, c<T> cVar) {
        T t11 = null;
        int i12 = Integer.MAX_VALUE;
        for (T t12 : tArr) {
            int abs = (Math.abs(cVar.a(t12) - i11) * 2) + (cVar.b(t12) == z11 ? 0 : 1);
            if (t11 == null || i12 > abs) {
                t11 = t12;
                i12 = abs;
            }
        }
        return t11;
    }

    public static long k(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e11) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e11);
            return 0;
        } catch (IllegalAccessException e12) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e12);
            return 0;
        }
    }

    public final void a(Typeface typeface, a.c cVar) {
        long k11 = k(typeface);
        if (k11 != 0) {
            this.f16533a.put(Long.valueOf(k11), cVar);
        }
    }

    public Typeface b(Context context, a.c cVar, Resources resources, int i11) {
        a.d f11 = f(cVar, i11);
        if (f11 == null) {
            return null;
        }
        Typeface d11 = g.d(context, resources, f11.b(), f11.a(), 0, i11);
        a(d11, cVar);
        return d11;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.b[] bVarArr, int i11) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(i(bVarArr, i11).d());
            try {
                Typeface d11 = d(context, inputStream);
                k.a(inputStream);
                return d11;
            } catch (IOException unused) {
                k.a(inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                k.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            k.a(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            k.a(inputStream2);
            throw th;
        }
    }

    public Typeface d(Context context, InputStream inputStream) {
        File e11 = k.e(context);
        if (e11 == null) {
            return null;
        }
        try {
            if (!k.d(e11, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e11.getPath());
            e11.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e11.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i11, String str, int i12) {
        File e11 = k.e(context);
        if (e11 == null) {
            return null;
        }
        try {
            if (!k.c(e11, resources, i11)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e11.getPath());
            e11.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e11.delete();
        }
    }

    public final a.d f(a.c cVar, int i11) {
        return (a.d) g(cVar.a(), i11, new b());
    }

    public FontsContractCompat.b i(FontsContractCompat.b[] bVarArr, int i11) {
        return (FontsContractCompat.b) g(bVarArr, i11, new a());
    }

    public a.c j(Typeface typeface) {
        long k11 = k(typeface);
        if (k11 == 0) {
            return null;
        }
        return this.f16533a.get(Long.valueOf(k11));
    }
}
