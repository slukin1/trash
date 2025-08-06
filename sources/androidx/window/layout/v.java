package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\fH\u0003R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/window/layout/v;", "Landroidx/window/layout/u;", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/t;", "a", "Landroid/graphics/Rect;", "e", "(Landroid/app/Activity;)Landroid/graphics/Rect;", "d", "c", "b", "Landroid/view/Display;", "display", "Landroid/graphics/Point;", "h", "(Landroid/view/Display;)Landroid/graphics/Point;", "bounds", "", "i", "Landroid/content/Context;", "context", "", "g", "Landroid/view/DisplayCutout;", "f", "", "Ljava/lang/String;", "TAG", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class v implements u {

    /* renamed from: a  reason: collision with root package name */
    public static final v f12159a = new v();

    /* renamed from: b  reason: collision with root package name */
    public static final String f12160b = v.class.getSimpleName();

    public t a(Activity activity) {
        Rect rect;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            rect = b.f12106a.a(activity);
        } else if (i11 >= 29) {
            rect = e(activity);
        } else if (i11 >= 28) {
            rect = d(activity);
        } else if (i11 >= 24) {
            rect = c(activity);
        } else {
            rect = b(activity);
        }
        return new t(rect);
    }

    public final Rect b(Activity activity) {
        int i11;
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point h11 = h(defaultDisplay);
        Rect rect = new Rect();
        int i12 = h11.x;
        if (i12 == 0 || (i11 = h11.y) == 0) {
            defaultDisplay.getRectSize(rect);
        } else {
            rect.right = i12;
            rect.bottom = i11;
        }
        return rect;
    }

    public final Rect c(Activity activity) {
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!a.f12105a.a(activity)) {
            Point h11 = h(defaultDisplay);
            int g11 = g(activity);
            int i11 = rect.bottom;
            if (i11 + g11 == h11.y) {
                rect.bottom = i11 + g11;
            } else {
                int i12 = rect.right;
                if (i12 + g11 == h11.x) {
                    rect.right = i12 + g11;
                }
            }
        }
        return rect;
    }

    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    public final Rect d(Activity activity) {
        DisplayCutout f11;
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (a.f12105a.a(activity)) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
                if (invoke != null) {
                    rect.set((Rect) invoke);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(obj, new Object[0]);
                if (invoke2 != null) {
                    rect.set((Rect) invoke2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
            }
        } catch (NoSuchFieldException e11) {
            Log.w(f12160b, e11);
            i(activity, rect);
        } catch (NoSuchMethodException e12) {
            Log.w(f12160b, e12);
            i(activity, rect);
        } catch (IllegalAccessException e13) {
            Log.w(f12160b, e13);
            i(activity, rect);
        } catch (InvocationTargetException e14) {
            Log.w(f12160b, e14);
            i(activity, rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        c.f12107a.a(defaultDisplay, point);
        a aVar = a.f12105a;
        if (!aVar.a(activity)) {
            int g11 = g(activity);
            int i11 = rect.bottom;
            if (i11 + g11 == point.y) {
                rect.bottom = i11 + g11;
            } else {
                int i12 = rect.right;
                if (i12 + g11 == point.x) {
                    rect.right = i12 + g11;
                } else if (rect.left == g11) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !aVar.a(activity) && (f11 = f(defaultDisplay)) != null) {
            int i13 = rect.left;
            d dVar = d.f12108a;
            if (i13 == dVar.b(f11)) {
                rect.left = 0;
            }
            if (point.x - rect.right == dVar.c(f11)) {
                rect.right += dVar.c(f11);
            }
            if (rect.top == dVar.d(f11)) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == dVar.a(f11)) {
                rect.bottom += dVar.a(f11);
            }
        }
        return rect;
    }

    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    public final Rect e(Activity activity) {
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object invoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
            if (invoke != null) {
                return new Rect((Rect) invoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
        } catch (NoSuchFieldException e11) {
            Log.w(f12160b, e11);
            return d(activity);
        } catch (NoSuchMethodException e12) {
            Log.w(f12160b, e12);
            return d(activity);
        } catch (IllegalAccessException e13) {
            Log.w(f12160b, e13);
            return d(activity);
        } catch (InvocationTargetException e14) {
            Log.w(f12160b, e14);
            return d(activity);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public final DisplayCutout f(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(new Class[0]);
            constructor.setAccessible(true);
            Object newInstance = constructor.newInstance(new Object[0]);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{newInstance.getClass()});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, new Object[]{newInstance});
            Field declaredField = newInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(newInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
        } catch (ClassNotFoundException e11) {
            Log.w(f12160b, e11);
        } catch (NoSuchMethodException e12) {
            Log.w(f12160b, e12);
        } catch (NoSuchFieldException e13) {
            Log.w(f12160b, e13);
        } catch (IllegalAccessException e14) {
            Log.w(f12160b, e14);
        } catch (InvocationTargetException e15) {
            Log.w(f12160b, e15);
        } catch (InstantiationException e16) {
            Log.w(f12160b, e16);
        }
        return null;
    }

    public final int g(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final Point h(Display display) {
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            c.f12107a.a(display, point);
        } else {
            try {
                Method declaredMethod = Display.class.getDeclaredMethod("getRealSize", new Class[]{Point.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(display, new Object[]{point});
            } catch (NoSuchMethodException e11) {
                Log.w(f12160b, e11);
            } catch (IllegalAccessException e12) {
                Log.w(f12160b, e12);
            } catch (InvocationTargetException e13) {
                Log.w(f12160b, e13);
            }
        }
        return point;
    }

    public final void i(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }
}
