package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static Field f3935a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3936b;

    /* renamed from: c  reason: collision with root package name */
    public static Class<?> f3937c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f3938d;

    /* renamed from: e  reason: collision with root package name */
    public static Field f3939e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f3940f;

    /* renamed from: g  reason: collision with root package name */
    public static Field f3941g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f3942h;

    public static class a {
        public static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    public static void a(Resources resources) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 28) {
            if (i11 >= 24) {
                d(resources);
            } else if (i11 >= 23) {
                c(resources);
            } else if (i11 >= 21) {
                b(resources);
            }
        }
    }

    public static void b(Resources resources) {
        if (!f3936b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f3935a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e11);
            }
            f3936b = true;
        }
        Field field = f3935a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e12) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e12);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    public static void c(Resources resources) {
        if (!f3936b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f3935a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e11);
            }
            f3936b = true;
        }
        Object obj = null;
        Field field = f3935a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e12) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e12);
            }
        }
        if (obj != null) {
            e(obj);
        }
    }

    public static void d(Resources resources) {
        Object obj;
        if (!f3942h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f3941g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e11);
            }
            f3942h = true;
        }
        Field field = f3941g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e12) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e12);
                obj = null;
            }
            if (obj != null) {
                if (!f3936b) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f3935a = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e13) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e13);
                    }
                    f3936b = true;
                }
                Field field2 = f3935a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e14) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e14);
                    }
                }
                if (obj2 != null) {
                    e(obj2);
                }
            }
        }
    }

    public static void e(Object obj) {
        if (!f3938d) {
            try {
                f3937c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e11) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e11);
            }
            f3938d = true;
        }
        Class<?> cls = f3937c;
        if (cls != null) {
            if (!f3940f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f3939e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e12) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e12);
                }
                f3940f = true;
            }
            Field field = f3939e;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e13) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e13);
                }
                if (longSparseArray != null) {
                    a.a(longSparseArray);
                }
            }
        }
    }
}
