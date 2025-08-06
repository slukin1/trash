package com.tencent.qcloud.tuicore;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.webkit.WebView;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuicore.util.TUIBuild;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TUIThemeManager {
    public static final String LANGUAGE_EN = "en";
    public static final String LANGUAGE_ZH_CN = "zh";
    private static final String SP_KEY_LANGUAGE = "language";
    private static final String SP_KEY_THEME = "theme";
    private static final String SP_THEME_AND_LANGUAGE_NAME = "TUIThemeAndLanguage";
    private static final String TAG = "TUIThemeManager";
    public static final int THEME_LIGHT = 0;
    public static final int THEME_LIVELY = 1;
    public static final int THEME_SERIOUS = 2;
    private static String currentProcessName = "";
    private String currentLanguage;
    private int currentThemeID;
    private Locale defaultLocale;
    private boolean isInit;
    private final Map<String, Locale> languageMap;
    private final Map<Integer, List<Integer>> themeResIDMap;

    public static class ThemeAndLanguageCallback implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
            TUIThemeManager.getInstance().applyTheme(activity);
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static final class ThemeManagerHolder {
        /* access modifiers changed from: private */
        public static final TUIThemeManager instance = new TUIThemeManager();

        private ThemeManagerHolder() {
        }
    }

    public static void addLanguage(String str, Locale locale) {
        String str2 = TAG;
        Log.i(str2, "addLanguage language=" + str + " locale=" + locale);
        getInstance().languageMap.put(str, locale);
    }

    public static void addLightTheme(int i11) {
        addTheme(0, i11);
    }

    public static void addLivelyTheme(int i11) {
        addTheme(1, i11);
    }

    public static void addSeriousTheme(int i11) {
        addTheme(2, i11);
    }

    public static void addTheme(int i11, int i12) {
        if (i12 == 0) {
            Log.e(TAG, "addTheme failed, theme resID is zero");
            return;
        }
        String str = TAG;
        Log.i(str, "addTheme themeID=" + i11 + " resID=" + i12);
        List list = getInstance().themeResIDMap.get(Integer.valueOf(i11));
        if (list == null) {
            list = new ArrayList();
            getInstance().themeResIDMap.put(Integer.valueOf(i11), list);
        }
        if (!list.contains(Integer.valueOf(i12))) {
            list.add(Integer.valueOf(i12));
            getInstance().applyTheme(ServiceInitializer.getAppContext());
        }
    }

    /* access modifiers changed from: private */
    public void applyTheme(Context context) {
        if (context != null) {
            Resources.Theme theme = context.getTheme();
            if (theme == null) {
                context.setTheme(R.style.TUIBaseTheme);
                theme = context.getTheme();
            }
            mergeTheme(theme);
        }
    }

    public static int getAttrResId(Context context, int i11) {
        if (context == null || i11 == 0) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }

    public static TUIThemeManager getInstance() {
        return ThemeManagerHolder.instance;
    }

    public static String getProcessName() {
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            currentProcessName = processName;
            return processName;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            if (invoke instanceof String) {
                currentProcessName = (String) invoke;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return currentProcessName;
    }

    private void mergeTheme(Resources.Theme theme) {
        List<Integer> list;
        if (theme != null && (list = this.themeResIDMap.get(Integer.valueOf(this.currentThemeID))) != null) {
            for (Integer intValue : list) {
                theme.applyStyle(intValue.intValue(), true);
            }
        }
    }

    private void notifySetLanguageEvent() {
        TUICore.notifyEvent("TUIThemeManager", TUIConstants.TUICore.LANGUAGE_EVENT_SUB_KEY, (Map<String, Object>) null);
    }

    public static void setTheme(Context context) {
        getInstance().setThemeInternal(context);
    }

    private void setThemeInternal(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (!this.isInit) {
                this.isInit = true;
                if (applicationContext instanceof Application) {
                    ((Application) applicationContext).registerActivityLifecycleCallbacks(new ThemeAndLanguageCallback());
                }
                notifySetLanguageEvent();
                Locale locale = getLocale(applicationContext);
                SPUtils instance = SPUtils.getInstance(SP_THEME_AND_LANGUAGE_NAME);
                this.currentLanguage = instance.getString(SP_KEY_LANGUAGE, locale.getLanguage());
                this.currentThemeID = instance.getInt(SP_KEY_THEME, 0);
            }
        }
    }

    public static void setWebViewLanguage(Context context) {
        try {
            Log.i(TAG, "setWebViewLanguage");
            if (Build.VERSION.SDK_INT >= 28) {
                WebView.setDataDirectorySuffix(getProcessName());
            }
            new WebView(context).destroy();
        } catch (Throwable th2) {
            Log.e("TUIThemeManager", "init language settings failed, " + th2.getMessage());
        }
    }

    public void changeLanguage(Context context, String str) {
        if (context != null && !TextUtils.equals(str, this.currentLanguage)) {
            this.currentLanguage = str;
            SPUtils.getInstance(SP_THEME_AND_LANGUAGE_NAME).put(SP_KEY_LANGUAGE, str, true);
        }
    }

    public void changeTheme(Context context, int i11) {
        if (context != null && i11 != this.currentThemeID) {
            this.currentThemeID = i11;
            SPUtils.getInstance(SP_THEME_AND_LANGUAGE_NAME).put(SP_KEY_THEME, i11, true);
            applyTheme(context.getApplicationContext());
            applyTheme(context);
        }
    }

    public String getCurrentLanguage() {
        return this.currentLanguage;
    }

    public int getCurrentTheme() {
        return this.currentThemeID;
    }

    public Locale getLocale(Context context) {
        if (TUIBuild.getVersionInt() < 24) {
            return context.getResources().getConfiguration().locale;
        }
        return context.getResources().getConfiguration().getLocales().get(0);
    }

    public void setDefaultLocale(Locale locale) {
        this.defaultLocale = locale;
    }

    private TUIThemeManager() {
        this.isInit = false;
        this.themeResIDMap = new HashMap();
        HashMap hashMap = new HashMap();
        this.languageMap = hashMap;
        this.currentThemeID = 0;
        this.currentLanguage = "";
        this.defaultLocale = null;
        hashMap.put("zh", Locale.SIMPLIFIED_CHINESE);
        hashMap.put(LANGUAGE_EN, Locale.ENGLISH);
    }
}
