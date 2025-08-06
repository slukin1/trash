package mz;

import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import com.zendesk.logger.Logger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f58286a = "c";

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f58287b = Arrays.asList(new String[]{"he", "yi", "id"});

    public static Locale a(String str, String str2) {
        Class<String> cls = String.class;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                Constructor<Locale> declaredConstructor = Locale.class.getDeclaredConstructor(new Class[]{Boolean.TYPE, cls, cls});
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[]{Boolean.TRUE, str, str2});
            }
            Constructor<Locale> declaredConstructor2 = Locale.class.getDeclaredConstructor(new Class[0]);
            declaredConstructor2.setAccessible(true);
            Locale newInstance = declaredConstructor2.newInstance(new Object[0]);
            Class<?> cls2 = newInstance.getClass();
            Field declaredField = cls2.getDeclaredField("languageCode");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, str);
            Field declaredField2 = cls2.getDeclaredField("countryCode");
            declaredField2.setAccessible(true);
            declaredField2.set(newInstance, str2);
            return newInstance;
        } catch (Exception e11) {
            Logger.c(f58286a, "Unable to create ISO-6390-Alpha3 per reflection", e11, new Object[0]);
            return null;
        }
    }

    public static Locale b(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Method declaredMethod = Locale.class.getDeclaredMethod("createConstant", new Class[]{cls, cls});
            declaredMethod.setAccessible(true);
            return (Locale) declaredMethod.invoke((Object) null, new Object[]{str, str2});
        } catch (Exception e11) {
            Logger.c(f58286a, "Unable to create ISO-6390-Alpha3 per reflection", e11, new Object[0]);
            return null;
        }
    }

    public static Locale c(String str) {
        Locale locale;
        String str2 = f58286a;
        Logger.b(str2, "Assuming Locale.getDefault()", new Object[0]);
        Locale locale2 = Locale.getDefault();
        if (!f.c(str)) {
            return locale2;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        int countTokens = stringTokenizer.countTokens();
        int i11 = 2;
        if (countTokens == 1 || countTokens == 2) {
            if (countTokens != 1) {
                i11 = 5;
            }
            if (i11 != str.length()) {
                Logger.b(str2, "number of tokens is correct but the length of the locale string does not match the expected length", new Object[0]);
                return locale2;
            }
            String nextToken = stringTokenizer.nextToken();
            String upperCase = (stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : "").toUpperCase(Locale.US);
            if (f58287b.contains(nextToken)) {
                Logger.b(str2, "New ISO-6390-Alpha3 locale detected trying to create new locale per reflection", new Object[0]);
                locale = b(nextToken, upperCase);
                if (locale == null) {
                    locale = a(nextToken, upperCase);
                }
                if (locale == null) {
                    locale = new Locale(nextToken, upperCase);
                }
            } else {
                locale = new Locale(nextToken, upperCase);
            }
            return locale;
        }
        Logger.l(str2, "Unexpected number of tokens, must be at least one and at most two", new Object[0]);
        return locale2;
    }

    public static String d(Locale locale) {
        if (locale == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(locale.getLanguage());
        if (f.c(locale.getCountry())) {
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb2.append(locale.getCountry().toLowerCase(Locale.US));
        }
        return sb2.toString();
    }
}
