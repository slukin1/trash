package com.huobi.otc.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import java.lang.ref.WeakReference;
import java.util.List;
import vp.q0;
import vp.r0;

public class SecurityScrollLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f80127b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80128c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintLayout f80129d;

    /* renamed from: e  reason: collision with root package name */
    public View f80130e;

    /* renamed from: f  reason: collision with root package name */
    public b f80131f;

    /* renamed from: g  reason: collision with root package name */
    public int f80132g;

    /* renamed from: h  reason: collision with root package name */
    public int f80133h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f80134i = true;

    /* renamed from: j  reason: collision with root package name */
    public int f80135j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f80136k;

    /* renamed from: l  reason: collision with root package name */
    public Interpolator f80137l = new DecelerateInterpolator();

    /* renamed from: m  reason: collision with root package name */
    public boolean f80138m;

    /* renamed from: n  reason: collision with root package name */
    public ValueAnimator f80139n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f80140o;

    /* renamed from: p  reason: collision with root package name */
    public int f80141p = 0;

    public static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<SecurityScrollLayout> f80142a;

        public void handleMessage(Message message) {
            SecurityScrollLayout securityScrollLayout;
            if (message.what == 1) {
                WeakReference<SecurityScrollLayout> weakReference = this.f80142a;
                if (!(weakReference == null || (securityScrollLayout = (SecurityScrollLayout) weakReference.get()) == null)) {
                    securityScrollLayout.d();
                }
                removeMessages(1);
                sendEmptyMessageDelayed(1, 5000);
            }
        }

        public b(SecurityScrollLayout securityScrollLayout) {
            this.f80142a = new WeakReference<>(securityScrollLayout);
        }
    }

    public SecurityScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(ValueAnimator valueAnimator) {
        setShadowViewWith(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        setShadowViewWith(this.f80127b.getWidth());
    }

    private void setShadowViewWith(int i11) {
        if (this.f80133h == 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f80127b.getLayoutParams();
            this.f80133h = layoutParams.getMarginStart() + layoutParams.getMarginEnd();
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f80130e.getLayoutParams();
        layoutParams2.width = i11 + this.f80133h + this.f80141p;
        ViewGroup viewGroup = (ViewGroup) this.f80129d.getParent();
        if (layoutParams2.width > viewGroup.getWidth()) {
            layoutParams2.width = viewGroup.getWidth();
        }
        this.f80130e.setLayoutParams(layoutParams2);
        this.f80140o.setTranslationX((float) (layoutParams2.width - PixelUtils.a(33.0f)));
    }

    public final void d() {
        List<String> list = this.f80136k;
        if (list != null && list.size() > 1) {
            int i11 = this.f80135j + 1;
            if (i11 == this.f80136k.size()) {
                i11 = 0;
            }
            String e11 = e(i11);
            if (!TextUtils.isEmpty(e11) && this.f80127b != null && this.f80128c != null) {
                this.f80135j = i11;
                AnimatorSet animatorSet = new AnimatorSet();
                if (this.f80134i) {
                    this.f80128c.setText(e11);
                    this.f80128c.measure(0, 0);
                    animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f80127b, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.f80132g)}), ObjectAnimator.ofFloat(this.f80128c, View.TRANSLATION_Y, new float[]{(float) this.f80132g, 0.0f}), ObjectAnimator.ofFloat(this.f80128c, View.ALPHA, new float[]{0.0f, 1.0f})});
                    this.f80139n.setIntValues(new int[]{this.f80127b.getMeasuredWidth(), this.f80128c.getMeasuredWidth()});
                    this.f80139n.start();
                    ObjectAnimator duration = ObjectAnimator.ofFloat(this.f80127b, View.ALPHA, new float[]{1.0f, 0.0f}).setDuration(200);
                    duration.setInterpolator(this.f80137l);
                    duration.start();
                } else {
                    this.f80127b.setText(e11);
                    this.f80127b.measure(0, 0);
                    animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f80127b, View.TRANSLATION_Y, new float[]{(float) this.f80132g, 0.0f}), ObjectAnimator.ofFloat(this.f80127b, View.ALPHA, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(this.f80128c, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.f80132g)})});
                    this.f80139n.setIntValues(new int[]{this.f80128c.getMeasuredWidth(), this.f80127b.getMeasuredWidth()});
                    this.f80139n.start();
                    ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f80128c, View.ALPHA, new float[]{1.0f, 0.0f}).setDuration(200);
                    duration2.setInterpolator(this.f80137l);
                    duration2.start();
                }
                animatorSet.setDuration(500);
                animatorSet.setInterpolator(this.f80137l);
                animatorSet.start();
                this.f80134i = !this.f80134i;
            }
        }
    }

    public final String e(int i11) {
        List<String> list = this.f80136k;
        if (list == null || list.isEmpty() || i11 >= this.f80136k.size()) {
            return null;
        }
        return this.f80136k.get(i11);
    }

    public final void f(Context context) {
        this.f80132g = getResources().getDimensionPixelOffset(R$dimen.dimen_30);
        this.f80131f = new b();
        g(context);
    }

    public final void g(Context context) {
        FrameLayout.inflate(context, R$layout.layout_security_scroll_view, this);
        this.f80127b = (TextView) findViewById(R$id.index_security_tv);
        this.f80128c = (TextView) findViewById(R$id.index_security_tv2);
        this.f80129d = (ConstraintLayout) findViewById(R$id.root_container);
        this.f80130e = findViewById(R$id.shadow_view);
        this.f80140o = (ImageView) findViewById(R$id.right_icon_iv);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f80139n = valueAnimator;
        valueAnimator.setInterpolator(this.f80137l);
        this.f80139n.setDuration(500);
        this.f80139n.addUpdateListener(new q0(this));
    }

    public void setDatas(List<String> list) {
        if (!list.isEmpty()) {
            this.f80136k = list;
            if (!this.f80138m) {
                this.f80138m = true;
                this.f80135j = 0;
                this.f80134i = true;
                this.f80127b.setText(list.get(0));
                this.f80127b.post(new r0(this));
                this.f80128c.setText("");
            }
        }
    }

    public SecurityScrollLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        f(context);
    }
}
