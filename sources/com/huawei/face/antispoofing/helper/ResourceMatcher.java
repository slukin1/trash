package com.huawei.face.antispoofing.helper;

import a.a;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.face.antispoofing.R;
import com.huawei.face.antispoofing.utils.LogFace;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ResourceMatcher {
    public static final String LOCALE = "zh";
    public static final String PREFIX = "HW_SDK_";

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f37555a = new HashMap();

    private ResourceMatcher() {
    }

    public static Map<String, String> getMatchLocaleMap() {
        if (f37555a.isEmpty()) {
            LogFace.e("ResourceMatcher", "[getMatchLocaleMap] call readLocale() at least once firstly.");
        }
        return f37555a;
    }

    public static void readLocale(Activity activity, String str) {
        Locale locale;
        Class<R.string> cls = R.string.class;
        if (f37555a.isEmpty()) {
            StringBuilder c11 = a.c("[readLocale] default language: ");
            c11.append(Locale.getDefault().getLanguage());
            LogFace.i("ResourceMatcher", c11.toString());
            if (TextUtils.isEmpty(str)) {
                locale = new Locale("zh");
            } else {
                locale = new Locale(str);
            }
            Resources resources = activity.getResources();
            Configuration configuration = resources.getConfiguration();
            configuration.setLocale(locale);
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            int i11 = 0;
            for (Field field : cls.getFields()) {
                if (field.getName().startsWith(PREFIX)) {
                    try {
                        i11 = field.getInt(cls);
                    } catch (IllegalArgumentException e11) {
                        LogFace.e("ResourceMatcher", "[readLocale] IllegalArgumentException:", e11);
                    } catch (IllegalAccessException e12) {
                        LogFace.e("ResourceMatcher", "[readLocale] IllegalAccessException:", e12);
                    }
                    f37555a.put(field.getName(), resources.getString(i11));
                }
            }
        }
    }
}
