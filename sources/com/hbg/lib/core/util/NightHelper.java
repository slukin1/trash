package com.hbg.lib.core.util;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatDelegate;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.R$anim;
import i6.i;

public final class NightHelper {

    /* renamed from: d  reason: collision with root package name */
    public static NightHelper f68670d = new NightHelper();

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f68671a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68672b;

    /* renamed from: c  reason: collision with root package name */
    public long f68673c;

    public static class NightEvent {
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            AppCompatDelegate.M(NightHelper.this.f68671a ? 2 : 1);
        }
    }

    public NightHelper() {
        this.f68671a = ConfigPreferences.g("user_config", "night_theme", 1) != 0 ? false : true;
        i.b().f(new a());
    }

    public static NightHelper e() {
        return f68670d;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(Activity activity, Class cls, String str) {
        if (this.f68672b) {
            Intent intent = new Intent(activity, cls);
            intent.putExtra("navigator_action", str);
            intent.setClass(activity, cls);
            activity.startActivity(intent);
            activity.overridePendingTransition(R$anim.start_act_anim, R$anim.out_act_anim);
        }
        this.f68672b = false;
    }

    public void c(boolean z11) {
        this.f68673c = SystemClock.elapsedRealtime();
        this.f68671a = z11;
        ConfigPreferences.m("user_config", "night_theme", z11 ? "0" : "1");
        AppCompatDelegate.M(z11 ? 2 : 1);
    }

    public void d(BaseCoreActivity baseCoreActivity) {
        if (((baseCoreActivity.getResources().getConfiguration().uiMode & 48) == 32) != g()) {
            long j11 = this.f68673c;
            c(g());
            if (SystemClock.elapsedRealtime() - j11 > 3000) {
                oa.a.g().j((Class<?>) null);
            }
        }
    }

    public boolean f() {
        return this.f68672b;
    }

    public boolean g() {
        return this.f68671a;
    }

    public void i(Activity activity, Class cls, String str) {
        i.b().g(new q(this, activity, cls, str), 1);
    }

    public void j(boolean z11) {
        this.f68672b = z11;
    }
}
