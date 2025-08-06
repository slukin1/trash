package com.dianping.logan;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f64845a = new SimpleDateFormat("yyyy-MM-dd");

    public static long a() {
        try {
            return f64845a.parse(f64845a.format(new Date(System.currentTimeMillis()))).getTime();
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static boolean b(String str, Class cls) {
        Class<String> cls2 = String.class;
        try {
            ClassLoader classLoader = cls.getClassLoader();
            Class<?> cls3 = Runtime.getRuntime().getClass();
            Class[] clsArr = new Class[2];
            if (Build.VERSION.SDK_INT > 24) {
                clsArr[0] = ClassLoader.class;
                clsArr[1] = cls2;
                Method declaredMethod = cls3.getDeclaredMethod("loadLibrary0", clsArr);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(Runtime.getRuntime(), new Object[]{classLoader, str});
            } else {
                clsArr[0] = cls2;
                clsArr[1] = ClassLoader.class;
                Method declaredMethod2 = cls3.getDeclaredMethod("loadLibrary", clsArr);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(Runtime.getRuntime(), new Object[]{str, classLoader});
            }
            return true;
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            return false;
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
            return false;
        } catch (NoSuchMethodException e13) {
            e13.printStackTrace();
            return false;
        }
    }
}
