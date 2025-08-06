package com.huobi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import pro.huobi.R;

public class LoadingProgressView extends ProgressBar {
    private Context mContext;
    private Drawable mDrawable;
    private int mGap;

    public LoadingProgressView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mDrawable = ContextCompat.getDrawable(context, R.drawable.loading_static_icon);
        this.mGap = PixelUtils.a(8.0f);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.mDrawable;
        int i11 = this.mGap;
        drawable.setBounds(i11, i11, getWidth() - this.mGap, getHeight() - this.mGap);
        this.mDrawable.draw(canvas);
    }

    public LoadingProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingProgressView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
