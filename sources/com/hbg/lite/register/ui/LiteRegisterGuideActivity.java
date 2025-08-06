package com.hbg.lite.register.ui;

import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lite.R$anim;
import com.hbg.lite.R$color;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.base.LiteBaseActivity;
import com.hbg.lite.register.presenter.LiteRegisterGuidePresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import kb.b;
import nb.c;

public class LiteRegisterGuideActivity extends LiteBaseActivity<LiteRegisterGuidePresenter, LiteRegisterGuidePresenter.a> implements LiteRegisterGuidePresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f77437b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f77438c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f77439d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f77440e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f77441f;

    /* renamed from: g  reason: collision with root package name */
    public SafeLottieView f77442g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f77443h;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            c.i(LiteRegisterGuideActivity.this, false, false, true);
            boolean unused = LiteRegisterGuideActivity.this.f77443h = true;
            LiteRegisterGuideActivity.this.finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(View view) {
        Qg();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Pg() {
        this.f77442g.playAnimation();
    }

    public final void Qg() {
        startActivity(ra.c.b().o(this));
        finish();
    }

    public void addEvent() {
        this.f77437b.setOnClickListener(new a());
        this.f77438c.setOnClickListener(new kb.a(this));
    }

    /* renamed from: fg */
    public LiteRegisterGuidePresenter createPresenter() {
        return new LiteRegisterGuidePresenter();
    }

    public void finish() {
        super.finish();
        if (!this.f77443h) {
            overridePendingTransition(0, R$anim.activity_anim_exit_from_bottom);
        }
    }

    public int getContentView() {
        return R$layout.activity_lite_register_guide;
    }

    /* renamed from: gg */
    public LiteRegisterGuidePresenter.a getUI() {
        return this;
    }

    public void initView() {
        this.f77437b = (TextView) findViewById(R$id.tv_verify_action);
        this.f77438c = (ImageView) findViewById(R$id.iv_guide_close);
        this.f77439d = (TextView) findViewById(R$id.tv_title1);
        this.f77440e = (TextView) findViewById(R$id.tv_title2);
        this.f77441f = (TextView) findViewById(R$id.tv_title3);
        this.f77442g = (SafeLottieView) findViewById(R$id.iv_success);
        float a11 = (float) PixelUtils.a(60.0f);
        this.f77439d.setTranslationY(a11);
        this.f77440e.setTranslationY(a11);
        this.f77441f.setTranslationY(a11);
        this.f77439d.setAlpha(0.0f);
        this.f77440e.setAlpha(0.0f);
        this.f77441f.setAlpha(0.0f);
        this.f77439d.animate().alpha(1.0f).translationY(0.0f).setDuration(300).setInterpolator(new DecelerateInterpolator()).setStartDelay(200).start();
        this.f77440e.animate().alpha(1.0f).translationY(0.0f).setDuration(300).setInterpolator(new DecelerateInterpolator()).setStartDelay(265).start();
        this.f77441f.animate().alpha(1.0f).translationY(0.0f).setDuration(300).setInterpolator(new DecelerateInterpolator()).setStartDelay(330).start();
        this.f77442g.postDelayed(new b(this), 300);
    }

    public void onBackPressed() {
        super.onBackPressed();
        Qg();
        finish();
    }

    public void onCreate(Bundle bundle) {
        overridePendingTransition(R$anim.activity_anim_enter_from_bottom, R$anim.activity_anim_exit_from_bottom);
        super.onCreate(bundle);
        setStatusBarColor(getResources().getColor(R$color.lite_guide_page_bg));
    }
}
