package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ButterKnife {
    public static final Map<Class<?>, Constructor<? extends Unbinder>> BINDINGS = new LinkedHashMap();
    private static final String TAG = "ButterKnife";
    private static boolean debug = false;

    @Deprecated
    public interface Action<T extends View> extends Action<T> {
    }

    @Deprecated
    public interface Setter<T extends View, V> extends Setter<T, V> {
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    @Deprecated
    @SafeVarargs
    public static <T extends View> void apply(List<T> list, Action<? super T>... actionArr) {
        ViewCollections.run(list, (Action<? super T>[]) actionArr);
    }

    public static Unbinder bind(Activity activity) {
        return bind((Object) activity, activity.getWindow().getDecorView());
    }

    private static Constructor<? extends Unbinder> findBindingConstructorForClass(Class<?> cls) {
        Constructor<? extends Unbinder> constructor;
        Map<Class<?>, Constructor<? extends Unbinder>> map = BINDINGS;
        Constructor<? extends Unbinder> constructor2 = map.get(cls);
        if (constructor2 != null || map.containsKey(cls)) {
            if (debug) {
                Log.d(TAG, "HIT: Cached in binding map.");
            }
            return constructor2;
        }
        String name = cls.getName();
        if (!name.startsWith("android.") && !name.startsWith("java.") && !name.startsWith("androidx.")) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                constructor = classLoader.loadClass(name + "_ViewBinding").getConstructor(new Class[]{cls, View.class});
                if (debug) {
                    Log.d(TAG, "HIT: Loaded binding class and constructor.");
                }
            } catch (ClassNotFoundException unused) {
                if (debug) {
                    Log.d(TAG, "Not found. Trying superclass " + cls.getSuperclass().getName());
                }
                constructor = findBindingConstructorForClass(cls.getSuperclass());
            } catch (NoSuchMethodException e11) {
                throw new RuntimeException("Unable to find binding constructor for " + name, e11);
            }
            BINDINGS.put(cls, constructor);
            return constructor;
        } else if (!debug) {
            return null;
        } else {
            Log.d(TAG, "MISS: Reached framework class. Abandoning search.");
            return null;
        }
    }

    public static void setDebug(boolean z11) {
        debug = z11;
    }

    @Deprecated
    @SafeVarargs
    public static <T extends View> void apply(T[] tArr, Action<? super T>... actionArr) {
        ViewCollections.run(tArr, (Action<? super T>[]) actionArr);
    }

    @Deprecated
    public static <T extends View> void apply(List<T> list, Action<? super T> action) {
        ViewCollections.run(list, action);
    }

    public static Unbinder bind(View view) {
        return bind((Object) view, view);
    }

    @Deprecated
    public static <T extends View> void apply(T[] tArr, Action<? super T> action) {
        ViewCollections.run(tArr, action);
    }

    public static Unbinder bind(Dialog dialog) {
        return bind((Object) dialog, dialog.getWindow().getDecorView());
    }

    @Deprecated
    @SafeVarargs
    public static <T extends View> void apply(T t11, Action<? super T>... actionArr) {
        ViewCollections.run(t11, (Action<? super T>[]) actionArr);
    }

    @Deprecated
    public static <T extends View> void apply(T t11, Action<? super T> action) {
        ViewCollections.run(t11, action);
    }

    public static Unbinder bind(Object obj, Activity activity) {
        return bind(obj, activity.getWindow().getDecorView());
    }

    @Deprecated
    public static <T extends View, V> void apply(List<T> list, Setter<? super T, V> setter, V v11) {
        ViewCollections.set(list, setter, v11);
    }

    @Deprecated
    public static <T extends View, V> void apply(T[] tArr, Setter<? super T, V> setter, V v11) {
        ViewCollections.set(tArr, setter, v11);
    }

    public static Unbinder bind(Object obj, Dialog dialog) {
        return bind(obj, dialog.getWindow().getDecorView());
    }

    @Deprecated
    public static <T extends View, V> void apply(T t11, Setter<? super T, V> setter, V v11) {
        ViewCollections.set(t11, setter, v11);
    }

    @Deprecated
    public static <T extends View, V> void apply(List<T> list, Property<? super T, V> property, V v11) {
        ViewCollections.set(list, property, v11);
    }

    public static Unbinder bind(Object obj, View view) {
        Class<?> cls = obj.getClass();
        if (debug) {
            Log.d(TAG, "Looking up binding for " + cls.getName());
        }
        Constructor<? extends Unbinder> findBindingConstructorForClass = findBindingConstructorForClass(cls);
        if (findBindingConstructorForClass == null) {
            return Unbinder.EMPTY;
        }
        try {
            return (Unbinder) findBindingConstructorForClass.newInstance(new Object[]{obj, view});
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Unable to invoke " + findBindingConstructorForClass, e11);
        } catch (InstantiationException e12) {
            throw new RuntimeException("Unable to invoke " + findBindingConstructorForClass, e12);
        } catch (InvocationTargetException e13) {
            Throwable cause = e13.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
        }
    }

    @Deprecated
    public static <T extends View, V> void apply(T[] tArr, Property<? super T, V> property, V v11) {
        ViewCollections.set(tArr, property, v11);
    }

    @Deprecated
    public static <T extends View, V> void apply(T t11, Property<? super T, V> property, V v11) {
        ViewCollections.set(t11, property, v11);
    }
}
