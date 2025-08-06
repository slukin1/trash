package com.huobi.account.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.huobi.view.roundview.RoundLinearLayout;
import pro.huobi.R;

public class TaskBoxButtonView extends RoundLinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public AppCompatImageView f42021b;

    /* renamed from: c  reason: collision with root package name */
    public AppCompatTextView f42022c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f42023d;

    public TaskBoxButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.task_box_button, this, true);
        this.f42021b = (AppCompatImageView) inflate.findViewById(R.id.aivAction);
        this.f42022c = (AppCompatTextView) inflate.findViewById(R.id.atvAction);
        this.f42023d = (LottieAnimationView) inflate.findViewById(R.id.lavAction);
    }

    @SuppressLint({"SetTextI18n"})
    public void b(int i11, int i12) {
        if (i11 == 1) {
            this.f42022c.setText(getResources().getString(R.string.n_user_center_go));
            this.f42021b.setVisibility(8);
            this.f42023d.setVisibility(8);
            this.f42022c.setVisibility(0);
            getDelegate().setBackgroundColor(getContext().getResources().getColor(R.color.baseColorMajorTheme100));
        } else if (i11 == 2) {
            this.f42021b.setVisibility(8);
            this.f42023d.setVisibility(0);
            this.f42022c.setVisibility(8);
            getDelegate().setBackgroundColor(getContext().getResources().getColor(R.color.baseColorMajorTheme100));
        } else if (i11 == 3) {
            AppCompatTextView appCompatTextView = this.f42022c;
            appCompatTextView.setText(" X" + i12);
            this.f42021b.setVisibility(8);
            this.f42023d.setVisibility(0);
            this.f42022c.setVisibility(0);
            getDelegate().setBackgroundColor(getContext().getResources().getColor(R.color.baseColorMajorTheme100));
        } else if (i11 == 4) {
            this.f42021b.setVisibility(0);
            this.f42023d.setVisibility(8);
            this.f42022c.setVisibility(8);
            getDelegate().setBackgroundColor(getContext().getResources().getColor(R.color.baseColorMajorTheme006));
        }
    }

    public void setButtonUIState(int i11) {
        b(i11, 0);
    }

    public void setText(int i11) {
        this.f42022c.setText(getResources().getString(i11));
    }

    public TaskBoxButtonView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
        getDelegate().setCornerRadius(4);
        setGravity(17);
        setOrientation(0);
    }
}
