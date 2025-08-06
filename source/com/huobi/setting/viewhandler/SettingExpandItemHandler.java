package com.huobi.setting.viewhandler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import bj.p0;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import kr.a;
import kr.b;
import kr.d;
import kr.e;
import pro.huobi.R;
import s9.c;

public class SettingExpandItemHandler implements c, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TransitionSet f80822b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f80823c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f80824d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f80825e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f80826f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f80827g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f80828h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f80829i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f80830j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f80831k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f80832l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f80833m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f80834n = true;

    /* access modifiers changed from: private */
    public /* synthetic */ void m() {
        TransitionManager.b((ViewGroup) this.f80823c.getParent(), this.f80822b);
        n(this.f80823c, this.f80824d);
        this.f80834n = false;
    }

    public final void g(Context context, hr.c cVar, int i11) {
        int i12 = i11;
        int color = context.getResources().getColor(R.color.baseColorMajorTheme100);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) PixelUtils.a(4.0f));
        gradientDrawable.setStroke(PixelUtils.a(1.0f), color);
        gradientDrawable.setAlpha(0);
        this.f80826f.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius((float) PixelUtils.a(4.0f));
        gradientDrawable2.setStroke(PixelUtils.a(1.0f), color);
        gradientDrawable2.setAlpha(0);
        this.f80828h.setBackground(gradientDrawable2);
        if (i12 == 0) {
            this.f80829i.setText(cVar.a().D(cVar.c()));
            this.f80831k.setTextColor(context.getResources().getColor(R.color.baseColorMajorTheme100));
            this.f80830j.setTextColor(context.getResources().getColor(R.color.baseColorSecondaryText));
            this.f80832l.setImageResource(R.drawable.marquee_selected);
            this.f80833m.setImageResource(R.drawable.marquee_unselected);
            if (Build.VERSION.SDK_INT >= 19) {
                this.f80826f.animate().scaleY(1.0f).scaleX(1.0f).setUpdateListener(new b(gradientDrawable)).setDuration(200).start();
                this.f80828h.animate().scaleY(0.95f).scaleX(0.95f).setUpdateListener(new a(gradientDrawable2)).setDuration(200).start();
                return;
            }
            int color2 = context.getResources().getColor(R.color.baseColorMajorTheme100);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setCornerRadius((float) PixelUtils.a(5.0f));
            gradientDrawable3.setStroke(PixelUtils.a(1.0f), color2);
            this.f80826f.setBackground(gradientDrawable3);
            this.f80828h.setBackground((Drawable) null);
        } else if (1 == i12) {
            this.f80829i.setText(cVar.a().D(cVar.c()));
            this.f80830j.setTextColor(context.getResources().getColor(R.color.baseColorMajorTheme100));
            this.f80831k.setTextColor(context.getResources().getColor(R.color.baseColorSecondaryText));
            this.f80833m.setImageResource(R.drawable.marquee_selected);
            this.f80832l.setImageResource(R.drawable.marquee_unselected);
            if (Build.VERSION.SDK_INT >= 19) {
                this.f80828h.animate().scaleY(1.0f).scaleX(1.0f).setUpdateListener(new kr.c(gradientDrawable2)).setDuration(200).start();
                this.f80826f.animate().scaleY(0.95f).scaleX(0.95f).setUpdateListener(new d(gradientDrawable)).setDuration(200).start();
                return;
            }
            int color3 = context.getResources().getColor(R.color.baseColorMajorTheme100);
            GradientDrawable gradientDrawable4 = new GradientDrawable();
            gradientDrawable4.setCornerRadius((float) PixelUtils.a(5.0f));
            gradientDrawable4.setStroke(PixelUtils.a(1.0f), color3);
            this.f80828h.setBackground(gradientDrawable4);
            this.f80826f.setBackground((Drawable) null);
        }
    }

    public int getResId() {
        return R.layout.layout_setting_expand_list_item;
    }

    /* renamed from: h */
    public void handleView(v9.c cVar, int i11, hr.c cVar2, ViewGroup viewGroup) {
        if (cVar != null && cVar2 != null) {
            TransitionSet transitionSet = new TransitionSet();
            this.f80822b = transitionSet;
            transitionSet.setDuration(270);
            this.f80822b.g(new Fade(2));
            this.f80822b.g(new Fade(1));
            this.f80822b.s(0);
            r e11 = cVar.e();
            cVar.itemView.setTag(cVar2);
            cVar.itemView.setOnClickListener(this);
            this.f80829i = (TextView) e11.b(R.id.id_setting_list_item_desc);
            ((TextView) e11.b(R.id.id_setting_list_item_title)).setText(cVar2.a().a(cVar2.c()));
            this.f80829i.setText(cVar2.a().D(cVar2.c()));
            this.f80824d = (ImageView) e11.b(R.id.id_setting_list_item_arrow);
            this.f80823c = (LinearLayout) e11.b(R.id.rl_expand_area);
            this.f80825e = (RelativeLayout) e11.b(R.id.rl_same_panel_area);
            this.f80827g = (RelativeLayout) e11.b(R.id.rl_split_panel_area);
            this.f80826f = (RelativeLayout) e11.b(R.id.rl_same_panel);
            this.f80828h = (RelativeLayout) e11.b(R.id.rl_split_panel);
            this.f80825e.setOnClickListener(this);
            this.f80825e.setTag(cVar2);
            this.f80827g.setOnClickListener(this);
            this.f80827g.setTag(cVar2);
            this.f80831k = (TextView) e11.b(R.id.tv_same_panel);
            this.f80830j = (TextView) e11.b(R.id.tv_split_panel);
            this.f80833m = (ImageView) e11.b(R.id.iv_split_check);
            this.f80832l = (ImageView) e11.b(R.id.iv_same_check);
            View b11 = e11.b(R.id.setting_list_item_divider);
            View b12 = e11.b(R.id.setting_list_item_divider2);
            ViewUtil.m(b11, cVar2.d());
            ViewUtil.m(b12, cVar2.d());
            g(this.f80825e.getContext(), cVar2, p0.h() ^ true ? 1 : 0);
            if (cVar2.a().F() && this.f80834n) {
                cVar.itemView.postDelayed(new e(this), 300);
            }
        }
    }

    public final void n(View view, ImageView imageView) {
        if (view.getVisibility() == 0) {
            imageView.setImageDrawable(view.getResources().getDrawable(R.drawable.trade_arrow_down));
            view.setVisibility(8);
            return;
        }
        imageView.setImageDrawable(view.getResources().getDrawable(R.drawable.trade_arrow_up));
        view.setVisibility(0);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        hr.c cVar = (hr.c) view.getTag();
        if (cVar == null || cVar.a() == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (view.getId() == R.id.rl_item) {
            cVar.a().b(cVar.c());
            TransitionManager.b((ViewGroup) this.f80823c.getParent(), this.f80822b);
            n(this.f80823c, this.f80824d);
        } else if (view.getId() == R.id.rl_same_panel_area) {
            if (!(!p0.h())) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            } else {
                cVar.a().E(cVar.c(), 0);
                g(view.getContext(), cVar, 0);
            }
        } else if (view.getId() == R.id.rl_split_panel_area) {
            if (!p0.h()) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            } else {
                cVar.a().E(cVar.c(), 1);
                g(view.getContext(), cVar, 1);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
