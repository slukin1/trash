package com.huobi.setting.viewhandler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hr.e;
import i6.d;
import i6.r;
import kr.g;
import pro.huobi.R;
import s9.c;

public class SettingNotificationPushExpandItemHandler implements c, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f80836b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f80837c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f80838d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f80839e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f80840f;

    /* renamed from: g  reason: collision with root package name */
    public View f80841g;

    /* renamed from: h  reason: collision with root package name */
    public SwitchCompat f80842h;

    /* renamed from: i  reason: collision with root package name */
    public int f80843i = -1;

    /* renamed from: j  reason: collision with root package name */
    public AnimatorSet f80844j;

    /* renamed from: k  reason: collision with root package name */
    public AnimatorSet f80845k;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f80846b;

        public a(View view) {
            this.f80846b = view;
        }

        public void onAnimationEnd(Animator animator) {
            View view = this.f80846b;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        g(this.f80836b, 0);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, e eVar, ViewGroup viewGroup) {
        if (cVar != null && eVar != null) {
            if (this.f80843i == -1) {
                this.f80843i = cVar.itemView.getResources().getDimensionPixelOffset(R.dimen.dimen_100);
            }
            r e11 = cVar.e();
            cVar.itemView.setTag(eVar);
            TextView textView = (TextView) e11.b(R.id.id_setting_list_item_title);
            TextView textView2 = (TextView) e11.b(R.id.id_setting_list_item_sub_title);
            this.f80839e = (TextView) e11.b(R.id.tv_nodisturb_start_time_content);
            this.f80840f = (TextView) e11.b(R.id.tv_nodisturb_end_time_content);
            this.f80837c = (RelativeLayout) e11.b(R.id.rl_nodisturb_start_time);
            this.f80838d = (RelativeLayout) e11.b(R.id.rl_nodisturb_end_time);
            this.f80842h = (SwitchCompat) e11.b(R.id.push_timepicker_switch);
            this.f80841g = e11.b(R.id.setting_list_item_divider2);
            LinearLayout linearLayout = (LinearLayout) e11.b(R.id.rl_expand_area);
            this.f80836b = linearLayout;
            linearLayout.setZ(-20.0f);
            this.f80842h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            boolean s11 = eVar.a().s(eVar.c());
            d.e("tab", "isChecked == " + s11 + " switchCompat.isChecked() == " + this.f80842h.isChecked());
            if (s11 != this.f80842h.isChecked()) {
                this.f80842h.setChecked(s11);
                if (this.f80842h.isChecked()) {
                    cVar.itemView.postDelayed(new g(this), 50);
                } else {
                    g(this.f80836b, 8);
                }
            }
            this.f80842h.setOnCheckedChangeListener(this);
            this.f80842h.setTag(eVar);
            String g11 = eVar.a().g(eVar.c());
            if (!TextUtils.isEmpty(g11)) {
                textView2.setText(g11);
            }
            textView.setText(eVar.a().a(eVar.c()));
            this.f80839e.setText(eVar.a().f());
            this.f80840f.setText(eVar.a().e());
            this.f80837c.setOnClickListener(this);
            this.f80837c.setTag(eVar);
            this.f80838d.setOnClickListener(this);
            this.f80838d.setTag(eVar);
        }
    }

    public void d(View view) {
        AnimatorSet animatorSet = this.f80845k;
        if ((animatorSet == null || !animatorSet.isRunning()) && view != null && (view.getParent() instanceof View)) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f80845k = animatorSet2;
            animatorSet2.setDuration(270);
            this.f80845k.setInterpolator(new DecelerateInterpolator());
            this.f80845k.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.f80843i)}), ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f, 0.0f})});
            this.f80845k.addListener(new a(view));
            this.f80845k.start();
        }
    }

    public void f(View view) {
        AnimatorSet animatorSet = this.f80844j;
        if ((animatorSet == null || !animatorSet.isRunning()) && view != null && (view.getParent() instanceof View)) {
            view.setVisibility(0);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f80844j = animatorSet2;
            animatorSet2.setDuration(270);
            this.f80844j.setInterpolator(new DecelerateInterpolator());
            this.f80844j.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{(float) (-this.f80843i), 0.0f}), ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f, 1.0f})});
            this.f80844j.start();
        }
    }

    public final void g(View view, int i11) {
        if (i11 == 0) {
            f(view);
            this.f80841g.setVisibility(0);
            view.setVisibility(0);
            return;
        }
        d(view);
        this.f80841g.setVisibility(8);
    }

    public int getResId() {
        return R.layout.layout_setting_notification_push_expand_list_item;
    }

    @SensorsDataInstrumented
    public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        e eVar = (e) compoundButton.getTag();
        if (!(compoundButton.getId() != R.id.push_timepicker_switch || eVar == null || eVar.a() == null)) {
            eVar.a().d(eVar.c(), compoundButton.isChecked());
            if (compoundButton.isChecked()) {
                g(this.f80836b, 0);
            } else {
                g(this.f80836b, 8);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        e eVar = (e) view.getTag();
        if (eVar == null || eVar.a() == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (view.getId() == R.id.rl_nodisturb_start_time) {
            eVar.a().E(eVar.c(), 0);
        } else if (view.getId() == R.id.rl_nodisturb_end_time) {
            eVar.a().E(eVar.c(), 1);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
