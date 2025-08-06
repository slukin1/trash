package com.hbg.lib.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.widgets.TopScrollItemView;
import i6.d;

public class TopScrollNoticeItemView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TopScrollItemView.a f71638b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f71639c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f71640d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f71641e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f71642f;

    /* renamed from: g  reason: collision with root package name */
    public TopScrollData f71643g;

    /* renamed from: h  reason: collision with root package name */
    public int f71644h;

    /* renamed from: i  reason: collision with root package name */
    public int f71645i;

    /* renamed from: j  reason: collision with root package name */
    public TextUtils.TruncateAt f71646j;

    /* renamed from: k  reason: collision with root package name */
    public ObjectAnimator f71647k;

    /* renamed from: l  reason: collision with root package name */
    public final Interpolator f71648l;

    public TopScrollNoticeItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        if (this.f71645i == 1) {
            d.b("TopScrollItemView-->continueAnim-->" + this.f71644h + "-->" + this.f71643g + "-->滑出去了");
            this.f71645i = 2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LinearLayout.TRANSLATION_Y, new float[]{0.0f, (float) (-getHeight())});
            this.f71647k = ofFloat;
            ofFloat.setInterpolator(this.f71648l);
            this.f71647k.setDuration(500);
            this.f71647k.start();
            return;
        }
        d.b("TopScrollItemView-->continueAnim-->" + this.f71644h + "-->" + this.f71643g + "-->没动");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(TopScrollData topScrollData) {
        d.b("TopScrollItemView-->startAnim-->" + this.f71644h + "-->" + this.f71643g + "-->滑上来了");
        this.f71645i = 1;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LinearLayout.TRANSLATION_Y, new float[]{(float) getHeight(), 0.0f});
        this.f71647k = ofFloat;
        ofFloat.setInterpolator(this.f71648l);
        this.f71647k.setDuration(500);
        this.f71647k.start();
        TopScrollItemView.a aVar = this.f71638b;
        if (aVar != null) {
            aVar.a(topScrollData);
        }
    }

    private void setTvLeftHintBackgroundColor(TopScrollData topScrollData) {
        GradientDrawable gradientDrawable;
        TextView textView = this.f71642f;
        if (textView != null && topScrollData != null && (gradientDrawable = (GradientDrawable) textView.getBackground()) != null) {
            gradientDrawable.setColor(ContextCompat.getColor(getContext(), topScrollData.b()));
        }
    }

    public void c() {
        post(new p1(this));
    }

    public final String d(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public void e() {
        TextView textView = this.f71642f;
        if (textView != null) {
            textView.setVisibility(4);
        }
    }

    public final void f(Context context) {
        this.f71639c = (LinearLayout) LayoutInflater.from(context).inflate(R$layout.view_top_notice_scroll_item, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.f71642f = (TextView) this.f71639c.findViewById(R$id.tv_left_hint);
        TextView textView = (TextView) this.f71639c.findViewById(R$id.tv_content);
        this.f71640d = textView;
        textView.setLayoutParams(layoutParams);
        this.f71640d.setSingleLine();
        this.f71640d.setEllipsize(this.f71646j);
        this.f71640d.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
        this.f71640d.setTextSize(1, 12.0f);
        addView(this.f71639c);
        this.f71641e = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = (int) getResources().getDimension(R$dimen.dimen_5);
        this.f71641e.setLayoutParams(layoutParams2);
        this.f71641e.setSingleLine();
        this.f71641e.setEllipsize(this.f71646j);
        this.f71641e.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
        this.f71641e.setTextSize(1, 12.0f);
        addView(this.f71641e);
    }

    public void i() {
        ObjectAnimator objectAnimator = this.f71647k;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f71647k.cancel();
        }
        this.f71640d.setText("");
        this.f71641e.setText("");
        this.f71642f.setVisibility(4);
        this.f71645i = 0;
    }

    public void j(TopScrollData topScrollData) {
        this.f71643g = topScrollData;
        d.b("TopScrollItemView-->startAnim-->" + this.f71644h + "-->" + this.f71643g);
        if (topScrollData == null) {
            i();
            return;
        }
        this.f71640d.setText(d(topScrollData.e()));
        this.f71641e.setText(d(topScrollData.f()));
        TextView textView = this.f71642f;
        if (textView != null) {
            textView.setVisibility(0);
            this.f71642f.setText(topScrollData.c());
        }
        setTvLeftHintBackgroundColor(topScrollData);
        post(new q1(this, topScrollData));
    }

    public void setCallback(TopScrollItemView.a aVar) {
        this.f71638b = aVar;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.f71646j = truncateAt;
        TextView textView = this.f71640d;
        if (textView != null) {
            textView.setEllipsize(truncateAt);
        }
        TextView textView2 = this.f71641e;
        if (textView2 != null) {
            textView2.setEllipsize(truncateAt);
        }
    }

    public void setFirstTextColor(int i11) {
        this.f71640d.setTextColor(i11);
    }

    public void setIndex(int i11) {
        this.f71644h = i11;
    }

    public void setText(TopScrollData topScrollData) {
        TextView textView = this.f71640d;
        if (textView != null) {
            textView.setText(d(topScrollData.e()));
        }
        TextView textView2 = this.f71641e;
        if (textView2 != null) {
            textView2.setText(d(topScrollData.f()));
        }
        TextView textView3 = this.f71642f;
        if (!(textView3 == null || topScrollData == null)) {
            textView3.setText(topScrollData.c());
        }
        setTvLeftHintBackgroundColor(topScrollData);
    }

    public void setTextBold(boolean z11) {
        Typeface h11 = ResourcesCompat.h(getContext(), R$font.dinpro_regular);
        this.f71640d.getPaint().setTypeface(h11);
        this.f71641e.getPaint().setTypeface(h11);
    }

    public TopScrollNoticeItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71645i = 0;
        this.f71646j = null;
        this.f71648l = new DecelerateInterpolator();
        setOrientation(0);
        setGravity(16);
        f(context);
        if (isInEditMode()) {
            this.f71640d.setText("title");
            this.f71641e.setText("desc");
        }
    }
}
