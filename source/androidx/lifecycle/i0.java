package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.x;

public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<Class<?>> f10011a;

    /* renamed from: b  reason: collision with root package name */
    public static final List<Class<?>> f10012b;

    static {
        Class<SavedStateHandle> cls = SavedStateHandle.class;
        f10011a = CollectionsKt__CollectionsKt.n(Application.class, cls);
        f10012b = CollectionsKt__CollectionsJVMKt.e(cls);
    }

    public static final <T> Constructor<T> c(Class<T> cls, List<? extends Class<?>> list) {
        Constructor<T>[] constructors = cls.getConstructors();
        int length = constructors.length;
        int i11 = 0;
        while (i11 < length) {
            Constructor<T> constructor = constructors[i11];
            List x02 = ArraysKt___ArraysKt.x0(constructor.getParameterTypes());
            if (x.b(list, x02)) {
                return constructor;
            }
            if (list.size() != x02.size() || !x02.containsAll(list)) {
                i11++;
            } else {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T d(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        try {
            return (ViewModel) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Failed to access " + cls, e11);
        } catch (InstantiationException e12) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e13.getCause());
        }
    }
}
