package com.hbg.lib.core.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import androidx.appcompat.view.ContextThemeWrapper;
import com.hbg.lib.core.R$style;
import com.hbg.lib.core.model.MgtJaKo;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.huobi.store.AppConfigManager;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import i6.i;
import java.util.Locale;

@Keep
public final class AppLanguageHelper {
    public static final Locale BRAZIL_LOCALE = new Locale("pt", "BR");
    public static final Locale DUTCH_LOCALE = new Locale("nl", "NL");
    public static final Locale EN_IN_LOCALE = new Locale(TUIThemeManager.LANGUAGE_EN, "IN");
    public static final Locale FRENCH_LOCALE = new Locale("fr", "");
    public static final Locale HI_IN_LOCALE = new Locale("hi", "IN");
    public static final Locale INDONESIA_LOCALE = new Locale("id", "ID");
    public static final Locale MS_MY_LOCALE = new Locale("ms", "MY");
    private static final AppLanguageHelper OUR_INSTANCE = new AppLanguageHelper();
    public static final Locale PORTUGAL_LOCALE = new Locale("pt", "PT");
    public static final Locale RUSSIAN_LOCALE = new Locale("ru", "RU");
    public static final Locale SPAIN_US_LOCALE = new Locale("es", "LA");
    public static final Locale SPANISH_LOCALE = new Locale("es", "ES");
    private static final Locale SYSTEM_LOCALE = Locale.getDefault();
    public static final Locale TRADITIONAL_CHINESE_LOCALE = new Locale("zh", "HK");
    public static final Locale TURKEY_LOCALE = new Locale("tr", "TR");
    public static final Locale UK_UA_LOCALE = new Locale("uk", "UA");
    public static final Locale VIETNAM_LOCALE = new Locale("vi", "");
    private boolean isChangeLanguage;

    @Keep
    public static class HuobiContextThemeWrapper extends ContextThemeWrapper {
        public Configuration configuration;

        public HuobiContextThemeWrapper(Configuration configuration2, Context context, int i11) {
            super(context, i11);
            this.configuration = configuration2;
        }

        public void applyOverrideConfiguration(Configuration configuration2) {
            if (configuration2 != null) {
                configuration2.setTo(this.configuration);
            }
            super.applyOverrideConfiguration(configuration2);
        }
    }

    public class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Application f68662b;

        public a(Application application) {
            this.f68662b = application;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (!Locale.getDefault().getLanguage().equals(AppLanguageHelper.this.getCurAppLocale().getLanguage())) {
                AppLanguageHelper appLanguageHelper = AppLanguageHelper.this;
                appLanguageHelper.changeAppLanguage(this.f68662b, appLanguageHelper.getCurAppLocale());
            }
            String name = activity.getClass().getName();
            if (AppLanguageHelper.this.isSpainUsLanguage()) {
                return;
            }
            if (name.contains("com.jumio") || name.contains("com.iproov")) {
                AppLanguageHelper.setAppLanguage(activity, AppLanguageHelper.this.getCurAppLocale());
            }
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

    private AppLanguageHelper() {
    }

    public static AppLanguageHelper getInstance() {
        return OUR_INSTANCE;
    }

    public static boolean isJaMgtOpen() {
        MgtJaKo mgtJaKo = (MgtJaKo) AppConfigManager.c(MgtConfigNumber.JA_KO.number, MgtJaKo.class);
        return mgtJaKo != null && TextUtils.equals(mgtJaKo.getJp(), "1");
    }

    public static boolean isKoMgtOpen() {
        MgtJaKo mgtJaKo = (MgtJaKo) AppConfigManager.c(MgtConfigNumber.JA_KO.number, MgtJaKo.class);
        return mgtJaKo != null && TextUtils.equals(mgtJaKo.getKo(), "1");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$openAppLanguageActivity$0(Activity activity, Class cls) {
        if (this.isChangeLanguage) {
            Intent intent = new Intent(activity, cls);
            activity.overridePendingTransition(0, 0);
            intent.addFlags(65536);
            activity.startActivity(intent);
        }
        this.isChangeLanguage = false;
    }

    /* access modifiers changed from: private */
    public static void setAppLanguage(Context context, Locale locale) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            configuration.setLocale(locale);
            configuration.setLocales(new LocaleList(new Locale[]{locale}));
            context.createConfigurationContext(configuration);
            resources.updateConfiguration(configuration, displayMetrics);
        } else if (i11 >= 17) {
            configuration.setLocale(locale);
            resources.updateConfiguration(configuration, displayMetrics);
        } else {
            configuration.locale = locale;
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @TargetApi(26)
    private Context updateResources(Context context) {
        Resources resources = context.getResources();
        Locale curAppLocale = getCurAppLocale();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(curAppLocale);
        configuration.setLocales(new LocaleList(new Locale[]{curAppLocale}));
        return context.createConfigurationContext(configuration);
    }

    public Context attachBaseContext(Context context) {
        Resources resources = context.getResources();
        Locale curAppLocale = getCurAppLocale();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(curAppLocale);
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocales(new LocaleList(new Locale[]{curAppLocale}));
        }
        return new HuobiContextThemeWrapper(configuration, context.createConfigurationContext(configuration), R$style.AppTheme);
    }

    public void changeAppLanguage(Context context, Locale locale) {
        Locale n11 = m6.a.n(locale);
        Resources resources = context.getApplicationContext().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(n11);
        } else {
            configuration.locale = n11;
        }
        resources.updateConfiguration(configuration, displayMetrics);
        m6.a.p(n11);
    }

    public Locale getCurAppLocale() {
        return m6.a.a();
    }

    public String getCurAppLocaleName() {
        return m6.a.b();
    }

    public String getCurLanguageHeader() {
        return m6.a.f();
    }

    public String getCurLanguageUrlLowerCase() {
        return m6.a.f().toLowerCase(Locale.US);
    }

    public String getSensorsLanguage() {
        return m6.a.i();
    }

    public Locale getSystemLocale() {
        return SYSTEM_LOCALE;
    }

    public void initAppLanguage(Application application) {
        if (TextUtils.isEmpty(ConfigPreferences.d("user_config", "config_app_language"))) {
            FirstInstallHelper.f68668a = true;
            ConfigPreferences.l("user_config", "FIRST_INSTALL_TIME", System.currentTimeMillis());
            if (Locale.getDefault().getLanguage().equals(Locale.SIMPLIFIED_CHINESE.getLanguage())) {
                changeAppLanguage(application, Locale.SIMPLIFIED_CHINESE);
            } else {
                changeAppLanguage(application, Locale.getDefault());
            }
        } else {
            changeAppLanguage(application, getCurAppLocale());
        }
        b.c().e();
        application.registerActivityLifecycleCallbacks(new a(application));
    }

    public boolean isChangeLanguage() {
        return this.isChangeLanguage;
    }

    public boolean isChineseLanguage() {
        return Locale.SIMPLIFIED_CHINESE.toString().equals(getCurAppLocale().toString());
    }

    public boolean isDutchLanguage() {
        return DUTCH_LOCALE.toString().equals(getCurAppLocale().toString());
    }

    public boolean isEnglishLanguage() {
        return Locale.ENGLISH.toString().equals(getCurAppLocale().toString());
    }

    public boolean isFrenchLanguage() {
        return FRENCH_LOCALE.toString().equals(getCurAppLocale().toString());
    }

    public boolean isHkChineseLanguage() {
        return TRADITIONAL_CHINESE_LOCALE.toString().equals(getCurAppLocale().toString());
    }

    public boolean isItalianLanguage() {
        return Locale.ITALIAN.toString().equals(getCurAppLocale().toString());
    }

    public boolean isKoreaLanguage() {
        return Locale.KOREA.toString().equals(getCurAppLocale().toString());
    }

    public boolean isRussianLanguage() {
        return RUSSIAN_LOCALE.toString().equals(getCurAppLocale().toString());
    }

    public boolean isSpainUsLanguage() {
        return SPAIN_US_LOCALE.toString().equals(getCurAppLocale().toString());
    }

    public boolean isTurkeyLanguage() {
        return TURKEY_LOCALE.toString().equals(getCurAppLocale().toString());
    }

    public boolean isVietnamLanguage() {
        return VIETNAM_LOCALE.toString().equals(getCurAppLocale().toString());
    }

    public void openAppLanguageActivity(Activity activity, Class cls) {
        i.b().g(new c(this, activity, cls), 1);
    }

    public void setChangeLanguage(boolean z11) {
        this.isChangeLanguage = z11;
    }
}
