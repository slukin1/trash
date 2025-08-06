package com.hbg.lib.core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.mvp.BaseMVPActivity;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.IntentSafeUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import i6.i;
import i6.k;
import qiu.niorgai.StatusBarCompat;
import rx.subjects.BehaviorSubject;
import s6.a;
import u6.b;
import u6.c;
import u6.g;
import z9.g1;
import z9.h1;

public abstract class BaseActivity<P extends ActivityPresenter<V>, V extends g> extends BaseMVPActivity<P, V> implements g, BaseDialogFragment.c {
    public static final boolean CAN_FULL_SCREEN = true;
    private boolean isActive;
    private g1 mLoadingDialog;
    private h1 mLoadingDialogOld;
    private View mStatusBar;
    private BehaviorSubject<Integer> uiBehavior = BehaviorSubject.create();

    public static int getStatusBarHeight(Context context) {
        int i11 = 0;
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                i11 = context.getResources().getDimensionPixelSize(identifier);
            }
            if (i11 <= 0) {
                return PixelUtils.a(25.0f);
            }
            return i11;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissProgressDialog$2() {
        g1 g1Var = this.mLoadingDialog;
        if (g1Var != null) {
            g1Var.dismiss();
        }
        h1 h1Var = this.mLoadingDialogOld;
        if (h1Var != null) {
            h1Var.dismiss();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$setToolBar$3(View view) {
        doFinish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showOldProgressDialog$0(String str) {
        if (this.mLoadingDialogOld == null) {
            this.mLoadingDialogOld = new h1(this);
        }
        this.mLoadingDialogOld.show();
        this.mLoadingDialogOld.a(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showProgressDialog$1(boolean z11) {
        try {
            if (this.mLoadingDialog == null) {
                this.mLoadingDialog = new g1(this);
                if (altFocusableIM()) {
                    Window window = this.mLoadingDialog.getWindow();
                    if (window != null) {
                        window.setFlags(131072, 131072);
                    } else {
                        return;
                    }
                }
            }
            if (!isFinishing()) {
                this.mLoadingDialog.show();
                this.mLoadingDialog.setCanceledOnTouchOutside(z11);
                this.mLoadingDialog.setCancelable(z11);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            d.e("showProgressDialog", "---->" + e11.getMessage());
        }
    }

    public static void start(Activity activity, Intent intent) {
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (Exception e11) {
                d.f(activity + "-->start-->", e11);
                e11.printStackTrace();
            }
        }
    }

    public static void startForResult(Activity activity, Intent intent, int i11) {
        if (activity != null) {
            try {
                activity.startActivityForResult(intent, i11);
            } catch (Exception e11) {
                d.f(activity + "-->start-->", e11);
                e11.printStackTrace();
            }
        }
    }

    public abstract void addEvent();

    public void afterInit() {
    }

    public boolean altFocusableIM() {
        return false;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(AppLanguageHelper.getInstance().attachBaseContext(context));
    }

    public boolean canFullScreen() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public void changeStatusBarTextColor(boolean z11) {
        if (Build.VERSION.SDK_INT <= 23) {
            return;
        }
        if (z11) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    public void dismissProgressDialog() {
        i.b().d(new b(this));
    }

    public void doFinish() {
        SoftInputUtils.f(this);
        finish();
    }

    @Deprecated
    public void gIOignoreView(View view) {
    }

    public abstract int getContentView();

    public AppCompatDelegate getDelegate() {
        return super.getDelegate();
    }

    public ViewGroup getParentLayout() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        this.mStatusBar = new View(this);
        setStatusBarColor(getStatusBarColor());
        linearLayout.addView(this.mStatusBar, new LinearLayout.LayoutParams(-1, getStatusBarHeight(this)));
        return linearLayout;
    }

    public Resources getResources() {
        return super.getResources();
    }

    public View getStatusBar() {
        return this.mStatusBar;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R$color.baseColorContentBackground);
    }

    public BehaviorSubject<Integer> getUIChangeSubject() {
        return this.uiBehavior;
    }

    public void hideStatusBar() {
        View view = this.mStatusBar;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void initContentView() {
        setContentView(getContentView());
        initExtra();
        initView();
        addEvent();
        afterInit();
    }

    public void initExtra() {
    }

    public void initStatus() {
        if (!canFullScreen()) {
            return;
        }
        if (useNewStatusBarFunc()) {
            StatusBarCompat.d(this, true);
            StatusBarCompat.a(this);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
            if (isLightStatusBar()) {
                StatusBarCompat.a(this);
            } else {
                StatusBarCompat.b(this);
            }
        } else {
            getWindow().addFlags(67108864);
            changeStatusBarTextColor(!isLightStatusBar());
        }
    }

    public abstract void initView();

    public boolean isCanBeSeen() {
        return this.isActive;
    }

    public boolean isLightStatusBar() {
        return NightHelper.e().g();
    }

    public void onCreate(Bundle bundle) {
        k.o("ACTION-PAGE", "[ActivityOnCreate]" + getClass().getName());
        initStatus();
        super.onCreate(bundle);
        if (!IntentSafeUtils.a(getIntent())) {
            finish();
        }
        setPossiblyResize();
    }

    public void onDestroy() {
        k.o("ACTION-PAGE", "[ActivityOnDestroy]" + getClass().getName());
        this.uiBehavior.onNext(5);
        super.onDestroy();
        a.d();
    }

    public void onDialogFragmentBackPressed() {
    }

    public void onDialogFragmentPause() {
    }

    public void onDialogFragmentResume() {
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!IntentSafeUtils.a(getIntent())) {
            finish();
        }
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
        if (BaseModuleConfig.a() != null) {
            BaseModuleConfig.a().K(this);
        }
    }

    public void onStart() {
        super.onStart();
        k.o("ACTION-PAGE", "[ActivityStart]" + getClass().getName());
    }

    public void onStop() {
        super.onStop();
        k.o("ACTION-PAGE", "[ActivityStop]" + getClass().getName());
    }

    public void removeWinBg() {
        getWindow().setBackgroundDrawable((Drawable) null);
    }

    public void setContentView(int i11) {
        if (canFullScreen()) {
            ViewGroup parentLayout = getParentLayout();
            LayoutInflater.from(this).inflate(i11, parentLayout, true);
            super.setContentView((View) parentLayout);
            return;
        }
        super.setContentView(i11);
    }

    public void setContentViewNotOverride(View view) {
        super.setContentView(view);
    }

    public void setPossiblyResize() {
        if (canFullScreen()) {
            oa.k.b(findViewById(16908290));
        }
    }

    public void setStatusBarColor(int i11) {
        View view = this.mStatusBar;
        if (view != null) {
            view.setBackgroundColor(i11);
        }
    }

    public void setToolBar(Toolbar toolbar, CharSequence charSequence, boolean z11) {
        toolbar.setTitle(charSequence);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(z11);
            supportActionBar.setDisplayShowHomeEnabled(z11);
            supportActionBar.setDisplayShowTitleEnabled(z11);
        }
        toolbar.setNavigationOnClickListener(new u6.a(this));
    }

    public void showOldProgressDialog(String str) {
        i.b().d(new c(this, str));
    }

    public void showProgressDialog() {
        showProgressDialog((String) null);
    }

    public void showStatusBar() {
        View view = this.mStatusBar;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public boolean useNewStatusBarFunc() {
        return false;
    }

    public void showProgressDialog(boolean z11) {
        showProgressDialog((String) null, z11);
    }

    public void showProgressDialog(String str) {
        showProgressDialog(str, false);
    }

    public void showProgressDialog(String str, boolean z11) {
        i.b().d(new u6.d(this, z11));
    }

    public void setContentView(View view) {
        if (canFullScreen()) {
            ViewGroup parentLayout = getParentLayout();
            parentLayout.addView(view, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            super.setContentView((View) parentLayout);
            return;
        }
        super.setContentView(view);
    }
}
