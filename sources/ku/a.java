package ku;

import android.app.Application;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a {
    public static Application a() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
            declaredMethod.setAccessible(true);
            return (Application) declaredMethod.invoke((Object) null, (Object[]) null);
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
            return null;
        } catch (ClassNotFoundException e12) {
            e12.printStackTrace();
            return null;
        } catch (IllegalAccessException e13) {
            e13.printStackTrace();
            return null;
        } catch (InvocationTargetException e14) {
            e14.printStackTrace();
            return null;
        }
    }

    public static Context b() {
        if (iu.a.f().c() != null) {
            return iu.a.f().c();
        }
        return a();
    }

    public static String c(int i11) {
        return b().getString(i11);
    }

    public static String d(int i11, Object... objArr) {
        return b().getString(i11, objArr);
    }
}
