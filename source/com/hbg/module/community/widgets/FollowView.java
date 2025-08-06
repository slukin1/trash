package com.hbg.module.community.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.content.R$styleable;
import com.huobi.view.roundview.RoundConstraintLayout;
import kotlin.jvm.internal.r;

public final class FollowView extends RoundConstraintLayout {

    /* renamed from: b  reason: collision with root package name */
    public final int f17668b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17669c;

    /* renamed from: d  reason: collision with root package name */
    public final int f17670d;

    /* renamed from: e  reason: collision with root package name */
    public final Drawable f17671e;

    /* renamed from: f  reason: collision with root package name */
    public final Drawable f17672f;

    /* renamed from: g  reason: collision with root package name */
    public final Drawable f17673g;

    /* renamed from: h  reason: collision with root package name */
    public final int f17674h;

    /* renamed from: i  reason: collision with root package name */
    public final int f17675i;

    /* renamed from: j  reason: collision with root package name */
    public final String f17676j;

    /* renamed from: k  reason: collision with root package name */
    public final int f17677k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f17678l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f17679m;

    /* renamed from: n  reason: collision with root package name */
    public int f17680n;

    public FollowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FollowView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static /* synthetic */ void getFollowType$annotations() {
    }

    public final int getFollowType() {
        return this.f17680n;
    }

    public final void h() {
        int i11 = this.f17680n;
        if (i11 == 0) {
            getDelegate().setBackgroundColor(this.f17674h);
            getDelegate().setBackgroundPressColor(this.f17674h);
            getDelegate().setStrokeColor(this.f17669c);
            getDelegate().setStrokePressColor(this.f17669c);
            ImageView imageView = this.f17678l;
            if (imageView != null) {
                imageView.setImageDrawable(this.f17671e);
            }
            TextView textView = this.f17679m;
            if (textView != null) {
                textView.setTextColor(this.f17669c);
            }
        } else if (i11 == 1) {
            getDelegate().setBackgroundColor(this.f17675i);
            getDelegate().setBackgroundPressColor(this.f17675i);
            getDelegate().setStrokeColor(this.f17675i);
            getDelegate().setStrokePressColor(this.f17675i);
            ImageView imageView2 = this.f17678l;
            if (imageView2 != null) {
                imageView2.setImageDrawable(this.f17672f);
            }
            TextView textView2 = this.f17679m;
            if (textView2 != null) {
                textView2.setTextColor(this.f17670d);
            }
        } else if (i11 == 2) {
            getDelegate().setBackgroundColor(this.f17675i);
            getDelegate().setBackgroundPressColor(this.f17675i);
            getDelegate().setStrokeColor(this.f17675i);
            getDelegate().setStrokePressColor(this.f17675i);
            ImageView imageView3 = this.f17678l;
            if (imageView3 != null) {
                imageView3.setImageDrawable(this.f17673g);
            }
            TextView textView3 = this.f17679m;
            if (textView3 != null) {
                textView3.setTextColor(this.f17670d);
            }
        }
    }

    public final void setFollowType(int i11) {
        this.f17680n = i11;
        h();
    }

    public FollowView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        int a11 = PixelUtils.a(14.0f);
        this.f17668b = a11;
        this.f17669c = ContextCompat.getColor(context, R$color.community_action_btn);
        this.f17670d = ContextCompat.getColor(context, R$color.community_cell_attentioned_text);
        this.f17671e = ContextCompat.getDrawable(context, R$drawable.icon_blue_plus);
        int i12 = R$drawable.icon_hook_focus_on;
        this.f17672f = ContextCompat.getDrawable(context, i12);
        this.f17673g = ContextCompat.getDrawable(context, i12);
        this.f17674h = ContextCompat.getColor(context, R$color.community_cell_attention_btn_background);
        this.f17675i = ContextCompat.getColor(context, R$color.baseColorRemarksBackground);
        String string = context.getResources().getString(R$string.n_content_communityList_attention);
        this.f17676j = string;
        int a12 = PixelUtils.a(12.0f);
        this.f17677k = a12;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FollowView);
            setFollowType(obtainStyledAttributes.getInt(R$styleable.FollowView_followType, this.f17680n));
            obtainStyledAttributes.recycle();
        }
        LayoutInflater.from(context).inflate(R$layout.layout_follow_view, this, true);
        this.f17678l = (ImageView) findViewById(R$id.imageAttentionPlus);
        this.f17679m = (TextView) findViewById(R$id.tvARAction);
        setPadding(a11, 0, a11, 0);
        TextView textView = this.f17679m;
        if (textView != null) {
            textView.setTextSize(0, (float) a12);
        }
        TextView textView2 = this.f17679m;
        if (textView2 != null) {
            textView2.setText(string);
        }
        getDelegate().setStrokeWidth(1);
        h();
    }
}
