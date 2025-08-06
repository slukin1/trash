package com.huobi.trade.utils;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.BaseApplication;
import com.huobi.main.helper.l;
import com.huobi.trade.utils.TradeHeavyBubbleDialog;
import com.huobi.view.HighLightPopup;
import pro.huobi.R;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f82799c;

    /* renamed from: a  reason: collision with root package name */
    public HighLightPopup f82800a;

    /* renamed from: b  reason: collision with root package name */
    public View f82801b;

    public class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public final Activity f82802a;

        /* renamed from: b  reason: collision with root package name */
        public final e[] f82803b;

        /* renamed from: c  reason: collision with root package name */
        public final c f82804c;

        /* renamed from: d  reason: collision with root package name */
        public int f82805d = 0;

        public b(Activity activity, e[] eVarArr, c cVar) {
            this.f82802a = activity;
            this.f82803b = eVarArr;
            this.f82804c = cVar;
        }

        public void a(DialogFragment dialogFragment) {
            boolean unused = a.f82799c = false;
            dialogFragment.dismiss();
            a.this.p();
            a.this.o(this.f82802a);
            this.f82804c.a();
        }

        public void b(DialogFragment dialogFragment) {
            boolean unused = a.f82799c = false;
            dialogFragment.dismiss();
            a.this.p();
            int i11 = this.f82805d - 1;
            this.f82805d = i11;
            e eVar = this.f82803b[i11];
            if (!a.this.i(this.f82802a, eVar.g())) {
                try {
                    a.this.o(this.f82802a);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } else {
                a.this.n(this.f82802a, eVar, this, this.f82805d + 1, this.f82803b.length);
            }
        }

        public void c(DialogFragment dialogFragment) {
            boolean unused = a.f82799c = false;
            dialogFragment.dismiss();
            a.this.p();
            int i11 = this.f82805d;
            e[] eVarArr = this.f82803b;
            if (i11 == eVarArr.length - 1) {
                a.this.o(this.f82802a);
                this.f82804c.onFinish();
                return;
            }
            int i12 = i11 + 1;
            this.f82805d = i12;
            e eVar = eVarArr[i12];
            if (!a.this.i(this.f82802a, eVar.g())) {
                try {
                    a.this.o(this.f82802a);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } else {
                a.this.n(this.f82802a, eVar, this, this.f82805d + 1, this.f82803b.length);
            }
        }
    }

    public interface c {
        void a();

        boolean b();

        void onFinish();

        void onShow();
    }

    public interface d {
        void a(DialogFragment dialogFragment);

        void b(DialogFragment dialogFragment);

        void c(DialogFragment dialogFragment);
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final View f82807a;

        /* renamed from: b  reason: collision with root package name */
        public final String f82808b;

        /* renamed from: c  reason: collision with root package name */
        public final String f82809c;

        /* renamed from: d  reason: collision with root package name */
        public int f82810d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f82811e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f82812f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f82813g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f82814h = 3;

        /* renamed from: i  reason: collision with root package name */
        public boolean f82815i = true;

        public e(View view, String str, String str2) {
            this.f82807a = view;
            this.f82808b = str;
            this.f82809c = str2;
        }

        public int a() {
            return this.f82813g;
        }

        public String b() {
            return this.f82809c;
        }

        public int c() {
            return this.f82810d;
        }

        public int d() {
            return this.f82812f;
        }

        public String e() {
            return this.f82808b;
        }

        public int f() {
            return this.f82811e;
        }

        public View g() {
            return this.f82807a;
        }

        public int h() {
            return this.f82814h;
        }

        public boolean i() {
            return this.f82815i;
        }

        public e j(int i11, int i12, int i13, int i14) {
            this.f82810d = i11;
            this.f82811e = i12;
            this.f82812f = i13;
            this.f82813g = i14;
            return this;
        }

        public e k(boolean z11) {
            this.f82815i = z11;
            return this;
        }

        public e l(int i11) {
            this.f82814h = i11;
            return this;
        }
    }

    public static class f {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static a f82816a = new a();
    }

    public static a j() {
        return f.f82816a;
    }

    public final boolean i(Activity activity, View view) {
        return (activity == null || view == null || view.getWindowToken() == null || view.getWidth() == 0 || view.getHeight() == 0) ? false : true;
    }

    public final void n(Activity activity, e eVar, d dVar, int i11, int i12) {
        String str;
        f82799c = true;
        View g11 = eVar.g();
        if (i11 == i12) {
            str = g11.getResources().getString(R.string.n_exchange_guide_begin);
        } else {
            str = g11.getResources().getString(R.string.n_grid_user_guide_next);
        }
        String str2 = null;
        if (i11 != 1) {
            str2 = activity.getResources().getString(R.string.n_exchange_guide_last);
        }
        HighLightPopup highLightPopup = new HighLightPopup(g11);
        this.f82800a = highLightPopup;
        highLightPopup.setContainerBg(ContextCompat.getDrawable(activity, R.drawable.asset_guide_header_bg));
        this.f82800a.setSizeAndShow(eVar.c(), eVar.f(), eVar.d(), eVar.a());
        TradeHeavyBubbleDialog.b bVar = new TradeHeavyBubbleDialog.b((FragmentActivity) activity, this.f82800a.ivMirror);
        bVar.d(eVar.e()).n(eVar.b()).e(i11).a(i12).c(new lt.b(dVar)).g(str2).f(new lt.c(dVar)).j(str).h(ContextCompat.getColor(BaseApplication.b(), R.color.baseColorMajorTheme100)).i(new lt.a(dVar)).k(eVar.i()).m(eVar.h()).l(true);
        bVar.b(true).show();
    }

    public final void o(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View view = this.f82801b;
        if (view != null) {
            viewGroup.removeView(view);
            this.f82801b = null;
        }
    }

    public final void p() {
        HighLightPopup highLightPopup = this.f82800a;
        if (highLightPopup != null) {
            if (highLightPopup.isShowing()) {
                this.f82800a.dismiss();
            }
            this.f82800a = null;
        }
    }

    public final void q(Activity activity) {
        View view = new View(activity);
        this.f82801b = view;
        view.setBackgroundColor(ContextCompat.getColor(activity, R.color.bubble_popup_cover));
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this.f82801b);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f82801b, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat.setDuration(500).setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
    }

    public boolean r(Activity activity, e[] eVarArr, boolean z11, c cVar) {
        if (l.c().d() || eVarArr == null || eVarArr.length == 0 || f82799c) {
            return false;
        }
        if (!z11 && !cVar.b()) {
            return false;
        }
        b bVar = new b(activity, eVarArr, cVar);
        e eVar = eVarArr[0];
        if (!i(activity, eVar.g())) {
            return false;
        }
        cVar.onShow();
        n(activity, eVar, bVar, 1, eVarArr.length);
        q(activity);
        return true;
    }

    public a() {
    }
}
