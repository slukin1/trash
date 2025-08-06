package cn.sharesdk.loopshare.utils;

import java.lang.reflect.InvocationTargetException;

public class h {
    public static boolean a(String str) {
        try {
            Class<?> cls = Class.forName("com.youzu.yad.YAD");
            Object a11 = a();
            cls.getMethod("ulinkclickEvent", new Class[]{String.class, a11.getClass()}).invoke((Object) null, new Object[]{str, a11});
            return true;
        } catch (ClassNotFoundException e11) {
            MobLinkLog.getInstance().d(e11);
            return false;
        } catch (IllegalAccessException e12) {
            MobLinkLog.getInstance().e((Throwable) e12);
            return false;
        } catch (NoSuchMethodException e13) {
            MobLinkLog.getInstance().e((Throwable) e13);
            return false;
        } catch (InvocationTargetException e14) {
            MobLinkLog.getInstance().e((Throwable) e14);
            return false;
        } catch (IllegalArgumentException e15) {
            MobLinkLog.getInstance().e((Throwable) e15);
            return false;
        }
    }

    private static Object a() {
        return new Object();
    }
}
