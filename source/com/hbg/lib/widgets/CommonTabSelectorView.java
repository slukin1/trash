package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;

public class CommonTabSelectorView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<y9.a> f71256b;

    /* renamed from: c  reason: collision with root package name */
    public int f71257c;

    /* renamed from: d  reason: collision with root package name */
    public AnimatorSet f71258d;

    /* renamed from: e  reason: collision with root package name */
    public AnimatorSet f71259e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71260f;

    /* renamed from: g  reason: collision with root package name */
    public View f71261g;

    /* renamed from: h  reason: collision with root package name */
    public b f71262h;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            CommonTabSelectorView.this.setVisibility(8);
            if (CommonTabSelectorView.this.f71262h != null) {
                CommonTabSelectorView.this.f71262h.onHide();
            }
        }
    }

    public interface b {
        void onHide();

        void onShow();
    }

    public CommonTabSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        d();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        d();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void d() {
        this.f71260f = false;
        AnimatorSet animatorSet = this.f71259e;
        if (animatorSet == null || !animatorSet.isRunning()) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f71259e = animatorSet2;
            animatorSet2.setDuration(270);
            this.f71259e.setInterpolator(new DecelerateInterpolator());
            this.f71259e.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f71256b, FrameLayout.TRANSLATION_Y, new float[]{0.0f, (float) (-this.f71257c)}), ObjectAnimator.ofFloat(this.f71261g, FrameLayout.ALPHA, new float[]{0.2f, 0.0f})});
            this.f71259e.addListener(new a());
            this.f71259e.start();
        }
    }

    public boolean e() {
        return this.f71260f;
    }

    public void h() {
        this.f71260f = true;
        AnimatorSet animatorSet = this.f71258d;
        if (animatorSet == null || !animatorSet.isRunning()) {
            this.f71257c = getResources().getDimensionPixelOffset(R$dimen.dimen_72_5) + (Math.max((this.f71256b.getItemCount() - 1) / 3, 0) * getResources().getDimensionPixelOffset(R$dimen.dimen_40));
            setVisibility(0);
            b bVar = this.f71262h;
            if (bVar != null) {
                bVar.onShow();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f71258d = animatorSet2;
            animatorSet2.setDuration(270);
            this.f71258d.setInterpolator(new DecelerateInterpolator());
            this.f71258d.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f71256b, FrameLayout.TRANSLATION_Y, new float[]{(float) (-this.f71257c), 0.0f}), ObjectAnimator.ofFloat(this.f71261g, FrameLayout.ALPHA, new float[]{0.0f, 0.2f})});
            this.f71258d.start();
        }
    }

    public void setCallback(b bVar) {
        this.f71262h = bVar;
    }

    public void setDataList(List<y9.a> list) {
        this.f71256b.setData(list);
    }

    public CommonTabSelectorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        FrameLayout.inflate(context, R$layout.common_tab_selector_view, this);
        this.f71256b = (EasyRecyclerView) findViewById(R$id.id_common_tab_selector_view_recyclerView);
        this.f71261g = findViewById(R$id.id_common_tab_selector_view_shape);
        this.f71256b.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.f71256b.addItemDecoration(new oa.b(getContext()));
        this.f71261g.setOnClickListener(new a0(this));
        setOnClickListener(new z(this));
    }
}
