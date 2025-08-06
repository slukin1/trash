package com.tencent.qcloud.tuikit.timcommon.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;

public class LineControllerView extends RelativeLayout {
    public View bottomLine;
    private View container;
    private String mContent;
    public TextView mContentText;
    private boolean mIsBottom;
    private boolean mIsJump;
    private boolean mIsSwitch;
    private boolean mIsTop;
    private View mMask;
    private String mName;
    public TextView mNameText;
    private ImageView mNavArrowView;
    public Switch mSwitchView;

    public LineControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.line_controller_view, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LineControllerView, 0, 0);
        try {
            this.mName = obtainStyledAttributes.getString(R.styleable.LineControllerView_name);
            this.mContent = obtainStyledAttributes.getString(R.styleable.LineControllerView_subject);
            this.mIsBottom = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_isBottom, false);
            this.mIsTop = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_isTop, false);
            this.mIsJump = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_canNav, false);
            this.mIsSwitch = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_isSwitch, false);
            setUpView();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void setUpView() {
        TextView textView = (TextView) findViewById(R.id.name);
        this.mNameText = textView;
        textView.setText(this.mName);
        TextView textView2 = (TextView) findViewById(R.id.content);
        this.mContentText = textView2;
        textView2.setText(this.mContent);
        this.bottomLine = findViewById(R.id.bottom_line);
        View findViewById = findViewById(R.id.top_line);
        int i11 = 0;
        this.bottomLine.setVisibility(this.mIsBottom ? 0 : 8);
        findViewById.setVisibility(this.mIsTop ? 0 : 8);
        ImageView imageView = (ImageView) findViewById(R.id.rightArrow);
        this.mNavArrowView = imageView;
        imageView.setVisibility(this.mIsJump ? 0 : 8);
        ((RelativeLayout) findViewById(R.id.contentText)).setVisibility(this.mIsSwitch ? 8 : 0);
        Switch switchR = (Switch) findViewById(R.id.btnSwitch);
        this.mSwitchView = switchR;
        if (!this.mIsSwitch) {
            i11 = 8;
        }
        switchR.setVisibility(i11);
        this.mMask = findViewById(R.id.disable_mask);
        this.container = findViewById(R.id.view_container);
    }

    public String getContent() {
        return this.mContentText.getText().toString();
    }

    public boolean isChecked() {
        return this.mSwitchView.isChecked();
    }

    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        this.container.setBackground(drawable);
    }

    public void setCanNav(boolean z11) {
        this.mIsJump = z11;
        this.mNavArrowView.setVisibility(z11 ? 0 : 8);
        if (z11) {
            ViewGroup.LayoutParams layoutParams = this.mContentText.getLayoutParams();
            layoutParams.width = ScreenUtil.getPxByDp(120.0f);
            layoutParams.height = -2;
            this.mContentText.setLayoutParams(layoutParams);
            this.mContentText.setTextIsSelectable(false);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.mContentText.getLayoutParams();
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        this.mContentText.setLayoutParams(layoutParams2);
        this.mContentText.setTextIsSelectable(true);
    }

    public void setCheckListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mSwitchView.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setChecked(boolean z11) {
        this.mSwitchView.setChecked(z11);
    }

    public void setContent(String str) {
        this.mContent = str;
        this.mContentText.setText(str);
    }

    public void setMask(boolean z11) {
        if (z11) {
            this.mMask.setVisibility(0);
            this.mSwitchView.setEnabled(false);
            return;
        }
        this.mMask.setVisibility(8);
        this.mSwitchView.setEnabled(true);
    }

    public void setSingleLine(boolean z11) {
        this.mContentText.setSingleLine(z11);
    }
}
