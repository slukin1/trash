package com.alibaba.android.arouter.core;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import b2.a;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.utils.TextUtils;
import java.lang.reflect.Field;

@Deprecated
public class InstrumentationHook extends Instrumentation {
    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        String[] stringArrayExtra;
        Class<?> loadClass = classLoader.loadClass(str);
        Object newInstance = loadClass.newInstance();
        if (a.b() && (stringArrayExtra = intent.getStringArrayExtra("wmHzgD4lOj5o4241")) != null && stringArrayExtra.length > 0) {
            for (String str2 : stringArrayExtra) {
                Object obj = intent.getExtras().get(TextUtils.b(str2));
                if (obj != null) {
                    try {
                        Field declaredField = loadClass.getDeclaredField(TextUtils.b(str2));
                        declaredField.setAccessible(true);
                        declaredField.set(newInstance, obj);
                    } catch (Exception e11) {
                        a.f12290c.error(ILogger.defaultTag, "Inject values for activity error! [" + e11.getMessage() + "]");
                    }
                }
            }
        }
        return (Activity) newInstance;
    }
}
