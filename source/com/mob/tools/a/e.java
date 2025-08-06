package com.mob.tools.a;

import com.mob.commons.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class e implements a {
    public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Throwable {
        Method method = (Method) Class.class.getDeclaredMethod(m.a("017EchJdgRdjKdaeb'bhJdDbafa8dgf:biba"), new Class[]{String.class, Class[].class}).invoke(cls, new Object[]{str, clsArr});
        method.setAccessible(true);
        return method.invoke(obj, objArr);
    }

    public <T> T a(String str, Object obj, String str2, Class[] clsArr, Object[] objArr) throws Throwable {
        return a((Class) Class.class.getDeclaredMethod(m.a("007(cdbibhceZbTbdJd"), new Class[]{String.class}).invoke((Object) null, new Object[]{str}), obj, str2, clsArr, objArr);
    }

    public <T> T a(String str) throws Throwable {
        Method declaredMethod = Class.class.getDeclaredMethod(m.a("007LcdbibhceXb+bd8d"), new Class[]{String.class});
        Object[] objArr = {str};
        return Class.class.getDeclaredMethod(m.a("011cdKdeccAc;dgGgbcad"), new Class[0]).invoke((Class) declaredMethod.invoke((Object) null, objArr), new Object[0]);
    }

    public <T> T a(String str, String str2, Object obj) throws Throwable {
        Class<String> cls = String.class;
        Method declaredMethod = Class.class.getDeclaredMethod(m.a("016Zch3dg8dj=daeb_bh8dEbaeabg+de*ba"), new Class[]{cls});
        Object[] objArr = {str2};
        Field field = (Field) declaredMethod.invoke((Class) Class.class.getDeclaredMethod(m.a("007Ecdbibhce'b?bdHd"), new Class[]{cls}).invoke((Object) null, new Object[]{str}), objArr);
        field.setAccessible(true);
        return field.get(obj);
    }

    public <T> T a(String str, Class[] clsArr, Object[] objArr) throws Throwable {
        if (clsArr == null || clsArr.length == 0 || objArr == null || objArr.length == 0) {
            return a(str);
        }
        Method declaredMethod = Class.class.getDeclaredMethod(m.a("022>chIdg$djHdaebDbhXd(bacbbi.c]dgRgEbhbe+ag@bibh"), new Class[]{Class[].class});
        Object[] objArr2 = {clsArr};
        Constructor constructor = (Constructor) declaredMethod.invoke((Class) Class.class.getDeclaredMethod(m.a("007;cdbibhceYbJbd>d"), new Class[]{String.class}).invoke((Object) null, new Object[]{str}), objArr2);
        constructor.setAccessible(true);
        return constructor.newInstance(objArr);
    }
}
