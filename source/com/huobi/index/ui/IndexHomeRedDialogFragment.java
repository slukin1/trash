package com.huobi.index.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.youth.banner.config.BannerConfig;
import gs.g;
import i6.i;
import i6.n;
import i6.r;
import java.util.HashMap;
import pro.huobi.R;

public class IndexHomeRedDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public SafeLottieView f73728b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73729c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f73730d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f73731e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f73732f;

    /* renamed from: g  reason: collision with root package name */
    public View f73733g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f73734h;

    /* renamed from: i  reason: collision with root package name */
    public String f73735i;

    /* renamed from: j  reason: collision with root package name */
    public String f73736j;

    /* renamed from: k  reason: collision with root package name */
    public String f73737k;

    /* renamed from: l  reason: collision with root package name */
    public String f73738l;

    /* renamed from: m  reason: collision with root package name */
    public int[] f73739m;

    /* renamed from: n  reason: collision with root package name */
    public int f73740n;

    /* renamed from: o  reason: collision with root package name */
    public PathMeasure f73741o;

    /* renamed from: p  reason: collision with root package name */
    public float[] f73742p = new float[2];

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f73743b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f73744c;

        public a(float f11, float f12) {
            this.f73743b = f11;
            this.f73744c = f12;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IndexHomeRedDialogFragment.this.f73741o.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), IndexHomeRedDialogFragment.this.f73742p, (float[]) null);
            IndexHomeRedDialogFragment.this.f73733g.setTranslationX(IndexHomeRedDialogFragment.this.f73742p[0] - this.f73743b);
            IndexHomeRedDialogFragment.this.f73733g.setTranslationY(IndexHomeRedDialogFragment.this.f73742p[1] - this.f73744c);
        }
    }

    public class b implements Animator.AnimatorListener {
        public b() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            IndexHomeRedDialogFragment.this.dismiss();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        this.f73732f.setVisibility(8);
        this.f73734h.setVisibility(8);
        this.f73731e.setVisibility(8);
        this.f73730d.getLocationOnScreen(new int[2]);
        float width = ((float) this.f73733g.getWidth()) / 2.0f;
        float height = ((float) this.f73733g.getHeight()) / 2.0f;
        int[] iArr = this.f73739m;
        int i11 = iArr[0];
        int i12 = iArr[1] + (this.f73740n / 2);
        Path path = new Path();
        path.moveTo(width, height);
        path.quadTo(width, (float) (i12 + 50), (float) i11, (float) i12);
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f73741o = pathMeasure;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, pathMeasure.getLength()});
        ofFloat.addUpdateListener(new a(width, height));
        ofFloat.addListener(new b());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f73733g, "alpha", new float[]{1.0f, 0.7f});
        ofFloat2.setDuration(300);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f73733g, "alpha", new float[]{0.7f, 0.0f});
        ofFloat3.setDuration(200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat3});
        animatorSet.start();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f73733g, "scaleX", new float[]{1.0f, 0.1f});
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f73733g, "scaleY", new float[]{1.0f, 0.1f});
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(new Animator[]{ofFloat, ofFloat4, ofFloat5});
        animatorSet2.setDuration(500);
        animatorSet2.start();
        g.i("home_page_activity_pop_close_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        HBBaseWebActivity.showWebView(getActivity(), this.f73738l, (String) null, "", false);
        HashMap hashMap = new HashMap();
        hashMap.put("title_code", this.f73737k);
        g.i("home_page_activity_pop_click", hashMap);
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        this.f73731e.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f73731e, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f73731e, "scaleX", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f73731e, "scaleY", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setDuration(400);
        animatorSet.start();
        this.f73732f.setVisibility(0);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f73732f, "alpha", new float[]{0.0f, 1.0f});
        ofFloat4.setDuration(300);
        ofFloat4.start();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f73732f, "scaleX", new float[]{1.0f, 1.1f, 1.0f});
        ofFloat5.setRepeatCount(-1);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f73732f, "scaleY", new float[]{1.0f, 1.1f, 1.0f});
        ofFloat6.setRepeatCount(-1);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(new Animator[]{ofFloat5, ofFloat6});
        animatorSet2.setDuration(1200);
        animatorSet2.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh() {
        this.f73729c.setVisibility(0);
        this.f73730d.setVisibility(0);
        this.f73734h.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f73729c, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f73730d, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(300);
        animatorSet.start();
    }

    public void addEvent(r rVar) {
        this.f73734h.setOnClickListener(new x0(this));
        this.f73732f.setOnClickListener(new y0(this));
    }

    public void afterInit() {
        this.f73729c.setText(this.f73735i);
        this.f73730d.setText(this.f73736j);
        customizeWindowDimAmount();
    }

    public void customizeWindowDimAmount() {
        TypedValue typedValue = new TypedValue();
        getResources().getValue(R.dimen.dialog_window_08, typedValue, true);
        setWindowDimAmount(typedValue.getFloat());
    }

    public int getContentViewResId() {
        return R.layout.dialog_index_home_red;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        SafeLottieView safeLottieView = (SafeLottieView) rVar.b(R.id.index_red_page_view);
        this.f73728b = safeLottieView;
        safeLottieView.setImageAssetsFolder("images/");
        this.f73729c = (TextView) rVar.b(R.id.index_red_package_value_tv);
        this.f73730d = (TextView) rVar.b(R.id.index_red_package_currency_tv);
        this.f73732f = (TextView) rVar.b(R.id.index_red_package_receive_tv);
        this.f73734h = (ImageView) rVar.b(R.id.close_iv);
        this.f73731e = (TextView) rVar.b(R.id.red_package_title);
        this.f73733g = rVar.b(R.id.red_package_container);
        int i11 = 0;
        setCanceledOnTouchOutside(false);
        setCanDismissOnBackPress(false);
        float g11 = (float) n.g(getContext());
        int f11 = n.f(getContext());
        if (g11 / ((float) f11) < 0.5625f) {
            i11 = 65;
        }
        this.f73728b.setTranslationY((float) (-i11));
        float f12 = 375.0f / g11;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f73731e.getLayoutParams();
        if (n.j(getContext())) {
            layoutParams.bottomMargin = f11 - ((int) (230.0f / f12));
        } else {
            layoutParams.bottomMargin = (f11 - ((int) (230.0f / f12))) - n.b(getActivity());
        }
        this.f73731e.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f73729c.getLayoutParams();
        layoutParams2.topMargin = ((int) (305.0f / f12)) - i11;
        this.f73729c.setLayoutParams(layoutParams2);
        this.f73729c.setMaxWidth((int) (g11 * 0.33466667f));
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f73730d.getLayoutParams();
        layoutParams3.topMargin = ((int) (350.0f / f12)) - i11;
        this.f73730d.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f73732f.getLayoutParams();
        layoutParams4.topMargin = ((int) (521.0f / f12)) - i11;
        this.f73732f.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f73734h.getLayoutParams();
        layoutParams5.topMargin = (int) (75.0f / f12);
        this.f73734h.setLayoutParams(layoutParams5);
        i.b().g(new a1(this), BannerConfig.SCROLL_TIME);
        i.b().g(new z0(this), 930);
    }

    public boolean isTransparent() {
        return false;
    }

    public void onPause() {
        super.onPause();
        this.f73728b.cancelAnimation();
        this.f73728b.setProgress(0.0f);
    }

    public void onResume() {
        super.onResume();
        this.f73728b.playAnimation();
    }
}
