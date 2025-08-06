package com.hbg.module.huobi.im.group.base;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.h0;
import com.hbg.lib.core.util.AppLanguageHelper;
import i6.i;
import jd.a;
import jd.b;
import rx.subjects.BehaviorSubject;
import u6.g;
import z9.g1;

public abstract class BaseActivity extends AppCompatActivity implements g {

    /* renamed from: b  reason: collision with root package name */
    public g1 f19874b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19875c;

    public static final void Df(BaseActivity baseActivity) {
        g1 g1Var = baseActivity.f19874b;
        if (g1Var != null) {
            g1Var.dismiss();
        }
    }

    public static final void Yf(BaseActivity baseActivity, boolean z11) {
        if (baseActivity.f19874b == null) {
            baseActivity.f19874b = new g1(baseActivity);
            if (baseActivity.altFocusableIM()) {
                g1 g1Var = baseActivity.f19874b;
                Window window = g1Var != null ? g1Var.getWindow() : null;
                if (window != null) {
                    window.setFlags(131072, 131072);
                } else {
                    return;
                }
            }
        }
        g1 g1Var2 = baseActivity.f19874b;
        if (g1Var2 != null) {
            g1Var2.show();
        }
        g1 g1Var3 = baseActivity.f19874b;
        if (g1Var3 != null) {
            g1Var3.setCanceledOnTouchOutside(z11);
        }
        g1 g1Var4 = baseActivity.f19874b;
        if (g1Var4 != null) {
            g1Var4.setCancelable(z11);
        }
    }

    public final boolean Bf(Activity activity) {
        return activity != null && !activity.isFinishing();
    }

    public final boolean Xf(Activity activity, boolean z11) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        View decorView = activity.getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i11 = z11 ? systemUiVisibility | 8192 : systemUiVisibility & -8193;
        if (decorView.getSystemUiVisibility() == i11) {
            return true;
        }
        decorView.setSystemUiVisibility(i11);
        return true;
    }

    public final void Zf(boolean z11) {
        getWindow().addFlags(Integer.MIN_VALUE);
        if (z11) {
            getWindow().clearFlags(67108864);
            getWindow().setStatusBarColor(0);
            getWindow().getDecorView().setSystemUiVisibility(0);
        } else {
            getWindow().clearFlags(67108864);
            getWindow().setNavigationBarColor(0);
            getWindow().getDecorView().setSystemUiVisibility(1280);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        View childAt = ((ViewGroup) getWindow().findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            h0.G0(childAt, false);
            h0.u0(childAt);
        }
    }

    public boolean altFocusableIM() {
        return false;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(AppLanguageHelper.getInstance().attachBaseContext(context));
    }

    public void dismissProgressDialog() {
        i.b().d(new a(this));
    }

    public BehaviorSubject<Integer> getUIChangeSubject() {
        return null;
    }

    public boolean isAlive() {
        return this.f19875c && !isFinishing();
    }

    public boolean isCanBeSeen() {
        return this.f19875c;
    }

    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Zf(false);
        super.onCreate(bundle, persistableBundle);
    }

    public void onPause() {
        super.onPause();
        this.f19875c = false;
    }

    public void onResume() {
        super.onResume();
        this.f19875c = true;
    }

    public void showProgressDialog() {
        showProgressDialog((String) null);
    }

    public void showProgressDialog(boolean z11) {
        showProgressDialog((String) null, z11);
    }

    public void showProgressDialog(String str) {
        showProgressDialog(str, false);
    }

    public void showProgressDialog(String str, boolean z11) {
        i.b().d(new b(this, z11));
    }
}
