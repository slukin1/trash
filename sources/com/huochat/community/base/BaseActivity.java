package com.huochat.community.base;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.hbg.lib.common.BaseApplication;
import com.huochat.community.CommunityManager;
import com.huochat.community.R;
import com.huochat.community.eventbus.EventMessage;
import i6.i;
import java.lang.reflect.Field;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rv.a;
import rv.b;
import rx.subjects.BehaviorSubject;
import u6.g;
import z9.g1;

public abstract class BaseActivity extends AppCompatActivity implements BaseInterface, g {
    private boolean isActive = true;
    private g1 mLoadingDialog;
    private final BehaviorSubject<Integer> uiBehavior = BehaviorSubject.create();

    /* access modifiers changed from: private */
    public static final void dismissProgressDialog$lambda$1(BaseActivity baseActivity) {
        g1 g1Var = baseActivity.mLoadingDialog;
        if (g1Var != null && g1Var != null) {
            g1Var.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void showProgressDialog$lambda$0(BaseActivity baseActivity, boolean z11) {
        if (baseActivity.mLoadingDialog == null) {
            baseActivity.mLoadingDialog = new g1(baseActivity);
        }
        g1 g1Var = baseActivity.mLoadingDialog;
        if (g1Var != null) {
            g1Var.show();
        }
        g1 g1Var2 = baseActivity.mLoadingDialog;
        if (g1Var2 != null) {
            g1Var2.setCanceledOnTouchOutside(z11);
        }
        g1 g1Var3 = baseActivity.mLoadingDialog;
        if (g1Var3 != null) {
            g1Var3.setCancelable(z11);
        }
    }

    public void dismissProgressDialog() {
        i.b().d(new a(this));
    }

    public Resources getResources() {
        return BaseApplication.b().getResources();
    }

    public final int getStatusBarColor() {
        return -1;
    }

    public BehaviorSubject<Integer> getUIChangeSubject() {
        return this.uiBehavior;
    }

    public boolean isAlive() {
        return this.isActive && !isFinishing();
    }

    public boolean isCanBeSeen() {
        return this.isActive;
    }

    public final boolean isRegistEventBus() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        if (CommunityManager.Companion.getInstance().isNightModel()) {
            setTheme(R.style.communityThemeNight);
        } else {
            setTheme(R.style.communityThemeLight);
        }
        requestWindowFeature(1);
        super.onCreate(bundle);
        int layoutId = getLayoutId();
        if (layoutId != 0) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    Field declaredField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mSemiTransparentStatusBarColor");
                    declaredField.setAccessible(true);
                    if (declaredField.getInt(getWindow().getDecorView()) != 0) {
                        declaredField.setInt(getWindow().getDecorView(), 0);
                    }
                } catch (Exception unused) {
                }
            }
            setContentView(layoutId);
        }
        if (Build.VERSION.SDK_INT >= 23 && -1 == getStatusBarColor()) {
            getWindow().getDecorView().setSystemUiVisibility(8448);
        }
        initView((View) null);
        initData(bundle);
        if (isRegistEventBus()) {
            EventBus.d().p(this);
        }
    }

    public void onDestroy() {
        this.uiBehavior.onNext(5);
        super.onDestroy();
        if (isRegistEventBus()) {
            EventBus.d().r(this);
        }
        this.isActive = false;
    }

    @h(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(EventMessage<?> eventMessage) {
    }

    public void onPause() {
        this.isActive = false;
        this.uiBehavior.onNext(3);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.uiBehavior.onNext(2);
        this.isActive = true;
    }

    public void showOldProgressDialog(String str) {
    }

    public void showProgressDialog() {
    }

    public void showProgressDialog(String str) {
    }

    public void showProgressDialog(String str, boolean z11) {
    }

    public void showProgressDialog(boolean z11) {
        i.b().d(new b(this, z11));
    }
}
