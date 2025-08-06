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
import com.tencent.rtmp.TXLivePushConfig;
import gs.g;
import i6.i;
import i6.n;
import i6.r;
import java.util.HashMap;
import pro.huobi.R;

public class IndexHomeGiftDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public SafeLottieView f73708b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73709c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f73710d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f73711e;

    /* renamed from: f  reason: collision with root package name */
    public View f73712f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f73713g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f73714h;

    /* renamed from: i  reason: collision with root package name */
    public View f73715i;

    /* renamed from: j  reason: collision with root package name */
    public String f73716j;

    /* renamed from: k  reason: collision with root package name */
    public String f73717k;

    /* renamed from: l  reason: collision with root package name */
    public String f73718l;

    /* renamed from: m  reason: collision with root package name */
    public String f73719m;

    /* renamed from: n  reason: collision with root package name */
    public int[] f73720n;

    /* renamed from: o  reason: collision with root package name */
    public int f73721o;

    /* renamed from: p  reason: collision with root package name */
    public PathMeasure f73722p;

    /* renamed from: q  reason: collision with root package name */
    public float[] f73723q = new float[2];

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f73724b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f73725c;

        public a(float f11, float f12) {
            this.f73724b = f11;
            this.f73725c = f12;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IndexHomeGiftDialogFragment.this.f73722p.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), IndexHomeGiftDialogFragment.this.f73723q, (float[]) null);
            IndexHomeGiftDialogFragment.this.f73712f.setTranslationX(IndexHomeGiftDialogFragment.this.f73723q[0] - this.f73724b);
            IndexHomeGiftDialogFragment.this.f73712f.setTranslationY(IndexHomeGiftDialogFragment.this.f73723q[1] - this.f73725c);
        }
    }

    public class b implements Animator.AnimatorListener {
        public b() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            IndexHomeGiftDialogFragment.this.dismiss();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ah() {
        this.f73709c.setVisibility(0);
        this.f73713g.setVisibility(0);
        this.f73714h.setVisibility(0);
        this.f73715i.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f73709c, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(300);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f73713g, "alpha", new float[]{0.0f, 1.0f});
        ofFloat2.setDuration(300);
        ofFloat2.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bh() {
        this.f73711e.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f73711e, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(300);
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        this.f73714h.setVisibility(8);
        this.f73715i.setVisibility(8);
        this.f73710d.setVisibility(8);
        n.g(getContext());
        float height = ((float) this.f73712f.getHeight()) / 2.0f;
        float width = ((float) this.f73712f.getWidth()) / 2.0f;
        int[] iArr = this.f73720n;
        int i11 = iArr[0];
        int i12 = iArr[1] + (this.f73721o / 2);
        Path path = new Path();
        path.moveTo(width, height);
        path.quadTo(width, (float) (i12 + 50), (float) i11, (float) i12);
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f73722p = pathMeasure;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, pathMeasure.getLength()});
        ofFloat.addUpdateListener(new a(width, height));
        ofFloat.addListener(new b());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f73712f, "alpha", new float[]{1.0f, 0.7f});
        ofFloat2.setDuration(300);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f73712f, "alpha", new float[]{0.7f, 0.0f});
        ofFloat3.setDuration(200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat3});
        animatorSet.start();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f73712f, "scaleX", new float[]{1.0f, 0.1f});
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f73712f, "scaleY", new float[]{1.0f, 0.1f});
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(new Animator[]{ofFloat, ofFloat4, ofFloat5});
        animatorSet2.setDuration(500);
        animatorSet2.start();
        g.i("home_page_activity_pop_close_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        HBBaseWebActivity.showWebView(getActivity(), this.f73719m, (String) null, "", false);
        HashMap hashMap = new HashMap();
        hashMap.put("title_code", this.f73718l);
        g.i("home_page_activity_pop_click", hashMap);
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        this.f73710d.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f73710d, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f73710d, "scaleX", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f73710d, "scaleY", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setDuration(400);
        animatorSet.start();
    }

    public void addEvent(r rVar) {
        this.f73714h.setOnClickListener(new t0(this));
        this.f73711e.setOnClickListener(new s0(this));
    }

    public void afterInit() {
        this.f73709c.setText(this.f73716j);
        this.f73713g.setText(this.f73717k);
        customizeWindowDimAmount();
    }

    public void customizeWindowDimAmount() {
        TypedValue typedValue = new TypedValue();
        getResources().getValue(R.dimen.dialog_window_08, typedValue, true);
        setWindowDimAmount(typedValue.getFloat());
    }

    public int getContentViewResId() {
        return R.layout.dialog_index_home_gift;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        SafeLottieView safeLottieView = (SafeLottieView) rVar.b(R.id.index_red_page_view);
        this.f73708b = safeLottieView;
        safeLottieView.setImageAssetsFolder("images/");
        this.f73709c = (TextView) rVar.b(R.id.index_red_package_value_tv);
        this.f73713g = (TextView) rVar.b(R.id.index_red_package_currency_tv);
        this.f73711e = (TextView) rVar.b(R.id.index_red_package_receive_tv);
        this.f73712f = rVar.b(R.id.red_package_container);
        this.f73714h = (ImageView) rVar.b(R.id.close_iv);
        this.f73715i = rVar.b(R.id.divider);
        this.f73710d = (TextView) rVar.b(R.id.red_package_title);
        int i11 = 0;
        setCanceledOnTouchOutside(false);
        setCanDismissOnBackPress(false);
        float g11 = (float) n.g(getContext());
        int f11 = n.f(getContext());
        float f12 = 375.0f / g11;
        if (g11 / ((float) f11) < 0.5625f) {
            i11 = 100;
        }
        float f13 = (float) (-i11);
        this.f73708b.setTranslationY(f13);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f73710d.getLayoutParams();
        if (n.j(getContext())) {
            layoutParams.bottomMargin = f11 - ((int) (198.0f / f12));
        } else {
            layoutParams.bottomMargin = (f11 - ((int) (198.0f / f12))) - n.b(getActivity());
        }
        this.f73710d.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f73709c.getLayoutParams();
        layoutParams2.topMargin = ((int) (303.0f / f12)) - i11;
        this.f73709c.setLayoutParams(layoutParams2);
        this.f73709c.setMaxWidth((int) (g11 * 0.55733335f));
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f73713g.getLayoutParams();
        layoutParams3.topMargin = ((int) (358.0f / f12)) - i11;
        this.f73713g.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f73711e.getLayoutParams();
        layoutParams4.topMargin = ((int) (466.0f / f12)) - i11;
        this.f73711e.setLayoutParams(layoutParams4);
        this.f73715i.setTranslationY(f13);
        this.f73714h.setTranslationY(f13);
        i.b().g(new u0(this), 530);
        i.b().g(new w0(this), 930);
        i.b().g(new v0(this), TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE);
    }

    public boolean isTransparent() {
        return false;
    }

    public void onPause() {
        super.onPause();
        this.f73708b.cancelAnimation();
        this.f73708b.setProgress(0.0f);
    }

    public void onResume() {
        super.onResume();
        this.f73708b.playAnimation();
    }
}
