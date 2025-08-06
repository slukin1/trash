package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonTabLayout extends FrameLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public int f71232b;

    /* renamed from: c  reason: collision with root package name */
    public int f71233c;

    /* renamed from: d  reason: collision with root package name */
    public int f71234d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71235e;

    /* renamed from: f  reason: collision with root package name */
    public float f71236f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f71237g;

    /* renamed from: h  reason: collision with root package name */
    public View f71238h;

    /* renamed from: i  reason: collision with root package name */
    public int f71239i;

    /* renamed from: j  reason: collision with root package name */
    public final List<String> f71240j;

    /* renamed from: k  reason: collision with root package name */
    public int f71241k;

    /* renamed from: l  reason: collision with root package name */
    public float f71242l;

    /* renamed from: m  reason: collision with root package name */
    public int f71243m;

    /* renamed from: n  reason: collision with root package name */
    public int f71244n;

    /* renamed from: o  reason: collision with root package name */
    public int f71245o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f71246p;

    /* renamed from: q  reason: collision with root package name */
    public int f71247q;

    /* renamed from: r  reason: collision with root package name */
    public d f71248r;

    /* renamed from: s  reason: collision with root package name */
    public final Interpolator f71249s;

    /* renamed from: t  reason: collision with root package name */
    public RotateAnimation f71250t;

    /* renamed from: u  reason: collision with root package name */
    public float f71251u;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f71253b;

        public b(ImageView imageView) {
            this.f71253b = imageView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f71253b.setImageResource(0);
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public class c implements Animation.AnimationListener {
        public c() {
        }

        public void onAnimationEnd(Animation animation) {
            animation.reset();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public interface d {
        void a(int i11, CommonTabLayout commonTabLayout);
    }

    public CommonTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(int i11, boolean z11) {
        this.f71247q = getWidth();
        g(i11, z11);
    }

    public final void d(int i11, String str) {
        LinearLayout.LayoutParams layoutParams;
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.view_common_tab_layout_item, (ViewGroup) null);
        if (this.f71233c <= 0) {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
            inflate.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
        } else {
            inflate.measure(0, 0);
            layoutParams = new LinearLayout.LayoutParams(Math.max(this.f71232b / this.f71233c, inflate.getMeasuredWidth()), -1, 1.0f);
        }
        inflate.setLayoutParams(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_tab_item_text);
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.f71242l);
        textView.setTextColor(this.f71244n);
        textView.getPaint().setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_tab_item_icon);
        if (i11 != 0) {
            imageView.setVisibility(0);
            imageView.setImageResource(i11);
        } else {
            imageView.setVisibility(8);
        }
        inflate.setOnClickListener(this);
        this.f71237g.addView(inflate);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f71247q = getWidth();
        if (isInEditMode() && this.f71247q != 0 && !this.f71246p) {
            this.f71246p = true;
            q(this.f71239i, false);
        }
    }

    public final void e(String str) {
        LinearLayout.LayoutParams layoutParams;
        TextView textView = new TextView(getContext());
        if (this.f71233c <= 0) {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
            textView.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
        } else {
            layoutParams = new LinearLayout.LayoutParams(Math.max(this.f71232b / this.f71233c, (int) (((double) textView.getPaint().measureText(str)) + 0.5d)), -1, 1.0f);
        }
        textView.getPaint().setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        textView.setLayoutParams(layoutParams);
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.f71242l);
        textView.setTextColor(this.f71244n);
        textView.setOnClickListener(this);
        this.f71237g.addView(textView);
    }

    public final void f(List<String> list, String str) {
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        }
    }

    public final void g(int i11, boolean z11) {
        int size = this.f71240j.size();
        if (this.f71235e) {
            size--;
            if (i11 > 2) {
                i11--;
            }
        }
        float f11 = (float) size;
        float f12 = (((((float) this.f71247q) * 1.0f) / f11) / 2.0f) - (this.f71236f / 2.0f);
        if (!this.f71240j.isEmpty()) {
            f12 += ((float) i11) * ((((float) this.f71247q) * 1.0f) / f11);
        }
        if (z11) {
            ViewPropertyAnimator animate = this.f71238h.animate();
            animate.setInterpolator(this.f71249s);
            animate.setDuration(270);
            animate.translationX(f12);
            return;
        }
        this.f71238h.setTranslationX(f12);
    }

    public int getCurrentPosition() {
        return this.f71239i;
    }

    public List<String> getTabs() {
        return this.f71240j;
    }

    public ImageView h(int i11) {
        View childAt = this.f71237g.getChildAt(i11);
        if (childAt instanceof ViewGroup) {
            return (ImageView) childAt.findViewById(R$id.iv_tab_item_icon);
        }
        return null;
    }

    public void i(int i11) {
        this.f71237g.getChildAt(i11).setVisibility(8);
        this.f71235e = true;
    }

    public void j(ImageView imageView) {
        if (imageView != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, this.f71251u});
            ofFloat.addUpdateListener(new w(imageView));
            ofFloat.setDuration(200);
            ofFloat.addListener(new b(imageView));
            ofFloat.start();
        }
    }

    public void k(List<Integer> list, String... strArr) {
        int i11;
        this.f71240j.clear();
        if (strArr != null && strArr.length > 0) {
            this.f71240j.addAll(Arrays.asList(strArr));
        }
        this.f71237g.removeAllViews();
        if (list == null) {
            i11 = 0;
        } else {
            i11 = list.size();
        }
        int i12 = 0;
        while (i12 < this.f71240j.size()) {
            d((i11 <= 0 || i12 >= i11) ? 0 : list.get(i12).intValue(), this.f71240j.get(i12));
            i12++;
        }
    }

    public void l(String... strArr) {
        this.f71240j.clear();
        if (strArr != null && strArr.length > 0) {
            this.f71240j.addAll(Arrays.asList(strArr));
        }
        this.f71237g.removeAllViews();
        for (int i11 = 0; i11 < this.f71240j.size(); i11++) {
            e(this.f71240j.get(i11));
        }
    }

    public final void m(Context context) {
        this.f71237g = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = this.f71241k;
        this.f71237g.setLayoutParams(layoutParams);
        this.f71237g.setOrientation(0);
        addView(this.f71237g);
        this.f71238h = new View(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) this.f71236f, this.f71241k);
        layoutParams2.gravity = 80;
        this.f71238h.setLayoutParams(layoutParams2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f71245o);
        gradientDrawable.setCornerRadius((float) PixelUtils.a(1.0f));
        this.f71238h.setBackground(gradientDrawable);
        addView(this.f71238h);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int indexOfChild = this.f71237g.indexOfChild(view);
        d dVar = this.f71248r;
        if (dVar != null) {
            dVar.a(indexOfChild, this);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void q(int i11, boolean z11) {
        this.f71239i = i11;
        int size = this.f71240j.size();
        TextView textView = null;
        for (int i12 = 0; i12 < size; i12++) {
            View childAt = this.f71237g.getChildAt(i12);
            if (childAt instanceof TextView) {
                textView = (TextView) this.f71237g.getChildAt(i12);
            } else if (childAt instanceof ViewGroup) {
                textView = (TextView) childAt.findViewById(R$id.tv_tab_item_text);
            }
            if (textView != null) {
                if (i12 == i11) {
                    textView.setTextColor(this.f71243m);
                } else {
                    textView.setTextColor(this.f71244n);
                }
            }
        }
        int width = getWidth();
        this.f71247q = width;
        if (width != 0) {
            g(i11, z11);
        } else {
            post(new y(this, i11, z11));
        }
    }

    public void r(ImageView imageView) {
        if (imageView != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f71251u, 1.0f});
            ofFloat.addUpdateListener(new x(imageView));
            ofFloat.setDuration(200);
            ofFloat.addListener(new a());
            ofFloat.start();
        }
    }

    public RotateAnimation s(ImageView imageView, int i11, int i12) {
        if (imageView == null) {
            return null;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, (float) (i12 * 360), 1, 0.5f, 1, 0.5f);
        this.f71250t = rotateAnimation;
        rotateAnimation.setDuration((long) (i11 * i12));
        this.f71250t.setInterpolator(new LinearInterpolator());
        this.f71250t.setRepeatMode(1);
        this.f71250t.setFillAfter(true);
        this.f71250t.setAnimationListener(new c());
        imageView.startAnimation(this.f71250t);
        return this.f71250t;
    }

    public void setCallback(d dVar) {
        this.f71248r = dVar;
    }

    public void setSpacing(int i11) {
        this.f71234d = i11;
    }

    public void setWeightSum(int i11) {
        this.f71233c = i11;
    }

    public CommonTabLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71233c = 2;
        this.f71234d = 0;
        this.f71235e = false;
        this.f71236f = (float) PixelUtils.a(20.0f);
        this.f71239i = -1;
        this.f71240j = new ArrayList();
        this.f71249s = new DecelerateInterpolator();
        this.f71251u = 0.1f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonTabLayout, i11, 0);
        this.f71242l = obtainStyledAttributes.getDimension(R$styleable.CommonTabLayout_tab_text_size, getResources().getDimension(R$dimen.global_text_size_14));
        this.f71239i = obtainStyledAttributes.getInteger(R$styleable.CommonTabLayout_tab_current_position, 0);
        this.f71243m = obtainStyledAttributes.getColor(R$styleable.CommonTabLayout_tab_select_color, 0);
        this.f71244n = obtainStyledAttributes.getColor(R$styleable.CommonTabLayout_tab_unselect_color, 0);
        this.f71245o = obtainStyledAttributes.getColor(R$styleable.CommonTabLayout_tab_indicator_color, 0);
        this.f71241k = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CommonTabLayout_tab_indicator_height, 0);
        ArrayList arrayList = new ArrayList();
        f(arrayList, obtainStyledAttributes.getString(R$styleable.CommonTabLayout_tab_text_1));
        f(arrayList, obtainStyledAttributes.getString(R$styleable.CommonTabLayout_tab_text_2));
        f(arrayList, obtainStyledAttributes.getString(R$styleable.CommonTabLayout_tab_text_3));
        f(arrayList, obtainStyledAttributes.getString(R$styleable.CommonTabLayout_tab_text_4));
        f(arrayList, obtainStyledAttributes.getString(R$styleable.CommonTabLayout_tab_text_5));
        obtainStyledAttributes.recycle();
        m(context);
        if (!arrayList.isEmpty()) {
            String[] strArr = new String[arrayList.size()];
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                strArr[i12] = (String) arrayList.get(i12);
            }
            l(strArr);
        }
        this.f71232b = n.g(getContext());
    }
}
