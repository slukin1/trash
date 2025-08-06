package com.hbg.module.libkt.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.j;
import com.cpiz.android.bubbleview.BubbleTextView;
import com.cpiz.android.bubbleview.c;
import com.cpiz.android.bubbleview.d;
import com.hbg.module.libkt.R$id;
import com.hbg.module.libkt.R$layout;
import kotlin.Unit;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f24892a = new f();

    public static final class a implements DefaultLifecycleObserver {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f24893b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Runnable f24894c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f24895d;

        public a(Handler handler, Runnable runnable, PopupWindow popupWindow) {
            this.f24893b = handler;
            this.f24894c = runnable;
            this.f24895d = popupWindow;
        }

        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            j.a(this, lifecycleOwner);
        }

        public void onDestroy(LifecycleOwner lifecycleOwner) {
            j.b(this, lifecycleOwner);
            this.f24893b.removeCallbacks(this.f24894c);
            if (this.f24895d.isShowing()) {
                this.f24895d.dismiss();
            }
        }

        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            j.c(this, lifecycleOwner);
        }

        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            j.d(this, lifecycleOwner);
        }

        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            j.e(this, lifecycleOwner);
        }

        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            j.f(this, lifecycleOwner);
        }
    }

    public static final void d(Context context, int i11, View view, Integer num, d10.a<Unit> aVar) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.view_bubble_animation_icon_text, (ViewGroup) null);
        View findViewById = inflate.findViewById(R$id.popupView);
        AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R$id.tvContent);
        appCompatTextView.setText(i11);
        if (num != null) {
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), num.intValue());
            if (drawable != null) {
                drawable.setBounds(0, 0, m.a(16), m.a(16));
            }
            appCompatTextView.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            appCompatTextView.setCompoundDrawablePadding(m.a(6));
        }
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, false);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(false);
        popupWindow.setOnDismissListener(new c(aVar));
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        popupWindow.showAtLocation(view, 0, (iArr[0] - inflate.getMeasuredWidth()) + (view.getWidth() / 2) + m.a(24) + m.a(14) + m.a(4), (iArr[1] - inflate.getMeasuredHeight()) + m.a(24) + m.a(Double.valueOf(3.5d)));
        f24892a.i(findViewById);
        Handler handler = new Handler(Looper.getMainLooper());
        e eVar = new e(context, popupWindow);
        if (context instanceof AppCompatActivity) {
            ((AppCompatActivity) context).getLifecycle().a(new a(handler, eVar, popupWindow));
        }
        handler.postDelayed(eVar, 10000);
    }

    public static final void e(d10.a aVar) {
        if (aVar != null) {
            Unit unit = (Unit) aVar.invoke();
        }
    }

    public static final void f(Context context, PopupWindow popupWindow) {
        if (context instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) context;
            if (!appCompatActivity.isFinishing() && !appCompatActivity.isDestroyed() && popupWindow.isShowing()) {
                popupWindow.dismiss();
                return;
            }
            return;
        }
        popupWindow.dismiss();
    }

    public static final void g(Context context, int i11, View view, d dVar, Integer num, d10.a<Unit> aVar) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.view_bubble_icon_text, (ViewGroup) null);
        BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
        bubbleTextView.setText(i11);
        if (num != null) {
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), num.intValue());
            if (drawable != null) {
                drawable.setBounds(0, 0, m.a(16), m.a(16));
            }
            bubbleTextView.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            bubbleTextView.setCompoundDrawablePadding(m.a(4));
        }
        c cVar = new c(inflate, bubbleTextView);
        cVar.setArrowPosDelta(view.getWidth() / 2);
        cVar.setCancelOnLater(10000);
        cVar.setPadding(m.a(16));
        cVar.setCancelOnTouch(true);
        cVar.setCancelOnTouchOutside(true);
        cVar.setOnDismissListener(new d(aVar));
        cVar.showArrowTo(view, dVar, 0, 0);
    }

    public static final void h(d10.a aVar) {
        if (aVar != null) {
            Unit unit = (Unit) aVar.invoke();
        }
    }

    public final void i(View view) {
        view.setPivotX((((float) view.getWidth()) - ((float) m.a(14))) - ((float) m.a(4)));
        view.setPivotY((float) view.getHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(320);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", new float[]{0.0f, 1.1f});
        ofFloat2.setDuration(320);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{0.0f, 1.1f});
        ofFloat3.setDuration(320);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.1f, 1.0f});
        ofFloat4.setStartDelay(320);
        ofFloat4.setDuration(280);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.1f, 1.0f});
        ofFloat5.setStartDelay(320);
        ofFloat5.setDuration(280);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5});
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
    }
}
