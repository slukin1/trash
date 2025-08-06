package com.huobi.trade.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import lt.d;
import lt.e;
import lt.f;
import lt.g;
import lt.h;
import pro.huobi.R;

public class TradeHeavyBubbleDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public final int f82762b = PixelUtils.a(258.0f);

    /* renamed from: c  reason: collision with root package name */
    public final int f82763c = PixelUtils.a(8.0f);

    /* renamed from: d  reason: collision with root package name */
    public final int f82764d = PixelUtils.a(10.0f);

    /* renamed from: e  reason: collision with root package name */
    public final int f82765e = PixelUtils.a(12.0f);

    /* renamed from: f  reason: collision with root package name */
    public final int f82766f = PixelUtils.a(6.0f);

    /* renamed from: g  reason: collision with root package name */
    public View f82767g;

    /* renamed from: h  reason: collision with root package name */
    public View f82768h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f82769i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f82770j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f82771k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f82772l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f82773m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f82774n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f82775o;

    /* renamed from: p  reason: collision with root package name */
    public b f82776p;

    /* renamed from: q  reason: collision with root package name */
    public Context f82777q;

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f82778r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f82779s = false;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            try {
                TradeHeavyBubbleDialog.super.dismiss();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public FragmentActivity f82781a;

        /* renamed from: b  reason: collision with root package name */
        public View f82782b;

        /* renamed from: c  reason: collision with root package name */
        public a f82783c;

        /* renamed from: d  reason: collision with root package name */
        public String f82784d;

        /* renamed from: e  reason: collision with root package name */
        public String f82785e;

        /* renamed from: f  reason: collision with root package name */
        public int f82786f = -1;

        /* renamed from: g  reason: collision with root package name */
        public String f82787g;

        /* renamed from: h  reason: collision with root package name */
        public a f82788h;

        /* renamed from: i  reason: collision with root package name */
        public String f82789i;

        /* renamed from: j  reason: collision with root package name */
        public int f82790j;

        /* renamed from: k  reason: collision with root package name */
        public a f82791k;

        /* renamed from: l  reason: collision with root package name */
        public int f82792l;

        /* renamed from: m  reason: collision with root package name */
        public int f82793m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f82794n;

        /* renamed from: o  reason: collision with root package name */
        public int f82795o = 3;

        /* renamed from: p  reason: collision with root package name */
        public boolean f82796p = true;

        /* renamed from: q  reason: collision with root package name */
        public int f82797q = -1;

        public interface a {
            void onDialogClick(DialogFragment dialogFragment, View view);
        }

        public b(FragmentActivity fragmentActivity, View view) {
            this.f82781a = fragmentActivity;
            this.f82782b = view;
        }

        public b a(int i11) {
            this.f82793m = i11;
            return this;
        }

        public TradeHeavyBubbleDialog b(boolean z11) {
            TradeHeavyBubbleDialog tradeHeavyBubbleDialog = new TradeHeavyBubbleDialog(z11);
            tradeHeavyBubbleDialog.Dh(this);
            return tradeHeavyBubbleDialog;
        }

        public b c(a aVar) {
            this.f82783c = aVar;
            return this;
        }

        public b d(String str) {
            this.f82784d = str;
            return this;
        }

        public b e(int i11) {
            this.f82792l = i11;
            return this;
        }

        public b f(a aVar) {
            this.f82788h = aVar;
            return this;
        }

        public b g(String str) {
            this.f82787g = str;
            return this;
        }

        public b h(int i11) {
            this.f82790j = i11;
            return this;
        }

        public b i(a aVar) {
            this.f82791k = aVar;
            return this;
        }

        public b j(String str) {
            this.f82789i = str;
            return this;
        }

        public b k(boolean z11) {
            this.f82796p = z11;
            return this;
        }

        public b l(boolean z11) {
            this.f82794n = z11;
            return this;
        }

        public b m(int i11) {
            this.f82795o = i11;
            return this;
        }

        public b n(String str) {
            this.f82785e = str;
            return this;
        }
    }

    public TradeHeavyBubbleDialog(boolean z11) {
        this.f82779s = z11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ah(b.a aVar, Void voidR) {
        if (aVar != null) {
            aVar.onDialogClick(this, this.f82772l);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bh(b.a aVar, Void voidR) {
        if (aVar != null) {
            aVar.onDialogClick(this, this.f82773m);
        } else {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh() {
        vh();
        afterLayout();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(b.a aVar, Void voidR) {
        if (aVar != null) {
            aVar.onDialogClick(this, this.f82769i);
        }
    }

    public int[] Ch(View view) {
        int i11;
        int i12;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f82762b, -2);
        }
        int i13 = layoutParams.width;
        if (i13 > 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        } else {
            i11 = View.MeasureSpec.makeMeasureSpec(this.f82762b, 1073741824);
        }
        int i14 = layoutParams.height;
        if (i14 > 0) {
            i12 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        } else {
            i12 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(i11, i12);
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public void Dh(b bVar) {
        this.f82776p = bVar;
    }

    public final void Eh(b.a aVar) {
        if (aVar == null) {
            this.f82769i.setVisibility(8);
        } else {
            this.f82769i.setVisibility(0);
        }
        dw.a.a(this.f82769i).throttleFirst(1, TimeUnit.SECONDS).subscribe(new h(this, aVar));
    }

    public final void Fh(b.a aVar) {
        dw.a.a(this.f82772l).throttleFirst(1, TimeUnit.SECONDS).subscribe(new g(this, aVar));
    }

    public final void Gh(b.a aVar) {
        dw.a.a(this.f82773m).throttleFirst(1, TimeUnit.SECONDS).subscribe(new f(this, aVar));
    }

    public final void Hh(b bVar) {
        TextView textView = this.f82775o;
        textView.setText("" + bVar.f82792l);
        TextView textView2 = this.f82774n;
        textView2.setText("/" + bVar.f82793m);
    }

    public void afterLayout() {
        this.f82768h.post(new d(this));
    }

    public void dismiss() {
        b bVar = this.f82776p;
        if (bVar == null || bVar.f82794n) {
            try {
                super.dismissAllowingStateLoss();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            hideAnim(new a());
        }
    }

    public final void forbidNightMode() {
        if (AppCompatDelegate.m() == 2) {
            Configuration configuration = new Configuration(this.f82777q.getResources().getConfiguration());
            configuration.uiMode = 16;
            this.f82777q = this.f82777q.createConfigurationContext(configuration);
        }
    }

    public int[] getAnchorViewLocation() {
        View view;
        int[] iArr = new int[2];
        b bVar = this.f82776p;
        if (!(bVar == null || (view = bVar.f82782b) == null)) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    public final void hideAnim(Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f82767g, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(270).setInterpolator(new AccelerateInterpolator());
        ofFloat.addListener(animatorListener);
        ofFloat.start();
    }

    public final void initView() {
        this.f82767g.setVisibility(4);
        this.f82778r = (LinearLayout) this.f82767g.findViewById(R.id.ll_bubble_card);
        this.f82768h = this.f82767g.findViewById(R.id.view_arrow);
        this.f82769i = (ImageView) this.f82767g.findViewById(R.id.iv_close);
        this.f82770j = (TextView) this.f82767g.findViewById(R.id.tv_content);
        this.f82771k = (TextView) this.f82767g.findViewById(R.id.tv_sub_content);
        this.f82772l = (TextView) this.f82767g.findViewById(R.id.tv_negative);
        this.f82773m = (TextView) this.f82767g.findViewById(R.id.tv_positive);
        this.f82775o = (TextView) this.f82767g.findViewById(R.id.tv_current_step);
        this.f82774n = (TextView) this.f82767g.findViewById(R.id.tv_all_step);
    }

    public final void initWindow() {
        setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(BadgeDrawable.TOP_START);
        }
    }

    public final void makeContentWidthMatters() {
        ViewGroup.LayoutParams layoutParams = this.f82771k.getLayoutParams();
        layoutParams.width = this.f82762b;
        this.f82771k.setLayoutParams(layoutParams);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f82777q = getActivity();
        if (!this.f82779s) {
            forbidNightMode();
        }
        if (this.f82776p.f82796p) {
            this.f82767g = LayoutInflater.from(this.f82777q).inflate(R.layout.layout_text_bubble, viewGroup, true);
        } else {
            this.f82767g = LayoutInflater.from(this.f82777q).inflate(R.layout.layout_text_bubble_top, viewGroup, true);
        }
        initWindow();
        initView();
        b bVar = this.f82776p;
        if (bVar != null) {
            setContent(bVar.f82784d);
            b bVar2 = this.f82776p;
            setSubContent(bVar2.f82785e, bVar2.f82786f);
            setNegText(this.f82776p.f82787g);
            Fh(this.f82776p.f82788h);
            Eh(this.f82776p.f82783c);
            setPosText(this.f82776p.f82789i);
            setPosTextColor(this.f82776p.f82790j);
            Gh(this.f82776p.f82791k);
            Hh(this.f82776p);
        }
        makeContentWidthMatters();
        return this.f82767g;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onStart() {
        super.onStart();
        if (!vh()) {
            this.f82771k.postDelayed(new e(this), 200);
        } else {
            afterLayout();
        }
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public final void setContent(String str) {
        this.f82770j.setText(str);
        this.f82770j.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public final void setNegText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f82772l.setVisibility(8);
            return;
        }
        this.f82772l.setVisibility(0);
        this.f82772l.setText(str);
    }

    public final void setPosText(String str) {
        this.f82773m.setText(str);
    }

    public final void setPosTextColor(int i11) {
        if (i11 != 0) {
            this.f82773m.setTextColor(i11);
        }
    }

    public final void setSubContent(String str, int i11) {
        if (!TextUtils.isEmpty(str)) {
            this.f82771k.setVisibility(0);
            if (i11 >= 0) {
                this.f82771k.setTextColor(i11);
            }
            this.f82771k.setText(str);
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void show() {
        b bVar = this.f82776p;
        if (bVar != null) {
            showAllowingStateLoss(bVar.f82781a.getSupportFragmentManager(), "HeavyBubbleDialog");
        }
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        if (!isAdded()) {
            try {
                fragmentManager.q().s(this).k();
                Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
                declaredField.setAccessible(true);
                declaredField.set(this, Boolean.FALSE);
                Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
                declaredField2.setAccessible(true);
                declaredField2.set(this, Boolean.TRUE);
                FragmentTransaction q11 = fragmentManager.q();
                q11.e(this, str);
                q11.k();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void showAnim() {
        int[] iArr = new int[2];
        this.f82768h.getLocationInWindow(iArr);
        this.f82767g.setPivotX(((float) iArr[0]) + (((float) this.f82763c) / 2.0f));
        this.f82767g.setPivotY((float) iArr[1]);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f82767g, View.SCALE_X, new float[]{0.0f, 1.06f});
        ofFloat.setDuration(300);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f82767g, View.SCALE_X, new float[]{1.06f, 1.0f});
        ofFloat2.setDuration(200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofFloat, ofFloat2});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f82767g, View.SCALE_Y, new float[]{0.0f, 1.06f});
        ofFloat3.setDuration(300);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f82767g, View.SCALE_Y, new float[]{1.06f, 1.0f});
        ofFloat4.setDuration(200);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(new Animator[]{ofFloat3, ofFloat4});
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet3.playTogether(new Animator[]{animatorSet, animatorSet2});
        this.f82767g.setVisibility(0);
        animatorSet3.start();
    }

    public boolean vh() {
        b bVar = this.f82776p;
        if (bVar == null) {
            return false;
        }
        View view = bVar.f82782b;
        int[] anchorViewLocation = getAnchorViewLocation();
        Window window = getDialog().getWindow();
        if (window == null) {
            return false;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f82768h.getLayoutParams();
        attributes.width = this.f82762b;
        if (xh(anchorViewLocation[1])) {
            attributes.y = ((anchorViewLocation[1] - ViewUtil.g()) - Ch(this.f82767g)[1]) - this.f82766f;
            layoutParams.gravity = 80;
        } else {
            attributes.y = ((anchorViewLocation[1] + view.getHeight()) - ViewUtil.g()) + this.f82766f;
            layoutParams.gravity = 48;
        }
        float width = ((float) anchorViewLocation[0]) + (((float) view.getWidth()) / 2.0f);
        int i11 = this.f82762b;
        if (wh(i11, (int) (width - (((float) i11) / 2.0f)))) {
            attributes.gravity = BadgeDrawable.TOP_START;
            attributes.x = (PixelUtils.g() - this.f82762b) - this.f82764d;
            layoutParams.setMarginStart(0);
            layoutParams.setMarginEnd(this.f82765e);
            layoutParams.gravity = 8388613 | layoutParams.gravity;
        } else if (this.f82776p.f82795o == 17) {
            attributes.gravity = BadgeDrawable.TOP_START;
            attributes.x = (PixelUtils.g() - this.f82762b) / 2;
            layoutParams.setMarginEnd(0);
            layoutParams.gravity |= 8388611;
            layoutParams.setMarginStart((anchorViewLocation[0] - attributes.x) + this.f82765e);
        } else {
            attributes.gravity = BadgeDrawable.TOP_START;
            attributes.x = this.f82764d;
            layoutParams.setMarginEnd(0);
            layoutParams.gravity |= 8388611;
            layoutParams.setMarginStart(this.f82765e);
        }
        this.f82768h.setLayoutParams(layoutParams);
        window.setAttributes(attributes);
        window.setLayout(this.f82762b, -2);
        if (anchorViewLocation[0] == 0 && anchorViewLocation[1] == 0) {
            return false;
        }
        return true;
    }

    public final boolean wh(int i11, int i12) {
        return this.f82776p.f82795o == 5 || i12 + i11 > PixelUtils.g();
    }

    public final boolean xh(int i11) {
        return !this.f82776p.f82796p;
    }
}
