package androidx.window.layout;

import android.graphics.Rect;
import d10.a;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1 extends Lambda implements a<Boolean> {
    public final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    public final Boolean invoke() {
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.f12078a;
        Class d11 = safeWindowLayoutComponentProvider.l(this.$classLoader);
        boolean z11 = false;
        Method method = d11.getMethod("getBounds", new Class[0]);
        Method method2 = d11.getMethod("getType", new Class[0]);
        Method method3 = d11.getMethod("getState", new Class[0]);
        if (safeWindowLayoutComponentProvider.k(method, Reflection.b(Rect.class)) && safeWindowLayoutComponentProvider.o(method)) {
            Class cls = Integer.TYPE;
            if (safeWindowLayoutComponentProvider.k(method2, Reflection.b(cls)) && safeWindowLayoutComponentProvider.o(method2) && safeWindowLayoutComponentProvider.k(method3, Reflection.b(cls)) && safeWindowLayoutComponentProvider.o(method3)) {
                z11 = true;
            }
        }
        return Boolean.valueOf(z11);
    }
}
