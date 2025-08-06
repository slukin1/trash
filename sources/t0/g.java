package t0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.a;
import androidx.core.graphics.TypefaceCompatApi26Impl;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import androidx.core.graphics.TypefaceCompatApi29Impl;
import androidx.core.provider.FontsContractCompat;
import i0.b;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f16521a;

    /* renamed from: b  reason: collision with root package name */
    public static final b<String, Typeface> f16522b = new b<>(16);

    public static class a extends FontsContractCompat.FontRequestCallback {

        /* renamed from: a  reason: collision with root package name */
        public ResourcesCompat.FontCallback f16523a;

        public a(ResourcesCompat.FontCallback fontCallback) {
            this.f16523a = fontCallback;
        }

        public void a(int i11) {
            ResourcesCompat.FontCallback fontCallback = this.f16523a;
            if (fontCallback != null) {
                fontCallback.lambda$callbackFailAsync$1(i11);
            }
        }

        public void b(Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.f16523a;
            if (fontCallback != null) {
                fontCallback.lambda$callbackSuccessAsync$0(typeface);
            }
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            f16521a = new TypefaceCompatApi29Impl();
        } else if (i11 >= 28) {
            f16521a = new TypefaceCompatApi28Impl();
        } else if (i11 >= 26) {
            f16521a = new TypefaceCompatApi26Impl();
        } else if (i11 >= 24 && i.n()) {
            f16521a = new i();
        } else if (i11 >= 21) {
            f16521a = new h();
        } else {
            f16521a = new j();
        }
    }

    public static Typeface a(Context context, Typeface typeface, int i11) {
        Typeface g11;
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (Build.VERSION.SDK_INT >= 21 || (g11 = g(context, typeface, i11)) == null) {
            return Typeface.create(typeface, i11);
        } else {
            return g11;
        }
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, FontsContractCompat.b[] bVarArr, int i11) {
        return f16521a.c(context, cancellationSignal, bVarArr, i11);
    }

    public static Typeface c(Context context, a.b bVar, Resources resources, int i11, String str, int i12, int i13, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z11) {
        Typeface typeface;
        a.b bVar2 = bVar;
        ResourcesCompat.FontCallback fontCallback2 = fontCallback;
        Handler handler2 = handler;
        if (bVar2 instanceof a.e) {
            a.e eVar = (a.e) bVar2;
            Typeface h11 = h(eVar.c());
            if (h11 != null) {
                if (fontCallback2 != null) {
                    fontCallback2.callbackSuccessAsync(h11, handler2);
                }
                return h11;
            }
            typeface = FontsContractCompat.c(context, eVar.b(), i13, !z11 ? fontCallback2 == null : eVar.a() == 0, z11 ? eVar.d() : -1, ResourcesCompat.FontCallback.getHandler(handler), new a(fontCallback2));
            Resources resources2 = resources;
            int i14 = i13;
        } else {
            Context context2 = context;
            Resources resources3 = resources;
            typeface = f16521a.b(context, (a.c) bVar2, resources, i13);
            if (fontCallback2 != null) {
                if (typeface != null) {
                    fontCallback2.callbackSuccessAsync(typeface, handler2);
                } else {
                    fontCallback2.callbackFailAsync(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            f16522b.put(e(resources, i11, str, i12, i13), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources, int i11, String str, int i12, int i13) {
        Typeface e11 = f16521a.e(context, resources, i11, str, i13);
        if (e11 != null) {
            f16522b.put(e(resources, i11, str, i12, i13), e11);
        }
        return e11;
    }

    public static String e(Resources resources, int i11, String str, int i12, int i13) {
        return resources.getResourcePackageName(i11) + '-' + str + '-' + i12 + '-' + i11 + '-' + i13;
    }

    public static Typeface f(Resources resources, int i11, String str, int i12, int i13) {
        return f16522b.get(e(resources, i11, str, i12, i13));
    }

    public static Typeface g(Context context, Typeface typeface, int i11) {
        j jVar = f16521a;
        a.c j11 = jVar.j(typeface);
        if (j11 == null) {
            return null;
        }
        return jVar.b(context, j11, context.getResources(), i11);
    }

    public static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
