package com.hbg.lib.widgets.notice;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$font;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.TopScrollItemView;
import ha.a;
import ha.b;
import i6.d;

public class TopScrollNoticeItemView2 extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TopScrollItemView.a f72086b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f72087c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f72088d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f72089e;

    /* renamed from: f  reason: collision with root package name */
    public TopScrollData f72090f;

    /* renamed from: g  reason: collision with root package name */
    public int f72091g;

    /* renamed from: h  reason: collision with root package name */
    public int f72092h;

    /* renamed from: i  reason: collision with root package name */
    public TextUtils.TruncateAt f72093i;

    /* renamed from: j  reason: collision with root package name */
    public ObjectAnimator f72094j;

    /* renamed from: k  reason: collision with root package name */
    public final Interpolator f72095k;

    public TopScrollNoticeItemView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (this.f72092h == 1) {
            d.b("TopScrollItemView-->continueAnim-->" + this.f72091g + "-->" + this.f72090f + "-->滑出去了");
            this.f72092h = 2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LinearLayout.TRANSLATION_Y, new float[]{0.0f, (float) (-getHeight())});
            this.f72094j = ofFloat;
            ofFloat.setInterpolator(this.f72095k);
            this.f72094j.setDuration(500);
            this.f72094j.start();
            return;
        }
        d.b("TopScrollItemView-->continueAnim-->" + this.f72091g + "-->" + this.f72090f + "-->没动");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(TopScrollData topScrollData) {
        d.b("TopScrollItemView-->startAnim-->" + this.f72091g + "-->" + this.f72090f + "-->滑上来了");
        this.f72092h = 1;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LinearLayout.TRANSLATION_Y, new float[]{(float) getHeight(), 0.0f});
        this.f72094j = ofFloat;
        ofFloat.setInterpolator(this.f72095k);
        this.f72094j.setDuration(500);
        this.f72094j.start();
        TopScrollItemView.a aVar = this.f72086b;
        if (aVar != null) {
            aVar.a(topScrollData);
        }
    }

    public void c() {
        post(new a(this));
    }

    public final String d(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public final void e(Context context) {
        this.f72087c = (LinearLayout) LayoutInflater.from(context).inflate(R$layout.view_top_notice_scroll_item, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        ((TextView) this.f72087c.findViewById(R$id.tv_left_hint)).setVisibility(8);
        TextView textView = (TextView) this.f72087c.findViewById(R$id.tv_content);
        this.f72088d = textView;
        textView.setLayoutParams(layoutParams);
        this.f72088d.setSingleLine();
        this.f72088d.setEllipsize(this.f72093i);
        TextView textView2 = this.f72088d;
        Resources resources = getResources();
        int i11 = R$color.account_box_customer_question;
        textView2.setTextColor(resources.getColor(i11));
        this.f72088d.setTextSize(1, 12.0f);
        addView(this.f72087c);
        this.f72089e = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = (int) getResources().getDimension(R$dimen.dimen_5);
        this.f72089e.setLayoutParams(layoutParams2);
        this.f72089e.setSingleLine();
        this.f72089e.setEllipsize(this.f72093i);
        this.f72089e.setTextColor(getResources().getColor(i11));
        this.f72089e.setTextSize(1, 12.0f);
        addView(this.f72089e);
    }

    public void h() {
        ObjectAnimator objectAnimator = this.f72094j;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f72094j.cancel();
        }
        this.f72088d.setText("");
        this.f72089e.setText("");
        this.f72092h = 0;
    }

    public void i(TopScrollData topScrollData) {
        this.f72090f = topScrollData;
        d.b("TopScrollItemView-->startAnim-->" + this.f72091g + "-->" + this.f72090f);
        if (topScrollData == null) {
            h();
            return;
        }
        this.f72088d.setText(d(topScrollData.e()));
        this.f72089e.setText(d(topScrollData.f()));
        post(new b(this, topScrollData));
    }

    public void setCallback(TopScrollItemView.a aVar) {
        this.f72086b = aVar;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.f72093i = truncateAt;
        TextView textView = this.f72088d;
        if (textView != null) {
            textView.setEllipsize(truncateAt);
        }
        TextView textView2 = this.f72089e;
        if (textView2 != null) {
            textView2.setEllipsize(truncateAt);
        }
    }

    public void setFirstTextColor(int i11) {
        this.f72088d.setTextColor(i11);
    }

    public void setIndex(int i11) {
        this.f72091g = i11;
    }

    public void setText(TopScrollData topScrollData) {
        TextView textView = this.f72088d;
        if (textView != null) {
            textView.setText(d(topScrollData.e()));
        }
        TextView textView2 = this.f72089e;
        if (textView2 != null) {
            textView2.setText(d(topScrollData.f()));
        }
    }

    public void setTextBold(boolean z11) {
        Typeface h11 = ResourcesCompat.h(getContext(), R$font.dinpro_regular);
        this.f72088d.getPaint().setTypeface(h11);
        this.f72089e.getPaint().setTypeface(h11);
    }

    public TopScrollNoticeItemView2(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f72092h = 0;
        this.f72093i = null;
        this.f72095k = new DecelerateInterpolator();
        setOrientation(0);
        setGravity(16);
        e(context);
        if (isInEditMode()) {
            this.f72088d.setText("title");
            this.f72089e.setText("desc");
        }
    }
}
