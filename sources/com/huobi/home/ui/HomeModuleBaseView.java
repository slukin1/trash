package com.huobi.home.ui;

import ah.a;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.core.util.NightHelper;
import com.huobi.home.util.ViewExtKt;
import d10.p;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.x;
import pro.huobi.R;

public final class HomeModuleBaseView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public Context f72542b;

    /* renamed from: c  reason: collision with root package name */
    public LottieAnimationView f72543c;

    /* renamed from: d  reason: collision with root package name */
    public View f72544d;

    /* renamed from: e  reason: collision with root package name */
    public String f72545e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f72546f = "";

    public HomeModuleBaseView(Context context) {
        super(context);
        e(context);
    }

    public static /* synthetic */ void g(HomeModuleBaseView homeModuleBaseView, List list, boolean z11, p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = null;
        }
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        homeModuleBaseView.f(list, z11, pVar);
    }

    public final void a(String str, View view) {
        Log.d("Home1", "addModlueView: " + str);
        this.f72544d = view;
        this.f72545e = str;
        addView(view, 1);
        ((TextView) findViewById(R.id.home_module_debugname_view)).setText(str);
    }

    public final void b() {
        if (this.f72546f.length() > 0) {
            LottieAnimationView lottieAnimationView = this.f72543c;
            if (lottieAnimationView != null) {
                lottieAnimationView.cancelAnimation();
            }
            LottieAnimationView lottieAnimationView2 = this.f72543c;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setVisibility(8);
            }
        }
    }

    public final void c() {
        Log.d("Home1", "dismissModuleView: " + this.f72545e);
        View view = this.f72544d;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void d() {
        Log.d("Home1", "dismiss: " + this.f72545e);
        setVisibility(8);
    }

    public final void e(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_home_module, this);
        this.f72543c = (LottieAnimationView) findViewById(R.id.home_module_yugu_view);
        this.f72542b = context;
    }

    public final void f(List<? extends ViewGroup> list, boolean z11, p<? super View, ? super Boolean, Unit> pVar) {
        View view = this.f72544d;
        if (view != null) {
            ViewExtKt.c(view, list, z11, pVar);
        }
    }

    public final String getModuleName() {
        return this.f72545e;
    }

    public final void h() {
        if (this.f72546f.length() > 0) {
            LottieAnimationView lottieAnimationView = this.f72543c;
            if (lottieAnimationView != null) {
                lottieAnimationView.playAnimation();
            }
            LottieAnimationView lottieAnimationView2 = this.f72543c;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setVisibility(0);
            }
        }
    }

    public final void i() {
        Log.d("Home1", "showModuleView: " + this.f72545e);
        View view = this.f72544d;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void j() {
        Log.d("Home1", "show: " + this.f72545e);
        i();
        if (x.b("ranking", this.f72545e)) {
            a.c().b();
        }
        setVisibility(0);
    }

    public final void setAnimationRes(String str) {
        if (str != null) {
            if (str.length() > 0) {
                this.f72546f = str;
                if (NightHelper.e().g()) {
                    LottieAnimationView lottieAnimationView = this.f72543c;
                    if (lottieAnimationView != null) {
                        lottieAnimationView.setAnimation(str + "_night.json");
                        return;
                    }
                    return;
                }
                LottieAnimationView lottieAnimationView2 = this.f72543c;
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setAnimation(str + ".json");
                }
            }
        }
    }

    public HomeModuleBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    public HomeModuleBaseView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        e(context);
    }
}
