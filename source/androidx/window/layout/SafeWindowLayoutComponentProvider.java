package androidx.window.layout;

import android.os.Build;
import androidx.window.extensions.layout.WindowLayoutComponent;
import c10.a;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.i;
import kotlin.reflect.c;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u0004*\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u0004*\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002J \u0010\u0014\u001a\u0012\u0012\u0002\b\u0003 \u0013*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0015\u001a\u0012\u0012\u0002\b\u0003 \u0013*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0016\u001a\u0012\u0012\u0002\b\u0003 \u0013*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0017\u001a\u0012\u0012\u0002\b\u0003 \u0013*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00188FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u00020\u0004*\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Landroidx/window/layout/SafeWindowLayoutComponentProvider;", "", "Ljava/lang/ClassLoader;", "classLoader", "", "i", "r", "p", "n", "q", "Lkotlin/Function0;", "block", "s", "Ljava/lang/reflect/Method;", "Lkotlin/reflect/c;", "clazz", "k", "Ljava/lang/Class;", "j", "kotlin.jvm.PlatformType", "u", "t", "l", "v", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "b", "Lkotlin/i;", "m", "()Landroidx/window/extensions/layout/WindowLayoutComponent;", "windowLayoutComponent", "o", "(Ljava/lang/reflect/Method;)Z", "isPublic", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class SafeWindowLayoutComponentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final SafeWindowLayoutComponentProvider f12078a = new SafeWindowLayoutComponentProvider();

    /* renamed from: b  reason: collision with root package name */
    public static final i f12079b = LazyKt__LazyJVMKt.a(SafeWindowLayoutComponentProvider$windowLayoutComponent$2.INSTANCE);

    public final boolean i(ClassLoader classLoader) {
        if (Build.VERSION.SDK_INT < 24 || !r(classLoader) || !p(classLoader) || !q(classLoader) || !n(classLoader)) {
            return false;
        }
        return true;
    }

    public final boolean j(Method method, Class<?> cls) {
        return method.getReturnType().equals(cls);
    }

    public final boolean k(Method method, c<?> cVar) {
        return j(method, a.a(cVar));
    }

    public final Class<?> l(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    public final WindowLayoutComponent m() {
        return (WindowLayoutComponent) f12079b.getValue();
    }

    public final boolean n(ClassLoader classLoader) {
        return s(new SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(classLoader));
    }

    public final boolean o(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    public final boolean p(ClassLoader classLoader) {
        return s(new SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1(classLoader));
    }

    public final boolean q(ClassLoader classLoader) {
        return s(new SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1(classLoader));
    }

    public final boolean r(ClassLoader classLoader) {
        return s(new SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1(classLoader));
    }

    public final boolean s(d10.a<Boolean> aVar) {
        try {
            return aVar.invoke().booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    public final Class<?> t(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensions");
    }

    public final Class<?> u(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    public final Class<?> v(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }
}
