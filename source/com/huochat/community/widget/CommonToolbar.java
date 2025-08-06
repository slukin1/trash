package com.huochat.community.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huochat.community.R;
import com.huochat.community.util.DisplayTool;

public class CommonToolbar extends RelativeLayout {
    private int backgroundColor = -1;
    private ColorStateList backgroundColorStateList = null;
    public ImageView ivLeftIcon;
    public ImageView ivRightIcon;
    private int leftIcon;
    private int leftIconFilterColor = Color.parseColor("#333333");
    private ColorStateList leftIconFilterColorStateList = null;
    private int leftIconVisible;
    private String leftText;
    private int leftTextColor = Color.parseColor("#333333");
    private ColorStateList leftTextColorStateList = null;
    private float leftTextSize;
    private int leftTextVisible;
    public LinearLayout llLeft;
    public LinearLayout llRight;
    private int rightIcon;
    private int rightIconFilterColor = Color.parseColor("#333333");
    private ColorStateList rightIconFilterColorStateList = null;
    private int rightIconVisible;
    private String rightText;
    private int rightTextColor = Color.parseColor("#333333");
    private ColorStateList rightTextColorStateList = null;
    private float rightTextSize;
    private int rightTextVisible;
    private String title;
    private int titleColor = Color.parseColor("#333333");
    private ColorStateList titleColorStateList = null;
    private float titleSize;
    private int titleVisible;
    public TextView tvLeftText;
    public TextView tvRightText;
    public TextView tvTitle;

    public CommonToolbar(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    @SuppressLint({"ResourceType"})
    private void init(Context context, AttributeSet attributeSet) {
        int i11;
        int i12;
        int i13;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonToolbar);
            try {
                int i14 = R.styleable.CommonToolbar_title;
                this.title = obtainStyledAttributes.getString(i14);
                i13 = obtainStyledAttributes.getResourceId(i14, 0);
                int i15 = R.styleable.CommonToolbar_leftText;
                this.leftText = obtainStyledAttributes.getString(i15);
                i12 = obtainStyledAttributes.getResourceId(i15, 0);
                int i16 = R.styleable.CommonToolbar_rightText;
                this.rightText = obtainStyledAttributes.getString(i16);
                i11 = obtainStyledAttributes.getResourceId(i16, 0);
                this.leftIconVisible = obtainStyledAttributes.getInt(R.styleable.CommonToolbar_leftIconVisible, 0);
                this.rightIconVisible = obtainStyledAttributes.getInt(R.styleable.CommonToolbar_rightIconVisible, 8);
                this.leftTextVisible = obtainStyledAttributes.getInt(R.styleable.CommonToolbar_leftTextVisible, 8);
                this.rightTextVisible = obtainStyledAttributes.getInt(R.styleable.CommonToolbar_rightTextVisible, 8);
                this.titleVisible = obtainStyledAttributes.getInt(R.styleable.CommonToolbar_titleVisible, 0);
                this.titleColor = obtainStyledAttributes.getColor(R.styleable.CommonToolbar_titleColor, this.titleColor);
                this.leftTextColor = obtainStyledAttributes.getColor(R.styleable.CommonToolbar_leftTextColor, this.leftTextColor);
                this.rightTextColor = obtainStyledAttributes.getColor(R.styleable.CommonToolbar_rightTextColor, this.rightTextColor);
                this.leftIconFilterColor = obtainStyledAttributes.getColor(R.styleable.CommonToolbar_leftIconFilterColor, this.leftIconFilterColor);
                this.rightIconFilterColor = obtainStyledAttributes.getColor(R.styleable.CommonToolbar_rightIconFilterColor, this.rightIconFilterColor);
                this.backgroundColor = obtainStyledAttributes.getColor(R.styleable.CommonToolbar_backgroundColor, this.backgroundColor);
                this.leftIcon = obtainStyledAttributes.getResourceId(R.styleable.CommonToolbar_leftIcon, -1);
                this.rightIcon = obtainStyledAttributes.getResourceId(R.styleable.CommonToolbar_rightIcon, -1);
                this.leftTextSize = obtainStyledAttributes.getDimension(R.styleable.CommonToolbar_leftTextSize, (float) DisplayTool.dp2px(getContext(), 17.0f));
                this.titleSize = obtainStyledAttributes.getDimension(R.styleable.CommonToolbar_titleSize, (float) DisplayTool.dp2px(getContext(), 17.0f));
                this.rightTextSize = obtainStyledAttributes.getDimension(R.styleable.CommonToolbar_rightTextSize, (float) DisplayTool.dp2px(getContext(), 17.0f));
                obtainStyledAttributes.recycle();
            } catch (Throwable th2) {
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
                throw th2;
            }
        } else {
            i13 = 0;
            i12 = 0;
            i11 = 0;
        }
        View inflate = View.inflate(context, R.layout.view_community_common_toolbar, this);
        this.llLeft = (LinearLayout) inflate.findViewById(R.id.ll_left);
        this.llRight = (LinearLayout) inflate.findViewById(R.id.ll_right);
        this.tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.ivLeftIcon = (ImageView) inflate.findViewById(R.id.iv_left_icon);
        this.ivRightIcon = (ImageView) inflate.findViewById(R.id.iv_right_icon);
        this.tvLeftText = (TextView) inflate.findViewById(R.id.tv_left_text);
        this.tvRightText = (TextView) inflate.findViewById(R.id.tv_right_text);
        this.tvTitle.setText(i13 == 0 ? this.title : getResources().getString(i13));
        this.tvTitle.setTextColor(this.titleColor);
        this.tvTitle.setVisibility(this.titleVisible);
        this.tvTitle.setTextSize(0, this.titleSize);
        this.tvLeftText.setText(i12 == 0 ? this.leftText : getResources().getString(i12));
        this.tvLeftText.setTextColor(this.leftTextColor);
        this.tvLeftText.setVisibility(this.leftTextVisible);
        this.tvLeftText.setTextSize(0, this.leftTextSize);
        this.tvRightText.setText(i11 == 0 ? this.rightText : getResources().getString(i11));
        this.tvRightText.setTextColor(this.rightTextColor);
        this.tvRightText.setVisibility(this.rightTextVisible);
        this.tvRightText.setTextSize(0, this.rightTextSize);
        int i17 = this.leftIcon;
        if (i17 != -1) {
            this.ivLeftIcon.setImageResource(i17);
        }
        this.ivLeftIcon.setVisibility(this.leftIconVisible);
        this.ivLeftIcon.setColorFilter(this.leftIconFilterColor);
        int i18 = this.rightIcon;
        if (i18 != -1) {
            this.ivRightIcon.setImageResource(i18);
        }
        this.ivRightIcon.setVisibility(this.rightIconVisible);
        this.ivRightIcon.setColorFilter(this.rightIconFilterColor);
    }

    public ImageView getIvLeftIcon() {
        return this.ivLeftIcon;
    }

    public ImageView getIvRightIcon() {
        return this.ivRightIcon;
    }

    public TextView getTvLeftText() {
        return this.tvLeftText;
    }

    public TextView getTvRightText() {
        return this.tvRightText;
    }

    public TextView getTvTitle() {
        return this.tvTitle;
    }

    public void setLeftClick(View.OnClickListener onClickListener) {
        this.llLeft.setOnClickListener(onClickListener);
    }

    public void setLeftIcon(int i11) {
        this.ivLeftIcon.setImageResource(i11);
    }

    public void setLeftLayoutVisible(int i11) {
        this.llLeft.setVisibility(i11);
    }

    public void setLeftVisible(int i11) {
        this.llLeft.setVisibility(i11);
    }

    public void setRightClick(View.OnClickListener onClickListener) {
        this.llRight.setOnClickListener(onClickListener);
    }

    public void setRightEnable(boolean z11) {
        this.llRight.setEnabled(z11);
    }

    public void setRightIcon(int i11) {
        this.ivRightIcon.setImageResource(i11);
    }

    public void setRightVisible(int i11) {
        this.llRight.setVisibility(i11);
    }

    public void setTitle(String str) {
        this.tvTitle.setText(str);
    }

    public CommonToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public CommonToolbar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
