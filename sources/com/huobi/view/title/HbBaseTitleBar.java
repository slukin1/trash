package com.huobi.view.title;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public abstract class HbBaseTitleBar extends FrameLayout {
    private Drawable actionIcon;
    public Context context;
    private ImageView ivAction;
    private ImageView ivBack;
    private View.OnClickListener onClickActionListener;
    private View.OnClickListener onClickBackListener;
    private FrameLayout rightContainer;
    private boolean showBack;
    private FrameLayout titleContainer;
    private TextView tvAction;

    public HbBaseTitleBar(Context context2) {
        super(context2);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        View.OnClickListener onClickListener = this.onClickBackListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        Context context2 = this.context;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        View.OnClickListener onClickListener = this.onClickActionListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent() {
        this.ivBack.setOnClickListener(new b(this));
        a aVar = new a(this);
        this.ivAction.setOnClickListener(aVar);
        this.tvAction.setOnClickListener(aVar);
    }

    public ImageView getBackAction() {
        return this.ivBack;
    }

    public ImageView getIvAction() {
        return this.ivAction;
    }

    public FrameLayout getRightContainer() {
        return this.rightContainer;
    }

    public abstract View getTitleContent();

    public TextView getTvAction() {
        return this.tvAction;
    }

    public void init(Context context2, AttributeSet attributeSet, int i11, int i12) {
        this.context = context2;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.HbBaseTitleBar, i12, 0);
        this.showBack = obtainStyledAttributes.getBoolean(R$styleable.HbBaseTitleBar_showBack, true);
        this.actionIcon = obtainStyledAttributes.getDrawable(R$styleable.HbBaseTitleBar_actionIcon);
        String string = obtainStyledAttributes.getString(R$styleable.HbBaseTitleBar_actionText);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context2).inflate(R$layout.title_layout, this, true);
        ImageView imageView = (ImageView) findViewById(R$id.iv_back);
        this.ivBack = imageView;
        ViewUtil.m(imageView, this.showBack);
        this.titleContainer = (FrameLayout) findViewById(R$id.title_container);
        View titleContent = getTitleContent();
        if (titleContent != null) {
            this.titleContainer.addView(titleContent);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.iv_action);
        this.ivAction = imageView2;
        if (this.actionIcon != null) {
            imageView2.setVisibility(0);
            this.ivAction.setImageDrawable(this.actionIcon);
        }
        TextView textView = (TextView) findViewById(R$id.tv_action);
        this.tvAction = textView;
        if (string != null) {
            textView.setVisibility(0);
            this.tvAction.setText(string);
        }
        this.rightContainer = (FrameLayout) findViewById(R$id.right_container);
        addEvent();
    }

    public void setOnClickActionListener(View.OnClickListener onClickListener) {
        this.onClickActionListener = onClickListener;
    }

    public void setOnClickBackListener(View.OnClickListener onClickListener) {
        this.onClickBackListener = onClickListener;
    }

    public HbBaseTitleBar(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        init(context2, attributeSet, 0, 0);
    }

    public HbBaseTitleBar(Context context2, AttributeSet attributeSet, int i11) {
        super(context2, attributeSet, i11);
        init(context2, attributeSet, i11, i11);
    }

    public HbBaseTitleBar(Context context2, AttributeSet attributeSet, int i11, int i12) {
        super(context2, attributeSet, i11, i12);
        init(context2, attributeSet, i11, i12);
    }
}
