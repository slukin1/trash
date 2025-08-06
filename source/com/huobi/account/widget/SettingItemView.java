package com.huobi.account.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.common.utils.ViewUtil;
import com.huobi.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dw.a;
import i6.r;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import wg.a0;
import wg.b0;
import wg.c0;

public class SettingItemView extends ConstraintLayout {

    /* renamed from: b  reason: collision with root package name */
    public SwitchCompat f42015b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42016c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42017d;

    /* renamed from: e  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f42018e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f42019f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f42020g;

    public SettingItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(CompoundButton compoundButton, boolean z11) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f42018e;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(View view, Void voidR) {
        View.OnClickListener onClickListener = this.f42019f;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        View.OnClickListener onClickListener = this.f42020g;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void k() {
    }

    public final void m(TypedArray typedArray) {
        boolean z11 = true;
        int integer = typedArray.getInteger(2, 1);
        boolean z12 = typedArray.getBoolean(3, false);
        boolean z13 = typedArray.getBoolean(0, true);
        String string = typedArray.getString(6);
        String string2 = typedArray.getString(4);
        int resourceId = typedArray.getResourceId(1, 0);
        int resourceId2 = typedArray.getResourceId(5, 0);
        boolean z14 = integer == 2;
        r rVar = new r((View) this);
        this.f42015b = (SwitchCompat) rVar.b(R.id.account_setting_item_switch);
        this.f42017d = (TextView) rVar.b(R.id.account_setting_item_title);
        this.f42016c = (TextView) rVar.b(R.id.account_setting_item_sub_title);
        ImageView imageView = (ImageView) rVar.b(R.id.account_setting_item_image_button);
        View b11 = rVar.b(R.id.account_setting_item_image_btm_line);
        ImageView imageView2 = (ImageView) rVar.b(R.id.account_setting_item_title_tips);
        ViewUtil.m(this.f42015b, z14);
        ViewUtil.m(this.f42016c, !z14);
        ViewUtil.m(imageView, !z14);
        ViewUtil.m(b11, z12);
        if (resourceId2 == 0) {
            z11 = false;
        }
        ViewUtil.m(imageView2, z11);
        this.f42017d.setText(string);
        if (!TextUtils.isEmpty(string2)) {
            this.f42016c.setText(string2);
        }
        if (resourceId != 0) {
            imageView.setImageResource(resourceId);
        }
        if (resourceId2 != 0) {
            imageView2.setImageResource(resourceId2);
        }
        this.f42015b.setChecked(z13);
        this.f42015b.setOnCheckedChangeListener(new b0(this));
        View b12 = rVar.b(R.id.account_setting_item_layout);
        a.a(b12).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new c0(this, b12));
        imageView2.setOnClickListener(new a0(this));
    }

    public void setChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f42018e = onCheckedChangeListener;
    }

    public void setChecked(boolean z11) {
        this.f42015b.setChecked(z11);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.f42019f = onClickListener;
    }

    public void setSubTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f42016c.setText(str);
        }
    }

    public void setTipsClickListener(View.OnClickListener onClickListener) {
        this.f42020g = onClickListener;
    }

    public void setTitle(String str) {
        this.f42017d.setText(str);
    }

    public SettingItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R.layout.account_setting_item_view, this, true);
        m(context.obtainStyledAttributes(attributeSet, R$styleable.SettingItemView));
        k();
    }
}
